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
/* loaded from: classes3.dex */
public class AlaLiveCategoryActivity extends BaseActivity<AlaLiveCategoryActivity> {
    private CommonEmptyView baR;
    private TextView fym;
    private BdTypeListView fyn;
    private BdTypeListView fyo;
    private a fyp;
    private com.baidu.tieba.ala.category.a.a fyq;
    private c fyr;
    private String fys;
    private String fyt;
    private com.baidu.tieba.ala.category.b.c fyu;
    private com.baidu.tieba.ala.category.b.c fyv;
    private MessageListener<?> fyw = new CustomMessageListener(2913200) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.c) {
                AlaLiveCategoryActivity.this.a((com.baidu.tieba.ala.category.b.c) customResponsedMessage.getData());
            }
        }
    };
    private MessageListener<?> fyx = new CustomMessageListener(2913201) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.4
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
        if (this.fyv != null && !TextUtils.equals(this.fyv.getId(), this.fyt)) {
            com.baidu.tieba.ala.category.b.a aVar = new com.baidu.tieba.ala.category.b.a();
            aVar.c(this.fyu);
            aVar.d(this.fyv);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913202, aVar));
        }
    }

    private void registerListener() {
        registerListener(this.fyw);
        registerListener(this.fyx);
    }

    private void initData() {
        this.fys = getIntent().getStringExtra("cat1_id");
        this.fyt = getIntent().getStringExtra("cat2_id");
        this.fyp = new com.baidu.tieba.ala.category.c.a(getPageContext());
        this.fyp.a(new a.InterfaceC0538a() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.1
            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0538a
            public void axT() {
                List<IAdapterData> bvL = AlaLiveCategoryActivity.this.fyp.bvL();
                AlaLiveCategoryActivity.this.fyn.setData(bvL);
                AlaLiveCategoryActivity.this.bD(bvL);
            }

            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0538a
            public void an(int i, String str) {
                AlaLiveCategoryActivity.this.btS();
            }
        });
        this.fyq = new com.baidu.tieba.ala.category.a.a(getPageContext().getContext(), this.fyp.getUniqueId());
        this.fyr = new c(getPageContext().getContext(), this.fyp.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(List<IAdapterData> list) {
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
                if (TextUtils.equals(((com.baidu.tieba.ala.category.b.c) next).getId(), this.fys)) {
                    for (IAdapterData iAdapterData : ((com.baidu.tieba.ala.category.b.c) next).bvM()) {
                        if ((iAdapterData instanceof com.baidu.tieba.ala.category.b.c) && TextUtils.equals(((com.baidu.tieba.ala.category.b.c) iAdapterData).getId(), this.fyt)) {
                            this.fyu = (com.baidu.tieba.ala.category.b.c) next;
                            this.fyv = (com.baidu.tieba.ala.category.b.c) iAdapterData;
                            break loop0;
                        }
                    }
                    cVar2 = cVar;
                } else {
                    cVar2 = cVar;
                }
            }
        }
        if (this.fyu != null) {
            cVar = this.fyu;
        }
        a(cVar);
        b(this.fyv);
    }

    private void initView() {
        this.mRootView = (RelativeLayout) findViewById(a.g.root_view);
        this.baR = (CommonEmptyView) findViewById(a.g.empty_view);
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_live_category_nav_bar);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.i.ala_live_category_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button), a.f.sdk_d_icon_return_n, a.f.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.d.sdk_cp_cont_i, a.d.sdk_cp_cont_i);
        this.fym = (TextView) findViewById(a.g.selected_category_tv);
        this.fyn = (BdTypeListView) findViewById(a.g.ala_live_category_one_list);
        this.fyo = (BdTypeListView) findViewById(a.g.ala_live_category_two_list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fyq);
        this.fyn.addAdapters(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.fyr);
        this.fyo.addAdapters(arrayList2);
        ViewGroup.LayoutParams layoutParams = this.fyn.getLayoutParams();
        layoutParams.width = (ScreenHelper.getScreenWidth(getPageContext().getContext()) * 85) / 375;
        this.fyn.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.fyp.bvQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.c cVar) {
        if (cVar != null) {
            this.fyq.BA(cVar.getId());
            this.fyo.setData(cVar.bvM());
            this.fyo.setTag(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.category.b.c cVar) {
        if (cVar != null) {
            this.fyv = cVar;
            this.fyu = (com.baidu.tieba.ala.category.b.c) this.fyo.getTag();
            this.fyr.BA(this.fyv.getId());
            this.fym.setText(cVar.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btS() {
        this.baR.reset();
        this.baR.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveCategoryActivity.this.loadData();
                AlaLiveCategoryActivity.this.baR.setVisibility(8);
                AlaLiveCategoryActivity.this.mRootView.setVisibility(0);
            }
        });
        this.baR.setTitle(a.i.sdk_net_fail_tip_rank);
        this.baR.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.baR.setVisibility(0);
        this.mRootView.setVisibility(8);
    }
}
