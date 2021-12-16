package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.l.d;
import c.a.d.f.p.l;
import com.alipay.sdk.encrypt.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.producers.ProducerConstants;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ImageFileInfo extends MediaFileInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IMAGE_TYPE_EMOTION = 1;
    public static final int IMAGE_TYPE_NORMAL = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public String _cacheKey_all;
    public String _cacheKey_page;
    public String albumId;
    public String contentUriStr;
    public String extra;
    public String filePath;
    public boolean hasAddPostQualityAction;
    public int height;
    public boolean isFromCamera;
    public boolean isFromMoreForum;
    public boolean isGif;
    public boolean isLong;
    public boolean isOrginalBitmapShared;
    public boolean isTempFile;
    public int mCount;
    public int mImageType;
    public String modifyTime;
    public Bitmap orginalBitmap;
    public LinkedList<ImageOperation> pageActionsList;
    public LinkedList<ImageOperation> persistActionsList;
    public String serverImageCode;
    public ImageUploadResult.picInfo serverPicInfo;
    public transient long startUploadTime;
    public String tempUploadFileName;
    public int width;

    public ImageFileInfo() {
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
        this.mCount = 0;
        this.mImageType = 0;
        this.isFromMoreForum = false;
    }

    public void addPageAction(ImageOperation imageOperation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, imageOperation) == null) {
            if (this.pageActionsList == null) {
                this.pageActionsList = new LinkedList<>();
            }
            this.pageActionsList.add(imageOperation);
            this._cacheKey_all = null;
            this._cacheKey_page = null;
        }
    }

    public void addPersistAction(ImageOperation imageOperation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageOperation) == null) {
            if (this.persistActionsList == null) {
                this.persistActionsList = new LinkedList<>();
            }
            this.persistActionsList.add(imageOperation);
            this.serverImageCode = null;
            this._cacheKey_all = null;
            this._cacheKey_page = null;
        }
    }

    public void applayRotatePageActionToPersistAction(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imageFileInfo) == null) || getPageActionsList() == null) {
            return;
        }
        Iterator<ImageOperation> it = getPageActionsList().iterator();
        while (it.hasNext()) {
            ImageOperation next = it.next();
            if (AnimationProperty.ROTATE.equals(next.actionName)) {
                if (imageFileInfo != null) {
                    imageFileInfo.setIsGif(false);
                }
                addPersistAction(next);
            }
        }
    }

    public void clearAllActions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LinkedList<ImageOperation> linkedList = this.persistActionsList;
            if (linkedList != null) {
                linkedList.clear();
                this.serverImageCode = null;
            }
            LinkedList<ImageOperation> linkedList2 = this.pageActionsList;
            if (linkedList2 != null) {
                linkedList2.clear();
            }
            this._cacheKey_all = null;
            this._cacheKey_page = null;
        }
    }

    public void clearPageActions() {
        LinkedList<ImageOperation> linkedList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (linkedList = this.pageActionsList) == null) {
            return;
        }
        linkedList.clear();
        this._cacheKey_all = null;
        this._cacheKey_page = null;
    }

    public ImageFileInfo cloneWithoutFilterAction(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(getFilePath());
            imageFileInfo.setContentUriStr(getContentUriStr());
            imageFileInfo.setModifyTime(getModifyTime());
            if (getPageActionsList() != null) {
                Iterator<ImageOperation> it = getPageActionsList().iterator();
                while (it.hasNext()) {
                    ImageOperation next = it.next();
                    if (!CloudControlRequest.REQUEST_KEY_FILTER.equals(next.actionName) && (!z || !"resize".equals(next.actionName))) {
                        imageFileInfo.addPageAction(next);
                    }
                }
            }
            if (getPersistActionsList() != null) {
                Iterator<ImageOperation> it2 = getPersistActionsList().iterator();
                while (it2.hasNext()) {
                    ImageOperation next2 = it2.next();
                    if (!CloudControlRequest.REQUEST_KEY_FILTER.equals(next2.actionName) && (!z || !"resize".equals(next2.actionName))) {
                        imageFileInfo.addPageAction(next2);
                    }
                }
            }
            imageFileInfo.setIsGif(isGif());
            imageFileInfo.setIsLong(isLong());
            imageFileInfo.setIsFromCamera(isFromCamera());
            imageFileInfo.setImageType(getImageType());
            return imageFileInfo;
        }
        return (ImageFileInfo) invokeZ.objValue;
    }

    public String getAlbumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.albumId : (String) invokeV.objValue;
    }

    public String getContentUriStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.contentUriStr : (String) invokeV.objValue;
    }

    public String getFilePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.filePath : (String) invokeV.objValue;
    }

    public int getImageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mImageType : invokeV.intValue;
    }

    public String getModifyTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.modifyTime : (String) invokeV.objValue;
    }

    public Bitmap getOrginalBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.orginalBitmap : (Bitmap) invokeV.objValue;
    }

    public LinkedList<ImageOperation> getPageActionsList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.pageActionsList : (LinkedList) invokeV.objValue;
    }

    public LinkedList<ImageOperation> getPersistActionsList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.persistActionsList : (LinkedList) invokeV.objValue;
    }

    public String getServerImageCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.serverImageCode : (String) invokeV.objValue;
    }

    public String getTempUploadFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.tempUploadFileName : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.album.MediaFileInfo
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean hasActions(boolean z) {
        InterceptResult invokeZ;
        LinkedList<ImageOperation> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            if (this.persistActionsList == null && this.pageActionsList == null) {
                return false;
            }
            if (!z || (linkedList = this.persistActionsList) == null || linkedList.isEmpty()) {
                LinkedList<ImageOperation> linkedList2 = this.pageActionsList;
                if (linkedList2 == null) {
                    return false;
                }
                return !linkedList2.isEmpty();
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean hasActionsWithoutResize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.persistActionsList == null && this.pageActionsList == null) {
                return false;
            }
            LinkedList<ImageOperation> linkedList = this.persistActionsList;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator<ImageOperation> it = this.persistActionsList.iterator();
                while (it.hasNext()) {
                    if (!"resize".equals(it.next().actionName)) {
                        return true;
                    }
                }
            }
            LinkedList<ImageOperation> linkedList2 = this.pageActionsList;
            if (linkedList2 != null && !linkedList2.isEmpty()) {
                Iterator<ImageOperation> it2 = this.pageActionsList.iterator();
                while (it2.hasNext()) {
                    if (!"resize".equals(it2.next().actionName)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isAlreadyUploadedToServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? !l.isEmpty(this.serverImageCode) : invokeV.booleanValue;
    }

    public boolean isFromCamera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.isFromCamera : invokeV.booleanValue;
    }

    public boolean isGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.isGif : invokeV.booleanValue;
    }

    public boolean isHasAddPostQualityAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.hasAddPostQualityAction : invokeV.booleanValue;
    }

    public boolean isLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.isLong : invokeV.booleanValue;
    }

    public boolean isOrginalBitmapShared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.isOrginalBitmapShared : invokeV.booleanValue;
    }

    public boolean isTempFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.isTempFile : invokeV.booleanValue;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.filePath = jSONObject.optString("filePath", "");
        this.albumId = jSONObject.optString("albumId", null);
        this.contentUriStr = jSONObject.optString("contentUriStr", null);
        this.isTempFile = jSONObject.optBoolean("isTempFile", false);
        this.serverImageCode = jSONObject.optString("serverImageCode", null);
        this.modifyTime = jSONObject.optString("modifyTime");
        JSONArray optJSONArray = jSONObject.optJSONArray("actionsList");
        this.persistActionsList = new LinkedList<>();
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                ImageOperation imageOperation = new ImageOperation();
                imageOperation.parseJson(optJSONArray.optJSONObject(i2));
                this.persistActionsList.add(imageOperation);
            }
        }
        this.hasAddPostQualityAction = jSONObject.optBoolean("hasAddPostQualityAction", false);
        this._cacheKey_all = null;
        this._cacheKey_page = null;
        ImageUploadResult.picInfo picinfo = new ImageUploadResult.picInfo();
        this.serverPicInfo = picinfo;
        picinfo.parseJson(jSONObject.optJSONObject("serverPicInfo"));
        this.isGif = jSONObject.optBoolean("isGif", false);
        this.isLong = jSONObject.optBoolean("isLong", false);
        this.isFromCamera = jSONObject.optBoolean("isFromCamera", false);
        this.mImageType = jSONObject.optInt(ProducerConstants.EXTRA_IMAGE_TYPE, 0);
    }

    public void setAlbumnId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.albumId = str;
        }
    }

    public void setContentUriStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.contentUriStr = str;
        }
    }

    public void setFilePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.filePath = str;
        }
    }

    public void setHasAddPostQualityAction(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.hasAddPostQualityAction = z;
        }
    }

    public void setImageType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.mImageType = i2;
        }
    }

    public void setIsFromCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.isFromCamera = z;
        }
    }

    public void setIsGif(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.isGif = z;
        }
    }

    public void setIsLong(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.isLong = z;
        }
    }

    public void setModifyTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.modifyTime = str;
        }
    }

    public void setOrginalBitmap(Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048612, this, bitmap, z) == null) {
            this.orginalBitmap = bitmap;
            this.isOrginalBitmapShared = z;
        }
    }

    public void setPageActionsList(LinkedList<ImageOperation> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, linkedList) == null) {
            this.pageActionsList = linkedList;
            this._cacheKey_all = null;
            this._cacheKey_page = null;
        }
    }

    public void setPersistActionsList(LinkedList<ImageOperation> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, linkedList) == null) {
            this.persistActionsList = linkedList;
            this._cacheKey_all = null;
            this._cacheKey_page = null;
        }
    }

    public void setServerImageCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.serverImageCode = str;
        }
    }

    public void setTempFile(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.isTempFile = z;
        }
    }

    public void setTempUploadFileName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.tempUploadFileName = str;
        }
    }

    public String toCachedKey(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048618, this, z)) == null) {
            if (getImageType() == 1) {
                return d.h().g(this.filePath, 20);
            }
            if (z) {
                if (this._cacheKey_all == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("persist_");
                    sb.append(this.filePath);
                    if (ListUtils.getCount(this.persistActionsList) > 0) {
                        Iterator<ImageOperation> it = this.persistActionsList.iterator();
                        while (it.hasNext()) {
                            ImageOperation next = it.next();
                            if (next != null) {
                                sb.append(':');
                                sb.append(next.actionName);
                                sb.append(a.f31721h);
                                sb.append(next.actionParam);
                            }
                        }
                    }
                    if (ListUtils.getCount(this.pageActionsList) > 0) {
                        Iterator<ImageOperation> it2 = this.pageActionsList.iterator();
                        while (it2.hasNext()) {
                            ImageOperation next2 = it2.next();
                            if (next2 != null) {
                                sb.append(':');
                                sb.append(next2.actionName);
                                sb.append(a.f31721h);
                                sb.append(next2.actionParam);
                            }
                        }
                    }
                    this._cacheKey_all = sb.toString();
                }
                return this._cacheKey_all;
            }
            if (this._cacheKey_page == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("page_");
                sb2.append(this.filePath);
                if (this.pageActionsList != null) {
                    for (int i2 = 0; i2 < this.pageActionsList.size(); i2++) {
                        ImageOperation imageOperation = this.pageActionsList.get(i2);
                        sb2.append(':');
                        sb2.append(imageOperation.actionName);
                        sb2.append(a.f31721h);
                        sb2.append(imageOperation.actionParam);
                    }
                }
                this._cacheKey_page = sb2.toString();
            }
            return this._cacheKey_page;
        }
        return (String) invokeZ.objValue;
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("filePath", this.filePath);
                if (this.albumId != null) {
                    jSONObject.put("albumId", this.albumId);
                }
                if (!TextUtils.isEmpty(this.contentUriStr)) {
                    jSONObject.put("contentUriStr", this.contentUriStr);
                }
                jSONObject.put("isTempFile", this.isTempFile);
                if (this.serverImageCode != null) {
                    jSONObject.put("serverImageCode", this.serverImageCode);
                }
                if (!StringUtils.isNull(this.modifyTime)) {
                    jSONObject.put("modifyTime", this.modifyTime);
                }
                if (this.persistActionsList != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i2 = 0; i2 < this.persistActionsList.size(); i2++) {
                        jSONArray.put(this.persistActionsList.get(i2).toJson());
                    }
                    jSONObject.put("actionsList", jSONArray);
                }
                jSONObject.put("hasAddPostQualityAction", this.hasAddPostQualityAction);
                if (this.serverPicInfo != null) {
                    jSONObject.put("serverPicInfo", this.serverPicInfo.toJson());
                }
                jSONObject.put("isGif", this.isGif);
                jSONObject.put("isLong", this.isLong);
                jSONObject.put("isFromCamera", this.isFromCamera);
                jSONObject.put(ProducerConstants.EXTRA_IMAGE_TYPE, this.mImageType);
                return jSONObject;
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
