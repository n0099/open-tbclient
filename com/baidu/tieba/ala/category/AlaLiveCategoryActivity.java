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
/* loaded from: classes10.dex */
public class AlaLiveCategoryActivity extends BaseActivity<AlaLiveCategoryActivity> {
    private CommonEmptyView btf;
    private TextView gJG;
    private BdTypeListView gJH;
    private BdTypeListView gJI;
    private a gJJ;
    private com.baidu.tieba.ala.category.a.a gJK;
    private c gJL;
    private String gJM;
    private String gJN;
    private com.baidu.tieba.ala.category.b.c gJO;
    private com.baidu.tieba.ala.category.b.c gJP;
    private MessageListener<?> gJQ = new CustomMessageListener(2913200) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.c) {
                AlaLiveCategoryActivity.this.a((com.baidu.tieba.ala.category.b.c) customResponsedMessage.getData());
            }
        }
    };
    private MessageListener<?> gJR = new CustomMessageListener(2913201) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.4
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
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.activity_ala_live_category);
        registerListener();
        initData();
        initView();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gJP != null && !TextUtils.equals(this.gJP.getId(), this.gJN)) {
            com.baidu.tieba.ala.category.b.a aVar = new com.baidu.tieba.ala.category.b.a();
            aVar.c(this.gJO);
            aVar.d(this.gJP);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913202, aVar));
        }
    }

    private void registerListener() {
        registerListener(this.gJQ);
        registerListener(this.gJR);
    }

    private void initData() {
        this.gJM = getIntent().getStringExtra("cat1_id");
        this.gJN = getIntent().getStringExtra("cat2_id");
        this.gJJ = new com.baidu.tieba.ala.category.c.a(getPageContext());
        this.gJJ.a(new a.InterfaceC0622a() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.1
            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0622a
            public void onLoadSuccess() {
                List<IAdapterData> bSK = AlaLiveCategoryActivity.this.gJJ.bSK();
                AlaLiveCategoryActivity.this.gJH.setData(bSK);
                AlaLiveCategoryActivity.this.cs(bSK);
            }

            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0622a
            public void aF(int i, String str) {
                AlaLiveCategoryActivity.this.bQU();
            }
        });
        this.gJK = new com.baidu.tieba.ala.category.a.a(getPageContext().getContext(), this.gJJ.getUniqueId());
        this.gJL = new c(getPageContext().getContext(), this.gJJ.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cs(List<IAdapterData> list) {
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
                if (TextUtils.equals(((com.baidu.tieba.ala.category.b.c) next).getId(), this.gJM)) {
                    for (IAdapterData iAdapterData : ((com.baidu.tieba.ala.category.b.c) next).bSL()) {
                        if ((iAdapterData instanceof com.baidu.tieba.ala.category.b.c) && TextUtils.equals(((com.baidu.tieba.ala.category.b.c) iAdapterData).getId(), this.gJN)) {
                            this.gJO = (com.baidu.tieba.ala.category.b.c) next;
                            this.gJP = (com.baidu.tieba.ala.category.b.c) iAdapterData;
                            break loop0;
                        }
                    }
                    cVar2 = cVar;
                } else {
                    cVar2 = cVar;
                }
            }
        }
        if (this.gJO != null) {
            cVar = this.gJO;
        }
        a(cVar);
        b(this.gJP);
    }

    private void initView() {
        this.mRootView = (RelativeLayout) findViewById(a.f.root_view);
        this.btf = (CommonEmptyView) findViewById(a.f.empty_view);
        this.mNavigationBar = (NavigationBar) findViewById(a.f.ala_live_category_nav_bar);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.h.ala_live_category_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.f.widget_navi_back_button), a.e.sdk_d_icon_return_n, a.e.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.c.sdk_cp_cont_i, a.c.sdk_cp_cont_i);
        this.gJG = (TextView) findViewById(a.f.selected_category_tv);
        this.gJH = (BdTypeListView) findViewById(a.f.ala_live_category_one_list);
        this.gJI = (BdTypeListView) findViewById(a.f.ala_live_category_two_list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.gJK);
        this.gJH.addAdapters(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.gJL);
        this.gJI.addAdapters(arrayList2);
        ViewGroup.LayoutParams layoutParams = this.gJH.getLayoutParams();
        layoutParams.width = (ScreenHelper.getScreenWidth(getPageContext().getContext()) * 85) / 375;
        this.gJH.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.gJJ.bSP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.c cVar) {
        if (cVar != null) {
            this.gJK.FE(cVar.getId());
            this.gJI.setData(cVar.bSL());
            this.gJI.setTag(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.category.b.c cVar) {
        if (cVar != null) {
            this.gJP = cVar;
            this.gJO = (com.baidu.tieba.ala.category.b.c) this.gJI.getTag();
            this.gJL.FE(this.gJP.getId());
            this.gJG.setText(cVar.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQU() {
        this.btf.reset();
        this.btf.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveCategoryActivity.this.loadData();
                AlaLiveCategoryActivity.this.btf.setVisibility(8);
                AlaLiveCategoryActivity.this.mRootView.setVisibility(0);
            }
        });
        this.btf.setTitle(a.h.sdk_net_fail_tip_rank);
        this.btf.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.btf.setVisibility(0);
        this.mRootView.setVisibility(8);
    }
}
