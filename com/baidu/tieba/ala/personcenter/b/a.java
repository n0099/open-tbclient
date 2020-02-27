package com.baidu.tieba.ala.personcenter.b;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.a.c;
import com.baidu.tieba.ala.personcenter.c.b;
import com.baidu.tieba.ala.personcenter.c.d;
import com.baidu.tieba.ala.personcenter.c.f;
import com.baidu.tieba.ala.personcenter.c.i;
import com.baidu.tieba.ala.personcenter.c.j;
import com.baidu.tieba.ala.personcenter.c.k;
import com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a implements com.baidu.tieba.ala.personcenter.d.a, com.baidu.tieba.ala.personcenter.model.a {
    private TbPageContext cVg;
    private int eLg;
    private NoNetworkView elh;
    private g etW;
    private AlaPersonCenterModel ftU;
    private b ftV;
    private c ftW;
    private BdTypeListView ftX;
    private ImageView ftY;
    private TextView ftZ;
    private boolean fua;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean eLf = true;
    private boolean erR = false;
    private boolean fub = false;
    private CustomMessageListener fuc = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.ftU != null) {
                a.this.ftU.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.eLg = 0;
        this.fua = false;
        this.cVg = tbPageContext;
        this.fua = z;
        this.eLg = (int) this.cVg.getResources().getDimension(R.dimen.ds400);
        this.ftU = new AlaPersonCenterModel(tbPageContext);
        this.ftU.a(this);
        eJ(tbPageContext.getPageActivity());
    }

    private void bcu() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.cVg.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.cVg.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.cVg.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.erR) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.erR = true;
    }

    private void bcv() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.erR = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void eJ(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.fua) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.cVg.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.ftY = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.fua) {
            this.ftZ = this.mNavigationBar.setCenterTextTitle(this.cVg.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.cVg.getResources().getString(R.string.forum));
            this.ftZ = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.elh = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.ftX = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.ftX.setItemsCanFocus(true);
        this.ftX.setVisibility(8);
        this.ftW = new c(this.cVg, this.ftX, this);
        if (this.fua) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.etW = new g(this.cVg.getPageActivity());
        this.etW.attachView(this.mRootView, false);
        this.ftX.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bgB();
                a.this.bgC();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgB() {
        if (Build.VERSION.SDK_INT >= 11 && this.ftX.getChildAt(0) != null) {
            int dimension = (int) this.cVg.getResources().getDimension(R.dimen.ds98);
            int i = this.eLg - (-this.ftX.getChildAt(0).getTop());
            if (i < dimension) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
                }
            } else if (i >= dimension && i <= dimension * 2) {
                float f = 1.0f - (((i - dimension) * 1.0f) / dimension);
                this.mNavigationBar.getBarBgView().setAlpha(f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
            } else if (i > dimension * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            }
            if (this.ftX.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgC() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.eLf) {
                    this.eLf = true;
                }
            } else if (this.eLf) {
                this.eLf = false;
            }
            a(alpha, this.eLf ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.erR) {
            am.setNavbarIconSrc(this.ftY, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            am.setNavbarTitleColor(this.ftZ, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            am.setNavbarIconSrc(this.ftY, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            am.setNavbarTitleColor(this.ftZ, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.ftZ.setAlpha(f);
        this.ftY.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cVg, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        am.setNavbarIconSrc(this.ftY, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.ftX.setDivider(am.getDrawable(i, (int) R.color.cp_bg_line_c));
        this.ftX.setDividerHeight(this.cVg.getResources().getDimensionPixelSize(R.dimen.ds2));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.ftX.getAdapter() instanceof e) {
            this.ftX.getAdapter().notifyDataSetChanged();
            if (this.etW != null) {
                this.etW.onChangeSkinType();
            }
            this.elh.onChangeSkinType(this.cVg, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.cVg.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.cVg.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.cVg.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.cVg.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.ftU.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.ftU.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void b(Object obj, int i) {
        if (obj != null) {
            bcv();
            if ((obj instanceof b) && i == 1) {
                this.ftV = (b) obj;
                this.ftV.setIsHost(this.mIsHost);
                this.etW.dettachView(this.mRootView);
                this.ftX.setVisibility(0);
                bse();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.etW != null) {
            this.etW.dettachView(this.mRootView);
        }
        this.ftX.setVisibility(0);
        if (this.ftX != null && v.isEmpty(this.ftX.getData())) {
            bcu();
        }
    }

    public void onDestory() {
        if (this.etW != null) {
            this.etW.release();
            this.etW.dettachView(this.mRootView);
        }
        if (this.ftU != null) {
            this.ftU.destory();
        }
    }

    public void bse() {
        ArrayList arrayList;
        if (this.ftV != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                d dVar = new d();
                dVar.a(this.ftV);
                arrayList.add(dVar);
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.ftV);
                arrayList.add(hVar);
                i iVar = new i();
                iVar.a(this.ftV);
                arrayList.add(iVar);
                f fVar = new f();
                fVar.a(this.ftV);
                arrayList.add(fVar);
                j jVar = new j();
                jVar.a(this.ftV);
                arrayList.add(jVar);
                com.baidu.tieba.ala.personcenter.c.e eVar = new com.baidu.tieba.ala.personcenter.c.e();
                eVar.a(this.ftV);
                arrayList.add(eVar);
                com.baidu.tieba.ala.personcenter.c.c cVar = new com.baidu.tieba.ala.personcenter.c.c();
                cVar.a(this.ftV);
                arrayList.add(cVar);
                k kVar = new k();
                kVar.a(this.ftV);
                arrayList.add(kVar);
            } else {
                arrayList = new ArrayList(4);
                d dVar2 = new d();
                dVar2.a(this.ftV);
                arrayList.add(dVar2);
            }
            this.ftW.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (!this.fua) {
            this.ftZ = this.mNavigationBar.setCenterTextTitle(this.cVg.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.cVg.getResources().getString(R.string.forum));
        this.ftZ = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void qM(int i) {
        if (i == 1) {
            this.fub = true;
        }
    }

    public void onResume() {
        if (this.fub) {
            this.fub = false;
            loadData();
        }
    }
}
