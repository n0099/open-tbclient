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
/* loaded from: classes11.dex */
public class b {
    private String aDB;
    private boolean bnF;
    private TextView gOE;
    private ImageView gOF;
    private TbListViewPullView gOG;
    private RelativeLayout gOH;
    private TextView gOI;
    private AlaCharmDetailEmptyView gOJ;
    private com.baidu.tieba.ala.charm.view.a gOK;
    private LoadingView gOL;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener gOM = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.gOI || view == b.this.gOH) {
                if (b.this.gOI.getVisibility() == 0) {
                    b.this.gOI.setVisibility(8);
                }
            } else if (view == b.this.gOF) {
                if (b.this.gOI.getVisibility() == 8) {
                    b.this.gOI.setVisibility(0);
                } else {
                    b.this.gOI.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener gON = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gOK != null) {
                    b.this.b(b.this.gOK.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener gOO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gOK != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.gOK.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.gOK.notifyDataSetChanged();
                    f fVar = new f();
                    fVar.setUserId(item.pay_userid);
                    fVar.setPortrait(item.portrait);
                    fVar.setPageId(b.this.mPageId);
                    fVar.setIsAttention(z ? false : true);
                    fVar.setFrom("source_charm_game_live");
                    com.baidu.live.view.a.Xo().a(item.pay_userid, fVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bnF = z;
        this.aDB = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_game_live_layout, (ViewGroup) null);
        this.gOH = (RelativeLayout) this.mRootView.findViewById(a.f.ala_charm_game_live_header_layout);
        this.gOH.setOnClickListener(this.gOM);
        this.gOE = (TextView) this.mRootView.findViewById(a.f.ala_charm_game_live_charm_value);
        this.gOI = (TextView) this.mRootView.findViewById(a.f.ala_charm_game_live_help_tips);
        this.gOI.setOnClickListener(this.gOM);
        this.gOF = (ImageView) this.mRootView.findViewById(a.f.ala_charm_game_live_help_img);
        this.gOF.setOnClickListener(this.gOM);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.ala_charm_game_live_detail_list);
        this.gOK = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.gOK.o(this.gOO);
        this.gOK.p(this.gON);
        this.mListView.setAdapter((ListAdapter) this.gOK);
        this.gOJ = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.gOJ.setParams(a.e.sdk_emotion07, -1, a.h.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.gOJ);
        this.gOG = new TbListViewPullView(this.mPageContext);
        this.gOG.setTag(this.mPageContext.getUniqueId());
        this.gOG.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.gOG);
    }

    public void Gz(String str) {
        String format = String.format(this.mPageContext.getString(a.h.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.gOE != null) {
            this.gOE.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.gOL == null) {
            this.gOL = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds248));
            this.gOL.setSkinType(this.mSkinType);
            this.gOL.onChangeSkinType();
            this.gOL.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.gOL != null) {
                this.gOL.dettachView(this.mRootView);
                this.gOL = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.gOG != null) {
            this.gOG.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void V(ArrayList<ALaCharmData> arrayList) {
        this.gOK.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bTP() {
        this.gOK.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.bnF, this.aDB, aLaCharmData.appId, aLaCharmData.user_name);
            alaPersonCardActivityConfig.setExtInfo(aLaCharmData.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }
    }

    public void aA(String str, boolean z) {
        if (this.gOK != null) {
            this.gOK.aA(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.gOH, a.e.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.gOE, a.c.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.gOF, a.e.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.gOI, a.c.sdk_cp_cont_d, i);
        if (this.gOK != null) {
            this.gOK.setSkinType(i);
            this.gOK.notifyDataSetChanged();
        }
        if (this.gOL != null) {
            this.gOL.setSkinType(i);
            this.gOL.onChangeSkinType();
        }
        if (this.gOG != null) {
            this.gOG.setSkinType(i);
        }
    }
}
