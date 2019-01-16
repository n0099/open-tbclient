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
    private LinearLayout aKk;
    private PbListView bPm;
    private NavigationBarCoverTip dGE;
    private TextView dGF;
    private BdRecyclerView dGG;
    private b dGH;
    private c dGI;
    private e dGJ;
    private TextView dGK;
    private c.a dGL = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.dGH.L(arrayList);
                MyForbiddenFansActivity.this.dGH.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener dGM = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.ll()) {
                if (view == MyForbiddenFansActivity.this.dGF) {
                    TiebaStatic.log(new am("c13104").y("obj_locate", 2));
                    MyForbiddenFansActivity.this.dGJ.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(e.j.neterror));
        }
    };
    private View.OnClickListener dGN = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.ll()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(e.j.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new am("c13105"));
                MyForbiddenFansActivity.this.dGJ.bW(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener dGO = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.aKk = (LinearLayout) findViewById(e.g.container_forbidden_fans);
        this.dGI = new c();
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dGF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(e.j.remove_all_forbidden_fans));
        this.dGE = (NavigationBarCoverTip) findViewById(e.g.navi_cover_tip_forbidden);
        this.dGG = (BdRecyclerView) findViewById(e.g.listview_forbidden_fans);
        this.dGG.setLayoutManager(new LinearLayoutManager(this));
        this.dGG.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.dGI.hasMore() && MyForbiddenFansActivity.this.bPm != null && !MyForbiddenFansActivity.this.bPm.Fv()) {
                    MyForbiddenFansActivity.this.bPm.Fp();
                }
                MyForbiddenFansActivity.this.dGI.aAs();
            }
        });
        this.bPm = new PbListView(getActivity());
        this.bPm.getView();
        this.bPm.ex(e.d.cp_bg_line_e);
        this.bPm.Fm();
        this.bPm.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bPm.setTextSize(e.C0210e.tbfontsize33);
        this.bPm.ew(e.d.cp_cont_e);
        this.bPm.setHeight(l.h(getActivity(), e.C0210e.tbds182));
        this.bPm.Ft();
        this.dGH = new b(this);
        this.dGG.setAdapter(this.dGH);
        this.dGI.a(this.dGL);
        this.dGJ = new e(getPageContext(), getUniqueId());
        this.dGF.setOnClickListener(this.dGM);
        this.dGH.j(this.dGO);
        this.dGH.q(this.dGN);
        this.dGJ.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.dGK == null) {
                            MyForbiddenFansActivity.this.dGK = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.dGK.setGravity(19);
                            MyForbiddenFansActivity.this.dGK.setPadding(l.h(MyForbiddenFansActivity.this.getActivity(), e.C0210e.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.dGK.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(MyForbiddenFansActivity.this.getActivity(), e.C0210e.tbds112)));
                            MyForbiddenFansActivity.this.dGK.setTextSize(0, l.h(MyForbiddenFansActivity.this.getActivity(), e.C0210e.fontsize30));
                            MyForbiddenFansActivity.this.dGK.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.cp_cont_i));
                        }
                        MyForbiddenFansActivity.this.dGK.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.dGE.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.dGE.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.dGE.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.dGK, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.dGH.bV(j)) {
                                if (MyForbiddenFansActivity.this.dGH.aAq()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.dGH.getItemCount() > 20 || !MyForbiddenFansActivity.this.dGI.hasMore()) {
                                    MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dGH.getFansList());
                                    MyForbiddenFansActivity.this.dGH.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.dGI.aAs();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.dGH.bV(j)) {
                    if (MyForbiddenFansActivity.this.dGH.aAq()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.dGH.getItemCount() > 20 || !MyForbiddenFansActivity.this.dGI.hasMore()) {
                        MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dGH.getFansList());
                        MyForbiddenFansActivity.this.dGH.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.dGI.aAs();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void aAp() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(e.j.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.dGI.aAr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(ArrayList<a> arrayList) {
        if (!v.I(arrayList)) {
            this.dGG.setNextPage(this.bPm);
            if (this.dGI.hasMore()) {
                this.bPm.setText(getString(e.j.pb_load_more));
                this.bPm.Fq();
                return;
            }
            this.bPm.setText(getString(e.j.no_more_data_tip));
            this.bPm.Fq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.h(this.dGF, e.d.color_remove_all_title);
        this.dGH.notifyDataSetChanged();
        this.dGJ.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.bPm.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bPm.ey(i);
        al.h(this.dGK, e.d.cp_cont_i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dGI.onDestroy();
        this.dGE.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.aKk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0210e.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(e.d.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.dGG.setVisibility(8);
        this.dGF.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.dGG.setVisibility(0);
        this.dGF.setEnabled(true);
    }
}
