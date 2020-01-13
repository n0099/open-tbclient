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
import com.baidu.live.r.a;
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
/* loaded from: classes2.dex */
public class b {
    private String apA;
    private boolean apz;
    private TextView esm;
    private ImageView esn;
    private TbListViewPullView eso;
    private RelativeLayout esp;
    private TextView esq;
    private AlaCharmDetailEmptyView esr;
    private com.baidu.tieba.ala.charm.view.a ess;
    private LoadingView est;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener esu = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.esq || view == b.this.esp) {
                if (b.this.esq.getVisibility() == 0) {
                    b.this.esq.setVisibility(8);
                }
            } else if (view == b.this.esn) {
                if (b.this.esq.getVisibility() == 8) {
                    b.this.esq.setVisibility(0);
                } else {
                    b.this.esq.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener erK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.ess != null) {
                    b.this.a(b.this.ess.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener esv = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.ess != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.ess.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.ess.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(item.pay_userid);
                    bVar.setPortrait(item.portrait);
                    bVar.setPageId(b.this.mPageId);
                    bVar.setIsAttention(z ? false : true);
                    com.baidu.live.view.a.yR().a(item.pay_userid, bVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.apz = z;
        this.apA = str3;
        initView();
    }

    public void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.esp = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.esp.setOnClickListener(this.esu);
        this.esm = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.esq = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.esq.setOnClickListener(this.esu);
        this.esn = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.esn.setOnClickListener(this.esu);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.ess = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.ess.m(this.esv);
        this.ess.n(this.erK);
        this.mListView.setAdapter((ListAdapter) this.ess);
        this.esr = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.esr.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.esr);
        this.eso = new TbListViewPullView(this.mPageContext);
        this.eso.setTag(this.mPageContext.getUniqueId());
        this.eso.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.eso);
    }

    public void xJ(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.esm != null) {
            this.esm.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.est == null) {
            this.est = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.est.setSkinType(this.mSkinType);
            this.est.onChangeSkinType();
            this.est.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.est != null) {
                this.est.dettachView(this.mRootView);
                this.est = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.eso != null) {
            this.eso.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void Q(ArrayList<ALaCharmData> arrayList) {
        this.ess.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bbG() {
        this.ess.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.apz, this.apA, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void X(String str, boolean z) {
        if (this.ess != null) {
            this.ess.X(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.esp, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.esm, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.esn, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.esq, a.d.sdk_cp_cont_d, i);
        if (this.ess != null) {
            this.ess.setSkinType(i);
            this.ess.notifyDataSetChanged();
        }
        if (this.est != null) {
            this.est.setSkinType(i);
            this.est.onChangeSkinType();
        }
        if (this.eso != null) {
            this.eso.setSkinType(i);
        }
    }
}
