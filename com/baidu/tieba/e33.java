package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.publisher.emoji.adapter.NoHorizontalScrollerVPAdapter;
import com.baidu.swan.apps.publisher.emoji.view.EmojiBagLayout;
import com.baidu.swan.apps.publisher.view.SPSwitchPanelLinearLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static e33 c;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Activity> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947683364, "Lcom/baidu/tieba/e33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947683364, "Lcom/baidu/tieba/e33;");
                return;
            }
        }
        b = am1.a;
    }

    public e33() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static e33 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (e33.class) {
                    if (c == null) {
                        c = new e33();
                    }
                }
            }
            return c;
        }
        return (e33) invokeV.objValue;
    }

    public final View a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EmojiBagLayout emojiBagLayout = new EmojiBagLayout(context);
            emojiBagLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07013f)));
            emojiBagLayout.setEmotionList(c33.c().b());
            return emojiBagLayout;
        }
        return (View) invokeL.objValue;
    }

    public boolean c(Activity activity, ViewGroup viewGroup, View view2, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        IllegalArgumentException illegalArgumentException;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, viewGroup, view2, str, str2, str3})) == null) {
            if (!(viewGroup instanceof SPSwitchPanelLinearLayout)) {
                illegalArgumentException = new IllegalArgumentException("panelLayout must be SPSwitchLinearLayout");
            } else {
                illegalArgumentException = null;
            }
            if (!(view2 instanceof EditText)) {
                illegalArgumentException = new IllegalArgumentException("focus view must be EditText");
            }
            if (illegalArgumentException != null) {
                if (!b) {
                    return false;
                }
                throw illegalArgumentException;
            } else if (TextUtils.isEmpty(str)) {
                return false;
            } else {
                if (b) {
                    Log.d("EmojiPanelManager", "start loading emoji " + str);
                }
                this.a = new WeakReference<>(activity);
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    File v = lo2.v(str2, str3, false, null, null);
                    c33.c().f(v.getAbsolutePath() + File.separator + str);
                    ViewPager viewPager = (ViewPager) viewGroup.findViewById(R.id.obfuscated_res_0x7f0909b7);
                    ImageView imageView = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0909b4);
                    if (imageView != null) {
                        imageView.setImageBitmap(c33.c().d());
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(a(activity.getApplicationContext()));
                    viewPager.setAdapter(new NoHorizontalScrollerVPAdapter(arrayList));
                    EditText editText = (EditText) view2;
                    if (this.a.get() != null) {
                        b33.g(this.a.get().getApplicationContext()).f(editText);
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
