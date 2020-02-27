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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
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
/* loaded from: classes10.dex */
public class MyForbiddenFansActivity extends BaseActivity {
    private PbListView eli;
    private BdRecyclerView fCs;
    private NavigationBarCoverTip gjd;
    private TextView gje;
    private b gjf;
    private c gjg;
    private e gjh;
    private TextView gji;
    private c.a gjj = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
        @Override // com.baidu.tieba.forbidden.fans.c.a
        public void a(int i, String str, ArrayList<a> arrayList) {
            if (MyForbiddenFansActivity.this.isProgressBarShown()) {
                MyForbiddenFansActivity.this.hideProgressBar();
            }
            if (i != 0) {
                MyForbiddenFansActivity.this.showToast(str);
            }
            if (v.isEmpty(arrayList)) {
                MyForbiddenFansActivity.this.showNoDataView();
            } else if (i == 0) {
                MyForbiddenFansActivity.this.hideNoDataView();
                MyForbiddenFansActivity.this.ah(arrayList);
                MyForbiddenFansActivity.this.gjf.ai(arrayList);
                MyForbiddenFansActivity.this.gjf.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener gjk = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.gje) {
                    TiebaStatic.log(new an("c13104").X("obj_locate", 2));
                    MyForbiddenFansActivity.this.gjh.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener gjl = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new an("c13105"));
                MyForbiddenFansActivity.this.gjh.ds(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener gjm = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.gjg = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gje = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.gjd = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.fCs = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.fCs.setLayoutManager(new LinearLayoutManager(this));
        this.fCs.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.gjg.hasMore() && MyForbiddenFansActivity.this.eli != null && !MyForbiddenFansActivity.this.eli.isLoading()) {
                    MyForbiddenFansActivity.this.eli.startLoadData();
                }
                MyForbiddenFansActivity.this.gjg.bCj();
            }
        });
        this.eli = new PbListView(getActivity());
        this.eli.getView();
        this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.eli.setLineGone();
        this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
        this.eli.setTextSize(R.dimen.tbfontsize33);
        this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
        this.eli.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.eli.aHE();
        this.gjf = new b(this);
        this.fCs.setAdapter(this.gjf);
        this.gjg.a(this.gjj);
        this.gjh = new e(getPageContext(), getUniqueId());
        this.gje.setOnClickListener(this.gjk);
        this.gjf.n(this.gjm);
        this.gjf.w(this.gjl);
        this.gjh.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.gji == null) {
                            MyForbiddenFansActivity.this.gji = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.gji.setGravity(19);
                            MyForbiddenFansActivity.this.gji.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.gji.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.gji.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.gji.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        MyForbiddenFansActivity.this.gji.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.gjd.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.gjd.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.gjd.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.gji, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.gjf.dr(j)) {
                                if (MyForbiddenFansActivity.this.gjf.bCh()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.gjf.getItemCount() > 20 || !MyForbiddenFansActivity.this.gjg.hasMore()) {
                                    MyForbiddenFansActivity.this.ah(MyForbiddenFansActivity.this.gjf.getFansList());
                                    MyForbiddenFansActivity.this.gjf.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.gjg.bCj();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.gjf.dr(j)) {
                    if (MyForbiddenFansActivity.this.gjf.bCh()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.gjf.getItemCount() > 20 || !MyForbiddenFansActivity.this.gjg.hasMore()) {
                        MyForbiddenFansActivity.this.ah(MyForbiddenFansActivity.this.gjf.getFansList());
                        MyForbiddenFansActivity.this.gjf.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.gjg.bCj();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bCg() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.gjg.bCi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(ArrayList<a> arrayList) {
        if (!v.isEmpty(arrayList)) {
            this.fCs.setNextPage(this.eli);
            if (this.gjg.hasMore()) {
                this.eli.setText(getString(R.string.pb_load_more));
                this.eli.endLoadData();
                return;
            }
            this.eli.setText(getString(R.string.no_more_data_tip));
            this.eli.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.gje, (int) R.color.color_remove_all_title);
        this.gjf.notifyDataSetChanged();
        this.gjh.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.eli.setTextColor(am.getColor(R.color.cp_cont_d));
        this.eli.changeSkin(i);
        am.setViewTextColor(this.gji, (int) R.color.cp_cont_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gjg.onDestroy();
        this.gjd.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.lh(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.fCs.setVisibility(8);
        this.gje.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.fCs.setVisibility(0);
        this.gje.setEnabled(true);
    }
}
