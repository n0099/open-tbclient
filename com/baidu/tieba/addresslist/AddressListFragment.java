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
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes21.dex */
public class AddressListFragment extends BaseFragment implements f.c, a.InterfaceC0610a, AssortView.a {
    private final CustomMessageListener exb = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.addresslist.AddressListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (!j.isNetWorkAvailable() || !BdSocketLinkService.isAvailable()) {
                    AddressListFragment.this.fTq.completePullRefreshPostDelayed(0L);
                }
            }
        }
    };
    private AddressListModel fTi;
    private a fTj;
    private b fTk;
    private c fTl;
    private d fTm;
    private long fTn;
    private AssortView fTo;
    private LinearLayout fTp;
    private BdListView fTq;
    private com.baidu.tieba.addresslist.a.a fTr;
    private TextView fTs;
    private ImageView fTt;
    private int fTu;
    private BaseFragmentActivity fTv;
    private com.baidu.tbadk.core.c mLayoutMode;
    private View mParent;
    private g mPullView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener();
        this.fTn = 0L;
        this.fTi = new AddressListModel(getBaseFragmentActivity());
        this.fTi.setUniqueId(getUniqueId());
    }

    private void registerListener() {
        this.fTj = new a();
        registerListener(this.fTj);
        this.fTk = new b();
        registerListener(this.fTk);
        this.fTl = new c();
        registerListener(this.fTl);
        this.fTm = new d();
        registerListener(this.fTm);
        registerListener(this.exb);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.fTv = getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.SHOW_NEW_ICON_FOR_NEW_FRIEND + TbadkCoreApplication.getCurrentAccount(), true)) {
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.SHOW_NEW_ICON_FOR_NEW_FRIEND + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        bJL();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.fTi.b(this);
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
        this.mParent = LayoutInflater.from(this.fTv.getPageContext().getPageActivity()).inflate(R.layout.addresslist_fragment, (ViewGroup) null);
        this.mPullView = new g(this.fTv.getPageContext());
        this.fTr = new com.baidu.tieba.addresslist.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mLayoutMode);
        this.fTp = (LinearLayout) LayoutInflater.from(this.fTv.getPageContext().getPageActivity()).inflate(R.layout.addresslist_search_layout, (ViewGroup) null, false);
        this.fTp.setOnClickListener(this);
        this.fTt = (ImageView) this.fTp.findViewById(R.id.addresslist_search_icon);
        this.fTs = (TextView) this.fTp.findViewById(R.id.addresslist_search_bar);
        this.fTq = (BdListView) this.mParent.findViewById(R.id.addresslist_contacts_list);
        this.fTq.setPullRefresh(this.mPullView);
        this.fTq.addHeaderView(this.fTp);
        BdListViewHelper.a(this.fTv.getActivity(), this.fTq, BdListViewHelper.HeadType.DEFAULT);
        this.fTq.setAdapter((ListAdapter) this.fTr);
        this.fTq.setOnItemClickListener(this);
        this.mPullView.setListPullRefreshListener(this);
        this.fTo = (AssortView) this.mParent.findViewById(R.id.addresslist_assortview);
        this.fTo.setClickable(true);
        this.fTo.setOnTouchListener(this);
        return this.mParent;
    }

    private void bJK() {
        this.fTi.bKi();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.fTi.a(this);
        bJK();
    }

    private void bJL() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void bN(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fTr.setContacts(list);
        this.fTr.ts(this.fTu);
        this.fTr.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.fTo.setVisibility(8);
        } else {
            this.fTo.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.addresslist.b.a.InterfaceC0610a
    public void bO(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        bN(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mLayoutMode != null) {
            this.mLayoutMode.setNightMode(i == 1);
            this.mLayoutMode.onModeChanged(this.mParent);
            this.mLayoutMode.onModeChanged(this.fTp);
        }
        ap.setBackgroundResource(this.fTp, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.fTs, R.drawable.enter_forum_inputbox_top);
        ap.setViewTextColor(this.fTs, R.color.cp_cont_d, 1);
        ap.setBackgroundResource(this.fTt, R.drawable.icon_head_bar_search);
        this.mPullView.changeSkin(i);
        this.fTr.notifyDataSetChanged();
        this.fTo.invalidate();
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (Math.abs(System.currentTimeMillis() - this.fTn) <= 30000) {
            this.fTq.completePullRefreshPostDelayed(0L);
        } else if (l.isNetOk()) {
            this.fTn = System.currentTimeMillis();
            this.fTi.bKe();
        } else {
            this.fTq.completePullRefreshPostDelayed(0L);
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
            this.fTu = 0;
            this.fTr.ts(this.fTu);
            this.fTr.notifyDataSetChanged();
            TiebaStatic.log("contacts_new");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
        } else if (i == 1) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            TiebaStatic.log("contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = this.fTr.getItem(i);
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
    public void Fs(String str) {
        int FF;
        List<com.baidu.tbadk.coreExtra.relationship.a> bKh = this.fTi.bKh();
        if (bKh != null && bKh.size() != 0 && (FF = this.fTi.FF(str)) >= 0) {
            this.fTq.setSelection(FF + 5);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void bJM() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends com.baidu.adp.framework.listener.c {
        public a() {
            super(CmdConfigSocket.CMD_GET_ADDRESSLIST);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001) {
                AddressListFragment.this.fTq.completePullRefreshPostDelayed(0L);
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
                            aVar.CY(eVar.getKey());
                            arrayList.add(aVar);
                        }
                        for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : contacts) {
                            arrayList.add(aVar2);
                        }
                    }
                }
                AddressListFragment.this.fTi.bT(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class b extends CustomMessageListener {
        public b() {
            super(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.GET_ADDRESSLIST_SWITCH + TbadkCoreApplication.getCurrentAccount(), true)) {
                AddressListFragment.this.fTq.completePullRefreshPostDelayed(0L);
            }
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                AddressListFragment.this.fTi.bT((List) customResponsedMessage.getData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
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
                        aVar.CY(responseNewFriendUpdateUiMsg.getKey());
                        aVar.setQuanpin(responseNewFriendUpdateUiMsg.getQuanping());
                        aVar.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                        aVar.setUserName(responseNewFriendUpdateUiMsg.getName());
                        aVar.setUserPortrait(responseNewFriendUpdateUiMsg.getPortrait());
                        AddressListFragment.this.fTi.a(aVar);
                    }
                } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                    AddressListFragment.this.fTi.ej(responseNewFriendUpdateUiMsg.getFriendId());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
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
                AddressListFragment.this.fTu = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
                AddressListFragment.this.fTr.ts(AddressListFragment.this.fTu);
                AddressListFragment.this.fTr.notifyDataSetChanged();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
            }
        }
    }
}
