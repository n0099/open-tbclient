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
    private String aFp;
    private boolean bkL;
    private TextView gwn;
    private ImageView gwo;
    private TbListViewPullView gwp;
    private RelativeLayout gwq;
    private TextView gwr;
    private AlaCharmDetailEmptyView gws;
    private com.baidu.tieba.ala.charm.view.a gwt;
    private LoadingView gwu;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener gwv = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.gwr || view == b.this.gwq) {
                if (b.this.gwr.getVisibility() == 0) {
                    b.this.gwr.setVisibility(8);
                }
            } else if (view == b.this.gwo) {
                if (b.this.gwr.getVisibility() == 8) {
                    b.this.gwr.setVisibility(0);
                } else {
                    b.this.gwr.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener gww = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gwt != null) {
                    b.this.b(b.this.gwt.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener gwx = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gwt != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.gwt.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.gwt.notifyDataSetChanged();
                    f fVar = new f();
                    fVar.setUserId(item.pay_userid);
                    fVar.setPortrait(item.portrait);
                    fVar.setPageId(b.this.mPageId);
                    fVar.setIsAttention(z ? false : true);
                    fVar.setFrom("source_charm_game_live");
                    com.baidu.live.view.a.Wx().a(item.pay_userid, fVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bkL = z;
        this.aFp = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_game_live_layout, (ViewGroup) null);
        this.gwq = (RelativeLayout) this.mRootView.findViewById(a.f.ala_charm_game_live_header_layout);
        this.gwq.setOnClickListener(this.gwv);
        this.gwn = (TextView) this.mRootView.findViewById(a.f.ala_charm_game_live_charm_value);
        this.gwr = (TextView) this.mRootView.findViewById(a.f.ala_charm_game_live_help_tips);
        this.gwr.setOnClickListener(this.gwv);
        this.gwo = (ImageView) this.mRootView.findViewById(a.f.ala_charm_game_live_help_img);
        this.gwo.setOnClickListener(this.gwv);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.ala_charm_game_live_detail_list);
        this.gwt = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.gwt.n(this.gwx);
        this.gwt.o(this.gww);
        this.mListView.setAdapter((ListAdapter) this.gwt);
        this.gws = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.gws.setParams(a.e.sdk_emotion07, -1, a.h.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.gws);
        this.gwp = new TbListViewPullView(this.mPageContext);
        this.gwp.setTag(this.mPageContext.getUniqueId());
        this.gwp.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.gwp);
    }

    public void setCharmValue(String str) {
        String format = String.format(this.mPageContext.getString(a.h.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.gwn != null) {
            this.gwn.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.gwu == null) {
            this.gwu = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds248));
            this.gwu.setSkinType(this.mSkinType);
            this.gwu.onChangeSkinType();
            this.gwu.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.gwu != null) {
                this.gwu.dettachView(this.mRootView);
                this.gwu = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.gwp != null) {
            this.gwp.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void aa(ArrayList<ALaCharmData> arrayList) {
        this.gwt.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bRo() {
        this.gwt.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.bkL, this.aFp, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void az(String str, boolean z) {
        if (this.gwt != null) {
            this.gwt.az(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.gwq, a.e.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.gwn, a.c.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.gwo, a.e.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.gwr, a.c.sdk_cp_cont_d, i);
        if (this.gwt != null) {
            this.gwt.setSkinType(i);
            this.gwt.notifyDataSetChanged();
        }
        if (this.gwu != null) {
            this.gwu.setSkinType(i);
            this.gwu.onChangeSkinType();
        }
        if (this.gwp != null) {
            this.gwp.setSkinType(i);
        }
    }
}
