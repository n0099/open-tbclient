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
    private int aqR;
    private long eId;
    private String eIf;
    private boolean eIg;
    private CommonEmptyView faB;
    private a fgs;
    private TbPageContext<BaseFragmentActivity> gfO;
    private BdListView ggp;
    private com.baidu.tieba.ala.adapter.b ggq;
    private LinearLayout ggr;
    private com.baidu.tieba.ala.view.a ggs;
    private c ggt;
    private b ggu;
    private AlaRankListHeaderView ggv;
    private LinearLayout ggw;
    private n ggx;
    private ArrayList<g> ggy;
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
        this.gfO = tbPageContext;
        this.mContext = this.gfO.getPageActivity();
        this.fgs = aVar;
        this.eIg = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.aqR = i;
        this.mPortrait = str3;
        this.eId = j2;
        Bs(str);
    }

    private void Bs(String str) {
        this.eIf = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.ggp = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.ggq = new com.baidu.tieba.ala.adapter.b(this.mContext, str, this.eId, this.eIg);
        this.ggp.setAdapter((ListAdapter) this.ggq);
        this.ggv = new AlaRankListHeaderView(this.gfO.getPageActivity(), this.eId, this.eIg);
        this.ggv.a(this.gfO, str, 0L);
        this.ggp.addHeaderView(this.ggv);
        if (TextUtils.equals("hour", this.eIf) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ggw = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.ggp.addFooterView(this.ggw);
            this.ggw.setVisibility(0);
        } else if (this.ggw != null) {
            this.ggw.setVisibility(8);
        }
        this.ggr = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.ggs = new com.baidu.tieba.ala.view.a(this.mContext, str, this.eIg);
            this.ggs.a(this.fgs);
            this.ggr.addView(this.ggs.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.ggt = new c(this.mContext, str, this.eIg, this.mUserId, this.aqR, this.mPortrait);
            this.ggr.addView(this.ggt.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.ggu = new b(this.mContext, str, this.eIg, this.mPortrait);
            this.ggr.addView(this.ggu.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.ggs = new com.baidu.tieba.ala.view.a(this.mContext, str, this.eIg);
            this.ggs.a(this.fgs);
            this.ggr.addView(this.ggs.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.faB = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.ggp.setEmptyView(this.faB);
    }

    public void wK() {
        if (this.ggs != null) {
            this.ggs.wK();
        }
    }

    public void setDatas(ArrayList<g> arrayList) {
        if (this.ggq != null) {
            this.ggq.setData(arrayList);
            this.ggy = arrayList;
        }
    }

    public void a(ArrayList<g> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.ggv.setCountDownCallback(aVar);
        this.ggv.a(this.gfO, this.eIf, j);
    }

    public ArrayList<g> bch() {
        return this.ggy;
    }

    public void c(m mVar) {
        this.ggv.b(mVar);
    }

    public void rs(int i) {
        if (this.ggv != null) {
            this.ggv.setHourHeaderInfoVisible(i);
        }
    }

    public void rt(int i) {
        if (this.ggw != null) {
            this.ggw.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.ggv != null) {
            this.ggv.setRankListCallback(bVar);
        }
    }

    public void ru(int i) {
        this.ggp.setVisibility(i);
    }

    public n bDu() {
        return this.ggx;
    }

    public void c(final n nVar) {
        if (nVar == null) {
            if (this.ggs != null) {
                this.ggs.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!nVar.isValid()) {
            nVar.userName = this.mUserName;
            nVar.ffm = this.mPortrait;
        }
        this.ggx = nVar;
        View view = null;
        if (this.ggs != null) {
            this.ggs.b(nVar);
            this.ggs.getView().setVisibility(0);
            view = this.ggs.getView();
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
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mContext, nVar.userId + "", nVar.userName, nVar.ffm, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, nVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void bDv() {
        if (this.ggs != null) {
            this.ggs.getView().setVisibility(8);
        }
        if (this.ggt != null) {
            this.ggt.getView().setVisibility(8);
        }
        if (this.ggu != null) {
            this.ggu.getView().setVisibility(8);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.faB.reset();
        this.faB.setTitle(a.i.sdk_net_fail_tip_rank);
        this.faB.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.faB.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.faB.setVisibility(0);
    }

    public void blt() {
        this.faB.setVisibility(8);
    }

    public void jm(boolean z) {
        if (z) {
            this.faB.reset();
            this.faB.setTitle(a.i.rank_empty_text);
            this.faB.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.faB.setVisibility(0);
            return;
        }
        this.faB.setVisibility(8);
    }

    public void release() {
        if (this.ggv != null) {
            this.ggv.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
