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
    private AlaLiveRoomPanelTabHost atl;
    private boolean avR;
    private View contentView;
    private ALaCharmCardActivity foc;
    private com.baidu.tieba.ala.charm.e fpQ;
    private ImageView fpc;
    private RelativeLayout fpe;
    private TextView fpf;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> ati = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.fpc) {
                if (c.this.fpf.getVisibility() == 0) {
                    c.this.fpf.setVisibility(8);
                } else {
                    c.this.fpf.setVisibility(0);
                }
            } else if (view == c.this.fpe && c.this.fpf.getVisibility() == 0) {
                c.this.fpf.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.foc = aLaCharmCardActivity;
        initView();
        btn();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.foc).inflate(a.h.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        ya();
        this.atl = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.atl.setIndicatorWidthAuto(true);
        this.atl.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.ati.isEmpty() && i <= c.this.ati.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.ati.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            String pY = com.baidu.tieba.ala.charm.g.pY(aVar.bta());
                            if (c.this.avR) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, pY);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bsZ().btm();
                    }
                }
            }
        });
        this.fpc = (ImageView) this.mRootView.findViewById(a.g.ala_charm_help_img);
        this.fpc.setOnClickListener(this.mClickListener);
        this.fpf = (TextView) this.mRootView.findViewById(a.g.ala_charm_help_tips);
        this.fpe = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_title_layout);
        this.fpe.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void btn() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.foc.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.avR = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_ID);
        String stringExtra8 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_NAME);
        String stringExtra9 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGINUSER_PORTRAIT);
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.fpQ = new com.baidu.tieba.ala.charm.e(this.foc);
        this.fpQ.Bn(stringExtra4).jG(this.avR).Bo(stringExtra5).Bp(stringExtra6).Bq(stringExtra2).Br(stringExtra7).createView();
        this.ati.add(this.fpQ);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.foc, 3);
        aVar.Bi(stringExtra3).Bf(stringExtra4).Bd(stringExtra).jE(this.avR).Bg(stringExtra5).Be(stringExtra2).Bh(stringExtra6).Bj(stringExtra7).Bk(stringExtra8).Bl(stringExtra9).Bm(this.otherParams).createView();
        this.ati.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.foc, 2);
        aVar2.Bi(stringExtra3).Bf(stringExtra4).Bd(stringExtra).jE(this.avR).Bg(stringExtra5).Be(stringExtra2).Bh(stringExtra6).Bj(stringExtra7).Bk(stringExtra8).Bl(stringExtra9).Bm(this.otherParams).createView();
        this.ati.add(aVar2);
        this.atl.setData(this.ati);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            if (this.avR) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.ati != null && this.ati.size() > 0 && (this.ati.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.ati.get(0)).bsZ().btm();
        }
    }

    public void ap(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.ati) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).ap(str, z);
            }
        }
    }

    public void dm(long j) {
        if (this.fpQ != null) {
            this.fpQ.dm(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.ati) {
            dVar.onDestroy();
        }
    }

    public void ya() {
        if (this.foc != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.foc) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.f.ala_charm_corner_bg);
            }
            if (this.ati != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.ati) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).ya();
                    }
                }
            }
        }
    }
}
