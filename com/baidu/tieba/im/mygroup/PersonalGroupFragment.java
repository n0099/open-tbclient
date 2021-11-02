package com.baidu.tieba.im.mygroup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
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
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class PersonalGroupFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public g f50526e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.l1.n.a f50527f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f50528g;

    /* renamed from: h  reason: collision with root package name */
    public View f50529h;

    /* renamed from: i  reason: collision with root package name */
    public int f50530i;
    public boolean isNeedUpdate;
    public final b.a.e.c.g.c j;
    public final b.a.e.c.g.c k;
    public final b.a.e.c.g.c l;
    public final CustomMessageListener m;
    public BdListView mListGroup;
    public final CustomMessageListener n;

    /* loaded from: classes9.dex */
    public class a extends b.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalGroupFragment f50531a;

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
            this.f50531a = personalGroupFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.f50531a.isNeedUpdate = true;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalGroupFragment f50532e;

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
            this.f50532e = personalGroupFragment;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            PersonGroupActivity rootActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (rootActivity = this.f50532e.getRootActivity()) == null) {
                return;
            }
            rootActivity.getMyGroupModel().update();
        }
    }

    /* loaded from: classes9.dex */
    public class c extends b.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalGroupFragment f50533a;

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
            this.f50533a = personalGroupFragment;
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
                            this.f50533a.isNeedUpdate = true;
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends b.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalGroupFragment f50534a;

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
            this.f50534a = personalGroupFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                PersonGroupActivity rootActivity = this.f50534a.getRootActivity();
                if (this.f50534a.getActivity() == null || this.f50534a.mListGroup == null || rootActivity == null || rootActivity.getMyGroupModel() == null) {
                    return;
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    this.f50534a.mListGroup.completePullRefreshPostDelayed(0L);
                }
                ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
                if (responseGroupsByUidMessage.getError() != 0) {
                    if (responseGroupsByUidMessage.getError() != 0) {
                        this.f50534a.showToast(StringUtils.isNull(responseGroupsByUidMessage.getErrorString()) ? this.f50534a.getResources().getString(R.string.neterror) : responseGroupsByUidMessage.getErrorString());
                        return;
                    }
                    return;
                }
                List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
                if (this.f50534a.f50530i == 1) {
                    groups = responseGroupsByUidMessage.getCommonGroups();
                }
                if (!rootActivity.getIsHost()) {
                    rootActivity.setGroups(responseGroupsByUidMessage.getGroups());
                    rootActivity.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                rootActivity.updateTabTitle(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    this.f50534a.f50527f.c(groups);
                    this.f50534a.f50527f.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        this.f50534a.f50528g.setVisibility(8);
                        PersonalGroupFragment personalGroupFragment = this.f50534a;
                        personalGroupFragment.mListGroup.removeHeaderView(personalGroupFragment.f50528g);
                    } else {
                        this.f50534a.f50528g.setVisibility(0);
                        PersonalGroupFragment personalGroupFragment2 = this.f50534a;
                        personalGroupFragment2.mListGroup.removeHeaderView(personalGroupFragment2.f50528g);
                        PersonalGroupFragment personalGroupFragment3 = this.f50534a;
                        personalGroupFragment3.mListGroup.addHeaderView(personalGroupFragment3.f50528g);
                    }
                    this.f50534a.mListGroup.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    this.f50534a.isNeedUpdate = false;
                } else if (socketResponsedMessage.getCmd() != 2001106 || rootActivity.getMyGroupModel() == null) {
                } else {
                    rootActivity.getMyGroupModel().update();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalGroupFragment f50535a;

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
            this.f50535a = personalGroupFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                PersonGroupActivity rootActivity = this.f50535a.getRootActivity();
                if (this.f50535a.getActivity() == null || this.f50535a.mListGroup == null || rootActivity == null || rootActivity.getMyGroupModel() == null) {
                    return;
                }
                ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
                if (responseGroupsByUidLocalMessage.getError() != 0) {
                    if (responseGroupsByUidLocalMessage.getError() == 0 || TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                        return;
                    }
                    this.f50535a.showToast(responseGroupsByUidLocalMessage.getErrorString());
                    return;
                }
                if (rootActivity.getIsHost()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (this.f50535a.f50530i == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    rootActivity.updateTabTitle(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        this.f50535a.f50527f.c(groups);
                        this.f50535a.f50527f.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            this.f50535a.f50528g.setVisibility(8);
                            PersonalGroupFragment personalGroupFragment = this.f50535a;
                            personalGroupFragment.mListGroup.removeHeaderView(personalGroupFragment.f50528g);
                        } else {
                            this.f50535a.f50528g.setVisibility(0);
                            PersonalGroupFragment personalGroupFragment2 = this.f50535a;
                            personalGroupFragment2.mListGroup.removeHeaderView(personalGroupFragment2.f50528g);
                            PersonalGroupFragment personalGroupFragment3 = this.f50535a;
                            personalGroupFragment3.mListGroup.addHeaderView(personalGroupFragment3.f50528g);
                        }
                        this.f50535a.mListGroup.setVisibility(0);
                    }
                }
                if (rootActivity.getMyGroupModel() != null) {
                    rootActivity.getMyGroupModel().update();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalGroupFragment f50536a;

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
            this.f50536a = personalGroupFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null && "dismiss_group".equals(p.getCmd())) {
                this.f50536a.e(p);
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
        this.mListGroup = null;
        this.f50526e = null;
        this.f50527f = null;
        this.f50528g = null;
        this.f50529h = null;
        this.f50530i = 0;
        this.j = new a(this, 0);
        this.k = new c(this, 0);
        this.l = new d(this, 0);
        this.m = new e(this, 0);
        this.n = new f(this, 0);
        this.isNeedUpdate = false;
    }

    public final void e(GroupNewsPojo groupNewsPojo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, groupNewsPojo) == null) || groupNewsPojo == null) {
            return;
        }
        try {
            if (TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP.equals(new JSONObject(groupNewsPojo.getContent()).getString(TbEnum.SystemMessage.KEY_EVENT_ID)) && j.z()) {
                this.isNeedUpdate = true;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public PersonGroupActivity getRootActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            if (baseFragmentActivity instanceof PersonGroupActivity) {
                return (PersonGroupActivity) baseFragmentActivity;
            }
            return null;
        }
        return (PersonGroupActivity) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(103003, this.l);
            registerListener(2001106, this.m);
            registerListener(103101, this.k);
            registerListener(103112, this.k);
            registerListener(103102, this.k);
            registerListener(2001109, this.k);
            registerListener(103104, this.k);
            registerListener(103105, this.k);
            registerListener(2001126, this.j);
            registerListener(2001128, this.j);
            registerListener(2001132, this.j);
            registerListener(2001133, this.j);
            registerListener(2001130, this.j);
            registerListener(2001134, this.j);
            registerListener(2001137, this.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            b.a.r0.l1.n.a aVar = this.f50527f;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
            NoDataView noDataView = this.f50528g;
            if (noDataView != null) {
                SkinManager.setBackgroundColor(noDataView, R.color.CAM_X0201);
            }
            if (isAdded()) {
                getRootActivity().getLayoutMode().j(this.f50529h);
                this.f50526e.C(i2);
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
                PersonGroupActivity rootActivity = getRootActivity();
                if (rootActivity == null || rootActivity.onGroupSelected(groupInfoData) || groupInfoData == null) {
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
            this.f50530i = getArguments().getInt("page_type", 0);
            getArguments().getInt("page_size", 1);
            View inflate = layoutInflater.inflate(R.layout.person_group_fragment, viewGroup, false);
            PersonGroupActivity rootActivity = getRootActivity();
            if (rootActivity != null && !rootActivity.getIsHost()) {
                if (this.f50530i == 0) {
                    d2 = NoDataViewFactory.e.c(String.format(getString(R.string.person_group_no_personal_info), rootActivity.getUtype()));
                } else {
                    d2 = NoDataViewFactory.e.c(getString(R.string.person_group_no_common_info));
                }
            } else {
                d2 = (rootActivity == null || !rootActivity.getIsHost()) ? null : NoDataViewFactory.e.d(getString(R.string.group_no_data_tip), getString(R.string.group_no_data_tip_1));
            }
            this.f50528g = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), d2, null);
            this.mListGroup = (BdListView) inflate.findViewById(R.id.person_group_list);
            this.f50526e = new g(getPageContext());
            this.f50527f = new b.a.r0.l1.n.a(this);
            this.f50526e.a(new b(this));
            this.mListGroup.setPullRefresh(this.f50526e);
            this.mListGroup.setAdapter((ListAdapter) this.f50527f);
            this.mListGroup.setOnItemClickListener(this);
            this.f50528g.setVisibility(8);
            this.mListGroup.removeHeaderView(this.f50528g);
            this.f50529h = inflate.findViewById(R.id.group_fragment_parent);
            if (getRootActivity() != null && this.f50530i == getRootActivity().getCurrentPageType()) {
                this.mListGroup.startPullRefresh();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
            MessageManager.getInstance().unRegisterListener(this.k);
            MessageManager.getInstance().unRegisterListener(this.n);
            MessageManager.getInstance().unRegisterListener(this.j);
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            GroupInfoData item = this.f50527f.getItem(i2);
            PersonGroupActivity rootActivity = getRootActivity();
            if (rootActivity == null || rootActivity.onGroupSelected(item) || item == null) {
                return;
            }
            if (this.f50530i != 1 && !rootActivity.getIsHost()) {
                if (rootActivity.isCommonGroup(item.getGroupId())) {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
                    return;
                }
                TiebaStatic.eventStat(getActivity(), "his_group_item", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), item.getGroupId(), 1)));
                return;
            }
            if (rootActivity.getIsHost()) {
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
            if (this.isNeedUpdate) {
                this.mListGroup.startPullRefresh();
            }
            onChangeSkinType(TbadkApplication.getInst().getSkinType());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStart();
            NoDataView noDataView = this.f50528g;
            if (noDataView != null) {
                noDataView.onActivityStart(getRootActivity().getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onStop();
            NoDataView noDataView = this.f50528g;
            if (noDataView != null) {
                noDataView.onActivityStop();
            }
        }
    }
}
