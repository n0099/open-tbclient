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
    private LinearLayout bOb;
    private PbListView dnG;
    private BdRecyclerView evb;
    private NavigationBarCoverTip foO;
    private TextView foP;
    private b foQ;
    private c foR;
    private e foS;
    private TextView foT;
    private c.a foU = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.foQ.S(arrayList);
                MyForbiddenFansActivity.this.foQ.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener foV = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.kt()) {
                if (view == MyForbiddenFansActivity.this.foP) {
                    TiebaStatic.log(new an("c13104").P("obj_locate", 2));
                    MyForbiddenFansActivity.this.foS.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener foW = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.kt()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new an("c13105"));
                MyForbiddenFansActivity.this.foS.df(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener foX = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.bOb = (LinearLayout) findViewById(R.id.container_forbidden_fans);
        this.foR = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.foP = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.foO = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.evb = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.evb.setLayoutManager(new LinearLayoutManager(this));
        this.evb.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.foR.hasMore() && MyForbiddenFansActivity.this.dnG != null && !MyForbiddenFansActivity.this.dnG.pP()) {
                    MyForbiddenFansActivity.this.dnG.akD();
                }
                MyForbiddenFansActivity.this.foR.bkn();
            }
        });
        this.dnG = new PbListView(getActivity());
        this.dnG.getView();
        this.dnG.iU(R.color.cp_bg_line_e);
        this.dnG.akA();
        this.dnG.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnG.setTextSize(R.dimen.tbfontsize33);
        this.dnG.iT(R.color.cp_cont_e);
        this.dnG.setHeight(l.g(getActivity(), R.dimen.tbds182));
        this.dnG.akH();
        this.foQ = new b(this);
        this.evb.setAdapter(this.foQ);
        this.foR.a(this.foU);
        this.foS = new e(getPageContext(), getUniqueId());
        this.foP.setOnClickListener(this.foV);
        this.foQ.l(this.foX);
        this.foQ.t(this.foW);
        this.foS.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.foT == null) {
                            MyForbiddenFansActivity.this.foT = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.foT.setGravity(19);
                            MyForbiddenFansActivity.this.foT.setPadding(l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.foT.setLayoutParams(new ViewGroup.LayoutParams(-1, l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.foT.setTextSize(0, l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.foT.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_btn_a));
                        }
                        MyForbiddenFansActivity.this.foT.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.foO.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.foO.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.foO.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.foT, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.foQ.de(j)) {
                                if (MyForbiddenFansActivity.this.foQ.bkl()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.foQ.getItemCount() > 20 || !MyForbiddenFansActivity.this.foR.hasMore()) {
                                    MyForbiddenFansActivity.this.R(MyForbiddenFansActivity.this.foQ.getFansList());
                                    MyForbiddenFansActivity.this.foQ.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.foR.bkn();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.foQ.de(j)) {
                    if (MyForbiddenFansActivity.this.foQ.bkl()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.foQ.getItemCount() > 20 || !MyForbiddenFansActivity.this.foR.hasMore()) {
                        MyForbiddenFansActivity.this.R(MyForbiddenFansActivity.this.foQ.getFansList());
                        MyForbiddenFansActivity.this.foQ.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.foR.bkn();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bkk() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.foR.bkm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(ArrayList<a> arrayList) {
        if (!v.aa(arrayList)) {
            this.evb.setNextPage(this.dnG);
            if (this.foR.hasMore()) {
                this.dnG.setText(getString(R.string.pb_load_more));
                this.dnG.akE();
                return;
            }
            this.dnG.setText(getString(R.string.no_more_data_tip));
            this.dnG.akE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.j(this.foP, R.color.color_remove_all_title);
        this.foQ.notifyDataSetChanged();
        this.foS.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.dnG.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dnG.iV(i);
        am.j(this.foT, R.color.cp_btn_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.foR.onDestroy();
        this.foO.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.bOb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.evb.setVisibility(8);
        this.foP.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.evb.setVisibility(0);
        this.foP.setEnabled(true);
    }
}
