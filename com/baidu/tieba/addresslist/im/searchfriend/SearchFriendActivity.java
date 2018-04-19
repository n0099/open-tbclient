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
import com.baidu.adp.lib.e.b;
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
import com.baidu.tieba.addresslist.im.searchfriend.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class SearchFriendActivity extends BaseActivity<SearchFriendActivity> implements UserIconBox.b {
    private View bee;
    private a.InterfaceC0118a bfA = new a.InterfaceC0118a() { // from class: com.baidu.tieba.addresslist.im.searchfriend.SearchFriendActivity.1
        @Override // com.baidu.tieba.addresslist.im.searchfriend.a.InterfaceC0118a
        public void io(String str) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
            httpMessage.addParam("search_key", str);
            SearchFriendActivity.this.sendMessage(httpMessage);
        }
    };
    private CustomMessageListener bfB = new CustomMessageListener(2001265) { // from class: com.baidu.tieba.addresslist.im.searchfriend.SearchFriendActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SearchFriendResult.UserInfo userInfo;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ArrayList) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage)) {
                CustomMessage customMessage = (CustomMessage) customResponsedMessage.getOrginalMessage();
                if ((customMessage.getData() instanceof SearchFriendResult.UserInfo) && (userInfo = (SearchFriendResult.UserInfo) customMessage.getData()) != null) {
                    ArrayList arrayList = (ArrayList) customResponsedMessage.getData();
                    if (arrayList == null || arrayList.size() == 0) {
                        SearchFriendActivity.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(SearchFriendActivity.this.getPageContext().getPageActivity(), String.valueOf(userInfo.getUserId()), userInfo.getUserName(), null, "search")));
                        return;
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if ((next instanceof com.baidu.tbadk.coreExtra.relationship.a) && userInfo.getUserId() == ((com.baidu.tbadk.coreExtra.relationship.a) next).getUserId()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(SearchFriendActivity.this.getPageContext().getPageActivity(), userInfo.getUserId(), userInfo.getUserName(), userInfo.getPortrait(), 0, 4)));
                            return;
                        }
                    }
                    SearchFriendActivity.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(SearchFriendActivity.this.getPageContext().getPageActivity(), String.valueOf(userInfo.getUserId()), userInfo.getUserName(), null, "search")));
                }
            }
        }
    };
    private final HttpMessageListener bfC = new HttpMessageListener(CmdConfigHttp.SEARCH_FRIEND_CMD) { // from class: com.baidu.tieba.addresslist.im.searchfriend.SearchFriendActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001521) {
                SearchFriendActivity.this.bfx.cq(true);
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (httpResponsedMessage instanceof ResponseSearchFriendMessage) {
                    ResponseSearchFriendMessage responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage;
                    if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                        List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                        if (userInfo != null && userInfo.size() > 0) {
                            SearchFriendActivity.this.bfx.ip(null);
                            SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                            if (userInfo2 == null) {
                                SearchFriendActivity.this.showToast(SearchFriendActivity.this.getPageContext().getString(d.k.neterror));
                                return;
                            } else {
                                SearchFriendActivity.this.sendMessage(new CustomMessage(2001265, userInfo2));
                                return;
                            }
                        }
                        SearchFriendActivity.this.showToast(SearchFriendActivity.this.getPageContext().getString(d.k.neterror));
                    } else if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                        SearchFriendActivity.this.showToast(SearchFriendActivity.this.getPageContext().getString(d.k.neterror));
                    } else {
                        SearchFriendActivity.this.showToast(httpResponsedMessage.getErrorString());
                    }
                }
            }
        }
    };
    private a bfx;
    private NavigationBar bfy;
    private View bfz;

    private void NC() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SEARCH_FRIEND_CMD, TbConfig.SERVER_ADDRESS + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bfC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.activity_search_friend);
        this.bee = findViewById(d.g.new_search_friend_root_view);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.SearchFriendActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SearchFriendActivity.this.bfx.NE();
            }
        };
        this.bee.setOnClickListener(onClickListener);
        this.bfy = (NavigationBar) findViewById(d.g.new_search_friend_navigation_bar);
        this.bfy.setTitleText(d.k.find_new_friend);
        this.bfy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.SearchFriendActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SearchFriendActivity.this.finish();
            }
        });
        this.bfz = findViewById(d.g.new_search_friend_search_container);
        this.bfx = new a(getPageContext(), this.bfz);
        this.bfz.setOnClickListener(onClickListener);
        this.bfx.a(this.bfA);
        TiebaStatic.log("add_new");
        registerListener(this.bfB);
        NC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bfy.onChangeSkinType(getPageContext(), i);
        this.bfx.dv(i);
        getLayoutMode().u(this.bfz);
        getLayoutMode().u(this.bee);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bfx.ND();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView xj() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public b<TbImageView> xk() {
        return UserIconBox.h(getPageContext().getPageActivity(), 8);
    }
}
