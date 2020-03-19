package com.baidu.tieba.addresslist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.b.a;
import com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivityConfig;
import com.baidu.tieba.addresslist.model.AddressListModel;
import com.baidu.tieba.addresslist.relationship.ResponseGetAddressListMessage;
import com.baidu.tieba.addresslist.relationship.e;
import com.baidu.tieba.addresslist.view.AssortView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class AddressListFragment extends BaseFragment implements g.c, a.InterfaceC0408a, AssortView.a {
    private final CustomMessageListener cLK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.addresslist.AddressListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (!j.isNetWorkAvailable() || !BdSocketLinkService.isAvailable()) {
                    AddressListFragment.this.eaW.completePullRefreshPostDelayed(0L);
                }
            }
        }
    };
    private AddressListModel eaO;
    private a eaP;
    private b eaQ;
    private c eaR;
    private d eaS;
    private long eaT;
    private AssortView eaU;
    private LinearLayout eaV;
    private BdListView eaW;
    private com.baidu.tieba.addresslist.a.a eaX;
    private TextView eaY;
    private ImageView eaZ;
    private int eba;
    private BaseFragmentActivity ebb;
    private com.baidu.tbadk.core.c mLayoutMode;
    private View mParent;
    private h mPullView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener();
        this.eaT = 0L;
        this.eaO = new AddressListModel(getBaseFragmentActivity());
        this.eaO.setUniqueId(getUniqueId());
    }

    private void registerListener() {
        this.eaP = new a();
        registerListener(this.eaP);
        this.eaQ = new b();
        registerListener(this.eaQ);
        this.eaR = new c();
        registerListener(this.eaR);
        this.eaS = new d();
        registerListener(this.eaS);
        registerListener(this.cLK);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.ebb = getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.SHOW_NEW_ICON_FOR_NEW_FRIEND + TbadkCoreApplication.getCurrentAccount(), true)) {
            com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.SHOW_NEW_ICON_FOR_NEW_FRIEND + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        aYF();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eaO.b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity != null) {
            this.mLayoutMode = baseFragmentActivity.getLayoutMode();
        }
        return a(layoutInflater);
    }

    private View a(LayoutInflater layoutInflater) {
        this.mParent = LayoutInflater.from(this.ebb.getPageContext().getPageActivity()).inflate(R.layout.addresslist_fragment, (ViewGroup) null);
        this.mPullView = new h(this.ebb.getPageContext());
        this.eaX = new com.baidu.tieba.addresslist.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mLayoutMode);
        this.eaV = (LinearLayout) LayoutInflater.from(this.ebb.getPageContext().getPageActivity()).inflate(R.layout.addresslist_search_layout, (ViewGroup) null, false);
        this.eaV.setOnClickListener(this);
        this.eaZ = (ImageView) this.eaV.findViewById(R.id.addresslist_search_icon);
        this.eaY = (TextView) this.eaV.findViewById(R.id.addresslist_search_bar);
        this.eaW = (BdListView) this.mParent.findViewById(R.id.addresslist_contacts_list);
        this.eaW.setPullRefresh(this.mPullView);
        this.eaW.addHeaderView(this.eaV);
        BdListViewHelper.a(this.ebb.getActivity(), this.eaW, BdListViewHelper.HeadType.DEFAULT);
        this.eaW.setAdapter((ListAdapter) this.eaX);
        this.eaW.setOnItemClickListener(this);
        this.mPullView.setListPullRefreshListener(this);
        this.eaU = (AssortView) this.mParent.findViewById(R.id.addresslist_assortview);
        this.eaU.setClickable(true);
        this.eaU.setOnTouchListener(this);
        return this.mParent;
    }

    private void aYE() {
        this.eaO.aZd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eaO.a(this);
        aYE();
    }

    private void aYF() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void aW(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.eaX.setContacts(list);
        this.eaX.on(this.eba);
        this.eaX.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.eaU.setVisibility(8);
        } else {
            this.eaU.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.addresslist.b.a.InterfaceC0408a
    public void aX(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        aW(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mLayoutMode != null) {
            this.mLayoutMode.setNightMode(i == 1);
            this.mLayoutMode.onModeChanged(this.mParent);
            this.mLayoutMode.onModeChanged(this.eaV);
        }
        am.setBackgroundResource(this.eaV, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.eaY, R.drawable.enter_forum_inputbox_top);
        am.setViewTextColor(this.eaY, R.color.cp_cont_d, 1);
        am.setBackgroundResource(this.eaZ, R.drawable.icon_head_bar_search);
        this.mPullView.changeSkin(i);
        this.eaX.notifyDataSetChanged();
        this.eaU.invalidate();
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (Math.abs(System.currentTimeMillis() - this.eaT) <= 30000) {
            this.eaW.completePullRefreshPostDelayed(0L);
        } else if (l.isNetOk()) {
            this.eaT = System.currentTimeMillis();
            this.eaO.aYY();
        } else {
            this.eaW.completePullRefreshPostDelayed(0L);
            showToast(R.string.no_network_guide);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.addresslist_search_layout) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), QuickSearchActivity.class);
            getActivity().startActivity(intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewFriendsActivityConfig(getActivity())));
            this.eba = 0;
            this.eaX.on(this.eba);
            this.eaX.notifyDataSetChanged();
            TiebaStatic.log("contacts_new");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
        } else if (i == 1) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            TiebaStatic.log("contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = this.eaX.getItem(i);
            if (item != null && item.getUserId() > 0) {
                if (item.getUserType() == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.aMs(), 0, 4)));
                    return;
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.getUserId()), item.getUserName())));
            }
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void xj(String str) {
        int xw;
        List<com.baidu.tbadk.coreExtra.relationship.a> aZc = this.eaO.aZc();
        if (aZc != null && aZc.size() != 0 && (xw = this.eaO.xw(str)) >= 0) {
            this.eaW.setSelection(xw + 5);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void aYG() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends com.baidu.adp.framework.listener.c {
        public a() {
            super(CmdConfigSocket.CMD_GET_ADDRESSLIST);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001) {
                AddressListFragment.this.eaW.completePullRefreshPostDelayed(0L);
                if (socketResponsedMessage.hasError() || !(socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
                    AddressListFragment.this.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? AddressListFragment.this.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString(), false);
                    return;
                }
                com.baidu.tieba.addresslist.relationship.a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
                ArrayList arrayList = new ArrayList();
                if (addressListData != null) {
                    for (e eVar : addressListData.getAddressList()) {
                        List<com.baidu.tbadk.coreExtra.relationship.a> contacts = eVar.getContacts();
                        if (contacts.size() > 0) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar.uw(eVar.getKey());
                            arrayList.add(aVar);
                        }
                        for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : contacts) {
                            arrayList.add(aVar2);
                        }
                    }
                }
                AddressListFragment.this.eaO.bc(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public b() {
            super(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.GET_ADDRESSLIST_SWITCH + TbadkCoreApplication.getCurrentAccount(), true)) {
                AddressListFragment.this.eaW.completePullRefreshPostDelayed(0L);
            }
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                AddressListFragment.this.eaO.bc((List) customResponsedMessage.getData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public c() {
            super(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                if (customResponsedMessage.getError() != 0) {
                    AddressListFragment.this.showToast(customResponsedMessage.getErrorString());
                    return;
                }
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    if (!StringUtils.isNull(responseNewFriendUpdateUiMsg.getKey()) && !StringUtils.isNull(responseNewFriendUpdateUiMsg.getName())) {
                        com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                        aVar.uw(responseNewFriendUpdateUiMsg.getKey());
                        aVar.setQuanpin(responseNewFriendUpdateUiMsg.getQuanping());
                        aVar.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                        aVar.setUserName(responseNewFriendUpdateUiMsg.getName());
                        aVar.cU(responseNewFriendUpdateUiMsg.getPortrait());
                        AddressListFragment.this.eaO.a(aVar);
                    }
                } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                    AddressListFragment.this.eaO.cr(responseNewFriendUpdateUiMsg.getFriendId());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public d() {
            super(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                if (customResponsedMessage.getError() != 0) {
                    AddressListFragment.this.showToast(customResponsedMessage.getErrorString());
                    return;
                }
                AddressListFragment.this.eba = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
                AddressListFragment.this.eaX.on(AddressListFragment.this.eba);
                AddressListFragment.this.eaX.notifyDataSetChanged();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
            }
        }
    }
}
