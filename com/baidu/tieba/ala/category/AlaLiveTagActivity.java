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
    private String bme;
    private CommonEmptyView bnY;
    private BdGridView gcY;
    private View guc;
    private b gud;
    private e gue;
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
        this.bme = getIntent().getStringExtra("anchor_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.gud = new b(getPageContext(), this.bme, this.mLiveId);
        this.gud.a(new b.a() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.1
            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bQb() {
                AlaLiveTagActivity.this.gue.setTagList(AlaLiveTagActivity.this.gud.getTagList());
                AlaLiveTagActivity.this.guc.setVisibility(0);
                AlaLiveTagActivity.this.bQa();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void aS(int i, String str) {
                AlaLiveTagActivity.this.bOx();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bQc() {
                AlaLiveTagActivity.this.showToast(a.h.ala_live_tag_commit_success);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913203));
                AlaLiveTagActivity.this.finish();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bQd() {
                AlaLiveTagActivity.this.showToast(a.h.ala_live_tag_commit_fail);
            }
        });
        this.gue = new e(getPageContext());
        this.gue.a(new e.b() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.2
            @Override // com.baidu.tieba.ala.category.a.e.b
            public void bQe() {
                AlaLiveTagActivity.this.bQa();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQa() {
        if (ListUtils.isEmpty(this.gue.bQf())) {
            this.guc.setAlpha(0.3f);
            this.guc.setClickable(false);
            return;
        }
        this.guc.setAlpha(1.0f);
        this.guc.setClickable(true);
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) findViewById(a.f.ala_live_tag_nav_bar);
        this.mRootView = findViewById(a.f.root_view);
        this.gcY = (BdGridView) findViewById(a.f.live_tag_gridview);
        this.bnY = (CommonEmptyView) findViewById(a.f.empty_view);
        this.guc = findViewById(a.f.tag_commit_tv);
        this.guc.setOnClickListener(this);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.h.ala_live_tag_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.f.widget_navi_back_button), a.e.sdk_d_icon_return_n, a.e.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.c.sdk_cp_cont_i, a.c.sdk_cp_cont_i);
        this.gcY.setAdapter((ListAdapter) this.gue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.gud.bQt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOx() {
        this.bnY.reset();
        this.bnY.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveTagActivity.this.loadData();
                AlaLiveTagActivity.this.bnY.setVisibility(8);
                AlaLiveTagActivity.this.mRootView.setVisibility(0);
            }
        });
        this.bnY.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bnY.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.bnY.setVisibility(0);
        this.mRootView.setVisibility(8);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == a.f.tag_commit_tv) {
            List<String> bQf = this.gue.bQf();
            Set<String> bQg = this.gue.bQg();
            if (bQf != null && bQg != null && bQf.size() == bQg.size() && bQg.containsAll(bQf)) {
                finish();
            } else {
                this.gud.ci(bQf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
