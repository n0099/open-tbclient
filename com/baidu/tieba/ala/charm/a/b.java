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
    private boolean atc;
    private String atd;
    private TextView exg;
    private ImageView exh;
    private TbListViewPullView exi;
    private RelativeLayout exj;
    private TextView exk;
    private AlaCharmDetailEmptyView exl;
    private com.baidu.tieba.ala.charm.view.a exm;
    private LoadingView exn;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener exo = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.exk || view == b.this.exj) {
                if (b.this.exk.getVisibility() == 0) {
                    b.this.exk.setVisibility(8);
                }
            } else if (view == b.this.exh) {
                if (b.this.exk.getVisibility() == 8) {
                    b.this.exk.setVisibility(0);
                } else {
                    b.this.exk.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener ewE = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.exm != null) {
                    b.this.a(b.this.exm.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener exp = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.exm != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.exm.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.exm.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(item.pay_userid);
                    bVar.setPortrait(item.portrait);
                    bVar.setPageId(b.this.mPageId);
                    bVar.setIsAttention(z ? false : true);
                    com.baidu.live.view.a.Bq().a(item.pay_userid, bVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.atc = z;
        this.atd = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.exj = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.exj.setOnClickListener(this.exo);
        this.exg = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.exk = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.exk.setOnClickListener(this.exo);
        this.exh = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.exh.setOnClickListener(this.exo);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.exm = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.exm.m(this.exp);
        this.exm.n(this.ewE);
        this.mListView.setAdapter((ListAdapter) this.exm);
        this.exl = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.exl.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.exl);
        this.exi = new TbListViewPullView(this.mPageContext);
        this.exi.setTag(this.mPageContext.getUniqueId());
        this.exi.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.exi);
    }

    public void yf(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.exg != null) {
            this.exg.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.exn == null) {
            this.exn = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.exn.setSkinType(this.mSkinType);
            this.exn.onChangeSkinType();
            this.exn.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.exn != null) {
                this.exn.dettachView(this.mRootView);
                this.exn = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.exi != null) {
            this.exi.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void S(ArrayList<ALaCharmData> arrayList) {
        this.exm.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bed() {
        this.exm.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.atc, this.atd, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void X(String str, boolean z) {
        if (this.exm != null) {
            this.exm.X(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.exj, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.exg, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.exh, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.exk, a.d.sdk_cp_cont_d, i);
        if (this.exm != null) {
            this.exm.setSkinType(i);
            this.exm.notifyDataSetChanged();
        }
        if (this.exn != null) {
            this.exn.setSkinType(i);
            this.exn.onChangeSkinType();
        }
        if (this.exi != null) {
            this.exi.setSkinType(i);
        }
    }
}
