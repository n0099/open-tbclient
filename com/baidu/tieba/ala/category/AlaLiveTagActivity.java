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
    private String bhk;
    private CommonEmptyView bjf;
    private BdGridView fCb;
    private View fSm;
    private b fSn;
    private e fSo;
    private String mLiveId;
    private NavigationBar mNavigationBar;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
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
        this.bhk = getIntent().getStringExtra("anchor_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.fSn = new b(getPageContext(), this.bhk, this.mLiveId);
        this.fSn.a(new b.a() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.1
            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bIW() {
                AlaLiveTagActivity.this.fSo.setTagList(AlaLiveTagActivity.this.fSn.getTagList());
                AlaLiveTagActivity.this.fSm.setVisibility(0);
                AlaLiveTagActivity.this.bIV();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void aE(int i, String str) {
                AlaLiveTagActivity.this.bHr();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bIX() {
                AlaLiveTagActivity.this.showToast(a.i.ala_live_tag_commit_success);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913203));
                AlaLiveTagActivity.this.finish();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bIY() {
                AlaLiveTagActivity.this.showToast(a.i.ala_live_tag_commit_fail);
            }
        });
        this.fSo = new e(getPageContext());
        this.fSo.a(new e.b() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.2
            @Override // com.baidu.tieba.ala.category.a.e.b
            public void bIZ() {
                AlaLiveTagActivity.this.bIV();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIV() {
        if (ListUtils.isEmpty(this.fSo.bJa())) {
            this.fSm.setAlpha(0.3f);
            this.fSm.setClickable(false);
            return;
        }
        this.fSm.setAlpha(1.0f);
        this.fSm.setClickable(true);
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_live_tag_nav_bar);
        this.mRootView = findViewById(a.g.root_view);
        this.fCb = (BdGridView) findViewById(a.g.live_tag_gridview);
        this.bjf = (CommonEmptyView) findViewById(a.g.empty_view);
        this.fSm = findViewById(a.g.tag_commit_tv);
        this.fSm.setOnClickListener(this);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.i.ala_live_tag_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button), a.f.sdk_d_icon_return_n, a.f.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.d.sdk_cp_cont_i, a.d.sdk_cp_cont_i);
        this.fCb.setAdapter((ListAdapter) this.fSo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.fSn.bJo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHr() {
        this.bjf.reset();
        this.bjf.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveTagActivity.this.loadData();
                AlaLiveTagActivity.this.bjf.setVisibility(8);
                AlaLiveTagActivity.this.mRootView.setVisibility(0);
            }
        });
        this.bjf.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bjf.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.bjf.setVisibility(0);
        this.mRootView.setVisibility(8);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == a.g.tag_commit_tv) {
            List<String> bJa = this.fSo.bJa();
            Set<String> bJb = this.fSo.bJb();
            if (bJa != null && bJb != null && bJa.size() == bJb.size() && bJb.containsAll(bJa)) {
                finish();
            } else {
                this.fSn.bO(bJa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
