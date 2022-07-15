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
import com.repackage.al5;
import com.repackage.az4;
import com.repackage.bb;
import com.repackage.bl5;
import com.repackage.fu4;
import com.repackage.gu4;
import com.repackage.hl5;
import com.repackage.ll5;
import com.repackage.ni;
import com.repackage.pi;
import com.repackage.rm4;
import com.repackage.xt4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AddressListFragment extends BaseFragment implements bl5.a, fu4.g, AssortView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AddressListModel a;
    public b b;
    public c c;
    public d d;
    public e e;
    public long f;
    public rm4 g;
    public View h;
    public AssortView i;
    public LinearLayout j;
    public gu4 k;
    public BdListView l;
    public al5 m;
    public TextView n;
    public ImageView o;
    public int p;
    public BaseFragmentActivity q;
    public final CustomMessageListener r;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddressListFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AddressListFragment addressListFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addressListFragment, Integer.valueOf(i)};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (ni.z() && BdSocketLinkService.isAvailable()) {
                    return;
                }
                this.a.l.A(0L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends bb {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.l.A(0L);
                if (!socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
                    hl5 addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
                    ArrayList arrayList = new ArrayList();
                    if (addressListData != null) {
                        for (ll5 ll5Var : addressListData.a()) {
                            List<az4> a = ll5Var.a();
                            if (a.size() > 0) {
                                az4 az4Var = new az4();
                                az4Var.j(ll5Var.b());
                                arrayList.add(az4Var);
                            }
                            for (az4 az4Var2 : a) {
                                arrayList.add(az4Var2);
                            }
                        }
                    }
                    this.a.a.H(arrayList);
                    return;
                }
                this.a.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c2b) : socketResponsedMessage.getErrorString(), false);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                xt4 k = xt4.k();
                if (!k.h("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    this.a.l.A(0L);
                }
                if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                    return;
                }
                this.a.a.H((List) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    az4 az4Var = new az4();
                    az4Var.j(responseNewFriendUpdateUiMsg.getKey());
                    az4Var.l(responseNewFriendUpdateUiMsg.getQuanping());
                    az4Var.m(responseNewFriendUpdateUiMsg.getFriendId());
                    az4Var.n(responseNewFriendUpdateUiMsg.getName());
                    az4Var.p(responseNewFriendUpdateUiMsg.getPortrait());
                    this.a.a.A(az4Var);
                } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                    this.a.a.C(responseNewFriendUpdateUiMsg.getFriendId());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.p = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
                this.a.m.f(this.a.p);
                this.a.m.notifyDataSetChanged();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001185));
            }
        }
    }

    public AddressListFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new a(this, 2000994);
    }

    public final View A1(LayoutInflater layoutInflater) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, layoutInflater)) == null) {
            this.h = LayoutInflater.from(this.q.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0079, (ViewGroup) null);
            this.k = new gu4(this.q.getPageContext());
            this.m = new al5(TbadkCoreApplication.getInst().getApplicationContext(), this.g);
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.q.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d007d, (ViewGroup) null, false);
            this.j = linearLayout;
            linearLayout.setOnClickListener(this);
            this.o = (ImageView) this.j.findViewById(R.id.obfuscated_res_0x7f09013a);
            this.n = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f090139);
            BdListView bdListView = (BdListView) this.h.findViewById(R.id.obfuscated_res_0x7f090130);
            this.l = bdListView;
            bdListView.setPullRefresh(this.k);
            this.l.addHeaderView(this.j);
            BdListViewHelper.d(this.q.getActivity(), this.l, BdListViewHelper.HeadType.DEFAULT);
            this.l.setAdapter((ListAdapter) this.m);
            this.l.setOnItemClickListener(this);
            this.k.f(this);
            AssortView assortView = (AssortView) this.h.findViewById(R.id.obfuscated_res_0x7f09012c);
            this.i = assortView;
            assortView.setClickable(true);
            this.i.setOnTouchListener(this);
            return this.h;
        }
        return (View) invokeL.objValue;
    }

    public final void B1(List<az4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.m.e(list);
            this.m.f(this.p);
            this.m.notifyDataSetChanged();
            if (list != null && list.size() != 0) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b bVar = new b(this);
            this.b = bVar;
            registerListener(bVar);
            c cVar = new c(this);
            this.c = cVar;
            registerListener(cVar);
            d dVar = new d(this);
            this.d = dVar;
            registerListener(dVar);
            e eVar = new e(this);
            this.e = eVar;
            registerListener(eVar);
            registerListener(this.r);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void c1(String str) {
        List<az4> D;
        int B;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (D = this.a.D()) == null || D.size() == 0 || (B = this.a.B(str)) < 0) {
            return;
        }
        this.l.setSelection(B + 5);
    }

    @Override // com.repackage.fu4.g
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (Math.abs(System.currentTimeMillis() - this.f) <= 30000) {
                this.l.A(0L);
            } else if (pi.D()) {
                this.f = System.currentTimeMillis();
                this.a.F();
            } else {
                this.l.A(0L);
                showToast(R.string.obfuscated_res_0x7f0f0c64);
            }
        }
    }

    @Override // com.baidu.tieba.addresslist.view.AssortView.a
    public void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.a.G(this);
            x1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            super.onAttach(activity);
            this.q = getBaseFragmentActivity();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            rm4 rm4Var = this.g;
            if (rm4Var != null) {
                rm4Var.k(i == 1);
                this.g.j(this.h);
                this.g.j(this.j);
            }
            SkinManager.setBackgroundResource(this.j, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.n, R.drawable.enter_forum_inputbox_top);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1);
            SkinManager.setBackgroundResource(this.o, R.drawable.icon_head_bar_search);
            this.k.H(i);
            this.m.notifyDataSetChanged();
            this.i.invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f09013b) {
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
            C1();
            this.f = 0L;
            AddressListModel addressListModel = new AddressListModel(getBaseFragmentActivity());
            this.a = addressListModel;
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
                this.g = baseFragmentActivity.getLayoutMode();
            }
            return A1(layoutInflater);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            this.a.I(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (i == 0) {
                sendMessage(new CustomMessage(2002001, new NewFriendsActivityConfig(getActivity())));
                this.p = 0;
                this.m.f(0);
                this.m.notifyDataSetChanged();
                TiebaStatic.log("contacts_new");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001185));
            } else if (i == 1) {
                sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getActivity())));
            } else if (i == 2) {
                sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(getActivity(), 0, 1)));
                TiebaStatic.log("contacts_mygp");
            } else {
                az4 item = this.m.getItem(i);
                if (item == null || item.d() <= 0) {
                    return;
                }
                if (item.h() == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.d(), item.e(), item.g(), 0, 4)));
                } else {
                    sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.d()), item.e())));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            xt4 k = xt4.k();
            if (k.h("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                xt4 k2 = xt4.k();
                k2.u("show_new_icon_for_new_friend_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            y1();
        }
    }

    @Override // com.repackage.bl5.a
    public void p(List<az4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            B1(list);
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.a.E();
        }
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
        }
    }
}
