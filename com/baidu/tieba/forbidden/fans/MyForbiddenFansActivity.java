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
/* loaded from: classes8.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private PbListView gAi;
    private BdRecyclerView ipu;
    private NavigationBarCoverTip jaP;
    private TextView jaQ;
    private MyForbiddenFansListAdapter jaR;
    private b jaS;
    private d jaT;
    private TextView jaU;
    private b.a jaV = new b.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.jaR.aq(arrayList);
                MyForbiddenFansActivity.this.jaR.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener jaW = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.jaQ) {
                    TiebaStatic.log(new ar("c13104").ap("obj_locate", 2));
                    MyForbiddenFansActivity.this.jaT.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener jaX = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new ar("c13105"));
                MyForbiddenFansActivity.this.jaT.gn(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener jaY = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.jaS = new b();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.jaQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.jaP = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.ipu = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.ipu.setLayoutManager(new LinearLayoutManager(this));
        this.ipu.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.jaS.hasMore() && MyForbiddenFansActivity.this.gAi != null && !MyForbiddenFansActivity.this.gAi.isLoading()) {
                    MyForbiddenFansActivity.this.gAi.startLoadData();
                }
                MyForbiddenFansActivity.this.jaS.cAA();
            }
        });
        this.gAi = new PbListView(getActivity());
        this.gAi.getView();
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAi.setLineGone();
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAi.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.gAi.bud();
        this.jaR = new MyForbiddenFansListAdapter(this);
        this.ipu.setAdapter(this.jaR);
        this.jaS.a(this.jaV);
        this.jaT = new d(getPageContext(), getUniqueId());
        this.jaQ.setOnClickListener(this.jaW);
        this.jaR.p(this.jaY);
        this.jaR.z(this.jaX);
        this.jaT.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.jaU == null) {
                            MyForbiddenFansActivity.this.jaU = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.jaU.setGravity(19);
                            MyForbiddenFansActivity.this.jaU.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.jaU.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.jaU.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.jaU.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.CAM_X0101));
                        }
                        MyForbiddenFansActivity.this.jaU.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.jaP.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.jaP.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.jaP.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.jaU, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.jaR.gm(j)) {
                                if (MyForbiddenFansActivity.this.jaR.cAy()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.jaR.getItemCount() > 20 || !MyForbiddenFansActivity.this.jaS.hasMore()) {
                                    MyForbiddenFansActivity.this.ap(MyForbiddenFansActivity.this.jaR.getFansList());
                                    MyForbiddenFansActivity.this.jaR.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.jaS.cAA();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.jaR.gm(j)) {
                    if (MyForbiddenFansActivity.this.jaR.cAy()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.jaR.getItemCount() > 20 || !MyForbiddenFansActivity.this.jaS.hasMore()) {
                        MyForbiddenFansActivity.this.ap(MyForbiddenFansActivity.this.jaR.getFansList());
                        MyForbiddenFansActivity.this.jaR.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.jaS.cAA();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void cAx() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.jaS.cAz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(ArrayList<a> arrayList) {
        if (!y.isEmpty(arrayList)) {
            this.ipu.setNextPage(this.gAi);
            if (this.jaS.hasMore()) {
                this.gAi.setText(getString(R.string.pb_load_more));
                this.gAi.endLoadData();
                return;
            }
            this.gAi.setText(getString(R.string.no_more_data_tip));
            this.gAi.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.jaQ, R.color.color_remove_all_title);
        this.jaR.notifyDataSetChanged();
        this.jaT.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gAi.changeSkin(i);
        ap.setViewTextColor(this.jaU, R.color.CAM_X0101);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jaS.onDestroy();
        this.jaP.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pz(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.CAM_X0106);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.ipu.setVisibility(8);
        this.jaQ.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.ipu.setVisibility(0);
        this.jaQ.setEnabled(true);
    }
}
