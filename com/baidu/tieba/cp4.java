package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ss2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cp4 extends ap4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ap4, com.baidu.tieba.gq2
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ap4, com.baidu.tieba.gq2
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tieba.gq2
    public void N(ZeusPluginFactory.Invoker invoker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, invoker) == null) {
        }
    }

    @Override // com.baidu.tieba.ap4, com.baidu.tieba.gq2
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.baidu.tieba.gq2
    public ZeusPluginFactory.Invoker e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (ZeusPluginFactory.Invoker) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ap4, com.baidu.tieba.gq2
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp4(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invoker, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ZeusPluginFactory.Invoker) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ap4
    public void B0(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
            try {
                JSONObject I0 = I0();
                JSONObject J0 = J0();
                J0.put(ShareLoginStat.MakeShareLoginStat.KEY_ERRNO, i);
                J0.put("sub_errorNo", i2);
                J0.put("errorInfo", str);
                I0.put("ext", J0.toString());
                bn4.l("36", I0);
            } catch (Exception e) {
                if (ap4.x) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.tieba.ap4
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                JSONObject I0 = I0();
                I0.put("type", "first_frame");
                I0.put("ext", J0().toString());
                bn4.l(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_SUCCESS, I0);
            } catch (Exception e) {
                if (ap4.x) {
                    e.printStackTrace();
                }
            }
        }
    }

    @NonNull
    public final JSONObject I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "video");
                jSONObject.put("network", SwanAppNetworkUtils.e());
            } catch (Exception e) {
                if (ap4.x) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @NonNull
    public final JSONObject J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext_from", "aiapp");
                jSONObject.put("appid", v73.g0());
                jSONObject.put("url", this.b);
                jSONObject.put(TiebaStatic.Params.VID, this.b);
                jSONObject.put("isInline", true);
                String str = "";
                v73 M = v73.M();
                if (M != null) {
                    if (M.w0()) {
                        str = SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
                    } else {
                        str = "swan";
                    }
                    ss2.a Y = M.Y();
                    if (Y != null && Y.u1() > 0) {
                        jSONObject.put("ext_start", Y.u1());
                    }
                }
                jSONObject.put("ext_page", str);
            } catch (Exception e) {
                if (ap4.x) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
