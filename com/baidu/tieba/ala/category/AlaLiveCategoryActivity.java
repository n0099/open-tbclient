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
    private CommonEmptyView bpJ;
    private TextView gui;
    private BdTypeListView guj;
    private BdTypeListView guk;
    private a gul;
    private com.baidu.tieba.ala.category.a.a gum;
    private c gun;
    private String guo;
    private String gup;
    private com.baidu.tieba.ala.category.b.c guq;
    private com.baidu.tieba.ala.category.b.c gur;
    private MessageListener<?> gus = new CustomMessageListener(2913200) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.c) {
                AlaLiveCategoryActivity.this.a((com.baidu.tieba.ala.category.b.c) customResponsedMessage.getData());
            }
        }
    };
    private MessageListener<?> gut = new CustomMessageListener(2913201) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.4
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
        if (this.gur != null && !TextUtils.equals(this.gur.getId(), this.gup)) {
            com.baidu.tieba.ala.category.b.a aVar = new com.baidu.tieba.ala.category.b.a();
            aVar.c(this.guq);
            aVar.d(this.gur);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913202, aVar));
        }
    }

    private void registerListener() {
        registerListener(this.gus);
        registerListener(this.gut);
    }

    private void initData() {
        this.guo = getIntent().getStringExtra("cat1_id");
        this.gup = getIntent().getStringExtra("cat2_id");
        this.gul = new com.baidu.tieba.ala.category.c.a(getPageContext());
        this.gul.a(new a.InterfaceC0636a() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.1
            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0636a
            public void aRN() {
                List<IAdapterData> bQS = AlaLiveCategoryActivity.this.gul.bQS();
                AlaLiveCategoryActivity.this.guj.setData(bQS);
                AlaLiveCategoryActivity.this.ch(bQS);
            }

            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0636a
            public void aE(int i, String str) {
                AlaLiveCategoryActivity.this.bPe();
            }
        });
        this.gum = new com.baidu.tieba.ala.category.a.a(getPageContext().getContext(), this.gul.getUniqueId());
        this.gun = new c(getPageContext().getContext(), this.gul.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(List<IAdapterData> list) {
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
                if (TextUtils.equals(((com.baidu.tieba.ala.category.b.c) next).getId(), this.guo)) {
                    for (IAdapterData iAdapterData : ((com.baidu.tieba.ala.category.b.c) next).bQT()) {
                        if ((iAdapterData instanceof com.baidu.tieba.ala.category.b.c) && TextUtils.equals(((com.baidu.tieba.ala.category.b.c) iAdapterData).getId(), this.gup)) {
                            this.guq = (com.baidu.tieba.ala.category.b.c) next;
                            this.gur = (com.baidu.tieba.ala.category.b.c) iAdapterData;
                            break loop0;
                        }
                    }
                    cVar2 = cVar;
                } else {
                    cVar2 = cVar;
                }
            }
        }
        if (this.guq != null) {
            cVar = this.guq;
        }
        a(cVar);
        b(this.gur);
    }

    private void initView() {
        this.mRootView = (RelativeLayout) findViewById(a.f.root_view);
        this.bpJ = (CommonEmptyView) findViewById(a.f.empty_view);
        this.mNavigationBar = (NavigationBar) findViewById(a.f.ala_live_category_nav_bar);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.h.ala_live_category_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.f.widget_navi_back_button), a.e.sdk_d_icon_return_n, a.e.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.c.sdk_cp_cont_i, a.c.sdk_cp_cont_i);
        this.gui = (TextView) findViewById(a.f.selected_category_tv);
        this.guj = (BdTypeListView) findViewById(a.f.ala_live_category_one_list);
        this.guk = (BdTypeListView) findViewById(a.f.ala_live_category_two_list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.gum);
        this.guj.addAdapters(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.gun);
        this.guk.addAdapters(arrayList2);
        ViewGroup.LayoutParams layoutParams = this.guj.getLayoutParams();
        layoutParams.width = (ScreenHelper.getScreenWidth(getPageContext().getContext()) * 85) / 375;
        this.guj.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.gul.bQX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.c cVar) {
        if (cVar != null) {
            this.gum.GC(cVar.getId());
            this.guk.setData(cVar.bQT());
            this.guk.setTag(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.category.b.c cVar) {
        if (cVar != null) {
            this.gur = cVar;
            this.guq = (com.baidu.tieba.ala.category.b.c) this.guk.getTag();
            this.gun.GC(this.gur.getId());
            this.gui.setText(cVar.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPe() {
        this.bpJ.reset();
        this.bpJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveCategoryActivity.this.loadData();
                AlaLiveCategoryActivity.this.bpJ.setVisibility(8);
                AlaLiveCategoryActivity.this.mRootView.setVisibility(0);
            }
        });
        this.bpJ.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bpJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.bpJ.setVisibility(0);
        this.mRootView.setVisibility(8);
    }
}
