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
import com.baidu.live.k.a;
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
/* loaded from: classes6.dex */
public class b {
    private boolean ahd;
    private String ahe;
    private TextView dFO;
    private ImageView dFP;
    private TbListViewPullView dFQ;
    private RelativeLayout dFR;
    private TextView dFS;
    private AlaCharmDetailEmptyView dFT;
    private com.baidu.tieba.ala.charm.view.a dFU;
    private LoadingView dFV;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener dFW = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.dFS || view == b.this.dFR) {
                if (b.this.dFS.getVisibility() == 0) {
                    b.this.dFS.setVisibility(8);
                }
            } else if (view == b.this.dFP) {
                if (b.this.dFS.getVisibility() == 8) {
                    b.this.dFS.setVisibility(0);
                } else {
                    b.this.dFS.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener dFA = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.dFU != null) {
                    b.this.a(b.this.dFU.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener dFX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.dFU != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.dFU.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.dFU.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(item.pay_userid);
                    bVar.setPortrait(item.portrait);
                    bVar.setPageId(b.this.mPageId);
                    bVar.setIsAttention(z ? false : true);
                    com.baidu.live.view.a.wx().a(item.pay_userid, bVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.ahd = z;
        this.ahe = str3;
        initView();
    }

    public void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.dFR = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.dFR.setOnClickListener(this.dFW);
        this.dFO = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.dFS = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.dFS.setOnClickListener(this.dFW);
        this.dFP = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.dFP.setOnClickListener(this.dFW);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.dFU = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.dFU.m(this.dFX);
        this.dFU.n(this.dFA);
        this.mListView.setAdapter((ListAdapter) this.dFU);
        this.dFT = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.dFT.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.dFT);
        this.dFQ = new TbListViewPullView(this.mPageContext);
        this.dFQ.setTag(this.mPageContext.getUniqueId());
        this.dFQ.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.dFQ);
    }

    public void sW(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.dFO != null) {
            this.dFO.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.dFV == null) {
            this.dFV = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.dFV.setSkinType(this.mSkinType);
            this.dFV.onChangeSkinType();
            this.dFV.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.dFV != null) {
                this.dFV.dettachView(this.mRootView);
                this.dFV = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.dFQ != null) {
            this.dFQ.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void K(ArrayList<ALaCharmData> arrayList) {
        this.dFU.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void aKx() {
        this.dFU.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.ahd, this.ahe, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void T(String str, boolean z) {
        if (this.dFU != null) {
            this.dFU.T(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.dFR, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.dFO, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.dFP, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.dFS, a.d.sdk_cp_cont_d, i);
        if (this.dFU != null) {
            this.dFU.setSkinType(i);
            this.dFU.notifyDataSetChanged();
        }
        if (this.dFV != null) {
            this.dFV.setSkinType(i);
            this.dFV.onChangeSkinType();
        }
        if (this.dFQ != null) {
            this.dFQ.setSkinType(i);
        }
    }
}
