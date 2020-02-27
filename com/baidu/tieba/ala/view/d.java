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
    private int Yx;
    private a eBp;
    private long ehK;
    private String ehM;
    private boolean ehN;
    private CommonEmptyView evQ;
    private BdListView fAR;
    private com.baidu.tieba.ala.adapter.b fAS;
    private LinearLayout fAT;
    private com.baidu.tieba.ala.view.a fAU;
    private c fAV;
    private b fAW;
    private AlaRankListHeaderView fAX;
    private LinearLayout fAY;
    private n fAZ;
    private TbPageContext<BaseFragmentActivity> fAq;
    private ArrayList<g> fBa;
    private Context mContext;
    private String mPortrait;
    private View mRootView;
    private long mUserId;
    private String mUserName;

    /* loaded from: classes3.dex */
    public interface a {
        void f(View view, String str);
    }

    public d(TbPageContext<BaseFragmentActivity> tbPageContext, String str, int i, a aVar, boolean z, long j, String str2, String str3, long j2) {
        this.fAq = tbPageContext;
        this.mContext = this.fAq.getPageActivity();
        this.eBp = aVar;
        this.ehN = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.Yx = i;
        this.mPortrait = str3;
        this.ehK = j2;
        zJ(str);
    }

    private void zJ(String str) {
        this.ehM = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.fAR = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.fAS = new com.baidu.tieba.ala.adapter.b(this.mContext, str, this.ehK, this.ehN);
        this.fAR.setAdapter((ListAdapter) this.fAS);
        this.fAX = new AlaRankListHeaderView(this.fAq.getPageActivity(), this.ehK, this.ehN);
        this.fAX.a(this.fAq, str, 0L);
        this.fAR.addHeaderView(this.fAX);
        if (TextUtils.equals("hour", this.ehM) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fAY = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.fAR.addFooterView(this.fAY);
            this.fAY.setVisibility(0);
        } else if (this.fAY != null) {
            this.fAY.setVisibility(8);
        }
        this.fAT = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.fAU = new com.baidu.tieba.ala.view.a(this.mContext, str, this.ehN);
            this.fAU.a(this.eBp);
            this.fAT.addView(this.fAU.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.fAV = new c(this.mContext, str, this.ehN, this.mUserId, this.Yx, this.mPortrait);
            this.fAT.addView(this.fAV.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.fAW = new b(this.mContext, str, this.ehN, this.mPortrait);
            this.fAT.addView(this.fAW.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.fAU = new com.baidu.tieba.ala.view.a(this.mContext, str, this.ehN);
            this.fAU.a(this.eBp);
            this.fAT.addView(this.fAU.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.evQ = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.fAR.setEmptyView(this.evQ);
    }

    public void sm() {
        if (this.fAU != null) {
            this.fAU.sm();
        }
    }

    public void setDatas(ArrayList<g> arrayList) {
        if (this.fAS != null) {
            this.fAS.setData(arrayList);
            this.fBa = arrayList;
        }
    }

    public void a(ArrayList<g> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.fAX.setCountDownCallback(aVar);
        this.fAX.a(this.fAq, this.ehM, j);
    }

    public ArrayList<g> aTQ() {
        return this.fBa;
    }

    public void c(m mVar) {
        this.fAX.b(mVar);
    }

    public void qX(int i) {
        if (this.fAX != null) {
            this.fAX.setHourHeaderInfoVisible(i);
        }
    }

    public void qY(int i) {
        if (this.fAY != null) {
            this.fAY.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.fAX != null) {
            this.fAX.setRankListCallback(bVar);
        }
    }

    public void qZ(int i) {
        this.fAR.setVisibility(i);
    }

    public n btB() {
        return this.fAZ;
    }

    public void c(final n nVar) {
        if (nVar == null) {
            if (this.fAU != null) {
                this.fAU.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!nVar.isValid()) {
            nVar.userName = this.mUserName;
            nVar.eAj = this.mPortrait;
        }
        this.fAZ = nVar;
        View view = null;
        if (this.fAU != null) {
            this.fAU.b(nVar);
            this.fAU.getView().setVisibility(0);
            view = this.fAU.getView();
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
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mContext, nVar.userId + "", nVar.userName, nVar.eAj, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, nVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void btC() {
        if (this.fAU != null) {
            this.fAU.getView().setVisibility(8);
        }
        if (this.fAV != null) {
            this.fAV.getView().setVisibility(8);
        }
        if (this.fAW != null) {
            this.fAW.getView().setVisibility(8);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.evQ.reset();
        this.evQ.setTitle(a.i.sdk_net_fail_tip_rank);
        this.evQ.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.evQ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.evQ.setVisibility(0);
    }

    public void bcv() {
        this.evQ.setVisibility(8);
    }

    public void ij(boolean z) {
        if (z) {
            this.evQ.reset();
            this.evQ.setTitle(a.i.rank_empty_text);
            this.evQ.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.evQ.setVisibility(0);
            return;
        }
        this.evQ.setVisibility(8);
    }

    public void release() {
        if (this.fAX != null) {
            this.fAX.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
