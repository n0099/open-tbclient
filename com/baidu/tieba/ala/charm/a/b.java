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
    private boolean aMq;
    private String aMr;
    private TextView fbj;
    private ImageView fbk;
    private TbListViewPullView fbl;
    private RelativeLayout fbm;
    private TextView fbn;
    private AlaCharmDetailEmptyView fbo;
    private com.baidu.tieba.ala.charm.view.a fbp;
    private LoadingView fbq;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener fbr = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.fbn || view == b.this.fbm) {
                if (b.this.fbn.getVisibility() == 0) {
                    b.this.fbn.setVisibility(8);
                }
            } else if (view == b.this.fbk) {
                if (b.this.fbn.getVisibility() == 8) {
                    b.this.fbn.setVisibility(0);
                } else {
                    b.this.fbn.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener fbs = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.fbp != null) {
                    b.this.b(b.this.fbp.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener fbt = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.fbp != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.fbp.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.fbp.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(item.pay_userid);
                    bVar.setPortrait(item.portrait);
                    bVar.setPageId(b.this.mPageId);
                    bVar.setIsAttention(z ? false : true);
                    bVar.setFrom("source_charm_game_live");
                    com.baidu.live.view.a.Ht().a(item.pay_userid, bVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.aMq = z;
        this.aMr = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.fbm = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.fbm.setOnClickListener(this.fbr);
        this.fbj = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.fbn = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.fbn.setOnClickListener(this.fbr);
        this.fbk = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.fbk.setOnClickListener(this.fbr);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.fbp = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.fbp.m(this.fbt);
        this.fbp.n(this.fbs);
        this.mListView.setAdapter((ListAdapter) this.fbp);
        this.fbo = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.fbo.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.fbo);
        this.fbl = new TbListViewPullView(this.mPageContext);
        this.fbl.setTag(this.mPageContext.getUniqueId());
        this.fbl.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.fbl);
    }

    public void zM(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.fbj != null) {
            this.fbj.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.fbq == null) {
            this.fbq = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.fbq.setSkinType(this.mSkinType);
            this.fbq.onChangeSkinType();
            this.fbq.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.fbq != null) {
                this.fbq.dettachView(this.mRootView);
                this.fbq = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.fbl != null) {
            this.fbl.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void T(ArrayList<ALaCharmData> arrayList) {
        this.fbp.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bnp() {
        this.fbp.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.aMq, this.aMr, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void ac(String str, boolean z) {
        if (this.fbp != null) {
            this.fbp.ac(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.fbm, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.fbj, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.fbk, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.fbn, a.d.sdk_cp_cont_d, i);
        if (this.fbp != null) {
            this.fbp.setSkinType(i);
            this.fbp.notifyDataSetChanged();
        }
        if (this.fbq != null) {
            this.fbq.setSkinType(i);
            this.fbq.onChangeSkinType();
        }
        if (this.fbl != null) {
            this.fbl.setSkinType(i);
        }
    }
}
