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
    private ALaCharmCardActivity evW;
    private ImageView ewL;
    private RelativeLayout ewN;
    private TextView ewO;
    private com.baidu.tieba.ala.charm.c exu;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> VW = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.ewL) {
                if (c.this.ewO.getVisibility() == 0) {
                    c.this.ewO.setVisibility(8);
                } else {
                    c.this.ewO.setVisibility(0);
                }
            } else if (view == c.this.ewN && c.this.ewO.getVisibility() == 0) {
                c.this.ewO.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.evW = aLaCharmCardActivity;
        initView();
        beb();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.evW).inflate(a.h.ala_charm_activity_layout, (ViewGroup) null);
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
                            String oY = com.baidu.tieba.ala.charm.e.oY(aVar.bdS());
                            if (c.this.Yr) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oY);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bdR().bea();
                    }
                }
            }
        });
        this.ewL = (ImageView) this.mRootView.findViewById(a.g.ala_charm_help_img);
        this.ewL.setOnClickListener(this.mClickListener);
        this.ewO = (TextView) this.mRootView.findViewById(a.g.ala_charm_help_tips);
        this.ewN = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_title_layout);
        this.ewN.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void beb() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.evW.getIntent();
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
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.evW, 3);
        aVar.xR(stringExtra3).xO(stringExtra4).xM(stringExtra).ii(this.Yr).xP(stringExtra5).xN(stringExtra2).xQ(stringExtra6).xS(stringExtra7).xT(stringExtra8).xU(stringExtra9).xV(this.otherParams).createView();
        this.VW.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.evW, 2);
        aVar2.xR(stringExtra3).xO(stringExtra4).xM(stringExtra).ii(this.Yr).xP(stringExtra5).xN(stringExtra2).xQ(stringExtra6).xS(stringExtra7).xT(stringExtra8).xU(stringExtra9).xV(this.otherParams).createView();
        this.VW.add(aVar2);
        this.exu = new com.baidu.tieba.ala.charm.c(this.evW);
        this.exu.xX(stringExtra4).ik(this.Yr).xY(stringExtra5).xZ(stringExtra6).createView();
        this.exu.cD(longExtra);
        this.VW.add(this.exu);
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
            ((com.baidu.tieba.ala.charm.a) this.VW.get(0)).bdR().bea();
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
        if (this.exu != null) {
            this.exu.cD(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.VW) {
            dVar.onDestroy();
        }
    }

    public void sm() {
        if (this.evW != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.evW) == 2) {
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
