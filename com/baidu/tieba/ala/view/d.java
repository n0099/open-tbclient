package com.baidu.tieba.ala.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class d {
    private int Ws;
    private String edB;
    private boolean edC;
    private long edz;
    private CommonEmptyView eqt;
    private a evU;
    private TbPageContext<BaseFragmentActivity> fuH;
    private BdListView fvi;
    private com.baidu.tieba.ala.adapter.b fvj;
    private LinearLayout fvk;
    private com.baidu.tieba.ala.view.a fvl;
    private c fvm;
    private b fvn;
    private AlaRankListHeaderView fvo;
    private LinearLayout fvp;
    private n fvq;
    private ArrayList<g> fvr;
    private Context mContext;
    private String mPortrait;
    private View mRootView;
    private long mUserId;
    private String mUserName;

    /* loaded from: classes2.dex */
    public interface a {
        void f(View view, String str);
    }

    public d(TbPageContext<BaseFragmentActivity> tbPageContext, String str, int i, a aVar, boolean z, long j, String str2, String str3, long j2) {
        this.fuH = tbPageContext;
        this.mContext = this.fuH.getPageActivity();
        this.evU = aVar;
        this.edC = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.Ws = i;
        this.mPortrait = str3;
        this.edz = j2;
        zj(str);
    }

    private void zj(String str) {
        this.edB = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.fvi = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.fvj = new com.baidu.tieba.ala.adapter.b(this.mContext, str, this.edz, this.edC);
        this.fvi.setAdapter((ListAdapter) this.fvj);
        this.fvo = new AlaRankListHeaderView(this.fuH.getPageActivity(), this.edz, this.edC);
        this.fvo.a(this.fuH, str, 0L);
        this.fvi.addHeaderView(this.fvo);
        if (TextUtils.equals("hour", this.edB) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fvp = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.fvi.addFooterView(this.fvp);
            this.fvp.setVisibility(0);
        } else if (this.fvp != null) {
            this.fvp.setVisibility(8);
        }
        this.fvk = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.fvl = new com.baidu.tieba.ala.view.a(this.mContext, str, this.edC);
            this.fvl.a(this.evU);
            this.fvk.addView(this.fvl.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.fvm = new c(this.mContext, str, this.edC, this.mUserId, this.Ws, this.mPortrait);
            this.fvk.addView(this.fvm.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.fvn = new b(this.mContext, str, this.edC, this.mPortrait);
            this.fvk.addView(this.fvn.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if (!"challenge_history".equals(str)) {
            this.fvl = new com.baidu.tieba.ala.view.a(this.mContext, str, this.edC);
            this.fvl.a(this.evU);
            this.fvk.addView(this.fvl.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.eqt = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.fvi.setEmptyView(this.eqt);
    }

    public void qZ() {
        if (this.fvl != null) {
            this.fvl.qZ();
        }
    }

    public void setDatas(ArrayList<g> arrayList) {
        if (this.fvj != null) {
            this.fvj.setData(arrayList);
            this.fvr = arrayList;
        }
    }

    public void a(ArrayList<g> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.fvo.setCountDownCallback(aVar);
        this.fvo.a(this.fuH, this.edB, j);
    }

    public ArrayList<g> aRf() {
        return this.fvr;
    }

    public void c(m mVar) {
        this.fvo.b(mVar);
    }

    public void qL(int i) {
        if (this.fvo != null) {
            this.fvo.setHourHeaderInfoVisible(i);
        }
    }

    public void qM(int i) {
        if (this.fvp != null) {
            this.fvp.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.fvo != null) {
            this.fvo.setRankListCallback(bVar);
        }
    }

    public void qN(int i) {
        this.fvi.setVisibility(i);
    }

    public n bqV() {
        return this.fvq;
    }

    public void c(final n nVar) {
        if (nVar == null) {
            if (this.fvl != null) {
                this.fvl.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!nVar.isValid()) {
            nVar.userName = this.mUserName;
            nVar.euN = this.mPortrait;
        }
        this.fvq = nVar;
        View view = null;
        if (this.fvl != null) {
            this.fvl.b(nVar);
            this.fvl.getView().setVisibility(0);
            view = this.fvl.getView();
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
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mContext, nVar.userId + "", nVar.userName, nVar.euN, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, nVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void bqW() {
        if (this.fvl != null) {
            this.fvl.getView().setVisibility(8);
        }
        if (this.fvm != null) {
            this.fvm.getView().setVisibility(8);
        }
        if (this.fvn != null) {
            this.fvn.getView().setVisibility(8);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.eqt.reset();
        this.eqt.setTitle(a.i.sdk_net_fail_tip_rank);
        this.eqt.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.eqt.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.eqt.setVisibility(0);
    }

    public void aZK() {
        this.eqt.setVisibility(8);
    }

    public void hS(boolean z) {
        if (z) {
            this.eqt.reset();
            this.eqt.setTitle(a.i.rank_empty_text);
            this.eqt.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.eqt.setVisibility(0);
            return;
        }
        this.eqt.setVisibility(8);
    }

    public void release() {
        if (this.fvo != null) {
            this.fvo.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
