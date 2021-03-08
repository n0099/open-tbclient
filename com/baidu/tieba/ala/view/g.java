package com.baidu.tieba.ala.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.data.p;
import com.baidu.tieba.ala.data.r;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class g {
    private int aLA;
    private LinearLayout bye;
    private CommonEmptyView byj;
    private LinearLayout cfz;
    private a gWN;
    private String grA;
    private boolean grB;
    private long gry;
    private AlaLastLiveroomInfo gto = new AlaLastLiveroomInfo();
    private TbPageContext<BaseFragmentActivity> ikK;
    private BdListView ill;
    private com.baidu.tieba.ala.adapter.c ilm;
    private d iln;
    private f ilo;
    private e ilp;
    private AlaRankListHeaderView ilq;
    private r ilr;
    private ArrayList<com.baidu.tieba.ala.data.h> ils;
    private Context mContext;
    private String mPortrait;
    private View mRootView;
    private long mUserId;
    private String mUserName;

    /* loaded from: classes10.dex */
    public interface a {
        void h(View view, String str);
    }

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, int i, a aVar, boolean z, long j, String str2, String str3, long j2) {
        this.ikK = tbPageContext;
        this.mContext = this.ikK.getPageActivity();
        this.gWN = aVar;
        this.grB = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.aLA = i;
        this.mPortrait = str3;
        this.gry = j2;
        this.gto.setLastAnchorPortrait(str3);
        this.gto.setLastAnchorUname(str2);
        this.gto.setLastAnchorUid(String.valueOf(j));
        this.gto.setLastLiveId(this.gry);
        this.gto.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
        II(str);
    }

    private void II(String str) {
        this.grA = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_fragment_layout, (ViewGroup) null);
        this.ill = (BdListView) this.mRootView.findViewById(a.f.ala_rank_list_view);
        this.ilm = new com.baidu.tieba.ala.adapter.c(this.mContext, str, this.gry, this.grB, this.gto);
        this.ill.setAdapter((ListAdapter) this.ilm);
        this.ilq = new AlaRankListHeaderView(this.ikK.getPageActivity(), this.gry, this.grB, this.gto);
        this.ilq.a(this.ikK, str, 0L);
        this.ill.addHeaderView(this.ilq);
        if (TextUtils.equals("hour", this.grA) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.cfz = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.hour_rank_list_footer_view, (ViewGroup) null);
            this.ill.addFooterView(this.cfz);
            this.cfz.setVisibility(0);
        } else if (this.cfz != null) {
            this.cfz.setVisibility(8);
        }
        this.bye = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.iln = new d(this.mContext, str, this.grB);
            this.iln.a(this.gWN);
            this.bye.addView(this.iln.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.ilo = new f(this.mContext, str, this.grB, this.mUserId, this.aLA, this.mPortrait);
            this.bye.addView(this.ilo.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.ilp = new e(this.mContext, str, this.grB, this.mPortrait);
            this.bye.addView(this.ilp.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.iln = new d(this.mContext, str, this.grB);
            this.iln.a(this.gWN);
            this.bye.addView(this.iln.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.byj = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_rank_list_empty);
        this.ill.setEmptyView(this.byj);
    }

    public void EN() {
        if (this.iln != null) {
            this.iln.EN();
        }
    }

    public void setDatas(ArrayList<com.baidu.tieba.ala.data.h> arrayList) {
        if (this.ilm != null) {
            this.ilm.setData(arrayList);
            this.ils = arrayList;
        }
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.h> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.ilq.setCountDownCallback(aVar);
        this.ilq.a(this.ikK, this.grA, j);
    }

    public ArrayList<com.baidu.tieba.ala.data.h> bHD() {
        return this.ils;
    }

    public void c(p pVar) {
        this.ilq.b(pVar);
    }

    public void wF(int i) {
        if (this.ilq != null) {
            this.ilq.setHourHeaderInfoVisible(i);
        }
    }

    public void fw(int i) {
        if (this.cfz != null) {
            this.cfz.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.ilq != null) {
            this.ilq.setRankListCallback(bVar);
        }
    }

    public void wG(int i) {
        this.ill.setVisibility(i);
    }

    public r cpM() {
        return this.ilr;
    }

    public void c(final r rVar) {
        if (rVar == null) {
            if (this.iln != null) {
                this.iln.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!rVar.isValid()) {
            rVar.userName = this.mUserName;
            rVar.bdPortrait = this.mPortrait;
        }
        this.ilr = rVar;
        View view = null;
        if (this.iln != null) {
            this.iln.b(rVar);
            this.iln.getView().setVisibility(0);
            view = this.iln.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (rVar != null && (g.this.mContext instanceof Activity)) {
                        Intent intent = ((Activity) g.this.mContext).getIntent();
                        long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                        String stringExtra = intent.getStringExtra("group_id");
                        String stringExtra2 = intent.getStringExtra("live_id");
                        boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                        String stringExtra3 = intent.getStringExtra("live_owner_uid");
                        if (longExtra == rVar.userId) {
                            stringExtra3 = longExtra + "";
                        }
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(g.this.mContext, rVar.userId + "", rVar.userName, rVar.bdPortrait, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, rVar.getNameShow());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void cpN() {
        if (this.iln != null) {
            this.iln.getView().setVisibility(8);
        }
        if (this.ilo != null) {
            this.ilo.getView().setVisibility(8);
        }
        if (this.ilp != null) {
            this.ilp.getView().setVisibility(8);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        this.byj.reset();
        this.byj.setTitle(a.h.sdk_net_fail_tip_rank);
        this.byj.setRefreshButton(a.h.sdk_click_refresh_net_text, onClickListener);
        this.byj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.byj.setVisibility(0);
    }

    public void Xc() {
        this.byj.setVisibility(8);
    }

    public void dQ(boolean z) {
        if (z) {
            this.byj.reset();
            this.byj.setTitle(a.h.rank_empty_text);
            this.byj.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.byj.setVisibility(0);
            return;
        }
        this.byj.setVisibility(8);
    }

    public void release() {
        if (this.ilq != null) {
            this.ilq.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
