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
public class SignItemView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f47178e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f47179f;

    /* renamed from: g  reason: collision with root package name */
    public LineView f47180g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f47181h;

    /* renamed from: i  reason: collision with root package name */
    public b f47182i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f47183e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SignItemView f47184f;

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
            this.f47184f = signItemView;
            this.f47183e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47183e.j) {
                return;
            }
            Iterator it = this.f47184f.f47181h.iterator();
            while (it.hasNext()) {
                ((c) it.next()).d(false);
            }
            this.f47183e.d(true);
            if (this.f47184f.f47182i != null) {
                this.f47184f.f47182i.a(this.f47183e.k);
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
        public int f47185a;

        /* renamed from: b  reason: collision with root package name */
        public int f47186b;

        /* renamed from: c  reason: collision with root package name */
        public int f47187c;

        /* renamed from: d  reason: collision with root package name */
        public int f47188d;

        /* renamed from: e  reason: collision with root package name */
        public int f47189e;

        /* renamed from: f  reason: collision with root package name */
        public View f47190f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f47191g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f47192h;

        /* renamed from: i  reason: collision with root package name */
        public CircleView f47193i;
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
            this.f47185a = R.drawable.ic_pic_mask_task_complete_svg;
            this.f47186b = R.drawable.ic_pic_mask_task_select_svg;
            int i4 = R.drawable.ic_pic_mask_task_comingsoon_svg;
            this.f47187c = i4;
            this.f47188d = R.drawable.ic_pic_mask_task_uncomplete_svg;
            this.f47189e = i4;
            this.j = false;
            this.k = activeCenterStatusData;
            this.f47190f = view;
            this.f47191g = (ImageView) view.findViewById(R.id.item_icon);
            this.f47192h = (TextView) this.f47190f.findViewById(R.id.item_text);
            CircleView circleView = (CircleView) this.f47190f.findViewById(R.id.select_circle);
            this.f47193i = circleView;
            circleView.setVisibility(4);
            int i5 = activeCenterStatusData.is_today_mission;
            if (i5 == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.f47189e = this.f47185a;
                } else {
                    this.f47189e = this.f47188d;
                }
            } else if (i5 == 1) {
                this.f47193i.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.f47189e = this.f47185a;
                } else {
                    this.f47189e = this.f47186b;
                }
            } else {
                this.f47189e = this.f47187c;
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f47191g, this.f47189e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f47192h, R.color.CAM_X0109);
            TextView textView = this.f47192h;
            textView.setText(activeCenterStatusData.day + "天");
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.j = true;
                    this.f47193i.setVisibility(0);
                    return;
                }
                this.j = false;
                this.f47193i.setVisibility(4);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f47191g, this.f47189e, SvgManager.SvgResourceStateType.NORMAL);
                SkinManager.setViewTextColor(this.f47192h, R.color.CAM_X0109);
                this.f47193i.onChangeSkinType();
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
        this.f47178e = 3;
        this.f47181h = new ArrayList<>();
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
            this.f47179f.addView(inflate, layoutParams);
            c cVar = new c(inflate, activeCenterStatusData);
            cVar.f47191g.setOnClickListener(new a(this, cVar));
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.sign_dialog_cus_view, (ViewGroup) this, true);
            this.f47179f = (LinearLayout) findViewById(R.id.sign_item_container);
            this.f47180g = (LineView) findViewById(R.id.line_view);
            this.j = l.g(getContext(), R.dimen.tbds23);
            this.k = l.g(getContext(), R.dimen.tbds26);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f47178e != i2) {
                this.f47180g.onChangeSkinType();
                Iterator<c> it = this.f47181h.iterator();
                while (it.hasNext()) {
                    it.next().e();
                }
            }
            this.f47178e = i2;
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
        this.f47179f.removeAllViews();
        this.f47181h.clear();
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
        if (this.f47180g.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f47180g.getLayoutParams();
            if (size <= 3) {
                int i4 = marginLayoutParams2.leftMargin;
                int i5 = this.l;
                if (i4 != i5 || marginLayoutParams2.rightMargin != i5) {
                    int i6 = this.l;
                    marginLayoutParams2.leftMargin = i6;
                    marginLayoutParams2.rightMargin = i6;
                    this.f47180g.setLayoutParams(marginLayoutParams2);
                }
            } else {
                int i7 = marginLayoutParams2.leftMargin;
                int i8 = this.m;
                if (i7 != i8 || marginLayoutParams2.rightMargin != i8) {
                    int i9 = this.m;
                    marginLayoutParams2.leftMargin = i9;
                    marginLayoutParams2.rightMargin = i9;
                    this.f47180g.setLayoutParams(marginLayoutParams2);
                }
            }
        }
        for (int i10 = 0; i10 < size; i10++) {
            this.f47181h.add(c(arrayList.get(i10)));
        }
    }

    public void setItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f47182i = bVar;
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
        this.f47178e = 3;
        this.f47181h = new ArrayList<>();
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
        this.f47178e = 3;
        this.f47181h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }
}
