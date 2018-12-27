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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
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
import com.baidu.tieba.addresslist.view.AssortView;
import com.baidu.tieba.e;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AddressListFragment extends BaseFragment implements j.b, a.InterfaceC0188a, AssortView.a {
    private AddressListModel bCk;
    private a bCl;
    private b bCm;
    private c bCn;
    private d bCo;
    private long bCp;
    private AssortView bCq;
    private LinearLayout bCr;
    private BdListView bCs;
    private com.baidu.tieba.addresslist.a.a bCt;
    private TextView bCu;
    private ImageView bCv;
    private int bCw;
    private BaseFragmentActivity bCx;
    private com.baidu.tbadk.core.c mLayoutMode;
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.addresslist.AddressListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (!com.baidu.adp.lib.util.j.kV() || !BdSocketLinkService.isAvailable()) {
                    AddressListFragment.this.bCs.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
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
        this.bCp = 0L;
        this.bCk = new AddressListModel(getBaseFragmentActivity());
        this.bCk.setUniqueId(getUniqueId());
    }

    private void registerListener() {
        this.bCl = new a();
        registerListener(this.bCl);
        this.bCm = new b();
        registerListener(this.bCm);
        this.bCn = new c();
        registerListener(this.bCn);
        this.bCo = new d();
        registerListener(this.bCo);
        registerListener(this.mNetworkChangedMessageListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.bCx = getBaseFragmentActivity();
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
        Ws();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.bCk.b(this);
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
        this.mParent = LayoutInflater.from(this.bCx.getPageContext().getPageActivity()).inflate(e.h.addresslist_fragment, (ViewGroup) null);
        this.mPullView = new k(this.bCx.getPageContext());
        this.bCt = new com.baidu.tieba.addresslist.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.mLayoutMode);
        this.bCr = (LinearLayout) LayoutInflater.from(this.bCx.getPageContext().getPageActivity()).inflate(e.h.addresslist_search_layout, (ViewGroup) null, false);
        this.bCr.setOnClickListener(this);
        this.bCv = (ImageView) this.bCr.findViewById(e.g.addresslist_search_icon);
        this.bCu = (TextView) this.bCr.findViewById(e.g.addresslist_search_bar);
        this.bCs = (BdListView) this.mParent.findViewById(e.g.addresslist_contacts_list);
        this.bCs.setPullRefresh(this.mPullView);
        this.bCs.addHeaderView(this.bCr);
        BdListViewHelper.a(this.bCx.getActivity(), this.bCs, BdListViewHelper.HeadType.DEFAULT);
        this.bCs.setAdapter((ListAdapter) this.bCt);
        this.bCs.setOnItemClickListener(this);
        this.mPullView.a(this);
        this.bCq = (AssortView) this.mParent.findViewById(e.g.addresslist_assortview);
        this.bCq.setClickable(true);
        this.bCq.setOnTouchListener(this);
        return this.mParent;
    }

    private void Wr() {
        this.bCk.WN();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.bCk.a(this);
        Wr();
    }

    private void Ws() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void ad(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bCt.setContacts(list);
        this.bCt.hM(this.bCw);
        this.bCt.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.bCq.setVisibility(8);
        } else {
            this.bCq.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.addresslist.b.a.InterfaceC0188a
    public void ae(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        ad(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mLayoutMode != null) {
            this.mLayoutMode.setNightMode(i == 1);
            this.mLayoutMode.onModeChanged(this.mParent);
            this.mLayoutMode.onModeChanged(this.bCr);
        }
        al.i(this.bCr, e.d.cp_bg_line_d);
        al.i(this.bCu, e.f.enter_forum_inputbox_top);
        al.c(this.bCu, e.d.cp_cont_d, 1);
        al.i(this.bCv, e.f.icon_head_bar_search);
        this.mPullView.ey(i);
        this.bCt.notifyDataSetChanged();
        this.bCq.invalidate();
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bH(boolean z) {
        if (Math.abs(System.currentTimeMillis() - this.bCp) <= StatisticConfig.MIN_UPLOAD_INTERVAL) {
            this.bCs.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        } else if (l.ll()) {
            this.bCp = System.currentTimeMillis();
            this.bCk.WI();
        } else {
            this.bCs.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            showToast(e.j.no_network_guide);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.addresslist_search_layout) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), QuickSearchActivity.class);
            getActivity().startActivity(intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            sendMessage(new CustomMessage(2002001, new NewFriendsActivityConfig(getActivity())));
            this.bCw = 0;
            this.bCt.hM(this.bCw);
            this.bCt.notifyDataSetChanged();
            TiebaStatic.log("contacts_new");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001185));
        } else if (i == 1) {
            sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            TiebaStatic.log("contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = this.bCt.getItem(i);
            if (item != null && item.getUserId() > 0) {
                if (item.getUserType() == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.Kc(), 0, 4)));
                    return;
                }
                sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.getUserId()), item.getUserName())));
            }
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void jU(String str) {
        int kh;
        List<com.baidu.tbadk.coreExtra.relationship.a> WM = this.bCk.WM();
        if (WM != null && WM.size() != 0 && (kh = this.bCk.kh(str)) >= 0) {
            this.bCs.setSelection(kh + 5);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void Wt() {
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
                AddressListFragment.this.bCs.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
                if (socketResponsedMessage.hasError() || !(socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
                    AddressListFragment.this.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? AddressListFragment.this.getResources().getString(e.j.neterror) : socketResponsedMessage.getErrorString(), false);
                    return;
                }
                com.baidu.tieba.addresslist.relationship.a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
                ArrayList arrayList = new ArrayList();
                if (addressListData != null) {
                    for (com.baidu.tieba.addresslist.relationship.e eVar : addressListData.getAddressList()) {
                        List<com.baidu.tbadk.coreExtra.relationship.a> contacts = eVar.getContacts();
                        if (contacts.size() > 0) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar.ha(eVar.getKey());
                            arrayList.add(aVar);
                        }
                        for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : contacts) {
                            arrayList.add(aVar2);
                        }
                    }
                }
                AddressListFragment.this.bCk.ai(arrayList);
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
                AddressListFragment.this.bCs.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            }
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                AddressListFragment.this.bCk.ai((List) customResponsedMessage.getData());
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
                        aVar.ha(responseNewFriendUpdateUiMsg.getKey());
                        aVar.setQuanpin(responseNewFriendUpdateUiMsg.getQuanping());
                        aVar.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                        aVar.setUserName(responseNewFriendUpdateUiMsg.getName());
                        aVar.gZ(responseNewFriendUpdateUiMsg.getPortrait());
                        AddressListFragment.this.bCk.a(aVar);
                    }
                } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                    AddressListFragment.this.bCk.aX(responseNewFriendUpdateUiMsg.getFriendId());
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
                AddressListFragment.this.bCw = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
                AddressListFragment.this.bCt.hM(AddressListFragment.this.bCw);
                AddressListFragment.this.bCt.notifyDataSetChanged();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001185));
            }
        }
    }
}
