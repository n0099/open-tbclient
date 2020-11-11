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
    private AlaLiveRoomPanelTabHost aGf;
    private boolean aKf;
    private View contentView;
    private ALaCharmCardActivity gvm;
    private ImageView gwo;
    private RelativeLayout gwq;
    private TextView gwr;
    private com.baidu.tieba.ala.charm.e gxb;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> aGc = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.gwo) {
                if (c.this.gwr.getVisibility() == 0) {
                    c.this.gwr.setVisibility(8);
                } else {
                    c.this.gwr.setVisibility(0);
                }
            } else if (view == c.this.gwq && c.this.gwr.getVisibility() == 0) {
                c.this.gwr.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gvm = aLaCharmCardActivity;
        initView();
        bRu();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.gvm).inflate(a.g.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        GI();
        this.aGf = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.aGf.setIndicatorWidthAuto(true);
        this.aGf.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.aGc.isEmpty() && i <= c.this.aGc.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.aGc.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            String us = com.baidu.tieba.ala.charm.g.us(aVar.bRd());
                            if (c.this.aKf) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, us);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bRc().bRt();
                    }
                }
            }
        });
        this.gwo = (ImageView) this.mRootView.findViewById(a.f.ala_charm_help_img);
        this.gwo.setOnClickListener(this.mClickListener);
        this.gwr = (TextView) this.mRootView.findViewById(a.f.ala_charm_help_tips);
        this.gwq = (RelativeLayout) this.mRootView.findViewById(a.f.ala_charm_title_layout);
        this.gwq.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bRu() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.gvm.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.aKf = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra("login_user_id");
        String stringExtra8 = intent.getStringExtra("login_user_name");
        String stringExtra9 = intent.getStringExtra("login_user_portrait");
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.gxb = new com.baidu.tieba.ala.charm.e(this.gvm);
        this.gxb.GN(stringExtra4).lX(this.aKf).GO(stringExtra5).GP(stringExtra6).GQ(stringExtra2).GR(stringExtra7).createView();
        this.aGc.add(this.gxb);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.gvm, 3);
        aVar.GI(stringExtra3).GF(stringExtra4).GD(stringExtra).lW(this.aKf).GG(stringExtra5).GE(stringExtra2).GH(stringExtra6).GJ(stringExtra7).GK(stringExtra8).GL(stringExtra9).GM(this.otherParams).createView();
        this.aGc.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.gvm, 2);
        aVar2.GI(stringExtra3).GF(stringExtra4).GD(stringExtra).lW(this.aKf).GG(stringExtra5).GE(stringExtra2).GH(stringExtra6).GJ(stringExtra7).GK(stringExtra8).GL(stringExtra9).GM(this.otherParams).createView();
        this.aGc.add(aVar2);
        this.aGf.setData(this.aGc);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (this.aKf) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aGc != null && this.aGc.size() > 0 && (this.aGc.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.aGc.get(0)).bRc().bRt();
        }
    }

    public void az(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aGc) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).az(str, z);
            }
        }
    }

    public void ew(long j) {
        if (this.gxb != null) {
            this.gxb.ew(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aGc) {
            dVar.onDestroy();
        }
    }

    public void GI() {
        if (this.gvm != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.gvm) == 2) {
                this.contentView.setBackgroundResource(a.e.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.e.ala_charm_corner_bg);
            }
            if (this.aGc != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.aGc) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).GI();
                    }
                }
            }
        }
    }
}
