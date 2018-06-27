package com.baidu.tieba.forbidden.fans;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.d;
import com.baidu.tieba.forbidden.fans.c;
import com.baidu.tieba.forbidden.fans.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private LinearLayout aya;
    private PbListView buU;
    private NavigationBarCoverTip deH;
    private TextView deI;
    private BdRecyclerView deJ;
    private b deK;
    private c deL;
    private e deM;
    private TextView deN;
    private c.a deO = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
        @Override // com.baidu.tieba.forbidden.fans.c.a
        public void a(int i, String str, ArrayList<a> arrayList) {
            if (MyForbiddenFansActivity.this.isProgressBarShown()) {
                MyForbiddenFansActivity.this.hideProgressBar();
            }
            if (i != 0) {
                MyForbiddenFansActivity.this.showToast(str);
            }
            if (w.A(arrayList)) {
                MyForbiddenFansActivity.this.showNoDataView();
            } else if (i == 0) {
                MyForbiddenFansActivity.this.hideNoDataView();
                MyForbiddenFansActivity.this.K(arrayList);
                MyForbiddenFansActivity.this.deK.L(arrayList);
                MyForbiddenFansActivity.this.deK.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener deP = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.jU()) {
                if (view == MyForbiddenFansActivity.this.deI) {
                    TiebaStatic.log(new an("c13104").r("obj_locate", 2));
                    MyForbiddenFansActivity.this.deM.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(d.k.neterror));
        }
    };
    private View.OnClickListener deQ = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.jU()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(d.k.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new an("c13105"));
                MyForbiddenFansActivity.this.deM.bz(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener deR = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof a) {
                a aVar = (a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MyForbiddenFansActivity.this.getActivity(), String.valueOf(aVar.id), aVar.name)));
            }
        }
    };
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.forbidden_fans_list_layout);
        this.aya = (LinearLayout) findViewById(d.g.container_forbidden_fans);
        this.deL = new c();
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.k.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.deI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(d.k.remove_all_forbidden_fans));
        this.deH = (NavigationBarCoverTip) findViewById(d.g.navi_cover_tip_forbidden);
        this.deJ = (BdRecyclerView) findViewById(d.g.listview_forbidden_fans);
        this.deJ.setLayoutManager(new LinearLayoutManager(this));
        this.deJ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.deL.hasMore() && MyForbiddenFansActivity.this.buU != null && !MyForbiddenFansActivity.this.buU.AO()) {
                    MyForbiddenFansActivity.this.buU.AH();
                }
                MyForbiddenFansActivity.this.deL.asl();
            }
        });
        this.buU = new PbListView(getActivity());
        this.buU.getView();
        this.buU.dy(d.C0142d.cp_bg_line_e);
        this.buU.AE();
        this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_j));
        this.buU.setTextSize(d.e.tbfontsize33);
        this.buU.dx(d.C0142d.cp_cont_e);
        this.buU.setHeight(l.e(getActivity(), d.e.tbds182));
        this.buU.AL();
        this.deK = new b(this);
        this.deJ.setAdapter(this.deK);
        this.deL.a(this.deO);
        this.deM = new e(getPageContext(), getUniqueId());
        this.deI.setOnClickListener(this.deP);
        this.deK.h(this.deR);
        this.deK.o(this.deQ);
        this.deM.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    if (i2 == 0) {
                        MyForbiddenFansActivity.this.closeLoadingDialog();
                        if (i == 0) {
                            MyForbiddenFansActivity.this.showNoDataView();
                        } else if (i == 2260104) {
                            return;
                        }
                        if (MyForbiddenFansActivity.this.deN == null) {
                            MyForbiddenFansActivity.this.deN = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.deN.setGravity(19);
                            MyForbiddenFansActivity.this.deN.setPadding(l.e(MyForbiddenFansActivity.this.getActivity(), d.e.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.deN.setLayoutParams(new ViewGroup.LayoutParams(-1, l.e(MyForbiddenFansActivity.this.getActivity(), d.e.tbds112)));
                            MyForbiddenFansActivity.this.deN.setTextSize(0, l.e(MyForbiddenFansActivity.this.getActivity(), d.e.fontsize30));
                            MyForbiddenFansActivity.this.deN.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(d.C0142d.cp_cont_i));
                        }
                        MyForbiddenFansActivity.this.deN.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.deH.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(d.C0142d.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.deH.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(d.C0142d.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.deH.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.deN, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.deK.by(j)) {
                                if (MyForbiddenFansActivity.this.deK.asj()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.deK.getItemCount() > 20 || !MyForbiddenFansActivity.this.deL.hasMore()) {
                                    MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.deK.getFansList());
                                    MyForbiddenFansActivity.this.deK.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.deL.asl();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.deK.by(j)) {
                    if (MyForbiddenFansActivity.this.deK.asj()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.deK.getItemCount() > 20 || !MyForbiddenFansActivity.this.deL.hasMore()) {
                        MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.deK.getFansList());
                        MyForbiddenFansActivity.this.deK.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.deL.asl();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void asi() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(d.k.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.deL.ask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(ArrayList<a> arrayList) {
        if (!w.A(arrayList)) {
            this.deJ.setNextPage(this.buU);
            if (this.deL.hasMore()) {
                this.buU.setText(getString(d.k.pb_load_more));
                this.buU.AI();
                return;
            }
            this.buU.setText(getString(d.k.no_more_data_tip));
            this.buU.AI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.h(this.deI, d.C0142d.color_remove_all_title);
        this.deK.notifyDataSetChanged();
        this.deM.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_d));
        this.buU.dz(i);
        am.h(this.deN, d.C0142d.cp_cont_i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.deL.onDestroy();
        this.deH.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.aya, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(getActivity(), d.e.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(d.k.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(d.C0142d.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.deJ.setVisibility(8);
        this.deI.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.deJ.setVisibility(0);
        this.deI.setEnabled(true);
    }
}
