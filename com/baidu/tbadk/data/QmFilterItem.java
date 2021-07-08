package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class QmFilterItem extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NO_FILTER_ID = "-1";
    public transient /* synthetic */ FieldHolder $fh;
    public String bgurl;
    public String complex;
    public String complexFileUrl;
    public String effect;
    public String fileUrl;
    public String id;
    public boolean isDownLoading;
    public boolean isSelect;
    public String localPath;
    public String name;

    public QmFilterItem() {
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
        this.id = jSONObject.getString("id");
        this.name = jSONObject.getString("name");
        this.fileUrl = jSONObject.getString("file");
        this.bgurl = jSONObject.getString("bgurl");
        this.effect = jSONObject.getString("effect");
        this.complex = jSONObject.getString("complex");
        this.complexFileUrl = jSONObject.getString("complex_file");
    }
}
