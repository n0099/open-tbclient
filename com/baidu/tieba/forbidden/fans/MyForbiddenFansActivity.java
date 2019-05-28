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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.c;
import com.baidu.tieba.forbidden.fans.e;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private LinearLayout bMZ;
    private PbListView dlY;
    private BdRecyclerView eqd;
    private NavigationBarCoverTip fjR;
    private TextView fjS;
    private b fjT;
    private c fjU;
    private e fjV;
    private TextView fjW;
    private c.a fjX = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
        @Override // com.baidu.tieba.forbidden.fans.c.a
        public void a(int i, String str, ArrayList<a> arrayList) {
            if (MyForbiddenFansActivity.this.isProgressBarShown()) {
                MyForbiddenFansActivity.this.hideProgressBar();
            }
            if (i != 0) {
                MyForbiddenFansActivity.this.showToast(str);
            }
            if (v.aa(arrayList)) {
                MyForbiddenFansActivity.this.showNoDataView();
            } else if (i == 0) {
                MyForbiddenFansActivity.this.hideNoDataView();
                MyForbiddenFansActivity.this.R(arrayList);
                MyForbiddenFansActivity.this.fjT.S(arrayList);
                MyForbiddenFansActivity.this.fjT.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener fjY = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.ki()) {
                if (view == MyForbiddenFansActivity.this.fjS) {
                    TiebaStatic.log(new am("c13104").P("obj_locate", 2));
                    MyForbiddenFansActivity.this.fjV.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener fjZ = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.ki()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new am("c13105"));
                MyForbiddenFansActivity.this.fjV.cY(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener fka = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof a) {
                a aVar = (a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(MyForbiddenFansActivity.this.getActivity(), String.valueOf(aVar.id), aVar.name)));
            }
        }
    };
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forbidden_fans_list_layout);
        this.bMZ = (LinearLayout) findViewById(R.id.container_forbidden_fans);
        this.fjU = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fjS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.fjR = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.eqd = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.eqd.setLayoutManager(new LinearLayoutManager(this));
        this.eqd.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.fjU.hasMore() && MyForbiddenFansActivity.this.dlY != null && !MyForbiddenFansActivity.this.dlY.pu()) {
                    MyForbiddenFansActivity.this.dlY.ajy();
                }
                MyForbiddenFansActivity.this.fjU.bil();
            }
        });
        this.dlY = new PbListView(getActivity());
        this.dlY.getView();
        this.dlY.iO(R.color.cp_bg_line_e);
        this.dlY.ajv();
        this.dlY.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlY.setTextSize(R.dimen.tbfontsize33);
        this.dlY.iN(R.color.cp_cont_e);
        this.dlY.setHeight(l.g(getActivity(), R.dimen.tbds182));
        this.dlY.ajC();
        this.fjT = new b(this);
        this.eqd.setAdapter(this.fjT);
        this.fjU.a(this.fjX);
        this.fjV = new e(getPageContext(), getUniqueId());
        this.fjS.setOnClickListener(this.fjY);
        this.fjT.l(this.fka);
        this.fjT.t(this.fjZ);
        this.fjV.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.fjW == null) {
                            MyForbiddenFansActivity.this.fjW = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.fjW.setGravity(19);
                            MyForbiddenFansActivity.this.fjW.setPadding(l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.fjW.setLayoutParams(new ViewGroup.LayoutParams(-1, l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.fjW.setTextSize(0, l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.fjW.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_btn_a));
                        }
                        MyForbiddenFansActivity.this.fjW.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.fjR.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.fjR.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.fjR.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.fjW, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.fjT.cX(j)) {
                                if (MyForbiddenFansActivity.this.fjT.bij()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.fjT.getItemCount() > 20 || !MyForbiddenFansActivity.this.fjU.hasMore()) {
                                    MyForbiddenFansActivity.this.R(MyForbiddenFansActivity.this.fjT.getFansList());
                                    MyForbiddenFansActivity.this.fjT.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.fjU.bil();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.fjT.cX(j)) {
                    if (MyForbiddenFansActivity.this.fjT.bij()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.fjT.getItemCount() > 20 || !MyForbiddenFansActivity.this.fjU.hasMore()) {
                        MyForbiddenFansActivity.this.R(MyForbiddenFansActivity.this.fjT.getFansList());
                        MyForbiddenFansActivity.this.fjT.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.fjU.bil();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bii() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.fjU.bik();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(ArrayList<a> arrayList) {
        if (!v.aa(arrayList)) {
            this.eqd.setNextPage(this.dlY);
            if (this.fjU.hasMore()) {
                this.dlY.setText(getString(R.string.pb_load_more));
                this.dlY.ajz();
                return;
            }
            this.dlY.setText(getString(R.string.no_more_data_tip));
            this.dlY.ajz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.j(this.fjS, R.color.color_remove_all_title);
        this.fjT.notifyDataSetChanged();
        this.fjV.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.dlY.setTextColor(al.getColor(R.color.cp_cont_d));
        this.dlY.iP(i);
        al.j(this.fjW, R.color.cp_btn_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fjU.onDestroy();
        this.fjR.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.bMZ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.eqd.setVisibility(8);
        this.fjS.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.eqd.setVisibility(0);
        this.fjS.setEnabled(true);
    }
}
