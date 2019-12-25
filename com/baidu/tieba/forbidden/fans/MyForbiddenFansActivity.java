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
/* loaded from: classes7.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private PbListView egU;
    private BdRecyclerView fwJ;
    private NavigationBarCoverTip gdS;
    private TextView gdT;
    private b gdU;
    private c gdV;
    private e gdW;
    private TextView gdX;
    private c.a gdY = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.gdU.ai(arrayList);
                MyForbiddenFansActivity.this.gdU.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener gdZ = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.gdT) {
                    TiebaStatic.log(new an("c13104").Z("obj_locate", 2));
                    MyForbiddenFansActivity.this.gdW.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener gea = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new an("c13105"));
                MyForbiddenFansActivity.this.gdW.dn(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener geb = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.gdV = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gdT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.gdS = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.fwJ = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.fwJ.setLayoutManager(new LinearLayoutManager(this));
        this.fwJ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.gdV.hasMore() && MyForbiddenFansActivity.this.egU != null && !MyForbiddenFansActivity.this.egU.isLoading()) {
                    MyForbiddenFansActivity.this.egU.startLoadData();
                }
                MyForbiddenFansActivity.this.gdV.bzF();
            }
        });
        this.egU = new PbListView(getActivity());
        this.egU.getView();
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.egU.setLineGone();
        this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
        this.egU.setTextSize(R.dimen.tbfontsize33);
        this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
        this.egU.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.egU.aEZ();
        this.gdU = new b(this);
        this.fwJ.setAdapter(this.gdU);
        this.gdV.a(this.gdY);
        this.gdW = new e(getPageContext(), getUniqueId());
        this.gdT.setOnClickListener(this.gdZ);
        this.gdU.o(this.geb);
        this.gdU.w(this.gea);
        this.gdW.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.gdX == null) {
                            MyForbiddenFansActivity.this.gdX = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.gdX.setGravity(19);
                            MyForbiddenFansActivity.this.gdX.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.gdX.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.gdX.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.gdX.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        MyForbiddenFansActivity.this.gdX.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.gdS.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.gdS.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.gdS.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.gdX, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.gdU.dm(j)) {
                                if (MyForbiddenFansActivity.this.gdU.bzD()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.gdU.getItemCount() > 20 || !MyForbiddenFansActivity.this.gdV.hasMore()) {
                                    MyForbiddenFansActivity.this.ah(MyForbiddenFansActivity.this.gdU.getFansList());
                                    MyForbiddenFansActivity.this.gdU.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.gdV.bzF();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.gdU.dm(j)) {
                    if (MyForbiddenFansActivity.this.gdU.bzD()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.gdU.getItemCount() > 20 || !MyForbiddenFansActivity.this.gdV.hasMore()) {
                        MyForbiddenFansActivity.this.ah(MyForbiddenFansActivity.this.gdU.getFansList());
                        MyForbiddenFansActivity.this.gdU.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.gdV.bzF();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bzC() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.gdV.bzE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(ArrayList<a> arrayList) {
        if (!v.isEmpty(arrayList)) {
            this.fwJ.setNextPage(this.egU);
            if (this.gdV.hasMore()) {
                this.egU.setText(getString(R.string.pb_load_more));
                this.egU.endLoadData();
                return;
            }
            this.egU.setText(getString(R.string.no_more_data_tip));
            this.egU.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.gdT, (int) R.color.color_remove_all_title);
        this.gdU.notifyDataSetChanged();
        this.gdW.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.egU.setTextColor(am.getColor(R.color.cp_cont_d));
        this.egU.changeSkin(i);
        am.setViewTextColor(this.gdX, (int) R.color.cp_cont_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gdV.onDestroy();
        this.gdS.onDestroy();
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
        this.fwJ.setVisibility(8);
        this.gdT.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.fwJ.setVisibility(0);
        this.gdT.setEnabled(true);
    }
}
