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
    private LinearLayout bOF;
    private PbListView dpz;
    private BdRecyclerView ewS;
    private NavigationBarCoverTip frb;
    private TextView frc;
    private b frd;
    private c fre;
    private e frf;
    private TextView frg;
    private c.a frh = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.frd.S(arrayList);
                MyForbiddenFansActivity.this.frd.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener fri = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.kt()) {
                if (view == MyForbiddenFansActivity.this.frc) {
                    TiebaStatic.log(new an("c13104").P("obj_locate", 2));
                    MyForbiddenFansActivity.this.frf.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener frj = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.kt()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new an("c13105"));
                MyForbiddenFansActivity.this.frf.di(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener frk = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.bOF = (LinearLayout) findViewById(R.id.container_forbidden_fans);
        this.fre = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.frc = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.frb = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.ewS = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.ewS.setLayoutManager(new LinearLayoutManager(this));
        this.ewS.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.fre.hasMore() && MyForbiddenFansActivity.this.dpz != null && !MyForbiddenFansActivity.this.dpz.pQ()) {
                    MyForbiddenFansActivity.this.dpz.akR();
                }
                MyForbiddenFansActivity.this.fre.blf();
            }
        });
        this.dpz = new PbListView(getActivity());
        this.dpz.getView();
        this.dpz.iX(R.color.cp_bg_line_e);
        this.dpz.akO();
        this.dpz.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dpz.setTextSize(R.dimen.tbfontsize33);
        this.dpz.iW(R.color.cp_cont_e);
        this.dpz.setHeight(l.g(getActivity(), R.dimen.tbds182));
        this.dpz.akV();
        this.frd = new b(this);
        this.ewS.setAdapter(this.frd);
        this.fre.a(this.frh);
        this.frf = new e(getPageContext(), getUniqueId());
        this.frc.setOnClickListener(this.fri);
        this.frd.l(this.frk);
        this.frd.t(this.frj);
        this.frf.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.frg == null) {
                            MyForbiddenFansActivity.this.frg = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.frg.setGravity(19);
                            MyForbiddenFansActivity.this.frg.setPadding(l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.frg.setLayoutParams(new ViewGroup.LayoutParams(-1, l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.frg.setTextSize(0, l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.frg.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        MyForbiddenFansActivity.this.frg.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.frb.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.frb.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.frb.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.frg, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.frd.dh(j)) {
                                if (MyForbiddenFansActivity.this.frd.bld()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.frd.getItemCount() > 20 || !MyForbiddenFansActivity.this.fre.hasMore()) {
                                    MyForbiddenFansActivity.this.R(MyForbiddenFansActivity.this.frd.getFansList());
                                    MyForbiddenFansActivity.this.frd.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.fre.blf();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.frd.dh(j)) {
                    if (MyForbiddenFansActivity.this.frd.bld()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.frd.getItemCount() > 20 || !MyForbiddenFansActivity.this.fre.hasMore()) {
                        MyForbiddenFansActivity.this.R(MyForbiddenFansActivity.this.frd.getFansList());
                        MyForbiddenFansActivity.this.frd.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.fre.blf();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void blc() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.fre.ble();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(ArrayList<a> arrayList) {
        if (!v.aa(arrayList)) {
            this.ewS.setNextPage(this.dpz);
            if (this.fre.hasMore()) {
                this.dpz.setText(getString(R.string.pb_load_more));
                this.dpz.akS();
                return;
            }
            this.dpz.setText(getString(R.string.no_more_data_tip));
            this.dpz.akS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.j(this.frc, R.color.color_remove_all_title);
        this.frd.notifyDataSetChanged();
        this.frf.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.dpz.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dpz.iY(i);
        am.j(this.frg, R.color.cp_cont_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fre.onDestroy();
        this.frb.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.bOF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.ewS.setVisibility(8);
        this.frc.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.ewS.setVisibility(0);
        this.frc.setEnabled(true);
    }
}
