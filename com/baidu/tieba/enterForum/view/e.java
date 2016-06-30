package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.u;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private View aWw;
    private ViewEventCenter bfx;
    private final com.baidu.tieba.enterForum.home.e bte;
    private CommonTipView buA;
    private TextView buB;
    private View buC;
    private BdListView bur;
    private com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> bus;
    private r but;
    private ag buu;
    private com.baidu.tieba.enterForum.c.f buv;
    private ViewGroup buw;
    private boolean bux;
    private List<com.baidu.tieba.tbadkCore.x> buy;
    private boolean buz;
    private com.baidu.tbadk.core.view.w mPullView;
    private int bud = 0;
    private boolean buD = false;

    public e(com.baidu.tieba.enterForum.home.e eVar, View view, ViewEventCenter viewEventCenter) {
        this.buz = false;
        this.bte = eVar;
        this.bfx = viewEventCenter;
        this.buu = new ag(viewEventCenter);
        this.buv = new com.baidu.tieba.enterForum.c.f(eVar.getPageContext(), viewEventCenter);
        Z(view);
        SI();
        this.bur.setAdapter((ListAdapter) this.bus);
        this.buz = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void Z(View view) {
        this.buw = (ViewGroup) view.findViewById(u.g.mybar_root_layout);
        this.bur = (BdListView) view.findViewById(u.g.listview);
        this.mPullView = new com.baidu.tbadk.core.view.w(this.bte.getPageContext());
        this.mPullView.setTag(this.bte.getUniqueId());
        this.mPullView.a(new f(this));
        this.bur.setPullRefresh(this.mPullView);
        this.but = new r(this.bte.getFragmentActivity());
        this.but.setEventCenter(this.bfx);
        this.aWw = this.but.findViewById(u.g.divider_line);
        this.bur.addHeaderView(this.but);
        this.buB = (TextView) BdListViewHelper.a(this.bte.getPageContext().getPageActivity(), this.bur, BdListViewHelper.HeadType.HASTAB);
        this.buC = new View(this.bte.getActivity());
        this.buC.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.bte.getActivity(), u.e.ds150)));
    }

    public int SB() {
        return this.bud;
    }

    public int SH() {
        return this.buv.SB();
    }

    private void SI() {
        this.bus = new g(this, this.bte.getPageContext(), new Class[]{y.class, w.class, o.class}, new int[]{u.h.home_like_item_with_portrait, u.h.home_like_item_extra_with_text, u.h.home_like_two_column_item}, this.bfx);
        this.bus.bL(false);
    }

    public void b(com.baidu.tieba.tbadkCore.x xVar) {
        this.buv.b(xVar);
    }

    public void af(List<com.baidu.tieba.tbadkCore.x> list) {
        this.buv.ae(list);
    }

    public List<com.baidu.tieba.tbadkCore.x> SJ() {
        return this.buv.Eb();
    }

    public void SK() {
        this.buv.SC();
    }

    public boolean Sj() {
        return this.bux;
    }

    public BdListView SL() {
        return this.bur;
    }

    public TextView SM() {
        return this.buB;
    }

    public void SN() {
        this.bud = this.buv.SB();
        aj(this.buv.Eb());
    }

    public void gR(int i) {
        this.bux = true;
        if (this.buv.Sz() == null) {
            this.buv.SA();
        }
        j Sz = this.buv.Sz();
        Sz.n(this.bte.getPageContext());
        if (Sz.getParent() == null && this.bte.RY() != null && this.bte.RX() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.bte.RY().getId());
            this.bte.RX().addView(Sz);
        }
        this.buv.a(this.bud, this.buy);
        com.baidu.adp.lib.h.h.dM().post(new h(this, i));
    }

    public void Sh() {
        this.bux = false;
        this.bur.setVisibility(0);
        if (this.buv.Sz() != null && this.bte.RX() != null) {
            this.bte.RX().removeView(this.buv.Sz());
        }
    }

    public void SO() {
        this.bur.setVisibility(0);
        if (this.buv.Sz() != null) {
            this.buv.Sz().setVisibility(8);
        }
    }

    public void SP() {
        this.bur.setVisibility(8);
        if (this.buv.Sz() != null) {
            this.buv.Sz().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gS(int i) {
        int i2;
        if (this.buv.Sz() != null && this.bur != null && this.bur.getChildCount() > 0) {
            int firstVisiblePosition = this.bur.getFirstVisiblePosition();
            if (this.bud == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.bur.getChildAt(0);
            this.buv.Sz().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void jB() {
        this.bur.jB();
    }

    public void SQ() {
        this.bur.k(2000L);
    }

    public void cR(boolean z) {
        this.but.a(this.bte.getPageContext(), z);
    }

    public void g(com.baidu.tieba.enterForum.b.b bVar) {
        this.but.a(this.bte.getPageContext(), bVar);
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.but.b(list, tbPageContext);
    }

    public void aa(View view) {
        if (this.but != null && view != null) {
            this.but.aa(view);
        }
    }

    public View getBannerView() {
        if (this.but == null) {
            return null;
        }
        return this.but.getBannerView();
    }

    public void ab(View view) {
        if (this.but != null && view != null) {
            this.but.ab(view);
        }
    }

    public View getTogetherHiBannerView() {
        if (this.but == null) {
            return null;
        }
        return this.but.getTogetherHiBannerView();
    }

    public void ag(List<com.baidu.tieba.enterForum.b.g> list) {
        if (list == null || list.isEmpty()) {
            SV();
            return;
        }
        this.buu.a(this.bte.getFragmentActivity(), list, this.bte.getPageContext());
        if (!TbadkCoreApplication.isLogin()) {
            if (this.bur.getFooterViewsCount() < 1) {
                SR();
            }
        } else if (this.bur.getFooterViewsCount() < 2) {
            SR();
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bur.removeFooterView(this.buC);
            this.bur.addFooterView(this.buC);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bur.removeFooterView(this.buC);
        }
    }

    private void SR() {
        this.bur.addFooterView(this.buu.Tl(), null, false);
        com.baidu.tbadk.j.a.a(this.bte.getPageContext(), this.buu.Tl());
    }

    public List<com.baidu.tieba.tbadkCore.x> SS() {
        return this.buy;
    }

    public List<com.baidu.tieba.tbadkCore.x> ST() {
        return this.buv.Eb();
    }

    public void gT(int i) {
        this.bud = i;
    }

    private List<Object> ah(List<com.baidu.tieba.tbadkCore.x> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.buz) {
                arrayList.add(new com.baidu.tieba.tbadkCore.x(1));
            }
        }
        return arrayList;
    }

    private com.baidu.tieba.tbadkCore.x b(int i, List<com.baidu.tieba.tbadkCore.x> list) {
        com.baidu.tieba.tbadkCore.x xVar = new com.baidu.tieba.tbadkCore.x();
        if (list != null) {
            int size = list.size();
            if (i < size) {
                com.baidu.tieba.tbadkCore.x xVar2 = list.get(i);
                xVar2.setType(0);
                return xVar2;
            } else if (i == size && this.buz) {
                xVar.setType(1);
                return xVar;
            } else {
                xVar.setType(2);
                return xVar;
            }
        }
        return xVar;
    }

    private List<Object> ai(List<com.baidu.tieba.tbadkCore.x> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.buz) {
            size++;
        }
        int i = 0;
        int i2 = 1;
        while (i < size) {
            arrayList.add(new com.baidu.tieba.enterForum.b.a(b(i, list), b(i2, list)));
            i += 2;
            i2 = i + 1;
        }
        return arrayList;
    }

    public void notifyDataSetChanged() {
        this.bus.notifyDataSetChanged();
    }

    public void aj(List<com.baidu.tieba.tbadkCore.x> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.bus.A((List<Object>) new ArrayList());
            return;
        }
        this.buy = list;
        if (this.bud == 2) {
            this.aWw.setVisibility(8);
            this.bus.A(ai(list));
            return;
        }
        this.aWw.setVisibility(0);
        this.bus.A(ah(list));
    }

    public void SU() {
        if (this.buu != null) {
            this.buu.p(this.bte.getPageContext());
            if (TbadkCoreApplication.isLogin()) {
                this.bur.setSelection(this.bur.getCount() - 1);
            }
        }
    }

    public void SV() {
        if (this.buu != null && this.buu.Tl() != null) {
            this.bur.removeFooterView(this.buu.Tl());
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bur.removeFooterView(this.buC);
            this.bur.addFooterView(this.buC);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bur.removeFooterView(this.buC);
        }
        if (this.bus != null && !this.bus.isEmpty()) {
            this.bus.a(this.bte.getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.cT(i);
        }
        if (this.buu.Tl() != null) {
            this.buu.Tl().n(this.bte.getPageContext());
        }
        if (this.but != null) {
            this.but.n(this.bte.getPageContext());
        }
        if (this.buv.Sz() != null && this.buv.Sz().getVisibility() == 0) {
            this.buv.n(this.bte.getPageContext());
        }
    }

    public void a(t.b bVar) {
        this.mPullView.a(bVar);
    }

    public void SW() {
        this.buz = true;
        aj(this.buy);
        this.buu.Tm();
    }

    public void setSearchHint(String str) {
        if (this.but != null) {
            this.but.setSearchHint(str);
        }
    }

    public void SX() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("enter_forum_login_tip", true)) {
            if (this.buA == null) {
                this.buA = new CommonTipView(this.bte.getActivity());
            }
            this.buA.setText(u.j.enter_forum_login_tip);
            this.buA.b(this.bte.RX(), TbadkCoreApplication.m9getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestory() {
        if (this.buA != null) {
            this.buA.onDestroy();
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        this.but.setAttentionTitleVisibililty(z);
    }
}
