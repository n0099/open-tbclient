package com.baidu.tieba.homepage.lowFlows.e;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.lowFlows.LowFlowsActivity;
import com.baidu.tieba.homepage.lowFlows.a;
import com.baidu.tieba.homepage.lowFlows.a.d;
import com.baidu.tieba.homepage.lowFlows.d.b;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener, f, a.c {
    private BdTypeRecyclerView XW;
    private AppBarLayout ZM;
    private String eTL;
    private TbPageContext eUY;
    private View fLW;
    private LowFlowsActivity khF;
    private d khH;
    private ImageView khI;
    private ImageView khJ;
    private CollapsingToolbarLayout khK;
    private View khL;
    private View khM;
    private TextView khN;
    private RelativeLayout khO;
    private ImageView mBackImageView;
    private String mLFUser;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private TextView mTitle;
    private String mTaskId = "";
    private int mSkinType = 3;
    private AppBarLayout.OnOffsetChangedListener jjN = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.lowFlows.e.a.1
        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            int totalScrollRange = appBarLayout.getTotalScrollRange() - a.this.getNavigationBarHeight();
            if (totalScrollRange > 0) {
                float abs = Math.abs(i * 1.0f) / totalScrollRange;
                if (Float.compare(abs, 1.0f) > 0) {
                    abs = 1.0f;
                }
                if (a.this.mNavigationBar == null || abs != 1.0f) {
                    WebPManager.a(a.this.mBackImageView, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                    if (a.this.mTitle != null) {
                        a.this.mTitle.setAlpha(0.0f);
                    }
                    if (a.this.mNavigationBar.getBarBgView() != null) {
                        a.this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                        return;
                    }
                    return;
                }
                if (a.this.mNavigationBar.getBarBgView() != null) {
                    a.this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                }
                if (a.this.mTitle != null) {
                    a.this.mTitle.setAlpha(1.0f);
                }
                WebPManager.a(a.this.mBackImageView, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    };
    private a.b khG = new com.baidu.tieba.homepage.lowFlows.c.a(this);

    public a(TbPageContext tbPageContext) {
        this.eUY = tbPageContext;
        this.khF = (LowFlowsActivity) tbPageContext.getPageActivity();
        cwA();
        init();
    }

    private void cwA() {
        Intent intent;
        if (this.eUY != null && this.eUY.getPageActivity() != null && (intent = this.eUY.getPageActivity().getIntent()) != null) {
            this.eTL = intent.getStringExtra(LowFlowsActivityConfig.TAB_CODE);
            this.mLFUser = intent.getStringExtra(LowFlowsActivityConfig.LF_USER);
            this.mTaskId = intent.getStringExtra(LowFlowsActivityConfig.LF_USER_TASKID);
        }
    }

    private void init() {
        if (this.eUY != null && this.eUY.getPageActivity() != null) {
            this.eUY.getPageActivity().setContentView(getRootView());
            this.khI = (ImageView) getRootView().findViewById(R.id.header_img);
            this.khJ = (ImageView) getRootView().findViewById(R.id.header_shadow);
            this.mNavigationBar = (NavigationBar) getRootView().findViewById(R.id.lf_navigation_bar);
            this.XW = (BdTypeRecyclerView) getRootView().findViewById(R.id.more_treasure_trove_content);
            this.XW.setLayoutManager(new LinearLayoutManager(this.eUY.getPageActivity()));
            this.XW.setFadingEdgeLength(0);
            Md(this.eTL);
            this.ZM = (AppBarLayout) getRootView().findViewById(R.id.lf_app_bar_layout);
            this.ZM.addOnOffsetChangedListener(this.jjN);
            this.khK = (CollapsingToolbarLayout) getRootView().findViewById(R.id.lf_collapse_layout);
            this.khL = getRootView().findViewById(R.id.net_loading_view);
            this.khM = getRootView().findViewById(R.id.net_refresh_view);
            cQV();
            this.khH = new d(this.eUY, this.XW);
            this.khH.setPageUniqueId(getBdUniqueId());
            this.khH.setOnItemCoverListener(this);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.c
    public void loadData() {
        if (this.khM != null && this.khM.getParent() != null && this.khF != null) {
            this.khF.hideNetRefreshView(this.khM);
            this.khM.setVisibility(8);
        }
        if (this.XW != null && this.XW.getParent() != null) {
            this.XW.setVisibility(8);
        }
        if (this.khL != null && this.khF != null) {
            this.khL.setVisibility(0);
            this.khF.showLoadingView(this.khL);
        }
        if (this.khJ != null && this.khJ.getVisibility() == 0) {
            this.khJ.setVisibility(8);
        }
        if (this.khG != null) {
            this.khG.b(getBdUniqueId(), this.eTL, this.mLFUser, this.mTaskId);
        }
    }

    public void Mc(String str) {
        this.fLW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.mBackImageView = (ImageView) this.fLW.findViewById(R.id.widget_navi_back_button);
        this.mTitle = this.mNavigationBar.getCenterText();
        this.mNavigationBar.setCenterTextTitle(str);
    }

    public void Md(String str) {
        Drawable[] Ma = b.Ma(str);
        if (Ma != null) {
            this.khI.setImageDrawable(Ma[0]);
            this.khJ.setImageDrawable(Ma[1]);
        }
        Mc(b.Mb(str));
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.c
    public void setData(List<n> list) {
        if (this.khL != null && this.khF != null && this.khL.getParent() != null) {
            this.khF.hideLoadingView(this.khL);
            this.khL.setVisibility(8);
        }
        if (this.XW != null) {
            this.XW.setVisibility(0);
        }
        if (this.khJ != null && this.khJ.getVisibility() == 8) {
            this.khJ.setVisibility(0);
        }
        for (n nVar : list) {
            if (nVar instanceof ca) {
                ((ca) nVar).bln().eTL = this.eTL;
            }
        }
        if (this.khH != null) {
            this.khH.setData(list);
        }
        this.XW.setFooterView(this.khO);
    }

    private void cQV() {
        if (this.eUY != null) {
            int dimens = l.getDimens(this.eUY.getPageActivity(), R.dimen.M_H_X008);
            this.khO = new RelativeLayout(this.eUY.getPageActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            this.khO.setPadding(0, dimens, 0, dimens);
            this.khO.setLayoutParams(layoutParams);
            this.khN = new TextView(this.eUY.getPageActivity());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            this.khN.setLayoutParams(layoutParams2);
            this.khN.setText(R.string.lf_footer_no_more);
            this.khN.setBackgroundColor(0);
            this.khO.addView(this.khN);
        }
    }

    public View getRootView() {
        if (this.mRootView == null && this.eUY != null) {
            this.mRootView = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.activity_low_flows, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private BdUniqueId getBdUniqueId() {
        if (this.eUY != null) {
            return this.eUY.getUniqueId();
        }
        return null;
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            c.br(this.mTitle).oa(R.string.F_X02).nZ(R.dimen.T_X05).nY(R.color.CAM_X0105);
            this.mNavigationBar.getBarBgView().setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            this.mRootView.setBackgroundColor(ap.getColor(R.color.CAM_X0209));
            Drawable[] Ma = b.Ma(this.eTL);
            if (Ma != null) {
                this.khI.setImageDrawable(Ma[0]);
                this.khJ.setImageDrawable(Ma[1]);
            }
            this.khO.setBackgroundColor(ap.getColor(R.color.CAM_X0209));
            c.br(this.khN).nZ(R.dimen.T_X08).nY(R.color.CAM_X0109);
            if (this.khH != null) {
                this.khH.notifyDataSetChanged();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.c
    public void BU(int i) {
        if (this.khL != null && this.khL.getParent() != null && this.khF != null) {
            this.khF.hideLoadingView(this.khL);
            this.khL.setVisibility(8);
        }
        if (this.khF != null && this.khM != null) {
            this.khM.setVisibility(0);
            this.khF.showNetRefreshView(this.khM, "");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eUY != null && view.getId() == R.id.navigationBarGoBack && this.eUY.getPageActivity() != null) {
            this.eUY.getPageActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    @Override // com.baidu.tbadk.h.f
    public void a(View view, Object obj, int i, long j) {
        com.baidu.tieba.homepage.lowFlows.d.a.aK("c14084", StringUtils.isNull(this.mTaskId) ? "0" : TbSingleton.getInstance().getLFUserTaskId(), this.eTL);
    }

    @Override // com.baidu.tbadk.h.f
    public void b(View view, Object obj, int i, long j) {
    }
}
