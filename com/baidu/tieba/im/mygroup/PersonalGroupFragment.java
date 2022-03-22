package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.o0.r.l0.f;
import c.a.o0.r.l0.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class PersonalGroupFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;

    /* renamed from: b  reason: collision with root package name */
    public g f33875b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.u1.n.a f33876c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f33877d;

    /* renamed from: e  reason: collision with root package name */
    public View f33878e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f33879f;

    /* renamed from: g  reason: collision with root package name */
    public int f33880g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.d.c.g.c f33881h;
    public final c.a.d.c.g.c i;
    public final c.a.d.c.g.c j;
    public final CustomMessageListener k;
    public final CustomMessageListener l;

    /* loaded from: classes5.dex */
    public class a extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalGroupFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonalGroupFragment personalGroupFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalGroupFragment, Integer.valueOf(i)};
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
            this.a = personalGroupFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.a.f33879f = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalGroupFragment a;

        public b(PersonalGroupFragment personalGroupFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalGroupFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalGroupFragment;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            PersonGroupActivity G0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (G0 = this.a.G0()) == null) {
                return;
            }
            G0.getMyGroupModel().update();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalGroupFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonalGroupFragment personalGroupFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalGroupFragment, Integer.valueOf(i)};
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
            this.a = personalGroupFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                switch (socketResponsedMessage.getCmd()) {
                    case 103101:
                    case 103102:
                    case 103104:
                    case 103105:
                    case 103112:
                    case 2001109:
                        if (!(socketResponsedMessage instanceof ResponsedMessage) || socketResponsedMessage.getError() == 0 || ((socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) && socketResponsedMessage.getError() == 2230110)) {
                            this.a.f33879f = true;
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalGroupFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonalGroupFragment personalGroupFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalGroupFragment, Integer.valueOf(i)};
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
            this.a = personalGroupFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                PersonGroupActivity G0 = this.a.G0();
                if (this.a.getActivity() == null || this.a.a == null || G0 == null || G0.getMyGroupModel() == null) {
                    return;
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    this.a.a.A(0L);
                }
                ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
                if (responseGroupsByUidMessage.getError() != 0) {
                    if (responseGroupsByUidMessage.getError() != 0) {
                        this.a.showToast(StringUtils.isNull(responseGroupsByUidMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c15) : responseGroupsByUidMessage.getErrorString());
                        return;
                    }
                    return;
                }
                List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
                if (this.a.f33880g == 1) {
                    groups = responseGroupsByUidMessage.getCommonGroups();
                }
                if (!G0.getIsHost()) {
                    G0.setGroups(responseGroupsByUidMessage.getGroups());
                    G0.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                G0.updateTabTitle(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    this.a.f33876c.c(groups);
                    this.a.f33876c.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        this.a.f33877d.setVisibility(8);
                        PersonalGroupFragment personalGroupFragment = this.a;
                        personalGroupFragment.a.removeHeaderView(personalGroupFragment.f33877d);
                    } else {
                        this.a.f33877d.setVisibility(0);
                        PersonalGroupFragment personalGroupFragment2 = this.a;
                        personalGroupFragment2.a.removeHeaderView(personalGroupFragment2.f33877d);
                        PersonalGroupFragment personalGroupFragment3 = this.a;
                        personalGroupFragment3.a.addHeaderView(personalGroupFragment3.f33877d);
                    }
                    this.a.a.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    this.a.f33879f = false;
                } else if (socketResponsedMessage.getCmd() != 2001106 || G0.getMyGroupModel() == null) {
                } else {
                    G0.getMyGroupModel().update();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalGroupFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PersonalGroupFragment personalGroupFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalGroupFragment, Integer.valueOf(i)};
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
            this.a = personalGroupFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                PersonGroupActivity G0 = this.a.G0();
                if (this.a.getActivity() == null || this.a.a == null || G0 == null || G0.getMyGroupModel() == null) {
                    return;
                }
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() == 0 || TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        return;
                    }
                    this.a.showToast(responseGroupsByUidLocalMessage.getErrorString());
                    return;
                }
                if (G0.getIsHost()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (this.a.f33880g == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    G0.updateTabTitle(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        this.a.f33876c.c(groups);
                        this.a.f33876c.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            this.a.f33877d.setVisibility(8);
                            PersonalGroupFragment personalGroupFragment = this.a;
                            personalGroupFragment.a.removeHeaderView(personalGroupFragment.f33877d);
                        } else {
                            this.a.f33877d.setVisibility(0);
                            PersonalGroupFragment personalGroupFragment2 = this.a;
                            personalGroupFragment2.a.removeHeaderView(personalGroupFragment2.f33877d);
                            PersonalGroupFragment personalGroupFragment3 = this.a;
                            personalGroupFragment3.a.addHeaderView(personalGroupFragment3.f33877d);
                        }
                        this.a.a.setVisibility(0);
                    }
                }
                if (G0.getMyGroupModel() != null) {
                    G0.getMyGroupModel().update();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalGroupFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PersonalGroupFragment personalGroupFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalGroupFragment, Integer.valueOf(i)};
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
            this.a = personalGroupFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                this.a.H0(p);
            }
        }
    }

    public PersonalGroupFragment() {
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
        this.a = null;
        this.f33875b = null;
        this.f33876c = null;
        this.f33877d = null;
        this.f33878e = null;
        this.f33880g = 0;
        this.f33881h = new a(this, 0);
        this.i = new c(this, 0);
        this.j = new d(this, 0);
        this.k = new e(this, 0);
        this.l = new f(this, 0);
        this.f33879f = false;
    }

    public PersonGroupActivity G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            if (baseFragmentActivity instanceof PersonGroupActivity) {
                return (PersonGroupActivity) baseFragmentActivity;
            }
            return null;
        }
        return (PersonGroupActivity) invokeV.objValue;
    }

    public final void H0(GroupNewsPojo groupNewsPojo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, groupNewsPojo) == null) || groupNewsPojo == null) {
            return;
        }
        try {
            if (TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP.equals(new JSONObject(groupNewsPojo.getContent()).getString(TbEnum.SystemMessage.KEY_EVENT_ID)) && l.z()) {
                this.f33879f = true;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(103003, this.j);
            registerListener(2001106, this.k);
            registerListener(103101, this.i);
            registerListener(103112, this.i);
            registerListener(103102, this.i);
            registerListener(2001109, this.i);
            registerListener(103104, this.i);
            registerListener(103105, this.i);
            registerListener(2001126, this.f33881h);
            registerListener(2001128, this.f33881h);
            registerListener(2001132, this.f33881h);
            registerListener(2001133, this.f33881h);
            registerListener(2001130, this.f33881h);
            registerListener(2001134, this.f33881h);
            registerListener(2001137, this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            c.a.p0.u1.n.a aVar = this.f33876c;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
            NoDataView noDataView = this.f33877d;
            if (noDataView != null) {
                SkinManager.setBackgroundColor(noDataView, R.color.CAM_X0201);
            }
            if (isAdded()) {
                G0().getLayoutMode().j(this.f33878e);
                this.f33875b.H(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            super.onClick(view);
            if (view.getId() == R.id.obfuscated_res_0x7f090656) {
                GroupInfoData groupInfoData = view.getTag() instanceof GroupInfoData ? (GroupInfoData) view.getTag() : null;
                PersonGroupActivity G0 = G0();
                if (G0 == null || G0.onGroupSelected(groupInfoData) || groupInfoData == null) {
                    return;
                }
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), groupInfoData.getGroupId(), 1)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        NoDataViewFactory.e d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f33880g = getArguments().getInt("page_type", 0);
            getArguments().getInt("page_size", 1);
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d06be, viewGroup, false);
            PersonGroupActivity G0 = G0();
            if (G0 != null && !G0.getIsHost()) {
                if (this.f33880g == 0) {
                    d2 = NoDataViewFactory.e.c(String.format(getString(R.string.obfuscated_res_0x7f0f0e10), G0.getUtype()));
                } else {
                    d2 = NoDataViewFactory.e.c(getString(R.string.obfuscated_res_0x7f0f0e0f));
                }
            } else {
                d2 = (G0 == null || !G0.getIsHost()) ? null : NoDataViewFactory.e.d(getString(R.string.obfuscated_res_0x7f0f07dd), getString(R.string.obfuscated_res_0x7f0f07de));
            }
            this.f33877d = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07022a)), d2, null);
            this.a = (BdListView) inflate.findViewById(R.id.obfuscated_res_0x7f0917b2);
            this.f33875b = new g(getPageContext());
            this.f33876c = new c.a.p0.u1.n.a(this);
            this.f33875b.f(new b(this));
            this.a.setPullRefresh(this.f33875b);
            this.a.setAdapter((ListAdapter) this.f33876c);
            this.a.setOnItemClickListener(this);
            this.f33877d.setVisibility(8);
            this.a.removeHeaderView(this.f33877d);
            this.f33878e = inflate.findViewById(R.id.obfuscated_res_0x7f090cf4);
            if (G0() != null && this.f33880g == G0().getCurrentPageType()) {
                this.a.F();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.j);
            MessageManager.getInstance().unRegisterListener(this.i);
            MessageManager.getInstance().unRegisterListener(this.l);
            MessageManager.getInstance().unRegisterListener(this.f33881h);
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            GroupInfoData item = this.f33876c.getItem(i);
            PersonGroupActivity G0 = G0();
            if (G0 == null || G0.onGroupSelected(item) || item == null) {
                return;
            }
            if (this.f33880g != 1 && !G0.getIsHost()) {
                if (G0.isCommonGroup(item.getGroupId())) {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
                    return;
                }
                TiebaStatic.eventStat(getActivity(), "his_group_item", "click", 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), item.getGroupId(), 1)));
                return;
            }
            if (G0.getIsHost()) {
                TiebaStatic.eventStat(getActivity(), "my_group_item", "click", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            if (this.f33879f) {
                this.a.F();
            }
            onChangeSkinType(TbadkApplication.getInst().getSkinType());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStart();
            NoDataView noDataView = this.f33877d;
            if (noDataView != null) {
                noDataView.d(G0().getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onStop();
            NoDataView noDataView = this.f33877d;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }
}
