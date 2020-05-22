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
    private TextView fmN;
    private BdTypeListView fmO;
    private BdTypeListView fmP;
    private a fmQ;
    private com.baidu.tieba.ala.category.a.a fmR;
    private c fmS;
    private String fmT;
    private String fmU;
    private com.baidu.tieba.ala.category.b.c fmV;
    private com.baidu.tieba.ala.category.b.c fmW;
    private MessageListener<?> fmX = new CustomMessageListener(2913200) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.c) {
                AlaLiveCategoryActivity.this.a((com.baidu.tieba.ala.category.b.c) customResponsedMessage.getData());
            }
        }
    };
    private MessageListener<?> fmY = new CustomMessageListener(2913201) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.4
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
        if (this.fmW != null && !TextUtils.equals(this.fmW.getId(), this.fmU)) {
            com.baidu.tieba.ala.category.b.a aVar = new com.baidu.tieba.ala.category.b.a();
            aVar.c(this.fmV);
            aVar.d(this.fmW);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913202, aVar));
        }
    }

    private void registerListener() {
        registerListener(this.fmX);
        registerListener(this.fmY);
    }

    private void initData() {
        this.fmT = getIntent().getStringExtra("cat1_id");
        this.fmU = getIntent().getStringExtra("cat2_id");
        this.fmQ = new com.baidu.tieba.ala.category.c.a(getPageContext());
        this.fmQ.a(new a.InterfaceC0530a() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.1
            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0530a
            public void awN() {
                List<IAdapterData> bsN = AlaLiveCategoryActivity.this.fmQ.bsN();
                AlaLiveCategoryActivity.this.fmO.setData(bsN);
                AlaLiveCategoryActivity.this.bu(bsN);
            }

            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0530a
            public void al(int i, String str) {
                AlaLiveCategoryActivity.this.bqS();
            }
        });
        this.fmR = new com.baidu.tieba.ala.category.a.a(getPageContext().getContext(), this.fmQ.getUniqueId());
        this.fmS = new c(getPageContext().getContext(), this.fmQ.getUniqueId());
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
                if (TextUtils.equals(((com.baidu.tieba.ala.category.b.c) next).getId(), this.fmT)) {
                    for (IAdapterData iAdapterData : ((com.baidu.tieba.ala.category.b.c) next).bsO()) {
                        if ((iAdapterData instanceof com.baidu.tieba.ala.category.b.c) && TextUtils.equals(((com.baidu.tieba.ala.category.b.c) iAdapterData).getId(), this.fmU)) {
                            this.fmV = (com.baidu.tieba.ala.category.b.c) next;
                            this.fmW = (com.baidu.tieba.ala.category.b.c) iAdapterData;
                            break loop0;
                        }
                    }
                    cVar2 = cVar;
                } else {
                    cVar2 = cVar;
                }
            }
        }
        if (this.fmV != null) {
            cVar = this.fmV;
        }
        a(cVar);
        b(this.fmW);
    }

    private void initView() {
        this.mRootView = (RelativeLayout) findViewById(a.g.root_view);
        this.aYj = (CommonEmptyView) findViewById(a.g.empty_view);
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_live_category_nav_bar);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.i.ala_live_category_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button), a.f.sdk_d_icon_return_n, a.f.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.d.sdk_cp_cont_i, a.d.sdk_cp_cont_i);
        this.fmN = (TextView) findViewById(a.g.selected_category_tv);
        this.fmO = (BdTypeListView) findViewById(a.g.ala_live_category_one_list);
        this.fmP = (BdTypeListView) findViewById(a.g.ala_live_category_two_list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fmR);
        this.fmO.addAdapters(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.fmS);
        this.fmP.addAdapters(arrayList2);
        ViewGroup.LayoutParams layoutParams = this.fmO.getLayoutParams();
        layoutParams.width = (ScreenHelper.getScreenWidth(getPageContext().getContext()) * 85) / 375;
        this.fmO.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.fmQ.bsS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.c cVar) {
        if (cVar != null) {
            this.fmR.Bc(cVar.getId());
            this.fmP.setData(cVar.bsO());
            this.fmP.setTag(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.category.b.c cVar) {
        if (cVar != null) {
            this.fmW = cVar;
            this.fmV = (com.baidu.tieba.ala.category.b.c) this.fmP.getTag();
            this.fmS.Bc(this.fmW.getId());
            this.fmN.setText(cVar.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqS() {
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
