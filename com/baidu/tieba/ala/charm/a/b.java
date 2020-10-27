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
/* loaded from: classes4.dex */
public class b {
    private String aEz;
    private boolean bjr;
    private ImageView gqA;
    private TbListViewPullView gqB;
    private RelativeLayout gqC;
    private TextView gqD;
    private AlaCharmDetailEmptyView gqE;
    private com.baidu.tieba.ala.charm.view.a gqF;
    private LoadingView gqG;
    private TextView gqz;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener gqH = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.gqD || view == b.this.gqC) {
                if (b.this.gqD.getVisibility() == 0) {
                    b.this.gqD.setVisibility(8);
                }
            } else if (view == b.this.gqA) {
                if (b.this.gqD.getVisibility() == 8) {
                    b.this.gqD.setVisibility(0);
                } else {
                    b.this.gqD.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener gqI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gqF != null) {
                    b.this.b(b.this.gqF.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener gqJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gqF != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.gqF.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.gqF.notifyDataSetChanged();
                    f fVar = new f();
                    fVar.setUserId(item.pay_userid);
                    fVar.setPortrait(item.portrait);
                    fVar.setPageId(b.this.mPageId);
                    fVar.setIsAttention(z ? false : true);
                    fVar.setFrom("source_charm_game_live");
                    com.baidu.live.view.a.TX().a(item.pay_userid, fVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bjr = z;
        this.aEz = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.gqC = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.gqC.setOnClickListener(this.gqH);
        this.gqz = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.gqD = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.gqD.setOnClickListener(this.gqH);
        this.gqA = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.gqA.setOnClickListener(this.gqH);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.gqF = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.gqF.m(this.gqJ);
        this.gqF.n(this.gqI);
        this.mListView.setAdapter((ListAdapter) this.gqF);
        this.gqE = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.gqE.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.gqE);
        this.gqB = new TbListViewPullView(this.mPageContext);
        this.gqB.setTag(this.mPageContext.getUniqueId());
        this.gqB.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.gqB);
    }

    public void GJ(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.gqz != null) {
            this.gqz.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.gqG == null) {
            this.gqG = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.gqG.setSkinType(this.mSkinType);
            this.gqG.onChangeSkinType();
            this.gqG.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.gqG != null) {
                this.gqG.dettachView(this.mRootView);
                this.gqG = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.gqB != null) {
            this.gqB.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void aa(ArrayList<ALaCharmData> arrayList) {
        this.gqF.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bOO() {
        this.gqF.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.bjr, this.aEz, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void az(String str, boolean z) {
        if (this.gqF != null) {
            this.gqF.az(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.gqC, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.gqz, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.gqA, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.gqD, a.d.sdk_cp_cont_d, i);
        if (this.gqF != null) {
            this.gqF.setSkinType(i);
            this.gqF.notifyDataSetChanged();
        }
        if (this.gqG != null) {
            this.gqG.setSkinType(i);
            this.gqG.onChangeSkinType();
        }
        if (this.gqB != null) {
            this.gqB.setSkinType(i);
        }
    }
}
