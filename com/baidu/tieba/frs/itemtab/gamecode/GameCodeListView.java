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
import b.a.e.f.p.l;
import b.a.q0.s.u.c;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.f1;
import b.a.r0.x0.g1;
import b.a.r0.x0.i1;
import b.a.r0.x0.m2.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.GameCodeList;
/* loaded from: classes9.dex */
public class GameCodeListView extends ConstraintLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f49754e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f49755f;

    /* renamed from: g  reason: collision with root package name */
    public GameCodeAdapter f49756g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f49757h;

    /* renamed from: i  reason: collision with root package name */
    public int f49758i;

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
        j = l.g(TbadkCoreApplication.getInst(), d1.tbds48);
        k = l.g(TbadkCoreApplication.getInst(), d1.M_H_X007);
        l = l.g(TbadkCoreApplication.getInst(), d1.M_H_X004);
        m = l.g(TbadkCoreApplication.getInst(), d1.M_H_X005);
        n = l.g(TbadkCoreApplication.getInst(), d1.T_X08);
        o = l.g(TbadkCoreApplication.getInst(), d1.T_X06);
        p = l.g(TbadkCoreApplication.getInst(), d1.M_H_X003);
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
        this.f49758i = 0;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(g1.frs_item_game_code_dialog_view, this);
            EMTextView eMTextView = (EMTextView) findViewById(f1.game_code_title);
            this.f49754e = eMTextView;
            eMTextView.setTextSize(0, n);
            EMTextView eMTextView2 = this.f49754e;
            int i2 = j;
            eMTextView2.setPadding(i2, k, i2, l);
            this.f49754e.setGravity(1);
            this.f49754e.setText(i1.all_game_code_title);
            RecyclerView recyclerView = (RecyclerView) findViewById(f1.game_code_list);
            this.f49755f = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            GameCodeAdapter gameCodeAdapter = new GameCodeAdapter(context);
            this.f49756g = gameCodeAdapter;
            this.f49755f.setAdapter(gameCodeAdapter);
            EMTextView eMTextView3 = (EMTextView) findViewById(f1.game_code_cancel);
            this.f49757h = eMTextView3;
            eMTextView3.setTextSize(0, o);
            this.f49757h.setText(i1.cancel);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f49757h.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = p;
            this.f49757h.setLayoutParams(layoutParams);
            EMTextView eMTextView4 = this.f49757h;
            int i3 = m;
            eMTextView4.setPadding(0, i3, 0, i3);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            c d2 = c.d(this);
            d2.n(i1.J_X14);
            d2.f(c1.CAM_X0212);
            SkinManager.setViewTextColor(this.f49754e, c1.CAM_X0109);
            SkinManager.setViewTextColorSelector(this.f49757h, c1.CAM_X0107);
            this.f49756g.notifyDataSetChanged();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), this.f49758i), Integer.MIN_VALUE));
        }
    }

    public void setCancelClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f49757h.setOnClickListener(onClickListener);
        }
    }

    public void setData(List<GameCodeList> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f49756g.setGameCodeList(list);
            this.f49756g.notifyDataSetChanged();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setMaxHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f49758i = i2;
        }
    }

    public void updateAfterGetGameCodeSuccess(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f49756g.updateAfterGetGameCodeSuccess(aVar);
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
        this.f49758i = 0;
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
        this.f49758i = 0;
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
        this.f49758i = 0;
        this.f49758i = i2;
        a(context);
    }
}
