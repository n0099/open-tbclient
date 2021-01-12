package com.baidu.tieba.forbidden.fans;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.b;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private PbListView gxy;
    private NavigationBarCoverTip iVi;
    private TextView iVj;
    private MyForbiddenFansListAdapter iVk;
    private b iVl;
    private d iVm;
    private TextView iVn;
    private b.a iVo = new b.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
        @Override // com.baidu.tieba.forbidden.fans.b.a
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
                MyForbiddenFansActivity.this.aq(arrayList);
                MyForbiddenFansActivity.this.iVk.ar(arrayList);
                MyForbiddenFansActivity.this.iVk.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener iVp = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.iVj) {
                    TiebaStatic.log(new aq("c13104").an("obj_locate", 2));
                    MyForbiddenFansActivity.this.iVm.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener iVq = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new aq("c13105"));
                MyForbiddenFansActivity.this.iVm.gi(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener iVr = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof a) {
                a aVar = (a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MyForbiddenFansActivity.this.getActivity(), String.valueOf(aVar.id), aVar.name)));
            }
        }
    };
    private BdRecyclerView ijM;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private LinearLayout mRootView;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forbidden_fans_list_layout);
        this.mRootView = (LinearLayout) findViewById(R.id.container_forbidden_fans);
        this.iVl = new b();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.iVj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.iVi = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.ijM = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.ijM.setLayoutManager(new LinearLayoutManager(this));
        this.ijM.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.iVl.hasMore() && MyForbiddenFansActivity.this.gxy != null && !MyForbiddenFansActivity.this.gxy.isLoading()) {
                    MyForbiddenFansActivity.this.gxy.startLoadData();
                }
                MyForbiddenFansActivity.this.iVl.czp();
            }
        });
        this.gxy = new PbListView(getActivity());
        this.gxy.getView();
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gxy.setLineGone();
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gxy.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.gxy.btJ();
        this.iVk = new MyForbiddenFansListAdapter(this);
        this.ijM.setAdapter(this.iVk);
        this.iVl.a(this.iVo);
        this.iVm = new d(getPageContext(), getUniqueId());
        this.iVj.setOnClickListener(this.iVp);
        this.iVk.p(this.iVr);
        this.iVk.z(this.iVq);
        this.iVm.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    if (i2 == 0) {
                        MyForbiddenFansActivity.this.closeLoadingDialog();
                        if (i == 0) {
                            MyForbiddenFansActivity.this.showNoDataView();
                        } else if (i == 2260104) {
                            return;
                        }
                        if (MyForbiddenFansActivity.this.iVn == null) {
                            MyForbiddenFansActivity.this.iVn = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.iVn.setGravity(19);
                            MyForbiddenFansActivity.this.iVn.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.iVn.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.iVn.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.iVn.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.CAM_X0101));
                        }
                        MyForbiddenFansActivity.this.iVn.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.iVi.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.iVi.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.iVi.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.iVn, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.iVk.gh(j)) {
                                if (MyForbiddenFansActivity.this.iVk.czn()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.iVk.getItemCount() > 20 || !MyForbiddenFansActivity.this.iVl.hasMore()) {
                                    MyForbiddenFansActivity.this.aq(MyForbiddenFansActivity.this.iVk.getFansList());
                                    MyForbiddenFansActivity.this.iVk.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.iVl.czp();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.iVk.gh(j)) {
                    if (MyForbiddenFansActivity.this.iVk.czn()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.iVk.getItemCount() > 20 || !MyForbiddenFansActivity.this.iVl.hasMore()) {
                        MyForbiddenFansActivity.this.aq(MyForbiddenFansActivity.this.iVk.getFansList());
                        MyForbiddenFansActivity.this.iVk.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.iVl.czp();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void czm() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.iVl.czo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(ArrayList<a> arrayList) {
        if (!x.isEmpty(arrayList)) {
            this.ijM.setNextPage(this.gxy);
            if (this.iVl.hasMore()) {
                this.gxy.setText(getString(R.string.pb_load_more));
                this.gxy.endLoadData();
                return;
            }
            this.gxy.setText(getString(R.string.no_more_data_tip));
            this.gxy.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.iVj, R.color.color_remove_all_title);
        this.iVk.notifyDataSetChanged();
        this.iVm.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.gxy.changeSkin(i);
        ao.setViewTextColor(this.iVn, R.color.CAM_X0101);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iVl.onDestroy();
        this.iVi.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pu(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0106);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.ijM.setVisibility(8);
        this.iVj.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.ijM.setVisibility(0);
        this.iVj.setEnabled(true);
    }
}
