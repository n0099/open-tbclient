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
import c.a.e.e.p.l;
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
/* loaded from: classes6.dex */
public class SignItemView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f48784e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f48785f;

    /* renamed from: g  reason: collision with root package name */
    public LineView f48786g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f48787h;

    /* renamed from: i  reason: collision with root package name */
    public b f48788i;

    /* renamed from: j  reason: collision with root package name */
    public int f48789j;
    public int k;
    public int l;
    public int m;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f48790e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SignItemView f48791f;

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
            this.f48791f = signItemView;
            this.f48790e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f48790e.f48801j) {
                return;
            }
            Iterator it = this.f48791f.f48787h.iterator();
            while (it.hasNext()) {
                ((c) it.next()).d(false);
            }
            this.f48790e.d(true);
            if (this.f48791f.f48788i != null) {
                this.f48791f.f48788i.a(this.f48790e.k);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f48792a;

        /* renamed from: b  reason: collision with root package name */
        public int f48793b;

        /* renamed from: c  reason: collision with root package name */
        public int f48794c;

        /* renamed from: d  reason: collision with root package name */
        public int f48795d;

        /* renamed from: e  reason: collision with root package name */
        public int f48796e;

        /* renamed from: f  reason: collision with root package name */
        public View f48797f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f48798g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f48799h;

        /* renamed from: i  reason: collision with root package name */
        public CircleView f48800i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f48801j;
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
            this.f48792a = R.drawable.ic_pic_mask_task_complete_svg;
            this.f48793b = R.drawable.ic_pic_mask_task_select_svg;
            int i4 = R.drawable.ic_pic_mask_task_comingsoon_svg;
            this.f48794c = i4;
            this.f48795d = R.drawable.ic_pic_mask_task_uncomplete_svg;
            this.f48796e = i4;
            this.f48801j = false;
            this.k = activeCenterStatusData;
            this.f48797f = view;
            this.f48798g = (ImageView) view.findViewById(R.id.item_icon);
            this.f48799h = (TextView) this.f48797f.findViewById(R.id.item_text);
            CircleView circleView = (CircleView) this.f48797f.findViewById(R.id.select_circle);
            this.f48800i = circleView;
            circleView.setVisibility(4);
            int i5 = activeCenterStatusData.is_today_mission;
            if (i5 == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.f48796e = this.f48792a;
                } else {
                    this.f48796e = this.f48795d;
                }
            } else if (i5 == 1) {
                this.f48800i.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.f48796e = this.f48792a;
                } else {
                    this.f48796e = this.f48793b;
                }
            } else {
                this.f48796e = this.f48794c;
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f48798g, this.f48796e, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f48799h, R.color.CAM_X0109);
            TextView textView = this.f48799h;
            textView.setText(activeCenterStatusData.day + "天");
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.f48801j = true;
                    this.f48800i.setVisibility(0);
                    return;
                }
                this.f48801j = false;
                this.f48800i.setVisibility(4);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f48798g, this.f48796e, SvgManager.SvgResourceStateType.NORMAL);
                SkinManager.setViewTextColor(this.f48799h, R.color.CAM_X0109);
                this.f48800i.onChangeSkinType();
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
        this.f48784e = 3;
        this.f48787h = new ArrayList<>();
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
            this.f48785f.addView(inflate, layoutParams);
            c cVar = new c(inflate, activeCenterStatusData);
            cVar.f48798g.setOnClickListener(new a(this, cVar));
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.sign_dialog_cus_view, (ViewGroup) this, true);
            this.f48785f = (LinearLayout) findViewById(R.id.sign_item_container);
            this.f48786g = (LineView) findViewById(R.id.line_view);
            this.f48789j = l.g(getContext(), R.dimen.tbds23);
            this.k = l.g(getContext(), R.dimen.tbds26);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f48784e != i2) {
                this.f48786g.onChangeSkinType();
                Iterator<c> it = this.f48787h.iterator();
                while (it.hasNext()) {
                    it.next().e();
                }
            }
            this.f48784e = i2;
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
        this.f48785f.removeAllViews();
        this.f48787h.clear();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (size <= 3) {
                int i2 = this.k;
                marginLayoutParams.leftMargin = i2;
                marginLayoutParams.rightMargin = i2;
            } else {
                int i3 = this.f48789j;
                marginLayoutParams.leftMargin = i3;
                marginLayoutParams.rightMargin = i3;
            }
            setLayoutParams(marginLayoutParams);
        }
        if (this.f48786g.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f48786g.getLayoutParams();
            if (size <= 3) {
                int i4 = marginLayoutParams2.leftMargin;
                int i5 = this.l;
                if (i4 != i5 || marginLayoutParams2.rightMargin != i5) {
                    int i6 = this.l;
                    marginLayoutParams2.leftMargin = i6;
                    marginLayoutParams2.rightMargin = i6;
                    this.f48786g.setLayoutParams(marginLayoutParams2);
                }
            } else {
                int i7 = marginLayoutParams2.leftMargin;
                int i8 = this.m;
                if (i7 != i8 || marginLayoutParams2.rightMargin != i8) {
                    int i9 = this.m;
                    marginLayoutParams2.leftMargin = i9;
                    marginLayoutParams2.rightMargin = i9;
                    this.f48786g.setLayoutParams(marginLayoutParams2);
                }
            }
        }
        for (int i10 = 0; i10 < size; i10++) {
            this.f48787h.add(c(arrayList.get(i10)));
        }
    }

    public void setItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f48788i = bVar;
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
        this.f48784e = 3;
        this.f48787h = new ArrayList<>();
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
        this.f48784e = 3;
        this.f48787h = new ArrayList<>();
        this.l = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        d();
    }
}
