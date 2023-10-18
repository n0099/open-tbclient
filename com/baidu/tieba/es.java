package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.play.operableVideoView.FakeVideoContainer;
import com.baidu.tieba.vt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class es extends wr<jv4> {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static int o;
    public static int p;
    public static int q;
    public static int r;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public jv4 h;
    public RoundCornerFrameLayout i;
    public FakeVideoContainer j;
    public int k;
    public boolean l;
    public vt.b m;

    @Override // com.baidu.tieba.wr
    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ es b;

        public a(es esVar, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {esVar, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = esVar;
            this.a = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.width = this.b.f.getWidth();
                this.a.height = (this.b.f.getWidth() / 16) * 9;
                this.b.i.setLayoutParams(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements vt.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es a;

        public b(es esVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {esVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = esVar;
        }

        @Override // com.baidu.tieba.vt.b
        public boolean a(vt.a aVar) {
            InterceptResult invokeL;
            RoundCornerFrameLayout roundCornerFrameLayout;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (aVar.b() == 7 && (roundCornerFrameLayout = this.a.i) != null) {
                    roundCornerFrameLayout.d(((Boolean) aVar.c()).booleanValue());
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448303807, "Lcom/baidu/tieba/es;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448303807, "Lcom/baidu/tieba/es;");
                return;
            }
        }
        n = (BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
        o = equipmentWidth;
        int i = equipmentWidth - n;
        p = i;
        q = i / 2;
        r = i / 3;
    }

    @Override // com.baidu.tieba.wr
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f == null) {
                View inflate = LayoutInflater.from(this.b).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
                this.f = inflate;
                this.g = (TextView) inflate.findViewById(R.id.video_seg_title);
                this.i = (RoundCornerFrameLayout) this.f.findViewById(R.id.frame_video);
                FakeVideoContainer fakeVideoContainer = new FakeVideoContainer(this.b);
                this.j = fakeVideoContainer;
                fakeVideoContainer.setBackgroundResource(R.color.transparent);
                this.i.addView(this.j);
            }
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public es(Context context) {
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
        this.k = 0;
        this.l = false;
        this.m = new b(this);
    }

    @Override // com.baidu.tieba.wr
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            m(7, this.m);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.l = z;
        }
    }

    @Override // com.baidu.tieba.rs
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        jv4 jv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) && (jv4Var = this.h) != null && jv4Var.getThreadData() != null) {
            mj6.l(this.g, this.h.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            this.i.c(i);
            this.i.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b5, code lost:
        if (r1 != r2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (r1 != r2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bc, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bd, code lost:
        r0 = com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper.handleVerticalVideoSize(r11, r8, null, r0, r1);
     */
    @Override // com.baidu.tieba.qs
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindDataToView(jv4 jv4Var) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jv4Var) == null) {
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
            if (equipmentWidth != this.k) {
                int equipmentWidth2 = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
                o = equipmentWidth2;
                int i = equipmentWidth2 - n;
                p = i;
                q = i / 2;
                r = i / 3;
                this.k = equipmentWidth;
            }
            this.h = jv4Var;
            if (jv4Var != null && jv4Var.getThreadData() != null && this.h.getThreadData().getThreadVideoInfo() != null) {
                this.j.setData(jv4Var.getThreadData());
                ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
                int i2 = layoutParams.width;
                int i3 = layoutParams.height;
                boolean z3 = false;
                if (this.h.getThreadData().getThreadVideoInfo().is_vertical.intValue() == 1) {
                    int i4 = (q / 9) * 16;
                    int i5 = r;
                    int intValue = this.h.getThreadData().getThreadVideoInfo().video_width.intValue();
                    int intValue2 = this.h.getThreadData().getThreadVideoInfo().video_height.intValue();
                    int i6 = q;
                    layoutParams.width = i6;
                    if (i2 != i6) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (intValue != 0 && intValue2 != 0) {
                        int i7 = (int) (((intValue2 * 1.0f) / intValue) * q);
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
                    int i8 = p;
                    layoutParams.width = i8;
                    int i9 = (i8 / 16) * 9;
                    layoutParams.height = i9;
                    if (i3 == i9 && i2 == i8) {
                        z = false;
                    } else {
                        z = true;
                    }
                }
                if (z) {
                    if (this.h.getThreadData().getThreadVideoInfo().is_vertical.intValue() == 1) {
                        this.i.setLayoutParams(layoutParams);
                    } else {
                        this.i.post(new a(this, layoutParams));
                    }
                }
                if (!this.h.getThreadData().isBJHVideoDynamicThreadType() && this.h.getThreadData().getType() != ThreadData.TYPE_FAKE_VIDEO) {
                    this.g.setMaxLines(2);
                    ThreadCardUtils.setTitle(this.g, this.h.getThreadData(), 0, this.l);
                } else {
                    this.g.setMaxLines(5);
                    ThreadCardUtils.setTitle(this.g, this.h.getThreadData(), p, this.l);
                }
                TextView textView = this.g;
                ThreadCardUtils.dealMainViewTopMargin(this.i, (textView == null || textView.getVisibility() != 0) ? true : true, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            }
        }
    }
}
