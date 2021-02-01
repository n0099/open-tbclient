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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.a.d;
import com.baidu.tieba.ala.personcenter.c.c;
import com.baidu.tieba.ala.personcenter.c.f;
import com.baidu.tieba.ala.personcenter.c.j;
import com.baidu.tieba.ala.personcenter.c.k;
import com.baidu.tieba.ala.personcenter.c.l;
import com.baidu.tieba.ala.personcenter.c.m;
import com.baidu.tieba.ala.personcenter.c.n;
import com.baidu.tieba.ala.personcenter.c.o;
import com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a implements com.baidu.tieba.ala.personcenter.d.a, com.baidu.tieba.ala.personcenter.model.a {
    private TbPageContext eUY;
    private NoNetworkView gAh;
    private g gJn;
    private AlaPersonCenterModel hZn;
    private c hZo;
    private d hZp;
    private BdTypeListView hZq;
    private ImageView hZr;
    private TextView hZs;
    private int hkw;
    private boolean isInFrs;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean hkv = true;
    private boolean gHj = false;
    private boolean hZt = false;
    private CustomMessageListener hZu = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hZn != null) {
                a.this.hZn.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.hkw = 0;
        this.isInFrs = false;
        this.eUY = tbPageContext;
        this.isInFrs = z;
        this.hkw = (int) this.eUY.getResources().getDimension(R.dimen.ds400);
        this.hZn = new AlaPersonCenterModel(tbPageContext);
        this.hZn.a(this);
        gb(tbPageContext.getPageActivity());
    }

    private void bRu() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.eUY.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.eUY.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.eUY.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.gHj) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gHj = true;
    }

    private void WZ() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.gHj = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void gb(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.isInFrs) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.eUY.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.hZr = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.isInFrs) {
            this.hZs = this.mNavigationBar.setCenterTextTitle(this.eUY.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eUY.getResources().getString(R.string.forum));
            this.hZs = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.gAh = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.hZq = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.hZq.setItemsCanFocus(true);
        this.hZq.setVisibility(8);
        this.hZp = new d(this.eUY, this.hZq, this);
        this.hZp.mw(this.isInFrs);
        if (this.isInFrs) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.gJn = new g(this.eUY.getPageActivity());
        this.gJn.attachView(this.mRootView, false);
        this.hZq.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bYm();
                a.this.bYn();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYm() {
        if (Build.VERSION.SDK_INT >= 11 && this.hZq.getChildAt(0) != null) {
            int dimension = (int) this.eUY.getResources().getDimension(R.dimen.ds98);
            int i = this.hkw - (-this.hZq.getChildAt(0).getTop());
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
            if (this.hZq.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYn() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.hkv) {
                    this.hkv = true;
                }
            } else if (this.hkv) {
                this.hkv = false;
            }
            b(alpha, this.hkv ? false : true);
        }
    }

    protected void b(float f, boolean z) {
        if (z || this.gHj) {
            ap.setNavbarIconSrc(this.hZr, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            ap.setNavbarTitleColor(this.hZs, R.color.CAM_X0105, R.color.s_navbar_title_color);
        } else {
            ap.setNavbarIconSrc(this.hZr, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            ap.setNavbarTitleColor(this.hZs, R.color.CAM_X0101, R.color.CAM_X0101);
        }
        this.hZs.setAlpha(f);
        this.hZr.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.eUY, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        ap.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.CAM_X0101, R.color.CAM_X0101);
        ap.setNavbarIconSrc(this.hZr, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.hZq.setDivider(ap.getDrawable(i, R.color.CAM_X0204));
        this.hZq.setDividerHeight(this.eUY.getResources().getDimensionPixelSize(R.dimen.ds2));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.hZq.getAdapter() instanceof e) {
            this.hZq.getAdapter().notifyDataSetChanged();
            if (this.gJn != null) {
                this.gJn.onChangeSkinType();
            }
            this.gAh.onChangeSkinType(this.eUY, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.eUY.getResources().getColor(R.color.CAM_X0207_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.eUY.getResources().getColor(R.color.CAM_X0201_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.eUY.getResources().getColor(R.color.CAM_X0207));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.eUY.getResources().getColor(R.color.CAM_X0201));
            }
        }
    }

    public void h(String str, String str2, String str3, boolean z) {
        this.hZn.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.hZn.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void d(Object obj, int i) {
        if (obj != null) {
            WZ();
            if ((obj instanceof c) && i == 1) {
                this.hZo = (c) obj;
                this.hZo.setIsHost(this.mIsHost);
                this.gJn.dettachView(this.mRootView);
                this.hZq.setVisibility(0);
                cmM();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.gJn != null) {
            this.gJn.dettachView(this.mRootView);
        }
        this.hZq.setVisibility(0);
        if (this.hZq != null && y.isEmpty(this.hZq.getData())) {
            bRu();
        }
    }

    public void onDestory() {
        if (this.gJn != null) {
            this.gJn.release();
            this.gJn.dettachView(this.mRootView);
        }
        if (this.hZn != null) {
            this.hZn.destory();
        }
    }

    public void cmM() {
        ArrayList arrayList;
        if (this.hZo != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                f fVar = new f();
                fVar.a(this.hZo);
                arrayList.add(fVar);
                m mVar = new m();
                mVar.a(this.hZo);
                arrayList.add(mVar);
                j jVar = new j();
                jVar.a(this.hZo);
                arrayList.add(jVar);
                k kVar = new k();
                kVar.a(this.hZo);
                arrayList.add(kVar);
                if (this.hZo.hZD != null) {
                    com.baidu.tieba.ala.personcenter.c.d dVar = new com.baidu.tieba.ala.personcenter.c.d();
                    dVar.a(this.hZo);
                    arrayList.add(dVar);
                }
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.hZo);
                arrayList.add(hVar);
                l lVar = new l();
                lVar.a(this.hZo);
                arrayList.add(lVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.hZo);
                arrayList.add(gVar);
                com.baidu.tieba.ala.personcenter.c.e eVar = new com.baidu.tieba.ala.personcenter.c.e();
                eVar.a(this.hZo);
                arrayList.add(eVar);
                o oVar = new o();
                oVar.a(this.hZo);
                arrayList.add(oVar);
                n nVar = new n();
                nVar.a(this.hZo);
                arrayList.add(nVar);
            } else {
                arrayList = new ArrayList(4);
                f fVar2 = new f();
                fVar2.a(this.hZo);
                arrayList.add(fVar2);
            }
            this.hZp.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.hZp != null) {
            this.hZp.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.hZp != null) {
            this.hZp.setForumName(str);
        }
        if (!this.isInFrs) {
            this.hZs = this.mNavigationBar.setCenterTextTitle(this.eUY.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eUY.getResources().getString(R.string.forum));
        this.hZs = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void Im(String str) {
        if (this.hZp != null) {
            this.hZp.Im(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void wr(int i) {
        if (i == 1) {
            this.hZt = true;
        }
    }

    public void onResume() {
        if (this.hZt) {
            this.hZt = false;
            loadData();
        }
    }
}
