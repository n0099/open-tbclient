package com.baidu.tbadk.img;

import androidx.annotation.Nullable;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ImageUploadResult extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static int CHUNK_ERROR = 2230203;
    public static int CHUNK_FILE_ERROR = 2230204;
    public static int CHUNK_NET_ERROR = 110003;
    public static int INTER_ERROR_FILE_ERROR = -1;
    public static int INTER_ERROR_SEND_CALCELLED = -3;
    public static int INTER_ERROR_SEND_ERROR = -2;
    public transient /* synthetic */ FieldHolder $fh;
    public int chunkNo;
    public int error_code;
    public String error_msg;
    public String picId;
    public picInfo picInfo;
    public String resourceId;
    @Nullable
    public String sharpText;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-502122735, "Lcom/baidu/tbadk/img/ImageUploadResult;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-502122735, "Lcom/baidu/tbadk/img/ImageUploadResult;");
        }
    }

    /* loaded from: classes3.dex */
    public static class PicDetailedInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int height;
        public String picUrl;
        public int type;
        public int width;

        public PicDetailedInfo() {
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

        public void parseJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
                return;
            }
            this.width = jSONObject.optInt("width");
            this.height = jSONObject.optInt("height");
            this.picUrl = jSONObject.optString("picUrl");
        }

        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("width", this.width);
                    jSONObject.put("height", this.height);
                    jSONObject.put("picUrl", this.picUrl);
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class picInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PicDetailedInfo bigPic;
        public PicDetailedInfo originPic;
        public PicDetailedInfo smallPic;

        public picInfo() {
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

        public void parseJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
                return;
            }
            PicDetailedInfo picDetailedInfo = new PicDetailedInfo();
            this.bigPic = picDetailedInfo;
            picDetailedInfo.parseJson(jSONObject.optJSONObject("bigPic"));
            PicDetailedInfo picDetailedInfo2 = new PicDetailedInfo();
            this.smallPic = picDetailedInfo2;
            picDetailedInfo2.parseJson(jSONObject.optJSONObject("smallPic"));
            PicDetailedInfo picDetailedInfo3 = new PicDetailedInfo();
            this.originPic = picDetailedInfo3;
            picDetailedInfo3.parseJson(jSONObject.optJSONObject("originPic"));
        }

        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (this.bigPic != null) {
                        jSONObject.put("bigPic", this.bigPic.toJson());
                    }
                    if (this.smallPic != null) {
                        jSONObject.put("smallPic", this.smallPic.toJson());
                    }
                    if (this.originPic != null) {
                        jSONObject.put("originPic", this.originPic.toJson());
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public ImageUploadResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.error_code = 0;
        this.error_msg = null;
        this.resourceId = null;
        this.chunkNo = 0;
        this.picInfo = null;
    }

    public static ImageUploadResult parser(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            ImageUploadResult imageUploadResult = new ImageUploadResult();
            try {
                return (ImageUploadResult) OrmObject.objectWithJsonStr(str, ImageUploadResult.class);
            } catch (Exception e) {
                e.printStackTrace();
                return imageUploadResult;
            }
        }
        return (ImageUploadResult) invokeL.objValue;
    }

    public static boolean shouldReply(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i != CHUNK_ERROR && i != CHUNK_NET_ERROR && i != CHUNK_FILE_ERROR) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void setSharpText(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.sharpText = str;
        }
    }

    public UploadedImageInfo getUploadedPicInfo() {
        InterceptResult invokeV;
        PicDetailedInfo picDetailedInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.picInfo != null && this.error_code == 0) {
                UploadedImageInfo uploadedImageInfo = new UploadedImageInfo();
                uploadedImageInfo.setPic_id(String.valueOf(this.picId));
                uploadedImageInfo.setSharpText(this.sharpText);
                picInfo picinfo = this.picInfo;
                if (picinfo != null && (picDetailedInfo = picinfo.originPic) != null) {
                    uploadedImageInfo.setHeight(picDetailedInfo.height);
                    uploadedImageInfo.setWidth(this.picInfo.originPic.width);
                }
                return uploadedImageInfo;
            }
            return null;
        }
        return (UploadedImageInfo) invokeV.objValue;
    }
}
