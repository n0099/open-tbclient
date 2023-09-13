package com.baidu.tieba.funAd.strategy;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.r15;
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
/* loaded from: classes5.dex */
public class FunAdSidConfigData extends r15 implements Serializable {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mBearSidList;
        }
        return (List) invokeV.objValue;
    }

    public long getExpiryTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mExpiryTime;
        }
        return invokeV.longValue;
    }

    public int getForce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mForce;
        }
        return invokeV.intValue;
    }

    public int getRecordNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mRecordNum;
        }
        return invokeV.intValue;
    }

    public long getSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mSpace;
        }
        return invokeV.longValue;
    }

    public int getThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mThreshold;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.r15
    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("bear_sid_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    this.mBearSidList.add(optJSONArray.getString(i));
                }
            }
            this.mThreshold = jSONObject.optInt("threshold", 0);
            this.mExpiryTime = jSONObject.optLong("expiry_time", 0L);
            this.mRecordNum = jSONObject.optInt("record_num", 0);
            this.mSpace = jSONObject.optLong("space", 0L);
            this.mForce = jSONObject.optInt("force", 0);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void setForce(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.mForce = i;
        }
    }

    public void setSpace(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.mSpace = j;
        }
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
            } catch (JSONException e) {
                BdLog.detailException(e);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
