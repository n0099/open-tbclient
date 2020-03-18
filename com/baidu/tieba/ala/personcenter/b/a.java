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
import com.baidu.tieba.ala.personcenter.c.l;
import com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a implements com.baidu.tieba.ala.personcenter.d.a, com.baidu.tieba.ala.personcenter.model.a {
    private TbPageContext cVv;
    private int eLQ;
    private NoNetworkView elL;
    private g euG;
    private AlaPersonCenterModel fuN;
    private b fuO;
    private c fuP;
    private BdTypeListView fuQ;
    private ImageView fuR;
    private TextView fuS;
    private boolean fuT;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean eLP = true;
    private boolean esB = false;
    private boolean fuU = false;
    private CustomMessageListener fuV = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.fuN != null) {
                a.this.fuN.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.eLQ = 0;
        this.fuT = false;
        this.cVv = tbPageContext;
        this.fuT = z;
        this.eLQ = (int) this.cVv.getResources().getDimension(R.dimen.ds400);
        this.fuN = new AlaPersonCenterModel(tbPageContext);
        this.fuN.a(this);
        eI(tbPageContext.getPageActivity());
    }

    private void bcB() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.cVv.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.cVv.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.cVv.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.esB) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.esB = true;
    }

    private void bcC() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.esB = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void eI(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.fuT) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.cVv.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.fuR = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.fuT) {
            this.fuS = this.mNavigationBar.setCenterTextTitle(this.cVv.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.cVv.getResources().getString(R.string.forum));
            this.fuS = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.elL = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.fuQ = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.fuQ.setItemsCanFocus(true);
        this.fuQ.setVisibility(8);
        this.fuP = new c(this.cVv, this.fuQ, this);
        this.fuP.jZ(this.fuT);
        if (this.fuT) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.euG = new g(this.cVv.getPageActivity());
        this.euG.attachView(this.mRootView, false);
        this.fuQ.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bgJ();
                a.this.bgK();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgJ() {
        if (Build.VERSION.SDK_INT >= 11 && this.fuQ.getChildAt(0) != null) {
            int dimension = (int) this.cVv.getResources().getDimension(R.dimen.ds98);
            int i = this.eLQ - (-this.fuQ.getChildAt(0).getTop());
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
            if (this.fuQ.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgK() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.eLP) {
                    this.eLP = true;
                }
            } else if (this.eLP) {
                this.eLP = false;
            }
            a(alpha, this.eLP ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.esB) {
            am.setNavbarIconSrc(this.fuR, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            am.setNavbarTitleColor(this.fuS, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            am.setNavbarIconSrc(this.fuR, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            am.setNavbarTitleColor(this.fuS, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.fuS.setAlpha(f);
        this.fuR.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cVv, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        am.setNavbarIconSrc(this.fuR, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.fuQ.setDivider(am.getDrawable(i, (int) R.color.cp_bg_line_c));
        this.fuQ.setDividerHeight(this.cVv.getResources().getDimensionPixelSize(R.dimen.ds2));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.fuQ.getAdapter() instanceof e) {
            this.fuQ.getAdapter().notifyDataSetChanged();
            if (this.euG != null) {
                this.euG.onChangeSkinType();
            }
            this.elL.onChangeSkinType(this.cVv, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.cVv.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.cVv.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.cVv.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.cVv.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.fuN.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.fuN.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void b(Object obj, int i) {
        if (obj != null) {
            bcC();
            if ((obj instanceof b) && i == 1) {
                this.fuO = (b) obj;
                this.fuO.setIsHost(this.mIsHost);
                this.euG.dettachView(this.mRootView);
                this.fuQ.setVisibility(0);
                bsn();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.euG != null) {
            this.euG.dettachView(this.mRootView);
        }
        this.fuQ.setVisibility(0);
        if (this.fuQ != null && v.isEmpty(this.fuQ.getData())) {
            bcB();
        }
    }

    public void onDestory() {
        if (this.euG != null) {
            this.euG.release();
            this.euG.dettachView(this.mRootView);
        }
        if (this.fuN != null) {
            this.fuN.destory();
        }
    }

    public void bsn() {
        ArrayList arrayList;
        if (this.fuO != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                d dVar = new d();
                dVar.a(this.fuO);
                arrayList.add(dVar);
                k kVar = new k();
                kVar.a(this.fuO);
                arrayList.add(kVar);
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.fuO);
                arrayList.add(hVar);
                i iVar = new i();
                iVar.a(this.fuO);
                arrayList.add(iVar);
                f fVar = new f();
                fVar.a(this.fuO);
                arrayList.add(fVar);
                j jVar = new j();
                jVar.a(this.fuO);
                arrayList.add(jVar);
                com.baidu.tieba.ala.personcenter.c.e eVar = new com.baidu.tieba.ala.personcenter.c.e();
                eVar.a(this.fuO);
                arrayList.add(eVar);
                com.baidu.tieba.ala.personcenter.c.c cVar = new com.baidu.tieba.ala.personcenter.c.c();
                cVar.a(this.fuO);
                arrayList.add(cVar);
                l lVar = new l();
                lVar.a(this.fuO);
                arrayList.add(lVar);
            } else {
                arrayList = new ArrayList(4);
                d dVar2 = new d();
                dVar2.a(this.fuO);
                arrayList.add(dVar2);
            }
            this.fuP.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.fuP != null) {
            this.fuP.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.fuP != null) {
            this.fuP.setForumName(str);
        }
        if (!this.fuT) {
            this.fuS = this.mNavigationBar.setCenterTextTitle(this.cVv.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.cVv.getResources().getString(R.string.forum));
        this.fuS = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void zF(String str) {
        if (this.fuP != null) {
            this.fuP.zF(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void qO(int i) {
        if (i == 1) {
            this.fuU = true;
        }
    }

    public void onResume() {
        if (this.fuU) {
            this.fuU = false;
            loadData();
        }
    }
}
