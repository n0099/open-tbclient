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
import com.baidu.tieba.bg;
import com.baidu.tieba.e26;
import com.baidu.tieba.frs.forumRule.model.ForumRulesShowModel;
import com.baidu.tieba.go7;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vn7;
import com.baidu.tieba.xn7;
import com.baidu.tieba.yn7;
import com.baidu.tieba.zn7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class ForumRulesShowActivity extends BaseActivity<ForumRulesShowActivity> implements Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumRulesShowModel a;
    public go7 b;
    public String c;
    public vn7 d;
    public CustomMessageListener e;

    public bg<GifView> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    public bg<LinearLayout> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public void M(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
        }
    }

    public void P(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) {
        }
    }

    public bg<TiebaPlusRecommendCard> V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    public bg<RelativeLayout> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    public bg<FestivalTipView> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    public bg<ImageView> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    public bg<View> d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    public void f0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, str) == null) {
        }
    }

    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public bg<TextView> j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    public void m0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, context, str, str2) == null) {
        }
    }

    public void p0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, context, str) == null) {
        }
    }

    public void u1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, str) == null) {
        }
    }

    public bg<ItemCardView> v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements vn7 {
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

        @Override // com.baidu.tieba.vn7
        public void a(xn7 xn7Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, xn7Var) == null) && this.a.b != null) {
                this.a.b.x(xn7Var);
            }
        }

        @Override // com.baidu.tieba.vn7
        public void b(List<zn7> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.a.b != null) {
                this.a.b.y(list);
            }
        }

        @Override // com.baidu.tieba.vn7
        public void d(yn7 yn7Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, yn7Var) == null) && this.a.b != null) {
                this.a.b.u(yn7Var);
            }
        }

        @Override // com.baidu.tieba.vn7
        public void e(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && this.a.b != null) {
                this.a.b.z(str);
            }
        }

        @Override // com.baidu.tieba.vn7
        public void c(boolean z, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) != null) || this.a.b == null) {
                return;
            }
            if (z) {
                this.a.b.S(str);
            } else {
                this.a.b.I();
            }
        }

        @Override // com.baidu.tieba.vn7
        public void f() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a.b != null) {
                this.a.b.F();
                this.a.b.Q();
                ForumRulesShowActivity forumRulesShowActivity = this.a;
                forumRulesShowActivity.showNetRefreshView(forumRulesShowActivity.b.D(), "");
            }
        }

        @Override // com.baidu.tieba.vn7
        public void finish() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a.b != null) {
                ForumRulesShowActivity forumRulesShowActivity = this.a;
                forumRulesShowActivity.hideNetRefreshView(forumRulesShowActivity.b.D());
                this.a.b.G();
                this.a.b.P();
                this.a.b.M();
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e26.a)) {
                e26.a aVar = (e26.a) customResponsedMessage.getData();
                e26.b(this.a.getPageContext(), aVar.a, aVar.b, aVar.c);
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

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            super.onChangeSkinType(i);
            go7 go7Var = this.b;
            if (go7Var != null) {
                go7Var.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onCreate(bundle);
            q1(bundle);
            initView();
            this.a.S(bundle);
        }
    }

    public final void q1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            this.a = new ForumRulesShowModel(this);
            t1();
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.c = str;
            go7 go7Var = this.b;
            if (go7Var != null) {
                go7Var.setFrom(str);
            }
        }
    }

    public void h0(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, context, str, z) == null) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (getIntent() != null) {
                this.c = getIntent().getStringExtra("from");
            }
            go7 go7Var = new go7(this, this.c);
            this.b = go7Var;
            go7Var.N(getRefreshView());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDestroy();
            ForumRulesShowModel forumRulesShowModel = this.a;
            if (forumRulesShowModel != null) {
                forumRulesShowModel.destory();
            }
            go7 go7Var = this.b;
            if (go7Var != null) {
                go7Var.C();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onPause();
            MessageManager.getInstance().unRegisterListener(this.e);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onResume();
            registerListener(this.e);
        }
    }

    public go7 p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.b;
        }
        return (go7) invokeV.objValue;
    }

    public void s1() {
        ForumRulesShowModel forumRulesShowModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (forumRulesShowModel = this.a) != null) {
            forumRulesShowModel.a0();
        }
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.a.b0(this.d);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048592, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 25053) {
                String stringExtra = intent.getStringExtra("group_name");
                if (!intent.getBooleanExtra("from", true)) {
                    this.b.L();
                    this.b.n.clear();
                    this.a.a0();
                }
                new BdTopToast(this, 3000).setIcon(true).setContent(stringExtra).show(this.b.E());
            }
        }
    }
}
