package com.baidu.tieba.frs.forumRule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.frs.forumRule.model.ForumRulesShowModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cj6;
import com.repackage.eg;
import com.repackage.ri6;
import com.repackage.sg5;
import com.repackage.ti6;
import com.repackage.ui6;
import com.repackage.vi6;
import java.util.List;
/* loaded from: classes3.dex */
public class ForumRulesShowActivity extends BaseActivity<ForumRulesShowActivity> implements Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumRulesShowModel a;
    public cj6 b;
    public String c;
    public ri6 d;
    public CustomMessageListener e;

    /* loaded from: classes3.dex */
    public class a implements ri6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumRulesShowActivity a;

        public a(ForumRulesShowActivity forumRulesShowActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRulesShowActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumRulesShowActivity;
        }

        @Override // com.repackage.ri6
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.p();
            this.a.b.A();
            ForumRulesShowActivity forumRulesShowActivity = this.a;
            forumRulesShowActivity.showNetRefreshView(forumRulesShowActivity.b.n(), "");
        }

        @Override // com.repackage.ri6
        public void b(ti6 ti6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ti6Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.j(ti6Var);
        }

        @Override // com.repackage.ri6
        public void c(List<vi6> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || this.a.b == null) {
                return;
            }
            this.a.b.k(list);
        }

        @Override // com.repackage.ri6
        public void d(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(1048579, this, z, str) == null) || this.a.b == null) {
                return;
            }
            if (z) {
                this.a.b.C(str);
            } else {
                this.a.b.s();
            }
        }

        @Override // com.repackage.ri6
        public void e(ui6 ui6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, ui6Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.h(ui6Var);
        }

        @Override // com.repackage.ri6
        public void f(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.a.b == null) {
                return;
            }
            this.a.b.l(str);
        }

        @Override // com.repackage.ri6
        public void finish() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a.b == null) {
                return;
            }
            ForumRulesShowActivity forumRulesShowActivity = this.a;
            forumRulesShowActivity.hideNetRefreshView(forumRulesShowActivity.b.n());
            this.a.b.q();
            this.a.b.z();
            this.a.b.w();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumRulesShowActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ForumRulesShowActivity forumRulesShowActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRulesShowActivity, Integer.valueOf(i)};
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
            this.a = forumRulesShowActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof sg5.a)) {
                sg5.a aVar = (sg5.a) customResponsedMessage.getData();
                sg5.b(this.a.getPageContext(), aVar.a, aVar.b, aVar.c);
            }
        }
    }

    public ForumRulesShowActivity() {
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
        this.d = new a(this);
        this.e = new b(this, 2001332);
    }

    public eg<LinearLayout> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public cj6 B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (cj6) invokeV.objValue;
    }

    public final void C1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            this.a = new ForumRulesShowModel(this);
            F1();
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (getIntent() != null) {
                this.c = getIntent().getStringExtra("from");
            }
            cj6 cj6Var = new cj6(this, this.c);
            this.b = cj6Var;
            cj6Var.x(getRefreshView());
        }
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public void E1() {
        ForumRulesShowModel forumRulesShowModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (forumRulesShowModel = this.a) == null) {
            return;
        }
        forumRulesShowModel.M();
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.N(this.d);
        }
    }

    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, str) == null) {
        }
    }

    public void J(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
        }
    }

    public eg<RelativeLayout> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public eg<ImageView> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public eg<View> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, context, str) == null) {
        }
    }

    public void R(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048589, this, context, str, z) == null) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
    }

    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, context, str, str2) == null) {
        }
    }

    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, context, str) == null) {
        }
    }

    public eg<TextView> Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public eg<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public void h1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048596, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 25053) {
                String stringExtra = intent.getStringExtra("group_name");
                if (!intent.getBooleanExtra("from", true)) {
                    this.b.v();
                    this.b.n.clear();
                    this.a.M();
                }
                BdTopToast bdTopToast = new BdTopToast(this, 3000);
                bdTopToast.i(true);
                bdTopToast.h(stringExtra);
                bdTopToast.j(this.b.o());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            super.onChangeSkinType(i);
            cj6 cj6Var = this.b;
            if (cj6Var != null) {
                cj6Var.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            super.onCreate(bundle);
            C1(bundle);
            D1();
            this.a.G(bundle);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onDestroy();
            ForumRulesShowModel forumRulesShowModel = this.a;
            if (forumRulesShowModel != null) {
                forumRulesShowModel.destory();
            }
            cj6 cj6Var = this.b;
            if (cj6Var != null) {
                cj6Var.m();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onPause();
            MessageManager.getInstance().unRegisterListener(this.e);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onResume();
            registerListener(this.e);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.c = str;
            cj6 cj6Var = this.b;
            if (cj6Var != null) {
                cj6Var.setFrom(str);
            }
        }
    }

    public eg<GifView> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public eg<TiebaPlusRecommendCard> z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }
}
