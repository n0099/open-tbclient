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
    private AlaLiveRoomPanelTabHost VZ;
    private boolean Yr;
    private View contentView;
    private ALaCharmCardActivity evJ;
    private RelativeLayout ewA;
    private TextView ewB;
    private ImageView ewy;
    private com.baidu.tieba.ala.charm.c exg;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> VW = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.ewy) {
                if (c.this.ewB.getVisibility() == 0) {
                    c.this.ewB.setVisibility(8);
                } else {
                    c.this.ewB.setVisibility(0);
                }
            } else if (view == c.this.ewA && c.this.ewB.getVisibility() == 0) {
                c.this.ewB.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.evJ = aLaCharmCardActivity;
        initView();
        bea();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.evJ).inflate(a.h.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        sm();
        this.VZ = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.VZ.setIndicatorWidthAuto(true);
        this.VZ.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.VW.isEmpty() && i <= c.this.VW.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.VW.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            String oY = com.baidu.tieba.ala.charm.e.oY(aVar.bdR());
                            if (c.this.Yr) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oY);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bdQ().bdZ();
                    }
                }
            }
        });
        this.ewy = (ImageView) this.mRootView.findViewById(a.g.ala_charm_help_img);
        this.ewy.setOnClickListener(this.mClickListener);
        this.ewB = (TextView) this.mRootView.findViewById(a.g.ala_charm_help_tips);
        this.ewA = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_title_layout);
        this.ewA.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bea() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.evJ.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.Yr = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_ID);
        String stringExtra8 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_NAME);
        String stringExtra9 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGINUSER_PORTRAIT);
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        long longExtra = intent.getLongExtra(AlaCharmCardActivityConfig.ONLINE_COUNT, 0L);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.evJ, 3);
        aVar.xQ(stringExtra3).xN(stringExtra4).xL(stringExtra).ii(this.Yr).xO(stringExtra5).xM(stringExtra2).xP(stringExtra6).xR(stringExtra7).xS(stringExtra8).xT(stringExtra9).xU(this.otherParams).createView();
        this.VW.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.evJ, 2);
        aVar2.xQ(stringExtra3).xN(stringExtra4).xL(stringExtra).ii(this.Yr).xO(stringExtra5).xM(stringExtra2).xP(stringExtra6).xR(stringExtra7).xS(stringExtra8).xT(stringExtra9).xU(this.otherParams).createView();
        this.VW.add(aVar2);
        this.exg = new com.baidu.tieba.ala.charm.c(this.evJ);
        this.exg.xW(stringExtra4).ik(this.Yr).xX(stringExtra5).xY(stringExtra6).createView();
        this.exg.cD(longExtra);
        this.VW.add(this.exg);
        this.VZ.setData(this.VW);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            if (this.Yr) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.VW != null && this.VW.size() > 0 && (this.VW.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.VW.get(0)).bdQ().bdZ();
        }
    }

    public void X(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.VW) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).X(str, z);
            }
        }
    }

    public void cD(long j) {
        if (this.exg != null) {
            this.exg.cD(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.VW) {
            dVar.onDestroy();
        }
    }

    public void sm() {
        if (this.evJ != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.evJ) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.f.ala_charm_corner_bg);
            }
            if (this.VW != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.VW) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).sm();
                    }
                }
            }
        }
    }
}
