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
import com.baidu.tbadk.core.util.ar;
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
/* loaded from: classes22.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private PbListView giV;
    private BdRecyclerView hQZ;
    private NavigationBarCoverTip iCK;
    private TextView iCL;
    private b iCM;
    private c iCN;
    private e iCO;
    private TextView iCP;
    private c.a iCQ = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.au(arrayList);
                MyForbiddenFansActivity.this.iCM.av(arrayList);
                MyForbiddenFansActivity.this.iCM.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener iCR = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.iCL) {
                    TiebaStatic.log(new ar("c13104").ak("obj_locate", 2));
                    MyForbiddenFansActivity.this.iCO.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener iCS = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new ar("c13105"));
                MyForbiddenFansActivity.this.iCO.fE(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener iCT = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.iCN = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.iCL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.iCK = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.hQZ = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.hQZ.setLayoutManager(new LinearLayoutManager(this));
        this.hQZ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.iCN.hasMore() && MyForbiddenFansActivity.this.giV != null && !MyForbiddenFansActivity.this.giV.isLoading()) {
                    MyForbiddenFansActivity.this.giV.startLoadData();
                }
                MyForbiddenFansActivity.this.iCN.cvX();
            }
        });
        this.giV = new PbListView(getActivity());
        this.giV.getView();
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.giV.setLineGone();
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.giV.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.giV.brI();
        this.iCM = new b(this);
        this.hQZ.setAdapter(this.iCM);
        this.iCN.a(this.iCQ);
        this.iCO = new e(getPageContext(), getUniqueId());
        this.iCL.setOnClickListener(this.iCR);
        this.iCM.o(this.iCT);
        this.iCM.y(this.iCS);
        this.iCO.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.iCP == null) {
                            MyForbiddenFansActivity.this.iCP = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.iCP.setGravity(19);
                            MyForbiddenFansActivity.this.iCP.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.iCP.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.iCP.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.iCP.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.CAM_X0101));
                        }
                        MyForbiddenFansActivity.this.iCP.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.iCK.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.iCK.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.iCK.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.iCP, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.iCM.fD(j)) {
                                if (MyForbiddenFansActivity.this.iCM.cvV()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.iCM.getItemCount() > 20 || !MyForbiddenFansActivity.this.iCN.hasMore()) {
                                    MyForbiddenFansActivity.this.au(MyForbiddenFansActivity.this.iCM.getFansList());
                                    MyForbiddenFansActivity.this.iCM.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.iCN.cvX();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.iCM.fD(j)) {
                    if (MyForbiddenFansActivity.this.iCM.cvV()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.iCM.getItemCount() > 20 || !MyForbiddenFansActivity.this.iCN.hasMore()) {
                        MyForbiddenFansActivity.this.au(MyForbiddenFansActivity.this.iCM.getFansList());
                        MyForbiddenFansActivity.this.iCM.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.iCN.cvX();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void cvU() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.iCN.cvW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(ArrayList<a> arrayList) {
        if (!y.isEmpty(arrayList)) {
            this.hQZ.setNextPage(this.giV);
            if (this.iCN.hasMore()) {
                this.giV.setText(getString(R.string.pb_load_more));
                this.giV.endLoadData();
                return;
            }
            this.giV.setText(getString(R.string.no_more_data_tip));
            this.giV.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.iCL, R.color.color_remove_all_title);
        this.iCM.notifyDataSetChanged();
        this.iCO.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.giV.changeSkin(i);
        ap.setViewTextColor(this.iCP, R.color.CAM_X0101);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iCN.onDestroy();
        this.iCK.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.qo(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0106);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.hQZ.setVisibility(8);
        this.iCL.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.hQZ.setVisibility(0);
        this.iCL.setEnabled(true);
    }
}
