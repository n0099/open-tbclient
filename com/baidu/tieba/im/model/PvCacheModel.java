package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.f.b;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes8.dex */
public class PvCacheModel {
    private static PvCacheModel mCacheModel;
    private a<String, String> mCache;

    private PvCacheModel() {
        this.mCache = null;
        this.mCache = new a<>(256);
    }

    public static synchronized PvCacheModel getInstance() {
        PvCacheModel pvCacheModel;
        synchronized (PvCacheModel.class) {
            if (mCacheModel == null) {
                mCacheModel = new PvCacheModel();
            }
            pvCacheModel = mCacheModel;
        }
        return pvCacheModel;
    }

    public void addCacheData(String str, Long l) {
        if (str != null && str.length() > 0) {
            this.mCache.put(TbadkApplication.getCurrentAccount() + str, String.valueOf(l));
        }
    }

    public void removeCacheData(String str) {
        if (str != null && str.length() > 0) {
            this.mCache.remove(TbadkApplication.getCurrentAccount() + str);
        }
    }

    public boolean isSameDay(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        String str2 = this.mCache.get(TbadkApplication.getCurrentAccount() + str);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return UtilHelper.isSameDay(b.toLong(str2, 0L), System.currentTimeMillis());
    }
}
