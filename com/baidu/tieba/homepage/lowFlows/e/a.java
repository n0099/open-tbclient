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
    private BdTypeRecyclerView Zq;
    private AppBarLayout abf;
    private String eVm;
    private TbPageContext eWx;
    private View fNw;
    private LowFlowsActivity kjI;
    private d kjK;
    private ImageView kjL;
    private ImageView kjM;
    private CollapsingToolbarLayout kjN;
    private View kjO;
    private View kjP;
    private TextView kjQ;
    private RelativeLayout kjR;
    private ImageView mBackImageView;
    private String mLFUser;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private TextView mTitle;
    private String mTaskId = "";
    private int mSkinType = 3;
    private AppBarLayout.OnOffsetChangedListener jlw = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.lowFlows.e.a.1
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
    private a.b kjJ = new com.baidu.tieba.homepage.lowFlows.c.a(this);

    public a(TbPageContext tbPageContext) {
        this.eWx = tbPageContext;
        this.kjI = (LowFlowsActivity) tbPageContext.getPageActivity();
        cwG();
        init();
    }

    private void cwG() {
        Intent intent;
        if (this.eWx != null && this.eWx.getPageActivity() != null && (intent = this.eWx.getPageActivity().getIntent()) != null) {
            this.eVm = intent.getStringExtra(LowFlowsActivityConfig.TAB_CODE);
            this.mLFUser = intent.getStringExtra(LowFlowsActivityConfig.LF_USER);
            this.mTaskId = intent.getStringExtra(LowFlowsActivityConfig.LF_USER_TASKID);
        }
    }

    private void init() {
        if (this.eWx != null && this.eWx.getPageActivity() != null) {
            this.eWx.getPageActivity().setContentView(getRootView());
            this.kjL = (ImageView) getRootView().findViewById(R.id.header_img);
            this.kjM = (ImageView) getRootView().findViewById(R.id.header_shadow);
            this.mNavigationBar = (NavigationBar) getRootView().findViewById(R.id.lf_navigation_bar);
            this.Zq = (BdTypeRecyclerView) getRootView().findViewById(R.id.more_treasure_trove_content);
            this.Zq.setLayoutManager(new LinearLayoutManager(this.eWx.getPageActivity()));
            this.Zq.setFadingEdgeLength(0);
            Mj(this.eVm);
            this.abf = (AppBarLayout) getRootView().findViewById(R.id.lf_app_bar_layout);
            this.abf.addOnOffsetChangedListener(this.jlw);
            this.kjN = (CollapsingToolbarLayout) getRootView().findViewById(R.id.lf_collapse_layout);
            this.kjO = getRootView().findViewById(R.id.net_loading_view);
            this.kjP = getRootView().findViewById(R.id.net_refresh_view);
            cRc();
            this.kjK = new d(this.eWx, this.Zq);
            this.kjK.setPageUniqueId(getBdUniqueId());
            this.kjK.setOnItemCoverListener(this);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.c
    public void loadData() {
        if (this.kjP != null && this.kjP.getParent() != null && this.kjI != null) {
            this.kjI.hideNetRefreshView(this.kjP);
            this.kjP.setVisibility(8);
        }
        if (this.Zq != null && this.Zq.getParent() != null) {
            this.Zq.setVisibility(8);
        }
        if (this.kjO != null && this.kjI != null) {
            this.kjO.setVisibility(0);
            this.kjI.showLoadingView(this.kjO);
        }
        if (this.kjM != null && this.kjM.getVisibility() == 0) {
            this.kjM.setVisibility(8);
        }
        if (this.kjJ != null) {
            this.kjJ.b(getBdUniqueId(), this.eVm, this.mLFUser, this.mTaskId);
        }
    }

    public void Mi(String str) {
        this.fNw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.mBackImageView = (ImageView) this.fNw.findViewById(R.id.widget_navi_back_button);
        this.mTitle = this.mNavigationBar.getCenterText();
        this.mNavigationBar.setCenterTextTitle(str);
    }

    public void Mj(String str) {
        Drawable[] Mg = b.Mg(str);
        if (Mg != null) {
            this.kjL.setImageDrawable(Mg[0]);
            this.kjM.setImageDrawable(Mg[1]);
        }
        Mi(b.Mh(str));
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.c
    public void setData(List<n> list) {
        if (this.kjO != null && this.kjI != null && this.kjO.getParent() != null) {
            this.kjI.hideLoadingView(this.kjO);
            this.kjO.setVisibility(8);
        }
        if (this.Zq != null) {
            this.Zq.setVisibility(0);
        }
        if (this.kjM != null && this.kjM.getVisibility() == 8) {
            this.kjM.setVisibility(0);
        }
        for (n nVar : list) {
            if (nVar instanceof ca) {
                ((ca) nVar).blp().eVm = this.eVm;
            }
        }
        if (this.kjK != null) {
            this.kjK.setData(list);
        }
        this.Zq.setFooterView(this.kjR);
    }

    private void cRc() {
        if (this.eWx != null) {
            int dimens = l.getDimens(this.eWx.getPageActivity(), R.dimen.M_H_X008);
            this.kjR = new RelativeLayout(this.eWx.getPageActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            this.kjR.setPadding(0, dimens, 0, dimens);
            this.kjR.setLayoutParams(layoutParams);
            this.kjQ = new TextView(this.eWx.getPageActivity());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            this.kjQ.setLayoutParams(layoutParams2);
            this.kjQ.setText(R.string.lf_footer_no_more);
            this.kjQ.setBackgroundColor(0);
            this.kjR.addView(this.kjQ);
        }
    }

    public View getRootView() {
        if (this.mRootView == null && this.eWx != null) {
            this.mRootView = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.activity_low_flows, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private BdUniqueId getBdUniqueId() {
        if (this.eWx != null) {
            return this.eWx.getUniqueId();
        }
        return null;
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.c
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            c.br(this.mTitle).ob(R.string.F_X02).oa(R.dimen.T_X05).nZ(R.color.CAM_X0105);
            this.mNavigationBar.getBarBgView().setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            this.mRootView.setBackgroundColor(ap.getColor(R.color.CAM_X0209));
            Drawable[] Mg = b.Mg(this.eVm);
            if (Mg != null) {
                this.kjL.setImageDrawable(Mg[0]);
                this.kjM.setImageDrawable(Mg[1]);
            }
            this.kjR.setBackgroundColor(ap.getColor(R.color.CAM_X0209));
            c.br(this.kjQ).oa(R.dimen.T_X08).nZ(R.color.CAM_X0109);
            if (this.kjK != null) {
                this.kjK.notifyDataSetChanged();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.homepage.lowFlows.a.c
    public void BX(int i) {
        if (this.kjO != null && this.kjO.getParent() != null && this.kjI != null) {
            this.kjI.hideLoadingView(this.kjO);
            this.kjO.setVisibility(8);
        }
        if (this.kjI != null && this.kjP != null) {
            this.kjP.setVisibility(0);
            this.kjI.showNetRefreshView(this.kjP, "");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eWx != null && view.getId() == R.id.navigationBarGoBack && this.eWx.getPageActivity() != null) {
            this.eWx.getPageActivity().finish();
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
        com.baidu.tieba.homepage.lowFlows.d.a.aK("c14084", StringUtils.isNull(this.mTaskId) ? "0" : TbSingleton.getInstance().getLFUserTaskId(), this.eVm);
    }

    @Override // com.baidu.tbadk.h.f
    public void b(View view, Object obj, int i, long j) {
    }
}
