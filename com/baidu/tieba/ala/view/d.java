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
    private int Qc;
    private CommonEmptyView dFw;
    private a dIz;
    private long duD;
    private String duF;
    private boolean duG;
    private TbPageContext<BaseFragmentActivity> eDT;
    private AlaRankListHeaderView eEA;
    private LinearLayout eEB;
    private com.baidu.tieba.ala.data.f eEC;
    private ArrayList<com.baidu.tieba.ala.data.c> eED;
    private BdListView eEu;
    private com.baidu.tieba.ala.adapter.b eEv;
    private LinearLayout eEw;
    private com.baidu.tieba.ala.view.a eEx;
    private c eEy;
    private b eEz;
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
        this.eDT = tbPageContext;
        this.mContext = this.eDT.getPageActivity();
        this.dIz = aVar;
        this.duG = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.Qc = i;
        this.mPortrait = str3;
        this.duD = j2;
        up(str);
    }

    private void up(String str) {
        this.duF = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.eEu = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.eEv = new com.baidu.tieba.ala.adapter.b(this.mContext, str, this.duD, this.duG);
        this.eEu.setAdapter((ListAdapter) this.eEv);
        this.eEA = new AlaRankListHeaderView(this.eDT.getPageActivity(), this.duD, this.duG);
        this.eEA.a(this.eDT, str, 0L);
        this.eEu.addHeaderView(this.eEA);
        if (TextUtils.equals("hour", this.duF) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eEB = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.eEu.addFooterView(this.eEB);
            this.eEB.setVisibility(0);
        } else if (this.eEB != null) {
            this.eEB.setVisibility(8);
        }
        this.eEw = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.eEx = new com.baidu.tieba.ala.view.a(this.mContext, str, this.duG);
            this.eEx.a(this.dIz);
            this.eEw.addView(this.eEx.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.eEy = new c(this.mContext, str, this.duG, this.mUserId, this.Qc, this.mPortrait);
            this.eEw.addView(this.eEy.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.eEz = new b(this.mContext, str, this.duG, this.mPortrait);
            this.eEw.addView(this.eEz.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if (!"challenge_history".equals(str)) {
            this.eEx = new com.baidu.tieba.ala.view.a(this.mContext, str, this.duG);
            this.eEx.a(this.dIz);
            this.eEw.addView(this.eEx.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.dFw = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.eEu.setEmptyView(this.dFw);
    }

    public void pC() {
        if (this.eEx != null) {
            this.eEx.pC();
        }
    }

    public void setDatas(ArrayList<com.baidu.tieba.ala.data.c> arrayList) {
        if (this.eEv != null) {
            this.eEv.setData(arrayList);
            this.eED = arrayList;
        }
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.c> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.eEA.setCountDownCallback(aVar);
        this.eEA.a(this.eDT, this.duF, j);
    }

    public ArrayList<com.baidu.tieba.ala.data.c> azh() {
        return this.eED;
    }

    public void c(com.baidu.tieba.ala.data.e eVar) {
        this.eEA.b(eVar);
    }

    public void os(int i) {
        if (this.eEA != null) {
            this.eEA.setHourHeaderInfoVisible(i);
        }
    }

    public void ot(int i) {
        if (this.eEB != null) {
            this.eEB.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.eEA != null) {
            this.eEA.setRankListCallback(bVar);
        }
    }

    public void ou(int i) {
        this.eEu.setVisibility(i);
    }

    public com.baidu.tieba.ala.data.f aYW() {
        return this.eEC;
    }

    public void c(final com.baidu.tieba.ala.data.f fVar) {
        if (fVar == null) {
            if (this.eEx != null) {
                this.eEx.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!fVar.isValid()) {
            fVar.userName = this.mUserName;
            fVar.dHw = this.mPortrait;
        }
        this.eEC = fVar;
        View view = null;
        if (this.eEx != null) {
            this.eEx.b(fVar);
            this.eEx.getView().setVisibility(0);
            view = this.eEx.getView();
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
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mContext, fVar.userId + "", fVar.userName, fVar.dHw, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, fVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void aYX() {
        if (this.eEx != null) {
            this.eEx.getView().setVisibility(8);
        }
        if (this.eEy != null) {
            this.eEy.getView().setVisibility(8);
        }
        if (this.eEz != null) {
            this.eEz.getView().setVisibility(8);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.dFw.reset();
        this.dFw.setTitle(a.i.sdk_net_fail_tip_rank);
        this.dFw.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.dFw.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.dFw.setVisibility(0);
    }

    public void aJo() {
        this.dFw.setVisibility(8);
    }

    public void gN(boolean z) {
        if (z) {
            this.dFw.reset();
            this.dFw.setTitle(a.i.sdk_net_fail_tip_rank);
            this.dFw.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.dFw.setVisibility(0);
            return;
        }
        this.dFw.setVisibility(8);
    }

    public void release() {
        if (this.eEA != null) {
            this.eEA.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
