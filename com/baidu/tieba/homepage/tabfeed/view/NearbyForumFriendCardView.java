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
import c.a.l.p;
import c.a.l.q;
import c.a.t0.b.g.b;
import c.a.t0.s.v.c;
import c.a.t0.u.i;
import c.a.u0.n2.b.a;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.NearbyFriendsActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes12.dex */
public class NearbyForumFriendCardView extends LinearLayout implements q, p<a>, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f44735e;

    /* renamed from: f  reason: collision with root package name */
    public View f44736f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44737g;

    /* renamed from: h  reason: collision with root package name */
    public View f44738h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f44739i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f44740j;
    public View k;
    public LinearLayout l;
    public BdTypeRecyclerView m;
    public c.a.u0.n2.a.a n;
    public a o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NearbyForumFriendCardView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.nearby_forum_friend_card, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f44737g = (TextView) findViewById(R.id.tv_nearby_title);
            this.f44739i = (TextView) findViewById(R.id.tv_nearby_more_tip);
            this.f44740j = (ImageView) findViewById(R.id.iv_nearby_more);
            this.f44738h = findViewById(R.id.nearby_more_layout);
            this.k = findViewById(R.id.nearby_divider_line_top);
            this.l = (LinearLayout) findViewById(R.id.nearby_card_container);
            this.f44736f = findViewById(R.id.layout_nearby_title);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.recyclerview_forum_friend);
            this.m = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f44738h.setOnClickListener(this);
            b(context);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.n = new c.a.u0.n2.a.a(context, i.p, 1);
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.n);
            this.m.addAdapters(linkedList);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) || this.f44735e == i2) {
            return;
        }
        b.j(this.k);
        c d2 = c.d(this.f44737g);
        d2.v(R.color.CAM_X0105);
        d2.z(R.dimen.T_X07);
        d2.A(R.string.F_X02);
        c d3 = c.d(this.f44739i);
        d3.v(R.color.CAM_X0109);
        d3.z(R.dimen.T_X08);
        d3.A(R.string.F_X01);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f44740j, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        this.f44735e = i2;
        c d4 = c.d(this.l);
        d4.n(R.string.J_X06);
        d4.f(R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || view.getId() != R.id.nearby_more_layout || getContext() == null || this.o == null) {
            return;
        }
        new NearbyFriendsActivityConfig(getContext(), this.o.f19730e).start();
        c.a.u0.p1.k.c.i();
    }

    public void setNeedCompleteProfile(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            a aVar = this.o;
            if (aVar != null) {
                aVar.f19730e = z;
            }
            c.a.u0.n2.a.a aVar2 = this.n;
            if (aVar2 != null) {
                aVar2.i0(z);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    public void onBindDataToView(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.o = aVar;
            c.a.u0.n2.a.a aVar2 = this.n;
            if (aVar2 != null) {
                aVar2.i0(aVar.f19730e);
            }
            this.m.setData(aVar.f19731f);
            if (aVar.f19732g) {
                this.f44738h.setVisibility(0);
                c.a.u0.p1.k.c.o();
                return;
            }
            this.f44738h.setVisibility(4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyForumFriendCardView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f44735e = 3;
        a(context);
    }
}
