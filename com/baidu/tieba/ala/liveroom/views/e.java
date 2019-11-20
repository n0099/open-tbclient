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
import com.baidu.live.k.a;
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
/* loaded from: classes6.dex */
public class e {
    private int count;
    private ViewGroup erq;
    private ImageView ers;
    private TextView ert;
    private String eru;
    private Runnable erv = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.e.1
        @Override // java.lang.Runnable
        public void run() {
            e.this.mHandler.removeCallbacks(this);
            if (e.this.count > 2) {
                e.this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            e.this.isShowLocation = e.this.aWP();
            e.this.aWT();
            e.this.mHandler.postDelayed(this, 3000L);
            e.d(e.this);
        }
    };
    private CustomMessageListener erw = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.ala.liveroom.views.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                e.this.isShowLocation = e.this.aWP();
                if (e.this.isShowLocation) {
                    e.this.ert.setText(a.i.ala_live_prepare_locating);
                } else {
                    e.this.ert.setText(a.i.ala_live_prepare_locate_title);
                }
            }
            e.this.mHandler.postDelayed(e.this.erv, 3000L);
        }
    };
    private CustomMessageListener erx = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.ala.liveroom.views.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.isShowLocation = e.this.aWP();
            e.this.aWT();
            if (e.this.aWP()) {
                LocationInfo locationInfo = e.this.mLocation.getLocationInfo();
                if (locationInfo == null || StringUtils.isNull(locationInfo.getCurCityName())) {
                    e.this.ert.setText(a.i.ala_live_prepare_locate_fail);
                }
            }
        }
    };
    private boolean isShowLocation;
    private Handler mHandler;
    private ILocation mLocation;
    private TbPageContext mPageContext;

    static /* synthetic */ int d(e eVar) {
        int i = eVar.count;
        eVar.count = i + 1;
        return i;
    }

    public e(TbPageContext tbPageContext) {
        this.isShowLocation = true;
        this.mPageContext = tbPageContext;
        this.isShowLocation = aWP();
        MessageManager.getInstance().registerListener(this.erw);
        MessageManager.getInstance().registerListener(this.erx);
        this.mHandler = new Handler();
    }

    public void ak(ViewGroup viewGroup) {
        this.erq = viewGroup;
        this.ers = (ImageView) viewGroup.findViewById(a.g.ala_live_prepare_locate_img);
        this.ert = (TextView) viewGroup.findViewById(a.g.ala_live_prepare_locate_tv);
        this.mLocation = LocationManager.getInstance().buildLocation();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            if (!checkPermission()) {
                aWS();
            } else {
                aWT();
            }
        } else {
            aWT();
        }
        this.erq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aWQ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aWP() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aSR() {
        boolean z = false;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            com.baidu.live.c.np().getBoolean("has_request_location", false);
            com.baidu.live.c.np().putBoolean("has_request_location", true);
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
    public void aWQ() {
        if (this.isShowLocation) {
            LogManager.getLiveRecordLogger().doClickLiveLocationAlreadyButtonLog("");
        } else {
            LogManager.getLiveRecordLogger().doClickLiveLocationAllowButtonLog("");
        }
        if (!aSR()) {
            this.isShowLocation = !this.isShowLocation;
            aWR();
        }
    }

    private void aWR() {
        aWT();
    }

    private void aWS() {
        if (!com.baidu.live.c.np().getBoolean("has_master_show_location_dialog", false)) {
            com.baidu.live.c.np().putBoolean("has_master_show_location_dialog", true);
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.setTitle(a.i.sdk_open_permission_title);
            bdAlertDialog.setMessageId(a.i.sdk_open_permission_content);
            bdAlertDialog.setTitleShowCenter(true);
            bdAlertDialog.setMessageShowCenter(true);
            bdAlertDialog.isShowTitleAndMessage();
            bdAlertDialog.setPositiveButton(a.i.sdk_isopen, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.e.6
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                    e.this.aSR();
                }
            }).setNegativeButton(a.i.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.e.5
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            }).create(this.mPageContext);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWT() {
        if (this.isShowLocation) {
            if (this.mLocation != null) {
                LocationInfo locationInfo = this.mLocation.getLocationInfo();
                if (locationInfo != null && !StringUtils.isNull(locationInfo.getCurCityName())) {
                    this.ert.setText(locationInfo.getCurCityName());
                    this.eru = locationInfo.getCurCityName();
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                    this.ert.setText(a.i.ala_live_prepare_locating);
                } else {
                    this.ert.setText(a.i.ala_live_prepare_locate_opened_title);
                }
            } else {
                this.ert.setText(a.i.ala_live_prepare_locate_opened_title);
            }
        } else {
            this.ert.setText(a.i.ala_live_prepare_locate_title);
        }
        this.ers.setSelected(!this.isShowLocation);
        this.ert.setTextColor(this.isShowLocation ? this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_g) : this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aWU() {
        this.isShowLocation = aWP();
        aWT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String aWV() {
        return this.eru;
    }

    public boolean isShowLocation() {
        return this.isShowLocation;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.erw);
        MessageManager.getInstance().unRegisterListener(this.erx);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
