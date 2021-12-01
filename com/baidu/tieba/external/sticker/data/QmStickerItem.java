package com.baidu.tieba.external.sticker.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class QmStickerItem extends OrmObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NO_STICKER_ID = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public String bgurl;
    public String fileUrl;
    public int id;
    public boolean isDownLoading;
    public boolean isLocalSource;
    public boolean isSelect;
    public String localPath;
    public String name;
    public int sdkVersionMax;
    public int sdkVersionMin;

    public QmStickerItem() {
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

    public void parseJson(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.id = jSONObject.getInt("id");
        this.name = jSONObject.getString("name");
        this.fileUrl = jSONObject.getString("file");
        this.bgurl = jSONObject.getString("bgurl");
        this.sdkVersionMin = jSONObject.getInt("sdk_version_min");
        this.sdkVersionMax = jSONObject.getInt("sdk_version_max");
    }
}
