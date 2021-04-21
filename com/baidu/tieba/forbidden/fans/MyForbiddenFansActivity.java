package com.baidu.tieba.forbidden.fans;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
import d.b.c.e.p.l;
import d.b.j0.n0.a.b;
import d.b.j0.n0.a.d;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    public MyForbiddenFansListAdapter mAdapter;
    public NavigationBarCoverTip mCoverTipNaviBar;
    public BdRecyclerView mListView;
    public PbListView mLoadMoreView;
    public d.b.j0.n0.a.b mModel;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public d.b.j0.n0.a.d mRemoveController;
    public TextView mRemoveView;
    public TextView mResultTipView;
    public LinearLayout mRootView;
    public b.InterfaceC1421b mNetDataCallBack = new a();
    public View.OnClickListener mRemoveAllClick = new b();
    public View.OnClickListener mRemoveSingleClick = new c();
    public View.OnClickListener mPersonClick = new d();

    /* loaded from: classes4.dex */
    public class a implements b.InterfaceC1421b {
        public a() {
        }

        @Override // d.b.j0.n0.a.b.InterfaceC1421b
        public void a(int i, String str, ArrayList<d.b.j0.n0.a.a> arrayList) {
            if (MyForbiddenFansActivity.this.isProgressBarShown()) {
                MyForbiddenFansActivity.this.hideProgressBar();
            }
            if (i != 0) {
                MyForbiddenFansActivity.this.showToast(str);
            }
            if (ListUtils.isEmpty(arrayList)) {
                MyForbiddenFansActivity.this.showNoDataView();
            } else if (i != 0) {
            } else {
                MyForbiddenFansActivity.this.hideNoDataView();
                MyForbiddenFansActivity.this.updateLoadMoreView(arrayList);
                MyForbiddenFansActivity.this.mAdapter.r(arrayList);
                MyForbiddenFansActivity.this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.C()) {
                if (view == MyForbiddenFansActivity.this.mRemoveView) {
                    TiebaStatic.log(new StatisticItem("c13104").param("obj_locate", 2));
                    MyForbiddenFansActivity.this.mRemoveController.e();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity myForbiddenFansActivity = MyForbiddenFansActivity.this;
            myForbiddenFansActivity.showToast(myForbiddenFansActivity.getString(R.string.neterror));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.C()) {
                MyForbiddenFansActivity myForbiddenFansActivity = MyForbiddenFansActivity.this;
                myForbiddenFansActivity.showToast(myForbiddenFansActivity.getString(R.string.neterror));
            } else if (view.getTag() instanceof d.b.j0.n0.a.a) {
                TiebaStatic.log(new StatisticItem("c13105"));
                MyForbiddenFansActivity.this.mRemoveController.f(((d.b.j0.n0.a.a) view.getTag()).f58865a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof d.b.j0.n0.a.a) {
                d.b.j0.n0.a.a aVar = (d.b.j0.n0.a.a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MyForbiddenFansActivity.this.getActivity(), String.valueOf(aVar.f58865a), aVar.f58866b)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdListView.p {
        public e() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (MyForbiddenFansActivity.this.mModel.f() && MyForbiddenFansActivity.this.mLoadMoreView != null && !MyForbiddenFansActivity.this.mLoadMoreView.l()) {
                MyForbiddenFansActivity.this.mLoadMoreView.O();
            }
            MyForbiddenFansActivity.this.mModel.h();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.e {
        public f() {
        }

        @Override // d.b.j0.n0.a.d.e
        public void a() {
            MyForbiddenFansActivity myForbiddenFansActivity = MyForbiddenFansActivity.this;
            myForbiddenFansActivity.showLoadingDialog(myForbiddenFansActivity.getString(R.string.remove_fans_loading));
        }

        @Override // d.b.j0.n0.a.d.e
        public void b(int i, String str, boolean z, int i2, long j) {
            if (!z) {
                if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.mAdapter.d(j)) {
                    if (MyForbiddenFansActivity.this.mAdapter.o()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.mAdapter.getItemCount() <= 20 && MyForbiddenFansActivity.this.mModel.f()) {
                        MyForbiddenFansActivity.this.mModel.h();
                    } else {
                        MyForbiddenFansActivity myForbiddenFansActivity = MyForbiddenFansActivity.this;
                        myForbiddenFansActivity.updateLoadMoreView(myForbiddenFansActivity.mAdapter.m());
                        MyForbiddenFansActivity.this.mAdapter.notifyDataSetChanged();
                    }
                }
            } else if (i2 != 0) {
                if (i2 != 1 || i == 2260104) {
                    return;
                }
                if (i == 0) {
                    if (MyForbiddenFansActivity.this.mAdapter.d(j)) {
                        if (MyForbiddenFansActivity.this.mAdapter.o()) {
                            MyForbiddenFansActivity.this.showNoDataView();
                            return;
                        } else if (MyForbiddenFansActivity.this.mAdapter.getItemCount() <= 20 && MyForbiddenFansActivity.this.mModel.f()) {
                            MyForbiddenFansActivity.this.mModel.h();
                            return;
                        } else {
                            MyForbiddenFansActivity myForbiddenFansActivity2 = MyForbiddenFansActivity.this;
                            myForbiddenFansActivity2.updateLoadMoreView(myForbiddenFansActivity2.mAdapter.m());
                            MyForbiddenFansActivity.this.mAdapter.notifyDataSetChanged();
                            return;
                        }
                    }
                    return;
                }
                l.L(MyForbiddenFansActivity.this.getActivity(), str);
            } else {
                MyForbiddenFansActivity.this.closeLoadingDialog();
                if (i == 0) {
                    MyForbiddenFansActivity.this.showNoDataView();
                } else if (i == 2260104) {
                    return;
                }
                if (MyForbiddenFansActivity.this.mResultTipView == null) {
                    MyForbiddenFansActivity.this.mResultTipView = new TextView(MyForbiddenFansActivity.this.getActivity());
                    MyForbiddenFansActivity.this.mResultTipView.setGravity(19);
                    MyForbiddenFansActivity.this.mResultTipView.setPadding(l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                    MyForbiddenFansActivity.this.mResultTipView.setLayoutParams(new ViewGroup.LayoutParams(-1, l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                    MyForbiddenFansActivity.this.mResultTipView.setTextSize(0, l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                    MyForbiddenFansActivity.this.mResultTipView.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.CAM_X0101));
                }
                MyForbiddenFansActivity.this.mResultTipView.setText(str);
                if (i == 0) {
                    MyForbiddenFansActivity.this.mCoverTipNaviBar.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                } else {
                    MyForbiddenFansActivity.this.mCoverTipNaviBar.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                }
                MyForbiddenFansActivity.this.mCoverTipNaviBar.m(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.mResultTipView, 3000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        NoDataView noDataView = this.mNoDataView;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.mListView.setVisibility(0);
        this.mRemoveView.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView = a2;
            a2.setTextOption(NoDataViewFactory.e.a(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0106);
            this.mNoDataView.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mRemoveView.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLoadMoreView(ArrayList<d.b.j0.n0.a.a> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        this.mListView.setNextPage(this.mLoadMoreView);
        if (this.mModel.f()) {
            this.mLoadMoreView.A(getString(R.string.pb_load_more));
            this.mLoadMoreView.f();
            return;
        }
        this.mLoadMoreView.A(getString(R.string.no_more_data_tip));
        this.mLoadMoreView.f();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        SkinManager.setViewTextColor(this.mRemoveView, R.color.color_remove_all_title);
        this.mAdapter.notifyDataSetChanged();
        this.mRemoveController.d();
        NoDataView noDataView = this.mNoDataView;
        if (noDataView != null) {
            noDataView.f(getPageContext(), i);
        }
        this.mLoadMoreView.C(SkinManager.getColor(R.color.CAM_X0109));
        this.mLoadMoreView.d(i);
        SkinManager.setViewTextColor(this.mResultTipView, R.color.CAM_X0101);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forbidden_fans_list_layout);
        this.mRootView = (LinearLayout) findViewById(R.id.container_forbidden_fans);
        this.mModel = new d.b.j0.n0.a.b();
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar = navigationBar;
        navigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mRemoveView = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.mCoverTipNaviBar = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.mListView = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mListView.setOnSrollToBottomListener(new e());
        PbListView pbListView = new PbListView(getActivity());
        this.mLoadMoreView = pbListView;
        pbListView.b();
        this.mLoadMoreView.o(R.color.CAM_X0205);
        this.mLoadMoreView.v();
        this.mLoadMoreView.C(SkinManager.getColor(R.color.CAM_X0107));
        this.mLoadMoreView.E(R.dimen.tbfontsize33);
        this.mLoadMoreView.y(R.color.CAM_X0110);
        this.mLoadMoreView.r(l.g(getActivity(), R.dimen.tbds182));
        this.mLoadMoreView.q();
        MyForbiddenFansListAdapter myForbiddenFansListAdapter = new MyForbiddenFansListAdapter(this);
        this.mAdapter = myForbiddenFansListAdapter;
        this.mListView.setAdapter(myForbiddenFansListAdapter);
        this.mModel.j(this.mNetDataCallBack);
        this.mRemoveController = new d.b.j0.n0.a.d(getPageContext(), getUniqueId());
        this.mRemoveView.setOnClickListener(this.mRemoveAllClick);
        this.mAdapter.s(this.mPersonClick);
        this.mAdapter.u(this.mRemoveSingleClick);
        this.mRemoveController.g(new f());
        showProgressBar(true, 0, 0);
        this.mModel.g();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mModel.i();
        this.mCoverTipNaviBar.i();
    }
}
