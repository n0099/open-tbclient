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
    private AlaLiveRoomPanelTabHost aCE;
    private boolean aGY;
    private View contentView;
    private ALaCharmCardActivity gKK;
    private ImageView gLL;
    private RelativeLayout gLN;
    private TextView gLO;
    private com.baidu.tieba.ala.charm.e gMA;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> aCB = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.gLL) {
                if (c.this.gLO.getVisibility() == 0) {
                    c.this.gLO.setVisibility(8);
                } else {
                    c.this.gLO.setVisibility(0);
                }
            } else if (view == c.this.gLN && c.this.gLO.getVisibility() == 0) {
                c.this.gLO.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gKK = aLaCharmCardActivity;
        initView();
        bTl();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.gKK).inflate(a.g.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        Du();
        this.aCE = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.aCE.setIndicatorWidthAuto(true);
        this.aCE.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.aCB.isEmpty() && i <= c.this.aCB.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.aCB.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            String uc = com.baidu.tieba.ala.charm.g.uc(aVar.bSV());
                            if (c.this.aGY) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, uc);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bSU().bTk();
                    }
                }
            }
        });
        this.gLL = (ImageView) this.mRootView.findViewById(a.f.ala_charm_help_img);
        this.gLL.setOnClickListener(this.mClickListener);
        this.gLO = (TextView) this.mRootView.findViewById(a.f.ala_charm_help_tips);
        this.gLN = (RelativeLayout) this.mRootView.findViewById(a.f.ala_charm_title_layout);
        this.gLN.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bTl() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.gKK.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.aGY = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra("login_user_id");
        String stringExtra8 = intent.getStringExtra("login_user_name");
        String stringExtra9 = intent.getStringExtra("login_user_portrait");
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.gMA = new com.baidu.tieba.ala.charm.e(this.gKK);
        this.gMA.FP(stringExtra4).mP(this.aGY).FQ(stringExtra5).FR(stringExtra6).FS(stringExtra2).FT(stringExtra7).createView();
        this.aCB.add(this.gMA);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.gKK, 3);
        aVar.FK(stringExtra3).FH(stringExtra4).FF(stringExtra).mO(this.aGY).FI(stringExtra5).FG(stringExtra2).FJ(stringExtra6).FL(stringExtra7).FM(stringExtra8).FN(stringExtra9).FO(this.otherParams).createView();
        this.aCB.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.gKK, 2);
        aVar2.FK(stringExtra3).FH(stringExtra4).FF(stringExtra).mO(this.aGY).FI(stringExtra5).FG(stringExtra2).FJ(stringExtra6).FL(stringExtra7).FM(stringExtra8).FN(stringExtra9).FO(this.otherParams).createView();
        this.aCB.add(aVar2);
        this.aCE.setData(this.aCB);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (this.aGY) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aCB != null && this.aCB.size() > 0 && (this.aCB.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.aCB.get(0)).bSU().bTk();
        }
    }

    public void aB(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aCB) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).aB(str, z);
            }
        }
    }

    public void eZ(long j) {
        if (this.gMA != null) {
            this.gMA.eZ(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aCB) {
            dVar.onDestroy();
        }
    }

    public void Du() {
        if (this.gKK != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.gKK) == 2) {
                this.contentView.setBackgroundResource(a.e.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.e.ala_charm_corner_bg);
            }
            if (this.aCB != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.aCB) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).Du();
                    }
                }
            }
        }
    }
}
