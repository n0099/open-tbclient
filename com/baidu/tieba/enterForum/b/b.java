package com.baidu.tieba.enterForum.b;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private BdListView bEe;
    private View bYw;
    private ViewEventCenter cjP;
    private final com.baidu.tieba.enterForum.home.a ckl;
    private com.baidu.tieba.enterForum.a.a clI;
    private f clJ;
    private com.baidu.tieba.enterForum.model.c clK;
    private com.baidu.tieba.enterForum.multiConcern.a clL;
    private boolean clM;
    private List<com.baidu.tieba.enterForum.data.f> clN;
    private CommonTipView clO;
    private com.baidu.tbadk.core.view.f mNoDataView;
    private h mPullView;

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.ckl = aVar;
        this.cjP = viewEventCenter;
        this.clK = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.clL = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().oQ(), viewEventCenter);
        ar(view);
        this.clI = new com.baidu.tieba.enterForum.a.a(this.ckl.getPageContext(), this.cjP);
        this.bEe.setAdapter((ListAdapter) this.clI);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ar(View view) {
        this.bEe = (BdListView) view.findViewById(d.g.listview);
        this.bEe.setVerticalScrollBarEnabled(false);
        this.mPullView = new h(this.ckl.getPageContext());
        this.mPullView.setTag(this.ckl.getUniqueId());
        this.bEe.setPullRefresh(this.mPullView);
        this.clJ = new f(this.ckl.getFragmentActivity());
        this.clJ.setEventCenter(this.cjP);
        this.bEe.addHeaderView(this.clJ);
        BdListViewHelper.a(this.ckl.getPageContext().getPageActivity(), this.bEe, BdListViewHelper.HeadType.DEFAULT);
        this.bYw = new View(this.ckl.getActivity());
        this.bYw.setLayoutParams(new AbsListView.LayoutParams(-1, l.f(this.ckl.getActivity(), d.e.ds0)));
    }

    public View afl() {
        this.clJ.iR(l.f(this.ckl.getPageContext().getPageActivity(), d.e.ds20));
        return BdListViewHelper.a(this.ckl.getPageContext().getPageActivity(), this.bEe, BdListViewHelper.HeadType.TIP);
    }

    public void aq(View view) {
        this.clJ.iR(l.f(this.ckl.getPageContext().getPageActivity(), d.e.ds10));
        this.bEe.removeHeaderView(view);
    }

    public void as(View view) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ckl.getPageContext().getContext(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.net_refresh_emotion, l.f(this.ckl.getPageContext().getContext(), d.e.ds300), l.f(this.ckl.getPageContext().getContext(), d.e.ds480), l.f(this.ckl.getPageContext().getContext(), d.e.ds360)), NoDataViewFactory.d.af(this.ckl.getString(d.j.neterror), this.ckl.getString(d.j.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ckl.getString(d.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.clJ.setVisibility(8);
                    b.this.startPullRefresh();
                }
            })));
        }
        this.mNoDataView.onChangeSkinType(this.ckl.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bEe.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bEe.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.v(this.clN);
    }

    public void b(com.baidu.tieba.enterForum.data.f fVar) {
        this.clK.b(fVar);
    }

    public boolean afq() {
        return this.clM;
    }

    public BdListView afJ() {
        return this.bEe;
    }

    public void afK() {
        ax(this.clK.getDataList());
    }

    public void iP(final int i) {
        this.clM = true;
        if (this.clK.afD() == null) {
            this.clK.createView();
            this.clK.afD().setVisibility(8);
        }
        d afD = this.clK.afD();
        afD.k(this.ckl.getPageContext());
        if (afD.getParent() == null && this.ckl.afi() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.ckl.afc().getId());
            this.ckl.afc().addView(afD);
            this.ckl.afh();
        }
        this.clK.au(this.clN);
        com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.iQ(i);
                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.clK.afD() != null) {
                            b.this.clK.afD().setVisibility(0);
                            b.this.bEe.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void afL() {
        this.clM = false;
        this.bEe.setVisibility(0);
        if (this.clK.afD() != null && this.ckl.afc() != null) {
            this.ckl.afc().removeView(this.clK.afD());
            this.clK.afD().setVisibility(8);
        }
        this.ckl.afh();
    }

    public void afM() {
        this.clM = true;
        this.bEe.setVisibility(8);
        if (this.clK.afD() != null) {
            this.clK.afD().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iQ(int i) {
        if (this.clK.afD() != null && this.bEe != null && this.bEe.getChildCount() > 0) {
            int firstVisiblePosition = (this.bEe.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.bEe.getChildAt(0);
            this.clK.afD().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bEe.startPullRefresh();
    }

    public void afN() {
        this.bEe.completePullRefreshPostDelayed(2000L);
    }

    public List<com.baidu.tieba.enterForum.data.f> afO() {
        return this.clN;
    }

    public List<com.baidu.tieba.enterForum.data.f> afP() {
        List<com.baidu.tieba.enterForum.data.f> dataList = this.clK.getDataList();
        com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) v.c(dataList, 0);
        if (fVar != null && fVar.getType() == 1) {
            v.d(dataList, 0);
        }
        return dataList;
    }

    private List<com.baidu.tieba.enterForum.data.c> a(List list, boolean z, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        int size = list.size();
        int i3 = 1;
        int i4 = 0;
        while (i4 < size && (i2 <= 0 || i3 < i2 * 2)) {
            com.baidu.tieba.enterForum.data.e eVar = new com.baidu.tieba.enterForum.data.e();
            com.baidu.tieba.enterForum.data.e eVar2 = new com.baidu.tieba.enterForum.data.e();
            if (i3 < size) {
                eVar = (com.baidu.tieba.enterForum.data.e) list.get(i4);
                eVar2 = (com.baidu.tieba.enterForum.data.e) list.get(i3);
                eVar.setType(i);
                eVar2.setType(i);
            } else if (i4 < size) {
                eVar = (com.baidu.tieba.enterForum.data.e) list.get(i4);
                eVar.setType(i);
                eVar2.setType(2);
            }
            arrayList.add(new com.baidu.tieba.enterForum.data.a(eVar, eVar2));
            int i5 = i4 + 2;
            i3 = i5 + 1;
            i4 = i5;
        }
        return arrayList;
    }

    public void notifyDataSetChanged() {
        this.clI.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ax(List<com.baidu.tieba.enterForum.data.f> list) {
        boolean z;
        this.clN = list;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (v.u(a) == 1 && (a.get(0) instanceof com.baidu.tieba.enterForum.data.a)) {
            com.baidu.tieba.enterForum.data.a aVar = (com.baidu.tieba.enterForum.data.a) a.get(0);
            if (aVar.aeR().getType() == 1 && aVar.aeS().getType() == 2) {
                z = false;
                if (v.v(a)) {
                    arrayList.add(new com.baidu.tieba.enterForum.data.d(this.ckl.getPageContext().getResources().getString(d.j.my_attention_bar), z));
                    arrayList.addAll(a);
                } else {
                    com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                    cVar.setType(3);
                    arrayList.add(cVar);
                }
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.setType(2);
                arrayList.add(cVar2);
                hideNoDataView();
                this.clI.setData(arrayList);
                if (!this.clM) {
                    this.bEe.setVisibility(8);
                    return;
                }
                afL();
                this.clJ.setVisibility(0);
                return;
            }
        }
        z = true;
        if (v.v(a)) {
        }
        com.baidu.tieba.enterForum.data.c cVar22 = new com.baidu.tieba.enterForum.data.c();
        cVar22.setType(2);
        arrayList.add(cVar22);
        hideNoDataView();
        this.clI.setData(arrayList);
        if (!this.clM) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bEe.removeFooterView(this.bYw);
            this.bEe.addFooterView(this.bYw);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.bEe.removeFooterView(this.bYw);
        }
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
        if (this.clJ != null) {
            this.clJ.k(this.ckl.getPageContext());
        }
        if (this.clK.afD() != null && this.clK.afD().getVisibility() == 0) {
            this.clK.k(this.ckl.getPageContext());
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ckl.getPageContext(), i);
        }
        if (this.clL.afI() != null) {
            this.clL.onChangeSkinType();
        }
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.clJ != null) {
            this.clJ.setSearchHint(str);
        }
    }

    public void afQ() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.clO == null) {
                this.clO = new CommonTipView(this.ckl.getActivity());
            }
            this.clO.setText(d.j.enter_forum_login_tip);
            this.clO.show(this.ckl.afc(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.clO != null) {
            this.clO.onDestroy();
        }
        if (this.clL != null) {
            this.clL.onDestroy();
        }
    }

    public void ay(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.clL.isShowing() && !v.v(list)) {
            this.clL.aw(list);
        }
    }
}
