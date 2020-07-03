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
/* loaded from: classes3.dex */
public class b {
    private boolean aVc;
    private String aVd;
    private TextView fAn;
    private ImageView fAo;
    private TbListViewPullView fAp;
    private RelativeLayout fAq;
    private TextView fAr;
    private AlaCharmDetailEmptyView fAs;
    private com.baidu.tieba.ala.charm.view.a fAt;
    private LoadingView fAu;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener fAv = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.fAr || view == b.this.fAq) {
                if (b.this.fAr.getVisibility() == 0) {
                    b.this.fAr.setVisibility(8);
                }
            } else if (view == b.this.fAo) {
                if (b.this.fAr.getVisibility() == 8) {
                    b.this.fAr.setVisibility(0);
                } else {
                    b.this.fAr.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener fAw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.fAt != null) {
                    b.this.b(b.this.fAt.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener fAx = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.fAt != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.fAt.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.fAt.notifyDataSetChanged();
                    d dVar = new d();
                    dVar.setUserId(item.pay_userid);
                    dVar.setPortrait(item.portrait);
                    dVar.setPageId(b.this.mPageId);
                    dVar.setIsAttention(z ? false : true);
                    dVar.setFrom("source_charm_game_live");
                    com.baidu.live.view.a.Ky().a(item.pay_userid, dVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.aVc = z;
        this.aVd = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.fAq = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.fAq.setOnClickListener(this.fAv);
        this.fAn = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.fAr = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.fAr.setOnClickListener(this.fAv);
        this.fAo = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.fAo.setOnClickListener(this.fAv);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.fAt = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.fAt.m(this.fAx);
        this.fAt.n(this.fAw);
        this.mListView.setAdapter((ListAdapter) this.fAt);
        this.fAs = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.fAs.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.fAs);
        this.fAp = new TbListViewPullView(this.mPageContext);
        this.fAp.setTag(this.mPageContext.getUniqueId());
        this.fAp.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.fAp);
    }

    public void BU(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.fAn != null) {
            this.fAn.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.fAu == null) {
            this.fAu = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.fAu.setSkinType(this.mSkinType);
            this.fAu.onChangeSkinType();
            this.fAu.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.fAu != null) {
                this.fAu.dettachView(this.mRootView);
                this.fAu = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.fAp != null) {
            this.fAp.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void T(ArrayList<ALaCharmData> arrayList) {
        this.fAt.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bwb() {
        this.fAt.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.aVc, this.aVd, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void ar(String str, boolean z) {
        if (this.fAt != null) {
            this.fAt.ar(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.fAq, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.fAn, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.fAo, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.fAr, a.d.sdk_cp_cont_d, i);
        if (this.fAt != null) {
            this.fAt.setSkinType(i);
            this.fAt.notifyDataSetChanged();
        }
        if (this.fAu != null) {
            this.fAu.setSkinType(i);
            this.fAu.onChangeSkinType();
        }
        if (this.fAp != null) {
            this.fAp.setSkinType(i);
        }
    }
}
