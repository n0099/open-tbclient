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
    private int aIL;
    private LinearLayout bSJ;
    private LinearLayout bnT;
    private CommonEmptyView bnY;
    private long fYO;
    private String fYQ;
    private boolean fYR;
    private a gCb;
    private AlaLastLiveroomInfo gaF = new AlaLastLiveroomInfo();
    private BdListView hLF;
    private com.baidu.tieba.ala.adapter.c hLG;
    private d hLH;
    private f hLI;
    private e hLJ;
    private AlaRankListHeaderView hLK;
    private r hLL;
    private ArrayList<com.baidu.tieba.ala.data.h> hLM;
    private TbPageContext<BaseFragmentActivity> hLe;
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
        this.hLe = tbPageContext;
        this.mContext = this.hLe.getPageActivity();
        this.gCb = aVar;
        this.fYR = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.aIL = i;
        this.mPortrait = str3;
        this.fYO = j2;
        this.gaF.setLastAnchorPortrait(str3);
        this.gaF.setLastAnchorUname(str2);
        this.gaF.setLastAnchorUid(String.valueOf(j));
        this.gaF.setLastLiveId(this.fYO);
        this.gaF.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
        Ip(str);
    }

    private void Ip(String str) {
        this.fYQ = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_fragment_layout, (ViewGroup) null);
        this.hLF = (BdListView) this.mRootView.findViewById(a.f.ala_rank_list_view);
        this.hLG = new com.baidu.tieba.ala.adapter.c(this.mContext, str, this.fYO, this.fYR, this.gaF);
        this.hLF.setAdapter((ListAdapter) this.hLG);
        this.hLK = new AlaRankListHeaderView(this.hLe.getPageActivity(), this.fYO, this.fYR, this.gaF);
        this.hLK.a(this.hLe, str, 0L);
        this.hLF.addHeaderView(this.hLK);
        if (TextUtils.equals("hour", this.fYQ) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.bSJ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.hour_rank_list_footer_view, (ViewGroup) null);
            this.hLF.addFooterView(this.bSJ);
            this.bSJ.setVisibility(0);
        } else if (this.bSJ != null) {
            this.bSJ.setVisibility(8);
        }
        this.bnT = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.hLH = new d(this.mContext, str, this.fYR);
            this.hLH.a(this.gCb);
            this.bnT.addView(this.hLH.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.hLI = new f(this.mContext, str, this.fYR, this.mUserId, this.aIL, this.mPortrait);
            this.bnT.addView(this.hLI.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.hLJ = new e(this.mContext, str, this.fYR, this.mPortrait);
            this.bnT.addView(this.hLJ.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.hLH = new d(this.mContext, str, this.fYR);
            this.hLH.a(this.gCb);
            this.bnT.addView(this.hLH.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.bnY = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_rank_list_empty);
        this.hLF.setEmptyView(this.bnY);
    }

    public void FZ() {
        if (this.hLH != null) {
            this.hLH.FZ();
        }
    }

    public void setDatas(ArrayList<com.baidu.tieba.ala.data.h> arrayList) {
        if (this.hLG != null) {
            this.hLG.setData(arrayList);
            this.hLM = arrayList;
        }
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.h> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.hLK.setCountDownCallback(aVar);
        this.hLK.a(this.hLe, this.fYQ, j);
    }

    public ArrayList<com.baidu.tieba.ala.data.h> bFb() {
        return this.hLM;
    }

    public void c(p pVar) {
        this.hLK.b(pVar);
    }

    public void xg(int i) {
        if (this.hLK != null) {
            this.hLK.setHourHeaderInfoVisible(i);
        }
    }

    public void gx(int i) {
        if (this.bSJ != null) {
            this.bSJ.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.hLK != null) {
            this.hLK.setRankListCallback(bVar);
        }
    }

    public void xh(int i) {
        this.hLF.setVisibility(i);
    }

    public r clc() {
        return this.hLL;
    }

    public void c(final r rVar) {
        if (rVar == null) {
            if (this.hLH != null) {
                this.hLH.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!rVar.isValid()) {
            rVar.userName = this.mUserName;
            rVar.bdPortrait = this.mPortrait;
        }
        this.hLL = rVar;
        View view = null;
        if (this.hLH != null) {
            this.hLH.b(rVar);
            this.hLH.getView().setVisibility(0);
            view = this.hLH.getView();
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

    public void cld() {
        if (this.hLH != null) {
            this.hLH.getView().setVisibility(8);
        }
        if (this.hLI != null) {
            this.hLI.getView().setVisibility(8);
        }
        if (this.hLJ != null) {
            this.hLJ.getView().setVisibility(8);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.bnY.reset();
        this.bnY.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bnY.setRefreshButton(a.h.sdk_click_refresh_net_text, onClickListener);
        this.bnY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bnY.setVisibility(0);
    }

    public void VB() {
        this.bnY.setVisibility(8);
    }

    public void ds(boolean z) {
        if (z) {
            this.bnY.reset();
            this.bnY.setTitle(a.h.rank_empty_text);
            this.bnY.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.bnY.setVisibility(0);
            return;
        }
        this.bnY.setVisibility(8);
    }

    public void release() {
        if (this.hLK != null) {
            this.hLK.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
