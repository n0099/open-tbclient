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
    private int aLE;
    private LinearLayout bXZ;
    private LinearLayout btb;
    private CommonEmptyView btg;
    private a gKY;
    private long ggZ;
    private String ghb;
    private boolean ghc;
    private AlaLastLiveroomInfo giQ = new AlaLastLiveroomInfo();
    private TbPageContext<BaseFragmentActivity> hVY;
    private com.baidu.tieba.ala.adapter.c hWA;
    private d hWB;
    private f hWC;
    private e hWD;
    private AlaRankListHeaderView hWE;
    private r hWF;
    private ArrayList<com.baidu.tieba.ala.data.h> hWG;
    private BdListView hWz;
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
        this.hVY = tbPageContext;
        this.mContext = this.hVY.getPageActivity();
        this.gKY = aVar;
        this.ghc = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.aLE = i;
        this.mPortrait = str3;
        this.ggZ = j2;
        this.giQ.setLastAnchorPortrait(str3);
        this.giQ.setLastAnchorUname(str2);
        this.giQ.setLastAnchorUid(String.valueOf(j));
        this.giQ.setLastLiveId(this.ggZ);
        this.giQ.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
        Jg(str);
    }

    private void Jg(String str) {
        this.ghb = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_fragment_layout, (ViewGroup) null);
        this.hWz = (BdListView) this.mRootView.findViewById(a.f.ala_rank_list_view);
        this.hWA = new com.baidu.tieba.ala.adapter.c(this.mContext, str, this.ggZ, this.ghc, this.giQ);
        this.hWz.setAdapter((ListAdapter) this.hWA);
        this.hWE = new AlaRankListHeaderView(this.hVY.getPageActivity(), this.ggZ, this.ghc, this.giQ);
        this.hWE.a(this.hVY, str, 0L);
        this.hWz.addHeaderView(this.hWE);
        if (TextUtils.equals("hour", this.ghb) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.bXZ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.hour_rank_list_footer_view, (ViewGroup) null);
            this.hWz.addFooterView(this.bXZ);
            this.bXZ.setVisibility(0);
        } else if (this.bXZ != null) {
            this.bXZ.setVisibility(8);
        }
        this.btb = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.hWB = new d(this.mContext, str, this.ghc);
            this.hWB.a(this.gKY);
            this.btb.addView(this.hWB.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.hWC = new f(this.mContext, str, this.ghc, this.mUserId, this.aLE, this.mPortrait);
            this.btb.addView(this.hWC.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.hWD = new e(this.mContext, str, this.ghc, this.mPortrait);
            this.btb.addView(this.hWD.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.hWB = new d(this.mContext, str, this.ghc);
            this.hWB.a(this.gKY);
            this.btb.addView(this.hWB.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.btg = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_rank_list_empty);
        this.hWz.setEmptyView(this.btg);
    }

    public void HO() {
        if (this.hWB != null) {
            this.hWB.HO();
        }
    }

    public void setDatas(ArrayList<com.baidu.tieba.ala.data.h> arrayList) {
        if (this.hWA != null) {
            this.hWA.setData(arrayList);
            this.hWG = arrayList;
        }
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.h> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.hWE.setCountDownCallback(aVar);
        this.hWE.a(this.hVY, this.ghb, j);
    }

    public ArrayList<com.baidu.tieba.ala.data.h> bIC() {
        return this.hWG;
    }

    public void c(p pVar) {
        this.hWE.b(pVar);
    }

    public void xM(int i) {
        if (this.hWE != null) {
            this.hWE.setHourHeaderInfoVisible(i);
        }
    }

    public void gV(int i) {
        if (this.bXZ != null) {
            this.bXZ.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.hWE != null) {
            this.hWE.setRankListCallback(bVar);
        }
    }

    public void xN(int i) {
        this.hWz.setVisibility(i);
    }

    public r cpr() {
        return this.hWF;
    }

    public void c(final r rVar) {
        if (rVar == null) {
            if (this.hWB != null) {
                this.hWB.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!rVar.isValid()) {
            rVar.userName = this.mUserName;
            rVar.bdPortrait = this.mPortrait;
        }
        this.hWF = rVar;
        View view = null;
        if (this.hWB != null) {
            this.hWB.b(rVar);
            this.hWB.getView().setVisibility(0);
            view = this.hWB.getView();
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

    public void cps() {
        if (this.hWB != null) {
            this.hWB.getView().setVisibility(8);
        }
        if (this.hWC != null) {
            this.hWC.getView().setVisibility(8);
        }
        if (this.hWD != null) {
            this.hWD.getView().setVisibility(8);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.btg.reset();
        this.btg.setTitle(a.h.sdk_net_fail_tip_rank);
        this.btg.setRefreshButton(a.h.sdk_click_refresh_net_text, onClickListener);
        this.btg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.btg.setVisibility(0);
    }

    public void Yb() {
        this.btg.setVisibility(8);
    }

    public void dG(boolean z) {
        if (z) {
            this.btg.reset();
            this.btg.setTitle(a.h.rank_empty_text);
            this.btg.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.btg.setVisibility(0);
            return;
        }
        this.btg.setVisibility(8);
    }

    public void release() {
        if (this.hWE != null) {
            this.hWE.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
