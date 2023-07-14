package com.baidu.tbadk.widget.multidelmenu.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.s26;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class MultiDelPostMenuView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s26 a;
    public View b;
    public final Activity c;
    public TextView d;
    public TextView e;
    public TextView f;
    public State g;
    public int h;
    public final CustomMessageListener i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final State SELECTED;
        public static final State UNSELECTED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1783542428, "Lcom/baidu/tbadk/widget/multidelmenu/view/MultiDelPostMenuView$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1783542428, "Lcom/baidu/tbadk/widget/multidelmenu/view/MultiDelPostMenuView$State;");
                    return;
                }
            }
            SELECTED = new State("SELECTED", 0);
            State state = new State("UNSELECTED", 1);
            UNSELECTED = state;
            $VALUES = new State[]{SELECTED, state};
        }

        public State(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static State valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (State) Enum.valueOf(State.class, str);
            }
            return (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (State[]) $VALUES.clone();
            }
            return (State[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiDelPostMenuView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MultiDelPostMenuView multiDelPostMenuView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiDelPostMenuView, Integer.valueOf(i)};
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
            this.a = multiDelPostMenuView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.b();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiDelPostMenuView(TbPageContext tbPageContext, s26 s26Var) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, s26Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = State.UNSELECTED;
        this.i = new a(this, 2001304);
        this.c = tbPageContext.getPageActivity();
        this.a = s26Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(this.c).inflate(R.layout.multi_del_post_menu_layout, this);
            View findViewById = findViewById(R.id.multi_del_post_menu_container);
            this.b = findViewById;
            if (findViewById == null) {
                return;
            }
            TextView textView = (TextView) findViewById.findViewById(R.id.multi_del_cancel_btn);
            this.d = textView;
            if (textView != null) {
                textView.setText(R.string.obfuscated_res_0x7f0f03ce);
                this.d.setOnClickListener(this);
            }
            TextView textView2 = (TextView) this.b.findViewById(R.id.multi_del_btn);
            this.e = textView2;
            if (textView2 != null) {
                textView2.setText(R.string.obfuscated_res_0x7f0f0546);
                this.e.setOnClickListener(this);
            }
            TextView textView3 = (TextView) this.b.findViewById(R.id.multi_del_forbidden_btn);
            this.f = textView3;
            if (textView3 != null) {
                textView3.setText(R.string.delete_and_forbidden_one_day);
                this.f.setOnClickListener(this);
            }
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.d, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f, R.drawable.multi_del_bottom_menu_del_forbid_item);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0301);
            SkinManager.setBackgroundResource(this.e, R.drawable.multi_del_bottom_menu_del_item);
            if (this.g == State.SELECTED) {
                TextView textView = this.f;
                if (textView != null) {
                    textView.setAlpha(1.0f);
                }
                TextView textView2 = this.e;
                if (textView2 != null) {
                    textView2.setAlpha(1.0f);
                    return;
                }
                return;
            }
            TextView textView3 = this.f;
            if (textView3 != null) {
                textView3.setAlpha(0.33f);
            }
            TextView textView4 = this.e;
            if (textView4 != null) {
                textView4.setAlpha(0.33f);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.i);
            s26 s26Var = this.a;
            if (s26Var != null && s26Var.c() != null) {
                this.a.c().dismiss();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        s26 s26Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && view2 != null && (s26Var = this.a) != null && s26Var.c() != null) {
            int id = view2.getId();
            if (id == R.id.multi_del_cancel_btn) {
                this.a.c().e();
            }
            if (id == R.id.multi_del_btn) {
                this.a.c().f();
            }
            if (id == R.id.multi_del_forbidden_btn) {
                this.a.c().g();
            }
        }
    }

    public void setDelCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.h = i;
            if (i == 0) {
                this.g = State.UNSELECTED;
            } else {
                this.g = State.SELECTED;
            }
            String string = this.c.getString(R.string.obfuscated_res_0x7f0f0546);
            TextView textView = this.e;
            if (textView != null) {
                if (this.g == State.SELECTED) {
                    this.e.setText(string + i);
                } else {
                    textView.setText(string);
                }
            }
            b();
        }
    }
}
