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
    private NavigationBar aeS;
    private View apa;
    private j bnP;
    private BdListView bnQ;
    private n bnR;
    private View bnS;
    private m bnT = new a(this);
    private com.baidu.adp.framework.listener.e bnU = new b(this, 304106);
    private CustomMessageListener aDy = new c(this, 2001197);
    private CustomMessageListener bnV = new d(this, 2001199);
    private CustomMessageListener bnW = new e(this, 2001272);
    private final HttpMessageListener bnX = new f(this, CmdConfigHttp.SEARCH_FRIEND_CMD);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(SearchFriendActivityConfig.class, SearchFriendActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001199, new com.baidu.tieba.im.searchfriend.cache.b());
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001198, new com.baidu.tieba.im.searchfriend.cache.c());
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2001272, new com.baidu.tieba.im.searchfriend.cache.a());
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerTask(customMessageTask2);
        MessageManager.getInstance().registerTask(customMessageTask3);
    }

    private void Tb() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SEARCH_FRIEND_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bnX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.activity_search_friend);
        this.apa = findViewById(w.new_search_friend_root_view);
        g gVar = new g(this);
        this.apa.setOnClickListener(gVar);
        this.aeS = (NavigationBar) findViewById(w.new_search_friend_navigation_bar);
        this.aeS.setTitleText(z.find_friend);
        this.aeS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new h(this));
        this.bnQ = (BdListView) findViewById(w.new_search_friend_recommend);
        this.bnQ.setOnScrollListener(new i(this));
        this.bnS = com.baidu.adp.lib.g.b.ei().a(getPageContext().getPageActivity(), x.add_friend_recommend_header, null, false);
        this.bnP = new j(getPageContext(), this.bnS);
        this.bnS.setOnClickListener(gVar);
        this.bnP.a(this.bnT);
        this.bnQ.addHeaderView(this.bnS);
        this.bnR = new n(this);
        this.bnQ.setAdapter((ListAdapter) this.bnR);
        com.baidu.tbadk.core.i.B(TbadkCoreApplication.m255getInst().getApplicationContext(), "add_new");
        registerListener(this.bnU);
        registerListener(this.aDy);
        registerListener(this.bnV);
        registerListener(this.bnW);
        sendMessage(new RequestRecommendReadMessage());
        MessageManager.getInstance().registerTask(uU());
        Tb();
    }

    private SocketMessageTask uU() {
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
        this.aeS.onChangeSkinType(getPageContext(), i);
        this.bnP.cs(i);
        getLayoutMode().h(this.bnS);
        getLayoutMode().h(this.apa);
    }

    @Override // com.baidu.tbadk.core.view.as
    public ListView getListView() {
        return this.bnQ;
    }

    @Override // com.baidu.tbadk.core.view.as
    public int qI() {
        return w.recommend_new_crown;
    }

    @Override // com.baidu.tbadk.core.view.as
    public com.baidu.adp.lib.e.b<TbImageView> qJ() {
        return UserIconBox.g(getPageContext().getPageActivity(), 8);
    }
}
