package com.baidu.tieba.addresslist.im.newFriend;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import b.a.q0.c1.i0;
import b.a.q0.c1.l0;
import b.a.q0.c1.q;
import b.a.q0.s.g0.f;
import b.a.q0.s.s.b;
import b.a.r0.t.e.a.a;
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
import java.util.List;
/* loaded from: classes8.dex */
public class NewFriendsActivity extends BaseActivity<NewFriendsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String SHARE_ID;
    public b.a.q0.s.s.b mDeleteNewFriendDialog;
    public final CustomMessageListener mNewFriendAction;
    public a.c mNewFriendItemListener;
    public final f.g mOnPullRefreshLisner;
    public final b.a.e.c.g.c mPassListener;
    public b.a.r0.t.e.a.c mView;
    public final RecommendFriendModel praiseYModel;

    /* loaded from: classes8.dex */
    public class a extends i0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.l1.g.a f47647a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f47648b;

        public a(NewFriendsActivity newFriendsActivity, b.a.r0.l1.g.a aVar) {
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
            this.f47648b = newFriendsActivity;
            this.f47647a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // b.a.q0.c1.i0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(b.a.r0.t.e.a.b.f().b(this.f47647a.b())) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements q<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.l1.g.a f47649a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f47650b;

        public b(NewFriendsActivity newFriendsActivity, b.a.r0.l1.g.a aVar) {
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
            this.f47650b = newFriendsActivity;
            this.f47649a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.q
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bool) == null) && bool.booleanValue()) {
                this.f47650b.mView.f(this.f47649a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f47651e;

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
            this.f47651e = newFriendsActivity;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || z) {
                return;
            }
            this.f47651e.loadNewFriendList();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements RecommendFriendModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f47652a;

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
            this.f47652a = newFriendsActivity;
        }

        @Override // com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f47652a.loadNewFriendList();
                TbadkSettings.getInst().saveBoolean(this.f47652a.SHARE_ID, true);
            }
        }

        @Override // com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.b
        public void onLoadFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f47652a.mView.d();
                this.f47652a.mView.g(null);
                BdToast.c(this.f47652a.getPageContext().getPageActivity(), str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f47653a;

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
            this.f47653a = newFriendsActivity;
        }

        @Override // b.a.r0.t.e.a.a.c
        public void a(int i2, int i3, View view, b.a.r0.l1.g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), view, aVar}) == null) {
                if (aVar.f() == 0) {
                    this.f47653a.addtNewFriend(aVar);
                } else if (aVar.f() == 1) {
                    this.f47653a.passNewFriend(aVar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f47654a;

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
            this.f47654a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                if (((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 1) {
                    this.f47654a.notifyData();
                } else {
                    this.f47654a.updateNewFriendList();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends i0<List<b.a.r0.l1.g.a>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f47655a;

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
            this.f47655a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.i0
        /* renamed from: a */
        public List<b.a.r0.l1.g.a> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.a.r0.t.e.a.b.f().j() : (List) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class h implements q<List<b.a.r0.l1.g.a>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f47656a;

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
            this.f47656a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.q
        /* renamed from: a */
        public void onReturnDataInUI(List<b.a.r0.l1.g.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.f47656a.mView.e().e(list);
                this.f47656a.mView.e().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i extends b.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f47657a;

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
            this.f47657a = newFriendsActivity;
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
                    this.f47657a.showToast(StringUtils.isNull(responsePassFriendMessage.getErrorString()) ? this.f47657a.getResources().getString(R.string.neterror) : responsePassFriendMessage.getErrorString());
                    return;
                }
                this.f47657a.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends i0<List<b.a.r0.l1.g.a>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f47658a;

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
            this.f47658a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.i0
        /* renamed from: a */
        public List<b.a.r0.l1.g.a> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.r0.t.e.a.b.f().p();
                return b.a.r0.t.e.a.b.f().j();
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class k implements q<List<b.a.r0.l1.g.a>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f47659a;

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
            this.f47659a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.q
        /* renamed from: a */
        public void onReturnDataInUI(List<b.a.r0.l1.g.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.f47659a.mView.d();
                this.f47659a.mView.g(list);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l extends i0<List<b.a.r0.l1.g.a>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f47660a;

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
            this.f47660a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.i0
        /* renamed from: a */
        public List<b.a.r0.l1.g.a> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.a.r0.t.e.a.b.f().g() : (List) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class m implements q<List<b.a.r0.l1.g.a>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f47661a;

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
            this.f47661a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.q
        /* renamed from: a */
        public void onReturnDataInUI(List<b.a.r0.l1.g.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.f47661a.mView.k(list);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.r0.l1.g.a f47662a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewFriendsActivity f47663b;

        public n(NewFriendsActivity newFriendsActivity, b.a.r0.l1.g.a aVar) {
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
            this.f47663b = newFriendsActivity;
            this.f47662a = aVar;
        }

        @Override // b.a.q0.s.s.b.c
        public void a(b.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                bVar.e();
                b.a.r0.l1.g.a aVar = this.f47662a;
                if (aVar != null) {
                    this.f47663b.deleteNewFriend(aVar);
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
    public void addtNewFriend(b.a.r0.l1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, aVar) == null) || aVar == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), String.valueOf(aVar.b()), aVar.d(), aVar.e(), "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteNewFriend(b.a.r0.l1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, aVar) == null) {
            l0.c(new a(this, aVar), new b(this, aVar));
        }
    }

    private b.a.q0.s.s.b getDeleteNewFriendDialog(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, nVar)) == null) {
            b.a.q0.s.s.b bVar = new b.a.q0.s.s.b(getPageContext().getPageActivity());
            bVar.k(R.string.operation);
            bVar.j(new String[]{getPageContext().getString(R.string.delete)}, nVar);
            return bVar;
        }
        return (b.a.q0.s.s.b) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNewFriendList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            l0.c(new j(this), new k(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            l0.c(new g(this), new h(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void passNewFriend(b.a.r0.l1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, aVar) == null) {
            b.a.q0.l0.a.a(aVar.b(), AddFriendActivityConfig.TYPE_NEW_FRD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNewFriendList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            l0.c(new l(this), new m(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.mView.c(getLayoutMode(), i2);
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
            b.a.r0.t.e.a.c cVar = new b.a.r0.t.e.a.c(this);
            this.mView = cVar;
            cVar.h(this.mOnPullRefreshLisner);
            this.mView.i(this.mNewFriendItemListener);
            registerListener(this.mNewFriendAction);
            registerListener(this.mPassListener);
            if (TbadkSettings.getInst().loadBoolean(this.SHARE_ID, false)) {
                loadNewFriendList();
                this.mView.j();
                return;
            }
            this.praiseYModel.setUniqueId(getUniqueId());
            this.praiseYModel.registerListener();
            this.praiseYModel.x();
            this.mView.j();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            b.a.q0.s.s.b bVar = this.mDeleteNewFriendDialog;
            if (bVar != null) {
                bVar.e();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        b.a.r0.l1.g.a item;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (item = this.mView.e().getItem(i2)) != null && (item instanceof b.a.r0.l1.g.a) && i2 == j2) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.b()), item.d())));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            b.a.r0.l1.g.a item = this.mView.e().getItem(i2);
            if (item == null || !(item instanceof b.a.r0.l1.g.a)) {
                return true;
            }
            b.a.q0.s.s.b deleteNewFriendDialog = getDeleteNewFriendDialog(new n(this, item));
            this.mDeleteNewFriendDialog = deleteNewFriendDialog;
            deleteNewFriendDialog.c(getPageContext());
            this.mDeleteNewFriendDialog.m();
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
