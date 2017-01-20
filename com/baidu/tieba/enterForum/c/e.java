package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.r;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private BdListView bbC;
    private View bdb;
    private View brw;
    private final com.baidu.tieba.enterForum.home.f bxA;
    private ViewEventCenter bxK;
    private com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>> byG;
    private r byH;
    private ag byI;
    private com.baidu.tieba.enterForum.model.e byJ;
    private boolean byK;
    private List<com.baidu.tieba.tbadkCore.u> byL;
    private boolean byM;
    private CommonTipView byN;
    private TextView byO;
    private com.baidu.tbadk.core.view.ad mPullView;
    private int byx = 0;
    private boolean byP = false;

    public e(com.baidu.tieba.enterForum.home.f fVar, View view, ViewEventCenter viewEventCenter) {
        this.byM = false;
        this.bxA = fVar;
        this.bxK = viewEventCenter;
        this.byI = new ag(viewEventCenter);
        this.byJ = new com.baidu.tieba.enterForum.model.e(fVar.getPageContext(), viewEventCenter);
        af(view);
        Vc();
        this.bbC.setAdapter((ListAdapter) this.byG);
        this.byM = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void af(View view) {
        this.bbC = (BdListView) view.findViewById(r.h.listview);
        this.mPullView = new com.baidu.tbadk.core.view.ad(this.bxA.getPageContext());
        this.mPullView.setTag(this.bxA.getUniqueId());
        this.mPullView.a(new f(this));
        this.bbC.setPullRefresh(this.mPullView);
        this.byH = new r(this.bxA.getFragmentActivity());
        this.byH.setEventCenter(this.bxK);
        this.bdb = this.byH.findViewById(r.h.divider_line);
        this.bbC.addHeaderView(this.byH);
        this.byO = (TextView) BdListViewHelper.a(this.bxA.getPageContext().getPageActivity(), this.bbC, BdListViewHelper.HeadType.DEFAULT);
        this.brw = new View(this.bxA.getActivity());
        this.brw.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.bxA.getActivity(), r.f.ds150)));
    }

    public int UV() {
        return this.byx;
    }

    public int Vb() {
        return this.byJ.UV();
    }

    private void Vc() {
        this.byG = new g(this, this.bxA.getPageContext(), new Class[]{y.class, w.class, o.class}, new int[]{r.j.home_like_item_with_portrait, r.j.home_like_item_extra_with_text, r.j.home_like_two_column_item}, this.bxK);
        this.byG.bS(false);
    }

    public void b(com.baidu.tieba.tbadkCore.u uVar) {
        this.byJ.b(uVar);
    }

    public void aj(List<com.baidu.tieba.tbadkCore.u> list) {
        this.byJ.ai(list);
    }

    public List<com.baidu.tieba.tbadkCore.u> Vd() {
        return this.byJ.getDataList();
    }

    public void Ve() {
        this.byJ.UW();
    }

    public boolean UE() {
        return this.byK;
    }

    public BdListView Vf() {
        return this.bbC;
    }

    public TextView Vg() {
        return this.byO;
    }

    public void Vh() {
        this.byx = this.byJ.UV();
        an(this.byJ.getDataList());
    }

    public void hu(int i) {
        this.byK = true;
        if (this.byJ.UT() == null) {
            this.byJ.UU();
        }
        j UT = this.byJ.UT();
        UT.n(this.bxA.getPageContext());
        if (UT.getParent() == null && this.bxA.Uu() != null && this.bxA.Ut() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.bxA.Uu().getId());
            this.bxA.Ut().addView(UT);
        }
        this.byJ.a(this.byx, this.byL);
        com.baidu.adp.lib.g.h.eE().post(new h(this, i));
    }

    public void Vi() {
        this.byK = false;
        this.bbC.setVisibility(0);
        if (this.byJ.UT() != null && this.bxA.Ut() != null) {
            this.bxA.Ut().removeView(this.byJ.UT());
        }
    }

    public void Vj() {
        this.bbC.setVisibility(8);
        if (this.byJ.UT() != null) {
            this.byJ.UT().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hv(int i) {
        int i2;
        if (this.byJ.UT() != null && this.bbC != null && this.bbC.getChildCount() > 0) {
            int firstVisiblePosition = this.bbC.getFirstVisiblePosition();
            if (this.byx == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.bbC.getChildAt(0);
            this.byJ.UT().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bbC.startPullRefresh();
    }

    public void Vk() {
        this.bbC.completePullRefreshPostDelayed(2000L);
    }

    public void dj(boolean z) {
        this.byH.a(this.bxA.getPageContext(), z);
    }

    public void f(com.baidu.tieba.enterForum.b.b bVar) {
        this.byH.a(this.bxA.getPageContext(), bVar);
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.byH.b(list, tbPageContext);
    }

    public void ag(View view) {
        if (this.byH != null && view != null) {
            this.byH.ag(view);
        }
    }

    public View getBannerView() {
        if (this.byH == null) {
            return null;
        }
        return this.byH.getBannerView();
    }

    public void ak(List<com.baidu.tieba.enterForum.b.g> list) {
        if (list == null || list.isEmpty()) {
            Vp();
            return;
        }
        this.byI.a(this.bxA.getFragmentActivity(), list, this.bxA.getPageContext());
        if (!TbadkCoreApplication.isLogin()) {
            if (this.bbC.getFooterViewsCount() < 1) {
                Vl();
            }
        } else if (this.bbC.getFooterViewsCount() < 2) {
            Vl();
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bbC.removeFooterView(this.brw);
            this.bbC.addFooterView(this.brw);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bbC.removeFooterView(this.brw);
        }
    }

    private void Vl() {
        this.bbC.addFooterView(this.byI.VC(), null, false);
        com.baidu.tbadk.i.a.a(this.bxA.getPageContext(), this.byI.VC());
    }

    public List<com.baidu.tieba.tbadkCore.u> Vm() {
        return this.byL;
    }

    public List<com.baidu.tieba.tbadkCore.u> Vn() {
        return this.byJ.getDataList();
    }

    public void hw(int i) {
        this.byx = i;
    }

    private List<Object> al(List<com.baidu.tieba.tbadkCore.u> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.byM) {
                arrayList.add(new com.baidu.tieba.tbadkCore.u(1));
            }
        }
        return arrayList;
    }

    private com.baidu.tieba.tbadkCore.u b(int i, List<com.baidu.tieba.tbadkCore.u> list) {
        com.baidu.tieba.tbadkCore.u uVar = new com.baidu.tieba.tbadkCore.u();
        if (list != null) {
            int size = list.size();
            if (i < size) {
                com.baidu.tieba.tbadkCore.u uVar2 = list.get(i);
                uVar2.setType(0);
                return uVar2;
            } else if (i == size && this.byM) {
                uVar.setType(1);
                return uVar;
            } else {
                uVar.setType(2);
                return uVar;
            }
        }
        return uVar;
    }

    private List<Object> am(List<com.baidu.tieba.tbadkCore.u> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.byM) {
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
        this.byG.notifyDataSetChanged();
    }

    public void an(List<com.baidu.tieba.tbadkCore.u> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.byG.y(new ArrayList());
            return;
        }
        this.byL = list;
        if (this.byx == 2) {
            this.bdb.setVisibility(8);
            this.byG.y(am(list));
            return;
        }
        this.bdb.setVisibility(0);
        this.byG.y(al(list));
    }

    public void Vo() {
        if (this.byI != null) {
            this.byI.p(this.bxA.getPageContext());
            if (TbadkCoreApplication.isLogin()) {
                this.bbC.setSelection(this.bbC.getCount() - 1);
            }
        }
    }

    public void Vp() {
        if (this.byI != null && this.byI.VC() != null) {
            this.bbC.removeFooterView(this.byI.VC());
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bbC.removeFooterView(this.brw);
            this.bbC.addFooterView(this.brw);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bbC.removeFooterView(this.brw);
        }
        if (this.byG != null && !this.byG.isEmpty()) {
            this.byG.a(this.bxA.getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.dl(i);
        }
        if (this.byI.VC() != null) {
            this.byI.VC().n(this.bxA.getPageContext());
        }
        if (this.byH != null) {
            this.byH.n(this.bxA.getPageContext());
        }
        if (this.byJ.UT() != null && this.byJ.UT().getVisibility() == 0) {
            this.byJ.n(this.bxA.getPageContext());
        }
    }

    public void a(aa.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.byH != null) {
            this.byH.setSearchHint(str);
        }
    }

    public void Vq() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("enter_forum_login_tip", true)) {
            if (this.byN == null) {
                this.byN = new CommonTipView(this.bxA.getActivity());
            }
            this.byN.setText(r.l.enter_forum_login_tip);
            this.byN.b(this.bxA.Ut(), TbadkCoreApplication.m9getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestory() {
        if (this.byN != null) {
            this.byN.onDestroy();
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        this.byH.setAttentionTitleVisibililty(z);
    }
}
