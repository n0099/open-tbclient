package com.baidu.tbadk.plugins;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class XiaoyingProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public boolean onCreate() {
        ContentProvider contentProvider = XiaoyingPlugin.getContentProvider();
        if (contentProvider == null) {
            return false;
        }
        return contentProvider.onCreate();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        ContentProvider contentProvider = XiaoyingPlugin.getContentProvider();
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.query(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        ContentProvider contentProvider = XiaoyingPlugin.getContentProvider();
        return contentProvider == null ? "" : contentProvider.getType(uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        ContentProvider contentProvider = XiaoyingPlugin.getContentProvider();
        return contentProvider == null ? uri : contentProvider.insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        ContentProvider contentProvider = XiaoyingPlugin.getContentProvider();
        if (contentProvider == null) {
            return -1;
        }
        return contentProvider.delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        ContentProvider contentProvider = XiaoyingPlugin.getContentProvider();
        if (contentProvider == null) {
            return -1;
        }
        return contentProvider.update(uri, contentValues, str, strArr);
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) {
        ContentProvider contentProvider = XiaoyingPlugin.getContentProvider();
        if (contentProvider == null) {
            return null;
        }
        return contentProvider.applyBatch(arrayList);
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        ContentProvider contentProvider = XiaoyingPlugin.getContentProvider();
        if (contentProvider == null) {
            return -1;
        }
        return contentProvider.bulkInsert(uri, contentValuesArr);
    }
}
