package com.baidu.tbadk.plugins.gameCenter;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class GameCenterDownloadProvider extends ContentProvider {
    private boolean isPluginSetted = false;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        setPlugin();
        if (a.KW() != null) {
            try {
                return a.KW().query(uri, strArr, str, strArr2, str2);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        setPlugin();
        if (a.KW() != null) {
            try {
                return a.KW().getType(uri);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        setPlugin();
        if (a.KW() != null) {
            try {
                return a.KW().insert(uri, contentValues);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        setPlugin();
        if (a.KW() != null) {
            try {
                return a.KW().delete(uri, str, strArr);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        setPlugin();
        if (a.KW() != null) {
            try {
                return a.KW().update(uri, contentValues, str, strArr);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        return 0;
    }

    private void setPlugin() {
        if (!this.isPluginSetted) {
            MessageManager.getInstance().runTask(new CustomMessage<>(2016518, this), (Class) null);
            if (a.KW() != null) {
                a.KW().onCreate();
                this.isPluginSetted = true;
            }
        }
    }
}
