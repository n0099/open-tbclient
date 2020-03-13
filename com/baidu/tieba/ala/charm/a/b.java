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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.core.view.TbListViewPullView;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
import com.baidu.tieba.ala.charm.view.AlaCharmDetailEmptyView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b {
    private boolean asS;
    private String asT;
    private TextView ewK;
    private ImageView ewL;
    private TbListViewPullView ewM;
    private RelativeLayout ewN;
    private TextView ewO;
    private AlaCharmDetailEmptyView ewP;
    private com.baidu.tieba.ala.charm.view.a ewQ;
    private LoadingView ewR;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener ewS = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.ewO || view == b.this.ewN) {
                if (b.this.ewO.getVisibility() == 0) {
                    b.this.ewO.setVisibility(8);
                }
            } else if (view == b.this.ewL) {
                if (b.this.ewO.getVisibility() == 8) {
                    b.this.ewO.setVisibility(0);
                } else {
                    b.this.ewO.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener ewi = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.ewQ != null) {
                    b.this.a(b.this.ewQ.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener ewT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.ewQ != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.ewQ.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.ewQ.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(item.pay_userid);
                    bVar.setPortrait(item.portrait);
                    bVar.setPageId(b.this.mPageId);
                    bVar.setIsAttention(z ? false : true);
                    com.baidu.live.view.a.Bj().a(item.pay_userid, bVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.asS = z;
        this.asT = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.ewN = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.ewN.setOnClickListener(this.ewS);
        this.ewK = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.ewO = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.ewO.setOnClickListener(this.ewS);
        this.ewL = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.ewL.setOnClickListener(this.ewS);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.ewQ = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.ewQ.m(this.ewT);
        this.ewQ.n(this.ewi);
        this.mListView.setAdapter((ListAdapter) this.ewQ);
        this.ewP = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.ewP.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.ewP);
        this.ewM = new TbListViewPullView(this.mPageContext);
        this.ewM.setTag(this.mPageContext.getUniqueId());
        this.ewM.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.ewM);
    }

    public void ye(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.ewK != null) {
            this.ewK.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.ewR == null) {
            this.ewR = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.ewR.setSkinType(this.mSkinType);
            this.ewR.onChangeSkinType();
            this.ewR.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.ewR != null) {
                this.ewR.dettachView(this.mRootView);
                this.ewR = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.ewM != null) {
            this.ewM.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void S(ArrayList<ALaCharmData> arrayList) {
        this.ewQ.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bdY() {
        this.ewQ.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.asS, this.asT, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void X(String str, boolean z) {
        if (this.ewQ != null) {
            this.ewQ.X(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.ewN, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.ewK, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.ewL, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.ewO, a.d.sdk_cp_cont_d, i);
        if (this.ewQ != null) {
            this.ewQ.setSkinType(i);
            this.ewQ.notifyDataSetChanged();
        }
        if (this.ewR != null) {
            this.ewR.setSkinType(i);
            this.ewR.onChangeSkinType();
        }
        if (this.ewM != null) {
            this.ewM.setSkinType(i);
        }
    }
}
