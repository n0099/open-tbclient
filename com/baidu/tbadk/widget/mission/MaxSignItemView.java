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

    /* renamed from: e  reason: collision with root package name */
    public int f40039e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f40040f;

    /* renamed from: g  reason: collision with root package name */
    public LineView f40041g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f40042h;

    /* renamed from: i  reason: collision with root package name */
    public b f40043i;

    /* renamed from: j  reason: collision with root package name */
    public int f40044j;
    public int k;
    public int l;
    public int m;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f40045e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MaxSignItemView f40046f;

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
            this.f40046f = maxSignItemView;
            this.f40045e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f40045e.f40055j) {
                return;
            }
            Iterator it = this.f40046f.f40042h.iterator();
            while (it.hasNext()) {
                ((c) it.next()).d(false);
            }
            this.f40045e.d(true);
            if (this.f40046f.f40043i != null) {
                this.f40046f.f40043i.a(this.f40045e.k);
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
        public int f40047b;

        /* renamed from: c  reason: collision with root package name */
        public int f40048c;

        /* renamed from: d  reason: collision with root package name */
        public int f40049d;

        /* renamed from: e  reason: collision with root package name */
        public int f40050e;

        /* renamed from: f  reason: collision with root package name */
        public View f40051f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f40052g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f40053h;

        /* renamed from: i  reason: collision with root package name */
        public CircleView f40054i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f40055j;
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
            this.a = R.drawable.ic_pic_mask_task_complete_svg;
            this.f40047b = R.drawable.ic_pic_mask_task_select_svg;
            this.f40048c = R.drawable.ic_pic_mask_task_comingsoon_svg;
            this.f40049d = R.drawable.ic_pic_mask_task_uncomplete_svg;
            this.f40050e = R.drawable.ic_pic_mask_task_comingsoon_svg;
            this.f40055j = false;
            this.k = activeCenterStatusData;
            this.f40051f = view;
            this.f40052g = (ImageView) view.findViewById(R.id.item_icon);
            this.f40053h = (TextView) this.f40051f.findViewById(R.id.item_text);
            CircleView circleView = (CircleView) this.f40051f.findViewById(R.id.select_circle);
            this.f40054i = circleView;
            circleView.setVisibility(4);
            int i4 = activeCenterStatusData.is_today_mission;
            if (i4 == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.f40050e = this.a;
                } else {
                    this.f40050e = this.f40049d;
                }
            } else if (i4 == 1) {
                this.f40054i.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.f40050e = this.a;
                } else {
                    this.f40050e = this.f40047b;
                }
            } else {
                this.f40050e = this.f40048c;
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f40052g, this.f40050e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f40053h, (int) R.color.CAM_X0109);
            TextView textView = this.f40053h;
            textView.setText(activeCenterStatusData.day + "天");
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.f40055j = true;
                    this.f40054i.setVisibility(0);
                    return;
                }
                this.f40055j = false;
                this.f40054i.setVisibility(4);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f40052g, this.f40050e, SvgManager.SvgResourceStateType.NORMAL);
                SkinManager.setViewTextColor(this.f40053h, (int) R.color.CAM_X0109);
                this.f40054i.onChangeSkinType();
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
        this.f40039e = 3;
        this.f40042h = new ArrayList<>();
        this.l = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.m = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        d();
    }

    public final c c(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activeCenterStatusData)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.max_sing_dialog_item_view, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.weight = 1.0f;
            this.f40040f.addView(inflate, layoutParams);
            c cVar = new c(inflate, activeCenterStatusData);
            cVar.f40052g.setOnClickListener(new a(this, cVar));
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.max_sign_dialog_cus_view, (ViewGroup) this, true);
            this.f40040f = (LinearLayout) findViewById(R.id.sign_item_container);
            this.f40041g = (LineView) findViewById(R.id.line_view);
            this.f40044j = n.f(getContext(), R.dimen.tbds3);
            this.k = n.f(getContext(), R.dimen.tbds0);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f40039e != i2) {
                this.f40041g.onChangeSkinType();
                Iterator<c> it = this.f40042h.iterator();
                while (it.hasNext()) {
                    it.next().e();
                }
            }
            this.f40039e = i2;
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
                int i6 = this.f40044j;
                if (i5 != i6 || marginLayoutParams.rightMargin != i6) {
                    int i7 = this.f40044j;
                    marginLayoutParams.leftMargin = i7;
                    marginLayoutParams.rightMargin = i7;
                    setLayoutParams(layoutParams);
                }
            }
        }
        if (this.f40041g.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f40041g.getLayoutParams();
            if (size <= 3) {
                int i8 = marginLayoutParams2.leftMargin;
                int i9 = this.l;
                if (i8 != i9 || marginLayoutParams2.rightMargin != i9) {
                    int i10 = this.l;
                    marginLayoutParams2.leftMargin = i10;
                    marginLayoutParams2.rightMargin = i10;
                    this.f40041g.setLayoutParams(marginLayoutParams2);
                }
            } else {
                int i11 = marginLayoutParams2.leftMargin;
                int i12 = this.m;
                if (i11 != i12 || marginLayoutParams2.rightMargin != i12) {
                    int i13 = this.m;
                    marginLayoutParams2.leftMargin = i13;
                    marginLayoutParams2.rightMargin = i13;
                    this.f40041g.setLayoutParams(marginLayoutParams2);
                }
            }
        }
        this.f40040f.removeAllViews();
        this.f40042h.clear();
        for (int i14 = 0; i14 < size; i14++) {
            this.f40042h.add(c(arrayList.get(i14)));
        }
    }

    public void setItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f40043i = bVar;
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
        this.f40039e = 3;
        this.f40042h = new ArrayList<>();
        this.l = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.m = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds115);
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
        this.f40039e = 3;
        this.f40042h = new ArrayList<>();
        this.l = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.m = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        d();
    }
}
