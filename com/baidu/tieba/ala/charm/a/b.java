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
    private boolean agL;
    private String agM;
    private TextView dEX;
    private ImageView dEY;
    private TbListViewPullView dEZ;
    private RelativeLayout dFa;
    private TextView dFb;
    private AlaCharmDetailEmptyView dFc;
    private com.baidu.tieba.ala.charm.view.a dFd;
    private LoadingView dFe;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener dFf = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.dFb || view == b.this.dFa) {
                if (b.this.dFb.getVisibility() == 0) {
                    b.this.dFb.setVisibility(8);
                }
            } else if (view == b.this.dEY) {
                if (b.this.dFb.getVisibility() == 8) {
                    b.this.dFb.setVisibility(0);
                } else {
                    b.this.dFb.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener dEJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.dFd != null) {
                    b.this.a(b.this.dFd.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener dFg = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.dFd != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.dFd.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.dFd.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(item.pay_userid);
                    bVar.setPortrait(item.portrait);
                    bVar.setPageId(b.this.mPageId);
                    bVar.setIsAttention(z ? false : true);
                    com.baidu.live.view.a.wy().a(item.pay_userid, bVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.agL = z;
        this.agM = str3;
        initView();
    }

    public void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.dFa = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.dFa.setOnClickListener(this.dFf);
        this.dEX = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.dFb = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.dFb.setOnClickListener(this.dFf);
        this.dEY = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.dEY.setOnClickListener(this.dFf);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.dFd = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.dFd.m(this.dFg);
        this.dFd.n(this.dEJ);
        this.mListView.setAdapter((ListAdapter) this.dFd);
        this.dFc = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.dFc.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.dFc);
        this.dEZ = new TbListViewPullView(this.mPageContext);
        this.dEZ.setTag(this.mPageContext.getUniqueId());
        this.dEZ.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.dEZ);
    }

    public void sW(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.dEX != null) {
            this.dEX.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.dFe == null) {
            this.dFe = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.dFe.setSkinType(this.mSkinType);
            this.dFe.onChangeSkinType();
            this.dFe.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.dFe != null) {
                this.dFe.dettachView(this.mRootView);
                this.dFe = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.dEZ != null) {
            this.dEZ.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void K(ArrayList<ALaCharmData> arrayList) {
        this.dFd.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void aKv() {
        this.dFd.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.agL, this.agM, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void T(String str, boolean z) {
        if (this.dFd != null) {
            this.dFd.T(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.dFa, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.dEX, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.dEY, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.dFb, a.d.sdk_cp_cont_d, i);
        if (this.dFd != null) {
            this.dFd.setSkinType(i);
            this.dFd.notifyDataSetChanged();
        }
        if (this.dFe != null) {
            this.dFe.setSkinType(i);
            this.dFe.onChangeSkinType();
        }
        if (this.dEZ != null) {
            this.dEZ.setSkinType(i);
        }
    }
}
