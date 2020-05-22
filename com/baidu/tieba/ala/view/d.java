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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {
    private LinearLayout aYe;
    private CommonEmptyView aYj;
    private int avX;
    private long eUH;
    private String eUJ;
    private boolean eUK;
    private a fue;
    private TbPageContext<BaseFragmentActivity> guN;
    private BdListView gvo;
    private com.baidu.tieba.ala.adapter.b gvp;
    private com.baidu.tieba.ala.view.a gvq;
    private c gvr;
    private b gvs;
    private AlaRankListHeaderView gvt;
    private LinearLayout gvu;
    private n gvv;
    private ArrayList<g> gvw;
    private Context mContext;
    private String mPortrait;
    private View mRootView;
    private long mUserId;
    private String mUserName;

    /* loaded from: classes3.dex */
    public interface a {
        void g(View view, String str);
    }

    public d(TbPageContext<BaseFragmentActivity> tbPageContext, String str, int i, a aVar, boolean z, long j, String str2, String str3, long j2) {
        this.guN = tbPageContext;
        this.mContext = this.guN.getPageActivity();
        this.fue = aVar;
        this.eUK = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.avX = i;
        this.mPortrait = str3;
        this.eUH = j2;
        De(str);
    }

    private void De(String str) {
        this.eUJ = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.gvo = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.gvp = new com.baidu.tieba.ala.adapter.b(this.mContext, str, this.eUH, this.eUK);
        this.gvo.setAdapter((ListAdapter) this.gvp);
        this.gvt = new AlaRankListHeaderView(this.guN.getPageActivity(), this.eUH, this.eUK);
        this.gvt.a(this.guN, str, 0L);
        this.gvo.addHeaderView(this.gvt);
        if (TextUtils.equals("hour", this.eUJ) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gvu = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.gvo.addFooterView(this.gvu);
            this.gvu.setVisibility(0);
        } else if (this.gvu != null) {
            this.gvu.setVisibility(8);
        }
        this.aYe = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.gvq = new com.baidu.tieba.ala.view.a(this.mContext, str, this.eUK);
            this.gvq.a(this.fue);
            this.aYe.addView(this.gvq.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.gvr = new c(this.mContext, str, this.eUK, this.mUserId, this.avX, this.mPortrait);
            this.aYe.addView(this.gvr.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.gvs = new b(this.mContext, str, this.eUK, this.mPortrait);
            this.aYe.addView(this.gvs.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.gvq = new com.baidu.tieba.ala.view.a(this.mContext, str, this.eUK);
            this.gvq.a(this.fue);
            this.aYe.addView(this.gvq.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.aYj = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.gvo.setEmptyView(this.aYj);
    }

    public void ya() {
        if (this.gvq != null) {
            this.gvq.ya();
        }
    }

    public void setDatas(ArrayList<g> arrayList) {
        if (this.gvp != null) {
            this.gvp.setData(arrayList);
            this.gvw = arrayList;
        }
    }

    public void a(ArrayList<g> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.gvt.setCountDownCallback(aVar);
        this.gvt.a(this.guN, this.eUJ, j);
    }

    public ArrayList<g> biq() {
        return this.gvw;
    }

    public void c(m mVar) {
        this.gvt.b(mVar);
    }

    public void rV(int i) {
        if (this.gvt != null) {
            this.gvt.setHourHeaderInfoVisible(i);
        }
    }

    public void rW(int i) {
        if (this.gvu != null) {
            this.gvu.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.gvt != null) {
            this.gvt.setRankListCallback(bVar);
        }
    }

    public void rX(int i) {
        this.gvo.setVisibility(i);
    }

    public n bJK() {
        return this.gvv;
    }

    public void c(final n nVar) {
        if (nVar == null) {
            if (this.gvq != null) {
                this.gvq.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!nVar.isValid()) {
            nVar.userName = this.mUserName;
            nVar.fsW = this.mPortrait;
        }
        this.gvv = nVar;
        View view = null;
        if (this.gvq != null) {
            this.gvq.b(nVar);
            this.gvq.getView().setVisibility(0);
            view = this.gvq.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (nVar != null && (d.this.mContext instanceof Activity)) {
                        Intent intent = ((Activity) d.this.mContext).getIntent();
                        long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                        String stringExtra = intent.getStringExtra("group_id");
                        String stringExtra2 = intent.getStringExtra("live_id");
                        boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                        String stringExtra3 = intent.getStringExtra("live_owner_uid");
                        if (longExtra == nVar.userId) {
                            stringExtra3 = longExtra + "";
                        }
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mContext, nVar.userId + "", nVar.userName, nVar.fsW, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, nVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void bJL() {
        if (this.gvq != null) {
            this.gvq.getView().setVisibility(8);
        }
        if (this.gvr != null) {
            this.gvr.getView().setVisibility(8);
        }
        if (this.gvs != null) {
            this.gvs.getView().setVisibility(8);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.aYj.reset();
        this.aYj.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aYj.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.aYj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.aYj.setVisibility(0);
    }

    public void bqO() {
        this.aYj.setVisibility(8);
    }

    public void jF(boolean z) {
        if (z) {
            this.aYj.reset();
            this.aYj.setTitle(a.i.rank_empty_text);
            this.aYj.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.aYj.setVisibility(0);
            return;
        }
        this.aYj.setVisibility(8);
    }

    public void release() {
        if (this.gvt != null) {
            this.gvt.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
