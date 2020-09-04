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
    private AlaLiveRoomPanelTabHost aBw;
    private boolean aEy;
    private View contentView;
    private ALaCharmCardActivity fPR;
    private ImageView fQT;
    private RelativeLayout fQV;
    private TextView fQW;
    private com.baidu.tieba.ala.charm.e fRG;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> aBt = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.fQT) {
                if (c.this.fQW.getVisibility() == 0) {
                    c.this.fQW.setVisibility(8);
                } else {
                    c.this.fQW.setVisibility(0);
                }
            } else if (view == c.this.fQV && c.this.fQW.getVisibility() == 0) {
                c.this.fQW.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.fPR = aLaCharmCardActivity;
        initView();
        bIA();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.fPR).inflate(a.h.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        EF();
        this.aBw = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.aBw.setIndicatorWidthAuto(true);
        this.aBw.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.aBt.isEmpty() && i <= c.this.aBt.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.aBt.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            String sY = com.baidu.tieba.ala.charm.g.sY(aVar.bIj());
                            if (c.this.aEy) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, sY);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bIi().bIz();
                    }
                }
            }
        });
        this.fQT = (ImageView) this.mRootView.findViewById(a.g.ala_charm_help_img);
        this.fQT.setOnClickListener(this.mClickListener);
        this.fQW = (TextView) this.mRootView.findViewById(a.g.ala_charm_help_tips);
        this.fQV = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_title_layout);
        this.fQV.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bIA() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.fPR.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.aEy = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_ID);
        String stringExtra8 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_NAME);
        String stringExtra9 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGINUSER_PORTRAIT);
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.fRG = new com.baidu.tieba.ala.charm.e(this.fPR);
        this.fRG.ES(stringExtra4).kX(this.aEy).ET(stringExtra5).EU(stringExtra6).EV(stringExtra2).EW(stringExtra7).createView();
        this.aBt.add(this.fRG);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.fPR, 3);
        aVar.EN(stringExtra3).EK(stringExtra4).EI(stringExtra).kV(this.aEy).EL(stringExtra5).EJ(stringExtra2).EM(stringExtra6).EO(stringExtra7).EP(stringExtra8).EQ(stringExtra9).ER(this.otherParams).createView();
        this.aBt.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.fPR, 2);
        aVar2.EN(stringExtra3).EK(stringExtra4).EI(stringExtra).kV(this.aEy).EL(stringExtra5).EJ(stringExtra2).EM(stringExtra6).EO(stringExtra7).EP(stringExtra8).EQ(stringExtra9).ER(this.otherParams).createView();
        this.aBt.add(aVar2);
        this.aBw.setData(this.aBt);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            if (this.aEy) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aBt != null && this.aBt.size() > 0 && (this.aBt.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.aBt.get(0)).bIi().bIz();
        }
    }

    public void at(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aBt) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).at(str, z);
            }
        }
    }

    public void dO(long j) {
        if (this.fRG != null) {
            this.fRG.dO(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aBt) {
            dVar.onDestroy();
        }
    }

    public void EF() {
        if (this.fPR != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.fPR) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.f.ala_charm_corner_bg);
            }
            if (this.aBt != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.aBt) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).EF();
                    }
                }
            }
        }
    }
}
