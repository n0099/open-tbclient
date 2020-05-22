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
    private PbListView fbY;
    private BdRecyclerView gwN;
    private NavigationBarCoverTip hhY;
    private TextView hhZ;
    private b hia;
    private c hib;
    private e hic;
    private TextView hie;
    private c.a hif = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.hia.ak(arrayList);
                MyForbiddenFansActivity.this.hia.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener hig = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.hhZ) {
                    TiebaStatic.log(new an("c13104").ag("obj_locate", 2));
                    MyForbiddenFansActivity.this.hic.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener hih = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new an("c13105"));
                MyForbiddenFansActivity.this.hic.ec(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener hii = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.hib = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.hhZ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.hhY = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.gwN = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.gwN.setLayoutManager(new LinearLayoutManager(this));
        this.gwN.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.hib.hasMore() && MyForbiddenFansActivity.this.fbY != null && !MyForbiddenFansActivity.this.fbY.isLoading()) {
                    MyForbiddenFansActivity.this.fbY.startLoadData();
                }
                MyForbiddenFansActivity.this.hib.bTm();
            }
        });
        this.fbY = new PbListView(getActivity());
        this.fbY.getView();
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fbY.setLineGone();
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fbY.setTextSize(R.dimen.tbfontsize33);
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fbY.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.fbY.aWe();
        this.hia = new b(this);
        this.gwN.setAdapter(this.hia);
        this.hib.a(this.hif);
        this.hic = new e(getPageContext(), getUniqueId());
        this.hhZ.setOnClickListener(this.hig);
        this.hia.m(this.hii);
        this.hia.w(this.hih);
        this.hic.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.hie == null) {
                            MyForbiddenFansActivity.this.hie = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.hie.setGravity(19);
                            MyForbiddenFansActivity.this.hie.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.hie.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.hie.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.hie.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        MyForbiddenFansActivity.this.hie.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.hhY.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.hhY.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.hhY.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.hie, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.hia.eb(j)) {
                                if (MyForbiddenFansActivity.this.hia.bTk()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.hia.getItemCount() > 20 || !MyForbiddenFansActivity.this.hib.hasMore()) {
                                    MyForbiddenFansActivity.this.aj(MyForbiddenFansActivity.this.hia.getFansList());
                                    MyForbiddenFansActivity.this.hia.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.hib.bTm();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.hia.eb(j)) {
                    if (MyForbiddenFansActivity.this.hia.bTk()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.hia.getItemCount() > 20 || !MyForbiddenFansActivity.this.hib.hasMore()) {
                        MyForbiddenFansActivity.this.aj(MyForbiddenFansActivity.this.hia.getFansList());
                        MyForbiddenFansActivity.this.hia.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.hib.bTm();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bTj() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.hib.bTl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(ArrayList<a> arrayList) {
        if (!v.isEmpty(arrayList)) {
            this.gwN.setNextPage(this.fbY);
            if (this.hib.hasMore()) {
                this.fbY.setText(getString(R.string.pb_load_more));
                this.fbY.endLoadData();
                return;
            }
            this.fbY.setText(getString(R.string.no_more_data_tip));
            this.fbY.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.hhZ, (int) R.color.color_remove_all_title);
        this.hia.notifyDataSetChanged();
        this.hic.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_d));
        this.fbY.changeSkin(i);
        am.setViewTextColor(this.hie, (int) R.color.cp_cont_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hib.onDestroy();
        this.hhY.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.lT(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.gwN.setVisibility(8);
        this.hhZ.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.gwN.setVisibility(0);
        this.hhZ.setEnabled(true);
    }
}
