package com.baidu.tieba.addresslist.im.searchfriend;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.at;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.addresslist.im.searchfriend.cache.RequestRecommendReadMessage;
/* loaded from: classes.dex */
public class SearchFriendActivity extends BaseActivity<SearchFriendActivity> implements at {
    private j aAH;
    private BdListView aAI;
    private n aAJ;
    private View aAK;
    private m aAL = new a(this);
    private com.baidu.adp.framework.listener.e aAM = new b(this, 304106);
    private CustomMessageListener aAN = new c(this, 2001197);
    private CustomMessageListener aAO = new d(this, 2001199);
    private CustomMessageListener aAP = new e(this, 2001272);
    private final HttpMessageListener aAQ = new f(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private NavigationBar aox;
    private View azp;

    private void Ge() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SEARCH_FRIEND_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.aAQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.r.activity_search_friend);
        this.azp = findViewById(com.baidu.tieba.q.new_search_friend_root_view);
        g gVar = new g(this);
        this.azp.setOnClickListener(gVar);
        this.aox = (NavigationBar) findViewById(com.baidu.tieba.q.new_search_friend_navigation_bar);
        this.aox.setTitleText(com.baidu.tieba.t.find_friend);
        this.aox.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new h(this));
        this.aAI = (BdListView) findViewById(com.baidu.tieba.q.new_search_friend_recommend);
        this.aAI.setOnScrollListener(new i(this));
        this.aAK = com.baidu.adp.lib.g.b.hr().a(getPageContext().getPageActivity(), com.baidu.tieba.r.add_friend_recommend_header, null, false);
        this.aAH = new j(getPageContext(), this.aAK);
        this.aAK.setOnClickListener(gVar);
        this.aAH.a(this.aAL);
        this.aAI.addHeaderView(this.aAK);
        this.aAJ = new n(this);
        this.aAI.setAdapter((ListAdapter) this.aAJ);
        com.baidu.tbadk.core.k.B(TbadkCoreApplication.m411getInst().getApplicationContext(), "add_new");
        registerListener(this.aAM);
        registerListener(this.aAN);
        registerListener(this.aAO);
        registerListener(this.aAP);
        sendMessage(new RequestRecommendReadMessage());
        MessageManager.getInstance().registerTask(ze());
        Ge();
    }

    private SocketMessageTask ze() {
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
        this.aox.onChangeSkinType(getPageContext(), i);
        this.aAH.cy(i);
        getLayoutMode().j(this.aAK);
        getLayoutMode().j(this.azp);
    }

    @Override // com.baidu.tbadk.core.view.at
    public ListView getListView() {
        return this.aAI;
    }

    @Override // com.baidu.tbadk.core.view.at
    public int uB() {
        return com.baidu.tieba.q.recommend_new_crown;
    }

    @Override // com.baidu.tbadk.core.view.at
    public com.baidu.adp.lib.e.b<TbImageView> uC() {
        return UserIconBox.g(getPageContext().getPageActivity(), 8);
    }
}
