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
import com.baidu.live.data.e;
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
    private String aBm;
    private boolean bej;
    private TextView fUd;
    private ImageView fUe;
    private TbListViewPullView fUf;
    private RelativeLayout fUg;
    private TextView fUh;
    private AlaCharmDetailEmptyView fUi;
    private com.baidu.tieba.ala.charm.view.a fUj;
    private LoadingView fUk;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener fUl = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.fUh || view == b.this.fUg) {
                if (b.this.fUh.getVisibility() == 0) {
                    b.this.fUh.setVisibility(8);
                }
            } else if (view == b.this.fUe) {
                if (b.this.fUh.getVisibility() == 8) {
                    b.this.fUh.setVisibility(0);
                } else {
                    b.this.fUh.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener fUm = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.fUj != null) {
                    b.this.b(b.this.fUj.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener fUn = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.fUj != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.fUj.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.fUj.notifyDataSetChanged();
                    e eVar = new e();
                    eVar.setUserId(item.pay_userid);
                    eVar.setPortrait(item.portrait);
                    eVar.setPageId(b.this.mPageId);
                    eVar.setIsAttention(z ? false : true);
                    eVar.setFrom("source_charm_game_live");
                    com.baidu.live.view.a.Rg().a(item.pay_userid, eVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bej = z;
        this.aBm = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.fUg = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.fUg.setOnClickListener(this.fUl);
        this.fUd = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.fUh = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.fUh.setOnClickListener(this.fUl);
        this.fUe = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.fUe.setOnClickListener(this.fUl);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.fUj = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.fUj.m(this.fUn);
        this.fUj.n(this.fUm);
        this.mListView.setAdapter((ListAdapter) this.fUj);
        this.fUi = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.fUi.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.fUi);
        this.fUf = new TbListViewPullView(this.mPageContext);
        this.fUf.setTag(this.mPageContext.getUniqueId());
        this.fUf.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.fUf);
    }

    public void Fz(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.fUd != null) {
            this.fUd.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.fUk == null) {
            this.fUk = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.fUk.setSkinType(this.mSkinType);
            this.fUk.onChangeSkinType();
            this.fUk.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.fUk != null) {
                this.fUk.dettachView(this.mRootView);
                this.fUk = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.fUf != null) {
            this.fUf.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void aa(ArrayList<ALaCharmData> arrayList) {
        this.fUj.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bJC() {
        this.fUj.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.bej, this.aBm, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void at(String str, boolean z) {
        if (this.fUj != null) {
            this.fUj.at(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.fUg, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.fUd, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.fUe, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.fUh, a.d.sdk_cp_cont_d, i);
        if (this.fUj != null) {
            this.fUj.setSkinType(i);
            this.fUj.notifyDataSetChanged();
        }
        if (this.fUk != null) {
            this.fUk.setSkinType(i);
            this.fUk.onChangeSkinType();
        }
        if (this.fUf != null) {
            this.fUf.setSkinType(i);
        }
    }
}
