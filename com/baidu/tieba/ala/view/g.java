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
/* loaded from: classes4.dex */
public class g {
    private int aJw;
    private LinearLayout bOJ;
    private LinearLayout bol;
    private CommonEmptyView boq;
    private long fTr;
    private String fTt;
    private boolean fTu;
    private AlaLastLiveroomInfo fVh = new AlaLastLiveroomInfo();
    private a gwG;
    private TbPageContext<BaseFragmentActivity> hFA;
    private BdListView hGb;
    private com.baidu.tieba.ala.adapter.c hGc;
    private d hGd;
    private f hGe;
    private e hGf;
    private AlaRankListHeaderView hGg;
    private r hGh;
    private ArrayList<com.baidu.tieba.ala.data.h> hGi;
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
        this.hFA = tbPageContext;
        this.mContext = this.hFA.getPageActivity();
        this.gwG = aVar;
        this.fTu = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.aJw = i;
        this.mPortrait = str3;
        this.fTr = j2;
        this.fVh.setLastAnchorPortrait(str3);
        this.fVh.setLastAnchorUname(str2);
        this.fVh.setLastAnchorUid(String.valueOf(j));
        this.fVh.setLastLiveId(this.fTr);
        this.fVh.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
        Ix(str);
    }

    private void Ix(String str) {
        this.fTt = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.hGb = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.hGc = new com.baidu.tieba.ala.adapter.c(this.mContext, str, this.fTr, this.fTu, this.fVh);
        this.hGb.setAdapter((ListAdapter) this.hGc);
        this.hGg = new AlaRankListHeaderView(this.hFA.getPageActivity(), this.fTr, this.fTu, this.fVh);
        this.hGg.a(this.hFA, str, 0L);
        this.hGb.addHeaderView(this.hGg);
        if (TextUtils.equals("hour", this.fTt) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.bOJ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.hGb.addFooterView(this.bOJ);
            this.bOJ.setVisibility(0);
        } else if (this.bOJ != null) {
            this.bOJ.setVisibility(8);
        }
        this.bol = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.hGd = new d(this.mContext, str, this.fTu);
            this.hGd.a(this.gwG);
            this.bol.addView(this.hGd.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.hGe = new f(this.mContext, str, this.fTu, this.mUserId, this.aJw, this.mPortrait);
            this.bol.addView(this.hGe.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.hGf = new e(this.mContext, str, this.fTu, this.mPortrait);
            this.bol.addView(this.hGf.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.hGd = new d(this.mContext, str, this.fTu);
            this.hGd.a(this.gwG);
            this.bol.addView(this.hGd.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.boq = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.hGb.setEmptyView(this.boq);
    }

    public void Gh() {
        if (this.hGd != null) {
            this.hGd.Gh();
        }
    }

    public void setDatas(ArrayList<com.baidu.tieba.ala.data.h> arrayList) {
        if (this.hGc != null) {
            this.hGc.setData(arrayList);
            this.hGi = arrayList;
        }
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.h> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.hGg.setCountDownCallback(aVar);
        this.hGg.a(this.hFA, this.fTt, j);
    }

    public ArrayList<com.baidu.tieba.ala.data.h> bDj() {
        return this.hGi;
    }

    public void c(p pVar) {
        this.hGg.b(pVar);
    }

    public void wv(int i) {
        if (this.hGg != null) {
            this.hGg.setHourHeaderInfoVisible(i);
        }
    }

    public void gr(int i) {
        if (this.bOJ != null) {
            this.bOJ.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.hGg != null) {
            this.hGg.setRankListCallback(bVar);
        }
    }

    public void ww(int i) {
        this.hGb.setVisibility(i);
    }

    public r cjh() {
        return this.hGh;
    }

    public void c(final r rVar) {
        if (rVar == null) {
            if (this.hGd != null) {
                this.hGd.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!rVar.isValid()) {
            rVar.userName = this.mUserName;
            rVar.bdPortrait = this.mPortrait;
        }
        this.hGh = rVar;
        View view = null;
        if (this.hGd != null) {
            this.hGd.b(rVar);
            this.hGd.getView().setVisibility(0);
            view = this.hGd.getView();
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
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(g.this.mContext, rVar.userId + "", rVar.userName, rVar.bdPortrait, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, rVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void cji() {
        if (this.hGd != null) {
            this.hGd.getView().setVisibility(8);
        }
        if (this.hGe != null) {
            this.hGe.getView().setVisibility(8);
        }
        if (this.hGf != null) {
            this.hGf.getView().setVisibility(8);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.boq.reset();
        this.boq.setTitle(a.i.sdk_net_fail_tip_rank);
        this.boq.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.boq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.boq.setVisibility(0);
    }

    public void TK() {
        this.boq.setVisibility(8);
    }

    public void dj(boolean z) {
        if (z) {
            this.boq.reset();
            this.boq.setTitle(a.i.rank_empty_text);
            this.boq.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.boq.setVisibility(0);
            return;
        }
        this.boq.setVisibility(8);
    }

    public void release() {
        if (this.hGg != null) {
            this.hGg.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
