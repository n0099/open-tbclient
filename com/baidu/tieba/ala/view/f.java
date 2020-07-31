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
/* loaded from: classes4.dex */
public class f {
    private int azs;
    private LinearLayout baL;
    private CommonEmptyView baQ;
    private a fKU;
    private long fkg;
    private String fki;
    private boolean fkj;
    private AlaLastLiveroomInfo flX = new AlaLastLiveroomInfo();
    private BdListView gNT;
    private com.baidu.tieba.ala.adapter.c gNU;
    private c gNV;
    private e gNW;
    private d gNX;
    private AlaRankListHeaderView gNY;
    private LinearLayout gNZ;
    private TbPageContext<BaseFragmentActivity> gNs;
    private o gOa;
    private ArrayList<com.baidu.tieba.ala.data.h> gOb;
    private Context mContext;
    private String mPortrait;
    private View mRootView;
    private long mUserId;
    private String mUserName;

    /* loaded from: classes4.dex */
    public interface a {
        void g(View view, String str);
    }

    public f(TbPageContext<BaseFragmentActivity> tbPageContext, String str, int i, a aVar, boolean z, long j, String str2, String str3, long j2) {
        this.gNs = tbPageContext;
        this.mContext = this.gNs.getPageActivity();
        this.fKU = aVar;
        this.fkj = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.azs = i;
        this.mPortrait = str3;
        this.fkg = j2;
        this.flX.setLastAnchorPortrait(str3);
        this.flX.setLastAnchorUname(str2);
        this.flX.setLastAnchorUid(String.valueOf(j));
        this.flX.setLastLiveId(this.fkg);
        this.flX.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
        Eq(str);
    }

    private void Eq(String str) {
        this.fki = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.gNT = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.gNU = new com.baidu.tieba.ala.adapter.c(this.mContext, str, this.fkg, this.fkj, this.flX);
        this.gNT.setAdapter((ListAdapter) this.gNU);
        this.gNY = new AlaRankListHeaderView(this.gNs.getPageActivity(), this.fkg, this.fkj, this.flX);
        this.gNY.a(this.gNs, str, 0L);
        this.gNT.addHeaderView(this.gNY);
        if (TextUtils.equals("hour", this.fki) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gNZ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.gNT.addFooterView(this.gNZ);
            this.gNZ.setVisibility(0);
        } else if (this.gNZ != null) {
            this.gNZ.setVisibility(8);
        }
        this.baL = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.gNV = new c(this.mContext, str, this.fkj);
            this.gNV.a(this.fKU);
            this.baL.addView(this.gNV.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.gNW = new e(this.mContext, str, this.fkj, this.mUserId, this.azs, this.mPortrait);
            this.baL.addView(this.gNW.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.gNX = new d(this.mContext, str, this.fkj, this.mPortrait);
            this.baL.addView(this.gNX.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.gNV = new c(this.mContext, str, this.fkj);
            this.gNV.a(this.fKU);
            this.baL.addView(this.gNV.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.baQ = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.gNT.setEmptyView(this.baQ);
    }

    public void zc() {
        if (this.gNV != null) {
            this.gNV.zc();
        }
    }

    public void setDatas(ArrayList<com.baidu.tieba.ala.data.h> arrayList) {
        if (this.gNU != null) {
            this.gNU.setData(arrayList);
            this.gOb = arrayList;
        }
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.h> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.gNY.setCountDownCallback(aVar);
        this.gNY.a(this.gNs, this.fki, j);
    }

    public ArrayList<com.baidu.tieba.ala.data.h> boJ() {
        return this.gOb;
    }

    public void c(n nVar) {
        this.gNY.b(nVar);
    }

    public void sO(int i) {
        if (this.gNY != null) {
            this.gNY.setHourHeaderInfoVisible(i);
        }
    }

    public void sP(int i) {
        if (this.gNZ != null) {
            this.gNZ.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.gNY != null) {
            this.gNY.setRankListCallback(bVar);
        }
    }

    public void sQ(int i) {
        this.gNT.setVisibility(i);
    }

    public o bQd() {
        return this.gOa;
    }

    public void c(final o oVar) {
        if (oVar == null) {
            if (this.gNV != null) {
                this.gNV.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!oVar.isValid()) {
            oVar.userName = this.mUserName;
            oVar.fJN = this.mPortrait;
        }
        this.gOa = oVar;
        View view = null;
        if (this.gNV != null) {
            this.gNV.b(oVar);
            this.gNV.getView().setVisibility(0);
            view = this.gNV.getView();
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
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(f.this.mContext, oVar.userId + "", oVar.userName, oVar.fJN, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, oVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void bQe() {
        if (this.gNV != null) {
            this.gNV.getView().setVisibility(8);
        }
        if (this.gNW != null) {
            this.gNW.getView().setVisibility(8);
        }
        if (this.gNX != null) {
            this.gNX.getView().setVisibility(8);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.baQ.reset();
        this.baQ.setTitle(a.i.sdk_net_fail_tip_rank);
        this.baQ.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.baQ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.baQ.setVisibility(0);
    }

    public void bwX() {
        this.baQ.setVisibility(8);
    }

    public void kw(boolean z) {
        if (z) {
            this.baQ.reset();
            this.baQ.setTitle(a.i.rank_empty_text);
            this.baQ.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.baQ.setVisibility(0);
            return;
        }
        this.baQ.setVisibility(8);
    }

    public void release() {
        if (this.gNY != null) {
            this.gNY.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
