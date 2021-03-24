package com.baidu.tieba.addresslist.im.searchfriend;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.data.SearchFriendResult;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.i0.q.e.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class SearchFriendActivity extends BaseActivity<SearchFriendActivity> implements UserIconBox.c {
    public static final String HTTP_PARAMS_SEARCH_KEY = "search_key";
    public View mParentView;
    public NavigationBar navigationBar;
    public d.b.i0.q.e.b.a searchBar;
    public View searchView;
    public a.c searchBarCallback = new a();
    public CustomMessageListener getOfficialAccountListener = new b(2001265);
    public final HttpMessageListener mRequestSearchFriendListener = new c(CmdConfigHttp.SEARCH_FRIEND_CMD);

    /* loaded from: classes4.dex */
    public class a implements a.c {
        public a() {
        }

        @Override // d.b.i0.q.e.b.a.c
        public void a(String str) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
            httpMessage.addParam(SearchFriendActivity.HTTP_PARAMS_SEARCH_KEY, str);
            SearchFriendActivity.this.sendMessage(httpMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SearchFriendResult.UserInfo userInfo;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ArrayList) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage)) {
                CustomMessage customMessage = (CustomMessage) customResponsedMessage.getOrginalMessage();
                if ((customMessage.getData() instanceof SearchFriendResult.UserInfo) && (userInfo = (SearchFriendResult.UserInfo) customMessage.getData()) != null) {
                    ArrayList arrayList = (ArrayList) customResponsedMessage.getData();
                    if (arrayList != null && arrayList.size() != 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if ((next instanceof d.b.h0.s.f.a) && userInfo.getUserId() == ((d.b.h0.s.f.a) next).e()) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(SearchFriendActivity.this.getPageContext().getPageActivity(), userInfo.getUserId(), userInfo.getUserName(), userInfo.getPortrait(), 0, 4)));
                                return;
                            }
                        }
                        SearchFriendActivity.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(SearchFriendActivity.this.getPageContext().getPageActivity(), String.valueOf(userInfo.getUserId()), userInfo.getUserName(), null, "search")));
                        return;
                    }
                    SearchFriendActivity.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(SearchFriendActivity.this.getPageContext().getPageActivity(), String.valueOf(userInfo.getUserId()), userInfo.getUserName(), null, "search")));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends HttpMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001521) {
                return;
            }
            SearchFriendActivity.this.searchBar.j(true);
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (httpResponsedMessage instanceof ResponseSearchFriendMessage) {
                ResponseSearchFriendMessage responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                    List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                    if (userInfo != null && userInfo.size() > 0) {
                        SearchFriendActivity.this.searchBar.k(null);
                        SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                        if (userInfo2 == null) {
                            SearchFriendActivity searchFriendActivity = SearchFriendActivity.this;
                            searchFriendActivity.showToast(searchFriendActivity.getPageContext().getString(R.string.neterror));
                            return;
                        }
                        SearchFriendActivity.this.sendMessage(new CustomMessage(2001265, userInfo2));
                        return;
                    }
                    SearchFriendActivity searchFriendActivity2 = SearchFriendActivity.this;
                    searchFriendActivity2.showToast(searchFriendActivity2.getPageContext().getString(R.string.neterror));
                } else if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    SearchFriendActivity searchFriendActivity3 = SearchFriendActivity.this;
                    searchFriendActivity3.showToast(searchFriendActivity3.getPageContext().getString(R.string.neterror));
                } else {
                    SearchFriendActivity.this.showToast(httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchFriendActivity.this.searchBar.g();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchFriendActivity.this.finish();
        }
    }

    private void registerSearchPersonTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SEARCH_FRIEND_CMD, TbConfig.SERVER_ADDRESS + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.mRequestSearchFriendListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public d.b.b.e.k.b<TbImageView> getUserIconPool() {
        return UserIconBox.c(getPageContext().getPageActivity(), 8);
    }

    public int getUserIconViewId() {
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.navigationBar.onChangeSkinType(getPageContext(), i);
        this.searchBar.f(i);
        getLayoutMode().j(this.searchView);
        getLayoutMode().j(this.mParentView);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_friend);
        this.mParentView = findViewById(R.id.new_search_friend_root_view);
        d dVar = new d();
        this.mParentView.setOnClickListener(dVar);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.new_search_friend_navigation_bar);
        this.navigationBar = navigationBar;
        navigationBar.setTitleText(R.string.find_new_friend);
        this.navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e());
        this.searchView = findViewById(R.id.new_search_friend_search_container);
        this.searchBar = new d.b.i0.q.e.b.a(getPageContext(), this.searchView);
        this.searchView.setOnClickListener(dVar);
        this.searchBar.l(this.searchBarCallback);
        TiebaStatic.log("add_new");
        registerListener(this.getOfficialAccountListener);
        registerSearchPersonTask();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.searchBar.h();
    }
}
