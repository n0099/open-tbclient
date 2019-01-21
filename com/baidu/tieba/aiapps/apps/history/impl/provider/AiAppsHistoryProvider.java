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
    public static final Uri bHD = Uri.parse("content://com.baidu.tieba.aiapps_visit_history/swanhistory");
    private static UriMatcher bHE = new UriMatcher(-1);
    private a bHF;

    static {
        bHE.addURI("com.baidu.tieba.aiapps_visit_history", "swanhistory", 1);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.bHF = new a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        switch (bHE.match(uri)) {
            case 1:
                Cursor a = this.bHF.a(strArr, str, strArr2, str2);
                a.setNotificationUri(getContext().getContentResolver(), bHD);
                return a;
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        switch (bHE.match(uri)) {
            case 1:
                return this.bHF.getType();
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        switch (bHE.match(uri)) {
            case 1:
                Uri insert = this.bHF.insert(uri, contentValues);
                getContext().getContentResolver().notifyChange(bHD, null);
                return insert;
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        switch (bHE.match(uri)) {
            case 1:
                return this.bHF.b(str, strArr);
            default:
                return 0;
        }
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        switch (bHE.match(uri)) {
            case 1:
                int a = this.bHF.a(contentValues, str, strArr);
                getContext().getContentResolver().notifyChange(bHD, null);
                return a;
            default:
                return 0;
        }
    }
}
