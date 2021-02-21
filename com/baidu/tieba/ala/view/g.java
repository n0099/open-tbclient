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
    private a gVe;
    private long gpP;
    private String gpR;
    private boolean gpS;
    private AlaLastLiveroomInfo grF = new AlaLastLiveroomInfo();
    private BdListView ijC;
    private com.baidu.tieba.ala.adapter.c ijD;
    private d ijE;
    private f ijF;
    private e ijG;
    private AlaRankListHeaderView ijH;
    private r ijI;
    private ArrayList<com.baidu.tieba.ala.data.h> ijJ;
    private TbPageContext<BaseFragmentActivity> ijb;
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
        this.ijb = tbPageContext;
        this.mContext = this.ijb.getPageActivity();
        this.gVe = aVar;
        this.gpS = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.aKa = i;
        this.mPortrait = str3;
        this.gpP = j2;
        this.grF.setLastAnchorPortrait(str3);
        this.grF.setLastAnchorUname(str2);
        this.grF.setLastAnchorUid(String.valueOf(j));
        this.grF.setLastLiveId(this.gpP);
        this.grF.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
        Iz(str);
    }

    private void Iz(String str) {
        this.gpR = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_fragment_layout, (ViewGroup) null);
        this.ijC = (BdListView) this.mRootView.findViewById(a.f.ala_rank_list_view);
        this.ijD = new com.baidu.tieba.ala.adapter.c(this.mContext, str, this.gpP, this.gpS, this.grF);
        this.ijC.setAdapter((ListAdapter) this.ijD);
        this.ijH = new AlaRankListHeaderView(this.ijb.getPageActivity(), this.gpP, this.gpS, this.grF);
        this.ijH.a(this.ijb, str, 0L);
        this.ijC.addHeaderView(this.ijH);
        if (TextUtils.equals("hour", this.gpR) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.cdZ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.hour_rank_list_footer_view, (ViewGroup) null);
            this.ijC.addFooterView(this.cdZ);
            this.cdZ.setVisibility(0);
        } else if (this.cdZ != null) {
            this.cdZ.setVisibility(8);
        }
        this.bwE = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.ijE = new d(this.mContext, str, this.gpS);
            this.ijE.a(this.gVe);
            this.bwE.addView(this.ijE.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.ijF = new f(this.mContext, str, this.gpS, this.mUserId, this.aKa, this.mPortrait);
            this.bwE.addView(this.ijF.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.ijG = new e(this.mContext, str, this.gpS, this.mPortrait);
            this.bwE.addView(this.ijG.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.ijE = new d(this.mContext, str, this.gpS);
            this.ijE.a(this.gVe);
            this.bwE.addView(this.ijE.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.bwJ = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_rank_list_empty);
        this.ijC.setEmptyView(this.bwJ);
    }

    public void EK() {
        if (this.ijE != null) {
            this.ijE.EK();
        }
    }

    public void setDatas(ArrayList<com.baidu.tieba.ala.data.h> arrayList) {
        if (this.ijD != null) {
            this.ijD.setData(arrayList);
            this.ijJ = arrayList;
        }
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.h> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.ijH.setCountDownCallback(aVar);
        this.ijH.a(this.ijb, this.gpR, j);
    }

    public ArrayList<com.baidu.tieba.ala.data.h> bHz() {
        return this.ijJ;
    }

    public void c(p pVar) {
        this.ijH.b(pVar);
    }

    public void wE(int i) {
        if (this.ijH != null) {
            this.ijH.setHourHeaderInfoVisible(i);
        }
    }

    public void fv(int i) {
        if (this.cdZ != null) {
            this.cdZ.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.ijH != null) {
            this.ijH.setRankListCallback(bVar);
        }
    }

    public void wF(int i) {
        this.ijC.setVisibility(i);
    }

    public r cpG() {
        return this.ijI;
    }

    public void c(final r rVar) {
        if (rVar == null) {
            if (this.ijE != null) {
                this.ijE.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!rVar.isValid()) {
            rVar.userName = this.mUserName;
            rVar.bdPortrait = this.mPortrait;
        }
        this.ijI = rVar;
        View view = null;
        if (this.ijE != null) {
            this.ijE.b(rVar);
            this.ijE.getView().setVisibility(0);
            view = this.ijE.getView();
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

    public void cpH() {
        if (this.ijE != null) {
            this.ijE.getView().setVisibility(8);
        }
        if (this.ijF != null) {
            this.ijF.getView().setVisibility(8);
        }
        if (this.ijG != null) {
            this.ijG.getView().setVisibility(8);
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
        if (this.ijH != null) {
            this.ijH.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
