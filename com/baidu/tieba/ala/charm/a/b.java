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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.core.view.TbListViewPullView;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
import com.baidu.tieba.ala.charm.view.AlaCharmDetailEmptyView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b {
    private boolean asR;
    private String asS;
    private TextView ewA;
    private AlaCharmDetailEmptyView ewB;
    private com.baidu.tieba.ala.charm.view.a ewC;
    private LoadingView ewD;
    private TextView eww;
    private ImageView ewx;
    private TbListViewPullView ewy;
    private RelativeLayout ewz;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener ewE = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.ewA || view == b.this.ewz) {
                if (b.this.ewA.getVisibility() == 0) {
                    b.this.ewA.setVisibility(8);
                }
            } else if (view == b.this.ewx) {
                if (b.this.ewA.getVisibility() == 8) {
                    b.this.ewA.setVisibility(0);
                } else {
                    b.this.ewA.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener evU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.ewC != null) {
                    b.this.a(b.this.ewC.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener ewF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.ewC != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.ewC.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.ewC.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(item.pay_userid);
                    bVar.setPortrait(item.portrait);
                    bVar.setPageId(b.this.mPageId);
                    bVar.setIsAttention(z ? false : true);
                    com.baidu.live.view.a.Bh().a(item.pay_userid, bVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.asR = z;
        this.asS = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.ewz = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.ewz.setOnClickListener(this.ewE);
        this.eww = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.ewA = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.ewA.setOnClickListener(this.ewE);
        this.ewx = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.ewx.setOnClickListener(this.ewE);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.ewC = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.ewC.m(this.ewF);
        this.ewC.n(this.evU);
        this.mListView.setAdapter((ListAdapter) this.ewC);
        this.ewB = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.ewB.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.ewB);
        this.ewy = new TbListViewPullView(this.mPageContext);
        this.ewy.setTag(this.mPageContext.getUniqueId());
        this.ewy.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.ewy);
    }

    public void yd(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.eww != null) {
            this.eww.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.ewD == null) {
            this.ewD = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.ewD.setSkinType(this.mSkinType);
            this.ewD.onChangeSkinType();
            this.ewD.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.ewD != null) {
                this.ewD.dettachView(this.mRootView);
                this.ewD = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.ewy != null) {
            this.ewy.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void S(ArrayList<ALaCharmData> arrayList) {
        this.ewC.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bdV() {
        this.ewC.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.asR, this.asS, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void X(String str, boolean z) {
        if (this.ewC != null) {
            this.ewC.X(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.ewz, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.eww, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.ewx, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.ewA, a.d.sdk_cp_cont_d, i);
        if (this.ewC != null) {
            this.ewC.setSkinType(i);
            this.ewC.notifyDataSetChanged();
        }
        if (this.ewD != null) {
            this.ewD.setSkinType(i);
            this.ewD.onChangeSkinType();
        }
        if (this.ewy != null) {
            this.ewy.setSkinType(i);
        }
    }
}
