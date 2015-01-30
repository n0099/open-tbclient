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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.as;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.im.searchfriend.cache.RequestRecommendReadMessage;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class SearchFriendActivity extends BaseActivity<SearchFriendActivity> implements as {
    private NavigationBar aeV;
    private View apd;
    private j bnQ;
    private BdListView bnR;
    private n bnS;
    private View bnT;
    private m bnU = new a(this);
    private com.baidu.adp.framework.listener.e bnV = new b(this, 304106);
    private CustomMessageListener aDB = new c(this, 2001197);
    private CustomMessageListener bnW = new d(this, 2001199);
    private CustomMessageListener bnX = new e(this, 2001272);
    private final HttpMessageListener bnY = new f(this, CmdConfigHttp.SEARCH_FRIEND_CMD);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(SearchFriendActivityConfig.class, SearchFriendActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001199, new com.baidu.tieba.im.searchfriend.cache.b());
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001198, new com.baidu.tieba.im.searchfriend.cache.c());
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2001272, new com.baidu.tieba.im.searchfriend.cache.a());
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerTask(customMessageTask2);
        MessageManager.getInstance().registerTask(customMessageTask3);
    }

    private void Tg() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SEARCH_FRIEND_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bnY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.activity_search_friend);
        this.apd = findViewById(w.new_search_friend_root_view);
        g gVar = new g(this);
        this.apd.setOnClickListener(gVar);
        this.aeV = (NavigationBar) findViewById(w.new_search_friend_navigation_bar);
        this.aeV.setTitleText(z.find_friend);
        this.aeV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new h(this));
        this.bnR = (BdListView) findViewById(w.new_search_friend_recommend);
        this.bnR.setOnScrollListener(new i(this));
        this.bnT = com.baidu.adp.lib.g.b.ei().a(getPageContext().getPageActivity(), x.add_friend_recommend_header, null, false);
        this.bnQ = new j(getPageContext(), this.bnT);
        this.bnT.setOnClickListener(gVar);
        this.bnQ.a(this.bnU);
        this.bnR.addHeaderView(this.bnT);
        this.bnS = new n(this);
        this.bnR.setAdapter((ListAdapter) this.bnS);
        com.baidu.tbadk.core.i.B(TbadkCoreApplication.m255getInst().getApplicationContext(), "add_new");
        registerListener(this.bnV);
        registerListener(this.aDB);
        registerListener(this.bnW);
        registerListener(this.bnX);
        sendMessage(new RequestRecommendReadMessage());
        MessageManager.getInstance().registerTask(va());
        Tg();
    }

    private SocketMessageTask va() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(304106);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(ResponsedRecommendMessage.class);
        socketMessageTask.j(false);
        return socketMessageTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aeV.onChangeSkinType(getPageContext(), i);
        this.bnQ.cs(i);
        getLayoutMode().h(this.bnT);
        getLayoutMode().h(this.apd);
    }

    @Override // com.baidu.tbadk.core.view.as
    public ListView getListView() {
        return this.bnR;
    }

    @Override // com.baidu.tbadk.core.view.as
    public int qO() {
        return w.recommend_new_crown;
    }

    @Override // com.baidu.tbadk.core.view.as
    public com.baidu.adp.lib.e.b<TbImageView> qP() {
        return UserIconBox.g(getPageContext().getPageActivity(), 8);
    }
}
