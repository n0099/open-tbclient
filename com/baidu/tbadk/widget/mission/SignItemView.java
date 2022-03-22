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
public class SignItemView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f30872b;

    /* renamed from: c  reason: collision with root package name */
    public LineView f30873c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<c> f30874d;

    /* renamed from: e  reason: collision with root package name */
    public b f30875e;

    /* renamed from: f  reason: collision with root package name */
    public int f30876f;

    /* renamed from: g  reason: collision with root package name */
    public int f30877g;

    /* renamed from: h  reason: collision with root package name */
    public int f30878h;
    public int i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SignItemView f30879b;

        public a(SignItemView signItemView, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signItemView, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30879b = signItemView;
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.j) {
                return;
            }
            Iterator it = this.f30879b.f30874d.iterator();
            while (it.hasNext()) {
                ((c) it.next()).d(false);
            }
            this.a.d(true);
            if (this.f30879b.f30875e != null) {
                this.f30879b.f30875e.a(this.a.k);
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
        public int f30880b;

        /* renamed from: c  reason: collision with root package name */
        public int f30881c;

        /* renamed from: d  reason: collision with root package name */
        public int f30882d;

        /* renamed from: e  reason: collision with root package name */
        public int f30883e;

        /* renamed from: f  reason: collision with root package name */
        public View f30884f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f30885g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f30886h;
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
            this.f30880b = R.drawable.obfuscated_res_0x7f080650;
            this.f30881c = R.drawable.obfuscated_res_0x7f08064e;
            this.f30882d = R.drawable.obfuscated_res_0x7f080651;
            this.f30883e = R.drawable.obfuscated_res_0x7f08064e;
            this.j = false;
            this.k = activeCenterStatusData;
            this.f30884f = view;
            this.f30885g = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090f7b);
            this.f30886h = (TextView) this.f30884f.findViewById(R.id.obfuscated_res_0x7f090fa9);
            CircleView circleView = (CircleView) this.f30884f.findViewById(R.id.obfuscated_res_0x7f091c6f);
            this.i = circleView;
            circleView.setVisibility(4);
            int i3 = activeCenterStatusData.is_today_mission;
            if (i3 == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.f30883e = this.a;
                } else {
                    this.f30883e = this.f30882d;
                }
            } else if (i3 == 1) {
                this.i.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.f30883e = this.a;
                } else {
                    this.f30883e = this.f30880b;
                }
            } else {
                this.f30883e = this.f30881c;
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f30885g, this.f30883e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f30886h, (int) R.color.CAM_X0109);
            TextView textView = this.f30886h;
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

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f30885g, this.f30883e, SvgManager.SvgResourceStateType.NORMAL);
                SkinManager.setViewTextColor(this.f30886h, (int) R.color.CAM_X0109);
                this.i.b();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignItemView(Context context) {
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
        this.a = 3;
        this.f30874d = new ArrayList<>();
        this.f30878h = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.i = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }

    public final c c(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activeCenterStatusData)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0781, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.weight = 1.0f;
            this.f30872b.addView(inflate, layoutParams);
            c cVar = new c(inflate, activeCenterStatusData);
            cVar.f30885g.setOnClickListener(new a(this, cVar));
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d077a, (ViewGroup) this, true);
            this.f30872b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091d00);
            this.f30873c = (LineView) findViewById(R.id.obfuscated_res_0x7f091269);
            this.f30876f = n.f(getContext(), R.dimen.tbds23);
            this.f30877g = n.f(getContext(), R.dimen.tbds26);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.a != i) {
                this.f30873c.b();
                Iterator<c> it = this.f30874d.iterator();
                while (it.hasNext()) {
                    it.next().e();
                }
            }
            this.a = i;
        }
    }

    public void setData(ActiveCenterData activeCenterData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, activeCenterData) == null) || activeCenterData == null) {
            return;
        }
        ArrayList<ActiveCenterData.ActiveCenterStatusData> arrayList = activeCenterData.mission_status_list;
        int size = arrayList.size();
        if (arrayList == null || size == 0) {
            return;
        }
        this.f30872b.removeAllViews();
        this.f30874d.clear();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (size <= 3) {
                int i = this.f30877g;
                marginLayoutParams.leftMargin = i;
                marginLayoutParams.rightMargin = i;
            } else {
                int i2 = this.f30876f;
                marginLayoutParams.leftMargin = i2;
                marginLayoutParams.rightMargin = i2;
            }
            setLayoutParams(marginLayoutParams);
        }
        if (this.f30873c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f30873c.getLayoutParams();
            if (size <= 3) {
                int i3 = marginLayoutParams2.leftMargin;
                int i4 = this.f30878h;
                if (i3 != i4 || marginLayoutParams2.rightMargin != i4) {
                    int i5 = this.f30878h;
                    marginLayoutParams2.leftMargin = i5;
                    marginLayoutParams2.rightMargin = i5;
                    this.f30873c.setLayoutParams(marginLayoutParams2);
                }
            } else {
                int i6 = marginLayoutParams2.leftMargin;
                int i7 = this.i;
                if (i6 != i7 || marginLayoutParams2.rightMargin != i7) {
                    int i8 = this.i;
                    marginLayoutParams2.leftMargin = i8;
                    marginLayoutParams2.rightMargin = i8;
                    this.f30873c.setLayoutParams(marginLayoutParams2);
                }
            }
        }
        for (int i9 = 0; i9 < size; i9++) {
            this.f30874d.add(c(arrayList.get(i9)));
        }
    }

    public void setItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f30875e = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignItemView(Context context, AttributeSet attributeSet) {
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
        this.a = 3;
        this.f30874d = new ArrayList<>();
        this.f30878h = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.i = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignItemView(Context context, AttributeSet attributeSet, int i) {
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
        this.f30874d = new ArrayList<>();
        this.f30878h = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.i = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }
}
