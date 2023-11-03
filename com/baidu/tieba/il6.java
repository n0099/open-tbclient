package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class il6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? "frs_page" : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? "personalize_page" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;
        public int c;
        public int d;
        public int e;

        public a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = -1;
            this.b = "";
            this.c = R.color.CAM_X0304;
            this.d = R.drawable.pic_dot_title;
            this.e = 0;
            this.a = i;
        }

        public a(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = -1;
            this.b = "";
            this.c = R.color.CAM_X0304;
            this.d = R.drawable.pic_dot_title;
            this.e = 0;
            this.a = i;
            this.c = i2;
            this.d = i3;
        }

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.a = -1;
            this.b = "";
            this.c = R.color.CAM_X0304;
            this.d = R.drawable.pic_dot_title;
            this.e = 0;
            this.b = str;
        }

        public a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.a = -1;
            this.b = "";
            this.c = R.color.CAM_X0304;
            this.d = R.drawable.pic_dot_title;
            this.e = 0;
            this.b = str;
            this.d = i;
        }
    }

    public static void a(String str) {
        ysa readThreadHistory;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && !StringUtils.isNull(str) && !"0".equalsIgnoreCase(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.b(str)) {
            readThreadHistory.a(str);
        }
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        ysa readThreadHistory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.d(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(ThreadData threadData, SpannableStringBuilder spannableStringBuilder, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(65537, null, threadData, spannableStringBuilder, z) != null) || spannableStringBuilder == null || qd.isEmptyStringAfterTrim(spannableStringBuilder.toString()) || threadData == null || threadData.getIs_top() != 0) {
            return;
        }
        if (!z && threadData.getIsNoTitle() != 1 && !StringUtils.isNull(threadData.getTitle())) {
            return;
        }
        ArrayList<ey5> prefixIcons = threadData.getPrefixIcons();
        if (ListUtils.isEmpty(prefixIcons)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prefixIcons.size(); i++) {
            if (prefixIcons.get(i) != null && !StringUtils.isNull(prefixIcons.get(i).a())) {
                sb.append(prefixIcons.get(i).a());
            }
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        int i2 = 0;
        for (int i3 = 0; i3 < prefixIcons.size(); i3++) {
            if (prefixIcons.get(i3) != null && !StringUtils.isNull(prefixIcons.get(i3).a())) {
                int length = prefixIcons.get(i3).a().length();
                c(spannableString, prefixIcons.get(i3), i2, length);
                i2 += length;
            }
        }
        spannableStringBuilder.insert(0, (CharSequence) spannableString);
    }

    public static void c(SpannableString spannableString, ey5 ey5Var, int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLII(65538, null, spannableString, ey5Var, i, i2) == null) && spannableString != null && ey5Var != null && (i3 = i2 + i) <= spannableString.length()) {
            spannableString.setSpan(new fy5(ey5Var), i, i3, 33);
            spannableString.setSpan(new AbsoluteSizeSpan(ey5Var.i), i, i3, 33);
        }
    }

    public static SpannableStringBuilder h(Context context, String str, ArrayList<a> arrayList, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, str, arrayList, Boolean.valueOf(z)})) == null) {
            return i(context, str, arrayList, z, true);
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public static void l(TextView textView, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLII(65547, null, textView, str, i, i2) != null) || !(textView instanceof TextView)) {
            return;
        }
        if (k(str) && TbSingleton.getInstance().isInFrs) {
            SkinManager.setViewTextColor(textView, i2);
        } else {
            SkinManager.setViewTextColor(textView, i);
        }
    }

    public static SpannableStringBuilder d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), 0, str.length(), 17);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0106)), str.length(), str.length() + 1, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return String.valueOf(System.currentTimeMillis() / 1000);
        }
        return (String) invokeV.objValue;
    }

    public static SpannableStringBuilder i(Context context, String str, ArrayList<a> arrayList, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, str, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (str != null && context != null && arrayList != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                for (int i = 0; i != arrayList.size(); i++) {
                    a aVar = arrayList.get(i);
                    if (aVar != null) {
                        int i2 = aVar.a;
                        if (i2 > 0) {
                            aVar.b = context.getString(i2);
                        }
                        if (!qd.isEmpty(aVar.b)) {
                            int length = spannableStringBuilder.length();
                            spannableStringBuilder.append((CharSequence) aVar.b);
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(aVar.c)), length, spannableStringBuilder.length(), 17);
                            if (i == arrayList.size() - 1 && !z2) {
                                break;
                            }
                            Bitmap bitmap = SkinManager.getBitmap(aVar.d);
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                            if (bitmap != null) {
                                bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                            }
                            j55 j55Var = new j55(bitmapDrawable);
                            int i3 = aVar.e;
                            if (i3 != 0) {
                                j55Var.b(i3);
                            }
                            int length2 = spannableStringBuilder.length();
                            spannableStringBuilder.append((CharSequence) " ");
                            spannableStringBuilder.setSpan(j55Var, length2, spannableStringBuilder.length(), 17);
                        } else {
                            continue;
                        }
                    }
                }
                if (z) {
                    spannableStringBuilder.append((CharSequence) str);
                }
                return spannableStringBuilder;
            }
            return null;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public static void j(ThreadData threadData, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, threadData, textView) == null) {
            if ((StringUtils.isNull(threadData.getTitle()) && (threadData.getRichTitle() == null || threadData.getRichTitle().size() == 0)) || threadData.getIsNoTitle() == 1) {
                threadData.parserSpecTitleForFrsAndPb(false, true);
                if (threadData.getSpan_str() != null && !StringUtils.isNull(threadData.getSpan_str().toString())) {
                    textView.setVisibility(0);
                    textView.setText(threadData.getSpan_str());
                    return;
                }
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            threadData.threadTitleSpanOffset = 0;
            threadData.parserSpecTitleForFrsAndPb(false, true);
            SpannableStringBuilder span_str = threadData.getSpan_str();
            textView.setOnTouchListener(new g5b(span_str));
            textView.setText(span_str);
            l(textView, threadData.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }
}
