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
import com.baidu.tieba.e;
import com.baidu.tieba.forbidden.fans.c;
import com.baidu.tieba.forbidden.fans.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private LinearLayout aAJ;
    private PbListView bBr;
    private NavigationBarCoverTip dnn;
    private TextView dno;
    private BdRecyclerView dnp;
    private b dnq;
    private c dnr;
    private e dns;
    private TextView dnt;
    private c.a dnu = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
        @Override // com.baidu.tieba.forbidden.fans.c.a
        public void a(int i, String str, ArrayList<a> arrayList) {
            if (MyForbiddenFansActivity.this.isProgressBarShown()) {
                MyForbiddenFansActivity.this.hideProgressBar();
            }
            if (i != 0) {
                MyForbiddenFansActivity.this.showToast(str);
            }
            if (v.z(arrayList)) {
                MyForbiddenFansActivity.this.showNoDataView();
            } else if (i == 0) {
                MyForbiddenFansActivity.this.hideNoDataView();
                MyForbiddenFansActivity.this.K(arrayList);
                MyForbiddenFansActivity.this.dnq.L(arrayList);
                MyForbiddenFansActivity.this.dnq.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener dnv = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.lb()) {
                if (view == MyForbiddenFansActivity.this.dno) {
                    TiebaStatic.log(new am("c13104").w("obj_locate", 2));
                    MyForbiddenFansActivity.this.dns.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(e.j.neterror));
        }
    };
    private View.OnClickListener dnw = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.lb()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(e.j.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new am("c13105"));
                MyForbiddenFansActivity.this.dns.bH(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener dnx = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        setContentView(e.h.forbidden_fans_list_layout);
        this.aAJ = (LinearLayout) findViewById(e.g.container_forbidden_fans);
        this.dnr = new c();
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dno = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(e.j.remove_all_forbidden_fans));
        this.dnn = (NavigationBarCoverTip) findViewById(e.g.navi_cover_tip_forbidden);
        this.dnp = (BdRecyclerView) findViewById(e.g.listview_forbidden_fans);
        this.dnp.setLayoutManager(new LinearLayoutManager(this));
        this.dnp.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.dnr.hasMore() && MyForbiddenFansActivity.this.bBr != null && !MyForbiddenFansActivity.this.bBr.BO()) {
                    MyForbiddenFansActivity.this.bBr.BI();
                }
                MyForbiddenFansActivity.this.dnr.auC();
            }
        });
        this.bBr = new PbListView(getActivity());
        this.bBr.getView();
        this.bBr.dL(e.d.cp_bg_line_e);
        this.bBr.BF();
        this.bBr.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bBr.setTextSize(e.C0141e.tbfontsize33);
        this.bBr.dK(e.d.cp_cont_e);
        this.bBr.setHeight(l.h(getActivity(), e.C0141e.tbds182));
        this.bBr.BM();
        this.dnq = new b(this);
        this.dnp.setAdapter(this.dnq);
        this.dnr.a(this.dnu);
        this.dns = new e(getPageContext(), getUniqueId());
        this.dno.setOnClickListener(this.dnv);
        this.dnq.h(this.dnx);
        this.dnq.o(this.dnw);
        this.dns.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.dnt == null) {
                            MyForbiddenFansActivity.this.dnt = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.dnt.setGravity(19);
                            MyForbiddenFansActivity.this.dnt.setPadding(l.h(MyForbiddenFansActivity.this.getActivity(), e.C0141e.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.dnt.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(MyForbiddenFansActivity.this.getActivity(), e.C0141e.tbds112)));
                            MyForbiddenFansActivity.this.dnt.setTextSize(0, l.h(MyForbiddenFansActivity.this.getActivity(), e.C0141e.fontsize30));
                            MyForbiddenFansActivity.this.dnt.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.cp_cont_i));
                        }
                        MyForbiddenFansActivity.this.dnt.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.dnn.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.dnn.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.dnn.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.dnt, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.dnq.bG(j)) {
                                if (MyForbiddenFansActivity.this.dnq.auA()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.dnq.getItemCount() > 20 || !MyForbiddenFansActivity.this.dnr.hasMore()) {
                                    MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dnq.getFansList());
                                    MyForbiddenFansActivity.this.dnq.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.dnr.auC();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.dnq.bG(j)) {
                    if (MyForbiddenFansActivity.this.dnq.auA()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.dnq.getItemCount() > 20 || !MyForbiddenFansActivity.this.dnr.hasMore()) {
                        MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dnq.getFansList());
                        MyForbiddenFansActivity.this.dnq.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.dnr.auC();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void auz() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(e.j.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.dnr.auB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(ArrayList<a> arrayList) {
        if (!v.z(arrayList)) {
            this.dnp.setNextPage(this.bBr);
            if (this.dnr.hasMore()) {
                this.bBr.setText(getString(e.j.pb_load_more));
                this.bBr.BJ();
                return;
            }
            this.bBr.setText(getString(e.j.no_more_data_tip));
            this.bBr.BJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.h(this.dno, e.d.color_remove_all_title);
        this.dnq.notifyDataSetChanged();
        this.dns.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.bBr.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bBr.dM(i);
        al.h(this.dnt, e.d.cp_cont_i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dnr.onDestroy();
        this.dnn.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.aAJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0141e.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(e.j.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(e.d.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.dnp.setVisibility(8);
        this.dno.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.dnp.setVisibility(0);
        this.dno.setEnabled(true);
    }
}
