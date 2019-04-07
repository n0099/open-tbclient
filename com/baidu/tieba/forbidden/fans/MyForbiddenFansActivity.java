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
    private LinearLayout bFy;
    private PbListView dbr;
    private NavigationBarCoverTip eTE;
    private TextView eTF;
    private BdRecyclerView eTG;
    private b eTH;
    private c eTI;
    private e eTJ;
    private TextView eTK;
    private c.a eTL = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.eTH.O(arrayList);
                MyForbiddenFansActivity.this.eTH.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener eTM = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.lo()) {
                if (view == MyForbiddenFansActivity.this.eTF) {
                    TiebaStatic.log(new am("c13104").T("obj_locate", 2));
                    MyForbiddenFansActivity.this.eTJ.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(d.j.neterror));
        }
    };
    private View.OnClickListener eTN = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.lo()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(d.j.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new am("c13105"));
                MyForbiddenFansActivity.this.eTJ.cB(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener eTO = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.bFy = (LinearLayout) findViewById(d.g.container_forbidden_fans);
        this.eTI = new c();
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eTF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(d.j.remove_all_forbidden_fans));
        this.eTE = (NavigationBarCoverTip) findViewById(d.g.navi_cover_tip_forbidden);
        this.eTG = (BdRecyclerView) findViewById(d.g.listview_forbidden_fans);
        this.eTG.setLayoutManager(new LinearLayoutManager(this));
        this.eTG.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.eTI.hasMore() && MyForbiddenFansActivity.this.dbr != null && !MyForbiddenFansActivity.this.dbr.qz()) {
                    MyForbiddenFansActivity.this.dbr.aez();
                }
                MyForbiddenFansActivity.this.eTI.baP();
            }
        });
        this.dbr = new PbListView(getActivity());
        this.dbr.getView();
        this.dbr.ia(d.C0277d.cp_bg_line_e);
        this.dbr.aew();
        this.dbr.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbr.setTextSize(d.e.tbfontsize33);
        this.dbr.hZ(d.C0277d.cp_cont_e);
        this.dbr.setHeight(l.h(getActivity(), d.e.tbds182));
        this.dbr.aeD();
        this.eTH = new b(this);
        this.eTG.setAdapter(this.eTH);
        this.eTI.a(this.eTL);
        this.eTJ = new e(getPageContext(), getUniqueId());
        this.eTF.setOnClickListener(this.eTM);
        this.eTH.k(this.eTO);
        this.eTH.r(this.eTN);
        this.eTJ.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.eTK == null) {
                            MyForbiddenFansActivity.this.eTK = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.eTK.setGravity(19);
                            MyForbiddenFansActivity.this.eTK.setPadding(l.h(MyForbiddenFansActivity.this.getActivity(), d.e.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.eTK.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(MyForbiddenFansActivity.this.getActivity(), d.e.tbds112)));
                            MyForbiddenFansActivity.this.eTK.setTextSize(0, l.h(MyForbiddenFansActivity.this.getActivity(), d.e.fontsize30));
                            MyForbiddenFansActivity.this.eTK.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(d.C0277d.cp_btn_a));
                        }
                        MyForbiddenFansActivity.this.eTK.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.eTE.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(d.C0277d.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.eTE.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(d.C0277d.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.eTE.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.eTK, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.eTH.cA(j)) {
                                if (MyForbiddenFansActivity.this.eTH.baN()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.eTH.getItemCount() > 20 || !MyForbiddenFansActivity.this.eTI.hasMore()) {
                                    MyForbiddenFansActivity.this.N(MyForbiddenFansActivity.this.eTH.getFansList());
                                    MyForbiddenFansActivity.this.eTH.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.eTI.baP();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.eTH.cA(j)) {
                    if (MyForbiddenFansActivity.this.eTH.baN()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.eTH.getItemCount() > 20 || !MyForbiddenFansActivity.this.eTI.hasMore()) {
                        MyForbiddenFansActivity.this.N(MyForbiddenFansActivity.this.eTH.getFansList());
                        MyForbiddenFansActivity.this.eTH.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.eTI.baP();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void baM() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(d.j.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.eTI.baO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(ArrayList<a> arrayList) {
        if (!v.T(arrayList)) {
            this.eTG.setNextPage(this.dbr);
            if (this.eTI.hasMore()) {
                this.dbr.setText(getString(d.j.pb_load_more));
                this.dbr.aeA();
                return;
            }
            this.dbr.setText(getString(d.j.no_more_data_tip));
            this.dbr.aeA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.j(this.eTF, d.C0277d.color_remove_all_title);
        this.eTH.notifyDataSetChanged();
        this.eTJ.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.dbr.setTextColor(al.getColor(d.C0277d.cp_cont_d));
        this.dbr.ib(i);
        al.j(this.eTK, d.C0277d.cp_btn_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eTI.onDestroy();
        this.eTE.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.bFy, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), d.e.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(d.C0277d.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.eTG.setVisibility(8);
        this.eTF.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.eTG.setVisibility(0);
        this.eTF.setEnabled(true);
    }
}
