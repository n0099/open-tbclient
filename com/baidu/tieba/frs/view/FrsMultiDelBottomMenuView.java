package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.w0;
import d.a.s0.h.e;
import d.a.s0.h.f;
import d.a.s0.u0.b;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes5.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final e f16142e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16143f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16144g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16145h;

    /* renamed from: i  reason: collision with root package name */
    public View f16146i;
    public View j;
    public f k;
    public TbPageContext l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsMultiDelBottomMenuView(Context context) {
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

    public void a() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.k) == null) {
            return;
        }
        fVar.p();
    }

    public void b() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (fVar = this.k) == null) {
            return;
        }
        fVar.q();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
            TextView textView = (TextView) findViewById(R.id.multi_del_cancel_btn);
            this.f16143f = textView;
            textView.setText(R.string.cancel);
            TextView textView2 = (TextView) findViewById(R.id.multi_del_btn);
            this.f16144g = textView2;
            textView2.setText(R.string.delete);
            TextView textView3 = (TextView) findViewById(R.id.multi_del_forbidden_btn);
            this.f16145h = textView3;
            textView3.setText(R.string.delete_and_forbidden_one_day);
            this.f16146i = findViewById(R.id.divider_top_line);
            this.j = findViewById(R.id.divider);
            this.f16143f.setOnClickListener(this);
            this.f16144g.setOnClickListener(this);
            this.f16145h.setOnClickListener(this);
            d();
            setClickable(true);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f16143f, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f16143f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f16145h, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f16145h, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f16144g, R.color.CAM_X0301);
            SkinManager.setBackgroundResource(this.f16144g, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setBackgroundColor(this.f16146i, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
        }
    }

    public void e() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (eVar = this.f16142e) == null) {
            return;
        }
        eVar.f(null);
        this.f16142e.d();
    }

    public final void f(String str) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (tbPageContext = this.l) == null) {
            return;
        }
        if (this.k == null) {
            this.k = new f(tbPageContext, this);
        }
        this.k.z(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            this.f16142e.e();
            if (view == this.f16143f) {
                b.e().k();
            } else if (view == this.f16144g) {
                if (ListUtils.isEmpty(b.e().f())) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13122").param("obj_type", 1));
                setData(1);
                f("2");
            } else if (view != this.f16145h || ListUtils.isEmpty(b.e().f())) {
            } else {
                TiebaStatic.log(new StatisticItem("c13122").param("obj_type", 2));
                setData(2);
                f("2");
            }
        }
    }

    public void setData(int i2) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (tbPageContext = this.l) == null) {
            return;
        }
        if (this.k == null) {
            this.k = new f(tbPageContext, this);
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        AntiData c2 = b.e().c();
        if (c2 != null && c2.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = c2.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        List<b2> f2 = b.e().f();
        for (int i4 = 0; i4 < f2.size(); i4++) {
            jSONArray.put(f2.get(i4).n1());
        }
        w0 w0Var = new w0();
        w0Var.j(sparseArray);
        w0Var.i(i2);
        w0Var.o(jSONArray);
        w0Var.l(b.e().d());
        this.k.x(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
        this.k.w(w0Var);
    }

    public void setDeleteCallback(e.c cVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || (eVar = this.f16142e) == null) {
            return;
        }
        eVar.f(cVar);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbPageContext) == null) {
            this.l = tbPageContext;
        }
    }

    public void setSelectNumber(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            String string = getContext().getString(R.string.delete);
            if (i2 > 0) {
                string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i2));
            }
            this.f16144g.setText(string);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
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
        c();
        this.f16142e = new e("0");
    }
}
