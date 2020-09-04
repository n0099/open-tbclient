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
    private PbListView fEa;
    private NavigationBarCoverTip hNA;
    private TextView hNB;
    private b hNC;
    private c hND;
    private e hNE;
    private TextView hNF;
    private c.a hNG = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.hNC.ar(arrayList);
                MyForbiddenFansActivity.this.hNC.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener hNH = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.hNB) {
                    TiebaStatic.log(new aq("c13104").ai("obj_locate", 2));
                    MyForbiddenFansActivity.this.hNE.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener hNI = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new aq("c13105"));
                MyForbiddenFansActivity.this.hNE.eD(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener hNJ = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof a) {
                a aVar = (a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MyForbiddenFansActivity.this.getActivity(), String.valueOf(aVar.id), aVar.name)));
            }
        }
    };
    private BdRecyclerView hcm;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private LinearLayout mRootView;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forbidden_fans_list_layout);
        this.mRootView = (LinearLayout) findViewById(R.id.container_forbidden_fans);
        this.hND = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.hNB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.hNA = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.hcm = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.hcm.setLayoutManager(new LinearLayoutManager(this));
        this.hcm.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.hND.hasMore() && MyForbiddenFansActivity.this.fEa != null && !MyForbiddenFansActivity.this.fEa.isLoading()) {
                    MyForbiddenFansActivity.this.fEa.startLoadData();
                }
                MyForbiddenFansActivity.this.hND.ckb();
            }
        });
        this.fEa = new PbListView(getActivity());
        this.fEa.getView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setLineGone();
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fEa.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.fEa.bkv();
        this.hNC = new b(this);
        this.hcm.setAdapter(this.hNC);
        this.hND.a(this.hNG);
        this.hNE = new e(getPageContext(), getUniqueId());
        this.hNB.setOnClickListener(this.hNH);
        this.hNC.n(this.hNJ);
        this.hNC.x(this.hNI);
        this.hNE.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.hNF == null) {
                            MyForbiddenFansActivity.this.hNF = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.hNF.setGravity(19);
                            MyForbiddenFansActivity.this.hNF.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.hNF.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.hNF.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.hNF.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        MyForbiddenFansActivity.this.hNF.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.hNA.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.hNA.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.hNA.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.hNF, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.hNC.eC(j)) {
                                if (MyForbiddenFansActivity.this.hNC.cjZ()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.hNC.getItemCount() > 20 || !MyForbiddenFansActivity.this.hND.hasMore()) {
                                    MyForbiddenFansActivity.this.aq(MyForbiddenFansActivity.this.hNC.getFansList());
                                    MyForbiddenFansActivity.this.hNC.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.hND.ckb();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.hNC.eC(j)) {
                    if (MyForbiddenFansActivity.this.hNC.cjZ()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.hNC.getItemCount() > 20 || !MyForbiddenFansActivity.this.hND.hasMore()) {
                        MyForbiddenFansActivity.this.aq(MyForbiddenFansActivity.this.hNC.getFansList());
                        MyForbiddenFansActivity.this.hNC.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.hND.ckb();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void cjY() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.hND.cka();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(ArrayList<a> arrayList) {
        if (!y.isEmpty(arrayList)) {
            this.hcm.setNextPage(this.fEa);
            if (this.hND.hasMore()) {
                this.fEa.setText(getString(R.string.pb_load_more));
                this.fEa.endLoadData();
                return;
            }
            this.fEa.setText(getString(R.string.no_more_data_tip));
            this.fEa.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.hNB, R.color.color_remove_all_title);
        this.hNC.notifyDataSetChanged();
        this.hNE.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fEa.changeSkin(i);
        ap.setViewTextColor(this.hNF, R.color.cp_cont_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hND.onDestroy();
        this.hNA.onDestroy();
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
        this.hcm.setVisibility(8);
        this.hNB.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.hcm.setVisibility(0);
        this.hNB.setEnabled(true);
    }
}
