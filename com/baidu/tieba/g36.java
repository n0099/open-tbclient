package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.i36;
import com.baidu.tieba.l36;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class g36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements l36.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ j36 b;
        public final /* synthetic */ boolean c;

        public a(TbPageContext tbPageContext, j36 j36Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, j36Var, Boolean.valueOf(z)};
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
            this.b = j36Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.l36.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    g36.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    BdUtilHelper.showToast(this.a.getContext(), (int) R.string.obfuscated_res_0x7f0f0e21);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements i36.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ j36 b;
        public final /* synthetic */ boolean c;

        public b(TbPageContext tbPageContext, j36 j36Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, j36Var, Boolean.valueOf(z)};
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
            this.b = j36Var;
            this.c = z;
        }

        @Override // com.baidu.tieba.i36.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    g36.e(jSONArray, this.b.a(), this.b.b(), this.c);
                } else {
                    BdUtilHelper.showToast(this.a.getContext(), (int) R.string.obfuscated_res_0x7f0f0e21);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, j36 j36Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, j36Var) == null) && tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (j36Var.getType() == 3) {
                z = true;
            } else {
                z = false;
            }
            i36 i36Var = new i36(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
            if (j36Var != null) {
                i36Var.z(z);
            }
            AntiData c = ye7.f().c();
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
            List<ThreadData> g = ye7.f().g();
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
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray);
            if (j36Var != null) {
                negativeFeedBackData.setDeleteType(j36Var.getType());
            }
            negativeFeedBackData.setTidArray(jSONArray);
            negativeFeedBackData.setMaskTidArray(jSONArray2);
            negativeFeedBackData.setFid(ye7.f().d());
            i36Var.A(negativeFeedBackData);
            i36Var.B(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_5)});
            i36Var.D("1");
            i36Var.C(new b(tbPageContext, j36Var, z));
        }
    }

    public static void c(TbPageContext tbPageContext, j36 j36Var, k36 k36Var, UserData userData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, j36Var, k36Var, userData) == null) && tbPageContext != null && tbPageContext.getPageActivity() != null && tbPageContext.getPageActivity().getWindow() != null) {
            if (j36Var.getType() == 3) {
                z = true;
            } else {
                z = false;
            }
            l36 l36Var = new l36(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), k36Var, userData);
            if (j36Var != null) {
                l36Var.F(z);
            }
            AntiData c = ye7.f().c();
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
            List<ThreadData> g = ye7.f().g();
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
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray);
            if (j36Var != null) {
                negativeFeedBackData.setDeleteType(j36Var.getType());
            }
            negativeFeedBackData.setTidArray(jSONArray);
            negativeFeedBackData.setMaskTidArray(jSONArray2);
            negativeFeedBackData.setFid(ye7.f().d());
            l36Var.G(negativeFeedBackData);
            l36Var.H(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_5)});
            l36Var.J("1");
            l36Var.I(new a(tbPageContext, j36Var, z));
        }
    }

    public static void d(int i, TbPageContext tbPageContext, j36 j36Var, k36 k36Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, j36Var, k36Var, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, j36Var, k36Var, userData);
            } else {
                b(tbPageContext, j36Var);
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
                forumManageModel.i0(StringHelper.JsonArrayToString(jSONArray));
            }
            forumManageModel.j0(valueOf, forum_name, id, null, 0, 1, isCurrentAccount, threadData.getBaijiahaoData(), z);
        }
    }
}
