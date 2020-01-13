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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class d {
    private int WL;
    private long edH;
    private String edJ;
    private boolean edK;
    private CommonEmptyView erG;
    private a exf;
    private TbPageContext<BaseFragmentActivity> fxS;
    private LinearLayout fyA;
    private n fyB;
    private ArrayList<g> fyC;
    private BdListView fyt;
    private com.baidu.tieba.ala.adapter.b fyu;
    private LinearLayout fyv;
    private com.baidu.tieba.ala.view.a fyw;
    private c fyx;
    private b fyy;
    private AlaRankListHeaderView fyz;
    private Context mContext;
    private String mPortrait;
    private View mRootView;
    private long mUserId;
    private String mUserName;

    /* loaded from: classes2.dex */
    public interface a {
        void f(View view, String str);
    }

    public d(TbPageContext<BaseFragmentActivity> tbPageContext, String str, int i, a aVar, boolean z, long j, String str2, String str3, long j2) {
        this.fxS = tbPageContext;
        this.mContext = this.fxS.getPageActivity();
        this.exf = aVar;
        this.edK = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.WL = i;
        this.mPortrait = str3;
        this.edH = j2;
        zt(str);
    }

    private void zt(String str) {
        this.edJ = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.fyt = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.fyu = new com.baidu.tieba.ala.adapter.b(this.mContext, str, this.edH, this.edK);
        this.fyt.setAdapter((ListAdapter) this.fyu);
        this.fyz = new AlaRankListHeaderView(this.fxS.getPageActivity(), this.edH, this.edK);
        this.fyz.a(this.fxS, str, 0L);
        this.fyt.addHeaderView(this.fyz);
        if (TextUtils.equals("hour", this.edJ) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fyA = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.fyt.addFooterView(this.fyA);
            this.fyA.setVisibility(0);
        } else if (this.fyA != null) {
            this.fyA.setVisibility(8);
        }
        this.fyv = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.fyw = new com.baidu.tieba.ala.view.a(this.mContext, str, this.edK);
            this.fyw.a(this.exf);
            this.fyv.addView(this.fyw.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.fyx = new c(this.mContext, str, this.edK, this.mUserId, this.WL, this.mPortrait);
            this.fyv.addView(this.fyx.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.fyy = new b(this.mContext, str, this.edK, this.mPortrait);
            this.fyv.addView(this.fyy.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if (!"challenge_history".equals(str)) {
            this.fyw = new com.baidu.tieba.ala.view.a(this.mContext, str, this.edK);
            this.fyw.a(this.exf);
            this.fyv.addView(this.fyw.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.erG = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.fyt.setEmptyView(this.erG);
    }

    public void rl() {
        if (this.fyw != null) {
            this.fyw.rl();
        }
    }

    public void setDatas(ArrayList<g> arrayList) {
        if (this.fyu != null) {
            this.fyu.setData(arrayList);
            this.fyC = arrayList;
        }
    }

    public void a(ArrayList<g> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.fyz.setCountDownCallback(aVar);
        this.fyz.a(this.fxS, this.edJ, j);
    }

    public ArrayList<g> aRz() {
        return this.fyC;
    }

    public void c(m mVar) {
        this.fyz.b(mVar);
    }

    public void qQ(int i) {
        if (this.fyz != null) {
            this.fyz.setHourHeaderInfoVisible(i);
        }
    }

    public void qR(int i) {
        if (this.fyA != null) {
            this.fyA.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.fyz != null) {
            this.fyz.setRankListCallback(bVar);
        }
    }

    public void qS(int i) {
        this.fyt.setVisibility(i);
    }

    public n brX() {
        return this.fyB;
    }

    public void c(final n nVar) {
        if (nVar == null) {
            if (this.fyw != null) {
                this.fyw.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!nVar.isValid()) {
            nVar.userName = this.mUserName;
            nVar.evY = this.mPortrait;
        }
        this.fyB = nVar;
        View view = null;
        if (this.fyw != null) {
            this.fyw.b(nVar);
            this.fyw.getView().setVisibility(0);
            view = this.fyw.getView();
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
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mContext, nVar.userId + "", nVar.userName, nVar.evY, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, nVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void brY() {
        if (this.fyw != null) {
            this.fyw.getView().setVisibility(8);
        }
        if (this.fyx != null) {
            this.fyx.getView().setVisibility(8);
        }
        if (this.fyy != null) {
            this.fyy.getView().setVisibility(8);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.erG.reset();
        this.erG.setTitle(a.i.sdk_net_fail_tip_rank);
        this.erG.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.erG.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.erG.setVisibility(0);
    }

    public void baf() {
        this.erG.setVisibility(8);
    }

    public void ic(boolean z) {
        if (z) {
            this.erG.reset();
            this.erG.setTitle(a.i.rank_empty_text);
            this.erG.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.erG.setVisibility(0);
            return;
        }
        this.erG.setVisibility(8);
    }

    public void release() {
        if (this.fyz != null) {
            this.fyz.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
