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
    private boolean aMw;
    private String aMx;
    private TextView fbo;
    private ImageView fbp;
    private TbListViewPullView fbq;
    private RelativeLayout fbr;
    private TextView fbs;
    private AlaCharmDetailEmptyView fbt;
    private com.baidu.tieba.ala.charm.view.a fbu;
    private LoadingView fbv;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener fbw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.fbs || view == b.this.fbr) {
                if (b.this.fbs.getVisibility() == 0) {
                    b.this.fbs.setVisibility(8);
                }
            } else if (view == b.this.fbp) {
                if (b.this.fbs.getVisibility() == 8) {
                    b.this.fbs.setVisibility(0);
                } else {
                    b.this.fbs.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener fbx = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.fbu != null) {
                    b.this.b(b.this.fbu.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener fby = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.fbu != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.fbu.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.fbu.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(item.pay_userid);
                    bVar.setPortrait(item.portrait);
                    bVar.setPageId(b.this.mPageId);
                    bVar.setIsAttention(z ? false : true);
                    bVar.setFrom("source_charm_game_live");
                    com.baidu.live.view.a.Hs().a(item.pay_userid, bVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.aMw = z;
        this.aMx = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.fbr = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.fbr.setOnClickListener(this.fbw);
        this.fbo = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.fbs = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.fbs.setOnClickListener(this.fbw);
        this.fbp = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.fbp.setOnClickListener(this.fbw);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.fbu = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.fbu.m(this.fby);
        this.fbu.n(this.fbx);
        this.mListView.setAdapter((ListAdapter) this.fbu);
        this.fbt = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.fbt.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.fbt);
        this.fbq = new TbListViewPullView(this.mPageContext);
        this.fbq.setTag(this.mPageContext.getUniqueId());
        this.fbq.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.fbq);
    }

    public void zP(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.fbo != null) {
            this.fbo.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.fbv == null) {
            this.fbv = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.fbv.setSkinType(this.mSkinType);
            this.fbv.onChangeSkinType();
            this.fbv.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.fbv != null) {
                this.fbv.dettachView(this.mRootView);
                this.fbv = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.fbq != null) {
            this.fbq.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void T(ArrayList<ALaCharmData> arrayList) {
        this.fbu.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bnn() {
        this.fbu.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.aMw, this.aMx, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void ac(String str, boolean z) {
        if (this.fbu != null) {
            this.fbu.ac(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.fbr, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.fbo, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.fbp, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.fbs, a.d.sdk_cp_cont_d, i);
        if (this.fbu != null) {
            this.fbu.setSkinType(i);
            this.fbu.notifyDataSetChanged();
        }
        if (this.fbv != null) {
            this.fbv.setSkinType(i);
            this.fbv.onChangeSkinType();
        }
        if (this.fbq != null) {
            this.fbq.setSkinType(i);
        }
    }
}
