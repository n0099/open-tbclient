package com.baidu.tieba.ala.charm.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.core.view.TbListViewPullView;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
import com.baidu.tieba.ala.charm.view.AlaCharmDetailEmptyView;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class b {
    private String aAE;
    private boolean bbH;
    private TextView fQO;
    private ImageView fQP;
    private TbListViewPullView fQQ;
    private RelativeLayout fQR;
    private TextView fQS;
    private AlaCharmDetailEmptyView fQT;
    private com.baidu.tieba.ala.charm.view.a fQU;
    private LoadingView fQV;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener fQW = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.fQS || view == b.this.fQR) {
                if (b.this.fQS.getVisibility() == 0) {
                    b.this.fQS.setVisibility(8);
                }
            } else if (view == b.this.fQP) {
                if (b.this.fQS.getVisibility() == 8) {
                    b.this.fQS.setVisibility(0);
                } else {
                    b.this.fQS.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener fQX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.fQU != null) {
                    b.this.b(b.this.fQU.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener fQY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.fQU != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.fQU.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.fQU.notifyDataSetChanged();
                    d dVar = new d();
                    dVar.setUserId(item.pay_userid);
                    dVar.setPortrait(item.portrait);
                    dVar.setPageId(b.this.mPageId);
                    dVar.setIsAttention(z ? false : true);
                    dVar.setFrom("source_charm_game_live");
                    com.baidu.live.view.a.Qx().a(item.pay_userid, dVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bbH = z;
        this.aAE = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.fQR = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.fQR.setOnClickListener(this.fQW);
        this.fQO = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.fQS = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.fQS.setOnClickListener(this.fQW);
        this.fQP = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.fQP.setOnClickListener(this.fQW);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.fQU = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.fQU.m(this.fQY);
        this.fQU.n(this.fQX);
        this.mListView.setAdapter((ListAdapter) this.fQU);
        this.fQT = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.fQT.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.fQT);
        this.fQQ = new TbListViewPullView(this.mPageContext);
        this.fQQ.setTag(this.mPageContext.getUniqueId());
        this.fQQ.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.fQQ);
    }

    public void Fa(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.fQO != null) {
            this.fQO.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.fQV == null) {
            this.fQV = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.fQV.setSkinType(this.mSkinType);
            this.fQV.onChangeSkinType();
            this.fQV.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.fQV != null) {
                this.fQV.dettachView(this.mRootView);
                this.fQV = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.fQQ != null) {
            this.fQQ.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void aa(ArrayList<ALaCharmData> arrayList) {
        this.fQU.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bIt() {
        this.fQU.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.bbH, this.aAE, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void at(String str, boolean z) {
        if (this.fQU != null) {
            this.fQU.at(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.fQR, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.fQO, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.fQP, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.fQS, a.d.sdk_cp_cont_d, i);
        if (this.fQU != null) {
            this.fQU.setSkinType(i);
            this.fQU.notifyDataSetChanged();
        }
        if (this.fQV != null) {
            this.fQV.setSkinType(i);
            this.fQV.onChangeSkinType();
        }
        if (this.fQQ != null) {
            this.fQQ.setSkinType(i);
        }
    }
}
