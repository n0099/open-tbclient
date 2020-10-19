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
    private String aEr;
    private boolean bhU;
    private TextView ggA;
    private AlaCharmDetailEmptyView ggB;
    private com.baidu.tieba.ala.charm.view.a ggC;
    private LoadingView ggD;
    private TextView ggw;
    private ImageView ggx;
    private TbListViewPullView ggy;
    private RelativeLayout ggz;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener ggE = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.ggA || view == b.this.ggz) {
                if (b.this.ggA.getVisibility() == 0) {
                    b.this.ggA.setVisibility(8);
                }
            } else if (view == b.this.ggx) {
                if (b.this.ggA.getVisibility() == 8) {
                    b.this.ggA.setVisibility(0);
                } else {
                    b.this.ggA.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener ggF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.ggC != null) {
                    b.this.b(b.this.ggC.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener ggG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.ggC != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.ggC.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.ggC.notifyDataSetChanged();
                    e eVar = new e();
                    eVar.setUserId(item.pay_userid);
                    eVar.setPortrait(item.portrait);
                    eVar.setPageId(b.this.mPageId);
                    eVar.setIsAttention(z ? false : true);
                    eVar.setFrom("source_charm_game_live");
                    com.baidu.live.view.a.SY().a(item.pay_userid, eVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bhU = z;
        this.aEr = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.ggz = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.ggz.setOnClickListener(this.ggE);
        this.ggw = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.ggA = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.ggA.setOnClickListener(this.ggE);
        this.ggx = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.ggx.setOnClickListener(this.ggE);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.ggC = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.ggC.m(this.ggG);
        this.ggC.n(this.ggF);
        this.mListView.setAdapter((ListAdapter) this.ggC);
        this.ggB = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.ggB.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.ggB);
        this.ggy = new TbListViewPullView(this.mPageContext);
        this.ggy.setTag(this.mPageContext.getUniqueId());
        this.ggy.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.ggy);
    }

    public void Gk(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.ggw != null) {
            this.ggw.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.ggD == null) {
            this.ggD = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.ggD.setSkinType(this.mSkinType);
            this.ggD.onChangeSkinType();
            this.ggD.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.ggD != null) {
                this.ggD.dettachView(this.mRootView);
                this.ggD = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.ggy != null) {
            this.ggy.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void aa(ArrayList<ALaCharmData> arrayList) {
        this.ggC.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bMm() {
        this.ggC.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.bhU, this.aEr, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void ax(String str, boolean z) {
        if (this.ggC != null) {
            this.ggC.ax(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.ggz, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.ggw, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.ggx, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.ggA, a.d.sdk_cp_cont_d, i);
        if (this.ggC != null) {
            this.ggC.setSkinType(i);
            this.ggC.notifyDataSetChanged();
        }
        if (this.ggD != null) {
            this.ggD.setSkinType(i);
            this.ggD.onChangeSkinType();
        }
        if (this.ggy != null) {
            this.ggy.setSkinType(i);
        }
    }
}
