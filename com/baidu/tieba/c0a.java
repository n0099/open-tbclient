package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tieba.f05;
import com.baidu.tieba.l16;
import com.baidu.tieba.o16;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public final class c0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final PbModel b;
    public a c;
    public final int d;
    public f05 e;
    public l16 f;
    public o16 g;

    /* loaded from: classes5.dex */
    public interface a {
        void a(f05 f05Var, JSONArray jSONArray);

        void b(f05 f05Var);

        void c(SparseArray<Object> sparseArray, JSONArray jSONArray);
    }

    public c0a(TbPageContext<?> pageContext, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, pbModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(pbModel, "pbModel");
        this.a = pageContext;
        this.b = pbModel;
        this.d = 1;
    }

    public static final void c(c0a this$0, f05 f05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, f05Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            a aVar = this$0.c;
            if (aVar != null) {
                aVar.b(f05Var);
            }
        }
    }

    public static final void j(AlertDialog alertDialog, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, alertDialog, view2) == null) && alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public static final void n(AlertDialog alertDialog, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, alertDialog, view2) == null) && alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public static final void d(f05 f05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, f05Var) == null) {
            Intrinsics.checkNotNull(f05Var);
            f05Var.dismiss();
        }
    }

    public final void f(a listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.c = listener;
        }
    }

    public static final void i(AlertDialog alertDialog, c0a this$0, SparseArray sparseArray, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, alertDialog, this$0, sparseArray, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                BdUtilHelper.showToast(this$0.a.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f0e70);
                return;
            }
            a aVar = this$0.c;
            if (aVar != null) {
                aVar.c(sparseArray, null);
            }
        }
    }

    public static final void m(AlertDialog alertDialog, c0a this$0, SparseArray delTags, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, alertDialog, this$0, delTags, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(delTags, "$delTags");
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                BdUtilHelper.showToast(this$0.a.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f0e70);
                return;
            }
            a aVar = this$0.c;
            if (aVar != null) {
                aVar.c(delTags, null);
            }
        }
    }

    public static final void p(c0a this$0, SparseArray sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, this$0, sparseArray, jSONArray) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            a aVar = this$0.c;
            if (aVar != null) {
                aVar.c(sparseArray, jSONArray);
            }
        }
    }

    public static final void r(c0a this$0, f05 f05Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, this$0, f05Var, jSONArray) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            a aVar = this$0.c;
            if (aVar != null) {
                aVar.a(f05Var, jSONArray);
            }
        }
    }

    public final void a() {
        f05 f05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (f05Var = this.e) != null) {
            f05Var.dismiss();
        }
    }

    public final void b(View view2, int i, String str, int i2, boolean z, String str2, boolean z2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, Integer.valueOf(i), str, Integer.valueOf(i2), Boolean.valueOf(z), str2, Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
            sparseArray.put(o1a.i2, Integer.valueOf(o1a.j2));
            if (i2 == 1002 && !z) {
                i3 = R.string.report_post_confirm;
            } else {
                i3 = R.string.del_all_post_confirm;
            }
            int i4 = R.string.confirm_title;
            if (i == 0) {
                if (i2 == 1002 && !z) {
                    i3 = R.string.report_thread_confirm;
                } else {
                    i4 = R.string.del_my_thread_confirm;
                    i3 = R.string.del_my_thread_confirm_subtitle;
                }
            }
            this.e = new f05(this.a.getPageActivity());
            if (StringUtils.isNull(str2)) {
                f05 f05Var = this.e;
                Intrinsics.checkNotNull(f05Var);
                f05Var.setMessageId(i3);
            } else {
                f05 f05Var2 = this.e;
                Intrinsics.checkNotNull(f05Var2);
                f05Var2.setOnlyMessageShowCenter(false);
                f05 f05Var3 = this.e;
                Intrinsics.checkNotNull(f05Var3);
                f05Var3.setMessage(str2);
            }
            f05 f05Var4 = this.e;
            Intrinsics.checkNotNull(f05Var4);
            f05Var4.setYesButtonTag(sparseArray);
            f05 f05Var5 = this.e;
            Intrinsics.checkNotNull(f05Var5);
            f05Var5.setPositiveButton(R.string.obfuscated_res_0x7f0f05ab, new f05.e() { // from class: com.baidu.tieba.jz9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.f05.e
                public final void onClick(f05 f05Var6) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, f05Var6) == null) {
                        c0a.c(c0a.this, f05Var6);
                    }
                }
            });
            f05 f05Var6 = this.e;
            Intrinsics.checkNotNull(f05Var6);
            f05Var6.setNegativeButton(R.string.obfuscated_res_0x7f0f05a0, new f05.e() { // from class: com.baidu.tieba.iz9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.f05.e
                public final void onClick(f05 f05Var7) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, f05Var7) == null) {
                        c0a.d(f05Var7);
                    }
                }
            });
            f05 f05Var7 = this.e;
            Intrinsics.checkNotNull(f05Var7);
            f05Var7.setCancelable(true);
            f05 f05Var8 = this.e;
            Intrinsics.checkNotNull(f05Var8);
            f05Var8.create(this.a);
            if (z2) {
                l(sparseArray, i4, i3);
            } else if (z) {
                l(sparseArray, i4, i3);
            } else if (g(this.b)) {
                Integer num = this.b.s1().n().getDeletedReasonInfo().is_grays_cale_forum;
                Intrinsics.checkNotNullExpressionValue(num, "pbModel.getPbData().getF…nfo().is_grays_cale_forum");
                int intValue = num.intValue();
                Integer num2 = this.b.s1().n().getDeletedReasonInfo().is_boomgrow;
                Intrinsics.checkNotNullExpressionValue(num2, "pbModel.getPbData().getF…dReasonInfo().is_boomgrow");
                int intValue2 = num2.intValue();
                Integer num3 = this.b.s1().q().has_forum_rule;
                Intrinsics.checkNotNullExpressionValue(num3, "pbModel.getPbData().getForumRule().has_forum_rule");
                n16 n16Var = new n16(intValue, intValue2, num3.intValue());
                n16Var.i(this.b.s1().n().getId(), this.b.s1().n().getName());
                n16Var.h(this.b.s1().n().getImage_url());
                n16Var.j(this.b.s1().n().getUser_level());
                UserData Y = this.b.s1().Y();
                Intrinsics.checkNotNullExpressionValue(Y, "pbModel.getPbData().getUserData()");
                o(view2, sparseArray, i, n16Var, Y, false);
            } else {
                q(view2, this.e, i);
            }
        }
    }

    public final void e(View view2, int i, String postId, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, Integer.valueOf(i), postId, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            Intrinsics.checkNotNullParameter(postId, "postId");
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, postId);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
            sparseArray.put(o1a.i2, Integer.valueOf(o1a.j2));
            if (z) {
                h(sparseArray);
            } else {
                k(view2, i, sparseArray);
            }
        }
    }

    public final boolean g(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, pbModel)) == null) {
            if (pbModel.s1().n().getDeletedReasonInfo() == null) {
                return false;
            }
            int i = this.d;
            Integer num = pbModel.s1().n().getDeletedReasonInfo().is_grays_cale_forum;
            if (num == null || i != num.intValue()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void h(final SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, sparseArray) != null) || this.a.getPageActivity() == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f1429, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03db, TBAlertConfig.OperateBtnStyle.SECONDARY);
        final AlertDialog show = new TBAlertBuilder(this.a.getPageActivity()).setTitle(R.string.musk_my_thread_confirm).setDesc(R.string.musk_my_thread_confirm_subtitle).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new View.OnClickListener() { // from class: com.baidu.tieba.mz9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    c0a.i(AlertDialog.this, this, sparseArray, view2);
                }
            }
        });
        operateBtnConfig2.setListener(new View.OnClickListener() { // from class: com.baidu.tieba.lz9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    c0a.j(AlertDialog.this, view2);
                }
            }
        });
    }

    public final void k(View view2, int i, SparseArray<Object> sparseArray) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048582, this, view2, i, sparseArray) == null) && (pbModel = this.b) != null && pbModel.s1() != null && this.b.s1().q() != null && this.b.s1().n() != null && this.b.s1().n().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
            }
            Integer num = this.b.s1().n().getDeletedReasonInfo().is_grays_cale_forum;
            Intrinsics.checkNotNullExpressionValue(num, "pbModel.getPbData().getF…nfo().is_grays_cale_forum");
            int intValue = num.intValue();
            Integer num2 = this.b.s1().n().getDeletedReasonInfo().is_boomgrow;
            Intrinsics.checkNotNullExpressionValue(num2, "pbModel.getPbData().getF…dReasonInfo().is_boomgrow");
            int intValue2 = num2.intValue();
            Integer num3 = this.b.s1().q().has_forum_rule;
            Intrinsics.checkNotNullExpressionValue(num3, "pbModel.getPbData().getForumRule().has_forum_rule");
            n16 n16Var = new n16(intValue, intValue2, num3.intValue());
            n16Var.i(this.b.s1().n().getId(), this.b.s1().n().getName());
            n16Var.h(this.b.s1().n().getImage_url());
            n16Var.j(this.b.s1().n().getUser_level());
            UserData Y = this.b.s1().Y();
            Intrinsics.checkNotNullExpressionValue(Y, "pbModel.getPbData().getUserData()");
            o(view2, sparseArray, i, n16Var, Y, true);
        }
    }

    public final void q(View view2, final f05 f05Var, int i) {
        AntiData antiData;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048585, this, view2, f05Var, i) != null) || f05Var == null) {
            return;
        }
        if (this.f == null) {
            this.f = new l16(this.a, view2);
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        aw9 s1 = this.b.s1();
        if (s1 != null) {
            antiData = s1.f();
        } else {
            antiData = null;
        }
        if (antiData != null && antiData.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = antiData.getDelThreadInfoList();
            int size = delThreadInfoList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
        negativeFeedBackData.setFeedBackReasonMap(sparseArray);
        String string = this.a.getString(R.string.delete_thread_reason_1);
        Intrinsics.checkNotNullExpressionValue(string, "pageContext.getString(R.…g.delete_thread_reason_1)");
        String string2 = this.a.getString(R.string.delete_thread_reason_2);
        Intrinsics.checkNotNullExpressionValue(string2, "pageContext.getString(R.…g.delete_thread_reason_2)");
        String string3 = this.a.getString(R.string.delete_thread_reason_3);
        Intrinsics.checkNotNullExpressionValue(string3, "pageContext.getString(R.…g.delete_thread_reason_3)");
        String string4 = this.a.getString(R.string.delete_thread_reason_4);
        Intrinsics.checkNotNullExpressionValue(string4, "pageContext.getString(R.…g.delete_thread_reason_4)");
        String string5 = this.a.getString(R.string.delete_thread_reason_5);
        Intrinsics.checkNotNullExpressionValue(string5, "pageContext.getString(R.…g.delete_thread_reason_5)");
        String[] strArr = {string, string2, string3, string4, string5};
        l16 l16Var = this.f;
        Intrinsics.checkNotNull(l16Var);
        l16Var.B(strArr);
        l16 l16Var2 = this.f;
        Intrinsics.checkNotNull(l16Var2);
        l16Var2.A(negativeFeedBackData);
        if (i != 1 && i != 2) {
            str = "3";
        } else {
            str = "4";
        }
        l16 l16Var3 = this.f;
        Intrinsics.checkNotNull(l16Var3);
        l16Var3.D(str);
        l16 l16Var4 = this.f;
        Intrinsics.checkNotNull(l16Var4);
        l16Var4.C(new l16.h() { // from class: com.baidu.tieba.fz9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.l16.h
            public final void a(JSONArray jSONArray) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONArray) == null) {
                    c0a.r(c0a.this, f05Var, jSONArray);
                }
            }
        });
    }

    public final void l(final SparseArray<Object> sparseArray, @StringRes int i, @StringRes int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048583, this, sparseArray, i, i2) != null) || this.a.getPageActivity() == null) {
            return;
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f055b, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03db, TBAlertConfig.OperateBtnStyle.SECONDARY);
        final AlertDialog show = new TBAlertBuilder(this.a.getPageActivity()).setTitle(i).setDesc(i2).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new View.OnClickListener() { // from class: com.baidu.tieba.hz9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    c0a.m(AlertDialog.this, this, sparseArray, view2);
                }
            }
        });
        operateBtnConfig2.setListener(new View.OnClickListener() { // from class: com.baidu.tieba.ez9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    c0a.n(AlertDialog.this, view2);
                }
            }
        });
    }

    public final void o(View view2, final SparseArray<Object> sparseArray, int i, n16 n16Var, UserData userData, boolean z) {
        AntiData antiData;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view2, sparseArray, Integer.valueOf(i), n16Var, userData, Boolean.valueOf(z)}) == null) {
            if (this.g == null) {
                this.g = new o16(this.a, view2, n16Var, userData);
            }
            o16 o16Var = this.g;
            if (o16Var != null) {
                o16Var.G(z);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            aw9 s1 = this.b.s1();
            if (s1 != null) {
                antiData = s1.f();
            } else {
                antiData = null;
            }
            if (antiData != null && antiData.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = antiData.getDelThreadInfoList();
                int size = delThreadInfoList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray2);
            String string = this.a.getString(R.string.delete_thread_reason_1);
            Intrinsics.checkNotNullExpressionValue(string, "pageContext.getString(R.…g.delete_thread_reason_1)");
            String string2 = this.a.getString(R.string.delete_thread_reason_2);
            Intrinsics.checkNotNullExpressionValue(string2, "pageContext.getString(R.…g.delete_thread_reason_2)");
            String string3 = this.a.getString(R.string.delete_thread_reason_3);
            Intrinsics.checkNotNullExpressionValue(string3, "pageContext.getString(R.…g.delete_thread_reason_3)");
            String string4 = this.a.getString(R.string.delete_thread_reason_4);
            Intrinsics.checkNotNullExpressionValue(string4, "pageContext.getString(R.…g.delete_thread_reason_4)");
            String string5 = this.a.getString(R.string.delete_thread_reason_5);
            Intrinsics.checkNotNullExpressionValue(string5, "pageContext.getString(R.…g.delete_thread_reason_5)");
            String[] strArr = {string, string2, string3, string4, string5};
            o16 o16Var2 = this.g;
            if (o16Var2 != null) {
                o16Var2.I(strArr);
            }
            o16 o16Var3 = this.g;
            if (o16Var3 != null) {
                o16Var3.H(negativeFeedBackData);
            }
            if (i != 1 && i != 2) {
                str = "3";
            } else {
                str = "4";
            }
            o16 o16Var4 = this.g;
            if (o16Var4 != null) {
                o16Var4.K(str);
            }
            o16 o16Var5 = this.g;
            if (o16Var5 != null) {
                o16Var5.J(new o16.i() { // from class: com.baidu.tieba.kz9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.o16.i
                    public final void a(JSONArray jSONArray) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONArray) == null) {
                            c0a.p(c0a.this, sparseArray, jSONArray);
                        }
                    }
                });
            }
        }
    }
}
