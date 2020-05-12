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
    private int aqX;
    private long eIi;
    private String eIk;
    private boolean eIl;
    private CommonEmptyView faG;
    private a fgx;
    private TbPageContext<BaseFragmentActivity> gfU;
    private b ggA;
    private AlaRankListHeaderView ggB;
    private LinearLayout ggC;
    private n ggD;
    private ArrayList<g> ggE;
    private BdListView ggv;
    private com.baidu.tieba.ala.adapter.b ggw;
    private LinearLayout ggx;
    private com.baidu.tieba.ala.view.a ggy;
    private c ggz;
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
        this.gfU = tbPageContext;
        this.mContext = this.gfU.getPageActivity();
        this.fgx = aVar;
        this.eIl = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.aqX = i;
        this.mPortrait = str3;
        this.eIi = j2;
        Bv(str);
    }

    private void Bv(String str) {
        this.eIk = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.ggv = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.ggw = new com.baidu.tieba.ala.adapter.b(this.mContext, str, this.eIi, this.eIl);
        this.ggv.setAdapter((ListAdapter) this.ggw);
        this.ggB = new AlaRankListHeaderView(this.gfU.getPageActivity(), this.eIi, this.eIl);
        this.ggB.a(this.gfU, str, 0L);
        this.ggv.addHeaderView(this.ggB);
        if (TextUtils.equals("hour", this.eIk) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ggC = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.ggv.addFooterView(this.ggC);
            this.ggC.setVisibility(0);
        } else if (this.ggC != null) {
            this.ggC.setVisibility(8);
        }
        this.ggx = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.ggy = new com.baidu.tieba.ala.view.a(this.mContext, str, this.eIl);
            this.ggy.a(this.fgx);
            this.ggx.addView(this.ggy.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.ggz = new c(this.mContext, str, this.eIl, this.mUserId, this.aqX, this.mPortrait);
            this.ggx.addView(this.ggz.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.ggA = new b(this.mContext, str, this.eIl, this.mPortrait);
            this.ggx.addView(this.ggA.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.ggy = new com.baidu.tieba.ala.view.a(this.mContext, str, this.eIl);
            this.ggy.a(this.fgx);
            this.ggx.addView(this.ggy.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.faG = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.ggv.setEmptyView(this.faG);
    }

    public void wJ() {
        if (this.ggy != null) {
            this.ggy.wJ();
        }
    }

    public void setDatas(ArrayList<g> arrayList) {
        if (this.ggw != null) {
            this.ggw.setData(arrayList);
            this.ggE = arrayList;
        }
    }

    public void a(ArrayList<g> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.ggB.setCountDownCallback(aVar);
        this.ggB.a(this.gfU, this.eIk, j);
    }

    public ArrayList<g> bcf() {
        return this.ggE;
    }

    public void c(m mVar) {
        this.ggB.b(mVar);
    }

    public void rs(int i) {
        if (this.ggB != null) {
            this.ggB.setHourHeaderInfoVisible(i);
        }
    }

    public void rt(int i) {
        if (this.ggC != null) {
            this.ggC.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.ggB != null) {
            this.ggB.setRankListCallback(bVar);
        }
    }

    public void ru(int i) {
        this.ggv.setVisibility(i);
    }

    public n bDt() {
        return this.ggD;
    }

    public void c(final n nVar) {
        if (nVar == null) {
            if (this.ggy != null) {
                this.ggy.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!nVar.isValid()) {
            nVar.userName = this.mUserName;
            nVar.ffr = this.mPortrait;
        }
        this.ggD = nVar;
        View view = null;
        if (this.ggy != null) {
            this.ggy.b(nVar);
            this.ggy.getView().setVisibility(0);
            view = this.ggy.getView();
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
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mContext, nVar.userId + "", nVar.userName, nVar.ffr, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, nVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void bDu() {
        if (this.ggy != null) {
            this.ggy.getView().setVisibility(8);
        }
        if (this.ggz != null) {
            this.ggz.getView().setVisibility(8);
        }
        if (this.ggA != null) {
            this.ggA.getView().setVisibility(8);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.faG.reset();
        this.faG.setTitle(a.i.sdk_net_fail_tip_rank);
        this.faG.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.faG.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.faG.setVisibility(0);
    }

    public void blr() {
        this.faG.setVisibility(8);
    }

    public void jm(boolean z) {
        if (z) {
            this.faG.reset();
            this.faG.setTitle(a.i.rank_empty_text);
            this.faG.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.faG.setVisibility(0);
            return;
        }
        this.faG.setVisibility(8);
    }

    public void release() {
        if (this.ggB != null) {
            this.ggB.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
