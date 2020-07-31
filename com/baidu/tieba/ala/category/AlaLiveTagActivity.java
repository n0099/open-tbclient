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
/* loaded from: classes4.dex */
public class AlaLiveTagActivity extends BaseActivity<AlaLiveTagActivity> {
    private String aYY;
    private CommonEmptyView baQ;
    private View fDG;
    private b fDH;
    private e fDI;
    private BdGridView fnq;
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
        this.aYY = getIntent().getStringExtra("anchor_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.fDH = new b(getPageContext(), this.aYY, this.mLiveId);
        this.fDH.a(new b.a() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.1
            @Override // com.baidu.tieba.ala.category.c.b.a
            public void byK() {
                AlaLiveTagActivity.this.fDI.setTagList(AlaLiveTagActivity.this.fDH.getTagList());
                AlaLiveTagActivity.this.fDG.setVisibility(0);
                AlaLiveTagActivity.this.byJ();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void aG(int i, String str) {
                AlaLiveTagActivity.this.bxb();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void byL() {
                AlaLiveTagActivity.this.showToast(a.i.ala_live_tag_commit_success);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913203));
                AlaLiveTagActivity.this.finish();
            }

            @Override // com.baidu.tieba.ala.category.c.b.a
            public void byM() {
                AlaLiveTagActivity.this.showToast(a.i.ala_live_tag_commit_fail);
            }
        });
        this.fDI = new e(getPageContext());
        this.fDI.a(new e.b() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.2
            @Override // com.baidu.tieba.ala.category.a.e.b
            public void byN() {
                AlaLiveTagActivity.this.byJ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byJ() {
        if (ListUtils.isEmpty(this.fDI.byO())) {
            this.fDG.setAlpha(0.3f);
            this.fDG.setClickable(false);
            return;
        }
        this.fDG.setAlpha(1.0f);
        this.fDG.setClickable(true);
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_live_tag_nav_bar);
        this.mRootView = findViewById(a.g.root_view);
        this.fnq = (BdGridView) findViewById(a.g.live_tag_gridview);
        this.baQ = (CommonEmptyView) findViewById(a.g.empty_view);
        this.fDG = findViewById(a.g.tag_commit_tv);
        this.fDG.setOnClickListener(this);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.i.ala_live_tag_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button), a.f.sdk_d_icon_return_n, a.f.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.d.sdk_cp_cont_i, a.d.sdk_cp_cont_i);
        this.fnq.setAdapter((ListAdapter) this.fDI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.fDH.bzc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxb() {
        this.baQ.reset();
        this.baQ.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveTagActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveTagActivity.this.loadData();
                AlaLiveTagActivity.this.baQ.setVisibility(8);
                AlaLiveTagActivity.this.mRootView.setVisibility(0);
            }
        });
        this.baQ.setTitle(a.i.sdk_net_fail_tip_rank);
        this.baQ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.baQ.setVisibility(0);
        this.mRootView.setVisibility(8);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == a.g.tag_commit_tv) {
            List<String> byO = this.fDI.byO();
            Set<String> byP = this.fDI.byP();
            if (byO != null && byP != null && byO.size() == byP.size() && byP.containsAll(byO)) {
                finish();
            } else {
                this.fDH.bI(byO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
