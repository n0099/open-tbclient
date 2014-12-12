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
import com.baidu.tbadk.core.view.ar;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.im.searchfriend.cache.RequestRecommendReadMessage;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class SearchFriendActivity extends BaseActivity<SearchFriendActivity> implements ar {
    private NavigationBar aey;
    private View aoi;
    private j bmt;
    private BdListView bmu;
    private n bmv;
    private View bmw;
    private m bmx = new a(this);
    private com.baidu.adp.framework.listener.e bmy = new b(this, 304106);
    private CustomMessageListener aCA = new c(this, 2001197);
    private CustomMessageListener bmz = new d(this, 2001199);
    private CustomMessageListener bmA = new e(this, 2001272);
    private final HttpMessageListener bmB = new f(this, CmdConfigHttp.SEARCH_FRIEND_CMD);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(SearchFriendActivityConfig.class, SearchFriendActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001199, new com.baidu.tieba.im.searchfriend.cache.b());
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001198, new com.baidu.tieba.im.searchfriend.cache.c());
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2001272, new com.baidu.tieba.im.searchfriend.cache.a());
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerTask(customMessageTask2);
        MessageManager.getInstance().registerTask(customMessageTask3);
    }

    private void SK() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SEARCH_FRIEND_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bmB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.activity_search_friend);
        this.aoi = findViewById(w.new_search_friend_root_view);
        g gVar = new g(this);
        this.aoi.setOnClickListener(gVar);
        this.aey = (NavigationBar) findViewById(w.new_search_friend_navigation_bar);
        this.aey.setTitleText(z.find_friend);
        this.aey.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new h(this));
        this.bmu = (BdListView) findViewById(w.new_search_friend_recommend);
        this.bmu.setOnScrollListener(new i(this));
        this.bmw = com.baidu.adp.lib.g.b.ek().a(getPageContext().getPageActivity(), x.add_friend_recommend_header, null, false);
        this.bmt = new j(getPageContext(), this.bmw);
        this.bmw.setOnClickListener(gVar);
        this.bmt.a(this.bmx);
        this.bmu.addHeaderView(this.bmw);
        this.bmv = new n(this);
        this.bmu.setAdapter((ListAdapter) this.bmv);
        com.baidu.tbadk.core.i.C(TbadkCoreApplication.m255getInst().getApplicationContext(), "add_new");
        registerListener(this.bmy);
        registerListener(this.aCA);
        registerListener(this.bmz);
        registerListener(this.bmA);
        sendMessage(new RequestRecommendReadMessage());
        MessageManager.getInstance().registerTask(uJ());
        SK();
    }

    private SocketMessageTask uJ() {
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
        this.aey.onChangeSkinType(getPageContext(), i);
        this.bmt.cl(i);
        getLayoutMode().h(this.bmw);
        getLayoutMode().h(this.aoi);
    }

    @Override // com.baidu.tbadk.core.view.ar
    public ListView getListView() {
        return this.bmu;
    }

    @Override // com.baidu.tbadk.core.view.ar
    public int qD() {
        return w.recommend_new_crown;
    }

    @Override // com.baidu.tbadk.core.view.ar
    public com.baidu.adp.lib.e.b<TbImageView> qE() {
        return UserIconBox.g(getPageContext().getPageActivity(), 8);
    }
}
