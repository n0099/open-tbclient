package com.baidu.tieba.chosen.posts;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChosenPostActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
/* loaded from: classes.dex */
public class RecommendsStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(ChosenPostActivityConfig.class, ChosenPostActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(PbChosenActivityConfig.class, PbChosenActivity.class);
        Hj();
    }

    private static void Hj() {
        az.uX().a(new l());
    }
}
