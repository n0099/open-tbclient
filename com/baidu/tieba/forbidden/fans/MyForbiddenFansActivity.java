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
    private LinearLayout aJI;
    private PbListView bOB;
    private NavigationBarCoverTip dFV;
    private TextView dFW;
    private BdRecyclerView dFX;
    private b dFY;
    private c dFZ;
    private e dGa;
    private TextView dGb;
    private c.a dGc = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
        @Override // com.baidu.tieba.forbidden.fans.c.a
        public void a(int i, String str, ArrayList<a> arrayList) {
            if (MyForbiddenFansActivity.this.isProgressBarShown()) {
                MyForbiddenFansActivity.this.hideProgressBar();
            }
            if (i != 0) {
                MyForbiddenFansActivity.this.showToast(str);
            }
            if (v.I(arrayList)) {
                MyForbiddenFansActivity.this.showNoDataView();
            } else if (i == 0) {
                MyForbiddenFansActivity.this.hideNoDataView();
                MyForbiddenFansActivity.this.K(arrayList);
                MyForbiddenFansActivity.this.dFY.L(arrayList);
                MyForbiddenFansActivity.this.dFY.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener dGd = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.ll()) {
                if (view == MyForbiddenFansActivity.this.dFW) {
                    TiebaStatic.log(new am("c13104").x("obj_locate", 2));
                    MyForbiddenFansActivity.this.dGa.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(e.j.neterror));
        }
    };
    private View.OnClickListener dGe = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.ll()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(e.j.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new am("c13105"));
                MyForbiddenFansActivity.this.dGa.bW(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener dGf = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.aJI = (LinearLayout) findViewById(e.g.container_forbidden_fans);
        this.dFZ = new c();
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dFW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(e.j.remove_all_forbidden_fans));
        this.dFV = (NavigationBarCoverTip) findViewById(e.g.navi_cover_tip_forbidden);
        this.dFX = (BdRecyclerView) findViewById(e.g.listview_forbidden_fans);
        this.dFX.setLayoutManager(new LinearLayoutManager(this));
        this.dFX.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.dFZ.hasMore() && MyForbiddenFansActivity.this.bOB != null && !MyForbiddenFansActivity.this.bOB.Fi()) {
                    MyForbiddenFansActivity.this.bOB.Fc();
                }
                MyForbiddenFansActivity.this.dFZ.azV();
            }
        });
        this.bOB = new PbListView(getActivity());
        this.bOB.getView();
        this.bOB.ex(e.d.cp_bg_line_e);
        this.bOB.EZ();
        this.bOB.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bOB.setTextSize(e.C0210e.tbfontsize33);
        this.bOB.ew(e.d.cp_cont_e);
        this.bOB.setHeight(l.h(getActivity(), e.C0210e.tbds182));
        this.bOB.Fg();
        this.dFY = new b(this);
        this.dFX.setAdapter(this.dFY);
        this.dFZ.a(this.dGc);
        this.dGa = new e(getPageContext(), getUniqueId());
        this.dFW.setOnClickListener(this.dGd);
        this.dFY.j(this.dGf);
        this.dFY.q(this.dGe);
        this.dGa.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.dGb == null) {
                            MyForbiddenFansActivity.this.dGb = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.dGb.setGravity(19);
                            MyForbiddenFansActivity.this.dGb.setPadding(l.h(MyForbiddenFansActivity.this.getActivity(), e.C0210e.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.dGb.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(MyForbiddenFansActivity.this.getActivity(), e.C0210e.tbds112)));
                            MyForbiddenFansActivity.this.dGb.setTextSize(0, l.h(MyForbiddenFansActivity.this.getActivity(), e.C0210e.fontsize30));
                            MyForbiddenFansActivity.this.dGb.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.cp_cont_i));
                        }
                        MyForbiddenFansActivity.this.dGb.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.dFV.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.dFV.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.dFV.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.dGb, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.dFY.bV(j)) {
                                if (MyForbiddenFansActivity.this.dFY.azT()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.dFY.getItemCount() > 20 || !MyForbiddenFansActivity.this.dFZ.hasMore()) {
                                    MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dFY.getFansList());
                                    MyForbiddenFansActivity.this.dFY.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.dFZ.azV();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.dFY.bV(j)) {
                    if (MyForbiddenFansActivity.this.dFY.azT()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.dFY.getItemCount() > 20 || !MyForbiddenFansActivity.this.dFZ.hasMore()) {
                        MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dFY.getFansList());
                        MyForbiddenFansActivity.this.dFY.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.dFZ.azV();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void azS() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(e.j.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.dFZ.azU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(ArrayList<a> arrayList) {
        if (!v.I(arrayList)) {
            this.dFX.setNextPage(this.bOB);
            if (this.dFZ.hasMore()) {
                this.bOB.setText(getString(e.j.pb_load_more));
                this.bOB.Fd();
                return;
            }
            this.bOB.setText(getString(e.j.no_more_data_tip));
            this.bOB.Fd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.h(this.dFW, e.d.color_remove_all_title);
        this.dFY.notifyDataSetChanged();
        this.dGa.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.bOB.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bOB.ey(i);
        al.h(this.dGb, e.d.cp_cont_i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dFZ.onDestroy();
        this.dFV.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.aJI, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0210e.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(e.d.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.dFX.setVisibility(8);
        this.dFW.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.dFX.setVisibility(0);
        this.dFW.setEnabled(true);
    }
}
