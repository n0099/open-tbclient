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
    private String aBO;
    private boolean bkm;
    private TextView gLK;
    private ImageView gLL;
    private TbListViewPullView gLM;
    private RelativeLayout gLN;
    private TextView gLO;
    private AlaCharmDetailEmptyView gLP;
    private com.baidu.tieba.ala.charm.view.a gLQ;
    private LoadingView gLR;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener gLS = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.gLO || view == b.this.gLN) {
                if (b.this.gLO.getVisibility() == 0) {
                    b.this.gLO.setVisibility(8);
                }
            } else if (view == b.this.gLL) {
                if (b.this.gLO.getVisibility() == 8) {
                    b.this.gLO.setVisibility(0);
                } else {
                    b.this.gLO.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener gLT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gLQ != null) {
                    b.this.b(b.this.gLQ.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener gLU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gLQ != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.gLQ.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.gLQ.notifyDataSetChanged();
                    f fVar = new f();
                    fVar.setUserId(item.pay_userid);
                    fVar.setPortrait(item.portrait);
                    fVar.setPageId(b.this.mPageId);
                    fVar.setIsAttention(z ? false : true);
                    fVar.setFrom("source_charm_game_live");
                    com.baidu.live.view.a.VF().a(item.pay_userid, fVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bkm = z;
        this.aBO = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_game_live_layout, (ViewGroup) null);
        this.gLN = (RelativeLayout) this.mRootView.findViewById(a.f.ala_charm_game_live_header_layout);
        this.gLN.setOnClickListener(this.gLS);
        this.gLK = (TextView) this.mRootView.findViewById(a.f.ala_charm_game_live_charm_value);
        this.gLO = (TextView) this.mRootView.findViewById(a.f.ala_charm_game_live_help_tips);
        this.gLO.setOnClickListener(this.gLS);
        this.gLL = (ImageView) this.mRootView.findViewById(a.f.ala_charm_game_live_help_img);
        this.gLL.setOnClickListener(this.gLS);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.ala_charm_game_live_detail_list);
        this.gLQ = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.gLQ.o(this.gLU);
        this.gLQ.p(this.gLT);
        this.mListView.setAdapter((ListAdapter) this.gLQ);
        this.gLP = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.gLP.setParams(a.e.sdk_emotion07, -1, a.h.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.gLP);
        this.gLM = new TbListViewPullView(this.mPageContext);
        this.gLM.setTag(this.mPageContext.getUniqueId());
        this.gLM.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.gLM);
    }

    public void FZ(String str) {
        String format = String.format(this.mPageContext.getString(a.h.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.gLK != null) {
            this.gLK.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.gLR == null) {
            this.gLR = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds248));
            this.gLR.setSkinType(this.mSkinType);
            this.gLR.onChangeSkinType();
            this.gLR.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.gLR != null) {
                this.gLR.dettachView(this.mRootView);
                this.gLR = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.gLM != null) {
            this.gLM.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void W(ArrayList<ALaCharmData> arrayList) {
        this.gLQ.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bTf() {
        this.gLQ.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.bkm, this.aBO, aLaCharmData.appId, aLaCharmData.user_name);
            alaPersonCardActivityConfig.setExtInfo(aLaCharmData.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }
    }

    public void aB(String str, boolean z) {
        if (this.gLQ != null) {
            this.gLQ.aB(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.gLN, a.e.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.gLK, a.c.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.gLL, a.e.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.gLO, a.c.sdk_cp_cont_d, i);
        if (this.gLQ != null) {
            this.gLQ.setSkinType(i);
            this.gLQ.notifyDataSetChanged();
        }
        if (this.gLR != null) {
            this.gLR.setSkinType(i);
            this.gLR.onChangeSkinType();
        }
        if (this.gLM != null) {
            this.gLM.setSkinType(i);
        }
    }
}
