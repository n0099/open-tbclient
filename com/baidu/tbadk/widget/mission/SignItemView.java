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
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class SignItemView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f13434e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f13435f;

    /* renamed from: g  reason: collision with root package name */
    public LineView f13436g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f13437h;

    /* renamed from: i  reason: collision with root package name */
    public b f13438i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f13439e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SignItemView f13440f;

        public a(SignItemView signItemView, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signItemView, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13440f = signItemView;
            this.f13439e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13439e.j) {
                return;
            }
            Iterator it = this.f13440f.f13437h.iterator();
            while (it.hasNext()) {
                ((c) it.next()).d(false);
            }
            this.f13439e.d(true);
            if (this.f13440f.f13438i != null) {
                this.f13440f.f13438i.a(this.f13439e.k);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f13441a;

        /* renamed from: b  reason: collision with root package name */
        public int f13442b;

        /* renamed from: c  reason: collision with root package name */
        public int f13443c;

        /* renamed from: d  reason: collision with root package name */
        public int f13444d;

        /* renamed from: e  reason: collision with root package name */
        public int f13445e;

        /* renamed from: f  reason: collision with root package name */
        public View f13446f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f13447g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f13448h;

        /* renamed from: i  reason: collision with root package name */
        public CircleView f13449i;
        public boolean j;
        public ActiveCenterData.ActiveCenterStatusData k;

        public c(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, activeCenterStatusData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13441a = R.drawable.ic_pic_mask_task_complete_svg;
            this.f13442b = R.drawable.ic_pic_mask_task_select_svg;
            int i4 = R.drawable.ic_pic_mask_task_comingsoon_svg;
            this.f13443c = i4;
            this.f13444d = R.drawable.ic_pic_mask_task_uncomplete_svg;
            this.f13445e = i4;
            this.j = false;
            this.k = activeCenterStatusData;
            this.f13446f = view;
            this.f13447g = (ImageView) view.findViewById(R.id.item_icon);
            this.f13448h = (TextView) this.f13446f.findViewById(R.id.item_text);
            CircleView circleView = (CircleView) this.f13446f.findViewById(R.id.select_circle);
            this.f13449i = circleView;
            circleView.setVisibility(4);
            int i5 = activeCenterStatusData.is_today_mission;
            if (i5 == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.f13445e = this.f13441a;
                } else {
                    this.f13445e = this.f13444d;
                }
            } else if (i5 == 1) {
                this.f13449i.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.f13445e = this.f13441a;
                } else {
                    this.f13445e = this.f13442b;
                }
            } else {
                this.f13445e = this.f13443c;
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f13447g, this.f13445e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f13448h, R.color.CAM_X0109);
            TextView textView = this.f13448h;
            textView.setText(activeCenterStatusData.day + "天");
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.j = true;
                    this.f13449i.setVisibility(0);
                    return;
                }
                this.j = false;
                this.f13449i.setVisibility(4);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f13447g, this.f13445e, SvgManager.SvgResourceStateType.NORMAL);
                SkinManager.setViewTextColor(this.f13448h, R.color.CAM_X0109);
                this.f13449i.b();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13434e = 3;
        this.f13437h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }

    public final c c(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activeCenterStatusData)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.sing_dialog_item_view, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.weight = 1.0f;
            this.f13435f.addView(inflate, layoutParams);
            c cVar = new c(inflate, activeCenterStatusData);
            cVar.f13447g.setOnClickListener(new a(this, cVar));
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.sign_dialog_cus_view, (ViewGroup) this, true);
            this.f13435f = (LinearLayout) findViewById(R.id.sign_item_container);
            this.f13436g = (LineView) findViewById(R.id.line_view);
            this.j = l.g(getContext(), R.dimen.tbds23);
            this.k = l.g(getContext(), R.dimen.tbds26);
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f13434e != i2) {
                this.f13436g.b();
                Iterator<c> it = this.f13437h.iterator();
                while (it.hasNext()) {
                    it.next().e();
                }
            }
            this.f13434e = i2;
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
        this.f13435f.removeAllViews();
        this.f13437h.clear();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (size <= 3) {
                int i2 = this.k;
                marginLayoutParams.leftMargin = i2;
                marginLayoutParams.rightMargin = i2;
            } else {
                int i3 = this.j;
                marginLayoutParams.leftMargin = i3;
                marginLayoutParams.rightMargin = i3;
            }
            setLayoutParams(marginLayoutParams);
        }
        if (this.f13436g.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f13436g.getLayoutParams();
            if (size <= 3) {
                int i4 = marginLayoutParams2.leftMargin;
                int i5 = this.l;
                if (i4 != i5 || marginLayoutParams2.rightMargin != i5) {
                    int i6 = this.l;
                    marginLayoutParams2.leftMargin = i6;
                    marginLayoutParams2.rightMargin = i6;
                    this.f13436g.setLayoutParams(marginLayoutParams2);
                }
            } else {
                int i7 = marginLayoutParams2.leftMargin;
                int i8 = this.m;
                if (i7 != i8 || marginLayoutParams2.rightMargin != i8) {
                    int i9 = this.m;
                    marginLayoutParams2.leftMargin = i9;
                    marginLayoutParams2.rightMargin = i9;
                    this.f13436g.setLayoutParams(marginLayoutParams2);
                }
            }
        }
        for (int i10 = 0; i10 < size; i10++) {
            this.f13437h.add(c(arrayList.get(i10)));
        }
    }

    public void setItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f13438i = bVar;
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
        this.f13434e = 3;
        this.f13437h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignItemView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f13434e = 3;
        this.f13437h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }
}
