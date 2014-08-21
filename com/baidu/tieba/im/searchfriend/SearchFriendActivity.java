package com.baidu.tieba.im.searchfriend;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bs;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.im.searchfriend.cache.RequestRecommendReadMessage;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class SearchFriendActivity extends BaseActivity implements ab {
    private h a;
    private NavigationBar b;
    private BdListView c;
    private l d;
    private View e;
    private View f;
    private k g = new a(this);
    private com.baidu.adp.framework.listener.d h = new b(this, 304106);
    private CustomMessageListener i = new c(this, 2001197);
    private CustomMessageListener j = new d(this, 2001199);
    private final HttpMessageListener k = new e(this, CmdConfigHttp.SEARCH_FRIEND_CMD);

    static {
        TbadkApplication.m252getInst().RegisterIntent(bs.class, SearchFriendActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001199, new com.baidu.tieba.im.searchfriend.cache.a());
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001198, new com.baidu.tieba.im.searchfriend.cache.b());
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    private void d() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SEARCH_FRIEND_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(v.activity_search_friend);
        this.e = findViewById(u.new_search_friend_root_view);
        f fVar = new f(this);
        this.e.setOnClickListener(fVar);
        this.b = (NavigationBar) findViewById(u.new_search_friend_navigation_bar);
        this.b.a(x.find_friend);
        this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.c = (BdListView) findViewById(u.new_search_friend_recommend);
        this.f = com.baidu.adp.lib.e.b.a().a(this, v.add_friend_recommend_header, null, false);
        this.a = new h(this, this.f);
        this.f.setOnClickListener(fVar);
        this.a.a(this.g);
        this.c.addHeaderView(this.f);
        this.d = new l(this);
        this.c.setAdapter((ListAdapter) this.d);
        com.baidu.tbadk.core.f.b(TbadkApplication.m252getInst().getApplicationContext(), "add_new");
        registerListener(this.h);
        registerListener(this.i);
        registerListener(this.j);
        sendMessage(new RequestRecommendReadMessage());
        MessageManager.getInstance().registerTask(e());
        d();
    }

    private SocketMessageTask e() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(304106);
        socketMessageTask.a(true);
        socketMessageTask.a(ResponsedRecommendMessage.class);
        socketMessageTask.b(false);
        return socketMessageTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.c(i);
        this.a.a(i);
        getLayoutMode().a(this.f);
        getLayoutMode().a(this.e);
    }

    @Override // com.baidu.tbadk.core.view.ab
    public ListView a() {
        return this.c;
    }

    @Override // com.baidu.tbadk.core.view.ab
    public int c_() {
        return u.recommend_new_crown;
    }

    @Override // com.baidu.tbadk.core.view.ab
    public com.baidu.adp.lib.d.b<TbImageView> c() {
        return UserIconBox.a(this, 8);
    }
}
