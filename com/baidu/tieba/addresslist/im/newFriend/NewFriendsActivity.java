package com.baidu.tieba.addresslist.im.newFriend;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.f0.f;
import d.a.r0.r.s.b;
import d.a.r0.z0.f0;
import d.a.r0.z0.i0;
import d.a.s0.s.e.a.a;
import java.util.List;
/* loaded from: classes5.dex */
public class NewFriendsActivity extends BaseActivity<NewFriendsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String SHARE_ID;
    public d.a.r0.r.s.b mDeleteNewFriendDialog;
    public final CustomMessageListener mNewFriendAction;
    public a.c mNewFriendItemListener;
    public final f.g mOnPullRefreshLisner;
    public final d.a.c.c.g.c mPassListener;
    public d.a.s0.s.e.a.c mView;
    public final RecommendFriendModel praiseYModel;

    /* loaded from: classes5.dex */
    public class a extends f0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.i1.g.a f13820a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f13821b;

        public a(NewFriendsActivity newFriendsActivity, d.a.s0.i1.g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13821b = newFriendsActivity;
            this.f13820a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.r0.z0.f0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.s0.s.e.a.b.f().b(this.f13820a.b())) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a.r0.z0.n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.i1.g.a f13822a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f13823b;

        public b(NewFriendsActivity newFriendsActivity, d.a.s0.i1.g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13823b = newFriendsActivity;
            this.f13822a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bool) == null) && bool.booleanValue()) {
                this.f13823b.mView.g(this.f13822a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f13824e;

        public c(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13824e = newFriendsActivity;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || z) {
                return;
            }
            this.f13824e.loadNewFriendList();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements RecommendFriendModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f13825a;

        public d(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13825a = newFriendsActivity;
        }

        @Override // com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f13825a.loadNewFriendList();
                TbadkSettings.getInst().saveBoolean(this.f13825a.SHARE_ID, true);
            }
        }

        @Override // com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.b
        public void onLoadFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f13825a.mView.e();
                this.f13825a.mView.h(null);
                BdToast.c(this.f13825a.getPageContext().getPageActivity(), str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f13826a;

        public e(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13826a = newFriendsActivity;
        }

        @Override // d.a.s0.s.e.a.a.c
        public void a(int i2, int i3, View view, d.a.s0.i1.g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), view, aVar}) == null) {
                if (aVar.f() == 0) {
                    this.f13826a.addtNewFriend(aVar);
                } else if (aVar.f() == 1) {
                    this.f13826a.passNewFriend(aVar);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f13827a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(NewFriendsActivity newFriendsActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity, Integer.valueOf(i2)};
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
            this.f13827a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                if (((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 1) {
                    this.f13827a.notifyData();
                } else {
                    this.f13827a.updateNewFriendList();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends f0<List<d.a.s0.i1.g.a>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f13828a;

        public g(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13828a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.f0
        /* renamed from: a */
        public List<d.a.s0.i1.g.a> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.s0.s.e.a.b.f().j() : (List) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements d.a.r0.z0.n<List<d.a.s0.i1.g.a>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f13829a;

        public h(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13829a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(List<d.a.s0.i1.g.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.f13829a.mView.f().e(list);
                this.f13829a.mView.f().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends d.a.c.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f13830a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(NewFriendsActivity newFriendsActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity, Integer.valueOf(i2)};
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
            this.f13830a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponsePassFriendMessage responsePassFriendMessage;
            int error;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                if (socketResponsedMessage != null && (socketResponsedMessage instanceof SocketResponsedMessage)) {
                    if (!(socketResponsedMessage instanceof ResponsePassFriendMessage) || (error = (responsePassFriendMessage = (ResponsePassFriendMessage) socketResponsedMessage).getError()) == 0 || error == 3100098) {
                        return;
                    }
                    this.f13830a.showToast(StringUtils.isNull(responsePassFriendMessage.getErrorString()) ? this.f13830a.getResources().getString(R.string.neterror) : responsePassFriendMessage.getErrorString());
                    return;
                }
                this.f13830a.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends f0<List<d.a.s0.i1.g.a>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f13831a;

        public j(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13831a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.f0
        /* renamed from: a */
        public List<d.a.s0.i1.g.a> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.s0.s.e.a.b.f().p();
                return d.a.s0.s.e.a.b.f().j();
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements d.a.r0.z0.n<List<d.a.s0.i1.g.a>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f13832a;

        public k(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13832a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(List<d.a.s0.i1.g.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.f13832a.mView.e();
                this.f13832a.mView.h(list);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends f0<List<d.a.s0.i1.g.a>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f13833a;

        public l(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13833a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.f0
        /* renamed from: a */
        public List<d.a.s0.i1.g.a> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.s0.s.e.a.b.f().g() : (List) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class m implements d.a.r0.z0.n<List<d.a.s0.i1.g.a>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f13834a;

        public m(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13834a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(List<d.a.s0.i1.g.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.f13834a.mView.m(list);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.s0.i1.g.a f13835a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f13836b;

        public n(NewFriendsActivity newFriendsActivity, d.a.s0.i1.g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13836b = newFriendsActivity;
            this.f13835a = aVar;
        }

        @Override // d.a.r0.r.s.b.c
        public void a(d.a.r0.r.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                bVar.e();
                d.a.s0.i1.g.a aVar = this.f13835a;
                if (aVar != null) {
                    this.f13836b.deleteNewFriend(aVar);
                }
            }
        }
    }

    public NewFriendsActivity() {
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
        this.SHARE_ID = "recommend_new_friend" + TbadkCoreApplication.getCurrentAccount();
        this.mNewFriendItemListener = new e(this);
        this.mNewFriendAction = new f(this, 2001174);
        this.mPassListener = new i(this, 304101);
        this.mOnPullRefreshLisner = new c(this);
        this.praiseYModel = new RecommendFriendModel(this, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addtNewFriend(d.a.s0.i1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, aVar) == null) || aVar == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), String.valueOf(aVar.b()), aVar.d(), aVar.e(), "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteNewFriend(d.a.s0.i1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, aVar) == null) {
            i0.c(new a(this, aVar), new b(this, aVar));
        }
    }

    private d.a.r0.r.s.b getDeleteNewFriendDialog(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, nVar)) == null) {
            d.a.r0.r.s.b bVar = new d.a.r0.r.s.b(getPageContext().getPageActivity());
            bVar.k(R.string.operation);
            bVar.j(new String[]{getPageContext().getString(R.string.delete)}, nVar);
            return bVar;
        }
        return (d.a.r0.r.s.b) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNewFriendList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            i0.c(new j(this), new k(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            i0.c(new g(this), new h(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void passNewFriend(d.a.s0.i1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, aVar) == null) {
            d.a.r0.h0.a.a(aVar.b(), AddFriendActivityConfig.TYPE_NEW_FRD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNewFriendList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            i0.c(new l(this), new m(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.mView.d(getLayoutMode(), i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && view.getId() == R.id.new_friend_textview_container) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.new_friend_activity);
            d.a.s0.s.e.a.c cVar = new d.a.s0.s.e.a.c(this);
            this.mView = cVar;
            cVar.i(this.mOnPullRefreshLisner);
            this.mView.k(this.mNewFriendItemListener);
            registerListener(this.mNewFriendAction);
            registerListener(this.mPassListener);
            if (TbadkSettings.getInst().loadBoolean(this.SHARE_ID, false)) {
                loadNewFriendList();
                this.mView.l();
                return;
            }
            this.praiseYModel.setUniqueId(getUniqueId());
            this.praiseYModel.registerListener();
            this.praiseYModel.x();
            this.mView.l();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            d.a.r0.r.s.b bVar = this.mDeleteNewFriendDialog;
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        d.a.s0.i1.g.a item;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (item = this.mView.f().getItem(i2)) != null && (item instanceof d.a.s0.i1.g.a) && i2 == j2) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.b()), item.d())));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            d.a.s0.i1.g.a item = this.mView.f().getItem(i2);
            if (item == null || !(item instanceof d.a.s0.i1.g.a)) {
                return true;
            }
            d.a.r0.r.s.b deleteNewFriendDialog = getDeleteNewFriendDialog(new n(this, item));
            this.mDeleteNewFriendDialog = deleteNewFriendDialog;
            deleteNewFriendDialog.c(getPageContext());
            this.mDeleteNewFriendDialog.m();
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
