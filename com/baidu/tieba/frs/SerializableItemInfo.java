package com.baidu.tieba.frs;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.tieba.g29;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes5.dex */
public class SerializableItemInfo extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALL = "all";
    public transient /* synthetic */ FieldHolder $fh;
    public double averageScore;
    public String brief;
    public double icon_size;
    public String icon_url;
    public Integer id;
    public int isSchool;
    public String name;
    public SerializableItemTableInfo score;
    public List<String> tags;

    public SerializableItemInfo() {
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

    public String getBrief() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.brief;
        }
        return (String) invokeV.objValue;
    }

    public double getIconSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.icon_size;
        }
        return invokeV.doubleValue;
    }

    public String getIcon_url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.icon_url;
        }
        return (String) invokeV.objValue;
    }

    public Integer getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.id;
        }
        return (Integer) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.name;
        }
        return (String) invokeV.objValue;
    }

    public SerializableItemTableInfo getScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.score;
        }
        return (SerializableItemTableInfo) invokeV.objValue;
    }

    public List<String> getTags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.tags;
        }
        return (List) invokeV.objValue;
    }

    public SerializableItemInfo(ItemInfo itemInfo) {
        List<ItemPoint> list;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {itemInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (itemInfo == null) {
            return;
        }
        this.id = itemInfo.id;
        this.name = itemInfo.name;
        this.icon_url = itemInfo.icon_url;
        this.brief = itemInfo.brief;
        this.tags = itemInfo.tags;
        this.icon_size = itemInfo.icon_size.doubleValue();
        this.score = new SerializableItemTableInfo(itemInfo.score);
        this.isSchool = itemInfo.is_school.intValue();
        ItemTable itemTable = itemInfo.score;
        if (itemTable != null && (list = itemTable.item_point) != null) {
            for (ItemPoint itemPoint : list) {
                if (itemPoint.time_intval.equals("all")) {
                    this.averageScore = itemPoint.point.doubleValue();
                    return;
                }
            }
        }
    }

    public void parseJson(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            this.id = Integer.valueOf(jSONObject.optInt("id"));
            this.name = jSONObject.optString("name");
            this.icon_url = jSONObject.optString("icon_url");
            this.icon_size = jSONObject.optInt("icon_size");
            JSONObject optJSONObject = jSONObject.optJSONObject("score");
            if (optJSONObject != null) {
                SerializableItemTableInfo serializableItemTableInfo = new SerializableItemTableInfo();
                serializableItemTableInfo.parseJson(optJSONObject);
                this.score = serializableItemTableInfo;
            }
            this.brief = jSONObject.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray(TaskProcess.keyTags);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        g29.a(arrayList, optJSONObject2.optString("tag"));
                    }
                }
            }
            this.tags = arrayList;
            this.isSchool = jSONObject.optInt("is_school");
            this.averageScore = jSONObject.optInt("average_score");
        }
    }

    public void setAverageScore(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d)}) == null) {
            this.averageScore = d;
        }
    }

    public void setBrief(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.brief = str;
        }
    }

    public void setIconSize(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Double.valueOf(d)}) == null) {
            this.icon_size = d;
        }
    }

    public void setIcon_url(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.icon_url = str;
        }
    }

    public void setId(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, num) == null) {
            this.id = num;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.name = str;
        }
    }

    public void setScore(SerializableItemTableInfo serializableItemTableInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, serializableItemTableInfo) == null) {
            this.score = serializableItemTableInfo;
        }
    }

    public void setTags(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.tags = list;
        }
    }

    public String toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.id);
                jSONObject.put("name", this.name);
                jSONObject.put("icon_url", this.icon_url);
                jSONObject.put("icon_size", this.icon_size);
                jSONObject.put("score", this.score);
                jSONObject.put(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, this.brief);
                JSONArray jSONArray = new JSONArray();
                for (String str : this.tags) {
                    jSONArray.put(str);
                }
                jSONObject.put(TaskProcess.keyTags, jSONArray);
                jSONObject.put("is_school", this.isSchool);
                jSONObject.put("average_score", this.averageScore);
            } catch (JSONException e) {
                BdLog.e(e);
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
