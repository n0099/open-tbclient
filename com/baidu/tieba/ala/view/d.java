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
    private a eBq;
    private long ehL;
    private String ehN;
    private boolean ehO;
    private CommonEmptyView evR;
    private BdListView fAT;
    private com.baidu.tieba.ala.adapter.b fAU;
    private LinearLayout fAV;
    private com.baidu.tieba.ala.view.a fAW;
    private c fAX;
    private b fAY;
    private AlaRankListHeaderView fAZ;
    private TbPageContext<BaseFragmentActivity> fAs;
    private LinearLayout fBa;
    private n fBb;
    private ArrayList<g> fBc;
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
        this.fAs = tbPageContext;
        this.mContext = this.fAs.getPageActivity();
        this.eBq = aVar;
        this.ehO = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.Yx = i;
        this.mPortrait = str3;
        this.ehL = j2;
        zJ(str);
    }

    private void zJ(String str) {
        this.ehN = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.fAT = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.fAU = new com.baidu.tieba.ala.adapter.b(this.mContext, str, this.ehL, this.ehO);
        this.fAT.setAdapter((ListAdapter) this.fAU);
        this.fAZ = new AlaRankListHeaderView(this.fAs.getPageActivity(), this.ehL, this.ehO);
        this.fAZ.a(this.fAs, str, 0L);
        this.fAT.addHeaderView(this.fAZ);
        if (TextUtils.equals("hour", this.ehN) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fBa = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.fAT.addFooterView(this.fBa);
            this.fBa.setVisibility(0);
        } else if (this.fBa != null) {
            this.fBa.setVisibility(8);
        }
        this.fAV = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.fAW = new com.baidu.tieba.ala.view.a(this.mContext, str, this.ehO);
            this.fAW.a(this.eBq);
            this.fAV.addView(this.fAW.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.fAX = new c(this.mContext, str, this.ehO, this.mUserId, this.Yx, this.mPortrait);
            this.fAV.addView(this.fAX.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.fAY = new b(this.mContext, str, this.ehO, this.mPortrait);
            this.fAV.addView(this.fAY.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.fAW = new com.baidu.tieba.ala.view.a(this.mContext, str, this.ehO);
            this.fAW.a(this.eBq);
            this.fAV.addView(this.fAW.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.evR = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.fAT.setEmptyView(this.evR);
    }

    public void sm() {
        if (this.fAW != null) {
            this.fAW.sm();
        }
    }

    public void setDatas(ArrayList<g> arrayList) {
        if (this.fAU != null) {
            this.fAU.setData(arrayList);
            this.fBc = arrayList;
        }
    }

    public void a(ArrayList<g> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.fAZ.setCountDownCallback(aVar);
        this.fAZ.a(this.fAs, this.ehN, j);
    }

    public ArrayList<g> aTS() {
        return this.fBc;
    }

    public void c(m mVar) {
        this.fAZ.b(mVar);
    }

    public void qX(int i) {
        if (this.fAZ != null) {
            this.fAZ.setHourHeaderInfoVisible(i);
        }
    }

    public void qY(int i) {
        if (this.fBa != null) {
            this.fBa.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.fAZ != null) {
            this.fAZ.setRankListCallback(bVar);
        }
    }

    public void qZ(int i) {
        this.fAT.setVisibility(i);
    }

    public n btD() {
        return this.fBb;
    }

    public void c(final n nVar) {
        if (nVar == null) {
            if (this.fAW != null) {
                this.fAW.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!nVar.isValid()) {
            nVar.userName = this.mUserName;
            nVar.eAk = this.mPortrait;
        }
        this.fBb = nVar;
        View view = null;
        if (this.fAW != null) {
            this.fAW.b(nVar);
            this.fAW.getView().setVisibility(0);
            view = this.fAW.getView();
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
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mContext, nVar.userId + "", nVar.userName, nVar.eAk, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, nVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void btE() {
        if (this.fAW != null) {
            this.fAW.getView().setVisibility(8);
        }
        if (this.fAX != null) {
            this.fAX.getView().setVisibility(8);
        }
        if (this.fAY != null) {
            this.fAY.getView().setVisibility(8);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.evR.reset();
        this.evR.setTitle(a.i.sdk_net_fail_tip_rank);
        this.evR.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.evR.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.evR.setVisibility(0);
    }

    public void bcx() {
        this.evR.setVisibility(8);
    }

    public void ij(boolean z) {
        if (z) {
            this.evR.reset();
            this.evR.setTitle(a.i.rank_empty_text);
            this.evR.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.evR.setVisibility(0);
            return;
        }
        this.evR.setVisibility(8);
    }

    public void release() {
        if (this.fAZ != null) {
            this.fAZ.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
