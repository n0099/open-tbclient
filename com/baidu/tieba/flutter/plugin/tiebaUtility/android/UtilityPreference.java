package com.baidu.tieba.flutter.plugin.tiebaUtility.android;

import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityPreferenceAuto;
import d.a.n0.r.d0.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class UtilityPreference implements TiebaUtilityPreferenceAuto.HostUtilityPreference {
    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityPreferenceAuto.HostUtilityPreference
    public void preferenceGetValues(TiebaUtilityPreferenceAuto.GetPreferenceParam getPreferenceParam, TiebaUtilityPreferenceAuto.Result<TiebaUtilityPreferenceAuto.KVResult> result) {
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

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityPreferenceAuto.HostUtilityPreference
    public void preferenceSetValues(TiebaUtilityPreferenceAuto.SetPreferenceParam setPreferenceParam, TiebaUtilityPreferenceAuto.Result<TiebaUtilityPreferenceAuto.SuccessResult> result) {
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
