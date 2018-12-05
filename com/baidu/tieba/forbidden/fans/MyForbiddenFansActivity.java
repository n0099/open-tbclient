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
    private LinearLayout aJG;
    private PbListView bOy;
    private NavigationBarCoverTip dDh;
    private TextView dDi;
    private BdRecyclerView dDj;
    private b dDk;
    private c dDl;
    private e dDm;
    private TextView dDn;
    private c.a dDo = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.dDk.L(arrayList);
                MyForbiddenFansActivity.this.dDk.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener dDp = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.ll()) {
                if (view == MyForbiddenFansActivity.this.dDi) {
                    TiebaStatic.log(new am("c13104").x("obj_locate", 2));
                    MyForbiddenFansActivity.this.dDm.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(e.j.neterror));
        }
    };
    private View.OnClickListener dDq = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.ll()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(e.j.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new am("c13105"));
                MyForbiddenFansActivity.this.dDm.bR(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener dDr = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.aJG = (LinearLayout) findViewById(e.g.container_forbidden_fans);
        this.dDl = new c();
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dDi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(e.j.remove_all_forbidden_fans));
        this.dDh = (NavigationBarCoverTip) findViewById(e.g.navi_cover_tip_forbidden);
        this.dDj = (BdRecyclerView) findViewById(e.g.listview_forbidden_fans);
        this.dDj.setLayoutManager(new LinearLayoutManager(this));
        this.dDj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.dDl.hasMore() && MyForbiddenFansActivity.this.bOy != null && !MyForbiddenFansActivity.this.bOy.Fi()) {
                    MyForbiddenFansActivity.this.bOy.Fc();
                }
                MyForbiddenFansActivity.this.dDl.azg();
            }
        });
        this.bOy = new PbListView(getActivity());
        this.bOy.getView();
        this.bOy.ex(e.d.cp_bg_line_e);
        this.bOy.EZ();
        this.bOy.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bOy.setTextSize(e.C0210e.tbfontsize33);
        this.bOy.ew(e.d.cp_cont_e);
        this.bOy.setHeight(l.h(getActivity(), e.C0210e.tbds182));
        this.bOy.Fg();
        this.dDk = new b(this);
        this.dDj.setAdapter(this.dDk);
        this.dDl.a(this.dDo);
        this.dDm = new e(getPageContext(), getUniqueId());
        this.dDi.setOnClickListener(this.dDp);
        this.dDk.j(this.dDr);
        this.dDk.q(this.dDq);
        this.dDm.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.dDn == null) {
                            MyForbiddenFansActivity.this.dDn = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.dDn.setGravity(19);
                            MyForbiddenFansActivity.this.dDn.setPadding(l.h(MyForbiddenFansActivity.this.getActivity(), e.C0210e.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.dDn.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(MyForbiddenFansActivity.this.getActivity(), e.C0210e.tbds112)));
                            MyForbiddenFansActivity.this.dDn.setTextSize(0, l.h(MyForbiddenFansActivity.this.getActivity(), e.C0210e.fontsize30));
                            MyForbiddenFansActivity.this.dDn.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.cp_cont_i));
                        }
                        MyForbiddenFansActivity.this.dDn.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.dDh.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.dDh.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.dDh.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.dDn, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.dDk.bQ(j)) {
                                if (MyForbiddenFansActivity.this.dDk.aze()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.dDk.getItemCount() > 20 || !MyForbiddenFansActivity.this.dDl.hasMore()) {
                                    MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dDk.getFansList());
                                    MyForbiddenFansActivity.this.dDk.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.dDl.azg();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.dDk.bQ(j)) {
                    if (MyForbiddenFansActivity.this.dDk.aze()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.dDk.getItemCount() > 20 || !MyForbiddenFansActivity.this.dDl.hasMore()) {
                        MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dDk.getFansList());
                        MyForbiddenFansActivity.this.dDk.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.dDl.azg();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void azd() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(e.j.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.dDl.azf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(ArrayList<a> arrayList) {
        if (!v.I(arrayList)) {
            this.dDj.setNextPage(this.bOy);
            if (this.dDl.hasMore()) {
                this.bOy.setText(getString(e.j.pb_load_more));
                this.bOy.Fd();
                return;
            }
            this.bOy.setText(getString(e.j.no_more_data_tip));
            this.bOy.Fd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.h(this.dDi, e.d.color_remove_all_title);
        this.dDk.notifyDataSetChanged();
        this.dDm.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.bOy.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bOy.ey(i);
        al.h(this.dDn, e.d.cp_cont_i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dDl.onDestroy();
        this.dDh.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.aJG, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0210e.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(e.d.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.dDj.setVisibility(8);
        this.dDi.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.dDj.setVisibility(0);
        this.dDi.setEnabled(true);
    }
}
