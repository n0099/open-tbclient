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
    private String aGB;
    private boolean boZ;
    private TextView gQq;
    private ImageView gQr;
    private TbListViewPullView gQs;
    private RelativeLayout gQt;
    private TextView gQu;
    private AlaCharmDetailEmptyView gQv;
    private com.baidu.tieba.ala.charm.view.a gQw;
    private LoadingView gQx;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener gQy = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.gQu || view == b.this.gQt) {
                if (b.this.gQu.getVisibility() == 0) {
                    b.this.gQu.setVisibility(8);
                }
            } else if (view == b.this.gQr) {
                if (b.this.gQu.getVisibility() == 8) {
                    b.this.gQu.setVisibility(0);
                } else {
                    b.this.gQu.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener gQz = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gQw != null) {
                    b.this.b(b.this.gQw.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener gQA = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.gQw != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.gQw.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.gQw.notifyDataSetChanged();
                    f fVar = new f();
                    fVar.setUserId(item.pay_userid);
                    fVar.setPortrait(item.portrait);
                    fVar.setPageId(b.this.mPageId);
                    fVar.setIsAttention(z ? false : true);
                    fVar.setFrom("source_charm_game_live");
                    com.baidu.live.view.a.Zy().a(item.pay_userid, fVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.boZ = z;
        this.aGB = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_game_live_layout, (ViewGroup) null);
        this.gQt = (RelativeLayout) this.mRootView.findViewById(a.f.ala_charm_game_live_header_layout);
        this.gQt.setOnClickListener(this.gQy);
        this.gQq = (TextView) this.mRootView.findViewById(a.f.ala_charm_game_live_charm_value);
        this.gQu = (TextView) this.mRootView.findViewById(a.f.ala_charm_game_live_help_tips);
        this.gQu.setOnClickListener(this.gQy);
        this.gQr = (ImageView) this.mRootView.findViewById(a.f.ala_charm_game_live_help_img);
        this.gQr.setOnClickListener(this.gQy);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.ala_charm_game_live_detail_list);
        this.gQw = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.gQw.o(this.gQA);
        this.gQw.p(this.gQz);
        this.mListView.setAdapter((ListAdapter) this.gQw);
        this.gQv = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.gQv.setParams(a.e.sdk_emotion07, -1, a.h.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.gQv);
        this.gQs = new TbListViewPullView(this.mPageContext);
        this.gQs.setTag(this.mPageContext.getUniqueId());
        this.gQs.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.gQs);
    }

    public void Hk(String str) {
        String format = String.format(this.mPageContext.getString(a.h.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.gQq != null) {
            this.gQq.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.gQx == null) {
            this.gQx = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds248));
            this.gQx.setSkinType(this.mSkinType);
            this.gQx.onChangeSkinType();
            this.gQx.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.gQx != null) {
                this.gQx.dettachView(this.mRootView);
                this.gQx = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.gQs != null) {
            this.gQs.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void ab(ArrayList<ALaCharmData> arrayList) {
        this.gQw.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bWX() {
        this.gQw.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.boZ, this.aGB, aLaCharmData.appId, aLaCharmData.user_name);
            alaPersonCardActivityConfig.setExtInfo(aLaCharmData.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }
    }

    public void aB(String str, boolean z) {
        if (this.gQw != null) {
            this.gQw.aB(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.gQt, a.e.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.gQq, a.c.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.gQr, a.e.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.gQu, a.c.sdk_cp_cont_d, i);
        if (this.gQw != null) {
            this.gQw.setSkinType(i);
            this.gQw.notifyDataSetChanged();
        }
        if (this.gQx != null) {
            this.gQx.setSkinType(i);
            this.gQx.onChangeSkinType();
        }
        if (this.gQs != null) {
            this.gQs.setSkinType(i);
        }
    }
}
