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
    private TextView gED;
    private ImageView gEE;
    private TbListViewPullView gEF;
    private RelativeLayout gEG;
    private TextView gEH;
    private AlaCharmDetailEmptyView gEI;
    private com.baidu.tieba.ala.charm.view.a gEJ;
    private LoadingView gEK;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener gEL = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.gEH || view == b.this.gEG) {
                if (b.this.gEH.getVisibility() == 0) {
                    b.this.gEH.setVisibility(8);
                }
            } else if (view == b.this.gEE) {
                if (b.this.gEH.getVisibility() == 8) {
                    b.this.gEH.setVisibility(0);
                } else {
                    b.this.gEH.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener gEM = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gEJ != null) {
                    b.this.b(b.this.gEJ.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener gEN = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gEJ != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.gEJ.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.gEJ.notifyDataSetChanged();
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
        this.gEG = (RelativeLayout) this.mRootView.findViewById(a.f.ala_charm_game_live_header_layout);
        this.gEG.setOnClickListener(this.gEL);
        this.gED = (TextView) this.mRootView.findViewById(a.f.ala_charm_game_live_charm_value);
        this.gEH = (TextView) this.mRootView.findViewById(a.f.ala_charm_game_live_help_tips);
        this.gEH.setOnClickListener(this.gEL);
        this.gEE = (ImageView) this.mRootView.findViewById(a.f.ala_charm_game_live_help_img);
        this.gEE.setOnClickListener(this.gEL);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.ala_charm_game_live_detail_list);
        this.gEJ = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.gEJ.n(this.gEN);
        this.gEJ.o(this.gEM);
        this.mListView.setAdapter((ListAdapter) this.gEJ);
        this.gEI = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.gEI.setParams(a.e.sdk_emotion07, -1, a.h.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.gEI);
        this.gEF = new TbListViewPullView(this.mPageContext);
        this.gEF.setTag(this.mPageContext.getUniqueId());
        this.gEF.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.gEF);
    }

    public void setCharmValue(String str) {
        String format = String.format(this.mPageContext.getString(a.h.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.gED != null) {
            this.gED.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.gEK == null) {
            this.gEK = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds248));
            this.gEK.setSkinType(this.mSkinType);
            this.gEK.onChangeSkinType();
            this.gEK.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.gEK != null) {
                this.gEK.dettachView(this.mRootView);
                this.gEK = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.gEF != null) {
            this.gEF.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void ab(ArrayList<ALaCharmData> arrayList) {
        this.gEJ.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bUr() {
        this.gEJ.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.bns, this.aGk, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void aA(String str, boolean z) {
        if (this.gEJ != null) {
            this.gEJ.aA(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.gEG, a.e.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.gED, a.c.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.gEE, a.e.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.gEH, a.c.sdk_cp_cont_d, i);
        if (this.gEJ != null) {
            this.gEJ.setSkinType(i);
            this.gEJ.notifyDataSetChanged();
        }
        if (this.gEK != null) {
            this.gEK.setSkinType(i);
            this.gEK.onChangeSkinType();
        }
        if (this.gEF != null) {
            this.gEF.setSkinType(i);
        }
    }
}
