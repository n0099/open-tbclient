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
/* loaded from: classes4.dex */
public class c {
    private AlaLiveRoomPanelTabHost aEu;
    private boolean aIu;
    private View contentView;
    private ALaCharmCardActivity guT;
    private ImageView gvV;
    private RelativeLayout gvX;
    private TextView gvY;
    private com.baidu.tieba.ala.charm.e gwI;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> aEr = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.gvV) {
                if (c.this.gvY.getVisibility() == 0) {
                    c.this.gvY.setVisibility(8);
                } else {
                    c.this.gvY.setVisibility(0);
                }
            } else if (view == c.this.gvX && c.this.gvY.getVisibility() == 0) {
                c.this.gvY.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.guT = aLaCharmCardActivity;
        initView();
        bQN();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.guT).inflate(a.g.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        FZ();
        this.aEu = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.aEu.setIndicatorWidthAuto(true);
        this.aEu.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.aEr.isEmpty() && i <= c.this.aEr.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.aEr.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            String uQ = com.baidu.tieba.ala.charm.g.uQ(aVar.bQw());
                            if (c.this.aIu) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, uQ);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bQv().bQM();
                    }
                }
            }
        });
        this.gvV = (ImageView) this.mRootView.findViewById(a.f.ala_charm_help_img);
        this.gvV.setOnClickListener(this.mClickListener);
        this.gvY = (TextView) this.mRootView.findViewById(a.f.ala_charm_help_tips);
        this.gvX = (RelativeLayout) this.mRootView.findViewById(a.f.ala_charm_title_layout);
        this.gvX.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bQN() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.guT.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.aIu = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra("login_user_id");
        String stringExtra8 = intent.getStringExtra("login_user_name");
        String stringExtra9 = intent.getStringExtra("login_user_portrait");
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.gwI = new com.baidu.tieba.ala.charm.e(this.guT);
        this.gwI.Go(stringExtra4).lY(this.aIu).Gp(stringExtra5).Gq(stringExtra6).Gr(stringExtra2).Gs(stringExtra7).createView();
        this.aEr.add(this.gwI);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.guT, 3);
        aVar.Gj(stringExtra3).Gg(stringExtra4).Ge(stringExtra).lX(this.aIu).Gh(stringExtra5).Gf(stringExtra2).Gi(stringExtra6).Gk(stringExtra7).Gl(stringExtra8).Gm(stringExtra9).Gn(this.otherParams).createView();
        this.aEr.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.guT, 2);
        aVar2.Gj(stringExtra3).Gg(stringExtra4).Ge(stringExtra).lX(this.aIu).Gh(stringExtra5).Gf(stringExtra2).Gi(stringExtra6).Gk(stringExtra7).Gl(stringExtra8).Gm(stringExtra9).Gn(this.otherParams).createView();
        this.aEr.add(aVar2);
        this.aEu.setData(this.aEr);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (this.aIu) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aEr != null && this.aEr.size() > 0 && (this.aEr.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.aEr.get(0)).bQv().bQM();
        }
    }

    public void az(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aEr) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).az(str, z);
            }
        }
    }

    public void ew(long j) {
        if (this.gwI != null) {
            this.gwI.ew(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aEr) {
            dVar.onDestroy();
        }
    }

    public void FZ() {
        if (this.guT != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.guT) == 2) {
                this.contentView.setBackgroundResource(a.e.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.e.ala_charm_corner_bg);
            }
            if (this.aEr != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.aEr) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).FZ();
                    }
                }
            }
        }
    }
}
