package com.baidu.tieba.faceshop.emotioncenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.faceshop.EmotionPackageData;
/* loaded from: classes8.dex */
public class b implements n {
    public static final BdUniqueId iSz = BdUniqueId.gen();
    public EmotionPackageData iSA;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iSz;
    }
}
