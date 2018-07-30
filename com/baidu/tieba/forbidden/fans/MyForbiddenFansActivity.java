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
    private LinearLayout axG;
    private PbListView bvA;
    private b dhA;
    private c dhB;
    private e dhC;
    private TextView dhD;
    private c.a dhE = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
        @Override // com.baidu.tieba.forbidden.fans.c.a
        public void a(int i, String str, ArrayList<a> arrayList) {
            if (MyForbiddenFansActivity.this.isProgressBarShown()) {
                MyForbiddenFansActivity.this.hideProgressBar();
            }
            if (i != 0) {
                MyForbiddenFansActivity.this.showToast(str);
            }
            if (w.z(arrayList)) {
                MyForbiddenFansActivity.this.showNoDataView();
            } else if (i == 0) {
                MyForbiddenFansActivity.this.hideNoDataView();
                MyForbiddenFansActivity.this.K(arrayList);
                MyForbiddenFansActivity.this.dhA.L(arrayList);
                MyForbiddenFansActivity.this.dhA.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener dhF = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.jV()) {
                if (view == MyForbiddenFansActivity.this.dhy) {
                    TiebaStatic.log(new an("c13104").r("obj_locate", 2));
                    MyForbiddenFansActivity.this.dhC.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(d.j.neterror));
        }
    };
    private View.OnClickListener dhG = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.jV()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(d.j.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new an("c13105"));
                MyForbiddenFansActivity.this.dhC.bD(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener dhH = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof a) {
                a aVar = (a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MyForbiddenFansActivity.this.getActivity(), String.valueOf(aVar.id), aVar.name)));
            }
        }
    };
    private NavigationBarCoverTip dhx;
    private TextView dhy;
    private BdRecyclerView dhz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.forbidden_fans_list_layout);
        this.axG = (LinearLayout) findViewById(d.g.container_forbidden_fans);
        this.dhB = new c();
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dhy = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(d.j.remove_all_forbidden_fans));
        this.dhx = (NavigationBarCoverTip) findViewById(d.g.navi_cover_tip_forbidden);
        this.dhz = (BdRecyclerView) findViewById(d.g.listview_forbidden_fans);
        this.dhz.setLayoutManager(new LinearLayoutManager(this));
        this.dhz.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.dhB.hasMore() && MyForbiddenFansActivity.this.bvA != null && !MyForbiddenFansActivity.this.bvA.AE()) {
                    MyForbiddenFansActivity.this.bvA.Ax();
                }
                MyForbiddenFansActivity.this.dhB.asP();
            }
        });
        this.bvA = new PbListView(getActivity());
        this.bvA.getView();
        this.bvA.dB(d.C0140d.cp_bg_line_e);
        this.bvA.Au();
        this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_j));
        this.bvA.setTextSize(d.e.tbfontsize33);
        this.bvA.dA(d.C0140d.cp_cont_e);
        this.bvA.setHeight(l.f(getActivity(), d.e.tbds182));
        this.bvA.AB();
        this.dhA = new b(this);
        this.dhz.setAdapter(this.dhA);
        this.dhB.a(this.dhE);
        this.dhC = new e(getPageContext(), getUniqueId());
        this.dhy.setOnClickListener(this.dhF);
        this.dhA.h(this.dhH);
        this.dhA.o(this.dhG);
        this.dhC.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.dhD == null) {
                            MyForbiddenFansActivity.this.dhD = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.dhD.setGravity(19);
                            MyForbiddenFansActivity.this.dhD.setPadding(l.f(MyForbiddenFansActivity.this.getActivity(), d.e.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.dhD.setLayoutParams(new ViewGroup.LayoutParams(-1, l.f(MyForbiddenFansActivity.this.getActivity(), d.e.tbds112)));
                            MyForbiddenFansActivity.this.dhD.setTextSize(0, l.f(MyForbiddenFansActivity.this.getActivity(), d.e.fontsize30));
                            MyForbiddenFansActivity.this.dhD.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(d.C0140d.cp_cont_i));
                        }
                        MyForbiddenFansActivity.this.dhD.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.dhx.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(d.C0140d.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.dhx.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(d.C0140d.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.dhx.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.dhD, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.dhA.bC(j)) {
                                if (MyForbiddenFansActivity.this.dhA.asN()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.dhA.getItemCount() > 20 || !MyForbiddenFansActivity.this.dhB.hasMore()) {
                                    MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dhA.getFansList());
                                    MyForbiddenFansActivity.this.dhA.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.dhB.asP();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.dhA.bC(j)) {
                    if (MyForbiddenFansActivity.this.dhA.asN()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.dhA.getItemCount() > 20 || !MyForbiddenFansActivity.this.dhB.hasMore()) {
                        MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dhA.getFansList());
                        MyForbiddenFansActivity.this.dhA.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.dhB.asP();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void asM() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(d.j.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.dhB.asO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(ArrayList<a> arrayList) {
        if (!w.z(arrayList)) {
            this.dhz.setNextPage(this.bvA);
            if (this.dhB.hasMore()) {
                this.bvA.setText(getString(d.j.pb_load_more));
                this.bvA.Ay();
                return;
            }
            this.bvA.setText(getString(d.j.no_more_data_tip));
            this.bvA.Ay();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.h(this.dhy, d.C0140d.color_remove_all_title);
        this.dhA.notifyDataSetChanged();
        this.dhC.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_d));
        this.bvA.dC(i);
        am.h(this.dhD, d.C0140d.cp_cont_i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dhB.onDestroy();
        this.dhx.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.axG, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), d.e.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.du(d.j.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(d.C0140d.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.dhz.setVisibility(8);
        this.dhy.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.dhz.setVisibility(0);
        this.dhy.setEnabled(true);
    }
}
