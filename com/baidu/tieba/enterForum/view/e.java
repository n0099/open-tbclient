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
    private View aXu;
    private ViewEventCenter bgJ;
    private final com.baidu.tieba.enterForum.home.e bvt;
    private BdListView bwF;
    private com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> bwG;
    private r bwH;
    private ag bwI;
    private com.baidu.tieba.enterForum.c.f bwJ;
    private ViewGroup bwK;
    private boolean bwL;
    private List<com.baidu.tieba.tbadkCore.x> bwM;
    private boolean bwN;
    private CommonTipView bwO;
    private TextView bwP;
    private View bwQ;
    private com.baidu.tbadk.core.view.w mPullView;
    private int bwr = 0;
    private boolean bwR = false;

    public e(com.baidu.tieba.enterForum.home.e eVar, View view, ViewEventCenter viewEventCenter) {
        this.bwN = false;
        this.bvt = eVar;
        this.bgJ = viewEventCenter;
        this.bwI = new ag(viewEventCenter);
        this.bwJ = new com.baidu.tieba.enterForum.c.f(eVar.getPageContext(), viewEventCenter);
        Z(view);
        Tq();
        this.bwF.setAdapter((ListAdapter) this.bwG);
        this.bwN = TbadkCoreApplication.m10getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
    }

    private void Z(View view) {
        this.bwK = (ViewGroup) view.findViewById(u.g.mybar_root_layout);
        this.bwF = (BdListView) view.findViewById(u.g.listview);
        this.mPullView = new com.baidu.tbadk.core.view.w(this.bvt.getPageContext());
        this.mPullView.setTag(this.bvt.getUniqueId());
        this.mPullView.a(new f(this));
        this.bwF.setPullRefresh(this.mPullView);
        this.bwH = new r(this.bvt.getFragmentActivity());
        this.bwH.setEventCenter(this.bgJ);
        this.aXu = this.bwH.findViewById(u.g.divider_line);
        this.bwF.addHeaderView(this.bwH);
        this.bwP = (TextView) BdListViewHelper.a(this.bvt.getPageContext().getPageActivity(), this.bwF, BdListViewHelper.HeadType.HASTAB);
        this.bwQ = new View(this.bvt.getActivity());
        this.bwQ.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.bvt.getActivity(), u.e.ds150)));
    }

    public int Tj() {
        return this.bwr;
    }

    public int Tp() {
        return this.bwJ.Tj();
    }

    private void Tq() {
        this.bwG = new g(this, this.bvt.getPageContext(), new Class[]{y.class, w.class, o.class}, new int[]{u.h.home_like_item_with_portrait, u.h.home_like_item_extra_with_text, u.h.home_like_two_column_item}, this.bgJ);
        this.bwG.bO(false);
    }

    public void b(com.baidu.tieba.tbadkCore.x xVar) {
        this.bwJ.b(xVar);
    }

    public void ak(List<com.baidu.tieba.tbadkCore.x> list) {
        this.bwJ.aj(list);
    }

    public List<com.baidu.tieba.tbadkCore.x> Tr() {
        return this.bwJ.Ea();
    }

    public void Ts() {
        this.bwJ.Tk();
    }

    public boolean SR() {
        return this.bwL;
    }

    public BdListView Tt() {
        return this.bwF;
    }

    public TextView Tu() {
        return this.bwP;
    }

    public void Tv() {
        this.bwr = this.bwJ.Tj();
        ao(this.bwJ.Ea());
    }

    public void gR(int i) {
        this.bwL = true;
        if (this.bwJ.Th() == null) {
            this.bwJ.Ti();
        }
        j Th = this.bwJ.Th();
        Th.n(this.bvt.getPageContext());
        if (Th.getParent() == null && this.bvt.SG() != null && this.bvt.SF() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.bvt.SG().getId());
            this.bvt.SF().addView(Th);
        }
        this.bwJ.a(this.bwr, this.bwM);
        com.baidu.adp.lib.h.h.dL().post(new h(this, i));
    }

    public void SP() {
        this.bwL = false;
        this.bwF.setVisibility(0);
        if (this.bwJ.Th() != null && this.bvt.SF() != null) {
            this.bvt.SF().removeView(this.bwJ.Th());
        }
    }

    public void Tw() {
        this.bwF.setVisibility(0);
        if (this.bwJ.Th() != null) {
            this.bwJ.Th().setVisibility(8);
        }
    }

    public void Tx() {
        this.bwF.setVisibility(8);
        if (this.bwJ.Th() != null) {
            this.bwJ.Th().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gS(int i) {
        int i2;
        if (this.bwJ.Th() != null && this.bwF != null && this.bwF.getChildCount() > 0) {
            int firstVisiblePosition = this.bwF.getFirstVisiblePosition();
            if (this.bwr == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.bwF.getChildAt(0);
            this.bwJ.Th().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void jA() {
        this.bwF.jA();
    }

    public void Ty() {
        this.bwF.l(2000L);
    }

    public void cU(boolean z) {
        this.bwH.a(this.bvt.getPageContext(), z);
    }

    public void g(com.baidu.tieba.enterForum.b.b bVar) {
        this.bwH.a(this.bvt.getPageContext(), bVar);
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.bwH.b(list, tbPageContext);
    }

    public void aa(View view) {
        if (this.bwH != null && view != null) {
            this.bwH.aa(view);
        }
    }

    public View getBannerView() {
        if (this.bwH == null) {
            return null;
        }
        return this.bwH.getBannerView();
    }

    public void ab(View view) {
        if (this.bwH != null && view != null) {
            this.bwH.ab(view);
        }
    }

    public View getTogetherHiBannerView() {
        if (this.bwH == null) {
            return null;
        }
        return this.bwH.getTogetherHiBannerView();
    }

    public void al(List<com.baidu.tieba.enterForum.b.g> list) {
        if (list == null || list.isEmpty()) {
            TD();
            return;
        }
        this.bwI.a(this.bvt.getFragmentActivity(), list, this.bvt.getPageContext());
        if (!TbadkCoreApplication.isLogin()) {
            if (this.bwF.getFooterViewsCount() < 1) {
                Tz();
            }
        } else if (this.bwF.getFooterViewsCount() < 2) {
            Tz();
        }
        if (TbadkCoreApplication.m10getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bwF.removeFooterView(this.bwQ);
            this.bwF.addFooterView(this.bwQ);
        }
        if (TbadkCoreApplication.m10getInst().getSkinType() == 2) {
            this.bwF.removeFooterView(this.bwQ);
        }
    }

    private void Tz() {
        this.bwF.addFooterView(this.bwI.TT(), null, false);
        com.baidu.tbadk.j.a.a(this.bvt.getPageContext(), this.bwI.TT());
    }

    public List<com.baidu.tieba.tbadkCore.x> TA() {
        return this.bwM;
    }

    public List<com.baidu.tieba.tbadkCore.x> TB() {
        return this.bwJ.Ea();
    }

    public void gT(int i) {
        this.bwr = i;
    }

    private List<Object> am(List<com.baidu.tieba.tbadkCore.x> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.bwN) {
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
            } else if (i == size && this.bwN) {
                xVar.setType(1);
                return xVar;
            } else {
                xVar.setType(2);
                return xVar;
            }
        }
        return xVar;
    }

    private List<Object> an(List<com.baidu.tieba.tbadkCore.x> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.bwN) {
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
        this.bwG.notifyDataSetChanged();
    }

    public void ao(List<com.baidu.tieba.tbadkCore.x> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.bwG.A(new ArrayList());
            return;
        }
        this.bwM = list;
        if (this.bwr == 2) {
            this.aXu.setVisibility(8);
            this.bwG.A(an(list));
            return;
        }
        this.aXu.setVisibility(0);
        this.bwG.A(am(list));
    }

    public void TC() {
        if (this.bwI != null) {
            this.bwI.p(this.bvt.getPageContext());
            if (TbadkCoreApplication.isLogin()) {
                this.bwF.setSelection(this.bwF.getCount() - 1);
            }
        }
    }

    public void TD() {
        if (this.bwI != null && this.bwI.TT() != null) {
            this.bwF.removeFooterView(this.bwI.TT());
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.m10getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bwF.removeFooterView(this.bwQ);
            this.bwF.addFooterView(this.bwQ);
        }
        if (TbadkCoreApplication.m10getInst().getSkinType() == 2) {
            this.bwF.removeFooterView(this.bwQ);
        }
        if (this.bwG != null && !this.bwG.isEmpty()) {
            this.bwG.a(this.bvt.getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.cT(i);
        }
        if (this.bwI.TT() != null) {
            this.bwI.TT().n(this.bvt.getPageContext());
        }
        if (this.bwH != null) {
            this.bwH.n(this.bvt.getPageContext());
        }
        if (this.bwJ.Th() != null && this.bwJ.Th().getVisibility() == 0) {
            this.bwJ.n(this.bvt.getPageContext());
        }
    }

    public void a(t.b bVar) {
        this.mPullView.a(bVar);
    }

    public void TE() {
        this.bwN = true;
        ao(this.bwM);
        this.bwI.TU();
    }

    public void setSearchHint(String str) {
        if (this.bwH != null) {
            this.bwH.setSearchHint(str);
        }
    }

    public void TF() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("enter_forum_login_tip", true)) {
            if (this.bwO == null) {
                this.bwO = new CommonTipView(this.bvt.getActivity());
            }
            this.bwO.setText(u.j.enter_forum_login_tip);
            this.bwO.b(this.bvt.SF(), TbadkCoreApplication.m10getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestory() {
        if (this.bwO != null) {
            this.bwO.onDestroy();
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        this.bwH.setAttentionTitleVisibililty(z);
    }
}
