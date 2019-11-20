package com.baidu.tieba.ala.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class d {
    private int Pw;
    private CommonEmptyView dEF;
    private a dHI;
    private long dtM;
    private String dtO;
    private boolean dtP;
    private BdListView eDD;
    private com.baidu.tieba.ala.adapter.b eDE;
    private LinearLayout eDF;
    private com.baidu.tieba.ala.view.a eDG;
    private c eDH;
    private b eDI;
    private AlaRankListHeaderView eDJ;
    private LinearLayout eDK;
    private com.baidu.tieba.ala.data.f eDL;
    private ArrayList<com.baidu.tieba.ala.data.c> eDM;
    private TbPageContext<BaseFragmentActivity> eDc;
    private Context mContext;
    private String mPortrait;
    private View mRootView;
    private long mUserId;
    private String mUserName;

    /* loaded from: classes6.dex */
    public interface a {
        void f(View view, String str);
    }

    public d(TbPageContext<BaseFragmentActivity> tbPageContext, String str, int i, a aVar, boolean z, long j, String str2, String str3, long j2) {
        this.eDc = tbPageContext;
        this.mContext = this.eDc.getPageActivity();
        this.dHI = aVar;
        this.dtP = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.Pw = i;
        this.mPortrait = str3;
        this.dtM = j2;
        up(str);
    }

    private void up(String str) {
        this.dtO = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.eDD = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.eDE = new com.baidu.tieba.ala.adapter.b(this.mContext, str, this.dtM, this.dtP);
        this.eDD.setAdapter((ListAdapter) this.eDE);
        this.eDJ = new AlaRankListHeaderView(this.eDc.getPageActivity(), this.dtM, this.dtP);
        this.eDJ.a(this.eDc, str, 0L);
        this.eDD.addHeaderView(this.eDJ);
        if (TextUtils.equals("hour", this.dtO) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eDK = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.eDD.addFooterView(this.eDK);
            this.eDK.setVisibility(0);
        } else if (this.eDK != null) {
            this.eDK.setVisibility(8);
        }
        this.eDF = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.eDG = new com.baidu.tieba.ala.view.a(this.mContext, str, this.dtP);
            this.eDG.a(this.dHI);
            this.eDF.addView(this.eDG.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.eDH = new c(this.mContext, str, this.dtP, this.mUserId, this.Pw, this.mPortrait);
            this.eDF.addView(this.eDH.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.eDI = new b(this.mContext, str, this.dtP, this.mPortrait);
            this.eDF.addView(this.eDI.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if (!"challenge_history".equals(str)) {
            this.eDG = new com.baidu.tieba.ala.view.a(this.mContext, str, this.dtP);
            this.eDG.a(this.dHI);
            this.eDF.addView(this.eDG.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.dEF = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.eDD.setEmptyView(this.dEF);
    }

    public void pC() {
        if (this.eDG != null) {
            this.eDG.pC();
        }
    }

    public void setDatas(ArrayList<com.baidu.tieba.ala.data.c> arrayList) {
        if (this.eDE != null) {
            this.eDE.setData(arrayList);
            this.eDM = arrayList;
        }
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.c> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.eDJ.setCountDownCallback(aVar);
        this.eDJ.a(this.eDc, this.dtO, j);
    }

    public ArrayList<com.baidu.tieba.ala.data.c> azf() {
        return this.eDM;
    }

    public void c(com.baidu.tieba.ala.data.e eVar) {
        this.eDJ.b(eVar);
    }

    public void or(int i) {
        if (this.eDJ != null) {
            this.eDJ.setHourHeaderInfoVisible(i);
        }
    }

    public void os(int i) {
        if (this.eDK != null) {
            this.eDK.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.eDJ != null) {
            this.eDJ.setRankListCallback(bVar);
        }
    }

    public void ot(int i) {
        this.eDD.setVisibility(i);
    }

    public com.baidu.tieba.ala.data.f aYU() {
        return this.eDL;
    }

    public void c(final com.baidu.tieba.ala.data.f fVar) {
        if (fVar == null) {
            if (this.eDG != null) {
                this.eDG.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!fVar.isValid()) {
            fVar.userName = this.mUserName;
            fVar.dGF = this.mPortrait;
        }
        this.eDL = fVar;
        View view = null;
        if (this.eDG != null) {
            this.eDG.b(fVar);
            this.eDG.getView().setVisibility(0);
            view = this.eDG.getView();
        }
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (fVar != null && (d.this.mContext instanceof Activity)) {
                        Intent intent = ((Activity) d.this.mContext).getIntent();
                        long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                        String stringExtra = intent.getStringExtra("group_id");
                        String stringExtra2 = intent.getStringExtra("live_id");
                        boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                        String stringExtra3 = intent.getStringExtra("live_owner_uid");
                        if (longExtra == fVar.userId) {
                            stringExtra3 = longExtra + "";
                        }
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mContext, fVar.userId + "", fVar.userName, fVar.dGF, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, fVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void aYV() {
        if (this.eDG != null) {
            this.eDG.getView().setVisibility(8);
        }
        if (this.eDH != null) {
            this.eDH.getView().setVisibility(8);
        }
        if (this.eDI != null) {
            this.eDI.getView().setVisibility(8);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.dEF.reset();
        this.dEF.setTitle(a.i.sdk_net_fail_tip_rank);
        this.dEF.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.dEF.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.dEF.setVisibility(0);
    }

    public void aJm() {
        this.dEF.setVisibility(8);
    }

    public void gN(boolean z) {
        if (z) {
            this.dEF.reset();
            this.dEF.setTitle(a.i.sdk_net_fail_tip_rank);
            this.dEF.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.dEF.setVisibility(0);
            return;
        }
        this.dEF.setVisibility(8);
    }

    public void release() {
        if (this.eDJ != null) {
            this.eDJ.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
