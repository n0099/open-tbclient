package com.baidu.tieba.funAd.strategy;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.p;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class FunAdSidConfigData extends p implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> mBearSidList;
    public long mExpiryTime;
    public int mForce;
    public int mRecordNum;
    public long mSpace;
    public int mThreshold;

    public FunAdSidConfigData() {
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
        this.mBearSidList = new ArrayList();
    }

    public List<String> getBearSidList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBearSidList : (List) invokeV.objValue;
    }

    public long getExpiryTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mExpiryTime : invokeV.longValue;
    }

    public int getForce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mForce : invokeV.intValue;
    }

    public int getRecordNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRecordNum : invokeV.intValue;
    }

    public long getSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mSpace : invokeV.longValue;
    }

    public int getThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mThreshold : invokeV.intValue;
    }

    @Override // d.a.r0.r.q.p
    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("bear_sid_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    this.mBearSidList.add(optJSONArray.getString(i2));
                }
            }
            this.mThreshold = jSONObject.optInt("threshold", 0);
            this.mExpiryTime = jSONObject.optLong("expiry_time", 0L);
            this.mRecordNum = jSONObject.optInt("record_num", 0);
            this.mSpace = jSONObject.optLong("space", 0L);
            this.mForce = jSONObject.optInt("force", 0);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void setBearSidList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.mBearSidList = list;
        }
    }

    public void setExpiryTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.mExpiryTime = j;
        }
    }

    public void setForce(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mForce = i2;
        }
    }

    public void setRecordNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.mRecordNum = i2;
        }
    }

    public void setSpace(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.mSpace = j;
        }
    }

    public void setThreshold(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mThreshold = i2;
        }
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (String str : this.mBearSidList) {
                jSONArray.put(str);
            }
            try {
                jSONObject.put("bear_sid_list", jSONArray);
                jSONObject.put("threshold", this.mThreshold);
                jSONObject.put("expiry_time", this.mExpiryTime);
                jSONObject.put("record_num", this.mRecordNum);
                jSONObject.put("space", this.mSpace);
                jSONObject.put("force", this.mForce);
            } catch (JSONException e2) {
                BdLog.detailException(e2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
