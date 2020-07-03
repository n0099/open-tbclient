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
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.ala.charm.ALaCharmCardActivity;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private AlaLiveRoomPanelTabHost avn;
    private boolean axZ;
    private View contentView;
    private ImageView fAo;
    private RelativeLayout fAq;
    private TextView fAr;
    private com.baidu.tieba.ala.charm.e fBb;
    private ALaCharmCardActivity fzp;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> avk = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.fAo) {
                if (c.this.fAr.getVisibility() == 0) {
                    c.this.fAr.setVisibility(8);
                } else {
                    c.this.fAr.setVisibility(0);
                }
            } else if (view == c.this.fAq && c.this.fAr.getVisibility() == 0) {
                c.this.fAr.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.fzp = aLaCharmCardActivity;
        initView();
        bwh();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.fzp).inflate(a.h.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        yA();
        this.avn = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.avn.setIndicatorWidthAuto(true);
        this.avn.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.avk.isEmpty() && i <= c.this.avk.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.avk.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            String qx = com.baidu.tieba.ala.charm.g.qx(aVar.bvV());
                            if (c.this.axZ) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, qx);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bvU().bwg();
                    }
                }
            }
        });
        this.fAo = (ImageView) this.mRootView.findViewById(a.g.ala_charm_help_img);
        this.fAo.setOnClickListener(this.mClickListener);
        this.fAr = (TextView) this.mRootView.findViewById(a.g.ala_charm_help_tips);
        this.fAq = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_title_layout);
        this.fAq.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bwh() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.fzp.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.axZ = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_ID);
        String stringExtra8 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_NAME);
        String stringExtra9 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGINUSER_PORTRAIT);
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.fBb = new com.baidu.tieba.ala.charm.e(this.fzp);
        this.fBb.BL(stringExtra4).jT(this.axZ).BM(stringExtra5).BN(stringExtra6).BO(stringExtra2).BP(stringExtra7).createView();
        this.avk.add(this.fBb);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.fzp, 3);
        aVar.BG(stringExtra3).BD(stringExtra4).BB(stringExtra).jR(this.axZ).BE(stringExtra5).BC(stringExtra2).BF(stringExtra6).BH(stringExtra7).BI(stringExtra8).BJ(stringExtra9).BK(this.otherParams).createView();
        this.avk.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.fzp, 2);
        aVar2.BG(stringExtra3).BD(stringExtra4).BB(stringExtra).jR(this.axZ).BE(stringExtra5).BC(stringExtra2).BF(stringExtra6).BH(stringExtra7).BI(stringExtra8).BJ(stringExtra9).BK(this.otherParams).createView();
        this.avk.add(aVar2);
        this.avn.setData(this.avk);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            if (this.axZ) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.avk != null && this.avk.size() > 0 && (this.avk.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.avk.get(0)).bvU().bwg();
        }
    }

    public void ar(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.avk) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).ar(str, z);
            }
        }
    }

    public void dp(long j) {
        if (this.fBb != null) {
            this.fBb.dp(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.avk) {
            dVar.onDestroy();
        }
    }

    public void yA() {
        if (this.fzp != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.fzp) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.f.ala_charm_corner_bg);
            }
            if (this.avk != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.avk) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).yA();
                    }
                }
            }
        }
    }
}
