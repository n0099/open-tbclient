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
    private int aHv;
    private LinearLayout bZT;
    private LinearLayout bta;
    private CommonEmptyView btf;
    private a gSg;
    private long gmS;
    private String gmU;
    private boolean gmV;
    private AlaLastLiveroomInfo goI = new AlaLastLiveroomInfo();
    private TbPageContext<BaseFragmentActivity> idT;
    private r ieA;
    private ArrayList<com.baidu.tieba.ala.data.h> ieB;
    private BdListView ieu;
    private com.baidu.tieba.ala.adapter.c iev;
    private d iew;
    private f iex;
    private e iey;
    private AlaRankListHeaderView iez;
    private Context mContext;
    private String mPortrait;
    private View mRootView;
    private long mUserId;
    private String mUserName;

    /* loaded from: classes10.dex */
    public interface a {
        void g(View view, String str);
    }

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, int i, a aVar, boolean z, long j, String str2, String str3, long j2) {
        this.idT = tbPageContext;
        this.mContext = this.idT.getPageActivity();
        this.gSg = aVar;
        this.gmV = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.aHv = i;
        this.mPortrait = str3;
        this.gmS = j2;
        this.goI.setLastAnchorPortrait(str3);
        this.goI.setLastAnchorUname(str2);
        this.goI.setLastAnchorUid(String.valueOf(j));
        this.goI.setLastLiveId(this.gmS);
        this.goI.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
        HS(str);
    }

    private void HS(String str) {
        this.gmU = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_fragment_layout, (ViewGroup) null);
        this.ieu = (BdListView) this.mRootView.findViewById(a.f.ala_rank_list_view);
        this.iev = new com.baidu.tieba.ala.adapter.c(this.mContext, str, this.gmS, this.gmV, this.goI);
        this.ieu.setAdapter((ListAdapter) this.iev);
        this.iez = new AlaRankListHeaderView(this.idT.getPageActivity(), this.gmS, this.gmV, this.goI);
        this.iez.a(this.idT, str, 0L);
        this.ieu.addHeaderView(this.iez);
        if (TextUtils.equals("hour", this.gmU) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.bZT = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.hour_rank_list_footer_view, (ViewGroup) null);
            this.ieu.addFooterView(this.bZT);
            this.bZT.setVisibility(0);
        } else if (this.bZT != null) {
            this.bZT.setVisibility(8);
        }
        this.bta = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.iew = new d(this.mContext, str, this.gmV);
            this.iew.a(this.gSg);
            this.bta.addView(this.iew.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.iex = new f(this.mContext, str, this.gmV, this.mUserId, this.aHv, this.mPortrait);
            this.bta.addView(this.iex.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.iey = new e(this.mContext, str, this.gmV, this.mPortrait);
            this.bta.addView(this.iey.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.iew = new d(this.mContext, str, this.gmV);
            this.iew.a(this.gSg);
            this.bta.addView(this.iew.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.btf = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_rank_list_empty);
        this.ieu.setEmptyView(this.btf);
    }

    public void Du() {
        if (this.iew != null) {
            this.iew.Du();
        }
    }

    public void setDatas(ArrayList<com.baidu.tieba.ala.data.h> arrayList) {
        if (this.iev != null) {
            this.iev.setData(arrayList);
            this.ieB = arrayList;
        }
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.h> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.iez.setCountDownCallback(aVar);
        this.iez.a(this.idT, this.gmU, j);
    }

    public ArrayList<com.baidu.tieba.ala.data.h> bHf() {
        return this.ieB;
    }

    public void c(p pVar) {
        this.iez.b(pVar);
    }

    public void wt(int i) {
        if (this.iez != null) {
            this.iez.setHourHeaderInfoVisible(i);
        }
    }

    public void fp(int i) {
        if (this.bZT != null) {
            this.bZT.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.iez != null) {
            this.iez.setRankListCallback(bVar);
        }
    }

    public void wu(int i) {
        this.ieu.setVisibility(i);
    }

    public r cou() {
        return this.ieA;
    }

    public void c(final r rVar) {
        if (rVar == null) {
            if (this.iew != null) {
                this.iew.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!rVar.isValid()) {
            rVar.userName = this.mUserName;
            rVar.bdPortrait = this.mPortrait;
        }
        this.ieA = rVar;
        View view = null;
        if (this.iew != null) {
            this.iew.b(rVar);
            this.iew.getView().setVisibility(0);
            view = this.iew.getView();
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

    public void cov() {
        if (this.iew != null) {
            this.iew.getView().setVisibility(8);
        }
        if (this.iex != null) {
            this.iex.getView().setVisibility(8);
        }
        if (this.iey != null) {
            this.iey.getView().setVisibility(8);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        this.btf.reset();
        this.btf.setTitle(a.h.sdk_net_fail_tip_rank);
        this.btf.setRefreshButton(a.h.sdk_click_refresh_net_text, onClickListener);
        this.btf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.btf.setVisibility(0);
    }

    public void Vq() {
        this.btf.setVisibility(8);
    }

    public void dI(boolean z) {
        if (z) {
            this.btf.reset();
            this.btf.setTitle(a.h.rank_empty_text);
            this.btf.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.btf.setVisibility(0);
            return;
        }
        this.btf.setVisibility(8);
    }

    public void release() {
        if (this.iez != null) {
            this.iez.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
