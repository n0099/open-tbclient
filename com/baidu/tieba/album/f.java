package com.baidu.tieba.album;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.img.ImageFileInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Object, Integer, List<a>> {
    private final o aoX;
    final /* synthetic */ e aoY;

    public f(e eVar, o oVar) {
        this.aoY = eVar;
        this.aoX = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public List<a> doInBackground(Object... objArr) {
        Context context;
        Context context2;
        context = this.aoY.mContext;
        List<a> a = a(context, null, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        context2 = this.aoY.mContext;
        return a(context2, a, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        if (this.aoX != null) {
            this.aoX.jH();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public void onPostExecute(List<a> list) {
        super.onPostExecute(list);
        if (this.aoX != null) {
            this.aoX.C(list);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.database.Cursor] */
    private List<a> a(Context context, List<a> list, Uri uri) {
        Cursor cursor;
        String str;
        File[] listFiles;
        Matcher matcher;
        if (context == null) {
            return null;
        }
        Pattern compile = Pattern.compile("image\\/\\w+", 2);
        if (list == null) {
            list = new ArrayList<>();
        }
        ?? r2 = "count(*)";
        try {
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"bucket_id", "bucket_display_name", "_data", "count(*)"}, "mime_type like 'image/%') GROUP BY 1,(2", null, "datetaken DESC");
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
                                    String mimeType = this.aoY.getMimeType(file2.getAbsolutePath());
                                    if (mimeType != null && (matcher = compile.matcher(mimeType)) != null && matcher.matches()) {
                                        i++;
                                    }
                                }
                            }
                            if (i != 0) {
                                String sb = new StringBuilder(String.valueOf(i)).toString();
                                a aVar = new a();
                                aVar.eR(string);
                                aVar.eS(sb);
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                imageFileInfo.setFilePath(string3);
                                aVar.d(imageFileInfo);
                                aVar.setName(string2);
                                if (string2 != null) {
                                    str = this.aoY.aoU;
                                    if (string2.equals(str)) {
                                        list.add(0, aVar);
                                    }
                                }
                                list.add(aVar);
                            }
                        } while (cursor.moveToNext());
                        com.baidu.adp.lib.g.a.b(cursor);
                        return list;
                    }
                    com.baidu.adp.lib.g.a.b(cursor);
                    return list;
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    com.baidu.adp.lib.g.a.b(cursor);
                    return list;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.g.a.b((Cursor) r2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            r2 = 0;
            com.baidu.adp.lib.g.a.b((Cursor) r2);
            throw th;
        }
    }
}
