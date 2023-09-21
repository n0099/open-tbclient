package com.baidu.tieba.feed.constant;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/baidu/tieba/feed/constant/FeedPicDecorationLocation;", "", "locationText", "", "locationCode", "", "locationGravity", "(Ljava/lang/String;ILjava/lang/String;II)V", "getLocationCode", "()I", "getLocationGravity", "getLocationText", "()Ljava/lang/String;", "LEFT_TOP", "RIGHT_TOP", "LEFT_BOTTOM", "RIGHT_BOTTOM", "MIDDLE", "lib-components_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedPicDecorationLocation {
    public static final /* synthetic */ FeedPicDecorationLocation[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final FeedPicDecorationLocation LEFT_BOTTOM;
    public static final FeedPicDecorationLocation LEFT_TOP;
    public static final FeedPicDecorationLocation MIDDLE;
    public static final FeedPicDecorationLocation RIGHT_BOTTOM;
    public static final FeedPicDecorationLocation RIGHT_TOP;
    public transient /* synthetic */ FieldHolder $fh;
    public final int locationCode;
    public final int locationGravity;
    public final String locationText;

    public static final /* synthetic */ FeedPicDecorationLocation[] $values() {
        return new FeedPicDecorationLocation[]{LEFT_TOP, RIGHT_TOP, LEFT_BOTTOM, RIGHT_BOTTOM, MIDDLE};
    }

    public static FeedPicDecorationLocation valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (FeedPicDecorationLocation) Enum.valueOf(FeedPicDecorationLocation.class, str) : (FeedPicDecorationLocation) invokeL.objValue;
    }

    public static FeedPicDecorationLocation[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (FeedPicDecorationLocation[]) $VALUES.clone() : (FeedPicDecorationLocation[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(221031154, "Lcom/baidu/tieba/feed/constant/FeedPicDecorationLocation;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(221031154, "Lcom/baidu/tieba/feed/constant/FeedPicDecorationLocation;");
                return;
            }
        }
        LEFT_TOP = new FeedPicDecorationLocation("LEFT_TOP", 0, "left_top", FeedPicDecorationDirection.LEFT.getDirection() | FeedPicDecorationDirection.TOP.getDirection(), 51);
        RIGHT_TOP = new FeedPicDecorationLocation("RIGHT_TOP", 1, "right_top", FeedPicDecorationDirection.RIGHT.getDirection() | FeedPicDecorationDirection.TOP.getDirection(), 53);
        LEFT_BOTTOM = new FeedPicDecorationLocation("LEFT_BOTTOM", 2, "left_bottom", FeedPicDecorationDirection.LEFT.getDirection() | FeedPicDecorationDirection.BOTTOM.getDirection(), 83);
        RIGHT_BOTTOM = new FeedPicDecorationLocation("RIGHT_BOTTOM", 3, "right_bottom", FeedPicDecorationDirection.RIGHT.getDirection() | FeedPicDecorationDirection.BOTTOM.getDirection(), 85);
        MIDDLE = new FeedPicDecorationLocation("MIDDLE", 4, NativeConstants.MIDDLE, FeedPicDecorationDirection.MIDDLE.getDirection(), 17);
        $VALUES = $values();
    }

    public FeedPicDecorationLocation(String str, int i, String str2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.locationText = str2;
        this.locationCode = i2;
        this.locationGravity = i3;
    }

    public final int getLocationCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.locationCode;
        }
        return invokeV.intValue;
    }

    public final int getLocationGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.locationGravity;
        }
        return invokeV.intValue;
    }

    public final String getLocationText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.locationText;
        }
        return (String) invokeV.objValue;
    }
}
