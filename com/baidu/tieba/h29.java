package com.baidu.tieba;

import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface;
import com.baidu.ugc.editvideo.faceunity.encoder.MediaCodecHelper;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class h29 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h29 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<b> a;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b extends MediaMetadataRetriever implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean a;
        public String b;
        public boolean c;
        public volatile boolean d;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q29 a;
            public final /* synthetic */ p29 b;
            public final /* synthetic */ b c;

            public a(b bVar, q29 q29Var, p29 p29Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, q29Var, p29Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = q29Var;
                this.b = p29Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ArrayList<k29> arrayList = new ArrayList();
                    ArrayList<k29> arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (k29 k29Var : this.a.e) {
                        int i = k29Var.g;
                        if (i == 0) {
                            arrayList.add(k29Var);
                        } else if (i == 1) {
                            arrayList2.add(k29Var);
                        }
                    }
                    if (!wi9.e(arrayList)) {
                        for (k29 k29Var2 : arrayList) {
                            Bitmap d = l29.f().d(k29Var2.a);
                            if (d == null || d.isRecycled()) {
                                d = si9.e(k29Var2.b, k29Var2.h, k29Var2.i, k29Var2.c);
                                l29.f().g().b(k29Var2.a, d);
                                l29.f().e().c(k29Var2.a, d);
                            }
                            k29Var2.e = d;
                            k29Var2.a();
                        }
                    }
                    if (!wi9.e(arrayList2)) {
                        for (k29 k29Var3 : arrayList2) {
                            Bitmap d2 = l29.f().d(k29Var3.a);
                            if (d2 != null && !d2.isRecycled()) {
                                k29Var3.e = d2;
                                k29Var3.a();
                            } else {
                                arrayList3.add(k29Var3);
                            }
                        }
                    }
                    if (!wi9.e(arrayList3)) {
                        this.a.e = arrayList3;
                        if (!this.c.g()) {
                            this.c.j(this.a);
                        } else {
                            this.c.i(this.a);
                        }
                        this.c.k(this.b);
                        return;
                    }
                    this.c.k(this.b);
                }
            }
        }

        /* renamed from: com.baidu.tieba.h29$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0284b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p29 a;
            public final /* synthetic */ b b;

            public RunnableC0284b(b bVar, p29 p29Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, p29Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = p29Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                p29 p29Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (p29Var = this.a) != null) {
                    p29Var.a(this.b);
                }
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = true;
        }

        @Override // android.media.MediaMetadataRetriever, java.lang.AutoCloseable, java.io.Closeable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                release();
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.d;
            }
            return invokeV.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.c && !lj9.a(this.b)) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // android.media.MediaMetadataRetriever
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                super.release();
                this.a = true;
                this.d = false;
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public final void i(q29 q29Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, q29Var) == null) {
                try {
                    e(q29Var.a, q29Var.e, q29Var.c, q29Var.d, q29Var.b);
                } catch (Exception e) {
                    e.printStackTrace();
                    j(q29Var);
                }
            }
        }

        public final void k(p29 p29Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, p29Var) == null) {
                this.d = false;
                jj9.a().post(new RunnableC0284b(this, p29Var));
            }
        }

        public void l(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                this.d = z;
            }
        }

        public void m(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
                this.c = z;
            }
        }

        @Override // android.media.MediaMetadataRetriever
        public void setDataSource(String str) throws IllegalArgumentException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                try {
                    super.setDataSource(str);
                    this.b = str;
                } catch (Exception e) {
                    ri9.g(e);
                }
            }
        }

        public void h(q29 q29Var, p29 p29Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, q29Var, p29Var) == null) {
                if (q29Var != null && !wi9.e(q29Var.e)) {
                    this.d = true;
                    ThreadPool.b().e(new a(this, q29Var, p29Var));
                    return;
                }
                k(p29Var);
            }
        }

        public final void d(MediaExtractor mediaExtractor, int i, MediaCodec mediaCodec, BaseOutputSurface baseOutputSurface, List<k29> list) throws IOException {
            String str;
            int i2;
            long j;
            int i3;
            boolean z;
            boolean z2;
            int dequeueInputBuffer;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{mediaExtractor, Integer.valueOf(i), mediaCodec, baseOutputSurface, list}) == null) {
                ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                long j3 = 0;
                int i4 = 0;
                if (wi9.b(list) == 1) {
                    k29 k29Var = (k29) wi9.c(list, 0);
                    if (k29Var != null) {
                        j2 = k29Var.d;
                    } else {
                        j2 = 0;
                    }
                    if (j2 <= 0) {
                        j2 = 1;
                    }
                    mediaExtractor.getSampleTime();
                    mediaExtractor.seekTo(j2, 0);
                    if (mediaExtractor.getSampleTime() > j2) {
                        mediaExtractor.seekTo(0L, 2);
                    }
                }
                int i5 = 0;
                boolean z3 = false;
                boolean z4 = false;
                while (!z3 && !this.a) {
                    if (z4 || (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) < 0) {
                        str = "VideoFrameMetadataRetriever";
                        i2 = i5;
                        j = j3;
                    } else {
                        int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], i4);
                        if (readSampleData < 0) {
                            str = "VideoFrameMetadataRetriever";
                            i2 = i5;
                            j = j3;
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                            z4 = true;
                        } else {
                            str = "VideoFrameMetadataRetriever";
                            i2 = i5;
                            j = j3;
                            if (mediaExtractor.getSampleTrackIndex() != i) {
                                ri9.l(str, "WEIRD: got sample from track " + mediaExtractor.getSampleTrackIndex() + ", expected " + i);
                            }
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                            mediaExtractor.advance();
                        }
                    }
                    if (!z3) {
                        int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
                        if (dequeueOutputBuffer != -1 && dequeueOutputBuffer != -3) {
                            if (dequeueOutputBuffer == -2) {
                                mediaCodec.getOutputFormat();
                            } else if (dequeueOutputBuffer < 0) {
                                ri9.c(str, "unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                            } else {
                                if ((bufferInfo.flags & 4) != 0) {
                                    z = true;
                                } else {
                                    z = z3;
                                }
                                if (bufferInfo.size != 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z2);
                                if (z2) {
                                    i3 = i2;
                                    k29 k29Var2 = (k29) wi9.c(list, i3);
                                    baseOutputSurface.awaitNewImage();
                                    baseOutputSurface.drawImage((int) (((float) bufferInfo.presentationTimeUs) / 1000.0f));
                                    if (k29Var2 != null) {
                                        long j4 = k29Var2.d;
                                        if (j4 <= j) {
                                            j4 = 1;
                                        } else if (i3 == list.size() - 1) {
                                            j4 -= 800000;
                                        }
                                        if (bufferInfo.presentationTimeUs >= j4) {
                                            k29Var2.e = baseOutputSurface.getFrameBitmap();
                                            l29.f().g().b(k29Var2.a, k29Var2.e);
                                            k29Var2.a();
                                            l29.f().e().c(k29Var2.a, k29Var2.e);
                                            if (i3 == list.size() - 1) {
                                                z = true;
                                            }
                                            i5 = i3 + 1;
                                            z3 = z;
                                            j3 = j;
                                            i4 = 0;
                                        }
                                    }
                                } else {
                                    i3 = i2;
                                }
                                z3 = z;
                            }
                        }
                        i5 = i2;
                        j3 = j;
                        i4 = 0;
                    } else {
                        i3 = i2;
                    }
                    i5 = i3;
                    j3 = j;
                    i4 = 0;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:58:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void e(String str, List<k29> list, int i, int i2, float f) throws IOException {
            MediaExtractor mediaExtractor;
            MediaCodec mediaCodec;
            File file;
            int andSelectVideoTrackIndex;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, list, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)}) == null) {
                f29 f29Var = null;
                try {
                    file = new File(str);
                } catch (Exception e) {
                    e = e;
                    mediaExtractor = null;
                    mediaCodec = null;
                } catch (Throwable th) {
                    th = th;
                    mediaExtractor = null;
                    mediaCodec = null;
                }
                if (file.canRead()) {
                    mediaExtractor = new MediaExtractor();
                    try {
                        mediaExtractor.setDataSource(file.toString());
                        andSelectVideoTrackIndex = MediaCodecHelper.getAndSelectVideoTrackIndex(mediaExtractor);
                    } catch (Exception e2) {
                        e = e2;
                        mediaCodec = null;
                    } catch (Throwable th2) {
                        th = th2;
                        mediaCodec = null;
                    }
                    if (andSelectVideoTrackIndex >= 0) {
                        MediaFormat trackFormat = mediaExtractor.getTrackFormat(andSelectVideoTrackIndex);
                        int integer = trackFormat.getInteger("width");
                        int integer2 = trackFormat.getInteger("height");
                        if (i == 0 || i2 == 0) {
                            float f2 = f % 360.0f;
                            if (f2 != 90.0f && f2 != 270.0f) {
                                i = integer;
                                i2 = integer2;
                            }
                            i2 = integer;
                            i = integer2;
                        }
                        f29 f29Var2 = new f29(i, i2, true, null);
                        try {
                            f29Var2.a(integer, integer2, f);
                            mediaCodec = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
                        } catch (Exception e3) {
                            e = e3;
                            mediaCodec = null;
                        } catch (Throwable th3) {
                            th = th3;
                            mediaCodec = null;
                        }
                        try {
                            mediaCodec.configure(trackFormat, f29Var2.getSurface(), (MediaCrypto) null, 0);
                            mediaCodec.start();
                            d(mediaExtractor, andSelectVideoTrackIndex, mediaCodec, f29Var2, list);
                            f29Var2.release();
                            if (mediaCodec != null) {
                                mediaCodec.stop();
                                mediaCodec.release();
                            }
                        } catch (Exception e4) {
                            e = e4;
                            f29Var = f29Var2;
                            try {
                                ri9.g(e);
                                if (f29Var != null) {
                                    f29Var.release();
                                }
                                if (mediaCodec != null) {
                                    mediaCodec.stop();
                                    mediaCodec.release();
                                }
                                if (mediaExtractor == null) {
                                    return;
                                }
                                mediaExtractor.release();
                                return;
                            } catch (Throwable th4) {
                                th = th4;
                                if (f29Var != null) {
                                    f29Var.release();
                                }
                                if (mediaCodec != null) {
                                    mediaCodec.stop();
                                    mediaCodec.release();
                                }
                                if (mediaExtractor != null) {
                                    mediaExtractor.release();
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            f29Var = f29Var2;
                            if (f29Var != null) {
                            }
                            if (mediaCodec != null) {
                            }
                            if (mediaExtractor != null) {
                            }
                            throw th;
                        }
                        mediaExtractor.release();
                        return;
                    }
                    throw new RuntimeException("No video track found in " + file);
                }
                throw new FileNotFoundException("Unable to read " + file);
            }
        }

        public final void j(q29 q29Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, q29Var) == null) {
                try {
                    for (k29 k29Var : q29Var.e) {
                        Bitmap frameAtTime = getFrameAtTime(k29Var.d, 2);
                        if (frameAtTime != null) {
                            if (q29Var.c != 0 && q29Var.d != 0) {
                                k29Var.e = ThumbnailUtils.extractThumbnail(frameAtTime, q29Var.c, q29Var.d, 2);
                            }
                            k29Var.a();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public h29() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.add(new b(null));
        this.a.add(new b(null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
        r2.l(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
        r0 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized b b() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                bVar = null;
                Iterator<b> it = this.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b next = it.next();
                    if (next != null && !next.f()) {
                        break;
                    }
                }
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public static h29 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (h29.class) {
                    if (b == null) {
                        b = new h29();
                    }
                }
            }
            return b;
        }
        return (h29) invokeV.objValue;
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && bVar != null) {
            bVar.l(false);
        }
    }
}
