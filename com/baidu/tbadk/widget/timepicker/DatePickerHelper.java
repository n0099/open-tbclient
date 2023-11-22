package com.baidu.tbadk.widget.timepicker;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.timepicker.pickerview.listener.OnTimeSelectListener;
import com.baidu.tieba.R;
import com.baidu.tieba.ez5;
import com.baidu.tieba.ty5;
import com.baidu.tieba.vy5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class DatePickerHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity mActivity;
    public ez5 mTimePickerView;

    /* loaded from: classes5.dex */
    public class a implements vy5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DatePickerHelper a;

        /* renamed from: com.baidu.tbadk.widget.timepicker.DatePickerHelper$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC0222a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0222a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a.mTimePickerView != null) {
                    this.a.a.mTimePickerView.f();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a.mTimePickerView != null) {
                    this.a.a.mTimePickerView.D();
                    this.a.a.mTimePickerView.f();
                }
            }
        }

        public a(DatePickerHelper datePickerHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {datePickerHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = datePickerHelper;
        }

        @Override // com.baidu.tieba.vy5
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                SkinManager.setBackgroundResource(view2, R.drawable.person_birthday_select_top_bg);
                TextView textView = (TextView) view2.findViewById(R.id.person_constellation_cancle);
                textView.setOnClickListener(new View$OnClickListenerC0222a(this));
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
                TextView textView2 = (TextView) view2.findViewById(R.id.person_constellation_birthday_complete);
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, 1, TbadkCoreApplication.getInst().getSkinType());
                textView2.setOnClickListener(new b(this));
            }
        }
    }

    public DatePickerHelper(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActivity = activity;
    }

    private vy5 getCustomListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            return new a(this);
        }
        return (vy5) invokeV.objValue;
    }

    public void showTimePicker(OnTimeSelectListener onTimeSelectListener) {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, onTimeSelectListener) == null) && (activity = this.mActivity) != null && !activity.isFinishing()) {
            if (this.mTimePickerView == null) {
                ty5 ty5Var = new ty5(this.mActivity, onTimeSelectListener);
                ty5Var.k(R.layout.person_birthday_select_layout, getCustomListener());
                ty5Var.p(new boolean[]{true, true, true, false, false, false});
                ty5Var.j(this.mActivity.getString(R.string.pickerview_year), this.mActivity.getString(R.string.pickerview_month), this.mActivity.getString(R.string.pickerview_day), this.mActivity.getString(R.string.pickerview_hours), this.mActivity.getString(R.string.pickerview_minutes), this.mActivity.getString(R.string.pickerview_seconds));
                ty5Var.l(2.0f);
                ty5Var.b(false);
                ty5Var.i(SkinManager.getColor(R.color.CAM_X0206));
                ty5Var.m(SkinManager.getColor(R.color.CAM_X0105));
                ty5Var.n(SkinManager.getColor(R.color.CAM_X0109));
                ty5Var.d(SkinManager.getColor(R.color.black_alpha30));
                ty5Var.e(SkinManager.getColor(R.color.CAM_X0201));
                ty5Var.c(false);
                ty5Var.h((ViewGroup) this.mActivity.findViewById(16908290));
                this.mTimePickerView = ty5Var.a();
            }
            this.mTimePickerView.x();
        }
    }
}
