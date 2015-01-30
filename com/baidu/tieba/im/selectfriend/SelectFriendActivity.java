package com.baidu.tieba.im.selectfriend;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class SelectFriendActivity extends BaseActivity<SelectFriendActivity> {
    private LinearLayout Ae;
    NavigationBar aeV;
    BdListView aeW;
    g bop;
    private CustomMessageListener boq;
    private x mNoDataView;
    private int boo = -1;
    private CustomMessageListener bor = new a(this, 2001188);
    private AdapterView.OnItemClickListener itemClickListener = new b(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(SelectFriendActivityConfig.class, SelectFriendActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.select_friend_main);
        this.Ae = (LinearLayout) findViewById(w.select_friend_root_view);
        this.aeV = (NavigationBar) findViewById(w.select_friend_nevigation_bar);
        this.aeV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        this.aeV.setTitleText(z.select_friend_title);
        this.aeW = (BdListView) findViewById(w.select_friend_listview);
        this.bop = new g(getPageContext().getPageActivity());
        this.aeW.setAdapter((ListAdapter) this.bop);
        this.aeW.setOnItemClickListener(this.itemClickListener);
        registerListener(this.bor);
        MessageManager.getInstance().sendMessage(new GetContactListRequestMessage());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, aa.a(NoDataViewFactory.ImgType.NODATA), ab.cp(z.select_friend_no_data_tip), null);
        this.Ae.addView(this.mNoDataView, 1);
        if (bundle != null) {
            this.boo = bundle.getInt("key_from_where");
        } else if (getIntent() != null) {
            this.boo = getIntent().getIntExtra("key_from_where", -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.boq != null) {
            this.boq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.aeV.onChangeSkinType(getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(findViewById(w.select_friend_root_view));
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mNoDataView.f(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mNoDataView.onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, long j, String str, String str2) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.a(new LinearLayout.LayoutParams(l.d(getPageContext().getPageActivity(), u.ds640), -2));
        aVar.bV(shareFromGameCenterMsgData.getTitle());
        com.baidu.tieba.im.widget.b bVar = new com.baidu.tieba.im.widget.b(getPageContext().getPageActivity());
        bVar.setData(shareFromGameCenterMsgData);
        aVar.j(bVar);
        aVar.a(z.share, new e(this, j, shareFromGameCenterMsgData, str, str2, bVar));
        aVar.b(z.alert_no_button, new f(this, bVar));
        aVar.ai(false);
        aVar.b(getPageContext()).nX();
    }
}
