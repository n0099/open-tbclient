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
import com.baidu.live.data.f;
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
/* loaded from: classes10.dex */
public class b {
    private String aFb;
    private boolean bpf;
    private TextView gQn;
    private ImageView gQo;
    private TbListViewPullView gQp;
    private RelativeLayout gQq;
    private TextView gQr;
    private AlaCharmDetailEmptyView gQs;
    private com.baidu.tieba.ala.charm.view.a gQt;
    private LoadingView gQu;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener gQv = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.gQr || view == b.this.gQq) {
                if (b.this.gQr.getVisibility() == 0) {
                    b.this.gQr.setVisibility(8);
                }
            } else if (view == b.this.gQo) {
                if (b.this.gQr.getVisibility() == 8) {
                    b.this.gQr.setVisibility(0);
                } else {
                    b.this.gQr.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener gQw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gQt != null) {
                    b.this.b(b.this.gQt.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener gQx = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gQt != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.gQt.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.gQt.notifyDataSetChanged();
                    f fVar = new f();
                    fVar.setUserId(item.pay_userid);
                    fVar.setPortrait(item.portrait);
                    fVar.setPageId(b.this.mPageId);
                    fVar.setIsAttention(z ? false : true);
                    fVar.setFrom("source_charm_game_live");
                    com.baidu.live.view.a.Xr().a(item.pay_userid, fVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bpf = z;
        this.aFb = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_game_live_layout, (ViewGroup) null);
        this.gQq = (RelativeLayout) this.mRootView.findViewById(a.f.ala_charm_game_live_header_layout);
        this.gQq.setOnClickListener(this.gQv);
        this.gQn = (TextView) this.mRootView.findViewById(a.f.ala_charm_game_live_charm_value);
        this.gQr = (TextView) this.mRootView.findViewById(a.f.ala_charm_game_live_help_tips);
        this.gQr.setOnClickListener(this.gQv);
        this.gQo = (ImageView) this.mRootView.findViewById(a.f.ala_charm_game_live_help_img);
        this.gQo.setOnClickListener(this.gQv);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.ala_charm_game_live_detail_list);
        this.gQt = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.gQt.o(this.gQx);
        this.gQt.p(this.gQw);
        this.mListView.setAdapter((ListAdapter) this.gQt);
        this.gQs = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.gQs.setParams(a.e.sdk_emotion07, -1, a.h.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.gQs);
        this.gQp = new TbListViewPullView(this.mPageContext);
        this.gQp.setTag(this.mPageContext.getUniqueId());
        this.gQp.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.gQp);
    }

    public void GI(String str) {
        String format = String.format(this.mPageContext.getString(a.h.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.gQn != null) {
            this.gQn.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.gQu == null) {
            this.gQu = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds248));
            this.gQu.setSkinType(this.mSkinType);
            this.gQu.onChangeSkinType();
            this.gQu.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.gQu != null) {
                this.gQu.dettachView(this.mRootView);
                this.gQu = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.gQp != null) {
            this.gQp.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void V(ArrayList<ALaCharmData> arrayList) {
        this.gQt.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bTV() {
        this.gQt.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.bpf, this.aFb, aLaCharmData.appId, aLaCharmData.user_name);
            alaPersonCardActivityConfig.setExtInfo(aLaCharmData.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }
    }

    public void aA(String str, boolean z) {
        if (this.gQt != null) {
            this.gQt.aA(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.gQq, a.e.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.gQn, a.c.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.gQo, a.e.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.gQr, a.c.sdk_cp_cont_d, i);
        if (this.gQt != null) {
            this.gQt.setSkinType(i);
            this.gQt.notifyDataSetChanged();
        }
        if (this.gQu != null) {
            this.gQu.setSkinType(i);
            this.gQu.onChangeSkinType();
        }
        if (this.gQp != null) {
            this.gQp.setSkinType(i);
        }
    }
}
