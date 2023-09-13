package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fib;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import com.google.android.material.badge.BadgeDrawable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class dfb extends cfb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int h;
    public int i;
    public int j;
    public xeb k;
    public long l;
    public boolean m;
    public boolean n;
    public yeb o;
    public boolean p;
    public boolean q;
    public zeb r;

    /* loaded from: classes5.dex */
    public class a implements fib.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ dfb b;

        public a(dfb dfbVar, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dfbVar, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dfbVar;
            this.a = sb;
        }

        @Override // com.baidu.tieba.fib.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.fib.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(",createMuteAudio ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                iib.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.fib.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                iib.j("FFmpegChain", " createMuteAudio 进度i1 = " + i2);
                dfb dfbVar = this.b;
                dfbVar.i((int) (((float) dfbVar.i) + (((((float) i2) * 1.0f) / 100.0f) * 10.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements fib.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ dfb b;

        public b(dfb dfbVar, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dfbVar, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dfbVar;
            this.a = sb;
        }

        @Override // com.baidu.tieba.fib.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.fib.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(",concatAudio ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                iib.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.fib.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                iib.j("FFmpegChain", " concatMuteAudio 进度i1 = " + i2);
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements fib.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ xeb b;
        public final /* synthetic */ dfb c;

        public c(dfb dfbVar, StringBuilder sb, xeb xebVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dfbVar, sb, xebVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dfbVar;
            this.a = sb;
            this.b = xebVar;
        }

        @Override // com.baidu.tieba.fib.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.c) {
                    this.c.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.fib.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(",dealAudioPlayData ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                xeb xebVar = this.b;
                if (xebVar != null && xebVar.a() != null) {
                    this.a.append(",audioformat:");
                    this.a.append(this.b.a().f());
                    this.a.append(",audiopath:");
                    this.a.append(this.b.a().h());
                }
                iib.j("FFmpegChain", sb2);
                synchronized (this.c) {
                    this.c.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.fib.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                iib.j("FFmpegChain", " dealAudioPlayData 进度i1 = " + i2);
                dfb dfbVar = this.c;
                dfbVar.i(dfbVar.i + ((int) ((((((float) (this.c.j + (-1))) + ((((float) i2) * 1.0f) / 100.0f)) * 1.0f) / ((float) this.c.h)) * 60.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements fib.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ dfb b;

        public d(dfb dfbVar, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dfbVar, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dfbVar;
            this.a = sb;
        }

        @Override // com.baidu.tieba.fib.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.fib.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("concatAudio ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                iib.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.fib.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                iib.j("FFmpegChain", " concatAudio 进度i1 = " + i2);
                dfb dfbVar = this.b;
                dfbVar.i((int) (((float) dfbVar.i) + (((((float) i2) * 1.0f) / 100.0f) * 10.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements fib.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ dfb b;

        public e(dfb dfbVar, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dfbVar, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dfbVar;
            this.a = sb;
        }

        @Override // com.baidu.tieba.fib.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.fib.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("mixAudio ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                iib.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.fib.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                iib.j("FFmpegChain", " mixAudio 进度i1 = " + i2);
                dfb dfbVar = this.b;
                dfbVar.i((int) (((float) dfbVar.i) + (((((float) i2) * 1.0f) / 100.0f) * 20.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    public dfb() {
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

    public final void A() {
        String str;
        String a2;
        yeb yebVar;
        xeb xebVar;
        yeb yebVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            xeb xebVar2 = this.k;
            boolean z = xebVar2 != null && xebVar2.c();
            if (!z && ((yebVar2 = this.o) == null || !FileUtils.isExists(yebVar2.h()))) {
                g("nosource to create mute audio");
                return;
            }
            if (z && (yebVar = this.o) != null && (xebVar = this.k) != null && !yebVar.equals(xebVar.a())) {
                z = false;
            }
            StringBuilder sb = new StringBuilder();
            str = "";
            if (!z) {
                try {
                } catch (Throwable th) {
                    sb.append(th.getMessage());
                }
                if (this.o == null) {
                    return;
                }
                str = a(this.o.h(), "_mute.aac");
                xgb.l(this.o.h(), str, -1, -1, 0.0f, -1, 0.0f, -1.0f, false, new a(this, sb));
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e2) {
                    sb.append(e2.getMessage());
                }
                if (FileUtils.isExists(a2) && TextUtils.isEmpty(sb.toString())) {
                    iib.j("FFmpegChain", "createconcatMuteAudio 生成成功");
                    this.k = new xeb(new AudioPlayData(a2, 0, -1, 1.0f));
                    return;
                }
                g(sb.toString());
            }
            xeb xebVar3 = this.k;
            str = xebVar3 != null ? xebVar3.a().h() : "";
            i(this.i + 10);
            if (FileUtils.isExists(str) && TextUtils.isEmpty(sb.toString())) {
                iib.j("FFmpegChain", "createMuteAudio 生成成功");
                xeb xebVar4 = new xeb(new AudioPlayData(str, 0, -1, 1.0f));
                this.k = xebVar4;
                if (xebVar4.a() == null || this.k.a().e() <= 0) {
                    return;
                }
                long e3 = this.k.a().e();
                long j = this.l;
                if (e3 >= j) {
                    return;
                }
                int e4 = (int) ((j / this.k.a().e()) + 1);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < e4; i++) {
                    arrayList.add(str);
                }
                a2 = a(str, "_concat.aac");
                xgb.b(arrayList, a2, this.g, new b(this, sb), false, true);
                try {
                } catch (InterruptedException e5) {
                    sb.append(e5.getMessage());
                }
                synchronized (this) {
                    wait();
                    if (FileUtils.isExists(a2)) {
                        iib.j("FFmpegChain", "createconcatMuteAudio 生成成功");
                        this.k = new xeb(new AudioPlayData(a2, 0, -1, 1.0f));
                        return;
                    }
                }
            }
            g(sb.toString());
        }
    }

    public final void B(zeb zebVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zebVar) == null) {
            if (zebVar == null || nib.e(zebVar.c())) {
                g("concatAudio tempDataForOutPut data error");
                return;
            }
            List<bfb> c2 = zebVar.c();
            StringBuilder sb = new StringBuilder();
            for (bfb bfbVar : c2) {
                if (!nib.e(bfbVar.a())) {
                    ArrayList arrayList = new ArrayList();
                    for (xeb xebVar : bfbVar.a()) {
                        if (xebVar.b() != null) {
                            arrayList.add(xebVar.b().audioPath);
                        }
                    }
                    if (!nib.e(arrayList)) {
                        String str = this.g;
                        if (TextUtils.isEmpty(str)) {
                            str = FileUtils.getParentDir((String) arrayList.get(0));
                        }
                        String str2 = str + System.currentTimeMillis() + "_trackconcat.aac";
                        xgb.b(arrayList, str2, this.g, new d(this, sb), false, true);
                        try {
                            synchronized (this) {
                                wait();
                            }
                        } catch (InterruptedException e2) {
                            sb.append(e2.getMessage());
                        }
                        if (FileUtils.isExists(str2) && TextUtils.isEmpty(sb.toString())) {
                            iib.j("FFmpegChain", "concatAudio 生成成功");
                            xeb xebVar2 = new xeb(new AudioPlayData(str2, 0, -1, 1.0f));
                            bfbVar.a().clear();
                            bfbVar.a().add(xebVar2);
                        } else {
                            g(sb.toString());
                        }
                    }
                }
            }
        }
    }

    public final void C(zeb zebVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zebVar) == null) {
            if (zebVar == null || nib.b(zebVar.c()) < 2) {
                str = "mixAudio tempDataForOutPut data error";
            } else {
                List<bfb> c2 = zebVar.c();
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                for (bfb bfbVar : c2) {
                    if (bfbVar != null && !nib.e(bfbVar.a())) {
                        xeb xebVar = bfbVar.a().get(0);
                        if (xebVar.b() != null) {
                            arrayList.add(xebVar.b().audioPath);
                        }
                    }
                }
                if (arrayList.size() >= 2) {
                    String str2 = this.g;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = FileUtils.getParentDir((String) arrayList.get(0));
                    }
                    String str3 = str2 + System.currentTimeMillis() + "_mix.aac";
                    xgb.k(arrayList, str3, -1, new e(this, sb));
                    try {
                        synchronized (this) {
                            wait();
                        }
                    } catch (InterruptedException e2) {
                        sb.append(e2.getMessage());
                    }
                    if (!FileUtils.isExists(str3) || !TextUtils.isEmpty(sb.toString())) {
                        g(sb.toString());
                        return;
                    }
                    iib.j("FFmpegChain", "mixAudio 生成成功");
                    xeb xebVar2 = new xeb(new AudioPlayData(str3, 0, -1, 1.0f));
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(xebVar2);
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(new bfb(arrayList2));
                    this.r = new zeb(arrayList3);
                    return;
                }
                str = "mixAudio inputList data error";
            }
            g(str);
        }
    }

    @Override // com.baidu.tieba.cfb
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f = true;
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.cfb
    public void d(zeb zebVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zebVar) == null) {
            if (zebVar == null || nib.e(zebVar.c())) {
                g("input data error: null or length=0");
                return;
            }
            this.m = false;
            this.n = false;
            this.p = false;
            this.q = false;
            if (!j(zebVar)) {
                l(zebVar);
                return;
            }
            String a2 = zebVar.a();
            this.g = a2;
            if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                new File(this.g).mkdir();
            }
            this.e = false;
            this.f = false;
            this.k = zebVar.b();
            x(zebVar);
            y(zebVar);
            this.i = 0;
            if (this.m && !this.f && !this.e) {
                A();
            }
            if (this.n && !this.f && !this.e) {
                this.i = 10;
                i(10);
                z(zebVar);
            }
            if (this.p && !this.f && !this.e) {
                this.i = 70;
                i(70);
                B(this.r);
            }
            if (this.q && !this.f && !this.e) {
                this.i = 80;
                i(80);
                C(this.r);
            }
            if (this.e || this.f) {
                return;
            }
            l(this.r);
        }
    }

    @Override // com.baidu.tieba.cfb
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final void q(xeb xebVar, int i) {
        int i2;
        xeb xebVar2;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, xebVar, i) == null) || this.e || this.f) {
            return;
        }
        AudioPlayData b2 = xebVar.b();
        if (b2 == null) {
            sb = new StringBuilder();
            str = "dealAudioPlayData audioPlayData = null,trackIndx:";
        } else if (this.o != null) {
            if (!xebVar.c() && (xebVar2 = this.k) != null && xebVar2.b() != null) {
                b2.audioPath = this.k.b().audioPath;
                xebVar.d(this.k.a());
            }
            StringBuilder sb2 = new StringBuilder();
            String str2 = b2.audioPath;
            String a2 = a(str2, System.currentTimeMillis() + "_ffmpeg.aac");
            try {
                boolean z = xebVar.a() != null && "audio/mp4a-latm".equals(xebVar.a().f());
                String str3 = b2.audioPath;
                int g = this.o.g();
                int d2 = this.o.d();
                float f = b2.volume;
                int c2 = this.o.c();
                float f2 = (b2.start * 1.0f) / 1000.0f;
                float f3 = ((b2.end - b2.start) * 1.0f) / 1000.0f;
                i2 = 0;
                try {
                    xgb.l(str3, a2, g, d2, f, c2, f2, f3, !z, new c(this, sb2, xebVar));
                    try {
                        synchronized (this) {
                            wait();
                        }
                    } catch (InterruptedException e2) {
                        sb2.append(e2.getMessage());
                    }
                } catch (Throwable th) {
                    th = th;
                    sb2.append(th.getMessage());
                    if (FileUtils.isExists(a2)) {
                    }
                    g(sb2.toString());
                    return;
                }
            } catch (Throwable th2) {
                th = th2;
                i2 = 0;
            }
            if (FileUtils.isExists(a2) || !TextUtils.isEmpty(sb2.toString())) {
                g(sb2.toString());
                return;
            }
            iib.j("FFmpegChain", "dealAudioPlayData 生成成功");
            r(this.r, new xeb(new AudioPlayData(a2, i2, -1, 1.0f)), i);
            return;
        } else {
            sb = new StringBuilder();
            str = "dealAudioPlayData mTargetInfo = null ,trackIndx:";
        }
        sb.append(str);
        sb.append(i);
        g(sb.toString());
    }

    public final void r(zeb zebVar, xeb xebVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048583, this, zebVar, xebVar, i) == null) || zebVar == null || zebVar.c() == null || zebVar.c().get(i) == null) {
            return;
        }
        zebVar.c().get(i).a().add(xebVar);
    }

    public final void s(bfb bfbVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, bfbVar, i) == null) || bfbVar == null || nib.e(bfbVar.a()) || this.f || this.e) {
            return;
        }
        for (int i2 = 0; !this.e && !this.f && i2 < bfbVar.a().size(); i2++) {
            xeb xebVar = bfbVar.a().get(i2);
            this.j++;
            if (v(xebVar)) {
                q(xebVar, i);
            } else {
                r(this.r, xebVar, i);
                i(this.i + ((int) (((this.j * 1.0f) / this.h) * 60.0f)));
            }
        }
    }

    public final boolean t(xeb xebVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, xebVar)) == null) {
            if (xebVar == null || xebVar.b() == null || !FileUtils.isExists(xebVar.b().audioPath)) {
                return false;
            }
            if (xebVar.b().start <= 0 && xebVar.b().end <= 0 && xebVar.b().volume == 1.0f) {
                return (xebVar.a() == null || "audio/mp4a-latm".equals(xebVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean v(xeb xebVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, xebVar)) == null) {
            if (xebVar == null) {
                return false;
            }
            return t(xebVar) || xebVar.a() == null || xebVar.a().k(this.o) != 0;
        }
        return invokeL.booleanValue;
    }

    public final void x(zeb zebVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, zebVar) == null) {
            List<bfb> c2 = zebVar.c();
            HashMap hashMap = new HashMap();
            if (c2.size() > 1) {
                this.q = true;
            }
            int i = 0;
            for (int i2 = 0; i2 < c2.size(); i2++) {
                if (!nib.e(c2.get(i2).a())) {
                    this.h += nib.b(c2.get(i2).a());
                    List<xeb> a2 = c2.get(i2).a();
                    if (!nib.e(a2)) {
                        if (a2.size() > 1) {
                            this.p = true;
                        }
                        for (xeb xebVar : a2) {
                            if (xebVar != null && xebVar.b() != null && !xebVar.c()) {
                                long j = xebVar.b().end - xebVar.b().start;
                                if (j > this.l) {
                                    this.l = j;
                                }
                                this.m = true;
                                this.n = true;
                            }
                            if (t(xebVar)) {
                                this.n = true;
                            }
                            if (xebVar != null && xebVar.a() != null) {
                                Integer num = (Integer) hashMap.get(xebVar.a());
                                if (num == null) {
                                    num = 0;
                                }
                                hashMap.put(xebVar.a(), Integer.valueOf(num.intValue() + 1));
                            }
                        }
                    }
                }
            }
            if (hashMap.size() > 1) {
                this.n = true;
            }
            for (yeb yebVar : hashMap.keySet()) {
                if (((Integer) hashMap.get(yebVar)).intValue() > i && "audio/mp4a-latm".equals(yebVar.f())) {
                    this.o = yebVar;
                    i = ((Integer) hashMap.get(yebVar)).intValue();
                }
            }
            if (this.o == null) {
                this.o = yeb.b();
            }
        }
    }

    public final void y(zeb zebVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, zebVar) == null) {
            if (this.n) {
                if (zebVar == null || nib.e(zebVar.c())) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < zebVar.c().size(); i++) {
                    arrayList.add(new bfb(new ArrayList()));
                }
                zebVar = new zeb(arrayList);
            }
            this.r = zebVar;
        }
    }

    public final void z(zeb zebVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, zebVar) == null) {
            List<bfb> c2 = zebVar.c();
            int size = c2.size();
            for (int i = 0; i < size; i++) {
                s(c2.get(i), i);
            }
        }
    }
}
