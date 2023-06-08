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
import com.baidu.tieba.o75;
import com.baidu.tieba.oy;
import com.baidu.tieba.py;
import com.baidu.tieba.qy8;
import com.baidu.tieba.ry8;
import com.baidu.tieba.z18;
import com.baidu.tieba.zg5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class NearbyForumFriendCardView extends LinearLayout implements py, oy<ry8>, View.OnClickListener {
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
    public qy8 j;
    public ry8 k;

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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.oy
    /* renamed from: d */
    public void a(ry8 ry8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ry8Var) == null) {
            this.k = ry8Var;
            qy8 qy8Var = this.j;
            if (qy8Var != null) {
                qy8Var.D(ry8Var.a);
            }
            this.i.setData(ry8Var.b);
            if (ry8Var.c) {
                this.d.setVisibility(0);
                z18.q();
                return;
            }
            this.d.setVisibility(4);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f091871 && getContext() != null && this.k != null) {
            new NearbyFriendsActivityConfig(getContext(), this.k.a).start();
            z18.j();
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

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.j = new qy8(context, zg5.l, 1);
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.j);
            this.i.addAdapters(linkedList);
        }
    }

    public void setNeedCompleteProfile(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            ry8 ry8Var = this.k;
            if (ry8Var != null) {
                ry8Var.a = z;
            }
            qy8 qy8Var = this.j;
            if (qy8Var != null) {
                qy8Var.D(z);
            }
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d06bc, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f09267a);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f092679);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911e7);
            this.d = findViewById(R.id.obfuscated_res_0x7f091871);
            this.g = findViewById(R.id.obfuscated_res_0x7f09186f);
            this.h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09186e);
            this.b = findViewById(R.id.obfuscated_res_0x7f09146b);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f091de2);
            this.i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.d.setOnClickListener(this);
            c(context);
        }
    }

    @Override // com.baidu.tieba.py
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) && this.a != i) {
            HomeGroupUbsUIHelper.handleLineColor(this.g);
            o75 d = o75.d(this.c);
            d.w(R.color.CAM_X0105);
            d.B(R.dimen.T_X07);
            d.C(R.string.F_X02);
            o75 d2 = o75.d(this.e);
            d2.w(R.color.CAM_X0109);
            d2.B(R.dimen.T_X08);
            d2.C(R.string.F_X01);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            this.a = i;
            o75 d3 = o75.d(this.h);
            d3.o(R.string.J_X06);
            d3.f(R.color.CAM_X0205);
        }
    }
}
