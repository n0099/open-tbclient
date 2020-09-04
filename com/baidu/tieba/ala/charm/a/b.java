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
/* loaded from: classes7.dex */
public class b {
    private String aAG;
    private boolean bbJ;
    private TextView fQS;
    private ImageView fQT;
    private TbListViewPullView fQU;
    private RelativeLayout fQV;
    private TextView fQW;
    private AlaCharmDetailEmptyView fQX;
    private com.baidu.tieba.ala.charm.view.a fQY;
    private LoadingView fQZ;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener fRa = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.fQW || view == b.this.fQV) {
                if (b.this.fQW.getVisibility() == 0) {
                    b.this.fQW.setVisibility(8);
                }
            } else if (view == b.this.fQT) {
                if (b.this.fQW.getVisibility() == 8) {
                    b.this.fQW.setVisibility(0);
                } else {
                    b.this.fQW.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener fRb = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.fQY != null) {
                    b.this.b(b.this.fQY.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener fRc = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.fQY != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.fQY.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.fQY.notifyDataSetChanged();
                    d dVar = new d();
                    dVar.setUserId(item.pay_userid);
                    dVar.setPortrait(item.portrait);
                    dVar.setPageId(b.this.mPageId);
                    dVar.setIsAttention(z ? false : true);
                    dVar.setFrom("source_charm_game_live");
                    com.baidu.live.view.a.Qx().a(item.pay_userid, dVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bbJ = z;
        this.aAG = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.fQV = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.fQV.setOnClickListener(this.fRa);
        this.fQS = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.fQW = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.fQW.setOnClickListener(this.fRa);
        this.fQT = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.fQT.setOnClickListener(this.fRa);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.fQY = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.fQY.m(this.fRc);
        this.fQY.n(this.fRb);
        this.mListView.setAdapter((ListAdapter) this.fQY);
        this.fQX = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.fQX.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.fQX);
        this.fQU = new TbListViewPullView(this.mPageContext);
        this.fQU.setTag(this.mPageContext.getUniqueId());
        this.fQU.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.fQU);
    }

    public void Fb(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.fQS != null) {
            this.fQS.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.fQZ == null) {
            this.fQZ = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.fQZ.setSkinType(this.mSkinType);
            this.fQZ.onChangeSkinType();
            this.fQZ.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.fQZ != null) {
                this.fQZ.dettachView(this.mRootView);
                this.fQZ = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.fQU != null) {
            this.fQU.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void aa(ArrayList<ALaCharmData> arrayList) {
        this.fQY.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bIu() {
        this.fQY.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.bbJ, this.aAG, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void at(String str, boolean z) {
        if (this.fQY != null) {
            this.fQY.at(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.fQV, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.fQS, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.fQT, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.fQW, a.d.sdk_cp_cont_d, i);
        if (this.fQY != null) {
            this.fQY.setSkinType(i);
            this.fQY.notifyDataSetChanged();
        }
        if (this.fQZ != null) {
            this.fQZ.setSkinType(i);
            this.fQZ.onChangeSkinType();
        }
        if (this.fQU != null) {
            this.fQU.setSkinType(i);
        }
    }
}
