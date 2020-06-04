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
import com.baidu.live.data.d;
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
    private boolean aSw;
    private String aSx;
    private TextView fpb;
    private ImageView fpc;
    private TbListViewPullView fpd;
    private RelativeLayout fpe;
    private TextView fpf;
    private AlaCharmDetailEmptyView fpg;
    private com.baidu.tieba.ala.charm.view.a fph;
    private LoadingView fpi;
    private String mGroupId;
    private BdListView mListView;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private View mRootView;
    private boolean mIsLoading = false;
    private int mSkinType = 0;
    private View.OnClickListener fpj = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == b.this.fpf || view == b.this.fpe) {
                if (b.this.fpf.getVisibility() == 0) {
                    b.this.fpf.setVisibility(8);
                }
            } else if (view == b.this.fpc) {
                if (b.this.fpf.getVisibility() == 8) {
                    b.this.fpf.setVisibility(0);
                } else {
                    b.this.fpf.setVisibility(8);
                }
            }
        }
    };
    private View.OnClickListener fpk = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.fph != null) {
                    b.this.b(b.this.fph.getItem(intValue));
                }
            }
        }
    };
    private View.OnClickListener fpl = new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ALaCharmData item;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (b.this.fph != null && ViewHelper.checkUpIsLogin(b.this.mPageContext.getPageActivity()) && (item = b.this.fph.getItem(intValue)) != null && item.pay_userid != null) {
                    boolean z = item.follow_status != 0;
                    item.follow_status = z ? 0 : 1;
                    b.this.fph.notifyDataSetChanged();
                    d dVar = new d();
                    dVar.setUserId(item.pay_userid);
                    dVar.setPortrait(item.portrait);
                    dVar.setPageId(b.this.mPageId);
                    dVar.setIsAttention(z ? false : true);
                    dVar.setFrom("source_charm_game_live");
                    com.baidu.live.view.a.Jl().a(item.pay_userid, dVar);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, String str, String str2, boolean z, String str3) {
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId;
        this.mGroupId = str;
        this.mLiveId = str2;
        this.aSw = z;
        this.aSx = str3;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_layout, (ViewGroup) null);
        this.fpe = (RelativeLayout) this.mRootView.findViewById(a.g.ala_charm_game_live_header_layout);
        this.fpe.setOnClickListener(this.fpj);
        this.fpb = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_charm_value);
        this.fpf = (TextView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_tips);
        this.fpf.setOnClickListener(this.fpj);
        this.fpc = (ImageView) this.mRootView.findViewById(a.g.ala_charm_game_live_help_img);
        this.fpc.setOnClickListener(this.fpj);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_charm_game_live_detail_list);
        this.fph = new com.baidu.tieba.ala.charm.view.a(this.mPageContext, 2);
        this.fph.l(this.fpl);
        this.fph.m(this.fpk);
        this.mListView.setAdapter((ListAdapter) this.fph);
        this.fpg = (AlaCharmDetailEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.fpg.setParams(a.f.sdk_emotion07, -1, a.i.ala_charm_empty_msg);
        this.mListView.setEmptyView(this.fpg);
        this.fpd = new TbListViewPullView(this.mPageContext);
        this.fpd.setTag(this.mPageContext.getUniqueId());
        this.fpd.setSkinType(this.mSkinType);
        this.mListView.setPullRefresh(this.fpd);
    }

    public void Bw(String str) {
        String format = String.format(this.mPageContext.getString(a.i.ala_charm_game_live_name), StringHelper.formatTosepara(JavaTypesHelper.toLong(str, 0L)));
        if (this.fpb != null) {
            this.fpb.setText(format);
        }
    }

    public void showLoadingView() {
        if (this.mRootView != null && !this.mIsLoading && this.fpi == null) {
            this.fpi = new LoadingView(this.mPageContext.getPageActivity(), this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds248));
            this.fpi.setSkinType(this.mSkinType);
            this.fpi.onChangeSkinType();
            this.fpi.attachView(this.mRootView, false);
            this.mIsLoading = true;
        }
    }

    public void hideLoadingView() {
        if (this.mIsLoading) {
            if (this.fpi != null) {
                this.fpi.dettachView(this.mRootView);
                this.fpi = null;
            }
            this.mIsLoading = false;
        }
    }

    public void a(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        if (this.fpd != null) {
            this.fpd.setListPullRefreshListener(listPullRefreshListener);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void T(ArrayList<ALaCharmData> arrayList) {
        this.fph.setData(arrayList);
    }

    public void completePullRefresh() {
        this.mListView.completePullRefresh();
    }

    public void bth() {
        this.fph.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null && aLaCharmData.pay_userid != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aLaCharmData.pay_userid, aLaCharmData.user_name, aLaCharmData.portrait, aLaCharmData.sex, aLaCharmData.level_id, null, null, 0L, aLaCharmData.fans_count, aLaCharmData.follow_count, aLaCharmData.user_status, this.mGroupId, this.mLiveId, this.aSw, this.aSx, aLaCharmData.appId, aLaCharmData.user_name, "")));
        }
    }

    public void ap(String str, boolean z) {
        if (this.fph != null) {
            this.fph.ap(str, z);
        }
    }

    public void onSkinTypeChanged(int i) {
        this.mSkinType = i;
        SkinManager.setBackgroundResource(this.fpe, a.f.ala_charm_game_live_header_bg, i);
        SkinManager.setViewTextColor(this.fpb, a.d.sdk_cp_cont_f, i);
        SkinManager.setImageResource(this.fpc, a.f.sdk_icon_follow_explain_n, i);
        SkinManager.setViewTextColor(this.fpf, a.d.sdk_cp_cont_d, i);
        if (this.fph != null) {
            this.fph.setSkinType(i);
            this.fph.notifyDataSetChanged();
        }
        if (this.fpi != null) {
            this.fpi.setSkinType(i);
            this.fpi.onChangeSkinType();
        }
        if (this.fpd != null) {
            this.fpd.setSkinType(i);
        }
    }
}
