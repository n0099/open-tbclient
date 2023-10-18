package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.ad;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.producers.ProducerConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
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
    public boolean isHeif;
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

    @Override // com.baidu.tbadk.album.MediaFileInfo
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public ImageFileInfo() {
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
        this.mCount = 0;
        this.mImageType = 0;
        this.isFromMoreForum = false;
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
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (linkedList = this.pageActionsList) != null) {
            linkedList.clear();
            this._cacheKey_all = null;
            this._cacheKey_page = null;
        }
    }

    public String getAlbumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.albumId;
        }
        return (String) invokeV.objValue;
    }

    public String getContentUriStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.contentUriStr;
        }
        return (String) invokeV.objValue;
    }

    public String getExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.extra;
        }
        return (String) invokeV.objValue;
    }

    public String getFilePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.filePath;
        }
        return (String) invokeV.objValue;
    }

    public int getImageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mImageType;
        }
        return invokeV.intValue;
    }

    public String getModifyTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.modifyTime;
        }
        return (String) invokeV.objValue;
    }

    public Bitmap getOrginalBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.orginalBitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    public LinkedList<ImageOperation> getPageActionsList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.pageActionsList;
        }
        return (LinkedList) invokeV.objValue;
    }

    public LinkedList<ImageOperation> getPersistActionsList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.persistActionsList;
        }
        return (LinkedList) invokeV.objValue;
    }

    public String getServerImageCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.serverImageCode;
        }
        return (String) invokeV.objValue;
    }

    public String getTempUploadFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.tempUploadFileName;
        }
        return (String) invokeV.objValue;
    }

    public boolean isAlreadyUploadedToServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return !ad.isEmpty(this.serverImageCode);
        }
        return invokeV.booleanValue;
    }

    public boolean isFromCamera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.isFromCamera;
        }
        return invokeV.booleanValue;
    }

    public boolean isGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.isGif;
        }
        return invokeV.booleanValue;
    }

    public boolean isHasAddPostQualityAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.hasAddPostQualityAction;
        }
        return invokeV.booleanValue;
    }

    public boolean isHeif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.isHeif;
        }
        return invokeV.booleanValue;
    }

    public boolean isLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.isLong;
        }
        return invokeV.booleanValue;
    }

    public boolean isOrginalBitmapShared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.isOrginalBitmapShared;
        }
        return invokeV.booleanValue;
    }

    public boolean isTempFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.isTempFile;
        }
        return invokeV.booleanValue;
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

    public void setAlbumnId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.albumId = str;
        }
    }

    public void setContentUriStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.contentUriStr = str;
        }
    }

    public void setExtra(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.extra = str;
        }
    }

    public void setFilePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.filePath = str;
        }
    }

    public void setHasAddPostQualityAction(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.hasAddPostQualityAction = z;
        }
    }

    public void setImageType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.mImageType = i;
        }
    }

    public void setIsFromCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.isFromCamera = z;
        }
    }

    public void setIsGif(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.isGif = z;
        }
    }

    public void setIsHeif(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.isHeif = z;
        }
    }

    public void setIsLong(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.isLong = z;
        }
    }

    public void setModifyTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.modifyTime = str;
        }
    }

    public void setPageActionsList(LinkedList<ImageOperation> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, linkedList) == null) {
            this.pageActionsList = linkedList;
            this._cacheKey_all = null;
            this._cacheKey_page = null;
        }
    }

    public void setPersistActionsList(LinkedList<ImageOperation> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, linkedList) == null) {
            this.persistActionsList = linkedList;
            this._cacheKey_all = null;
            this._cacheKey_page = null;
        }
    }

    public void setServerImageCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.serverImageCode = str;
        }
    }

    public void setTempFile(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.isTempFile = z;
        }
    }

    public void setTempUploadFileName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.tempUploadFileName = str;
        }
    }

    public void applayRotatePageActionToPersistAction(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imageFileInfo) == null) && getPageActionsList() != null) {
            Iterator<ImageOperation> it = getPageActionsList().iterator();
            while (it.hasNext()) {
                ImageOperation next = it.next();
                if ("rotate".equals(next.actionName)) {
                    if (imageFileInfo != null) {
                        imageFileInfo.setIsGif(false);
                    }
                    addPersistAction(next);
                }
            }
        }
    }

    public boolean hasActions(boolean z) {
        InterceptResult invokeZ;
        LinkedList<ImageOperation> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            if (this.persistActionsList == null && this.pageActionsList == null) {
                return false;
            }
            if (z && (linkedList = this.persistActionsList) != null && !linkedList.isEmpty()) {
                return true;
            }
            LinkedList<ImageOperation> linkedList2 = this.pageActionsList;
            if (linkedList2 == null) {
                return false;
            }
            return !linkedList2.isEmpty();
        }
        return invokeZ.booleanValue;
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
                    if (!"filter".equals(next.actionName) && (!z || !"resize".equals(next.actionName))) {
                        imageFileInfo.addPageAction(next);
                    }
                }
            }
            if (getPersistActionsList() != null) {
                Iterator<ImageOperation> it2 = getPersistActionsList().iterator();
                while (it2.hasNext()) {
                    ImageOperation next2 = it2.next();
                    if (!"filter".equals(next2.actionName) && (!z || !"resize".equals(next2.actionName))) {
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

    public ImageFileInfo parseJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return this;
            }
            this.filePath = jSONObject.optString("filePath", "");
            this.extra = jSONObject.optString("extra", "");
            this.albumId = jSONObject.optString("albumId", null);
            this.contentUriStr = jSONObject.optString("contentUriStr", null);
            this.isTempFile = jSONObject.optBoolean("isTempFile", false);
            this.serverImageCode = jSONObject.optString("serverImageCode", null);
            this.modifyTime = jSONObject.optString("modifyTime");
            JSONArray optJSONArray = jSONObject.optJSONArray("actionsList");
            this.persistActionsList = new LinkedList<>();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    ImageOperation imageOperation = new ImageOperation();
                    imageOperation.parseJson(optJSONArray.optJSONObject(i));
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
            this.isHeif = jSONObject.optBoolean("isHeif", false);
            this.isFromCamera = jSONObject.optBoolean("isFromCamera", false);
            this.mImageType = jSONObject.optInt(ProducerConstants.EXTRA_IMAGE_TYPE, 0);
            return this;
        }
        return (ImageFileInfo) invokeL.objValue;
    }

    public boolean hasActionsWithoutResize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
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

    public void setOrginalBitmap(Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048616, this, bitmap, z) == null) {
            this.orginalBitmap = bitmap;
            this.isOrginalBitmapShared = z;
        }
    }

    public String toCachedKey(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048622, this, z)) == null) {
            if (getImageType() == 1) {
                return BdResourceLoader.getInstance().genCacheKey(this.filePath, 20);
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
                                sb.append('=');
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
                                sb.append('=');
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
                    for (int i = 0; i < this.pageActionsList.size(); i++) {
                        ImageOperation imageOperation = this.pageActionsList.get(i);
                        sb2.append(':');
                        sb2.append(imageOperation.actionName);
                        sb2.append('=');
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
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
                    for (int i = 0; i < this.persistActionsList.size(); i++) {
                        jSONArray.put(this.persistActionsList.get(i).toJson());
                    }
                    jSONObject.put("actionsList", jSONArray);
                }
                jSONObject.put("hasAddPostQualityAction", this.hasAddPostQualityAction);
                if (this.serverPicInfo != null) {
                    jSONObject.put("serverPicInfo", this.serverPicInfo.toJson());
                }
                jSONObject.put("isGif", this.isGif);
                jSONObject.put("isLong", this.isLong);
                jSONObject.put("isHeif", this.isHeif);
                jSONObject.put("isFromCamera", this.isFromCamera);
                jSONObject.put(ProducerConstants.EXTRA_IMAGE_TYPE, this.mImageType);
                jSONObject.put("extra", this.extra);
                return jSONObject;
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
