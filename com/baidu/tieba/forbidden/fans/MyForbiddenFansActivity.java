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
    private LinearLayout aFq;
    private PbListView bJY;
    private NavigationBarCoverTip dvq;
    private TextView dvr;
    private BdRecyclerView dvs;
    private b dvt;
    private c dvu;
    private e dvv;
    private TextView dvw;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private c.a dvx = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
        @Override // com.baidu.tieba.forbidden.fans.c.a
        public void a(int i, String str, ArrayList<a> arrayList) {
            if (MyForbiddenFansActivity.this.isProgressBarShown()) {
                MyForbiddenFansActivity.this.hideProgressBar();
            }
            if (i != 0) {
                MyForbiddenFansActivity.this.showToast(str);
            }
            if (v.J(arrayList)) {
                MyForbiddenFansActivity.this.showNoDataView();
            } else if (i == 0) {
                MyForbiddenFansActivity.this.hideNoDataView();
                MyForbiddenFansActivity.this.K(arrayList);
                MyForbiddenFansActivity.this.dvt.L(arrayList);
                MyForbiddenFansActivity.this.dvt.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener dvy = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.lo()) {
                if (view == MyForbiddenFansActivity.this.dvr) {
                    TiebaStatic.log(new am("c13104").x("obj_locate", 2));
                    MyForbiddenFansActivity.this.dvv.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(e.j.neterror));
        }
    };
    private View.OnClickListener dvz = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.lo()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(e.j.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new am("c13105"));
                MyForbiddenFansActivity.this.dvv.bO(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener dvA = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof a) {
                a aVar = (a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MyForbiddenFansActivity.this.getActivity(), String.valueOf(aVar.id), aVar.name)));
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.forbidden_fans_list_layout);
        this.aFq = (LinearLayout) findViewById(e.g.container_forbidden_fans);
        this.dvu = new c();
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dvr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(e.j.remove_all_forbidden_fans));
        this.dvq = (NavigationBarCoverTip) findViewById(e.g.navi_cover_tip_forbidden);
        this.dvs = (BdRecyclerView) findViewById(e.g.listview_forbidden_fans);
        this.dvs.setLayoutManager(new LinearLayoutManager(this));
        this.dvs.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.dvu.hasMore() && MyForbiddenFansActivity.this.bJY != null && !MyForbiddenFansActivity.this.bJY.DU()) {
                    MyForbiddenFansActivity.this.bJY.DO();
                }
                MyForbiddenFansActivity.this.dvu.axZ();
            }
        });
        this.bJY = new PbListView(getActivity());
        this.bJY.getView();
        this.bJY.dV(e.d.cp_bg_line_e);
        this.bJY.DL();
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bJY.setTextSize(e.C0175e.tbfontsize33);
        this.bJY.dU(e.d.cp_cont_e);
        this.bJY.setHeight(l.h(getActivity(), e.C0175e.tbds182));
        this.bJY.DS();
        this.dvt = new b(this);
        this.dvs.setAdapter(this.dvt);
        this.dvu.a(this.dvx);
        this.dvv = new e(getPageContext(), getUniqueId());
        this.dvr.setOnClickListener(this.dvy);
        this.dvt.i(this.dvA);
        this.dvt.o(this.dvz);
        this.dvv.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.dvw == null) {
                            MyForbiddenFansActivity.this.dvw = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.dvw.setGravity(19);
                            MyForbiddenFansActivity.this.dvw.setPadding(l.h(MyForbiddenFansActivity.this.getActivity(), e.C0175e.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.dvw.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(MyForbiddenFansActivity.this.getActivity(), e.C0175e.tbds112)));
                            MyForbiddenFansActivity.this.dvw.setTextSize(0, l.h(MyForbiddenFansActivity.this.getActivity(), e.C0175e.fontsize30));
                            MyForbiddenFansActivity.this.dvw.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.cp_cont_i));
                        }
                        MyForbiddenFansActivity.this.dvw.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.dvq.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.dvq.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.dvq.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.dvw, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.dvt.bN(j)) {
                                if (MyForbiddenFansActivity.this.dvt.axX()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.dvt.getItemCount() > 20 || !MyForbiddenFansActivity.this.dvu.hasMore()) {
                                    MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dvt.getFansList());
                                    MyForbiddenFansActivity.this.dvt.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.dvu.axZ();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.dvt.bN(j)) {
                    if (MyForbiddenFansActivity.this.dvt.axX()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.dvt.getItemCount() > 20 || !MyForbiddenFansActivity.this.dvu.hasMore()) {
                        MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dvt.getFansList());
                        MyForbiddenFansActivity.this.dvt.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.dvu.axZ();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void axW() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(e.j.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.dvu.axY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(ArrayList<a> arrayList) {
        if (!v.J(arrayList)) {
            this.dvs.setNextPage(this.bJY);
            if (this.dvu.hasMore()) {
                this.bJY.setText(getString(e.j.pb_load_more));
                this.bJY.DP();
                return;
            }
            this.bJY.setText(getString(e.j.no_more_data_tip));
            this.bJY.DP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.h(this.dvr, e.d.color_remove_all_title);
        this.dvt.notifyDataSetChanged();
        this.dvv.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bJY.dW(i);
        al.h(this.dvw, e.d.cp_cont_i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dvu.onDestroy();
        this.dvq.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.aFq, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0175e.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(e.j.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(e.d.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.dvs.setVisibility(8);
        this.dvr.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.dvs.setVisibility(0);
        this.dvr.setEnabled(true);
    }
}
