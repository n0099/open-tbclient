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
import com.baidu.live.sdk.a;
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
/* loaded from: classes4.dex */
public class d {
    private int count;
    private ViewGroup gAs;
    private ImageView gAt;
    private TextView gAu;
    private String gAv;
    private Runnable gAw = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.mHandler.removeCallbacks(this);
            if (d.this.count > 2) {
                d.this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            d.this.isShowLocation = d.this.bNz();
            d.this.bNE();
            d.this.mHandler.postDelayed(this, 3000L);
            d.d(d.this);
        }
    };
    private CustomMessageListener gAx = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.ala.liveroom.views.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                d.this.isShowLocation = d.this.bNz();
                if (d.this.isShowLocation) {
                    d.this.gAu.setText(a.i.ala_live_prepare_locating);
                } else {
                    d.this.gAu.setText(a.i.ala_live_prepare_locate_title);
                }
            }
            d.this.mHandler.postDelayed(d.this.gAw, 3000L);
        }
    };
    private CustomMessageListener gAy = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.ala.liveroom.views.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.isShowLocation = d.this.bNz();
            d.this.bNE();
            if (d.this.bNz()) {
                LocationInfo locationInfo = d.this.mLocation.getLocationInfo();
                if (locationInfo == null || StringUtils.isNull(locationInfo.getCurCityName())) {
                    d.this.gAu.setText(a.i.ala_live_prepare_locate_fail);
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
        this.isShowLocation = bNz();
        MessageManager.getInstance().registerListener(this.gAx);
        MessageManager.getInstance().registerListener(this.gAy);
        this.mHandler = new Handler();
    }

    public void aD(ViewGroup viewGroup) {
        this.gAs = viewGroup;
        this.gAt = (ImageView) viewGroup.findViewById(a.g.ala_live_prepare_locate_img);
        this.gAu = (TextView) viewGroup.findViewById(a.g.ala_live_prepare_locate_tv);
        this.mLocation = LocationManager.getInstance().buildLocation();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
            if (!checkPermission()) {
                bND();
            } else {
                bNE();
            }
        } else {
            bNE();
        }
        this.gAs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.bNB();
            }
        });
    }

    public boolean bNz() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mPageContext.getPageActivity());
    }

    public boolean bNA() {
        return bNz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIW() {
        boolean z = false;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            com.baidu.live.c.vf().getBoolean("has_request_location", false);
            com.baidu.live.c.vf().putBoolean("has_request_location", true);
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
    public void bNB() {
        if (this.isShowLocation) {
            LogManager.getLiveRecordLogger().doClickLiveLocationAlreadyButtonLog("");
        } else {
            LogManager.getLiveRecordLogger().doClickLiveLocationAllowButtonLog("");
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "location"));
        if (!bIW()) {
            this.isShowLocation = !this.isShowLocation;
            bNC();
        }
    }

    private void bNC() {
        bNE();
    }

    private void bND() {
        if (!com.baidu.live.c.vf().getBoolean("has_master_show_location_dialog", false)) {
            com.baidu.live.c.vf().putBoolean("has_master_show_location_dialog", true);
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
                    d.this.bIW();
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
    public void bNE() {
        if (this.isShowLocation) {
            if (this.mLocation != null) {
                LocationInfo locationInfo = this.mLocation.getLocationInfo();
                if (locationInfo != null && !StringUtils.isNull(locationInfo.getCurCityName())) {
                    this.gAu.setText(locationInfo.getCurCityName());
                    this.gAv = locationInfo.getCurCityName();
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                    this.gAu.setText(a.i.ala_live_prepare_locating);
                } else {
                    this.gAu.setText(a.i.ala_live_prepare_locate_opened_title);
                }
            } else {
                this.gAu.setText(a.i.ala_live_prepare_locate_opened_title);
            }
        } else {
            this.gAu.setText(a.i.ala_live_prepare_locate_title);
        }
        this.gAt.setSelected(!this.isShowLocation);
        this.gAu.setTextColor(this.isShowLocation ? this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_g) : this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
    }

    public void bNF() {
        this.isShowLocation = bNz();
        bNE();
    }

    public String bNG() {
        return this.gAv;
    }

    public boolean isShowLocation() {
        return this.isShowLocation;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.gAx);
        MessageManager.getInstance().unRegisterListener(this.gAy);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
