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
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.q15;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class gj8 {
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

    public static boolean a(List<x15> list, b25 b25Var, PostData postData, xd8 xd8Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, b25Var, postData, xd8Var, Boolean.valueOf(z)})) == null) {
            if (list == null || postData == null || xd8Var == null || !z || !xd8Var.q() || !TbadkCoreApplication.isLogin() || l(postData) || xd8Var.p()) {
                return false;
            }
            x15 x15Var = new x15(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f032f), b25Var);
            list.add(x15Var);
            ed9.f(x15Var.d, postData);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<x15> list, b25 b25Var, PostData postData, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, b25Var, postData, pbModel)) == null) {
            if (list != null && postData != null && pbModel != null && pbModel.s1() != null) {
                hd8 s1 = pbModel.s1();
                if (s1.m0() && TbadkCoreApplication.isLogin() && !l(postData) && !s1.l0()) {
                    x15 x15Var = new x15(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f032f), b25Var);
                    list.add(x15Var);
                    ed9.f(x15Var.d, postData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<x15> c(List<x15> list, AgreeData agreeData, SparseArray<?> sparseArray, b25 b25Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, b25Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    x15 x15Var = new x15(-1, jh8.u(R.string.c_agreeed, new Object[0]), b25Var);
                    x15Var.d.setTag(sparseArray);
                    arrayList.add(x15Var);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        x15 x15Var2 = new x15(-2, jh8.u(R.string.c_disagree, new Object[0]), b25Var);
                        x15Var2.d.setTag(sparseArray);
                        arrayList.add(x15Var2);
                    }
                } else {
                    x15 x15Var3 = new x15(-1, jh8.u(R.string.c_agree, new Object[0]), b25Var);
                    x15Var3.d.setTag(sparseArray);
                    arrayList.add(x15Var3);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        x15 x15Var4 = new x15(-2, jh8.u(R.string.c_disagreeed, new Object[0]), b25Var);
                        x15Var4.d.setTag(sparseArray);
                        arrayList.add(x15Var4);
                    }
                }
            } else {
                x15 x15Var5 = new x15(-1, jh8.u(R.string.c_agree, new Object[0]), b25Var);
                x15Var5.d.setTag(sparseArray);
                arrayList.add(x15Var5);
                if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    x15 x15Var6 = new x15(-2, jh8.u(R.string.c_disagree, new Object[0]), b25Var);
                    x15Var6.d.setTag(sparseArray);
                    arrayList.add(x15Var6);
                }
            }
            x15 x15Var7 = new x15(-3, jh8.u(R.string.obfuscated_res_0x7f0f10b3, new Object[0]), b25Var);
            x15Var7.d.setTag(sparseArray);
            arrayList.add(x15Var7);
            x15 x15Var8 = new x15(-4, jh8.u(R.string.obfuscated_res_0x7f0f1201, new Object[0]), b25Var);
            x15Var8.d.setTag(sparseArray);
            arrayList.add(x15Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<x15> d(List<x15> list, AgreeData agreeData, SparseArray<?> sparseArray, b25 b25Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, list, agreeData, sparseArray, b25Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        x15 x15Var = new x15(-2, jh8.u(R.string.action_dislike, new Object[0]), b25Var);
                        x15Var.d.setTag(sparseArray);
                        arrayList.add(x15Var);
                    }
                } else if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    x15 x15Var2 = new x15(-2, jh8.u(R.string.c_disagreeed, new Object[0]), b25Var);
                    x15Var2.d.setTag(sparseArray);
                    arrayList.add(x15Var2);
                }
            } else if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                x15 x15Var3 = new x15(-2, jh8.u(R.string.action_dislike, new Object[0]), b25Var);
                x15Var3.d.setTag(sparseArray);
                arrayList.add(x15Var3);
            }
            x15 x15Var4 = new x15(-3, jh8.u(R.string.obfuscated_res_0x7f0f10b3, new Object[0]), b25Var);
            x15Var4.d.setTag(sparseArray);
            arrayList.add(0, x15Var4);
            x15 x15Var5 = new x15(-4, jh8.u(R.string.obfuscated_res_0x7f0f1201, new Object[0]), b25Var);
            x15Var5.d.setTag(sparseArray);
            arrayList.add(1, x15Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable x9<?> x9Var, q15.e eVar, q15.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, x9Var, eVar, eVar2) == null) {
            q15 q15Var = new q15(activity);
            q15Var.setMessageId(R.string.del_post_confirm);
            q15Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0520, eVar);
            q15Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0518, eVar2);
            q15Var.setCancelable(true);
            q15Var.create(x9Var);
            q15Var.show();
        }
    }

    public static List<x15> f(List<x15> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (x15 x15Var : list) {
                x15Var.l(i(x15Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean j(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pbModel)) == null) {
            if (pbModel != null && pbModel.s1() != null && pbModel.s1().m0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(xd8 xd8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, xd8Var)) == null) {
            if (xd8Var != null && xd8Var.q()) {
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

    public static SpannableStringBuilder h(PostData postData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, postData)) == null) {
            if (postData == null) {
                return null;
            }
            if (postData.Z() != null) {
                str = postData.Z().toString();
            } else {
                str = "";
            }
            SpannableString o = o(postData.r().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString o2 = o(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) o);
            spannableStringBuilder.append((CharSequence) o2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable i(x15 x15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, x15Var)) == null) {
            switch (x15Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (jh8.u(R.string.c_disagree, new Object[0]).equals(x15Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (jh8.u(R.string.c_agree, new Object[0]).equals(x15Var.g())) {
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
                    if (jh8.u(R.string.obfuscated_res_0x7f0f0b4f, new Object[0]).equals(x15Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (jh8.u(R.string.report_text, new Object[0]).equals(x15Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!jh8.u(R.string.obfuscated_res_0x7f0f0bf3, new Object[0]).equals(x15Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (jh8.u(R.string.report_text, new Object[0]).equals(x15Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!jh8.u(R.string.obfuscated_res_0x7f0f04d8, new Object[0]).equals(x15Var.g())) {
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
                    if (jh8.u(R.string.obfuscated_res_0x7f0f04e5, new Object[0]).equals(x15Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!jh8.u(R.string.obfuscated_res_0x7f0f04d8, new Object[0]).equals(x15Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (jh8.u(R.string.obfuscated_res_0x7f0f0bef, new Object[0]).equals(x15Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!jh8.u(R.string.un_mute, new Object[0]).equals(x15Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_batch_delete, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean l(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, postData)) == null) {
            if (postData != null && postData.r() != null && !StringUtils.isNull(postData.r().getUserId()) && postData.r().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<x15> m(List<x15> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<x15> it = list.iterator();
                while (it.hasNext()) {
                    x15 next = it.next();
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
