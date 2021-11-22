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
import b.a.e.f.p.l;
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
/* loaded from: classes8.dex */
public class MaxSignItemView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f47162e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f47163f;

    /* renamed from: g  reason: collision with root package name */
    public LineView f47164g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f47165h;

    /* renamed from: i  reason: collision with root package name */
    public b f47166i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f47167e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MaxSignItemView f47168f;

        public a(MaxSignItemView maxSignItemView, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maxSignItemView, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47168f = maxSignItemView;
            this.f47167e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47167e.j) {
                return;
            }
            Iterator it = this.f47168f.f47165h.iterator();
            while (it.hasNext()) {
                ((c) it.next()).d(false);
            }
            this.f47167e.d(true);
            if (this.f47168f.f47166i != null) {
                this.f47168f.f47166i.a(this.f47167e.k);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f47169a;

        /* renamed from: b  reason: collision with root package name */
        public int f47170b;

        /* renamed from: c  reason: collision with root package name */
        public int f47171c;

        /* renamed from: d  reason: collision with root package name */
        public int f47172d;

        /* renamed from: e  reason: collision with root package name */
        public int f47173e;

        /* renamed from: f  reason: collision with root package name */
        public View f47174f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f47175g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f47176h;

        /* renamed from: i  reason: collision with root package name */
        public CircleView f47177i;
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
            this.f47169a = R.drawable.ic_pic_mask_task_complete_svg;
            this.f47170b = R.drawable.ic_pic_mask_task_select_svg;
            int i4 = R.drawable.ic_pic_mask_task_comingsoon_svg;
            this.f47171c = i4;
            this.f47172d = R.drawable.ic_pic_mask_task_uncomplete_svg;
            this.f47173e = i4;
            this.j = false;
            this.k = activeCenterStatusData;
            this.f47174f = view;
            this.f47175g = (ImageView) view.findViewById(R.id.item_icon);
            this.f47176h = (TextView) this.f47174f.findViewById(R.id.item_text);
            CircleView circleView = (CircleView) this.f47174f.findViewById(R.id.select_circle);
            this.f47177i = circleView;
            circleView.setVisibility(4);
            int i5 = activeCenterStatusData.is_today_mission;
            if (i5 == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.f47173e = this.f47169a;
                } else {
                    this.f47173e = this.f47172d;
                }
            } else if (i5 == 1) {
                this.f47177i.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.f47173e = this.f47169a;
                } else {
                    this.f47173e = this.f47170b;
                }
            } else {
                this.f47173e = this.f47171c;
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f47175g, this.f47173e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f47176h, R.color.CAM_X0109);
            TextView textView = this.f47176h;
            textView.setText(activeCenterStatusData.day + "天");
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.j = true;
                    this.f47177i.setVisibility(0);
                    return;
                }
                this.j = false;
                this.f47177i.setVisibility(4);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f47175g, this.f47173e, SvgManager.SvgResourceStateType.NORMAL);
                SkinManager.setViewTextColor(this.f47176h, R.color.CAM_X0109);
                this.f47177i.onChangeSkinType();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47162e = 3;
        this.f47165h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        d();
    }

    public final c c(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activeCenterStatusData)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.max_sing_dialog_item_view, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.weight = 1.0f;
            this.f47163f.addView(inflate, layoutParams);
            c cVar = new c(inflate, activeCenterStatusData);
            cVar.f47175g.setOnClickListener(new a(this, cVar));
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.max_sign_dialog_cus_view, (ViewGroup) this, true);
            this.f47163f = (LinearLayout) findViewById(R.id.sign_item_container);
            this.f47164g = (LineView) findViewById(R.id.line_view);
            this.j = l.g(getContext(), R.dimen.tbds3);
            this.k = l.g(getContext(), R.dimen.tbds0);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f47162e != i2) {
                this.f47164g.onChangeSkinType();
                Iterator<c> it = this.f47165h.iterator();
                while (it.hasNext()) {
                    it.next().e();
                }
            }
            this.f47162e = i2;
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
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (size <= 3) {
                int i2 = marginLayoutParams.leftMargin;
                int i3 = this.k;
                if (i2 != i3 || marginLayoutParams.rightMargin != i3) {
                    int i4 = this.k;
                    marginLayoutParams.leftMargin = i4;
                    marginLayoutParams.rightMargin = i4;
                    setLayoutParams(marginLayoutParams);
                }
            } else {
                int i5 = marginLayoutParams.leftMargin;
                int i6 = this.j;
                if (i5 != i6 || marginLayoutParams.rightMargin != i6) {
                    int i7 = this.j;
                    marginLayoutParams.leftMargin = i7;
                    marginLayoutParams.rightMargin = i7;
                    setLayoutParams(layoutParams);
                }
            }
        }
        if (this.f47164g.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f47164g.getLayoutParams();
            if (size <= 3) {
                int i8 = marginLayoutParams2.leftMargin;
                int i9 = this.l;
                if (i8 != i9 || marginLayoutParams2.rightMargin != i9) {
                    int i10 = this.l;
                    marginLayoutParams2.leftMargin = i10;
                    marginLayoutParams2.rightMargin = i10;
                    this.f47164g.setLayoutParams(marginLayoutParams2);
                }
            } else {
                int i11 = marginLayoutParams2.leftMargin;
                int i12 = this.m;
                if (i11 != i12 || marginLayoutParams2.rightMargin != i12) {
                    int i13 = this.m;
                    marginLayoutParams2.leftMargin = i13;
                    marginLayoutParams2.rightMargin = i13;
                    this.f47164g.setLayoutParams(marginLayoutParams2);
                }
            }
        }
        this.f47163f.removeAllViews();
        this.f47165h.clear();
        for (int i14 = 0; i14 < size; i14++) {
            this.f47165h.add(c(arrayList.get(i14)));
        }
    }

    public void setItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f47166i = bVar;
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
        this.f47162e = 3;
        this.f47165h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxSignItemView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f47162e = 3;
        this.f47165h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        d();
    }
}
