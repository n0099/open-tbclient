package com.baidu.tieba.ala.charm.view;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.ala.charm.ALaCharmCardActivity;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private AlaLiveRoomPanelTabHost Uq;
    private boolean WF;
    private View contentView;
    private ALaCharmCardActivity ery;
    private com.baidu.tieba.ala.charm.c esV;
    private ImageView esn;
    private RelativeLayout esp;
    private TextView esq;
    private View mRootView;
    private List<com.baidu.live.liveroom.c.d> Un = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.esn) {
                if (c.this.esq.getVisibility() == 0) {
                    c.this.esq.setVisibility(8);
                } else {
                    c.this.esq.setVisibility(0);
                }
            } else if (view == c.this.esp && c.this.esq.getVisibility() == 0) {
                c.this.esq.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.ery = aLaCharmCardActivity;
        initView();
        bbJ();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.ery).inflate(a.h.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        rl();
        this.Uq = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.Uq.setIndicatorWidthAuto(true);
        this.Uq.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.Un.isEmpty() && i <= c.this.Un.size() - 1) {
                    com.baidu.live.liveroom.c.d dVar = (com.baidu.live.liveroom.c.d) c.this.Un.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            String oH = com.baidu.tieba.ala.charm.e.oH(aVar.bbA());
                            if (c.this.WF) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oH);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bbz().bbI();
                    }
                }
            }
        });
        this.esn = (ImageView) this.mRootView.findViewById(a.g.ala_charm_help_img);
        this.esn.setOnClickListener(this.mClickListener);
        this.esq = (TextView) this.mRootView.findViewById(a.g.ala_charm_help_tips);
        this.esp = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_title_layout);
        this.esp.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bbJ() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.ery.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.WF = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_ID);
        String stringExtra8 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_NAME);
        String stringExtra9 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGINUSER_PORTRAIT);
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        long longExtra = intent.getLongExtra(AlaCharmCardActivityConfig.ONLINE_COUNT, 0L);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.ery, 3);
        aVar.xw(stringExtra3).xt(stringExtra4).xr(stringExtra).ib(this.WF).xu(stringExtra5).xs(stringExtra2).xv(stringExtra6).xx(stringExtra7).xy(stringExtra8).xz(stringExtra9).xA(this.otherParams).createView();
        this.Un.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.ery, 2);
        aVar2.xw(stringExtra3).xt(stringExtra4).xr(stringExtra).ib(this.WF).xu(stringExtra5).xs(stringExtra2).xv(stringExtra6).xx(stringExtra7).xy(stringExtra8).xz(stringExtra9).xA(this.otherParams).createView();
        this.Un.add(aVar2);
        this.esV = new com.baidu.tieba.ala.charm.c(this.ery);
        this.esV.xC(stringExtra4).id(this.WF).xD(stringExtra5).xE(stringExtra6).createView();
        this.esV.cA(longExtra);
        this.Un.add(this.esV);
        this.Uq.setData(this.Un);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            if (this.WF) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.Un != null && this.Un.size() > 0 && (this.Un.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.Un.get(0)).bbz().bbI();
        }
    }

    public void X(String str, boolean z) {
        for (com.baidu.live.liveroom.c.d dVar : this.Un) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).X(str, z);
            }
        }
    }

    public void cA(long j) {
        if (this.esV != null) {
            this.esV.cA(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.c.d dVar : this.Un) {
            dVar.onDestroy();
        }
    }

    public void rl() {
        if (this.ery != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.ery) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.f.ala_charm_corner_bg);
            }
            if (this.Un != null) {
                for (com.baidu.live.liveroom.c.d dVar : this.Un) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).rl();
                    }
                }
            }
        }
    }
}
