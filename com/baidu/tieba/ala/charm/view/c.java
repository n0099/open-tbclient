package com.baidu.tieba.ala.charm.view;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.ala.charm.ALaCharmCardActivity;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private AlaLiveRoomPanelTabHost TZ;
    private boolean Wm;
    private View contentView;
    private ALaCharmCardActivity eql;
    private com.baidu.tieba.ala.charm.c erK;
    private ImageView erb;
    private RelativeLayout erd;
    private TextView ere;
    private View mRootView;
    private List<com.baidu.live.liveroom.c.d> TW = new LinkedList();
    private String otherParams = "";
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.erb) {
                if (c.this.ere.getVisibility() == 0) {
                    c.this.ere.setVisibility(8);
                } else {
                    c.this.ere.setVisibility(0);
                }
            } else if (view == c.this.erd && c.this.ere.getVisibility() == 0) {
                c.this.ere.setVisibility(8);
            }
        }
    };

    public c(ALaCharmCardActivity aLaCharmCardActivity) {
        this.eql = aLaCharmCardActivity;
        initView();
        bbo();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.eql).inflate(a.h.ala_charm_activity_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.ala_charm_root_view);
        qZ();
        this.TZ = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.g.ala_charm_tab_host);
        this.TZ.setIndicatorWidthAuto(true);
        this.TZ.setPageSelectedListener(new AlaLiveRoomPanelTabHost.b() { // from class: com.baidu.tieba.ala.charm.view.c.1
            @Override // com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost.b
            public void onPageSelected(int i) {
                AlaStaticItem alaStaticItem;
                if (!c.this.TW.isEmpty() && i <= c.this.TW.size() - 1) {
                    com.baidu.live.liveroom.c.d dVar = (com.baidu.live.liveroom.c.d) c.this.TW.get(i);
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        com.baidu.tieba.ala.charm.a aVar = (com.baidu.tieba.ala.charm.a) dVar;
                        String oG = com.baidu.tieba.ala.charm.e.oG(aVar.bbf());
                        if (c.this.Wm) {
                            alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
                        } else {
                            alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
                        }
                        alaStaticItem.addParams("other_params", c.this.otherParams);
                        alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, oG);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                        aVar.bbe().bbn();
                    }
                }
            }
        });
        this.erb = (ImageView) this.mRootView.findViewById(a.g.ala_charm_help_img);
        this.erb.setOnClickListener(this.mClickListener);
        this.ere = (TextView) this.mRootView.findViewById(a.g.ala_charm_help_tips);
        this.erd = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_title_layout);
        this.erd.setOnClickListener(this.mClickListener);
    }

    public View getView() {
        return this.mRootView;
    }

    private void bbo() {
        AlaStaticItem alaStaticItem;
        Intent intent = this.eql.getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        String stringExtra2 = intent.getStringExtra("user_name");
        String stringExtra3 = intent.getStringExtra("charm_value");
        String stringExtra4 = intent.getStringExtra("group_id");
        String stringExtra5 = intent.getStringExtra("live_id");
        this.Wm = intent.getBooleanExtra("live_owner_flag", false);
        String stringExtra6 = intent.getStringExtra("live_owner_uid");
        String stringExtra7 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_ID);
        String stringExtra8 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGIN_USER_NAME);
        String stringExtra9 = intent.getStringExtra(AlaCharmCardActivityConfig.LOGINUSER_PORTRAIT);
        this.otherParams = intent.getStringExtra(IntentConfig.OTHER_PARAMS);
        long longExtra = intent.getLongExtra(AlaCharmCardActivityConfig.ONLINE_COUNT, 0L);
        com.baidu.tieba.ala.charm.a aVar = new com.baidu.tieba.ala.charm.a(this.eql, 3);
        aVar.xr(stringExtra3).xo(stringExtra4).xm(stringExtra).hR(this.Wm).xp(stringExtra5).xn(stringExtra2).xq(stringExtra6).xs(stringExtra7).xt(stringExtra8).xu(stringExtra9).xv(this.otherParams).createView();
        this.TW.add(aVar);
        com.baidu.tieba.ala.charm.a aVar2 = new com.baidu.tieba.ala.charm.a(this.eql, 2);
        aVar2.xr(stringExtra3).xo(stringExtra4).xm(stringExtra).hR(this.Wm).xp(stringExtra5).xn(stringExtra2).xq(stringExtra6).xs(stringExtra7).xt(stringExtra8).xu(stringExtra9).xv(this.otherParams).createView();
        this.TW.add(aVar2);
        this.erK = new com.baidu.tieba.ala.charm.c(this.eql);
        this.erK.xx(stringExtra4).hT(this.Wm).xy(stringExtra5).xz(stringExtra6).createView();
        this.erK.cv(longExtra);
        this.TW.add(this.erK);
        this.TZ.setData(this.TW);
        if (this.Wm) {
            alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CHARMLIST);
        } else {
            alaStaticItem = new AlaStaticItem(SdkStaticKeys.ACCESS_CHARMLIST);
        }
        alaStaticItem.addParams("other_params", this.otherParams);
        alaStaticItem.addParams(SdkStaticKeys.KEY_CHARM_TYPE, SdkStaticKeys.CHARM_TYPE_DAY);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
        if (this.TW != null && this.TW.size() > 0 && (this.TW.get(0) instanceof com.baidu.tieba.ala.charm.a)) {
            ((com.baidu.tieba.ala.charm.a) this.TW.get(0)).bbe().bbn();
        }
    }

    public void X(String str, boolean z) {
        for (com.baidu.live.liveroom.c.d dVar : this.TW) {
            if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                ((com.baidu.tieba.ala.charm.a) dVar).X(str, z);
            }
        }
    }

    public void cv(long j) {
        if (this.erK != null) {
            this.erK.cv(j);
        }
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.c.d dVar : this.TW) {
            dVar.onDestroy();
        }
    }

    public void qZ() {
        if (this.eql != null && this.contentView != null) {
            if (UtilHelper.getRealScreenOrientation(this.eql) == 2) {
                this.contentView.setBackgroundResource(a.f.ala_charm_layout_bg_corner_land);
            } else {
                this.contentView.setBackgroundResource(a.f.ala_charm_corner_bg);
            }
            if (this.TW != null) {
                for (com.baidu.live.liveroom.c.d dVar : this.TW) {
                    if (dVar instanceof com.baidu.tieba.ala.charm.a) {
                        ((com.baidu.tieba.ala.charm.a) dVar).qZ();
                    }
                }
            }
        }
    }
}
