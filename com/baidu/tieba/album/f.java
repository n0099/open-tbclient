package com.baidu.tieba.album;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.img.ImageFileInfo;
import java.io.File;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends BdAsyncTask<Object, Integer, List<a>> {
    final /* synthetic */ e a;
    private final o b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ List<a> a(Object... objArr) {
        Context context;
        Context context2;
        context = this.a.e;
        List<a> a = a(context, null, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        context2 = this.a.e;
        return a(context2, a, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(List<a> list) {
        List<a> list2 = list;
        super.a((f) list2);
        if (this.b != null) {
            this.b.a(list2);
        }
    }

    public f(e eVar, o oVar) {
        this.a = eVar;
        this.b = oVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        super.b();
        if (this.b != null) {
            o oVar = this.b;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0122 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.database.Cursor] */
    private List<a> a(Context context, List<a> list, Uri uri) {
        Cursor cursor;
        String str;
        String str2;
        File[] listFiles;
        if (context == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        ?? r1 = "count(*)";
        try {
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"bucket_id", "bucket_display_name", "_data", "count(*)"}, "mime_type = 'image/jpeg' OR mime_type = 'image/png' OR mime_type = 'image/gif') GROUP BY 1,(2", null, "datetaken DESC");
                try {
                    if (cursor.moveToFirst()) {
                        int columnIndex = cursor.getColumnIndex("bucket_id");
                        int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
                        int columnIndex3 = cursor.getColumnIndex("_data");
                        int columnIndex4 = cursor.getColumnIndex("count(*)");
                        do {
                            String string = cursor.getString(columnIndex);
                            String string2 = cursor.getString(columnIndex2);
                            String string3 = cursor.getString(columnIndex3);
                            cursor.getString(columnIndex4);
                            int i = 0;
                            File file = new File(string3.substring(0, string3.lastIndexOf("/")));
                            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                                for (File file2 : listFiles) {
                                    String guessContentTypeFromName = URLConnection.guessContentTypeFromName(file2.getAbsolutePath());
                                    if (guessContentTypeFromName != null && (guessContentTypeFromName.equalsIgnoreCase("image/png") || guessContentTypeFromName.equalsIgnoreCase("image/jpeg") || guessContentTypeFromName.equalsIgnoreCase("image/gif"))) {
                                        i++;
                                    }
                                }
                            }
                            if (i != 0) {
                                String sb = new StringBuilder(String.valueOf(i)).toString();
                                a aVar = new a();
                                aVar.a(string);
                                aVar.c(sb);
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
                            }
                        } while (cursor.moveToNext());
                        com.baidu.adp.lib.f.a.a(cursor);
                        return list;
                    }
                    com.baidu.adp.lib.f.a.a(cursor);
                    return list;
                } catch (Exception e) {
                    e = e;
                    str = this.a.a;
                    com.baidu.adp.lib.util.e.b(str, "getAlbumData", "error = " + e.getMessage());
                    com.baidu.adp.lib.f.a.a(cursor);
                    return list;
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
    }
}
