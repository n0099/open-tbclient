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
/* loaded from: classes7.dex */
public class AlaLiveCategoryActivity extends BaseActivity<AlaLiveCategoryActivity> {
    private CommonEmptyView bgl;
    private TextView fOK;
    private BdTypeListView fOL;
    private BdTypeListView fOM;
    private a fON;
    private com.baidu.tieba.ala.category.a.a fOO;
    private c fOP;
    private String fOQ;
    private String fOR;
    private com.baidu.tieba.ala.category.b.c fOS;
    private com.baidu.tieba.ala.category.b.c fOT;
    private MessageListener<?> fOU = new CustomMessageListener(2913200) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.c) {
                AlaLiveCategoryActivity.this.a((com.baidu.tieba.ala.category.b.c) customResponsedMessage.getData());
            }
        }
    };
    private MessageListener<?> fOV = new CustomMessageListener(2913201) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.4
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
        if (this.fOT != null && !TextUtils.equals(this.fOT.getId(), this.fOR)) {
            com.baidu.tieba.ala.category.b.a aVar = new com.baidu.tieba.ala.category.b.a();
            aVar.c(this.fOS);
            aVar.d(this.fOT);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913202, aVar));
        }
    }

    private void registerListener() {
        registerListener(this.fOU);
        registerListener(this.fOV);
    }

    private void initData() {
        this.fOQ = getIntent().getStringExtra("cat1_id");
        this.fOR = getIntent().getStringExtra("cat2_id");
        this.fON = new com.baidu.tieba.ala.category.c.a(getPageContext());
        this.fON.a(new a.InterfaceC0595a() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.1
            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0595a
            public void aJZ() {
                List<IAdapterData> bHX = AlaLiveCategoryActivity.this.fON.bHX();
                AlaLiveCategoryActivity.this.fOL.setData(bHX);
                AlaLiveCategoryActivity.this.bI(bHX);
            }

            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0595a
            public void am(int i, String str) {
                AlaLiveCategoryActivity.this.bGa();
            }
        });
        this.fOO = new com.baidu.tieba.ala.category.a.a(getPageContext().getContext(), this.fON.getUniqueId());
        this.fOP = new c(getPageContext().getContext(), this.fON.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(List<IAdapterData> list) {
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
                if (TextUtils.equals(((com.baidu.tieba.ala.category.b.c) next).getId(), this.fOQ)) {
                    for (IAdapterData iAdapterData : ((com.baidu.tieba.ala.category.b.c) next).bHY()) {
                        if ((iAdapterData instanceof com.baidu.tieba.ala.category.b.c) && TextUtils.equals(((com.baidu.tieba.ala.category.b.c) iAdapterData).getId(), this.fOR)) {
                            this.fOS = (com.baidu.tieba.ala.category.b.c) next;
                            this.fOT = (com.baidu.tieba.ala.category.b.c) iAdapterData;
                            break loop0;
                        }
                    }
                    cVar2 = cVar;
                } else {
                    cVar2 = cVar;
                }
            }
        }
        if (this.fOS != null) {
            cVar = this.fOS;
        }
        a(cVar);
        b(this.fOT);
    }

    private void initView() {
        this.mRootView = (RelativeLayout) findViewById(a.g.root_view);
        this.bgl = (CommonEmptyView) findViewById(a.g.empty_view);
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_live_category_nav_bar);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.i.ala_live_category_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button), a.f.sdk_d_icon_return_n, a.f.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.d.sdk_cp_cont_i, a.d.sdk_cp_cont_i);
        this.fOK = (TextView) findViewById(a.g.selected_category_tv);
        this.fOL = (BdTypeListView) findViewById(a.g.ala_live_category_one_list);
        this.fOM = (BdTypeListView) findViewById(a.g.ala_live_category_two_list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fOO);
        this.fOL.addAdapters(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.fOP);
        this.fOM.addAdapters(arrayList2);
        ViewGroup.LayoutParams layoutParams = this.fOL.getLayoutParams();
        layoutParams.width = (ScreenHelper.getScreenWidth(getPageContext().getContext()) * 85) / 375;
        this.fOL.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.fON.bIc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.c cVar) {
        if (cVar != null) {
            this.fOO.EG(cVar.getId());
            this.fOM.setData(cVar.bHY());
            this.fOM.setTag(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.category.b.c cVar) {
        if (cVar != null) {
            this.fOT = cVar;
            this.fOS = (com.baidu.tieba.ala.category.b.c) this.fOM.getTag();
            this.fOP.EG(this.fOT.getId());
            this.fOK.setText(cVar.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGa() {
        this.bgl.reset();
        this.bgl.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveCategoryActivity.this.loadData();
                AlaLiveCategoryActivity.this.bgl.setVisibility(8);
                AlaLiveCategoryActivity.this.mRootView.setVisibility(0);
            }
        });
        this.bgl.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bgl.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.bgl.setVisibility(0);
        this.mRootView.setVisibility(8);
    }
}
