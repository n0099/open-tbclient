package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class f25 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<Integer, Integer[]> p;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<CharSequence> b;
    public c c;
    public final Activity d;
    public final ViewGroup e;
    public final ViewGroup f;
    public final TextView g;
    public final View h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public AlertDialog n;
    public int o;

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int a = 2131755970;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-854282046, "Lcom/baidu/tieba/f25$b;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-854282046, "Lcom/baidu/tieba/f25$b;");
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(f25 f25Var, int i, View view2);
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ f25 c;

        public a(f25 f25Var, int i, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f25Var, Integer.valueOf(i), textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = f25Var;
            this.a = i;
            this.b = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.c.c.a(this.c, this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947712256, "Lcom/baidu/tieba/f25;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947712256, "Lcom/baidu/tieba/f25;");
                return;
            }
        }
        HashMap<Integer, Integer[]> hashMap = new HashMap<>(2);
        p = hashMap;
        hashMap.put(0, new Integer[]{Integer.valueOf((int) R.drawable.dialg_alert_btn_bg), Integer.valueOf((int) R.drawable.dialog_bdalert_button_textcolor_pressed)});
        p.put(1, new Integer[]{Integer.valueOf((int) R.drawable.btn_blue_square), Integer.valueOf((int) R.color.CAM_X0201)});
    }

    public f25(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = false;
        this.o = -1;
        this.d = activity;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_bdlist, (ViewGroup) null);
        this.e = viewGroup;
        this.g = (TextView) viewGroup.findViewById(R.id.dialog_title_list);
        this.f = (ViewGroup) this.e.findViewById(R.id.dialog_content);
        this.h = this.e.findViewById(R.id.line_bg);
        this.i = R.layout.dialog_bdlist_item;
    }

    public View f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ViewGroup viewGroup = this.f;
            if (viewGroup == null) {
                return null;
            }
            int childCount = viewGroup.getChildCount();
            if (i < 0 || i > childCount - 1) {
                return null;
            }
            return this.f.getChildAt(i);
        }
        return (View) invokeI.objValue;
    }

    public f25 g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.j = i;
            return this;
        }
        return (f25) invokeI.objValue;
    }

    public f25 h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.k = i;
            return this;
        }
        return (f25) invokeI.objValue;
    }

    public f25 k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            l(this.d.getResources().getString(i));
            return this;
        }
        return (f25) invokeI.objValue;
    }

    public f25 l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.a = str;
            return this;
        }
        return (f25) invokeL.objValue;
    }

    public void b(g9<?> g9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, g9Var) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f.removeAllViews();
            List<CharSequence> list = this.b;
            boolean z = false;
            if (list != null && list.size() > 0) {
                int size = this.b.size();
                for (int i = 0; i < size; i++) {
                    d(i);
                }
            }
            if (g9Var instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) g9Var;
                hx4 layoutMode = tbPageContext.getLayoutMode();
                if (skinType == 4) {
                    z = true;
                }
                layoutMode.l(z);
                tbPageContext.getLayoutMode().k(this.e);
            }
            this.e.setBackgroundResource(R.drawable.transparent_bg);
        }
    }

    public f25 c(g9<?> g9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g9Var)) == null) {
            if (this.m) {
                return this;
            }
            this.m = true;
            if (!TextUtils.isEmpty(this.a)) {
                this.g.setText(this.a);
                this.g.setVisibility(0);
                this.h.setVisibility(0);
            } else {
                this.g.setVisibility(8);
                this.h.setVisibility(8);
            }
            b(g9Var);
            return this;
        }
        return (f25) invokeL.objValue;
    }

    public final View d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            View inflate = LayoutInflater.from(this.d).inflate(this.i, this.f, false);
            LinearLayout linearLayout = (LinearLayout) inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.dialog_item_btn);
            int i2 = this.l;
            if (i2 != -1) {
                textView.setTextSize(0, i2);
            }
            if (this.o != -1) {
                textView.setPadding(0, 0, 0, 0);
                textView.setGravity(this.o);
            }
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0914c0);
            CharSequence charSequence = this.b.get(i);
            if (charSequence.length() <= 0) {
                charSequence = "";
            }
            textView.setText(charSequence);
            if (i == this.b.size() - 1) {
                findViewById.setVisibility(8);
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_bg_selector);
            } else if (this.b.size() == 1) {
                findViewById.setVisibility(8);
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_only_one_bg_selector);
            } else if (i == 0 && StringUtils.isNull(this.a)) {
                SkinManager.setBackgroundResource(inflate, R.drawable.dialog_single_button_first_bg_selector);
            } else {
                SkinManager.setBackgroundResource(inflate, R.drawable.dialg_alert_btn_bg);
            }
            if (this.c != null) {
                linearLayout.setOnClickListener(new a(this, i, textView));
            }
            this.f.addView(inflate);
            return inflate;
        }
        return (View) invokeI.objValue;
    }

    public void e() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (alertDialog = this.n) != null) {
            ug.a(alertDialog, this.d);
        }
    }

    public f25 i(List<CharSequence> list, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, list, cVar)) == null) {
            if (list != null && list.size() > 0) {
                this.b = list;
                if (cVar != null) {
                    this.c = cVar;
                }
            }
            return this;
        }
        return (f25) invokeLL.objValue;
    }

    public f25 j(CharSequence[] charSequenceArr, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequenceArr, cVar)) == null) {
            if (charSequenceArr != null && charSequenceArr.length > 0) {
                i(Arrays.asList(charSequenceArr), cVar);
            }
            return this;
        }
        return (f25) invokeLL.objValue;
    }

    public f25 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.m) {
                AlertDialog alertDialog = this.n;
                if (alertDialog != null) {
                    ug.i(alertDialog, this.d);
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.d, R.style.obfuscated_res_0x7f100148).create();
                this.n = create;
                GreyUtil.grey(create);
                this.n.setCanceledOnTouchOutside(true);
                if (!ug.i(this.n, this.d)) {
                    return this;
                }
                Window window = this.n.getWindow();
                if (this.j == -1) {
                    this.j = b.a;
                }
                if (this.k == -1) {
                    this.k = 17;
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.setGravity(this.k);
                window.setContentView(this.e);
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (f25) invokeV.objValue;
    }
}
