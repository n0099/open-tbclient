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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bv5;
import com.repackage.dv5;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MarkLevelGroup extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public List<View> b;
    public b c;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv5 a;
        public final /* synthetic */ MarkLevelGroup b;

        public a(MarkLevelGroup markLevelGroup, dv5 dv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {markLevelGroup, dv5Var};
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
            this.a = dv5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                for (View view3 : this.b.b) {
                    if (view2 == view3) {
                        this.b.e((FrameLayout) view3.findViewById(R.id.obfuscated_res_0x7f0913a7), true);
                    } else {
                        this.b.e((FrameLayout) view3.findViewById(R.id.obfuscated_res_0x7f0913a7), false);
                    }
                }
                if (this.b.c != null) {
                    this.b.c.a(this.a.b(), this.a.a());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str, String str2);
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

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(0);
            setGravity(1);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d00e4, (ViewGroup) this, true);
            this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0913a8);
        }
    }

    public final void e(FrameLayout frameLayout, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frameLayout, z) == null) {
            if (z) {
                frameLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f4d);
            } else {
                frameLayout.setBackgroundResource(0);
            }
        }
    }

    public void f(bv5 bv5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bv5Var) == null) || bv5Var == null) {
            return;
        }
        List<dv5> c = bv5Var.c();
        if (ListUtils.isEmpty(c)) {
            if (getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023d);
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
            dv5 dv5Var = c.get(i);
            if (dv5Var != null) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d00e3, (ViewGroup) null);
                FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0913a7);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0913aa);
                textView.setText(String.valueOf(i + 1));
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0913a9)).setText(AlaStringHelper.numFormatMarkLevel(dv5Var.d()));
                this.b.add(inflate);
                boolean z = bv5Var.j() == 0;
                if (bv5Var.g() == dv5Var.c()) {
                    e(frameLayout, true);
                    if (z) {
                        textView.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f4b);
                    } else {
                        textView.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f4c);
                    }
                } else if (bv5Var.g() > dv5Var.c()) {
                    e(frameLayout, false);
                    if (z) {
                        textView.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f4b);
                    } else {
                        textView.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f4c);
                    }
                } else if (bv5Var.g() < dv5Var.c()) {
                    e(frameLayout, false);
                    textView.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f4b);
                }
                inflate.setOnClickListener(new a(this, dv5Var));
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) inflate.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070307), -2);
                } else {
                    layoutParams2.width = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070307);
                    layoutParams2.height = -2;
                }
                this.a.addView(inflate, layoutParams2);
            }
        }
    }

    public void setCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.c = bVar;
        }
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
}
