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
import com.baidu.tbadk.core.view.ao;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.addresslist.im.searchfriend.cache.RequestRecommendReadMessage;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class SearchFriendActivity extends BaseActivity<SearchFriendActivity> implements ao {
    private NavigationBar anu;
    private View axC;
    private j ayV;
    private BdListView ayW;
    private n ayX;
    private View ayY;
    private m ayZ = new a(this);
    private com.baidu.adp.framework.listener.e aza = new b(this, 304106);
    private CustomMessageListener azb = new c(this, 2001197);
    private CustomMessageListener azc = new d(this, 2001199);
    private CustomMessageListener azd = new e(this, 2001272);
    private final HttpMessageListener aze = new f(this, CmdConfigHttp.SEARCH_FRIEND_CMD);

    private void Fk() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SEARCH_FRIEND_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.aze);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.activity_search_friend);
        this.axC = findViewById(com.baidu.tieba.v.new_search_friend_root_view);
        g gVar = new g(this);
        this.axC.setOnClickListener(gVar);
        this.anu = (NavigationBar) findViewById(com.baidu.tieba.v.new_search_friend_navigation_bar);
        this.anu.setTitleText(y.find_friend);
        this.anu.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new h(this));
        this.ayW = (BdListView) findViewById(com.baidu.tieba.v.new_search_friend_recommend);
        this.ayW.setOnScrollListener(new i(this));
        this.ayY = com.baidu.adp.lib.g.b.hH().a(getPageContext().getPageActivity(), w.add_friend_recommend_header, null, false);
        this.ayV = new j(getPageContext(), this.ayY);
        this.ayY.setOnClickListener(gVar);
        this.ayV.a(this.ayZ);
        this.ayW.addHeaderView(this.ayY);
        this.ayX = new n(this);
        this.ayW.setAdapter((ListAdapter) this.ayX);
        com.baidu.tbadk.core.k.B(TbadkCoreApplication.m411getInst().getApplicationContext(), "add_new");
        registerListener(this.aza);
        registerListener(this.azb);
        registerListener(this.azc);
        registerListener(this.azd);
        sendMessage(new RequestRecommendReadMessage());
        MessageManager.getInstance().registerTask(yq());
        Fk();
    }

    private SocketMessageTask yq() {
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
        this.anu.onChangeSkinType(getPageContext(), i);
        this.ayV.ct(i);
        getLayoutMode().h(this.ayY);
        getLayoutMode().h(this.axC);
    }

    @Override // com.baidu.tbadk.core.view.ao
    public ListView getListView() {
        return this.ayW;
    }

    @Override // com.baidu.tbadk.core.view.ao
    public int tS() {
        return com.baidu.tieba.v.recommend_new_crown;
    }

    @Override // com.baidu.tbadk.core.view.ao
    public com.baidu.adp.lib.e.b<TbImageView> tT() {
        return UserIconBox.g(getPageContext().getPageActivity(), 8);
    }
}
