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
import com.baidu.tieba.ho5;
import com.baidu.tieba.ko5;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class fo5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public final class a implements ko5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ io5 b;
        public final /* synthetic */ boolean c;

        public a(TbPageContext tbPageContext, io5 io5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, io5Var, Boolean.valueOf(z)};
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
            this.b = io5Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.ko5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    fo5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    fj.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c68);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class b implements ho5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ io5 b;
        public final /* synthetic */ boolean c;

        public b(TbPageContext tbPageContext, io5 io5Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, io5Var, Boolean.valueOf(z)};
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
            this.b = io5Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.ho5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    fo5.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    fj.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c68);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, io5 io5Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, io5Var) == null) && tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (io5Var.getType() == 3) {
                z = true;
            } else {
                z = false;
            }
            ho5 ho5Var = new ho5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
            if (io5Var != null) {
                ho5Var.z(z);
            }
            AntiData c = bh6.f().c();
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
            List g = bh6.f().g();
            for (int i2 = 0; i2 < g.size(); i2++) {
                if (g.get(i2) != null) {
                    jSONArray.put(((ThreadData) g.get(i2)).getTid());
                    if (z) {
                        jSONArray2.put("1");
                    } else if (!((ThreadData) g.get(i2)).isScoreThread() && !((ThreadData) g.get(i2)).isWorksInfo()) {
                        jSONArray2.put("0");
                    } else {
                        jSONArray2.put("1");
                    }
                }
            }
            xs4 xs4Var = new xs4();
            xs4Var.j(sparseArray);
            if (io5Var != null) {
                xs4Var.i(io5Var.getType());
            }
            xs4Var.p(jSONArray);
            xs4Var.m(jSONArray2);
            xs4Var.l(bh6.f().d());
            ho5Var.A(xs4Var);
            ho5Var.B(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04cc), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04cd), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ce), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04cf), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04d0)});
            ho5Var.D("1");
            ho5Var.C(new b(tbPageContext, io5Var, z));
        }
    }

    public static void c(TbPageContext tbPageContext, io5 io5Var, jo5 jo5Var, UserData userData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, io5Var, jo5Var, userData) == null) && tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (io5Var.getType() == 3) {
                z = true;
            } else {
                z = false;
            }
            ko5 ko5Var = new ko5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), jo5Var, userData);
            if (io5Var != null) {
                ko5Var.F(z);
            }
            AntiData c = bh6.f().c();
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
            List g = bh6.f().g();
            for (int i2 = 0; i2 < g.size(); i2++) {
                if (g.get(i2) != null) {
                    jSONArray.put(((ThreadData) g.get(i2)).getTid());
                    if (z) {
                        jSONArray2.put("1");
                    } else if (!((ThreadData) g.get(i2)).isScoreThread() && !((ThreadData) g.get(i2)).isWorksInfo()) {
                        jSONArray2.put("0");
                    } else {
                        jSONArray2.put("1");
                    }
                }
            }
            xs4 xs4Var = new xs4();
            xs4Var.j(sparseArray);
            if (io5Var != null) {
                xs4Var.i(io5Var.getType());
            }
            xs4Var.p(jSONArray);
            xs4Var.m(jSONArray2);
            xs4Var.l(bh6.f().d());
            ko5Var.G(xs4Var);
            ko5Var.H(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c7), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c8), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c9), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ca), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04cb)});
            ko5Var.J("1");
            ko5Var.I(new a(tbPageContext, io5Var, z));
        }
    }

    public static void d(int i, TbPageContext tbPageContext, io5 io5Var, jo5 jo5Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, io5Var, jo5Var, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, io5Var, jo5Var, userData);
            } else {
                b(tbPageContext, io5Var);
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
