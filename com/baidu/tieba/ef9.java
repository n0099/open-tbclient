package com.baidu.tieba;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class ef9 implements View.OnClickListener, o57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public View c;
    public View d;
    public ImageView e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public Animation i;
    public TbPageContext j;
    public int k;
    public m57 l;

    public void update(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, obj) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ef9 a;

        /* renamed from: com.baidu.tieba.ef9$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0267a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ a b;

            public RunnableC0267a(a aVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a < 30) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.b.a.j.getPageActivity(), true, 25021)));
                    } else {
                        BdUtilHelper.showToast(this.b.a.j.getPageActivity(), String.format(this.b.a.j.getString(R.string.obfuscated_res_0x7f0f0642), 30));
                    }
                }
            }
        }

        public a(ef9 ef9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ef9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ef9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<MyEmotionGroupData> f = je9.i().f();
                if (f == null) {
                    size = 0;
                } else {
                    size = f.size();
                }
                SafeHandler.getInst().post(new RunnableC0267a(this, size));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ef9 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ b b;

            public a(b bVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a < 30) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.b.a.j.getPageActivity(), 25021)));
                    } else {
                        BdUtilHelper.showToast(this.b.a.j.getPageActivity(), String.format(this.b.a.j.getString(R.string.obfuscated_res_0x7f0f0642), 30));
                    }
                }
            }
        }

        public b(ef9 ef9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ef9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ef9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<MyEmotionGroupData> f = je9.i().f();
                if (f == null) {
                    size = 0;
                } else {
                    size = f.size();
                }
                SafeHandler.getInst().post(new a(this, size));
            }
        }
    }

    public ef9(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = null;
        this.j = tbPageContext;
        this.k = i;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02a9, (ViewGroup) null);
        this.c = inflate;
        this.a = inflate.findViewById(R.id.obfuscated_res_0x7f0909d5);
        View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f0909d6);
        this.b = findViewById;
        findViewById.setOnClickListener(this);
        this.a.setVisibility(0);
        View findViewById2 = this.c.findViewById(R.id.obfuscated_res_0x7f0909da);
        this.d = findViewById2;
        findViewById2.setClickable(false);
        this.d.setOnClickListener(this);
        this.d.setVisibility(8);
        this.e = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09285d);
        this.f = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091000);
        this.g = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090127);
        this.h = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090126);
    }

    @Override // com.baidu.tieba.o57
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ge9.b().a(new b(this));
        }
    }

    @Override // com.baidu.tieba.o57
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ge9.b().a(new a(this));
        }
    }

    public void d() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (imageView = this.e) != null) {
            imageView.clearAnimation();
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void h() {
        m57 m57Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (m57Var = this.l) != null && m57Var.isShowing()) {
            this.l.dismiss();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            m57 m57Var = this.l;
            if (m57Var != null) {
                m57Var.dismiss();
            }
            d();
            this.d.setVisibility(8);
            this.a.setVisibility(0);
        }
    }

    public void k() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (imageView = this.e) != null) {
            imageView.startAnimation(e());
        }
    }

    public final Animation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.i == null) {
                this.i = AnimationUtils.loadAnimation(this.j.getPageActivity(), R.anim.obfuscated_res_0x7f010135);
                this.i.setInterpolator(new LinearInterpolator());
                this.i.setFillAfter(true);
            }
            return this.i;
        }
        return (Animation) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            FaceGroupDraft k = te9.l().k();
            if (k != null && TextUtils.isEmpty(k.getFailMsg())) {
                BdUtilHelper.showToast(this.j.getPageActivity(), k.getFailMsg());
            }
            m(null);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            View view2 = this.a;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.cp_bg_line_d_alpha90, i);
            }
            TextView textView = this.h;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302, i);
            }
            ImageView imageView = this.f;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.emotion_bar_add_icon);
            }
            TextView textView2 = this.g;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, i);
            }
            View view3 = this.d;
            if (view3 != null) {
                SkinManager.setBackgroundColor(view3, R.color.cp_bg_line_d_alpha90, i);
            }
            ImageView imageView2 = this.e;
            if (imageView2 != null) {
                SkinManager.setImageResource(imageView2, R.drawable.emotion_uploading_bar_refresh);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            m57 m57Var = this.l;
            if (m57Var != null) {
                m57Var.dismiss();
            }
            k();
            this.d.setVisibility(0);
            this.a.setVisibility(8);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
            SkinManager.setImageResource(this.e, R.drawable.emotion_uploading_bar_refresh);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0302);
            this.h.setText(R.string.obfuscated_res_0x7f0f0663);
            this.d.setClickable(false);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            m57 m57Var = this.l;
            if (m57Var != null) {
                m57Var.dismiss();
            }
            d();
            this.d.setVisibility(0);
            this.a.setVisibility(8);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
            SkinManager.setImageResource(this.e, R.drawable.emotion_update_fail);
            SkinManager.setViewTextColor(this.h, (int) R.color.common_color_10037);
            if (!TextUtils.isEmpty(str)) {
                this.h.setText(str);
            } else {
                this.h.setText(R.string.obfuscated_res_0x7f0f0640);
            }
            this.d.setClickable(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            boolean z = false;
            if (this.b != null && view2.getId() == this.b.getId() && this.b.isShown()) {
                if (this.k == 1) {
                    if (this.l == null) {
                        m57 m57Var = new m57(this.j.getPageActivity(), this.k);
                        this.l = m57Var;
                        m57Var.d(this);
                    }
                    this.l.c(TbadkCoreApplication.getInst().getSkinType());
                    Rect rect = new Rect();
                    this.j.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    this.l.showAtLocation(this.c, 81, 0, this.j.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                } else {
                    a();
                }
            }
            if (this.d != null && view2.getId() == this.d.getId() && this.d.isShown()) {
                MessageManager messageManager = MessageManager.getInstance();
                Activity pageActivity = this.j.getPageActivity();
                if (this.k == 1) {
                    z = true;
                }
                messageManager.sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(pageActivity, z, 25021)));
            }
        }
    }
}
