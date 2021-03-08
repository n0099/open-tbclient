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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
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
    private PbListView gCf;
    private BdRecyclerView irr;
    private NavigationBarCoverTip jcM;
    private TextView jcN;
    private MyForbiddenFansListAdapter jcO;
    private b jcP;
    private d jcQ;
    private TextView jcR;
    private b.a jcS = new b.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
        @Override // com.baidu.tieba.forbidden.fans.b.a
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
                MyForbiddenFansActivity.this.ap(arrayList);
                MyForbiddenFansActivity.this.jcO.aq(arrayList);
                MyForbiddenFansActivity.this.jcO.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener jcT = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.jcN) {
                    TiebaStatic.log(new ar("c13104").aq("obj_locate", 2));
                    MyForbiddenFansActivity.this.jcQ.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener jcU = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new ar("c13105"));
                MyForbiddenFansActivity.this.jcQ.gn(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener jcV = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.jcP = new b();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.jcN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.jcM = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.irr = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.irr.setLayoutManager(new LinearLayoutManager(this));
        this.irr.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.jcP.hasMore() && MyForbiddenFansActivity.this.gCf != null && !MyForbiddenFansActivity.this.gCf.isLoading()) {
                    MyForbiddenFansActivity.this.gCf.startLoadData();
                }
                MyForbiddenFansActivity.this.jcP.cAN();
            }
        });
        this.gCf = new PbListView(getActivity());
        this.gCf.getView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setLineGone();
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.gCf.bug();
        this.jcO = new MyForbiddenFansListAdapter(this);
        this.irr.setAdapter(this.jcO);
        this.jcP.a(this.jcS);
        this.jcQ = new d(getPageContext(), getUniqueId());
        this.jcN.setOnClickListener(this.jcT);
        this.jcO.p(this.jcV);
        this.jcO.z(this.jcU);
        this.jcQ.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.jcR == null) {
                            MyForbiddenFansActivity.this.jcR = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.jcR.setGravity(19);
                            MyForbiddenFansActivity.this.jcR.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.jcR.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.jcR.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.jcR.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.CAM_X0101));
                        }
                        MyForbiddenFansActivity.this.jcR.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.jcM.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.jcM.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.jcM.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.jcR, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.jcO.gm(j)) {
                                if (MyForbiddenFansActivity.this.jcO.cAL()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.jcO.getItemCount() > 20 || !MyForbiddenFansActivity.this.jcP.hasMore()) {
                                    MyForbiddenFansActivity.this.ap(MyForbiddenFansActivity.this.jcO.getFansList());
                                    MyForbiddenFansActivity.this.jcO.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.jcP.cAN();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.jcO.gm(j)) {
                    if (MyForbiddenFansActivity.this.jcO.cAL()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.jcO.getItemCount() > 20 || !MyForbiddenFansActivity.this.jcP.hasMore()) {
                        MyForbiddenFansActivity.this.ap(MyForbiddenFansActivity.this.jcO.getFansList());
                        MyForbiddenFansActivity.this.jcO.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.jcP.cAN();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void cAK() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.jcP.cAM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(ArrayList<a> arrayList) {
        if (!y.isEmpty(arrayList)) {
            this.irr.setNextPage(this.gCf);
            if (this.jcP.hasMore()) {
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
        ap.setViewTextColor(this.jcN, R.color.color_remove_all_title);
        this.jcO.notifyDataSetChanged();
        this.jcQ.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gCf.changeSkin(i);
        ap.setViewTextColor(this.jcR, R.color.CAM_X0101);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jcP.onDestroy();
        this.jcM.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pA(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0106);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.irr.setVisibility(8);
        this.jcN.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.irr.setVisibility(0);
        this.jcN.setEnabled(true);
    }
}
