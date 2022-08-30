package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.gl5;
import com.baidu.tieba.jl5;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class el5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements jl5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ hl5 b;
        public final /* synthetic */ boolean c;

        public a(TbPageContext tbPageContext, hl5 hl5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, hl5Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = hl5Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.jl5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (pi.A()) {
                    el5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    ri.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c40);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements gl5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ hl5 b;
        public final /* synthetic */ boolean c;

        public b(TbPageContext tbPageContext, hl5 hl5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, hl5Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = hl5Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.gl5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (pi.A()) {
                    el5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    ri.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c40);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, hl5 hl5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, hl5Var) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = hl5Var.getType() == 3;
        gl5 gl5Var = new gl5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
        if (hl5Var != null) {
            gl5Var.w(z);
        }
        AntiData c = te6.f().c();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (c != null && c.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = c.getDelThreadInfoList();
            for (int i = 0; i < delThreadInfoList.size(); i++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        List<ThreadData> g = te6.f().g();
        for (int i2 = 0; i2 < g.size(); i2++) {
            if (g.get(i2) != null) {
                jSONArray.put(g.get(i2).getTid());
                if (z) {
                    jSONArray2.put("1");
                } else if (!g.get(i2).isScoreThread() && !g.get(i2).isWorksInfo()) {
                    jSONArray2.put("0");
                } else {
                    jSONArray2.put("1");
                }
            }
        }
        eq4 eq4Var = new eq4();
        eq4Var.j(sparseArray);
        if (hl5Var != null) {
            eq4Var.i(hl5Var.getType());
        }
        eq4Var.p(jSONArray);
        eq4Var.m(jSONArray2);
        eq4Var.l(te6.f().d());
        gl5Var.x(eq4Var);
        gl5Var.y(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c0), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c1), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c2), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c3), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c4)});
        gl5Var.A("1");
        gl5Var.z(new b(tbPageContext, hl5Var, z));
    }

    public static void c(TbPageContext tbPageContext, hl5 hl5Var, il5 il5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, hl5Var, il5Var, userData) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = hl5Var.getType() == 3;
        jl5 jl5Var = new jl5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), il5Var, userData);
        if (hl5Var != null) {
            jl5Var.C(z);
        }
        AntiData c = te6.f().c();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (c != null && c.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = c.getDelThreadInfoList();
            for (int i = 0; i < delThreadInfoList.size(); i++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        List<ThreadData> g = te6.f().g();
        for (int i2 = 0; i2 < g.size(); i2++) {
            if (g.get(i2) != null) {
                jSONArray.put(g.get(i2).getTid());
                if (z) {
                    jSONArray2.put("1");
                } else if (!g.get(i2).isScoreThread() && !g.get(i2).isWorksInfo()) {
                    jSONArray2.put("0");
                } else {
                    jSONArray2.put("1");
                }
            }
        }
        eq4 eq4Var = new eq4();
        eq4Var.j(sparseArray);
        if (hl5Var != null) {
            eq4Var.i(hl5Var.getType());
        }
        eq4Var.p(jSONArray);
        eq4Var.m(jSONArray2);
        eq4Var.l(te6.f().d());
        jl5Var.D(eq4Var);
        jl5Var.E(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bb), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bc), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bd), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04be), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bf)});
        jl5Var.G("1");
        jl5Var.F(new a(tbPageContext, hl5Var, z));
    }

    public static void d(int i, TbPageContext tbPageContext, hl5 hl5Var, il5 il5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, hl5Var, il5Var, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, hl5Var, il5Var, userData);
            } else {
                b(tbPageContext, hl5Var);
            }
        }
    }

    public static void e(JSONArray jSONArray, ForumManageModel forumManageModel, ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{jSONArray, forumManageModel, threadData, Boolean.valueOf(z)}) == null) || forumManageModel == null || threadData == null || threadData.getAuthor() == null) {
            return;
        }
        String userId = threadData.getAuthor().getUserId();
        String id = threadData.getId();
        String forum_name = threadData.getForum_name();
        String valueOf = String.valueOf(threadData.getFid());
        boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
        if (jSONArray != null) {
            forumManageModel.U(StringHelper.JsonArrayToString(jSONArray));
        }
        forumManageModel.V(valueOf, forum_name, id, null, 0, 1, isCurrentAccount, threadData.getBaijiahaoData(), z);
    }
}
