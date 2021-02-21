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
    private ALaCharmCardActivity gNE;
    private ImageView gOF;
    private RelativeLayout gOH;
    private TextView gOI;
    private com.baidu.tieba.ala.charm.e gPu;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> aEo = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.gOF) {
                if (c.this.gOI.getVisibility() == 0) {
                    c.this.gOI.setVisibility(8);
                } else {
                    c.this.gOI.setVisibility(0);
                }
            } else if (view == c.this.gOH && c.this.gOI.getVisibility() == 0) {
                c.this.gOI.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gNE = aLaCharmCardActivity;
        initView();
        bTV();
    }

    public final void initView() {
        this.mRootView = LayoutInflater.from(this.gNE).inflate(a.g.ala_charm_activity_layout, (ViewGroup) null);
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
                            String ui = com.baidu.tieba.ala.charm.g.ui(aVar.bTF());
                            if (c.this.aJC) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, ui);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bTE().bTU();
                    }
                }
            }
        });
        this.gOF = (ImageView) this.mRootView.findViewById(a.f.ala_charm_help_img);
        this.gOF.setOnClickListener(this.mClickListener);
        this.gOI = (TextView) this.mRootView.findViewById(a.f.ala_charm_help_tips);
        this.gOH = (RelativeLayout) this.mRootView.findViewById(a.f.ala_charm_title_layout);
        this.gOH.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bTV() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.gNE.getIntent();
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
        this.gPu = new com.baidu.tieba.ala.charm.e(this.gNE);
        this.gPu.Gp(stringExtra4).mT(this.aJC).Gq(stringExtra5).Gr(stringExtra6).Gs(stringExtra2).Gt(stringExtra7).createView();
        this.aEo.add(this.gPu);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.gNE, 3);
        aVar.Gk(stringExtra3).Gh(stringExtra4).Gf(stringExtra).mS(this.aJC).Gi(stringExtra5).Gg(stringExtra2).Gj(stringExtra6).Gl(stringExtra7).Gm(stringExtra8).Gn(stringExtra9).Go(this.otherParams).createView();
        this.aEo.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.gNE, 2);
        aVar2.Gk(stringExtra3).Gh(stringExtra4).Gf(stringExtra).mS(this.aJC).Gi(stringExtra5).Gg(stringExtra2).Gj(stringExtra6).Gl(stringExtra7).Gm(stringExtra8).Gn(stringExtra9).Go(this.otherParams).createView();
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
            ((com.baidu.tieba.ala.charm.a) this.aEo.get(0)).bTE().bTU();
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
        if (this.gPu != null) {
            this.gPu.ff(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aEo) {
            dVar.onDestroy();
        }
    }

    public void EK() {
        if (this.gNE != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.gNE) == 2) {
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
