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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.c;
import com.baidu.tieba.forbidden.fans.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private PbListView fHm;
    private NavigationBarCoverTip hUB;
    private TextView hUC;
    private b hUD;
    private c hUE;
    private e hUF;
    private TextView hUG;
    private c.a hUH = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
        @Override // com.baidu.tieba.forbidden.fans.c.a
        public void b(int i, String str, ArrayList<a> arrayList) {
            if (MyForbiddenFansActivity.this.isProgressBarShown()) {
                MyForbiddenFansActivity.this.hideProgressBar();
            }
            if (i != 0) {
                MyForbiddenFansActivity.this.showToast(str);
            }
            if (y.isEmpty(arrayList)) {
                MyForbiddenFansActivity.this.showNoDataView();
            } else if (i == 0) {
                MyForbiddenFansActivity.this.hideNoDataView();
                MyForbiddenFansActivity.this.as(arrayList);
                MyForbiddenFansActivity.this.hUD.at(arrayList);
                MyForbiddenFansActivity.this.hUD.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener hUI = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.hUC) {
                    TiebaStatic.log(new aq("c13104").ai("obj_locate", 2));
                    MyForbiddenFansActivity.this.hUF.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener hUJ = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new aq("c13105"));
                MyForbiddenFansActivity.this.hUF.eN(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener hUK = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof a) {
                a aVar = (a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MyForbiddenFansActivity.this.getActivity(), String.valueOf(aVar.id), aVar.name)));
            }
        }
    };
    private BdRecyclerView hjl;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private LinearLayout mRootView;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forbidden_fans_list_layout);
        this.mRootView = (LinearLayout) findViewById(R.id.container_forbidden_fans);
        this.hUE = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.hUC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.hUB = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.hjl = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.hjl.setLayoutManager(new LinearLayoutManager(this));
        this.hjl.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.hUE.hasMore() && MyForbiddenFansActivity.this.fHm != null && !MyForbiddenFansActivity.this.fHm.isLoading()) {
                    MyForbiddenFansActivity.this.fHm.startLoadData();
                }
                MyForbiddenFansActivity.this.hUE.cno();
            }
        });
        this.fHm = new PbListView(getActivity());
        this.fHm.getView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setLineGone();
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fHm.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.fHm.blq();
        this.hUD = new b(this);
        this.hjl.setAdapter(this.hUD);
        this.hUE.a(this.hUH);
        this.hUF = new e(getPageContext(), getUniqueId());
        this.hUC.setOnClickListener(this.hUI);
        this.hUD.n(this.hUK);
        this.hUD.x(this.hUJ);
        this.hUF.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.hUG == null) {
                            MyForbiddenFansActivity.this.hUG = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.hUG.setGravity(19);
                            MyForbiddenFansActivity.this.hUG.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.hUG.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.hUG.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.hUG.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        MyForbiddenFansActivity.this.hUG.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.hUB.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.hUB.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.hUB.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.hUG, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.hUD.eM(j)) {
                                if (MyForbiddenFansActivity.this.hUD.cnm()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.hUD.getItemCount() > 20 || !MyForbiddenFansActivity.this.hUE.hasMore()) {
                                    MyForbiddenFansActivity.this.as(MyForbiddenFansActivity.this.hUD.getFansList());
                                    MyForbiddenFansActivity.this.hUD.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.hUE.cno();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.hUD.eM(j)) {
                    if (MyForbiddenFansActivity.this.hUD.cnm()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.hUD.getItemCount() > 20 || !MyForbiddenFansActivity.this.hUE.hasMore()) {
                        MyForbiddenFansActivity.this.as(MyForbiddenFansActivity.this.hUD.getFansList());
                        MyForbiddenFansActivity.this.hUD.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.hUE.cno();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void cnl() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.hUE.cnn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(ArrayList<a> arrayList) {
        if (!y.isEmpty(arrayList)) {
            this.hjl.setNextPage(this.fHm);
            if (this.hUE.hasMore()) {
                this.fHm.setText(getString(R.string.pb_load_more));
                this.fHm.endLoadData();
                return;
            }
            this.fHm.setText(getString(R.string.no_more_data_tip));
            this.fHm.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.hUC, R.color.color_remove_all_title);
        this.hUD.notifyDataSetChanged();
        this.hUF.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fHm.changeSkin(i);
        ap.setViewTextColor(this.hUG, R.color.cp_cont_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hUE.onDestroy();
        this.hUB.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.oW(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.hjl.setVisibility(8);
        this.hUC.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.hjl.setVisibility(0);
        this.hUC.setEnabled(true);
    }
}
