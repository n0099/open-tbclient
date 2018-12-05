package com.baidu.tieba.aiapps.apps.history.impl.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes4.dex */
public class AiAppsHistoryProvider extends ContentProvider {
    public static final Uri bGM = Uri.parse("content://com.baidu.tieba.aiapps_visit_history/swanhistory");
    private static UriMatcher bGN = new UriMatcher(-1);
    private a bGO;

    static {
        bGN.addURI("com.baidu.tieba.aiapps_visit_history", "swanhistory", 1);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.bGO = new a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        switch (bGN.match(uri)) {
            case 1:
                Cursor a = this.bGO.a(strArr, str, strArr2, str2);
                a.setNotificationUri(getContext().getContentResolver(), bGM);
                return a;
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        switch (bGN.match(uri)) {
            case 1:
                return this.bGO.getType();
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        switch (bGN.match(uri)) {
            case 1:
                Uri insert = this.bGO.insert(uri, contentValues);
                getContext().getContentResolver().notifyChange(bGM, null);
                return insert;
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        switch (bGN.match(uri)) {
            case 1:
                return this.bGO.b(str, strArr);
            default:
                return 0;
        }
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        switch (bGN.match(uri)) {
            case 1:
                int a = this.bGO.a(contentValues, str, strArr);
                getContext().getContentResolver().notifyChange(bGM, null);
                return a;
            default:
                return 0;
        }
    }
}
