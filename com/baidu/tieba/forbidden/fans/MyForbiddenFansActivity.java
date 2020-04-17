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
/* loaded from: classes10.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private PbListView ePm;
    private NavigationBarCoverTip gTh;
    private TextView gTi;
    private b gTj;
    private c gTk;
    private e gTl;
    private TextView gTm;
    private c.a gTn = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
        @Override // com.baidu.tieba.forbidden.fans.c.a
        public void b(int i, String str, ArrayList<a> arrayList) {
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
                MyForbiddenFansActivity.this.aj(arrayList);
                MyForbiddenFansActivity.this.gTj.ak(arrayList);
                MyForbiddenFansActivity.this.gTj.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener gTo = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.gTi) {
                    TiebaStatic.log(new an("c13104").af("obj_locate", 2));
                    MyForbiddenFansActivity.this.gTl.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener gTp = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new an("c13105"));
                MyForbiddenFansActivity.this.gTl.eb(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener gTq = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof a) {
                a aVar = (a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MyForbiddenFansActivity.this.getActivity(), String.valueOf(aVar.id), aVar.name)));
            }
        }
    };
    private BdRecyclerView ghQ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private LinearLayout mRootView;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forbidden_fans_list_layout);
        this.mRootView = (LinearLayout) findViewById(R.id.container_forbidden_fans);
        this.gTk = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gTi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.gTh = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.ghQ = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.ghQ.setLayoutManager(new LinearLayoutManager(this));
        this.ghQ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.gTk.hasMore() && MyForbiddenFansActivity.this.ePm != null && !MyForbiddenFansActivity.this.ePm.isLoading()) {
                    MyForbiddenFansActivity.this.ePm.startLoadData();
                }
                MyForbiddenFansActivity.this.gTk.bMS();
            }
        });
        this.ePm = new PbListView(getActivity());
        this.ePm.getView();
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePm.setLineGone();
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePm.setTextSize(R.dimen.tbfontsize33);
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePm.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.ePm.aQd();
        this.gTj = new b(this);
        this.ghQ.setAdapter(this.gTj);
        this.gTk.a(this.gTn);
        this.gTl = new e(getPageContext(), getUniqueId());
        this.gTi.setOnClickListener(this.gTo);
        this.gTj.n(this.gTq);
        this.gTj.x(this.gTp);
        this.gTl.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.gTm == null) {
                            MyForbiddenFansActivity.this.gTm = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.gTm.setGravity(19);
                            MyForbiddenFansActivity.this.gTm.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.gTm.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.gTm.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.gTm.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        MyForbiddenFansActivity.this.gTm.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.gTh.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.gTh.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.gTh.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.gTm, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.gTj.ea(j)) {
                                if (MyForbiddenFansActivity.this.gTj.bMQ()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.gTj.getItemCount() > 20 || !MyForbiddenFansActivity.this.gTk.hasMore()) {
                                    MyForbiddenFansActivity.this.aj(MyForbiddenFansActivity.this.gTj.getFansList());
                                    MyForbiddenFansActivity.this.gTj.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.gTk.bMS();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.gTj.ea(j)) {
                    if (MyForbiddenFansActivity.this.gTj.bMQ()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.gTj.getItemCount() > 20 || !MyForbiddenFansActivity.this.gTk.hasMore()) {
                        MyForbiddenFansActivity.this.aj(MyForbiddenFansActivity.this.gTj.getFansList());
                        MyForbiddenFansActivity.this.gTj.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.gTk.bMS();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bMP() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.gTk.bMR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(ArrayList<a> arrayList) {
        if (!v.isEmpty(arrayList)) {
            this.ghQ.setNextPage(this.ePm);
            if (this.gTk.hasMore()) {
                this.ePm.setText(getString(R.string.pb_load_more));
                this.ePm.endLoadData();
                return;
            }
            this.ePm.setText(getString(R.string.no_more_data_tip));
            this.ePm.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.gTi, (int) R.color.color_remove_all_title);
        this.gTj.notifyDataSetChanged();
        this.gTl.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_d));
        this.ePm.changeSkin(i);
        am.setViewTextColor(this.gTm, (int) R.color.cp_cont_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gTk.onDestroy();
        this.gTh.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.lr(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.ghQ.setVisibility(8);
        this.gTi.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.ghQ.setVisibility(0);
        this.gTi.setEnabled(true);
    }
}
