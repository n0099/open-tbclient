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
    private AlaLiveRoomPanelTabHost aHa;
    private boolean aLj;
    private View contentView;
    private ALaCharmCardActivity gDE;
    private ImageView gEG;
    private RelativeLayout gEI;
    private TextView gEJ;
    private com.baidu.tieba.ala.charm.e gFv;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> aGX = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.gEG) {
                if (c.this.gEJ.getVisibility() == 0) {
                    c.this.gEJ.setVisibility(8);
                } else {
                    c.this.gEJ.setVisibility(0);
                }
            } else if (view == c.this.gEI && c.this.gEJ.getVisibility() == 0) {
                c.this.gEJ.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gDE = aLaCharmCardActivity;
        initView();
        bUy();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.gDE).inflate(a.g.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        HO();
        this.aHa = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.aHa.setIndicatorWidthAuto(true);
        this.aHa.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.aGX.isEmpty() && i <= c.this.aGX.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.aGX.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            String vx = com.baidu.tieba.ala.charm.g.vx(aVar.bUh());
                            if (c.this.aLj) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, vx);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bUg().bUx();
                    }
                }
            }
        });
        this.gEG = (ImageView) this.mRootView.findViewById(a.f.ala_charm_help_img);
        this.gEG.setOnClickListener(this.mClickListener);
        this.gEJ = (TextView) this.mRootView.findViewById(a.f.ala_charm_help_tips);
        this.gEI = (RelativeLayout) this.mRootView.findViewById(a.f.ala_charm_title_layout);
        this.gEI.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bUy() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.gDE.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.aLj = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra("login_user_id");
        String stringExtra8 = intent.getStringExtra("login_user_name");
        String stringExtra9 = intent.getStringExtra("login_user_portrait");
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.gFv = new com.baidu.tieba.ala.charm.e(this.gDE);
        this.gFv.Hc(stringExtra4).mt(this.aLj).Hd(stringExtra5).He(stringExtra6).Hf(stringExtra2).Hg(stringExtra7).createView();
        this.aGX.add(this.gFv);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.gDE, 3);
        aVar.GX(stringExtra3).GU(stringExtra4).GS(stringExtra).ms(this.aLj).GV(stringExtra5).GT(stringExtra2).GW(stringExtra6).GY(stringExtra7).GZ(stringExtra8).Ha(stringExtra9).Hb(this.otherParams).createView();
        this.aGX.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.gDE, 2);
        aVar2.GX(stringExtra3).GU(stringExtra4).GS(stringExtra).ms(this.aLj).GV(stringExtra5).GT(stringExtra2).GW(stringExtra6).GY(stringExtra7).GZ(stringExtra8).Ha(stringExtra9).Hb(this.otherParams).createView();
        this.aGX.add(aVar2);
        this.aHa.setData(this.aGX);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (this.aLj) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aGX != null && this.aGX.size() > 0 && (this.aGX.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.aGX.get(0)).bUg().bUx();
        }
    }

    public void aA(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aGX) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).aA(str, z);
            }
        }
    }

    public void eZ(long j) {
        if (this.gFv != null) {
            this.gFv.eZ(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aGX) {
            dVar.onDestroy();
        }
    }

    public void HO() {
        if (this.gDE != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.gDE) == 2) {
                this.contentView.setBackgroundResource(a.e.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.e.ala_charm_corner_bg);
            }
            if (this.aGX != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.aGX) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).HO();
                    }
                }
            }
        }
    }
}
