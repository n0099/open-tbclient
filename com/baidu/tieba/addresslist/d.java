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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.addresslist.b.a;
import com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivityConfig;
import com.baidu.tieba.addresslist.relationship.ResponseGetAddressListMessage;
import com.baidu.tieba.addresslist.view.AssortView;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends BaseFragment implements q.a, a.InterfaceC0059a, AssortView.a {
    private View Mk;
    private com.baidu.tieba.addresslist.c.a aHA;
    private a aHB;
    private b aHC;
    private c aHD;
    private C0060d aHE;
    private long aHF;
    private AssortView aHG;
    private LinearLayout aHH;
    private BdListView aHI;
    private com.baidu.tieba.addresslist.a.a aHJ;
    private TextView aHK;
    private ImageView aHL;
    private int aHM;
    private BaseFragmentActivity aHN;
    private com.baidu.tbadk.core.c mLayoutMode;
    private s mPullView;
    private final CustomMessageListener aHO = new e(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
    private final CustomMessageListener mNetworkChangedMessageListener = new f(this, 2000994);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener();
        this.aHF = 0L;
        this.aHA = new com.baidu.tieba.addresslist.c.a(getBaseFragmentActivity());
        this.aHA.setUniqueId(getUniqueId());
    }

    private void registerListener() {
        this.aHB = new a();
        registerListener(this.aHB);
        this.aHC = new b();
        registerListener(this.aHC);
        this.aHD = new c();
        registerListener(this.aHD);
        this.aHE = new C0060d();
        registerListener(this.aHE);
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.aHO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aHN = getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), true)) {
            com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        Hf();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.aHA.b(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity != null) {
            this.mLayoutMode = baseFragmentActivity.getLayoutMode();
        }
        return b(layoutInflater);
    }

    private View b(LayoutInflater layoutInflater) {
        this.Mk = LayoutInflater.from(this.aHN.getPageContext().getPageActivity()).inflate(n.g.addresslist_fragment, (ViewGroup) null);
        this.mPullView = new s(this.aHN.getPageContext());
        this.aHJ = new com.baidu.tieba.addresslist.a.a(TbadkCoreApplication.m411getInst().getApplicationContext(), this.mLayoutMode);
        this.aHH = (LinearLayout) LayoutInflater.from(this.aHN.getPageContext().getPageActivity()).inflate(n.g.addresslist_search_layout, (ViewGroup) null, false);
        this.aHH.setOnClickListener(this);
        this.aHL = (ImageView) this.aHH.findViewById(n.f.addresslist_search_icon);
        this.aHK = (TextView) this.aHH.findViewById(n.f.addresslist_search_bar);
        this.aHI = (BdListView) this.Mk.findViewById(n.f.addresslist_contacts_list);
        this.aHI.setPullRefresh(this.mPullView);
        this.aHI.addHeaderView(this.aHH);
        this.aHI.setAdapter((ListAdapter) this.aHJ);
        this.aHI.setOnItemClickListener(this);
        this.mPullView.a(this);
        this.aHG = (AssortView) this.Mk.findViewById(n.f.addresslist_assortview);
        this.aHG.setClickable(true);
        this.aHG.setOnTouchListener(this);
        return this.Mk;
    }

    private void He() {
        this.aHA.HJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.aHA.a(this);
        He();
    }

    private void Hf() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void u(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aHJ.setContacts(list);
        this.aHJ.fe(this.aHM);
        this.aHJ.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.aHG.setVisibility(8);
        } else {
            this.aHG.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.addresslist.b.a.InterfaceC0059a
    public void v(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        u(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mLayoutMode != null) {
            this.mLayoutMode.af(i == 1);
            this.mLayoutMode.k(this.Mk);
            this.mLayoutMode.k(this.aHH);
        }
        as.i(this.aHH, n.c.cp_bg_line_d);
        as.i((View) this.aHK, n.e.enter_forum_inputbox_top);
        as.b(this.aHK, n.c.cp_cont_d, 1);
        as.i(this.aHL, n.e.icon_head_bar_search);
        this.mPullView.cV(i);
        this.aHJ.notifyDataSetChanged();
        this.aHG.invalidate();
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        if (Math.abs(System.currentTimeMillis() - this.aHF) <= 30000) {
            this.aHI.completePullRefresh();
        } else if (com.baidu.adp.lib.util.k.jg()) {
            this.aHF = System.currentTimeMillis();
            this.aHA.Hx();
        } else {
            this.aHI.completePullRefresh();
            showToast(n.i.no_network_guide);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == n.f.addresslist_search_layout) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), QuickSearchActivity.class);
            getActivity().startActivity(intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewFriendsActivityConfig(getActivity())));
            this.aHM = 0;
            this.aHJ.fe(this.aHM);
            this.aHJ.notifyDataSetChanged();
            TiebaStatic.log("contacts_new");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
        } else if (i == 1) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            TiebaStatic.log("contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = this.aHJ.getItem(i);
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
    public void gk(String str) {
        int gy;
        List<com.baidu.tbadk.coreExtra.relationship.a> HI = this.aHA.HI();
        if (HI != null && HI.size() != 0 && (gy = this.aHA.gy(str)) >= 0) {
            this.aHI.setSelection(gy + 5);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void Hg() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.framework.listener.e {
        public a() {
            super(304001);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001) {
                d.this.aHI.completePullRefresh();
                if (socketResponsedMessage.hasError() || !(socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
                    d.this.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? d.this.getResources().getString(n.i.neterror) : socketResponsedMessage.getErrorString(), false);
                    return;
                }
                com.baidu.tieba.addresslist.relationship.a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
                ArrayList arrayList = new ArrayList();
                if (addressListData != null) {
                    for (com.baidu.tieba.addresslist.relationship.e eVar : addressListData.getAddressList()) {
                        List<com.baidu.tbadk.coreExtra.relationship.a> contacts = eVar.getContacts();
                        if (contacts.size() > 0) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar.ew(eVar.getKey());
                            arrayList.add(aVar);
                        }
                        for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : contacts) {
                            arrayList.add(aVar2);
                        }
                    }
                }
                d.this.aHA.A(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends CustomMessageListener {
        public b() {
            super(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true)) {
                d.this.aHI.completePullRefresh();
            }
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                d.this.aHA.A((List) customResponsedMessage.getData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends CustomMessageListener {
        public c() {
            super(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001178 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                if (customResponsedMessage.getError() != 0) {
                    d.this.showToast(customResponsedMessage.getErrorString());
                    return;
                }
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    if (!StringUtils.isNull(responseNewFriendUpdateUiMsg.getKey()) && !StringUtils.isNull(responseNewFriendUpdateUiMsg.getName())) {
                        com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                        aVar.ew(responseNewFriendUpdateUiMsg.getKey());
                        aVar.setQuanpin(responseNewFriendUpdateUiMsg.getQuanping());
                        aVar.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                        aVar.setUserName(responseNewFriendUpdateUiMsg.getName());
                        aVar.ev(responseNewFriendUpdateUiMsg.getPortrait());
                        d.this.aHA.a(aVar);
                    }
                } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                    d.this.aHA.ag(responseNewFriendUpdateUiMsg.getFriendId());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.addresslist.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0060d extends CustomMessageListener {
        public C0060d() {
            super(CmdConfigCustom.CMD_RESPONSE_UNREAD_NEW_FRIENDS_NUM);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001180 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                if (customResponsedMessage.getError() != 0) {
                    d.this.showToast(customResponsedMessage.getErrorString());
                    return;
                }
                d.this.aHM = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
                d.this.aHJ.fe(d.this.aHM);
                d.this.aHJ.notifyDataSetChanged();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
            }
        }
    }
}
