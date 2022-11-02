package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.gp5;
import com.baidu.tieba.jp5;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class ep5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements jp5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ hp5 b;
        public final /* synthetic */ boolean c;

        public a(TbPageContext tbPageContext, hp5 hp5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, hp5Var, Boolean.valueOf(z)};
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
            this.b = hp5Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.jp5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    ep5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    xi.O(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c7f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements gp5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ hp5 b;
        public final /* synthetic */ boolean c;

        public b(TbPageContext tbPageContext, hp5 hp5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, hp5Var, Boolean.valueOf(z)};
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
            this.b = hp5Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.gp5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    ep5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    xi.O(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c7f);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, hp5 hp5Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, hp5Var) == null) && tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (hp5Var.getType() == 3) {
                z = true;
            } else {
                z = false;
            }
            gp5 gp5Var = new gp5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
            if (hp5Var != null) {
                gp5Var.z(z);
            }
            AntiData c = li6.f().c();
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
            List<ThreadData> g = li6.f().g();
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
            ot4 ot4Var = new ot4();
            ot4Var.j(sparseArray);
            if (hp5Var != null) {
                ot4Var.i(hp5Var.getType());
            }
            ot4Var.p(jSONArray);
            ot4Var.m(jSONArray2);
            ot4Var.l(li6.f().d());
            gp5Var.A(ot4Var);
            gp5Var.B(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ce), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04cf), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04d0), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04d1), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04d2)});
            gp5Var.D("1");
            gp5Var.C(new b(tbPageContext, hp5Var, z));
        }
    }

    public static void c(TbPageContext tbPageContext, hp5 hp5Var, ip5 ip5Var, UserData userData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, hp5Var, ip5Var, userData) == null) && tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (hp5Var.getType() == 3) {
                z = true;
            } else {
                z = false;
            }
            jp5 jp5Var = new jp5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), ip5Var, userData);
            if (hp5Var != null) {
                jp5Var.F(z);
            }
            AntiData c = li6.f().c();
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
            List<ThreadData> g = li6.f().g();
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
            ot4 ot4Var = new ot4();
            ot4Var.j(sparseArray);
            if (hp5Var != null) {
                ot4Var.i(hp5Var.getType());
            }
            ot4Var.p(jSONArray);
            ot4Var.m(jSONArray2);
            ot4Var.l(li6.f().d());
            jp5Var.G(ot4Var);
            jp5Var.H(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c9), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ca), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04cb), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04cc), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04cd)});
            jp5Var.J("1");
            jp5Var.I(new a(tbPageContext, hp5Var, z));
        }
    }

    public static void d(int i, TbPageContext tbPageContext, hp5 hp5Var, ip5 ip5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, hp5Var, ip5Var, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, hp5Var, ip5Var, userData);
            } else {
                b(tbPageContext, hp5Var);
            }
        }
    }

    public static void e(JSONArray jSONArray, ForumManageModel forumManageModel, ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{jSONArray, forumManageModel, threadData, Boolean.valueOf(z)}) == null) && forumManageModel != null && threadData != null && threadData.getAuthor() != null) {
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
}
