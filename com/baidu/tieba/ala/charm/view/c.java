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
/* loaded from: classes10.dex */
public class c {
    private AlaLiveRoomPanelTabHost aFR;
    private boolean aLc;
    private View contentView;
    private ALaCharmCardActivity gPn;
    private ImageView gQo;
    private RelativeLayout gQq;
    private TextView gQr;
    private com.baidu.tieba.ala.charm.e gRd;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> aFO = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.gQo) {
                if (c.this.gQr.getVisibility() == 0) {
                    c.this.gQr.setVisibility(8);
                } else {
                    c.this.gQr.setVisibility(0);
                }
            } else if (view == c.this.gQq && c.this.gQr.getVisibility() == 0) {
                c.this.gQr.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gPn = aLaCharmCardActivity;
        initView();
        bUb();
    }

    public final void initView() {
        this.mRootView = LayoutInflater.from(this.gPn).inflate(a.g.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        EN();
        this.aFR = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.aFR.setIndicatorWidthAuto(true);
        this.aFR.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.aFO.isEmpty() && i <= c.this.aFO.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.aFO.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            String uk = com.baidu.tieba.ala.charm.g.uk(aVar.bTL());
                            if (c.this.aLc) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, uk);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bTK().bUa();
                    }
                }
            }
        });
        this.gQo = (ImageView) this.mRootView.findViewById(a.f.ala_charm_help_img);
        this.gQo.setOnClickListener(this.mClickListener);
        this.gQr = (TextView) this.mRootView.findViewById(a.f.ala_charm_help_tips);
        this.gQq = (RelativeLayout) this.mRootView.findViewById(a.f.ala_charm_title_layout);
        this.gQq.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bUb() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.gPn.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.aLc = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra("login_user_id");
        String stringExtra8 = intent.getStringExtra("login_user_name");
        String stringExtra9 = intent.getStringExtra("login_user_portrait");
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.gRd = new com.baidu.tieba.ala.charm.e(this.gPn);
        this.gRd.Gy(stringExtra4).mT(this.aLc).Gz(stringExtra5).GA(stringExtra6).GB(stringExtra2).GC(stringExtra7).createView();
        this.aFO.add(this.gRd);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.gPn, 3);
        aVar.Gt(stringExtra3).Gq(stringExtra4).Go(stringExtra).mS(this.aLc).Gr(stringExtra5).Gp(stringExtra2).Gs(stringExtra6).Gu(stringExtra7).Gv(stringExtra8).Gw(stringExtra9).Gx(this.otherParams).createView();
        this.aFO.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.gPn, 2);
        aVar2.Gt(stringExtra3).Gq(stringExtra4).Go(stringExtra).mS(this.aLc).Gr(stringExtra5).Gp(stringExtra2).Gs(stringExtra6).Gu(stringExtra7).Gv(stringExtra8).Gw(stringExtra9).Gx(this.otherParams).createView();
        this.aFO.add(aVar2);
        this.aFR.setData(this.aFO);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (this.aLc) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aFO != null && this.aFO.size() > 0 && (this.aFO.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.aFO.get(0)).bTK().bUa();
        }
    }

    public void aA(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aFO) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).aA(str, z);
            }
        }
    }

    public void ff(long j) {
        if (this.gRd != null) {
            this.gRd.ff(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aFO) {
            dVar.onDestroy();
        }
    }

    public void EN() {
        if (this.gPn != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.gPn) == 2) {
                this.contentView.setBackgroundResource(a.e.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.e.ala_charm_corner_bg);
            }
            if (this.aFO != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.aFO) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).EN();
                    }
                }
            }
        }
    }
}
