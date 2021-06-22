package com.baidu.tbadk.plugins.gameCenter;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import d.a.n0.p0.c.a;
/* loaded from: classes3.dex */
public class GameCenterDownloadProvider extends ContentProvider {
    public boolean isPluginSetted = false;

    private void setPlugin() {
        if (this.isPluginSetted) {
            return;
        }
        MessageManager.getInstance().runTask(new CustomMessage<>(2016518, this), (Class) null);
        if (a.b() != null) {
            a.b().onCreate();
            this.isPluginSetted = true;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        setPlugin();
        if (a.b() != null) {
            try {
                return a.b().delete(uri, str, strArr);
            } catch (Throwable th) {
                BdLog.e(th);
                return 0;
            }
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        setPlugin();
        if (a.b() != null) {
            try {
                return a.b().getType(uri);
            } catch (Throwable th) {
                BdLog.e(th);
                return null;
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        setPlugin();
        if (a.b() != null) {
            try {
                return a.b().insert(uri, contentValues);
            } catch (Throwable th) {
                BdLog.e(th);
                return null;
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        setPlugin();
        if (a.b() != null) {
            try {
                return a.b().query(uri, strArr, str, strArr2, str2);
            } catch (Throwable th) {
                BdLog.e(th);
                return null;
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        setPlugin();
        if (a.b() != null) {
            try {
                return a.b().update(uri, contentValues, str, strArr);
            } catch (Throwable th) {
                BdLog.e(th);
                return 0;
            }
        }
        return 0;
    }
}
