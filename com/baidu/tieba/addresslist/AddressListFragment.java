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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
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
import com.baidu.tieba.d;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AddressListFragment extends BaseFragment implements f.b, a.InterfaceC0131a, AssortView.a {
    private AddressListModel blY;
    private a blZ;
    private b bma;
    private c bmb;
    private d bmc;
    private long bmd;
    private AssortView bme;
    private LinearLayout bmf;
    private BdListView bmg;
    private com.baidu.tieba.addresslist.a.a bmh;
    private TextView bmi;
    private ImageView bmj;
    private int bmk;
    private BaseFragmentActivity bml;
    private com.baidu.tbadk.core.c mLayoutMode;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.addresslist.AddressListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (!j.jD() || !BdSocketLinkService.isAvailable()) {
                    AddressListFragment.this.bmg.completePullRefreshPostDelayed(2000L);
                }
            }
        }
    };
    private View mParent;
    private g mPullView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener();
        this.bmd = 0L;
        this.blY = new AddressListModel(getBaseFragmentActivity());
        this.blY.setUniqueId(getUniqueId());
    }

    private void registerListener() {
        this.blZ = new a();
        registerListener(this.blZ);
        this.bma = new b();
        registerListener(this.bma);
        this.bmb = new c();
        registerListener(this.bmb);
        this.bmc = new d();
        registerListener(this.bmc);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.bml = getBaseFragmentActivity();
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
        QI();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.blY.b(this);
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
        this.mParent = LayoutInflater.from(this.bml.getPageContext().getPageActivity()).inflate(d.i.addresslist_fragment, (ViewGroup) null);
        this.mPullView = new g(this.bml.getPageContext());
        this.bmh = new com.baidu.tieba.addresslist.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mLayoutMode);
        this.bmf = (LinearLayout) LayoutInflater.from(this.bml.getPageContext().getPageActivity()).inflate(d.i.addresslist_search_layout, (ViewGroup) null, false);
        this.bmf.setOnClickListener(this);
        this.bmj = (ImageView) this.bmf.findViewById(d.g.addresslist_search_icon);
        this.bmi = (TextView) this.bmf.findViewById(d.g.addresslist_search_bar);
        this.bmg = (BdListView) this.mParent.findViewById(d.g.addresslist_contacts_list);
        this.bmg.setPullRefresh(this.mPullView);
        this.bmg.addHeaderView(this.bmf);
        BdListViewHelper.a(this.bml.getActivity(), this.bmg, BdListViewHelper.HeadType.DEFAULT);
        this.bmg.setAdapter((ListAdapter) this.bmh);
        this.bmg.setOnItemClickListener(this);
        this.mPullView.a(this);
        this.bme = (AssortView) this.mParent.findViewById(d.g.addresslist_assortview);
        this.bme.setClickable(true);
        this.bme.setOnTouchListener(this);
        return this.mParent;
    }

    private void QH() {
        this.blY.Rd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.blY.a(this);
        QH();
    }

    private void QI() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void U(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bmh.setContacts(list);
        this.bmh.gw(this.bmk);
        this.bmh.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.bme.setVisibility(8);
        } else {
            this.bme.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.addresslist.b.a.InterfaceC0131a
    public void V(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        U(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mLayoutMode != null) {
            this.mLayoutMode.setNightMode(i == 1);
            this.mLayoutMode.onModeChanged(this.mParent);
            this.mLayoutMode.onModeChanged(this.bmf);
        }
        al.i(this.bmf, d.C0141d.cp_bg_line_d);
        al.i(this.bmi, d.f.enter_forum_inputbox_top);
        al.c(this.bmi, d.C0141d.cp_cont_d, 1);
        al.i(this.bmj, d.f.icon_head_bar_search);
        this.mPullView.dy(i);
        this.bmh.notifyDataSetChanged();
        this.bme.invalidate();
    }

    @Override // com.baidu.tbadk.core.view.f.b
    public void aS(boolean z) {
        if (Math.abs(System.currentTimeMillis() - this.bmd) <= StatisticConfig.MIN_UPLOAD_INTERVAL) {
            this.bmg.completePullRefreshPostDelayed(2000L);
        } else if (l.jU()) {
            this.bmd = System.currentTimeMillis();
            this.blY.QY();
        } else {
            this.bmg.completePullRefreshPostDelayed(2000L);
            showToast(d.k.no_network_guide);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.addresslist_search_layout) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), QuickSearchActivity.class);
            getActivity().startActivity(intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            sendMessage(new CustomMessage(2002001, new NewFriendsActivityConfig(getActivity())));
            this.bmk = 0;
            this.bmh.gw(this.bmk);
            this.bmh.notifyDataSetChanged();
            TiebaStatic.log("contacts_new");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001185));
        } else if (i == 1) {
            sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            TiebaStatic.log("contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = this.bmh.getItem(i);
            if (item != null && item.getUserId() > 0) {
                if (item.getUserType() == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.Fg(), 0, 4)));
                    return;
                }
                sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.getUserId()), item.getUserName())));
            }
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void iH(String str) {
        int iU;
        List<com.baidu.tbadk.coreExtra.relationship.a> Rc = this.blY.Rc();
        if (Rc != null && Rc.size() != 0 && (iU = this.blY.iU(str)) >= 0) {
            this.bmg.setSelection(iU + 5);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void QJ() {
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
                AddressListFragment.this.bmg.completePullRefreshPostDelayed(2000L);
                if (socketResponsedMessage.hasError() || !(socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
                    AddressListFragment.this.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? AddressListFragment.this.getResources().getString(d.k.neterror) : socketResponsedMessage.getErrorString(), false);
                    return;
                }
                com.baidu.tieba.addresslist.relationship.a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
                ArrayList arrayList = new ArrayList();
                if (addressListData != null) {
                    for (e eVar : addressListData.getAddressList()) {
                        List<com.baidu.tbadk.coreExtra.relationship.a> contacts = eVar.getContacts();
                        if (contacts.size() > 0) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar.fT(eVar.getKey());
                            arrayList.add(aVar);
                        }
                        for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : contacts) {
                            arrayList.add(aVar2);
                        }
                    }
                }
                AddressListFragment.this.blY.Z(arrayList);
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
                AddressListFragment.this.bmg.completePullRefreshPostDelayed(2000L);
            }
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                AddressListFragment.this.blY.Z((List) customResponsedMessage.getData());
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
                        aVar.fT(responseNewFriendUpdateUiMsg.getKey());
                        aVar.setQuanpin(responseNewFriendUpdateUiMsg.getQuanping());
                        aVar.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                        aVar.setUserName(responseNewFriendUpdateUiMsg.getName());
                        aVar.fS(responseNewFriendUpdateUiMsg.getPortrait());
                        AddressListFragment.this.blY.a(aVar);
                    }
                } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                    AddressListFragment.this.blY.aD(responseNewFriendUpdateUiMsg.getFriendId());
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
                AddressListFragment.this.bmk = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
                AddressListFragment.this.bmh.gw(AddressListFragment.this.bmk);
                AddressListFragment.this.bmh.notifyDataSetChanged();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001185));
            }
        }
    }
}
