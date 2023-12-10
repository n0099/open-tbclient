package com.baidu.tieba;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.a7b;
import com.baidu.tieba.q6b;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class i7b extends BdBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public HorizontalListView b;
    public Resources c;
    public e7b d;
    public q6b e;
    public LinearLayout f;
    public ImageView g;
    public TextView h;
    public boolean i;
    public MediaPlayer j;
    public String k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public String p;
    public boolean q;
    public gp9 r;
    public String s;
    public String t;

    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i7b a;

        public a(i7b i7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i7bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i7bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (this.a.e.b() == i && i != this.a.l) {
                    return;
                }
                this.a.m = i;
                this.a.L(i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a7b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q6b.a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ i7b c;

        public b(i7b i7bVar, q6b.a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i7bVar, aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i7bVar;
            this.a = aVar;
            this.b = i;
        }

        @Override // com.baidu.tieba.a7b.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.b.setVisibility(4);
                BdUtilHelper.showToast(this.c.mContext.getPageActivity(), str);
                if (this.c.r != null) {
                    this.c.r.a(206, str);
                }
            }
        }

        @Override // com.baidu.tieba.a7b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.b.setVisibility(4);
            }
        }

        @Override // com.baidu.tieba.a7b.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.a.b.setVisibility(4);
                this.c.W(str, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a7b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ i7b b;

        @Override // com.baidu.tieba.a7b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public c(i7b i7bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i7bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i7bVar;
            this.a = i;
        }

        @Override // com.baidu.tieba.a7b.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                BdUtilHelper.showToast(this.b.mContext.getPageActivity(), str);
                if (this.b.r != null) {
                    this.b.r.a(206, str);
                }
            }
        }

        @Override // com.baidu.tieba.a7b.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.b.W(str, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ i7b b;

        public d(i7b i7bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i7bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i7bVar;
            this.a = i;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.b.e.d(this.a);
                this.b.j.setLooping(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i7b a;

        public e(i7b i7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i7bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i7bVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                if (this.a.r != null) {
                    gp9 gp9Var = this.a.r;
                    gp9Var.a(207, "what-->" + i + "  extra-->" + i2);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ i7b b;

        public f(i7b i7bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i7bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i7bVar;
            this.a = i;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.b.e.d(this.a);
                this.b.j.setLooping(true);
                this.b.j.start();
                this.b.d.f0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i7b a;

        public g(i7b i7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i7bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i7bVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                if (this.a.r != null) {
                    gp9 gp9Var = this.a.r;
                    gp9Var.a(207, "what-->" + i + "  extra-->" + i2);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i7b a;

        public h(i7b i7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i7bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i7bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                i7b i7bVar = this.a;
                i7bVar.d0(!i7bVar.i);
                this.a.d.l0(!this.a.i);
                this.a.a0();
                StatisticItem statisticItem = new StatisticItem("c12423");
                statisticItem.param("obj_type", !this.a.i ? 1 : 0);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i7b a;

        public i(i7b i7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i7bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i7bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.setSelection(this.a.n);
                this.a.b.v(this.a.m * BdUtilHelper.getDimens(this.a.getPageContext().getContext(), R.dimen.obfuscated_res_0x7f070366));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i7b(BdPageContext bdPageContext, e7b e7bVar, gp9 gp9Var) {
        super(bdPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, e7bVar, gp9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = true;
        this.l = 1;
        this.d = e7bVar;
        this.r = gp9Var;
        View inflate = LayoutInflater.from(bdPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0299, (ViewGroup) null);
        this.a = inflate;
        this.c = inflate.getResources();
        Q();
    }

    public void c0(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.e.f(list);
            q6b q6bVar = this.e;
            if (q6bVar != null) {
                int b2 = q6bVar.b();
                this.n = b2;
                this.m = b2;
            }
            g0();
        }
    }

    public void R(BdPageContext bdPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, bdPageContext, i2) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
        }
    }

    public void S(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            this.o = false;
            int i2 = this.l;
            this.m = i2;
            this.p = str2;
            W(str, i2);
        }
    }

    public void f0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, str2) == null) {
            this.s = str;
            this.t = str2;
            g0();
        }
    }

    public final void L(int i2, View view2) {
        MusicData musicData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048576, this, i2, view2) != null) || (musicData = (MusicData) this.e.getItem(i2)) == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12423");
        statisticItem.param("obj_id", musicData.id);
        statisticItem.param("obj_locate", i2 + 1);
        statisticItem.param("obj_source", 2);
        TiebaStatic.log(statisticItem);
        int i3 = musicData.editMusicType;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.l = i2;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
                    return;
                }
                return;
            }
            this.e.d(i2);
            Z();
            this.d.f0();
            return;
        }
        X(i2, view2, musicData);
    }

    public final void W(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, str, i2) == null) {
            this.n = i2;
            if (this.m != i2 || this.o) {
                return;
            }
            if (this.j == null) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.j = mediaPlayer;
                mediaPlayer.setAudioStreamType(3);
            }
            try {
                this.k = str;
                this.j.reset();
                this.j.setDataSource(str);
                this.j.prepare();
                this.j.setOnPreparedListener(new f(this, i2));
                this.j.setOnErrorListener(new g(this));
            } catch (Exception e2) {
                e2.printStackTrace();
                b0(str, i2);
                gp9 gp9Var = this.r;
                if (gp9Var != null) {
                    gp9Var.a(208, ap9.a(e2));
                }
            }
        }
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.p;
        }
        return (String) invokeV.objValue;
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public View O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.o = true;
            MediaPlayer mediaPlayer = this.j;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.j.pause();
            }
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.o = false;
            MediaPlayer mediaPlayer = this.j;
            if (mediaPlayer != null && this.d.l == 2) {
                mediaPlayer.start();
                this.j.seekTo(0);
            }
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MediaPlayer mediaPlayer = this.j;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.j.stop();
                }
                this.j.release();
                this.j = null;
            }
            this.k = null;
            this.p = null;
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.o = false;
            MediaPlayer mediaPlayer = this.j;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.j.pause();
            }
            MediaPlayer mediaPlayer2 = this.j;
            if (mediaPlayer2 != null) {
                mediaPlayer2.start();
                this.j.seekTo(0);
            }
        }
    }

    public void P(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f092a2c);
            this.g = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092a2b);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092a2d);
            this.f.setVisibility(8);
            this.f.setOnClickListener(new h(this));
            d0(this.i);
            this.d.l0(!this.i);
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                this.f.setVisibility(0);
                if (this.q && this.j == null && !TextUtils.isEmpty(this.k)) {
                    W(this.k, this.n);
                    this.q = false;
                    if (this.n > 4) {
                        new Handler().postDelayed(new i(this), 300L);
                        return;
                    }
                    return;
                }
                a0();
                return;
            }
            this.f.setVisibility(8);
            T();
        }
    }

    public void e0(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, intent) == null) && intent != null && intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) != null && intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) != null) {
            this.q = true;
            this.p = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
            this.k = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
            q6b q6bVar = this.e;
            if (q6bVar != null) {
                q6bVar.e(this.p);
                int b2 = this.e.b();
                this.n = b2;
                this.l = b2;
                this.m = b2;
            }
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b = (HorizontalListView) this.a.findViewById(R.id.obfuscated_res_0x7f091002);
            q6b q6bVar = new q6b(this.mContext);
            this.e = q6bVar;
            this.b.setAdapter((ListAdapter) q6bVar);
            this.b.setOnItemClickListener(new a(this));
        }
    }

    public final void X(int i2, View view2, MusicData musicData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048588, this, i2, view2, musicData) == null) && musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            this.p = musicData.id;
            this.d.K();
            String f2 = a7b.g().f(musicData.resource);
            if (TextUtils.isEmpty(f2)) {
                if (view2 != null) {
                    q6b.a aVar = (q6b.a) view2.getTag();
                    aVar.b.setVisibility(0);
                    a7b.g().e(musicData.id, musicData.resource, new b(this, aVar, i2));
                    return;
                }
                a7b.g().e(musicData.id, musicData.resource, new c(this, i2));
                return;
            }
            W(f2, i2);
        }
    }

    public final void Y(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048589, this, i2) != null) || rd.isEmpty(this.s)) {
            return;
        }
        this.n = i2;
        if (this.j == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.j = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            try {
                this.p = this.t;
                this.k = this.s;
                this.j.reset();
                this.j.setDataSource(this.s);
                this.j.prepare();
                this.j.setOnPreparedListener(new d(this, i2));
                this.j.setOnErrorListener(new e(this));
            } catch (Exception e2) {
                e2.printStackTrace();
                b0(this.k, i2);
                if (this.r != null) {
                    this.r.a(208, ap9.a(e2));
                }
            }
        } finally {
            this.t = null;
            this.s = null;
        }
    }

    public final void b0(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, str, i2) == null) {
            View view2 = null;
            this.k = null;
            Z();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                a7b.g().d();
            }
            MusicData musicData = (MusicData) this.e.getItem(i2);
            if (this.b.getChildCount() > i2) {
                view2 = this.b.getChildAt(i2);
            }
            X(i2, view2, musicData);
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.i = z;
            if (z) {
                this.g.setSelected(false);
                this.h.setText(this.c.getString(R.string.obfuscated_res_0x7f0f1851));
                return;
            }
            this.g.setSelected(true);
            this.h.setText(this.c.getString(R.string.obfuscated_res_0x7f0f1850));
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && !rd.isEmpty(this.t) && !rd.isEmpty(this.s)) {
            List<MusicData> c2 = this.e.c();
            if (!ListUtils.isEmpty(c2)) {
                for (int i2 = 0; i2 < c2.size(); i2++) {
                    if (c2.get(i2) != null && StringHelper.equals(c2.get(i2).id, this.t)) {
                        Y(i2);
                        return;
                    }
                }
                Y(1);
            }
        }
    }
}
