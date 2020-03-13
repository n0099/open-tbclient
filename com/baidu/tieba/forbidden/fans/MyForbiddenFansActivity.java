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
    private PbListView elw;
    private BdRecyclerView fCH;
    private NavigationBarCoverTip gjs;
    private TextView gjt;
    private b gju;
    private c gjv;
    private e gjw;
    private TextView gjx;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private LinearLayout mRootView;
    private c.a gjy = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.gju.ai(arrayList);
                MyForbiddenFansActivity.this.gju.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener gjz = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.gjt) {
                    TiebaStatic.log(new an("c13104").X("obj_locate", 2));
                    MyForbiddenFansActivity.this.gjw.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener gjA = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new an("c13105"));
                MyForbiddenFansActivity.this.gjw.ds(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener gjB = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof a) {
                a aVar = (a) view.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(MyForbiddenFansActivity.this.getActivity(), String.valueOf(aVar.id), aVar.name)));
            }
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forbidden_fans_list_layout);
        this.mRootView = (LinearLayout) findViewById(R.id.container_forbidden_fans);
        this.gjv = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gjt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.gjs = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.fCH = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.fCH.setLayoutManager(new LinearLayoutManager(this));
        this.fCH.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.gjv.hasMore() && MyForbiddenFansActivity.this.elw != null && !MyForbiddenFansActivity.this.elw.isLoading()) {
                    MyForbiddenFansActivity.this.elw.startLoadData();
                }
                MyForbiddenFansActivity.this.gjv.bCm();
            }
        });
        this.elw = new PbListView(getActivity());
        this.elw.getView();
        this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elw.setLineGone();
        this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elw.setTextSize(R.dimen.tbfontsize33);
        this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elw.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.elw.aHH();
        this.gju = new b(this);
        this.fCH.setAdapter(this.gju);
        this.gjv.a(this.gjy);
        this.gjw = new e(getPageContext(), getUniqueId());
        this.gjt.setOnClickListener(this.gjz);
        this.gju.n(this.gjB);
        this.gju.w(this.gjA);
        this.gjw.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.gjx == null) {
                            MyForbiddenFansActivity.this.gjx = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.gjx.setGravity(19);
                            MyForbiddenFansActivity.this.gjx.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.gjx.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.gjx.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.gjx.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        MyForbiddenFansActivity.this.gjx.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.gjs.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.gjs.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.gjs.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.gjx, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.gju.dr(j)) {
                                if (MyForbiddenFansActivity.this.gju.bCk()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.gju.getItemCount() > 20 || !MyForbiddenFansActivity.this.gjv.hasMore()) {
                                    MyForbiddenFansActivity.this.ah(MyForbiddenFansActivity.this.gju.getFansList());
                                    MyForbiddenFansActivity.this.gju.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.gjv.bCm();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.gju.dr(j)) {
                    if (MyForbiddenFansActivity.this.gju.bCk()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.gju.getItemCount() > 20 || !MyForbiddenFansActivity.this.gjv.hasMore()) {
                        MyForbiddenFansActivity.this.ah(MyForbiddenFansActivity.this.gju.getFansList());
                        MyForbiddenFansActivity.this.gju.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.gjv.bCm();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bCj() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.gjv.bCl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(ArrayList<a> arrayList) {
        if (!v.isEmpty(arrayList)) {
            this.fCH.setNextPage(this.elw);
            if (this.gjv.hasMore()) {
                this.elw.setText(getString(R.string.pb_load_more));
                this.elw.endLoadData();
                return;
            }
            this.elw.setText(getString(R.string.no_more_data_tip));
            this.elw.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.gjt, (int) R.color.color_remove_all_title);
        this.gju.notifyDataSetChanged();
        this.gjw.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.elw.setTextColor(am.getColor(R.color.cp_cont_d));
        this.elw.changeSkin(i);
        am.setViewTextColor(this.gjx, (int) R.color.cp_cont_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gjv.onDestroy();
        this.gjs.onDestroy();
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
        this.fCH.setVisibility(8);
        this.gjt.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.fCH.setVisibility(0);
        this.gjt.setEnabled(true);
    }
}
