package com.baidu.tieba;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.s45;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class eo9 {
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

    public static boolean a(List<y45> list, c55 c55Var, zfa zfaVar, pi9 pi9Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, c55Var, zfaVar, pi9Var, Boolean.valueOf(z)})) == null) {
            if (list == null || zfaVar == null || pi9Var == null || !z || !pi9Var.o() || !TbadkCoreApplication.isLogin() || k(zfaVar) || pi9Var.n()) {
                return false;
            }
            y45 y45Var = new y45(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0366), c55Var);
            list.add(y45Var);
            koa.f(y45Var.d, zfaVar);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<y45> list, c55 c55Var, zfa zfaVar, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, c55Var, zfaVar, pbModel)) == null) {
            if (list != null && zfaVar != null && pbModel != null && pbModel.s1() != null) {
                yh9 s1 = pbModel.s1();
                if (s1.k0() && TbadkCoreApplication.isLogin() && !k(zfaVar) && !s1.j0()) {
                    y45 y45Var = new y45(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0366), c55Var);
                    list.add(y45Var);
                    koa.f(y45Var.d, zfaVar);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<y45> c(List<y45> list, AgreeData agreeData, SparseArray<?> sparseArray, c55 c55Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, c55Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    y45 y45Var = new y45(-1, gm9.t(R.string.c_agreeed, new Object[0]), c55Var);
                    y45Var.d.setTag(sparseArray);
                    arrayList.add(y45Var);
                    if (!f(sparseArray, R.id.pb_dialog_item_isugc)) {
                        y45 y45Var2 = new y45(-2, gm9.t(R.string.c_disagree, new Object[0]), c55Var);
                        y45Var2.d.setTag(sparseArray);
                        arrayList.add(y45Var2);
                    }
                } else {
                    y45 y45Var3 = new y45(-1, gm9.t(R.string.c_agree, new Object[0]), c55Var);
                    y45Var3.d.setTag(sparseArray);
                    arrayList.add(y45Var3);
                    if (!f(sparseArray, R.id.pb_dialog_item_isugc)) {
                        y45 y45Var4 = new y45(-2, gm9.t(R.string.c_disagreeed, new Object[0]), c55Var);
                        y45Var4.d.setTag(sparseArray);
                        arrayList.add(y45Var4);
                    }
                }
            } else {
                y45 y45Var5 = new y45(-1, gm9.t(R.string.c_agree, new Object[0]), c55Var);
                y45Var5.d.setTag(sparseArray);
                arrayList.add(y45Var5);
                if (!f(sparseArray, R.id.pb_dialog_item_isugc)) {
                    y45 y45Var6 = new y45(-2, gm9.t(R.string.c_disagree, new Object[0]), c55Var);
                    y45Var6.d.setTag(sparseArray);
                    arrayList.add(y45Var6);
                }
            }
            y45 y45Var7 = new y45(-3, gm9.t(R.string.obfuscated_res_0x7f0f122e, new Object[0]), c55Var);
            y45Var7.d.setTag(sparseArray);
            arrayList.add(y45Var7);
            y45 y45Var8 = new y45(-4, gm9.t(R.string.obfuscated_res_0x7f0f1387, new Object[0]), c55Var);
            y45Var8.d.setTag(sparseArray);
            arrayList.add(y45Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void d(Activity activity, @Nullable BdPageContext<?> bdPageContext, s45.e eVar, s45.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, activity, bdPageContext, eVar, eVar2) == null) {
            s45 s45Var = new s45(activity);
            s45Var.setMessageId(R.string.del_post_confirm);
            s45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0598, eVar);
            s45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f058d, eVar2);
            s45Var.setCancelable(true);
            s45Var.create(bdPageContext);
            s45Var.show();
        }
    }

    public static List<y45> e(List<y45> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (y45 y45Var : list) {
                y45Var.l(h(y45Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean i(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, pbModel)) == null) {
            if (pbModel != null && pbModel.s1() != null && pbModel.s1().k0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(pi9 pi9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pi9Var)) == null) {
            if (pi9Var != null && pi9Var.o()) {
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

    public static SpannableStringBuilder g(zfa zfaVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, zfaVar)) == null) {
            if (zfaVar == null) {
                return null;
            }
            if (zfaVar.e0() != null) {
                str = zfaVar.e0().toString();
            } else {
                str = "";
            }
            SpannableString n = n(zfaVar.r().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString n2 = n(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) n);
            spannableStringBuilder.append((CharSequence) n2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable h(y45 y45Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, y45Var)) == null) {
            switch (y45Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_share30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_comment30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (gm9.t(R.string.c_disagree, new Object[0]).equals(y45Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_dislike30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_disliked30, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (gm9.t(R.string.c_agree, new Object[0]).equals(y45Var.g())) {
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
                    if (gm9.t(R.string.obfuscated_res_0x7f0f0c45, new Object[0]).equals(y45Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collect30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_collected30, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (gm9.t(R.string.report_text, new Object[0]).equals(y45Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!gm9.t(R.string.obfuscated_res_0x7f0f0d05, new Object[0]).equals(y45Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakingset30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (gm9.t(R.string.report_text, new Object[0]).equals(y45Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_report30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!gm9.t(R.string.obfuscated_res_0x7f0f0548, new Object[0]).equals(y45Var.g())) {
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
                    if (gm9.t(R.string.obfuscated_res_0x7f0f0557, new Object[0]).equals(y45Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!gm9.t(R.string.obfuscated_res_0x7f0f0548, new Object[0]).equals(y45Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_delete30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_block30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (gm9.t(R.string.obfuscated_res_0x7f0f0d01, new Object[0]).equals(y45Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeaking30, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!gm9.t(R.string.un_mute, new Object[0]).equals(y45Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_recommend_nospeakinged30, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.icon_pure_pb_batch_delete, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean k(zfa zfaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, zfaVar)) == null) {
            if (zfaVar != null && zfaVar.r() != null && !StringUtils.isNull(zfaVar.r().getUserId()) && zfaVar.r().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<y45> l(List<y45> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<y45> it = list.iterator();
                while (it.hasNext()) {
                    y45 next = it.next();
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
