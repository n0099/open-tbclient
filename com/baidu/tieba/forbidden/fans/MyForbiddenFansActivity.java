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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.c;
import com.baidu.tieba.forbidden.fans.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
/* loaded from: classes17.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private PbListView fsC;
    private BdRecyclerView gPs;
    private NavigationBarCoverTip hAf;
    private TextView hAg;
    private b hAh;
    private c hAi;
    private e hAj;
    private TextView hAk;
    private c.a hAl = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
        @Override // com.baidu.tieba.forbidden.fans.c.a
        public void b(int i, String str, ArrayList<a> arrayList) {
            if (MyForbiddenFansActivity.this.isProgressBarShown()) {
                MyForbiddenFansActivity.this.hideProgressBar();
            }
            if (i != 0) {
                MyForbiddenFansActivity.this.showToast(str);
            }
            if (x.isEmpty(arrayList)) {
                MyForbiddenFansActivity.this.showNoDataView();
            } else if (i == 0) {
                MyForbiddenFansActivity.this.hideNoDataView();
                MyForbiddenFansActivity.this.ak(arrayList);
                MyForbiddenFansActivity.this.hAh.al(arrayList);
                MyForbiddenFansActivity.this.hAh.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener hAm = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.hAg) {
                    TiebaStatic.log(new ap("c13104").ah("obj_locate", 2));
                    MyForbiddenFansActivity.this.hAj.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener hAn = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new ap("c13105"));
                MyForbiddenFansActivity.this.hAj.es(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener hAo = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.hAi = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.hAg = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.hAf = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.gPs = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.gPs.setLayoutManager(new LinearLayoutManager(this));
        this.gPs.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.hAi.hasMore() && MyForbiddenFansActivity.this.fsC != null && !MyForbiddenFansActivity.this.fsC.isLoading()) {
                    MyForbiddenFansActivity.this.fsC.startLoadData();
                }
                MyForbiddenFansActivity.this.hAi.bZE();
            }
        });
        this.fsC = new PbListView(getActivity());
        this.fsC.getView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setLineGone();
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fsC.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.fsC.bbZ();
        this.hAh = new b(this);
        this.gPs.setAdapter(this.hAh);
        this.hAi.a(this.hAl);
        this.hAj = new e(getPageContext(), getUniqueId());
        this.hAg.setOnClickListener(this.hAm);
        this.hAh.n(this.hAo);
        this.hAh.x(this.hAn);
        this.hAj.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.hAk == null) {
                            MyForbiddenFansActivity.this.hAk = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.hAk.setGravity(19);
                            MyForbiddenFansActivity.this.hAk.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.hAk.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.hAk.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.hAk.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        MyForbiddenFansActivity.this.hAk.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.hAf.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.hAf.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.hAf.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.hAk, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.hAh.er(j)) {
                                if (MyForbiddenFansActivity.this.hAh.bZC()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.hAh.getItemCount() > 20 || !MyForbiddenFansActivity.this.hAi.hasMore()) {
                                    MyForbiddenFansActivity.this.ak(MyForbiddenFansActivity.this.hAh.getFansList());
                                    MyForbiddenFansActivity.this.hAh.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.hAi.bZE();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.hAh.er(j)) {
                    if (MyForbiddenFansActivity.this.hAh.bZC()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.hAh.getItemCount() > 20 || !MyForbiddenFansActivity.this.hAi.hasMore()) {
                        MyForbiddenFansActivity.this.ak(MyForbiddenFansActivity.this.hAh.getFansList());
                        MyForbiddenFansActivity.this.hAh.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.hAi.bZE();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bZB() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.hAi.bZD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(ArrayList<a> arrayList) {
        if (!x.isEmpty(arrayList)) {
            this.gPs.setNextPage(this.fsC);
            if (this.hAi.hasMore()) {
                this.fsC.setText(getString(R.string.pb_load_more));
                this.fsC.endLoadData();
                return;
            }
            this.fsC.setText(getString(R.string.no_more_data_tip));
            this.fsC.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.hAg, R.color.color_remove_all_title);
        this.hAh.notifyDataSetChanged();
        this.hAj.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
        this.fsC.changeSkin(i);
        ao.setViewTextColor(this.hAk, R.color.cp_cont_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hAi.onDestroy();
        this.hAf.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.mF(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.gPs.setVisibility(8);
        this.hAg.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.gPs.setVisibility(0);
        this.hAg.setEnabled(true);
    }
}
