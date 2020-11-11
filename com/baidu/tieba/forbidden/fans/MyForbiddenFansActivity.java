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
    private PbListView gjo;
    private BdRecyclerView hQz;
    private NavigationBarCoverTip iBV;
    private TextView iBW;
    private b iBX;
    private c iBY;
    private e iBZ;
    private TextView iCa;
    private c.a iCb = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.iBX.au(arrayList);
                MyForbiddenFansActivity.this.iBX.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener iCc = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.iBW) {
                    TiebaStatic.log(new aq("c13104").al("obj_locate", 2));
                    MyForbiddenFansActivity.this.iBZ.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener iCd = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new aq("c13105"));
                MyForbiddenFansActivity.this.iBZ.fB(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener iCe = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.iBY = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.iBW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.iBV = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.hQz = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.hQz.setLayoutManager(new LinearLayoutManager(this));
        this.hQz.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.iBY.hasMore() && MyForbiddenFansActivity.this.gjo != null && !MyForbiddenFansActivity.this.gjo.isLoading()) {
                    MyForbiddenFansActivity.this.gjo.startLoadData();
                }
                MyForbiddenFansActivity.this.iBY.cwu();
            }
        });
        this.gjo = new PbListView(getActivity());
        this.gjo.getView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setLineGone();
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gjo.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.gjo.bst();
        this.iBX = new b(this);
        this.hQz.setAdapter(this.iBX);
        this.iBY.a(this.iCb);
        this.iBZ = new e(getPageContext(), getUniqueId());
        this.iBW.setOnClickListener(this.iCc);
        this.iBX.o(this.iCe);
        this.iBX.y(this.iCd);
        this.iBZ.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.iCa == null) {
                            MyForbiddenFansActivity.this.iCa = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.iCa.setGravity(19);
                            MyForbiddenFansActivity.this.iCa.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.iCa.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.iCa.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.iCa.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        MyForbiddenFansActivity.this.iCa.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.iBV.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.iBV.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.iBV.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.iCa, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.iBX.fA(j)) {
                                if (MyForbiddenFansActivity.this.iBX.cws()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.iBX.getItemCount() > 20 || !MyForbiddenFansActivity.this.iBY.hasMore()) {
                                    MyForbiddenFansActivity.this.at(MyForbiddenFansActivity.this.iBX.getFansList());
                                    MyForbiddenFansActivity.this.iBX.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.iBY.cwu();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.iBX.fA(j)) {
                    if (MyForbiddenFansActivity.this.iBX.cws()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.iBX.getItemCount() > 20 || !MyForbiddenFansActivity.this.iBY.hasMore()) {
                        MyForbiddenFansActivity.this.at(MyForbiddenFansActivity.this.iBX.getFansList());
                        MyForbiddenFansActivity.this.iBX.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.iBY.cwu();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void cwr() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.iBY.cwt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(ArrayList<a> arrayList) {
        if (!y.isEmpty(arrayList)) {
            this.hQz.setNextPage(this.gjo);
            if (this.iBY.hasMore()) {
                this.gjo.setText(getString(R.string.pb_load_more));
                this.gjo.endLoadData();
                return;
            }
            this.gjo.setText(getString(R.string.no_more_data_tip));
            this.gjo.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.iBW, R.color.color_remove_all_title);
        this.iBX.notifyDataSetChanged();
        this.iBZ.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.gjo.changeSkin(i);
        ap.setViewTextColor(this.iCa, R.color.cp_cont_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iBY.onDestroy();
        this.iBV.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pQ(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.hQz.setVisibility(8);
        this.iBW.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.hQz.setVisibility(0);
        this.iBW.setEnabled(true);
    }
}
