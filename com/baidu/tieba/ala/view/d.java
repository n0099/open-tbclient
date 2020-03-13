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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {
    private int Yx;
    private a eBD;
    private long ehY;
    private String eia;
    private boolean eib;
    private CommonEmptyView ewe;
    private TbPageContext<BaseFragmentActivity> fAF;
    private BdListView fBg;
    private com.baidu.tieba.ala.adapter.b fBh;
    private LinearLayout fBi;
    private com.baidu.tieba.ala.view.a fBj;
    private c fBk;
    private b fBl;
    private AlaRankListHeaderView fBm;
    private LinearLayout fBn;
    private n fBo;
    private ArrayList<g> fBp;
    private Context mContext;
    private String mPortrait;
    private View mRootView;
    private long mUserId;
    private String mUserName;

    /* loaded from: classes3.dex */
    public interface a {
        void f(View view, String str);
    }

    public d(TbPageContext<BaseFragmentActivity> tbPageContext, String str, int i, a aVar, boolean z, long j, String str2, String str3, long j2) {
        this.fAF = tbPageContext;
        this.mContext = this.fAF.getPageActivity();
        this.eBD = aVar;
        this.eib = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.Yx = i;
        this.mPortrait = str3;
        this.ehY = j2;
        zK(str);
    }

    private void zK(String str) {
        this.eia = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.fBg = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.fBh = new com.baidu.tieba.ala.adapter.b(this.mContext, str, this.ehY, this.eib);
        this.fBg.setAdapter((ListAdapter) this.fBh);
        this.fBm = new AlaRankListHeaderView(this.fAF.getPageActivity(), this.ehY, this.eib);
        this.fBm.a(this.fAF, str, 0L);
        this.fBg.addHeaderView(this.fBm);
        if (TextUtils.equals("hour", this.eia) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fBn = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.fBg.addFooterView(this.fBn);
            this.fBn.setVisibility(0);
        } else if (this.fBn != null) {
            this.fBn.setVisibility(8);
        }
        this.fBi = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.fBj = new com.baidu.tieba.ala.view.a(this.mContext, str, this.eib);
            this.fBj.a(this.eBD);
            this.fBi.addView(this.fBj.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.fBk = new c(this.mContext, str, this.eib, this.mUserId, this.Yx, this.mPortrait);
            this.fBi.addView(this.fBk.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.fBl = new b(this.mContext, str, this.eib, this.mPortrait);
            this.fBi.addView(this.fBl.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.fBj = new com.baidu.tieba.ala.view.a(this.mContext, str, this.eib);
            this.fBj.a(this.eBD);
            this.fBi.addView(this.fBj.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.ewe = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.fBg.setEmptyView(this.ewe);
    }

    public void sm() {
        if (this.fBj != null) {
            this.fBj.sm();
        }
    }

    public void setDatas(ArrayList<g> arrayList) {
        if (this.fBh != null) {
            this.fBh.setData(arrayList);
            this.fBp = arrayList;
        }
    }

    public void a(ArrayList<g> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.fBm.setCountDownCallback(aVar);
        this.fBm.a(this.fAF, this.eia, j);
    }

    public ArrayList<g> aTT() {
        return this.fBp;
    }

    public void c(m mVar) {
        this.fBm.b(mVar);
    }

    public void qX(int i) {
        if (this.fBm != null) {
            this.fBm.setHourHeaderInfoVisible(i);
        }
    }

    public void qY(int i) {
        if (this.fBn != null) {
            this.fBn.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.fBm != null) {
            this.fBm.setRankListCallback(bVar);
        }
    }

    public void qZ(int i) {
        this.fBg.setVisibility(i);
    }

    public n btE() {
        return this.fBo;
    }

    public void c(final n nVar) {
        if (nVar == null) {
            if (this.fBj != null) {
                this.fBj.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!nVar.isValid()) {
            nVar.userName = this.mUserName;
            nVar.eAx = this.mPortrait;
        }
        this.fBo = nVar;
        View view = null;
        if (this.fBj != null) {
            this.fBj.b(nVar);
            this.fBj.getView().setVisibility(0);
            view = this.fBj.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (nVar != null && (d.this.mContext instanceof Activity)) {
                        Intent intent = ((Activity) d.this.mContext).getIntent();
                        long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                        String stringExtra = intent.getStringExtra("group_id");
                        String stringExtra2 = intent.getStringExtra("live_id");
                        boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                        String stringExtra3 = intent.getStringExtra("live_owner_uid");
                        if (longExtra == nVar.userId) {
                            stringExtra3 = longExtra + "";
                        }
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mContext, nVar.userId + "", nVar.userName, nVar.eAx, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, nVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void btF() {
        if (this.fBj != null) {
            this.fBj.getView().setVisibility(8);
        }
        if (this.fBk != null) {
            this.fBk.getView().setVisibility(8);
        }
        if (this.fBl != null) {
            this.fBl.getView().setVisibility(8);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.ewe.reset();
        this.ewe.setTitle(a.i.sdk_net_fail_tip_rank);
        this.ewe.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.ewe.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.ewe.setVisibility(0);
    }

    public void bcy() {
        this.ewe.setVisibility(8);
    }

    public void ij(boolean z) {
        if (z) {
            this.ewe.reset();
            this.ewe.setTitle(a.i.rank_empty_text);
            this.ewe.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.ewe.setVisibility(0);
            return;
        }
        this.ewe.setVisibility(8);
    }

    public void release() {
        if (this.fBm != null) {
            this.fBm.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
