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
/* loaded from: classes17.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private PbListView fDW;
    private c.a hNA = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.aq(arrayList);
                MyForbiddenFansActivity.this.hNw.ar(arrayList);
                MyForbiddenFansActivity.this.hNw.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener hNB = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.hNv) {
                    TiebaStatic.log(new aq("c13104").ai("obj_locate", 2));
                    MyForbiddenFansActivity.this.hNy.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener hNC = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new aq("c13105"));
                MyForbiddenFansActivity.this.hNy.eD(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener hND = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof a) {
                a aVar = (a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MyForbiddenFansActivity.this.getActivity(), String.valueOf(aVar.id), aVar.name)));
            }
        }
    };
    private NavigationBarCoverTip hNu;
    private TextView hNv;
    private b hNw;
    private c hNx;
    private e hNy;
    private TextView hNz;
    private BdRecyclerView hci;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private LinearLayout mRootView;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forbidden_fans_list_layout);
        this.mRootView = (LinearLayout) findViewById(R.id.container_forbidden_fans);
        this.hNx = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.hNv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.hNu = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.hci = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.hci.setLayoutManager(new LinearLayoutManager(this));
        this.hci.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.hNx.hasMore() && MyForbiddenFansActivity.this.fDW != null && !MyForbiddenFansActivity.this.fDW.isLoading()) {
                    MyForbiddenFansActivity.this.fDW.startLoadData();
                }
                MyForbiddenFansActivity.this.hNx.cka();
            }
        });
        this.fDW = new PbListView(getActivity());
        this.fDW.getView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setLineGone();
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fDW.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.fDW.bkv();
        this.hNw = new b(this);
        this.hci.setAdapter(this.hNw);
        this.hNx.a(this.hNA);
        this.hNy = new e(getPageContext(), getUniqueId());
        this.hNv.setOnClickListener(this.hNB);
        this.hNw.n(this.hND);
        this.hNw.x(this.hNC);
        this.hNy.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.hNz == null) {
                            MyForbiddenFansActivity.this.hNz = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.hNz.setGravity(19);
                            MyForbiddenFansActivity.this.hNz.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.hNz.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.hNz.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.hNz.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        MyForbiddenFansActivity.this.hNz.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.hNu.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.hNu.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.hNu.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.hNz, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.hNw.eC(j)) {
                                if (MyForbiddenFansActivity.this.hNw.cjY()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.hNw.getItemCount() > 20 || !MyForbiddenFansActivity.this.hNx.hasMore()) {
                                    MyForbiddenFansActivity.this.aq(MyForbiddenFansActivity.this.hNw.getFansList());
                                    MyForbiddenFansActivity.this.hNw.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.hNx.cka();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.hNw.eC(j)) {
                    if (MyForbiddenFansActivity.this.hNw.cjY()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.hNw.getItemCount() > 20 || !MyForbiddenFansActivity.this.hNx.hasMore()) {
                        MyForbiddenFansActivity.this.aq(MyForbiddenFansActivity.this.hNw.getFansList());
                        MyForbiddenFansActivity.this.hNw.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.hNx.cka();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void cjX() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.hNx.cjZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(ArrayList<a> arrayList) {
        if (!y.isEmpty(arrayList)) {
            this.hci.setNextPage(this.fDW);
            if (this.hNx.hasMore()) {
                this.fDW.setText(getString(R.string.pb_load_more));
                this.fDW.endLoadData();
                return;
            }
            this.fDW.setText(getString(R.string.no_more_data_tip));
            this.fDW.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.hNv, R.color.color_remove_all_title);
        this.hNw.notifyDataSetChanged();
        this.hNy.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fDW.changeSkin(i);
        ap.setViewTextColor(this.hNz, R.color.cp_cont_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hNx.onDestroy();
        this.hNu.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.oK(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.hci.setVisibility(8);
        this.hNv.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.hci.setVisibility(0);
        this.hNv.setEnabled(true);
    }
}
