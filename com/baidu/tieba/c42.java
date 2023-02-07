package com.baidu.tieba;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.tieba.d42;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class c42<V extends SwanEditText, M extends d42> extends h42<V, M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c42(@Nullable Context context, @NonNull M m) {
        super(context, m);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (i42) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void f0(@NonNull V v, @NonNull M m) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, v, m) == null) {
            if (l42.h) {
                Log.d("Component-EditText", "renderSelection");
            }
            Editable text = v.getText();
            int i2 = 0;
            if (text != null) {
                i2 = text.length();
            }
            int i3 = m.H;
            if (i3 <= i2 && (i = m.G) >= 0 && i <= i3) {
                v.setSelection(i, i3);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.j42
    /* renamed from: b0 */
    public void Q(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v, m) == null) {
            if (l42.h) {
                Log.d("Component-EditText", "renderBackground");
            }
            v.setBackgroundColor(0);
        }
    }

    public void d0(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, v, m) == null) {
            if (l42.h) {
                Log.d("Component-EditText", "renderCursor");
            }
            Editable text = v.getText();
            int i = 0;
            if (text != null) {
                i = text.length();
            }
            int i2 = m.F;
            if (i2 <= i && i2 >= 0) {
                v.setSelection(i2);
            }
        }
    }

    public final void e0(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, v, m) == null) {
            if (l42.h) {
                Log.d("Component-EditText", "renderMaxLength");
            }
            if (m.D >= 0) {
                v.setFilters(new InputFilter[]{new InputFilter.LengthFilter(m.D)});
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h42, com.baidu.tieba.j42, com.baidu.tieba.l42
    @NonNull
    /* renamed from: Z */
    public o52 k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, m, m2)) == null) {
            o52 k = super.k(m, m2);
            if (q() != 0 && !TextUtils.equals(((SwanEditText) q()).getText().toString(), m2.t)) {
                k.b(6);
            }
            if (m.D != m2.D) {
                k.b(10);
            }
            if (m.F != m2.F) {
                k.b(11);
            }
            if (m.G != m2.G || m.H != m2.H) {
                k.b(12);
            }
            if (!TextUtils.equals(m.I, m2.I)) {
                k.b(13);
            }
            return k;
        }
        return (o52) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h42
    /* renamed from: a0 */
    public void T(@NonNull V v, @NonNull M m, @NonNull o52 o52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, v, m, o52Var) == null) {
            super.O(v, m, o52Var);
            if (o52Var.a(11)) {
                d0(v, m);
            }
            if (o52Var.a(12)) {
                f0(v, m);
            }
            if (o52Var.a(10)) {
                e0(v, m);
            }
            if (o52Var.a(13)) {
                c0(v, m);
            }
        }
    }

    public boolean c0(@NonNull V v, @NonNull M m) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, v, m)) == null) {
            if (l42.h) {
                Log.d("Component-EditText", "renderConfirmType:" + m.I);
            }
            String str = m.I;
            char c = 65535;
            switch (str.hashCode()) {
                case -906336856:
                    if (str.equals("search")) {
                        c = 1;
                        break;
                    }
                    break;
                case SpeedStatsStampTable.AD_LOAD_BEAR_END_STAMP_KEY /* 3304 */:
                    if (str.equals("go")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3089282:
                    if (str.equals("done")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3377907:
                    if (str.equals(UnitedSchemeConstants.UNITED_SCHEME_NEXT)) {
                        c = 2;
                        break;
                    }
                    break;
                case 3526536:
                    if (str.equals("send")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            if (c != 4) {
                                return false;
                            }
                            v.setImeOptions(6);
                        } else {
                            v.setImeOptions(2);
                        }
                    } else {
                        v.setImeOptions(5);
                    }
                } else {
                    v.setImeOptions(3);
                }
            } else {
                v.setImeOptions(4);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
