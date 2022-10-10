package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tieba.dz;
import com.baidu.tieba.gx;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class az extends gx<yq4> implements ka8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int t;
    public static int u;
    public static int v;
    public static int w;
    public static int x;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public yq4 h;
    public RoundCornerFrameLayout i;
    public fb8 j;
    public String k;
    public String l;
    public BdUniqueId m;
    public int n;
    public boolean o;
    public View.OnClickListener p;
    public final View.OnClickListener q;
    public final View.OnClickListener r;
    public dz.b s;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ az b;

        public a(az azVar, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {azVar, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = azVar;
            this.a = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                yq4 yq4Var = this.b.h;
                if (yq4Var != null && yq4Var.getThreadData().getThreadVideoInfo().is_vertical.intValue() != 1) {
                    this.a.width = this.b.f.getWidth();
                    this.a.height = (this.b.f.getWidth() / 16) * 9;
                }
                this.b.i.setLayoutParams(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az a;

        public b(az azVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {azVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = azVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            yq4 yq4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (yq4Var = this.a.h) == null || yq4Var.getThreadData() == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.i);
            az azVar = this.a;
            Context context = azVar.b;
            ThreadData threadData = azVar.h.getThreadData();
            az azVar2 = this.a;
            String str = azVar2.k;
            oh5.c(false, context, threadData, 0, computeViewArea, "from_nani_video", "personalize_page", "", str, str, azVar2.h.getThreadData().isJumpToFrsVideoTabPlay);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az a;

        public c(az azVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {azVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = azVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            az azVar;
            gx.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (aVar = (azVar = this.a).e) == null) {
                return;
            }
            aVar.a(azVar.h);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az a;

        public d(az azVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {azVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = azVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.e() == null) {
                return;
            }
            this.a.e().a(view2, this.a.h);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements dz.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az a;

        public e(az azVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {azVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = azVar;
        }

        @Override // com.baidu.tieba.dz.b
        public boolean a(dz.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (aVar.b() == 1) {
                    az azVar = this.a;
                    t16.l(azVar.g, azVar.h.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    return false;
                } else if (aVar.b() == 2) {
                    fb8 fb8Var = this.a.j;
                    if (fb8Var != null) {
                        fb8Var.onScroll();
                        return false;
                    }
                    return false;
                } else if (aVar.b() == 3) {
                    fb8 fb8Var2 = this.a.j;
                    if (fb8Var2 != null) {
                        fb8Var2.onVolumeUp();
                        return false;
                    }
                    return false;
                } else if (aVar.b() == 6) {
                    fb8 fb8Var3 = this.a.j;
                    if (fb8Var3 != null) {
                        return fb8Var3.onBackPress();
                    }
                    return false;
                } else if (aVar.b() == 7) {
                    RoundCornerFrameLayout roundCornerFrameLayout = this.a.i;
                    if (roundCornerFrameLayout != null) {
                        roundCornerFrameLayout.d(((Boolean) aVar.c()).booleanValue());
                        return false;
                    }
                    return false;
                } else if (aVar.b() == 8 && this.a.j != null && (aVar.c() instanceof Boolean)) {
                    return this.a.j.onBackground(((Boolean) aVar.c()).booleanValue());
                } else {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448300180, "Lcom/baidu/tieba/az;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448300180, "Lcom/baidu/tieba/az;");
                return;
            }
        }
        t = (ej.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + ej.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
        int k = ej.k(TbadkCoreApplication.getInst());
        u = k;
        int i = k - t;
        v = i;
        w = (i / 2) * 3;
        x = i / 3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = 0;
        this.o = false;
        this.p = new b(this);
        this.q = new c(this);
        this.r = new d(this);
        this.s = new e(this);
    }

    @Override // com.baidu.tieba.ka8
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j.getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.ka8
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            yq4 yq4Var = this.h;
            if (yq4Var == null || yq4Var.getThreadData() == null) {
                return null;
            }
            return this.h.getThreadData().getVideoUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ka8
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gx
    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f == null) {
                if (TbadkCoreApplication.getInst().getPersonalizeViewData().k != null && TbadkCoreApplication.getInst().getPersonalizeViewData().k.getParent() == null) {
                    this.f = TbadkCoreApplication.getInst().getPersonalizeViewData().k;
                } else {
                    this.f = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d01c3, (ViewGroup) null, true);
                }
                this.g = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09256b);
                this.i = (RoundCornerFrameLayout) this.f.findViewById(R.id.obfuscated_res_0x7f090ad4);
                fb8 q = q();
                this.j = q;
                q.setUniqueId(this.m);
                this.j.setFrom(this.k);
                this.j.setStageType(this.l);
            }
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gx
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            j(1, this.s);
            j(2, this.s);
            j(3, this.s);
            j(6, this.s);
            j(7, this.s);
            j(8, this.s);
        }
    }

    @Override // com.baidu.tieba.ka8
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            fb8 fb8Var = this.j;
            if (fb8Var == null) {
                return false;
            }
            return fb8Var.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ka8
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j.isPlaying() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ka8
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j.isPlaying() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        yq4 yq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048585, this, tbPageContext, i) == null) || (yq4Var = this.h) == null || yq4Var.getThreadData() == null) {
            return;
        }
        t16.l(this.g, this.h.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        this.i.c(i);
        this.i.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
    }

    public fb8 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.j : (fb8) invokeV.objValue;
    }

    public abstract fb8 q();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b5, code lost:
        if (r1 != r2) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (r1 != r2) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bc, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bd, code lost:
        r0 = com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper.handleVerticalVideoSize(r11, r8, r10.j, r0, r1);
     */
    @Override // com.baidu.tieba.wx
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(yq4 yq4Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, yq4Var) == null) {
            int k = ej.k(TbadkCoreApplication.getInst());
            if (k != this.n) {
                int k2 = ej.k(TbadkCoreApplication.getInst());
                u = k2;
                int i = k2 - t;
                v = i;
                w = i / 2;
                x = i / 3;
                this.n = k;
            }
            this.h = yq4Var;
            if (yq4Var == null || yq4Var.getThreadData() == null || this.h.getThreadData().getThreadVideoInfo() == null) {
                return;
            }
            this.j.setData(yq4Var.getThreadData());
            ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
            int i2 = layoutParams.width;
            int i3 = layoutParams.height;
            boolean z2 = false;
            if (this.h.getThreadData().getThreadVideoInfo().is_vertical.intValue() == 1) {
                int i4 = (w / 9) * 16;
                int i5 = x;
                int intValue = this.h.getThreadData().getThreadVideoInfo().video_width.intValue();
                int intValue2 = this.h.getThreadData().getThreadVideoInfo().video_height.intValue();
                int i6 = w;
                layoutParams.width = i6;
                boolean z3 = i2 != i6;
                if (intValue != 0 && intValue2 != 0) {
                    int i7 = (int) (((intValue2 * 1.0f) / intValue) * w);
                    if (i7 < i5) {
                        i4 = i5;
                    } else if (i7 <= i4) {
                        i4 = i7;
                    }
                    layoutParams.height = i4;
                } else {
                    layoutParams.height = i4;
                }
            } else {
                int i8 = v;
                layoutParams.width = i8;
                int i9 = (i8 / 16) * 9;
                layoutParams.height = i9;
                z = (i3 == i9 && i2 == i8) ? false : true;
            }
            if (z) {
                if (this.h.getThreadData().getThreadVideoInfo().is_vertical.intValue() == 1) {
                    this.i.setLayoutParams(layoutParams);
                } else {
                    this.i.post(new a(this, layoutParams));
                }
            }
            if (this.h.getThreadData().isBJHVideoDynamicThreadType()) {
                this.g.setMaxLines(5);
                ThreadCardUtils.setTitle(this.g, this.h.getThreadData(), v, this.o);
            } else {
                this.g.setMaxLines(2);
                ThreadCardUtils.setTitle(this.g, this.h.getThreadData(), v, 2, this.o);
            }
            TextView textView = this.g;
            ThreadCardUtils.dealMainViewTopMargin(this.i, (textView == null || textView.getVisibility() != 0) ? true : true, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            if (this.e != null) {
                this.j.setJumpToPbClickListener(this.q);
            }
            if (e() != null) {
                this.j.setAfterClickListener(this.r);
            }
            TextView textView2 = this.g;
            if (textView2 == null || this.f == null) {
                return;
            }
            textView2.setOnClickListener(this.p);
            this.g.setMovementMethod(LinkMovementMethod.getInstance());
            this.f.setOnClickListener(this.p);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ka8
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Context context = this.b;
            if ((context instanceof IVideoNeedPreload) && ((IVideoNeedPreload) context).videoNeedPreload()) {
                this.j.startPlay();
            }
        }
    }

    @Override // com.baidu.tieba.ka8
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.j.stopPlay();
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.k = str;
            fb8 fb8Var = this.j;
            if (fb8Var != null) {
                fb8Var.setFrom(str);
            }
        }
    }

    public void v(gx.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.e = aVar;
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.o = z;
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) {
            this.m = bdUniqueId;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.l = str;
            fb8 fb8Var = this.j;
            if (fb8Var != null) {
                fb8Var.setStageType(str);
            }
        }
    }

    public void z(ab8 ab8Var) {
        fb8 fb8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, ab8Var) == null) || (fb8Var = this.j) == null) {
            return;
        }
        fb8Var.setStatistic(ab8Var);
    }
}
