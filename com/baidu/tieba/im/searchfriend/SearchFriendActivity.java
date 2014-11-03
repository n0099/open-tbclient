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
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.im.searchfriend.cache.RequestRecommendReadMessage;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class SearchFriendActivity extends BaseActivity implements ae {
    private View agS;
    private NavigationBar bhL;
    private h bhR;
    private BdListView bhS;
    private l bhT;
    private View bhU;
    private k bhV = new a(this);
    private com.baidu.adp.framework.listener.e bhW = new b(this, 304106);
    private CustomMessageListener aAZ = new c(this, 2001197);
    private CustomMessageListener bhX = new d(this, 2001199);
    private final HttpMessageListener bhY = new e(this, CmdConfigHttp.SEARCH_FRIEND_CMD);

    static {
        TbadkApplication.m251getInst().RegisterIntent(SearchFriendActivityConfig.class, SearchFriendActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001199, new com.baidu.tieba.im.searchfriend.cache.a());
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001198, new com.baidu.tieba.im.searchfriend.cache.b());
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    private void Rx() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SEARCH_FRIEND_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bhY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.activity_search_friend);
        this.agS = findViewById(v.new_search_friend_root_view);
        f fVar = new f(this);
        this.agS.setOnClickListener(fVar);
        this.bhL = (NavigationBar) findViewById(v.new_search_friend_navigation_bar);
        this.bhL.setTitleText(y.find_friend);
        this.bhL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.bhS = (BdListView) findViewById(v.new_search_friend_recommend);
        this.bhU = com.baidu.adp.lib.g.b.ek().a(this, w.add_friend_recommend_header, null, false);
        this.bhR = new h(this, this.bhU);
        this.bhU.setOnClickListener(fVar);
        this.bhR.a(this.bhV);
        this.bhS.addHeaderView(this.bhU);
        this.bhT = new l(this);
        this.bhS.setAdapter((ListAdapter) this.bhT);
        com.baidu.tbadk.core.j.m(TbadkApplication.m251getInst().getApplicationContext(), "add_new");
        registerListener(this.bhW);
        registerListener(this.aAZ);
        registerListener(this.bhX);
        sendMessage(new RequestRecommendReadMessage());
        MessageManager.getInstance().registerTask(ri());
        Rx();
    }

    private SocketMessageTask ri() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(304106);
        socketMessageTask.e(true);
        socketMessageTask.setResponsedClass(ResponsedRecommendMessage.class);
        socketMessageTask.f(false);
        return socketMessageTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bhL.onChangeSkinType(i);
        this.bhR.bM(i);
        getLayoutMode().h(this.bhU);
        getLayoutMode().h(this.agS);
    }

    @Override // com.baidu.tbadk.core.view.ae
    public ListView getListView() {
        return this.bhS;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public int nC() {
        return v.recommend_new_crown;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public com.baidu.adp.lib.e.b<TbImageView> nD() {
        return UserIconBox.f(this, 8);
    }
}
