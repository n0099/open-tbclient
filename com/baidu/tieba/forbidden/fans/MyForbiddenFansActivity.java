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
/* loaded from: classes8.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private PbListView ehe;
    private BdRecyclerView fzU;
    private NavigationBarCoverTip ghc;
    private TextView ghd;
    private b ghe;
    private c ghf;
    private e ghg;
    private TextView ghh;
    private c.a ghi = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.ah(arrayList);
                MyForbiddenFansActivity.this.ghe.ai(arrayList);
                MyForbiddenFansActivity.this.ghe.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener ghj = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.ghd) {
                    TiebaStatic.log(new an("c13104").Z("obj_locate", 2));
                    MyForbiddenFansActivity.this.ghg.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener ghk = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new an("c13105"));
                MyForbiddenFansActivity.this.ghg.ds(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener ghl = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.ghf = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.ghd = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.ghc = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.fzU = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.fzU.setLayoutManager(new LinearLayoutManager(this));
        this.fzU.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.ghf.hasMore() && MyForbiddenFansActivity.this.ehe != null && !MyForbiddenFansActivity.this.ehe.isLoading()) {
                    MyForbiddenFansActivity.this.ehe.startLoadData();
                }
                MyForbiddenFansActivity.this.ghf.bAH();
            }
        });
        this.ehe = new PbListView(getActivity());
        this.ehe.getView();
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ehe.setLineGone();
        this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ehe.setTextSize(R.dimen.tbfontsize33);
        this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ehe.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.ehe.aFs();
        this.ghe = new b(this);
        this.fzU.setAdapter(this.ghe);
        this.ghf.a(this.ghi);
        this.ghg = new e(getPageContext(), getUniqueId());
        this.ghd.setOnClickListener(this.ghj);
        this.ghe.n(this.ghl);
        this.ghe.v(this.ghk);
        this.ghg.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.ghh == null) {
                            MyForbiddenFansActivity.this.ghh = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.ghh.setGravity(19);
                            MyForbiddenFansActivity.this.ghh.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.ghh.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.ghh.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.ghh.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        MyForbiddenFansActivity.this.ghh.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.ghc.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.ghc.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.ghc.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.ghh, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.ghe.dr(j)) {
                                if (MyForbiddenFansActivity.this.ghe.bAF()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.ghe.getItemCount() > 20 || !MyForbiddenFansActivity.this.ghf.hasMore()) {
                                    MyForbiddenFansActivity.this.ah(MyForbiddenFansActivity.this.ghe.getFansList());
                                    MyForbiddenFansActivity.this.ghe.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.ghf.bAH();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.ghe.dr(j)) {
                    if (MyForbiddenFansActivity.this.ghe.bAF()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.ghe.getItemCount() > 20 || !MyForbiddenFansActivity.this.ghf.hasMore()) {
                        MyForbiddenFansActivity.this.ah(MyForbiddenFansActivity.this.ghe.getFansList());
                        MyForbiddenFansActivity.this.ghe.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.ghf.bAH();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bAE() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.ghf.bAG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(ArrayList<a> arrayList) {
        if (!v.isEmpty(arrayList)) {
            this.fzU.setNextPage(this.ehe);
            if (this.ghf.hasMore()) {
                this.ehe.setText(getString(R.string.pb_load_more));
                this.ehe.endLoadData();
                return;
            }
            this.ehe.setText(getString(R.string.no_more_data_tip));
            this.ehe.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.ghd, (int) R.color.color_remove_all_title);
        this.ghe.notifyDataSetChanged();
        this.ghg.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.ehe.setTextColor(am.getColor(R.color.cp_cont_d));
        this.ehe.changeSkin(i);
        am.setViewTextColor(this.ghh, (int) R.color.cp_cont_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ghf.onDestroy();
        this.ghc.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.kQ(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.fzU.setVisibility(8);
        this.ghd.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.fzU.setVisibility(0);
        this.ghd.setEnabled(true);
    }
}
