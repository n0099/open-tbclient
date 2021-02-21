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
import com.baidu.live.adp.framework.message.HttpMessage;
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
/* loaded from: classes11.dex */
public class AlaLiveCategoryActivity extends BaseActivity<AlaLiveCategoryActivity> {
    private CommonEmptyView bwJ;
    private TextView gMA;
    private BdTypeListView gMB;
    private BdTypeListView gMC;
    private a gMD;
    private com.baidu.tieba.ala.category.a.a gME;
    private c gMF;
    private String gMG;
    private String gMH;
    private com.baidu.tieba.ala.category.b.c gMI;
    private com.baidu.tieba.ala.category.b.c gMJ;
    private MessageListener<?> gMK = new CustomMessageListener(2913200) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.category.b.c) {
                AlaLiveCategoryActivity.this.a((com.baidu.tieba.ala.category.b.c) customResponsedMessage.getData());
            }
        }
    };
    private MessageListener<?> gML = new CustomMessageListener(2913201) { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.4
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
        if (this.gMJ != null && !TextUtils.equals(this.gMJ.getId(), this.gMH)) {
            com.baidu.tieba.ala.category.b.a aVar = new com.baidu.tieba.ala.category.b.a();
            aVar.c(this.gMI);
            aVar.d(this.gMJ);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913202, aVar));
        }
    }

    private void registerListener() {
        registerListener(this.gMK);
        registerListener(this.gML);
    }

    private void initData() {
        this.gMG = getIntent().getStringExtra("cat1_id");
        this.gMH = getIntent().getStringExtra("cat2_id");
        this.gMD = new com.baidu.tieba.ala.category.c.a(getPageContext());
        this.gMD.a(new a.InterfaceC0622a() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.1
            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0622a
            public void onLoadSuccess() {
                List<IAdapterData> bTu = AlaLiveCategoryActivity.this.gMD.bTu();
                AlaLiveCategoryActivity.this.gMB.setData(bTu);
                AlaLiveCategoryActivity.this.cn(bTu);
            }

            @Override // com.baidu.tieba.ala.category.c.a.InterfaceC0622a
            public void aJ(int i, String str) {
                AlaLiveCategoryActivity.this.bRF();
            }
        });
        this.gME = new com.baidu.tieba.ala.category.a.a(getPageContext().getContext(), this.gMD.getUniqueId());
        this.gMF = new c(getPageContext().getContext(), this.gMD.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(List<IAdapterData> list) {
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
                if (TextUtils.equals(((com.baidu.tieba.ala.category.b.c) next).getId(), this.gMG)) {
                    for (IAdapterData iAdapterData : ((com.baidu.tieba.ala.category.b.c) next).bTv()) {
                        if ((iAdapterData instanceof com.baidu.tieba.ala.category.b.c) && TextUtils.equals(((com.baidu.tieba.ala.category.b.c) iAdapterData).getId(), this.gMH)) {
                            this.gMI = (com.baidu.tieba.ala.category.b.c) next;
                            this.gMJ = (com.baidu.tieba.ala.category.b.c) iAdapterData;
                            break loop0;
                        }
                    }
                    cVar2 = cVar;
                } else {
                    cVar2 = cVar;
                }
            }
        }
        if (this.gMI != null) {
            cVar = this.gMI;
        }
        a(cVar);
        b(this.gMJ);
    }

    private void initView() {
        this.mRootView = (RelativeLayout) findViewById(a.f.root_view);
        this.bwJ = (CommonEmptyView) findViewById(a.f.empty_view);
        this.mNavigationBar = (NavigationBar) findViewById(a.f.ala_live_category_nav_bar);
        TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(a.h.ala_live_category_title));
        SkinManager.setNavbarIconSrc((ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.f.widget_navi_back_button), a.e.sdk_d_icon_return_n, a.e.sdk_d_icon_return_n);
        SkinManager.setNavbarTitleColor(centerTextTitle, a.c.sdk_cp_cont_i, a.c.sdk_cp_cont_i);
        this.gMA = (TextView) findViewById(a.f.selected_category_tv);
        this.gMB = (BdTypeListView) findViewById(a.f.ala_live_category_one_list);
        this.gMC = (BdTypeListView) findViewById(a.f.ala_live_category_two_list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.gME);
        this.gMB.addAdapters(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.gMF);
        this.gMC.addAdapters(arrayList2);
        ViewGroup.LayoutParams layoutParams = this.gMB.getLayoutParams();
        layoutParams.width = (ScreenHelper.getScreenWidth(getPageContext().getContext()) * 85) / 375;
        this.gMB.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.gMD.bTz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.category.b.c cVar) {
        if (cVar != null) {
            this.gME.Ge(cVar.getId());
            this.gMC.setData(cVar.bTv());
            this.gMC.setTag(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.category.b.c cVar) {
        if (cVar != null) {
            this.gMJ = cVar;
            this.gMI = (com.baidu.tieba.ala.category.b.c) this.gMC.getTag();
            this.gMF.Ge(this.gMJ.getId());
            this.gMA.setText(cVar.getName());
            Gd(this.gMJ.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRF() {
        this.bwJ.reset();
        this.bwJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.category.AlaLiveCategoryActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveCategoryActivity.this.loadData();
                AlaLiveCategoryActivity.this.bwJ.setVisibility(8);
                AlaLiveCategoryActivity.this.mRootView.setVisibility(0);
            }
        });
        this.bwJ.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bwJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        this.bwJ.setVisibility(0);
        this.mRootView.setVisibility(8);
    }

    public void Gd(String str) {
        HttpMessage httpMessage = new HttpMessage(1021147);
        httpMessage.addParam("category_id", str);
        sendMessage(httpMessage);
    }
}
