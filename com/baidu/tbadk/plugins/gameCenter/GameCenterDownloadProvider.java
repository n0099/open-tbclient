package com.baidu.tbadk.plugins.gameCenter;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
public class GameCenterDownloadProvider extends ContentProvider {
    private boolean bCb = false;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        OI();
        if (a.OK() != null) {
            return a.OK().query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        OI();
        if (a.OK() != null) {
            return a.OK().getType(uri);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        OI();
        if (a.OK() != null) {
            return a.OK().insert(uri, contentValues);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        OI();
        if (a.OK() != null) {
            return a.OK().delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        OI();
        if (a.OK() != null) {
            return a.OK().update(uri, contentValues, str, strArr);
        }
        return 0;
    }

    private void OI() {
        if (!this.bCb) {
            MessageManager.getInstance().runTask(new CustomMessage<>(2016518, this), (Class) null);
            if (a.OK() != null) {
                a.OK().onCreate();
                this.bCb = true;
            }
        }
    }
}
