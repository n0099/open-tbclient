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
/* loaded from: classes3.dex */
public class ca7 extends o9<MsglistActivity<?>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView b;
    public ImageView c;
    public HorizontalScrollView d;
    public LinearLayout e;
    public int f;
    public rf g;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ca7 a;

        public a(ca7 ca7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ca7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ca7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g != null) {
                this.a.g.q(view2, 18, this.a.f, 0L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GifView a;
        public final /* synthetic */ kb7 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ca7 d;

        public b(ca7 ca7Var, GifView gifView, kb7 kb7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ca7Var, gifView, kb7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ca7Var;
            this.a = gifView;
            this.b = kb7Var;
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
                    this.d.g.q(view2, 19, this.d.f, this.c);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ca7(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d05ab);
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
                super((r9) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
            this.b = (TextView) j(R.id.obfuscated_res_0x7f0915ba);
            this.c = (ImageView) j(R.id.obfuscated_res_0x7f0915b7);
            this.d = (HorizontalScrollView) j(R.id.obfuscated_res_0x7f0915b9);
            this.e = (LinearLayout) j(R.id.obfuscated_res_0x7f0915b8);
            this.b.setText(R.string.obfuscated_res_0x7f0f08ea);
            this.c.setOnClickListener(new a(this));
        }
    }

    public void q(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, chatMessage) == null) && this.e != null && chatMessage != null && chatMessage.getIceBreakEmotions() != null) {
            this.e.removeAllViews();
            int g = yi.g(this.e.getContext(), R.dimen.tbds260);
            int g2 = yi.g(this.e.getContext(), R.dimen.M_W_X004);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            layoutParams.setMargins(0, 0, g2, 0);
            for (int i = 0; i < chatMessage.getIceBreakEmotions().size(); i++) {
                this.e.addView(n(chatMessage.getIceBreakEmotions().get(i), i), layoutParams);
            }
            new StatisticItem("c14661").addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
        }
    }

    public void p(rf rfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rfVar) == null) {
            this.g = rfVar;
        }
    }

    public final GifView n(kb7 kb7Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, kb7Var, i)) == null) {
            GifView gifView = new GifView(this.e.getContext());
            gifView.setDrawerType(1);
            gifView.setConrers(15);
            gifView.setRadiusById(R.string.J_X05);
            gifView.setShowStaticDrawable(false);
            gifView.setPlaceHolder(2);
            gifView.j0(kb7Var.b, 38);
            gifView.setOnClickListener(new b(this, gifView, kb7Var, i));
            return gifView;
        }
        return (GifView) invokeLI.objValue;
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            HorizontalScrollView horizontalScrollView = this.d;
            if (horizontalScrollView != null) {
                qw4 d = qw4.d(horizontalScrollView);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0201);
            }
            TextView textView = this.b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0107);
            }
            ImageView imageView = this.c;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080982, R.color.CAM_X0111, null);
            }
        }
    }
}
