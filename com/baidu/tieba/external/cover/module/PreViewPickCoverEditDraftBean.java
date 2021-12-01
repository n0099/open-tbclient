package com.baidu.tieba.external.cover.module;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class PreViewPickCoverEditDraftBean implements Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float mCoverPercent;
    @Deprecated
    public TextWordsEntity.TextFontEntity mFontEntity;
    @Deprecated
    public int mLayoutX;
    @Deprecated
    public int mLayoutY;
    public List<MultiMediaData> mMultiMediaDataList;
    @Deprecated
    public float mRotateAngle;
    @Deprecated
    public float mScale;
    @Deprecated
    public TextWordsEntity.TextStyleEntity mStyleEntity;
    @Deprecated
    public String mText;

    public PreViewPickCoverEditDraftBean() {
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
        this.mLayoutX = 0;
        this.mLayoutY = 0;
        this.mRotateAngle = 0.0f;
        this.mScale = 1.0f;
        this.mCoverPercent = 0.0f;
    }

    public List<MultiMediaData> cloneMultiMediaDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(this.mMultiMediaDataList)) {
                return arrayList;
            }
            for (MultiMediaData multiMediaData : this.mMultiMediaDataList) {
                arrayList.add((MultiMediaData) multiMediaData.clone());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public boolean parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.mText = jSONObject.optString("text");
                this.mLayoutX = jSONObject.optInt("layout_x");
                this.mLayoutY = jSONObject.optInt("layout_y");
                this.mRotateAngle = jSONObject.optInt("rotate_angle");
                this.mScale = jSONObject.optInt(AnimationProperty.SCALE);
                this.mCoverPercent = (float) jSONObject.optDouble(SapiOptions.KEY_CACHE_PERCENT);
                JSONObject optJSONObject = jSONObject.optJSONObject("style");
                if (optJSONObject != null) {
                    this.mStyleEntity = TextWordsEntity.TextStyleEntity.parse(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("font");
                if (optJSONObject2 != null) {
                    this.mFontEntity = TextWordsEntity.TextFontEntity.parse(optJSONObject2);
                }
                String optString = jSONObject.optString("multiMediaDataList");
                if (TextUtils.isEmpty(optString)) {
                    return true;
                }
                this.mMultiMediaDataList = MultiMediaData.parseArrayList(optString);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("text", this.mText);
                jSONObject.put("layout_x", this.mLayoutX);
                jSONObject.put("layout_y", this.mLayoutY);
                jSONObject.put("rotate_angle", this.mRotateAngle);
                jSONObject.put(AnimationProperty.SCALE, this.mScale);
                jSONObject.put(SapiOptions.KEY_CACHE_PERCENT, this.mCoverPercent);
                if (this.mStyleEntity != null) {
                    jSONObject.put("style", TextWordsEntity.TextStyleEntity.toJson(this.mStyleEntity));
                }
                if (this.mFontEntity != null) {
                    jSONObject.put("font", TextWordsEntity.TextFontEntity.toJson(this.mFontEntity));
                }
                jSONObject.put("multiMediaDataList", MultiMediaData.arratToJson(this.mMultiMediaDataList));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
