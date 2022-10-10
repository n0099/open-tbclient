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
import com.baidu.tieba.nu4;
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
public class g18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(List<uu4> list, yu4 yu4Var, PostData postData, zv7 zv7Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{list, yu4Var, postData, zv7Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (list == null || postData == null || zv7Var == null || !z || z2 || !zv7Var.q() || !TbadkCoreApplication.isLogin() || k(postData) || zv7Var.p()) {
                return false;
            }
            uu4 uu4Var = new uu4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0324), yu4Var);
            list.add(uu4Var);
            hu8.f(uu4Var.d, postData);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(List<uu4> list, yu4 yu4Var, PostData postData, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, yu4Var, postData, pbModel)) == null) {
            if (list != null && postData != null && pbModel != null && pbModel.S1() != null) {
                jv7 S1 = pbModel.S1();
                if (S1.j0() && TbadkCoreApplication.isLogin() && !k(postData) && !S1.i0()) {
                    uu4 uu4Var = new uu4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0324), yu4Var);
                    list.add(uu4Var);
                    hu8.f(uu4Var.d, postData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<uu4> c(List<uu4> list, AgreeData agreeData, SparseArray<?> sparseArray, yu4 yu4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, yu4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    uu4 uu4Var = new uu4(-1, lz7.j(R.string.obfuscated_res_0x7f0f0362, new Object[0]), yu4Var);
                    uu4Var.d.setTag(sparseArray);
                    arrayList.add(uu4Var);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917ec) == null || ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917ec)).booleanValue()) {
                        uu4 uu4Var2 = new uu4(-2, lz7.j(R.string.obfuscated_res_0x7f0f0363, new Object[0]), yu4Var);
                        uu4Var2.d.setTag(sparseArray);
                        arrayList.add(uu4Var2);
                    }
                } else {
                    uu4 uu4Var3 = new uu4(-1, lz7.j(R.string.obfuscated_res_0x7f0f0361, new Object[0]), yu4Var);
                    uu4Var3.d.setTag(sparseArray);
                    arrayList.add(uu4Var3);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917ec) == null || ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917ec)).booleanValue()) {
                        uu4 uu4Var4 = new uu4(-2, lz7.j(R.string.obfuscated_res_0x7f0f0364, new Object[0]), yu4Var);
                        uu4Var4.d.setTag(sparseArray);
                        arrayList.add(uu4Var4);
                    }
                }
            } else {
                uu4 uu4Var5 = new uu4(-1, lz7.j(R.string.obfuscated_res_0x7f0f0361, new Object[0]), yu4Var);
                uu4Var5.d.setTag(sparseArray);
                arrayList.add(uu4Var5);
                if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917ec) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917ec)).booleanValue()) {
                    uu4 uu4Var6 = new uu4(-2, lz7.j(R.string.obfuscated_res_0x7f0f0363, new Object[0]), yu4Var);
                    uu4Var6.d.setTag(sparseArray);
                    arrayList.add(uu4Var6);
                }
            }
            uu4 uu4Var7 = new uu4(-3, lz7.j(R.string.obfuscated_res_0x7f0f0ffe, new Object[0]), yu4Var);
            uu4Var7.d.setTag(sparseArray);
            arrayList.add(uu4Var7);
            uu4 uu4Var8 = new uu4(-4, lz7.j(R.string.obfuscated_res_0x7f0f1147, new Object[0]), yu4Var);
            uu4Var8.d.setTag(sparseArray);
            arrayList.add(uu4Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<uu4> d(List<uu4> list, AgreeData agreeData, SparseArray<?> sparseArray, yu4 yu4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, list, agreeData, sparseArray, yu4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917ec) == null || ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917ec)).booleanValue()) {
                        uu4 uu4Var = new uu4(-2, lz7.j(R.string.obfuscated_res_0x7f0f0087, new Object[0]), yu4Var);
                        uu4Var.d.setTag(sparseArray);
                        arrayList.add(uu4Var);
                    }
                } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917ec) == null || ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917ec)).booleanValue()) {
                    uu4 uu4Var2 = new uu4(-2, lz7.j(R.string.obfuscated_res_0x7f0f0364, new Object[0]), yu4Var);
                    uu4Var2.d.setTag(sparseArray);
                    arrayList.add(uu4Var2);
                }
            } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917ec) == null || ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917ec)).booleanValue()) {
                uu4 uu4Var3 = new uu4(-2, lz7.j(R.string.obfuscated_res_0x7f0f0087, new Object[0]), yu4Var);
                uu4Var3.d.setTag(sparseArray);
                arrayList.add(uu4Var3);
            }
            uu4 uu4Var4 = new uu4(-3, lz7.j(R.string.obfuscated_res_0x7f0f0ffe, new Object[0]), yu4Var);
            uu4Var4.d.setTag(sparseArray);
            arrayList.add(0, uu4Var4);
            uu4 uu4Var5 = new uu4(-4, lz7.j(R.string.obfuscated_res_0x7f0f1147, new Object[0]), yu4Var);
            uu4Var5.d.setTag(sparseArray);
            arrayList.add(1, uu4Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable r9<?> r9Var, nu4.e eVar, nu4.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, r9Var, eVar, eVar2) == null) {
            nu4 nu4Var = new nu4(activity);
            nu4Var.setMessageId(R.string.obfuscated_res_0x7f0f04ac);
            nu4Var.setPositiveButton(R.string.dialog_ok, eVar);
            nu4Var.setNegativeButton(R.string.dialog_cancel, eVar2);
            nu4Var.setCancelable(true);
            nu4Var.create(r9Var);
            nu4Var.show();
        }
    }

    public static List<uu4> f(List<uu4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (uu4 uu4Var : list) {
                uu4Var.l(h(uu4Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static SpannableStringBuilder g(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, postData)) == null) {
            if (postData == null) {
                return null;
            }
            String tbRichText = postData.W() != null ? postData.W().toString() : "";
            SpannableString n = n(postData.s().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString n2 = n(tbRichText, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) n);
            spannableStringBuilder.append((CharSequence) n2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable h(uu4 uu4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, uu4Var)) == null) {
            switch (uu4Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a6, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080990, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (lz7.j(R.string.obfuscated_res_0x7f0f0363, new Object[0]).equals(uu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080994, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080995, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (lz7.j(R.string.obfuscated_res_0x7f0f0361, new Object[0]).equals(uu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08099d, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08099e, SkinManager.getColor(R.color.CAM_X0301), null);
                case 0:
                default:
                    return null;
                case 1:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080996, SkinManager.getColor(R.color.CAM_X0107), null);
                case 2:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a5, SkinManager.getColor(R.color.CAM_X0107), null);
                case 3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080991, SkinManager.getColor(R.color.CAM_X0107), null);
                case 4:
                    if (lz7.j(R.string.obfuscated_res_0x7f0f0aaa, new Object[0]).equals(uu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08098e, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08098f, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (lz7.j(R.string.obfuscated_res_0x7f0f1017, new Object[0]).equals(uu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a4, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (lz7.j(R.string.obfuscated_res_0x7f0f0b4d, new Object[0]).equals(uu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a2, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 6:
                    if (lz7.j(R.string.obfuscated_res_0x7f0f1017, new Object[0]).equals(uu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a4, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (lz7.j(R.string.obfuscated_res_0x7f0f04b0, new Object[0]).equals(uu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080993, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 7:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080989, SkinManager.getColor(R.color.CAM_X0107), null);
                case 8:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080999, SkinManager.getColor(R.color.CAM_X0107), null);
                case 9:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08097c, SkinManager.getColor(R.color.CAM_X0107), null);
                case 10:
                    if (lz7.j(R.string.obfuscated_res_0x7f0f04bb, new Object[0]).equals(uu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080993, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (lz7.j(R.string.obfuscated_res_0x7f0f04b0, new Object[0]).equals(uu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080993, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08098d, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (lz7.j(R.string.obfuscated_res_0x7f0f0b49, new Object[0]).equals(uu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a0, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (lz7.j(R.string.obfuscated_res_0x7f0f14bd, new Object[0]).equals(uu4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a1, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08097b, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean i(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, pbModel)) == null) ? (pbModel == null || pbModel.S1() == null || !pbModel.S1().j0()) ? false : true : invokeL.booleanValue;
    }

    public static boolean j(zv7 zv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, zv7Var)) == null) ? zv7Var != null && zv7Var.q() : invokeL.booleanValue;
    }

    public static boolean k(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, postData)) == null) ? (postData == null || postData.s() == null || StringUtils.isNull(postData.s().getUserId()) || !postData.s().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true : invokeL.booleanValue;
    }

    public static List<uu4> l(List<uu4> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<uu4> it = list.iterator();
                while (it.hasNext()) {
                    uu4 next = it.next();
                    if (next.f() == 2 || next.f() == 1 || next.f() == 3) {
                        it.remove();
                    }
                }
            }
            return list;
        }
        return (List) invokeLZ.objValue;
    }

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
