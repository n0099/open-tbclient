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
    private View gMN;
    private b gMO;
    private e gMP;
    private BdGridView gtY;
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
        this.gMO = new b(getPageContext(), this.buH, this.mLiveId);
        this.gMO.a(new b.a() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.1
            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bTk() {
                AlaLiveTagActivity.this.gMP.setTagList(AlaLiveTagActivity.this.gMO.getTagList());
                AlaLiveTagActivity.this.gMN.setVisibility(0);
                AlaLiveTagActivity.this.bTj();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void ba(int i, String str) {
                AlaLiveTagActivity.this.bRF();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bTl() {
                AlaLiveTagActivity.this.showToast(a.h.ala_live_tag_commit_success);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913203));
                AlaLiveTagActivity.this.finish();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void bTm() {
                AlaLiveTagActivity.this.showToast(a.h.ala_live_tag_commit_fail);
            }
        });
        this.gMP = new e(getPageContext());
        this.gMP.a(new e.b() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.2
            @Override // com.baidu.tieba.ala.category.a.e.b
            public void bTn() {
                AlaLiveTagActivity.this.bTj();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTj() {
        if (ListUtils.isEmpty(this.gMP.bTo())) {
            this.gMN.setAlpha(0.3f);
            this.gMN.setClickable(false);
            return;
        }
        this.gMN.setAlpha(1.0f);
        this.gMN.setClickable(true);
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) findViewById(a.f.ala_live_tag_nav_bar);
        this.mRootView = findViewById(a.f.root_view);
        this.gtY = (BdGridView) findViewById(a.f.live_tag_gridview);
        this.bwJ = (CommonEmptyView) findViewById(a.f.empty_view);
        this.gMN = findViewById(a.f.tag_commit_tv);
        this.gMN.setOnClickListener(this);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.h.ala_live_tag_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.f.widget_navi_back_button), a.e.sdk_d_icon_return_n, a.e.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.c.sdk_cp_cont_i, a.c.sdk_cp_cont_i);
        this.gtY.setAdapter((ListAdapter) this.gMP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.gMO.bTC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRF() {
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
            List<String> bTo = this.gMP.bTo();
            Set<String> bTp = this.gMP.bTp();
            if (bTo != null && bTp != null && bTo.size() == bTp.size() && bTp.containsAll(bTo)) {
                finish();
            } else {
                this.gMO.co(bTo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
