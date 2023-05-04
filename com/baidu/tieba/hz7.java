package com.baidu.tieba;

import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hz7 extends x8<MsglistActivity<?>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView b;
    public ImageView c;
    public HorizontalScrollView d;
    public LinearLayout e;
    public int f;
    public af g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz7 a;

        public a(hz7 hz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g != null) {
                this.a.g.D(view2, 18, this.a.f, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GifView a;
        public final /* synthetic */ p08 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ hz7 d;

        public b(hz7 hz7Var, GifView gifView, p08 p08Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz7Var, gifView, p08Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = hz7Var;
            this.a = gifView;
            this.b = p08Var;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.getBdImage() != null && this.a.getBdImage().w()) {
                this.b.c = this.a.getBdImage().r();
                this.b.d = this.a.getBdImage().m();
                if (this.d.g != null) {
                    new StatisticItem("c14658").addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
                    this.d.g.D(view2, 19, this.d.f, this.c);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hz7(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgicebreak_view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((a9) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
            this.b = (TextView) u(R.id.msg_ice_break_title);
            this.c = (ImageView) u(R.id.msg_ice_break_close);
            this.d = (HorizontalScrollView) u(R.id.msg_ice_break_scroll_view);
            this.e = (LinearLayout) u(R.id.msg_ice_break_gif_ll);
            this.b.setText(R.string.im_ice_break_guide_title);
            this.c.setOnClickListener(new a(this));
        }
    }

    public void D(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, chatMessage) == null) && this.e != null && chatMessage != null && chatMessage.getIceBreakEmotions() != null) {
            this.e.removeAllViews();
            int g = ii.g(this.e.getContext(), R.dimen.tbds260);
            int g2 = ii.g(this.e.getContext(), R.dimen.M_W_X004);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            layoutParams.setMargins(0, 0, g2, 0);
            for (int i = 0; i < chatMessage.getIceBreakEmotions().size(); i++) {
                this.e.addView(A(chatMessage.getIceBreakEmotions().get(i), i), layoutParams);
            }
            new StatisticItem("c14661").addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
        }
    }

    public void C(af afVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, afVar) == null) {
            this.g = afVar;
        }
    }

    public final GifView A(p08 p08Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, p08Var, i)) == null) {
            GifView gifView = new GifView(this.e.getContext());
            gifView.setDrawerType(1);
            gifView.setConrers(15);
            gifView.setRadiusById(R.string.J_X05);
            gifView.setShowStaticDrawable(false);
            gifView.setPlaceHolder(2);
            gifView.m0(p08Var.b, 38);
            gifView.setOnClickListener(new b(this, gifView, p08Var, i));
            return gifView;
        }
        return (GifView) invokeLI.objValue;
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            HorizontalScrollView horizontalScrollView = this.d;
            if (horizontalScrollView != null) {
                g35 d = g35.d(horizontalScrollView);
                d.o(R.string.J_X05);
                d.f(R.color.CAM_X0201);
            }
            TextView textView = this.b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0107);
            }
            ImageView imageView = this.c;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_im_pobing_close18, R.color.CAM_X0111, null);
            }
        }
    }
}
