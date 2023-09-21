package com.baidu.tieba.feed.constant;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/baidu/tieba/feed/constant/FeedPicDecorationDirection;", "", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "", "marginValue", "(Ljava/lang/String;III)V", "getDirection", "()I", "getMarginValue", "LEFT", "TOP", "RIGHT", "BOTTOM", "MIDDLE", "lib-components_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedPicDecorationDirection {
    public static final /* synthetic */ FeedPicDecorationDirection[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final FeedPicDecorationDirection BOTTOM;
    public static final FeedPicDecorationDirection LEFT;
    public static final FeedPicDecorationDirection MIDDLE;
    public static final FeedPicDecorationDirection RIGHT;
    public static final FeedPicDecorationDirection TOP;
    public transient /* synthetic */ FieldHolder $fh;
    public final int direction;
    public final int marginValue;

    public static final /* synthetic */ FeedPicDecorationDirection[] $values() {
        return new FeedPicDecorationDirection[]{LEFT, TOP, RIGHT, BOTTOM, MIDDLE};
    }

    public static FeedPicDecorationDirection valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (FeedPicDecorationDirection) Enum.valueOf(FeedPicDecorationDirection.class, str) : (FeedPicDecorationDirection) invokeL.objValue;
    }

    public static FeedPicDecorationDirection[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (FeedPicDecorationDirection[]) $VALUES.clone() : (FeedPicDecorationDirection[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1239617104, "Lcom/baidu/tieba/feed/constant/FeedPicDecorationDirection;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1239617104, "Lcom/baidu/tieba/feed/constant/FeedPicDecorationDirection;");
                return;
            }
        }
        LEFT = new FeedPicDecorationDirection("LEFT", 0, 1, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004));
        TOP = new FeedPicDecorationDirection("TOP", 1, 2, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        RIGHT = new FeedPicDecorationDirection("RIGHT", 2, 4, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004));
        BOTTOM = new FeedPicDecorationDirection("BOTTOM", 3, 8, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        MIDDLE = new FeedPicDecorationDirection("MIDDLE", 4, 16, 0);
        $VALUES = $values();
    }

    public FeedPicDecorationDirection(String str, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.direction = i2;
        this.marginValue = i3;
    }

    public final int getDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.direction;
        }
        return invokeV.intValue;
    }

    public final int getMarginValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.marginValue;
        }
        return invokeV.intValue;
    }
}
