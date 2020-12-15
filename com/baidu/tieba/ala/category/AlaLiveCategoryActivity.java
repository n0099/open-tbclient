package com.baidu.tieba.ala.category;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.MessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.category.a.c;
import com.baidu.tieba.ala.category.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveCategoryActivity extends BaseActivity<AlaLiveCategoryActivity> {
    private CommonEmptyView btg;
    private TextView gCA;
    private BdTypeListView gCB;
    private BdTypeListView gCC;
    private a gCD;
    private com.baidu.tieba.ala.category.a.a gCE;
    private c gCF;
    private String gCG;
    private String gCH;
    private com.baidu.tieba.ala.category.b.c gCI;
    private com.baidu.tieba.ala.category.b.c gCJ;
    private MessageListener<?> gCK = new CustomMessageListener(2913200) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.c) {
                AlaLiveCategoryActivity.this.a((com.baidu.tieba.ala.category.b.c) customResponsedMessage.getData());
            }
        }
    };
    private MessageListener<?> gCL = new CustomMessageListener(2913201) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.c) {
                AlaLiveCategoryActivity.this.b((com.baidu.tieba.ala.category.b.c) customResponsedMessage.getData());
            }
        }
    };
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.activity_ala_live_category);
        registerListener();
        initData();
        initView();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gCJ != null && !TextUtils.equals(this.gCJ.getId(), this.gCH)) {
            com.baidu.tieba.ala.category.b.a aVar = new com.baidu.tieba.ala.category.b.a();
            aVar.c(this.gCI);
            aVar.d(this.gCJ);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913202, aVar));
        }
    }

    private void registerListener() {
        registerListener(this.gCK);
        registerListener(this.gCL);
    }

    private void initData() {
        this.gCG = getIntent().getStringExtra("cat1_id");
        this.gCH = getIntent().getStringExtra("cat2_id");
        this.gCD = new com.baidu.tieba.ala.category.c.a(getPageContext());
        this.gCD.a(new a.InterfaceC0648a() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.1
            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0648a
            public void aUk() {
                List<IAdapterData> bTW = AlaLiveCategoryActivity.this.gCD.bTW();
                AlaLiveCategoryActivity.this.gCB.setData(bTW);
                AlaLiveCategoryActivity.this.cl(bTW);
            }

            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0648a
            public void aC(int i, String str) {
                AlaLiveCategoryActivity.this.bSj();
            }
        });
        this.gCE = new com.baidu.tieba.ala.category.a.a(getPageContext().getContext(), this.gCD.getUniqueId());
        this.gCF = new c(getPageContext().getContext(), this.gCD.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(List<IAdapterData> list) {
        com.baidu.tieba.ala.category.b.c cVar;
        com.baidu.tieba.ala.category.b.c cVar2 = null;
        Iterator<IAdapterData> it = list.iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                cVar = cVar2;
                break;
            }
            IAdapterData next = it.next();
            if (next instanceof com.baidu.tieba.ala.category.b.c) {
                cVar = cVar2 == null ? (com.baidu.tieba.ala.category.b.c) next : cVar2;
                if (TextUtils.equals(((com.baidu.tieba.ala.category.b.c) next).getId(), this.gCG)) {
                    for (IAdapterData iAdapterData : ((com.baidu.tieba.ala.category.b.c) next).bTX()) {
                        if ((iAdapterData instanceof com.baidu.tieba.ala.category.b.c) && TextUtils.equals(((com.baidu.tieba.ala.category.b.c) iAdapterData).getId(), this.gCH)) {
                            this.gCI = (com.baidu.tieba.ala.category.b.c) next;
                            this.gCJ = (com.baidu.tieba.ala.category.b.c) iAdapterData;
                            break loop0;
                        }
                    }
                    cVar2 = cVar;
                } else {
                    cVar2 = cVar;
                }
            }
        }
        if (this.gCI != null) {
            cVar = this.gCI;
        }
        a(cVar);
        b(this.gCJ);
    }

    private void initView() {
        this.mRootView = (RelativeLayout) findViewById(a.f.root_view);
        this.btg = (CommonEmptyView) findViewById(a.f.empty_view);
        this.mNavigationBar = (NavigationBar) findViewById(a.f.ala_live_category_nav_bar);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.h.ala_live_category_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.f.widget_navi_back_button), a.e.sdk_d_icon_return_n, a.e.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.c.sdk_cp_cont_i, a.c.sdk_cp_cont_i);
        this.gCA = (TextView) findViewById(a.f.selected_category_tv);
        this.gCB = (BdTypeListView) findViewById(a.f.ala_live_category_one_list);
        this.gCC = (BdTypeListView) findViewById(a.f.ala_live_category_two_list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.gCE);
        this.gCB.addAdapters(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.gCF);
        this.gCC.addAdapters(arrayList2);
        ViewGroup.LayoutParams layoutParams = this.gCB.getLayoutParams();
        layoutParams.width = (ScreenHelper.getScreenWidth(getPageContext().getContext()) * 85) / 375;
        this.gCB.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.gCD.bUb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.c cVar) {
        if (cVar != null) {
            this.gCE.GR(cVar.getId());
            this.gCC.setData(cVar.bTX());
            this.gCC.setTag(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.category.b.c cVar) {
        if (cVar != null) {
            this.gCJ = cVar;
            this.gCI = (com.baidu.tieba.ala.category.b.c) this.gCC.getTag();
            this.gCF.GR(this.gCJ.getId());
            this.gCA.setText(cVar.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSj() {
        this.btg.reset();
        this.btg.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveCategoryActivity.this.loadData();
                AlaLiveCategoryActivity.this.btg.setVisibility(8);
                AlaLiveCategoryActivity.this.mRootView.setVisibility(0);
            }
        });
        this.btg.setTitle(a.h.sdk_net_fail_tip_rank);
        this.btg.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.btg.setVisibility(0);
        this.mRootView.setVisibility(8);
    }
}
