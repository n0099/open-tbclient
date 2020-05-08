package com.baidu.tieba.ala.charm.view;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.charm.ALaCharmCardActivity;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private AlaLiveRoomPanelTabHost aor;
    private boolean aqR;
    private View contentView;
    private ALaCharmCardActivity fao;
    private ImageView fbp;
    private RelativeLayout fbr;
    private TextView fbs;
    private com.baidu.tieba.ala.charm.e fcc;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> aoo = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.fbp) {
                if (c.this.fbs.getVisibility() == 0) {
                    c.this.fbs.setVisibility(8);
                } else {
                    c.this.fbs.setVisibility(0);
                }
            } else if (view == c.this.fbr && c.this.fbs.getVisibility() == 0) {
                c.this.fbs.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.fao = aLaCharmCardActivity;
        initView();
        bnt();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.fao).inflate(a.h.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        wJ();
        this.aor = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.aor.setIndicatorWidthAuto(true);
        this.aor.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.aoo.isEmpty() && i <= c.this.aoo.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.aoo.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            String pv = com.baidu.tieba.ala.charm.g.pv(aVar.bng());
                            if (c.this.aqR) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, pv);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bnf().bns();
                    }
                }
            }
        });
        this.fbp = (ImageView) this.mRootView.findViewById(a.g.ala_charm_help_img);
        this.fbp.setOnClickListener(this.mClickListener);
        this.fbs = (TextView) this.mRootView.findViewById(a.g.ala_charm_help_tips);
        this.fbr = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_title_layout);
        this.fbr.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bnt() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.fao.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.aqR = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_ID);
        String stringExtra8 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_NAME);
        String stringExtra9 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGINUSER_PORTRAIT);
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.fcc = new com.baidu.tieba.ala.charm.e(this.fao);
        this.fcc.zG(stringExtra4).jn(this.aqR).zH(stringExtra5).zI(stringExtra6).zJ(stringExtra2).zK(stringExtra7).createView();
        this.aoo.add(this.fcc);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.fao, 3);
        aVar.zB(stringExtra3).zy(stringExtra4).zw(stringExtra).jl(this.aqR).zz(stringExtra5).zx(stringExtra2).zA(stringExtra6).zC(stringExtra7).zD(stringExtra8).zE(stringExtra9).zF(this.otherParams).createView();
        this.aoo.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.fao, 2);
        aVar2.zB(stringExtra3).zy(stringExtra4).zw(stringExtra).jl(this.aqR).zz(stringExtra5).zx(stringExtra2).zA(stringExtra6).zC(stringExtra7).zD(stringExtra8).zE(stringExtra9).zF(this.otherParams).createView();
        this.aoo.add(aVar2);
        this.aor.setData(this.aoo);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            if (this.aqR) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aoo != null && this.aoo.size() > 0 && (this.aoo.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.aoo.get(0)).bnf().bns();
        }
    }

    public void ac(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aoo) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).ac(str, z);
            }
        }
    }

    public void dk(long j) {
        if (this.fcc != null) {
            this.fcc.dk(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aoo) {
            dVar.onDestroy();
        }
    }

    public void wJ() {
        if (this.fao != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.fao) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.f.ala_charm_corner_bg);
            }
            if (this.aoo != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.aoo) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).wJ();
                    }
                }
            }
        }
    }
}
