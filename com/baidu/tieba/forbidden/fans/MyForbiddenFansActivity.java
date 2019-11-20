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
    private PbListView dvS;
    private BdRecyclerView eEL;
    private e fpA;
    private TextView fpB;
    private c.a fpC = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.fpy.X(arrayList);
                MyForbiddenFansActivity.this.fpy.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener fpD = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.fpx) {
                    TiebaStatic.log(new an("c13104").O("obj_locate", 2));
                    MyForbiddenFansActivity.this.fpA.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener fpE = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new an("c13105"));
                MyForbiddenFansActivity.this.fpA.cH(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener fpF = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof a) {
                a aVar = (a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MyForbiddenFansActivity.this.getActivity(), String.valueOf(aVar.id), aVar.name)));
            }
        }
    };
    private NavigationBarCoverTip fpw;
    private TextView fpx;
    private b fpy;
    private c fpz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private LinearLayout mRootView;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forbidden_fans_list_layout);
        this.mRootView = (LinearLayout) findViewById(R.id.container_forbidden_fans);
        this.fpz = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fpx = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.fpw = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.eEL = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.eEL.setLayoutManager(new LinearLayoutManager(this));
        this.eEL.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.fpz.hasMore() && MyForbiddenFansActivity.this.dvS != null && !MyForbiddenFansActivity.this.dvS.isLoading()) {
                    MyForbiddenFansActivity.this.dvS.startLoadData();
                }
                MyForbiddenFansActivity.this.fpz.bik();
            }
        });
        this.dvS = new PbListView(getActivity());
        this.dvS.getView();
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dvS.setLineGone();
        this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dvS.setTextSize(R.dimen.tbfontsize33);
        this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dvS.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.dvS.anJ();
        this.fpy = new b(this);
        this.eEL.setAdapter(this.fpy);
        this.fpz.a(this.fpC);
        this.fpA = new e(getPageContext(), getUniqueId());
        this.fpx.setOnClickListener(this.fpD);
        this.fpy.n(this.fpF);
        this.fpy.u(this.fpE);
        this.fpA.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.fpB == null) {
                            MyForbiddenFansActivity.this.fpB = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.fpB.setGravity(19);
                            MyForbiddenFansActivity.this.fpB.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.fpB.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.fpB.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.fpB.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        MyForbiddenFansActivity.this.fpB.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.fpw.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.fpw.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.fpw.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.fpB, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.fpy.cG(j)) {
                                if (MyForbiddenFansActivity.this.fpy.bii()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.fpy.getItemCount() > 20 || !MyForbiddenFansActivity.this.fpz.hasMore()) {
                                    MyForbiddenFansActivity.this.W(MyForbiddenFansActivity.this.fpy.getFansList());
                                    MyForbiddenFansActivity.this.fpy.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.fpz.bik();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.fpy.cG(j)) {
                    if (MyForbiddenFansActivity.this.fpy.bii()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.fpy.getItemCount() > 20 || !MyForbiddenFansActivity.this.fpz.hasMore()) {
                        MyForbiddenFansActivity.this.W(MyForbiddenFansActivity.this.fpy.getFansList());
                        MyForbiddenFansActivity.this.fpy.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.fpz.bik();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bih() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.fpz.bij();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(ArrayList<a> arrayList) {
        if (!v.isEmpty(arrayList)) {
            this.eEL.setNextPage(this.dvS);
            if (this.fpz.hasMore()) {
                this.dvS.setText(getString(R.string.pb_load_more));
                this.dvS.endLoadData();
                return;
            }
            this.dvS.setText(getString(R.string.no_more_data_tip));
            this.dvS.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.fpx, (int) R.color.color_remove_all_title);
        this.fpy.notifyDataSetChanged();
        this.fpA.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.dvS.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dvS.changeSkin(i);
        am.setViewTextColor(this.fpB, (int) R.color.cp_cont_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fpz.onDestroy();
        this.fpw.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.eEL.setVisibility(8);
        this.fpx.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.eEL.setVisibility(0);
        this.fpx.setEnabled(true);
    }
}
