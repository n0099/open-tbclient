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
    private AlaLiveRoomPanelTabHost Wk;
    private boolean YB;
    private View contentView;
    private ALaCharmCardActivity ews;
    private com.baidu.tieba.ala.charm.c exQ;
    private ImageView exh;
    private RelativeLayout exj;
    private TextView exk;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> Wh = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.exh) {
                if (c.this.exk.getVisibility() == 0) {
                    c.this.exk.setVisibility(8);
                } else {
                    c.this.exk.setVisibility(0);
                }
            } else if (view == c.this.exj && c.this.exk.getVisibility() == 0) {
                c.this.exk.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.ews = aLaCharmCardActivity;
        initView();
        beg();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.ews).inflate(a.h.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        sr();
        this.Wk = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.Wk.setIndicatorWidthAuto(true);
        this.Wk.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.Wh.isEmpty() && i <= c.this.Wh.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.Wh.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            String pa = com.baidu.tieba.ala.charm.e.pa(aVar.bdX());
                            if (c.this.YB) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, pa);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bdW().bef();
                    }
                }
            }
        });
        this.exh = (ImageView) this.mRootView.findViewById(a.g.ala_charm_help_img);
        this.exh.setOnClickListener(this.mClickListener);
        this.exk = (TextView) this.mRootView.findViewById(a.g.ala_charm_help_tips);
        this.exj = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_title_layout);
        this.exj.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void beg() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.ews.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.YB = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_ID);
        String stringExtra8 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_NAME);
        String stringExtra9 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGINUSER_PORTRAIT);
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        long longExtra = intent.getLongExtra(AlaCharmCardActivityConfig.ONLINE_COUNT, 0L);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.ews, 3);
        aVar.xR(stringExtra3).xO(stringExtra4).xM(stringExtra).ik(this.YB).xP(stringExtra5).xN(stringExtra2).xQ(stringExtra6).xS(stringExtra7).xT(stringExtra8).xU(stringExtra9).xV(this.otherParams).createView();
        this.Wh.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.ews, 2);
        aVar2.xR(stringExtra3).xO(stringExtra4).xM(stringExtra).ik(this.YB).xP(stringExtra5).xN(stringExtra2).xQ(stringExtra6).xS(stringExtra7).xT(stringExtra8).xU(stringExtra9).xV(this.otherParams).createView();
        this.Wh.add(aVar2);
        this.exQ = new com.baidu.tieba.ala.charm.c(this.ews);
        this.exQ.xX(stringExtra4).im(this.YB).xY(stringExtra5).xZ(stringExtra6).createView();
        this.exQ.cD(longExtra);
        this.Wh.add(this.exQ);
        this.Wk.setData(this.Wh);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            if (this.YB) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.Wh != null && this.Wh.size() > 0 && (this.Wh.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.Wh.get(0)).bdW().bef();
        }
    }

    public void X(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.Wh) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).X(str, z);
            }
        }
    }

    public void cD(long j) {
        if (this.exQ != null) {
            this.exQ.cD(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.Wh) {
            dVar.onDestroy();
        }
    }

    public void sr() {
        if (this.ews != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.ews) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.f.ala_charm_corner_bg);
            }
            if (this.Wh != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.Wh) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).sr();
                    }
                }
            }
        }
    }
}
