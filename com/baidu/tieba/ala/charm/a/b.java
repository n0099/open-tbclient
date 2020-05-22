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
    private boolean aSw;
    private String aSx;
    private TextView foQ;
    private ImageView foR;
    private TbListViewPullView foS;
    private RelativeLayout foT;
    private TextView foU;
    private AlaCharmDetailEmptyView foV;
    private com.baidu.tieba.ala.charm.view.a foW;
    private LoadingView foX;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener foY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.foU || view == b.this.foT) {
                if (b.this.foU.getVisibility() == 0) {
                    b.this.foU.setVisibility(8);
                }
            } else if (view == b.this.foR) {
                if (b.this.foU.getVisibility() == 8) {
                    b.this.foU.setVisibility(0);
                } else {
                    b.this.foU.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener foZ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.foW != null) {
                    b.this.b(b.this.foW.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener fpa = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.foW != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.foW.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.foW.notifyDataSetChanged();
                    d dVar = new d();
                    dVar.setUserId(item.pay_userid);
                    dVar.setPortrait(item.portrait);
                    dVar.setPageId(b.this.mPageId);
                    dVar.setIsAttention(z ? false : true);
                    dVar.setFrom("source_charm_game_live");
                    com.baidu.live.view.a.Jl().a(item.pay_userid, dVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.aSw = z;
        this.aSx = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.foT = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.foT.setOnClickListener(this.foY);
        this.foQ = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.foU = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.foU.setOnClickListener(this.foY);
        this.foR = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.foR.setOnClickListener(this.foY);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.foW = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.foW.l(this.fpa);
        this.foW.m(this.foZ);
        this.mListView.setAdapter((ListAdapter) this.foW);
        this.foV = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.foV.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.foV);
        this.foS = new TbListViewPullView(this.mPageContext);
        this.foS.setTag(this.mPageContext.getUniqueId());
        this.foS.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.foS);
    }

    public void Bw(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.foQ != null) {
            this.foQ.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.foX == null) {
            this.foX = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.foX.setSkinType(this.mSkinType);
            this.foX.onChangeSkinType();
            this.foX.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.foX != null) {
                this.foX.dettachView(this.mRootView);
                this.foX = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.foS != null) {
            this.foS.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void T(ArrayList<ALaCharmData> arrayList) {
        this.foW.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void btf() {
        this.foW.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.aSw, this.aSx, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void ap(String str, boolean z) {
        if (this.foW != null) {
            this.foW.ap(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.foT, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.foQ, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.foR, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.foU, a.d.sdk_cp_cont_d, i);
        if (this.foW != null) {
            this.foW.setSkinType(i);
            this.foW.notifyDataSetChanged();
        }
        if (this.foX != null) {
            this.foX.setSkinType(i);
            this.foX.onChangeSkinType();
        }
        if (this.foS != null) {
            this.foS.setSkinType(i);
        }
    }
}
