package com.baidu.tieba.advert.sdk.data;

import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttDecoder;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class ResourceType {
    public static final /* synthetic */ ResourceType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ResourceType ARRAY;
    public static final ResourceType DRAWABLE;
    public static final ResourceType ID;
    public static final ResourceType LAYOUT;
    public static final ResourceType STRING;
    public static final ResourceType STYLE;
    public transient /* synthetic */ FieldHolder $fh;
    public String value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1875534992, "Lcom/baidu/tieba/advert/sdk/data/ResourceType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1875534992, "Lcom/baidu/tieba/advert/sdk/data/ResourceType;");
                return;
            }
        }
        ID = new ResourceType(UserSettingForceListListener.FORCE_LIST_ITEM_ID_KEY, 0, "id");
        ARRAY = new ResourceType("ARRAY", 1, "array");
        LAYOUT = new ResourceType("LAYOUT", 2, "layout");
        STYLE = new ResourceType(WebvttDecoder.STYLE_START, 3, "style");
        STRING = new ResourceType("STRING", 4, "string");
        ResourceType resourceType = new ResourceType("DRAWABLE", 5, "drawable");
        DRAWABLE = resourceType;
        $VALUES = new ResourceType[]{ID, ARRAY, LAYOUT, STYLE, STRING, resourceType};
    }

    public ResourceType(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = str2;
    }

    public static ResourceType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ResourceType) Enum.valueOf(ResourceType.class, str) : (ResourceType) invokeL.objValue;
    }

    public static ResourceType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ResourceType[]) $VALUES.clone() : (ResourceType[]) invokeV.objValue;
    }

    public String getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : (String) invokeV.objValue;
    }
}
