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
    private CommonEmptyView bmS;
    private c geA;
    private c geB;
    private MessageListener<?> geC = new CustomMessageListener(2913200) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof c) {
                AlaLiveCategoryActivity.this.a((c) customResponsedMessage.getData());
            }
        }
    };
    private MessageListener<?> geD = new CustomMessageListener(2913201) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof c) {
                AlaLiveCategoryActivity.this.b((c) customResponsedMessage.getData());
            }
        }
    };
    private TextView ges;
    private BdTypeListView get;
    private BdTypeListView geu;
    private a gev;
    private com.baidu.tieba.ala.category.a.a gew;
    private com.baidu.tieba.ala.category.a.c gex;
    private String gey;
    private String gez;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.activity_ala_live_category);
        registerListener();
        initData();
        initView();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.geB != null && !TextUtils.equals(this.geB.getId(), this.gez)) {
            com.baidu.tieba.ala.category.b.a aVar = new com.baidu.tieba.ala.category.b.a();
            aVar.c(this.geA);
            aVar.d(this.geB);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913202, aVar));
        }
    }

    private void registerListener() {
        registerListener(this.geC);
        registerListener(this.geD);
    }

    private void initData() {
        this.gey = getIntent().getStringExtra("cat1_id");
        this.gez = getIntent().getStringExtra("cat2_id");
        this.gev = new com.baidu.tieba.ala.category.c.a(getPageContext());
        this.gev.a(new a.InterfaceC0608a() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.1
            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0608a
            public void aNt() {
                List<IAdapterData> bLQ = AlaLiveCategoryActivity.this.gev.bLQ();
                AlaLiveCategoryActivity.this.get.setData(bLQ);
                AlaLiveCategoryActivity.this.bQ(bLQ);
            }

            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0608a
            public void ay(int i, String str) {
                AlaLiveCategoryActivity.this.bKc();
            }
        });
        this.gew = new com.baidu.tieba.ala.category.a.a(getPageContext().getContext(), this.gev.getUniqueId());
        this.gex = new com.baidu.tieba.ala.category.a.c(getPageContext().getContext(), this.gev.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ(List<IAdapterData> list) {
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
                if (TextUtils.equals(((c) next).getId(), this.gey)) {
                    for (IAdapterData iAdapterData : ((c) next).bLR()) {
                        if ((iAdapterData instanceof c) && TextUtils.equals(((c) iAdapterData).getId(), this.gez)) {
                            this.geA = (c) next;
                            this.geB = (c) iAdapterData;
                            break loop0;
                        }
                    }
                    cVar2 = cVar;
                } else {
                    cVar2 = cVar;
                }
            }
        }
        if (this.geA != null) {
            cVar = this.geA;
        }
        a(cVar);
        b(this.geB);
    }

    private void initView() {
        this.mRootView = (RelativeLayout) findViewById(a.g.root_view);
        this.bmS = (CommonEmptyView) findViewById(a.g.empty_view);
        this.mNavigationBar = (NavigationBar) findViewById(a.g.ala_live_category_nav_bar);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.i.ala_live_category_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button), a.f.sdk_d_icon_return_n, a.f.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.d.sdk_cp_cont_i, a.d.sdk_cp_cont_i);
        this.ges = (TextView) findViewById(a.g.selected_category_tv);
        this.get = (BdTypeListView) findViewById(a.g.ala_live_category_one_list);
        this.geu = (BdTypeListView) findViewById(a.g.ala_live_category_two_list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.gew);
        this.get.addAdapters(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.gex);
        this.geu.addAdapters(arrayList2);
        ViewGroup.LayoutParams layoutParams = this.get.getLayoutParams();
        layoutParams.width = (ScreenHelper.getScreenWidth(getPageContext().getContext()) * 85) / 375;
        this.get.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.gev.bLV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar != null) {
            this.gew.FP(cVar.getId());
            this.geu.setData(cVar.bLR());
            this.geu.setTag(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            this.geB = cVar;
            this.geA = (c) this.geu.getTag();
            this.gex.FP(this.geB.getId());
            this.ges.setText(cVar.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKc() {
        this.bmS.reset();
        this.bmS.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveCategoryActivity.this.loadData();
                AlaLiveCategoryActivity.this.bmS.setVisibility(8);
                AlaLiveCategoryActivity.this.mRootView.setVisibility(0);
            }
        });
        this.bmS.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bmS.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.bmS.setVisibility(0);
        this.mRootView.setVisibility(8);
    }
}
