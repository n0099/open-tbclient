package com.baidu.tbadk.download;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.filedownloader.data.ApkDownloadData;
import com.baidu.tieba.ph5;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class DownloadData implements Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FILE_DOWNLOAD_STATUS_CANCEL = 4;
    public static final int FILE_DOWNLOAD_STATUS_DOWNLOADING = 1;
    public static final int FILE_DOWNLOAD_STATUS_EXIST = 3;
    public static final int FILE_DOWNLOAD_STATUS_FAILED = 2;
    public static final int FILE_DOWNLOAD_STATUS_INIT = 5;
    public static final int FILE_DOWNLOAD_STATUS_INSTALLED = 8;
    public static final int FILE_DOWNLOAD_STATUS_PAUSE = 7;
    public static final int FILE_DOWNLOAD_STATUS_SUCEED = 0;
    public static final int FILE_DOWNLOAD_STATUS_UNDOWNLOAD = 6;
    public static final int FILE_DOWNLOAD_TYPE_ALA_IM_RECORD = 16;
    public static final int FILE_DOWNLOAD_TYPE_APP = 12;
    public static final int FILE_DOWNLOAD_TYPE_AR_RESOURCE = 20;
    public static final int FILE_DOWNLOAD_TYPE_DYNAMIC = 19;
    public static final int FILE_DOWNLOAD_TYPE_EMOYION_APCKAGE = 11;
    public static final int FILE_DOWNLOAD_TYPE_INSTALL_BACK = 21;
    public static final int FILE_DOWNLOAD_TYPE_MANGA = 14;
    public static final int FILE_DOWNLOAD_TYPE_MUSIC = 17;
    public static final int FILE_DOWNLOAD_TYPE_NORMAL = 10;
    public static final int FILE_DOWNLOAD_TYPE_NOVEL = 15;
    public static final int FILE_DOWNLOAD_TYPE_ORIGINAL_IMAGE = 13;
    public static final int FILE_DOWNLOAD_TYPE_PENDANT = 18;
    public static final long serialVersionUID = 1402749061179345930L;
    public transient /* synthetic */ FieldHolder $fh;
    public String action;
    public String app_icon;
    public transient ph5 callback;
    public String check;
    public String description;
    public DownloadStaticsData downloadStaticsData;
    public int errorCode;
    public int height;
    public String id;
    public boolean isForceDownload;
    public boolean isNeedInvokeApk;
    public boolean isNeedNotify;
    public long length;
    public ApkDownloadData mApkDownloadData;
    public Object mExtraData;
    public int mSource;
    public String name;
    public int notifyId;
    public String path;
    public int position;
    public long size;
    public int status;
    public String statusMsg;
    public String[] tag;
    public int type;
    public String uniqueId;
    public String url;
    public String user_name;
    public int width;

    public DownloadData() {
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
        this.status = 5;
        this.type = 10;
        this.length = 0L;
        this.size = 1L;
        this.width = 0;
        this.height = 0;
        this.statusMsg = null;
        this.callback = null;
        this.position = 0;
        this.notifyId = 0;
        this.isNeedInvokeApk = true;
        this.isForceDownload = false;
        this.isNeedNotify = true;
    }

    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (getLength() <= 0 || getSize() <= 0) {
                return 0;
            }
            return (int) ((getLength() * 100) / getSize());
        }
        return invokeV.intValue;
    }

    public DownloadData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.status = 5;
        this.type = 10;
        this.length = 0L;
        this.size = 1L;
        this.width = 0;
        this.height = 0;
        this.statusMsg = null;
        this.callback = null;
        this.position = 0;
        this.notifyId = 0;
        this.isNeedInvokeApk = true;
        this.isForceDownload = false;
        this.isNeedNotify = true;
        this.id = str;
    }

    public DownloadData(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.status = 5;
        this.type = 10;
        this.length = 0L;
        this.size = 1L;
        this.width = 0;
        this.height = 0;
        this.statusMsg = null;
        this.callback = null;
        this.position = 0;
        this.notifyId = 0;
        this.isNeedInvokeApk = true;
        this.isForceDownload = false;
        this.isNeedNotify = true;
        this.id = str;
        this.url = str2;
    }

    public DownloadData(String str, String str2, String str3, ph5 ph5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, ph5Var};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.status = 5;
        this.type = 10;
        this.length = 0L;
        this.size = 1L;
        this.width = 0;
        this.height = 0;
        this.statusMsg = null;
        this.callback = null;
        this.position = 0;
        this.notifyId = 0;
        this.isNeedInvokeApk = true;
        this.isForceDownload = false;
        this.isNeedNotify = true;
        this.id = str;
        this.name = str2;
        this.url = str3;
        this.callback = ph5Var;
        this.status = 5;
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return (DownloadData) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
        return invokeV.objValue;
    }

    public String getAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.action;
        }
        return (String) invokeV.objValue;
    }

    public ApkDownloadData getApkDownloadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mApkDownloadData;
        }
        return (ApkDownloadData) invokeV.objValue;
    }

    public String getApp_icon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.app_icon;
        }
        return (String) invokeV.objValue;
    }

    public ph5 getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.callback;
        }
        return (ph5) invokeV.objValue;
    }

    public String getCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.check;
        }
        return (String) invokeV.objValue;
    }

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.description;
        }
        return (String) invokeV.objValue;
    }

    public DownloadStaticsData getDownloadStaticsData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.downloadStaticsData;
        }
        return (DownloadStaticsData) invokeV.objValue;
    }

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.errorCode;
        }
        return invokeV.intValue;
    }

    public Object getExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mExtraData;
        }
        return invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.height;
        }
        return invokeV.intValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.id;
        }
        return (String) invokeV.objValue;
    }

    public long getLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.length;
        }
        return invokeV.longValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.name;
        }
        return (String) invokeV.objValue;
    }

    public int getNotifyId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.notifyId;
        }
        return invokeV.intValue;
    }

    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.path;
        }
        return (String) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.position;
        }
        return invokeV.intValue;
    }

    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.size;
        }
        return invokeV.longValue;
    }

    public int getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mSource;
        }
        return invokeV.intValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.status;
        }
        return invokeV.intValue;
    }

    public String getStatusMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.statusMsg;
        }
        return (String) invokeV.objValue;
    }

    public String[] getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.tag;
        }
        return (String[]) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    public String getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.uniqueId;
        }
        return (String) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.url;
        }
        return (String) invokeV.objValue;
    }

    public String getUser_name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.user_name;
        }
        return (String) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.width;
        }
        return invokeV.intValue;
    }

    public boolean isForceDownload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.isForceDownload;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedInvokeApk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.isNeedInvokeApk;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.isNeedNotify;
        }
        return invokeV.booleanValue;
    }

    public void setAction(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.action = str;
        }
    }

    public void setApkDownloadData(ApkDownloadData apkDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, apkDownloadData) == null) {
            this.mApkDownloadData = apkDownloadData;
        }
    }

    public void setApp_icon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.app_icon = str;
        }
    }

    public void setCallback(ph5 ph5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, ph5Var) == null) {
            this.callback = ph5Var;
        }
    }

    public void setCheck(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.check = str;
        }
    }

    public void setDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.description = str;
        }
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, downloadStaticsData) == null) {
            this.downloadStaticsData = downloadStaticsData;
        }
    }

    public void setErrorCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.errorCode = i;
        }
    }

    public void setExtra(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, obj) == null) {
            this.mExtraData = obj;
        }
    }

    public void setForceDownload(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.isForceDownload = z;
        }
    }

    public void setHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.height = i;
        }
    }

    public void setId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.id = str;
        }
    }

    public void setLength(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048619, this, j) == null) {
            this.length = j;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.name = str;
        }
    }

    public void setNeedInvokeApk(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.isNeedInvokeApk = z;
        }
    }

    public void setNeedNotify(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.isNeedNotify = z;
        }
    }

    public void setNotifyId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.notifyId = i;
        }
    }

    public void setPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.path = str;
        }
    }

    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.position = i;
        }
    }

    public void setSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048626, this, j) == null) {
            this.size = j;
        }
    }

    public void setSource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            this.mSource = i;
        }
    }

    public void setStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i) == null) {
            this.status = i;
        }
    }

    public void setStatusMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.statusMsg = str;
        }
    }

    public void setTag(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, strArr) == null) {
            this.tag = strArr;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            this.type = i;
        }
    }

    public void setUniqueId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.uniqueId = str;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            this.url = str;
        }
    }

    public void setUser_name(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.user_name = str;
        }
    }

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            this.width = i;
        }
    }
}
