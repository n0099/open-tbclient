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
import com.baidu.tieba.lv4;
import com.baidu.tieba.pb.pb.main.PbModel;
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
public class g68 {
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

    public static boolean a(List<sv4> list, wv4 wv4Var, PostData postData, y08 y08Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, wv4Var, postData, y08Var, Boolean.valueOf(z)})) == null) {
            if (list == null || postData == null || y08Var == null || !z || !y08Var.q() || !TbadkCoreApplication.isLogin() || l(postData) || y08Var.p()) {
                return false;
            }
            sv4 sv4Var = new sv4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f032a), wv4Var);
            list.add(sv4Var);
            pz8.f(sv4Var.d, postData);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<sv4> list, wv4 wv4Var, PostData postData, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, wv4Var, postData, pbModel)) == null) {
            if (list != null && postData != null && pbModel != null && pbModel.l1() != null) {
                i08 l1 = pbModel.l1();
                if (l1.m0() && TbadkCoreApplication.isLogin() && !l(postData) && !l1.l0()) {
                    sv4 sv4Var = new sv4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f032a), wv4Var);
                    list.add(sv4Var);
                    pz8.f(sv4Var.d, postData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<sv4> c(List<sv4> list, AgreeData agreeData, SparseArray<?> sparseArray, wv4 wv4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, wv4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    sv4 sv4Var = new sv4(-1, k48.u(R.string.c_agreeed, new Object[0]), wv4Var);
                    sv4Var.d.setTag(sparseArray);
                    arrayList.add(sv4Var);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        sv4 sv4Var2 = new sv4(-2, k48.u(R.string.c_disagree, new Object[0]), wv4Var);
                        sv4Var2.d.setTag(sparseArray);
                        arrayList.add(sv4Var2);
                    }
                } else {
                    sv4 sv4Var3 = new sv4(-1, k48.u(R.string.c_agree, new Object[0]), wv4Var);
                    sv4Var3.d.setTag(sparseArray);
                    arrayList.add(sv4Var3);
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        sv4 sv4Var4 = new sv4(-2, k48.u(R.string.c_disagreeed, new Object[0]), wv4Var);
                        sv4Var4.d.setTag(sparseArray);
                        arrayList.add(sv4Var4);
                    }
                }
            } else {
                sv4 sv4Var5 = new sv4(-1, k48.u(R.string.c_agree, new Object[0]), wv4Var);
                sv4Var5.d.setTag(sparseArray);
                arrayList.add(sv4Var5);
                if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    sv4 sv4Var6 = new sv4(-2, k48.u(R.string.c_disagree, new Object[0]), wv4Var);
                    sv4Var6.d.setTag(sparseArray);
                    arrayList.add(sv4Var6);
                }
            }
            sv4 sv4Var7 = new sv4(-3, k48.u(R.string.obfuscated_res_0x7f0f1068, new Object[0]), wv4Var);
            sv4Var7.d.setTag(sparseArray);
            arrayList.add(sv4Var7);
            sv4 sv4Var8 = new sv4(-4, k48.u(R.string.obfuscated_res_0x7f0f11b7, new Object[0]), wv4Var);
            sv4Var8.d.setTag(sparseArray);
            arrayList.add(sv4Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<sv4> d(List<sv4> list, AgreeData agreeData, SparseArray<?> sparseArray, wv4 wv4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, list, agreeData, sparseArray, wv4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                        sv4 sv4Var = new sv4(-2, k48.u(R.string.action_dislike, new Object[0]), wv4Var);
                        sv4Var.d.setTag(sparseArray);
                        arrayList.add(sv4Var);
                    }
                } else if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                    sv4 sv4Var2 = new sv4(-2, k48.u(R.string.c_disagreeed, new Object[0]), wv4Var);
                    sv4Var2.d.setTag(sparseArray);
                    arrayList.add(sv4Var2);
                }
            } else if (!g(sparseArray, R.id.pb_dialog_item_isugc)) {
                sv4 sv4Var3 = new sv4(-2, k48.u(R.string.action_dislike, new Object[0]), wv4Var);
                sv4Var3.d.setTag(sparseArray);
                arrayList.add(sv4Var3);
            }
            sv4 sv4Var4 = new sv4(-3, k48.u(R.string.obfuscated_res_0x7f0f1068, new Object[0]), wv4Var);
            sv4Var4.d.setTag(sparseArray);
            arrayList.add(0, sv4Var4);
            sv4 sv4Var5 = new sv4(-4, k48.u(R.string.obfuscated_res_0x7f0f11b7, new Object[0]), wv4Var);
            sv4Var5.d.setTag(sparseArray);
            arrayList.add(1, sv4Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable r9<?> r9Var, lv4.e eVar, lv4.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, r9Var, eVar, eVar2) == null) {
            lv4 lv4Var = new lv4(activity);
            lv4Var.setMessageId(R.string.del_post_confirm);
            lv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0509, eVar);
            lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0501, eVar2);
            lv4Var.setCancelable(true);
            lv4Var.create(r9Var);
            lv4Var.show();
        }
    }

    public static List<sv4> f(List<sv4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (sv4 sv4Var : list) {
                sv4Var.l(i(sv4Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean j(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pbModel)) == null) {
            if (pbModel != null && pbModel.l1() != null && pbModel.l1().m0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(y08 y08Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, y08Var)) == null) {
            if (y08Var != null && y08Var.q()) {
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
            if (postData.X() != null) {
                str = postData.X().toString();
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

    public static Drawable i(sv4 sv4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, sv4Var)) == null) {
            switch (sv4Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (k48.u(R.string.c_disagree, new Object[0]).equals(sv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (k48.u(R.string.c_agree, new Object[0]).equals(sv4Var.g())) {
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
                    if (k48.u(R.string.obfuscated_res_0x7f0f0afc, new Object[0]).equals(sv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (k48.u(R.string.report_text, new Object[0]).equals(sv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!k48.u(R.string.obfuscated_res_0x7f0f0ba1, new Object[0]).equals(sv4Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (k48.u(R.string.report_text, new Object[0]).equals(sv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!k48.u(R.string.obfuscated_res_0x7f0f04c1, new Object[0]).equals(sv4Var.g())) {
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
                    if (k48.u(R.string.obfuscated_res_0x7f0f04ce, new Object[0]).equals(sv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!k48.u(R.string.obfuscated_res_0x7f0f04c1, new Object[0]).equals(sv4Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (k48.u(R.string.obfuscated_res_0x7f0f0b9d, new Object[0]).equals(sv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!k48.u(R.string.un_mute, new Object[0]).equals(sv4Var.g())) {
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

    public static List<sv4> m(List<sv4> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<sv4> it = list.iterator();
                while (it.hasNext()) {
                    sv4 next = it.next();
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
