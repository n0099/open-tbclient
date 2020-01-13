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
import com.baidu.live.r.a;
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
/* loaded from: classes2.dex */
public class e {
    private int count;
    private ViewGroup fkX;
    private ImageView fkY;
    private TextView fkZ;
    private String fla;
    private Runnable flb = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.e.1
        @Override // java.lang.Runnable
        public void run() {
            e.this.mHandler.removeCallbacks(this);
            if (e.this.count > 2) {
                e.this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            e.this.isShowLocation = e.this.bpD();
            e.this.bpH();
            e.this.mHandler.postDelayed(this, 3000L);
            e.d(e.this);
        }
    };
    private CustomMessageListener flc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.ala.liveroom.views.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                e.this.isShowLocation = e.this.bpD();
                if (e.this.isShowLocation) {
                    e.this.fkZ.setText(a.i.ala_live_prepare_locating);
                } else {
                    e.this.fkZ.setText(a.i.ala_live_prepare_locate_title);
                }
            }
            e.this.mHandler.postDelayed(e.this.flb, 3000L);
        }
    };
    private CustomMessageListener fld = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.ala.liveroom.views.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.isShowLocation = e.this.bpD();
            e.this.bpH();
            if (e.this.bpD()) {
                LocationInfo locationInfo = e.this.mLocation.getLocationInfo();
                if (locationInfo == null || StringUtils.isNull(locationInfo.getCurCityName())) {
                    e.this.fkZ.setText(a.i.ala_live_prepare_locate_fail);
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
        this.isShowLocation = bpD();
        MessageManager.getInstance().registerListener(this.flc);
        MessageManager.getInstance().registerListener(this.fld);
        this.mHandler = new Handler();
    }

    public void an(ViewGroup viewGroup) {
        this.fkX = viewGroup;
        this.fkY = (ImageView) viewGroup.findViewById(a.g.ala_live_prepare_locate_img);
        this.fkZ = (TextView) viewGroup.findViewById(a.g.ala_live_prepare_locate_tv);
        this.mLocation = LocationManager.getInstance().buildLocation();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan()) {
            if (!checkPermission()) {
                bpG();
            } else {
                bpH();
            }
        } else {
            bpH();
        }
        this.fkX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.bpE();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bpD() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blA() {
        boolean z = false;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            com.baidu.live.c.oJ().getBoolean("has_request_location", false);
            com.baidu.live.c.oJ().putBoolean("has_request_location", true);
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
    public void bpE() {
        if (this.isShowLocation) {
            LogManager.getLiveRecordLogger().doClickLiveLocationAlreadyButtonLog("");
        } else {
            LogManager.getLiveRecordLogger().doClickLiveLocationAllowButtonLog("");
        }
        if (!blA()) {
            this.isShowLocation = !this.isShowLocation;
            bpF();
        }
    }

    private void bpF() {
        bpH();
    }

    private void bpG() {
        if (!com.baidu.live.c.oJ().getBoolean("has_master_show_location_dialog", false)) {
            com.baidu.live.c.oJ().putBoolean("has_master_show_location_dialog", true);
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
                    e.this.blA();
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
    public void bpH() {
        if (this.isShowLocation) {
            if (this.mLocation != null) {
                LocationInfo locationInfo = this.mLocation.getLocationInfo();
                if (locationInfo != null && !StringUtils.isNull(locationInfo.getCurCityName())) {
                    this.fkZ.setText(locationInfo.getCurCityName());
                    this.fla = locationInfo.getCurCityName();
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                    this.fkZ.setText(a.i.ala_live_prepare_locating);
                } else {
                    this.fkZ.setText(a.i.ala_live_prepare_locate_opened_title);
                }
            } else {
                this.fkZ.setText(a.i.ala_live_prepare_locate_opened_title);
            }
        } else {
            this.fkZ.setText(a.i.ala_live_prepare_locate_title);
        }
        this.fkY.setSelected(!this.isShowLocation);
        this.fkZ.setTextColor(this.isShowLocation ? this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_g) : this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bpI() {
        this.isShowLocation = bpD();
        bpH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String bpJ() {
        return this.fla;
    }

    public boolean isShowLocation() {
        return this.isShowLocation;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.flc);
        MessageManager.getInstance().unRegisterListener(this.fld);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
