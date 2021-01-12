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
/* loaded from: classes10.dex */
public class AlaLiveTagActivity extends BaseActivity<AlaLiveTagActivity> {
    private String bre;
    private CommonEmptyView btf;
    private View gJT;
    private b gJU;
    private e gJV;
    private BdGridView gra;
    private String mLiveId;
    private NavigationBar mNavigationBar;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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
        this.bre = getIntent().getStringExtra("anchor_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.gJU = new b(getPageContext(), this.bre, this.mLiveId);
        this.gJU.a(new b.a() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.1
            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bSA() {
                AlaLiveTagActivity.this.gJV.setTagList(AlaLiveTagActivity.this.gJU.getTagList());
                AlaLiveTagActivity.this.gJT.setVisibility(0);
                AlaLiveTagActivity.this.bSz();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void aV(int i, String str) {
                AlaLiveTagActivity.this.bQU();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bSB() {
                AlaLiveTagActivity.this.showToast(a.h.ala_live_tag_commit_success);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913203));
                AlaLiveTagActivity.this.finish();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bSC() {
                AlaLiveTagActivity.this.showToast(a.h.ala_live_tag_commit_fail);
            }
        });
        this.gJV = new e(getPageContext());
        this.gJV.a(new e.b() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.2
            @Override // com.baidu.tieba.ala.category.a.e.b
            public void bSD() {
                AlaLiveTagActivity.this.bSz();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSz() {
        if (ListUtils.isEmpty(this.gJV.bSE())) {
            this.gJT.setAlpha(0.3f);
            this.gJT.setClickable(false);
            return;
        }
        this.gJT.setAlpha(1.0f);
        this.gJT.setClickable(true);
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) findViewById(a.f.ala_live_tag_nav_bar);
        this.mRootView = findViewById(a.f.root_view);
        this.gra = (BdGridView) findViewById(a.f.live_tag_gridview);
        this.btf = (CommonEmptyView) findViewById(a.f.empty_view);
        this.gJT = findViewById(a.f.tag_commit_tv);
        this.gJT.setOnClickListener(this);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.h.ala_live_tag_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.f.widget_navi_back_button), a.e.sdk_d_icon_return_n, a.e.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.c.sdk_cp_cont_i, a.c.sdk_cp_cont_i);
        this.gra.setAdapter((ListAdapter) this.gJV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.gJU.bSS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQU() {
        this.btf.reset();
        this.btf.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveTagActivity.this.loadData();
                AlaLiveTagActivity.this.btf.setVisibility(8);
                AlaLiveTagActivity.this.mRootView.setVisibility(0);
            }
        });
        this.btf.setTitle(a.h.sdk_net_fail_tip_rank);
        this.btf.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.btf.setVisibility(0);
        this.mRootView.setVisibility(8);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == a.f.tag_commit_tv) {
            List<String> bSE = this.gJV.bSE();
            Set<String> bSF = this.gJV.bSF();
            if (bSE != null && bSF != null && bSE.size() == bSF.size() && bSF.containsAll(bSE)) {
                finish();
            } else {
                this.gJU.ct(bSE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
