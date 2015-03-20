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
    private NavigationBar anm;
    private View axu;
    private j ayN;
    private BdListView ayO;
    private n ayP;
    private View ayQ;
    private m ayR = new a(this);
    private com.baidu.adp.framework.listener.e ayS = new b(this, 304106);
    private CustomMessageListener ayT = new c(this, 2001197);
    private CustomMessageListener ayU = new d(this, 2001199);
    private CustomMessageListener ayV = new e(this, 2001272);
    private final HttpMessageListener ayW = new f(this, CmdConfigHttp.SEARCH_FRIEND_CMD);

    private void Fe() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SEARCH_FRIEND_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.ayW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.activity_search_friend);
        this.axu = findViewById(com.baidu.tieba.v.new_search_friend_root_view);
        g gVar = new g(this);
        this.axu.setOnClickListener(gVar);
        this.anm = (NavigationBar) findViewById(com.baidu.tieba.v.new_search_friend_navigation_bar);
        this.anm.setTitleText(y.find_friend);
        this.anm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new h(this));
        this.ayO = (BdListView) findViewById(com.baidu.tieba.v.new_search_friend_recommend);
        this.ayO.setOnScrollListener(new i(this));
        this.ayQ = com.baidu.adp.lib.g.b.hH().a(getPageContext().getPageActivity(), w.add_friend_recommend_header, null, false);
        this.ayN = new j(getPageContext(), this.ayQ);
        this.ayQ.setOnClickListener(gVar);
        this.ayN.a(this.ayR);
        this.ayO.addHeaderView(this.ayQ);
        this.ayP = new n(this);
        this.ayO.setAdapter((ListAdapter) this.ayP);
        com.baidu.tbadk.core.k.B(TbadkCoreApplication.m411getInst().getApplicationContext(), "add_new");
        registerListener(this.ayS);
        registerListener(this.ayT);
        registerListener(this.ayU);
        registerListener(this.ayV);
        sendMessage(new RequestRecommendReadMessage());
        MessageManager.getInstance().registerTask(yk());
        Fe();
    }

    private SocketMessageTask yk() {
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
        this.anm.onChangeSkinType(getPageContext(), i);
        this.ayN.ct(i);
        getLayoutMode().h(this.ayQ);
        getLayoutMode().h(this.axu);
    }

    @Override // com.baidu.tbadk.core.view.ao
    public ListView getListView() {
        return this.ayO;
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
