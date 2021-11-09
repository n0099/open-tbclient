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
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x0;
import b.a.r0.j.f;
import b.a.r0.j.i;
import b.a.r0.j.j;
import b.a.r0.x0.b;
import b.a.r0.x0.b1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
import tbclient.ForumRuleStatus;
/* loaded from: classes9.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DELETE_TYPE = 1;
    public static final int FORBIDDEN_AND_DELETE_TYPE = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final f f49124e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f49125f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49126g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49127h;

    /* renamed from: i  reason: collision with root package name */
    public View f49128i;
    public View j;
    public j k;
    public TbPageContext l;
    public boolean m;
    public FrsViewData n;

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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(f1.frs_multi_delete_menu_layout, this);
            TextView textView = (TextView) findViewById(e1.multi_del_cancel_btn);
            this.f49125f = textView;
            textView.setText(h1.cancel);
            TextView textView2 = (TextView) findViewById(e1.multi_del_btn);
            this.f49126g = textView2;
            textView2.setText(h1.delete);
            TextView textView3 = (TextView) findViewById(e1.multi_del_forbidden_btn);
            this.f49127h = textView3;
            textView3.setText(h1.delete_and_forbidden_one_day);
            this.f49128i = findViewById(e1.divider_top_line);
            this.j = findViewById(e1.divider);
            this.f49125f.setOnClickListener(this);
            this.f49126g.setOnClickListener(this);
            this.f49127h.setOnClickListener(this);
            onChangeSkinType();
            setClickable(true);
        }
    }

    public final void b(String str) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.l == null) {
            return;
        }
        if (this.k == null && (frsViewData = this.n) != null && frsViewData.getForum() != null && this.n.getForum().getDeletedReasonInfo() != null) {
            int intValue = this.n.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
            int intValue2 = this.n.getForum().getDeletedReasonInfo().is_boomgrow.intValue();
            ForumRuleStatus forumRuleStatus = this.n.forumRule;
            i iVar = new i(intValue, intValue2, forumRuleStatus != null ? forumRuleStatus.has_forum_rule.intValue() : 0);
            iVar.i(this.n.getForum().getId(), this.n.getForum().getName());
            iVar.h(this.n.getForum().getImage_url());
            iVar.j(this.n.getForum().getUser_level());
            j jVar = new j(this.l, this, iVar, this.n.getUserData());
            this.k = jVar;
            jVar.C(this.m);
        }
        this.k.G(str);
    }

    public void dismissLoadingView() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (jVar = this.k) == null) {
            return;
        }
        jVar.u();
    }

    public void dismissPopupWindow() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (jVar = this.k) == null) {
            return;
        }
        jVar.v();
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this, b1.CAM_X0201);
            SkinManager.setViewTextColor(this.f49125f, b1.CAM_X0105);
            SkinManager.setBackgroundResource(this.f49125f, d1.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f49127h, b1.CAM_X0105);
            SkinManager.setBackgroundResource(this.f49127h, d1.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f49126g, b1.CAM_X0301);
            SkinManager.setBackgroundResource(this.f49126g, d1.bg_bottom_up_list_dialog_item);
            SkinManager.setBackgroundColor(this.f49128i, b1.CAM_X0204);
            SkinManager.setBackgroundColor(this.j, b1.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.f49124e.e();
            if (view == this.f49125f) {
                b.f().m();
                if (this.m) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MULTI_MUSK_VIEW_CANCEL_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("fid", b.f().d());
                    statisticItem.param("fname", b.f().e());
                    TiebaStatic.log(statisticItem);
                }
            } else if (view == this.f49126g) {
                if (ListUtils.isEmpty(b.f().g())) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13122").param("obj_type", 1));
                setData(1);
                b("2");
                if (this.m) {
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_MULTI_MUSK_VIEW_MUSK_CLICK);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("fid", b.f().d());
                    statisticItem2.param("fname", b.f().e());
                    TiebaStatic.log(statisticItem2);
                }
            } else if (view != this.f49127h || ListUtils.isEmpty(b.f().g())) {
            } else {
                TiebaStatic.log(new StatisticItem("c13122").param("obj_type", 2));
                setData(2);
                b("2");
                if (this.m) {
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

    public void onDestroy() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (fVar = this.f49124e) == null) {
            return;
        }
        fVar.f(null);
        this.f49124e.d();
    }

    public void setData(int i2) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.l == null) {
            return;
        }
        if (this.k == null && (frsViewData = this.n) != null) {
            int intValue = frsViewData.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
            int intValue2 = this.n.getForum().getDeletedReasonInfo().is_boomgrow.intValue();
            ForumRuleStatus forumRuleStatus = this.n.forumRule;
            i iVar = new i(intValue, intValue2, forumRuleStatus != null ? forumRuleStatus.has_forum_rule.intValue() : 0);
            iVar.i(this.n.getForum().getId(), this.n.getForum().getName());
            iVar.h(this.n.getForum().getImage_url());
            iVar.j(this.n.getForum().getUser_level());
            j jVar = new j(this.l, this, iVar, this.n.getUserData());
            this.k = jVar;
            jVar.C(this.m);
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        AntiData c2 = b.f().c();
        if (c2 != null && c2.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = c2.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        List<d2> g2 = b.f().g();
        for (int i4 = 0; i4 < g2.size(); i4++) {
            if (g2.get(i4) != null) {
                jSONArray.put(g2.get(i4).s1());
                if (this.m) {
                    jSONArray2.put("1");
                } else if (!g2.get(i4).s2() && !g2.get(i4).I2()) {
                    jSONArray2.put("0");
                } else {
                    jSONArray2.put("1");
                }
            }
        }
        x0 x0Var = new x0();
        x0Var.j(sparseArray);
        x0Var.i(i2);
        x0Var.p(jSONArray);
        x0Var.m(jSONArray2);
        x0Var.l(b.f().d());
        this.k.E(new String[]{getContext().getString(h1.delete_thread_reason_1), getContext().getString(h1.delete_thread_reason_2), getContext().getString(h1.delete_thread_reason_3), getContext().getString(h1.delete_thread_reason_4), getContext().getString(h1.delete_thread_reason_5)});
        this.k.D(x0Var);
    }

    public void setDeleteCallback(f.c cVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || (fVar = this.f49124e) == null) {
            return;
        }
        fVar.f(cVar);
    }

    public void setFrsViewData(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, frsViewData) == null) {
            this.n = frsViewData;
        }
    }

    public void setIsBlockMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.m = z;
            if (z) {
                TextView textView = this.f49126g;
                if (textView != null) {
                    textView.setText(h1.shield);
                }
                TextView textView2 = this.f49127h;
                if (textView2 != null) {
                    textView2.setText(h1.shield_and_forbidden_one_day);
                }
            } else {
                TextView textView3 = this.f49126g;
                if (textView3 != null) {
                    textView3.setText(h1.delete);
                }
                TextView textView4 = this.f49127h;
                if (textView4 != null) {
                    textView4.setText(h1.delete_and_forbidden_one_day);
                }
            }
            j jVar = this.k;
            if (jVar != null) {
                jVar.C(this.m);
            }
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbPageContext) == null) {
            this.l = tbPageContext;
        }
    }

    public void setSelectNumber(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            String string = getContext().getString(h1.delete);
            if (this.m) {
                string = getContext().getString(h1.shield);
            }
            if (i2 > 0) {
                string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i2));
            }
            this.f49126g.setText(string);
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
        a();
        this.f49124e = new f("0");
    }
}
