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
    private View agJ;
    private h bhD;
    private BdListView bhE;
    private l bhF;
    private View bhG;
    private NavigationBar bhx;
    private k bhH = new a(this);
    private com.baidu.adp.framework.listener.e bhI = new b(this, 304106);
    private CustomMessageListener aAP = new c(this, 2001197);
    private CustomMessageListener bhJ = new d(this, 2001199);
    private final HttpMessageListener bhK = new e(this, CmdConfigHttp.SEARCH_FRIEND_CMD);

    static {
        TbadkApplication.m251getInst().RegisterIntent(SearchFriendActivityConfig.class, SearchFriendActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001199, new com.baidu.tieba.im.searchfriend.cache.a());
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001198, new com.baidu.tieba.im.searchfriend.cache.b());
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    private void Ru() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SEARCH_FRIEND_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bhK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.activity_search_friend);
        this.agJ = findViewById(v.new_search_friend_root_view);
        f fVar = new f(this);
        this.agJ.setOnClickListener(fVar);
        this.bhx = (NavigationBar) findViewById(v.new_search_friend_navigation_bar);
        this.bhx.setTitleText(y.find_friend);
        this.bhx.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.bhE = (BdListView) findViewById(v.new_search_friend_recommend);
        this.bhG = com.baidu.adp.lib.g.b.ek().a(this, w.add_friend_recommend_header, null, false);
        this.bhD = new h(this, this.bhG);
        this.bhG.setOnClickListener(fVar);
        this.bhD.a(this.bhH);
        this.bhE.addHeaderView(this.bhG);
        this.bhF = new l(this);
        this.bhE.setAdapter((ListAdapter) this.bhF);
        com.baidu.tbadk.core.i.m(TbadkApplication.m251getInst().getApplicationContext(), "add_new");
        registerListener(this.bhI);
        registerListener(this.aAP);
        registerListener(this.bhJ);
        sendMessage(new RequestRecommendReadMessage());
        MessageManager.getInstance().registerTask(rg());
        Ru();
    }

    private SocketMessageTask rg() {
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
        this.bhx.onChangeSkinType(i);
        this.bhD.bM(i);
        getLayoutMode().h(this.bhG);
        getLayoutMode().h(this.agJ);
    }

    @Override // com.baidu.tbadk.core.view.ae
    public ListView getListView() {
        return this.bhE;
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
