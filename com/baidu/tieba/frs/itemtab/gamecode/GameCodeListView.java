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
import com.repackage.ld5;
import com.repackage.ms4;
import com.repackage.qi;
import com.repackage.sn6;
import java.util.List;
import tbclient.GameCodeList;
/* loaded from: classes3.dex */
public class GameCodeListView extends ConstraintLayout implements ld5 {
    public static /* synthetic */ Interceptable $ic;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;
    public static final int k;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView a;
    public RecyclerView b;
    public GameCodeAdapter c;
    public EMTextView d;
    public int e;

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
        f = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
        g = qi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X007);
        h = qi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        i = qi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
        j = qi.f(TbadkCoreApplication.getInst(), R.dimen.T_X08);
        k = qi.f(TbadkCoreApplication.getInst(), R.dimen.T_X06);
        l = qi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
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
        this.e = 0;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0325, this);
            EMTextView eMTextView = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090c49);
            this.a = eMTextView;
            eMTextView.setTextSize(0, j);
            EMTextView eMTextView2 = this.a;
            int i2 = f;
            eMTextView2.setPadding(i2, g, i2, h);
            this.a.setGravity(1);
            this.a.setText(R.string.obfuscated_res_0x7f0f026c);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f090c48);
            this.b = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            GameCodeAdapter gameCodeAdapter = new GameCodeAdapter(context);
            this.c = gameCodeAdapter;
            this.b.setAdapter(gameCodeAdapter);
            EMTextView eMTextView3 = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090c47);
            this.d = eMTextView3;
            eMTextView3.setTextSize(0, k);
            this.d.setText(R.string.obfuscated_res_0x7f0f0370);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.d.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = l;
            this.d.setLayoutParams(layoutParams);
            EMTextView eMTextView4 = this.d;
            int i3 = i;
            eMTextView4.setPadding(0, i3, 0, i3);
        }
    }

    public void b(sn6 sn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sn6Var) == null) {
            this.c.g(sn6Var);
        }
    }

    @Override // com.repackage.ld5
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            ms4 d = ms4.d(this);
            d.n(R.string.J_X14);
            d.f(R.color.CAM_X0212);
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColorSelector(this.d, R.color.CAM_X0107);
            this.c.notifyDataSetChanged();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), this.e), Integer.MIN_VALUE));
        }
    }

    public void setCancelClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.d.setOnClickListener(onClickListener);
        }
    }

    public void setData(List<GameCodeList> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.c.f(list);
            this.c.notifyDataSetChanged();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setMaxHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.e = i2;
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
        this.e = 0;
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
        this.e = 0;
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
        this.e = 0;
        this.e = i2;
        a(context);
    }
}
