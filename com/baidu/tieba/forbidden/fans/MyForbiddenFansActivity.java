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
    private LinearLayout aGg;
    private PbListView bKJ;
    private NavigationBarCoverTip dwI;
    private TextView dwJ;
    private BdRecyclerView dwK;
    private b dwL;
    private c dwM;
    private e dwN;
    private TextView dwO;
    private c.a dwP = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.dwL.L(arrayList);
                MyForbiddenFansActivity.this.dwL.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener dwQ = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.lm()) {
                if (view == MyForbiddenFansActivity.this.dwJ) {
                    TiebaStatic.log(new am("c13104").x("obj_locate", 2));
                    MyForbiddenFansActivity.this.dwN.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(e.j.neterror));
        }
    };
    private View.OnClickListener dwR = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.lm()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(e.j.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new am("c13105"));
                MyForbiddenFansActivity.this.dwN.bK(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener dwS = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.aGg = (LinearLayout) findViewById(e.g.container_forbidden_fans);
        this.dwM = new c();
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dwJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(e.j.remove_all_forbidden_fans));
        this.dwI = (NavigationBarCoverTip) findViewById(e.g.navi_cover_tip_forbidden);
        this.dwK = (BdRecyclerView) findViewById(e.g.listview_forbidden_fans);
        this.dwK.setLayoutManager(new LinearLayoutManager(this));
        this.dwK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.dwM.hasMore() && MyForbiddenFansActivity.this.bKJ != null && !MyForbiddenFansActivity.this.bKJ.Ee()) {
                    MyForbiddenFansActivity.this.bKJ.DY();
                }
                MyForbiddenFansActivity.this.dwM.axw();
            }
        });
        this.bKJ = new PbListView(getActivity());
        this.bKJ.getView();
        this.bKJ.ej(e.d.cp_bg_line_e);
        this.bKJ.DV();
        this.bKJ.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bKJ.setTextSize(e.C0200e.tbfontsize33);
        this.bKJ.ei(e.d.cp_cont_e);
        this.bKJ.setHeight(l.h(getActivity(), e.C0200e.tbds182));
        this.bKJ.Ec();
        this.dwL = new b(this);
        this.dwK.setAdapter(this.dwL);
        this.dwM.a(this.dwP);
        this.dwN = new e(getPageContext(), getUniqueId());
        this.dwJ.setOnClickListener(this.dwQ);
        this.dwL.j(this.dwS);
        this.dwL.q(this.dwR);
        this.dwN.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.dwO == null) {
                            MyForbiddenFansActivity.this.dwO = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.dwO.setGravity(19);
                            MyForbiddenFansActivity.this.dwO.setPadding(l.h(MyForbiddenFansActivity.this.getActivity(), e.C0200e.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.dwO.setLayoutParams(new ViewGroup.LayoutParams(-1, l.h(MyForbiddenFansActivity.this.getActivity(), e.C0200e.tbds112)));
                            MyForbiddenFansActivity.this.dwO.setTextSize(0, l.h(MyForbiddenFansActivity.this.getActivity(), e.C0200e.fontsize30));
                            MyForbiddenFansActivity.this.dwO.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.cp_cont_i));
                        }
                        MyForbiddenFansActivity.this.dwO.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.dwI.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.dwI.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(e.d.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.dwI.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.dwO, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.dwL.bJ(j)) {
                                if (MyForbiddenFansActivity.this.dwL.axu()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.dwL.getItemCount() > 20 || !MyForbiddenFansActivity.this.dwM.hasMore()) {
                                    MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dwL.getFansList());
                                    MyForbiddenFansActivity.this.dwL.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.dwM.axw();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.dwL.bJ(j)) {
                    if (MyForbiddenFansActivity.this.dwL.axu()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.dwL.getItemCount() > 20 || !MyForbiddenFansActivity.this.dwM.hasMore()) {
                        MyForbiddenFansActivity.this.K(MyForbiddenFansActivity.this.dwL.getFansList());
                        MyForbiddenFansActivity.this.dwL.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.dwM.axw();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void axt() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(e.j.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.dwM.axv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(ArrayList<a> arrayList) {
        if (!v.I(arrayList)) {
            this.dwK.setNextPage(this.bKJ);
            if (this.dwM.hasMore()) {
                this.bKJ.setText(getString(e.j.pb_load_more));
                this.bKJ.DZ();
                return;
            }
            this.bKJ.setText(getString(e.j.no_more_data_tip));
            this.bKJ.DZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.h(this.dwJ, e.d.color_remove_all_title);
        this.dwL.notifyDataSetChanged();
        this.dwN.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.bKJ.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bKJ.ek(i);
        al.h(this.dwO, e.d.cp_cont_i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dwM.onDestroy();
        this.dwI.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.aGg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), e.C0200e.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(e.j.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(e.d.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.dwK.setVisibility(8);
        this.dwJ.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.dwK.setVisibility(0);
        this.dwJ.setEnabled(true);
    }
}
