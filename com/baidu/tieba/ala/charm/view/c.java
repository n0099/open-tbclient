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
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.ala.charm.ALaCharmCardActivity;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private AlaLiveRoomPanelTabHost aEr;
    private boolean aJC;
    private View contentView;
    private ALaCharmCardActivity gNq;
    private ImageView gOr;
    private RelativeLayout gOt;
    private TextView gOu;
    private com.baidu.tieba.ala.charm.e gPg;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> aEo = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.gOr) {
                if (c.this.gOu.getVisibility() == 0) {
                    c.this.gOu.setVisibility(8);
                } else {
                    c.this.gOu.setVisibility(0);
                }
            } else if (view == c.this.gOt && c.this.gOu.getVisibility() == 0) {
                c.this.gOu.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gNq = aLaCharmCardActivity;
        initView();
        bTO();
    }

    public final void initView() {
        this.mRootView = LayoutInflater.from(this.gNq).inflate(a.g.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        EK();
        this.aEr = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.aEr.setIndicatorWidthAuto(true);
        this.aEr.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.aEo.isEmpty() && i <= c.this.aEo.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.aEo.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            String ui = com.baidu.tieba.ala.charm.g.ui(aVar.bTy());
                            if (c.this.aJC) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, ui);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bTx().bTN();
                    }
                }
            }
        });
        this.gOr = (ImageView) this.mRootView.findViewById(a.f.ala_charm_help_img);
        this.gOr.setOnClickListener(this.mClickListener);
        this.gOu = (TextView) this.mRootView.findViewById(a.f.ala_charm_help_tips);
        this.gOt = (RelativeLayout) this.mRootView.findViewById(a.f.ala_charm_title_layout);
        this.gOt.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bTO() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.gNq.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.aJC = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra("login_user_id");
        String stringExtra8 = intent.getStringExtra("login_user_name");
        String stringExtra9 = intent.getStringExtra("login_user_portrait");
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.gPg = new com.baidu.tieba.ala.charm.e(this.gNq);
        this.gPg.Go(stringExtra4).mT(this.aJC).Gp(stringExtra5).Gq(stringExtra6).Gr(stringExtra2).Gs(stringExtra7).createView();
        this.aEo.add(this.gPg);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.gNq, 3);
        aVar.Gj(stringExtra3).Gg(stringExtra4).Ge(stringExtra).mS(this.aJC).Gh(stringExtra5).Gf(stringExtra2).Gi(stringExtra6).Gk(stringExtra7).Gl(stringExtra8).Gm(stringExtra9).Gn(this.otherParams).createView();
        this.aEo.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.gNq, 2);
        aVar2.Gj(stringExtra3).Gg(stringExtra4).Ge(stringExtra).mS(this.aJC).Gh(stringExtra5).Gf(stringExtra2).Gi(stringExtra6).Gk(stringExtra7).Gl(stringExtra8).Gm(stringExtra9).Gn(this.otherParams).createView();
        this.aEo.add(aVar2);
        this.aEr.setData(this.aEo);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (this.aJC) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aEo != null && this.aEo.size() > 0 && (this.aEo.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.aEo.get(0)).bTx().bTN();
        }
    }

    public void aA(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aEo) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).aA(str, z);
            }
        }
    }

    public void ff(long j) {
        if (this.gPg != null) {
            this.gPg.ff(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aEo) {
            dVar.onDestroy();
        }
    }

    public void EK() {
        if (this.gNq != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.gNq) == 2) {
                this.contentView.setBackgroundResource(a.e.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.e.ala_charm_corner_bg);
            }
            if (this.aEo != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.aEo) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).EK();
                    }
                }
            }
        }
    }
}
