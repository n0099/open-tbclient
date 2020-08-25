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
    private int aED;
    private LinearLayout bgg;
    private CommonEmptyView bgl;
    private a fWS;
    private long fvC;
    private String fvE;
    private boolean fvF;
    private AlaLastLiveroomInfo fxt = new AlaLastLiveroomInfo();
    private BdListView haJ;
    private com.baidu.tieba.ala.adapter.c haK;
    private c haL;
    private e haM;
    private d haN;
    private AlaRankListHeaderView haO;
    private LinearLayout haP;
    private o haQ;
    private ArrayList<com.baidu.tieba.ala.data.h> haR;
    private TbPageContext<BaseFragmentActivity> hai;
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
        this.hai = tbPageContext;
        this.mContext = this.hai.getPageActivity();
        this.fWS = aVar;
        this.fvF = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.aED = i;
        this.mPortrait = str3;
        this.fvC = j2;
        this.fxt.setLastAnchorPortrait(str3);
        this.fxt.setLastAnchorUname(str2);
        this.fxt.setLastAnchorUid(String.valueOf(j));
        this.fxt.setLastLiveId(this.fvC);
        this.fxt.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
        GP(str);
    }

    private void GP(String str) {
        this.fvE = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.haJ = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.haK = new com.baidu.tieba.ala.adapter.c(this.mContext, str, this.fvC, this.fvF, this.fxt);
        this.haJ.setAdapter((ListAdapter) this.haK);
        this.haO = new AlaRankListHeaderView(this.hai.getPageActivity(), this.fvC, this.fvF, this.fxt);
        this.haO.a(this.hai, str, 0L);
        this.haJ.addHeaderView(this.haO);
        if (TextUtils.equals("hour", this.fvE) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.haP = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.haJ.addFooterView(this.haP);
            this.haP.setVisibility(0);
        } else if (this.haP != null) {
            this.haP.setVisibility(8);
        }
        this.bgg = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.haL = new c(this.mContext, str, this.fvF);
            this.haL.a(this.fWS);
            this.bgg.addView(this.haL.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.haM = new e(this.mContext, str, this.fvF, this.mUserId, this.aED, this.mPortrait);
            this.bgg.addView(this.haM.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.haN = new d(this.mContext, str, this.fvF, this.mPortrait);
            this.bgg.addView(this.haN.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.haL = new c(this.mContext, str, this.fvF);
            this.haL.a(this.fWS);
            this.bgg.addView(this.haL.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.bgl = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.haJ.setEmptyView(this.bgl);
    }

    public void EF() {
        if (this.haL != null) {
            this.haL.EF();
        }
    }

    public void setDatas(ArrayList<com.baidu.tieba.ala.data.h> arrayList) {
        if (this.haK != null) {
            this.haK.setData(arrayList);
            this.haR = arrayList;
        }
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.h> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.haO.setCountDownCallback(aVar);
        this.haO.a(this.hai, this.fvE, j);
    }

    public ArrayList<com.baidu.tieba.ala.data.h> bxw() {
        return this.haR;
    }

    public void c(n nVar) {
        this.haO.b(nVar);
    }

    public void vc(int i) {
        if (this.haO != null) {
            this.haO.setHourHeaderInfoVisible(i);
        }
    }

    public void vd(int i) {
        if (this.haP != null) {
            this.haP.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.haO != null) {
            this.haO.setRankListCallback(bVar);
        }
    }

    public void ve(int i) {
        this.haJ.setVisibility(i);
    }

    public o cao() {
        return this.haQ;
    }

    public void c(final o oVar) {
        if (oVar == null) {
            if (this.haL != null) {
                this.haL.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!oVar.isValid()) {
            oVar.userName = this.mUserName;
            oVar.fVe = this.mPortrait;
        }
        this.haQ = oVar;
        View view = null;
        if (this.haL != null) {
            this.haL.b(oVar);
            this.haL.getView().setVisibility(0);
            view = this.haL.getView();
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
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(f.this.mContext, oVar.userId + "", oVar.userName, oVar.fVe, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, oVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void cap() {
        if (this.haL != null) {
            this.haL.getView().setVisibility(8);
        }
        if (this.haM != null) {
            this.haM.getView().setVisibility(8);
        }
        if (this.haN != null) {
            this.haN.getView().setVisibility(8);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.bgl.reset();
        this.bgl.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bgl.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.bgl.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bgl.setVisibility(0);
    }

    public void bFW() {
        this.bgl.setVisibility(8);
    }

    public void kU(boolean z) {
        if (z) {
            this.bgl.reset();
            this.bgl.setTitle(a.i.rank_empty_text);
            this.bgl.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.bgl.setVisibility(0);
            return;
        }
        this.bgl.setVisibility(8);
    }

    public void release() {
        if (this.haO != null) {
            this.haO.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
