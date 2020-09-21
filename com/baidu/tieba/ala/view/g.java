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
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.data.p;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g {
    private int aFQ;
    private LinearLayout bja;
    private CommonEmptyView bjf;
    private AlaLastLiveroomInfo fAJ = new AlaLastLiveroomInfo();
    private long fyR;
    private String fyT;
    private boolean fyU;
    private a gaj;
    private TbPageContext<BaseFragmentActivity> heG;
    private BdListView hfh;
    private com.baidu.tieba.ala.adapter.c hfi;
    private d hfj;
    private f hfk;
    private e hfl;
    private AlaRankListHeaderView hfm;
    private LinearLayout hfn;
    private p hfo;
    private ArrayList<com.baidu.tieba.ala.data.h> hfp;
    private Context mContext;
    private String mPortrait;
    private View mRootView;
    private long mUserId;
    private String mUserName;

    /* loaded from: classes4.dex */
    public interface a {
        void g(View view, String str);
    }

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, int i, a aVar, boolean z, long j, String str2, String str3, long j2) {
        this.heG = tbPageContext;
        this.mContext = this.heG.getPageActivity();
        this.gaj = aVar;
        this.fyU = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.aFQ = i;
        this.mPortrait = str3;
        this.fyR = j2;
        this.fAJ.setLastAnchorPortrait(str3);
        this.fAJ.setLastAnchorUname(str2);
        this.fAJ.setLastAnchorUid(String.valueOf(j));
        this.fAJ.setLastLiveId(this.fyR);
        this.fAJ.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
        Hk(str);
    }

    private void Hk(String str) {
        this.fyT = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.hfh = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.hfi = new com.baidu.tieba.ala.adapter.c(this.mContext, str, this.fyR, this.fyU, this.fAJ);
        this.hfh.setAdapter((ListAdapter) this.hfi);
        this.hfm = new AlaRankListHeaderView(this.heG.getPageActivity(), this.fyR, this.fyU, this.fAJ);
        this.hfm.a(this.heG, str, 0L);
        this.hfh.addHeaderView(this.hfm);
        if (TextUtils.equals("hour", this.fyT) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hfn = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.hfh.addFooterView(this.hfn);
            this.hfn.setVisibility(0);
        } else if (this.hfn != null) {
            this.hfn.setVisibility(8);
        }
        this.bja = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.hfj = new d(this.mContext, str, this.fyU);
            this.hfj.a(this.gaj);
            this.bja.addView(this.hfj.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.hfk = new f(this.mContext, str, this.fyU, this.mUserId, this.aFQ, this.mPortrait);
            this.bja.addView(this.hfk.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.hfl = new e(this.mContext, str, this.fyU, this.mPortrait);
            this.bja.addView(this.hfl.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.hfj = new d(this.mContext, str, this.fyU);
            this.hfj.a(this.gaj);
            this.bja.addView(this.hfj.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.bjf = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.hfh.setEmptyView(this.bjf);
    }

    public void EW() {
        if (this.hfj != null) {
            this.hfj.EW();
        }
    }

    public void setDatas(ArrayList<com.baidu.tieba.ala.data.h> arrayList) {
        if (this.hfi != null) {
            this.hfi.setData(arrayList);
            this.hfp = arrayList;
        }
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.h> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.hfm.setCountDownCallback(aVar);
        this.hfm.a(this.heG, this.fyT, j);
    }

    public ArrayList<com.baidu.tieba.ala.data.h> byG() {
        return this.hfp;
    }

    public void c(n nVar) {
        this.hfm.b(nVar);
    }

    public void vv(int i) {
        if (this.hfm != null) {
            this.hfm.setHourHeaderInfoVisible(i);
        }
    }

    public void vw(int i) {
        if (this.hfn != null) {
            this.hfn.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.hfm != null) {
            this.hfm.setRankListCallback(bVar);
        }
    }

    public void vx(int i) {
        this.hfh.setVisibility(i);
    }

    public p ccL() {
        return this.hfo;
    }

    public void c(final p pVar) {
        if (pVar == null) {
            if (this.hfj != null) {
                this.hfj.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!pVar.isValid()) {
            pVar.userName = this.mUserName;
            pVar.bdPortrait = this.mPortrait;
        }
        this.hfo = pVar;
        View view = null;
        if (this.hfj != null) {
            this.hfj.b(pVar);
            this.hfj.getView().setVisibility(0);
            view = this.hfj.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (pVar != null && (g.this.mContext instanceof Activity)) {
                        Intent intent = ((Activity) g.this.mContext).getIntent();
                        long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                        String stringExtra = intent.getStringExtra("group_id");
                        String stringExtra2 = intent.getStringExtra("live_id");
                        boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                        String stringExtra3 = intent.getStringExtra("live_owner_uid");
                        if (longExtra == pVar.userId) {
                            stringExtra3 = longExtra + "";
                        }
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(g.this.mContext, pVar.userId + "", pVar.userName, pVar.bdPortrait, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, pVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void ccM() {
        if (this.hfj != null) {
            this.hfj.getView().setVisibility(8);
        }
        if (this.hfk != null) {
            this.hfk.getView().setVisibility(8);
        }
        if (this.hfl != null) {
            this.hfl.getView().setVisibility(8);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.bjf.reset();
        this.bjf.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bjf.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.bjf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bjf.setVisibility(0);
    }

    public void bHn() {
        this.bjf.setVisibility(8);
    }

    public void kY(boolean z) {
        if (z) {
            this.bjf.reset();
            this.bjf.setTitle(a.i.rank_empty_text);
            this.bjf.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.bjf.setVisibility(0);
            return;
        }
        this.bjf.setVisibility(8);
    }

    public void release() {
        if (this.hfm != null) {
            this.hfm.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
