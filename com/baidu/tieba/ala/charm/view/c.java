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
    private AlaLiveRoomPanelTabHost Nd;
    private boolean Pr;
    private View contentView;
    private ImageView dEY;
    private ALaCharmCardActivity dEx;
    private com.baidu.tieba.ala.charm.c dFH;
    private RelativeLayout dFa;
    private TextView dFb;
    private View mRootView;
    private List<com.baidu.live.liveroom.c.d> Na = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.dEY) {
                if (c.this.dFb.getVisibility() == 0) {
                    c.this.dFb.setVisibility(8);
                } else {
                    c.this.dFb.setVisibility(0);
                }
            } else if (view == c.this.dFa && c.this.dFb.getVisibility() == 0) {
                c.this.dFb.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.dEx = aLaCharmCardActivity;
        initView();
        aKy();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.dEx).inflate(a.h.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        pC();
        this.Nd = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.Nd.setIndicatorWidthAuto(true);
        this.Nd.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.Na.isEmpty() && i <= c.this.Na.size() - 1) {
                    com.baidu.live.liveroom.c.d dVar = (com.baidu.live.liveroom.c.d) c.this.Na.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        String mv = com.baidu.tieba.ala.charm.d.mv(aVar.aKu());
                        if (c.this.Pr) {
                            alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                        } else {
                            alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                        }
                        alaStaticItem.addParams("other_params", c.this.otherParams);
                        alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, mv);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        aVar.aKt().aKx();
                    }
                }
            }
        });
        this.dEY = (ImageView) this.mRootView.findViewById(a.g.ala_charm_help_img);
        this.dEY.setOnClickListener(this.mClickListener);
        this.dFb = (TextView) this.mRootView.findViewById(a.g.ala_charm_help_tips);
        this.dFa = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_title_layout);
        this.dFa.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void aKy() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.dEx.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.Pr = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_ID);
        String stringExtra8 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_NAME);
        String stringExtra9 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGINUSER_PORTRAIT);
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        long longExtra = intent.getLongExtra(AlaCharmCardActivityConfig.ONLINE_COUNT, 0L);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.dEx, 3);
        aVar.sJ(stringExtra3).sG(stringExtra4).sE(stringExtra).gM(this.Pr).sH(stringExtra5).sF(stringExtra2).sI(stringExtra6).sK(stringExtra7).sL(stringExtra8).sM(stringExtra9).sN(this.otherParams).nw();
        this.Na.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.dEx, 2);
        aVar2.sJ(stringExtra3).sG(stringExtra4).sE(stringExtra).gM(this.Pr).sH(stringExtra5).sF(stringExtra2).sI(stringExtra6).sK(stringExtra7).sL(stringExtra8).sM(stringExtra9).sN(this.otherParams).nw();
        this.Na.add(aVar2);
        this.dFH = new com.baidu.tieba.ala.charm.c(this.dEx);
        this.dFH.sP(stringExtra4).gO(this.Pr).sQ(stringExtra5).sR(stringExtra6).nw();
        this.dFH.bU(longExtra);
        this.Na.add(this.dFH);
        this.Nd.setData(this.Na);
        if (this.Pr) {
            alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
        } else {
            alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
        }
        alaStaticItem.addParams("other_params", this.otherParams);
        alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
        if (this.Na != null && this.Na.size() > 0 && (this.Na.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.Na.get(0)).aKt().aKx();
        }
    }

    public void T(String str, boolean z) {
        for (com.baidu.live.liveroom.c.d dVar : this.Na) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).T(str, z);
            }
        }
    }

    public void bU(long j) {
        if (this.dFH != null) {
            this.dFH.bU(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.c.d dVar : this.Na) {
            dVar.onDestroy();
        }
    }

    public void pC() {
        if (this.dEx != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.dEx) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.f.ala_charm_corner_bg);
            }
            if (this.Na != null) {
                for (com.baidu.live.liveroom.c.d dVar : this.Na) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).pC();
                    }
                }
            }
        }
    }
}
