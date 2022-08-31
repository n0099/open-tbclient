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
import com.baidu.tieba.el5;
import com.baidu.tieba.hl5;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class cl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements hl5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ fl5 b;
        public final /* synthetic */ boolean c;

        public a(TbPageContext tbPageContext, fl5 fl5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, fl5Var, Boolean.valueOf(z)};
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
            this.b = fl5Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.hl5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (pi.A()) {
                    cl5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    ri.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c40);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements el5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ fl5 b;
        public final /* synthetic */ boolean c;

        public b(TbPageContext tbPageContext, fl5 fl5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, fl5Var, Boolean.valueOf(z)};
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
            this.b = fl5Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.el5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (pi.A()) {
                    cl5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    ri.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c40);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, fl5 fl5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, fl5Var) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = fl5Var.getType() == 3;
        el5 el5Var = new el5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
        if (fl5Var != null) {
            el5Var.w(z);
        }
        AntiData c = re6.f().c();
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
        List<ThreadData> g = re6.f().g();
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
        dq4 dq4Var = new dq4();
        dq4Var.j(sparseArray);
        if (fl5Var != null) {
            dq4Var.i(fl5Var.getType());
        }
        dq4Var.p(jSONArray);
        dq4Var.m(jSONArray2);
        dq4Var.l(re6.f().d());
        el5Var.x(dq4Var);
        el5Var.y(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c0), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c1), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c2), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c3), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c4)});
        el5Var.A("1");
        el5Var.z(new b(tbPageContext, fl5Var, z));
    }

    public static void c(TbPageContext tbPageContext, fl5 fl5Var, gl5 gl5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, fl5Var, gl5Var, userData) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = fl5Var.getType() == 3;
        hl5 hl5Var = new hl5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), gl5Var, userData);
        if (fl5Var != null) {
            hl5Var.C(z);
        }
        AntiData c = re6.f().c();
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
        List<ThreadData> g = re6.f().g();
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
        dq4 dq4Var = new dq4();
        dq4Var.j(sparseArray);
        if (fl5Var != null) {
            dq4Var.i(fl5Var.getType());
        }
        dq4Var.p(jSONArray);
        dq4Var.m(jSONArray2);
        dq4Var.l(re6.f().d());
        hl5Var.D(dq4Var);
        hl5Var.E(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bb), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bc), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bd), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04be), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04bf)});
        hl5Var.G("1");
        hl5Var.F(new a(tbPageContext, fl5Var, z));
    }

    public static void d(int i, TbPageContext tbPageContext, fl5 fl5Var, gl5 gl5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, fl5Var, gl5Var, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, fl5Var, gl5Var, userData);
            } else {
                b(tbPageContext, fl5Var);
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
