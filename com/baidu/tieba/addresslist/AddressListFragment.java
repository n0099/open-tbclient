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
public class AddressListFragment extends BaseFragment implements f.c, a.InterfaceC0507a, AssortView.a {
    private final CustomMessageListener dyW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.addresslist.AddressListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (!j.isNetWorkAvailable() || !BdSocketLinkService.isAvailable()) {
                    AddressListFragment.this.ePn.completePullRefreshPostDelayed(0L);
                }
            }
        }
    };
    private AddressListModel ePf;
    private a ePg;
    private b ePh;
    private c ePi;
    private d ePj;
    private long ePk;
    private AssortView ePl;
    private LinearLayout ePm;
    private BdListView ePn;
    private com.baidu.tieba.addresslist.a.a ePo;
    private TextView ePp;
    private ImageView ePq;
    private int ePr;
    private BaseFragmentActivity ePs;
    private com.baidu.tbadk.core.c mLayoutMode;
    private View mParent;
    private g mPullView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener();
        this.ePk = 0L;
        this.ePf = new AddressListModel(getBaseFragmentActivity());
        this.ePf.setUniqueId(getUniqueId());
    }

    private void registerListener() {
        this.ePg = new a();
        registerListener(this.ePg);
        this.ePh = new b();
        registerListener(this.ePh);
        this.ePi = new c();
        registerListener(this.ePi);
        this.ePj = new d();
        registerListener(this.ePj);
        registerListener(this.dyW);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.ePs = getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.SHOW_NEW_ICON_FOR_NEW_FRIEND + TbadkCoreApplication.getCurrentAccount(), true)) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.SHOW_NEW_ICON_FOR_NEW_FRIEND + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        bmS();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.ePf.b(this);
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
        this.mParent = LayoutInflater.from(this.ePs.getPageContext().getPageActivity()).inflate(R.layout.addresslist_fragment, (ViewGroup) null);
        this.mPullView = new g(this.ePs.getPageContext());
        this.ePo = new com.baidu.tieba.addresslist.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mLayoutMode);
        this.ePm = (LinearLayout) LayoutInflater.from(this.ePs.getPageContext().getPageActivity()).inflate(R.layout.addresslist_search_layout, (ViewGroup) null, false);
        this.ePm.setOnClickListener(this);
        this.ePq = (ImageView) this.ePm.findViewById(R.id.addresslist_search_icon);
        this.ePp = (TextView) this.ePm.findViewById(R.id.addresslist_search_bar);
        this.ePn = (BdListView) this.mParent.findViewById(R.id.addresslist_contacts_list);
        this.ePn.setPullRefresh(this.mPullView);
        this.ePn.addHeaderView(this.ePm);
        BdListViewHelper.a(this.ePs.getActivity(), this.ePn, BdListViewHelper.HeadType.DEFAULT);
        this.ePn.setAdapter((ListAdapter) this.ePo);
        this.ePn.setOnItemClickListener(this);
        this.mPullView.setListPullRefreshListener(this);
        this.ePl = (AssortView) this.mParent.findViewById(R.id.addresslist_assortview);
        this.ePl.setClickable(true);
        this.ePl.setOnTouchListener(this);
        return this.mParent;
    }

    private void bmR() {
        this.ePf.bnq();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.ePf.a(this);
        bmR();
    }

    private void bmS() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void bb(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ePo.setContacts(list);
        this.ePo.ph(this.ePr);
        this.ePo.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.ePl.setVisibility(8);
        } else {
            this.ePl.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.addresslist.b.a.InterfaceC0507a
    public void bc(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        bb(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mLayoutMode != null) {
            this.mLayoutMode.setNightMode(i == 1);
            this.mLayoutMode.onModeChanged(this.mParent);
            this.mLayoutMode.onModeChanged(this.ePm);
        }
        am.setBackgroundResource(this.ePm, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.ePp, R.drawable.enter_forum_inputbox_top);
        am.setViewTextColor(this.ePp, R.color.cp_cont_d, 1);
        am.setBackgroundResource(this.ePq, R.drawable.icon_head_bar_search);
        this.mPullView.changeSkin(i);
        this.ePo.notifyDataSetChanged();
        this.ePl.invalidate();
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (Math.abs(System.currentTimeMillis() - this.ePk) <= 30000) {
            this.ePn.completePullRefreshPostDelayed(0L);
        } else if (l.isNetOk()) {
            this.ePk = System.currentTimeMillis();
            this.ePf.bnl();
        } else {
            this.ePn.completePullRefreshPostDelayed(0L);
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
            this.ePr = 0;
            this.ePo.ph(this.ePr);
            this.ePo.notifyDataSetChanged();
            TiebaStatic.log("contacts_new");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
        } else if (i == 1) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            TiebaStatic.log("contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = this.ePo.getItem(i);
            if (item != null && item.getUserId() > 0) {
                if (item.getUserType() == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.baX(), 0, 4)));
                    return;
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.getUserId()), item.getUserName())));
            }
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void Ae(String str) {
        int Ar;
        List<com.baidu.tbadk.coreExtra.relationship.a> bnp = this.ePf.bnp();
        if (bnp != null && bnp.size() != 0 && (Ar = this.ePf.Ar(str)) >= 0) {
            this.ePn.setSelection(Ar + 5);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void bmT() {
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
                AddressListFragment.this.ePn.completePullRefreshPostDelayed(0L);
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
                            aVar.xt(eVar.getKey());
                            arrayList.add(aVar);
                        }
                        for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : contacts) {
                            arrayList.add(aVar2);
                        }
                    }
                }
                AddressListFragment.this.ePf.bh(arrayList);
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
            if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.GET_ADDRESSLIST_SWITCH + TbadkCoreApplication.getCurrentAccount(), true)) {
                AddressListFragment.this.ePn.completePullRefreshPostDelayed(0L);
            }
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                AddressListFragment.this.ePf.bh((List) customResponsedMessage.getData());
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
                        aVar.xt(responseNewFriendUpdateUiMsg.getKey());
                        aVar.setQuanpin(responseNewFriendUpdateUiMsg.getQuanping());
                        aVar.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                        aVar.setUserName(responseNewFriendUpdateUiMsg.getName());
                        aVar.eo(responseNewFriendUpdateUiMsg.getPortrait());
                        AddressListFragment.this.ePf.a(aVar);
                    }
                } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                    AddressListFragment.this.ePf.da(responseNewFriendUpdateUiMsg.getFriendId());
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
                AddressListFragment.this.ePr = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
                AddressListFragment.this.ePo.ph(AddressListFragment.this.ePr);
                AddressListFragment.this.ePo.notifyDataSetChanged();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
            }
        }
    }
}
