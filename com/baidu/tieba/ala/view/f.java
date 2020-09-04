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
import com.baidu.tieba.ala.data.o;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class f {
    private int aEF;
    private LinearLayout bgi;
    private CommonEmptyView bgn;
    private a fWW;
    private long fvG;
    private String fvI;
    private boolean fvJ;
    private AlaLastLiveroomInfo fxx = new AlaLastLiveroomInfo();
    private BdListView haN;
    private com.baidu.tieba.ala.adapter.c haO;
    private c haP;
    private e haQ;
    private d haR;
    private AlaRankListHeaderView haS;
    private LinearLayout haT;
    private o haU;
    private ArrayList<com.baidu.tieba.ala.data.h> haV;
    private TbPageContext<BaseFragmentActivity> ham;
    private Context mContext;
    private String mPortrait;
    private View mRootView;
    private long mUserId;
    private String mUserName;

    /* loaded from: classes7.dex */
    public interface a {
        void g(View view, String str);
    }

    public f(TbPageContext<BaseFragmentActivity> tbPageContext, String str, int i, a aVar, boolean z, long j, String str2, String str3, long j2) {
        this.ham = tbPageContext;
        this.mContext = this.ham.getPageActivity();
        this.fWW = aVar;
        this.fvJ = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.aEF = i;
        this.mPortrait = str3;
        this.fvG = j2;
        this.fxx.setLastAnchorPortrait(str3);
        this.fxx.setLastAnchorUname(str2);
        this.fxx.setLastAnchorUid(String.valueOf(j));
        this.fxx.setLastLiveId(this.fvG);
        this.fxx.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
        GQ(str);
    }

    private void GQ(String str) {
        this.fvI = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.haN = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.haO = new com.baidu.tieba.ala.adapter.c(this.mContext, str, this.fvG, this.fvJ, this.fxx);
        this.haN.setAdapter((ListAdapter) this.haO);
        this.haS = new AlaRankListHeaderView(this.ham.getPageActivity(), this.fvG, this.fvJ, this.fxx);
        this.haS.a(this.ham, str, 0L);
        this.haN.addHeaderView(this.haS);
        if (TextUtils.equals("hour", this.fvI) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.haT = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.haN.addFooterView(this.haT);
            this.haT.setVisibility(0);
        } else if (this.haT != null) {
            this.haT.setVisibility(8);
        }
        this.bgi = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.haP = new c(this.mContext, str, this.fvJ);
            this.haP.a(this.fWW);
            this.bgi.addView(this.haP.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.haQ = new e(this.mContext, str, this.fvJ, this.mUserId, this.aEF, this.mPortrait);
            this.bgi.addView(this.haQ.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.haR = new d(this.mContext, str, this.fvJ, this.mPortrait);
            this.bgi.addView(this.haR.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.haP = new c(this.mContext, str, this.fvJ);
            this.haP.a(this.fWW);
            this.bgi.addView(this.haP.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.bgn = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.haN.setEmptyView(this.bgn);
    }

    public void EF() {
        if (this.haP != null) {
            this.haP.EF();
        }
    }

    public void setDatas(ArrayList<com.baidu.tieba.ala.data.h> arrayList) {
        if (this.haO != null) {
            this.haO.setData(arrayList);
            this.haV = arrayList;
        }
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.h> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.haS.setCountDownCallback(aVar);
        this.haS.a(this.ham, this.fvI, j);
    }

    public ArrayList<com.baidu.tieba.ala.data.h> bxx() {
        return this.haV;
    }

    public void c(n nVar) {
        this.haS.b(nVar);
    }

    public void vc(int i) {
        if (this.haS != null) {
            this.haS.setHourHeaderInfoVisible(i);
        }
    }

    public void vd(int i) {
        if (this.haT != null) {
            this.haT.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.haS != null) {
            this.haS.setRankListCallback(bVar);
        }
    }

    public void ve(int i) {
        this.haN.setVisibility(i);
    }

    public o cap() {
        return this.haU;
    }

    public void c(final o oVar) {
        if (oVar == null) {
            if (this.haP != null) {
                this.haP.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!oVar.isValid()) {
            oVar.userName = this.mUserName;
            oVar.fVi = this.mPortrait;
        }
        this.haU = oVar;
        View view = null;
        if (this.haP != null) {
            this.haP.b(oVar);
            this.haP.getView().setVisibility(0);
            view = this.haP.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (oVar != null && (f.this.mContext instanceof Activity)) {
                        Intent intent = ((Activity) f.this.mContext).getIntent();
                        long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                        String stringExtra = intent.getStringExtra("group_id");
                        String stringExtra2 = intent.getStringExtra("live_id");
                        boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                        String stringExtra3 = intent.getStringExtra("live_owner_uid");
                        if (longExtra == oVar.userId) {
                            stringExtra3 = longExtra + "";
                        }
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(f.this.mContext, oVar.userId + "", oVar.userName, oVar.fVi, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, oVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void caq() {
        if (this.haP != null) {
            this.haP.getView().setVisibility(8);
        }
        if (this.haQ != null) {
            this.haQ.getView().setVisibility(8);
        }
        if (this.haR != null) {
            this.haR.getView().setVisibility(8);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.bgn.reset();
        this.bgn.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bgn.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.bgn.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bgn.setVisibility(0);
    }

    public void bFX() {
        this.bgn.setVisibility(8);
    }

    public void kW(boolean z) {
        if (z) {
            this.bgn.reset();
            this.bgn.setTitle(a.i.rank_empty_text);
            this.bgn.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.bgn.setVisibility(0);
            return;
        }
        this.bgn.setVisibility(8);
    }

    public void release() {
        if (this.haS != null) {
            this.haS.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
