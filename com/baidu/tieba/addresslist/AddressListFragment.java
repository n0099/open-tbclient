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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivityConfig;
import com.baidu.tieba.addresslist.model.AddressListModel;
import com.baidu.tieba.addresslist.relationship.ResponseGetAddressListMessage;
import com.baidu.tieba.addresslist.view.AssortView;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.i0.r.f0.f;
import d.b.i0.r.f0.g;
import d.b.j0.q.d.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AddressListFragment extends BaseFragment implements a.InterfaceC1457a, f.g, AssortView.a {

    /* renamed from: e  reason: collision with root package name */
    public AddressListModel f14237e;

    /* renamed from: f  reason: collision with root package name */
    public b f14238f;

    /* renamed from: g  reason: collision with root package name */
    public c f14239g;

    /* renamed from: h  reason: collision with root package name */
    public d f14240h;
    public e i;
    public long j;
    public d.b.i0.r.c k;
    public View l;
    public AssortView m;
    public LinearLayout n;
    public g o;
    public BdListView p;
    public d.b.j0.q.c.a q;
    public TextView r;
    public ImageView s;
    public int t;
    public BaseFragmentActivity u;
    public final CustomMessageListener v = new a(2000994);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.z() && BdSocketLinkService.isAvailable()) {
                    return;
                }
                AddressListFragment.this.p.A(0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.b.c.c.g.c {
        public b() {
            super(304001);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null || socketResponsedMessage.getCmd() != 304001) {
                return;
            }
            AddressListFragment.this.p.A(0L);
            if (!socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
                d.b.j0.q.f.a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
                ArrayList arrayList = new ArrayList();
                if (addressListData != null) {
                    for (d.b.j0.q.f.e eVar : addressListData.a()) {
                        List<d.b.i0.s.f.a> a2 = eVar.a();
                        if (a2.size() > 0) {
                            d.b.i0.s.f.a aVar = new d.b.i0.s.f.a();
                            aVar.k(eVar.b());
                            arrayList.add(aVar);
                        }
                        for (d.b.i0.s.f.a aVar2 : a2) {
                            arrayList.add(aVar2);
                        }
                    }
                }
                AddressListFragment.this.f14237e.z(arrayList);
                return;
            }
            AddressListFragment.this.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? AddressListFragment.this.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString(), false);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c() {
            super(2001178);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
            if (!j.g("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true)) {
                AddressListFragment.this.p.A(0L);
            }
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            AddressListFragment.this.f14237e.z((List) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d() {
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
                    if (StringUtils.isNull(responseNewFriendUpdateUiMsg.getKey()) || StringUtils.isNull(responseNewFriendUpdateUiMsg.getName())) {
                        return;
                    }
                    d.b.i0.s.f.a aVar = new d.b.i0.s.f.a();
                    aVar.k(responseNewFriendUpdateUiMsg.getKey());
                    aVar.m(responseNewFriendUpdateUiMsg.getQuanping());
                    aVar.n(responseNewFriendUpdateUiMsg.getFriendId());
                    aVar.o(responseNewFriendUpdateUiMsg.getName());
                    aVar.q(responseNewFriendUpdateUiMsg.getPortrait());
                    AddressListFragment.this.f14237e.s(aVar);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                    AddressListFragment.this.f14237e.u(responseNewFriendUpdateUiMsg.getFriendId());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e() {
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
                AddressListFragment.this.t = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
                AddressListFragment.this.q.f(AddressListFragment.this.t);
                AddressListFragment.this.q.notifyDataSetChanged();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001185));
            }
        }
    }

    public final void J0() {
        this.f14237e.w();
    }

    public final void K0() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    public final View L0(LayoutInflater layoutInflater) {
        this.l = LayoutInflater.from(this.u.getPageContext().getPageActivity()).inflate(R.layout.addresslist_fragment, (ViewGroup) null);
        this.o = new g(this.u.getPageContext());
        this.q = new d.b.j0.q.c.a(TbadkCoreApplication.getInst().getApplicationContext(), this.k);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.u.getPageContext().getPageActivity()).inflate(R.layout.addresslist_search_layout, (ViewGroup) null, false);
        this.n = linearLayout;
        linearLayout.setOnClickListener(this);
        this.s = (ImageView) this.n.findViewById(R.id.addresslist_search_icon);
        this.r = (TextView) this.n.findViewById(R.id.addresslist_search_bar);
        BdListView bdListView = (BdListView) this.l.findViewById(R.id.addresslist_contacts_list);
        this.p = bdListView;
        bdListView.setPullRefresh(this.o);
        this.p.addHeaderView(this.n);
        BdListViewHelper.d(this.u.getActivity(), this.p, BdListViewHelper.HeadType.DEFAULT);
        this.p.setAdapter((ListAdapter) this.q);
        this.p.setOnItemClickListener(this);
        this.o.b(this);
        AssortView assortView = (AssortView) this.l.findViewById(R.id.addresslist_assortview);
        this.m = assortView;
        assortView.setClickable(true);
        this.m.setOnTouchListener(this);
        return this.l;
    }

    public final void M0(List<d.b.i0.s.f.a> list) {
        this.q.e(list);
        this.q.f(this.t);
        this.q.notifyDataSetChanged();
        if (list != null && list.size() != 0) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
    }

    public final void N0() {
        b bVar = new b();
        this.f14238f = bVar;
        registerListener(bVar);
        c cVar = new c();
        this.f14239g = cVar;
        registerListener(cVar);
        d dVar = new d();
        this.f14240h = dVar;
        registerListener(dVar);
        e eVar = new e();
        this.i = eVar;
        registerListener(eVar);
        registerListener(this.v);
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void f0(String str) {
        int t;
        List<d.b.i0.s.f.a> v = this.f14237e.v();
        if (v == null || v.size() == 0 || (t = this.f14237e.t(str)) < 0) {
            return;
        }
        this.p.setSelection(t + 5);
    }

    @Override // d.b.j0.q.d.a.InterfaceC1457a
    public void g(List<d.b.i0.s.f.a> list) {
        M0(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f14237e.y(this);
        J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.u = getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.i0.r.c cVar = this.k;
        if (cVar != null) {
            cVar.k(i == 1);
            this.k.j(this.l);
            this.k.j(this.n);
        }
        SkinManager.setBackgroundResource(this.n, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.r, R.drawable.enter_forum_inputbox_top);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0109, 1);
        SkinManager.setBackgroundResource(this.s, R.drawable.icon_head_bar_search);
        this.o.I(i);
        this.q.notifyDataSetChanged();
        this.m.invalidate();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.addresslist_search_layout) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), QuickSearchActivity.class);
            getActivity().startActivity(intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        N0();
        this.j = 0L;
        AddressListModel addressListModel = new AddressListModel(getBaseFragmentActivity());
        this.f14237e = addressListModel;
        addressListModel.setUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity != null) {
            this.k = baseFragmentActivity.getLayoutMode();
        }
        return L0(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f14237e.A(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            sendMessage(new CustomMessage(2002001, new NewFriendsActivityConfig(getActivity())));
            this.t = 0;
            this.q.f(0);
            this.q.notifyDataSetChanged();
            TiebaStatic.log("contacts_new");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001185));
        } else if (i == 1) {
            sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getActivity())));
        } else if (i == 2) {
            sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getActivity(), 0, 1)));
            TiebaStatic.log("contacts_mygp");
        } else {
            d.b.i0.s.f.a item = this.q.getItem(i);
            if (item == null || item.e() <= 0) {
                return;
            }
            if (item.i() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.e(), item.f(), item.h(), 0, 4)));
                return;
            }
            sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.e()), item.f())));
        }
    }

    @Override // d.b.i0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        if (Math.abs(System.currentTimeMillis() - this.j) <= StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD) {
            this.p.A(0L);
        } else if (l.C()) {
            this.j = System.currentTimeMillis();
            this.f14237e.x();
        } else {
            this.p.A(0L);
            showToast(R.string.no_network_guide);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
        if (j.g("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), true)) {
            d.b.i0.r.d0.b j2 = d.b.i0.r.d0.b.j();
            j2.t("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        K0();
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void z0() {
    }
}
