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
    private PbListView dlX;
    private BdRecyclerView eqc;
    private NavigationBarCoverTip fjQ;
    private TextView fjR;
    private b fjS;
    private c fjT;
    private e fjU;
    private TextView fjV;
    private c.a fjW = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.fjS.S(arrayList);
                MyForbiddenFansActivity.this.fjS.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener fjX = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.ki()) {
                if (view == MyForbiddenFansActivity.this.fjR) {
                    TiebaStatic.log(new am("c13104").P("obj_locate", 2));
                    MyForbiddenFansActivity.this.fjU.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener fjY = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.ki()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new am("c13105"));
                MyForbiddenFansActivity.this.fjU.cY(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener fjZ = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.fjT = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fjR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.fjQ = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.eqc = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.eqc.setLayoutManager(new LinearLayoutManager(this));
        this.eqc.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.fjT.hasMore() && MyForbiddenFansActivity.this.dlX != null && !MyForbiddenFansActivity.this.dlX.pu()) {
                    MyForbiddenFansActivity.this.dlX.ajy();
                }
                MyForbiddenFansActivity.this.fjT.bii();
            }
        });
        this.dlX = new PbListView(getActivity());
        this.dlX.getView();
        this.dlX.iO(R.color.cp_bg_line_e);
        this.dlX.ajv();
        this.dlX.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlX.setTextSize(R.dimen.tbfontsize33);
        this.dlX.iN(R.color.cp_cont_e);
        this.dlX.setHeight(l.g(getActivity(), R.dimen.tbds182));
        this.dlX.ajC();
        this.fjS = new b(this);
        this.eqc.setAdapter(this.fjS);
        this.fjT.a(this.fjW);
        this.fjU = new e(getPageContext(), getUniqueId());
        this.fjR.setOnClickListener(this.fjX);
        this.fjS.l(this.fjZ);
        this.fjS.t(this.fjY);
        this.fjU.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.fjV == null) {
                            MyForbiddenFansActivity.this.fjV = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.fjV.setGravity(19);
                            MyForbiddenFansActivity.this.fjV.setPadding(l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.fjV.setLayoutParams(new ViewGroup.LayoutParams(-1, l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.fjV.setTextSize(0, l.g(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.fjV.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_btn_a));
                        }
                        MyForbiddenFansActivity.this.fjV.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.fjQ.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.fjQ.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.fjQ.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.fjV, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.fjS.cX(j)) {
                                if (MyForbiddenFansActivity.this.fjS.big()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.fjS.getItemCount() > 20 || !MyForbiddenFansActivity.this.fjT.hasMore()) {
                                    MyForbiddenFansActivity.this.R(MyForbiddenFansActivity.this.fjS.getFansList());
                                    MyForbiddenFansActivity.this.fjS.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.fjT.bii();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.fjS.cX(j)) {
                    if (MyForbiddenFansActivity.this.fjS.big()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.fjS.getItemCount() > 20 || !MyForbiddenFansActivity.this.fjT.hasMore()) {
                        MyForbiddenFansActivity.this.R(MyForbiddenFansActivity.this.fjS.getFansList());
                        MyForbiddenFansActivity.this.fjS.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.fjT.bii();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bif() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.fjT.bih();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(ArrayList<a> arrayList) {
        if (!v.aa(arrayList)) {
            this.eqc.setNextPage(this.dlX);
            if (this.fjT.hasMore()) {
                this.dlX.setText(getString(R.string.pb_load_more));
                this.dlX.ajz();
                return;
            }
            this.dlX.setText(getString(R.string.no_more_data_tip));
            this.dlX.ajz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.j(this.fjR, R.color.color_remove_all_title);
        this.fjS.notifyDataSetChanged();
        this.fjU.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.dlX.setTextColor(al.getColor(R.color.cp_cont_d));
        this.dlX.iP(i);
        al.j(this.fjV, R.color.cp_btn_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fjT.onDestroy();
        this.fjQ.onDestroy();
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
        this.eqc.setVisibility(8);
        this.fjR.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.eqc.setVisibility(0);
        this.fjR.setEnabled(true);
    }
}
