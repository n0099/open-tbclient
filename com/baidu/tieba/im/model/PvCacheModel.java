package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import d.b.c.e.k.a;
import d.b.c.e.m.b;
/* loaded from: classes4.dex */
public class PvCacheModel {
    public static PvCacheModel mCacheModel;
    public a<String, String> mCache;

    public PvCacheModel() {
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
        if (str == null || str.length() <= 0) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        a<String, String> aVar = this.mCache;
        aVar.h(currentAccount + str, String.valueOf(l));
    }

    public boolean isSameDay(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        a<String, String> aVar = this.mCache;
        String f2 = aVar.f(currentAccount + str);
        if (TextUtils.isEmpty(f2)) {
            return false;
        }
        return UtilHelper.isSameDay(b.f(f2, 0L), System.currentTimeMillis());
    }

    public void removeCacheData(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        a<String, String> aVar = this.mCache;
        aVar.i(currentAccount + str);
    }
}
