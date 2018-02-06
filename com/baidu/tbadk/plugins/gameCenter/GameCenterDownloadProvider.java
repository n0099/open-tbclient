package com.baidu.tbadk.plugins.gameCenter;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
public class GameCenterDownloadProvider extends ContentProvider {
    private boolean bCo = false;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        OJ();
        if (a.OL() != null) {
            return a.OL().query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        OJ();
        if (a.OL() != null) {
            return a.OL().getType(uri);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        OJ();
        if (a.OL() != null) {
            return a.OL().insert(uri, contentValues);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        OJ();
        if (a.OL() != null) {
            return a.OL().delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        OJ();
        if (a.OL() != null) {
            return a.OL().update(uri, contentValues, str, strArr);
        }
        return 0;
    }

    private void OJ() {
        if (!this.bCo) {
            MessageManager.getInstance().runTask(new CustomMessage<>(2016518, this), (Class) null);
            if (a.OL() != null) {
                a.OL().onCreate();
                this.bCo = true;
            }
        }
    }
}
