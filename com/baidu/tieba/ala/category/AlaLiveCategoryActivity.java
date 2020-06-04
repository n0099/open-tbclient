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
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.category.a.c;
import com.baidu.tieba.ala.category.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaLiveCategoryActivity extends BaseActivity<AlaLiveCategoryActivity> {
    private CommonEmptyView aYj;
    private TextView fmY;
    private BdTypeListView fmZ;
    private BdTypeListView fna;
    private a fnb;
    private com.baidu.tieba.ala.category.a.a fnc;
    private c fnd;
    private String fne;
    private String fnf;
    private com.baidu.tieba.ala.category.b.c fng;
    private com.baidu.tieba.ala.category.b.c fnh;
    private MessageListener<?> fni = new CustomMessageListener(2913200) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.c) {
                AlaLiveCategoryActivity.this.a((com.baidu.tieba.ala.category.b.c) customResponsedMessage.getData());
            }
        }
    };
    private MessageListener<?> fnj = new CustomMessageListener(2913201) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.4
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
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.activity_ala_live_category);
        registerListener();
        initData();
        initView();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fnh != null && !TextUtils.equals(this.fnh.getId(), this.fnf)) {
            com.baidu.tieba.ala.category.b.a aVar = new com.baidu.tieba.ala.category.b.a();
            aVar.c(this.fng);
            aVar.d(this.fnh);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913202, aVar));
        }
    }

    private void registerListener() {
        registerListener(this.fni);
        registerListener(this.fnj);
    }

    private void initData() {
        this.fne = getIntent().getStringExtra("cat1_id");
        this.fnf = getIntent().getStringExtra("cat2_id");
        this.fnb = new com.baidu.tieba.ala.category.c.a(getPageContext());
        this.fnb.a(new a.InterfaceC0530a() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.1
            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0530a
            public void awN() {
                List<IAdapterData> bsP = AlaLiveCategoryActivity.this.fnb.bsP();
                AlaLiveCategoryActivity.this.fmZ.setData(bsP);
                AlaLiveCategoryActivity.this.bu(bsP);
            }

            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0530a
            public void al(int i, String str) {
                AlaLiveCategoryActivity.this.bqU();
            }
        });
        this.fnc = new com.baidu.tieba.ala.category.a.a(getPageContext().getContext(), this.fnb.getUniqueId());
        this.fnd = new c(getPageContext().getContext(), this.fnb.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(List<IAdapterData> list) {
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
                if (TextUtils.equals(((com.baidu.tieba.ala.category.b.c) next).getId(), this.fne)) {
                    for (IAdapterData iAdapterData : ((com.baidu.tieba.ala.category.b.c) next).bsQ()) {
                        if ((iAdapterData instanceof com.baidu.tieba.ala.category.b.c) && TextUtils.equals(((com.baidu.tieba.ala.category.b.c) iAdapterData).getId(), this.fnf)) {
                            this.fng = (com.baidu.tieba.ala.category.b.c) next;
                            this.fnh = (com.baidu.tieba.ala.category.b.c) iAdapterData;
                            break loop0;
                        }
                    }
                    cVar2 = cVar;
                } else {
                    cVar2 = cVar;
                }
            }
        }
        if (this.fng != null) {
            cVar = this.fng;
        }
        a(cVar);
        b(this.fnh);
    }

    private void initView() {
        this.mRootView = (RelativeLayout) findViewById(a.g.root_view);
        this.aYj = (CommonEmptyView) findViewById(a.g.empty_view);
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_live_category_nav_bar);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.i.ala_live_category_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button), a.f.sdk_d_icon_return_n, a.f.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.d.sdk_cp_cont_i, a.d.sdk_cp_cont_i);
        this.fmY = (TextView) findViewById(a.g.selected_category_tv);
        this.fmZ = (BdTypeListView) findViewById(a.g.ala_live_category_one_list);
        this.fna = (BdTypeListView) findViewById(a.g.ala_live_category_two_list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fnc);
        this.fmZ.addAdapters(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.fnd);
        this.fna.addAdapters(arrayList2);
        ViewGroup.LayoutParams layoutParams = this.fmZ.getLayoutParams();
        layoutParams.width = (ScreenHelper.getScreenWidth(getPageContext().getContext()) * 85) / 375;
        this.fmZ.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.fnb.bsU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.c cVar) {
        if (cVar != null) {
            this.fnc.Bc(cVar.getId());
            this.fna.setData(cVar.bsQ());
            this.fna.setTag(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.category.b.c cVar) {
        if (cVar != null) {
            this.fnh = cVar;
            this.fng = (com.baidu.tieba.ala.category.b.c) this.fna.getTag();
            this.fnd.Bc(this.fnh.getId());
            this.fmY.setText(cVar.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqU() {
        this.aYj.reset();
        this.aYj.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveCategoryActivity.this.loadData();
                AlaLiveCategoryActivity.this.aYj.setVisibility(8);
                AlaLiveCategoryActivity.this.mRootView.setVisibility(0);
            }
        });
        this.aYj.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aYj.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.aYj.setVisibility(0);
        this.mRootView.setVisibility(8);
    }
}
