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
/* loaded from: classes23.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private PbListView gdy;
    private BdRecyclerView hKC;
    private NavigationBarCoverTip ivY;
    private TextView ivZ;
    private b iwa;
    private c iwb;
    private e iwc;
    private TextView iwd;
    private c.a iwe = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.at(arrayList);
                MyForbiddenFansActivity.this.iwa.au(arrayList);
                MyForbiddenFansActivity.this.iwa.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener iwf = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.ivZ) {
                    TiebaStatic.log(new aq("c13104").aj("obj_locate", 2));
                    MyForbiddenFansActivity.this.iwc.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener iwg = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new aq("c13105"));
                MyForbiddenFansActivity.this.iwc.ff(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener iwh = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.iwb = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.ivZ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.ivY = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.hKC = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.hKC.setLayoutManager(new LinearLayoutManager(this));
        this.hKC.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.iwb.hasMore() && MyForbiddenFansActivity.this.gdy != null && !MyForbiddenFansActivity.this.gdy.isLoading()) {
                    MyForbiddenFansActivity.this.gdy.startLoadData();
                }
                MyForbiddenFansActivity.this.iwb.ctT();
            }
        });
        this.gdy = new PbListView(getActivity());
        this.gdy.getView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setLineGone();
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gdy.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.gdy.bpT();
        this.iwa = new b(this);
        this.hKC.setAdapter(this.iwa);
        this.iwb.a(this.iwe);
        this.iwc = new e(getPageContext(), getUniqueId());
        this.ivZ.setOnClickListener(this.iwf);
        this.iwa.n(this.iwh);
        this.iwa.x(this.iwg);
        this.iwc.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.iwd == null) {
                            MyForbiddenFansActivity.this.iwd = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.iwd.setGravity(19);
                            MyForbiddenFansActivity.this.iwd.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.iwd.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.iwd.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.iwd.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        MyForbiddenFansActivity.this.iwd.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.ivY.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.ivY.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.ivY.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.iwd, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.iwa.fe(j)) {
                                if (MyForbiddenFansActivity.this.iwa.ctR()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.iwa.getItemCount() > 20 || !MyForbiddenFansActivity.this.iwb.hasMore()) {
                                    MyForbiddenFansActivity.this.at(MyForbiddenFansActivity.this.iwa.getFansList());
                                    MyForbiddenFansActivity.this.iwa.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.iwb.ctT();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.iwa.fe(j)) {
                    if (MyForbiddenFansActivity.this.iwa.ctR()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.iwa.getItemCount() > 20 || !MyForbiddenFansActivity.this.iwb.hasMore()) {
                        MyForbiddenFansActivity.this.at(MyForbiddenFansActivity.this.iwa.getFansList());
                        MyForbiddenFansActivity.this.iwa.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.iwb.ctT();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void ctQ() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.iwb.ctS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(ArrayList<a> arrayList) {
        if (!y.isEmpty(arrayList)) {
            this.hKC.setNextPage(this.gdy);
            if (this.iwb.hasMore()) {
                this.gdy.setText(getString(R.string.pb_load_more));
                this.gdy.endLoadData();
                return;
            }
            this.gdy.setText(getString(R.string.no_more_data_tip));
            this.gdy.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.ivZ, R.color.color_remove_all_title);
        this.iwa.notifyDataSetChanged();
        this.iwc.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.gdy.changeSkin(i);
        ap.setViewTextColor(this.iwd, R.color.cp_cont_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iwb.onDestroy();
        this.ivY.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pG(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.hKC.setVisibility(8);
        this.ivZ.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.hKC.setVisibility(0);
        this.ivZ.setEnabled(true);
    }
}
