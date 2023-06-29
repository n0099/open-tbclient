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
import com.baidu.tieba.g55;
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
public class af9 {
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

    public static boolean a(List<n55> list, r55 r55Var, n4a n4aVar, l99 l99Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, r55Var, n4aVar, l99Var, Boolean.valueOf(z)})) == null) {
            if (list == null || n4aVar == null || l99Var == null || !z || !l99Var.o() || !TbadkCoreApplication.isLogin() || k(n4aVar) || l99Var.n()) {
                return false;
            }
            n55 n55Var = new n55(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0365), r55Var);
            list.add(n55Var);
            eca.f(n55Var.d, n4aVar);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<n55> list, r55 r55Var, n4a n4aVar, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, r55Var, n4aVar, pbModel)) == null) {
            if (list != null && n4aVar != null && pbModel != null && pbModel.y1() != null) {
                u89 y1 = pbModel.y1();
                if (y1.j0() && TbadkCoreApplication.isLogin() && !k(n4aVar) && !y1.i0()) {
                    n55 n55Var = new n55(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0365), r55Var);
                    list.add(n55Var);
                    eca.f(n55Var.d, n4aVar);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<n55> c(List<n55> list, AgreeData agreeData, SparseArray<?> sparseArray, r55 r55Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, r55Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    n55 n55Var = new n55(-1, cd9.t(R.string.c_agreeed, new Object[0]), r55Var);
                    n55Var.d.setTag(sparseArray);
                    arrayList.add(n55Var);
                    if (!f(sparseArray, R.id.pb_dialog_item_isugc)) {
                        n55 n55Var2 = new n55(-2, cd9.t(R.string.c_disagree, new Object[0]), r55Var);
                        n55Var2.d.setTag(sparseArray);
                        arrayList.add(n55Var2);
                    }
                } else {
                    n55 n55Var3 = new n55(-1, cd9.t(R.string.c_agree, new Object[0]), r55Var);
                    n55Var3.d.setTag(sparseArray);
                    arrayList.add(n55Var3);
                    if (!f(sparseArray, R.id.pb_dialog_item_isugc)) {
                        n55 n55Var4 = new n55(-2, cd9.t(R.string.c_disagreeed, new Object[0]), r55Var);
                        n55Var4.d.setTag(sparseArray);
                        arrayList.add(n55Var4);
                    }
                }
            } else {
                n55 n55Var5 = new n55(-1, cd9.t(R.string.c_agree, new Object[0]), r55Var);
                n55Var5.d.setTag(sparseArray);
                arrayList.add(n55Var5);
                if (!f(sparseArray, R.id.pb_dialog_item_isugc)) {
                    n55 n55Var6 = new n55(-2, cd9.t(R.string.c_disagree, new Object[0]), r55Var);
                    n55Var6.d.setTag(sparseArray);
                    arrayList.add(n55Var6);
                }
            }
            n55 n55Var7 = new n55(-3, cd9.t(R.string.obfuscated_res_0x7f0f120e, new Object[0]), r55Var);
            n55Var7.d.setTag(sparseArray);
            arrayList.add(n55Var7);
            n55 n55Var8 = new n55(-4, cd9.t(R.string.obfuscated_res_0x7f0f1360, new Object[0]), r55Var);
            n55Var8.d.setTag(sparseArray);
            arrayList.add(n55Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void d(Activity activity, @Nullable l9<?> l9Var, g55.e eVar, g55.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, activity, l9Var, eVar, eVar2) == null) {
            g55 g55Var = new g55(activity);
            g55Var.setMessageId(R.string.del_post_confirm);
            g55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0593, eVar);
            g55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0588, eVar2);
            g55Var.setCancelable(true);
            g55Var.create(l9Var);
            g55Var.show();
        }
    }

    public static List<n55> e(List<n55> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (n55 n55Var : list) {
                n55Var.l(h(n55Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean i(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, pbModel)) == null) {
            if (pbModel != null && pbModel.y1() != null && pbModel.y1().j0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(l99 l99Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, l99Var)) == null) {
            if (l99Var != null && l99Var.o()) {
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

    public static SpannableStringBuilder g(n4a n4aVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, n4aVar)) == null) {
            if (n4aVar == null) {
                return null;
            }
            if (n4aVar.e0() != null) {
                str = n4aVar.e0().toString();
            } else {
                str = "";
            }
            SpannableString n = n(n4aVar.q().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString n2 = n(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) n);
            spannableStringBuilder.append((CharSequence) n2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable h(n55 n55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, n55Var)) == null) {
            switch (n55Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (cd9.t(R.string.c_disagree, new Object[0]).equals(n55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (cd9.t(R.string.c_agree, new Object[0]).equals(n55Var.g())) {
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
                    if (cd9.t(R.string.obfuscated_res_0x7f0f0c30, new Object[0]).equals(n55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (cd9.t(R.string.report_text, new Object[0]).equals(n55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!cd9.t(R.string.obfuscated_res_0x7f0f0cf0, new Object[0]).equals(n55Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (cd9.t(R.string.report_text, new Object[0]).equals(n55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!cd9.t(R.string.obfuscated_res_0x7f0f0543, new Object[0]).equals(n55Var.g())) {
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
                    if (cd9.t(R.string.obfuscated_res_0x7f0f0552, new Object[0]).equals(n55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!cd9.t(R.string.obfuscated_res_0x7f0f0543, new Object[0]).equals(n55Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (cd9.t(R.string.obfuscated_res_0x7f0f0cec, new Object[0]).equals(n55Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!cd9.t(R.string.un_mute, new Object[0]).equals(n55Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_batch_delete, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean k(n4a n4aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, n4aVar)) == null) {
            if (n4aVar != null && n4aVar.q() != null && !StringUtils.isNull(n4aVar.q().getUserId()) && n4aVar.q().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<n55> l(List<n55> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<n55> it = list.iterator();
                while (it.hasNext()) {
                    n55 next = it.next();
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
