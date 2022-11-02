package com.baidu.tieba;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MediaInfo;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class cj9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                return Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
            } catch (Exception e) {
                e.printStackTrace();
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static long b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            MediaMetadataRetriever mediaMetadataRetriever = null;
            try {
                if (!new File(str).exists()) {
                    return 0L;
                }
                MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever2.setDataSource(str);
                    long c = vi9.c(mediaMetadataRetriever2.extractMetadata(9), 0L);
                    try {
                        mediaMetadataRetriever2.release();
                    } catch (Exception unused) {
                    }
                    return c;
                } catch (Exception unused2) {
                    mediaMetadataRetriever = mediaMetadataRetriever2;
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception unused3) {
                        }
                    }
                    return 0L;
                } catch (Throwable th) {
                    th = th;
                    mediaMetadataRetriever = mediaMetadataRetriever2;
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return invokeL.longValue;
        }
    }

    public static int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    int b = vi9.b(mediaMetadataRetriever.extractMetadata(20), 0);
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return b;
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
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static int f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            MediaMetadataRetriever mediaMetadataRetriever = null;
            try {
                if (!new File(str).exists()) {
                    return 0;
                }
                MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever2.setDataSource(str);
                    int parseInt = Integer.parseInt(mediaMetadataRetriever2.extractMetadata(9));
                    try {
                        mediaMetadataRetriever2.release();
                    } catch (Exception unused) {
                    }
                    return parseInt;
                } catch (Exception unused2) {
                    mediaMetadataRetriever = mediaMetadataRetriever2;
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception unused3) {
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    mediaMetadataRetriever = mediaMetadataRetriever2;
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return invokeL.intValue;
        }
    }

    public static long c(String str, int i) {
        InterceptResult invokeLI;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            long j = 0;
            if (!FileUtils.isExists(str)) {
                return 0L;
            }
            MediaExtractor mediaExtractor = new MediaExtractor();
            try {
                try {
                    mediaExtractor.setDataSource(str);
                    MediaFormat mediaFormat = null;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= mediaExtractor.getTrackCount()) {
                            break;
                        }
                        MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
                        String string = trackFormat.getString("mime");
                        if (i == 0) {
                            str2 = "audio/";
                        } else {
                            str2 = com.sina.weibo.sdk.utils.FileUtils.VIDEO_FILE_START;
                        }
                        if (string.startsWith(str2)) {
                            mediaExtractor.selectTrack(i2);
                            mediaFormat = trackFormat;
                            break;
                        }
                        i2++;
                    }
                    if (mediaFormat != null) {
                        j = mediaFormat.getLong("durationUs");
                    }
                } catch (Exception e) {
                    ri9.e("VideoMuxer", "getMediaDurationMs error:" + e.getMessage());
                }
                return j / 1000;
            } finally {
                mediaExtractor.release();
            }
        }
        return invokeLI.longValue;
    }

    public static MediaInfo d(String str) {
        InterceptResult invokeL;
        MediaInfo mediaInfo;
        File file;
        MediaMetadataRetriever mediaMetadataRetriever;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever2 = null;
            try {
                try {
                    file = new File(str);
                } catch (Exception e) {
                    e = e;
                    mediaInfo = null;
                }
                if (file.exists() && file.isFile()) {
                    mediaInfo = new MediaInfo();
                    try {
                        mediaInfo.setVideoPath(str);
                        mediaInfo.setLastModified(file.lastModified());
                        mediaMetadataRetriever = new MediaMetadataRetriever();
                    } catch (Exception e2) {
                        e = e2;
                    }
                    try {
                        mediaMetadataRetriever.setDataSource(str);
                        mediaInfo.setDuration(Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)));
                        mediaInfo.setMimeType(mediaMetadataRetriever.extractMetadata(12));
                        mediaInfo.setVideoWidth(Integer.parseInt(mediaMetadataRetriever.extractMetadata(18)));
                        mediaInfo.setVideoHeight(Integer.parseInt(mediaMetadataRetriever.extractMetadata(19)));
                        mediaInfo.setRotation(vi9.b(mediaMetadataRetriever.extractMetadata(24), 0));
                        qi9.a(mediaMetadataRetriever);
                    } catch (Exception e3) {
                        e = e3;
                        mediaMetadataRetriever2 = mediaMetadataRetriever;
                        ri9.g(e);
                        if (mediaMetadataRetriever2 != null) {
                            qi9.a(mediaMetadataRetriever2);
                        }
                        return mediaInfo;
                    } catch (Throwable th) {
                        th = th;
                        mediaMetadataRetriever2 = mediaMetadataRetriever;
                        if (mediaMetadataRetriever2 != null) {
                            qi9.a(mediaMetadataRetriever2);
                        }
                        throw th;
                    }
                    return mediaInfo;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (MediaInfo) invokeL.objValue;
        }
    }

    @TargetApi(16)
    public static boolean g(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str);
            for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
                if (bj9.j(mediaExtractor.getTrackFormat(i))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
