package com.baidu.tieba.funad;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes5.dex */
public class d implements com.baidu.tieba.h.c {
    @Override // com.baidu.tieba.h.c
    public com.baidu.adp.widget.ListView.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.eML) {
            return new com.baidu.tieba.funad.adapter.b(baseFragmentActivity, bdUniqueId);
        }
        if (bdUniqueId == AdvertAppInfo.eMM) {
            return new com.baidu.tieba.funad.adapter.a(baseFragmentActivity, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.h.c
    public com.baidu.adp.widget.ListView.a<?, ?> b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.eMN) {
            return new com.baidu.tieba.funad.adapter.b(baseFragmentActivity, bdUniqueId);
        }
        if (bdUniqueId == AdvertAppInfo.eMM) {
            return new com.baidu.tieba.funad.adapter.a(baseFragmentActivity, bdUniqueId);
        }
        return null;
    }

    @Override // com.baidu.tieba.h.c
    public com.baidu.adp.widget.ListView.a<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.eMN) {
            return new com.baidu.tieba.funad.adapter.b(baseFragmentActivity, bdUniqueId);
        }
        if (bdUniqueId == AdvertAppInfo.eMM) {
            return new com.baidu.tieba.funad.adapter.a(baseFragmentActivity, bdUniqueId);
        }
        return null;
    }
}
