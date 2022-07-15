package com.baidu.tieba.addresslist.im.newFriend;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.bb;
import com.repackage.cl5;
import com.repackage.de5;
import com.repackage.dl5;
import com.repackage.el5;
import com.repackage.er4;
import com.repackage.fu4;
import com.repackage.he5;
import com.repackage.j85;
import com.repackage.jd5;
import com.repackage.n57;
import java.util.List;
/* loaded from: classes3.dex */
public class NewFriendsActivity extends BaseActivity<NewFriendsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public el5 b;
    public er4 c;
    public cl5.c d;
    public final CustomMessageListener e;
    public final bb f;
    public final fu4.g g;
    public final RecommendFriendModel h;

    /* loaded from: classes3.dex */
    public class a extends de5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n57 a;
        public final /* synthetic */ NewFriendsActivity b;

        public a(NewFriendsActivity newFriendsActivity, n57 n57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity, n57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = newFriendsActivity;
            this.a = n57Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.de5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(dl5.f().b(this.a.b())) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements jd5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n57 a;
        public final /* synthetic */ NewFriendsActivity b;

        public b(NewFriendsActivity newFriendsActivity, n57 n57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity, n57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = newFriendsActivity;
            this.a = n57Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bool) == null) && bool.booleanValue()) {
                this.b.b.k(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements fu4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFriendsActivity a;

        public c(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFriendsActivity;
        }

        @Override // com.repackage.fu4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || z) {
                return;
            }
            this.a.L1();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements RecommendFriendModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFriendsActivity a;

        public d(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFriendsActivity;
        }

        @Override // com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.b
        public void h(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.b.h();
                this.a.b.l(null);
                BdToast.b(this.a.getPageContext().getPageActivity(), str);
            }
        }

        @Override // com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.b
        public void i(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.L1();
                TbadkSettings.getInst().saveBoolean(this.a.a, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements cl5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFriendsActivity a;

        public e(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFriendsActivity;
        }

        @Override // com.repackage.cl5.c
        public void a(int i, int i2, View view2, n57 n57Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), view2, n57Var}) == null) {
                if (n57Var.f() == 0) {
                    this.a.I1(n57Var);
                } else if (n57Var.f() == 1) {
                    this.a.N1(n57Var);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFriendsActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(NewFriendsActivity newFriendsActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity, Integer.valueOf(i)};
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
            this.a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                if (((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 1) {
                    this.a.M1();
                } else {
                    this.a.O1();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends de5<List<n57>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFriendsActivity a;

        public g(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.de5
        /* renamed from: a */
        public List<n57> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? dl5.f().j() : (List) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements jd5<List<n57>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFriendsActivity a;

        public h(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(List<n57> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.a.b.j().e(list);
                this.a.b.j().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends bb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFriendsActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(NewFriendsActivity newFriendsActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity, Integer.valueOf(i)};
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
            this.a = newFriendsActivity;
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
                    this.a.showToast(StringUtils.isNull(responsePassFriendMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c2b) : responsePassFriendMessage.getErrorString());
                    return;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c2b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends de5<List<n57>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFriendsActivity a;

        public j(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.de5
        /* renamed from: a */
        public List<n57> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                dl5.f().p();
                return dl5.f().j();
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class k implements jd5<List<n57>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFriendsActivity a;

        public k(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(List<n57> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.a.b.h();
                this.a.b.l(list);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends de5<List<n57>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFriendsActivity a;

        public l(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.de5
        /* renamed from: a */
        public List<n57> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? dl5.f().g() : (List) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class m implements jd5<List<n57>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFriendsActivity a;

        public m(NewFriendsActivity newFriendsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFriendsActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(List<n57> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.a.b.p(list);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements er4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public n57 a;
        public final /* synthetic */ NewFriendsActivity b;

        public n(NewFriendsActivity newFriendsActivity, n57 n57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFriendsActivity, n57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = newFriendsActivity;
            this.a = n57Var;
        }

        @Override // com.repackage.er4.c
        public void a(er4 er4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, er4Var, i, view2) == null) {
                er4Var.e();
                n57 n57Var = this.a;
                if (n57Var != null) {
                    this.b.J1(n57Var);
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
        this.a = "recommend_new_friend" + TbadkCoreApplication.getCurrentAccount();
        this.d = new e(this);
        this.e = new f(this, 2001174);
        this.f = new i(this, 304101);
        this.g = new c(this);
        this.h = new RecommendFriendModel(this, new d(this));
    }

    public final void I1(n57 n57Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, n57Var) == null) || n57Var == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), String.valueOf(n57Var.b()), n57Var.d(), n57Var.e(), "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
    }

    public final void J1(n57 n57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n57Var) == null) {
            he5.c(new a(this, n57Var), new b(this, n57Var));
        }
    }

    public final er4 K1(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nVar)) == null) {
            er4 er4Var = new er4(getPageContext().getPageActivity());
            er4Var.k(R.string.obfuscated_res_0x7f0f0cf1);
            er4Var.j(new String[]{getPageContext().getString(R.string.obfuscated_res_0x7f0f049f)}, nVar);
            return er4Var;
        }
        return (er4) invokeL.objValue;
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            he5.c(new j(this), new k(this));
        }
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            he5.c(new g(this), new h(this));
        }
    }

    public final void N1(n57 n57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, n57Var) == null) {
            j85.a(n57Var.b(), AddFriendActivityConfig.TYPE_NEW_FRD);
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            he5.c(new l(this), new m(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.b.a(getLayoutMode(), i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f0915bc) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d05fa);
            el5 el5Var = new el5(this);
            this.b = el5Var;
            el5Var.m(this.g);
            this.b.n(this.d);
            registerListener(this.e);
            registerListener(this.f);
            if (TbadkSettings.getInst().loadBoolean(this.a, false)) {
                L1();
                this.b.o();
                return;
            }
            this.h.setUniqueId(getUniqueId());
            this.h.registerListener();
            this.h.B();
            this.b.o();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            er4 er4Var = this.c;
            if (er4Var != null) {
                er4Var.e();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j2) {
        n57 item;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{adapterView, view2, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (item = this.b.j().getItem(i2)) != null && (item instanceof n57) && i2 == j2) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.b()), item.d())));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{adapterView, view2, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            n57 item = this.b.j().getItem(i2);
            if (item == null || !(item instanceof n57)) {
                return true;
            }
            er4 K1 = K1(new n(this, item));
            this.c = K1;
            K1.c(getPageContext());
            this.c.m();
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
