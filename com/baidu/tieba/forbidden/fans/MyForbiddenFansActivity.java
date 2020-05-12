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
    private PbListView ePr;
    private NavigationBarCoverTip gTn;
    private TextView gTo;
    private b gTp;
    private c gTq;
    private e gTr;
    private TextView gTs;
    private c.a gTt = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.gTp.ak(arrayList);
                MyForbiddenFansActivity.this.gTp.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener gTu = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.gTo) {
                    TiebaStatic.log(new an("c13104").af("obj_locate", 2));
                    MyForbiddenFansActivity.this.gTr.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener gTv = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new an("c13105"));
                MyForbiddenFansActivity.this.gTr.eb(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener gTw = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof a) {
                a aVar = (a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MyForbiddenFansActivity.this.getActivity(), String.valueOf(aVar.id), aVar.name)));
            }
        }
    };
    private BdRecyclerView ghW;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private LinearLayout mRootView;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forbidden_fans_list_layout);
        this.mRootView = (LinearLayout) findViewById(R.id.container_forbidden_fans);
        this.gTq = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gTo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.gTn = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.ghW = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.ghW.setLayoutManager(new LinearLayoutManager(this));
        this.ghW.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.gTq.hasMore() && MyForbiddenFansActivity.this.ePr != null && !MyForbiddenFansActivity.this.ePr.isLoading()) {
                    MyForbiddenFansActivity.this.ePr.startLoadData();
                }
                MyForbiddenFansActivity.this.gTq.bMR();
            }
        });
        this.ePr = new PbListView(getActivity());
        this.ePr.getView();
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePr.setLineGone();
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePr.setTextSize(R.dimen.tbfontsize33);
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePr.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.ePr.aQa();
        this.gTp = new b(this);
        this.ghW.setAdapter(this.gTp);
        this.gTq.a(this.gTt);
        this.gTr = new e(getPageContext(), getUniqueId());
        this.gTo.setOnClickListener(this.gTu);
        this.gTp.n(this.gTw);
        this.gTp.x(this.gTv);
        this.gTr.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.gTs == null) {
                            MyForbiddenFansActivity.this.gTs = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.gTs.setGravity(19);
                            MyForbiddenFansActivity.this.gTs.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.gTs.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.gTs.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.gTs.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        MyForbiddenFansActivity.this.gTs.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.gTn.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.gTn.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.gTn.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.gTs, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.gTp.ea(j)) {
                                if (MyForbiddenFansActivity.this.gTp.bMP()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.gTp.getItemCount() > 20 || !MyForbiddenFansActivity.this.gTq.hasMore()) {
                                    MyForbiddenFansActivity.this.aj(MyForbiddenFansActivity.this.gTp.getFansList());
                                    MyForbiddenFansActivity.this.gTp.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.gTq.bMR();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.gTp.ea(j)) {
                    if (MyForbiddenFansActivity.this.gTp.bMP()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.gTp.getItemCount() > 20 || !MyForbiddenFansActivity.this.gTq.hasMore()) {
                        MyForbiddenFansActivity.this.aj(MyForbiddenFansActivity.this.gTp.getFansList());
                        MyForbiddenFansActivity.this.gTp.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.gTq.bMR();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bMO() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.gTq.bMQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(ArrayList<a> arrayList) {
        if (!v.isEmpty(arrayList)) {
            this.ghW.setNextPage(this.ePr);
            if (this.gTq.hasMore()) {
                this.ePr.setText(getString(R.string.pb_load_more));
                this.ePr.endLoadData();
                return;
            }
            this.ePr.setText(getString(R.string.no_more_data_tip));
            this.ePr.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.gTo, (int) R.color.color_remove_all_title);
        this.gTp.notifyDataSetChanged();
        this.gTr.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_d));
        this.ePr.changeSkin(i);
        am.setViewTextColor(this.gTs, (int) R.color.cp_cont_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gTq.onDestroy();
        this.gTn.onDestroy();
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
        this.ghW.setVisibility(8);
        this.gTo.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.ghW.setVisibility(0);
        this.gTo.setEnabled(true);
    }
}
