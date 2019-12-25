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
import com.baidu.live.q.a;
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
    private ViewGroup fhJ;
    private ImageView fhK;
    private TextView fhL;
    private String fhM;
    private Runnable fhN = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.e.1
        @Override // java.lang.Runnable
        public void run() {
            e.this.mHandler.removeCallbacks(this);
            if (e.this.count > 2) {
                e.this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            e.this.isShowLocation = e.this.boD();
            e.this.boH();
            e.this.mHandler.postDelayed(this, 3000L);
            e.d(e.this);
        }
    };
    private CustomMessageListener fhO = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.ala.liveroom.views.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                e.this.isShowLocation = e.this.boD();
                if (e.this.isShowLocation) {
                    e.this.fhL.setText(a.i.ala_live_prepare_locating);
                } else {
                    e.this.fhL.setText(a.i.ala_live_prepare_locate_title);
                }
            }
            e.this.mHandler.postDelayed(e.this.fhN, 3000L);
        }
    };
    private CustomMessageListener fhP = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.ala.liveroom.views.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.isShowLocation = e.this.boD();
            e.this.boH();
            if (e.this.boD()) {
                LocationInfo locationInfo = e.this.mLocation.getLocationInfo();
                if (locationInfo == null || StringUtils.isNull(locationInfo.getCurCityName())) {
                    e.this.fhL.setText(a.i.ala_live_prepare_locate_fail);
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
        this.isShowLocation = boD();
        MessageManager.getInstance().registerListener(this.fhO);
        MessageManager.getInstance().registerListener(this.fhP);
        this.mHandler = new Handler();
    }

    public void aj(ViewGroup viewGroup) {
        this.fhJ = viewGroup;
        this.fhK = (ImageView) viewGroup.findViewById(a.g.ala_live_prepare_locate_img);
        this.fhL = (TextView) viewGroup.findViewById(a.g.ala_live_prepare_locate_tv);
        this.mLocation = LocationManager.getInstance().buildLocation();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan()) {
            if (!checkPermission()) {
                boG();
            } else {
                boH();
            }
        } else {
            boH();
        }
        this.fhJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.boE();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean boD() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkE() {
        boolean z = false;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            com.baidu.live.c.oI().getBoolean("has_request_location", false);
            com.baidu.live.c.oI().putBoolean("has_request_location", true);
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
    public void boE() {
        if (this.isShowLocation) {
            LogManager.getLiveRecordLogger().doClickLiveLocationAlreadyButtonLog("");
        } else {
            LogManager.getLiveRecordLogger().doClickLiveLocationAllowButtonLog("");
        }
        if (!bkE()) {
            this.isShowLocation = !this.isShowLocation;
            boF();
        }
    }

    private void boF() {
        boH();
    }

    private void boG() {
        if (!com.baidu.live.c.oI().getBoolean("has_master_show_location_dialog", false)) {
            com.baidu.live.c.oI().putBoolean("has_master_show_location_dialog", true);
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
                    e.this.bkE();
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
    public void boH() {
        if (this.isShowLocation) {
            if (this.mLocation != null) {
                LocationInfo locationInfo = this.mLocation.getLocationInfo();
                if (locationInfo != null && !StringUtils.isNull(locationInfo.getCurCityName())) {
                    this.fhL.setText(locationInfo.getCurCityName());
                    this.fhM = locationInfo.getCurCityName();
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                    this.fhL.setText(a.i.ala_live_prepare_locating);
                } else {
                    this.fhL.setText(a.i.ala_live_prepare_locate_opened_title);
                }
            } else {
                this.fhL.setText(a.i.ala_live_prepare_locate_opened_title);
            }
        } else {
            this.fhL.setText(a.i.ala_live_prepare_locate_title);
        }
        this.fhK.setSelected(!this.isShowLocation);
        this.fhL.setTextColor(this.isShowLocation ? this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_g) : this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_i_alpha50));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void boI() {
        this.isShowLocation = boD();
        boH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String boJ() {
        return this.fhM;
    }

    public boolean isShowLocation() {
        return this.isShowLocation;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.fhO);
        MessageManager.getInstance().unRegisterListener(this.fhP);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
