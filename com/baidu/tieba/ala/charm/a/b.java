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
import com.baidu.live.q.a;
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
    private boolean aoM;
    private String aoN;
    private TextView era;
    private ImageView erb;
    private TbListViewPullView erc;
    private RelativeLayout erd;
    private TextView ere;
    private AlaCharmDetailEmptyView erf;
    private com.baidu.tieba.ala.charm.view.a erg;
    private LoadingView erh;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener eri = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.ere || view == b.this.erd) {
                if (b.this.ere.getVisibility() == 0) {
                    b.this.ere.setVisibility(8);
                }
            } else if (view == b.this.erb) {
                if (b.this.ere.getVisibility() == 8) {
                    b.this.ere.setVisibility(0);
                } else {
                    b.this.ere.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener eqx = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.erg != null) {
                    b.this.a(b.this.erg.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener erj = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.erg != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.erg.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.erg.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(item.pay_userid);
                    bVar.setPortrait(item.portrait);
                    bVar.setPageId(b.this.mPageId);
                    bVar.setIsAttention(z ? false : true);
                    com.baidu.live.view.a.yy().a(item.pay_userid, bVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.aoM = z;
        this.aoN = str3;
        initView();
    }

    public void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.erd = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.erd.setOnClickListener(this.eri);
        this.era = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.ere = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.ere.setOnClickListener(this.eri);
        this.erb = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.erb.setOnClickListener(this.eri);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.erg = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.erg.n(this.erj);
        this.erg.o(this.eqx);
        this.mListView.setAdapter((ListAdapter) this.erg);
        this.erf = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.erf.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.erf);
        this.erc = new TbListViewPullView(this.mPageContext);
        this.erc.setTag(this.mPageContext.getUniqueId());
        this.erc.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.erc);
    }

    public void xE(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.era != null) {
            this.era.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.erh == null) {
            this.erh = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.erh.setSkinType(this.mSkinType);
            this.erh.onChangeSkinType();
            this.erh.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.erh != null) {
                this.erh.dettachView(this.mRootView);
                this.erh = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.erc != null) {
            this.erc.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void Q(ArrayList<ALaCharmData> arrayList) {
        this.erg.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bbl() {
        this.erg.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.aoM, this.aoN, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void X(String str, boolean z) {
        if (this.erg != null) {
            this.erg.X(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.erd, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.era, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.erb, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.ere, a.d.sdk_cp_cont_d, i);
        if (this.erg != null) {
            this.erg.setSkinType(i);
            this.erg.notifyDataSetChanged();
        }
        if (this.erh != null) {
            this.erh.setSkinType(i);
            this.erh.onChangeSkinType();
        }
        if (this.erc != null) {
            this.erc.setSkinType(i);
        }
    }
}
