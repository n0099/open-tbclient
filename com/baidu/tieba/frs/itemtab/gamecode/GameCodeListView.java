package com.baidu.tieba.frs.itemtab.gamecode;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.o0.a1.i.f;
import c.a.o0.r.v.c;
import c.a.p0.f1.d2.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.GameCodeList;
/* loaded from: classes5.dex */
public class GameCodeListView extends ConstraintLayout implements f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f32757f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f32758g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f32759h;
    public static final int i;
    public static final int j;
    public static final int k;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f32760b;

    /* renamed from: c  reason: collision with root package name */
    public GameCodeAdapter f32761c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f32762d;

    /* renamed from: e  reason: collision with root package name */
    public int f32763e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-251605908, "Lcom/baidu/tieba/frs/itemtab/gamecode/GameCodeListView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-251605908, "Lcom/baidu/tieba/frs/itemtab/gamecode/GameCodeListView;");
                return;
            }
        }
        f32757f = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
        f32758g = n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X007);
        f32759h = n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        i = n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
        j = n.f(TbadkCoreApplication.getInst(), R.dimen.T_X08);
        k = n.f(TbadkCoreApplication.getInst(), R.dimen.T_X06);
        l = n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameCodeListView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32763e = 0;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0332, this);
            EMTextView eMTextView = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090c39);
            this.a = eMTextView;
            eMTextView.setTextSize(0, j);
            EMTextView eMTextView2 = this.a;
            int i2 = f32757f;
            eMTextView2.setPadding(i2, f32758g, i2, f32759h);
            this.a.setGravity(1);
            this.a.setText(R.string.obfuscated_res_0x7f0f0262);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f090c38);
            this.f32760b = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            GameCodeAdapter gameCodeAdapter = new GameCodeAdapter(context);
            this.f32761c = gameCodeAdapter;
            this.f32760b.setAdapter(gameCodeAdapter);
            EMTextView eMTextView3 = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090c37);
            this.f32762d = eMTextView3;
            eMTextView3.setTextSize(0, k);
            this.f32762d.setText(R.string.obfuscated_res_0x7f0f036c);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f32762d.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = l;
            this.f32762d.setLayoutParams(layoutParams);
            EMTextView eMTextView4 = this.f32762d;
            int i3 = i;
            eMTextView4.setPadding(0, i3, 0, i3);
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f32761c.g(aVar);
        }
    }

    @Override // c.a.o0.a1.i.f
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            c d2 = c.d(this);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0212);
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColorSelector(this.f32762d, R.color.CAM_X0107);
            this.f32761c.notifyDataSetChanged();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), this.f32763e), Integer.MIN_VALUE));
        }
    }

    public void setCancelClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f32762d.setOnClickListener(onClickListener);
        }
    }

    public void setData(List<GameCodeList> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f32761c.f(list);
            this.f32761c.notifyDataSetChanged();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setMaxHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f32763e = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameCodeListView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f32763e = 0;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameCodeListView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f32763e = 0;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameCodeListView(Context context, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f32763e = 0;
        this.f32763e = i2;
        a(context);
    }
}
