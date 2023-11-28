package com.baidu.tbadk.mainTab.dynamicIcon;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jk5;
import com.baidu.tieba.kk5;
import com.baidu.tieba.rd;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class DynamicIconData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int IMG_LOAD_TYPE;
    public boolean isAllStatusIconLoadedFinish;
    public boolean isBgDarkImgLoadCompleted;
    public boolean isBgDayImgLoadCompleted;
    public boolean isBgNightImgLoadCompleted;
    public boolean isNormalStateImgLoadingCompleted;
    public boolean isSelectedStateImgLoadingCompleted;
    public BdResourceCallback<BdImage> mCallback;
    public jk5 mDynamicStyleData;
    public kk5 mIconLoadedFinishCallback;
    public BdUniqueId mMainTabPageId;
    public String normalStateUrl;
    public String selectedStateUrl;

    public int getImgLoadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 45;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DynamicIconData a;

        public a(DynamicIconData dynamicIconData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dynamicIconData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dynamicIconData;
        }

        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdImage, str, i) == null) {
                if (bdImage != null && str != null) {
                    if (this.a.isDynamicStyleDataValid()) {
                        if (str.equals(this.a.mDynamicStyleData.b())) {
                            this.a.isBgDayImgLoadCompleted = true;
                        }
                        if (str.equals(this.a.mDynamicStyleData.c())) {
                            this.a.isBgNightImgLoadCompleted = true;
                        }
                        if (str.equals(this.a.mDynamicStyleData.a())) {
                            this.a.isBgDarkImgLoadCompleted = true;
                        }
                        if (this.a.isBgDayImgLoadCompleted && this.a.isBgNightImgLoadCompleted && this.a.isBgDarkImgLoadCompleted) {
                            this.a.isAllStatusIconLoadedFinish = true;
                        }
                    } else {
                        if (str.equals(this.a.normalStateUrl)) {
                            this.a.isNormalStateImgLoadingCompleted = true;
                        }
                        if (str.equals(this.a.selectedStateUrl)) {
                            this.a.isSelectedStateImgLoadingCompleted = true;
                        }
                        if (this.a.isNormalStateImgLoadingCompleted && this.a.isSelectedStateImgLoadingCompleted) {
                            this.a.isAllStatusIconLoadedFinish = true;
                        }
                    }
                }
                if (this.a.mIconLoadedFinishCallback != null && this.a.isAllStatusIconLoadedFinish) {
                    this.a.mIconLoadedFinishCallback.onIconLoadedFinish();
                }
            }
        }
    }

    public DynamicIconData() {
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
        this.IMG_LOAD_TYPE = 45;
        this.mCallback = new a(this);
    }

    public jk5 getDynamicStyleData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mDynamicStyleData;
        }
        return (jk5) invokeV.objValue;
    }

    public String getNormalStateUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.normalStateUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getSelectedStateUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.selectedStateUrl;
        }
        return (String) invokeV.objValue;
    }

    public boolean isAllStatusIconLoadedFinish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.isAllStatusIconLoadedFinish;
        }
        return invokeV.booleanValue;
    }

    public void parse(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            this.normalStateUrl = jSONObject.optString("pic_before");
            this.selectedStateUrl = jSONObject.optString("pic_after");
            jk5 jk5Var = new jk5();
            this.mDynamicStyleData = jk5Var;
            jk5Var.h(jSONObject);
        }
    }

    public void setDynamicStyleData(jk5 jk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jk5Var) == null) {
            this.mDynamicStyleData = jk5Var;
        }
    }

    public void setIconLoadedFinishCallback(kk5 kk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kk5Var) == null) {
            this.mIconLoadedFinishCallback = kk5Var;
        }
    }

    public void setMainTabPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            this.mMainTabPageId = bdUniqueId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDynamicStyleDataValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            jk5 jk5Var = this.mDynamicStyleData;
            if (jk5Var != null && StringUtils.isNotNull(jk5Var.b()) && StringUtils.isNotNull(this.mDynamicStyleData.c()) && StringUtils.isNotNull(this.mDynamicStyleData.a())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadImages() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String str = this.normalStateUrl;
            if (str != null && !rd.isEmpty(str)) {
                BdResourceLoader.getInstance().loadResource(this.normalStateUrl, getImgLoadType(), this.mCallback, 0, 0, this.mMainTabPageId, new Object[0]);
            }
            String str2 = this.selectedStateUrl;
            if (str2 != null && !rd.isEmpty(str2)) {
                BdResourceLoader.getInstance().loadResource(this.selectedStateUrl, getImgLoadType(), this.mCallback, 0, 0, this.mMainTabPageId, new Object[0]);
            }
            if (isDynamicStyleDataValid()) {
                BdResourceLoader.getInstance().loadResource(this.mDynamicStyleData.b(), getImgLoadType(), this.mCallback, 0, 0, this.mMainTabPageId, new Object[0]);
                BdResourceLoader.getInstance().loadResource(this.mDynamicStyleData.c(), getImgLoadType(), this.mCallback, 0, 0, this.mMainTabPageId, new Object[0]);
                BdResourceLoader.getInstance().loadResource(this.mDynamicStyleData.a(), getImgLoadType(), this.mCallback, 0, 0, this.mMainTabPageId, new Object[0]);
            }
        }
    }
}
