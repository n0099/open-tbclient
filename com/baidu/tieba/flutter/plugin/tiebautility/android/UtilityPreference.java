package com.baidu.tieba.flutter.plugin.tiebautility.android;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityPreferenceAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.d0.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class UtilityPreference implements TiebaUtilityPreferenceAuto.HostUtilityPreference {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UtilityPreference() {
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

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityPreferenceAuto.HostUtilityPreference
    public void preferenceGetValues(TiebaUtilityPreferenceAuto.GetPreferenceParam getPreferenceParam, TiebaUtilityPreferenceAuto.Result<TiebaUtilityPreferenceAuto.KVResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, getPreferenceParam, result) == null) {
            ArrayList keys = getPreferenceParam.getKeys();
            getPreferenceParam.getNameSpace();
            HashMap hashMap = new HashMap();
            TiebaUtilityPreferenceAuto.KVResult kVResult = new TiebaUtilityPreferenceAuto.KVResult();
            for (int i2 = 0; i2 < keys.size(); i2++) {
                if (b.j().s(SharePrefNameTransform.getAndroidNameFromIos((String) keys.get(i2)))) {
                    hashMap.put(keys.get(i2), Boolean.valueOf(b.j().g(SharePrefNameTransform.getAndroidNameFromIos((String) keys.get(i2)), false)));
                }
            }
            kVResult.setResult(hashMap);
            result.success(kVResult);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityPreferenceAuto.HostUtilityPreference
    public void preferenceSetValues(TiebaUtilityPreferenceAuto.SetPreferenceParam setPreferenceParam, TiebaUtilityPreferenceAuto.Result<TiebaUtilityPreferenceAuto.SuccessResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, setPreferenceParam, result) == null) {
            setPreferenceParam.getNameSpace();
            HashMap keyValueMap = setPreferenceParam.getKeyValueMap();
            TiebaUtilityPreferenceAuto.SuccessResult successResult = new TiebaUtilityPreferenceAuto.SuccessResult();
            if (keyValueMap != null && !keyValueMap.isEmpty()) {
                for (Map.Entry entry : keyValueMap.entrySet()) {
                    if (entry.getValue() instanceof Boolean) {
                        b.j().t(SharePrefNameTransform.getAndroidNameFromIos((String) entry.getKey()), ((Boolean) entry.getValue()).booleanValue());
                    }
                }
            }
            successResult.setResult(Boolean.TRUE);
            result.success(successResult);
        }
    }
}
