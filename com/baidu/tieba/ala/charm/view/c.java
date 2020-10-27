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
    private AlaLiveRoomPanelTabHost aFp;
    private boolean aJi;
    private View contentView;
    private ALaCharmCardActivity gpy;
    private ImageView gqA;
    private RelativeLayout gqC;
    private TextView gqD;
    private com.baidu.tieba.ala.charm.e grn;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> aFm = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.gqA) {
                if (c.this.gqD.getVisibility() == 0) {
                    c.this.gqD.setVisibility(8);
                } else {
                    c.this.gqD.setVisibility(0);
                }
            } else if (view == c.this.gqC && c.this.gqD.getVisibility() == 0) {
                c.this.gqD.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gpy = aLaCharmCardActivity;
        initView();
        bOU();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.gpy).inflate(a.h.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        Gh();
        this.aFp = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.aFp.setIndicatorWidthAuto(true);
        this.aFp.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.aFm.isEmpty() && i <= c.this.aFm.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.aFm.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            String ui = com.baidu.tieba.ala.charm.g.ui(aVar.bOD());
                            if (c.this.aJi) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, ui);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bOC().bOT();
                    }
                }
            }
        });
        this.gqA = (ImageView) this.mRootView.findViewById(a.g.ala_charm_help_img);
        this.gqA.setOnClickListener(this.mClickListener);
        this.gqD = (TextView) this.mRootView.findViewById(a.g.ala_charm_help_tips);
        this.gqC = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_title_layout);
        this.gqC.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bOU() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.gpy.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.aJi = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra("login_user_id");
        String stringExtra8 = intent.getStringExtra("login_user_name");
        String stringExtra9 = intent.getStringExtra("login_user_portrait");
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.grn = new com.baidu.tieba.ala.charm.e(this.gpy);
        this.grn.Gz(stringExtra4).lO(this.aJi).GA(stringExtra5).GB(stringExtra6).GC(stringExtra2).GD(stringExtra7).createView();
        this.aFm.add(this.grn);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.gpy, 3);
        aVar.Gu(stringExtra3).Gr(stringExtra4).Gp(stringExtra).lN(this.aJi).Gs(stringExtra5).Gq(stringExtra2).Gt(stringExtra6).Gv(stringExtra7).Gw(stringExtra8).Gx(stringExtra9).Gy(this.otherParams).createView();
        this.aFm.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.gpy, 2);
        aVar2.Gu(stringExtra3).Gr(stringExtra4).Gp(stringExtra).lN(this.aJi).Gs(stringExtra5).Gq(stringExtra2).Gt(stringExtra6).Gv(stringExtra7).Gw(stringExtra8).Gx(stringExtra9).Gy(this.otherParams).createView();
        this.aFm.add(aVar2);
        this.aFp.setData(this.aFm);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (this.aJi) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aFm != null && this.aFm.size() > 0 && (this.aFm.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.aFm.get(0)).bOC().bOT();
        }
    }

    public void az(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aFm) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).az(str, z);
            }
        }
    }

    public void ea(long j) {
        if (this.grn != null) {
            this.grn.ea(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aFm) {
            dVar.onDestroy();
        }
    }

    public void Gh() {
        if (this.gpy != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.gpy) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.f.ala_charm_corner_bg);
            }
            if (this.aFm != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.aFm) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).Gh();
                    }
                }
            }
        }
    }
}
