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
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class d {
    private int count;
    private ViewGroup fTa;
    private ImageView fTb;
    private TextView fTc;
    private String fTd;
    private Runnable fTe = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.mHandler.removeCallbacks(this);
            if (d.this.count > 2) {
                d.this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            d.this.isShowLocation = d.this.bAU();
            d.this.bAZ();
            d.this.mHandler.postDelayed(this, 3000L);
            d.d(d.this);
        }
    };
    private CustomMessageListener fTf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.ala.liveroom.views.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                d.this.isShowLocation = d.this.bAU();
                if (d.this.isShowLocation) {
                    d.this.fTc.setText(a.i.ala_live_prepare_locating);
                } else {
                    d.this.fTc.setText(a.i.ala_live_prepare_locate_title);
                }
            }
            d.this.mHandler.postDelayed(d.this.fTe, 3000L);
        }
    };
    private CustomMessageListener fTg = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.ala.liveroom.views.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.isShowLocation = d.this.bAU();
            d.this.bAZ();
            if (d.this.bAU()) {
                LocationInfo locationInfo = d.this.mLocation.getLocationInfo();
                if (locationInfo == null || StringUtils.isNull(locationInfo.getCurCityName())) {
                    d.this.fTc.setText(a.i.ala_live_prepare_locate_fail);
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
        this.isShowLocation = bAU();
        MessageManager.getInstance().registerListener(this.fTf);
        MessageManager.getInstance().registerListener(this.fTg);
        this.mHandler = new Handler();
    }

    public void ap(ViewGroup viewGroup) {
        this.fTa = viewGroup;
        this.fTb = (ImageView) viewGroup.findViewById(a.g.ala_live_prepare_locate_img);
        this.fTc = (TextView) viewGroup.findViewById(a.g.ala_live_prepare_locate_tv);
        this.mLocation = LocationManager.getInstance().buildLocation();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
            if (!checkPermission()) {
                bAY();
            } else {
                bAZ();
            }
        } else {
            bAZ();
        }
        this.fTa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bAW();
            }
        });
    }

    public boolean bAU() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mPageContext.getPageActivity());
    }

    public boolean bAV() {
        return bAU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bwH() {
        boolean z = false;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            com.baidu.live.c.tH().getBoolean("has_request_location", false);
            com.baidu.live.c.tH().putBoolean("has_request_location", true);
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
    public void bAW() {
        if (this.isShowLocation) {
            LogManager.getLiveRecordLogger().doClickLiveLocationAlreadyButtonLog("");
        } else {
            LogManager.getLiveRecordLogger().doClickLiveLocationAllowButtonLog("");
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.LIVE_ACTION, "location"));
        if (!bwH()) {
            this.isShowLocation = !this.isShowLocation;
            bAX();
        }
    }

    private void bAX() {
        bAZ();
    }

    private void bAY() {
        if (!com.baidu.live.c.tH().getBoolean("has_master_show_location_dialog", false)) {
            com.baidu.live.c.tH().putBoolean("has_master_show_location_dialog", true);
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
                    d.this.bwH();
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
    public void bAZ() {
        if (this.isShowLocation) {
            if (this.mLocation != null) {
                LocationInfo locationInfo = this.mLocation.getLocationInfo();
                if (locationInfo != null && !StringUtils.isNull(locationInfo.getCurCityName())) {
                    this.fTc.setText(locationInfo.getCurCityName());
                    this.fTd = locationInfo.getCurCityName();
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                    this.fTc.setText(a.i.ala_live_prepare_locating);
                } else {
                    this.fTc.setText(a.i.ala_live_prepare_locate_opened_title);
                }
            } else {
                this.fTc.setText(a.i.ala_live_prepare_locate_opened_title);
            }
        } else {
            this.fTc.setText(a.i.ala_live_prepare_locate_title);
        }
        this.fTb.setSelected(!this.isShowLocation);
        this.fTc.setTextColor(this.isShowLocation ? this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_g) : this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
    }

    public void bBa() {
        this.isShowLocation = bAU();
        bAZ();
    }

    public String bBb() {
        return this.fTd;
    }

    public boolean isShowLocation() {
        return this.isShowLocation;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.fTf);
        MessageManager.getInstance().unRegisterListener(this.fTg);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
