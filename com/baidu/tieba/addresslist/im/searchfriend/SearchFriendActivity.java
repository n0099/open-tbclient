package com.baidu.tieba.addresslist.im.searchfriend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.addresslist.im.searchfriend.cache.RequestRecommendReadMessage;
import com.baidu.tieba.addresslist.im.searchfriend.j;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class SearchFriendActivity extends BaseActivity<SearchFriendActivity> implements UserIconBox.b {
    private View aHS;
    private j aJl;
    private NavigationBar aJm;
    private BdListView aJn;
    private m aJo;
    private View aJp;
    private j.a aJq = new a(this);
    private com.baidu.adp.framework.listener.e aJr = new b(this, 304106);
    private CustomMessageListener aJs = new c(this, CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND);
    private CustomMessageListener aJt = new d(this, CmdConfigCustom.CMD_REQUEST_RECOMMEND_READ_CACHE);
    private CustomMessageListener aJu = new e(this, CmdConfigCustom.CMD_GET_OFFICIAL_ACCOUNT);
    private final HttpMessageListener aJv = new f(this, CmdConfigHttp.SEARCH_FRIEND_CMD);

    private void Hy() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SEARCH_FRIEND_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.aJv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.activity_search_friend);
        this.aHS = findViewById(n.f.new_search_friend_root_view);
        g gVar = new g(this);
        this.aHS.setOnClickListener(gVar);
        this.aJm = (NavigationBar) findViewById(n.f.new_search_friend_navigation_bar);
        this.aJm.setTitleText(n.i.find_friend);
        this.aJm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new h(this));
        this.aJn = (BdListView) findViewById(n.f.new_search_friend_recommend);
        this.aJn.setOnScrollListener(new i(this));
        this.aJp = LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.g.add_friend_recommend_header, (ViewGroup) null, false);
        this.aJl = new j(getPageContext(), this.aJp);
        this.aJp.setOnClickListener(gVar);
        this.aJl.a(this.aJq);
        this.aJn.addHeaderView(this.aJp);
        this.aJo = new m(this);
        this.aJn.setAdapter((ListAdapter) this.aJo);
        TiebaStatic.log("add_new");
        registerListener(this.aJr);
        registerListener(this.aJs);
        registerListener(this.aJt);
        registerListener(this.aJu);
        sendMessage(new RequestRecommendReadMessage());
        MessageManager.getInstance().registerTask(Bl());
        Hy();
    }

    private SocketMessageTask Bl() {
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
        this.aJm.onChangeSkinType(getPageContext(), i);
        this.aJl.cV(i);
        getLayoutMode().k(this.aJp);
        getLayoutMode().k(this.aHS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aJl.Hz();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        return this.aJn;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int wk() {
        return n.f.recommend_new_crown;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> wl() {
        return UserIconBox.g(getPageContext().getPageActivity(), 8);
    }
}
