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
import com.baidu.tieba.f;
import com.baidu.tieba.forbidden.fans.c;
import com.baidu.tieba.forbidden.fans.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private LinearLayout axD;
    private PbListView bvC;
    private e dhA;
    private TextView dhB;
    private c.a dhC = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.dhy.L(arrayList);
                MyForbiddenFansActivity.this.dhy.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener dhD = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.jV()) {
                if (view == MyForbiddenFansActivity.this.dhw) {
                    TiebaStatic.log(new an("c13104").r("obj_locate", 2));
                    MyForbiddenFansActivity.this.dhA.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(f.j.neterror));
        }
    };
    private View.OnClickListener dhE = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.jV()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(f.j.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new an("c13105"));
                MyForbiddenFansActivity.this.dhA.bD(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener dhF = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof a) {
                a aVar = (a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MyForbiddenFansActivity.this.getActivity(), String.valueOf(aVar.id), aVar.name)));
            }
        }
    };
    private NavigationBarCoverTip dhv;
    private TextView dhw;
    private BdRecyclerView dhx;
    private b dhy;
    private c dhz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.h.forbidden_fans_list_layout);
        this.axD = (LinearLayout) findViewById(f.g.container_forbidden_fans);
        this.dhz = new c();
        this.mNavigationBar = (NavigationBar) findViewById(f.g.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(f.j.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dhw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(f.j.remove_all_forbidden_fans));
        this.dhv = (NavigationBarCoverTip) findViewById(f.g.navi_cover_tip_forbidden);
        this.dhx = (BdRecyclerView) findViewById(f.g.listview_forbidden_fans);
        this.dhx.setLayoutManager(new LinearLayoutManager(this));
        this.dhx.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.dhz.hasMore() && MyForbiddenFansActivity.this.bvC != null && !MyForbiddenFansActivity.this.bvC.AB()) {
                    MyForbiddenFansActivity.this.bvC.Av();
                }
                MyForbiddenFansActivity.this.dhz.asO();
            }
        });
        this.bvC = new PbListView(getActivity());
        this.bvC.getView();
        this.bvC.dA(f.d.cp_bg_line_e);
        this.bvC.As();
        this.bvC.setTextColor(am.getColor(f.d.cp_cont_j));
        this.bvC.setTextSize(f.e.tbfontsize33);
        this.bvC.dz(f.d.cp_cont_e);
        this.bvC.setHeight(l.f(getActivity(), f.e.tbds182));
        this.bvC.Az();
        this.dhy = new b(this);
        this.dhx.setAdapter(this.dhy);
        this.dhz.a(this.dhC);
        this.dhA = new e(getPageContext(), getUniqueId());
        this.dhw.setOnClickListener(this.dhD);
        this.dhy.h(this.dhF);
        this.dhy.o(this.dhE);
        this.dhA.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.dhB == null) {
                            MyForbiddenFansActivity.this.dhB = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.dhB.setGravity(19);
                            MyForbiddenFansActivity.this.dhB.setPadding(l.f(MyForbiddenFansActivity.this.getActivity(), f.e.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.dhB.setLayoutParams(new ViewGroup.LayoutParams(-1, l.f(MyForbiddenFansActivity.this.getActivity(), f.e.tbds112)));
                            MyForbiddenFansActivity.this.dhB.setTextSize(0, l.f(MyForbiddenFansActivity.this.getActivity(), f.e.fontsize30));
                            MyForbiddenFansActivity.this.dhB.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(f.d.cp_cont_i));
                        }
                        MyForbiddenFansActivity.this.dhB.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.dhv.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(f.d.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.dhv.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(f.d.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.dhv.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.dhB, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.dhy.bC(j)) {
                                if (MyForbiddenFansActivity.this.dhy.asM()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.dhy.getItemCount() > 20 || !MyForbiddenFansActivity.this.dhz.hasMore()) {
                                    MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dhy.getFansList());
                                    MyForbiddenFansActivity.this.dhy.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.dhz.asO();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.dhy.bC(j)) {
                    if (MyForbiddenFansActivity.this.dhy.asM()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.dhy.getItemCount() > 20 || !MyForbiddenFansActivity.this.dhz.hasMore()) {
                        MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dhy.getFansList());
                        MyForbiddenFansActivity.this.dhy.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.dhz.asO();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void asL() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(f.j.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.dhz.asN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(ArrayList<a> arrayList) {
        if (!w.z(arrayList)) {
            this.dhx.setNextPage(this.bvC);
            if (this.dhz.hasMore()) {
                this.bvC.setText(getString(f.j.pb_load_more));
                this.bvC.Aw();
                return;
            }
            this.bvC.setText(getString(f.j.no_more_data_tip));
            this.bvC.Aw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.h(this.dhw, f.d.color_remove_all_title);
        this.dhy.notifyDataSetChanged();
        this.dhA.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.bvC.setTextColor(am.getColor(f.d.cp_cont_d));
        this.bvC.dB(i);
        am.h(this.dhB, f.d.cp_cont_i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dhz.onDestroy();
        this.dhv.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.axD, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), f.e.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(f.j.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(f.d.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.dhx.setVisibility(8);
        this.dhw.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.dhx.setVisibility(0);
        this.dhw.setEnabled(true);
    }
}
