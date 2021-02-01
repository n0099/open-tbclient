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
/* loaded from: classes11.dex */
public class AlaLiveTagActivity extends BaseActivity<AlaLiveTagActivity> {
    private String buH;
    private CommonEmptyView bwJ;
    private b gMA;
    private e gMB;
    private View gMz;
    private BdGridView gtK;
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
        this.buH = getIntent().getStringExtra("anchor_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.gMA = new b(getPageContext(), this.buH, this.mLiveId);
        this.gMA.a(new b.a() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.1
            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bTd() {
                AlaLiveTagActivity.this.gMB.setTagList(AlaLiveTagActivity.this.gMA.getTagList());
                AlaLiveTagActivity.this.gMz.setVisibility(0);
                AlaLiveTagActivity.this.bTc();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void ba(int i, String str) {
                AlaLiveTagActivity.this.bRy();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bTe() {
                AlaLiveTagActivity.this.showToast(a.h.ala_live_tag_commit_success);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913203));
                AlaLiveTagActivity.this.finish();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bTf() {
                AlaLiveTagActivity.this.showToast(a.h.ala_live_tag_commit_fail);
            }
        });
        this.gMB = new e(getPageContext());
        this.gMB.a(new e.b() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.2
            @Override // com.baidu.tieba.ala.category.a.e.b
            public void bTg() {
                AlaLiveTagActivity.this.bTc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTc() {
        if (ListUtils.isEmpty(this.gMB.bTh())) {
            this.gMz.setAlpha(0.3f);
            this.gMz.setClickable(false);
            return;
        }
        this.gMz.setAlpha(1.0f);
        this.gMz.setClickable(true);
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) findViewById(a.f.ala_live_tag_nav_bar);
        this.mRootView = findViewById(a.f.root_view);
        this.gtK = (BdGridView) findViewById(a.f.live_tag_gridview);
        this.bwJ = (CommonEmptyView) findViewById(a.f.empty_view);
        this.gMz = findViewById(a.f.tag_commit_tv);
        this.gMz.setOnClickListener(this);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.h.ala_live_tag_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.f.widget_navi_back_button), a.e.sdk_d_icon_return_n, a.e.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.c.sdk_cp_cont_i, a.c.sdk_cp_cont_i);
        this.gtK.setAdapter((ListAdapter) this.gMB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.gMA.bTv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRy() {
        this.bwJ.reset();
        this.bwJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveTagActivity.this.loadData();
                AlaLiveTagActivity.this.bwJ.setVisibility(8);
                AlaLiveTagActivity.this.mRootView.setVisibility(0);
            }
        });
        this.bwJ.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bwJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.bwJ.setVisibility(0);
        this.mRootView.setVisibility(8);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == a.f.tag_commit_tv) {
            List<String> bTh = this.gMB.bTh();
            Set<String> bTi = this.gMB.bTi();
            if (bTh != null && bTi != null && bTh.size() == bTi.size() && bTi.containsAll(bTh)) {
                finish();
            } else {
                this.gMA.co(bTh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
