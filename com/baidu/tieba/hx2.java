package com.baidu.tieba;

import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class hx2 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<gx2> a;
    public ArrayList<MediaModel> b;
    public String c;
    public Handler d;

    public hx2(String str, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
        this.c = str;
        this.d = handler;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || TextUtils.equals(this.c, "video")) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, "date_added DESC");
            } catch (Exception e) {
                if (vw2.a) {
                    e.printStackTrace();
                }
            }
            if (cursor == null) {
                return;
            }
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex("_data"));
                long j = cursor.getLong(cursor.getColumnIndexOrThrow("date_added"));
                long j2 = cursor.getLong(cursor.getColumnIndexOrThrow("_size"));
                File file = new File(string);
                if (file.exists() && (vw2.d || !ww2.d(string))) {
                    ImageModel imageModel = new ImageModel(string);
                    imageModel.setAddDate(j);
                    imageModel.setSize(j2);
                    d(file, imageModel);
                }
            }
        } finally {
            kp4.d(null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a0, code lost:
        if (r11 != null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() {
        Cursor cursor;
        Throwable th;
        Exception e;
        MediaMetadataRetriever mediaMetadataRetriever;
        Throwable th2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || TextUtils.equals(this.c, "Image")) {
            return;
        }
        try {
            cursor = AppRuntime.getAppContext().getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, "date_added DESC");
        } catch (Exception e2) {
            cursor = null;
            e = e2;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            kp4.d(cursor);
            throw th;
        }
        if (cursor == null) {
            kp4.d(cursor);
            return;
        }
        while (cursor.moveToNext()) {
            try {
                try {
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                    long j = cursor.getLong(cursor.getColumnIndexOrThrow("date_added"));
                    long j2 = cursor.getInt(cursor.getColumnIndexOrThrow("duration"));
                    long j3 = cursor.getLong(cursor.getColumnIndexOrThrow("_size"));
                    int i = cursor.getInt(cursor.getColumnIndexOrThrow("width"));
                    int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("height"));
                    if (i <= 0 || i2 <= 0) {
                        try {
                            mediaMetadataRetriever = new MediaMetadataRetriever();
                            try {
                                try {
                                    mediaMetadataRetriever.setDataSource(string);
                                    String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                                    i = Integer.parseInt(extractMetadata);
                                    i2 = Integer.parseInt(extractMetadata2);
                                } catch (Throwable th4) {
                                    th2 = th4;
                                    if (mediaMetadataRetriever != null) {
                                        mediaMetadataRetriever.release();
                                    }
                                    throw th2;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                if (vw2.a) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            mediaMetadataRetriever = null;
                        } catch (Throwable th5) {
                            mediaMetadataRetriever = null;
                            th2 = th5;
                        }
                        mediaMetadataRetriever.release();
                    }
                    File file = new File(string);
                    if (file.exists()) {
                        VideoModel videoModel = new VideoModel(string);
                        videoModel.setAddDate(j);
                        videoModel.setDuration(j2);
                        videoModel.setSize(j3);
                        videoModel.setWidth(i);
                        videoModel.setHeight(i2);
                        d(file, videoModel);
                    }
                } catch (Exception e5) {
                    e = e5;
                    if (vw2.a) {
                        e.printStackTrace();
                    }
                    kp4.d(cursor);
                }
            } catch (Throwable th6) {
                th = th6;
                kp4.d(cursor);
                throw th;
            }
        }
        kp4.d(cursor);
    }

    public final void c(ArrayList<gx2> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            Iterator<gx2> it = arrayList.iterator();
            while (it.hasNext()) {
                gx2 next = it.next();
                next.i(new File(next.b()).lastModified());
            }
            Collections.sort(arrayList);
        }
    }

    public final void d(File file, MediaModel mediaModel) {
        String name;
        String path;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, file, mediaModel) == null) {
            if (file.getParentFile() != null) {
                name = file.getParentFile().getName();
                path = file.getParent();
            } else {
                name = file.getName();
                path = file.getPath();
            }
            gx2 gx2Var = new gx2();
            gx2Var.h(name);
            gx2Var.g(path);
            int indexOf = this.a.indexOf(gx2Var);
            if (indexOf >= 0) {
                this.a.get(indexOf).a(mediaModel);
            } else {
                gx2Var.a(mediaModel);
                this.a.add(gx2Var);
            }
            this.b.add(mediaModel);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            b();
            c(this.a);
            gx2 gx2Var = new gx2();
            gx2Var.h(ww2.b(AppRuntime.getAppContext(), this.c));
            gx2Var.d = this.b;
            this.a.add(0, gx2Var);
            Iterator<gx2> it = this.a.iterator();
            while (it.hasNext()) {
                Collections.sort(it.next().f());
            }
            Handler handler = this.d;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage(0);
                obtainMessage.obj = this.a;
                this.d.sendMessage(obtainMessage);
            }
        }
    }
}
