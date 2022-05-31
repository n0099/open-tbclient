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
import com.repackage.a57;
import com.repackage.ft4;
import com.repackage.gt4;
import com.repackage.ji;
import com.repackage.ya;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PersonalGroupFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;
    public gt4 b;
    public a57 c;
    public NoDataView d;
    public View e;
    public boolean f;
    public int g;
    public final ya h;
    public final ya i;
    public final ya j;
    public final CustomMessageListener k;
    public final CustomMessageListener l;

    /* loaded from: classes3.dex */
    public class a extends ya {
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
                this.a.f = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ft4.g {
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

        @Override // com.repackage.ft4.g
        public void onListPullRefresh(boolean z) {
            PersonGroupActivity I0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (I0 = this.a.I0()) == null) {
                return;
            }
            I0.getMyGroupModel().update();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ya {
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
                            this.a.f = true;
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ya {
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
                PersonGroupActivity I0 = this.a.I0();
                if (this.a.getActivity() == null || this.a.a == null || I0 == null || I0.getMyGroupModel() == null) {
                    return;
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    this.a.a.A(0L);
                }
                ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
                if (responseGroupsByUidMessage.getError() != 0) {
                    if (responseGroupsByUidMessage.getError() != 0) {
                        this.a.showToast(StringUtils.isNull(responseGroupsByUidMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c33) : responseGroupsByUidMessage.getErrorString());
                        return;
                    }
                    return;
                }
                List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
                if (this.a.g == 1) {
                    groups = responseGroupsByUidMessage.getCommonGroups();
                }
                if (!I0.getIsHost()) {
                    I0.setGroups(responseGroupsByUidMessage.getGroups());
                    I0.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
                }
                I0.updateTabTitle(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
                if (groups != null) {
                    this.a.c.c(groups);
                    this.a.c.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        this.a.d.setVisibility(8);
                        PersonalGroupFragment personalGroupFragment = this.a;
                        personalGroupFragment.a.removeHeaderView(personalGroupFragment.d);
                    } else {
                        this.a.d.setVisibility(0);
                        PersonalGroupFragment personalGroupFragment2 = this.a;
                        personalGroupFragment2.a.removeHeaderView(personalGroupFragment2.d);
                        PersonalGroupFragment personalGroupFragment3 = this.a;
                        personalGroupFragment3.a.addHeaderView(personalGroupFragment3.d);
                    }
                    this.a.a.setVisibility(0);
                }
                if (socketResponsedMessage.getCmd() == 103003) {
                    this.a.f = false;
                } else if (socketResponsedMessage.getCmd() != 2001106 || I0.getMyGroupModel() == null) {
                } else {
                    I0.getMyGroupModel().update();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                PersonGroupActivity I0 = this.a.I0();
                if (this.a.getActivity() == null || this.a.a == null || I0 == null || I0.getMyGroupModel() == null) {
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
                if (I0.getIsHost()) {
                    List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                    if (this.a.g == 1) {
                        groups = responseGroupsByUidLocalMessage.getCommonGroups();
                    }
                    I0.updateTabTitle(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                    if (groups != null) {
                        this.a.c.c(groups);
                        this.a.c.notifyDataSetChanged();
                        if (groups.size() > 0) {
                            this.a.d.setVisibility(8);
                            PersonalGroupFragment personalGroupFragment = this.a;
                            personalGroupFragment.a.removeHeaderView(personalGroupFragment.d);
                        } else {
                            this.a.d.setVisibility(0);
                            PersonalGroupFragment personalGroupFragment2 = this.a;
                            personalGroupFragment2.a.removeHeaderView(personalGroupFragment2.d);
                            PersonalGroupFragment personalGroupFragment3 = this.a;
                            personalGroupFragment3.a.addHeaderView(personalGroupFragment3.d);
                        }
                        this.a.a.setVisibility(0);
                    }
                }
                if (I0.getMyGroupModel() != null) {
                    I0.getMyGroupModel().update();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.J0(p);
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
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.g = 0;
        this.h = new a(this, 0);
        this.i = new c(this, 0);
        this.j = new d(this, 0);
        this.k = new e(this, 0);
        this.l = new f(this, 0);
        this.f = false;
    }

    public PersonGroupActivity I0() {
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

    public final void J0(GroupNewsPojo groupNewsPojo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, groupNewsPojo) == null) || groupNewsPojo == null) {
            return;
        }
        try {
            if (TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP.equals(new JSONObject(groupNewsPojo.getContent()).getString(TbEnum.SystemMessage.KEY_EVENT_ID)) && ji.z()) {
                this.f = true;
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
            registerListener(2001126, this.h);
            registerListener(2001128, this.h);
            registerListener(2001132, this.h);
            registerListener(2001133, this.h);
            registerListener(2001130, this.h);
            registerListener(2001134, this.h);
            registerListener(2001137, this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            a57 a57Var = this.c;
            if (a57Var != null) {
                a57Var.notifyDataSetChanged();
            }
            NoDataView noDataView = this.d;
            if (noDataView != null) {
                SkinManager.setBackgroundColor(noDataView, R.color.CAM_X0201);
            }
            if (isAdded()) {
                I0().getLayoutMode().j(this.e);
                this.b.H(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f090639) {
                GroupInfoData groupInfoData = view2.getTag() instanceof GroupInfoData ? (GroupInfoData) view2.getTag() : null;
                PersonGroupActivity I0 = I0();
                if (I0 == null || I0.onGroupSelected(groupInfoData) || groupInfoData == null) {
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
            this.g = getArguments().getInt("page_type", 0);
            getArguments().getInt("page_size", 1);
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d06a8, viewGroup, false);
            PersonGroupActivity I0 = I0();
            if (I0 != null && !I0.getIsHost()) {
                if (this.g == 0) {
                    d2 = NoDataViewFactory.e.c(String.format(getString(R.string.obfuscated_res_0x7f0f0e35), I0.getUtype()));
                } else {
                    d2 = NoDataViewFactory.e.c(getString(R.string.obfuscated_res_0x7f0f0e34));
                }
            } else {
                d2 = (I0 == null || !I0.getIsHost()) ? null : NoDataViewFactory.e.d(getString(R.string.obfuscated_res_0x7f0f07ef), getString(R.string.obfuscated_res_0x7f0f07f0));
            }
            this.d = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070235)), d2, null);
            this.a = (BdListView) inflate.findViewById(R.id.obfuscated_res_0x7f0917ba);
            this.b = new gt4(getPageContext());
            this.c = new a57(this);
            this.b.e(new b(this));
            this.a.setPullRefresh(this.b);
            this.a.setAdapter((ListAdapter) this.c);
            this.a.setOnItemClickListener(this);
            this.d.setVisibility(8);
            this.a.removeHeaderView(this.d);
            this.e = inflate.findViewById(R.id.obfuscated_res_0x7f090cab);
            if (I0() != null && this.g == I0().getCurrentPageType()) {
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
            MessageManager.getInstance().unRegisterListener(this.h);
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            GroupInfoData item = this.c.getItem(i);
            PersonGroupActivity I0 = I0();
            if (I0 == null || I0.onGroupSelected(item) || item == null) {
                return;
            }
            if (this.g != 1 && !I0.getIsHost()) {
                if (I0.isCommonGroup(item.getGroupId())) {
                    TiebaStatic.eventStat(getActivity(), "common_group_item", "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getActivity(), item.getGroupId(), item.getName(), item.getAuthorId(), "group_lstb")));
                    return;
                }
                TiebaStatic.eventStat(getActivity(), "his_group_item", "click", 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getActivity(), item.getGroupId(), 1)));
                return;
            }
            if (I0.getIsHost()) {
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
            if (this.f) {
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
            NoDataView noDataView = this.d;
            if (noDataView != null) {
                noDataView.d(I0().getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onStop();
            NoDataView noDataView = this.d;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }
}
