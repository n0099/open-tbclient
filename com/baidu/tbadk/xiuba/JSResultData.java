package com.baidu.tbadk.xiuba;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class JSResultData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUTH_KEY = "Bk87E*iWaZ4ORmQrCxVGOq+]-i!S*v";
    public static final int DOWNLOAD_FAIL = 0;
    public static final int DOWNLOAD_FINISH = 2;
    public static final int DOWNLOAD_START = 1;
    public static final String ERRORCODE_NO = "0";
    public static final String ERRORMSG_NO = "";
    public static final int INSTALL_SUCCESS = 1;
    public static final int IN_INSTALL_NO = 0;
    public static final int IN_INSTALL_YES = 1;
    public static final int STATUS_FAIL = 0;
    public static final int STATUS_SUCCESS = 1;
    public static final long serialVersionUID = -3999492409273265508L;
    public transient /* synthetic */ FieldHolder $fh;
    public String errorCode;
    public String errorMsg;
    public Result result;
    public int status;

    /* loaded from: classes5.dex */
    public static final class Result extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 678301888552831958L;
        public transient /* synthetic */ FieldHolder $fh;
        public String apkVersion;
        public int download;
        public int install;
        public int isInstall;

        public Result() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String getApkVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.apkVersion : (String) invokeV.objValue;
        }

        public int getDownload() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.download : invokeV.intValue;
        }

        public int getInstall() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.install : invokeV.intValue;
        }

        public int getIsInstall() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isInstall : invokeV.intValue;
        }

        public void setApkVersion(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.apkVersion = str;
            }
        }

        public void setDownload(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                this.download = i2;
            }
        }

        public void setInstall(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.install = i2;
            }
        }

        public void setIsInstall(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
                this.isInstall = i2;
            }
        }
    }

    public JSResultData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.errorCode : (String) invokeV.objValue;
    }

    public String getErrorMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.errorMsg : (String) invokeV.objValue;
    }

    public Result getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.result : (Result) invokeV.objValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.status : invokeV.intValue;
    }

    public void setErrorCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.errorCode = str;
        }
    }

    public void setErrorMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.errorMsg = str;
        }
    }

    public void setResult(Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, result) == null) {
            this.result = result;
        }
    }

    public void setStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.status = i2;
        }
    }
}
