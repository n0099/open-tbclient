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
    private AlaLiveRoomPanelTabHost aCc;
    private boolean aFD;
    private View contentView;
    private ALaCharmCardActivity fTc;
    private com.baidu.tieba.ala.charm.e fUR;
    private ImageView fUe;
    private RelativeLayout fUg;
    private TextView fUh;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> aBZ = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.fUe) {
                if (c.this.fUh.getVisibility() == 0) {
                    c.this.fUh.setVisibility(8);
                } else {
                    c.this.fUh.setVisibility(0);
                }
            } else if (view == c.this.fUg && c.this.fUh.getVisibility() == 0) {
                c.this.fUh.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.fTc = aLaCharmCardActivity;
        initView();
        bJI();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.fTc).inflate(a.h.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        EW();
        this.aCc = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.aCc.setIndicatorWidthAuto(true);
        this.aCc.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.aBZ.isEmpty() && i <= c.this.aBZ.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.aBZ.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            String tr = com.baidu.tieba.ala.charm.g.tr(aVar.bJr());
                            if (c.this.aFD) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, tr);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bJq().bJH();
                    }
                }
            }
        });
        this.fUe = (ImageView) this.mRootView.findViewById(a.g.ala_charm_help_img);
        this.fUe.setOnClickListener(this.mClickListener);
        this.fUh = (TextView) this.mRootView.findViewById(a.g.ala_charm_help_tips);
        this.fUg = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_title_layout);
        this.fUg.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bJI() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.fTc.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.aFD = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra("login_user_id");
        String stringExtra8 = intent.getStringExtra("login_user_name");
        String stringExtra9 = intent.getStringExtra("login_user_portrait");
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.fUR = new com.baidu.tieba.ala.charm.e(this.fTc);
        this.fUR.Fp(stringExtra4).kZ(this.aFD).Fq(stringExtra5).Fr(stringExtra6).Fs(stringExtra2).Ft(stringExtra7).createView();
        this.aBZ.add(this.fUR);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.fTc, 3);
        aVar.Fk(stringExtra3).Fh(stringExtra4).Ff(stringExtra).kX(this.aFD).Fi(stringExtra5).Fg(stringExtra2).Fj(stringExtra6).Fl(stringExtra7).Fm(stringExtra8).Fn(stringExtra9).Fo(this.otherParams).createView();
        this.aBZ.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.fTc, 2);
        aVar2.Fk(stringExtra3).Fh(stringExtra4).Ff(stringExtra).kX(this.aFD).Fi(stringExtra5).Fg(stringExtra2).Fj(stringExtra6).Fl(stringExtra7).Fm(stringExtra8).Fn(stringExtra9).Fo(this.otherParams).createView();
        this.aBZ.add(aVar2);
        this.aCc.setData(this.aBZ);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            if (this.aFD) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aBZ != null && this.aBZ.size() > 0 && (this.aBZ.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.aBZ.get(0)).bJq().bJH();
        }
    }

    public void at(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aBZ) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).at(str, z);
            }
        }
    }

    public void dP(long j) {
        if (this.fUR != null) {
            this.fUR.dP(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aBZ) {
            dVar.onDestroy();
        }
    }

    public void EW() {
        if (this.fTc != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.fTc) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.f.ala_charm_corner_bg);
            }
            if (this.aBZ != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.aBZ) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).EW();
                    }
                }
            }
        }
    }
}
