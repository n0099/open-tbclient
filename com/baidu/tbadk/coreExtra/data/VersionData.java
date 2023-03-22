package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.unitedscheme.SchemeDescPatchListener;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.gi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class VersionData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FORCE_UPDATE = 1;
    public static final int HAS_NEW_VERSION = 1;
    public static final long serialVersionUID = 5102616316349188013L;
    public transient /* synthetic */ FieldHolder $fh;
    public String apkMD5RSA;
    public String asApkMD5RSA;
    public String asDownloadUrl;
    public String clientId;
    public int forceUpdate;
    public int hasNewVer;
    public boolean isOfficialVersion;
    public String newFile;
    public String newVer;
    public int newVersionCode;
    public String newVersionDesc;
    public int newVersionRemind;
    public String patch;
    public String patchSize;
    public String size;
    public int strategy;
    public String tiebaIconUrl;
    public String url;

    public VersionData() {
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
        this.forceUpdate = 0;
        this.strategy = 0;
        this.hasNewVer = 0;
        this.newVer = null;
        this.url = null;
        this.clientId = null;
        this.newFile = null;
        this.newVersionCode = -1;
        this.tiebaIconUrl = null;
        this.asDownloadUrl = null;
        this.apkMD5RSA = null;
        this.asApkMD5RSA = null;
    }

    private boolean hasNewVersion() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.newVersionRemind == 1 && (str = this.url) != null && URLUtil.isNetworkUrl(str) && !TextUtils.isEmpty(this.apkMD5RSA) && this.newVer != null && !TbConfig.getVersion().equalsIgnoreCase(this.newVer)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean forceUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.forceUpdate == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getApkMD5RSA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.apkMD5RSA;
        }
        return (String) invokeV.objValue;
    }

    public String getAsApkMD5RSA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.asApkMD5RSA;
        }
        return (String) invokeV.objValue;
    }

    public String getAsDownloadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.asDownloadUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getClientId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.clientId;
        }
        return (String) invokeV.objValue;
    }

    public String getNewFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.newFile;
        }
        return (String) invokeV.objValue;
    }

    public String getNewVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.newVer;
        }
        return (String) invokeV.objValue;
    }

    public int getNewVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.newVersionCode;
        }
        return invokeV.intValue;
    }

    public String getNewVersionDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.newVersionDesc;
        }
        return (String) invokeV.objValue;
    }

    public String getPatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.patch;
        }
        return (String) invokeV.objValue;
    }

    public String getPatchSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.patchSize;
        }
        return (String) invokeV.objValue;
    }

    public String getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.size;
        }
        return (String) invokeV.objValue;
    }

    public int getStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.strategy;
        }
        return invokeV.intValue;
    }

    public String getTiebaIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.tiebaIconUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.url;
        }
        return (String) invokeV.objValue;
    }

    public boolean hasNewVer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.hasNewVer == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isOfficialVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.isOfficialVersion;
        }
        return invokeV.booleanValue;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            boolean z = false;
            this.forceUpdate = jSONObject.optInt("force_update", 0);
            this.strategy = jSONObject.optInt("strategy", 0);
            this.newVer = jSONObject.optString("new_version", null);
            this.size = jSONObject.optString("size", null);
            String optString = jSONObject.optString("new_four_version", null);
            if (!gi.isEmpty(optString)) {
                this.newVer = optString;
            }
            this.url = jSONObject.optString("new_version_url");
            this.newVersionRemind = jSONObject.optInt("new_version_remind", 0);
            this.newVersionDesc = jSONObject.optString("new_version_desc", null);
            this.patch = jSONObject.optString(SchemeDescPatchListener.PATCH);
            this.patchSize = jSONObject.optString("patch_size");
            this.newVersionCode = jSONObject.optInt("new_version_code", -1);
            this.tiebaIconUrl = jSONObject.optString("tieba_iconurl", null);
            this.asDownloadUrl = jSONObject.optString("as_downloadurl", null);
            this.apkMD5RSA = jSONObject.optString("apk_MD5_RSA", null);
            this.asApkMD5RSA = jSONObject.optString("as_apk_MD5_RSA", null);
            if (jSONObject.optInt("android_is_official_version", 0) == 1) {
                z = true;
            }
            this.isOfficialVersion = z;
            if (hasNewVersion()) {
                this.hasNewVer = 1;
                this.newFile = "tieba_" + this.newVer + Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void setApkMD5RSA(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.apkMD5RSA = str;
        }
    }

    public void setForceUpdate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.forceUpdate = i;
        }
    }

    public void setHasNewVer(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.hasNewVer = i;
        }
    }

    public void setNewFile(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.newFile = str;
        }
    }

    public void setNewVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.newVer = str;
        }
    }

    public void setNewVersionCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.newVersionCode = i;
        }
    }

    public void setNewVersionDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.newVersionDesc = str;
        }
    }

    public void setPatch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.patch = str;
        }
    }

    public void setPatchSize(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.patchSize = str;
        }
    }

    public void setSize(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.size = str;
        }
    }

    public void setStrategy(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.strategy = i;
        }
    }

    public void setTiebaIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.tiebaIconUrl = str;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.url = str;
        }
    }
}
