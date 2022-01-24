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
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.s.k0.f;
import c.a.s0.s.k0.g;
import c.a.t0.x.d.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class AddressListFragment extends BaseFragment implements a.InterfaceC1505a, f.g, AssortView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AddressListModel f41787e;

    /* renamed from: f  reason: collision with root package name */
    public b f41788f;

    /* renamed from: g  reason: collision with root package name */
    public c f41789g;

    /* renamed from: h  reason: collision with root package name */
    public d f41790h;

    /* renamed from: i  reason: collision with root package name */
    public e f41791i;

    /* renamed from: j  reason: collision with root package name */
    public long f41792j;
    public c.a.s0.s.c k;
    public View l;
    public AssortView m;
    public LinearLayout n;
    public g o;
    public BdListView p;
    public c.a.t0.x.c.a q;
    public TextView r;
    public ImageView s;
    public int t;
    public BaseFragmentActivity u;
    public final CustomMessageListener v;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddressListFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AddressListFragment addressListFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addressListFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addressListFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (l.z() && BdSocketLinkService.isAvailable()) {
                    return;
                }
                this.a.p.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddressListFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AddressListFragment addressListFragment) {
            super(304001);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addressListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addressListFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001) {
                this.a.p.completePullRefreshPostDelayed(0L);
                if (!socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
                    c.a.t0.x.f.a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
                    ArrayList arrayList = new ArrayList();
                    if (addressListData != null) {
                        for (c.a.t0.x.f.e eVar : addressListData.a()) {
                            List<c.a.s0.t.f.a> a = eVar.a();
                            if (a.size() > 0) {
                                c.a.s0.t.f.a aVar = new c.a.s0.t.f.a();
                                aVar.k(eVar.b());
                                arrayList.add(aVar);
                            }
                            for (c.a.s0.t.f.a aVar2 : a) {
                                arrayList.add(aVar2);
                            }
                        }
                    }
                    this.a.f41787e.D(arrayList);
                    return;
                }
                this.a.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString(), false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddressListFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AddressListFragment addressListFragment) {
            super(2001178);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addressListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addressListFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                c.a.s0.s.i0.b k = c.a.s0.s.i0.b.k();
                if (!k.h("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    this.a.p.completePullRefreshPostDelayed(0L);
                }
                if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                    return;
                }
                this.a.f41787e.D((List) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddressListFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AddressListFragment addressListFragment) {
            super(2001174);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addressListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addressListFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                if (customResponsedMessage.getError() != 0) {
                    this.a.showToast(customResponsedMessage.getErrorString());
                    return;
                }
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    if (StringUtils.isNull(responseNewFriendUpdateUiMsg.getKey()) || StringUtils.isNull(responseNewFriendUpdateUiMsg.getName())) {
                        return;
                    }
                    c.a.s0.t.f.a aVar = new c.a.s0.t.f.a();
                    aVar.k(responseNewFriendUpdateUiMsg.getKey());
                    aVar.m(responseNewFriendUpdateUiMsg.getQuanping());
                    aVar.n(responseNewFriendUpdateUiMsg.getFriendId());
                    aVar.o(responseNewFriendUpdateUiMsg.getName());
                    aVar.q(responseNewFriendUpdateUiMsg.getPortrait());
                    this.a.f41787e.w(aVar);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                    this.a.f41787e.y(responseNewFriendUpdateUiMsg.getFriendId());
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddressListFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AddressListFragment addressListFragment) {
            super(2001176);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addressListFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addressListFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                if (customResponsedMessage.getError() != 0) {
                    this.a.showToast(customResponsedMessage.getErrorString());
                    return;
                }
                this.a.t = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
                this.a.q.f(this.a.t);
                this.a.q.notifyDataSetChanged();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001185));
            }
        }
    }

    public AddressListFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new a(this, 2000994);
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f41787e.A();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
        }
    }

    public final View l(LayoutInflater layoutInflater) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
            this.l = LayoutInflater.from(this.u.getPageContext().getPageActivity()).inflate(R.layout.addresslist_fragment, (ViewGroup) null);
            this.o = new g(this.u.getPageContext());
            this.q = new c.a.t0.x.c.a(TbadkCoreApplication.getInst().getApplicationContext(), this.k);
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
            this.o.a(this);
            AssortView assortView = (AssortView) this.l.findViewById(R.id.addresslist_assortview);
            this.m = assortView;
            assortView.setClickable(true);
            this.m.setOnTouchListener(this);
            return this.l;
        }
        return (View) invokeL.objValue;
    }

    public final void n(List<c.a.s0.t.f.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.q.e(list);
            this.q.f(this.t);
            this.q.notifyDataSetChanged();
            if (list != null && list.size() != 0) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
        }
    }

    @Override // c.a.t0.x.d.a.InterfaceC1505a
    public void notifyCacheDataChanged(List<c.a.s0.t.f.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            n(list);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b bVar = new b(this);
            this.f41788f = bVar;
            registerListener(bVar);
            c cVar = new c(this);
            this.f41789g = cVar;
            registerListener(cVar);
            d dVar = new d(this);
            this.f41790h = dVar;
            registerListener(dVar);
            e eVar = new e(this);
            this.f41791i = eVar;
            registerListener(eVar);
            registerListener(this.v);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.f41787e.C(this);
            j();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            super.onAttach(activity);
            this.u = getBaseFragmentActivity();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.s0.s.c cVar = this.k;
            if (cVar != null) {
                cVar.k(i2 == 1);
                this.k.j(this.l);
                this.k.j(this.n);
            }
            SkinManager.setBackgroundResource(this.n, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.r, R.drawable.enter_forum_inputbox_top);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0109, 1);
            SkinManager.setBackgroundResource(this.s, R.drawable.icon_head_bar_search);
            this.o.C(i2);
            this.q.notifyDataSetChanged();
            this.m.invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, view) == null) && view.getId() == R.id.addresslist_search_layout) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), QuickSearchActivity.class);
            getActivity().startActivity(intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            o();
            this.f41792j = 0L;
            AddressListModel addressListModel = new AddressListModel(getBaseFragmentActivity());
            this.f41787e = addressListModel;
            addressListModel.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            if (baseFragmentActivity != null) {
                this.k = baseFragmentActivity.getLayoutMode();
            }
            return l(layoutInflater);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            this.f41787e.E(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (i2 == 0) {
                sendMessage(new CustomMessage(2002001, new NewFriendsActivityConfig(getActivity())));
                this.t = 0;
                this.q.f(0);
                this.q.notifyDataSetChanged();
                TiebaStatic.log("contacts_new");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001185));
            } else if (i2 == 1) {
                sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getActivity())));
            } else if (i2 == 2) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getActivity(), 0, 1)));
                TiebaStatic.log("contacts_mygp");
            } else {
                c.a.s0.t.f.a item = this.q.getItem(i2);
                if (item == null || item.e() <= 0) {
                    return;
                }
                if (item.i() == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.e(), item.f(), item.h(), 0, 4)));
                } else {
                    sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.e()), item.f())));
                }
            }
        }
    }

    @Override // c.a.s0.s.k0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (Math.abs(System.currentTimeMillis() - this.f41792j) <= 30000) {
                this.p.completePullRefreshPostDelayed(0L);
            } else if (n.C()) {
                this.f41792j = System.currentTimeMillis();
                this.f41787e.B();
            } else {
                this.p.completePullRefreshPostDelayed(0L);
                showToast(R.string.no_network_guide);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPrimary();
            c.a.s0.s.i0.b k = c.a.s0.s.i0.b.k();
            if (k.h("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                c.a.s0.s.i0.b k2 = c.a.s0.s.i0.b.k();
                k2.u("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            k();
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void onTouchDown(String str) {
        List<c.a.s0.t.f.a> z;
        int x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || (z = this.f41787e.z()) == null || z.size() == 0 || (x = this.f41787e.x(str)) < 0) {
            return;
        }
        this.p.setSelection(x + 5);
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void onTouchUP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }
}
