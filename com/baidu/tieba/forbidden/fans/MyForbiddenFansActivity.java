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
/* loaded from: classes8.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private PbListView gCf;
    private NavigationBarCoverTip iZP;
    private TextView iZQ;
    private MyForbiddenFansListAdapter iZR;
    private b iZS;
    private d iZT;
    private TextView iZU;
    private b.a iZV = new b.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.av(arrayList);
                MyForbiddenFansActivity.this.iZR.aw(arrayList);
                MyForbiddenFansActivity.this.iZR.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener iZW = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.iZQ) {
                    TiebaStatic.log(new aq("c13104").an("obj_locate", 2));
                    MyForbiddenFansActivity.this.iZT.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener iZX = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new aq("c13105"));
                MyForbiddenFansActivity.this.iZT.gi(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener iZY = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof a) {
                a aVar = (a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MyForbiddenFansActivity.this.getActivity(), String.valueOf(aVar.id), aVar.name)));
            }
        }
    };
    private BdRecyclerView iov;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private LinearLayout mRootView;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forbidden_fans_list_layout);
        this.mRootView = (LinearLayout) findViewById(R.id.container_forbidden_fans);
        this.iZS = new b();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.iZQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.iZP = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.iov = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.iov.setLayoutManager(new LinearLayoutManager(this));
        this.iov.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.iZS.hasMore() && MyForbiddenFansActivity.this.gCf != null && !MyForbiddenFansActivity.this.gCf.isLoading()) {
                    MyForbiddenFansActivity.this.gCf.startLoadData();
                }
                MyForbiddenFansActivity.this.iZS.cDh();
            }
        });
        this.gCf = new PbListView(getActivity());
        this.gCf.getView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setLineGone();
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.gCf.bxD();
        this.iZR = new MyForbiddenFansListAdapter(this);
        this.iov.setAdapter(this.iZR);
        this.iZS.a(this.iZV);
        this.iZT = new d(getPageContext(), getUniqueId());
        this.iZQ.setOnClickListener(this.iZW);
        this.iZR.p(this.iZY);
        this.iZR.z(this.iZX);
        this.iZT.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.iZU == null) {
                            MyForbiddenFansActivity.this.iZU = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.iZU.setGravity(19);
                            MyForbiddenFansActivity.this.iZU.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.iZU.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.iZU.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.iZU.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.CAM_X0101));
                        }
                        MyForbiddenFansActivity.this.iZU.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.iZP.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.iZP.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.iZP.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.iZU, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.iZR.gh(j)) {
                                if (MyForbiddenFansActivity.this.iZR.cDf()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.iZR.getItemCount() > 20 || !MyForbiddenFansActivity.this.iZS.hasMore()) {
                                    MyForbiddenFansActivity.this.av(MyForbiddenFansActivity.this.iZR.getFansList());
                                    MyForbiddenFansActivity.this.iZR.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.iZS.cDh();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.iZR.gh(j)) {
                    if (MyForbiddenFansActivity.this.iZR.cDf()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.iZR.getItemCount() > 20 || !MyForbiddenFansActivity.this.iZS.hasMore()) {
                        MyForbiddenFansActivity.this.av(MyForbiddenFansActivity.this.iZR.getFansList());
                        MyForbiddenFansActivity.this.iZR.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.iZS.cDh();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void cDe() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.iZS.cDg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(ArrayList<a> arrayList) {
        if (!x.isEmpty(arrayList)) {
            this.iov.setNextPage(this.gCf);
            if (this.iZS.hasMore()) {
                this.gCf.setText(getString(R.string.pb_load_more));
                this.gCf.endLoadData();
                return;
            }
            this.gCf.setText(getString(R.string.no_more_data_tip));
            this.gCf.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.iZQ, R.color.color_remove_all_title);
        this.iZR.notifyDataSetChanged();
        this.iZT.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.gCf.changeSkin(i);
        ao.setViewTextColor(this.iZU, R.color.CAM_X0101);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iZS.onDestroy();
        this.iZP.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ra(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0106);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.iov.setVisibility(8);
        this.iZQ.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.iov.setVisibility(0);
        this.iZQ.setEnabled(true);
    }
}
