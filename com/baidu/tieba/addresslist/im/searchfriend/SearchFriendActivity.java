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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.data.SearchFriendResult;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.searchfriend.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class SearchFriendActivity extends BaseActivity<SearchFriendActivity> implements UserIconBox.b {
    private View diF;
    private a djU;
    private NavigationBar djV;
    private View djW;
    private a.InterfaceC0312a djX = new a.InterfaceC0312a() { // from class: com.baidu.tieba.addresslist.im.searchfriend.SearchFriendActivity.1
        @Override // com.baidu.tieba.addresslist.im.searchfriend.a.InterfaceC0312a
        public void rN(String str) {
            HttpMessage httpMessage = new HttpMessage(1001521);
            httpMessage.addParam("search_key", str);
            SearchFriendActivity.this.sendMessage(httpMessage);
        }
    };
    private CustomMessageListener djY = new CustomMessageListener(CmdConfigCustom.CMD_GET_OFFICIAL_ACCOUNT) { // from class: com.baidu.tieba.addresslist.im.searchfriend.SearchFriendActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SearchFriendResult.UserInfo userInfo;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ArrayList) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage)) {
                CustomMessage customMessage = (CustomMessage) customResponsedMessage.getOrginalMessage();
                if ((customMessage.getData() instanceof SearchFriendResult.UserInfo) && (userInfo = (SearchFriendResult.UserInfo) customMessage.getData()) != null) {
                    ArrayList arrayList = (ArrayList) customResponsedMessage.getData();
                    if (arrayList == null || arrayList.size() == 0) {
                        SearchFriendActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(SearchFriendActivity.this.getPageContext().getPageActivity(), String.valueOf(userInfo.getUserId()), userInfo.getUserName(), null, "search")));
                        return;
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if ((next instanceof com.baidu.tbadk.coreExtra.relationship.a) && userInfo.getUserId() == ((com.baidu.tbadk.coreExtra.relationship.a) next).getUserId()) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(SearchFriendActivity.this.getPageContext().getPageActivity(), userInfo.getUserId(), userInfo.getUserName(), userInfo.getPortrait(), 0, 4)));
                            return;
                        }
                    }
                    SearchFriendActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(SearchFriendActivity.this.getPageContext().getPageActivity(), String.valueOf(userInfo.getUserId()), userInfo.getUserName(), null, "search")));
                }
            }
        }
    };
    private final HttpMessageListener djZ = new HttpMessageListener(1001521) { // from class: com.baidu.tieba.addresslist.im.searchfriend.SearchFriendActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001521) {
                SearchFriendActivity.this.djU.ge(true);
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (httpResponsedMessage instanceof ResponseSearchFriendMessage) {
                    ResponseSearchFriendMessage responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage;
                    if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                        List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                        if (userInfo != null && userInfo.size() > 0) {
                            SearchFriendActivity.this.djU.rO(null);
                            SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                            if (userInfo2 == null) {
                                SearchFriendActivity.this.showToast(SearchFriendActivity.this.getPageContext().getString(R.string.neterror));
                                return;
                            } else {
                                SearchFriendActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_GET_OFFICIAL_ACCOUNT, userInfo2));
                                return;
                            }
                        }
                        SearchFriendActivity.this.showToast(SearchFriendActivity.this.getPageContext().getString(R.string.neterror));
                    } else if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                        SearchFriendActivity.this.showToast(SearchFriendActivity.this.getPageContext().getString(R.string.neterror));
                    } else {
                        SearchFriendActivity.this.showToast(httpResponsedMessage.getErrorString());
                    }
                }
            }
        }
    };

    private void aEq() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001521, TbConfig.SERVER_ADDRESS + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.djZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_friend);
        this.diF = findViewById(R.id.new_search_friend_root_view);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.SearchFriendActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchFriendActivity.this.djU.aEs();
            }
        };
        this.diF.setOnClickListener(onClickListener);
        this.djV = (NavigationBar) findViewById(R.id.new_search_friend_navigation_bar);
        this.djV.setTitleText(R.string.find_new_friend);
        this.djV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.im.searchfriend.SearchFriendActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchFriendActivity.this.finish();
            }
        });
        this.djW = findViewById(R.id.new_search_friend_search_container);
        this.djU = new a(getPageContext(), this.djW);
        this.djW.setOnClickListener(onClickListener);
        this.djU.a(this.djX);
        TiebaStatic.log("add_new");
        registerListener(this.djY);
        aEq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.djV.onChangeSkinType(getPageContext(), i);
        this.djU.changeSkin(i);
        getLayoutMode().onModeChanged(this.djW);
        getLayoutMode().onModeChanged(this.diF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.djU.aEr();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView aod() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public b<TbImageView> aoe() {
        return UserIconBox.o(getPageContext().getPageActivity(), 8);
    }
}
