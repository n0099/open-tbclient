package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.b;
import com.baidu.tieba.t;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class z extends FrameLayout {
    private com.baidu.tbadk.g.f HA;
    private final CustomMessageListener bQj;
    private PbListView bvo;
    private TagInfo cFj;
    private BdTypeListView cFk;
    private com.baidu.tieba.homepage.personalize.a.ac cFl;
    private com.baidu.tieba.homepage.framework.c cFm;
    private b cFn;
    private com.baidu.tieba.homepage.personalize.b.f cFo;
    private long cFp;
    private TextView cFq;
    private b.a cFr;
    private com.baidu.tbadk.core.view.w mPullView;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.g.h refreshView;

    public BdTypeListView getListView() {
        return this.cFk;
    }

    public void a(com.baidu.tieba.homepage.framework.b.a aVar, View.OnTouchListener onTouchListener, ViewGroup viewGroup) {
        if (this.cFn != null) {
            this.cFn.a(aVar, onTouchListener, viewGroup);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cFn != null) {
            this.cFn.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void YO() {
        if (this.cFn != null) {
            this.cFn.YO();
        }
    }

    public void ku() {
        if (this.cFk != null) {
            this.cFk.ku();
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cFn != null) {
            this.cFn.b(view, i, i2, i3, i4);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cFl != null) {
            this.cFl.setPageUniqueId(bdUniqueId);
        }
        if (this.cFn != null) {
            this.cFn.j(bdUniqueId);
        }
        if (this.cFo != null) {
            this.cFo.n(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.bQj != null) {
            this.bQj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bQj);
        }
    }

    public z(Context context) {
        super(context);
        this.cFp = 0L;
        this.cFr = new aa(this);
        this.bQj = new ab(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        init(context);
    }

    private void init(Context context) {
        this.cFk = new BdTypeListView(context);
        this.cFk.setDividerHeight(0);
        this.cFk.setSelector(17170445);
        this.bvo = new PbListView(context);
        this.bvo.kk();
        this.bvo.dg(t.d.cp_bg_line_c);
        this.bvo.setTextColor(av.getColor(t.d.cp_cont_d));
        this.bvo.dh(TbadkCoreApplication.m9getInst().getSkinType());
        this.cFk.setNextPage(this.bvo);
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        this.mPullView = new com.baidu.tbadk.core.view.w(this.pageContext);
        this.cFk.setPullRefresh(this.mPullView);
        this.cFq = new TextView(context);
        this.cFq.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(context, t.e.ds176)));
        this.cFk.f(this.cFq, 0);
        this.mPullView.U(true);
        this.mPullView.a(new ad(this));
        this.mPullView.a(new ae(this));
        this.cFk.setOnSrollToBottomListener(new af(this));
        this.mPullView.a(new ag(this));
        this.cFo = new com.baidu.tieba.homepage.personalize.b.f();
        this.cFl = new com.baidu.tieba.homepage.personalize.a.ac(context, this.cFk);
        this.cFl.b(this.cFo);
        this.cFn = new b(this.pageContext, this.cFk, this.cFq, this.cFl, this);
        this.cFn.a(this.cFr);
        addView(this.cFk);
        this.cFk.setRecyclerListener(new ah(this));
    }

    public void setCallback(com.baidu.tieba.homepage.framework.c cVar) {
        this.cFm = cVar;
    }

    public void setTagInfo(TagInfo tagInfo) {
        this.cFj = tagInfo;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bvo != null) {
            this.bvo.wm();
            this.bvo.di(com.baidu.adp.lib.util.k.e(this.pageContext.getPageActivity(), t.e.ds110));
        }
        this.cFn.a(z, dataRes, 0, null);
    }

    public void onChangeSkinType(int i) {
        if (this.cFq != null) {
            av.l(this.cFq, t.d.cp_bg_line_d);
        }
        if (this.HA != null) {
            this.HA.ti();
        }
        if (this.refreshView != null) {
            this.refreshView.ti();
        }
        if (this.mPullView != null) {
            this.mPullView.dh(i);
        }
        if (this.bvo != null) {
            this.bvo.setTextColor(av.getColor(t.d.cp_cont_d));
            this.bvo.dh(i);
        }
        this.cFl.onChangeSkinType(i);
        av.l(this, t.d.cp_bg_line_d);
    }

    public long getTagCode() {
        if (this.cFj == null || this.cFj.tag_code == null) {
            return 0L;
        }
        return this.cFj.tag_code.longValue();
    }

    public void V(String str, int i) {
        if (this.bvo != null) {
            this.bvo.wm();
            this.bvo.di(com.baidu.adp.lib.util.k.e(this.pageContext.getPageActivity(), t.e.ds110));
        }
        this.cFn.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.g.h(getContext(), new ai(this));
        }
        this.refreshView.eT(getContext().getResources().getDimensionPixelSize(t.e.ds280));
        this.refreshView.fY(str);
        this.refreshView.b(view, z);
        this.refreshView.EB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void La() {
        if (this.refreshView != null) {
            this.refreshView.L(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lb() {
        if (this.HA != null) {
            this.HA.L(this);
            this.HA = null;
        }
        if (this.cFm != null) {
            this.cFm.alx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean amA() {
        if (this.refreshView != null) {
            return this.refreshView.Eu();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.HA == null) {
            if (i < 0) {
                this.HA = new com.baidu.tbadk.g.f(getContext());
            } else {
                this.HA = new com.baidu.tbadk.g.f(getContext(), i);
            }
            this.HA.ti();
        }
        this.HA.b(this, z);
    }

    public void amB() {
        setViewForeground(false);
        if (this.cFn != null) {
            this.cFn.dL(false);
        }
    }

    public void setViewForeground(boolean z) {
        this.cFp = System.currentTimeMillis();
        if (this.cFn != null) {
            this.cFn.eY(z);
        }
    }

    public void alF() {
        if (this.cFn != null) {
            this.cFn.update();
        }
    }

    public void reload() {
        if (this.cFk != null) {
            YO();
            this.cFk.setSelection(0);
            if (this.cFk.kw()) {
                if (this.cFn != null && this.cFn.Ki() != null) {
                    this.cFn.Ki().aZR();
                    this.cFn.fb(false);
                }
                this.cFk.kv();
            }
        }
    }

    public void onDestroy() {
        this.cFn.onDestroy();
    }

    public void onPause() {
        this.cFn.onPause();
    }

    public void onResume() {
        this.cFn.onResume();
    }

    public void alb() {
        if (this.cFl != null) {
            this.cFl.notifyDataSetChanged();
        }
    }

    public void amC() {
        if (this.cFn != null) {
            this.cFn.dL(true);
        }
        if (this.cFp > 0) {
            TiebaStatic.log(new ay("c10794").ab("obj_duration", String.valueOf((System.currentTimeMillis() - this.cFp) / 1000)));
            this.cFp = 0L;
        }
        cd.NI().cr(false);
    }

    public void amD() {
        this.cFn.amy();
    }
}
