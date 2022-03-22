package com.baidu.tbadk.widget.mission;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class MaxSignItemView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public LineView f30857b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<c> f30858c;

    /* renamed from: d  reason: collision with root package name */
    public b f30859d;

    /* renamed from: e  reason: collision with root package name */
    public int f30860e;

    /* renamed from: f  reason: collision with root package name */
    public int f30861f;

    /* renamed from: g  reason: collision with root package name */
    public int f30862g;

    /* renamed from: h  reason: collision with root package name */
    public int f30863h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MaxSignItemView f30864b;

        public a(MaxSignItemView maxSignItemView, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maxSignItemView, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30864b = maxSignItemView;
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.j) {
                return;
            }
            Iterator it = this.f30864b.f30858c.iterator();
            while (it.hasNext()) {
                ((c) it.next()).d(false);
            }
            this.a.d(true);
            if (this.f30864b.f30859d != null) {
                this.f30864b.f30859d.a(this.a.k);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f30865b;

        /* renamed from: c  reason: collision with root package name */
        public int f30866c;

        /* renamed from: d  reason: collision with root package name */
        public int f30867d;

        /* renamed from: e  reason: collision with root package name */
        public int f30868e;

        /* renamed from: f  reason: collision with root package name */
        public View f30869f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f30870g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f30871h;
        public CircleView i;
        public boolean j;
        public ActiveCenterData.ActiveCenterStatusData k;

        public c(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, activeCenterStatusData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = R.drawable.obfuscated_res_0x7f08064f;
            this.f30865b = R.drawable.obfuscated_res_0x7f080650;
            this.f30866c = R.drawable.obfuscated_res_0x7f08064e;
            this.f30867d = R.drawable.obfuscated_res_0x7f080651;
            this.f30868e = R.drawable.obfuscated_res_0x7f08064e;
            this.j = false;
            this.k = activeCenterStatusData;
            this.f30869f = view;
            this.f30870g = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090f7b);
            this.f30871h = (TextView) this.f30869f.findViewById(R.id.obfuscated_res_0x7f090fa9);
            CircleView circleView = (CircleView) this.f30869f.findViewById(R.id.obfuscated_res_0x7f091c6f);
            this.i = circleView;
            circleView.setVisibility(4);
            int i3 = activeCenterStatusData.is_today_mission;
            if (i3 == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.f30868e = this.a;
                } else {
                    this.f30868e = this.f30867d;
                }
            } else if (i3 == 1) {
                this.i.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.f30868e = this.a;
                } else {
                    this.f30868e = this.f30865b;
                }
            } else {
                this.f30868e = this.f30866c;
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f30870g, this.f30868e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f30871h, (int) R.color.CAM_X0109);
            TextView textView = this.f30871h;
            textView.setText(activeCenterStatusData.day + "天");
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.j = true;
                    this.i.setVisibility(0);
                    return;
                }
                this.j = false;
                this.i.setVisibility(4);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxSignItemView(Context context) {
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
        this.f30858c = new ArrayList<>();
        this.f30862g = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.f30863h = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        d();
    }

    public final c c(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activeCenterStatusData)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d053d, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.weight = 1.0f;
            this.a.addView(inflate, layoutParams);
            c cVar = new c(inflate, activeCenterStatusData);
            cVar.f30870g.setOnClickListener(new a(this, cVar));
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d053c, (ViewGroup) this, true);
            this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091d00);
            this.f30857b = (LineView) findViewById(R.id.obfuscated_res_0x7f091269);
            this.f30860e = n.f(getContext(), R.dimen.tbds3);
            this.f30861f = n.f(getContext(), R.dimen.tbds0);
        }
    }

    public void setData(ActiveCenterData activeCenterData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activeCenterData) == null) || activeCenterData == null) {
            return;
        }
        ArrayList<ActiveCenterData.ActiveCenterStatusData> arrayList = activeCenterData.mission_status_list;
        int size = arrayList.size();
        if (arrayList == null || size == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (size <= 3) {
                int i = marginLayoutParams.leftMargin;
                int i2 = this.f30861f;
                if (i != i2 || marginLayoutParams.rightMargin != i2) {
                    int i3 = this.f30861f;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i3;
                    setLayoutParams(marginLayoutParams);
                }
            } else {
                int i4 = marginLayoutParams.leftMargin;
                int i5 = this.f30860e;
                if (i4 != i5 || marginLayoutParams.rightMargin != i5) {
                    int i6 = this.f30860e;
                    marginLayoutParams.leftMargin = i6;
                    marginLayoutParams.rightMargin = i6;
                    setLayoutParams(layoutParams);
                }
            }
        }
        if (this.f30857b.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f30857b.getLayoutParams();
            if (size <= 3) {
                int i7 = marginLayoutParams2.leftMargin;
                int i8 = this.f30862g;
                if (i7 != i8 || marginLayoutParams2.rightMargin != i8) {
                    int i9 = this.f30862g;
                    marginLayoutParams2.leftMargin = i9;
                    marginLayoutParams2.rightMargin = i9;
                    this.f30857b.setLayoutParams(marginLayoutParams2);
                }
            } else {
                int i10 = marginLayoutParams2.leftMargin;
                int i11 = this.f30863h;
                if (i10 != i11 || marginLayoutParams2.rightMargin != i11) {
                    int i12 = this.f30863h;
                    marginLayoutParams2.leftMargin = i12;
                    marginLayoutParams2.rightMargin = i12;
                    this.f30857b.setLayoutParams(marginLayoutParams2);
                }
            }
        }
        this.a.removeAllViews();
        this.f30858c.clear();
        for (int i13 = 0; i13 < size; i13++) {
            this.f30858c.add(c(arrayList.get(i13)));
        }
    }

    public void setItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f30859d = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxSignItemView(Context context, AttributeSet attributeSet) {
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
        this.f30858c = new ArrayList<>();
        this.f30862g = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.f30863h = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxSignItemView(Context context, AttributeSet attributeSet, int i) {
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
        this.f30858c = new ArrayList<>();
        this.f30862g = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.f30863h = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        d();
    }
}
