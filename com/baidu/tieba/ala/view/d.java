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
    private int YH;
    private a eBZ;
    private long eio;
    private String eiq;
    private boolean eir;
    private CommonEmptyView ewA;
    private BdListView fBO;
    private com.baidu.tieba.ala.adapter.b fBP;
    private LinearLayout fBQ;
    private com.baidu.tieba.ala.view.a fBR;
    private c fBS;
    private b fBT;
    private AlaRankListHeaderView fBU;
    private LinearLayout fBV;
    private n fBW;
    private ArrayList<g> fBX;
    private TbPageContext<BaseFragmentActivity> fBn;
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
        this.fBn = tbPageContext;
        this.mContext = this.fBn.getPageActivity();
        this.eBZ = aVar;
        this.eir = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.YH = i;
        this.mPortrait = str3;
        this.eio = j2;
        zL(str);
    }

    private void zL(String str) {
        this.eiq = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.fBO = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.fBP = new com.baidu.tieba.ala.adapter.b(this.mContext, str, this.eio, this.eir);
        this.fBO.setAdapter((ListAdapter) this.fBP);
        this.fBU = new AlaRankListHeaderView(this.fBn.getPageActivity(), this.eio, this.eir);
        this.fBU.a(this.fBn, str, 0L);
        this.fBO.addHeaderView(this.fBU);
        if (TextUtils.equals("hour", this.eiq) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fBV = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.fBO.addFooterView(this.fBV);
            this.fBV.setVisibility(0);
        } else if (this.fBV != null) {
            this.fBV.setVisibility(8);
        }
        this.fBQ = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.fBR = new com.baidu.tieba.ala.view.a(this.mContext, str, this.eir);
            this.fBR.a(this.eBZ);
            this.fBQ.addView(this.fBR.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.fBS = new c(this.mContext, str, this.eir, this.mUserId, this.YH, this.mPortrait);
            this.fBQ.addView(this.fBS.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.fBT = new b(this.mContext, str, this.eir, this.mPortrait);
            this.fBQ.addView(this.fBT.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.fBR = new com.baidu.tieba.ala.view.a(this.mContext, str, this.eir);
            this.fBR.a(this.eBZ);
            this.fBQ.addView(this.fBR.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.ewA = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.fBO.setEmptyView(this.ewA);
    }

    public void sr() {
        if (this.fBR != null) {
            this.fBR.sr();
        }
    }

    public void setDatas(ArrayList<g> arrayList) {
        if (this.fBP != null) {
            this.fBP.setData(arrayList);
            this.fBX = arrayList;
        }
    }

    public void a(ArrayList<g> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.fBU.setCountDownCallback(aVar);
        this.fBU.a(this.fBn, this.eiq, j);
    }

    public ArrayList<g> aTX() {
        return this.fBX;
    }

    public void c(m mVar) {
        this.fBU.b(mVar);
    }

    public void qZ(int i) {
        if (this.fBU != null) {
            this.fBU.setHourHeaderInfoVisible(i);
        }
    }

    public void ra(int i) {
        if (this.fBV != null) {
            this.fBV.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.fBU != null) {
            this.fBU.setRankListCallback(bVar);
        }
    }

    public void rb(int i) {
        this.fBO.setVisibility(i);
    }

    public n btJ() {
        return this.fBW;
    }

    public void c(final n nVar) {
        if (nVar == null) {
            if (this.fBR != null) {
                this.fBR.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!nVar.isValid()) {
            nVar.userName = this.mUserName;
            nVar.eAT = this.mPortrait;
        }
        this.fBW = nVar;
        View view = null;
        if (this.fBR != null) {
            this.fBR.b(nVar);
            this.fBR.getView().setVisibility(0);
            view = this.fBR.getView();
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
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mContext, nVar.userId + "", nVar.userName, nVar.eAT, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, nVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void btK() {
        if (this.fBR != null) {
            this.fBR.getView().setVisibility(8);
        }
        if (this.fBS != null) {
            this.fBS.getView().setVisibility(8);
        }
        if (this.fBT != null) {
            this.fBT.getView().setVisibility(8);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.ewA.reset();
        this.ewA.setTitle(a.i.sdk_net_fail_tip_rank);
        this.ewA.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.ewA.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.ewA.setVisibility(0);
    }

    public void bcC() {
        this.ewA.setVisibility(8);
    }

    public void il(boolean z) {
        if (z) {
            this.ewA.reset();
            this.ewA.setTitle(a.i.rank_empty_text);
            this.ewA.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.ewA.setVisibility(0);
            return;
        }
        this.ewA.setVisibility(8);
    }

    public void release() {
        if (this.fBU != null) {
            this.fBU.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
