package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cab;
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
public class a7b extends z6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int h;
    public int i;
    public int j;
    public u6b k;
    public long l;
    public boolean m;
    public boolean n;
    public v6b o;
    public boolean p;
    public boolean q;
    public w6b r;

    /* loaded from: classes5.dex */
    public class a implements cab.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ a7b b;

        public a(a7b a7bVar, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a7bVar, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a7bVar;
            this.a = sb;
        }

        @Override // com.baidu.tieba.cab.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.cab.a
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
                fab.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.cab.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                fab.j("FFmpegChain", " createMuteAudio 进度i1 = " + i2);
                a7b a7bVar = this.b;
                a7bVar.i((int) (((float) a7bVar.i) + (((((float) i2) * 1.0f) / 100.0f) * 10.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements cab.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ a7b b;

        public b(a7b a7bVar, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a7bVar, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a7bVar;
            this.a = sb;
        }

        @Override // com.baidu.tieba.cab.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.cab.a
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
                fab.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.cab.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                fab.j("FFmpegChain", " concatMuteAudio 进度i1 = " + i2);
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements cab.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ u6b b;
        public final /* synthetic */ a7b c;

        public c(a7b a7bVar, StringBuilder sb, u6b u6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a7bVar, sb, u6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a7bVar;
            this.a = sb;
            this.b = u6bVar;
        }

        @Override // com.baidu.tieba.cab.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.c) {
                    this.c.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.cab.a
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
                u6b u6bVar = this.b;
                if (u6bVar != null && u6bVar.a() != null) {
                    this.a.append(",audioformat:");
                    this.a.append(this.b.a().f());
                    this.a.append(",audiopath:");
                    this.a.append(this.b.a().h());
                }
                fab.j("FFmpegChain", sb2);
                synchronized (this.c) {
                    this.c.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.cab.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                fab.j("FFmpegChain", " dealAudioPlayData 进度i1 = " + i2);
                a7b a7bVar = this.c;
                a7bVar.i(a7bVar.i + ((int) ((((((float) (this.c.j + (-1))) + ((((float) i2) * 1.0f) / 100.0f)) * 1.0f) / ((float) this.c.h)) * 60.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements cab.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ a7b b;

        public d(a7b a7bVar, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a7bVar, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a7bVar;
            this.a = sb;
        }

        @Override // com.baidu.tieba.cab.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.cab.a
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
                fab.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.cab.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                fab.j("FFmpegChain", " concatAudio 进度i1 = " + i2);
                a7b a7bVar = this.b;
                a7bVar.i((int) (((float) a7bVar.i) + (((((float) i2) * 1.0f) / 100.0f) * 10.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements cab.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ a7b b;

        public e(a7b a7bVar, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a7bVar, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a7bVar;
            this.a = sb;
        }

        @Override // com.baidu.tieba.cab.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.cab.a
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
                fab.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.cab.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                fab.j("FFmpegChain", " mixAudio 进度i1 = " + i2);
                a7b a7bVar = this.b;
                a7bVar.i((int) (((float) a7bVar.i) + (((((float) i2) * 1.0f) / 100.0f) * 20.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    public a7b() {
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
        v6b v6bVar;
        u6b u6bVar;
        v6b v6bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            u6b u6bVar2 = this.k;
            boolean z = u6bVar2 != null && u6bVar2.c();
            if (!z && ((v6bVar2 = this.o) == null || !FileUtils.isExists(v6bVar2.h()))) {
                g("nosource to create mute audio");
                return;
            }
            if (z && (v6bVar = this.o) != null && (u6bVar = this.k) != null && !v6bVar.equals(u6bVar.a())) {
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
                u8b.l(this.o.h(), str, -1, -1, 0.0f, -1, 0.0f, -1.0f, false, new a(this, sb));
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e2) {
                    sb.append(e2.getMessage());
                }
                if (FileUtils.isExists(a2) && TextUtils.isEmpty(sb.toString())) {
                    fab.j("FFmpegChain", "createconcatMuteAudio 生成成功");
                    this.k = new u6b(new AudioPlayData(a2, 0, -1, 1.0f));
                    return;
                }
                g(sb.toString());
            }
            u6b u6bVar3 = this.k;
            str = u6bVar3 != null ? u6bVar3.a().h() : "";
            i(this.i + 10);
            if (FileUtils.isExists(str) && TextUtils.isEmpty(sb.toString())) {
                fab.j("FFmpegChain", "createMuteAudio 生成成功");
                u6b u6bVar4 = new u6b(new AudioPlayData(str, 0, -1, 1.0f));
                this.k = u6bVar4;
                if (u6bVar4.a() == null || this.k.a().e() <= 0) {
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
                u8b.b(arrayList, a2, this.g, new b(this, sb), false, true);
                try {
                } catch (InterruptedException e5) {
                    sb.append(e5.getMessage());
                }
                synchronized (this) {
                    wait();
                    if (FileUtils.isExists(a2)) {
                        fab.j("FFmpegChain", "createconcatMuteAudio 生成成功");
                        this.k = new u6b(new AudioPlayData(a2, 0, -1, 1.0f));
                        return;
                    }
                }
            }
            g(sb.toString());
        }
    }

    public final void B(w6b w6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w6bVar) == null) {
            if (w6bVar == null || kab.e(w6bVar.c())) {
                g("concatAudio tempDataForOutPut data error");
                return;
            }
            List<y6b> c2 = w6bVar.c();
            StringBuilder sb = new StringBuilder();
            for (y6b y6bVar : c2) {
                if (!kab.e(y6bVar.a())) {
                    ArrayList arrayList = new ArrayList();
                    for (u6b u6bVar : y6bVar.a()) {
                        if (u6bVar.b() != null) {
                            arrayList.add(u6bVar.b().audioPath);
                        }
                    }
                    if (!kab.e(arrayList)) {
                        String str = this.g;
                        if (TextUtils.isEmpty(str)) {
                            str = FileUtils.getParentDir((String) arrayList.get(0));
                        }
                        String str2 = str + System.currentTimeMillis() + "_trackconcat.aac";
                        u8b.b(arrayList, str2, this.g, new d(this, sb), false, true);
                        try {
                            synchronized (this) {
                                wait();
                            }
                        } catch (InterruptedException e2) {
                            sb.append(e2.getMessage());
                        }
                        if (FileUtils.isExists(str2) && TextUtils.isEmpty(sb.toString())) {
                            fab.j("FFmpegChain", "concatAudio 生成成功");
                            u6b u6bVar2 = new u6b(new AudioPlayData(str2, 0, -1, 1.0f));
                            y6bVar.a().clear();
                            y6bVar.a().add(u6bVar2);
                        } else {
                            g(sb.toString());
                        }
                    }
                }
            }
        }
    }

    public final void C(w6b w6bVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w6bVar) == null) {
            if (w6bVar == null || kab.b(w6bVar.c()) < 2) {
                str = "mixAudio tempDataForOutPut data error";
            } else {
                List<y6b> c2 = w6bVar.c();
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                for (y6b y6bVar : c2) {
                    if (y6bVar != null && !kab.e(y6bVar.a())) {
                        u6b u6bVar = y6bVar.a().get(0);
                        if (u6bVar.b() != null) {
                            arrayList.add(u6bVar.b().audioPath);
                        }
                    }
                }
                if (arrayList.size() >= 2) {
                    String str2 = this.g;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = FileUtils.getParentDir((String) arrayList.get(0));
                    }
                    String str3 = str2 + System.currentTimeMillis() + "_mix.aac";
                    u8b.k(arrayList, str3, -1, new e(this, sb));
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
                    fab.j("FFmpegChain", "mixAudio 生成成功");
                    u6b u6bVar2 = new u6b(new AudioPlayData(str3, 0, -1, 1.0f));
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(u6bVar2);
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(new y6b(arrayList2));
                    this.r = new w6b(arrayList3);
                    return;
                }
                str = "mixAudio inputList data error";
            }
            g(str);
        }
    }

    @Override // com.baidu.tieba.z6b
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

    @Override // com.baidu.tieba.z6b
    public void d(w6b w6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, w6bVar) == null) {
            if (w6bVar == null || kab.e(w6bVar.c())) {
                g("input data error: null or length=0");
                return;
            }
            this.m = false;
            this.n = false;
            this.p = false;
            this.q = false;
            if (!j(w6bVar)) {
                l(w6bVar);
                return;
            }
            String a2 = w6bVar.a();
            this.g = a2;
            if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                new File(this.g).mkdir();
            }
            this.e = false;
            this.f = false;
            this.k = w6bVar.b();
            x(w6bVar);
            y(w6bVar);
            this.i = 0;
            if (this.m && !this.f && !this.e) {
                A();
            }
            if (this.n && !this.f && !this.e) {
                this.i = 10;
                i(10);
                z(w6bVar);
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

    @Override // com.baidu.tieba.z6b
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final void q(u6b u6bVar, int i) {
        int i2;
        u6b u6bVar2;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, u6bVar, i) == null) || this.e || this.f) {
            return;
        }
        AudioPlayData b2 = u6bVar.b();
        if (b2 == null) {
            sb = new StringBuilder();
            str = "dealAudioPlayData audioPlayData = null,trackIndx:";
        } else if (this.o != null) {
            if (!u6bVar.c() && (u6bVar2 = this.k) != null && u6bVar2.b() != null) {
                b2.audioPath = this.k.b().audioPath;
                u6bVar.d(this.k.a());
            }
            StringBuilder sb2 = new StringBuilder();
            String str2 = b2.audioPath;
            String a2 = a(str2, System.currentTimeMillis() + "_ffmpeg.aac");
            try {
                boolean z = u6bVar.a() != null && "audio/mp4a-latm".equals(u6bVar.a().f());
                String str3 = b2.audioPath;
                int g = this.o.g();
                int d2 = this.o.d();
                float f = b2.volume;
                int c2 = this.o.c();
                float f2 = (b2.start * 1.0f) / 1000.0f;
                float f3 = ((b2.end - b2.start) * 1.0f) / 1000.0f;
                i2 = 0;
                try {
                    u8b.l(str3, a2, g, d2, f, c2, f2, f3, !z, new c(this, sb2, u6bVar));
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
            fab.j("FFmpegChain", "dealAudioPlayData 生成成功");
            r(this.r, new u6b(new AudioPlayData(a2, i2, -1, 1.0f)), i);
            return;
        } else {
            sb = new StringBuilder();
            str = "dealAudioPlayData mTargetInfo = null ,trackIndx:";
        }
        sb.append(str);
        sb.append(i);
        g(sb.toString());
    }

    public final void r(w6b w6bVar, u6b u6bVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048583, this, w6bVar, u6bVar, i) == null) || w6bVar == null || w6bVar.c() == null || w6bVar.c().get(i) == null) {
            return;
        }
        w6bVar.c().get(i).a().add(u6bVar);
    }

    public final void s(y6b y6bVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, y6bVar, i) == null) || y6bVar == null || kab.e(y6bVar.a()) || this.f || this.e) {
            return;
        }
        for (int i2 = 0; !this.e && !this.f && i2 < y6bVar.a().size(); i2++) {
            u6b u6bVar = y6bVar.a().get(i2);
            this.j++;
            if (v(u6bVar)) {
                q(u6bVar, i);
            } else {
                r(this.r, u6bVar, i);
                i(this.i + ((int) (((this.j * 1.0f) / this.h) * 60.0f)));
            }
        }
    }

    public final boolean t(u6b u6bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, u6bVar)) == null) {
            if (u6bVar == null || u6bVar.b() == null || !FileUtils.isExists(u6bVar.b().audioPath)) {
                return false;
            }
            if (u6bVar.b().start <= 0 && u6bVar.b().end <= 0 && u6bVar.b().volume == 1.0f) {
                return (u6bVar.a() == null || "audio/mp4a-latm".equals(u6bVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean v(u6b u6bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, u6bVar)) == null) {
            if (u6bVar == null) {
                return false;
            }
            return t(u6bVar) || u6bVar.a() == null || u6bVar.a().k(this.o) != 0;
        }
        return invokeL.booleanValue;
    }

    public final void x(w6b w6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, w6bVar) == null) {
            List<y6b> c2 = w6bVar.c();
            HashMap hashMap = new HashMap();
            if (c2.size() > 1) {
                this.q = true;
            }
            int i = 0;
            for (int i2 = 0; i2 < c2.size(); i2++) {
                if (!kab.e(c2.get(i2).a())) {
                    this.h += kab.b(c2.get(i2).a());
                    List<u6b> a2 = c2.get(i2).a();
                    if (!kab.e(a2)) {
                        if (a2.size() > 1) {
                            this.p = true;
                        }
                        for (u6b u6bVar : a2) {
                            if (u6bVar != null && u6bVar.b() != null && !u6bVar.c()) {
                                long j = u6bVar.b().end - u6bVar.b().start;
                                if (j > this.l) {
                                    this.l = j;
                                }
                                this.m = true;
                                this.n = true;
                            }
                            if (t(u6bVar)) {
                                this.n = true;
                            }
                            if (u6bVar != null && u6bVar.a() != null) {
                                Integer num = (Integer) hashMap.get(u6bVar.a());
                                if (num == null) {
                                    num = 0;
                                }
                                hashMap.put(u6bVar.a(), Integer.valueOf(num.intValue() + 1));
                            }
                        }
                    }
                }
            }
            if (hashMap.size() > 1) {
                this.n = true;
            }
            for (v6b v6bVar : hashMap.keySet()) {
                if (((Integer) hashMap.get(v6bVar)).intValue() > i && "audio/mp4a-latm".equals(v6bVar.f())) {
                    this.o = v6bVar;
                    i = ((Integer) hashMap.get(v6bVar)).intValue();
                }
            }
            if (this.o == null) {
                this.o = v6b.b();
            }
        }
    }

    public final void y(w6b w6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, w6bVar) == null) {
            if (this.n) {
                if (w6bVar == null || kab.e(w6bVar.c())) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < w6bVar.c().size(); i++) {
                    arrayList.add(new y6b(new ArrayList()));
                }
                w6bVar = new w6b(arrayList);
            }
            this.r = w6bVar;
        }
    }

    public final void z(w6b w6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, w6bVar) == null) {
            List<y6b> c2 = w6bVar.c();
            int size = c2.size();
            for (int i = 0; i < size; i++) {
                s(c2.get(i), i);
            }
        }
    }
}
