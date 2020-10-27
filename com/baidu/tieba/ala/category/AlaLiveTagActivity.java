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
    private String bmv;
    private CommonEmptyView boq;
    private BdGridView fXA;
    private View goI;
    private b goJ;
    private e goK;
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
        setContentView(a.h.activity_ala_live_tag);
        registerListener();
        initData();
        initView();
        loadData();
    }

    private void registerListener() {
    }

    private void initData() {
        this.bmv = getIntent().getStringExtra("anchor_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.goJ = new b(getPageContext(), this.bmv, this.mLiveId);
        this.goJ.a(new b.a() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.1
            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bOi() {
                AlaLiveTagActivity.this.goK.setTagList(AlaLiveTagActivity.this.goJ.getTagList());
                AlaLiveTagActivity.this.goI.setVisibility(0);
                AlaLiveTagActivity.this.bOh();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void aQ(int i, String str) {
                AlaLiveTagActivity.this.bME();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bOj() {
                AlaLiveTagActivity.this.showToast(a.i.ala_live_tag_commit_success);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913203));
                AlaLiveTagActivity.this.finish();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bOk() {
                AlaLiveTagActivity.this.showToast(a.i.ala_live_tag_commit_fail);
            }
        });
        this.goK = new e(getPageContext());
        this.goK.a(new e.b() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.2
            @Override // com.baidu.tieba.ala.category.a.e.b
            public void bOl() {
                AlaLiveTagActivity.this.bOh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOh() {
        if (ListUtils.isEmpty(this.goK.bOm())) {
            this.goI.setAlpha(0.3f);
            this.goI.setClickable(false);
            return;
        }
        this.goI.setAlpha(1.0f);
        this.goI.setClickable(true);
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_live_tag_nav_bar);
        this.mRootView = findViewById(a.g.root_view);
        this.fXA = (BdGridView) findViewById(a.g.live_tag_gridview);
        this.boq = (CommonEmptyView) findViewById(a.g.empty_view);
        this.goI = findViewById(a.g.tag_commit_tv);
        this.goI.setOnClickListener(this);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.i.ala_live_tag_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button), a.f.sdk_d_icon_return_n, a.f.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.d.sdk_cp_cont_i, a.d.sdk_cp_cont_i);
        this.fXA.setAdapter((ListAdapter) this.goK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.goJ.bOA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bME() {
        this.boq.reset();
        this.boq.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveTagActivity.this.loadData();
                AlaLiveTagActivity.this.boq.setVisibility(8);
                AlaLiveTagActivity.this.mRootView.setVisibility(0);
            }
        });
        this.boq.setTitle(a.i.sdk_net_fail_tip_rank);
        this.boq.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.boq.setVisibility(0);
        this.mRootView.setVisibility(8);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == a.g.tag_commit_tv) {
            List<String> bOm = this.goK.bOm();
            Set<String> bOn = this.goK.bOn();
            if (bOm != null && bOn != null && bOm.size() == bOn.size() && bOn.containsAll(bOm)) {
                finish();
            } else {
                this.goJ.cb(bOm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
