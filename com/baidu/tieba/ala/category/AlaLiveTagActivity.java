package com.baidu.tieba.ala.category;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.category.a.e;
import com.baidu.tieba.ala.category.c.b;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class AlaLiveTagActivity extends BaseActivity<AlaLiveTagActivity> {
    private String bnP;
    private CommonEmptyView bpJ;
    private BdGridView gdr;
    private View guv;
    private b guw;
    private e gux;
    private String mLiveId;
    private NavigationBar mNavigationBar;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (BdBaseApplication.getInst() == null) {
            finish();
            return;
        }
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(a.g.activity_ala_live_tag);
        registerListener();
        initData();
        initView();
        loadData();
    }

    private void registerListener() {
    }

    private void initData() {
        this.bnP = getIntent().getStringExtra("anchor_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.guw = new b(getPageContext(), this.bnP, this.mLiveId);
        this.guw.a(new b.a() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.1
            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bQI() {
                AlaLiveTagActivity.this.gux.setTagList(AlaLiveTagActivity.this.guw.getTagList());
                AlaLiveTagActivity.this.guv.setVisibility(0);
                AlaLiveTagActivity.this.bQH();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void aU(int i, String str) {
                AlaLiveTagActivity.this.bPe();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bQJ() {
                AlaLiveTagActivity.this.showToast(a.h.ala_live_tag_commit_success);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913203));
                AlaLiveTagActivity.this.finish();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bQK() {
                AlaLiveTagActivity.this.showToast(a.h.ala_live_tag_commit_fail);
            }
        });
        this.gux = new e(getPageContext());
        this.gux.a(new e.b() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.2
            @Override // com.baidu.tieba.ala.category.a.e.b
            public void bQL() {
                AlaLiveTagActivity.this.bQH();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQH() {
        if (ListUtils.isEmpty(this.gux.bQM())) {
            this.guv.setAlpha(0.3f);
            this.guv.setClickable(false);
            return;
        }
        this.guv.setAlpha(1.0f);
        this.guv.setClickable(true);
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) findViewById(a.f.ala_live_tag_nav_bar);
        this.mRootView = findViewById(a.f.root_view);
        this.gdr = (BdGridView) findViewById(a.f.live_tag_gridview);
        this.bpJ = (CommonEmptyView) findViewById(a.f.empty_view);
        this.guv = findViewById(a.f.tag_commit_tv);
        this.guv.setOnClickListener(this);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.h.ala_live_tag_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.f.widget_navi_back_button), a.e.sdk_d_icon_return_n, a.e.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.c.sdk_cp_cont_i, a.c.sdk_cp_cont_i);
        this.gdr.setAdapter((ListAdapter) this.gux);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.guw.bRa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPe() {
        this.bpJ.reset();
        this.bpJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveTagActivity.this.loadData();
                AlaLiveTagActivity.this.bpJ.setVisibility(8);
                AlaLiveTagActivity.this.mRootView.setVisibility(0);
            }
        });
        this.bpJ.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bpJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.bpJ.setVisibility(0);
        this.mRootView.setVisibility(8);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == a.f.tag_commit_tv) {
            List<String> bQM = this.gux.bQM();
            Set<String> bQN = this.gux.bQN();
            if (bQM != null && bQN != null && bQM.size() == bQN.size() && bQN.containsAll(bQM)) {
                finish();
            } else {
                this.guw.ci(bQM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
