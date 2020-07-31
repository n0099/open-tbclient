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
/* loaded from: classes4.dex */
public class b {
    private boolean aWs;
    private String avC;
    private RelativeLayout fFA;
    private TextView fFB;
    private AlaCharmDetailEmptyView fFC;
    private com.baidu.tieba.ala.charm.view.a fFD;
    private LoadingView fFE;
    private TextView fFx;
    private ImageView fFy;
    private TbListViewPullView fFz;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener fFF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.fFB || view == b.this.fFA) {
                if (b.this.fFB.getVisibility() == 0) {
                    b.this.fFB.setVisibility(8);
                }
            } else if (view == b.this.fFy) {
                if (b.this.fFB.getVisibility() == 8) {
                    b.this.fFB.setVisibility(0);
                } else {
                    b.this.fFB.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener fFG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.fFD != null) {
                    b.this.b(b.this.fFD.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener fFH = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.fFD != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.fFD.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.fFD.notifyDataSetChanged();
                    d dVar = new d();
                    dVar.setUserId(item.pay_userid);
                    dVar.setPortrait(item.portrait);
                    dVar.setPageId(b.this.mPageId);
                    dVar.setIsAttention(z ? false : true);
                    dVar.setFrom("source_charm_game_live");
                    com.baidu.live.view.a.KF().a(item.pay_userid, dVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.aWs = z;
        this.avC = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.fFA = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.fFA.setOnClickListener(this.fFF);
        this.fFx = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.fFB = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.fFB.setOnClickListener(this.fFF);
        this.fFy = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.fFy.setOnClickListener(this.fFF);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.fFD = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.fFD.m(this.fFH);
        this.fFD.n(this.fFG);
        this.mListView.setAdapter((ListAdapter) this.fFD);
        this.fFC = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.fFC.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.fFC);
        this.fFz = new TbListViewPullView(this.mPageContext);
        this.fFz.setTag(this.mPageContext.getUniqueId());
        this.fFz.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.fFz);
    }

    public void CF(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.fFx != null) {
            this.fFx.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.fFE == null) {
            this.fFE = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.fFE.setSkinType(this.mSkinType);
            this.fFE.onChangeSkinType();
            this.fFE.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.fFE != null) {
                this.fFE.dettachView(this.mRootView);
                this.fFE = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.fFz != null) {
            this.fFz.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void U(ArrayList<ALaCharmData> arrayList) {
        this.fFD.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bzq() {
        this.fFD.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.aWs, this.avC, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void ap(String str, boolean z) {
        if (this.fFD != null) {
            this.fFD.ap(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.fFA, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.fFx, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.fFy, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.fFB, a.d.sdk_cp_cont_d, i);
        if (this.fFD != null) {
            this.fFD.setSkinType(i);
            this.fFD.notifyDataSetChanged();
        }
        if (this.fFE != null) {
            this.fFE.setSkinType(i);
            this.fFE.onChangeSkinType();
        }
        if (this.fFz != null) {
            this.fFz.setSkinType(i);
        }
    }
}
