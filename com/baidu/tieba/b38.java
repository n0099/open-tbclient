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
import com.baidu.tieba.iv4;
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
/* loaded from: classes3.dex */
public class b38 {
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

    public static boolean a(List<pv4> list, tv4 tv4Var, PostData postData, tx7 tx7Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, tv4Var, postData, tx7Var, Boolean.valueOf(z)})) == null) {
            if (list == null || postData == null || tx7Var == null || !z || !tx7Var.q() || !TbadkCoreApplication.isLogin() || k(postData) || tx7Var.p()) {
                return false;
            }
            pv4 pv4Var = new pv4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0325), tv4Var);
            list.add(pv4Var);
            aw8.f(pv4Var.d, postData);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<pv4> list, tv4 tv4Var, PostData postData, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, tv4Var, postData, pbModel)) == null) {
            if (list != null && postData != null && pbModel != null && pbModel.S1() != null) {
                dx7 S1 = pbModel.S1();
                if (S1.m0() && TbadkCoreApplication.isLogin() && !k(postData) && !S1.l0()) {
                    pv4 pv4Var = new pv4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0325), tv4Var);
                    list.add(pv4Var);
                    aw8.f(pv4Var.d, postData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<pv4> c(List<pv4> list, AgreeData agreeData, SparseArray<?> sparseArray, tv4 tv4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, tv4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    pv4 pv4Var = new pv4(-1, f18.u(R.string.obfuscated_res_0x7f0f0363, new Object[0]), tv4Var);
                    pv4Var.d.setTag(sparseArray);
                    arrayList.add(pv4Var);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f09181f) == null || ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09181f)).booleanValue()) {
                        pv4 pv4Var2 = new pv4(-2, f18.u(R.string.obfuscated_res_0x7f0f0364, new Object[0]), tv4Var);
                        pv4Var2.d.setTag(sparseArray);
                        arrayList.add(pv4Var2);
                    }
                } else {
                    pv4 pv4Var3 = new pv4(-1, f18.u(R.string.obfuscated_res_0x7f0f0362, new Object[0]), tv4Var);
                    pv4Var3.d.setTag(sparseArray);
                    arrayList.add(pv4Var3);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f09181f) == null || ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09181f)).booleanValue()) {
                        pv4 pv4Var4 = new pv4(-2, f18.u(R.string.obfuscated_res_0x7f0f0365, new Object[0]), tv4Var);
                        pv4Var4.d.setTag(sparseArray);
                        arrayList.add(pv4Var4);
                    }
                }
            } else {
                pv4 pv4Var5 = new pv4(-1, f18.u(R.string.obfuscated_res_0x7f0f0362, new Object[0]), tv4Var);
                pv4Var5.d.setTag(sparseArray);
                arrayList.add(pv4Var5);
                if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f09181f) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09181f)).booleanValue()) {
                    pv4 pv4Var6 = new pv4(-2, f18.u(R.string.obfuscated_res_0x7f0f0364, new Object[0]), tv4Var);
                    pv4Var6.d.setTag(sparseArray);
                    arrayList.add(pv4Var6);
                }
            }
            pv4 pv4Var7 = new pv4(-3, f18.u(R.string.obfuscated_res_0x7f0f102b, new Object[0]), tv4Var);
            pv4Var7.d.setTag(sparseArray);
            arrayList.add(pv4Var7);
            pv4 pv4Var8 = new pv4(-4, f18.u(R.string.obfuscated_res_0x7f0f1179, new Object[0]), tv4Var);
            pv4Var8.d.setTag(sparseArray);
            arrayList.add(pv4Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<pv4> d(List<pv4> list, AgreeData agreeData, SparseArray<?> sparseArray, tv4 tv4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, list, agreeData, sparseArray, tv4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f09181f) == null || ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09181f)).booleanValue()) {
                        pv4 pv4Var = new pv4(-2, f18.u(R.string.obfuscated_res_0x7f0f0087, new Object[0]), tv4Var);
                        pv4Var.d.setTag(sparseArray);
                        arrayList.add(pv4Var);
                    }
                } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f09181f) == null || ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09181f)).booleanValue()) {
                    pv4 pv4Var2 = new pv4(-2, f18.u(R.string.obfuscated_res_0x7f0f0365, new Object[0]), tv4Var);
                    pv4Var2.d.setTag(sparseArray);
                    arrayList.add(pv4Var2);
                }
            } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f09181f) == null || ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09181f)).booleanValue()) {
                pv4 pv4Var3 = new pv4(-2, f18.u(R.string.obfuscated_res_0x7f0f0087, new Object[0]), tv4Var);
                pv4Var3.d.setTag(sparseArray);
                arrayList.add(pv4Var3);
            }
            pv4 pv4Var4 = new pv4(-3, f18.u(R.string.obfuscated_res_0x7f0f102b, new Object[0]), tv4Var);
            pv4Var4.d.setTag(sparseArray);
            arrayList.add(0, pv4Var4);
            pv4 pv4Var5 = new pv4(-4, f18.u(R.string.obfuscated_res_0x7f0f1179, new Object[0]), tv4Var);
            pv4Var5.d.setTag(sparseArray);
            arrayList.add(1, pv4Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable r9<?> r9Var, iv4.e eVar, iv4.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, r9Var, eVar, eVar2) == null) {
            iv4 iv4Var = new iv4(activity);
            iv4Var.setMessageId(R.string.obfuscated_res_0x7f0f04b6);
            iv4Var.setPositiveButton(R.string.dialog_ok, eVar);
            iv4Var.setNegativeButton(R.string.dialog_cancel, eVar2);
            iv4Var.setCancelable(true);
            iv4Var.create(r9Var);
            iv4Var.show();
        }
    }

    public static List<pv4> f(List<pv4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (pv4 pv4Var : list) {
                pv4Var.l(h(pv4Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean i(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, pbModel)) == null) {
            if (pbModel != null && pbModel.S1() != null && pbModel.S1().m0()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(tx7 tx7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tx7Var)) == null) {
            if (tx7Var != null && tx7Var.q()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static SpannableStringBuilder g(PostData postData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, postData)) == null) {
            if (postData == null) {
                return null;
            }
            if (postData.X() != null) {
                str = postData.X().toString();
            } else {
                str = "";
            }
            SpannableString n = n(postData.s().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString n2 = n(str, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) n);
            spannableStringBuilder.append((CharSequence) n2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable h(pv4 pv4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pv4Var)) == null) {
            switch (pv4Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809be, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a8, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (f18.u(R.string.obfuscated_res_0x7f0f0364, new Object[0]).equals(pv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ac, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ad, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (f18.u(R.string.obfuscated_res_0x7f0f0362, new Object[0]).equals(pv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b5, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b6, SkinManager.getColor(R.color.CAM_X0301), null);
                case 0:
                default:
                    return null;
                case 1:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ae, SkinManager.getColor(R.color.CAM_X0107), null);
                case 2:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809bd, SkinManager.getColor(R.color.CAM_X0107), null);
                case 3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a9, SkinManager.getColor(R.color.CAM_X0107), null);
                case 4:
                    if (f18.u(R.string.obfuscated_res_0x7f0f0ac4, new Object[0]).equals(pv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a6, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a7, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (f18.u(R.string.obfuscated_res_0x7f0f1044, new Object[0]).equals(pv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809bc, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!f18.u(R.string.obfuscated_res_0x7f0f0b68, new Object[0]).equals(pv4Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ba, SkinManager.getColor(R.color.CAM_X0107), null);
                case 6:
                    if (f18.u(R.string.obfuscated_res_0x7f0f1044, new Object[0]).equals(pv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809bc, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!f18.u(R.string.obfuscated_res_0x7f0f04ba, new Object[0]).equals(pv4Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ab, SkinManager.getColor(R.color.CAM_X0107), null);
                case 7:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a1, SkinManager.getColor(R.color.CAM_X0107), null);
                case 8:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b1, SkinManager.getColor(R.color.CAM_X0107), null);
                case 9:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080994, SkinManager.getColor(R.color.CAM_X0107), null);
                case 10:
                    if (f18.u(R.string.obfuscated_res_0x7f0f04c5, new Object[0]).equals(pv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ab, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!f18.u(R.string.obfuscated_res_0x7f0f04ba, new Object[0]).equals(pv4Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809ab, SkinManager.getColor(R.color.CAM_X0107), null);
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a5, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (f18.u(R.string.obfuscated_res_0x7f0f0b64, new Object[0]).equals(pv4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b8, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (!f18.u(R.string.obfuscated_res_0x7f0f14f4, new Object[0]).equals(pv4Var.g())) {
                        return null;
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809b9, SkinManager.getColor(R.color.CAM_X0107), null);
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080993, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean k(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, postData)) == null) {
            if (postData != null && postData.s() != null && !StringUtils.isNull(postData.s().getUserId()) && postData.s().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<pv4> l(List<pv4> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<pv4> it = list.iterator();
                while (it.hasNext()) {
                    pv4 next = it.next();
                    if (next.f() == 2 || next.f() == 1 || next.f() == 3) {
                        it.remove();
                    }
                }
            }
            return list;
        }
        return (List) invokeLZ.objValue;
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
}
