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
import com.baidu.tieba.ala.category.b.c;
import com.baidu.tieba.ala.category.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaLiveCategoryActivity extends BaseActivity<AlaLiveCategoryActivity> {
    private CommonEmptyView baQ;
    private String fDA;
    private c fDB;
    private c fDC;
    private MessageListener<?> fDD = new CustomMessageListener(2913200) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof c) {
                AlaLiveCategoryActivity.this.a((c) customResponsedMessage.getData());
            }
        }
    };
    private MessageListener<?> fDE = new CustomMessageListener(2913201) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof c) {
                AlaLiveCategoryActivity.this.b((c) customResponsedMessage.getData());
            }
        }
    };
    private TextView fDt;
    private BdTypeListView fDu;
    private BdTypeListView fDv;
    private a fDw;
    private com.baidu.tieba.ala.category.a.a fDx;
    private com.baidu.tieba.ala.category.a.c fDy;
    private String fDz;
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
        if (this.fDC != null && !TextUtils.equals(this.fDC.getId(), this.fDA)) {
            com.baidu.tieba.ala.category.b.a aVar = new com.baidu.tieba.ala.category.b.a();
            aVar.c(this.fDB);
            aVar.d(this.fDC);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913202, aVar));
        }
    }

    private void registerListener() {
        registerListener(this.fDD);
        registerListener(this.fDE);
    }

    private void initData() {
        this.fDz = getIntent().getStringExtra("cat1_id");
        this.fDA = getIntent().getStringExtra("cat2_id");
        this.fDw = new com.baidu.tieba.ala.category.c.a(getPageContext());
        this.fDw.a(new a.InterfaceC0549a() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.1
            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0549a
            public void aBj() {
                List<IAdapterData> byU = AlaLiveCategoryActivity.this.fDw.byU();
                AlaLiveCategoryActivity.this.fDu.setData(byU);
                AlaLiveCategoryActivity.this.bH(byU);
            }

            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0549a
            public void ao(int i, String str) {
                AlaLiveCategoryActivity.this.bxb();
            }
        });
        this.fDx = new com.baidu.tieba.ala.category.a.a(getPageContext().getContext(), this.fDw.getUniqueId());
        this.fDy = new com.baidu.tieba.ala.category.a.c(getPageContext().getContext(), this.fDw.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(List<IAdapterData> list) {
        c cVar;
        c cVar2 = null;
        Iterator<IAdapterData> it = list.iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                cVar = cVar2;
                break;
            }
            IAdapterData next = it.next();
            if (next instanceof c) {
                cVar = cVar2 == null ? (c) next : cVar2;
                if (TextUtils.equals(((c) next).getId(), this.fDz)) {
                    for (IAdapterData iAdapterData : ((c) next).byV()) {
                        if ((iAdapterData instanceof c) && TextUtils.equals(((c) iAdapterData).getId(), this.fDA)) {
                            this.fDB = (c) next;
                            this.fDC = (c) iAdapterData;
                            break loop0;
                        }
                    }
                    cVar2 = cVar;
                } else {
                    cVar2 = cVar;
                }
            }
        }
        if (this.fDB != null) {
            cVar = this.fDB;
        }
        a(cVar);
        b(this.fDC);
    }

    private void initView() {
        this.mRootView = (RelativeLayout) findViewById(a.g.root_view);
        this.baQ = (CommonEmptyView) findViewById(a.g.empty_view);
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_live_category_nav_bar);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.i.ala_live_category_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button), a.f.sdk_d_icon_return_n, a.f.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.d.sdk_cp_cont_i, a.d.sdk_cp_cont_i);
        this.fDt = (TextView) findViewById(a.g.selected_category_tv);
        this.fDu = (BdTypeListView) findViewById(a.g.ala_live_category_one_list);
        this.fDv = (BdTypeListView) findViewById(a.g.ala_live_category_two_list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fDx);
        this.fDu.addAdapters(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.fDy);
        this.fDv.addAdapters(arrayList2);
        ViewGroup.LayoutParams layoutParams = this.fDu.getLayoutParams();
        layoutParams.width = (ScreenHelper.getScreenWidth(getPageContext().getContext()) * 85) / 375;
        this.fDu.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.fDw.byZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar != null) {
            this.fDx.Cl(cVar.getId());
            this.fDv.setData(cVar.byV());
            this.fDv.setTag(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            this.fDC = cVar;
            this.fDB = (c) this.fDv.getTag();
            this.fDy.Cl(this.fDC.getId());
            this.fDt.setText(cVar.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxb() {
        this.baQ.reset();
        this.baQ.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveCategoryActivity.this.loadData();
                AlaLiveCategoryActivity.this.baQ.setVisibility(8);
                AlaLiveCategoryActivity.this.mRootView.setVisibility(0);
            }
        });
        this.baQ.setTitle(a.i.sdk_net_fail_tip_rank);
        this.baQ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.baQ.setVisibility(0);
        this.mRootView.setVisibility(8);
    }
}
