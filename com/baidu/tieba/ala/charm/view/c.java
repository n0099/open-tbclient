package com.baidu.tieba.ala.charm.view;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.ala.charm.ALaCharmCardActivity;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    private AlaLiveRoomPanelTabHost aBu;
    private boolean aEw;
    private View contentView;
    private ALaCharmCardActivity fPN;
    private ImageView fQP;
    private RelativeLayout fQR;
    private TextView fQS;
    private com.baidu.tieba.ala.charm.e fRC;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> aBr = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.fQP) {
                if (c.this.fQS.getVisibility() == 0) {
                    c.this.fQS.setVisibility(8);
                } else {
                    c.this.fQS.setVisibility(0);
                }
            } else if (view == c.this.fQR && c.this.fQS.getVisibility() == 0) {
                c.this.fQS.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.fPN = aLaCharmCardActivity;
        initView();
        bIz();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.fPN).inflate(a.h.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        EF();
        this.aBu = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.aBu.setIndicatorWidthAuto(true);
        this.aBu.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.aBr.isEmpty() && i <= c.this.aBr.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.aBr.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            String sY = com.baidu.tieba.ala.charm.g.sY(aVar.bIi());
                            if (c.this.aEw) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, sY);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bIh().bIy();
                    }
                }
            }
        });
        this.fQP = (ImageView) this.mRootView.findViewById(a.g.ala_charm_help_img);
        this.fQP.setOnClickListener(this.mClickListener);
        this.fQS = (TextView) this.mRootView.findViewById(a.g.ala_charm_help_tips);
        this.fQR = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_title_layout);
        this.fQR.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bIz() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.fPN.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.aEw = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_ID);
        String stringExtra8 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_NAME);
        String stringExtra9 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGINUSER_PORTRAIT);
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.fRC = new com.baidu.tieba.ala.charm.e(this.fPN);
        this.fRC.ER(stringExtra4).kV(this.aEw).ES(stringExtra5).ET(stringExtra6).EU(stringExtra2).EV(stringExtra7).createView();
        this.aBr.add(this.fRC);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.fPN, 3);
        aVar.EM(stringExtra3).EJ(stringExtra4).EH(stringExtra).kT(this.aEw).EK(stringExtra5).EI(stringExtra2).EL(stringExtra6).EN(stringExtra7).EO(stringExtra8).EP(stringExtra9).EQ(this.otherParams).createView();
        this.aBr.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.fPN, 2);
        aVar2.EM(stringExtra3).EJ(stringExtra4).EH(stringExtra).kT(this.aEw).EK(stringExtra5).EI(stringExtra2).EL(stringExtra6).EN(stringExtra7).EO(stringExtra8).EP(stringExtra9).EQ(this.otherParams).createView();
        this.aBr.add(aVar2);
        this.aBu.setData(this.aBr);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            if (this.aEw) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aBr != null && this.aBr.size() > 0 && (this.aBr.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.aBr.get(0)).bIh().bIy();
        }
    }

    public void at(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aBr) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).at(str, z);
            }
        }
    }

    public void dO(long j) {
        if (this.fRC != null) {
            this.fRC.dO(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aBr) {
            dVar.onDestroy();
        }
    }

    public void EF() {
        if (this.fPN != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.fPN) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.f.ala_charm_corner_bg);
            }
            if (this.aBr != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.aBr) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).EF();
                    }
                }
            }
        }
    }
}
