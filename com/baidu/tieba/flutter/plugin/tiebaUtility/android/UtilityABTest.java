package com.baidu.tieba.flutter.plugin.tiebaUtility.android;

import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAbtestAuto;
import d.a.i0.b.c;
/* loaded from: classes4.dex */
public class UtilityABTest implements TiebaUtilityAbtestAuto.HostUtilityABTest {
    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityAbtestAuto.HostUtilityABTest
    public void experimentTypeForBarEntry(TiebaUtilityAbtestAuto.Result<TiebaUtilityAbtestAuto.ExperimentType> result) {
        TiebaUtilityAbtestAuto.ExperimentType experimentType = new TiebaUtilityAbtestAuto.ExperimentType();
        if (c.d().b("11_8_forum_guide_b") != null) {
            experimentType.setResult(2L);
        } else if (c.d().b("11_8_forum_guide_a") != null) {
            experimentType.setResult(1L);
        } else {
            experimentType.setResult(1L);
        }
        result.success(experimentType);
    }
}
