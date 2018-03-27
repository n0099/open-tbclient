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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
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
public class a extends BaseFragment implements j.b, a.InterfaceC0128a, AssortView.a {
    private AddressListModel bTK;
    private C0126a bTL;
    private b bTM;
    private c bTN;
    private d bTO;
    private long bTP;
    private AssortView bTQ;
    private LinearLayout bTR;
    private BdListView bTS;
    private com.baidu.tieba.addresslist.a.a bTT;
    private TextView bTU;
    private ImageView bTV;
    private int bTW;
    private BaseFragmentActivity bTX;
    private com.baidu.tbadk.core.c mLayoutMode;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.addresslist.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (!com.baidu.adp.lib.util.j.oJ() || !BdSocketLinkService.isAvailable()) {
                    a.this.bTS.completePullRefreshPostDelayed(2000L);
                }
            }
        }
    };
    private View mParent;
    private k mPullView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener();
        this.bTP = 0L;
        this.bTK = new AddressListModel(getBaseFragmentActivity());
        this.bTK.setUniqueId(getUniqueId());
    }

    private void registerListener() {
        this.bTL = new C0126a();
        registerListener(this.bTL);
        this.bTM = new b();
        registerListener(this.bTM);
        this.bTN = new c();
        registerListener(this.bTN);
        this.bTO = new d();
        registerListener(this.bTO);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.bTX = getBaseFragmentActivity();
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
        UJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.bTK.b(this);
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
        this.mParent = LayoutInflater.from(this.bTX.getPageContext().getPageActivity()).inflate(d.h.addresslist_fragment, (ViewGroup) null);
        this.mPullView = new k(this.bTX.getPageContext());
        this.bTT = new com.baidu.tieba.addresslist.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mLayoutMode);
        this.bTR = (LinearLayout) LayoutInflater.from(this.bTX.getPageContext().getPageActivity()).inflate(d.h.addresslist_search_layout, (ViewGroup) null, false);
        this.bTR.setOnClickListener(this);
        this.bTV = (ImageView) this.bTR.findViewById(d.g.addresslist_search_icon);
        this.bTU = (TextView) this.bTR.findViewById(d.g.addresslist_search_bar);
        this.bTS = (BdListView) this.mParent.findViewById(d.g.addresslist_contacts_list);
        this.bTS.setPullRefresh(this.mPullView);
        this.bTS.addHeaderView(this.bTR);
        BdListViewHelper.a(this.bTX.getActivity(), this.bTS, BdListViewHelper.HeadType.DEFAULT);
        this.bTS.setAdapter((ListAdapter) this.bTT);
        this.bTS.setOnItemClickListener(this);
        this.mPullView.a(this);
        this.bTQ = (AssortView) this.mParent.findViewById(d.g.addresslist_assortview);
        this.bTQ.setClickable(true);
        this.bTQ.setOnTouchListener(this);
        return this.mParent;
    }

    private void UI() {
        this.bTK.Vf();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.bTK.a(this);
        UI();
    }

    private void UJ() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void aa(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bTT.setContacts(list);
        this.bTT.jq(this.bTW);
        this.bTT.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.bTQ.setVisibility(8);
        } else {
            this.bTQ.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.addresslist.b.a.InterfaceC0128a
    public void ab(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        aa(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mLayoutMode != null) {
            this.mLayoutMode.aQ(i == 1);
            this.mLayoutMode.aM(this.mParent);
            this.mLayoutMode.aM(this.bTR);
        }
        aj.s(this.bTR, d.C0141d.cp_bg_line_d);
        aj.s(this.bTU, d.f.enter_forum_inputbox_top);
        aj.e(this.bTU, d.C0141d.cp_cont_d, 1);
        aj.s(this.bTV, d.f.icon_head_bar_search);
        this.mPullView.gx(i);
        this.bTT.notifyDataSetChanged();
        this.bTQ.invalidate();
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bw(boolean z) {
        if (Math.abs(System.currentTimeMillis() - this.bTP) <= StatisticConfig.MIN_UPLOAD_INTERVAL) {
            this.bTS.completePullRefreshPostDelayed(2000L);
        } else if (l.pa()) {
            this.bTP = System.currentTimeMillis();
            this.bTK.Va();
        } else {
            this.bTS.completePullRefreshPostDelayed(2000L);
            showToast(d.j.no_network_guide);
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
            this.bTW = 0;
            this.bTT.jq(this.bTW);
            this.bTT.notifyDataSetChanged();
            TiebaStatic.log("contacts_new");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001185));
        } else if (i == 1) {
            sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            TiebaStatic.log("contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = this.bTT.getItem(i);
            if (item != null && item.getUserId() > 0) {
                if (item.getUserType() == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.IT(), 0, 4)));
                    return;
                }
                sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.getUserId()), item.getUserName())));
            }
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void ii(String str) {
        int iv;
        List<com.baidu.tbadk.coreExtra.relationship.a> Ve = this.bTK.Ve();
        if (Ve != null && Ve.size() != 0 && (iv = this.bTK.iv(str)) >= 0) {
            this.bTS.setSelection(iv + 5);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void UK() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.addresslist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0126a extends com.baidu.adp.framework.listener.c {
        public C0126a() {
            super(304001);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001) {
                a.this.bTS.completePullRefreshPostDelayed(2000L);
                if (socketResponsedMessage.hasError() || !(socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
                    a.this.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? a.this.getResources().getString(d.j.neterror) : socketResponsedMessage.getErrorString(), false);
                    return;
                }
                com.baidu.tieba.addresslist.relationship.a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
                ArrayList arrayList = new ArrayList();
                if (addressListData != null) {
                    for (e eVar : addressListData.getAddressList()) {
                        List<com.baidu.tbadk.coreExtra.relationship.a> contacts = eVar.getContacts();
                        if (contacts.size() > 0) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar.fE(eVar.getKey());
                            arrayList.add(aVar);
                        }
                        for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : contacts) {
                            arrayList.add(aVar2);
                        }
                    }
                }
                a.this.bTK.af(arrayList);
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
                a.this.bTS.completePullRefreshPostDelayed(2000L);
            }
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                a.this.bTK.af((List) customResponsedMessage.getData());
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
                    a.this.showToast(customResponsedMessage.getErrorString());
                    return;
                }
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    if (!StringUtils.isNull(responseNewFriendUpdateUiMsg.getKey()) && !StringUtils.isNull(responseNewFriendUpdateUiMsg.getName())) {
                        com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                        aVar.fE(responseNewFriendUpdateUiMsg.getKey());
                        aVar.setQuanpin(responseNewFriendUpdateUiMsg.getQuanping());
                        aVar.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                        aVar.setUserName(responseNewFriendUpdateUiMsg.getName());
                        aVar.fD(responseNewFriendUpdateUiMsg.getPortrait());
                        a.this.bTK.a(aVar);
                    }
                } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                    a.this.bTK.aI(responseNewFriendUpdateUiMsg.getFriendId());
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
                    a.this.showToast(customResponsedMessage.getErrorString());
                    return;
                }
                a.this.bTW = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
                a.this.bTT.jq(a.this.bTW);
                a.this.bTT.notifyDataSetChanged();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001185));
            }
        }
    }
}
