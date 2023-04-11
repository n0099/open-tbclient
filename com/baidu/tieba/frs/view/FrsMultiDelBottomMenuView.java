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
import com.baidu.tieba.hy4;
import com.baidu.tieba.p47;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.vx5;
import com.baidu.tieba.yx5;
import com.baidu.tieba.zx5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.ForumRuleStatus;
/* loaded from: classes4.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vx5 a;
    public TextView b;
    public TextView c;
    public TextView d;
    public View e;
    public View f;
    public zx5 g;
    public TbPageContext h;
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

    public void setIsBlockMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.i = z;
            if (z) {
                TextView textView = this.c;
                if (textView != null) {
                    textView.setText(R.string.obfuscated_res_0x7f0f1256);
                }
                TextView textView2 = this.d;
                if (textView2 != null) {
                    textView2.setText(R.string.shield_and_forbidden_one_day);
                }
            } else {
                TextView textView3 = this.c;
                if (textView3 != null) {
                    textView3.setText(R.string.obfuscated_res_0x7f0f04d9);
                }
                TextView textView4 = this.d;
                if (textView4 != null) {
                    textView4.setText(R.string.delete_and_forbidden_one_day);
                }
            }
            zx5 zx5Var = this.g;
            if (zx5Var != null) {
                zx5Var.F(this.i);
            }
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
        this.a = new vx5("0");
    }

    public void a() {
        zx5 zx5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (zx5Var = this.g) == null) {
            return;
        }
        zx5Var.w();
    }

    public void b() {
        zx5 zx5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (zx5Var = this.g) == null) {
            return;
        }
        zx5Var.x();
    }

    public void e() {
        vx5 vx5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (vx5Var = this.a) != null) {
            vx5Var.f(null);
            this.a.d();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d035c, this);
            TextView textView = (TextView) findViewById(R.id.multi_del_cancel_btn);
            this.b = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f038d);
            TextView textView2 = (TextView) findViewById(R.id.multi_del_btn);
            this.c = textView2;
            textView2.setText(R.string.obfuscated_res_0x7f0f04d9);
            TextView textView3 = (TextView) findViewById(R.id.multi_del_forbidden_btn);
            this.d = textView3;
            textView3.setText(R.string.delete_and_forbidden_one_day);
            this.e = findViewById(R.id.obfuscated_res_0x7f0908d4);
            this.f = findViewById(R.id.obfuscated_res_0x7f0908b0);
            this.b.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            d();
            setClickable(true);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.b, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.d, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0301);
            SkinManager.setBackgroundResource(this.c, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
        }
    }

    public final void f(String str) {
        FrsViewData frsViewData;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || this.h == null) {
            return;
        }
        if (this.g == null && (frsViewData = this.j) != null && frsViewData.getForum() != null && this.j.getForum().getDeletedReasonInfo() != null) {
            int intValue = this.j.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
            int intValue2 = this.j.getForum().getDeletedReasonInfo().is_boomgrow.intValue();
            ForumRuleStatus forumRuleStatus = this.j.forumRule;
            if (forumRuleStatus != null) {
                i = forumRuleStatus.has_forum_rule.intValue();
            } else {
                i = 0;
            }
            yx5 yx5Var = new yx5(intValue, intValue2, i);
            yx5Var.i(this.j.getForum().getId(), this.j.getForum().getName());
            yx5Var.h(this.j.getForum().getImage_url());
            yx5Var.j(this.j.getForum().getUser_level());
            zx5 zx5Var = new zx5(this.h, this, yx5Var, this.j.getUserData());
            this.g = zx5Var;
            zx5Var.F(this.i);
        }
        this.g.J(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            this.a.e();
            if (view2 == this.b) {
                p47.f().m();
                if (this.i) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MULTI_MUSK_VIEW_CANCEL_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("fid", p47.f().d());
                    statisticItem.param("fname", p47.f().e());
                    TiebaStatic.log(statisticItem);
                }
            } else if (view2 == this.c) {
                if (ListUtils.isEmpty(p47.f().g())) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_MULTI_DEL_BUTTON_CLICK).param("obj_type", 1).param("obj_source", "1"));
                setData(1);
                f("2");
                if (this.i) {
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_MULTI_MUSK_VIEW_MUSK_CLICK);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("fid", p47.f().d());
                    statisticItem2.param("fname", p47.f().e());
                    TiebaStatic.log(statisticItem2);
                }
            } else if (view2 != this.d || ListUtils.isEmpty(p47.f().g())) {
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_MULTI_DEL_BUTTON_CLICK).param("obj_type", 2).param("obj_source", "1"));
                setData(2);
                f("2");
                if (this.i) {
                    StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_FRS_MULTI_MUSK_VIEW_MUSK_AND_FORBIDDEN_CLICK);
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem3.param("fid", p47.f().d());
                    statisticItem3.param("fname", p47.f().e());
                    TiebaStatic.log(statisticItem3);
                    StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem4.param("fid", p47.f().d());
                    statisticItem4.param("fname", p47.f().e());
                    statisticItem4.param("obj_source", 2);
                    TiebaStatic.log(statisticItem4);
                }
            }
        }
    }

    public void setData(int i) {
        FrsViewData frsViewData;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048583, this, i) != null) || this.h == null) {
            return;
        }
        if (this.g == null && (frsViewData = this.j) != null) {
            int intValue = frsViewData.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
            int intValue2 = this.j.getForum().getDeletedReasonInfo().is_boomgrow.intValue();
            ForumRuleStatus forumRuleStatus = this.j.forumRule;
            if (forumRuleStatus != null) {
                i2 = forumRuleStatus.has_forum_rule.intValue();
            } else {
                i2 = 0;
            }
            yx5 yx5Var = new yx5(intValue, intValue2, i2);
            yx5Var.i(this.j.getForum().getId(), this.j.getForum().getName());
            yx5Var.h(this.j.getForum().getImage_url());
            yx5Var.j(this.j.getForum().getUser_level());
            zx5 zx5Var = new zx5(this.h, this, yx5Var, this.j.getUserData());
            this.g = zx5Var;
            zx5Var.F(this.i);
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        AntiData c = p47.f().c();
        if (c != null && c.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = c.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        List<ThreadData> g = p47.f().g();
        for (int i4 = 0; i4 < g.size(); i4++) {
            if (g.get(i4) != null) {
                jSONArray.put(g.get(i4).getTid());
                if (this.i) {
                    jSONArray2.put("1");
                } else if (!g.get(i4).isScoreThread() && !g.get(i4).isWorksInfo()) {
                    jSONArray2.put("0");
                } else {
                    jSONArray2.put("1");
                }
            }
        }
        hy4 hy4Var = new hy4();
        hy4Var.j(sparseArray);
        hy4Var.i(i);
        hy4Var.p(jSONArray);
        hy4Var.m(jSONArray2);
        hy4Var.l(p47.f().d());
        this.g.H(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
        this.g.G(hy4Var);
    }

    public void setDeleteCallback(vx5.c cVar) {
        vx5 vx5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) != null) || (vx5Var = this.a) == null) {
            return;
        }
        vx5Var.f(cVar);
    }

    public void setFrsViewData(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, frsViewData) == null) {
            this.j = frsViewData;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbPageContext) == null) {
            this.h = tbPageContext;
        }
    }

    public void setSelectNumber(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            String string = getContext().getString(R.string.obfuscated_res_0x7f0f04d9);
            if (this.i) {
                string = getContext().getString(R.string.obfuscated_res_0x7f0f1256);
            }
            if (i > 0) {
                string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
            }
            this.c.setText(string);
        }
    }
}
