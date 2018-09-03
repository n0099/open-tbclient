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
import com.baidu.tieba.addresslist.b.a;
import com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivityConfig;
import com.baidu.tieba.addresslist.model.AddressListModel;
import com.baidu.tieba.addresslist.relationship.ResponseGetAddressListMessage;
import com.baidu.tieba.addresslist.relationship.e;
import com.baidu.tieba.addresslist.view.AssortView;
import com.baidu.tieba.f;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AddressListFragment extends BaseFragment implements g.b, a.InterfaceC0130a, AssortView.a {
    private AddressListModel bof;
    private a bog;
    private b boh;
    private c boi;
    private d boj;
    private long bok;
    private AssortView bol;
    private LinearLayout bom;
    private BdListView bon;
    private com.baidu.tieba.addresslist.a.a boo;
    private TextView bop;
    private ImageView boq;
    private int bor;
    private BaseFragmentActivity bos;
    private com.baidu.tbadk.core.c mLayoutMode;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.addresslist.AddressListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (!j.jE() || !BdSocketLinkService.isAvailable()) {
                    AddressListFragment.this.bon.completePullRefreshPostDelayed(2000L);
                }
            }
        }
    };
    private View mParent;
    private h mPullView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener();
        this.bok = 0L;
        this.bof = new AddressListModel(getBaseFragmentActivity());
        this.bof.setUniqueId(getUniqueId());
    }

    private void registerListener() {
        this.bog = new a();
        registerListener(this.bog);
        this.boh = new b();
        registerListener(this.boh);
        this.boi = new c();
        registerListener(this.boi);
        this.boj = new d();
        registerListener(this.boj);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.bos = getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), true)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        Rr();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.bof.b(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity != null) {
            this.mLayoutMode = baseFragmentActivity.getLayoutMode();
        }
        return b(layoutInflater);
    }

    private View b(LayoutInflater layoutInflater) {
        this.mParent = LayoutInflater.from(this.bos.getPageContext().getPageActivity()).inflate(f.h.addresslist_fragment, (ViewGroup) null);
        this.mPullView = new h(this.bos.getPageContext());
        this.boo = new com.baidu.tieba.addresslist.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mLayoutMode);
        this.bom = (LinearLayout) LayoutInflater.from(this.bos.getPageContext().getPageActivity()).inflate(f.h.addresslist_search_layout, (ViewGroup) null, false);
        this.bom.setOnClickListener(this);
        this.boq = (ImageView) this.bom.findViewById(f.g.addresslist_search_icon);
        this.bop = (TextView) this.bom.findViewById(f.g.addresslist_search_bar);
        this.bon = (BdListView) this.mParent.findViewById(f.g.addresslist_contacts_list);
        this.bon.setPullRefresh(this.mPullView);
        this.bon.addHeaderView(this.bom);
        BdListViewHelper.a(this.bos.getActivity(), this.bon, BdListViewHelper.HeadType.DEFAULT);
        this.bon.setAdapter((ListAdapter) this.boo);
        this.bon.setOnItemClickListener(this);
        this.mPullView.a(this);
        this.bol = (AssortView) this.mParent.findViewById(f.g.addresslist_assortview);
        this.bol.setClickable(true);
        this.bol.setOnTouchListener(this);
        return this.mParent;
    }

    private void Rq() {
        this.bof.RM();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.bof.a(this);
        Rq();
    }

    private void Rr() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void U(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.boo.setContacts(list);
        this.boo.gC(this.bor);
        this.boo.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.bol.setVisibility(8);
        } else {
            this.bol.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.addresslist.b.a.InterfaceC0130a
    public void V(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        U(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mLayoutMode != null) {
            this.mLayoutMode.setNightMode(i == 1);
            this.mLayoutMode.onModeChanged(this.mParent);
            this.mLayoutMode.onModeChanged(this.bom);
        }
        am.i(this.bom, f.d.cp_bg_line_d);
        am.i(this.bop, f.C0146f.enter_forum_inputbox_top);
        am.c(this.bop, f.d.cp_cont_d, 1);
        am.i(this.boq, f.C0146f.icon_head_bar_search);
        this.mPullView.dB(i);
        this.boo.notifyDataSetChanged();
        this.bol.invalidate();
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aT(boolean z) {
        if (Math.abs(System.currentTimeMillis() - this.bok) <= StatisticConfig.MIN_UPLOAD_INTERVAL) {
            this.bon.completePullRefreshPostDelayed(2000L);
        } else if (l.jV()) {
            this.bok = System.currentTimeMillis();
            this.bof.RH();
        } else {
            this.bon.completePullRefreshPostDelayed(2000L);
            showToast(f.j.no_network_guide);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == f.g.addresslist_search_layout) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), QuickSearchActivity.class);
            getActivity().startActivity(intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            sendMessage(new CustomMessage(2002001, new NewFriendsActivityConfig(getActivity())));
            this.bor = 0;
            this.boo.gC(this.bor);
            this.boo.notifyDataSetChanged();
            TiebaStatic.log("contacts_new");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001185));
        } else if (i == 1) {
            sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            TiebaStatic.log("contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = this.boo.getItem(i);
            if (item != null && item.getUserId() > 0) {
                if (item.getUserType() == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.Fu(), 0, 4)));
                    return;
                }
                sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.getUserId()), item.getUserName())));
            }
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void iK(String str) {
        int iX;
        List<com.baidu.tbadk.coreExtra.relationship.a> RL = this.bof.RL();
        if (RL != null && RL.size() != 0 && (iX = this.bof.iX(str)) >= 0) {
            this.bon.setSelection(iX + 5);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void Rs() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends com.baidu.adp.framework.listener.c {
        public a() {
            super(304001);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001) {
                AddressListFragment.this.bon.completePullRefreshPostDelayed(2000L);
                if (socketResponsedMessage.hasError() || !(socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
                    AddressListFragment.this.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? AddressListFragment.this.getResources().getString(f.j.neterror) : socketResponsedMessage.getErrorString(), false);
                    return;
                }
                com.baidu.tieba.addresslist.relationship.a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
                ArrayList arrayList = new ArrayList();
                if (addressListData != null) {
                    for (e eVar : addressListData.getAddressList()) {
                        List<com.baidu.tbadk.coreExtra.relationship.a> contacts = eVar.getContacts();
                        if (contacts.size() > 0) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar.fV(eVar.getKey());
                            arrayList.add(aVar);
                        }
                        for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : contacts) {
                            arrayList.add(aVar2);
                        }
                    }
                }
                AddressListFragment.this.bof.Z(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b() {
            super(2001178);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true)) {
                AddressListFragment.this.bon.completePullRefreshPostDelayed(2000L);
            }
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                AddressListFragment.this.bof.Z((List) customResponsedMessage.getData());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c() {
            super(2001174);
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
                        aVar.fV(responseNewFriendUpdateUiMsg.getKey());
                        aVar.setQuanpin(responseNewFriendUpdateUiMsg.getQuanping());
                        aVar.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                        aVar.setUserName(responseNewFriendUpdateUiMsg.getName());
                        aVar.fU(responseNewFriendUpdateUiMsg.getPortrait());
                        AddressListFragment.this.bof.a(aVar);
                    }
                } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                    AddressListFragment.this.bof.aH(responseNewFriendUpdateUiMsg.getFriendId());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public d() {
            super(2001176);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                if (customResponsedMessage.getError() != 0) {
                    AddressListFragment.this.showToast(customResponsedMessage.getErrorString());
                    return;
                }
                AddressListFragment.this.bor = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
                AddressListFragment.this.boo.gC(AddressListFragment.this.bor);
                AddressListFragment.this.boo.notifyDataSetChanged();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001185));
            }
        }
    }
}
