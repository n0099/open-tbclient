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
    private ViewGroup esi;
    private ImageView esj;
    private TextView esk;
    private String esl;
    private Runnable esm = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.e.1
        @Override // java.lang.Runnable
        public void run() {
            e.this.mHandler.removeCallbacks(this);
            if (e.this.count > 2) {
                e.this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            e.this.isShowLocation = e.this.aWR();
            e.this.aWV();
            e.this.mHandler.postDelayed(this, 3000L);
            e.d(e.this);
        }
    };
    private CustomMessageListener esn = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.ala.liveroom.views.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                e.this.isShowLocation = e.this.aWR();
                if (e.this.isShowLocation) {
                    e.this.esk.setText(a.i.ala_live_prepare_locating);
                } else {
                    e.this.esk.setText(a.i.ala_live_prepare_locate_title);
                }
            }
            e.this.mHandler.postDelayed(e.this.esm, 3000L);
        }
    };
    private CustomMessageListener eso = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.ala.liveroom.views.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.isShowLocation = e.this.aWR();
            e.this.aWV();
            if (e.this.aWR()) {
                LocationInfo locationInfo = e.this.mLocation.getLocationInfo();
                if (locationInfo == null || StringUtils.isNull(locationInfo.getCurCityName())) {
                    e.this.esk.setText(a.i.ala_live_prepare_locate_fail);
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
        this.isShowLocation = aWR();
        MessageManager.getInstance().registerListener(this.esn);
        MessageManager.getInstance().registerListener(this.eso);
        this.mHandler = new Handler();
    }

    public void ak(ViewGroup viewGroup) {
        this.esi = viewGroup;
        this.esj = (ImageView) viewGroup.findViewById(a.g.ala_live_prepare_locate_img);
        this.esk = (TextView) viewGroup.findViewById(a.g.ala_live_prepare_locate_tv);
        this.mLocation = LocationManager.getInstance().buildLocation();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            if (!checkPermission()) {
                aWU();
            } else {
                aWV();
            }
        } else {
            aWV();
        }
        this.esi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.aWS();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aWR() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aST() {
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
    public void aWS() {
        if (this.isShowLocation) {
            LogManager.getLiveRecordLogger().doClickLiveLocationAlreadyButtonLog("");
        } else {
            LogManager.getLiveRecordLogger().doClickLiveLocationAllowButtonLog("");
        }
        if (!aST()) {
            this.isShowLocation = !this.isShowLocation;
            aWT();
        }
    }

    private void aWT() {
        aWV();
    }

    private void aWU() {
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
                    e.this.aST();
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
    public void aWV() {
        if (this.isShowLocation) {
            if (this.mLocation != null) {
                LocationInfo locationInfo = this.mLocation.getLocationInfo();
                if (locationInfo != null && !StringUtils.isNull(locationInfo.getCurCityName())) {
                    this.esk.setText(locationInfo.getCurCityName());
                    this.esl = locationInfo.getCurCityName();
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                    this.esk.setText(a.i.ala_live_prepare_locating);
                } else {
                    this.esk.setText(a.i.ala_live_prepare_locate_opened_title);
                }
            } else {
                this.esk.setText(a.i.ala_live_prepare_locate_opened_title);
            }
        } else {
            this.esk.setText(a.i.ala_live_prepare_locate_title);
        }
        this.esj.setSelected(!this.isShowLocation);
        this.esk.setTextColor(this.isShowLocation ? this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_g) : this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aWW() {
        this.isShowLocation = aWR();
        aWV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String aWX() {
        return this.esl;
    }

    public boolean isShowLocation() {
        return this.isShowLocation;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.esn);
        MessageManager.getInstance().unRegisterListener(this.eso);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
