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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.c;
import com.baidu.tieba.forbidden.fans.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private LinearLayout bOg;
    private PbListView dnN;
    private BdRecyclerView evi;
    private NavigationBarCoverTip fpn;
    private TextView fpo;
    private b fpp;
    private c fpq;
    private e fpr;
    private TextView fpt;
    private c.a fpu = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
        @Override // com.baidu.tieba.forbidden.fans.c.a
        public void a(int i, String str, ArrayList<a> arrayList) {
            if (MyForbiddenFansActivity.this.isProgressBarShown()) {
                MyForbiddenFansActivity.this.hideProgressBar();
            }
            if (i != 0) {
                MyForbiddenFansActivity.this.showToast(str);
            }
            if (v.aa(arrayList)) {
                MyForbiddenFansActivity.this.showNoDataView();
            } else if (i == 0) {
                MyForbiddenFansActivity.this.hideNoDataView();
                MyForbiddenFansActivity.this.R(arrayList);
                MyForbiddenFansActivity.this.fpp.S(arrayList);
                MyForbiddenFansActivity.this.fpp.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener fpv = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.kt()) {
                if (view == MyForbiddenFansActivity.this.fpo) {
                    TiebaStatic.log(new an("c13104").P("obj_locate", 2));
                    MyForbiddenFansActivity.this.fpr.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener fpw = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.kt()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new an("c13105"));
                MyForbiddenFansActivity.this.fpr.df(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener fpx = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        setContentView(R.layout.forbidden_fans_list_layout);
        this.bOg = (LinearLayout) findViewById(R.id.container_forbidden_fans);
        this.fpq = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fpo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.fpn = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.evi = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.evi.setLayoutManager(new LinearLayoutManager(this));
        this.evi.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.fpq.hasMore() && MyForbiddenFansActivity.this.dnN != null && !MyForbiddenFansActivity.this.dnN.pP()) {
                    MyForbiddenFansActivity.this.dnN.akF();
                }
                MyForbiddenFansActivity.this.fpq.bku();
            }
        });
        this.dnN = new PbListView(getActivity());
        this.dnN.getView();
        this.dnN.iU(R.color.cp_bg_line_e);
        this.dnN.akC();
        this.dnN.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnN.setTextSize(R.dimen.tbfontsize33);
        this.dnN.iT(R.color.cp_cont_e);
        this.dnN.setHeight(l.g(getActivity(), R.dimen.tbds182));
        this.dnN.akJ();
        this.fpp = new b(this);
        this.evi.setAdapter(this.fpp);
        this.fpq.a(this.fpu);
        this.fpr = new e(getPageContext(), getUniqueId());
        this.fpo.setOnClickListener(this.fpv);
        this.fpp.l(this.fpx);
        this.fpp.t(this.fpw);
        this.fpr.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.fpt == null) {
                            MyForbiddenFansActivity.this.fpt = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.fpt.setGravity(19);
                            MyForbiddenFansActivity.this.fpt.setPadding(l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.fpt.setLayoutParams(new ViewGroup.LayoutParams(-1, l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.fpt.setTextSize(0, l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.fpt.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_btn_a));
                        }
                        MyForbiddenFansActivity.this.fpt.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.fpn.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.fpn.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.fpn.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.fpt, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.fpp.de(j)) {
                                if (MyForbiddenFansActivity.this.fpp.bks()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.fpp.getItemCount() > 20 || !MyForbiddenFansActivity.this.fpq.hasMore()) {
                                    MyForbiddenFansActivity.this.R(MyForbiddenFansActivity.this.fpp.getFansList());
                                    MyForbiddenFansActivity.this.fpp.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.fpq.bku();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.fpp.de(j)) {
                    if (MyForbiddenFansActivity.this.fpp.bks()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.fpp.getItemCount() > 20 || !MyForbiddenFansActivity.this.fpq.hasMore()) {
                        MyForbiddenFansActivity.this.R(MyForbiddenFansActivity.this.fpp.getFansList());
                        MyForbiddenFansActivity.this.fpp.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.fpq.bku();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bkr() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.fpq.bkt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(ArrayList<a> arrayList) {
        if (!v.aa(arrayList)) {
            this.evi.setNextPage(this.dnN);
            if (this.fpq.hasMore()) {
                this.dnN.setText(getString(R.string.pb_load_more));
                this.dnN.akG();
                return;
            }
            this.dnN.setText(getString(R.string.no_more_data_tip));
            this.dnN.akG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.j(this.fpo, R.color.color_remove_all_title);
        this.fpp.notifyDataSetChanged();
        this.fpr.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.dnN.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dnN.iV(i);
        am.j(this.fpt, R.color.cp_btn_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fpq.onDestroy();
        this.fpn.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.bOg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.evi.setVisibility(8);
        this.fpo.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.evi.setVisibility(0);
        this.fpo.setEnabled(true);
    }
}
