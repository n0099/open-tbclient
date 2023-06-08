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
/* loaded from: classes6.dex */
public class h39 {
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

    /* loaded from: classes6.dex */
    public interface c {
        void a(long j, String str);

        void b(boolean z);
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h39 a;

        public a(h39 h39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h39Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.k || !ViewHelper.checkUpIsLogin(this.a.a)) {
                return;
            }
            this.a.k = true;
            this.a.d.startAnimation(this.a.g());
            if (this.a.g != null) {
                this.a.g.b(this.a.h);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExcellentPbThreadInfo a;
        public final /* synthetic */ h39 b;

        public b(h39 h39Var, ExcellentPbThreadInfo excellentPbThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h39Var, excellentPbThreadInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h39Var;
            this.a = excellentPbThreadInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.g != null) {
                c cVar = this.b.g;
                long longValue = this.a.forum.forum_id.longValue();
                cVar.a(longValue, this.a.thread_id + "");
            }
        }
    }

    public h39(Context context) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01fc, (ViewGroup) null);
        this.b = inflate;
        this.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0906fe);
        this.d = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090700);
        this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090701);
        this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0906ff);
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
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (textView = this.c) != null) {
            textView.setText(i);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) && (textView = this.f) != null) {
            textView.setOnClickListener(onClickListener);
        }
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

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.h = z;
            if (z) {
                SkinManager.setImageResource(this.d, R.drawable.obfuscated_res_0x7f08048c);
            } else {
                SkinManager.setImageResource(this.d, R.drawable.obfuscated_res_0x7f08048b);
            }
            this.d.setVisibility(0);
        }
    }

    public final Animation g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.j == null) {
                this.j = AnimationUtils.loadAnimation(this.a, R.anim.praise_animation_scale3);
            }
            return this.j;
        }
        return (Animation) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k = false;
        }
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048581, this, j) != null) || j < 0) {
            return;
        }
        this.i = j;
        TextView textView = this.e;
        if (textView != null) {
            textView.setVisibility(0);
            this.e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f044a, StringHelper.numFormatOver10000(j)));
        }
        TextView textView2 = this.e;
        if (textView2 != null && textView2.getVisibility() == 8) {
            this.e.setVisibility(0);
        }
    }

    public void update(ExcellentPbThreadInfo excellentPbThreadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, excellentPbThreadInfo) != null) || excellentPbThreadInfo == null) {
            return;
        }
        j(R.string.obfuscated_res_0x7f0f0446);
        l(excellentPbThreadInfo.zan.zansum.longValue());
        o(excellentPbThreadInfo.zan.is_zan.booleanValue());
        this.d.setOnClickListener(new a(this));
        k(new b(this, excellentPbThreadInfo));
    }
}
