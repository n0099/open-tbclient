package com.baidu.tbadk.coreExtra.view;

import android.graphics.Rect;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.FaceGroupInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ImageUrlData extends OrmObject implements Serializable, Comparable<ImageUrlData> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IMAGE_TYPE_CHUDIAN = 1;
    public static final long serialVersionUID = 2037469186418617574L;
    public transient /* synthetic */ FieldHolder $fh;
    public AgreeData agreeData;
    public AlaInfoData alaInfoData;
    public String commentNum;
    public FaceGroupInfoData faceGroupInfoData;
    public String forumId;
    public String forumName;
    public String from;
    public GuideInfo guideInfo;
    public String id;
    public String imageThumbUrl;
    public String imageUrl;
    public boolean isBlockedPic;
    public boolean isFirstPost;
    public boolean isLongPic;
    public boolean liveRoomEntranceLogged;
    public int mHeigth;
    public boolean mIsReserver;
    public boolean mIsSeeHost;
    public boolean mIsShowOrigonButton;
    public int mPicType;
    public String mSourceImageRectInScreenStr;
    public String mTagName;
    public int mThreadType;
    public int mWidth;
    public String nid;
    public int originalProcess;
    public long originalSize;
    public String originalUrl;
    public long overAllIndex;
    public String picId;
    public long postId;
    public String qrInfo;
    public String richTextArray;
    public long threadId;
    public int urlThumbType;
    public int urlType;
    public String userId;
    public String userNameShow;

    /* loaded from: classes4.dex */
    public static class GuideInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int STATUS_SHOW = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String scheme;
        public int status;
        public String text;

        public GuideInfo() {
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

        public String getScheme() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.scheme;
            }
            return (String) invokeV.objValue;
        }

        public int getStatus() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.status;
            }
            return invokeV.intValue;
        }

        public String getText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.text;
            }
            return (String) invokeV.objValue;
        }

        public static GuideInfo parseJson(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                GuideInfo guideInfo = new GuideInfo();
                guideInfo.status = jSONObject.optInt("status");
                guideInfo.scheme = jSONObject.optString("scheme");
                guideInfo.text = jSONObject.optString("text");
                return guideInfo;
            }
            return (GuideInfo) invokeL.objValue;
        }

        public void setScheme(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.scheme = str;
            }
        }

        public void setStatus(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                this.status = i;
            }
        }

        public void setText(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.text = str;
            }
        }
    }

    public ImageUrlData() {
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
        this.urlThumbType = -1;
        this.mIsShowOrigonButton = true;
        this.isLongPic = false;
        this.originalSize = 0L;
        this.originalProcess = -1;
        this.forumId = null;
        this.forumName = null;
        this.threadId = -1L;
        this.postId = -1L;
        this.mIsReserver = true;
        this.mIsSeeHost = false;
        this.overAllIndex = 0L;
        this.mThreadType = 0;
        this.mPicType = 0;
        this.mTagName = "";
        this.liveRoomEntranceLogged = false;
    }

    public Rect getDstRectInScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!StringUtils.isNull(this.mSourceImageRectInScreenStr)) {
                try {
                    JSONArray jSONArray = new JSONArray(this.mSourceImageRectInScreenStr);
                    if (jSONArray.length() == 8) {
                        return new Rect(((Integer) jSONArray.get(4)).intValue(), ((Integer) jSONArray.get(5)).intValue(), ((Integer) jSONArray.get(6)).intValue(), ((Integer) jSONArray.get(7)).intValue());
                    }
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (Rect) invokeV.objValue;
    }

    public Rect getSourceImageRectInScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!StringUtils.isNull(this.mSourceImageRectInScreenStr)) {
                try {
                    JSONArray jSONArray = new JSONArray(this.mSourceImageRectInScreenStr);
                    if (jSONArray.length() == 8) {
                        return new Rect(((Integer) jSONArray.get(0)).intValue(), ((Integer) jSONArray.get(1)).intValue(), ((Integer) jSONArray.get(2)).intValue(), ((Integer) jSONArray.get(3)).intValue());
                    }
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (Rect) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(ImageUrlData imageUrlData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageUrlData)) == null) {
            return (int) (this.overAllIndex - imageUrlData.overAllIndex);
        }
        return invokeL.intValue;
    }

    public void setSourceImageRectInScreen(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || str == null) {
            return;
        }
        this.mSourceImageRectInScreenStr = str;
    }
}
