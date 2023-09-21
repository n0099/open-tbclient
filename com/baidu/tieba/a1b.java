package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a1b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a a;
    public static final String b = "#\\(rich-image_[\\s\\S]+?_img\\)";
    @JvmField
    public static final String c = "#(rich-image_";
    public static final String d = "_img)";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947563735, "Lcom/baidu/tieba/a1b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947563735, "Lcom/baidu/tieba/a1b;");
                return;
            }
        }
        a = new a(null);
    }

    @JvmStatic
    public static final String c(WriteData writeData, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, writeData, str)) == null) ? a.a(writeData, str) : (String) invokeLL.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return a1b.b;
            }
            return (String) invokeV.objValue;
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return a1b.d;
            }
            return (String) invokeV.objValue;
        }

        @JvmStatic
        public final String a(WriteData writeData, String content) {
            InterceptResult invokeLL;
            String replace$default;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, writeData, content)) == null) {
                Intrinsics.checkNotNullParameter(writeData, "writeData");
                Intrinsics.checkNotNullParameter(content, "content");
                if (TextUtils.isEmpty(content)) {
                    return content;
                }
                Matcher matcher = Pattern.compile(c()).matcher(content);
                if (matcher.find()) {
                    String result = matcher.group();
                    Intrinsics.checkNotNullExpressionValue(result, "result");
                    String substring = result.substring(a1b.c.length(), result.length() - d().length());
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    if (!TextUtils.isEmpty(substring) && StringsKt__StringsJVMKt.startsWith$default(substring, "%7B%22", false, 2, null)) {
                        substring = URLDecoder.decode(substring);
                        Intrinsics.checkNotNullExpressionValue(substring, "decode(commodityJson)");
                    }
                    try {
                        ImageFileInfo b = b(writeData, new JSONObject(substring));
                        if (b != null && !TextUtils.isEmpty(b.getServerImageCode())) {
                            TbLog hybridLog = HybridLog.getInstance();
                            hybridLog.e("WriteDataHelper", "富文本图片数据替换成功，to：" + b.getServerImageCode() + " from " + result);
                            String serverImageCode = b.getServerImageCode();
                            Intrinsics.checkNotNullExpressionValue(serverImageCode, "data.serverImageCode");
                            replace$default = StringsKt__StringsJVMKt.replace$default(content, result, serverImageCode, false, 4, (Object) null);
                        } else {
                            HybridLog.getInstance().e("WriteDataHelper", "富文本图片数据替换失败，没有对应的serverImageCode");
                            replace$default = StringsKt__StringsJVMKt.replace$default(content, result, "", false, 4, (Object) null);
                        }
                    } catch (Exception e) {
                        TbLog hybridLog2 = HybridLog.getInstance();
                        hybridLog2.e("WriteDataHelper", "富文本数据解析失败：" + e);
                        replace$default = StringsKt__StringsJVMKt.replace$default(content, result, "", false, 4, (Object) null);
                    }
                    return a(writeData, replace$default);
                }
                return content;
            }
            return (String) invokeLL.objValue;
        }

        public final ImageFileInfo b(WriteData writeData, JSONObject jsonFromH5) {
            InterceptResult invokeLL;
            LinkedList<ImageFileInfo> linkedList;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData, jsonFromH5)) == null) {
                Intrinsics.checkNotNullParameter(writeData, "writeData");
                Intrinsics.checkNotNullParameter(jsonFromH5, "jsonFromH5");
                String optString = jsonFromH5.optString("tag");
                String optString2 = jsonFromH5.optString("name");
                int optInt = jsonFromH5.optInt("imageIndex");
                ImageFileInfo imageFileInfo = null;
                if (TextUtils.isEmpty(optString)) {
                    HybridLog.getInstance().e("WriteDataHelper", "图片解析失败：FE传递的tag错误，info=" + jsonFromH5);
                    return null;
                }
                WriteImagesInfo writeImagesInfo = writeData.getWriteImagesInfo();
                if (writeImagesInfo != null) {
                    linkedList = writeImagesInfo.getChosedFiles();
                } else {
                    linkedList = null;
                }
                if (ListUtils.isEmpty(linkedList)) {
                    HybridLog.getInstance().e("WriteDataHelper", "图片解析失败：端上没有图片数据，info=" + jsonFromH5);
                    return null;
                }
                LinkedList<ImageFileInfo> chosedFiles = writeData.getWriteImagesInfo().getChosedFiles();
                Intrinsics.checkNotNull(chosedFiles);
                Iterator<ImageFileInfo> it = chosedFiles.iterator();
                int i = 0;
                while (it.hasNext()) {
                    int i2 = i + 1;
                    ImageFileInfo item = it.next();
                    Intrinsics.checkNotNullExpressionValue(item, "item");
                    if (!optString.equals(b1b.a(item)) && !optString2.equals(b1b.b(item))) {
                        i = i2;
                    } else if (optInt == i) {
                        return item;
                    } else {
                        i = i2;
                        imageFileInfo = item;
                    }
                }
                return imageFileInfo;
            }
            return (ImageFileInfo) invokeLL.objValue;
        }
    }
}
