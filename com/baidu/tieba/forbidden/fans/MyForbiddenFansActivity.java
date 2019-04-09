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
    private LinearLayout bFz;
    private PbListView dbs;
    private NavigationBarCoverTip eTF;
    private TextView eTG;
    private BdRecyclerView eTH;
    private b eTI;
    private c eTJ;
    private e eTK;
    private TextView eTL;
    private c.a eTM = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.eTI.O(arrayList);
                MyForbiddenFansActivity.this.eTI.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener eTN = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.lo()) {
                if (view == MyForbiddenFansActivity.this.eTG) {
                    TiebaStatic.log(new am("c13104").T("obj_locate", 2));
                    MyForbiddenFansActivity.this.eTK.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(d.j.neterror));
        }
    };
    private View.OnClickListener eTO = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.lo()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(d.j.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new am("c13105"));
                MyForbiddenFansActivity.this.eTK.cB(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener eTP = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.bFz = (LinearLayout) findViewById(d.g.container_forbidden_fans);
        this.eTJ = new c();
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eTG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(d.j.remove_all_forbidden_fans));
        this.eTF = (NavigationBarCoverTip) findViewById(d.g.navi_cover_tip_forbidden);
        this.eTH = (BdRecyclerView) findViewById(d.g.listview_forbidden_fans);
        this.eTH.setLayoutManager(new LinearLayoutManager(this));
        this.eTH.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.eTJ.hasMore() && MyForbiddenFansActivity.this.dbs != null && !MyForbiddenFansActivity.this.dbs.qz()) {
                    MyForbiddenFansActivity.this.dbs.aez();
                }
                MyForbiddenFansActivity.this.eTJ.baP();
            }
        });
        this.dbs = new PbListView(getActivity());
        this.dbs.getView();
        this.dbs.ia(d.C0277d.cp_bg_line_e);
        this.dbs.aew();
        this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbs.setTextSize(d.e.tbfontsize33);
        this.dbs.hZ(d.C0277d.cp_cont_e);
        this.dbs.setHeight(l.h(getActivity(), d.e.tbds182));
        this.dbs.aeD();
        this.eTI = new b(this);
        this.eTH.setAdapter(this.eTI);
        this.eTJ.a(this.eTM);
        this.eTK = new e(getPageContext(), getUniqueId());
        this.eTG.setOnClickListener(this.eTN);
        this.eTI.k(this.eTP);
        this.eTI.r(this.eTO);
        this.eTK.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.eTL == null) {
                            MyForbiddenFansActivity.this.eTL = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.eTL.setGravity(19);
                            MyForbiddenFansActivity.this.eTL.setPadding(l.h(MyForbiddenFansActivity.this.getActivity(), d.e.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.eTL.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(MyForbiddenFansActivity.this.getActivity(), d.e.tbds112)));
                            MyForbiddenFansActivity.this.eTL.setTextSize(0, l.h(MyForbiddenFansActivity.this.getActivity(), d.e.fontsize30));
                            MyForbiddenFansActivity.this.eTL.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(d.C0277d.cp_btn_a));
                        }
                        MyForbiddenFansActivity.this.eTL.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.eTF.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(d.C0277d.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.eTF.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(d.C0277d.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.eTF.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.eTL, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.eTI.cA(j)) {
                                if (MyForbiddenFansActivity.this.eTI.baN()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.eTI.getItemCount() > 20 || !MyForbiddenFansActivity.this.eTJ.hasMore()) {
                                    MyForbiddenFansActivity.this.N(MyForbiddenFansActivity.this.eTI.getFansList());
                                    MyForbiddenFansActivity.this.eTI.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.eTJ.baP();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.eTI.cA(j)) {
                    if (MyForbiddenFansActivity.this.eTI.baN()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.eTI.getItemCount() > 20 || !MyForbiddenFansActivity.this.eTJ.hasMore()) {
                        MyForbiddenFansActivity.this.N(MyForbiddenFansActivity.this.eTI.getFansList());
                        MyForbiddenFansActivity.this.eTI.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.eTJ.baP();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void baM() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(d.j.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.eTJ.baO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(ArrayList<a> arrayList) {
        if (!v.T(arrayList)) {
            this.eTH.setNextPage(this.dbs);
            if (this.eTJ.hasMore()) {
                this.dbs.setText(getString(d.j.pb_load_more));
                this.dbs.aeA();
                return;
            }
            this.dbs.setText(getString(d.j.no_more_data_tip));
            this.dbs.aeA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.j(this.eTG, d.C0277d.color_remove_all_title);
        this.eTI.notifyDataSetChanged();
        this.eTK.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_d));
        this.dbs.ib(i);
        al.j(this.eTL, d.C0277d.cp_btn_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eTJ.onDestroy();
        this.eTF.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.bFz, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), d.e.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(d.C0277d.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.eTH.setVisibility(8);
        this.eTG.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.eTH.setVisibility(0);
        this.eTG.setEnabled(true);
    }
}
