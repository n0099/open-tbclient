package com.baidu.tieba;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.p55;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class fl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
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

    public static boolean a(List<w55> list, a65 a65Var, yca ycaVar, qf9 qf9Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, a65Var, ycaVar, qf9Var, Boolean.valueOf(z)})) == null) {
            if (list == null || ycaVar == null || qf9Var == null || !z || !qf9Var.o() || !TbadkCoreApplication.isLogin() || k(ycaVar) || qf9Var.n()) {
                return false;
            }
            w55 w55Var = new w55(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0365), a65Var);
            list.add(w55Var);
            vka.f(w55Var.d, ycaVar);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<w55> list, a65 a65Var, yca ycaVar, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, a65Var, ycaVar, pbModel)) == null) {
            if (list != null && ycaVar != null && pbModel != null && pbModel.z1() != null) {
                ze9 z1 = pbModel.z1();
                if (z1.j0() && TbadkCoreApplication.isLogin() && !k(ycaVar) && !z1.i0()) {
                    w55 w55Var = new w55(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0365), a65Var);
                    list.add(w55Var);
                    vka.f(w55Var.d, ycaVar);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<w55> c(List<w55> list, AgreeData agreeData, SparseArray<?> sparseArray, a65 a65Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, a65Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    w55 w55Var = new w55(-1, hj9.t(R.string.c_agreeed, new Object[0]), a65Var);
                    w55Var.d.setTag(sparseArray);
                    arrayList.add(w55Var);
                    if (!f(sparseArray, R.id.pb_dialog_item_isugc)) {
                        w55 w55Var2 = new w55(-2, hj9.t(R.string.c_disagree, new Object[0]), a65Var);
                        w55Var2.d.setTag(sparseArray);
                        arrayList.add(w55Var2);
                    }
                } else {
                    w55 w55Var3 = new w55(-1, hj9.t(R.string.c_agree, new Object[0]), a65Var);
                    w55Var3.d.setTag(sparseArray);
                    arrayList.add(w55Var3);
                    if (!f(sparseArray, R.id.pb_dialog_item_isugc)) {
                        w55 w55Var4 = new w55(-2, hj9.t(R.string.c_disagreeed, new Object[0]), a65Var);
                        w55Var4.d.setTag(sparseArray);
                        arrayList.add(w55Var4);
                    }
                }
            } else {
                w55 w55Var5 = new w55(-1, hj9.t(R.string.c_agree, new Object[0]), a65Var);
                w55Var5.d.setTag(sparseArray);
                arrayList.add(w55Var5);
                if (!f(sparseArray, R.id.pb_dialog_item_isugc)) {
                    w55 w55Var6 = new w55(-2, hj9.t(R.string.c_disagree, new Object[0]), a65Var);
                    w55Var6.d.setTag(sparseArray);
                    arrayList.add(w55Var6);
                }
            }
            w55 w55Var7 = new w55(-3, hj9.t(R.string.obfuscated_res_0x7f0f1220, new Object[0]), a65Var);
            w55Var7.d.setTag(sparseArray);
            arrayList.add(w55Var7);
            w55 w55Var8 = new w55(-4, hj9.t(R.string.obfuscated_res_0x7f0f1376, new Object[0]), a65Var);
            w55Var8.d.setTag(sparseArray);
            arrayList.add(w55Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void d(Activity activity, @Nullable l9<?> l9Var, p55.e eVar, p55.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, activity, l9Var, eVar, eVar2) == null) {
            p55 p55Var = new p55(activity);
            p55Var.setMessageId(R.string.del_post_confirm);
            p55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0596, eVar);
            p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f058b, eVar2);
            p55Var.setCancelable(true);
            p55Var.create(l9Var);
            p55Var.show();
        }
    }

    public static List<w55> e(List<w55> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (w55 w55Var : list) {
                w55Var.l(h(w55Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean i(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, pbModel)) == null) {
            if (pbModel != null && pbModel.z1() != null && pbModel.z1().j0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(qf9 qf9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, qf9Var)) == null) {
            if (qf9Var != null && qf9Var.o()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(SparseArray<?> sparseArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, sparseArray, i)) == null) {
            if (sparseArray != null && (sparseArray.get(i) instanceof Boolean)) {
                return ((Boolean) sparseArray.get(i)).booleanValue();
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static SpannableString n(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, str, i)) == null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeLI.objValue;
    }

    public static SpannableStringBuilder g(yca ycaVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, ycaVar)) == null) {
            if (ycaVar == null) {
                return null;
            }
            if (ycaVar.e0() != null) {
                str = ycaVar.e0().toString();
            } else {
                str = "";
            }
            SpannableString n = n(ycaVar.q().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString n2 = n(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) n);
            spannableStringBuilder.append((CharSequence) n2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable h(w55 w55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, w55Var)) == null) {
            switch (w55Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (hj9.t(R.string.c_disagree, new Object[0]).equals(w55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (hj9.t(R.string.c_agree, new Object[0]).equals(w55Var.g())) {
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
                    if (hj9.t(R.string.obfuscated_res_0x7f0f0c3b, new Object[0]).equals(w55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (hj9.t(R.string.report_text, new Object[0]).equals(w55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!hj9.t(R.string.obfuscated_res_0x7f0f0cfb, new Object[0]).equals(w55Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (hj9.t(R.string.report_text, new Object[0]).equals(w55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!hj9.t(R.string.obfuscated_res_0x7f0f0546, new Object[0]).equals(w55Var.g())) {
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
                    if (hj9.t(R.string.obfuscated_res_0x7f0f0555, new Object[0]).equals(w55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!hj9.t(R.string.obfuscated_res_0x7f0f0546, new Object[0]).equals(w55Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (hj9.t(R.string.obfuscated_res_0x7f0f0cf7, new Object[0]).equals(w55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!hj9.t(R.string.un_mute, new Object[0]).equals(w55Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_batch_delete, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean k(yca ycaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, ycaVar)) == null) {
            if (ycaVar != null && ycaVar.q() != null && !StringUtils.isNull(ycaVar.q().getUserId()) && ycaVar.q().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<w55> l(List<w55> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<w55> it = list.iterator();
                while (it.hasNext()) {
                    w55 next = it.next();
                    if (next.f() == 2 || next.f() == 1 || next.f() == 3) {
                        it.remove();
                    }
                }
            }
            return list;
        }
        return (List) invokeLZ.objValue;
    }
}
