package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private View aTv;
    private ViewEventCenter aWA;
    private final com.baidu.tieba.enterForum.home.e aWq;
    private int aXt = 0;
    private BdListView aYm;
    private com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> aYn;
    private r aYo;
    private ag aYp;
    private com.baidu.tieba.enterForum.c.g aYq;
    private ViewGroup aYr;
    private boolean aYs;
    private List<com.baidu.tieba.tbadkCore.v> aYt;
    private boolean aYu;
    private com.baidu.tbadk.core.view.t mPullView;

    public e(com.baidu.tieba.enterForum.home.e eVar, View view, ViewEventCenter viewEventCenter) {
        this.aYu = false;
        this.aWq = eVar;
        this.aWA = viewEventCenter;
        this.aYp = new ag(viewEventCenter);
        this.aYq = new com.baidu.tieba.enterForum.c.g(eVar.getPageContext(), viewEventCenter);
        R(view);
        MG();
        this.aYm.setAdapter((ListAdapter) this.aYn);
        this.aYu = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void R(View view) {
        this.aYr = (ViewGroup) view.findViewById(t.g.mybar_root_layout);
        this.aYm = (BdListView) view.findViewById(t.g.listview);
        this.mPullView = new com.baidu.tbadk.core.view.t(this.aWq.getPageContext());
        this.mPullView.setTag(this.aWq.getUniqueId());
        this.aYm.setPullRefresh(this.mPullView);
        this.aYo = new r(this.aWq.getFragmentActivity());
        this.aYo.setEventCenter(this.aWA);
        this.aTv = this.aYo.findViewById(t.g.divider_line);
        this.aYm.addHeaderView(this.aYo);
    }

    public int Mx() {
        return this.aXt;
    }

    public int MF() {
        return this.aYq.Mx();
    }

    private void MG() {
        this.aYn = new f(this, this.aWq.getPageContext(), new Class[]{y.class, w.class, o.class}, new int[]{t.h.home_like_item_with_portrait, t.h.home_like_item_extra_with_text, t.h.home_like_two_column_item}, this.aWA);
        this.aYn.bB(false);
    }

    public void b(com.baidu.tieba.tbadkCore.v vVar) {
        this.aYq.b(vVar);
    }

    public void T(List<com.baidu.tieba.tbadkCore.v> list) {
        this.aYq.N(list);
    }

    public List<com.baidu.tieba.tbadkCore.v> MH() {
        return this.aYq.Fm();
    }

    public void MI() {
        this.aYq.My();
    }

    public boolean MJ() {
        return this.aYs;
    }

    public void MK() {
        this.aXt = this.aYq.Mx();
        X(this.aYq.Fm());
    }

    public void fW(int i) {
        this.aYs = true;
        if (this.aYq.Mv() == null) {
            this.aYq.Mw();
        }
        i Mv = this.aYq.Mv();
        Mv.f(this.aWq.getPageContext());
        if (Mv.getParent() == null) {
            this.aYr.addView(Mv, new FrameLayout.LayoutParams(-1, -1));
        }
        this.aYq.a(this.aXt, this.aYt);
        com.baidu.adp.lib.h.h.hr().post(new g(this, i));
    }

    public void ML() {
        this.aYs = false;
        this.aYm.setVisibility(0);
        if (this.aYq.Mv() != null) {
            this.aYr.removeView(this.aYq.Mv());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fX(int i) {
        int i2;
        if (this.aYq.Mv() != null && this.aYm != null && this.aYm.getChildCount() > 0) {
            int firstVisiblePosition = this.aYm.getFirstVisiblePosition();
            if (this.aXt == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.aYm.getChildAt(0);
            this.aYq.Mv().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void ns() {
        this.aYm.ns();
    }

    public void MB() {
        this.aYm.nr();
    }

    public void cd(boolean z) {
        this.aYo.a(this.aWq.getPageContext(), z);
    }

    public void S(View view) {
        if (this.aYo != null && view != null) {
            this.aYo.S(view);
        }
    }

    public View getBannerView() {
        if (this.aYo == null) {
            return null;
        }
        return this.aYo.getBannerView();
    }

    public void U(List<com.baidu.tieba.enterForum.b.f> list) {
        if (list == null || list.isEmpty()) {
            MQ();
            return;
        }
        this.aYp.a(this.aWq.getFragmentActivity(), list, this.aWq.getPageContext());
        if (this.aYm.getFooterViewsCount() < 1) {
            this.aYm.addFooterView(this.aYp.Na(), null, false);
            com.baidu.tbadk.i.a.a(this.aWq.getPageContext(), this.aYp.Na());
        }
    }

    public List<com.baidu.tieba.tbadkCore.v> MM() {
        return this.aYt;
    }

    public List<com.baidu.tieba.tbadkCore.v> MN() {
        return this.aYq.Fm();
    }

    public void fY(int i) {
        this.aXt = i;
    }

    private List<Object> V(List<com.baidu.tieba.tbadkCore.v> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.aYu) {
                arrayList.add(new com.baidu.tieba.tbadkCore.v(1));
            }
        }
        return arrayList;
    }

    private com.baidu.tieba.tbadkCore.v b(int i, List<com.baidu.tieba.tbadkCore.v> list) {
        com.baidu.tieba.tbadkCore.v vVar = new com.baidu.tieba.tbadkCore.v();
        if (list != null) {
            int size = list.size();
            if (i < size) {
                com.baidu.tieba.tbadkCore.v vVar2 = list.get(i);
                vVar2.setType(0);
                return vVar2;
            } else if (i == size && this.aYu) {
                vVar.setType(1);
                return vVar;
            } else {
                vVar.setType(2);
                return vVar;
            }
        }
        return vVar;
    }

    private List<Object> W(List<com.baidu.tieba.tbadkCore.v> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.aYu) {
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
        this.aYn.notifyDataSetChanged();
    }

    public void X(List<com.baidu.tieba.tbadkCore.v> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.aYn.w(new ArrayList());
            return;
        }
        this.aYt = list;
        if (this.aXt == 2) {
            this.aTv.setVisibility(8);
            this.aYn.w(W(list));
            return;
        }
        this.aTv.setVisibility(0);
        this.aYn.w(V(list));
    }

    public void MO() {
        if (this.aYp != null) {
            this.aYp.h(this.aWq.getPageContext());
            if (TbadkCoreApplication.isLogin()) {
                this.aYm.setSelection(this.aYm.getCount() - 1);
            }
        }
    }

    public void MQ() {
        if (this.aYp != null && this.aYp.Na() != null) {
            this.aYm.removeFooterView(this.aYp.Na());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aYn != null && !this.aYn.isEmpty()) {
            this.aYn.a(this.aWq.getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.dg(i);
        }
        if (this.aYp.Na() != null) {
            this.aYp.Na().f(this.aWq.getPageContext());
        }
        if (this.aYo != null) {
            this.aYo.f(this.aWq.getPageContext());
        }
        if (this.aYq.Mv() != null && this.aYq.Mv().getVisibility() == 0) {
            this.aYq.f(this.aWq.getPageContext());
        }
    }

    public void a(r.a aVar) {
        this.mPullView.a(aVar);
    }

    public void MR() {
        this.aYu = true;
        X(this.aYt);
    }

    public void setSearchHint(String str) {
        if (this.aYo != null) {
            this.aYo.setSearchHint(str);
        }
    }
}
