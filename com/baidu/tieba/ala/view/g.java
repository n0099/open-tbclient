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
/* loaded from: classes11.dex */
public class g {
    private int aKa;
    private LinearLayout bwE;
    private CommonEmptyView bwJ;
    private LinearLayout cdZ;
    private a gUQ;
    private long gpB;
    private String gpD;
    private boolean gpE;
    private AlaLastLiveroomInfo grr = new AlaLastLiveroomInfo();
    private TbPageContext<BaseFragmentActivity> iiN;
    private BdListView ijo;
    private com.baidu.tieba.ala.adapter.c ijp;
    private d ijq;
    private f ijr;
    private e ijs;
    private AlaRankListHeaderView ijt;
    private r iju;
    private ArrayList<com.baidu.tieba.ala.data.h> ijv;
    private Context mContext;
    private String mPortrait;
    private View mRootView;
    private long mUserId;
    private String mUserName;

    /* loaded from: classes11.dex */
    public interface a {
        void h(View view, String str);
    }

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, int i, a aVar, boolean z, long j, String str2, String str3, long j2) {
        this.iiN = tbPageContext;
        this.mContext = this.iiN.getPageActivity();
        this.gUQ = aVar;
        this.gpE = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.aKa = i;
        this.mPortrait = str3;
        this.gpB = j2;
        this.grr.setLastAnchorPortrait(str3);
        this.grr.setLastAnchorUname(str2);
        this.grr.setLastAnchorUid(String.valueOf(j));
        this.grr.setLastLiveId(this.gpB);
        this.grr.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
        Iy(str);
    }

    private void Iy(String str) {
        this.gpD = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_fragment_layout, (ViewGroup) null);
        this.ijo = (BdListView) this.mRootView.findViewById(a.f.ala_rank_list_view);
        this.ijp = new com.baidu.tieba.ala.adapter.c(this.mContext, str, this.gpB, this.gpE, this.grr);
        this.ijo.setAdapter((ListAdapter) this.ijp);
        this.ijt = new AlaRankListHeaderView(this.iiN.getPageActivity(), this.gpB, this.gpE, this.grr);
        this.ijt.a(this.iiN, str, 0L);
        this.ijo.addHeaderView(this.ijt);
        if (TextUtils.equals("hour", this.gpD) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.cdZ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.hour_rank_list_footer_view, (ViewGroup) null);
            this.ijo.addFooterView(this.cdZ);
            this.cdZ.setVisibility(0);
        } else if (this.cdZ != null) {
            this.cdZ.setVisibility(8);
        }
        this.bwE = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.ijq = new d(this.mContext, str, this.gpE);
            this.ijq.a(this.gUQ);
            this.bwE.addView(this.ijq.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.ijr = new f(this.mContext, str, this.gpE, this.mUserId, this.aKa, this.mPortrait);
            this.bwE.addView(this.ijr.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.ijs = new e(this.mContext, str, this.gpE, this.mPortrait);
            this.bwE.addView(this.ijs.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.ijq = new d(this.mContext, str, this.gpE);
            this.ijq.a(this.gUQ);
            this.bwE.addView(this.ijq.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.bwJ = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_rank_list_empty);
        this.ijo.setEmptyView(this.bwJ);
    }

    public void EK() {
        if (this.ijq != null) {
            this.ijq.EK();
        }
    }

    public void setDatas(ArrayList<com.baidu.tieba.ala.data.h> arrayList) {
        if (this.ijp != null) {
            this.ijp.setData(arrayList);
            this.ijv = arrayList;
        }
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.h> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.ijt.setCountDownCallback(aVar);
        this.ijt.a(this.iiN, this.gpD, j);
    }

    public ArrayList<com.baidu.tieba.ala.data.h> bHz() {
        return this.ijv;
    }

    public void c(p pVar) {
        this.ijt.b(pVar);
    }

    public void wE(int i) {
        if (this.ijt != null) {
            this.ijt.setHourHeaderInfoVisible(i);
        }
    }

    public void fv(int i) {
        if (this.cdZ != null) {
            this.cdZ.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.ijt != null) {
            this.ijt.setRankListCallback(bVar);
        }
    }

    public void wF(int i) {
        this.ijo.setVisibility(i);
    }

    public r cpz() {
        return this.iju;
    }

    public void c(final r rVar) {
        if (rVar == null) {
            if (this.ijq != null) {
                this.ijq.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!rVar.isValid()) {
            rVar.userName = this.mUserName;
            rVar.bdPortrait = this.mPortrait;
        }
        this.iju = rVar;
        View view = null;
        if (this.ijq != null) {
            this.ijq.b(rVar);
            this.ijq.getView().setVisibility(0);
            view = this.ijq.getView();
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
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(g.this.mContext, rVar.userId + "", rVar.userName, rVar.bdPortrait, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, rVar.getNameShow());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void cpA() {
        if (this.ijq != null) {
            this.ijq.getView().setVisibility(8);
        }
        if (this.ijr != null) {
            this.ijr.getView().setVisibility(8);
        }
        if (this.ijs != null) {
            this.ijs.getView().setVisibility(8);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        this.bwJ.reset();
        this.bwJ.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bwJ.setRefreshButton(a.h.sdk_click_refresh_net_text, onClickListener);
        this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bwJ.setVisibility(0);
    }

    public void WZ() {
        this.bwJ.setVisibility(8);
    }

    public void dQ(boolean z) {
        if (z) {
            this.bwJ.reset();
            this.bwJ.setTitle(a.h.rank_empty_text);
            this.bwJ.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.bwJ.setVisibility(0);
            return;
        }
        this.bwJ.setVisibility(8);
    }

    public void release() {
        if (this.ijt != null) {
            this.ijt.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
