package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.atomData.NearbyFriendsActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fz;
import com.repackage.gz;
import com.repackage.pz4;
import com.repackage.r07;
import com.repackage.vr4;
import com.repackage.xm7;
import com.repackage.ym7;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class NearbyForumFriendCardView extends LinearLayout implements gz, fz<ym7>, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public View b;
    public TextView c;
    public View d;
    public TextView e;
    public ImageView f;
    public View g;
    public LinearLayout h;
    public BdTypeRecyclerView i;
    public xm7 j;
    public ym7 k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NearbyForumFriendCardView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05ea, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0921c2);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0921c1);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fe1);
            this.d = findViewById(R.id.obfuscated_res_0x7f09152d);
            this.g = findViewById(R.id.obfuscated_res_0x7f09152b);
            this.h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09152a);
            this.b = findViewById(R.id.obfuscated_res_0x7f0911e3);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f091a19);
            this.i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.d.setOnClickListener(this);
            c(context);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.j = new xm7(context, pz4.l, 1);
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.j);
            this.i.a(linkedList);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fz
    /* renamed from: d */
    public void a(ym7 ym7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ym7Var) == null) {
            this.k = ym7Var;
            xm7 xm7Var = this.j;
            if (xm7Var != null) {
                xm7Var.i0(ym7Var.a);
            }
            this.i.setData(ym7Var.b);
            if (ym7Var.c) {
                this.d.setVisibility(0);
                r07.o();
                return;
            }
            this.d.setVisibility(4);
        }
    }

    @Override // com.repackage.gz
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        HomeGroupUbsUIHelper.handleLineColor(this.g);
        vr4 d = vr4.d(this.c);
        d.v(R.color.CAM_X0105);
        d.z(R.dimen.T_X07);
        d.A(R.string.F_X02);
        vr4 d2 = vr4.d(this.e);
        d2.v(R.color.CAM_X0109);
        d2.z(R.dimen.T_X08);
        d2.A(R.string.F_X01);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f08091f, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        this.a = i;
        vr4 d3 = vr4.d(this.h);
        d3.n(R.string.J_X06);
        d3.f(R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view2) == null) || view2.getId() != R.id.obfuscated_res_0x7f09152d || getContext() == null || this.k == null) {
            return;
        }
        new NearbyFriendsActivityConfig(getContext(), this.k.a).start();
        r07.i();
    }

    public void setNeedCompleteProfile(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            ym7 ym7Var = this.k;
            if (ym7Var != null) {
                ym7Var.a = z;
            }
            xm7 xm7Var = this.j;
            if (xm7Var != null) {
                xm7Var.i0(z);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NearbyForumFriendCardView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyForumFriendCardView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = 3;
        b(context);
    }
}
