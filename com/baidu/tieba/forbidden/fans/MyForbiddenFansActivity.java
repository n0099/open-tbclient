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
    private PbListView gAw;
    private BdRecyclerView ipI;
    private NavigationBarCoverTip jbd;
    private TextView jbe;
    private MyForbiddenFansListAdapter jbf;
    private b jbg;
    private d jbh;
    private TextView jbi;
    private b.a jbj = new b.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.1
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
                MyForbiddenFansActivity.this.jbf.aq(arrayList);
                MyForbiddenFansActivity.this.jbf.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener jbk = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                if (view == MyForbiddenFansActivity.this.jbe) {
                    TiebaStatic.log(new ar("c13104").ap("obj_locate", 2));
                    MyForbiddenFansActivity.this.jbh.removeAll();
                    return;
                }
                return;
            }
            MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
        }
    };
    private View.OnClickListener jbl = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isNetOk()) {
                MyForbiddenFansActivity.this.showToast(MyForbiddenFansActivity.this.getString(R.string.neterror));
            } else if (view.getTag() instanceof a) {
                TiebaStatic.log(new ar("c13105"));
                MyForbiddenFansActivity.this.jbh.gn(((a) view.getTag()).id);
            }
        }
    };
    private View.OnClickListener jbm = new View.OnClickListener() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.4
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
        this.jbg = new b();
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navi_forbidden_fans);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.forbidden_fans));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.jbe = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.remove_all_forbidden_fans));
        this.jbd = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_forbidden);
        this.ipI = (BdRecyclerView) findViewById(R.id.listview_forbidden_fans);
        this.ipI.setLayoutManager(new LinearLayoutManager(this));
        this.ipI.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (MyForbiddenFansActivity.this.jbg.hasMore() && MyForbiddenFansActivity.this.gAw != null && !MyForbiddenFansActivity.this.gAw.isLoading()) {
                    MyForbiddenFansActivity.this.gAw.startLoadData();
                }
                MyForbiddenFansActivity.this.jbg.cAH();
            }
        });
        this.gAw = new PbListView(getActivity());
        this.gAw.getView();
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAw.setLineGone();
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAw.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.gAw.bud();
        this.jbf = new MyForbiddenFansListAdapter(this);
        this.ipI.setAdapter(this.jbf);
        this.jbg.a(this.jbj);
        this.jbh = new d(getPageContext(), getUniqueId());
        this.jbe.setOnClickListener(this.jbk);
        this.jbf.p(this.jbm);
        this.jbf.z(this.jbl);
        this.jbh.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity.6
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
                        if (MyForbiddenFansActivity.this.jbi == null) {
                            MyForbiddenFansActivity.this.jbi = new TextView(MyForbiddenFansActivity.this.getActivity());
                            MyForbiddenFansActivity.this.jbi.setGravity(19);
                            MyForbiddenFansActivity.this.jbi.setPadding(l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            MyForbiddenFansActivity.this.jbi.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.tbds112)));
                            MyForbiddenFansActivity.this.jbi.setTextSize(0, l.getDimens(MyForbiddenFansActivity.this.getActivity(), R.dimen.fontsize30));
                            MyForbiddenFansActivity.this.jbi.setTextColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.CAM_X0101));
                        }
                        MyForbiddenFansActivity.this.jbi.setText(str);
                        if (i == 0) {
                            MyForbiddenFansActivity.this.jbd.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            MyForbiddenFansActivity.this.jbd.setBackgroundColor(MyForbiddenFansActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        MyForbiddenFansActivity.this.jbd.a(MyForbiddenFansActivity.this.getActivity(), MyForbiddenFansActivity.this.jbi, 3000);
                    } else if (i2 == 1 && i != 2260104) {
                        if (i == 0) {
                            if (MyForbiddenFansActivity.this.jbf.gm(j)) {
                                if (MyForbiddenFansActivity.this.jbf.cAF()) {
                                    MyForbiddenFansActivity.this.showNoDataView();
                                    return;
                                } else if (MyForbiddenFansActivity.this.jbf.getItemCount() > 20 || !MyForbiddenFansActivity.this.jbg.hasMore()) {
                                    MyForbiddenFansActivity.this.ap(MyForbiddenFansActivity.this.jbf.getFansList());
                                    MyForbiddenFansActivity.this.jbf.notifyDataSetChanged();
                                    return;
                                } else {
                                    MyForbiddenFansActivity.this.jbg.cAH();
                                    return;
                                }
                            }
                            return;
                        }
                        l.showToast(MyForbiddenFansActivity.this.getActivity(), str);
                    }
                } else if (i == 0 && i2 == 1 && MyForbiddenFansActivity.this.jbf.gm(j)) {
                    if (MyForbiddenFansActivity.this.jbf.cAF()) {
                        MyForbiddenFansActivity.this.showNoDataView();
                    } else if (MyForbiddenFansActivity.this.jbf.getItemCount() > 20 || !MyForbiddenFansActivity.this.jbg.hasMore()) {
                        MyForbiddenFansActivity.this.ap(MyForbiddenFansActivity.this.jbf.getFansList());
                        MyForbiddenFansActivity.this.jbf.notifyDataSetChanged();
                    } else {
                        MyForbiddenFansActivity.this.jbg.cAH();
                    }
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void cAE() {
                MyForbiddenFansActivity.this.showLoadingDialog(MyForbiddenFansActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        showProgressBar(true, 0, 0);
        this.jbg.cAG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(ArrayList<a> arrayList) {
        if (!y.isEmpty(arrayList)) {
            this.ipI.setNextPage(this.gAw);
            if (this.jbg.hasMore()) {
                this.gAw.setText(getString(R.string.pb_load_more));
                this.gAw.endLoadData();
                return;
            }
            this.gAw.setText(getString(R.string.no_more_data_tip));
            this.gAw.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.jbe, R.color.color_remove_all_title);
        this.jbf.notifyDataSetChanged();
        this.jbh.onChangeSkinType();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gAw.changeSkin(i);
        ap.setViewTextColor(this.jbi, R.color.CAM_X0101);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jbg.onDestroy();
        this.jbd.onDestroy();
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
        this.ipI.setVisibility(8);
        this.jbe.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.ipI.setVisibility(0);
        this.jbe.setEnabled(true);
    }
}
