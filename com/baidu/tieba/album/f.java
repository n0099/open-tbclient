package com.baidu.tieba.album;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.img.ImageFileInfo;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Object, Integer, List<a>> {
    final /* synthetic */ e a;
    private o b;

    public f(e eVar, o oVar) {
        this.a = eVar;
        this.b = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public List<a> a(Object... objArr) {
        Context context;
        Context context2;
        context = this.a.e;
        List<a> a = a(context, null, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        context2 = this.a.e;
        return a(context2, a, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
        if (this.b != null) {
            this.b.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(List<a> list) {
        super.a((f) list);
        if (this.b != null) {
            this.b.a(list);
        }
    }

    private List<a> a(Context context, List<a> list, Uri uri) {
        String str;
        String str2;
        Cursor cursor = null;
        if (context == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"bucket_id", "bucket_display_name", "_data", "count(*)"}, "mime_type = 'image/jpeg' OR mime_type = 'image/png' OR mime_type = 'image/gif') GROUP BY 1,(2", null, "datetaken DESC");
            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex("bucket_id");
                int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
                int columnIndex3 = cursor.getColumnIndex("_data");
                int columnIndex4 = cursor.getColumnIndex("count(*)");
                do {
                    String string = cursor.getString(columnIndex);
                    String string2 = cursor.getString(columnIndex2);
                    String string3 = cursor.getString(columnIndex3);
                    String string4 = cursor.getString(columnIndex4);
                    a aVar = new a();
                    aVar.a(string);
                    aVar.c(string4);
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setFilePath(string3);
                    aVar.a(imageFileInfo);
                    aVar.b(string2);
                    if (string2 != null) {
                        str2 = this.a.b;
                        if (string2.equals(str2)) {
                            list.add(0, aVar);
                        }
                    }
                    list.add(aVar);
                } while (cursor.moveToNext());
                return list;
            }
            return list;
        } catch (Exception e) {
            str = this.a.a;
            com.baidu.adp.lib.util.f.b(str, "getAlbumData", "error = " + e.getMessage());
            return list;
        } finally {
            com.baidu.adp.lib.f.a.a(cursor);
        }
    }
}
