package com.baidu.tieba.album;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.img.ImageFileInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Void, Integer, List<ImageFileInfo>> {
    final /* synthetic */ e apW;
    private final aq apX;
    private final String apY;
    private String apZ;
    private List<a> aqa;

    public g(e eVar, String str, aq aqVar) {
        this.apW = eVar;
        this.apX = aqVar;
        this.apY = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public List<ImageFileInfo> doInBackground(Void... voidArr) {
        List<a> BM;
        List<ImageFileInfo> eW;
        if (TextUtils.isEmpty(this.apY)) {
            return null;
        }
        if (!this.apY.equals("-1")) {
            return eW(this.apY);
        }
        ArrayList arrayList = new ArrayList();
        BM = this.apW.BM();
        this.aqa = BM;
        if (this.aqa != null) {
            for (a aVar : this.aqa) {
                String albumId = aVar.getAlbumId();
                if (!TextUtils.isEmpty(albumId) && (eW = eW(albumId)) != null && eW.size() > 0) {
                    arrayList.addAll(eW);
                }
            }
        }
        return arrayList;
    }

    private List<ImageFileInfo> eW(String str) {
        Context context;
        Context context2;
        context = this.apW.mContext;
        List<ImageFileInfo> a = a(str, context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if (a == null || a.size() <= 0) {
            context2 = this.apW.mContext;
            return a(str, context2, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        if (this.apX != null) {
            this.apX.jG();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public void onPostExecute(List<ImageFileInfo> list) {
        super.onPostExecute(list);
        if (this.apX != null) {
            this.apX.a(this.aqa, list, this.apZ);
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
                    com.baidu.adp.lib.g.a.b(cursor);
                    return arrayList;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.g.a.b(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.adp.lib.g.a.b(cursor);
            throw th;
        }
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("_data");
            int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
            do {
                String string = cursor.getString(columnIndex);
                this.apZ = cursor.getString(columnIndex2);
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setAlbumnId(str);
                imageFileInfo.setFilePath(string);
                if (new File(string).exists()) {
                    arrayList.add(imageFileInfo);
                }
            } while (cursor.moveToNext());
            com.baidu.adp.lib.g.a.b(cursor);
            return arrayList;
        }
        com.baidu.adp.lib.g.a.b(cursor);
        return arrayList;
    }
}
