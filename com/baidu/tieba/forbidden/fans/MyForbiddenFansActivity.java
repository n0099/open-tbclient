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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private PbListView dwJ;
    private BdRecyclerView eFC;
    private NavigationBarCoverTip fqn;
    private TextView fqo;
    private b fqp;
    private c fqq;
    private e fqr;
    private TextView fqs;
    private c.a fqt = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
        @Override // com.baidu.tieba.forbidden.fans.c.a
        public void a(int i, String str, ArrayList<a> arrayList) {
            if (MyForbiddenFansActivity.this.isProgressBarShown()) {
                MyForbiddenFansActivity.this.hideProgressBar();
            }
            if (i != 0) {
                MyForbiddenFansActivity.this.showToast(str);
            }
            if (v.isEmpty(arrayList)) {
                MyForbiddenFansActivity.this.showNoDataView();
            } else if (i == 0) {
                MyForbiddenFansActivity.this.hideNoDataView();
                MyForbiddenFansActivity.this.W(arrayList);
                MyForbiddenFansActivity.this.fqp.X(arrayList);
                MyForbiddenFansActivity.this.fqp.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener fqu = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.fqo) {
                    TiebaStatic.log(new an("c13104").O("obj_locate", 2));
                    MyForbiddenFansActivity.this.fqr.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener fqv = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new an("c13105"));
                MyForbiddenFansActivity.this.fqr.cI(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener fqw = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof a) {
                a aVar = (a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MyForbiddenFansActivity.this.getActivity(), String.valueOf(aVar.id), aVar.name)));
            }
        }
    };
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private LinearLayout mRootView;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forbidden_fans_list_layout);
        this.mRootView = (LinearLayout) findViewById(R.id.container_forbidden_fans);
        this.fqq = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fqo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.fqn = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.eFC = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.eFC.setLayoutManager(new LinearLayoutManager(this));
        this.eFC.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.fqq.hasMore() && MyForbiddenFansActivity.this.dwJ != null && !MyForbiddenFansActivity.this.dwJ.isLoading()) {
                    MyForbiddenFansActivity.this.dwJ.startLoadData();
                }
                MyForbiddenFansActivity.this.fqq.bim();
            }
        });
        this.dwJ = new PbListView(getActivity());
        this.dwJ.getView();
        this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dwJ.setLineGone();
        this.dwJ.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dwJ.setTextSize(R.dimen.tbfontsize33);
        this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dwJ.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.dwJ.anL();
        this.fqp = new b(this);
        this.eFC.setAdapter(this.fqp);
        this.fqq.a(this.fqt);
        this.fqr = new e(getPageContext(), getUniqueId());
        this.fqo.setOnClickListener(this.fqu);
        this.fqp.n(this.fqw);
        this.fqp.u(this.fqv);
        this.fqr.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.fqs == null) {
                            MyForbiddenFansActivity.this.fqs = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.fqs.setGravity(19);
                            MyForbiddenFansActivity.this.fqs.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.fqs.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.fqs.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.fqs.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        MyForbiddenFansActivity.this.fqs.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.fqn.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.fqn.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.fqn.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.fqs, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.fqp.cH(j)) {
                                if (MyForbiddenFansActivity.this.fqp.bik()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.fqp.getItemCount() > 20 || !MyForbiddenFansActivity.this.fqq.hasMore()) {
                                    MyForbiddenFansActivity.this.W(MyForbiddenFansActivity.this.fqp.getFansList());
                                    MyForbiddenFansActivity.this.fqp.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.fqq.bim();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.fqp.cH(j)) {
                    if (MyForbiddenFansActivity.this.fqp.bik()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.fqp.getItemCount() > 20 || !MyForbiddenFansActivity.this.fqq.hasMore()) {
                        MyForbiddenFansActivity.this.W(MyForbiddenFansActivity.this.fqp.getFansList());
                        MyForbiddenFansActivity.this.fqp.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.fqq.bim();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bij() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.fqq.bil();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(ArrayList<a> arrayList) {
        if (!v.isEmpty(arrayList)) {
            this.eFC.setNextPage(this.dwJ);
            if (this.fqq.hasMore()) {
                this.dwJ.setText(getString(R.string.pb_load_more));
                this.dwJ.endLoadData();
                return;
            }
            this.dwJ.setText(getString(R.string.no_more_data_tip));
            this.dwJ.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.fqo, (int) R.color.color_remove_all_title);
        this.fqp.notifyDataSetChanged();
        this.fqr.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.dwJ.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dwJ.changeSkin(i);
        am.setViewTextColor(this.fqs, (int) R.color.cp_cont_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fqq.onDestroy();
        this.fqn.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iL(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.eFC.setVisibility(8);
        this.fqo.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.eFC.setVisibility(0);
        this.fqo.setEnabled(true);
    }
}
