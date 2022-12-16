package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jm9;
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
/* loaded from: classes4.dex */
public class hj9 extends gj9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int h;
    public int i;
    public int j;
    public bj9 k;
    public long l;
    public boolean m;
    public boolean n;
    public cj9 o;
    public boolean p;
    public boolean q;
    public dj9 r;

    /* loaded from: classes4.dex */
    public class a implements jm9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ hj9 b;

        public a(hj9 hj9Var, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hj9Var, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hj9Var;
            this.a = sb;
        }

        @Override // com.baidu.tieba.jm9.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.jm9.a
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
                mm9.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.jm9.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                mm9.j("FFmpegChain", " createMuteAudio 进度i1 = " + i2);
                hj9 hj9Var = this.b;
                hj9Var.i((int) (((float) hj9Var.i) + (((((float) i2) * 1.0f) / 100.0f) * 10.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements jm9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ hj9 b;

        public b(hj9 hj9Var, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hj9Var, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hj9Var;
            this.a = sb;
        }

        @Override // com.baidu.tieba.jm9.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.jm9.a
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
                mm9.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.jm9.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                mm9.j("FFmpegChain", " concatMuteAudio 进度i1 = " + i2);
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements jm9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ bj9 b;
        public final /* synthetic */ hj9 c;

        public c(hj9 hj9Var, StringBuilder sb, bj9 bj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hj9Var, sb, bj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hj9Var;
            this.a = sb;
            this.b = bj9Var;
        }

        @Override // com.baidu.tieba.jm9.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.c) {
                    this.c.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.jm9.a
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
                bj9 bj9Var = this.b;
                if (bj9Var != null && bj9Var.a() != null) {
                    this.a.append(",audioformat:");
                    this.a.append(this.b.a().f());
                    this.a.append(",audiopath:");
                    this.a.append(this.b.a().h());
                }
                mm9.j("FFmpegChain", sb2);
                synchronized (this.c) {
                    this.c.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.jm9.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                mm9.j("FFmpegChain", " dealAudioPlayData 进度i1 = " + i2);
                hj9 hj9Var = this.c;
                hj9Var.i(hj9Var.i + ((int) ((((((float) (this.c.j + (-1))) + ((((float) i2) * 1.0f) / 100.0f)) * 1.0f) / ((float) this.c.h)) * 60.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements jm9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ hj9 b;

        public d(hj9 hj9Var, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hj9Var, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hj9Var;
            this.a = sb;
        }

        @Override // com.baidu.tieba.jm9.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.jm9.a
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
                mm9.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.jm9.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                mm9.j("FFmpegChain", " concatAudio 进度i1 = " + i2);
                hj9 hj9Var = this.b;
                hj9Var.i((int) (((float) hj9Var.i) + (((((float) i2) * 1.0f) / 100.0f) * 10.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements jm9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ hj9 b;

        public e(hj9 hj9Var, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hj9Var, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hj9Var;
            this.a = sb;
        }

        @Override // com.baidu.tieba.jm9.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.jm9.a
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
                mm9.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.jm9.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                mm9.j("FFmpegChain", " mixAudio 进度i1 = " + i2);
                hj9 hj9Var = this.b;
                hj9Var.i((int) (((float) hj9Var.i) + (((((float) i2) * 1.0f) / 100.0f) * 20.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    public hj9() {
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
        cj9 cj9Var;
        bj9 bj9Var;
        cj9 cj9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            bj9 bj9Var2 = this.k;
            boolean z = bj9Var2 != null && bj9Var2.c();
            if (!z && ((cj9Var2 = this.o) == null || !FileUtils.isExists(cj9Var2.h()))) {
                g("nosource to create mute audio");
                return;
            }
            if (z && (cj9Var = this.o) != null && (bj9Var = this.k) != null && !cj9Var.equals(bj9Var.a())) {
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
                bl9.l(this.o.h(), str, -1, -1, 0.0f, -1, 0.0f, -1.0f, false, new a(this, sb));
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e2) {
                    sb.append(e2.getMessage());
                }
                if (FileUtils.isExists(a2) && TextUtils.isEmpty(sb.toString())) {
                    mm9.j("FFmpegChain", "createconcatMuteAudio 生成成功");
                    this.k = new bj9(new AudioPlayData(a2, 0, -1, 1.0f));
                    return;
                }
                g(sb.toString());
            }
            bj9 bj9Var3 = this.k;
            str = bj9Var3 != null ? bj9Var3.a().h() : "";
            i(this.i + 10);
            if (FileUtils.isExists(str) && TextUtils.isEmpty(sb.toString())) {
                mm9.j("FFmpegChain", "createMuteAudio 生成成功");
                bj9 bj9Var4 = new bj9(new AudioPlayData(str, 0, -1, 1.0f));
                this.k = bj9Var4;
                if (bj9Var4.a() == null || this.k.a().e() <= 0) {
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
                bl9.b(arrayList, a2, this.g, new b(this, sb), false, true);
                try {
                } catch (InterruptedException e5) {
                    sb.append(e5.getMessage());
                }
                synchronized (this) {
                    wait();
                    if (FileUtils.isExists(a2)) {
                        mm9.j("FFmpegChain", "createconcatMuteAudio 生成成功");
                        this.k = new bj9(new AudioPlayData(a2, 0, -1, 1.0f));
                        return;
                    }
                }
            }
            g(sb.toString());
        }
    }

    public final void B(dj9 dj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dj9Var) == null) {
            if (dj9Var == null || rm9.e(dj9Var.c())) {
                g("concatAudio tempDataForOutPut data error");
                return;
            }
            List<fj9> c2 = dj9Var.c();
            StringBuilder sb = new StringBuilder();
            for (fj9 fj9Var : c2) {
                if (!rm9.e(fj9Var.a())) {
                    ArrayList arrayList = new ArrayList();
                    for (bj9 bj9Var : fj9Var.a()) {
                        if (bj9Var.b() != null) {
                            arrayList.add(bj9Var.b().audioPath);
                        }
                    }
                    if (!rm9.e(arrayList)) {
                        String str = this.g;
                        if (TextUtils.isEmpty(str)) {
                            str = FileUtils.getParentDir((String) arrayList.get(0));
                        }
                        String str2 = str + System.currentTimeMillis() + "_trackconcat.aac";
                        bl9.b(arrayList, str2, this.g, new d(this, sb), false, true);
                        try {
                            synchronized (this) {
                                wait();
                            }
                        } catch (InterruptedException e2) {
                            sb.append(e2.getMessage());
                        }
                        if (FileUtils.isExists(str2) && TextUtils.isEmpty(sb.toString())) {
                            mm9.j("FFmpegChain", "concatAudio 生成成功");
                            bj9 bj9Var2 = new bj9(new AudioPlayData(str2, 0, -1, 1.0f));
                            fj9Var.a().clear();
                            fj9Var.a().add(bj9Var2);
                        } else {
                            g(sb.toString());
                        }
                    }
                }
            }
        }
    }

    public final void C(dj9 dj9Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dj9Var) == null) {
            if (dj9Var == null || rm9.b(dj9Var.c()) < 2) {
                str = "mixAudio tempDataForOutPut data error";
            } else {
                List<fj9> c2 = dj9Var.c();
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                for (fj9 fj9Var : c2) {
                    if (fj9Var != null && !rm9.e(fj9Var.a())) {
                        bj9 bj9Var = fj9Var.a().get(0);
                        if (bj9Var.b() != null) {
                            arrayList.add(bj9Var.b().audioPath);
                        }
                    }
                }
                if (arrayList.size() >= 2) {
                    String str2 = this.g;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = FileUtils.getParentDir((String) arrayList.get(0));
                    }
                    String str3 = str2 + System.currentTimeMillis() + "_mix.aac";
                    bl9.k(arrayList, str3, -1, new e(this, sb));
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
                    mm9.j("FFmpegChain", "mixAudio 生成成功");
                    bj9 bj9Var2 = new bj9(new AudioPlayData(str3, 0, -1, 1.0f));
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(bj9Var2);
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(new fj9(arrayList2));
                    this.r = new dj9(arrayList3);
                    return;
                }
                str = "mixAudio inputList data error";
            }
            g(str);
        }
    }

    @Override // com.baidu.tieba.gj9
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

    @Override // com.baidu.tieba.gj9
    public void d(dj9 dj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dj9Var) == null) {
            if (dj9Var == null || rm9.e(dj9Var.c())) {
                g("input data error: null or length=0");
                return;
            }
            this.m = false;
            this.n = false;
            this.p = false;
            this.q = false;
            if (!j(dj9Var)) {
                l(dj9Var);
                return;
            }
            String a2 = dj9Var.a();
            this.g = a2;
            if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                new File(this.g).mkdir();
            }
            this.e = false;
            this.f = false;
            this.k = dj9Var.b();
            x(dj9Var);
            y(dj9Var);
            this.i = 0;
            if (this.m && !this.f && !this.e) {
                A();
            }
            if (this.n && !this.f && !this.e) {
                this.i = 10;
                i(10);
                z(dj9Var);
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

    @Override // com.baidu.tieba.gj9
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final void q(bj9 bj9Var, int i) {
        int i2;
        bj9 bj9Var2;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, bj9Var, i) == null) || this.e || this.f) {
            return;
        }
        AudioPlayData b2 = bj9Var.b();
        if (b2 == null) {
            sb = new StringBuilder();
            str = "dealAudioPlayData audioPlayData = null,trackIndx:";
        } else if (this.o != null) {
            if (!bj9Var.c() && (bj9Var2 = this.k) != null && bj9Var2.b() != null) {
                b2.audioPath = this.k.b().audioPath;
                bj9Var.d(this.k.a());
            }
            StringBuilder sb2 = new StringBuilder();
            String str2 = b2.audioPath;
            String a2 = a(str2, System.currentTimeMillis() + "_ffmpeg.aac");
            try {
                boolean z = bj9Var.a() != null && "audio/mp4a-latm".equals(bj9Var.a().f());
                String str3 = b2.audioPath;
                int g = this.o.g();
                int d2 = this.o.d();
                float f = b2.volume;
                int c2 = this.o.c();
                float f2 = (b2.start * 1.0f) / 1000.0f;
                float f3 = ((b2.end - b2.start) * 1.0f) / 1000.0f;
                i2 = 0;
                try {
                    bl9.l(str3, a2, g, d2, f, c2, f2, f3, !z, new c(this, sb2, bj9Var));
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
            mm9.j("FFmpegChain", "dealAudioPlayData 生成成功");
            r(this.r, new bj9(new AudioPlayData(a2, i2, -1, 1.0f)), i);
            return;
        } else {
            sb = new StringBuilder();
            str = "dealAudioPlayData mTargetInfo = null ,trackIndx:";
        }
        sb.append(str);
        sb.append(i);
        g(sb.toString());
    }

    public final void r(dj9 dj9Var, bj9 bj9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048583, this, dj9Var, bj9Var, i) == null) || dj9Var == null || dj9Var.c() == null || dj9Var.c().get(i) == null) {
            return;
        }
        dj9Var.c().get(i).a().add(bj9Var);
    }

    public final void s(fj9 fj9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, fj9Var, i) == null) || fj9Var == null || rm9.e(fj9Var.a()) || this.f || this.e) {
            return;
        }
        for (int i2 = 0; !this.e && !this.f && i2 < fj9Var.a().size(); i2++) {
            bj9 bj9Var = fj9Var.a().get(i2);
            this.j++;
            if (v(bj9Var)) {
                q(bj9Var, i);
            } else {
                r(this.r, bj9Var, i);
                i(this.i + ((int) (((this.j * 1.0f) / this.h) * 60.0f)));
            }
        }
    }

    public final boolean t(bj9 bj9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bj9Var)) == null) {
            if (bj9Var == null || bj9Var.b() == null || !FileUtils.isExists(bj9Var.b().audioPath)) {
                return false;
            }
            if (bj9Var.b().start <= 0 && bj9Var.b().end <= 0 && bj9Var.b().volume == 1.0f) {
                return (bj9Var.a() == null || "audio/mp4a-latm".equals(bj9Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean v(bj9 bj9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bj9Var)) == null) {
            if (bj9Var == null) {
                return false;
            }
            return t(bj9Var) || bj9Var.a() == null || bj9Var.a().k(this.o) != 0;
        }
        return invokeL.booleanValue;
    }

    public final void x(dj9 dj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dj9Var) == null) {
            List<fj9> c2 = dj9Var.c();
            HashMap hashMap = new HashMap();
            if (c2.size() > 1) {
                this.q = true;
            }
            int i = 0;
            for (int i2 = 0; i2 < c2.size(); i2++) {
                if (!rm9.e(c2.get(i2).a())) {
                    this.h += rm9.b(c2.get(i2).a());
                    List<bj9> a2 = c2.get(i2).a();
                    if (!rm9.e(a2)) {
                        if (a2.size() > 1) {
                            this.p = true;
                        }
                        for (bj9 bj9Var : a2) {
                            if (bj9Var != null && bj9Var.b() != null && !bj9Var.c()) {
                                long j = bj9Var.b().end - bj9Var.b().start;
                                if (j > this.l) {
                                    this.l = j;
                                }
                                this.m = true;
                                this.n = true;
                            }
                            if (t(bj9Var)) {
                                this.n = true;
                            }
                            if (bj9Var != null && bj9Var.a() != null) {
                                Integer num = (Integer) hashMap.get(bj9Var.a());
                                if (num == null) {
                                    num = 0;
                                }
                                hashMap.put(bj9Var.a(), Integer.valueOf(num.intValue() + 1));
                            }
                        }
                    }
                }
            }
            if (hashMap.size() > 1) {
                this.n = true;
            }
            for (cj9 cj9Var : hashMap.keySet()) {
                if (((Integer) hashMap.get(cj9Var)).intValue() > i && "audio/mp4a-latm".equals(cj9Var.f())) {
                    this.o = cj9Var;
                    i = ((Integer) hashMap.get(cj9Var)).intValue();
                }
            }
            if (this.o == null) {
                this.o = cj9.b();
            }
        }
    }

    public final void y(dj9 dj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dj9Var) == null) {
            if (this.n) {
                if (dj9Var == null || rm9.e(dj9Var.c())) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < dj9Var.c().size(); i++) {
                    arrayList.add(new fj9(new ArrayList()));
                }
                dj9Var = new dj9(arrayList);
            }
            this.r = dj9Var;
        }
    }

    public final void z(dj9 dj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dj9Var) == null) {
            List<fj9> c2 = dj9Var.c();
            int size = c2.size();
            for (int i = 0; i < size; i++) {
                s(c2.get(i), i);
            }
        }
    }
}
