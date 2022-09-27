package com.baidu.tbadk.img;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tieba.dj;
import com.baidu.tieba.t85;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class WriteImagesInfo extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int allImageFileSize;
    public LinkedList<ImageFileInfo> chosedFiles;
    public int hasUploadFileSize;
    public int imageChunkRetry;
    public int imageChunkSize;
    public int imageUploadConcurrency;
    public boolean isEnableChooseOriginalImg;
    public boolean isFromQRCode;
    public boolean isOriginalImg;
    public String lastAlbumId;
    public boolean mIsFromIm;
    public int maxImagesAllowed;
    public boolean needImageParallel;
    public int originalImgIndex;
    public int originalImgViewIndex;

    public WriteImagesInfo() {
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
        this.mIsFromIm = false;
        this.isOriginalImg = false;
        this.isEnableChooseOriginalImg = true;
        this.isFromQRCode = false;
        this.maxImagesAllowed = 1;
        this.mIsFromIm = false;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, imageFileInfo) == null) {
            if (this.chosedFiles == null) {
                this.chosedFiles = new LinkedList<>();
            }
            this.chosedFiles.add(imageFileInfo);
        }
    }

    public void addChooseFileFromAlbum(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str2);
            imageFileInfo.setTempFile(false);
            imageFileInfo.setAlbumnId(str);
            addChooseFile(imageFileInfo);
        }
    }

    public void addChooseFileFromCamera(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            imageFileInfo.setAlbumnId(null);
            imageFileInfo.setIsFromCamera(true);
            addChooseFile(imageFileInfo);
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LinkedList<ImageFileInfo> linkedList = this.chosedFiles;
            if (linkedList != null) {
                linkedList.clear();
            }
            this.isOriginalImg = false;
        }
    }

    public void copyFrom(WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, writeImagesInfo) == null) || writeImagesInfo == null) {
            return;
        }
        this.lastAlbumId = writeImagesInfo.lastAlbumId;
        this.maxImagesAllowed = writeImagesInfo.maxImagesAllowed;
        this.mIsFromIm = writeImagesInfo.mIsFromIm;
        this.chosedFiles = writeImagesInfo.chosedFiles;
        this.isOriginalImg = writeImagesInfo.isOriginalImg;
        this.isEnableChooseOriginalImg = writeImagesInfo.isEnableChooseOriginalImg;
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, imageFileInfo) == null) || this.chosedFiles == null || imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return;
        }
        Iterator<ImageFileInfo> it = this.chosedFiles.iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.getFilePath() != null && next.getFilePath().equals(imageFileInfo.getFilePath())) {
                this.chosedFiles.remove(next);
                return;
            }
        }
    }

    public LinkedList<ImageFileInfo> getChosedFiles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.chosedFiles : (LinkedList) invokeV.objValue;
    }

    public ArrayList<String> getChosedUriStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            LinkedList<ImageFileInfo> linkedList = this.chosedFiles;
            if (linkedList != null) {
                Iterator<ImageFileInfo> it = linkedList.iterator();
                while (it.hasNext()) {
                    String contentUriStr = it.next().getContentUriStr();
                    if (!TextUtils.isEmpty(contentUriStr)) {
                        arrayList.add(contentUriStr);
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ImageFileInfo getImageInfoAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            LinkedList<ImageFileInfo> linkedList = this.chosedFiles;
            if (linkedList == null || i < 0 || i >= linkedList.size()) {
                return null;
            }
            return this.chosedFiles.get(i);
        }
        return (ImageFileInfo) invokeI.objValue;
    }

    public String getLastAlbumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.lastAlbumId : (String) invokeV.objValue;
    }

    public int getMaxImagesAllowed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.maxImagesAllowed : invokeV.intValue;
    }

    public int getOriginalImgIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.originalImgIndex : invokeV.intValue;
    }

    public int getOriginalImgViewIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.originalImgViewIndex : invokeV.intValue;
    }

    public boolean hasActionsWithoutResize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            LinkedList<ImageFileInfo> chosedFiles = getChosedFiles();
            if (chosedFiles == null) {
                return false;
            }
            Iterator<ImageFileInfo> it = chosedFiles.iterator();
            while (it.hasNext()) {
                if (it.next().hasActionsWithoutResize()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        LinkedList<ImageFileInfo> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, imageFileInfo)) == null) {
            if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && (linkedList = this.chosedFiles) != null && linkedList.size() != 0) {
                Iterator<ImageFileInfo> it = this.chosedFiles.iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.getFilePath()) && imageFileInfo.getFilePath().equals(next.getFilePath())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isEnableChooseOriginalImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.isEnableChooseOriginalImg : invokeV.booleanValue;
    }

    public boolean isFromQRCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.isFromQRCode : invokeV.booleanValue;
    }

    public boolean isOriginalImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.isOriginalImg : invokeV.booleanValue;
    }

    public void parseJson(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || dj.isEmpty(str)) {
            return;
        }
        try {
            parseJson(new JSONObject(str));
        } catch (JSONException e) {
            BdLog.e(e.getMessage());
        }
    }

    public void setChosedFiles(LinkedList<ImageFileInfo> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, linkedList) == null) {
            this.chosedFiles = linkedList;
        }
    }

    public void setEnableChooseOriginalImg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.isEnableChooseOriginalImg = z;
        }
    }

    public void setFromQRCode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.isFromQRCode = z;
        }
    }

    public void setLastAlbumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.lastAlbumId = str;
        }
    }

    public void setMaxImagesAllowed(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.maxImagesAllowed = i;
        }
    }

    public void setOriginalImg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.isOriginalImg = z;
        }
    }

    public void setOriginalImgIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.originalImgIndex = i;
        }
    }

    public void setOriginalImgViewIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.originalImgViewIndex = i;
        }
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            LinkedList<ImageFileInfo> linkedList = this.chosedFiles;
            if (linkedList == null) {
                return 0;
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("maxImagesAllowed", this.maxImagesAllowed);
                jSONObject.put("isOriginalImg", this.isOriginalImg);
                jSONObject.put("isEnableChooseOriginalImg", this.isEnableChooseOriginalImg);
                if (this.lastAlbumId != null) {
                    jSONObject.put("lastAlbumId", this.lastAlbumId);
                }
                jSONObject.put("isIm", this.mIsFromIm);
                jSONObject.put("isFromQRCode", this.isFromQRCode);
                jSONObject.put("originalImgIndex", this.originalImgIndex);
                jSONObject.put("originalImgViewIndex", this.originalImgViewIndex);
                if (this.chosedFiles != null) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<ImageFileInfo> it = this.chosedFiles.iterator();
                    while (it.hasNext()) {
                        ImageFileInfo next = it.next();
                        if (next != null) {
                            jSONArray.put(next.toJson());
                        }
                    }
                    jSONObject.put("chosedFiles", jSONArray);
                }
                return jSONObject;
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            JSONObject json = toJson();
            if (json != null) {
                return json.toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void updateQuality() {
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (chosedFiles = getChosedFiles()) == null || chosedFiles.size() == 0) {
            return;
        }
        Iterator<ImageFileInfo> descendingIterator = chosedFiles.descendingIterator();
        while (descendingIterator.hasNext()) {
            ImageFileInfo next = descendingIterator.next();
            if (next != null && !next.isHasAddPostQualityAction()) {
                next.addPersistAction(t85.g(TbImageHelper.getInstance().getPostImageSize(), TbImageHelper.getInstance().getPostImageHeightLimit()));
                next.setHasAddPostQualityAction(true);
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.lastAlbumId = jSONObject.optString("lastAlbumId", null);
        this.mIsFromIm = jSONObject.optBoolean("isIm", false);
        this.isFromQRCode = jSONObject.optBoolean("isFromQRCode", false);
        this.maxImagesAllowed = jSONObject.optInt("maxImagesAllowed");
        this.isOriginalImg = jSONObject.optBoolean("isOriginalImg");
        this.isEnableChooseOriginalImg = jSONObject.optBoolean("isEnableChooseOriginalImg");
        this.originalImgIndex = jSONObject.optInt("originalImgIndex");
        this.originalImgViewIndex = jSONObject.optInt("originalImgViewIndex");
        JSONArray optJSONArray = jSONObject.optJSONArray("chosedFiles");
        this.chosedFiles = new LinkedList<>();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.parseJson(optJSONArray.optJSONObject(i));
                imageFileInfo.setIsLong(FileHelper.checkIsLongImage(imageFileInfo.getFilePath()));
                this.chosedFiles.add(imageFileInfo);
            }
        }
    }

    public WriteImagesInfo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsFromIm = false;
        this.isOriginalImg = false;
        this.isEnableChooseOriginalImg = true;
        this.isFromQRCode = false;
        this.maxImagesAllowed = i;
    }
}
