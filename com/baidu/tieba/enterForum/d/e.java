package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private View aXh;
    private final com.baidu.tieba.enterForum.home.e baZ;
    private ViewEventCenter bbj;
    private BdListView bcV;
    private com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> bcW;
    private r bcX;
    private ag bcY;
    private com.baidu.tieba.enterForum.c.g bcZ;
    private int bcc = 0;
    private ViewGroup bda;
    private boolean bdb;
    private List<com.baidu.tieba.tbadkCore.v> bdc;
    private boolean bdd;
    private CommonTipView bde;
    private com.baidu.tbadk.core.view.u mPullView;

    public e(com.baidu.tieba.enterForum.home.e eVar, View view, ViewEventCenter viewEventCenter) {
        this.bdd = false;
        this.baZ = eVar;
        this.bbj = viewEventCenter;
        this.bcY = new ag(viewEventCenter);
        this.bcZ = new com.baidu.tieba.enterForum.c.g(eVar.getPageContext(), viewEventCenter);
        V(view);
        Ou();
        this.bcV.setAdapter((ListAdapter) this.bcW);
        this.bdd = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void V(View view) {
        this.bda = (ViewGroup) view.findViewById(t.g.mybar_root_layout);
        this.bcV = (BdListView) view.findViewById(t.g.listview);
        this.mPullView = new com.baidu.tbadk.core.view.u(this.baZ.getPageContext());
        this.mPullView.setTag(this.baZ.getUniqueId());
        this.bcV.setPullRefresh(this.mPullView);
        this.bcX = new r(this.baZ.getFragmentActivity());
        this.bcX.setEventCenter(this.bbj);
        this.aXh = this.bcX.findViewById(t.g.divider_line);
        this.bcV.addHeaderView(this.bcX);
    }

    public int Ol() {
        return this.bcc;
    }

    public int Ot() {
        return this.bcZ.Ol();
    }

    private void Ou() {
        this.bcW = new f(this, this.baZ.getPageContext(), new Class[]{y.class, w.class, o.class}, new int[]{t.h.home_like_item_with_portrait, t.h.home_like_item_extra_with_text, t.h.home_like_two_column_item}, this.bbj);
        this.bcW.bG(false);
    }

    public void b(com.baidu.tieba.tbadkCore.v vVar) {
        this.bcZ.b(vVar);
    }

    public void X(List<com.baidu.tieba.tbadkCore.v> list) {
        this.bcZ.R(list);
    }

    public List<com.baidu.tieba.tbadkCore.v> Ov() {
        return this.bcZ.FZ();
    }

    public void Ow() {
        this.bcZ.Om();
    }

    public boolean Ox() {
        return this.bdb;
    }

    public void Oy() {
        this.bcc = this.bcZ.Ol();
        ab(this.bcZ.FZ());
    }

    public void gm(int i) {
        this.bdb = true;
        if (this.bcZ.Oj() == null) {
            this.bcZ.Ok();
        }
        i Oj = this.bcZ.Oj();
        Oj.f(this.baZ.getPageContext());
        if (Oj.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(2, this.bcV.getId());
            this.bda.addView(Oj, layoutParams);
        }
        this.bcZ.a(this.bcc, this.bdc);
        com.baidu.adp.lib.h.h.hx().post(new g(this, i));
    }

    public void Oz() {
        this.bdb = false;
        this.bcV.setVisibility(0);
        if (this.bcZ.Oj() != null) {
            this.bda.removeView(this.bcZ.Oj());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gn(int i) {
        int i2;
        if (this.bcZ.Oj() != null && this.bcV != null && this.bcV.getChildCount() > 0) {
            int firstVisiblePosition = this.bcV.getFirstVisiblePosition();
            if (this.bcc == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.bcV.getChildAt(0);
            this.bcZ.Oj().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void nk() {
        this.bcV.nk();
    }

    public void Op() {
        this.bcV.nj();
    }

    public void cp(boolean z) {
        this.bcX.a(this.baZ.getPageContext(), z);
    }

    public void W(View view) {
        if (this.bcX != null && view != null) {
            this.bcX.W(view);
        }
    }

    public View getBannerView() {
        if (this.bcX == null) {
            return null;
        }
        return this.bcX.getBannerView();
    }

    public void Y(List<com.baidu.tieba.enterForum.b.f> list) {
        if (list == null || list.isEmpty()) {
            OD();
            return;
        }
        this.bcY.a(this.baZ.getFragmentActivity(), list, this.baZ.getPageContext());
        if (this.bcV.getFooterViewsCount() < 1) {
            this.bcV.addFooterView(this.bcY.OO(), null, false);
            com.baidu.tbadk.i.a.a(this.baZ.getPageContext(), this.bcY.OO());
        }
    }

    public List<com.baidu.tieba.tbadkCore.v> OA() {
        return this.bdc;
    }

    public List<com.baidu.tieba.tbadkCore.v> OB() {
        return this.bcZ.FZ();
    }

    public void go(int i) {
        this.bcc = i;
    }

    private List<Object> Z(List<com.baidu.tieba.tbadkCore.v> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.bdd) {
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
            } else if (i == size && this.bdd) {
                vVar.setType(1);
                return vVar;
            } else {
                vVar.setType(2);
                return vVar;
            }
        }
        return vVar;
    }

    private List<Object> aa(List<com.baidu.tieba.tbadkCore.v> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.bdd) {
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
        this.bcW.notifyDataSetChanged();
    }

    public void ab(List<com.baidu.tieba.tbadkCore.v> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.bcW.x(new ArrayList());
            return;
        }
        this.bdc = list;
        if (this.bcc == 2) {
            this.aXh.setVisibility(8);
            this.bcW.x(aa(list));
            return;
        }
        this.aXh.setVisibility(0);
        this.bcW.x(Z(list));
    }

    public void OC() {
        if (this.bcY != null) {
            this.bcY.h(this.baZ.getPageContext());
            if (TbadkCoreApplication.isLogin()) {
                this.bcV.setSelection(this.bcV.getCount() - 1);
            }
        }
    }

    public void OD() {
        if (this.bcY != null && this.bcY.OO() != null) {
            this.bcV.removeFooterView(this.bcY.OO());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bcW != null && !this.bcW.isEmpty()) {
            this.bcW.a(this.baZ.getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.dj(i);
        }
        if (this.bcY.OO() != null) {
            this.bcY.OO().f(this.baZ.getPageContext());
        }
        if (this.bcX != null) {
            this.bcX.f(this.baZ.getPageContext());
        }
        if (this.bcZ.Oj() != null && this.bcZ.Oj().getVisibility() == 0) {
            this.bcZ.f(this.baZ.getPageContext());
        }
    }

    public void a(s.a aVar) {
        this.mPullView.a(aVar);
    }

    public void OE() {
        this.bdd = true;
        ab(this.bdc);
    }

    public void setSearchHint(String str) {
        if (this.bcX != null) {
            this.bcX.setSearchHint(str);
        }
    }

    public void OF() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("enter_forum_login_tip", true)) {
            if (this.bde == null) {
                this.bde = new CommonTipView(this.baZ.getActivity());
            }
            this.bde.setText(t.j.enter_forum_login_tip);
            this.bde.a((RelativeLayout) this.bda, TbadkCoreApplication.m411getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestory() {
        if (this.bde != null) {
            this.bde.onDestroy();
        }
    }
}
