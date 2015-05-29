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
    private j aAG;
    private BdListView aAH;
    private n aAI;
    private View aAJ;
    private m aAK = new a(this);
    private com.baidu.adp.framework.listener.e aAL = new b(this, 304106);
    private CustomMessageListener aAM = new c(this, 2001197);
    private CustomMessageListener aAN = new d(this, 2001199);
    private CustomMessageListener aAO = new e(this, 2001272);
    private final HttpMessageListener aAP = new f(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private NavigationBar aox;
    private View azo;

    private void Gd() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SEARCH_FRIEND_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.aAP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.r.activity_search_friend);
        this.azo = findViewById(com.baidu.tieba.q.new_search_friend_root_view);
        g gVar = new g(this);
        this.azo.setOnClickListener(gVar);
        this.aox = (NavigationBar) findViewById(com.baidu.tieba.q.new_search_friend_navigation_bar);
        this.aox.setTitleText(com.baidu.tieba.t.find_friend);
        this.aox.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new h(this));
        this.aAH = (BdListView) findViewById(com.baidu.tieba.q.new_search_friend_recommend);
        this.aAH.setOnScrollListener(new i(this));
        this.aAJ = com.baidu.adp.lib.g.b.hr().a(getPageContext().getPageActivity(), com.baidu.tieba.r.add_friend_recommend_header, null, false);
        this.aAG = new j(getPageContext(), this.aAJ);
        this.aAJ.setOnClickListener(gVar);
        this.aAG.a(this.aAK);
        this.aAH.addHeaderView(this.aAJ);
        this.aAI = new n(this);
        this.aAH.setAdapter((ListAdapter) this.aAI);
        com.baidu.tbadk.core.k.B(TbadkCoreApplication.m411getInst().getApplicationContext(), "add_new");
        registerListener(this.aAL);
        registerListener(this.aAM);
        registerListener(this.aAN);
        registerListener(this.aAO);
        sendMessage(new RequestRecommendReadMessage());
        MessageManager.getInstance().registerTask(zd());
        Gd();
    }

    private SocketMessageTask zd() {
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
        this.aAG.cy(i);
        getLayoutMode().j(this.aAJ);
        getLayoutMode().j(this.azo);
    }

    @Override // com.baidu.tbadk.core.view.at
    public ListView getListView() {
        return this.aAH;
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
