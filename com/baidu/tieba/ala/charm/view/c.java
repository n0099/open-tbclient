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
    private AlaLiveRoomPanelTabHost aol;
    private boolean aqL;
    private View contentView;
    private ALaCharmCardActivity faj;
    private com.baidu.tieba.ala.charm.e fbX;
    private ImageView fbk;
    private RelativeLayout fbm;
    private TextView fbn;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> aoi = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.fbk) {
                if (c.this.fbn.getVisibility() == 0) {
                    c.this.fbn.setVisibility(8);
                } else {
                    c.this.fbn.setVisibility(0);
                }
            } else if (view == c.this.fbm && c.this.fbn.getVisibility() == 0) {
                c.this.fbn.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.faj = aLaCharmCardActivity;
        initView();
        bnv();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.faj).inflate(a.h.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        wK();
        this.aol = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.aol.setIndicatorWidthAuto(true);
        this.aol.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.aoi.isEmpty() && i <= c.this.aoi.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.aoi.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            String pv = com.baidu.tieba.ala.charm.g.pv(aVar.bni());
                            if (c.this.aqL) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, pv);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bnh().bnu();
                    }
                }
            }
        });
        this.fbk = (ImageView) this.mRootView.findViewById(a.g.ala_charm_help_img);
        this.fbk.setOnClickListener(this.mClickListener);
        this.fbn = (TextView) this.mRootView.findViewById(a.g.ala_charm_help_tips);
        this.fbm = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_title_layout);
        this.fbm.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bnv() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.faj.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.aqL = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_ID);
        String stringExtra8 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_NAME);
        String stringExtra9 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGINUSER_PORTRAIT);
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.fbX = new com.baidu.tieba.ala.charm.e(this.faj);
        this.fbX.zD(stringExtra4).jn(this.aqL).zE(stringExtra5).zF(stringExtra6).zG(stringExtra2).zH(stringExtra7).createView();
        this.aoi.add(this.fbX);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.faj, 3);
        aVar.zy(stringExtra3).zv(stringExtra4).zt(stringExtra).jl(this.aqL).zw(stringExtra5).zu(stringExtra2).zx(stringExtra6).zz(stringExtra7).zA(stringExtra8).zB(stringExtra9).zC(this.otherParams).createView();
        this.aoi.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.faj, 2);
        aVar2.zy(stringExtra3).zv(stringExtra4).zt(stringExtra).jl(this.aqL).zw(stringExtra5).zu(stringExtra2).zx(stringExtra6).zz(stringExtra7).zA(stringExtra8).zB(stringExtra9).zC(this.otherParams).createView();
        this.aoi.add(aVar2);
        this.aol.setData(this.aoi);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            if (this.aqL) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aoi != null && this.aoi.size() > 0 && (this.aoi.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.aoi.get(0)).bnh().bnu();
        }
    }

    public void ac(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aoi) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).ac(str, z);
            }
        }
    }

    public void dk(long j) {
        if (this.fbX != null) {
            this.fbX.dk(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aoi) {
            dVar.onDestroy();
        }
    }

    public void wK() {
        if (this.faj != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.faj) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.f.ala_charm_corner_bg);
            }
            if (this.aoi != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.aoi) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).wK();
                    }
                }
            }
        }
    }
}
