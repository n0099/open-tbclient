package com.baidu.tieba.ala.category;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.category.a.e;
import com.baidu.tieba.ala.category.c.b;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class AlaLiveTagActivity extends BaseActivity<AlaLiveTagActivity> {
    private String aWr;
    private CommonEmptyView aYj;
    private BdGridView eXK;
    private View fnl;
    private b fnm;
    private e fnn;
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
        this.aWr = getIntent().getStringExtra("anchor_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.fnm = new b(getPageContext(), this.aWr, this.mLiveId);
        this.fnm.a(new b.a() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.1
            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bsF() {
                AlaLiveTagActivity.this.fnn.setTagList(AlaLiveTagActivity.this.fnm.getTagList());
                AlaLiveTagActivity.this.fnl.setVisibility(0);
                AlaLiveTagActivity.this.bsE();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void aC(int i, String str) {
                AlaLiveTagActivity.this.bqU();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bsG() {
                AlaLiveTagActivity.this.showToast(a.i.ala_live_tag_commit_success);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913203));
                AlaLiveTagActivity.this.finish();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bsH() {
                AlaLiveTagActivity.this.showToast(a.i.ala_live_tag_commit_fail);
            }
        });
        this.fnn = new e(getPageContext());
        this.fnn.a(new e.b() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.2
            @Override // com.baidu.tieba.ala.category.a.e.b
            public void bsI() {
                AlaLiveTagActivity.this.bsE();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsE() {
        if (ListUtils.isEmpty(this.fnn.bsJ())) {
            this.fnl.setAlpha(0.3f);
            this.fnl.setClickable(false);
            return;
        }
        this.fnl.setAlpha(1.0f);
        this.fnl.setClickable(true);
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_live_tag_nav_bar);
        this.mRootView = findViewById(a.g.root_view);
        this.eXK = (BdGridView) findViewById(a.g.live_tag_gridview);
        this.aYj = (CommonEmptyView) findViewById(a.g.empty_view);
        this.fnl = findViewById(a.g.tag_commit_tv);
        this.fnl.setOnClickListener(this);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.i.ala_live_tag_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button), a.f.sdk_d_icon_return_n, a.f.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.d.sdk_cp_cont_i, a.d.sdk_cp_cont_i);
        this.eXK.setAdapter((ListAdapter) this.fnn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.fnm.bsX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqU() {
        this.aYj.reset();
        this.aYj.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveTagActivity.this.loadData();
                AlaLiveTagActivity.this.aYj.setVisibility(8);
                AlaLiveTagActivity.this.mRootView.setVisibility(0);
            }
        });
        this.aYj.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aYj.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.aYj.setVisibility(0);
        this.mRootView.setVisibility(8);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == a.g.tag_commit_tv) {
            List<String> bsJ = this.fnn.bsJ();
            Set<String> bsK = this.fnn.bsK();
            if (bsJ != null && bsK != null && bsJ.size() == bsK.size() && bsK.containsAll(bsJ)) {
                finish();
            } else {
                this.fnm.bv(bsJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
