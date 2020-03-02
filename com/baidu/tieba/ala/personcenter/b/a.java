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
    private TbPageContext cVh;
    private int eLh;
    private NoNetworkView eli;
    private g etX;
    private AlaPersonCenterModel ftV;
    private b ftW;
    private c ftX;
    private BdTypeListView ftY;
    private ImageView ftZ;
    private TextView fua;
    private boolean fub;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean eLg = true;
    private boolean erS = false;
    private boolean fuc = false;
    private CustomMessageListener fud = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.ftV != null) {
                a.this.ftV.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.eLh = 0;
        this.fub = false;
        this.cVh = tbPageContext;
        this.fub = z;
        this.eLh = (int) this.cVh.getResources().getDimension(R.dimen.ds400);
        this.ftV = new AlaPersonCenterModel(tbPageContext);
        this.ftV.a(this);
        eJ(tbPageContext.getPageActivity());
    }

    private void bcw() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.cVh.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.cVh.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.cVh.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.erS) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.erS = true;
    }

    private void bcx() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.erS = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void eJ(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.fub) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.cVh.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.ftZ = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.fub) {
            this.fua = this.mNavigationBar.setCenterTextTitle(this.cVh.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.cVh.getResources().getString(R.string.forum));
            this.fua = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.eli = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.ftY = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.ftY.setItemsCanFocus(true);
        this.ftY.setVisibility(8);
        this.ftX = new c(this.cVh, this.ftY, this);
        if (this.fub) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.etX = new g(this.cVh.getPageActivity());
        this.etX.attachView(this.mRootView, false);
        this.ftY.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bgD();
                a.this.bgE();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgD() {
        if (Build.VERSION.SDK_INT >= 11 && this.ftY.getChildAt(0) != null) {
            int dimension = (int) this.cVh.getResources().getDimension(R.dimen.ds98);
            int i = this.eLh - (-this.ftY.getChildAt(0).getTop());
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
            if (this.ftY.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgE() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.eLg) {
                    this.eLg = true;
                }
            } else if (this.eLg) {
                this.eLg = false;
            }
            a(alpha, this.eLg ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.erS) {
            am.setNavbarIconSrc(this.ftZ, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            am.setNavbarTitleColor(this.fua, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            am.setNavbarIconSrc(this.ftZ, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            am.setNavbarTitleColor(this.fua, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.fua.setAlpha(f);
        this.ftZ.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cVh, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        am.setNavbarIconSrc(this.ftZ, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.ftY.setDivider(am.getDrawable(i, (int) R.color.cp_bg_line_c));
        this.ftY.setDividerHeight(this.cVh.getResources().getDimensionPixelSize(R.dimen.ds2));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.ftY.getAdapter() instanceof e) {
            this.ftY.getAdapter().notifyDataSetChanged();
            if (this.etX != null) {
                this.etX.onChangeSkinType();
            }
            this.eli.onChangeSkinType(this.cVh, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.cVh.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.cVh.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.cVh.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.cVh.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.ftV.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.ftV.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void b(Object obj, int i) {
        if (obj != null) {
            bcx();
            if ((obj instanceof b) && i == 1) {
                this.ftW = (b) obj;
                this.ftW.setIsHost(this.mIsHost);
                this.etX.dettachView(this.mRootView);
                this.ftY.setVisibility(0);
                bsg();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.etX != null) {
            this.etX.dettachView(this.mRootView);
        }
        this.ftY.setVisibility(0);
        if (this.ftY != null && v.isEmpty(this.ftY.getData())) {
            bcw();
        }
    }

    public void onDestory() {
        if (this.etX != null) {
            this.etX.release();
            this.etX.dettachView(this.mRootView);
        }
        if (this.ftV != null) {
            this.ftV.destory();
        }
    }

    public void bsg() {
        ArrayList arrayList;
        if (this.ftW != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                d dVar = new d();
                dVar.a(this.ftW);
                arrayList.add(dVar);
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.ftW);
                arrayList.add(hVar);
                i iVar = new i();
                iVar.a(this.ftW);
                arrayList.add(iVar);
                f fVar = new f();
                fVar.a(this.ftW);
                arrayList.add(fVar);
                j jVar = new j();
                jVar.a(this.ftW);
                arrayList.add(jVar);
                com.baidu.tieba.ala.personcenter.c.e eVar = new com.baidu.tieba.ala.personcenter.c.e();
                eVar.a(this.ftW);
                arrayList.add(eVar);
                com.baidu.tieba.ala.personcenter.c.c cVar = new com.baidu.tieba.ala.personcenter.c.c();
                cVar.a(this.ftW);
                arrayList.add(cVar);
                k kVar = new k();
                kVar.a(this.ftW);
                arrayList.add(kVar);
            } else {
                arrayList = new ArrayList(4);
                d dVar2 = new d();
                dVar2.a(this.ftW);
                arrayList.add(dVar2);
            }
            this.ftX.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (!this.fub) {
            this.fua = this.mNavigationBar.setCenterTextTitle(this.cVh.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.cVh.getResources().getString(R.string.forum));
        this.fua = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void qM(int i) {
        if (i == 1) {
            this.fuc = true;
        }
    }

    public void onResume() {
        if (this.fuc) {
            this.fuc = false;
            loadData();
        }
    }
}
