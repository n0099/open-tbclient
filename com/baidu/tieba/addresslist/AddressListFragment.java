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
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.o0.s.f0.f;
import c.a.o0.s.f0.g;
import c.a.p0.s.d.a;
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
/* loaded from: classes6.dex */
public class AddressListFragment extends BaseFragment implements a.InterfaceC1105a, f.g, AssortView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AddressListModel f48979e;

    /* renamed from: f  reason: collision with root package name */
    public b f48980f;

    /* renamed from: g  reason: collision with root package name */
    public c f48981g;

    /* renamed from: h  reason: collision with root package name */
    public d f48982h;

    /* renamed from: i  reason: collision with root package name */
    public e f48983i;

    /* renamed from: j  reason: collision with root package name */
    public long f48984j;
    public c.a.o0.s.c k;
    public View l;
    public AssortView m;
    public LinearLayout n;
    public g o;
    public BdListView p;
    public c.a.p0.s.c.a q;
    public TextView r;
    public ImageView s;
    public int t;
    public BaseFragmentActivity u;
    public final CustomMessageListener v;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AddressListFragment f48985a;

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
            this.f48985a = addressListFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.z() && BdSocketLinkService.isAvailable()) {
                    return;
                }
                this.f48985a.p.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AddressListFragment f48986a;

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
            this.f48986a = addressListFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001) {
                this.f48986a.p.completePullRefreshPostDelayed(0L);
                if (!socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
                    c.a.p0.s.f.a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
                    ArrayList arrayList = new ArrayList();
                    if (addressListData != null) {
                        for (c.a.p0.s.f.e eVar : addressListData.a()) {
                            List<c.a.o0.t.f.a> a2 = eVar.a();
                            if (a2.size() > 0) {
                                c.a.o0.t.f.a aVar = new c.a.o0.t.f.a();
                                aVar.k(eVar.b());
                                arrayList.add(aVar);
                            }
                            for (c.a.o0.t.f.a aVar2 : a2) {
                                arrayList.add(aVar2);
                            }
                        }
                    }
                    this.f48986a.f48979e.D(arrayList);
                    return;
                }
                this.f48986a.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? this.f48986a.getResources().getString(R.string.neterror) : socketResponsedMessage.getErrorString(), false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AddressListFragment f48987a;

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
            this.f48987a = addressListFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                c.a.o0.s.d0.b j2 = c.a.o0.s.d0.b.j();
                if (!j2.g("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    this.f48987a.p.completePullRefreshPostDelayed(0L);
                }
                if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                    return;
                }
                this.f48987a.f48979e.D((List) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AddressListFragment f48988a;

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
            this.f48988a = addressListFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                if (customResponsedMessage.getError() != 0) {
                    this.f48988a.showToast(customResponsedMessage.getErrorString());
                    return;
                }
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    if (StringUtils.isNull(responseNewFriendUpdateUiMsg.getKey()) || StringUtils.isNull(responseNewFriendUpdateUiMsg.getName())) {
                        return;
                    }
                    c.a.o0.t.f.a aVar = new c.a.o0.t.f.a();
                    aVar.k(responseNewFriendUpdateUiMsg.getKey());
                    aVar.m(responseNewFriendUpdateUiMsg.getQuanping());
                    aVar.n(responseNewFriendUpdateUiMsg.getFriendId());
                    aVar.o(responseNewFriendUpdateUiMsg.getName());
                    aVar.q(responseNewFriendUpdateUiMsg.getPortrait());
                    this.f48988a.f48979e.w(aVar);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                    this.f48988a.f48979e.y(responseNewFriendUpdateUiMsg.getFriendId());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AddressListFragment f48989a;

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
            this.f48989a = addressListFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
                if (customResponsedMessage.getError() != 0) {
                    this.f48989a.showToast(customResponsedMessage.getErrorString());
                    return;
                }
                this.f48989a.t = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
                this.f48989a.q.f(this.f48989a.t);
                this.f48989a.q.notifyDataSetChanged();
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

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f48979e.A();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
        }
    }

    public final View i(LayoutInflater layoutInflater) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
            this.l = LayoutInflater.from(this.u.getPageContext().getPageActivity()).inflate(R.layout.addresslist_fragment, (ViewGroup) null);
            this.o = new g(this.u.getPageContext());
            this.q = new c.a.p0.s.c.a(TbadkCoreApplication.getInst().getApplicationContext(), this.k);
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

    public final void j(List<c.a.o0.t.f.a> list) {
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

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b bVar = new b(this);
            this.f48980f = bVar;
            registerListener(bVar);
            c cVar = new c(this);
            this.f48981g = cVar;
            registerListener(cVar);
            d dVar = new d(this);
            this.f48982h = dVar;
            registerListener(dVar);
            e eVar = new e(this);
            this.f48983i = eVar;
            registerListener(eVar);
            registerListener(this.v);
        }
    }

    @Override // c.a.p0.s.d.a.InterfaceC1105a
    public void notifyCacheDataChanged(List<c.a.o0.t.f.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            j(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.f48979e.C(this);
            g();
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
            c.a.o0.s.c cVar = this.k;
            if (cVar != null) {
                cVar.k(i2 == 1);
                this.k.j(this.l);
                this.k.j(this.n);
            }
            SkinManager.setBackgroundResource(this.n, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.r, R.drawable.enter_forum_inputbox_top);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0109, 1);
            SkinManager.setBackgroundResource(this.s, R.drawable.icon_head_bar_search);
            this.o.D(i2);
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
            k();
            this.f48984j = 0L;
            AddressListModel addressListModel = new AddressListModel(getBaseFragmentActivity());
            this.f48979e = addressListModel;
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
            return i(layoutInflater);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            this.f48979e.E(this);
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
                c.a.o0.t.f.a item = this.q.getItem(i2);
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

    @Override // c.a.o0.s.f0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (Math.abs(System.currentTimeMillis() - this.f48984j) <= 30000) {
                this.p.completePullRefreshPostDelayed(0L);
            } else if (l.D()) {
                this.f48984j = System.currentTimeMillis();
                this.f48979e.B();
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
            c.a.o0.s.d0.b j2 = c.a.o0.s.d0.b.j();
            if (j2.g("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                c.a.o0.s.d0.b j3 = c.a.o0.s.d0.b.j();
                j3.t("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            h();
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void onTouchDown(String str) {
        List<c.a.o0.t.f.a> z;
        int x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || (z = this.f48979e.z()) == null || z.size() == 0 || (x = this.f48979e.x(str)) < 0) {
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
