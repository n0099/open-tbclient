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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
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
public class AddressListFragment extends BaseFragment implements f.c, a.InterfaceC0613a, AssortView.a {
    private BdListView gkA;
    private com.baidu.tieba.addresslist.a.a gkB;
    private TextView gkC;
    private ImageView gkD;
    private int gkE;
    private BaseFragmentActivity gkF;
    private AddressListModel gks;
    private a gkt;
    private b gku;
    private c gkv;
    private d gkw;
    private long gkx;
    private AssortView gky;
    private LinearLayout gkz;
    private com.baidu.tbadk.core.c mLayoutMode;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.addresslist.AddressListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (!j.isNetWorkAvailable() || !BdSocketLinkService.isAvailable()) {
                    AddressListFragment.this.gkA.completePullRefreshPostDelayed(0L);
                }
            }
        }
    };
    private View mParent;
    private g mPullView;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener();
        this.gkx = 0L;
        this.gks = new AddressListModel(getBaseFragmentActivity());
        this.gks.setUniqueId(getUniqueId());
    }

    private void registerListener() {
        this.gkt = new a();
        registerListener(this.gkt);
        this.gku = new b();
        registerListener(this.gku);
        this.gkv = new c();
        registerListener(this.gkv);
        this.gkw = new d();
        registerListener(this.gkw);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.gkF = getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(SharedPrefConfig.SHOW_NEW_ICON_FOR_NEW_FRIEND + TbadkCoreApplication.getCurrentAccount(), true)) {
            com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SharedPrefConfig.SHOW_NEW_ICON_FOR_NEW_FRIEND + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        bPf();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gks.b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity != null) {
            this.mLayoutMode = baseFragmentActivity.getLayoutMode();
        }
        return b(layoutInflater);
    }

    private View b(LayoutInflater layoutInflater) {
        this.mParent = LayoutInflater.from(this.gkF.getPageContext().getPageActivity()).inflate(R.layout.addresslist_fragment, (ViewGroup) null);
        this.mPullView = new g(this.gkF.getPageContext());
        this.gkB = new com.baidu.tieba.addresslist.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mLayoutMode);
        this.gkz = (LinearLayout) LayoutInflater.from(this.gkF.getPageContext().getPageActivity()).inflate(R.layout.addresslist_search_layout, (ViewGroup) null, false);
        this.gkz.setOnClickListener(this);
        this.gkD = (ImageView) this.gkz.findViewById(R.id.addresslist_search_icon);
        this.gkC = (TextView) this.gkz.findViewById(R.id.addresslist_search_bar);
        this.gkA = (BdListView) this.mParent.findViewById(R.id.addresslist_contacts_list);
        this.gkA.setPullRefresh(this.mPullView);
        this.gkA.addHeaderView(this.gkz);
        BdListViewHelper.a(this.gkF.getActivity(), this.gkA, BdListViewHelper.HeadType.DEFAULT);
        this.gkA.setAdapter((ListAdapter) this.gkB);
        this.gkA.setOnItemClickListener(this);
        this.mPullView.setListPullRefreshListener(this);
        this.gky = (AssortView) this.mParent.findViewById(R.id.addresslist_assortview);
        this.gky.setClickable(true);
        this.gky.setOnTouchListener(this);
        return this.mParent;
    }

    private void bPe() {
        this.gks.bPC();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gks.a(this);
        bPe();
    }

    private void bPf() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void bY(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.gkB.setContacts(list);
        this.gkB.uF(this.gkE);
        this.gkB.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.gky.setVisibility(8);
        } else {
            this.gky.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.addresslist.b.a.InterfaceC0613a
    public void bZ(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        bY(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mLayoutMode != null) {
            this.mLayoutMode.setNightMode(i == 1);
            this.mLayoutMode.onModeChanged(this.mParent);
            this.mLayoutMode.onModeChanged(this.gkz);
        }
        ao.setBackgroundResource(this.gkz, R.color.CAM_X0201);
        ao.setBackgroundResource(this.gkC, R.drawable.enter_forum_inputbox_top);
        ao.setViewTextColor(this.gkC, R.color.CAM_X0109, 1);
        ao.setBackgroundResource(this.gkD, R.drawable.icon_head_bar_search);
        this.mPullView.changeSkin(i);
        this.gkB.notifyDataSetChanged();
        this.gky.invalidate();
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (Math.abs(System.currentTimeMillis() - this.gkx) <= 30000) {
            this.gkA.completePullRefreshPostDelayed(0L);
        } else if (l.isNetOk()) {
            this.gkx = System.currentTimeMillis();
            this.gks.bPy();
        } else {
            this.gkA.completePullRefreshPostDelayed(0L);
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
            this.gkE = 0;
            this.gkB.uF(this.gkE);
            this.gkB.notifyDataSetChanged();
            TiebaStatic.log("contacts_new");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
        } else if (i == 1) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            TiebaStatic.log("contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = this.gkB.getItem(i);
            if (item != null && item.getUserId() > 0) {
                if (item.getUserType() == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.getUserPortrait(), 0, 4)));
                    return;
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.getUserId()), item.getUserName())));
            }
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void FF(String str) {
        int FS;
        List<com.baidu.tbadk.coreExtra.relationship.a> bPB = this.gks.bPB();
        if (bPB != null && bPB.size() != 0 && (FS = this.gks.FS(str)) >= 0) {
            this.gkA.setSelection(FS + 5);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void bPg() {
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
                AddressListFragment.this.gkA.completePullRefreshPostDelayed(0L);
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
                            aVar.Dd(eVar.getKey());
                            arrayList.add(aVar);
                        }
                        for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : contacts) {
                            arrayList.add(aVar2);
                        }
                    }
                }
                AddressListFragment.this.gks.ce(arrayList);
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
            if (!com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(SharedPrefConfig.GET_ADDRESSLIST_SWITCH + TbadkCoreApplication.getCurrentAccount(), true)) {
                AddressListFragment.this.gkA.completePullRefreshPostDelayed(0L);
            }
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                AddressListFragment.this.gks.ce((List) customResponsedMessage.getData());
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
                        aVar.Dd(responseNewFriendUpdateUiMsg.getKey());
                        aVar.setQuanpin(responseNewFriendUpdateUiMsg.getQuanping());
                        aVar.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                        aVar.setUserName(responseNewFriendUpdateUiMsg.getName());
                        aVar.setUserPortrait(responseNewFriendUpdateUiMsg.getPortrait());
                        AddressListFragment.this.gks.a(aVar);
                    }
                } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                    AddressListFragment.this.gks.eM(responseNewFriendUpdateUiMsg.getFriendId());
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
                AddressListFragment.this.gkE = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
                AddressListFragment.this.gkB.uF(AddressListFragment.this.gkE);
                AddressListFragment.this.gkB.notifyDataSetChanged();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
            }
        }
    }
}
