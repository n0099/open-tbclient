package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.concern.d;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes21.dex */
public class ConcernPageView extends FrameLayout {
    private PbListView giV;
    private int glw;
    private g grV;
    private com.baidu.tieba.homepage.personalize.bigday.a jwf;
    private BdTypeRecyclerView jwg;
    private com.baidu.tieba.homepage.concern.a jwh;
    private a jwi;
    private d jwj;
    private ConcernNotLoginLayout jwk;
    private boolean jwl;
    private ScrollFragmentTabHost jwm;
    ScrollFragmentTabHost.a jwn;
    private BigdaySwipeRefreshLayout jwo;
    private d.a jwp;
    private View.OnClickListener jwq;
    private CustomMessageListener jwr;
    private CustomMessageListener jws;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes21.dex */
    public interface a {
        void Lc(String str);

        void ag(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jwm = scrollFragmentTabHost;
        if (this.jwm != null) {
            this.jwm.b(this.jwn);
            this.jwm.a(this.jwn);
        }
    }

    public void completePullRefresh() {
        if (this.jwo != null) {
            this.jwo.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jwh != null) {
            this.jwh.setPageUniqueId(bdUniqueId);
        }
        if (this.jwj != null) {
            this.jwj.s(bdUniqueId);
        }
        if (this.jwf != null) {
            this.jwf.setTag(bdUniqueId);
        }
        if (this.jwr != null) {
            this.jwr.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jwr);
        }
        MessageManager.getInstance().registerListener(this.jws);
    }

