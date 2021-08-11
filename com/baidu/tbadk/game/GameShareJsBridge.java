package com.baidu.tbadk.game;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GameShareJsBridge {
    public static /* synthetic */ Interceptable $ic;
    public static GameShareJsBridge g_instance;
    public transient /* synthetic */ FieldHolder $fh;
    public String mGameId;
    public String mIconUrl;
    public String mShareContent;
    public String mShareContentUrl;
    public String mShareImage;
    public String mShareName;
    public String mShareTitle;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-128906954, "Lcom/baidu/tbadk/game/GameShareJsBridge;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-128906954, "Lcom/baidu/tbadk/game/GameShareJsBridge;");
        }
    }

    public GameShareJsBridge() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static GameShareJsBridge getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (g_instance == null) {
                g_instance = new GameShareJsBridge();
            }
            return g_instance;
        }
        return (GameShareJsBridge) invokeV.objValue;
    }

    public String getGameId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mGameId : (String) invokeV.objValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mIconUrl : (String) invokeV.objValue;
    }

    public String getShareContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mShareContent : (String) invokeV.objValue;
    }

    public String getShareContentUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mShareContentUrl : (String) invokeV.objValue;
    }

    public String getShareImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mShareImage : (String) invokeV.objValue;
    }

    public String getShareName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mShareName : (String) invokeV.objValue;
    }

    public String getShareTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mShareTitle : (String) invokeV.objValue;
    }

    public void set_share_info(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.mShareTitle = String.valueOf(jSONObject.opt("title"));
                this.mShareContent = String.valueOf(jSONObject.opt("content"));
                this.mIconUrl = String.valueOf(jSONObject.opt("app_icon"));
                this.mShareContentUrl = String.valueOf(jSONObject.opt("app_link"));
                this.mShareImage = String.valueOf(jSONObject.opt("img"));
                this.mShareName = String.valueOf(jSONObject.opt("app_name"));
                this.mGameId = String.valueOf(jSONObject.opt("app_key"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void startShare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mShareContent = null;
            this.mShareTitle = null;
            this.mShareContentUrl = null;
            this.mIconUrl = null;
            this.mGameId = null;
            this.mShareImage = null;
            this.mShareName = null;
        }
    }
}
