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
    private LinearLayout aKl;
    private PbListView bPn;
    private NavigationBarCoverTip dGF;
    private TextView dGG;
    private BdRecyclerView dGH;
    private b dGI;
    private c dGJ;
    private e dGK;
    private TextView dGL;
    private c.a dGM = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.dGI.L(arrayList);
                MyForbiddenFansActivity.this.dGI.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener dGN = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.ll()) {
                if (view == MyForbiddenFansActivity.this.dGG) {
                    TiebaStatic.log(new am("c13104").y("obj_locate", 2));
                    MyForbiddenFansActivity.this.dGK.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(e.j.neterror));
        }
    };
    private View.OnClickListener dGO = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.ll()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(e.j.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new am("c13105"));
                MyForbiddenFansActivity.this.dGK.bW(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener dGP = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.aKl = (LinearLayout) findViewById(e.g.container_forbidden_fans);
        this.dGJ = new c();
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dGG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(e.j.remove_all_forbidden_fans));
        this.dGF = (NavigationBarCoverTip) findViewById(e.g.navi_cover_tip_forbidden);
        this.dGH = (BdRecyclerView) findViewById(e.g.listview_forbidden_fans);
        this.dGH.setLayoutManager(new LinearLayoutManager(this));
        this.dGH.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.dGJ.hasMore() && MyForbiddenFansActivity.this.bPn != null && !MyForbiddenFansActivity.this.bPn.Fv()) {
                    MyForbiddenFansActivity.this.bPn.Fp();
                }
                MyForbiddenFansActivity.this.dGJ.aAs();
            }
        });
        this.bPn = new PbListView(getActivity());
        this.bPn.getView();
        this.bPn.ex(e.d.cp_bg_line_e);
        this.bPn.Fm();
        this.bPn.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bPn.setTextSize(e.C0210e.tbfontsize33);
        this.bPn.ew(e.d.cp_cont_e);
        this.bPn.setHeight(l.h(getActivity(), e.C0210e.tbds182));
        this.bPn.Ft();
        this.dGI = new b(this);
        this.dGH.setAdapter(this.dGI);
        this.dGJ.a(this.dGM);
        this.dGK = new e(getPageContext(), getUniqueId());
        this.dGG.setOnClickListener(this.dGN);
        this.dGI.j(this.dGP);
        this.dGI.q(this.dGO);
        this.dGK.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.dGL == null) {
                            MyForbiddenFansActivity.this.dGL = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.dGL.setGravity(19);
                            MyForbiddenFansActivity.this.dGL.setPadding(l.h(MyForbiddenFansActivity.this.getActivity(), e.C0210e.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.dGL.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(MyForbiddenFansActivity.this.getActivity(), e.C0210e.tbds112)));
                            MyForbiddenFansActivity.this.dGL.setTextSize(0, l.h(MyForbiddenFansActivity.this.getActivity(), e.C0210e.fontsize30));
                            MyForbiddenFansActivity.this.dGL.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.cp_cont_i));
                        }
                        MyForbiddenFansActivity.this.dGL.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.dGF.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.dGF.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.dGF.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.dGL, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.dGI.bV(j)) {
                                if (MyForbiddenFansActivity.this.dGI.aAq()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.dGI.getItemCount() > 20 || !MyForbiddenFansActivity.this.dGJ.hasMore()) {
                                    MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dGI.getFansList());
                                    MyForbiddenFansActivity.this.dGI.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.dGJ.aAs();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.dGI.bV(j)) {
                    if (MyForbiddenFansActivity.this.dGI.aAq()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.dGI.getItemCount() > 20 || !MyForbiddenFansActivity.this.dGJ.hasMore()) {
                        MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dGI.getFansList());
                        MyForbiddenFansActivity.this.dGI.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.dGJ.aAs();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void aAp() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(e.j.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.dGJ.aAr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(ArrayList<a> arrayList) {
        if (!v.I(arrayList)) {
            this.dGH.setNextPage(this.bPn);
            if (this.dGJ.hasMore()) {
                this.bPn.setText(getString(e.j.pb_load_more));
                this.bPn.Fq();
                return;
            }
            this.bPn.setText(getString(e.j.no_more_data_tip));
            this.bPn.Fq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.h(this.dGG, e.d.color_remove_all_title);
        this.dGI.notifyDataSetChanged();
        this.dGK.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.bPn.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bPn.ey(i);
        al.h(this.dGL, e.d.cp_cont_i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dGJ.onDestroy();
        this.dGF.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.aKl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0210e.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(e.d.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.dGH.setVisibility(8);
        this.dGG.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.dGH.setVisibility(0);
        this.dGG.setEnabled(true);
    }
}
