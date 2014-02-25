package com.baidu.tieba.album;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.img.ImageFileInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Object, Integer, List<ImageFileInfo>> {
    final /* synthetic */ e a;
    private ak b;
    private String c;
    private String d;

    public g(e eVar, String str, ak akVar) {
        this.a = eVar;
        this.b = akVar;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public List<ImageFileInfo> a(Object... objArr) {
        Context context;
        Context context2;
        String str = this.c;
        context = this.a.e;
        List<ImageFileInfo> a = a(str, context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if (a == null || a.size() <= 0) {
            String str2 = this.c;
            context2 = this.a.e;
            return a(str2, context2, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a() {
        super.a();
        if (this.b != null) {
            this.b.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(List<ImageFileInfo> list) {
        super.a((g) list);
        if (this.b != null) {
            this.b.a(list, this.d);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0092 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    private List<ImageFileInfo> a(String str, Context context, Uri uri) {
        Cursor cursor;
        String str2;
        ArrayList arrayList = new ArrayList();
        ?? r1 = "bucket_display_name";
        try {
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"bucket_id", "_data", "bucket_display_name"}, "bucket_id=?", new String[]{str}, "datetaken DESC");
                try {
                } catch (Exception e) {
                    e = e;
                    str2 = this.a.a;
                    com.baidu.adp.lib.util.f.b(str2, "getAlbumData", "error = " + e.getMessage());
                    com.baidu.adp.lib.f.a.a(cursor);
                    return arrayList;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.f.a.a((Cursor) r1);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
            com.baidu.adp.lib.f.a.a((Cursor) r1);
            throw th;
        }
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("_data");
            int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
            do {
                String string = cursor.getString(columnIndex);
                this.d = cursor.getString(columnIndex2);
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setAlbumnId(str);
                imageFileInfo.setFilePath(string);
                if (new File(string).exists()) {
                    arrayList.add(imageFileInfo);
                }
            } while (cursor.moveToNext());
            com.baidu.adp.lib.f.a.a(cursor);
            return arrayList;
        }
        com.baidu.adp.lib.f.a.a(cursor);
        return arrayList;
    }
}
