package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.s0.x.b.d;
import d.a.s0.x.b.f;
/* loaded from: classes5.dex */
public class VotedAreaLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public Context f14413h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f14414i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VotedAreaLayout(Context context) {
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14414i = (TextView) findViewById(R.id.vote_num);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14413h = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(0);
            setGravity(17);
            setBackgroundResource(R.drawable.bar_select_bg_voted_area_layout);
            setMinimumHeight(l.g(getContext(), R.dimen.tbds62));
            setMinimumWidth(l.g(getContext(), R.dimen.tbds172));
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.voted_area_layout, (ViewGroup) this, true);
            a();
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setViewTextColor(this.f14414i, R.color.CAM_X0105, 1, i2);
            SkinManager.setBackgroundResource(this, R.drawable.bar_select_bg_voted_area_layout, i2);
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i2, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, fVar) == null) {
            super.setData(i2, fVar);
            if (this.f14404f != null && this.f14405g != null && this.f14403e >= 0) {
                TextView textView = this.f14414i;
                textView.setText(StringHelper.numFormatOverWan(this.f14405g.m()) + "票");
                c(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            setVisibility(8);
        }
    }

    public void setMyRecordData(d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f14405g = dVar;
        TextView textView = this.f14414i;
        textView.setText(StringHelper.numFormatOverWan(this.f14405g.m()) + "票");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VotedAreaLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b();
    }
}
