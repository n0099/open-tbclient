package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
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
import d.a.d.e.p.j;
import d.a.p0.s.f0.f;
import d.a.p0.s.f0.g;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PersonalGroupFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f17699e;

    /* renamed from: f  reason: collision with root package name */
    public g f17700f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.i1.n.a f17701g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f17702h;

    /* renamed from: i  reason: collision with root package name */
    public View f17703i;
    public boolean j;
    public int k;
    public final d.a.d.c.g.c l;
    public final d.a.d.c.g.c m;
    public final d.a.d.c.g.c n;
    public final CustomMessageListener o;
    public final CustomMessageListener p;

    /* loaded from: classes4.dex */
    public class a extends d.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalGroupFragment f17704a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonalGroupFragment personalGroupFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalGroupFragment, Integer.valueOf(i2)};
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
            this.f17704a = personalGroupFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.f17704a.j = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalGroupFragment f17705e;

        public b(PersonalGroupFragment personalGroupFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalGroupFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17705e = personalGroupFragment;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            PersonGroupActivity Q0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (Q0 = this.f17705e.Q0()) == null) {
                return;
            }
            Q0.getMyGroupModel().y();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalGroupFragment f17706a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonalGroupFragment personalGroupFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalGroupFragment, Integer.valueOf(i2)};
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
            this.f17706a = personalGroupFragment;
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
                            this.f17706a.j = true;
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalGroupFragment f17707a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonalGroupFragment personalGroupFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalGroupFragment, Integer.valueOf(i2)};
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
            this.f17707a = personalGroupFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                PersonGroupActivity Q0 = this.f17707a.Q0();
                if (this.f17707a.getActivity() == null || this.f17707a.f17699e == null || Q0 == null || Q0.getMyGroupModel() == null) {
                    return;
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    this.f17707a.f17699e.A(0L);
                }
                ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
                if (responseGroupsByUidMessage.getError() != 0) {
                    if (responseGroupsByUidMessage.getError() != 0) {
                        this.f17707a.showToast(StringUtils.isNull(responseGroupsByUidMessage.getErrorString()) ? this.f17707a.getResources().getString(R.string.neterror) : responseGroupsByUidMessage.getErrorString());
                        return;
                    }
                    return;
                }
                List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
                if (this.f17707a.k == 1) {
                    groups = responseGroupsByUidMessage.getCommonGroups();
                }
                if (!Q0.getIsHost()) {
                    Q0.setGroups(responseGroupsByUidMessage.getGroups());
                    Q0.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                Q0.updateTabTitle(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    this.f17707a.f17701g.c(groups);
                    this.f17707a.f17701g.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        this.f17707a.f17702h.setVisibility(8);
                        PersonalGroupFragment personalGroupFragment = this.f17707a;
                        personalGroupFragment.f17699e.removeHeaderView(personalGroupFragment.f17702h);
                    } else {
                        this.f17707a.f17702h.setVisibility(0);
                        PersonalGroupFragment personalGroupFragment2 = this.f17707a;
                        personalGroupFragment2.f17699e.removeHeaderView(personalGroupFragment2.f17702h);
                        PersonalGroupFragment personalGroupFragment3 = this.f17707a;
                        personalGroupFragment3.f17699e.addHeaderView(personalGroupFragment3.f17702h);
                    }
                    this.f17707a.f17699e.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    this.f17707a.j = false;
                } else if (socketResponsedMessage.getCmd() != 2001106 || Q0.getMyGroupModel() == null) {
                } else {
                    Q0.getMyGroupModel().y();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalGroupFragment f17708a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PersonalGroupFragment personalGroupFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalGroupFragment, Integer.valueOf(i2)};
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
            this.f17708a = personalGroupFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                PersonGroupActivity Q0 = this.f17708a.Q0();
                if (this.f17708a.getActivity() == null || this.f17708a.f17699e == null || Q0 == null || Q0.getMyGroupModel() == null) {
                    return;
                }
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() == 0 || TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        return;
                    }
                    this.f17708a.showToast(responseGroupsByUidLocalMessage.getErrorString());
                    return;
                }
                if (Q0.getIsHost()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (this.f17708a.k == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    Q0.updateTabTitle(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        this.f17708a.f17701g.c(groups);
                        this.f17708a.f17701g.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            this.f17708a.f17702h.setVisibility(8);
                            PersonalGroupFragment personalGroupFragment = this.f17708a;
                            personalGroupFragment.f17699e.removeHeaderView(personalGroupFragment.f17702h);
                        } else {
                            this.f17708a.f17702h.setVisibility(0);
                            PersonalGroupFragment personalGroupFragment2 = this.f17708a;
                            personalGroupFragment2.f17699e.removeHeaderView(personalGroupFragment2.f17702h);
                            PersonalGroupFragment personalGroupFragment3 = this.f17708a;
                            personalGroupFragment3.f17699e.addHeaderView(personalGroupFragment3.f17702h);
                        }
                        this.f17708a.f17699e.setVisibility(0);
                    }
                }
                if (Q0.getMyGroupModel() != null) {
                    Q0.getMyGroupModel().y();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalGroupFragment f17709a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PersonalGroupFragment personalGroupFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalGroupFragment, Integer.valueOf(i2)};
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
            this.f17709a = personalGroupFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                this.f17709a.R0(p);
            }
        }
    }

    public PersonalGroupFragment() {
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
        this.f17699e = null;
        this.f17700f = null;
        this.f17701g = null;
        this.f17702h = null;
        this.f17703i = null;
        this.k = 0;
        this.l = new a(this, 0);
        this.m = new c(this, 0);
        this.n = new d(this, 0);
        this.o = new e(this, 0);
        this.p = new f(this, 0);
        this.j = false;
    }

    public PersonGroupActivity Q0() {
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

    public final void R0(GroupNewsPojo groupNewsPojo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, groupNewsPojo) == null) || groupNewsPojo == null) {
            return;
        }
        try {
            if (TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP.equals(new JSONObject(groupNewsPojo.getContent()).getString(TbEnum.SystemMessage.KEY_EVENT_ID)) && j.z()) {
                this.j = true;
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
            registerListener(103003, this.n);
            registerListener(2001106, this.o);
            registerListener(103101, this.m);
            registerListener(103112, this.m);
            registerListener(103102, this.m);
            registerListener(2001109, this.m);
            registerListener(103104, this.m);
            registerListener(103105, this.m);
            registerListener(2001126, this.l);
            registerListener(2001128, this.l);
            registerListener(2001132, this.l);
            registerListener(2001133, this.l);
            registerListener(2001130, this.l);
            registerListener(2001134, this.l);
            registerListener(2001137, this.p);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.q0.i1.n.a aVar = this.f17701g;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
            NoDataView noDataView = this.f17702h;
            if (noDataView != null) {
                SkinManager.setBackgroundColor(noDataView, R.color.CAM_X0201);
            }
            if (isAdded()) {
                Q0().getLayoutMode().j(this.f17703i);
                this.f17700f.I(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            super.onClick(view);
            if (view.getId() == R.id.click_head) {
                GroupInfoData groupInfoData = view.getTag() instanceof GroupInfoData ? (GroupInfoData) view.getTag() : null;
                PersonGroupActivity Q0 = Q0();
                if (Q0 == null || Q0.onGroupSelected(groupInfoData) || groupInfoData == null) {
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
            this.k = getArguments().getInt("page_type", 0);
            getArguments().getInt("page_size", 1);
            View inflate = layoutInflater.inflate(R.layout.person_group_fragment, viewGroup, false);
            PersonGroupActivity Q0 = Q0();
            if (Q0 != null && !Q0.getIsHost()) {
                if (this.k == 0) {
                    d2 = NoDataViewFactory.e.c(String.format(getString(R.string.person_group_no_personal_info), Q0.getUtype()));
                } else {
                    d2 = NoDataViewFactory.e.c(getString(R.string.person_group_no_common_info));
                }
            } else {
                d2 = (Q0 == null || !Q0.getIsHost()) ? null : NoDataViewFactory.e.d(getString(R.string.group_no_data_tip), getString(R.string.group_no_data_tip_1));
            }
            this.f17702h = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), d2, null);
            this.f17699e = (BdListView) inflate.findViewById(R.id.person_group_list);
            this.f17700f = new g(getPageContext());
            this.f17701g = new d.a.q0.i1.n.a(this);
            this.f17700f.a(new b(this));
            this.f17699e.setPullRefresh(this.f17700f);
            this.f17699e.setAdapter((ListAdapter) this.f17701g);
            this.f17699e.setOnItemClickListener(this);
            this.f17702h.setVisibility(8);
            this.f17699e.removeHeaderView(this.f17702h);
            this.f17703i = inflate.findViewById(R.id.group_fragment_parent);
            if (Q0() != null && this.k == Q0().getCurrentPageType()) {
                this.f17699e.F();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
            MessageManager.getInstance().unRegisterListener(this.m);
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.l);
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            GroupInfoData item = this.f17701g.getItem(i2);
            PersonGroupActivity Q0 = Q0();
            if (Q0 == null || Q0.onGroupSelected(item) || item == null) {
                return;
            }
            if (this.k != 1 && !Q0.getIsHost()) {
                if (Q0.isCommonGroup(item.getGroupId())) {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
                    return;
                }
                TiebaStatic.eventStat(getActivity(), "his_group_item", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), item.getGroupId(), 1)));
                return;
            }
            if (Q0.getIsHost()) {
                TiebaStatic.eventStat(getActivity(), "my_group_item", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getActivity(), "common_group_item", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            if (this.j) {
                this.f17699e.F();
            }
            onChangeSkinType(TbadkApplication.getInst().getSkinType());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStart();
            NoDataView noDataView = this.f17702h;
            if (noDataView != null) {
                noDataView.d(Q0().getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onStop();
            NoDataView noDataView = this.f17702h;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }
}
