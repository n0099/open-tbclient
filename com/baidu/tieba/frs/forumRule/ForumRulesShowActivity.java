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
import com.baidu.tieba.oi7;
import com.baidu.tieba.ow5;
import com.baidu.tieba.qi7;
import com.baidu.tieba.ri7;
import com.baidu.tieba.si7;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.ya;
import com.baidu.tieba.zi7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class ForumRulesShowActivity extends BaseActivity<ForumRulesShowActivity> implements Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumRulesShowModel a;
    public zi7 b;
    public String c;
    public oi7 d;
    public CustomMessageListener e;

    public ya<ItemCardView> C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    public ya<GifView> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    public ya<LinearLayout> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public void U(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
        }
    }

    public void W(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, str) == null) {
        }
    }

    public ya<TiebaPlusRecommendCard> b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    public ya<RelativeLayout> f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public ya<FestivalTipView> i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    public ya<ImageView> j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    public ya<View> k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    public void m0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, context, str) == null) {
        }
    }

    public ya<TextView> p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (ya) invokeV.objValue;
    }

    public void s0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048602, this, context, str, str2) == null) {
        }
    }

    public void w0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, str) == null) {
        }
    }

    public void x1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, context, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements oi7 {
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

        @Override // com.baidu.tieba.oi7
        public void a(qi7 qi7Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, qi7Var) == null) && this.a.b != null) {
                this.a.b.t(qi7Var);
            }
        }

        @Override // com.baidu.tieba.oi7
        public void b(List<si7> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.a.b != null) {
                this.a.b.u(list);
            }
        }

        @Override // com.baidu.tieba.oi7
        public void d(ri7 ri7Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, ri7Var) == null) && this.a.b != null) {
                this.a.b.g(ri7Var);
            }
        }

        @Override // com.baidu.tieba.oi7
        public void e(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && this.a.b != null) {
                this.a.b.x(str);
            }
        }

        @Override // com.baidu.tieba.oi7
        public void c(boolean z, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) != null) || this.a.b == null) {
                return;
            }
            if (z) {
                this.a.b.O(str);
            } else {
                this.a.b.E();
            }
        }

        @Override // com.baidu.tieba.oi7
        public void f() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a.b != null) {
                this.a.b.B();
                this.a.b.M();
                ForumRulesShowActivity forumRulesShowActivity = this.a;
                forumRulesShowActivity.showNetRefreshView(forumRulesShowActivity.b.z(), "");
            }
        }

        @Override // com.baidu.tieba.oi7
        public void finish() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a.b != null) {
                ForumRulesShowActivity forumRulesShowActivity = this.a;
                forumRulesShowActivity.hideNetRefreshView(forumRulesShowActivity.b.z());
                this.a.b.C();
                this.a.b.L();
                this.a.b.I();
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ow5.a)) {
                ow5.a aVar = (ow5.a) customResponsedMessage.getData();
                ow5.b(this.a.getPageContext(), aVar.a, aVar.b, aVar.c);
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

    public final void Q0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            this.a = new ForumRulesShowModel(this);
            S0();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            super.onChangeSkinType(i);
            zi7 zi7Var = this.b;
            if (zi7Var != null) {
                zi7Var.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.onCreate(bundle);
            Q0(bundle);
            initView();
            this.a.T(bundle);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.c = str;
            zi7 zi7Var = this.b;
            if (zi7Var != null) {
                zi7Var.setFrom(str);
            }
        }
    }

    public zi7 N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (zi7) invokeV.objValue;
    }

    public void R0() {
        ForumRulesShowModel forumRulesShowModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (forumRulesShowModel = this.a) != null) {
            forumRulesShowModel.b0();
        }
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.c0(this.d);
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (getIntent() != null) {
                this.c = getIntent().getStringExtra("from");
            }
            zi7 zi7Var = new zi7(this, this.c);
            this.b = zi7Var;
            zi7Var.J(getRefreshView());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDestroy();
            ForumRulesShowModel forumRulesShowModel = this.a;
            if (forumRulesShowModel != null) {
                forumRulesShowModel.destory();
            }
            zi7 zi7Var = this.b;
            if (zi7Var != null) {
                zi7Var.y();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPause();
            MessageManager.getInstance().unRegisterListener(this.e);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            registerListener(this.e);
        }
    }

    public void n0(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048594, this, context, str, z) == null) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048595, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 25053) {
                String stringExtra = intent.getStringExtra("group_name");
                if (!intent.getBooleanExtra("from", true)) {
                    this.b.H();
                    this.b.n.clear();
                    this.a.b0();
                }
                new BdTopToast(this, 3000).setIcon(true).setContent(stringExtra).show(this.b.A());
            }
        }
    }
}
