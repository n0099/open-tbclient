package com.baidu.tbadk.img;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tieba.bc5;
import com.baidu.tieba.gj;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UploadedImageInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MD5_EMOTION_FORMAT = "meme,%s,%d,%d,%s";
    public static final String MD5_KEY = "7S6wbXjEKL9N";
    public static final String POST_BJH_FORMAT = "#(pic_bos,%s,%d,%d,%b)";
    public static final String POST_EMOTION_FORMAT = "#(meme,%s,%d,%d,%s,%s)";
    public static final String POST_FORMAT = "#(pic,%s,%d,%d)";
    public transient /* synthetic */ FieldHolder $fh;
    public int height;
    public boolean isBJH;
    public boolean isGif;
    public String pic_id;
    @Nullable
    public String sharpText;
    public int width;

    public UploadedImageInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pic_id = null;
        this.width = 0;
        this.height = 0;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.height;
        }
        return invokeV.intValue;
    }

    public String getPic_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.pic_id;
        }
        return (String) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.width;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return toPostString();
        }
        return (String) invokeV.objValue;
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void setHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.height = i;
        }
    }

    public void setPic_id(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.pic_id = str;
        }
    }

    public void setSharpText(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.sharpText = str;
        }
    }

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.width = i;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            this.pic_id = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
            this.width = jSONObject.optInt("width", 0);
            this.height = jSONObject.optInt("height", 0);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @SuppressLint({"DefaultLocale"})
    public String toPostString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.pic_id != null) {
                if (!TextUtils.isEmpty(this.sharpText)) {
                    return String.format(POST_EMOTION_FORMAT, this.pic_id, Integer.valueOf(this.width), Integer.valueOf(this.height), gj.c(String.format(MD5_EMOTION_FORMAT, this.pic_id, Integer.valueOf(this.width), Integer.valueOf(this.height), MD5_KEY)).toLowerCase(), bc5.b.b(this.sharpText));
                }
                if (this.isBJH) {
                    return String.format(POST_BJH_FORMAT, this.pic_id, Integer.valueOf(this.width), Integer.valueOf(this.height), Boolean.valueOf(this.isGif));
                }
                return String.format(POST_FORMAT, this.pic_id, Integer.valueOf(this.width), Integer.valueOf(this.height));
            }
            return "";
        }
        return (String) invokeV.objValue;
    }
}
