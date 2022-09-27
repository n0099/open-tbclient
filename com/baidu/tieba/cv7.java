package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes3.dex */
public class cv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public TextView c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public c g;
    public boolean h;
    public long i;
    public Animation j;
    public boolean k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv7 a;

        public a(cv7 cv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !this.a.k && ViewHelper.checkUpIsLogin(this.a.a)) {
                this.a.k = true;
                this.a.d.startAnimation(this.a.g());
                if (this.a.g != null) {
                    this.a.g.b(this.a.h);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExcellentPbThreadInfo a;
        public final /* synthetic */ cv7 b;

        public b(cv7 cv7Var, ExcellentPbThreadInfo excellentPbThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv7Var, excellentPbThreadInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cv7Var;
            this.a = excellentPbThreadInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.g == null) {
                return;
            }
            c cVar = this.b.g;
            long longValue = this.a.forum.forum_id.longValue();
            cVar.a(longValue, this.a.thread_id + "");
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(long j, String str);

        void b(boolean z);
    }

    public cv7(Context context) {
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
        this.i = 0L;
        this.k = false;
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01da, (ViewGroup) null);
        this.b = inflate;
        this.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09063a);
        this.d = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09063c);
        this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09063d);
        this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09063b);
    }

    public final Animation g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.j == null) {
                this.j = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f0100fb);
            }
            return this.j;
        }
        return (Animation) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public void i(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.g = cVar;
        }
    }

    public void j(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (textView = this.c) == null) {
            return;
        }
        textView.setText(i);
    }

    public void k(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (textView = this.f) == null) {
            return;
        }
        textView.setOnClickListener(onClickListener);
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048581, this, j) == null) || j < 0) {
            return;
        }
        this.i = j;
        TextView textView = this.e;
        if (textView != null) {
            textView.setVisibility(0);
            this.e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f03da, StringHelper.numFormatOver10000(j)));
        }
        TextView textView2 = this.e;
        if (textView2 == null || textView2.getVisibility() != 8) {
            return;
        }
        this.e.setVisibility(0);
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            o(z);
            if (z) {
                this.i++;
            } else {
                this.i--;
            }
            l(this.i);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k = false;
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.h = z;
            if (z) {
                SkinManager.setImageResource(this.d, R.drawable.obfuscated_res_0x7f080420);
            } else {
                SkinManager.setImageResource(this.d, R.drawable.obfuscated_res_0x7f08041f);
            }
            this.d.setVisibility(0);
        }
    }

    public void update(ExcellentPbThreadInfo excellentPbThreadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, excellentPbThreadInfo) == null) || excellentPbThreadInfo == null) {
            return;
        }
        j(R.string.obfuscated_res_0x7f0f03d6);
        l(excellentPbThreadInfo.zan.zansum.longValue());
        o(excellentPbThreadInfo.zan.is_zan.booleanValue());
        this.d.setOnClickListener(new a(this));
        k(new b(this, excellentPbThreadInfo));
    }
}
