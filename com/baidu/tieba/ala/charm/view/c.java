package com.baidu.tieba.ala.charm.view;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.ala.charm.ALaCharmCardActivity;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private AlaLiveRoomPanelTabHost NE;
    private boolean PW;
    private View contentView;
    private ImageView dFP;
    private RelativeLayout dFR;
    private TextView dFS;
    private ALaCharmCardActivity dFo;
    private com.baidu.tieba.ala.charm.c dGy;
    private View mRootView;
    private List<com.baidu.live.liveroom.c.d> NB = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.dFP) {
                if (c.this.dFS.getVisibility() == 0) {
                    c.this.dFS.setVisibility(8);
                } else {
                    c.this.dFS.setVisibility(0);
                }
            } else if (view == c.this.dFR && c.this.dFS.getVisibility() == 0) {
                c.this.dFS.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.dFo = aLaCharmCardActivity;
        initView();
        aKA();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.dFo).inflate(a.h.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        pC();
        this.NE = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.NE.setIndicatorWidthAuto(true);
        this.NE.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.NB.isEmpty() && i <= c.this.NB.size() - 1) {
                    com.baidu.live.liveroom.c.d dVar = (com.baidu.live.liveroom.c.d) c.this.NB.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        String mw = com.baidu.tieba.ala.charm.d.mw(aVar.aKw());
                        if (c.this.PW) {
                            alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                        } else {
                            alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                        }
                        alaStaticItem.addParams("other_params", c.this.otherParams);
                        alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, mw);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        aVar.aKv().aKz();
                    }
                }
            }
        });
        this.dFP = (ImageView) this.mRootView.findViewById(a.g.ala_charm_help_img);
        this.dFP.setOnClickListener(this.mClickListener);
        this.dFS = (TextView) this.mRootView.findViewById(a.g.ala_charm_help_tips);
        this.dFR = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_title_layout);
        this.dFR.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void aKA() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.dFo.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.PW = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_ID);
        String stringExtra8 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_NAME);
        String stringExtra9 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGINUSER_PORTRAIT);
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        long longExtra = intent.getLongExtra(AlaCharmCardActivityConfig.ONLINE_COUNT, 0L);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.dFo, 3);
        aVar.sJ(stringExtra3).sG(stringExtra4).sE(stringExtra).gM(this.PW).sH(stringExtra5).sF(stringExtra2).sI(stringExtra6).sK(stringExtra7).sL(stringExtra8).sM(stringExtra9).sN(this.otherParams).nw();
        this.NB.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.dFo, 2);
        aVar2.sJ(stringExtra3).sG(stringExtra4).sE(stringExtra).gM(this.PW).sH(stringExtra5).sF(stringExtra2).sI(stringExtra6).sK(stringExtra7).sL(stringExtra8).sM(stringExtra9).sN(this.otherParams).nw();
        this.NB.add(aVar2);
        this.dGy = new com.baidu.tieba.ala.charm.c(this.dFo);
        this.dGy.sP(stringExtra4).gO(this.PW).sQ(stringExtra5).sR(stringExtra6).nw();
        this.dGy.bV(longExtra);
        this.NB.add(this.dGy);
        this.NE.setData(this.NB);
        if (this.PW) {
            alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
        } else {
            alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
        }
        alaStaticItem.addParams("other_params", this.otherParams);
        alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
        if (this.NB != null && this.NB.size() > 0 && (this.NB.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.NB.get(0)).aKv().aKz();
        }
    }

    public void T(String str, boolean z) {
        for (com.baidu.live.liveroom.c.d dVar : this.NB) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).T(str, z);
            }
        }
    }

    public void bV(long j) {
        if (this.dGy != null) {
            this.dGy.bV(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.c.d dVar : this.NB) {
            dVar.onDestroy();
        }
    }

    public void pC() {
        if (this.dFo != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.dFo) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.f.ala_charm_corner_bg);
            }
            if (this.NB != null) {
                for (com.baidu.live.liveroom.c.d dVar : this.NB) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).pC();
                    }
                }
            }
        }
    }
}
