package com.baidu.tieba.history;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.List;
/* loaded from: classes.dex */
public class PbHistoryActivity extends BaseActivity<PbHistoryActivity> {
    private com.baidu.tbadk.b.a aNT;
    private final com.baidu.tbadk.mvc.model.d<com.baidu.tbadk.b.b> adP = new a(this);
    private RelativeLayout apl;
    private com.baidu.tbadk.mvc.j.c<com.baidu.tbadk.b.b, com.baidu.tbadk.mvc.e.c, f> asM;
    private TextView mEditBtn;
    private BdListView mListView;
    private NavigationBar mNavigationBar;

    static {
        TbadkApplication.getInst().RegisterIntent(PbHistoryActivityConfig.class, PbHistoryActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aNT = new com.baidu.tbadk.b.a(this);
        this.aNT.a(this.adP);
        this.apl = (RelativeLayout) com.baidu.adp.lib.g.b.ek().inflate(getPageContext().getPageActivity(), x.pb_history_activity, null);
        setContentView(this.apl);
        this.mNavigationBar = (NavigationBar) findViewById(w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(z.my_history);
        this.mEditBtn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(z.delete_all_user_chat));
        this.mEditBtn.setOnClickListener(new b(this));
        this.mEditBtn.setVisibility(8);
        this.mListView = (BdListView) findViewById(w.list);
        this.asM = new com.baidu.tbadk.mvc.j.c<>(getPageContext(), f.class, x.pb_history_list_item, null);
        this.asM.a(aa.a(NoDataViewFactory.ImgType.NODATA), ab.t(z.pb_history_no_data_tip, z.pb_history_no_data_tip_2), (com.baidu.tbadk.core.view.z) null, (FrameLayout.LayoutParams) null);
        this.mListView.setAdapter((ListAdapter) this.asM);
        this.mListView.setOnItemClickListener(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        IX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.asM.a(getPageContext(), i);
        getLayoutMode().h(this.apl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IX() {
        this.aNT.xn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(List<com.baidu.tbadk.b.b> list) {
        if (this.asM != null) {
            this.asM.w(list);
        }
        if (list == null || list.size() == 0) {
            this.mEditBtn.setVisibility(8);
        } else {
            this.mEditBtn.setVisibility(0);
        }
    }
}
