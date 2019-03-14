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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.d;
import com.baidu.tieba.forbidden.fans.c;
import com.baidu.tieba.forbidden.fans.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private LinearLayout bFw;
    private PbListView dbn;
    private NavigationBarCoverTip eTS;
    private TextView eTT;
    private BdRecyclerView eTU;
    private b eTV;
    private c eTW;
    private e eTX;
    private TextView eTY;
    private c.a eTZ = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
        @Override // com.baidu.tieba.forbidden.fans.c.a
        public void a(int i, String str, ArrayList<a> arrayList) {
            if (MyForbiddenFansActivity.this.isProgressBarShown()) {
                MyForbiddenFansActivity.this.hideProgressBar();
            }
            if (i != 0) {
                MyForbiddenFansActivity.this.showToast(str);
            }
            if (v.T(arrayList)) {
                MyForbiddenFansActivity.this.showNoDataView();
            } else if (i == 0) {
                MyForbiddenFansActivity.this.hideNoDataView();
                MyForbiddenFansActivity.this.N(arrayList);
                MyForbiddenFansActivity.this.eTV.O(arrayList);
                MyForbiddenFansActivity.this.eTV.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener eUa = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.lo()) {
                if (view == MyForbiddenFansActivity.this.eTT) {
                    TiebaStatic.log(new am("c13104").T("obj_locate", 2));
                    MyForbiddenFansActivity.this.eTX.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(d.j.neterror));
        }
    };
    private View.OnClickListener eUb = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.lo()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(d.j.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new am("c13105"));
                MyForbiddenFansActivity.this.eTX.cB(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener eUc = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        setContentView(d.h.forbidden_fans_list_layout);
        this.bFw = (LinearLayout) findViewById(d.g.container_forbidden_fans);
        this.eTW = new c();
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eTT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(d.j.remove_all_forbidden_fans));
        this.eTS = (NavigationBarCoverTip) findViewById(d.g.navi_cover_tip_forbidden);
        this.eTU = (BdRecyclerView) findViewById(d.g.listview_forbidden_fans);
        this.eTU.setLayoutManager(new LinearLayoutManager(this));
        this.eTU.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.eTW.hasMore() && MyForbiddenFansActivity.this.dbn != null && !MyForbiddenFansActivity.this.dbn.qz()) {
                    MyForbiddenFansActivity.this.dbn.aeC();
                }
                MyForbiddenFansActivity.this.eTW.baR();
            }
        });
        this.dbn = new PbListView(getActivity());
        this.dbn.getView();
        this.dbn.ib(d.C0277d.cp_bg_line_e);
        this.dbn.aez();
        this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbn.setTextSize(d.e.tbfontsize33);
        this.dbn.ia(d.C0277d.cp_cont_e);
        this.dbn.setHeight(l.h(getActivity(), d.e.tbds182));
        this.dbn.aeG();
        this.eTV = new b(this);
        this.eTU.setAdapter(this.eTV);
        this.eTW.a(this.eTZ);
        this.eTX = new e(getPageContext(), getUniqueId());
        this.eTT.setOnClickListener(this.eUa);
        this.eTV.k(this.eUc);
        this.eTV.r(this.eUb);
        this.eTX.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.eTY == null) {
                            MyForbiddenFansActivity.this.eTY = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.eTY.setGravity(19);
                            MyForbiddenFansActivity.this.eTY.setPadding(l.h(MyForbiddenFansActivity.this.getActivity(), d.e.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.eTY.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(MyForbiddenFansActivity.this.getActivity(), d.e.tbds112)));
                            MyForbiddenFansActivity.this.eTY.setTextSize(0, l.h(MyForbiddenFansActivity.this.getActivity(), d.e.fontsize30));
                            MyForbiddenFansActivity.this.eTY.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(d.C0277d.cp_btn_a));
                        }
                        MyForbiddenFansActivity.this.eTY.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.eTS.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(d.C0277d.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.eTS.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(d.C0277d.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.eTS.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.eTY, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.eTV.cA(j)) {
                                if (MyForbiddenFansActivity.this.eTV.baP()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.eTV.getItemCount() > 20 || !MyForbiddenFansActivity.this.eTW.hasMore()) {
                                    MyForbiddenFansActivity.this.N(MyForbiddenFansActivity.this.eTV.getFansList());
                                    MyForbiddenFansActivity.this.eTV.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.eTW.baR();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.eTV.cA(j)) {
                    if (MyForbiddenFansActivity.this.eTV.baP()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.eTV.getItemCount() > 20 || !MyForbiddenFansActivity.this.eTW.hasMore()) {
                        MyForbiddenFansActivity.this.N(MyForbiddenFansActivity.this.eTV.getFansList());
                        MyForbiddenFansActivity.this.eTV.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.eTW.baR();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void baO() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(d.j.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.eTW.baQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(ArrayList<a> arrayList) {
        if (!v.T(arrayList)) {
            this.eTU.setNextPage(this.dbn);
            if (this.eTW.hasMore()) {
                this.dbn.setText(getString(d.j.pb_load_more));
                this.dbn.aeD();
                return;
            }
            this.dbn.setText(getString(d.j.no_more_data_tip));
            this.dbn.aeD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.j(this.eTT, d.C0277d.color_remove_all_title);
        this.eTV.notifyDataSetChanged();
        this.eTX.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_d));
        this.dbn.ic(i);
        al.j(this.eTY, d.C0277d.cp_btn_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eTW.onDestroy();
        this.eTS.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.bFw, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), d.e.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(d.j.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(d.C0277d.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.eTU.setVisibility(8);
        this.eTT.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.eTU.setVisibility(0);
        this.eTT.setEnabled(true);
    }
}
