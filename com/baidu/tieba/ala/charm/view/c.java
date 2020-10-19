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
    private AlaLiveRoomPanelTabHost aFh;
    private boolean aIH;
    private View contentView;
    private ALaCharmCardActivity gfv;
    private TextView ggA;
    private ImageView ggx;
    private RelativeLayout ggz;
    private com.baidu.tieba.ala.charm.e ghk;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> aFe = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.ggx) {
                if (c.this.ggA.getVisibility() == 0) {
                    c.this.ggA.setVisibility(8);
                } else {
                    c.this.ggA.setVisibility(0);
                }
            } else if (view == c.this.ggz && c.this.ggA.getVisibility() == 0) {
                c.this.ggA.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gfv = aLaCharmCardActivity;
        initView();
        bMs();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.gfv).inflate(a.h.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        FS();
        this.aFh = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.aFh.setIndicatorWidthAuto(true);
        this.aFh.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.aFe.isEmpty() && i <= c.this.aFe.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.aFe.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            String tP = com.baidu.tieba.ala.charm.g.tP(aVar.bMb());
                            if (c.this.aIH) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, tP);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bMa().bMr();
                    }
                }
            }
        });
        this.ggx = (ImageView) this.mRootView.findViewById(a.g.ala_charm_help_img);
        this.ggx.setOnClickListener(this.mClickListener);
        this.ggA = (TextView) this.mRootView.findViewById(a.g.ala_charm_help_tips);
        this.ggz = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_title_layout);
        this.ggz.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bMs() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.gfv.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.aIH = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra("login_user_id");
        String stringExtra8 = intent.getStringExtra("login_user_name");
        String stringExtra9 = intent.getStringExtra("login_user_portrait");
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.ghk = new com.baidu.tieba.ala.charm.e(this.gfv);
        this.ghk.Ga(stringExtra4).lx(this.aIH).Gb(stringExtra5).Gc(stringExtra6).Gd(stringExtra2).Ge(stringExtra7).createView();
        this.aFe.add(this.ghk);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.gfv, 3);
        aVar.FV(stringExtra3).FS(stringExtra4).FQ(stringExtra).lv(this.aIH).FT(stringExtra5).FR(stringExtra2).FU(stringExtra6).FW(stringExtra7).FX(stringExtra8).FY(stringExtra9).FZ(this.otherParams).createView();
        this.aFe.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.gfv, 2);
        aVar2.FV(stringExtra3).FS(stringExtra4).FQ(stringExtra).lv(this.aIH).FT(stringExtra5).FR(stringExtra2).FU(stringExtra6).FW(stringExtra7).FX(stringExtra8).FY(stringExtra9).FZ(this.otherParams).createView();
        this.aFe.add(aVar2);
        this.aFh.setData(this.aFe);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (this.aIH) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aFe != null && this.aFe.size() > 0 && (this.aFe.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.aFe.get(0)).bMa().bMr();
        }
    }

    public void ax(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aFe) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).ax(str, z);
            }
        }
    }

    public void dY(long j) {
        if (this.ghk != null) {
            this.ghk.dY(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aFe) {
            dVar.onDestroy();
        }
    }

    public void FS() {
        if (this.gfv != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.gfv) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.f.ala_charm_corner_bg);
            }
            if (this.aFe != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.aFe) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).FS();
                    }
                }
            }
        }
    }
}
