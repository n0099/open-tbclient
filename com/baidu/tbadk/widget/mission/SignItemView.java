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

    /* renamed from: e  reason: collision with root package name */
    public int f40056e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f40057f;

    /* renamed from: g  reason: collision with root package name */
    public LineView f40058g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f40059h;

    /* renamed from: i  reason: collision with root package name */
    public b f40060i;

    /* renamed from: j  reason: collision with root package name */
    public int f40061j;
    public int k;
    public int l;
    public int m;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f40062e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SignItemView f40063f;

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
            this.f40063f = signItemView;
            this.f40062e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f40062e.f40072j) {
                return;
            }
            Iterator it = this.f40063f.f40059h.iterator();
            while (it.hasNext()) {
                ((c) it.next()).d(false);
            }
            this.f40062e.d(true);
            if (this.f40063f.f40060i != null) {
                this.f40063f.f40060i.a(this.f40062e.k);
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
        public int f40064b;

        /* renamed from: c  reason: collision with root package name */
        public int f40065c;

        /* renamed from: d  reason: collision with root package name */
        public int f40066d;

        /* renamed from: e  reason: collision with root package name */
        public int f40067e;

        /* renamed from: f  reason: collision with root package name */
        public View f40068f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f40069g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f40070h;

        /* renamed from: i  reason: collision with root package name */
        public CircleView f40071i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f40072j;
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
            this.f40064b = R.drawable.ic_pic_mask_task_select_svg;
            this.f40065c = R.drawable.ic_pic_mask_task_comingsoon_svg;
            this.f40066d = R.drawable.ic_pic_mask_task_uncomplete_svg;
            this.f40067e = R.drawable.ic_pic_mask_task_comingsoon_svg;
            this.f40072j = false;
            this.k = activeCenterStatusData;
            this.f40068f = view;
            this.f40069g = (ImageView) view.findViewById(R.id.item_icon);
            this.f40070h = (TextView) this.f40068f.findViewById(R.id.item_text);
            CircleView circleView = (CircleView) this.f40068f.findViewById(R.id.select_circle);
            this.f40071i = circleView;
            circleView.setVisibility(4);
            int i4 = activeCenterStatusData.is_today_mission;
            if (i4 == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.f40067e = this.a;
                } else {
                    this.f40067e = this.f40066d;
                }
            } else if (i4 == 1) {
                this.f40071i.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.f40067e = this.a;
                } else {
                    this.f40067e = this.f40064b;
                }
            } else {
                this.f40067e = this.f40065c;
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f40069g, this.f40067e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f40070h, (int) R.color.CAM_X0109);
            TextView textView = this.f40070h;
            textView.setText(activeCenterStatusData.day + "天");
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.f40072j = true;
                    this.f40071i.setVisibility(0);
                    return;
                }
                this.f40072j = false;
                this.f40071i.setVisibility(4);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f40069g, this.f40067e, SvgManager.SvgResourceStateType.NORMAL);
                SkinManager.setViewTextColor(this.f40070h, (int) R.color.CAM_X0109);
                this.f40071i.onChangeSkinType();
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
        this.f40056e = 3;
        this.f40059h = new ArrayList<>();
        this.l = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }

    public final c c(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activeCenterStatusData)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.sing_dialog_item_view, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.weight = 1.0f;
            this.f40057f.addView(inflate, layoutParams);
            c cVar = new c(inflate, activeCenterStatusData);
            cVar.f40069g.setOnClickListener(new a(this, cVar));
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.sign_dialog_cus_view, (ViewGroup) this, true);
            this.f40057f = (LinearLayout) findViewById(R.id.sign_item_container);
            this.f40058g = (LineView) findViewById(R.id.line_view);
            this.f40061j = n.f(getContext(), R.dimen.tbds23);
            this.k = n.f(getContext(), R.dimen.tbds26);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f40056e != i2) {
                this.f40058g.onChangeSkinType();
                Iterator<c> it = this.f40059h.iterator();
                while (it.hasNext()) {
                    it.next().e();
                }
            }
            this.f40056e = i2;
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
        this.f40057f.removeAllViews();
        this.f40059h.clear();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (size <= 3) {
                int i2 = this.k;
                marginLayoutParams.leftMargin = i2;
                marginLayoutParams.rightMargin = i2;
            } else {
                int i3 = this.f40061j;
                marginLayoutParams.leftMargin = i3;
                marginLayoutParams.rightMargin = i3;
            }
            setLayoutParams(marginLayoutParams);
        }
        if (this.f40058g.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f40058g.getLayoutParams();
            if (size <= 3) {
                int i4 = marginLayoutParams2.leftMargin;
                int i5 = this.l;
                if (i4 != i5 || marginLayoutParams2.rightMargin != i5) {
                    int i6 = this.l;
                    marginLayoutParams2.leftMargin = i6;
                    marginLayoutParams2.rightMargin = i6;
                    this.f40058g.setLayoutParams(marginLayoutParams2);
                }
            } else {
                int i7 = marginLayoutParams2.leftMargin;
                int i8 = this.m;
                if (i7 != i8 || marginLayoutParams2.rightMargin != i8) {
                    int i9 = this.m;
                    marginLayoutParams2.leftMargin = i9;
                    marginLayoutParams2.rightMargin = i9;
                    this.f40058g.setLayoutParams(marginLayoutParams2);
                }
            }
        }
        for (int i10 = 0; i10 < size; i10++) {
            this.f40059h.add(c(arrayList.get(i10)));
        }
    }

    public void setItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f40060i = bVar;
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
        this.f40056e = 3;
        this.f40059h = new ArrayList<>();
        this.l = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds90);
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
        this.f40056e = 3;
        this.f40059h = new ArrayList<>();
        this.l = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }
}
