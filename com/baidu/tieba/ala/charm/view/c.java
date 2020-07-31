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
/* loaded from: classes4.dex */
public class c {
    private AlaLiveRoomPanelTabHost aws;
    private boolean azm;
    private View contentView;
    private ALaCharmCardActivity fEw;
    private RelativeLayout fFA;
    private TextView fFB;
    private ImageView fFy;
    private com.baidu.tieba.ala.charm.e fGl;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> awp = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.fFy) {
                if (c.this.fFB.getVisibility() == 0) {
                    c.this.fFB.setVisibility(8);
                } else {
                    c.this.fFB.setVisibility(0);
                }
            } else if (view == c.this.fFA && c.this.fFB.getVisibility() == 0) {
                c.this.fFB.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.fEw = aLaCharmCardActivity;
        initView();
        bzw();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.fEw).inflate(a.h.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        zc();
        this.aws = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.aws.setIndicatorWidthAuto(true);
        this.aws.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.awp.isEmpty() && i <= c.this.awp.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.awp.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                            String qM = com.baidu.tieba.ala.charm.g.qM(aVar.bzf());
                            if (c.this.azm) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, qM);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bze().bzv();
                    }
                }
            }
        });
        this.fFy = (ImageView) this.mRootView.findViewById(a.g.ala_charm_help_img);
        this.fFy.setOnClickListener(this.mClickListener);
        this.fFB = (TextView) this.mRootView.findViewById(a.g.ala_charm_help_tips);
        this.fFA = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_title_layout);
        this.fFA.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bzw() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.fEw.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.azm = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_ID);
        String stringExtra8 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_NAME);
        String stringExtra9 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGINUSER_PORTRAIT);
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.fGl = new com.baidu.tieba.ala.charm.e(this.fEw);
        this.fGl.Cw(stringExtra4).kx(this.azm).Cx(stringExtra5).Cy(stringExtra6).Cz(stringExtra2).CA(stringExtra7).createView();
        this.awp.add(this.fGl);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.fEw, 3);
        aVar.Cr(stringExtra3).Co(stringExtra4).Cm(stringExtra).kv(this.azm).Cp(stringExtra5).Cn(stringExtra2).Cq(stringExtra6).Cs(stringExtra7).Ct(stringExtra8).Cu(stringExtra9).Cv(this.otherParams).createView();
        this.awp.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.fEw, 2);
        aVar2.Cr(stringExtra3).Co(stringExtra4).Cm(stringExtra).kv(this.azm).Cp(stringExtra5).Cn(stringExtra2).Cq(stringExtra6).Cs(stringExtra7).Ct(stringExtra8).Cu(stringExtra9).Cv(this.otherParams).createView();
        this.awp.add(aVar2);
        this.aws.setData(this.awp);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            if (this.azm) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.awp != null && this.awp.size() > 0 && (this.awp.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.awp.get(0)).bze().bzv();
        }
    }

    public void ap(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.awp) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).ap(str, z);
            }
        }
    }

    public void dD(long j) {
        if (this.fGl != null) {
            this.fGl.dD(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.awp) {
            dVar.onDestroy();
        }
    }

    public void zc() {
        if (this.fEw != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.fEw) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.f.ala_charm_corner_bg);
            }
            if (this.awp != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.awp) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).zc();
                    }
                }
            }
        }
    }
}
