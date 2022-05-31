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
import com.repackage.bx;
import com.repackage.cx;
import com.repackage.fk7;
import com.repackage.gk7;
import com.repackage.vx6;
import com.repackage.wq4;
import com.repackage.zy4;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class NearbyForumFriendCardView extends LinearLayout implements cx, bx<gk7>, View.OnClickListener {
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
    public fk7 j;
    public gk7 k;

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
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05d4, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0921be);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0921bd);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fb0);
            this.d = findViewById(R.id.obfuscated_res_0x7f091509);
            this.g = findViewById(R.id.obfuscated_res_0x7f091507);
            this.h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091506);
            this.b = findViewById(R.id.obfuscated_res_0x7f0911b4);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f091a1c);
            this.i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.d.setOnClickListener(this);
            c(context);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.j = new fk7(context, zy4.l, 1);
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.j);
            this.i.a(linkedList);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bx
    /* renamed from: d */
    public void a(gk7 gk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gk7Var) == null) {
            this.k = gk7Var;
            fk7 fk7Var = this.j;
            if (fk7Var != null) {
                fk7Var.i0(gk7Var.a);
            }
            this.i.setData(gk7Var.b);
            if (gk7Var.c) {
                this.d.setVisibility(0);
                vx6.o();
                return;
            }
            this.d.setVisibility(4);
        }
    }

    @Override // com.repackage.cx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        HomeGroupUbsUIHelper.handleLineColor(this.g);
        wq4 d = wq4.d(this.c);
        d.v(R.color.CAM_X0105);
        d.z(R.dimen.T_X07);
        d.A(R.string.F_X02);
        wq4 d2 = wq4.d(this.e);
        d2.v(R.color.CAM_X0109);
        d2.z(R.dimen.T_X08);
        d2.A(R.string.F_X01);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f08093e, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        this.a = i;
        wq4 d3 = wq4.d(this.h);
        d3.n(R.string.J_X06);
        d3.f(R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view2) == null) || view2.getId() != R.id.obfuscated_res_0x7f091509 || getContext() == null || this.k == null) {
            return;
        }
        new NearbyFriendsActivityConfig(getContext(), this.k.a).start();
        vx6.i();
    }

    public void setNeedCompleteProfile(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            gk7 gk7Var = this.k;
            if (gk7Var != null) {
                gk7Var.a = z;
            }
            fk7 fk7Var = this.j;
            if (fk7Var != null) {
                fk7Var.i0(z);
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
