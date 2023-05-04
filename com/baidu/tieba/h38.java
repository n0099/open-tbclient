package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class h38<T> implements b38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public EMTextView b;
    public SpanGroupEditText c;
    public TextView d;
    public TextView e;
    public a38 f;
    public CustomMessageListener g;
    public ViewGroup h;
    public View i;
    public T j;
    public MetaData k;
    public View.OnAttachStateChangeListener l;

    /* loaded from: classes4.dex */
    public class c implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h38 a;

        /* loaded from: classes4.dex */
        public class a extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, int i) {
                super(i);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i)};
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
                this.a = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                    this.a.a.g();
                }
            }
        }

        public c(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h38Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g == null) {
                this.a.g = new a(this, 2001304);
                MessageManager.getInstance().registerListener(this.a.g);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                MessageManager.getInstance().unRegisterListener(this.a.g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h38 a;

        public a(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h38Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.f != null) {
                this.a.f.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h38 a;

        public b(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h38Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.c.getText() != null) {
                    str = this.a.c.getText().toString();
                } else {
                    str = "";
                }
                this.a.k(str);
                if (this.a.f != null) {
                    this.a.f.b(str);
                }
            }
        }
    }

    public h38(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new c(this);
        this.a = context;
        m(context);
        l();
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || this.j == null) {
            return;
        }
        if (this.k.groupData != null) {
            b(str);
        } else {
            a(str);
        }
    }

    public void n(a38 a38Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a38Var) == null) {
            this.f = a38Var;
        }
    }

    public void o(T t, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, t, metaData) == null) {
            this.j = t;
            this.k = metaData;
            f(metaData);
        }
    }

    public final void f(MetaData metaData) {
        String name_show;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, metaData) != null) || metaData == null) {
            return;
        }
        GroupInfoData groupInfoData = metaData.groupData;
        if (groupInfoData != null) {
            name_show = groupInfoData.getName();
            SpanGroupEditText spanGroupEditText = this.c;
            if (spanGroupEditText != null) {
                spanGroupEditText.setVisibility(8);
            }
        } else {
            name_show = metaData.getName_show();
        }
        EMTextView eMTextView = this.b;
        String string = this.a.getResources().getString(R.string.im_share_title);
        Object[] objArr = new Object[1];
        if (name_show == null) {
            name_show = "";
        }
        objArr[0] = name_show;
        eMTextView.setText(String.format(string, objArr));
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            g35 d = g35.d(this.i);
            d.o(R.string.J_X14);
            d.f(R.color.CAM_X0212);
            g35.d(this.b).w(R.color.CAM_X0109);
            g35 d2 = g35.d(this.c);
            d2.o(R.string.J_X05);
            d2.f(R.color.CAM_X0207);
            this.c.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                p5a.l(this.c, R.drawable.edittext_cursor);
            } else {
                p5a.l(this.c, R.drawable.edittext_cursor_2);
            }
            this.c.setHintTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), (int) R.color.CAM_X0109));
            g35.d(this.d).z(R.color.CAM_X0107);
            g35.d(this.e).z(R.color.CAM_X0304);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.g);
            View view2 = this.i;
            if (view2 != null) {
                view2.removeOnAttachStateChangeListener(this.l);
            }
        }
    }

    public ViewGroup i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.d.setOnClickListener(new a(this));
            this.e.setOnClickListener(new b(this));
        }
    }

    public void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.im_share_dialog, (ViewGroup) null);
            this.i = inflate;
            this.b = (EMTextView) inflate.findViewById(R.id.im_share_title);
            this.h = (ViewGroup) this.i.findViewById(R.id.content_show);
            SpanGroupEditText spanGroupEditText = (SpanGroupEditText) this.i.findViewById(R.id.im_share_input);
            this.c = spanGroupEditText;
            spanGroupEditText.setHint(R.string.im_share_input_hint);
            this.c.setMaxLines(3);
            this.c.setMinLines(3);
            this.c.setIncludeFontPadding(false);
            this.c.setGravity(48);
            this.c.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.T_X06));
            this.c.setLineSpacing(ii.g(context, R.dimen.M_T_X002), 1.0f);
            TextView textView = (TextView) this.i.findViewById(R.id.im_share_op_container_cancel_btn);
            this.d = textView;
            textView.setText(context.getString(R.string.obfuscated_res_0x7f0f038b));
            TextView textView2 = (TextView) this.i.findViewById(R.id.im_share_op_container_share_btn);
            this.e = textView2;
            textView2.setText(context.getString(R.string.action_share));
            this.i.addOnAttachStateChangeListener(this.l);
        }
    }

    public void p(int i, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SEND_MSG).addParam("obj_source", i).addParam("obj_param1", i3).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam(TiebaStatic.Params.FRIEND_UID, str));
        }
    }
}
