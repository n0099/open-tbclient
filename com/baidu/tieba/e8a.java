package com.baidu.tieba;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.provider.MediaStore;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes5.dex */
public class e8a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a implements Comparator<d8a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d8a d8aVar, d8a d8aVar2) {
            InterceptResult invokeLL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, d8aVar, d8aVar2)) == null) {
                if (d8aVar.b() < d8aVar2.b()) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (d8aVar.b() > d8aVar2.b()) {
                    return -1;
                }
                return i;
            }
            return invokeLL.intValue;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00d3, code lost:
        if (r2 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d5, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ec, code lost:
        if (r2 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ef, code lost:
        r15.moveToNext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f6, code lost:
        if (r8.d() == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0100, code lost:
        if (r8.a() == 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010a, code lost:
        if (c(r8.c()) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0114, code lost:
        if (r8.a() < 1000) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0116, code lost:
        r0 = r8.d();
        r2 = r0.substring(r9, r0.lastIndexOf("/"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x012a, code lost:
        if (r0.contains("/DCIM/") != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x012c, code lost:
        if (r2 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0132, code lost:
        if (r2.equals("/sdcard") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x013e, code lost:
        if (new java.io.File(r0).exists() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0140, code lost:
        r1.add(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0143, code lost:
        r5 = r21 + 1;
        r7 = r17;
        r9 = r18;
        r8 = r22;
        r6 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<d8a> a(Context context) {
        InterceptResult invokeL;
        Cursor cursor;
        Cursor cursor2;
        int i;
        ContentResolver contentResolver;
        String str;
        int i2;
        d8a d8aVar;
        Cursor cursor3;
        ContentResolver contentResolver2;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            ContentResolver contentResolver3 = context.getContentResolver();
            String str2 = "_id";
            try {
                Cursor query = contentResolver3.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "duration", "mime_type", "date_modified"}, null, null, "title");
                try {
                    String[] strArr = {"video_id", "_data"};
                    query.moveToFirst();
                    int count = query.getCount();
                    int i3 = 0;
                    int i4 = 0;
                    while (i4 < count) {
                        d8a d8aVar2 = new d8a();
                        String string2 = query.getString(query.getColumnIndex(str2));
                        d8aVar2.i(string2);
                        String string3 = query.getString(query.getColumnIndex("_data"));
                        if (string3 != null) {
                            d8aVar2.j(string3.replace("/storage/emulated/0", "/sdcard"));
                        }
                        int i5 = count;
                        d8aVar2.e(tg.e(query.getString(query.getColumnIndex("duration")), i3));
                        d8aVar2.g(query.getString(query.getColumnIndex("mime_type")));
                        d8aVar2.f(Long.parseLong(query.getString(query.getColumnIndex("date_modified"))));
                        try {
                            try {
                                contentResolver2 = contentResolver3;
                                i = i4;
                                contentResolver = contentResolver3;
                                str = str2;
                                i2 = 0;
                                d8aVar = d8aVar2;
                            } catch (Exception e) {
                                e = e;
                                i = i4;
                                contentResolver = contentResolver3;
                                str = str2;
                                i2 = 0;
                                d8aVar = d8aVar2;
                            }
                            try {
                                cursor3 = contentResolver2.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, strArr, "video_id=" + string2, null, null);
                                if (cursor3 != null) {
                                    try {
                                        try {
                                            if (cursor3.moveToFirst() && (string = cursor3.getString(cursor3.getColumnIndex("_data"))) != null) {
                                                d8aVar.h(string.replace("/storage/emulated/0", "/sdcard"));
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor2 = cursor3;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        e.printStackTrace();
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                cursor3 = null;
                                e.printStackTrace();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = null;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e4) {
                    e = e4;
                    cursor = query;
                    try {
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    } catch (Throwable th3) {
                        th = th3;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    cursor = query;
                    if (cursor != null) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                cursor = null;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static d8a b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                d8a d8aVar = new d8a();
                d8aVar.j(str);
                d8aVar.f(file.lastModified());
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    try {
                        try {
                            mediaMetadataRetriever.setDataSource(str);
                            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                            if (extractMetadata != null) {
                                d8aVar.e(Integer.parseInt(extractMetadata));
                            }
                            d8aVar.g(mediaMetadataRetriever.extractMetadata(12));
                            mediaMetadataRetriever.release();
                        } catch (Exception e) {
                            e.printStackTrace();
                            mediaMetadataRetriever.release();
                        }
                    } catch (Throwable th) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                return d8aVar;
            }
            return null;
        }
        return (d8a) invokeL.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!"video/mp4".equals(str) && !"video/ext-mp4".equals(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void e(List<d8a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void d(String str, List<d8a> list, boolean z) {
        File[] listFiles;
        d8a b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65539, null, str, list, z) == null) && list != null && !StringUtils.isNull(str) && (listFiles = new File(str).listFiles()) != null && listFiles.length != 0) {
            for (File file : listFiles) {
                if (file != null && !StringUtils.isNull(file.getPath())) {
                    String path = file.getPath();
                    if (file.isFile()) {
                        if (path.contains("_tiebaconverting.mp4")) {
                            if (file.exists()) {
                                file.delete();
                            }
                        } else if (path.contains(DefaultHlsExtractorFactory.MP4_FILE_EXTENSION) && DefaultHlsExtractorFactory.MP4_FILE_EXTENSION.equals(path.substring(path.lastIndexOf(DefaultHlsExtractorFactory.MP4_FILE_EXTENSION))) && (b = b(file.getPath())) != null && file.length() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT && b.a() >= 1000 && c(b.c())) {
                            list.add(b);
                        }
                    } else if (file.isDirectory() && !path.contains(com.kuaishou.weapon.p0.i1.j) && z) {
                        d(path, list, z);
                    }
                }
            }
        }
    }
}
