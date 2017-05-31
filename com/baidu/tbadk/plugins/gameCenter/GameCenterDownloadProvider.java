package com.baidu.tbadk.plugins.gameCenter;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class GameCenterDownloadProvider extends ContentProvider {
    private boolean aIe = false;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        FS();
        if (a.FU() != null) {
            return a.FU().query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        FS();
        if (a.FU() != null) {
            return a.FU().getType(uri);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        FS();
        if (a.FU() != null) {
            return a.FU().insert(uri, contentValues);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        FS();
        if (a.FU() != null) {
            return a.FU().delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        FS();
        if (a.FU() != null) {
            return a.FU().update(uri, contentValues, str, strArr);
        }
        return 0;
    }

    private void FS() {
        if (!this.aIe) {
            MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PROXY_GAME_DOWNLOAD_PROVIDER_READY, this), (Class) null);
            if (a.FU() != null) {
                a.FU().onCreate();
                this.aIe = true;
            }
        }
    }
}
