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
    private String aGk;
    private boolean bns;
    private TextView gEF;
    private ImageView gEG;
    private TbListViewPullView gEH;
    private RelativeLayout gEI;
    private TextView gEJ;
    private AlaCharmDetailEmptyView gEK;
    private com.baidu.tieba.ala.charm.view.a gEL;
    private LoadingView gEM;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener gEN = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.gEJ || view == b.this.gEI) {
                if (b.this.gEJ.getVisibility() == 0) {
                    b.this.gEJ.setVisibility(8);
                }
            } else if (view == b.this.gEG) {
                if (b.this.gEJ.getVisibility() == 8) {
                    b.this.gEJ.setVisibility(0);
                } else {
                    b.this.gEJ.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener gEO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gEL != null) {
                    b.this.b(b.this.gEL.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener gEP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gEL != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.gEL.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.gEL.notifyDataSetChanged();
                    f fVar = new f();
                    fVar.setUserId(item.pay_userid);
                    fVar.setPortrait(item.portrait);
                    fVar.setPageId(b.this.mPageId);
                    fVar.setIsAttention(z ? false : true);
                    fVar.setFrom("source_charm_game_live");
                    com.baidu.live.view.a.Yo().a(item.pay_userid, fVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bns = z;
        this.aGk = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_game_live_layout, (ViewGroup) null);
        this.gEI = (RelativeLayout) this.mRootView.findViewById(a.f.ala_charm_game_live_header_layout);
        this.gEI.setOnClickListener(this.gEN);
        this.gEF = (TextView) this.mRootView.findViewById(a.f.ala_charm_game_live_charm_value);
        this.gEJ = (TextView) this.mRootView.findViewById(a.f.ala_charm_game_live_help_tips);
        this.gEJ.setOnClickListener(this.gEN);
        this.gEG = (ImageView) this.mRootView.findViewById(a.f.ala_charm_game_live_help_img);
        this.gEG.setOnClickListener(this.gEN);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.ala_charm_game_live_detail_list);
        this.gEL = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.gEL.n(this.gEP);
        this.gEL.o(this.gEO);
        this.mListView.setAdapter((ListAdapter) this.gEL);
        this.gEK = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.gEK.setParams(a.e.sdk_emotion07, -1, a.h.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.gEK);
        this.gEH = new TbListViewPullView(this.mPageContext);
        this.gEH.setTag(this.mPageContext.getUniqueId());
        this.gEH.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.gEH);
    }

    public void setCharmValue(String str) {
        String format = String.format(this.mPageContext.getString(a.h.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.gEF != null) {
            this.gEF.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.gEM == null) {
            this.gEM = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds248));
            this.gEM.setSkinType(this.mSkinType);
            this.gEM.onChangeSkinType();
            this.gEM.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.gEM != null) {
                this.gEM.dettachView(this.mRootView);
                this.gEM = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.gEH != null) {
            this.gEH.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void ab(ArrayList<ALaCharmData> arrayList) {
        this.gEL.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bUs() {
        this.gEL.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.bns, this.aGk, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void aA(String str, boolean z) {
        if (this.gEL != null) {
            this.gEL.aA(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.gEI, a.e.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.gEF, a.c.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.gEG, a.e.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.gEJ, a.c.sdk_cp_cont_d, i);
        if (this.gEL != null) {
            this.gEL.setSkinType(i);
            this.gEL.notifyDataSetChanged();
        }
        if (this.gEM != null) {
            this.gEM.setSkinType(i);
            this.gEM.onChangeSkinType();
        }
        if (this.gEH != null) {
            this.gEH.setSkinType(i);
        }
    }
}
