package com.baidu.tieba;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.hz4;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.AigcFeedbackInfo;
/* loaded from: classes5.dex */
public class fm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i)) == null) {
            if (i != -4) {
                if (i != -3) {
                    if (i != -2) {
                        if (i != -1) {
                            switch (i) {
                                case 4:
                                    return 5;
                                case 5:
                                    return 7;
                                case 6:
                                    return 6;
                                case 7:
                                    return 9;
                                case 8:
                                    return 8;
                                default:
                                    return 0;
                            }
                        }
                        return 1;
                    }
                    return 2;
                }
                return 3;
            }
            return 4;
        }
        return invokeI.intValue;
    }

    public static boolean a(List<nz4> list, rz4 rz4Var, pea peaVar, pf9 pf9Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, rz4Var, peaVar, pf9Var, Boolean.valueOf(z)})) == null) {
            if (list == null || peaVar == null || pf9Var == null || !z || !pf9Var.o() || !TbadkCoreApplication.isLogin() || l(peaVar) || pf9Var.n()) {
                return false;
            }
            nz4 nz4Var = new nz4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0369), rz4Var);
            list.add(nz4Var);
            hna.f(nz4Var.d, peaVar);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<nz4> list, rz4 rz4Var, pea peaVar, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, rz4Var, peaVar, pbModel)) == null) {
            if (list != null && peaVar != null && pbModel != null && pbModel.s1() != null) {
                ye9 s1 = pbModel.s1();
                if (s1.k0() && TbadkCoreApplication.isLogin() && !l(peaVar) && !s1.j0()) {
                    nz4 nz4Var = new nz4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0369), rz4Var);
                    list.add(nz4Var);
                    hna.f(nz4Var.d, peaVar);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<nz4> c(List<nz4> list, AgreeData agreeData, SparseArray<?> sparseArray, rz4 rz4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, rz4Var)) == null) {
            return d(list, agreeData, sparseArray, rz4Var, null);
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<nz4> d(List<nz4> list, AgreeData agreeData, SparseArray<?> sparseArray, rz4 rz4Var, AigcFeedbackInfo aigcFeedbackInfo) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65539, null, list, agreeData, sparseArray, rz4Var, aigcFeedbackInfo)) == null) {
            String t = ck9.t(R.string.c_agree, new Object[0]);
            String t2 = ck9.t(R.string.c_disagree, new Object[0]);
            String t3 = ck9.t(R.string.c_agreeed, new Object[0]);
            String t4 = ck9.t(R.string.c_disagreeed, new Object[0]);
            if (aigcFeedbackInfo != null) {
                String str = aigcFeedbackInfo.positive_text;
                String str2 = aigcFeedbackInfo.negative_text;
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    t2 = str2;
                    t4 = t2;
                    t = str;
                    t3 = t;
                }
            }
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    nz4 nz4Var = new nz4(-1, t3, rz4Var);
                    nz4Var.n(true);
                    nz4Var.d.setTag(sparseArray);
                    arrayList.add(nz4Var);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        nz4 nz4Var2 = new nz4(-2, t2, rz4Var);
                        nz4Var2.n(false);
                        nz4Var2.d.setTag(sparseArray);
                        arrayList.add(nz4Var2);
                    }
                } else {
                    nz4 nz4Var3 = new nz4(-1, t, rz4Var);
                    nz4Var3.n(false);
                    nz4Var3.d.setTag(sparseArray);
                    arrayList.add(nz4Var3);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        nz4 nz4Var4 = new nz4(-2, t4, rz4Var);
                        nz4Var4.n(true);
                        nz4Var4.d.setTag(sparseArray);
                        arrayList.add(nz4Var4);
                    }
                }
            } else {
                nz4 nz4Var5 = new nz4(-1, t, rz4Var);
                nz4Var5.n(false);
                nz4Var5.d.setTag(sparseArray);
                arrayList.add(nz4Var5);
                if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    nz4 nz4Var6 = new nz4(-2, t2, rz4Var);
                    nz4Var6.n(false);
                    nz4Var6.d.setTag(sparseArray);
                    arrayList.add(nz4Var6);
                }
            }
            nz4 nz4Var7 = new nz4(-3, ck9.t(R.string.obfuscated_res_0x7f0f1258, new Object[0]), rz4Var);
            nz4Var7.d.setTag(sparseArray);
            arrayList.add(nz4Var7);
            nz4 nz4Var8 = new nz4(-4, ck9.t(R.string.obfuscated_res_0x7f0f13b2, new Object[0]), rz4Var);
            nz4Var8.d.setTag(sparseArray);
            arrayList.add(nz4Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable BdPageContext<?> bdPageContext, hz4.e eVar, hz4.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, bdPageContext, eVar, eVar2) == null) {
            hz4 hz4Var = new hz4(activity);
            hz4Var.setMessageId(R.string.del_post_confirm);
            hz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f05a1, eVar);
            hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0596, eVar2);
            hz4Var.setCancelable(true);
            hz4Var.create(bdPageContext);
            hz4Var.show();
        }
    }

    public static List<nz4> f(List<nz4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (nz4 nz4Var : list) {
                nz4Var.l(i(nz4Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean j(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pbModel)) == null) {
            if (pbModel != null && pbModel.s1() != null && pbModel.s1().k0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(pf9 pf9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, pf9Var)) == null) {
            if (pf9Var != null && pf9Var.o()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean g(SparseArray<?> sparseArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, sparseArray, i)) == null) {
            if (sparseArray != null && (sparseArray.get(i) instanceof Boolean)) {
                return ((Boolean) sparseArray.get(i)).booleanValue();
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static SpannableString o(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, str, i)) == null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeLI.objValue;
    }

    public static SpannableStringBuilder h(pea peaVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, peaVar)) == null) {
            if (peaVar == null) {
                return null;
            }
            if (peaVar.f0() != null) {
                str = peaVar.f0().toString();
            } else {
                str = "";
            }
            SpannableString o = o(peaVar.t().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString o2 = o(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) o);
            spannableStringBuilder.append((CharSequence) o2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable i(nz4 nz4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, nz4Var)) == null) {
            switch (nz4Var.e()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (!nz4Var.j()) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (!nz4Var.j()) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_like30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_liked30, SkinManager.getColor(R.color.CAM_X0301), null);
                case 0:
                default:
                    return null;
                case 1:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_expression30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 2:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_save30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_copy30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 4:
                    if (ck9.t(R.string.obfuscated_res_0x7f0f0c69, new Object[0]).equals(nz4Var.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (ck9.t(R.string.report_text, new Object[0]).equals(nz4Var.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!ck9.t(R.string.obfuscated_res_0x7f0f0d2b, new Object[0]).equals(nz4Var.f())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (ck9.t(R.string.report_text, new Object[0]).equals(nz4Var.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!ck9.t(R.string.obfuscated_res_0x7f0f0551, new Object[0]).equals(nz4Var.f())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 7:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_administration30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 8:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_hide30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 9:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 10:
                    if (ck9.t(R.string.obfuscated_res_0x7f0f0560, new Object[0]).equals(nz4Var.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!ck9.t(R.string.obfuscated_res_0x7f0f0551, new Object[0]).equals(nz4Var.f())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (ck9.t(R.string.obfuscated_res_0x7f0f0d27, new Object[0]).equals(nz4Var.f())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!ck9.t(R.string.un_mute, new Object[0]).equals(nz4Var.f())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_batch_delete, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean l(pea peaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, peaVar)) == null) {
            if (peaVar != null && peaVar.t() != null && !StringUtils.isNull(peaVar.t().getUserId()) && peaVar.t().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<nz4> m(List<nz4> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<nz4> it = list.iterator();
                while (it.hasNext()) {
                    nz4 next = it.next();
                    if (next.e() == 2 || next.e() == 1 || next.e() == 3) {
                        it.remove();
                    }
                }
            }
            return list;
        }
        return (List) invokeLZ.objValue;
    }
}
