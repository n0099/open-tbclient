package com.baidu.tieba.ala.personcenter.privilege.achievementmark.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.ud6;
import com.baidu.tieba.wd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class MarkLevelGroup extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public List<View> b;
    public b c;

    /* loaded from: classes5.dex */
    public interface b {
        void a(String str, String str2);
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wd6 a;
        public final /* synthetic */ MarkLevelGroup b;

        public a(MarkLevelGroup markLevelGroup, wd6 wd6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {markLevelGroup, wd6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = markLevelGroup;
            this.a = wd6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                for (View view3 : this.b.b) {
                    if (view2 == view3) {
                        this.b.e((FrameLayout) view3.findViewById(R.id.obfuscated_res_0x7f091737), true);
                    } else {
                        this.b.e((FrameLayout) view3.findViewById(R.id.obfuscated_res_0x7f091737), false);
                    }
                }
                if (this.b.c != null) {
                    this.b.c.a(this.a.b(), this.a.a());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkLevelGroup(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkLevelGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkLevelGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        d();
    }

    public void setCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.c = bVar;
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(0);
            setGravity(1);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d00ec, (ViewGroup) this, true);
            this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091738);
        }
    }

    public final void e(FrameLayout frameLayout, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frameLayout, z) == null) {
            if (z) {
                frameLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f081235);
            } else {
                frameLayout.setBackgroundResource(0);
            }
        }
    }

    public void f(ud6 ud6Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ud6Var) != null) || ud6Var == null) {
            return;
        }
        List<wd6> c = ud6Var.c();
        if (ListUtils.isEmpty(c)) {
            if (getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070362);
                setLayoutParams(layoutParams);
            }
            setVisibility(4);
            return;
        }
        setVisibility(0);
        this.a.removeAllViews();
        List<View> list = this.b;
        if (list == null) {
            this.b = new ArrayList();
        } else {
            list.clear();
        }
        int size = c.size();
        for (int i = 0; i < size; i++) {
            wd6 wd6Var = c.get(i);
            if (wd6Var != null) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d00eb, (ViewGroup) null);
                FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091737);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09173a);
                textView.setText(String.valueOf(i + 1));
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091739)).setText(AlaStringHelper.numFormatMarkLevel(wd6Var.d()));
                this.b.add(inflate);
                if (ud6Var.j() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (ud6Var.g() == wd6Var.c()) {
                    e(frameLayout, true);
                    if (z) {
                        textView.setBackgroundResource(R.drawable.obfuscated_res_0x7f081233);
                    } else {
                        textView.setBackgroundResource(R.drawable.obfuscated_res_0x7f081234);
                    }
                } else if (ud6Var.g() > wd6Var.c()) {
                    e(frameLayout, false);
                    if (z) {
                        textView.setBackgroundResource(R.drawable.obfuscated_res_0x7f081233);
                    } else {
                        textView.setBackgroundResource(R.drawable.obfuscated_res_0x7f081234);
                    }
                } else if (ud6Var.g() < wd6Var.c()) {
                    e(frameLayout, false);
                    textView.setBackgroundResource(R.drawable.obfuscated_res_0x7f081233);
                }
                inflate.setOnClickListener(new a(this, wd6Var));
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) inflate.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07041e), -2);
                } else {
                    layoutParams2.width = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07041e);
                    layoutParams2.height = -2;
                }
                this.a.addView(inflate, layoutParams2);
            }
        }
    }
}
