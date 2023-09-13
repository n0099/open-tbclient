package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class e47 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;
    public static final Pattern b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947684449, "Lcom/baidu/tieba/e47;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947684449, "Lcom/baidu/tieba/e47;");
                return;
            }
        }
        a = Pattern.compile("#\\([a-zA-Z0-9_~！\\-\\u4E00-\\u9FA5]+\\)");
        b = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    }

    public static int a(CharSequence charSequence) {
        InterceptResult invokeL;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, charSequence)) == null) {
            int i = 0;
            if (charSequence != null && charSequence.length() != 0) {
                Matcher matcher = a.matcher(charSequence);
                while (matcher.find()) {
                    String group = matcher.group();
                    if (MessageManager.getInstance().findTask(2004608) != null && (runTask = MessageManager.getInstance().runTask(2004608, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                        i++;
                    }
                }
                Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(charSequence);
                while (matcher2.find()) {
                    String[] split = matcher2.group().split(",");
                    if (split != null && split.length == 5) {
                        i++;
                    }
                }
                Matcher matcher3 = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(charSequence);
                while (matcher3.find()) {
                    String[] split2 = matcher3.group().split(",");
                    if (split2 != null && split2.length == 6) {
                        i++;
                    }
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static int b(CharSequence charSequence) {
        InterceptResult invokeL;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, charSequence)) == null) {
            int i = 0;
            if (charSequence != null && charSequence.length() != 0) {
                Matcher matcher = a.matcher(charSequence);
                while (matcher.find()) {
                    String group = matcher.group();
                    if (MessageManager.getInstance().findTask(2004608) != null && (runTask = MessageManager.getInstance().runTask(2004608, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                        i++;
                    }
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String replaceAll = str.replaceAll(ym5.h, EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT).replaceAll("meme,diy_", EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT);
            Matcher matcher = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(replaceAll);
            StringBuilder sb = new StringBuilder(replaceAll);
            int i = 0;
            while (matcher.find()) {
                String[] split = matcher.group().split(",");
                if (split != null && split.length == 6) {
                    StringBuilder sb2 = new StringBuilder();
                    int start = matcher.start() - i;
                    int end = matcher.end() - i;
                    for (int i2 = 0; i2 < split.length; i2++) {
                        if (i2 != 1) {
                            sb2.append(split[i2]);
                            if (i2 < split.length - 1) {
                                sb2.append(",");
                            }
                        }
                    }
                    i += (end - start) - sb2.toString().length();
                    if (start >= 0 && end <= sb.length()) {
                        sb.replace(start, end, sb2.toString());
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
