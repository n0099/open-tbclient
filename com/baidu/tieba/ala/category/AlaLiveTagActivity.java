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
/* loaded from: classes7.dex */
public class AlaLiveTagActivity extends BaseActivity<AlaLiveTagActivity> {
    private String ber;
    private CommonEmptyView bgl;
    private View fOX;
    private b fOY;
    private e fOZ;
    private BdGridView fyL;
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
        this.ber = getIntent().getStringExtra("anchor_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.fOY = new b(getPageContext(), this.ber, this.mLiveId);
        this.fOY.a(new b.a() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.1
            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bHN() {
                AlaLiveTagActivity.this.fOZ.setTagList(AlaLiveTagActivity.this.fOY.getTagList());
                AlaLiveTagActivity.this.fOX.setVisibility(0);
                AlaLiveTagActivity.this.bHM();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void aE(int i, String str) {
                AlaLiveTagActivity.this.bGa();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bHO() {
                AlaLiveTagActivity.this.showToast(a.i.ala_live_tag_commit_success);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913203));
                AlaLiveTagActivity.this.finish();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bHP() {
                AlaLiveTagActivity.this.showToast(a.i.ala_live_tag_commit_fail);
            }
        });
        this.fOZ = new e(getPageContext());
        this.fOZ.a(new e.b() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.2
            @Override // com.baidu.tieba.ala.category.a.e.b
            public void bHQ() {
                AlaLiveTagActivity.this.bHM();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHM() {
        if (ListUtils.isEmpty(this.fOZ.bHR())) {
            this.fOX.setAlpha(0.3f);
            this.fOX.setClickable(false);
            return;
        }
        this.fOX.setAlpha(1.0f);
        this.fOX.setClickable(true);
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_live_tag_nav_bar);
        this.mRootView = findViewById(a.g.root_view);
        this.fyL = (BdGridView) findViewById(a.g.live_tag_gridview);
        this.bgl = (CommonEmptyView) findViewById(a.g.empty_view);
        this.fOX = findViewById(a.g.tag_commit_tv);
        this.fOX.setOnClickListener(this);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.i.ala_live_tag_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button), a.f.sdk_d_icon_return_n, a.f.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.d.sdk_cp_cont_i, a.d.sdk_cp_cont_i);
        this.fyL.setAdapter((ListAdapter) this.fOZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.fOY.bIf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGa() {
        this.bgl.reset();
        this.bgl.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveTagActivity.this.loadData();
                AlaLiveTagActivity.this.bgl.setVisibility(8);
                AlaLiveTagActivity.this.mRootView.setVisibility(0);
            }
        });
        this.bgl.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bgl.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.bgl.setVisibility(0);
        this.mRootView.setVisibility(8);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == a.g.tag_commit_tv) {
            List<String> bHR = this.fOZ.bHR();
            Set<String> bHS = this.fOZ.bHS();
            if (bHR != null && bHS != null && bHR.size() == bHS.size() && bHS.containsAll(bHR)) {
                finish();
            } else {
                this.fOY.bJ(bHR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
