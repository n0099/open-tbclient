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
    private TextView gOq;
    private ImageView gOr;
    private TbListViewPullView gOs;
    private RelativeLayout gOt;
    private TextView gOu;
    private AlaCharmDetailEmptyView gOv;
    private com.baidu.tieba.ala.charm.view.a gOw;
    private LoadingView gOx;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener gOy = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.gOu || view == b.this.gOt) {
                if (b.this.gOu.getVisibility() == 0) {
                    b.this.gOu.setVisibility(8);
                }
            } else if (view == b.this.gOr) {
                if (b.this.gOu.getVisibility() == 8) {
                    b.this.gOu.setVisibility(0);
                } else {
                    b.this.gOu.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener gOz = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gOw != null) {
                    b.this.b(b.this.gOw.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener gOA = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gOw != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.gOw.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.gOw.notifyDataSetChanged();
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
        this.gOt = (RelativeLayout) this.mRootView.findViewById(a.f.ala_charm_game_live_header_layout);
        this.gOt.setOnClickListener(this.gOy);
        this.gOq = (TextView) this.mRootView.findViewById(a.f.ala_charm_game_live_charm_value);
        this.gOu = (TextView) this.mRootView.findViewById(a.f.ala_charm_game_live_help_tips);
        this.gOu.setOnClickListener(this.gOy);
        this.gOr = (ImageView) this.mRootView.findViewById(a.f.ala_charm_game_live_help_img);
        this.gOr.setOnClickListener(this.gOy);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.ala_charm_game_live_detail_list);
        this.gOw = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.gOw.o(this.gOA);
        this.gOw.p(this.gOz);
        this.mListView.setAdapter((ListAdapter) this.gOw);
        this.gOv = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.gOv.setParams(a.e.sdk_emotion07, -1, a.h.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.gOv);
        this.gOs = new TbListViewPullView(this.mPageContext);
        this.gOs.setTag(this.mPageContext.getUniqueId());
        this.gOs.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.gOs);
    }

    public void Gy(String str) {
        String format = String.format(this.mPageContext.getString(a.h.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.gOq != null) {
            this.gOq.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.gOx == null) {
            this.gOx = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds248));
            this.gOx.setSkinType(this.mSkinType);
            this.gOx.onChangeSkinType();
            this.gOx.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.gOx != null) {
                this.gOx.dettachView(this.mRootView);
                this.gOx = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.gOs != null) {
            this.gOs.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void V(ArrayList<ALaCharmData> arrayList) {
        this.gOw.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bTI() {
        this.gOw.notifyDataSetChanged();
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
        if (this.gOw != null) {
            this.gOw.aA(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.gOt, a.e.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.gOq, a.c.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.gOr, a.e.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.gOu, a.c.sdk_cp_cont_d, i);
        if (this.gOw != null) {
            this.gOw.setSkinType(i);
            this.gOw.notifyDataSetChanged();
        }
        if (this.gOx != null) {
            this.gOx.setSkinType(i);
            this.gOx.onChangeSkinType();
        }
        if (this.gOs != null) {
            this.gOs.setSkinType(i);
        }
    }
}
