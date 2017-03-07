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
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private final com.baidu.tieba.enterForum.home.f bEG;
    private ViewEventCenter bEQ;
    private com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>> bFM;
    private r bFN;
    private ag bFO;
    private com.baidu.tieba.enterForum.model.e bFP;
    private boolean bFQ;
    private List<com.baidu.tieba.tbadkCore.u> bFR;
    private boolean bFS;
    private CommonTipView bFT;
    private TextView bFU;
    private BdListView bip;
    private View bjO;
    private View byy;
    private com.baidu.tbadk.core.view.ae mPullView;
    private int bFD = 0;
    private boolean bFV = false;

    public e(com.baidu.tieba.enterForum.home.f fVar, View view, ViewEventCenter viewEventCenter) {
        this.bFS = false;
        this.bEG = fVar;
        this.bEQ = viewEventCenter;
        this.bFO = new ag(viewEventCenter);
        this.bFP = new com.baidu.tieba.enterForum.model.e(fVar.getPageContext(), viewEventCenter);
        ad(view);
        Wa();
        this.bip.setAdapter((ListAdapter) this.bFM);
        this.bFS = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void ad(View view) {
        this.bip = (BdListView) view.findViewById(w.h.listview);
        this.mPullView = new com.baidu.tbadk.core.view.ae(this.bEG.getPageContext());
        this.mPullView.setTag(this.bEG.getUniqueId());
        this.mPullView.a(new f(this));
        this.bip.setPullRefresh(this.mPullView);
        this.bFN = new r(this.bEG.getFragmentActivity());
        this.bFN.setEventCenter(this.bEQ);
        this.bjO = this.bFN.findViewById(w.h.divider_line);
        this.bip.addHeaderView(this.bFN);
        this.bFU = (TextView) BdListViewHelper.a(this.bEG.getPageContext().getPageActivity(), this.bip, BdListViewHelper.HeadType.DEFAULT);
        this.byy = new View(this.bEG.getActivity());
        this.byy.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.bEG.getActivity(), w.f.ds150)));
    }

    public int VT() {
        return this.bFD;
    }

    public int VZ() {
        return this.bFP.VT();
    }

    private void Wa() {
        this.bFM = new g(this, this.bEG.getPageContext(), new Class[]{y.class, w.class, o.class}, new int[]{w.j.home_like_item_with_portrait, w.j.home_like_item_extra_with_text, w.j.home_like_two_column_item}, this.bEQ);
        this.bFM.bS(false);
    }

    public void b(com.baidu.tieba.tbadkCore.u uVar) {
        this.bFP.b(uVar);
    }

    public void ag(List<com.baidu.tieba.tbadkCore.u> list) {
        this.bFP.af(list);
    }

    public List<com.baidu.tieba.tbadkCore.u> Wb() {
        return this.bFP.getDataList();
    }

    public void Wc() {
        this.bFP.VU();
    }

    public boolean VC() {
        return this.bFQ;
    }

    public BdListView Wd() {
        return this.bip;
    }

    public TextView We() {
        return this.bFU;
    }

    public void Wf() {
        this.bFD = this.bFP.VT();
        ak(this.bFP.getDataList());
    }

    public void hq(int i) {
        this.bFQ = true;
        if (this.bFP.VR() == null) {
            this.bFP.VS();
        }
        j VR = this.bFP.VR();
        VR.n(this.bEG.getPageContext());
        if (VR.getParent() == null && this.bEG.Vs() != null && this.bEG.Vr() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.bEG.Vs().getId());
            this.bEG.Vr().addView(VR);
        }
        this.bFP.a(this.bFD, this.bFR);
        com.baidu.adp.lib.g.h.fM().post(new h(this, i));
    }

    public void Wg() {
        this.bFQ = false;
        this.bip.setVisibility(0);
        if (this.bFP.VR() != null && this.bEG.Vr() != null) {
            this.bEG.Vr().removeView(this.bFP.VR());
        }
    }

    public void Wh() {
        this.bip.setVisibility(8);
        if (this.bFP.VR() != null) {
            this.bFP.VR().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hr(int i) {
        int i2;
        if (this.bFP.VR() != null && this.bip != null && this.bip.getChildCount() > 0) {
            int firstVisiblePosition = this.bip.getFirstVisiblePosition();
            if (this.bFD == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.bip.getChildAt(0);
            this.bFP.VR().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bip.startPullRefresh();
    }

    public void Wi() {
        this.bip.completePullRefreshPostDelayed(2000L);
    }

    public void dj(boolean z) {
        this.bFN.a(this.bEG.getPageContext(), z);
    }

    public void f(com.baidu.tieba.enterForum.b.b bVar) {
        this.bFN.a(this.bEG.getPageContext(), bVar);
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.bFN.b(list, tbPageContext);
    }

    public void ae(View view) {
        if (this.bFN != null && view != null) {
            this.bFN.ae(view);
        }
    }

    public View getBannerView() {
        if (this.bFN == null) {
            return null;
        }
        return this.bFN.getBannerView();
    }

    public void ah(List<com.baidu.tieba.enterForum.b.g> list) {
        if (list == null || list.isEmpty()) {
            Wn();
            return;
        }
        this.bFO.a(this.bEG.getFragmentActivity(), list, this.bEG.getPageContext());
        if (!TbadkCoreApplication.isLogin()) {
            if (this.bip.getFooterViewsCount() < 1) {
                Wj();
            }
        } else if (this.bip.getFooterViewsCount() < 2) {
            Wj();
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bip.removeFooterView(this.byy);
            this.bip.addFooterView(this.byy);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bip.removeFooterView(this.byy);
        }
    }

    private void Wj() {
        this.bip.addFooterView(this.bFO.WA(), null, false);
        com.baidu.tbadk.i.a.a(this.bEG.getPageContext(), this.bFO.WA());
    }

    public List<com.baidu.tieba.tbadkCore.u> Wk() {
        return this.bFR;
    }

    public List<com.baidu.tieba.tbadkCore.u> Wl() {
        return this.bFP.getDataList();
    }

    public void hs(int i) {
        this.bFD = i;
    }

    private List<Object> ai(List<com.baidu.tieba.tbadkCore.u> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.bFS) {
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
            } else if (i == size && this.bFS) {
                uVar.setType(1);
                return uVar;
            } else {
                uVar.setType(2);
                return uVar;
            }
        }
        return uVar;
    }

    private List<Object> aj(List<com.baidu.tieba.tbadkCore.u> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.bFS) {
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
        this.bFM.notifyDataSetChanged();
    }

    public void ak(List<com.baidu.tieba.tbadkCore.u> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.bFM.w(new ArrayList());
            return;
        }
        this.bFR = list;
        if (this.bFD == 2) {
            this.bjO.setVisibility(8);
            this.bFM.w(aj(list));
            return;
        }
        this.bjO.setVisibility(0);
        this.bFM.w(ai(list));
    }

    public void Wm() {
        if (this.bFO != null) {
            this.bFO.p(this.bEG.getPageContext());
            if (TbadkCoreApplication.isLogin()) {
                this.bip.setSelection(this.bip.getCount() - 1);
            }
        }
    }

    public void Wn() {
        if (this.bFO != null && this.bFO.WA() != null) {
            this.bip.removeFooterView(this.bFO.WA());
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bip.removeFooterView(this.byy);
            this.bip.addFooterView(this.byy);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bip.removeFooterView(this.byy);
        }
        if (this.bFM != null && !this.bFM.isEmpty()) {
            this.bFM.b(this.bEG.getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.dh(i);
        }
        if (this.bFO.WA() != null) {
            this.bFO.WA().n(this.bEG.getPageContext());
        }
        if (this.bFN != null) {
            this.bFN.n(this.bEG.getPageContext());
        }
        if (this.bFP.VR() != null && this.bFP.VR().getVisibility() == 0) {
            this.bFP.n(this.bEG.getPageContext());
        }
    }

    public void a(ab.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.bFN != null) {
            this.bFN.setSearchHint(str);
        }
    }

    public void Wo() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("enter_forum_login_tip", true)) {
            if (this.bFT == null) {
                this.bFT = new CommonTipView(this.bEG.getActivity());
            }
            this.bFT.setText(w.l.enter_forum_login_tip);
            this.bFT.b(this.bEG.Vr(), TbadkCoreApplication.m9getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestory() {
        if (this.bFT != null) {
            this.bFT.onDestroy();
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        this.bFN.setAttentionTitleVisibililty(z);
    }
}
