package com.baidu.tieba.enterForum.d;

import android.util.Log;
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
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.r;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private ViewEventCenter aPL;
    private final com.baidu.tieba.enterForum.home.f bGQ;
    private BdListView bHV;
    private com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> bHW;
    private r bHX;
    private ag bHY;
    private com.baidu.tieba.enterForum.c.f bHZ;
    private ViewGroup bIa;
    private boolean bIb;
    private List<com.baidu.tieba.tbadkCore.w> bIc;
    private boolean bId;
    private CommonTipView bIe;
    private TextView bIf;
    private View bIg;
    private View bdH;
    private com.baidu.tbadk.core.view.ab mPullView;
    private int bHM = 0;
    private boolean bIh = false;

    public e(com.baidu.tieba.enterForum.home.f fVar, View view, ViewEventCenter viewEventCenter) {
        this.bId = false;
        this.bGQ = fVar;
        this.aPL = viewEventCenter;
        this.bHY = new ag(viewEventCenter);
        this.bHZ = new com.baidu.tieba.enterForum.c.f(fVar.getPageContext(), viewEventCenter);
        Z(view);
        Ys();
        this.bHV.setAdapter((ListAdapter) this.bHW);
        this.bId = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void Z(View view) {
        this.bIa = (ViewGroup) view.findViewById(r.g.mybar_root_layout);
        this.bHV = (BdListView) view.findViewById(r.g.listview);
        this.mPullView = new com.baidu.tbadk.core.view.ab(this.bGQ.getPageContext());
        this.mPullView.setTag(this.bGQ.getUniqueId());
        this.mPullView.a(new f(this));
        this.bHV.setPullRefresh(this.mPullView);
        this.bHX = new r(this.bGQ.getFragmentActivity());
        this.bHX.setEventCenter(this.aPL);
        this.bdH = this.bHX.findViewById(r.g.divider_line);
        this.bHV.addHeaderView(this.bHX);
        this.bIf = (TextView) BdListViewHelper.a(this.bGQ.getPageContext().getPageActivity(), this.bHV, BdListViewHelper.HeadType.HASTAB);
        this.bIg = new View(this.bGQ.getActivity());
        this.bIg.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.bGQ.getActivity(), r.e.ds150)));
    }

    public int Yn() {
        return this.bHM;
    }

    public int Yr() {
        return this.bHZ.Yn();
    }

    private void Ys() {
        this.bHW = new g(this, this.bGQ.getPageContext(), new Class[]{y.class, w.class, o.class}, new int[]{r.h.home_like_item_with_portrait, r.h.home_like_item_extra_with_text, r.h.home_like_two_column_item}, this.aPL);
        this.bHW.bP(false);
    }

    public void b(com.baidu.tieba.tbadkCore.w wVar) {
        this.bHZ.b(wVar);
    }

    public void am(List<com.baidu.tieba.tbadkCore.w> list) {
        this.bHZ.al(list);
    }

    public List<com.baidu.tieba.tbadkCore.w> Yt() {
        return this.bHZ.Ft();
    }

    public void Yu() {
        this.bHZ.Yo();
    }

    public boolean XW() {
        return this.bIb;
    }

    public BdListView Yv() {
        return this.bHV;
    }

    public TextView Yw() {
        return this.bIf;
    }

    public void Yx() {
        this.bHM = this.bHZ.Yn();
        aq(this.bHZ.Ft());
    }

    public void hx(int i) {
        this.bIb = true;
        if (this.bHZ.Yl() == null) {
            this.bHZ.Ym();
        }
        j Yl = this.bHZ.Yl();
        Yl.q(this.bGQ.getPageContext());
        if (Yl.getParent() == null && this.bGQ.XM() != null && this.bGQ.XL() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.bGQ.XM().getId());
            this.bGQ.XL().addView(Yl);
        }
        this.bHZ.a(this.bHM, this.bIc);
        com.baidu.adp.lib.h.h.eG().post(new h(this, i));
    }

    public void Yy() {
        this.bIb = false;
        this.bHV.setVisibility(0);
        if (this.bHZ.Yl() != null && this.bGQ.XL() != null) {
            this.bGQ.XL().removeView(this.bHZ.Yl());
        }
    }

    public void Yz() {
        this.bHV.setVisibility(8);
        if (this.bHZ.Yl() != null) {
            this.bHZ.Yl().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hy(int i) {
        int i2;
        if (this.bHZ.Yl() != null && this.bHV != null && this.bHV.getChildCount() > 0) {
            int firstVisiblePosition = this.bHV.getFirstVisiblePosition();
            if (this.bHM == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.bHV.getChildAt(0);
            this.bHZ.Yl().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void kv() {
        Log.e("EnterForum", "StartPullRefresh Called");
        this.bHV.kv();
    }

    public void YA() {
        this.bHV.l(2000L);
    }

    public void dp(boolean z) {
        this.bHX.b(this.bGQ.getPageContext(), z);
    }

    public void f(com.baidu.tieba.enterForum.b.b bVar) {
        this.bHX.a(this.bGQ.getPageContext(), bVar);
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.bHX.b(list, tbPageContext);
    }

    public void aa(View view) {
        if (this.bHX != null && view != null) {
            this.bHX.aa(view);
        }
    }

    public View getBannerView() {
        if (this.bHX == null) {
            return null;
        }
        return this.bHX.getBannerView();
    }

    public void an(List<com.baidu.tieba.enterForum.b.g> list) {
        if (list == null || list.isEmpty()) {
            YF();
            return;
        }
        this.bHY.a(this.bGQ.getFragmentActivity(), list, this.bGQ.getPageContext());
        if (!TbadkCoreApplication.isLogin()) {
            if (this.bHV.getFooterViewsCount() < 1) {
                YB();
            }
        } else if (this.bHV.getFooterViewsCount() < 2) {
            YB();
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bHV.removeFooterView(this.bIg);
            this.bHV.addFooterView(this.bIg);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bHV.removeFooterView(this.bIg);
        }
    }

    private void YB() {
        this.bHV.addFooterView(this.bHY.YS(), null, false);
        com.baidu.tbadk.i.a.a(this.bGQ.getPageContext(), this.bHY.YS());
    }

    public List<com.baidu.tieba.tbadkCore.w> YC() {
        return this.bIc;
    }

    public List<com.baidu.tieba.tbadkCore.w> YD() {
        return this.bHZ.Ft();
    }

    public void hz(int i) {
        this.bHM = i;
    }

    private List<Object> ao(List<com.baidu.tieba.tbadkCore.w> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.bId) {
                arrayList.add(new com.baidu.tieba.tbadkCore.w(1));
            }
        }
        return arrayList;
    }

    private com.baidu.tieba.tbadkCore.w b(int i, List<com.baidu.tieba.tbadkCore.w> list) {
        com.baidu.tieba.tbadkCore.w wVar = new com.baidu.tieba.tbadkCore.w();
        if (list != null) {
            int size = list.size();
            if (i < size) {
                com.baidu.tieba.tbadkCore.w wVar2 = list.get(i);
                wVar2.setType(0);
                return wVar2;
            } else if (i == size && this.bId) {
                wVar.setType(1);
                return wVar;
            } else {
                wVar.setType(2);
                return wVar;
            }
        }
        return wVar;
    }

    private List<Object> ap(List<com.baidu.tieba.tbadkCore.w> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.bId) {
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
        this.bHW.notifyDataSetChanged();
    }

    public void aq(List<com.baidu.tieba.tbadkCore.w> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.bHW.A(new ArrayList());
            return;
        }
        this.bIc = list;
        if (this.bHM == 2) {
            this.bdH.setVisibility(8);
            this.bHW.A(ap(list));
            return;
        }
        this.bdH.setVisibility(0);
        this.bHW.A(ao(list));
    }

    public void YE() {
        if (this.bHY != null) {
            this.bHY.s(this.bGQ.getPageContext());
            if (TbadkCoreApplication.isLogin()) {
                this.bHV.setSelection(this.bHV.getCount() - 1);
            }
        }
    }

    public void YF() {
        if (this.bHY != null && this.bHY.YS() != null) {
            this.bHV.removeFooterView(this.bHY.YS());
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bHV.removeFooterView(this.bIg);
            this.bHV.addFooterView(this.bIg);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bHV.removeFooterView(this.bIg);
        }
        if (this.bHW != null && !this.bHW.isEmpty()) {
            this.bHW.a(this.bGQ.getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.dh(i);
        }
        if (this.bHY.YS() != null) {
            this.bHY.YS().q(this.bGQ.getPageContext());
        }
        if (this.bHX != null) {
            this.bHX.q(this.bGQ.getPageContext());
        }
        if (this.bHZ.Yl() != null && this.bHZ.Yl().getVisibility() == 0) {
            this.bHZ.q(this.bGQ.getPageContext());
        }
    }

    public void a(y.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.bHX != null) {
            this.bHX.setSearchHint(str);
        }
    }

    public void YG() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("enter_forum_login_tip", true)) {
            if (this.bIe == null) {
                this.bIe = new CommonTipView(this.bGQ.getActivity());
            }
            this.bIe.setText(r.j.enter_forum_login_tip);
            this.bIe.b(this.bGQ.XL(), TbadkCoreApplication.m9getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestory() {
        if (this.bIe != null) {
            this.bIe.onDestroy();
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        this.bHX.setAttentionTitleVisibililty(z);
    }
}
