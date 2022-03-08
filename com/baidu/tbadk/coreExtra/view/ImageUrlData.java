package com.baidu.tbadk.coreExtra.view;

import android.graphics.Rect;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class ImageUrlData extends OrmObject implements Serializable, Comparable<ImageUrlData> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IMAGE_TYPE_CHUDIAN = 1;
    public static final long serialVersionUID = 2037469186418617574L;
    public transient /* synthetic */ FieldHolder $fh;
    public AgreeData agreeData;
    public String commentNum;
    public String forumId;
    public String forumName;
    public String from;
    public String id;
    public String imageUrl;
    public boolean isBlockedPic;
    public boolean isFirstPost;
    public boolean isLongPic;
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
    public long postId;
    public String qrInfo;
    public String richTextArray;
    public long threadId;
    public int urlType;
    public String userId;
    public String userNameShow;

    public ImageUrlData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
    }

    public Rect getDstRectInScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (StringUtils.isNull(this.mSourceImageRectInScreenStr)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(this.mSourceImageRectInScreenStr);
                if (jSONArray.length() == 8) {
                    return new Rect(((Integer) jSONArray.get(4)).intValue(), ((Integer) jSONArray.get(5)).intValue(), ((Integer) jSONArray.get(6)).intValue(), ((Integer) jSONArray.get(7)).intValue());
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Rect) invokeV.objValue;
    }

    public Rect getSourceImageRectInScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (StringUtils.isNull(this.mSourceImageRectInScreenStr)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(this.mSourceImageRectInScreenStr);
                if (jSONArray.length() == 8) {
                    return new Rect(((Integer) jSONArray.get(0)).intValue(), ((Integer) jSONArray.get(1)).intValue(), ((Integer) jSONArray.get(2)).intValue(), ((Integer) jSONArray.get(3)).intValue());
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Rect) invokeV.objValue;
    }

    public void setSourceImageRectInScreen(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || str == null) {
            return;
        }
        this.mSourceImageRectInScreenStr = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(ImageUrlData imageUrlData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageUrlData)) == null) ? (int) (this.overAllIndex - imageUrlData.overAllIndex) : invokeL.intValue;
    }
}
