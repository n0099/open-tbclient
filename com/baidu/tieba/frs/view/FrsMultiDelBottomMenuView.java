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
import c.a.o0.r.r.v0;
import c.a.p0.f1.b;
import c.a.p0.l.f;
import c.a.p0.l.i;
import c.a.p0.l.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.ForumRuleStatus;
/* loaded from: classes5.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f32959b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32960c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32961d;

    /* renamed from: e  reason: collision with root package name */
    public View f32962e;

    /* renamed from: f  reason: collision with root package name */
    public View f32963f;

    /* renamed from: g  reason: collision with root package name */
    public j f32964g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f32965h;
    public boolean i;
    public FrsViewData j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (jVar = this.f32964g) == null) {
            return;
        }
        jVar.u();
    }

    public void b() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (jVar = this.f32964g) == null) {
            return;
        }
        jVar.v();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0343, this);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09147c);
            this.f32959b = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f036c);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f09147b);
            this.f32960c = textView2;
            textView2.setText(R.string.obfuscated_res_0x7f0f048e);
            TextView textView3 = (TextView) findViewById(R.id.obfuscated_res_0x7f09147d);
            this.f32961d = textView3;
            textView3.setText(R.string.obfuscated_res_0x7f0f0491);
            this.f32962e = findViewById(R.id.obfuscated_res_0x7f090805);
            this.f32963f = findViewById(R.id.obfuscated_res_0x7f0907e1);
            this.f32959b.setOnClickListener(this);
            this.f32960c.setOnClickListener(this);
            this.f32961d.setOnClickListener(this);
            d();
            setClickable(true);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f32959b, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f32959b, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f32961d, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f32961d, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f32960c, (int) R.color.CAM_X0301);
            SkinManager.setBackgroundResource(this.f32960c, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setBackgroundColor(this.f32962e, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f32963f, R.color.CAM_X0204);
        }
    }

    public void e() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (fVar = this.a) == null) {
            return;
        }
        fVar.f(null);
        this.a.d();
    }

    public final void f(String str) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.f32965h == null) {
            return;
        }
        if (this.f32964g == null && (frsViewData = this.j) != null && frsViewData.getForum() != null && this.j.getForum().getDeletedReasonInfo() != null) {
            int intValue = this.j.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
            int intValue2 = this.j.getForum().getDeletedReasonInfo().is_boomgrow.intValue();
            ForumRuleStatus forumRuleStatus = this.j.forumRule;
            i iVar = new i(intValue, intValue2, forumRuleStatus != null ? forumRuleStatus.has_forum_rule.intValue() : 0);
            iVar.i(this.j.getForum().getId(), this.j.getForum().getName());
            iVar.h(this.j.getForum().getImage_url());
            iVar.j(this.j.getForum().getUser_level());
            j jVar = new j(this.f32965h, this, iVar, this.j.getUserData());
            this.f32964g = jVar;
            jVar.C(this.i);
        }
        this.f32964g.G(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            this.a.e();
            if (view == this.f32959b) {
                b.f().m();
                if (this.i) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MULTI_MUSK_VIEW_CANCEL_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("fid", b.f().d());
                    statisticItem.param("fname", b.f().e());
                    TiebaStatic.log(statisticItem);
                }
            } else if (view == this.f32960c) {
                if (ListUtils.isEmpty(b.f().g())) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13122").param("obj_type", 1));
                setData(1);
                f("2");
                if (this.i) {
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_MULTI_MUSK_VIEW_MUSK_CLICK);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("fid", b.f().d());
                    statisticItem2.param("fname", b.f().e());
                    TiebaStatic.log(statisticItem2);
                }
            } else if (view != this.f32961d || ListUtils.isEmpty(b.f().g())) {
            } else {
                TiebaStatic.log(new StatisticItem("c13122").param("obj_type", 2));
                setData(2);
                f("2");
                if (this.i) {
                    StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_FRS_MULTI_MUSK_VIEW_MUSK_AND_FORBIDDEN_CLICK);
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem3.param("fid", b.f().d());
                    statisticItem3.param("fname", b.f().e());
                    TiebaStatic.log(statisticItem3);
                    StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem4.param("fid", b.f().d());
                    statisticItem4.param("fname", b.f().e());
                    statisticItem4.param("obj_source", 2);
                    TiebaStatic.log(statisticItem4);
                }
            }
        }
    }

    public void setData(int i) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || this.f32965h == null) {
            return;
        }
        if (this.f32964g == null && (frsViewData = this.j) != null) {
            int intValue = frsViewData.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
            int intValue2 = this.j.getForum().getDeletedReasonInfo().is_boomgrow.intValue();
            ForumRuleStatus forumRuleStatus = this.j.forumRule;
            i iVar = new i(intValue, intValue2, forumRuleStatus != null ? forumRuleStatus.has_forum_rule.intValue() : 0);
            iVar.i(this.j.getForum().getId(), this.j.getForum().getName());
            iVar.h(this.j.getForum().getImage_url());
            iVar.j(this.j.getForum().getUser_level());
            j jVar = new j(this.f32965h, this, iVar, this.j.getUserData());
            this.f32964g = jVar;
            jVar.C(this.i);
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        AntiData c2 = b.f().c();
        if (c2 != null && c2.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = c2.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        List<ThreadData> g2 = b.f().g();
        for (int i3 = 0; i3 < g2.size(); i3++) {
            if (g2.get(i3) != null) {
                jSONArray.put(g2.get(i3).getTid());
                if (this.i) {
                    jSONArray2.put("1");
                } else if (!g2.get(i3).isScoreThread() && !g2.get(i3).isWorksInfo()) {
                    jSONArray2.put("0");
                } else {
                    jSONArray2.put("1");
                }
            }
        }
        v0 v0Var = new v0();
        v0Var.j(sparseArray);
        v0Var.i(i);
        v0Var.p(jSONArray);
        v0Var.m(jSONArray2);
        v0Var.l(b.f().d());
        this.f32964g.E(new String[]{getContext().getString(R.string.obfuscated_res_0x7f0f04a2), getContext().getString(R.string.obfuscated_res_0x7f0f04a3), getContext().getString(R.string.obfuscated_res_0x7f0f04a4), getContext().getString(R.string.obfuscated_res_0x7f0f04a5), getContext().getString(R.string.obfuscated_res_0x7f0f04a6)});
        this.f32964g.D(v0Var);
    }

    public void setDeleteCallback(f.c cVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || (fVar = this.a) == null) {
            return;
        }
        fVar.f(cVar);
    }

    public void setFrsViewData(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, frsViewData) == null) {
            this.j = frsViewData;
        }
    }

    public void setIsBlockMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.i = z;
            if (z) {
                TextView textView = this.f32960c;
                if (textView != null) {
                    textView.setText(R.string.obfuscated_res_0x7f0f1152);
                }
                TextView textView2 = this.f32961d;
                if (textView2 != null) {
                    textView2.setText(R.string.obfuscated_res_0x7f0f1153);
                }
            } else {
                TextView textView3 = this.f32960c;
                if (textView3 != null) {
                    textView3.setText(R.string.obfuscated_res_0x7f0f048e);
                }
                TextView textView4 = this.f32961d;
                if (textView4 != null) {
                    textView4.setText(R.string.obfuscated_res_0x7f0f0491);
                }
            }
            j jVar = this.f32964g;
            if (jVar != null) {
                jVar.C(this.i);
            }
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbPageContext) == null) {
            this.f32965h = tbPageContext;
        }
    }

    public void setSelectNumber(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            String string = getContext().getString(R.string.obfuscated_res_0x7f0f048e);
            if (this.i) {
                string = getContext().getString(R.string.obfuscated_res_0x7f0f1152);
            }
            if (i > 0) {
                string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
            }
            this.f32960c.setText(string);
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
        c();
        this.a = new f("0");
    }
}
