package com.baidu.tieba.ala.liveroom.views;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.live.tbadk.location.LocationInfo;
import com.baidu.live.tbadk.location.LocationManager;
import com.baidu.live.tbadk.location.interfaces.ILocation;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class d {
    private int count;
    private ViewGroup ghX;
    private ImageView ghY;
    private TextView ghZ;
    private String gia;
    private Runnable gib = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.mHandler.removeCallbacks(this);
            if (d.this.count > 2) {
                d.this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            d.this.isShowLocation = d.this.bHm();
            d.this.bHr();
            d.this.mHandler.postDelayed(this, 3000L);
            d.d(d.this);
        }
    };
    private CustomMessageListener gic = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.ala.liveroom.views.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                d.this.isShowLocation = d.this.bHm();
                if (d.this.isShowLocation) {
                    d.this.ghZ.setText(a.i.ala_live_prepare_locating);
                } else {
                    d.this.ghZ.setText(a.i.ala_live_prepare_locate_title);
                }
            }
            d.this.mHandler.postDelayed(d.this.gib, 3000L);
        }
    };
    private CustomMessageListener gie = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.ala.liveroom.views.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.isShowLocation = d.this.bHm();
            d.this.bHr();
            if (d.this.bHm()) {
                LocationInfo locationInfo = d.this.mLocation.getLocationInfo();
                if (locationInfo == null || StringUtils.isNull(locationInfo.getCurCityName())) {
                    d.this.ghZ.setText(a.i.ala_live_prepare_locate_fail);
                }
            }
        }
    };
    private boolean isShowLocation;
    private Handler mHandler;
    private ILocation mLocation;
    private TbPageContext mPageContext;

    static /* synthetic */ int d(d dVar) {
        int i = dVar.count;
        dVar.count = i + 1;
        return i;
    }

    public d(TbPageContext tbPageContext) {
        this.isShowLocation = true;
        this.mPageContext = tbPageContext;
        this.isShowLocation = bHm();
        MessageManager.getInstance().registerListener(this.gic);
        MessageManager.getInstance().registerListener(this.gie);
        this.mHandler = new Handler();
    }

    public void ay(ViewGroup viewGroup) {
        this.ghX = viewGroup;
        this.ghY = (ImageView) viewGroup.findViewById(a.g.ala_live_prepare_locate_img);
        this.ghZ = (TextView) viewGroup.findViewById(a.g.ala_live_prepare_locate_tv);
        this.mLocation = LocationManager.getInstance().buildLocation();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
            if (!checkPermission()) {
                bHq();
            } else {
                bHr();
            }
        } else {
            bHr();
        }
        this.ghX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bHo();
            }
        });
    }

    public boolean bHm() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mPageContext.getPageActivity());
    }

    public boolean bHn() {
        return bHm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bCF() {
        boolean z = false;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            com.baidu.live.c.uN().getBoolean("has_request_location", false);
            com.baidu.live.c.uN().putBoolean("has_request_location", true);
            z = true;
        }
        Activity pageActivity = this.mPageContext.getPageActivity();
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(pageActivity, "android.permission.ACCESS_FINE_LOCATION");
        permissionJudgePolicy.appendRequestPermission(pageActivity, "android.permission.ACCESS_COARSE_LOCATION");
        return permissionJudgePolicy.startRequestPermission(pageActivity, z, true);
    }

    private boolean checkPermission() {
        Activity pageActivity = this.mPageContext.getPageActivity();
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(pageActivity, "android.permission.ACCESS_FINE_LOCATION");
        permissionJudgePolicy.appendRequestPermission(pageActivity, "android.permission.ACCESS_COARSE_LOCATION");
        return permissionJudgePolicy.checkPermissionListGranted(pageActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHo() {
        if (this.isShowLocation) {
            LogManager.getLiveRecordLogger().doClickLiveLocationAlreadyButtonLog("");
        } else {
            LogManager.getLiveRecordLogger().doClickLiveLocationAllowButtonLog("");
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "location"));
        if (!bCF()) {
            this.isShowLocation = !this.isShowLocation;
            bHp();
        }
    }

    private void bHp() {
        bHr();
    }

    private void bHq() {
        if (!com.baidu.live.c.uN().getBoolean("has_master_show_location_dialog", false)) {
            com.baidu.live.c.uN().putBoolean("has_master_show_location_dialog", true);
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.setTitle(a.i.sdk_open_permission_title);
            bdAlertDialog.setMessageId(a.i.sdk_open_permission_content);
            bdAlertDialog.setTitleShowCenter(true);
            bdAlertDialog.setMessageShowCenter(true);
            bdAlertDialog.isShowTitleAndMessage();
            bdAlertDialog.setPositiveButton(a.i.sdk_isopen, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.6
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                    d.this.bCF();
                }
            }).setNegativeButton(a.i.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.5
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            }).create(this.mPageContext);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHr() {
        if (this.isShowLocation) {
            if (this.mLocation != null) {
                LocationInfo locationInfo = this.mLocation.getLocationInfo();
                if (locationInfo != null && !StringUtils.isNull(locationInfo.getCurCityName())) {
                    this.ghZ.setText(locationInfo.getCurCityName());
                    this.gia = locationInfo.getCurCityName();
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                    this.ghZ.setText(a.i.ala_live_prepare_locating);
                } else {
                    this.ghZ.setText(a.i.ala_live_prepare_locate_opened_title);
                }
            } else {
                this.ghZ.setText(a.i.ala_live_prepare_locate_opened_title);
            }
        } else {
            this.ghZ.setText(a.i.ala_live_prepare_locate_title);
        }
        this.ghY.setSelected(!this.isShowLocation);
        this.ghZ.setTextColor(this.isShowLocation ? this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_g) : this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
    }

    public void bHs() {
        this.isShowLocation = bHm();
        bHr();
    }

    public String bHt() {
        return this.gia;
    }

    public boolean isShowLocation() {
        return this.isShowLocation;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.gic);
        MessageManager.getInstance().unRegisterListener(this.gie);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
