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
    private int aKw;
    private LinearLayout bUt;
    private LinearLayout bpE;
    private CommonEmptyView bpJ;
    private long fZh;
    private String fZj;
    private boolean fZk;
    private a gCu;
    private AlaLastLiveroomInfo gaY = new AlaLastLiveroomInfo();
    private BdListView hLY;
    private com.baidu.tieba.ala.adapter.c hLZ;
    private TbPageContext<BaseFragmentActivity> hLx;
    private d hMa;
    private f hMb;
    private e hMc;
    private AlaRankListHeaderView hMd;
    private r hMe;
    private ArrayList<com.baidu.tieba.ala.data.h> hMf;
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
        this.hLx = tbPageContext;
        this.mContext = this.hLx.getPageActivity();
        this.gCu = aVar;
        this.fZk = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.aKw = i;
        this.mPortrait = str3;
        this.fZh = j2;
        this.gaY.setLastAnchorPortrait(str3);
        this.gaY.setLastAnchorUname(str2);
        this.gaY.setLastAnchorUid(String.valueOf(j));
        this.gaY.setLastLiveId(this.fZh);
        this.gaY.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
        IO(str);
    }

    private void IO(String str) {
        this.fZj = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_fragment_layout, (ViewGroup) null);
        this.hLY = (BdListView) this.mRootView.findViewById(a.f.ala_rank_list_view);
        this.hLZ = new com.baidu.tieba.ala.adapter.c(this.mContext, str, this.fZh, this.fZk, this.gaY);
        this.hLY.setAdapter((ListAdapter) this.hLZ);
        this.hMd = new AlaRankListHeaderView(this.hLx.getPageActivity(), this.fZh, this.fZk, this.gaY);
        this.hMd.a(this.hLx, str, 0L);
        this.hLY.addHeaderView(this.hMd);
        if (TextUtils.equals("hour", this.fZj) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.bUt = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.hour_rank_list_footer_view, (ViewGroup) null);
            this.hLY.addFooterView(this.bUt);
            this.bUt.setVisibility(0);
        } else if (this.bUt != null) {
            this.bUt.setVisibility(8);
        }
        this.bpE = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.hMa = new d(this.mContext, str, this.fZk);
            this.hMa.a(this.gCu);
            this.bpE.addView(this.hMa.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.hMb = new f(this.mContext, str, this.fZk, this.mUserId, this.aKw, this.mPortrait);
            this.bpE.addView(this.hMb.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.hMc = new e(this.mContext, str, this.fZk, this.mPortrait);
            this.bpE.addView(this.hMc.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.hMa = new d(this.mContext, str, this.fZk);
            this.hMa.a(this.gCu);
            this.bpE.addView(this.hMa.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.bpJ = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_rank_list_empty);
        this.hLY.setEmptyView(this.bpJ);
    }

    public void GI() {
        if (this.hMa != null) {
            this.hMa.GI();
        }
    }

    public void setDatas(ArrayList<com.baidu.tieba.ala.data.h> arrayList) {
        if (this.hLZ != null) {
            this.hLZ.setData(arrayList);
            this.hMf = arrayList;
        }
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.h> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.hMd.setCountDownCallback(aVar);
        this.hMd.a(this.hLx, this.fZj, j);
    }

    public ArrayList<com.baidu.tieba.ala.data.h> bFI() {
        return this.hMf;
    }

    public void c(p pVar) {
        this.hMd.b(pVar);
    }

    public void wI(int i) {
        if (this.hMd != null) {
            this.hMd.setHourHeaderInfoVisible(i);
        }
    }

    public void gB(int i) {
        if (this.bUt != null) {
            this.bUt.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.hMd != null) {
            this.hMd.setRankListCallback(bVar);
        }
    }

    public void wJ(int i) {
        this.hLY.setVisibility(i);
    }

    public r clJ() {
        return this.hMe;
    }

    public void c(final r rVar) {
        if (rVar == null) {
            if (this.hMa != null) {
                this.hMa.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!rVar.isValid()) {
            rVar.userName = this.mUserName;
            rVar.bdPortrait = this.mPortrait;
        }
        this.hMe = rVar;
        View view = null;
        if (this.hMa != null) {
            this.hMa.b(rVar);
            this.hMa.getView().setVisibility(0);
            view = this.hMa.getView();
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

    public void clK() {
        if (this.hMa != null) {
            this.hMa.getView().setVisibility(8);
        }
        if (this.hMb != null) {
            this.hMb.getView().setVisibility(8);
        }
        if (this.hMc != null) {
            this.hMc.getView().setVisibility(8);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        this.bpJ.reset();
        this.bpJ.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bpJ.setRefreshButton(a.h.sdk_click_refresh_net_text, onClickListener);
        this.bpJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bpJ.setVisibility(0);
    }

    public void Wk() {
        this.bpJ.setVisibility(8);
    }

    public void dq(boolean z) {
        if (z) {
            this.bpJ.reset();
            this.bpJ.setTitle(a.h.rank_empty_text);
            this.bpJ.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.bpJ.setVisibility(0);
            return;
        }
        this.bpJ.setVisibility(8);
    }

    public void release() {
        if (this.hMd != null) {
            this.hMd.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