    public ConcernPageView(Context context) {
        super(context);
        this.jwl = false;
        this.mSkinType = 3;
        this.glw = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.glw != i && ConcernPageView.this.jwm != null) {
                    ConcernPageView.this.glw = i;
                    if (ConcernPageView.this.glw == 1) {
                        ConcernPageView.this.jwm.bOJ();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jwm.bOK();
                    } else {
                        ConcernPageView.this.jwm.bOJ();
                    }
                }
            }
        };
        this.jwn = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cIm() {
                if (ConcernPageView.this.jwm != null) {
                    ConcernPageView.this.glw = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jwg)) {
                        ConcernPageView.this.jwm.bOK();
                    } else {
                        ConcernPageView.this.jwm.bOJ();
                    }
                }
            }
        };
        this.jwp = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cIn() {
                ConcernPageView.this.VB();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jwg.setSelection(0);
                if (ConcernPageView.this.jwg.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cIj();
                } else {
                    ConcernPageView.this.hM(true);
                }
                if (ConcernPageView.this.jwi != null) {
                    ConcernPageView.this.jwi.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void Lb(String str) {
                ConcernPageView.this.VB();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cIi();
                if (ConcernPageView.this.jwi != null) {
                    ConcernPageView.this.jwi.Lc(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jwi != null) {
                    ConcernPageView.this.jwi.ag(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jwg.setVisibility(8);
                    ConcernPageView.this.pb(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void af(boolean z, boolean z2) {
                if (ConcernPageView.this.jwi != null) {
                    ConcernPageView.this.jwi.ag(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.VB();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jwj.cIs()) {
                    ConcernPageView.this.cIj();
                } else {
                    ConcernPageView.this.cIi();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cIo() {
                if (ConcernPageView.this.jwi != null) {
                    ConcernPageView.this.jwi.ag(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.VB();
                ConcernPageView.this.jwg.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jwq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bOb();
            }
        };
        this.jwr = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jwl = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jws = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jwj.cIp();
                    } else {
                        ConcernPageView.this.jwj.cIq();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jwl = false;
        this.mSkinType = 3;
        this.glw = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.glw != i && ConcernPageView.this.jwm != null) {
                    ConcernPageView.this.glw = i;
                    if (ConcernPageView.this.glw == 1) {
                        ConcernPageView.this.jwm.bOJ();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jwm.bOK();
                    } else {
                        ConcernPageView.this.jwm.bOJ();
                    }
                }
            }
        };
        this.jwn = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cIm() {
                if (ConcernPageView.this.jwm != null) {
                    ConcernPageView.this.glw = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jwg)) {
                        ConcernPageView.this.jwm.bOK();
                    } else {
                        ConcernPageView.this.jwm.bOJ();
                    }
                }
            }
        };
        this.jwp = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cIn() {
                ConcernPageView.this.VB();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jwg.setSelection(0);
                if (ConcernPageView.this.jwg.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cIj();
                } else {
                    ConcernPageView.this.hM(true);
                }
                if (ConcernPageView.this.jwi != null) {
                    ConcernPageView.this.jwi.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void Lb(String str) {
                ConcernPageView.this.VB();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cIi();
                if (ConcernPageView.this.jwi != null) {
                    ConcernPageView.this.jwi.Lc(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.jwi != null) {
                    ConcernPageView.this.jwi.ag(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.jwg.setVisibility(8);
                    ConcernPageView.this.pb(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void af(boolean z, boolean z2) {
                if (ConcernPageView.this.jwi != null) {
                    ConcernPageView.this.jwi.ag(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.VB();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jwj.cIs()) {
                    ConcernPageView.this.cIj();
                } else {
                    ConcernPageView.this.cIi();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cIo() {
                if (ConcernPageView.this.jwi != null) {
                    ConcernPageView.this.jwi.ag(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.VB();
                ConcernPageView.this.jwg.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jwq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bOb();
            }
        };
        this.jwr = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jwl = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jws = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jwj.cIp();
                    } else {
                        ConcernPageView.this.jwj.cIq();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jwl = false;
        this.mSkinType = 3;
        this.glw = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.glw != i2 && ConcernPageView.this.jwm != null) {
                    ConcernPageView.this.glw = i2;
                    if (ConcernPageView.this.glw == 1) {
                        ConcernPageView.this.jwm.bOJ();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.jwm.bOK();
                    } else {
                        ConcernPageView.this.jwm.bOJ();
                    }
                }
            }
        };
        this.jwn = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cIm() {
                if (ConcernPageView.this.jwm != null) {
                    ConcernPageView.this.glw = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.jwg)) {
                        ConcernPageView.this.jwm.bOK();
                    } else {
                        ConcernPageView.this.jwm.bOJ();
                    }
                }
            }
        };
        this.jwp = new d.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cIn() {
                ConcernPageView.this.VB();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.jwg.setSelection(0);
                if (ConcernPageView.this.jwg.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cIj();
                } else {
                    ConcernPageView.this.hM(true);
                }
                if (ConcernPageView.this.jwi != null) {
                    ConcernPageView.this.jwi.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void Lb(String str) {
                ConcernPageView.this.VB();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cIi();
                if (ConcernPageView.this.jwi != null) {
                    ConcernPageView.this.jwi.Lc(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.jwi != null) {
                    ConcernPageView.this.jwi.ag(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.jwg.setVisibility(8);
                    ConcernPageView.this.pb(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void af(boolean z, boolean z2) {
                if (ConcernPageView.this.jwi != null) {
                    ConcernPageView.this.jwi.ag(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.VB();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.jwj.cIs()) {
                    ConcernPageView.this.cIj();
                } else {
                    ConcernPageView.this.cIi();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void cIo() {
                if (ConcernPageView.this.jwi != null) {
                    ConcernPageView.this.jwi.ag(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.VB();
                ConcernPageView.this.jwg.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.jwq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bOb();
            }
        };
        this.jwr = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.jwl = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        this.jws = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    if (intValue == 1) {
                        ConcernPageView.this.jwj.cIp();
                    } else {
                        ConcernPageView.this.jwj.cIq();
                    }
                    if (ConcernPageView.this.mNoDataView != null) {
                        if (intValue == 1) {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, ConcernPageView.this.getContext().getString(R.string.concern_person_no_data_title)));
                        } else {
                            ConcernPageView.this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, ConcernPageView.this.getContext().getString(R.string.concern_no_data_title)));
                        }
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jwg = new BdTypeRecyclerView(context);
        this.jwg.setLayoutManager(new LinearLayoutManager(context));
        this.jwg.setFadingEdgeLength(0);
        this.jwg.setOverScrollMode(2);
        if (!com.baidu.tbadk.a.d.bhw()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.jwg.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        }
        this.jwo = new BigdaySwipeRefreshLayout(context);
        this.jwo.addView(this.jwg);
        this.giV = new PbListView(context);
        this.giV.createView();
        this.giV.setContainerBackgroundColorResId(R.color.transparent);
        this.giV.setLineGone();
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.giV.setOnClickListener(this.jwq);
        this.jwg.setNextPage(this.giV);
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        addView(this.jwo);
        this.jwf = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.jwf.setEnable(true);
        this.jwo.setProgressView(this.jwf);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.jwo.setCustomDistances(i, i, i * 2);
        this.jwh = new com.baidu.tieba.homepage.concern.a(context, this.jwg);
        this.jwj = new d(this.pageContext, this.jwg, this.jwh, this.jwo);
        this.jwo.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bVF() {
        this.jwj.a(this.jwp);
        this.jwf.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.bIl().Ez("page_concern");
                    ConcernPageView.this.jwj.update();
                }
            }
        });
        this.jwg.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bOb();
            }
        });
        this.jwg.removeOnScrollListener(this.mOnScrollListener);
        this.jwg.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.jwi = aVar;
    }

    public void cIf() {
        if (!TbadkCoreApplication.isLogin()) {
            cIh();
        } else if (this.jwj != null) {
            this.jwj.update();
            hM(true);
        }
    }

    public void cIg() {
        if (!TbadkCoreApplication.isLogin()) {
            cIh();
        } else if (this.jwj != null) {
            this.jwj.cIr();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.jwj != null) {
            this.jwj.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.jwk != null) {
                this.jwk.onChangeSkinType(i);
            }
            if (this.grV != null) {
                this.grV.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.jwf != null) {
                this.jwf.changeSkin(i);
            }
            if (this.giV != null) {
                this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
                this.giV.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0105);
            }
            this.jwh.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        cIk();
    }

    public void aT(String str, int i) {
        this.jwj.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.jwj.a(z, dataRes, 0, null);
    }

    public void pb(boolean z) {
        if (!cmm()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.jwj != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.jwj.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VB() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.grV != null) {
            this.grV.dettachView(this);
            this.grV = null;
        }
    }

    private boolean cmm() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void cIh() {
        if (this.jwk == null) {
            this.jwk = new ConcernNotLoginLayout(getContext());
            this.jwk.onChangeSkinType(this.mSkinType);
        }
        if (this.jwk.getParent() == null) {
            this.jwo.setVisibility(8);
            this.jwk.setVisibility(0);
            addView(this.jwk);
        }
    }

    public boolean cml() {
        if (this.grV != null) {
            return this.grV.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hM(boolean z) {
        if (!cml()) {
            if (this.grV == null) {
                this.grV = new g(getContext());
                this.grV.br(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.grV.bAw();
                this.grV.setWrapStyle(true);
            }
            this.grV.onChangeSkinType();
            this.grV.attachView(this, z);
        }
    }

    public void cIi() {
        this.jwo.setVisibility(0);
        this.jwg.setVisibility(0);
        if (this.jwj.hasMore()) {
            this.giV.startLoadData();
        } else {
            this.giV.endLoadDataWithNoMore();
        }
        this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.giV.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void cIj() {
        this.jwo.setVisibility(0);
        this.jwg.setVisibility(0);
        this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.giV.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        int i = com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_home_concern_all_status", 0);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.dS(null, getContext().getString(R.string.concern_no_data_title)), null);
        }
        if (i == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getContext().getString(R.string.concern_person_no_data_title)));
            this.mNoDataView.setImgOption(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, getContext().getString(R.string.concern_no_data_title)));
            this.mNoDataView.setImgOption(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL));
        }
        this.mNoDataView.onChangeSkinType(this.pageContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.jwj != null) {
            this.jwj.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.jwj != null) {
            this.jwj.pI(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.jwj != null) {
            this.jwj.qP(z);
        }
        if (this.jwm != null) {
            this.jwm.b(this.jwn);
            this.jwm.a(this.jwn);
            this.jwn.cIm();
        }
    }

    public void reload() {
        if (this.jwg != null && this.jwo != null) {
            if (this.jwl && this.jwg.getFirstVisiblePosition() != 0) {
                this.jwl = false;
                return;
            }
            this.jwg.setSelection(0);
            if (!this.jwo.isRefreshing()) {
                if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                    if (TbadkCoreApplication.isLogin()) {
                        this.jwj.update();
                    }
                } else {
                    this.jwo.setRefreshing(true);
                }
            }
            if (!this.jwo.isRefreshing()) {
                this.jwo.setRefreshing(true);
            }
            if (this.jwn != null) {
                this.jwn.cIm();
            }
        }
    }

    public void onDestroy() {
        if (this.jwm != null) {
            this.jwm.b(this.jwn);
        }
        this.jwg.removeOnScrollListener(this.mOnScrollListener);
        this.jwj.a((d.a) null);
        this.jwf.setListPullRefreshListener(null);
        this.jwf.a((f.d) null);
        this.jwg.setOnSrollToBottomListener(null);
        this.jwf.a((f.b) null);
        this.jwf.release();
        this.jwg.setRecyclerListener(null);
    }

    public void cIk() {
        if (this.jwh != null) {
            this.jwh.notifyDataSetChanged();
        }
    }

    public void cIl() {
        if (this.jwj != null) {
            this.jwj.pI(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOb() {
        if (this.jwj != null) {
            this.jwj.bOb();
        }
    }

    public void FZ() {
        if (this.jwh != null) {
            List<q> dataList = this.jwh.getDataList();
            if (!y.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof k) {
                        k kVar = (k) qVar;
                        if (kVar.eBO != 0 && kVar.evQ != null) {
                            int[] imageWidthAndHeight = kVar.evQ.getImageWidthAndHeight();
                            kVar.eBO = imageWidthAndHeight[0];
                            kVar.eBP = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.jwh != null) {
                            ConcernPageView.this.jwh.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
