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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
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
    private PbListView fnt;
    private BdRecyclerView gJM;
    private NavigationBarCoverTip hut;
    private TextView huu;
    private b huv;
    private c huw;
    private e hux;
    private TextView huy;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private LinearLayout mRootView;
    private c.a huz = new c.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
        @Override // com.baidu.tieba.forbidden.fans.c.a
        public void b(int i, String str, ArrayList<a> arrayList) {
            if (MyForbiddenFansActivity.this.isProgressBarShown()) {
                MyForbiddenFansActivity.this.hideProgressBar();
            }
            if (i != 0) {
                MyForbiddenFansActivity.this.showToast(str);
            }
            if (w.isEmpty(arrayList)) {
                MyForbiddenFansActivity.this.showNoDataView();
            } else if (i == 0) {
                MyForbiddenFansActivity.this.hideNoDataView();
                MyForbiddenFansActivity.this.aj(arrayList);
                MyForbiddenFansActivity.this.huv.ak(arrayList);
                MyForbiddenFansActivity.this.huv.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener huA = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.huu) {
                    TiebaStatic.log(new ao("c13104").ag("obj_locate", 2));
                    MyForbiddenFansActivity.this.hux.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener huB = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new ao("c13105"));
                MyForbiddenFansActivity.this.hux.ef(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener huC = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.huw = new c();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.huu = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.hut = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.gJM = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.gJM.setLayoutManager(new LinearLayoutManager(this));
        this.gJM.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.huw.hasMore() && MyForbiddenFansActivity.this.fnt != null && !MyForbiddenFansActivity.this.fnt.isLoading()) {
                    MyForbiddenFansActivity.this.fnt.startLoadData();
                }
                MyForbiddenFansActivity.this.huw.bWl();
            }
        });
        this.fnt = new PbListView(getActivity());
        this.fnt.getView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setLineGone();
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fnt.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.fnt.aXZ();
        this.huv = new b(this);
        this.gJM.setAdapter(this.huv);
        this.huw.a(this.huz);
        this.hux = new e(getPageContext(), getUniqueId());
        this.huu.setOnClickListener(this.huA);
        this.huv.n(this.huC);
        this.huv.x(this.huB);
        this.hux.a(new e.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.huy == null) {
                            MyForbiddenFansActivity.this.huy = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.huy.setGravity(19);
                            MyForbiddenFansActivity.this.huy.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.huy.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.huy.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.huy.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        MyForbiddenFansActivity.this.huy.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.hut.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.hut.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.hut.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.huy, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.huv.ee(j)) {
                                if (MyForbiddenFansActivity.this.huv.bWj()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.huv.getItemCount() > 20 || !MyForbiddenFansActivity.this.huw.hasMore()) {
                                    MyForbiddenFansActivity.this.aj(MyForbiddenFansActivity.this.huv.getFansList());
                                    MyForbiddenFansActivity.this.huv.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.huw.bWl();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.huv.ee(j)) {
                    if (MyForbiddenFansActivity.this.huv.bWj()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.huv.getItemCount() > 20 || !MyForbiddenFansActivity.this.huw.hasMore()) {
                        MyForbiddenFansActivity.this.aj(MyForbiddenFansActivity.this.huv.getFansList());
                        MyForbiddenFansActivity.this.huv.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.huw.bWl();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bWi() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.huw.bWk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(ArrayList<a> arrayList) {
        if (!w.isEmpty(arrayList)) {
            this.gJM.setNextPage(this.fnt);
            if (this.huw.hasMore()) {
                this.fnt.setText(getString(R.string.pb_load_more));
                this.fnt.endLoadData();
                return;
            }
            this.fnt.setText(getString(R.string.no_more_data_tip));
            this.fnt.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        an.setViewTextColor(this.huu, (int) R.color.color_remove_all_title);
        this.huv.notifyDataSetChanged();
        this.hux.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
        this.fnt.changeSkin(i);
        an.setViewTextColor(this.huy, (int) R.color.cp_cont_a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.huw.onDestroy();
        this.hut.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds120)), null, null);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.mm(R.string.no_forbidden_fans));
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_f);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.gJM.setVisibility(8);
        this.huu.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.gJM.setVisibility(0);
        this.huu.setEnabled(true);
    }
}
