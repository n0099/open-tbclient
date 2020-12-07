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
/* loaded from: classes23.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private PbListView gre;
    private NavigationBarCoverTip iNC;
    private TextView iND;
    private b iNE;
    private c iNF;
    private e iNG;
    private TextView iNH;
    private c.a iNI = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.av(arrayList);
                MyForbiddenFansActivity.this.iNE.aw(arrayList);
                MyForbiddenFansActivity.this.iNE.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener iNJ = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.iND) {
                    TiebaStatic.log(new ar("c13104").al("obj_locate", 2));
                    MyForbiddenFansActivity.this.iNG.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener iNK = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new ar("c13105"));
                MyForbiddenFansActivity.this.iNG.gi(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener iNL = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof a) {
                a aVar = (a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MyForbiddenFansActivity.this.getActivity(), String.valueOf(aVar.id), aVar.name)));
            }
        }
    };
    private BdRecyclerView ibT;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private LinearLayout mRootView;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forbidden_fans_list_layout);
        this.mRootView = (LinearLayout) findViewById(R.id.container_forbidden_fans);
        this.iNF = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.iND = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.iNC = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.ibT = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.ibT.setLayoutManager(new LinearLayoutManager(this));
        this.ibT.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.iNF.hasMore() && MyForbiddenFansActivity.this.gre != null && !MyForbiddenFansActivity.this.gre.isLoading()) {
                    MyForbiddenFansActivity.this.gre.startLoadData();
                }
                MyForbiddenFansActivity.this.iNF.cAm();
            }
        });
        this.gre = new PbListView(getActivity());
        this.gre.getView();
        this.gre.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gre.setLineGone();
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gre.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.gre.bvh();
        this.iNE = new b(this);
        this.ibT.setAdapter(this.iNE);
        this.iNF.a(this.iNI);
        this.iNG = new e(getPageContext(), getUniqueId());
        this.iND.setOnClickListener(this.iNJ);
        this.iNE.o(this.iNL);
        this.iNE.y(this.iNK);
        this.iNG.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.iNH == null) {
                            MyForbiddenFansActivity.this.iNH = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.iNH.setGravity(19);
                            MyForbiddenFansActivity.this.iNH.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.iNH.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.iNH.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.iNH.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.CAM_X0101));
                        }
                        MyForbiddenFansActivity.this.iNH.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.iNC.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.iNC.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.iNC.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.iNH, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.iNE.gh(j)) {
                                if (MyForbiddenFansActivity.this.iNE.cAk()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.iNE.getItemCount() > 20 || !MyForbiddenFansActivity.this.iNF.hasMore()) {
                                    MyForbiddenFansActivity.this.av(MyForbiddenFansActivity.this.iNE.getFansList());
                                    MyForbiddenFansActivity.this.iNE.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.iNF.cAm();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.iNE.gh(j)) {
                    if (MyForbiddenFansActivity.this.iNE.cAk()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.iNE.getItemCount() > 20 || !MyForbiddenFansActivity.this.iNF.hasMore()) {
                        MyForbiddenFansActivity.this.av(MyForbiddenFansActivity.this.iNE.getFansList());
                        MyForbiddenFansActivity.this.iNE.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.iNF.cAm();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void cAj() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.iNF.cAl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(ArrayList<a> arrayList) {
        if (!y.isEmpty(arrayList)) {
            this.ibT.setNextPage(this.gre);
            if (this.iNF.hasMore()) {
                this.gre.setText(getString(R.string.pb_load_more));
                this.gre.endLoadData();
                return;
            }
            this.gre.setText(getString(R.string.no_more_data_tip));
            this.gre.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.iND, R.color.color_remove_all_title);
        this.iNE.notifyDataSetChanged();
        this.iNG.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gre.changeSkin(i);
        ap.setViewTextColor(this.iNH, R.color.CAM_X0101);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iNF.onDestroy();
        this.iNC.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.qP(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0106);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.ibT.setVisibility(8);
        this.iND.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.ibT.setVisibility(0);
        this.iND.setEnabled(true);
    }
}
