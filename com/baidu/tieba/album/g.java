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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Object, Integer, List<ImageFileInfo>> {
    final /* synthetic */ e ahJ;
    private final al ahK;
    private final String ahL;
    private String ahM;

    public g(e eVar, String str, al alVar) {
        this.ahJ = eVar;
        this.ahK = alVar;
        this.ahL = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: j */
    public List<ImageFileInfo> doInBackground(Object... objArr) {
        Context context;
        Context context2;
        String str = this.ahL;
        context = this.ahJ.mContext;
        List<ImageFileInfo> a = a(str, context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if (a == null || a.size() <= 0) {
            String str2 = this.ahL;
            context2 = this.ahJ.mContext;
            return a(str2, context2, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        if (this.ahK != null) {
            this.ahK.hL();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: i */
    public void onPostExecute(List<ImageFileInfo> list) {
        super.onPostExecute(list);
        if (this.ahK != null) {
            this.ahK.a(list, this.ahM);
        }
    }

    private List<ImageFileInfo> a(String str, Context context, Uri uri) {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"bucket_id", "_data", "bucket_display_name"}, "bucket_id=?", new String[]{str}, "datetaken DESC");
            try {
                try {
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    com.baidu.adp.lib.g.a.a(cursor);
                    return arrayList;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.g.a.a(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.adp.lib.g.a.a(cursor);
            throw th;
        }
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("_data");
            int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
            do {
                String string = cursor.getString(columnIndex);
                this.ahM = cursor.getString(columnIndex2);
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setAlbumnId(str);
                imageFileInfo.setFilePath(string);
                if (new File(string).exists()) {
                    arrayList.add(imageFileInfo);
                }
            } while (cursor.moveToNext());
            com.baidu.adp.lib.g.a.a(cursor);
            return arrayList;
        }
        com.baidu.adp.lib.g.a.a(cursor);
        return arrayList;
    }
}
