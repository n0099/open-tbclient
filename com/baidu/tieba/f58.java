package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Drawable[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            Drawable[] drawableArr = new Drawable[2];
            char c = 65535;
            switch (str.hashCode()) {
                case -1581702362:
                    if (str.equals("share_num")) {
                        c = 1;
                        break;
                    }
                    break;
                case -6986408:
                    if (str.equals("care_num")) {
                        c = 3;
                        break;
                    }
                    break;
                case 975378291:
                    if (str.equals("agree_num")) {
                        c = 0;
                        break;
                    }
                    break;
                case 2103869862:
                    if (str.equals("comment_num")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            drawableArr[0] = WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0811d4, WebPManager.ResourceStateType.NORMAL);
                            drawableArr[1] = WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f081205, WebPManager.ResourceStateType.NORMAL);
                        } else {
                            drawableArr[0] = WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0811d3, WebPManager.ResourceStateType.NORMAL);
                            drawableArr[1] = WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f081204, WebPManager.ResourceStateType.NORMAL);
                        }
                    } else {
                        drawableArr[0] = WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0811d5, WebPManager.ResourceStateType.NORMAL);
                        drawableArr[1] = WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f081206, WebPManager.ResourceStateType.NORMAL);
                    }
                } else {
                    drawableArr[0] = WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0811d7, WebPManager.ResourceStateType.NORMAL);
                    drawableArr[1] = WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f081208, WebPManager.ResourceStateType.NORMAL);
                }
            } else {
                drawableArr[0] = WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0811d6, WebPManager.ResourceStateType.NORMAL);
                drawableArr[1] = WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f081207, WebPManager.ResourceStateType.NORMAL);
            }
            return drawableArr;
        }
        return (Drawable[]) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String b(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            switch (str.hashCode()) {
                case -1581702362:
                    if (str.equals("share_num")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -6986408:
                    if (str.equals("care_num")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 975378291:
                    if (str.equals("agree_num")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 2103869862:
                    if (str.equals("comment_num")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            return TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b9a);
                        }
                        return TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b99);
                    }
                    return TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b9b);
                }
                return TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b9d);
            }
            return TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b9c);
        }
        return (String) invokeL.objValue;
    }
}
