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
/* loaded from: classes11.dex */
public class c {
    private AlaLiveRoomPanelTabHost aHr;
    private boolean aLL;
    private View contentView;
    private ALaCharmCardActivity gPq;
    private ImageView gQr;
    private RelativeLayout gQt;
    private TextView gQu;
    private com.baidu.tieba.ala.charm.e gRg;
    private View mRootView;
    private List<com.baidu.live.liveroom.d.d> aHo = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.gQr) {
                if (c.this.gQu.getVisibility() == 0) {
                    c.this.gQu.setVisibility(8);
                } else {
                    c.this.gQu.setVisibility(0);
                }
            } else if (view == c.this.gQt && c.this.gQu.getVisibility() == 0) {
                c.this.gQu.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.gPq = aLaCharmCardActivity;
        initView();
        bXd();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.gPq).inflate(a.g.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.ala_charm_root_view);
        Hp();
        this.aHr = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.aHr.setIndicatorWidthAuto(true);
        this.aHr.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.aHo.isEmpty() && i <= c.this.aHo.size() - 1) {
                    com.baidu.live.liveroom.d.d dVar = (com.baidu.live.liveroom.d.d) c.this.aHo.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            String vI = com.baidu.tieba.ala.charm.g.vI(aVar.bWN());
                            if (c.this.aLL) {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                            } else {
                                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                            }
                            alaStaticItem.addParams("other_params", c.this.otherParams);
                            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, vI);
                            AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        }
                        aVar.bWM().bXc();
                    }
                }
            }
        });
        this.gQr = (ImageView) this.mRootView.findViewById(a.f.ala_charm_help_img);
        this.gQr.setOnClickListener(this.mClickListener);
        this.gQu = (TextView) this.mRootView.findViewById(a.f.ala_charm_help_tips);
        this.gQt = (RelativeLayout) this.mRootView.findViewById(a.f.ala_charm_title_layout);
        this.gQt.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bXd() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.gPq.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.aLL = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra("login_user_id");
        String stringExtra8 = intent.getStringExtra("login_user_name");
        String stringExtra9 = intent.getStringExtra("login_user_portrait");
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        this.gRg = new com.baidu.tieba.ala.charm.e(this.gPq);
        this.gRg.Ha(stringExtra4).mT(this.aLL).Hb(stringExtra5).Hc(stringExtra6).Hd(stringExtra2).He(stringExtra7).createView();
        this.aHo.add(this.gRg);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.gPq, 3);
        aVar.GV(stringExtra3).GS(stringExtra4).GQ(stringExtra).mS(this.aLL).GT(stringExtra5).GR(stringExtra2).GU(stringExtra6).GW(stringExtra7).GX(stringExtra8).GY(stringExtra9).GZ(this.otherParams).createView();
        this.aHo.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.gPq, 2);
        aVar2.GV(stringExtra3).GS(stringExtra4).GQ(stringExtra).mS(this.aLL).GT(stringExtra5).GR(stringExtra2).GU(stringExtra6).GW(stringExtra7).GX(stringExtra8).GY(stringExtra9).GZ(this.otherParams).createView();
        this.aHo.add(aVar2);
        this.aHr.setData(this.aHo);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (this.aLL) {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
            } else {
                alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
            }
            alaStaticItem.addParams("other_params", this.otherParams);
            alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aHo != null && this.aHo.size() > 0 && (this.aHo.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.aHo.get(0)).bWM().bXc();
        }
    }

    public void aB(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aHo) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).aB(str, z);
            }
        }
    }

    public void eZ(long j) {
        if (this.gRg != null) {
            this.gRg.eZ(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aHo) {
            dVar.onDestroy();
        }
    }

    public void Hp() {
        if (this.gPq != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.gPq) == 2) {
                this.contentView.setBackgroundResource(a.e.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.e.ala_charm_corner_bg);
            }
            if (this.aHo != null) {
                for (com.baidu.live.liveroom.d.d dVar : this.aHo) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).Hp();
                    }
                }
            }
        }
    }
}
