package com.baidu.tieba.ala.category;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
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
/* loaded from: classes3.dex */
public class AlaLiveTagActivity extends BaseActivity<AlaLiveTagActivity> {
    private String aZa;
    private CommonEmptyView baR;
    private BdGridView fii;
    private b fyA;
    private e fyB;
    private View fyz;
    private String mLiveId;
    private NavigationBar mNavigationBar;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(a.h.activity_ala_live_tag);
        registerListener();
        initData();
        initView();
        loadData();
    }

    private void registerListener() {
    }

    private void initData() {
        this.aZa = getIntent().getStringExtra("anchor_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.fyA = new b(getPageContext(), this.aZa, this.mLiveId);
        this.fyA.a(new b.a() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.1
            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bvA() {
                AlaLiveTagActivity.this.fyB.setTagList(AlaLiveTagActivity.this.fyA.getTagList());
                AlaLiveTagActivity.this.fyz.setVisibility(0);
                AlaLiveTagActivity.this.bvz();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void aE(int i, String str) {
                AlaLiveTagActivity.this.btR();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bvB() {
                AlaLiveTagActivity.this.showToast(a.i.ala_live_tag_commit_success);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913203));
                AlaLiveTagActivity.this.finish();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bvC() {
                AlaLiveTagActivity.this.showToast(a.i.ala_live_tag_commit_fail);
            }
        });
        this.fyB = new e(getPageContext());
        this.fyB.a(new e.b() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.2
            @Override // com.baidu.tieba.ala.category.a.e.b
            public void bvD() {
                AlaLiveTagActivity.this.bvz();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvz() {
        if (ListUtils.isEmpty(this.fyB.bvE())) {
            this.fyz.setAlpha(0.3f);
            this.fyz.setClickable(false);
            return;
        }
        this.fyz.setAlpha(1.0f);
        this.fyz.setClickable(true);
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_live_tag_nav_bar);
        this.mRootView = findViewById(a.g.root_view);
        this.fii = (BdGridView) findViewById(a.g.live_tag_gridview);
        this.baR = (CommonEmptyView) findViewById(a.g.empty_view);
        this.fyz = findViewById(a.g.tag_commit_tv);
        this.fyz.setOnClickListener(this);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.i.ala_live_tag_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button), a.f.sdk_d_icon_return_n, a.f.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.d.sdk_cp_cont_i, a.d.sdk_cp_cont_i);
        this.fii.setAdapter((ListAdapter) this.fyB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.fyA.bvS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btR() {
        this.baR.reset();
        this.baR.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveTagActivity.this.loadData();
                AlaLiveTagActivity.this.baR.setVisibility(8);
                AlaLiveTagActivity.this.mRootView.setVisibility(0);
            }
        });
        this.baR.setTitle(a.i.sdk_net_fail_tip_rank);
        this.baR.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.baR.setVisibility(0);
        this.mRootView.setVisibility(8);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == a.g.tag_commit_tv) {
            List<String> bvE = this.fyB.bvE();
            Set<String> bvF = this.fyB.bvF();
            if (bvE != null && bvF != null && bvE.size() == bvF.size() && bvF.containsAll(bvE)) {
                finish();
            } else {
                this.fyA.bE(bvE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
