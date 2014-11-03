package com.baidu.tieba.im.selectfriend;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.m;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class SelectFriendActivity extends BaseActivity {
    private LinearLayout aHQ;
    BdListView aJA;
    private o ahX;
    NavigationBar bhL;
    f bis;
    private int bir = -1;
    private CustomMessageListener bit = new a(this, 2001188);
    private AdapterView.OnItemClickListener itemClickListener = new b(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(SelectFriendActivityConfig.class, SelectFriendActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.select_friend_main);
        this.aHQ = (LinearLayout) findViewById(v.select_friend_root_view);
        this.bhL = (NavigationBar) findViewById(v.select_friend_nevigation_bar);
        this.bhL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        this.bhL.setTitleText(y.select_friend_title);
        this.aJA = (BdListView) findViewById(v.select_friend_listview);
        this.bis = new f(this);
        this.aJA.setAdapter((ListAdapter) this.bis);
        this.aJA.setOnItemClickListener(this.itemClickListener);
        registerListener(this.bit);
        MessageManager.getInstance().sendMessage(new GetContactListRequestMessage());
        this.ahX = NoDataViewFactory.a(this, null, r.a(NoDataViewFactory.ImgType.NODATA), s.bL(y.select_friend_no_data_tip), null);
        this.aHQ.addView(this.ahX, 1);
        if (bundle != null) {
            this.bir = bundle.getInt("key_from_where");
        } else if (getIntent() != null) {
            this.bir = getIntent().getIntExtra("key_from_where", -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bhL.onChangeSkinType(i);
        if (this.ahX != null) {
            this.ahX.onChangeSkinType(i);
        }
        getLayoutMode().L(i == 1);
        getLayoutMode().h(findViewById(v.select_friend_root_view));
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.ahX.nv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.ahX.onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, long j, String str, String str2) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.a(new LinearLayout.LayoutParams(m.c(this, t.ds640), -2));
        aVar.bf(shareFromGameCenterMsgData.getTitle());
        com.baidu.tieba.im.mygroup.a aVar2 = new com.baidu.tieba.im.mygroup.a(this);
        aVar2.setData(shareFromGameCenterMsgData);
        aVar.j(aVar2);
        aVar.a(y.share, new d(this, j, shareFromGameCenterMsgData, str, str2, aVar2));
        aVar.b(y.alert_no_button, new e(this, aVar2));
        aVar.P(false);
        aVar.kT().kW();
    }
}
