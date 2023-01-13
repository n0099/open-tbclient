package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.FirstPraiseToast;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.RightFloatLayerLottieView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeRelativeLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.a48;
import com.baidu.tieba.hw4;
import com.baidu.tieba.ir5;
import com.baidu.tieba.lr5;
import com.baidu.tieba.lz4;
import com.baidu.tieba.pb.ejection.EjectionAnimationView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.pb.main.controller.PbContentCollectionController;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.r98;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tw8;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.tieba.wv4;
import com.baidu.tieba.x88;
import com.baidu.tieba.y58;
import com.baidu.tieba.y78;
import com.baidu.tieba.yv4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.ItemInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class c98 {
    public static /* synthetic */ Interceptable $ic;
    public static final int m2;
    public static int n2;
    public static int o2;
    public static int p2;
    public static int q2;
    public static int r2;
    public static int s2;
    public static final int t2;
    public static int u2;
    public static tw8.f v2;
    public transient /* synthetic */ FieldHolder $fh;
    public PbContentCollectionController A;
    public ImageView A0;
    public boolean A1;
    public LinearLayout B;
    public AgreeView B0;
    public l88 B1;
    public TextView C;
    public ImageView C0;
    public NavigationBarCoverTip C1;
    public TextView D;
    public ImageView D0;
    public ir5 D1;
    public ObservedChangeRelativeLayout E;
    public HeadImageView E0;
    public lr5 E1;
    public j78 F;
    public View F0;
    public String F1;
    public wv4 G;
    public jd8 G0;
    public PermissionJudgePolicy G1;
    public yv4 H;
    public TextView H0;
    public long H1;
    public View I;
    public TextView I0;
    public boolean I1;
    public EditText J;
    public TextView J0;
    public int J1;
    public kd8 K;
    public boolean K0;
    public int K1;
    public PbListView L;
    public int L0;
    public boolean L1;
    public gd8 M;
    public fz4 M0;
    public boolean M1;
    public View N;
    public boolean N0;
    public id8 N1;
    public View O;
    public y48 O0;
    public MaskView O1;
    public View P;
    public PostData P0;
    public final FallingView P1;
    public View.OnClickListener Q;
    public int Q0;
    public RightFloatLayerView Q1;
    public TbRichTextView.a0 R;
    public int R0;
    public final FrameLayout R1;
    public NoNetworkView.b S;
    public boolean S0;
    public CustomMessageListener S1;
    public fw4 T;
    public ViewStub T0;
    public boolean T1;
    public View.OnClickListener U;
    public PbInterviewStatusView U0;
    public String U1;
    public wv4 V;
    public FrameLayout V0;
    public CustomMessageListener V1;
    public Dialog W;
    public TextView W0;
    public View.OnClickListener W1;
    public Dialog X;
    public View X0;
    public CustomMessageListener X1;
    public View Y;
    public View Y0;
    public Handler Y1;
    public LinearLayout Z;
    public View Z0;
    public Runnable Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public CompoundButton.OnCheckedChangeListener a0;
    public PbReplyTitleViewHolder a1;
    public CustomMessageListener a2;
    public int b;
    public TextView b0;
    public View b1;
    public PbFragment.i3 b2;
    public PbFragment c;
    public TextView c0;
    public int c1;
    public boolean c2;
    public RelativeLayout d;
    public String d0;
    public boolean d1;
    public View.OnClickListener d2;
    public View e;
    public fw4 e0;
    public a1 e1;
    public boolean e2;
    public int f;
    public fw4 f0;
    public PbEmotionBar f1;
    public String f2;
    public final Handler g;
    public aw4 g0;
    public int g1;
    public lz4.g g2;
    public final fb8 h;
    public boolean h0;
    public int h1;
    public View.OnClickListener h2;
    public eb8 i;
    public boolean i0;
    public Runnable i1;
    public final List<TbImageView> i2;
    public ViewStub j;
    public String j0;
    public PbFakeFloorModel j1;
    public int j2;
    public ViewStub k;
    public String k0;
    public v78 k1;
    public boolean k2;
    public PbLandscapeListView l;
    public a68 l0;
    public u88 l1;
    public boolean l2;
    public NoNetworkView m;
    public ScrollView m0;
    public boolean m1;
    public List<CustomBlueCheckRadioButton> n;
    public EditorTools n0;
    public int n1;
    public PbThreadPostView o;
    public boolean o0;
    public boolean o1;
    public z78 p;
    public View p0;
    public boolean p1;
    public y78 q;
    public View q0;
    public boolean q1;
    public y88 r;
    public EjectionAnimationView r0;
    public int r1;
    public x88 s;
    public Button s0;
    public PbTopTipView s1;
    public x98 t;
    public View t0;
    public PopupWindow t1;
    public s98 u;
    public View u0;
    public TextView u1;
    public u98 v;
    public LinearLayout v0;
    public List<String> v1;
    public w98 w;
    public HeadImageView w0;
    public ca8 w1;
    public t98 x;
    public ImageView x0;
    public y68 x1;
    public v98 y;
    public TextView y0;
    public PbLandscapeListView.c y1;
    public r98 z;
    public WaterRippleView z0;
    public boolean z1;

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void U2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048661, this, z2) == null) {
        }
    }

    public int n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) ? R.id.obfuscated_res_0x7f091ce6 : invokeV.intValue;
    }

    public void p3(PbFragment.j3 j3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048755, this, j3Var) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        /* loaded from: classes4.dex */
        public class a implements w65 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tieba.w65
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.a.r0.setVisibility(0);
                    this.a.a.r0.setBitmaps(list);
                    Rect rect = new Rect();
                    this.a.a.B0.getImgAgree().getGlobalVisibleRect(rect);
                    this.a.a.r0.setAnchorPosition((rect.right + rect.left) / 2, (rect.bottom + rect.top) / 2);
                    this.a.a.r0.k();
                }
            }
        }

        public c(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.I3();
            y65.g().c(new a(this));
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.R2();
            this.a.r0.l();
        }
    }

    /* loaded from: classes4.dex */
    public class j implements y78.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.p != null) {
                    this.a.a.p.p();
                }
            }
        }

        public j(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // com.baidu.tieba.y78.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                this.a.l.post(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbReplyTitleViewHolder b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ c98 g;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g.b1 != null && this.a.g.b1.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = this.a.g.b1.getLayoutParams();
                    layoutParams.height = this.a.g.h1;
                    this.a.g.b1.setLayoutParams(layoutParams);
                }
            }
        }

        public l(c98 c98Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = c98Var;
            this.a = i;
            this.b = pbReplyTitleViewHolder;
            this.c = z;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
        public void onLayout() {
            ViewGroup.LayoutParams layoutParams;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.a;
                if (i2 >= 0 && i2 <= this.g.d.getMeasuredHeight()) {
                    int m1 = this.g.m1(this.b);
                    int i3 = this.a;
                    int i4 = m1 - i3;
                    if (this.c && i4 != 0 && i3 <= (i = this.d)) {
                        i4 = m1 - i;
                    }
                    if (this.g.b1 == null || (layoutParams = this.g.b1.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 != 0 && i4 <= this.g.d.getMeasuredHeight() && m1 < this.g.d.getMeasuredHeight()) {
                        if (layoutParams != null) {
                            int i5 = layoutParams.height;
                            if (i5 + i4 > 0 && i5 + i4 <= this.g.d.getMeasuredHeight()) {
                                layoutParams.height += i4;
                                if (this.g.l != null) {
                                    this.g.l.setSelectionFromTop(this.e, this.f);
                                }
                            }
                        }
                        layoutParams.height = this.g.h1;
                    } else {
                        layoutParams.height = this.g.h1;
                    }
                    this.g.b1.setLayoutParams(layoutParams);
                    bh.a().post(new a(this));
                }
                if (this.g.l != null) {
                    this.g.l.setOnLayoutListener(null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements x88.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;

            public a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = mVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.r != null) {
                    this.a.a.r.r();
                }
            }
        }

        public m(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // com.baidu.tieba.x88.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.c.B6() && this.a.l != null) {
                this.a.l.post(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p0 a;

            public a(p0 p0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {p0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = p0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.c.HidenSoftKeyPad((InputMethodManager) this.a.a.c.getBaseFragmentActivity().getSystemService("input_method"), this.a.a.d);
            }
        }

        public p0(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.i1 == null) {
                    this.a.i1 = new a(this);
                }
                bh.a().postDelayed(this.a.i1, 150L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public a(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.s2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public a0(c98 c98Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (alertDialog = this.a) != null) {
                alertDialog.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public PbReplyTitleViewHolder c;

        public a1() {
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
    }

    /* loaded from: classes4.dex */
    public class b implements x58 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        @Override // com.baidu.tieba.x58
        public /* synthetic */ void onStart() {
            w58.a(this);
        }

        public b(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // com.baidu.tieba.x58
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.r0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 implements ir5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wv4 a;
        public final /* synthetic */ c98 b;

        public b0(c98 c98Var, wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, wv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c98Var;
            this.a = wv4Var;
        }

        @Override // com.baidu.tieba.ir5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.l5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c0 implements lr5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ c98 b;

        public c0(c98 c98Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c98Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.lr5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.k5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public d(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.B0 != null && this.a.B0.getData() != null) {
                c98 c98Var = this.a;
                c98Var.L2(c98Var.B0.getData(), this.a.B0.getData().agreeNum);
                if (!this.a.B0.J()) {
                    c98 c98Var2 = this.a;
                    c98Var2.E2(c98Var2.B0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public d0(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.d0 = (String) compoundButton.getTag();
                if (this.a.n != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.n) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.d0 != null && !str.equals(this.a.d0)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public e(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.F0.getVisibility() == 0) {
                    if (this.a.c != null && this.a.c.C1()) {
                        return;
                    }
                    cz4.l().v("pb_share_red_dot_shown", true);
                    this.a.F0.setVisibility(8);
                }
                this.a.Q.onClick(view2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public e0(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.X instanceof Dialog)) {
                dh.b(this.a.X, this.a.c.getPageContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public f(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                z = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
            } else {
                z = false;
            }
            if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                z2 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
            } else {
                z2 = false;
            }
            if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                z3 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
            } else {
                z3 = false;
            }
            if (z) {
                if (z2) {
                    sparseArray.put(R.id.tag_from, 1);
                    this.a.c.b5(sparseArray);
                    return;
                }
                this.a.D2(view2);
            } else if (z2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.a.c.b5(sparseArray);
            } else if (z3) {
                this.a.y2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f0 implements hw4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yv4.c a;
        public final /* synthetic */ c98 b;

        public f0(c98 c98Var, yv4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c98Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.hw4.f
        public void o0(hw4 hw4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, hw4Var, i, view2) == null) {
                this.b.f0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public g(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.V2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g0 implements tw8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.tw8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public g0() {
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
    }

    /* loaded from: classes4.dex */
    public class h implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public h(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.j1.X(postData);
                this.a.F.Z();
                this.a.k1.g();
                this.a.n0.s();
                this.a.O3(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h0 implements hw4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yv4.c a;
        public final /* synthetic */ c98 b;

        public h0(c98 c98Var, yv4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c98Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.hw4.f
        public void o0(hw4 hw4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, hw4Var, i, view2) == null) {
                this.b.f0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements FallingView.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public i(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.s
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.i4();
        }

        @Override // com.baidu.tieba.pb.view.FallingView.s
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.P1.setTag(Boolean.FALSE);
                if (this.a.Q1 == null) {
                    return;
                }
                this.a.Q1.setAutoCompleteShown(false);
                if (this.a.Q1.getVisibility() == 0) {
                    this.a.Q1.setTag(this.a.P1);
                    this.a.Q1.c();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public i0(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((view2 instanceof HeadImageView) && this.a.O0 != null && this.a.O0.Q() != null && this.a.O0.Q().getAuthor() != null && this.a.O0.Q().getAuthor().getAlaInfo() != null && this.a.O0.Q().getAuthor().getAlaInfo().live_status == 1) {
                    StatisticItem statisticItem = new StatisticItem("c11851");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem("c13715");
                    statisticItem2.param("fid", this.a.O0.m());
                    statisticItem2.param("fname", this.a.O0.n());
                    if (this.a.O0.Q().getAuthor().getAlaInfo().user_info != null) {
                        j = this.a.O0.Q().getAuthor().getAlaInfo().user_info.user_id;
                    } else {
                        j = 0;
                    }
                    statisticItem2.param("obj_param1", j);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("tid", this.a.O0.S());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.O0.Q().getAuthor().getAlaInfo()));
                    if (this.a.O0.Q().getAuthor().getAlaInfo().mYyExtData != null) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                        TiebaStaticHelper.addYYParam(statisticItem2, this.a.O0.Q().getAuthor().getAlaInfo().mYyExtData);
                    }
                    TiebaStatic.log(statisticItem2);
                    if (this.a.O0.Q().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                        YYLiveUtil.jumpYYLiveRoom(this.a.c.getPageContext(), this.a.O0.Q().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        return;
                    }
                    return;
                }
                if (this.a.o1) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                }
                if (!this.a.o1 && this.a.O0 != null && this.a.O0.Q() != null && this.a.O0.Q().getAuthor() != null && this.a.O0.Q().getAuthor().isBigV()) {
                    TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                }
                if (this.a.c.S() != null) {
                    this.a.c.S().d.b.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j0 implements r98.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public j0(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // com.baidu.tieba.r98.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.z.a(this.a.l);
                } else {
                    this.a.z.d(this.a.l);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(c98 c98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921757) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.a.e1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public k0(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            c98 c98Var;
            fb8 fb8Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.F != null && (fb8Var = (c98Var = this.a).h) != null && fb8Var.i != null && c98Var.O0 != null && this.a.O0.Q() != null && !this.a.O0.Q().isVideoThreadType() && !this.a.Y1() && this.a.O0.l() != null && !yi.isEmpty(this.a.O0.l().getName())) {
                if ((this.a.F.I() == null || !this.a.F.I().isShown()) && (linearLayout = this.a.h.i) != null) {
                    linearLayout.setVisibility(0);
                    this.a.h.m();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ c98 b;

        public l0(c98 c98Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c98Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (zi.F()) {
                    UrlManager.getInstance().dealOneLink(this.b.c.getPageContext(), new String[]{this.a});
                    this.b.c.finish();
                    return;
                }
                this.b.c.showToast(R.string.obfuscated_res_0x7f0f0cd1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ y48 c;
        public final /* synthetic */ c98 d;

        public m0(c98 c98Var, Parcelable parcelable, ArrayList arrayList, y48 y48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, parcelable, arrayList, y48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = c98Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = y48Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.l.onRestoreInstanceState(this.a);
                if (ListUtils.getCount(this.b) > 1 && this.c.z().b() > 0) {
                    this.d.L.g();
                    this.d.L.F(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e72));
                    this.d.L.A();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public n(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.F0.getVisibility() == 0) {
                    cz4.l().v("pb_share_red_dot_shown", true);
                    this.a.F0.setVisibility(8);
                }
                this.a.Q.onClick(this.a.D0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public n0(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.c != null && this.a.c.isAdded()) {
                if (i < 0 && f > this.a.r1) {
                    this.a.v0();
                    this.a.o2();
                }
                this.a.E0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements a48.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public o(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // com.baidu.tieba.a48.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B0.W();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o0 implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public o0(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                this.a.v0();
                wv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(c98 c98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && this.a.F != null) {
                this.a.F.Z();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public q(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.B == null) {
                    this.a.I1();
                }
                this.a.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q0 implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q0(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                wv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(c98 c98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.K0 = false;
        }
    }

    /* loaded from: classes4.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a25 a;
        public final /* synthetic */ c98 b;

        public r0(c98 c98Var, a25 a25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, a25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c98Var;
            this.a = a25Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.O0 != null && this.b.Q1 != null) {
                this.b.Q1.g(this.a);
                this.b.Q1.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public s(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.V2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s0 implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s0(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                wv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements a75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public t(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // com.baidu.tieba.a75
        public void A(z65 z65Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z65Var) == null) {
                Object obj = z65Var.c;
                if ((obj instanceof r25) && EmotionGroupType.isSendAsPic(((r25) obj).getType())) {
                    if (this.a.G1 == null) {
                        this.a.G1 = new PermissionJudgePolicy();
                    }
                    this.a.G1.clearRequestPermissionList();
                    this.a.G1.appendRequestPermission(this.a.c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.G1.startRequestPermission(this.a.c.getBaseFragmentActivity())) {
                        return;
                    }
                    r25 r25Var = (r25) z65Var.c;
                    this.a.c.H5().f(r25Var);
                    if (r25Var.i()) {
                        this.a.c.H5().G(null, null);
                    } else {
                        this.a.c.H5().w(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ c98 e;

        public t0(c98 c98Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = c98Var;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.a;
                if (i != this.b && i - this.c < 0) {
                    this.e.t1.showAsDropDown(this.d);
                } else {
                    this.e.t1.showAsDropDown(this.e.u0, this.d.getLeft(), -this.e.u0.getHeight());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public u(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.a.c.J0 != null && this.a.c.J0.e() != null) {
                if (!this.a.c.J0.e().e()) {
                    this.a.c.J0.a(false);
                }
                this.a.c.J0.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && this.a.n0 != null && this.a.n0.getVisibility() == 0 && charSequence != null && charSequence.length() >= (i4 = i3 + i)) {
                String substring = charSequence.toString().substring(i, i4);
                if (TextUtils.isEmpty(substring)) {
                    return;
                }
                if (this.a.w1 == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(2, this.a.n0.getId());
                    c98 c98Var = this.a;
                    c98Var.w1 = new ca8(c98Var.c.getPageContext(), this.a.d, layoutParams);
                    if (!ListUtils.isEmpty(this.a.v1)) {
                        this.a.w1.q(this.a.v1);
                    }
                    this.a.w1.r(this.a.n0);
                }
                this.a.w1.p(substring);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u0 implements FallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public u0(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.q
        public void onClick() {
            String l1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.c != null && this.a.c.M() != null && this.a.c.M().T1()) {
                    l1 = this.a.c.getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    l1 = this.a.l1();
                }
                if (!StringUtils.isNull(l1) && this.a.O0 != null) {
                    l1 = TbSingleton.getInstance().getAdVertiComment(this.a.O0.r0(), this.a.O0.s0(), l1);
                }
                if (this.a.c != null && this.a.c.H5() != null) {
                    this.a.c.H5().c0(l1);
                }
                if (this.a.y0 != null) {
                    this.a.y0.setText(l1);
                }
                this.a.O3(false);
                this.a.i4();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v implements hw4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ c98 b;

        public v(c98 c98Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c98Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.hw4.f
        public void o0(hw4 hw4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, hw4Var, i, view2) == null) {
                this.b.T.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.y2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.b2 != null) {
                            this.b.b2.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.c.T5(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        this.b.A4(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a25 a;
        public final /* synthetic */ c98 b;

        public v0(c98 c98Var, a25 a25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, a25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c98Var;
            this.a = a25Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.Q1.setHomePbFloatLastCloseTime();
                this.b.C1();
                this.b.Q1.u(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public w(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                wv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w0(c98 c98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921306) {
                return;
            }
            this.a.U1 = null;
        }
    }

    /* loaded from: classes4.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ c98 c;

        public x(c98 c98Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = c98Var;
            this.a = alertDialog;
            this.b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    zi.P(this.c.c.S(), R.string.obfuscated_res_0x7f0f0cd1);
                } else {
                    this.c.c.k5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ c98 b;

        public x0(c98 c98Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c98Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.b.L1 && this.a != null && this.b.c.M() != null && this.b.c.M().W1()) {
                    this.b.L1 = true;
                    this.a.Z4(false);
                }
                if (this.b.M1) {
                    return;
                }
                this.b.M1 = true;
                if (this.b.V1() && this.b.A != null) {
                    this.b.A.h();
                    this.b.A.g(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public y(c98 c98Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (alertDialog = this.a) != null) {
                alertDialog.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y0 implements y58.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c98 a;

        public y0(c98 c98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c98Var;
        }

        @Override // com.baidu.tieba.y58.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.W5();
            }
        }

        @Override // com.baidu.tieba.y58.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.l != null) {
                if (this.a.t != null) {
                    this.a.t.t();
                }
                this.a.l.setSelection(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ c98 c;

        public z(c98 c98Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = c98Var;
            this.a = alertDialog;
            this.b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    zi.P(this.c.c.S(), R.string.obfuscated_res_0x7f0f0cd1);
                } else {
                    this.c.c.k5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyPrivacyCheckController a;
        public final /* synthetic */ c95 b;
        public final /* synthetic */ c98 c;

        public z0(c98 c98Var, ReplyPrivacyCheckController replyPrivacyCheckController, c95 c95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c98Var, replyPrivacyCheckController, c95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = c98Var;
            this.a = replyPrivacyCheckController;
            this.b = c95Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null && this.c.c != null && this.c.c.s5() != null && !this.a.checkPrivacyBeforeInvokeEditor(this.c.c.s5().replyPrivateFlag)) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                }
                this.c.w4();
                this.b.n0();
                this.c.B0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947629703, "Lcom/baidu/tieba/c98;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947629703, "Lcom/baidu/tieba/c98;");
                return;
            }
        }
        m2 = UtilHelper.getLightStatusBarHeight();
        n2 = 3;
        o2 = 0;
        p2 = 3;
        q2 = 4;
        r2 = 5;
        s2 = 6;
        t2 = zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        u2 = 1;
        v2 = new g0();
    }

    public PostData O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (this.l == null) {
                return null;
            }
            int N0 = N0() - this.l.getHeaderViewsCount();
            int i2 = 0;
            if (N0 < 0) {
                N0 = 0;
            }
            if (this.F.y(N0) != null && this.F.y(N0) != PostData.O0) {
                i2 = N0 + 1;
            }
            if (!(this.F.x(i2) instanceof PostData)) {
                return null;
            }
            return (PostData) this.F.x(i2);
        }
        return (PostData) invokeV.objValue;
    }

    public final boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            if (G3()) {
                for (int firstVisiblePosition = this.l.getFirstVisiblePosition(); firstVisiblePosition <= this.l.getLastVisiblePosition(); firstVisiblePosition++) {
                    View childAt = this.l.getListView2().getChildAt(firstVisiblePosition);
                    if (childAt != null && (childAt.getTag() instanceof String)) {
                        if (TbadkCoreApplication.getInst().getString(R.string.content_collection).equals((String) childAt.getTag())) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e4() {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048703, this) == null) && TbadkCoreApplication.isLogin() && this.O0 != null && this.p1 && !this.o1 && !this.i0 && (postData = this.P0) != null && postData.r() != null && !this.P0.r().getIsLike() && !this.P0.r().hadConcerned() && this.l1 == null) {
            this.l1 = new u88(this.c);
        }
    }

    public final void n0() {
        PbContentCollectionController pbContentCollectionController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048742, this) == null) {
            if (G3()) {
                new StatisticItem(CommonStatisticKey.KEY_PB_PAGE_CONTENT_COLLECTION_SHOW).addParam("tid", this.O0.Q().getTid()).addParam("obj_param1", this.O0.Q().getThreadRecommendInfoDataList().get(0).businessId).eventStat();
            }
            if (V1() && (pbContentCollectionController = this.A) != null) {
                pbContentCollectionController.h();
                this.A.g(true);
            }
        }
    }

    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            s4();
            this.F.a0(1);
            x98 x98Var = this.t;
            if (x98Var != null) {
                x98Var.l();
            }
            z78 z78Var = this.p;
            if (z78Var != null) {
                z78Var.k();
            }
            y88 y88Var = this.r;
            if (y88Var != null) {
                y88Var.j();
            }
            RightFloatLayerView rightFloatLayerView = this.Q1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048774, this) == null) {
            this.F.a0(2);
            x98 x98Var = this.t;
            if (x98Var != null) {
                x98Var.m();
                if (!TbSingleton.getInstance().isNotchScreen(this.c.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.c.getFragmentActivity())) {
                    t1().setSystemUiVisibility(4);
                }
            }
            u2();
            e2();
            C4();
            n0();
        }
    }

    public c98(PbFragment pbFragment, View.OnClickListener onClickListener, a68 a68Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, a68Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = new Handler();
        this.l = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.a0 = null;
        this.b0 = null;
        this.c0 = null;
        this.d0 = null;
        this.e0 = null;
        this.f0 = null;
        this.g0 = null;
        this.h0 = false;
        this.i0 = false;
        this.j0 = null;
        this.k0 = null;
        this.m0 = null;
        this.o0 = false;
        this.s0 = null;
        this.u0 = null;
        this.y0 = null;
        this.K0 = true;
        this.M0 = null;
        this.N0 = false;
        this.R0 = 3;
        this.S0 = false;
        this.T0 = null;
        this.c1 = 0;
        this.d1 = true;
        this.e1 = new a1();
        this.g1 = 0;
        this.m1 = false;
        this.n1 = 0;
        this.o1 = false;
        this.p1 = false;
        this.q1 = false;
        this.r1 = 0;
        this.z1 = false;
        this.A1 = false;
        this.H1 = 0L;
        this.K1 = 0;
        this.S1 = new k(this, 2921757);
        this.V1 = new w0(this, 2921306);
        this.W1 = new n(this);
        this.X1 = new p(this, 2005016);
        this.Y1 = new Handler();
        this.a2 = new r(this, 2004009);
        this.c2 = true;
        this.d2 = new i0(this);
        this.e2 = false;
        this.f2 = null;
        this.i2 = new ArrayList();
        this.k2 = false;
        this.H1 = System.currentTimeMillis();
        this.c = pbFragment;
        this.Q = onClickListener;
        this.l0 = a68Var;
        this.r1 = zi.l(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0665, (ViewGroup) null);
        this.d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.p0 = this.d.findViewById(R.id.obfuscated_res_0x7f09040b);
        this.C1 = (NavigationBarCoverTip) this.d.findViewById(R.id.obfuscated_res_0x7f091910);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f092073);
        this.R1 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091d08);
        this.E = (ObservedChangeRelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f092333);
        this.m = (NoNetworkView) this.d.findViewById(R.id.view_no_network);
        PbLandscapeListView pbLandscapeListView = (PbLandscapeListView) this.d.findViewById(R.id.obfuscated_res_0x7f09173f);
        this.l = pbLandscapeListView;
        pbLandscapeListView.setDividerHeight(0);
        this.V0 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091d53);
        this.W0 = new TextView(this.c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + zi.g(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070306));
        this.l.setOverScrollMode(2);
        this.l.x(this.W0, 0);
        this.l.setTextViewAdded(true);
        this.h1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.b1 = new View(this.c.getPageContext().getPageActivity());
        if (zp5.a()) {
            this.b1.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.b1.setLayoutParams(new AbsListView.LayoutParams(-1, this.h1));
        }
        MessageManager.getInstance().registerListener(this.S1);
        this.b1.setVisibility(4);
        this.l.addFooterView(this.b1);
        this.l.setOnTouchListener(this.c.N2);
        this.a = new x0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.h = new fb8(pbFragment, this.d);
        if (this.c.B5()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f09154e);
            this.j = viewStub;
            viewStub.setVisibility(0);
            eb8 eb8Var = new eb8(pbFragment);
            this.i = eb8Var;
            eb8Var.c();
            this.h.a.setVisibility(8);
            layoutParams.height = zi.g(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07023c);
        }
        this.W0.setLayoutParams(layoutParams);
        this.h.q().setOnTouchListener(new y58(new y0(this)));
        this.t0 = this.d.findViewById(R.id.obfuscated_res_0x7f09269f);
        this.u0 = this.d.findViewById(R.id.obfuscated_res_0x7f0918a9);
        zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.L0 = zi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070284);
        this.x0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0908bf);
        this.x0.setOnClickListener(new z0(this, new ReplyPrivacyCheckController(this.c.getPageContext()), this.c.H5()));
        d2();
        C0();
        this.y0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0918ac);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0918a4);
        this.v0 = linearLayout;
        linearLayout.setOnClickListener(new a(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f0908c3);
        this.r0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new b(this));
        this.A0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0918aa);
        this.O1 = (MaskView) this.d.findViewById(R.id.mask_view);
        this.A0.setOnClickListener(this.Q);
        AgreeView agreeView = (AgreeView) this.d.findViewById(R.id.obfuscated_res_0x7f0918a6);
        this.B0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.B0.w();
        this.B0.setAgreeLongClickListener(new c(this));
        this.B0.setAfterClickListener(new d(this));
        this.B0.setUseDynamicLikeRes("/pb");
        if (this.B0.getAgreeNumView() != null) {
            this.B0.getAgreeNumView().setVisibility(8);
        }
        if (this.B0.getMsgData() != null) {
            this.B0.getMsgData().a = BdUniqueId.gen();
        }
        boolean booleanExtra = this.c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0918a8);
        this.C0 = imageView;
        imageView.setOnClickListener(this.Q);
        if (booleanExtra) {
            this.C0.setVisibility(8);
        } else {
            this.C0.setVisibility(0);
        }
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f0918af);
        this.F0 = findViewById;
        if (!cz4.l().i("pb_share_red_dot_shown", false) && TbadkCoreApplication.isLogin()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        findViewById.setVisibility(i2);
        this.D0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0918ad);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0918ae);
        this.E0 = headImageView;
        headImageView.setIsRound(true);
        this.E0.setOnClickListener(this.W1);
        this.D0.setOnClickListener(new e(this));
        g2();
        jd8 jd8Var = new jd8(this.D0);
        this.G0 = jd8Var;
        jd8Var.n(this.E0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.G0.f();
        }
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0918ab);
        this.I0 = textView;
        textView.setVisibility(0);
        this.H0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0918a7);
        this.T0 = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091012);
        this.B0.setVisibility(0);
        this.H0.setVisibility(0);
        this.u = new s98(this.c, a68Var);
        this.w = new w98(this.c, a68Var, this.Q);
        j78 j78Var = new j78(this.c, this.l);
        this.F = j78Var;
        j78Var.y0(this.Q);
        this.F.A0(this.l0);
        this.F.v0(this.R);
        this.F.x0(this.c.k2);
        this.F.r0(this.h2);
        f fVar = new f(this);
        this.U = fVar;
        this.F.t0(fVar);
        M1();
        G1();
        v98 v98Var = new v98(this.c);
        this.y = v98Var;
        v98Var.f = 2;
        F1();
        E1();
        this.z.a(this.l);
        this.w.n(this.l);
        this.v.a(this.l);
        this.A.a(this.l);
        this.u.a(this.l);
        PbListView pbListView = new PbListView(this.c.getPageContext().getPageActivity());
        this.L = pbListView;
        this.N = pbListView.c().findViewById(R.id.pb_more_view);
        this.O = this.L.c().findViewById(R.id.pb_check_more);
        if (!this.L.j().booleanValue()) {
            this.O.setVisibility(8);
        }
        View view2 = this.N;
        if (view2 != null) {
            view2.setOnClickListener(this.Q);
            SkinManager.setBackgroundResource(this.N, R.drawable.pb_foot_more_trans_selector);
        }
        View view3 = this.O;
        if (view3 != null) {
            view3.setOnClickListener(this.Q);
        }
        this.L.C();
        this.L.q(R.drawable.pb_foot_more_trans_selector);
        this.L.r(R.drawable.pb_foot_more_trans_selector);
        this.P = this.d.findViewById(R.id.obfuscated_res_0x7f0926d5);
        this.c.registerListener(this.a2);
        this.j1 = new PbFakeFloorModel(this.c.getPageContext());
        PbModel M = this.c.M();
        this.j1.Z(M.P(), M.L(), M.M(), M.K(), M.Q());
        v78 v78Var = new v78(this.c.getPageContext(), this.j1, this.d);
        this.k1 = v78Var;
        v78Var.p(new g(this));
        this.k1.s(this.c.p2);
        this.j1.b0(new h(this));
        if (this.c.M() != null && !StringUtils.isNull(this.c.M().o1())) {
            PbFragment pbFragment2 = this.c;
            pbFragment2.showToast(pbFragment2.M().o1());
        }
        this.X0 = this.d.findViewById(R.id.obfuscated_res_0x7f0918b1);
        this.Y0 = this.d.findViewById(R.id.obfuscated_res_0x7f090409);
        View findViewById2 = this.d.findViewById(R.id.obfuscated_res_0x7f092080);
        this.Z0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.c.M() != null && this.c.M().X0()) {
            this.X0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.Z0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = m2;
            this.Z0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.c.getPageContext(), this.d.findViewById(R.id.obfuscated_res_0x7f09192e));
        this.a1 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.r(pbFragment.d0);
        this.a1.g.setVisibility(8);
        this.a1.q(this.Q);
        this.a1.p(this.c.k2);
        this.c.registerListener(this.X1);
        this.c.registerListener(this.V1);
        PbFragment pbFragment3 = this.c;
        this.N1 = new id8(pbFragment3, pbFragment3.getUniqueId());
        this.P1 = (FallingView) this.d.findViewById(R.id.obfuscated_res_0x7f0909cc);
        b3();
        this.P1.setAnimationListener(new i(this));
        q0();
        U2(false);
        this.q0 = this.d.findViewById(R.id.obfuscated_res_0x7f09189a);
        p0(zp5.a());
        if (UbsABTestHelper.isPbForumGuideTestA() && M.a2() && b48.b().e()) {
            if (this.p == null) {
                this.p = new z78(this.c.getActivity(), (ViewGroup) t1().findViewById(R.id.obfuscated_res_0x7f0918d6));
            }
            y78 y78Var = new y78(this.l);
            this.q = y78Var;
            y78Var.d(new j(this));
        }
        this.r = new y88(this.c.S(), (ViewGroup) t1().findViewById(R.id.obfuscated_res_0x7f091943));
        x88 x88Var = new x88(this.l);
        this.s = x88Var;
        x88Var.d(new m(this));
    }

    public void B4(y48 y48Var) {
        s98 s98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, y48Var) == null) && (s98Var = this.u) != null) {
            s98Var.h(y48Var, this.N0);
        }
    }

    public void C3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z2) == null) {
            this.w.J(z2);
        }
    }

    public void D2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        C2(sparseArray, false);
    }

    public void E3(int i2) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i2) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setSelection(i2);
        }
    }

    public void F3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, list) == null) {
            this.v1 = list;
            ca8 ca8Var = this.w1;
            if (ca8Var != null) {
                ca8Var.q(list);
            }
        }
    }

    public void N3(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z2) == null) {
            View view2 = this.p0;
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    public void O3(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048638, this, z2) != null) || this.u0 == null) {
            return;
        }
        d3(this.c.H5().y());
        if (this.o0) {
            S3(z2);
        } else {
            w1(z2);
        }
    }

    public void Z2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048681, this, str) == null) && (pbListView = this.L) != null) {
            pbListView.F(str);
        }
    }

    public void c3(PbFragment.i3 i3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, i3Var) == null) {
            this.b2 = i3Var;
        }
    }

    public final int d1(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048696, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.U0;
            if (pbInterviewStatusView == null || pbInterviewStatusView.getVisibility() != 0 || !z2) {
                return 0;
            }
            return 0 + zi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
        }
        return invokeZ.intValue;
    }

    public void d3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048698, this, z2) == null) {
            this.o0 = z2;
        }
    }

    public void e3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048702, this, z2) == null) {
            this.F.i0(z2);
        }
    }

    public void f3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048706, this, z2) == null) {
            this.I1 = z2;
        }
    }

    public void g3(boolean z2) {
        j78 j78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048710, this, z2) == null) && (j78Var = this.F) != null) {
            j78Var.j0(z2);
        }
    }

    public void h3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048715, this, z2) == null) {
            this.z1 = z2;
        }
    }

    public void i3(boolean z2) {
        x98 x98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048720, this, z2) == null) && (x98Var = this.t) != null) {
            x98Var.r(z2);
        }
    }

    public boolean j0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048722, this, z2)) == null) {
            EditorTools editorTools = this.n0;
            if (editorTools != null && editorTools.w()) {
                this.n0.s();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void j3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z2) == null) {
            this.F.l0(z2);
        }
    }

    public void k3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048730, this, z2) == null) {
            this.F.q0(z2);
        }
    }

    public void l3(lz4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, gVar) == null) {
            this.g2 = gVar;
            kd8 kd8Var = this.K;
            if (kd8Var != null) {
                kd8Var.f(gVar);
            }
        }
    }

    public void m3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048740, this, onClickListener) == null) {
            this.h2 = onClickListener;
            j78 j78Var = this.F;
            if (j78Var != null) {
                j78Var.r0(onClickListener);
            }
        }
    }

    public final void m4(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048741, this, postData) == null) && postData != null) {
            if (!StringUtils.isNull(postData.a0())) {
                this.A1 = true;
            } else {
                this.A1 = false;
            }
            w98 w98Var = this.w;
            if (w98Var != null) {
                w98Var.p(postData);
            }
        }
    }

    public boolean n2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048744, this, i2)) == null) {
            x98 x98Var = this.t;
            if (x98Var != null) {
                return x98Var.k(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void n3(String str) {
        eb8 eb8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048745, this, str) == null) && (eb8Var = this.i) != null) {
            eb8Var.b(str);
        }
    }

    public void o3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048750, this, z2) == null) {
            this.m1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.n1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void p4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048756, this, str) == null) {
            this.c.showToast(str);
        }
    }

    public void q3(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048760, this, a0Var) == null) {
            this.R = a0Var;
            this.F.v0(a0Var);
            this.x1.q(this.R);
        }
    }

    public void r2(bo boVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048764, this, boVar) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.b0 = boVar;
            pbLandscapeListView.W = true;
        }
    }

    public void r3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048765, this, bVar) == null) {
            this.S = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void s3(BdListView.p pVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048770, this, pVar) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setOnSrollToBottomListener(pVar);
        }
    }

    public void t3(AbsListView.OnScrollListener onScrollListener) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048775, this, onScrollListener) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setOnScrollListener(onScrollListener);
        }
    }

    public void t4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048776, this, z2) == null) {
            this.h0 = z2;
        }
    }

    public void u3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048780, this, onClickListener) == null) {
            this.F.z0(onClickListener);
        }
    }

    public void v3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048785, this, i2) == null) {
            this.J1 = i2;
        }
    }

    public void w3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048790, this, onLongClickListener) == null) {
            this.w.H(onLongClickListener);
            this.F.w0(onLongClickListener);
            y68 y68Var = this.x1;
            if (y68Var != null) {
                y68Var.r(onLongClickListener);
            }
        }
    }

    public void G2(r55 r55Var, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048605, this, r55Var, i2) == null) && (fallingView = this.P1) != null) {
            fallingView.A(r55Var, this.c.getPageContext(), i2, false);
        }
    }

    public void h2(boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048714, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            y78 y78Var = this.q;
            if (y78Var != null) {
                y78Var.b();
            }
            x88 x88Var = this.s;
            if (x88Var != null) {
                x88Var.b(z2, i2);
            }
        }
    }

    @SuppressLint({"CutPasteId"})
    public void o4(y48 y48Var, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048751, this, y48Var, z2) != null) || y48Var == null) {
            return;
        }
        y4(y48Var, z2);
        y0();
    }

    public final void x3(PostData postData, y48 y48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048795, this, postData, y48Var) == null) {
            this.w.I(postData, y48Var);
        }
    }

    public void A0() {
        x98 x98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (x98Var = this.t) != null) {
            x98Var.b();
        }
    }

    public void A1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.B == null) {
                I1();
            }
            this.k.setVisibility(8);
            Handler handler = this.Y1;
            if (handler != null && (runnable = this.Z1) != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }

    public void A3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (pbFragment = this.c) != null && pbFragment.getBaseFragmentActivity() != null) {
            zi.z(this.c.getPageContext().getPageActivity(), this.c.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", u2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.P.setVisibility(8);
        }
    }

    public void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.L.C();
            this.L.T();
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", u2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void C1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (rightFloatLayerView = this.Q1) != null) {
            rightFloatLayerView.c();
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            PbListView pbListView = this.L;
            if (pbListView != null) {
                pbListView.A();
                this.L.g();
            }
            z1();
        }
    }

    public void D1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (editorTools = this.n0) != null) {
            editorTools.s();
        }
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.A(0L);
            }
            y0();
        }
    }

    public final void E1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.A == null && (pbFragment = this.c) != null && pbFragment.getActivity() != null) {
            this.A = new PbContentCollectionController(this.c.getActivity());
        }
    }

    public final void F1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.z == null && (pbFragment = this.c) != null) {
            this.z = new r98(pbFragment.getContext());
        }
    }

    public boolean F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            y88 y88Var = this.r;
            if (y88Var != null && y88Var.l()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void G0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setForbidDragListener(true);
        }
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.v == null) {
            this.v = new u98(this.c, this.l0);
        }
    }

    public j78 J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.F;
        }
        return (j78) invokeV.objValue;
    }

    public final void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.w.E(this.O0, this.P0, this.p1, this.o1);
        }
    }

    public LinearLayout K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.v0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public void K3() {
        x98 x98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (x98Var = this.t) != null) {
            x98Var.u(this.l);
        }
    }

    public View L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            View view2 = this.Y;
            if (view2 != null) {
                return view2.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public String M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.d0;
        }
        return (String) invokeV.objValue;
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && this.x == null) {
            this.x = new t98(this.c, this.Q);
        }
    }

    public boolean O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.e2;
        }
        return invokeV.booleanValue;
    }

    public FallingView P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.P1;
        }
        return (FallingView) invokeV.objValue;
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.K0;
        }
        return invokeV.booleanValue;
    }

    public final void P2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && (pbInterviewStatusView = this.U0) != null && pbInterviewStatusView.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.U0.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.U0.setLayoutParams(marginLayoutParams);
        }
    }

    public int Q0() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                i2 = pbLandscapeListView.getFirstVisiblePosition();
            } else {
                i2 = 0;
            }
            return R0(i2);
        }
        return invokeV.intValue;
    }

    public void Q2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && this.f != 2) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setNextPage(this.L);
            }
            this.f = 2;
        }
    }

    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public Button S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.s0;
        }
        return (Button) invokeV.objValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            EditorTools editorTools = this.n0;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                return pbLandscapeListView.getHeaderViewsCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public TextView U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.w.s();
        }
        return (TextView) invokeV.objValue;
    }

    public final boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.f2);
        }
        return invokeV.booleanValue;
    }

    public void U3() {
        fb8 fb8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048662, this) == null) && (fb8Var = this.h) != null && !this.q1) {
            fb8Var.E();
            this.q1 = true;
        }
    }

    public int V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            jd8 jd8Var = this.G0;
            if (jd8Var != null) {
                return jd8Var.g();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            T2();
            x1();
            this.k1.g();
            O3(false);
        }
    }

    public void V3() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048666, this) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setVisibility(0);
        }
    }

    public PbInterviewStatusView W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return this.U0;
        }
        return (PbInterviewStatusView) invokeV.objValue;
    }

    public final void W2() {
        x98 x98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048669, this) == null) && (x98Var = this.t) != null) {
            x98Var.q(this.l, this.W0, this.Q0);
        }
    }

    public void W3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            if (this.M0 == null) {
                this.M0 = new fz4(this.c.getPageContext());
            }
            this.M0.h(true);
        }
    }

    public boolean X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.z1;
        }
        return invokeV.booleanValue;
    }

    public void X2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048673, this) != null) || (handler = this.Y1) == null) {
            return;
        }
        Runnable runnable = this.Z1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        q qVar = new q(this);
        this.Z1 = qVar;
        this.Y1.postDelayed(qVar, 2000L);
    }

    public void Y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            this.F.h0(this.O0, false);
            this.F.Z();
        }
    }

    public BdTypeListView Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            return this.l;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            x98 x98Var = this.t;
            if (x98Var != null && x98Var.f()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return this.m;
        }
        return (NoNetworkView) invokeV.objValue;
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.T1;
        }
        return invokeV.booleanValue;
    }

    public y68 b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            return this.x1;
        }
        return (y68) invokeV.objValue;
    }

    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            jd8 jd8Var = this.G0;
            if (jd8Var == null) {
                return false;
            }
            return jd8Var.i();
        }
        return invokeV.booleanValue;
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            this.P1.setFallingFeedbackListener(new u0(this));
        }
    }

    public View c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.O;
        }
        return (View) invokeV.objValue;
    }

    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            EditorTools editorTools = this.n0;
            if (editorTools != null && editorTools.w()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d2() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048697, this) == null) && (imageView = this.x0) != null) {
            imageView.setImageResource(R.drawable.icon_pure_post_expression24);
        }
    }

    public View e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            return this.N;
        }
        return (View) invokeV.objValue;
    }

    public PbListView f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            return this.L;
        }
        return (PbListView) invokeV.objValue;
    }

    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            M2(this.O0);
        }
    }

    public int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            try {
                return Integer.parseInt(this.J.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public void g4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048711, this) == null) {
            this.P.setVisibility(0);
        }
    }

    public View h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) {
            return this.X0;
        }
        return (View) invokeV.objValue;
    }

    public void h4() {
        j78 j78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048716, this) == null) && (j78Var = this.F) != null) {
            j78Var.B0();
        }
    }

    public void i0() {
        jd8 jd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048717, this) == null) && (jd8Var = this.G0) != null) {
            jd8Var.m(false);
        }
    }

    public PbFakeFloorModel i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            return this.j1;
        }
        return (PbFakeFloorModel) invokeV.objValue;
    }

    public v78 j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            return this.k1;
        }
        return (v78) invokeV.objValue;
    }

    public void j4() {
        jd8 jd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048726, this) != null) || (jd8Var = this.G0) == null) {
            return;
        }
        jd8Var.o(2);
    }

    public x98 k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            return this.t;
        }
        return (x98) invokeV.objValue;
    }

    public final int o1() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null || (childAt = pbLandscapeListView.getChildAt(0)) == null) {
                return 0;
            }
            return (-childAt.getTop()) + (this.l.getFirstVisiblePosition() * childAt.getHeight());
        }
        return invokeV.intValue;
    }

    public int p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) {
            return this.R0;
        }
        return invokeV.intValue;
    }

    public View q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public void q4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048761, this) == null) {
            this.c.showProgressBar();
        }
    }

    public PbThreadPostView r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) {
            return this.o;
        }
        return (PbThreadPostView) invokeV.objValue;
    }

    public void r4() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048766, this) == null) && (fallingView = this.P1) != null) {
            fallingView.C();
        }
    }

    public RelativeLayout s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) {
            return this.E;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void s4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048771, this) == null) && this.i2 != null) {
            while (this.i2.size() > 0) {
                TbImageView remove = this.i2.remove(0);
                if (remove != null) {
                    remove.O();
                }
            }
        }
    }

    public RelativeLayout t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048773, this)) == null) {
            return this.d;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void u1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048778, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.V0.setVisibility(8);
            }
            fb8 fb8Var = this.h;
            if (fb8Var != null && (view2 = fb8Var.d) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public final void u2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048779, this) == null) && (pbFragment = this.c) != null && pbFragment.H5() != null) {
            this.c.H5().E();
        }
    }

    public void v1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048783, this) != null) || this.u0 == null) {
            return;
        }
        this.t0.setVisibility(8);
        this.u0.setVisibility(8);
        this.K0 = false;
        PbEmotionBar pbEmotionBar = this.f1;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            U2(false);
        }
    }

    public void x0() {
        jd8 jd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048792, this) == null) && (jd8Var = this.G0) != null) {
            jd8Var.l(false);
        }
    }

    public void x1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048793, this) == null) && (editorTools = this.n0) != null) {
            editorTools.q();
            ca8 ca8Var = this.w1;
            if (ca8Var != null) {
                ca8Var.m();
            }
        }
    }

    public final boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048797, this)) == null) {
            return this.u.b(this.N0);
        }
        return invokeV.booleanValue;
    }

    public void y1() {
        fb8 fb8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048798, this) == null) && (fb8Var = this.h) != null) {
            fb8Var.r();
        }
    }

    public void z1() {
        fz4 fz4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048803, this) == null) && (fz4Var = this.M0) != null) {
            fz4Var.h(false);
        }
    }

    public void A2(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(o2, Integer.valueOf(p2));
            if (i3 == 1002 && !z2) {
                i4 = R.string.report_post_confirm;
            } else {
                i4 = R.string.del_all_post_confirm;
            }
            int i5 = R.string.confirm_title;
            if (i2 == 0) {
                if (i3 == 1002 && !z2) {
                    i4 = R.string.report_thread_confirm;
                } else {
                    i5 = R.string.del_my_thread_confirm;
                    i4 = R.string.del_my_thread_confirm_subtitle;
                }
            }
            this.V = new wv4(this.c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.V.setMessageId(i4);
            } else {
                this.V.setOnlyMessageShowCenter(false);
                this.V.setMessage(str2);
            }
            this.V.setYesButtonTag(sparseArray);
            this.V.setPositiveButton(R.string.obfuscated_res_0x7f0f0511, this.c);
            this.V.setNegativeButton(R.string.obfuscated_res_0x7f0f0509, new w(this));
            this.V.setCancelable(true);
            this.V.create(this.c.getPageContext());
            if (z3) {
                Q3(sparseArray, i5, i4);
            } else if (z2) {
                Q3(sparseArray, i5, i4);
            } else if (H3()) {
                kr5 kr5Var = new kr5(this.c.M().l1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.M().l1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.M().l1().o().has_forum_rule.intValue());
                kr5Var.i(this.c.M().l1().l().getId(), this.c.M().l1().l().getName());
                kr5Var.h(this.c.M().l1().l().getImage_url());
                kr5Var.j(this.c.M().l1().l().getUser_level());
                X3(sparseArray, i2, kr5Var, this.c.M().l1().X(), false);
            } else {
                f4(this.V, i2);
            }
        }
    }

    public void A4(boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z2) == null) {
            j78 j78Var = this.F;
            if (j78Var != null) {
                j78Var.u0(z2);
                this.F.Z();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.a1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.o(z2);
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder2 = this.e1.c;
            if (pbReplyTitleViewHolder2 != null) {
                pbReplyTitleViewHolder2.o(z2);
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                pbFragment.O6(z2);
            }
            if (z2) {
                ya8.d(this.c.getPageContext(), this.c.M(), this.c.K5());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            y48 y48Var = this.O0;
            if (y48Var != null) {
                str = y48Var.m();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public final String H0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048607, this, j2)) == null) {
            if (j2 == 0) {
                return "";
            }
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (j2 > 9990000) {
                return "· · ·";
            }
            if (j2 >= 1000000) {
                numberFormat.setMaximumFractionDigits(0);
                return numberFormat.format(((float) j2) / 10000.0f) + ExifInterface.LONGITUDE_WEST;
            } else if (j2 >= 10000) {
                numberFormat.setMaximumFractionDigits(1);
                return numberFormat.format(((float) j2) / 10000.0f) + ExifInterface.LONGITUDE_WEST;
            } else {
                return "" + j2;
            }
        }
        return (String) invokeJ.objValue;
    }

    public final String I0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            if (i2 == 0) {
                return this.c.getString(R.string.obfuscated_res_0x7f0f0e5f);
            }
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (i2 > 9990000) {
                return "· · ·";
            }
            if (i2 >= 1000000) {
                numberFormat.setMaximumFractionDigits(0);
                return numberFormat.format(i2 / 10000.0f) + ExifInterface.LONGITUDE_WEST;
            } else if (i2 >= 10000) {
                numberFormat.setMaximumFractionDigits(1);
                return numberFormat.format(i2 / 10000.0f) + ExifInterface.LONGITUDE_WEST;
            } else {
                return "" + i2;
            }
        }
        return (String) invokeI.objValue;
    }

    public final void L3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048626, this, sparseArray) != null) || this.c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1217, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f037e, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.S());
        tBAlertBuilder.w(R.string.musk_my_thread_confirm);
        tBAlertBuilder.m(R.string.musk_my_thread_confirm_subtitle);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog z2 = tBAlertBuilder.z();
        aVar.a(new z(this, z2, sparseArray));
        aVar2.a(new a0(this, z2));
    }

    public void Y2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, editorTools) == null) {
            this.n0 = editorTools;
            editorTools.setOnCancelClickListener(new s(this));
            this.n0.setId(R.id.obfuscated_res_0x7f0918a5);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.n0.getParent() == null) {
                this.d.addView(this.n0, layoutParams);
            }
            this.n0.y(TbadkCoreApplication.getInst().getSkinType());
            this.n0.setActionListener(24, new t(this));
            x1();
            this.c.H5().g(new u(this));
        }
    }

    public void i2(yw8 yw8Var) {
        y48 y48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048719, this, yw8Var) == null) && yw8Var != null && yw8Var.b != null && (y48Var = this.O0) != null && y48Var.Q() != null && this.O0.Q().getAgreeData() != null) {
            AgreeData agreeData = this.O0.Q().getAgreeData();
            String str = yw8Var.b.nid;
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                    return;
                }
            } else {
                String str2 = yw8Var.b.threadId;
                String str3 = agreeData.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
            }
            AgreeData agreeData2 = yw8Var.b;
            L2(agreeData2, agreeData2.agreeNum);
        }
    }

    public void k2(Configuration configuration) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048729, this, configuration) != null) || configuration == null) {
            return;
        }
        v0();
        if (configuration.orientation == 2) {
            v1();
            x1();
        } else {
            V2();
        }
        v78 v78Var = this.k1;
        if (v78Var != null) {
            v78Var.g();
        }
        this.c.W5();
        this.E.setVisibility(8);
        this.h.D(false);
        this.c.P6(false);
        if (this.t != null) {
            if (configuration.orientation == 1) {
                s1().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.l2 = true;
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setIsLandscape(true);
                    this.l.smoothScrollToPosition(0);
                }
            } else {
                this.l2 = false;
                PbLandscapeListView pbLandscapeListView2 = this.l;
                if (pbLandscapeListView2 != null) {
                    pbLandscapeListView2.setIsLandscape(false);
                    int i2 = this.j2;
                    if (i2 > 0) {
                        this.l.smoothScrollBy(i2, 0);
                    }
                }
            }
            this.t.j(configuration);
            this.V0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void l4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048736, this, z2) == null) && this.l != null && (textView = this.W0) != null && this.e != null) {
            if (z2) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.e.setVisibility(0);
                } else {
                    this.e.setVisibility(8);
                    this.l.removeHeaderView(this.W0);
                    this.l.setTextViewAdded(false);
                }
                if (this.W0.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.W0.getLayoutParams();
                    layoutParams.height = m2;
                    this.W0.setLayoutParams(layoutParams);
                }
                W2();
                return;
            }
            if (textView.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.W0.getLayoutParams();
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + d1(true);
                this.W0.setLayoutParams(layoutParams2);
            }
            W2();
            P2();
        }
    }

    public void w1(boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048788, this, z2) == null) && this.u0 != null && this.y0 != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            y48 y48Var = this.O0;
            if (y48Var != null && y48Var.r0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            y48 y48Var2 = this.O0;
            if (y48Var2 != null && y48Var2.s0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.y0.setText(tbSingleton.getAdVertiComment(z3, z4, l1()));
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.u0.startAnimation(alphaAnimation);
            }
            this.t0.setVisibility(0);
            this.u0.setVisibility(0);
            this.K0 = true;
            if (this.f1 != null && !this.x1.l()) {
                this.f1.setVisibility(0);
                U2(true);
            }
        }
    }

    public void x4(y48 y48Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048796, this, y48Var) == null) {
            if (y48Var != null && AntiHelper.o(y48Var.Q())) {
                jd8 jd8Var = this.G0;
                if (jd8Var != null) {
                    jd8Var.l(false);
                    this.G0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.D0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.D0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.D0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            jd8 jd8Var2 = this.G0;
            if (jd8Var2 != null && jd8Var2.h()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.D0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.D0.setLayoutParams(layoutParams2);
            ImageView imageView = this.D0;
            if (UbsABTestHelper.isShareTopRight()) {
                i2 = R.color.CAM_X0105;
            } else {
                i2 = R.color.CAM_X0107;
            }
            WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_pb_bottom_share26, i2, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void B2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(o2, Integer.valueOf(p2));
            if (z2) {
                L3(sparseArray);
            } else {
                M3(i2, sparseArray);
            }
        }
    }

    public void F0(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f12c7));
            } else if (z3) {
                if (yi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0cd1);
                }
                this.c.showToast(str);
            }
        }
    }

    public void C2(SparseArray<Object> sparseArray, boolean z2) {
        int i2;
        dw4 dw4Var;
        dw4 dw4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, sparseArray, z2) == null) {
            hw4 hw4Var = new hw4(this.c.getContext());
            hw4Var.s(this.c.getString(R.string.obfuscated_res_0x7f0f02f2));
            hw4Var.p(new v(this, z2));
            ArrayList arrayList = new ArrayList();
            int i3 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            } else {
                i2 = -1;
            }
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && i2 != 2) {
                if (sparseArray.get(R.id.tag_del_post_type) instanceof Integer) {
                    i3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                }
                if (i3 == 0) {
                    dw4Var2 = new dw4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04d6), hw4Var);
                } else {
                    dw4Var2 = new dw4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04c9), hw4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                dw4Var2.d.setTag(sparseArray2);
                arrayList.add(dw4Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                dw4 dw4Var3 = new dw4(13, this.c.getString(R.string.multi_delete), hw4Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                dw4Var3.d.setTag(sparseArray3);
                arrayList.add(dw4Var3);
            }
            if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !a2()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                dw4 dw4Var4 = new dw4(11, this.c.getString(R.string.forbidden_person), hw4Var);
                dw4Var4.d.setTag(sparseArray4);
                arrayList.add(dw4Var4);
            }
            if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                sparseArray5.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                sparseArray5.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                sparseArray5.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                sparseArray5.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                sparseArray5.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                sparseArray5.put(R.id.tag_user_mute_msg, sparseArray.get(R.id.tag_user_mute_msg));
                if (z2) {
                    dw4Var = new dw4(12, this.c.getString(R.string.un_mute), hw4Var);
                } else {
                    dw4Var = new dw4(12, this.c.getString(R.string.obfuscated_res_0x7f0f0bb7), hw4Var);
                }
                dw4Var.d.setTag(sparseArray5);
                arrayList.add(dw4Var);
            }
            xa8.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                hw4Var.l(arrayList, false);
            } else {
                hw4Var.l(arrayList, true);
            }
            fw4 fw4Var = new fw4(this.c.getPageContext(), hw4Var);
            this.T = fw4Var;
            fw4Var.k();
        }
    }

    public final void I2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        boolean z3;
        int measuredHeight;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048613, this, pbReplyTitleViewHolder, z2) == null) && !this.o1 && this.X0 != null && this.h.q() != null) {
            View s3 = J0().s();
            if (s3 != null) {
                int[] iArr = new int[2];
                s3.getLocationInWindow(iArr);
                int i3 = iArr[1];
                if (i3 != 0) {
                    if (this.X0.getVisibility() == 0 && i3 - this.h.q().getBottom() <= this.X0.getHeight()) {
                        this.Y0.setVisibility(0);
                        if (i3 > this.h.q().getBottom()) {
                            i2 = -(((this.X0.getHeight() + this.Y0.getHeight()) + this.h.q().getBottom()) - s3.getBottom());
                        } else {
                            i2 = -this.X0.getHeight();
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.X0.getLayoutParams();
                        if (layoutParams.topMargin != i2) {
                            layoutParams.topMargin = i2;
                            this.X0.setLayoutParams(layoutParams);
                        }
                    } else {
                        this.Y0.setVisibility(4);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.X0.getLayoutParams();
                        if (layoutParams2.topMargin != 0) {
                            layoutParams2.topMargin = 0;
                            this.X0.setLayoutParams(layoutParams2);
                        }
                    }
                }
            }
            int G = this.F.G();
            if (G > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null && G > pbLandscapeListView.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
                    this.X0.setVisibility(4);
                    return;
                }
                this.X0.setVisibility(0);
                N3(false);
                this.h.a.hideBottomLine();
                if (this.X0.getParent() != null && ((ViewGroup) this.X0.getParent()).getHeight() <= this.X0.getTop()) {
                    this.X0.getParent().requestLayout();
                }
            } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.getView() != null && pbReplyTitleViewHolder.g != null) {
                int top = pbReplyTitleViewHolder.getView().getTop();
                if (pbReplyTitleViewHolder.getView().getParent() != null) {
                    if (this.d1) {
                        this.c1 = top;
                        this.d1 = false;
                    }
                    int i4 = this.c1;
                    if (top < i4) {
                        i4 = top;
                    }
                    this.c1 = i4;
                }
                if (top == 0 && !pbReplyTitleViewHolder.getView().isShown()) {
                    return;
                }
                if (this.E.getY() < 0.0f) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    measuredHeight = m2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
                } else {
                    measuredHeight = this.h.q().getMeasuredHeight() - pbReplyTitleViewHolder.g.getMeasuredHeight();
                    this.h.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.c1) {
                    this.X0.setVisibility(0);
                    N3(false);
                } else if (top < measuredHeight) {
                    this.X0.setVisibility(0);
                    N3(false);
                } else {
                    this.X0.setVisibility(4);
                    this.h.a.hideBottomLine();
                }
                if (z2) {
                    this.d1 = true;
                }
            } else {
                PbLandscapeListView pbLandscapeListView2 = this.l;
                if (pbLandscapeListView2 != null && pbLandscapeListView2.getFirstVisiblePosition() == 0) {
                    this.X0.setVisibility(4);
                    this.h.a.hideBottomLine();
                }
            }
        }
    }

    public final void C4() {
        PbFragment pbFragment;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (pbFragment = this.c) != null && pbFragment.M() != null && this.c.M().G != null && this.c.M().G.Q() != null && this.c.M().G.Q().isXiuXiuThread()) {
            ThreadData Q = this.c.M().G.Q();
            int i3 = 0;
            if (this.c.M().Q0()) {
                i2 = 1;
            } else if (this.c.M().T0()) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            ItemInfo itemInfo = TbSingleton.getInstance().getFrsItemInfoCache().get(Q.getForum_name());
            if (itemInfo != null) {
                i3 = itemInfo.id.intValue();
                str = itemInfo.name;
            } else {
                str = "";
            }
            new StatisticItem("c15062").addParam("obj_locate", i2).addParam("fid", Q.getFid()).addParam("fname", Q.getForum_name()).addParam("post_id", Q.getTid()).addParam("obj_id", i3).addParam("obj_name", str).eventStat();
        }
    }

    public void K2() {
        PbLandscapeListView pbLandscapeListView;
        int i2;
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048621, this) != null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.n1;
        int i4 = 0;
        if (this.l.getFirstVisiblePosition() != 0 && this.l.getFirstVisiblePosition() + headerViewsCount >= 0) {
            i2 = this.l.getFirstVisiblePosition() + headerViewsCount;
        } else {
            i2 = 0;
        }
        View childAt = this.l.getChildAt(0);
        if (childAt != null) {
            i3 = childAt.getTop();
        } else {
            i3 = -1;
        }
        this.e1.c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.e1));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.e1.c;
        int m1 = m1(pbReplyTitleViewHolder);
        int measuredHeight = this.E.getMeasuredHeight() + ((int) this.E.getY());
        boolean z3 = true;
        if (this.X0.getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.E.getY() >= 0.0f) {
            z3 = false;
        }
        if ((z2 && pbReplyTitleViewHolder != null) || i2 >= this.F.G() + this.l.getHeaderViewsCount()) {
            if (pbReplyTitleViewHolder != null) {
                i4 = pbReplyTitleViewHolder.g.getMeasuredHeight();
            }
            if (z3) {
                this.l.setSelectionFromTop(this.F.G() + this.l.getHeaderViewsCount(), m2 - i4);
            } else {
                this.l.setSelectionFromTop(this.F.G() + this.l.getHeaderViewsCount(), this.h.q().getMeasuredHeight() - i4);
            }
        } else {
            this.l.setSelectionFromTop(i2, i3);
        }
        if (this.o1 && this.t != null) {
            this.l.setSelectionFromTop(this.F.G() + this.l.getHeaderViewsCount(), this.t.d());
        } else if (this.Q0 != 6) {
        } else {
            this.l.setOnLayoutListener(new l(this, m1, pbReplyTitleViewHolder, z2, measuredHeight, i2, i3));
        }
    }

    public void l2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048734, this) == null) {
            z78 z78Var = this.p;
            if (z78Var != null) {
                z78Var.l();
            }
            y88 y88Var = this.r;
            if (y88Var != null) {
                y88Var.o();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.d.getHandler().removeCallbacksAndMessages(null);
            }
            jd8 jd8Var = this.G0;
            if (jd8Var != null) {
                jd8Var.k();
            }
            u88 u88Var = this.l1;
            if (u88Var != null) {
                u88Var.a();
            }
            l88 l88Var = this.B1;
            if (l88Var != null) {
                l88Var.c();
            }
            PbTopTipView pbTopTipView = this.s1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.S) != null) {
                noNetworkView.e(bVar);
            }
            tw8.d();
            v0();
            D0();
            if (this.i1 != null) {
                bh.a().removeCallbacks(this.i1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.U0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            MessageManager.getInstance().unRegisterListener(this.S1);
            this.Y1 = null;
            this.g.removeCallbacksAndMessages(null);
            this.F.a0(3);
            View view2 = this.e;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            x98 x98Var = this.t;
            if (x98Var != null) {
                x98Var.a();
            }
            j78 j78Var = this.F;
            if (j78Var != null) {
                j78Var.c0();
            }
            ca8 ca8Var = this.w1;
            if (ca8Var != null) {
                ca8Var.l();
            }
            PbEmotionBar pbEmotionBar = this.f1;
            if (pbEmotionBar != null) {
                pbEmotionBar.x();
            }
            w98 w98Var = this.w;
            if (w98Var != null) {
                w98Var.D();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.a1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.p(null);
            }
            this.y1 = null;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setOnLayoutListener(null);
                this.l.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
                this.l.setListViewDragListener(null);
                this.l = null;
            }
            a1 a1Var = this.e1;
            if (a1Var != null) {
                a1Var.c = null;
            }
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048737, this) == null) {
            if (!this.c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                ac8.r("c10517", this.k0, 2);
            } else if (!this.c.c5()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                c95 H5 = this.c.H5();
                if (H5 != null && (H5.x() || H5.z())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.c.H5().w(false, null);
                    return;
                }
                if (this.n0 != null) {
                    J1();
                }
                EditorTools editorTools = this.n0;
                if (editorTools != null) {
                    this.K0 = false;
                    if (editorTools.p(2) != null) {
                        tw8.c(this.c.getPageContext(), (View) this.n0.p(2).m, false, v2);
                    }
                }
                v1();
            }
        }
    }

    public void o2() {
        PostData postData;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048749, this) != null) || this.c == null) {
            return;
        }
        if (!this.I1 && this.J1 != 17) {
            if (this.p1 && !this.o1 && (postData = this.P0) != null && postData.r() != null) {
                int i3 = 2;
                if (this.c.u0()) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                if (!this.o1) {
                    i3 = 1;
                }
                ac8.q("c12601", i3, i2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.getPageContext().getPageActivity(), this.P0.r().getUserId(), this.P0.r().getUserName(), this.c.M().K0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
                return;
            }
            return;
        }
        y48 y48Var = this.O0;
        if (y48Var != null && y48Var.l() != null && !yi.isEmpty(this.O0.l().getName())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getContext()).createNormalCfg(this.O0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.O0.S()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.O0.l().getId()));
        }
    }

    public void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048769, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            w4();
            this.c.z6();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && pbFragment.M() != null && this.c.M().l1() != null && this.c.M().l1().Q() != null && this.c.M().l1().Q().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.c.M().G1()).param("fid", this.c.M().l1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.c.M().b).param("fid", this.c.M().l1().m()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public void D3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.y0.performClick();
            if (!StringUtils.isNull(str) && this.c.H5() != null && this.c.H5().s() != null && this.c.H5().s().i() != null) {
                EditText i2 = this.c.H5().s().i();
                i2.setText(str);
                i2.setSelection(str.length());
            }
        }
    }

    public final void H1(y48 y48Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, y48Var) != null) || y48Var == null || y48Var.Q() == null || !y48Var.Q().isInterviewLive() || this.U0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.T0.inflate();
        this.U0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.Q);
        this.U0.setCallback(this.c.A5());
        this.U0.setData(this.c, y48Var);
    }

    public final int R0(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048647, this, i2)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return 0;
            }
            pn adapter2 = pbLandscapeListView.getAdapter2();
            if (adapter2 == null) {
                return i2;
            }
            if (i2 < adapter2.getCount() && i2 >= 0 && (adapter2.getItem(i2) instanceof v48)) {
                i2++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i2 > o3) {
                i2 = o3;
            }
            if (this.l.getAdapter2() != null && (this.l.getAdapter2() instanceof pn)) {
                i3 = this.l.getAdapter2().n();
            } else {
                i3 = 0;
            }
            if (i2 <= i3) {
                return 0;
            }
            return i2 - i3;
        }
        return invokeI.intValue;
    }

    public void S3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048654, this, z2) == null) && this.u0 != null && (textView = this.y0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f0541);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.u0.startAnimation(alphaAnimation);
            }
            this.t0.setVisibility(0);
            this.u0.setVisibility(0);
            this.K0 = true;
            if (this.f1 != null && !this.x1.l()) {
                this.f1.setVisibility(0);
                U2(true);
            }
        }
    }

    public void a3(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048686, this, str) == null) && this.L != null) {
            int i2 = 0;
            a1 a1Var = this.e1;
            if (a1Var != null && (pbReplyTitleViewHolder = a1Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                i2 = this.e1.c.getView().getTop() < 0 ? this.e1.c.getView().getHeight() : this.e1.c.getView().getBottom();
            }
            this.L.I(str, i2);
        }
    }

    public final void n4(y48 y48Var) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048746, this, y48Var) == null) && !this.A1 && y48Var != null && y48Var.Q() != null && !y48Var.Q().isVideoThreadType()) {
            boolean z3 = false;
            if (y48Var.Q().getIs_good() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (y48Var.Q().getIs_top() == 1) {
                z3 = true;
            }
            w98 w98Var = this.w;
            if (w98Var != null) {
                w98Var.q(y48Var, z2, z3);
            }
            u98 u98Var = this.v;
            if (u98Var != null) {
                u98Var.b(y48Var, z2, z3);
            }
        }
    }

    public void p0(boolean z2) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048752, this, z2) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            int i4 = 0;
            if (pbLandscapeListView != null) {
                if (z2) {
                    SkinManager.setBackgroundColor(pbLandscapeListView, R.color.CAM_X0202);
                } else {
                    pbLandscapeListView.setBackgroundResource(0);
                }
            }
            View view2 = this.q0;
            if (view2 != null) {
                if (z2) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                view2.setVisibility(i3);
            }
            PbListView pbListView = this.L;
            if (pbListView != null) {
                if (z2) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                pbListView.N(i2);
            }
            View view3 = this.N;
            if (view3 != null) {
                if (z2) {
                    i4 = 8;
                }
                view3.setVisibility(i4);
            }
        }
    }

    public void E2(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, view2) == null) && this.B0.getData() != null && this.B0.getData().hasAgree && this.c.getActivity() != null) {
            a48 a48Var = new a48(this.c.getContext());
            int g2 = zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds774);
            int g3 = zi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07076f);
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g3, g2);
            layoutParams.leftMargin = ((view2.getWidth() / 2) + i2) - ((int) ((g3 * 1) / 1.45d));
            layoutParams.topMargin = zi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
            a48Var.k(g2);
            a48Var.j(layoutParams);
            a48Var.i(false);
            a48Var.n(true, this.c.getActivity().findViewById(16908290), 0, i3, this.O0.S(), this.O0.m());
            a48Var.l(new o(this));
        }
    }

    public final boolean R3(y48 y48Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, y48Var)) == null) {
            if (y48Var == null || y48Var.Q() == null) {
                return false;
            }
            if (y48Var.Q().getIsLive() != 1 && y48Var.Q().getThreadType() != 33 && ((y48Var.Q().getTopicData() == null || y48Var.Q().getTopicData().a() == 0) && y48Var.Q().getIs_top() != 1 && y48Var.Q().getIs_good() != 1 && !y48Var.Q().isActInfo() && !y48Var.Q().isInterviewLive() && !y48Var.Q().isVoteThreadType() && y48Var.Q().getYulePostActivityData() == null && yi.isEmpty(y48Var.Q().getCategory()) && !y48Var.Q().isGodThread() && !y48Var.Q().isRealGod())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void m2(TbRichText tbRichText) {
        y48 y48Var;
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048739, this, tbRichText) == null) && (y48Var = this.O0) != null && y48Var.H() != null && !this.O0.H().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i2 = 0; i2 < this.O0.H().size() && (postData = this.O0.H().get(i2)) != null && postData.r() != null && !StringUtils.isNull(postData.r().getUserId()); i2++) {
                if (this.O0.H().get(i2).r().getUserId().equals(tbRichText.getAuthorId())) {
                    y68 y68Var = this.x1;
                    if (y68Var != null && y68Var.l()) {
                        O3(false);
                    }
                    PbEmotionBar pbEmotionBar = this.f1;
                    if (pbEmotionBar != null) {
                        pbEmotionBar.q(true);
                    }
                    postData.r().getName_show();
                    return;
                }
            }
        }
    }

    public void t0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048772, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            wv4 wv4Var = new wv4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            wv4Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(o2, Integer.valueOf(r2));
            wv4Var.setYesButtonTag(sparseArray);
            wv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f15f1, this.c);
            wv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037e, new s0(this));
            wv4Var.create(this.c.getPageContext()).show();
        }
    }

    public void v4(w48 w48Var) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048786, this, w48Var) != null) || w48Var == null) {
            return;
        }
        this.h.L();
        if (!StringUtils.isNull(w48Var.b)) {
            this.h.H(w48Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1472);
        int e2 = yg.e(w48Var.a, 0);
        if (e2 != 100) {
            if (e2 != 300) {
                if (e2 != 400) {
                    string = "";
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13ea);
                }
            } else {
                string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0304);
            }
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f119c);
        }
        this.c.showNetRefreshView(this.d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new l0(this, w48Var.c));
    }

    public final boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            y48 y48Var = this.O0;
            if (y48Var != null && y48Var.Q() != null && !ListUtils.isEmpty(this.O0.Q().getThreadRecommendInfoDataList()) && this.c != null && this.v.d() != null && this.v.d().getVisibility() == 0 && this.O0.Q().getThreadRecommendInfoDataList().get(0) != null && this.O0.Q().getThreadRecommendInfoDataList().get(0).businessType == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void H2() {
        fb8 fb8Var;
        y48 y48Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && this.v != null && (fb8Var = this.h) != null && fb8Var.q() != null && (y48Var = this.O0) != null && y48Var.Q() != null && this.O0.Q().isQuestionThread() && this.v.d() != null && this.v.d().getVisibility() == 0) {
            int[] iArr = new int[2];
            this.v.d().getLocationInWindow(iArr);
            boolean z3 = true;
            int height = iArr[1] + this.v.d().getHeight();
            if (this.v.d().getParent() == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            fb8 fb8Var2 = this.h;
            if (height > fb8Var2.q().getBottom() && z2) {
                z3 = false;
            }
            fb8Var2.I(z3, this.O0.Q().getSpan_str());
        }
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048612, this) != null) || !this.c.B5()) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091549);
        this.k = viewStub;
        viewStub.setVisibility(0);
        if (this.B == null) {
            this.B = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091548);
            xg5.a(this.c.getPageContext(), this.B);
        }
        if (this.C == null) {
            this.C = (TextView) this.B.findViewById(R.id.obfuscated_res_0x7f09154d);
        }
        if (this.D == null) {
            this.D = (TextView) this.B.findViewById(R.id.obfuscated_res_0x7f09154c);
        }
        this.C.setOnClickListener(this.Q);
        this.D.setOnClickListener(this.Q);
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            if (this.c != null && this.n0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.n0.j();
                v1();
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public int N0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return 0;
            }
            int firstVisiblePosition = pbLandscapeListView.getFirstVisiblePosition();
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (lastVisiblePosition > firstVisiblePosition) {
                int i2 = (lastVisiblePosition - firstVisiblePosition) + 1;
                int[] iArr = new int[i2];
                Rect rect = new Rect();
                int childCount = this.l.getChildCount();
                int i3 = 0;
                for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                    int i5 = i4 - firstVisiblePosition;
                    if (i5 < childCount && (childAt = this.l.getChildAt(i5)) != null) {
                        childAt.getGlobalVisibleRect(rect);
                        iArr[i5] = rect.height();
                    }
                    i3 += iArr[i5];
                }
                int i6 = i3 / 2;
                int i7 = 0;
                int i8 = 0;
                while (true) {
                    if (i7 >= i2) {
                        break;
                    }
                    i8 += iArr[i7];
                    if (i8 > i6) {
                        firstVisiblePosition += i7;
                        break;
                    }
                    i7++;
                }
            }
            if (firstVisiblePosition < 0) {
                return 0;
            }
            return firstVisiblePosition;
        }
        return invokeV.intValue;
    }

    public final void T2() {
        PbFragment pbFragment;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048657, this) == null) && (pbFragment = this.c) != null && pbFragment.H5() != null && this.n0 != null) {
            x85.a().c(0);
            c95 H5 = this.c.H5();
            H5.M();
            H5.K();
            if (H5.v() != null) {
                WriteImagesInfo v3 = H5.v();
                if (H5.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                v3.setMaxImagesAllowed(i2);
            }
            H5.d0(SendView.h);
            H5.h(SendView.h);
            g75 o3 = this.n0.o(23);
            g75 o4 = this.n0.o(2);
            g75 o5 = this.n0.o(5);
            if (o4 != null) {
                o4.display();
            }
            if (o5 != null) {
                o5.display();
            }
            if (o3 != null) {
                o3.hide();
            }
            this.n0.invalidate();
        }
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048709, this) == null) && UbsABTestHelper.isShareTopRight()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C0.getLayoutParams();
            layoutParams.addRule(11);
            this.C0.setLayoutParams(layoutParams);
            if (this.D0.getParent() != null) {
                ((ViewGroup) this.D0.getParent()).removeView(this.D0);
                ((ViewGroup) this.E0.getParent()).removeView(this.E0);
            }
            if (this.F0.getParent() != null) {
                ((ViewGroup) this.F0.getParent()).removeView(this.F0);
            }
            RelativeLayout relativeLayout = new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            relativeLayout.addView(this.D0);
            relativeLayout.addView(this.E0);
            relativeLayout.addView(this.F0);
            this.h.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, relativeLayout, (View.OnClickListener) null);
            this.h.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).setClipChildren(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r5.K1 == 1) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u0() {
        id8 id8Var;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048777, this) != null) || (id8Var = this.N1) == null) {
            return;
        }
        if (this.l != null && id8Var.a() != null && this.N1.a().getParent() != null) {
            i2 = this.l.getPositionForView(this.N1.a());
        } else {
            i2 = -1;
        }
        boolean z3 = false;
        if (i2 != -1) {
            if (this.N1.a().getTop() + t2 <= this.X0.getBottom()) {
                this.K1 = 1;
                z2 = true;
            } else {
                this.K1 = 0;
                z2 = false;
            }
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.a1;
        if (this.K1 == 1) {
            z3 = true;
        }
        pbReplyTitleViewHolder.t(z3);
        this.N1.e(z2);
    }

    public void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048805, this) == null) {
            this.c.hideProgressBar();
            y48 y48Var = this.O0;
            if (y48Var != null && this.L != null && y48Var.z() != null && this.O0.z().b() == 0) {
                this.L.x(this.O0.t());
                if (this.O0.t()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.O0.m());
                    statisticItem.param("fname", this.O0.n());
                    statisticItem.param("tid", this.O0.S());
                    TiebaStatic.log(statisticItem);
                }
            }
            D0();
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.A(0L);
            }
            y0();
        }
    }

    public final boolean H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            PbFragment pbFragment = this.c;
            if (pbFragment == null || pbFragment.M().l1().l().getDeletedReasonInfo() == null || 1 != this.c.M().l1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void J3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            int i2 = 0;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.V0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            fb8 fb8Var = this.h;
            if (fb8Var != null && (view2 = fb8Var.d) != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    i2 = 8;
                }
                view2.setVisibility(i2);
            }
        }
    }

    public final void R2() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048649, this) != null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null || (waterRippleView = this.z0) == null) {
            return;
        }
        ViewParent parent = waterRippleView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.z0);
        }
        TextView textView = this.H0;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void S2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048653, this) == null) && (pbLandscapeListView = this.l) != null) {
            this.z.d(pbLandscapeListView);
            this.v.h(this.l);
            this.w.F(this.l);
            this.x.d(this.l);
            this.u.f(this.l);
        }
    }

    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            View view2 = this.b1;
            if (view2 == null || view2.getParent() == null || this.L.o()) {
                return false;
            }
            int bottom = this.b1.getBottom();
            Rect rect = new Rect();
            this.b1.getWindowVisibleDisplayFrame(rect);
            if (bottom <= 0 || bottom > rect.bottom) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r0 < 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            int i2 = 0;
            if (pbLandscapeListView == null) {
                return 0;
            }
            int lastVisiblePosition = pbLandscapeListView.getLastVisiblePosition();
            if (this.t != null) {
                if (lastVisiblePosition == this.l.getCount() - 1) {
                    lastVisiblePosition--;
                }
            }
            i2 = lastVisiblePosition;
            return R0(i2);
        }
        return invokeV.intValue;
    }

    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            y48 y48Var = this.O0;
            if (y48Var == null || y48Var.l() == null || "0".equals(this.O0.l().getId()) || "me0407".equals(this.O0.l().getName())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void i4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            FallingView fallingView = this.P1;
            if (fallingView != null) {
                fallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.Q1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.P1) {
                this.Q1.setTag(null);
                this.Q1.setAutoCompleteShown(true);
                this.Q1.d();
            }
        }
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            PbListView pbListView = this.L;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.i())) {
                return this.L.i().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048732, this) == null) && this.O0 != null && UbsABTestHelper.isResizeInduceSharingABTest() && !za8.k(this.O0.S())) {
            this.G0.f();
            za8.b(this.O0.S());
        }
    }

    public String l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
            if (!yi.isEmpty(this.F1)) {
                return this.F1;
            }
            if (this.c != null) {
                this.F1 = TbadkCoreApplication.getInst().getResources().getString(a98.g());
            }
            return this.F1;
        }
        return (String) invokeV.objValue;
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            y68 y68Var = new y68(this.c, this, (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091609));
            this.x1 = y68Var;
            y68Var.o(this.Q);
            this.x1.p(this.U);
            this.x1.q(this.R);
            this.x1.o(this.Q);
            this.x1.s(this.l0);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048782, this) == null) {
            this.h.k();
            w98 w98Var = this.w;
            if (w98Var != null) {
                w98Var.r();
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                zi.z(pbFragment.getContext(), this.J);
            }
            x1();
            fw4 fw4Var = this.e0;
            if (fw4Var != null) {
                fw4Var.dismiss();
            }
            z0();
            wv4 wv4Var = this.G;
            if (wv4Var != null) {
                wv4Var.dismiss();
            }
            yv4 yv4Var = this.H;
            if (yv4Var != null) {
                yv4Var.e();
            }
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048787, this) == null) {
            this.h.k();
            w98 w98Var = this.w;
            if (w98Var != null) {
                w98Var.r();
            }
            fw4 fw4Var = this.e0;
            if (fw4Var != null) {
                fw4Var.dismiss();
            }
            z0();
            wv4 wv4Var = this.G;
            if (wv4Var != null) {
                wv4Var.dismiss();
            }
            yv4 yv4Var = this.H;
            if (yv4Var != null) {
                yv4Var.e();
            }
        }
    }

    public final void w4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048791, this) == null) && (pbFragment = this.c) != null && pbFragment.H5() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.c.H5().y())));
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048802, this) == null) {
            wv4 wv4Var = this.V;
            if (wv4Var != null) {
                wv4Var.dismiss();
            }
            Dialog dialog = this.W;
            if (dialog != null) {
                dh.b(dialog, this.c.getPageContext());
            }
            Dialog dialog2 = this.X;
            if (dialog2 != null) {
                dh.b(dialog2, this.c.getPageContext());
            }
            fw4 fw4Var = this.T;
            if (fw4Var != null) {
                fw4Var.dismiss();
            }
        }
    }

    public final void z4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048806, this) != null) || !this.c.B5()) {
            return;
        }
        if (this.c.G5() == -1) {
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0110, 1);
        }
        if (this.c.F5() == -1) {
            SkinManager.setViewTextColor(this.D, R.color.CAM_X0110, 1);
        }
    }

    public final void I3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (pbFragment = this.c) != null && pbFragment.getActivity() != null) {
            if (this.B0.getWidth() != 0 && this.B0.getHeight() != 0) {
                WaterRippleView waterRippleView = this.z0;
                if (waterRippleView == null) {
                    this.z0 = new WaterRippleView(this.c.getActivity());
                } else {
                    ViewParent parent = waterRippleView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(this.z0);
                    }
                }
                Rect rect = new Rect();
                this.d.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                this.B0.getImgAgree().getGlobalVisibleRect(rect2);
                int g2 = zi.g(this.c.getActivity(), R.dimen.tbds166);
                int i2 = ((rect2.right + rect2.left) / 2) - g2;
                int i3 = (rect.bottom - ((rect2.bottom + rect2.top) / 2)) - g2;
                int i4 = g2 * 2;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, i4);
                layoutParams.addRule(12, -1);
                layoutParams.setMargins(i2, 0, 0, i3);
                this.d.addView(this.z0, layoutParams);
                TextView textView = this.H0;
                if (textView != null) {
                    textView.setVisibility(4);
                    return;
                }
                return;
            }
            BdLog.e("AgreeView not measured");
        }
    }

    public final void e2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048701, this) == null) && (pbFragment = this.c) != null && pbFragment.M() != null && this.c.M().G != null && this.c.M().G.Q() != null && this.c.M().G.Q().isQuestionThread()) {
            ThreadData Q = this.c.M().G.Q();
            String x1 = this.c.M().x1();
            String y1 = this.c.M().y1();
            int i2 = 5;
            if ("question_answer_invite".equals(x1)) {
                i2 = 1;
            } else if ("3".equals(y1)) {
                i2 = 2;
            } else if ("answer_top".equals(x1)) {
                i2 = 3;
            } else if (this.c.M().Q0()) {
                i2 = 4;
            }
            TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", Q.getId()).param("fid", Q.getFid()).param("obj_source", i2));
        }
    }

    public final void o0() {
        y48 y48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048747, this) == null) && this.A != null && (y48Var = this.O0) != null && y48Var.Q() != null && !ListUtils.isEmpty(this.O0.Q().getThreadRecommendInfoDataList()) && this.O0.Q().getThreadRecommendInfoDataList().get(0) != null && this.v.d().getVisibility() == 0) {
            if (this.v.d().getParent() == null) {
                this.A.g(false);
                return;
            }
            int[] iArr = new int[2];
            this.A.b().getLocationInWindow(iArr);
            if (iArr[1] + this.A.b().getHeight() > this.h.q().getBottom()) {
                this.A.i();
                this.A.g(true);
                return;
            }
            this.A.g(false);
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048767, this) == null) && !this.k2) {
            TiebaStatic.log("c10490");
            this.k2 = true;
            wv4 wv4Var = new wv4(this.c.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(o2, Integer.valueOf(q2));
            wv4Var.setTitle(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            wv4Var.setContentView(inflate);
            wv4Var.setYesButtonTag(sparseArray);
            wv4Var.setPositiveButton(R.string.grade_button_tips, this.c);
            wv4Var.setNegativeButton(R.string.look_again, new q0(this));
            wv4Var.create(this.c.getPageContext()).show();
        }
    }

    public final void K1(y48 y48Var, a25 a25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048620, this, y48Var, a25Var) == null) && this.R1 != null && y48Var != null && a25Var != null && this.c.getContext() != null) {
            if (!RightFloatLayerView.k()) {
                C1();
                return;
            }
            if (this.Q1 == null) {
                RightFloatLayerView F = RightFloatLayerLottieView.F(a25Var, this.c.getContext());
                this.Q1 = F;
                F.setPageContext(this.c.getPageContext());
                this.R1.removeAllViews();
                this.R1.addView(this.Q1);
            }
            if ((this.P1.getTag() instanceof Boolean) && !((Boolean) this.P1.getTag()).booleanValue()) {
                this.Q1.setAutoCompleteShown(false);
                this.Q1.setTag(this.P1);
                this.Q1.c();
            }
            if (a25Var.a()) {
                return;
            }
            this.Q1.setData(a25Var);
            this.Q1.setLogoListener(new r0(this, a25Var));
            this.Q1.setFeedBackListener(new v0(this, a25Var));
        }
    }

    public void L1(y48 y48Var) {
        a25 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048624, this, y48Var) != null) || y48Var == null) {
            return;
        }
        if (y48Var.r0()) {
            pbAdFloatViewItemData = y48Var.d0();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            K1(y48Var, pbAdFloatViewItemData);
        } else {
            C1();
        }
    }

    public final boolean Q1(y48 y48Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, y48Var)) == null) {
            if (y48Var == null || y48Var.Q() == null) {
                return false;
            }
            SpannableStringBuilder span_str = y48Var.Q().getSpan_str();
            if (span_str == null) {
                return true;
            }
            if (!TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e60).equals(span_str.toString())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean W1(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        PostData Z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, threadData)) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                y48 y48Var = this.O0;
                if (y48Var != null && (Z = y48Var.Z()) != null && Z.r() != null) {
                    str = Z.r().getUserId();
                } else {
                    str = "";
                }
                return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int m1(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048738, this, pbReplyTitleViewHolder)) == null) {
            if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView() == null) {
                return 0;
            }
            if (pbReplyTitleViewHolder.getView().getTop() == 0 && !pbReplyTitleViewHolder.getView().isShown()) {
                return 0;
            }
            return pbReplyTitleViewHolder.getView().getBottom();
        }
        return invokeL.intValue;
    }

    public void p2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048754, this, z2) == null) {
            if (z2) {
                U3();
            } else {
                y1();
            }
            this.e1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.e1));
            I2(this.e1.c, false);
        }
    }

    public void u4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048781, this, z2) == null) {
            this.h.K(z2);
            if (z2 && this.S0) {
                this.L.F(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setNextPage(this.L);
                }
                this.f = 2;
            }
            d2();
        }
    }

    public final void L2(AgreeData agreeData, long j2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048625, this, agreeData, j2) == null) && agreeData != null && (textView = this.H0) != null) {
            if (j2 > 0) {
                if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                    textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.H0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
                this.H0.setText(H0(j2));
                this.H0.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public final void M2(y48 y48Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, y48Var) == null) && y48Var != null && y48Var.Q() != null) {
            x4(y48Var);
            ImageView imageView = this.C0;
            if (imageView != null && imageView.getContext() != null) {
                if (y48Var.r()) {
                    WebPManager.setPureDrawable(this.C0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
                } else {
                    WebPManager.setPureDrawable(this.C0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            String I0 = I0(y48Var.Q().getReply_num());
            TextView textView = this.I0;
            if (textView != null) {
                textView.setText(I0);
            }
            TextView textView2 = this.J0;
            if (textView2 != null) {
                textView2.setText(I0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, y48Var.Q()));
            L2(y48Var.Q().getAgreeData(), y48Var.Q().getAgreeNum());
            if (this.B0 != null && y48Var.Q() != null) {
                this.B0.setThreadData(y48Var.Q());
                int i2 = 1;
                if (y48Var.Q().getAgreeData() != null) {
                    y48Var.Q().getAgreeData().isInThread = true;
                }
                this.B0.setData(y48Var.Q().getAgreeData());
                ls4 ls4Var = new ls4();
                ls4Var.b = 26;
                if (y48Var.Q().isVideoThreadType() && y48Var.Q().getThreadVideoInfo() != null) {
                    i2 = 2;
                }
                ls4Var.c = i2;
                PbFragment pbFragment = this.c;
                if (pbFragment != null && pbFragment.M() != null) {
                    ls4Var.j = this.c.M().getFromForumId();
                    ls4Var.f = this.c.M().k1();
                }
                this.B0.setStatisticData(ls4Var);
            }
        }
    }

    public void N1(y48 y48Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, y48Var) == null) {
            int i2 = 0;
            this.F.h0(y48Var, false);
            this.F.Z();
            y0();
            y68 y68Var = this.x1;
            if (y68Var != null) {
                y68Var.n();
            }
            ArrayList<PostData> H = y48Var.H();
            if (y48Var.z().b() == 0 || H == null || H.size() < y48Var.z().e()) {
                if (ListUtils.getCount(H) != 0 && (ListUtils.getCount(H) != 1 || H.get(0) == null || H.get(0).F() != 1)) {
                    if (y48Var.z().b() == 0) {
                        this.L.F(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.L.F(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.L.m();
                } else {
                    a1 a1Var = this.e1;
                    if (a1Var != null && (pbReplyTitleViewHolder = a1Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.e1.c.getView().getTop() < 0) {
                            bottom = this.e1.c.getView().getHeight();
                        } else {
                            bottom = this.e1.c.getView().getBottom();
                        }
                        i2 = bottom;
                    }
                    if (this.c.f6()) {
                        this.L.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e78), i2);
                    } else {
                        this.L.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e79), i2);
                    }
                }
            }
            M2(y48Var);
        }
    }

    public void P3(y48 y48Var) {
        PostData postData;
        fb8 fb8Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048642, this, y48Var) == null) && y48Var != null && (postData = this.P0) != null && postData.r() != null && (fb8Var = this.h) != null) {
            boolean z3 = !this.o1;
            this.p1 = z3;
            fb8Var.J(z3);
            if (this.c.I5() != null) {
                this.c.I5().s(this.p1);
            }
            J2();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && !pbFragment.u0() && !ListUtils.isEmpty(y48Var.p())) {
                fv4 fv4Var = y48Var.p().get(0);
                if (fv4Var != null) {
                    this.h.N(y48Var, fv4Var.d(), fv4Var.b(), fv4Var.a(), fv4Var.e());
                }
            } else if (y48Var.l() != null) {
                fb8 fb8Var2 = this.h;
                String name = y48Var.l().getName();
                String id = y48Var.l().getId();
                String image_url = y48Var.l().getImage_url();
                if (y48Var.l().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                fb8Var2.N(y48Var, name, id, image_url, z2);
            }
            if (this.p1) {
                this.w.P(y48Var, this.P0, this.i0);
                View view2 = this.Z0;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                if (this.y1 == null) {
                    this.y1 = new n0(this);
                }
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setListViewDragListener(this.y1);
                    return;
                }
                return;
            }
            View view3 = this.Z0;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            this.w.P(y48Var, this.P0, this.i0);
            this.y1 = null;
            PbLandscapeListView pbLandscapeListView2 = this.l;
            if (pbLandscapeListView2 != null) {
                pbLandscapeListView2.setListViewDragListener(null);
            }
        }
    }

    public void T3(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048658, this, view2) != null) || cz4.l().i("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.u0.getGlobalVisibleRect(rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        view2.getGlobalVisibleRect(rect);
        int i4 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.c.getContext());
        this.u1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f0458);
        this.u1.setGravity(17);
        this.u1.setPadding(zi.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, zi.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = zi.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f070253);
        if (this.u1.getParent() == null) {
            frameLayout.addView(this.u1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.c.getContext());
        this.t1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.t1.setHeight(-2);
        this.t1.setWidth(-2);
        this.t1.setFocusable(true);
        this.t1.setOutsideTouchable(false);
        this.t1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        GreyUtil.grey(this.t1);
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.postDelayed(new t0(this, i4, i2, i3, view2), 100L);
        }
        cz4.l().v("show_long_press_collection_tips", true);
    }

    public void d4(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, onItemClickListener) == null) {
            aw4 aw4Var = this.g0;
            if (aw4Var != null) {
                aw4Var.d();
                this.g0 = null;
            }
            if (this.O0 == null) {
                return;
            }
            ArrayList<jw4> arrayList = new ArrayList<>();
            String string = this.c.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.O0.N() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new jw4(string, "", z2, Integer.toString(1)));
            String string2 = this.c.getContext().getString(R.string.my_fans);
            if (this.O0.N() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new jw4(string2, "", z3, Integer.toString(5)));
            String string3 = this.c.getContext().getString(R.string.my_attentions);
            if (this.O0.N() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new jw4(string3, "", z4, Integer.toString(6)));
            String string4 = this.c.getContext().getString(R.string.myself_only);
            if (this.O0.N() == 4) {
                z5 = true;
            }
            arrayList.add(new jw4(string4, "", z5, Integer.toString(7)));
            aw4 aw4Var2 = new aw4(this.c.getPageContext());
            aw4Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.g0 = aw4Var2;
            aw4Var2.k(arrayList, onItemClickListener);
            aw4Var2.c();
            this.g0.n();
        }
    }

    public final void M3(int i2, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048630, this, i2, sparseArray) == null) && (pbFragment = this.c) != null && pbFragment.M() != null && this.c.M().l1() != null && this.c.M().l1().o() != null && this.c.M().l1().l() != null && this.c.M().l1().l().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
            }
            kr5 kr5Var = new kr5(this.c.M().l1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.M().l1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.M().l1().o().has_forum_rule.intValue());
            kr5Var.i(this.c.M().l1().l().getId(), this.c.M().l1().l().getName());
            kr5Var.h(this.c.M().l1().l().getImage_url());
            kr5Var.j(this.c.M().l1().l().getUser_level());
            X3(sparseArray, i2, kr5Var, this.c.M().l1().X(), true);
        }
    }

    public final void f4(wv4 wv4Var, int i2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048707, this, wv4Var, i2) == null) && (pbFragment = this.c) != null && wv4Var != null) {
            if (this.D1 == null && this.u != null) {
                this.D1 = new ir5(pbFragment.getPageContext(), this.u.c());
            }
            AntiData s5 = this.c.s5();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (s5 != null && s5.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = s5.getDelThreadInfoList();
                for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                    }
                }
            }
            cu4 cu4Var = new cu4();
            cu4Var.j(sparseArray);
            this.D1.B(new String[]{this.c.getString(R.string.delete_thread_reason_1), this.c.getString(R.string.delete_thread_reason_2), this.c.getString(R.string.delete_thread_reason_3), this.c.getString(R.string.delete_thread_reason_4), this.c.getString(R.string.delete_thread_reason_5)});
            this.D1.A(cu4Var);
            if (i2 != 1 && i2 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.D1.D(str);
            this.D1.C(new b0(this, wv4Var));
        }
    }

    public void k4(gu4 gu4Var, wv4.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048731, this, gu4Var, eVar) != null) || gu4Var == null) {
            return;
        }
        int a2 = gu4Var.a();
        int h2 = gu4Var.h();
        wv4 wv4Var = this.G;
        if (wv4Var != null) {
            wv4Var.show();
        } else {
            this.G = new wv4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d022e, (ViewGroup) null);
            this.I = inflate;
            this.G.setContentView(inflate);
            this.G.setPositiveButton(R.string.obfuscated_res_0x7f0f0511, eVar);
            this.G.setNegativeButton(R.string.obfuscated_res_0x7f0f0509, new o0(this));
            this.G.setOnCalcelListener(new p0(this));
            this.G.create(this.c.getPageContext()).show();
        }
        EditText editText = (EditText) this.I.findViewById(R.id.obfuscated_res_0x7f090fca);
        this.J = editText;
        editText.setText("");
        TextView textView = (TextView) this.I.findViewById(R.id.obfuscated_res_0x7f090779);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a2), Integer.valueOf(h2)));
        this.c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.J, 150);
    }

    public boolean y4(y48 y48Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048801, this, y48Var, z2)) == null) {
            if (y48Var == null) {
                return false;
            }
            if (this.v != null) {
                if (y48Var.Q() != null && y48Var.Q().getIsNoTitle() == 0 && !y48Var.Q().isVideoThreadType() && !this.T1) {
                    if (y48Var.Q() != null) {
                        ThreadData Q = y48Var.Q();
                        Q.parserSpecTitleForFrsAndPb(true, R3(y48Var));
                        Q.setResource(3);
                        Q.setPbTitle("2");
                    }
                    if (y48Var.Q().isBJHArticleThreadType()) {
                        this.w.F(this.l);
                        this.v.h(this.l);
                        this.v.a(this.l);
                        this.w.n(this.l);
                        this.w.K(this.O0);
                        if (Q1(y48Var)) {
                            this.v.h(this.l);
                        } else {
                            this.v.i(y48Var);
                        }
                    } else {
                        this.w.K(this.O0);
                        if (Q1(y48Var)) {
                            this.v.h(this.l);
                        } else {
                            this.v.k(y48Var);
                        }
                    }
                } else if (y48Var.Q().getIsNoTitle() == 1) {
                    if (y48Var.Q() != null) {
                        this.v.h(this.l);
                        this.w.K(this.O0);
                    }
                } else {
                    this.v.h(this.l);
                    this.w.K(this.O0);
                }
            }
            m4(y48Var.Z());
            n4(y48Var);
            this.N0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void N2(int i2, y48 y48Var, boolean z2, int i3) {
        PostData Z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{Integer.valueOf(i2), y48Var, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) && i2 > 0 && y48Var != null && (Z = y48Var.Z()) != null && Z.r() != null) {
            MetaData r3 = Z.r();
            r3.setGiftNum(r3.getGiftNum() + i2);
        }
    }

    public void O2(y48 y48Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{y48Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            a4(y48Var, z2, i2, i3);
            this.w.C(i3);
        }
    }

    public void y2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048799, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            z2(i2, str, i3, z2, null);
        }
    }

    public final void Q3(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048646, this, sparseArray, i2, i3) != null) || this.c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04c9, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f037e, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.S());
        tBAlertBuilder.w(i2);
        tBAlertBuilder.m(i3);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog z2 = tBAlertBuilder.z();
        aVar.a(new x(this, z2, sparseArray));
        aVar2.a(new y(this, z2));
    }

    public final void X3(SparseArray<Object> sparseArray, int i2, kr5 kr5Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048674, this, new Object[]{sparseArray, Integer.valueOf(i2), kr5Var, userData, Boolean.valueOf(z2)}) != null) || (pbFragment = this.c) == null) {
            return;
        }
        if (this.E1 == null && this.u != null) {
            this.E1 = new lr5(pbFragment.getPageContext(), this.u.c(), kr5Var, userData);
        }
        this.E1.F(z2);
        AntiData s5 = this.c.s5();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (s5 != null && s5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = s5.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        cu4 cu4Var = new cu4();
        cu4Var.j(sparseArray2);
        this.E1.H(new String[]{this.c.getString(R.string.delete_thread_reason_1), this.c.getString(R.string.delete_thread_reason_2), this.c.getString(R.string.delete_thread_reason_3), this.c.getString(R.string.delete_thread_reason_4), this.c.getString(R.string.delete_thread_reason_5)});
        this.E1.G(cu4Var);
        if (i2 != 1 && i2 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.E1.J(str);
        this.E1.I(new c0(this, sparseArray));
    }

    public void c4(yv4.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048695, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            fw4 fw4Var = this.e0;
            if (fw4Var != null) {
                fw4Var.dismiss();
                this.e0 = null;
            }
            hw4 hw4Var = new hw4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new dw4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0469), hw4Var));
            }
            if (z3) {
                arrayList.add(new dw4(1, this.c.getPageContext().getString(R.string.report_text), hw4Var));
            } else if (!z2) {
                arrayList.add(new dw4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0b17), hw4Var));
            } else {
                arrayList.add(new dw4(1, this.c.getPageContext().getString(R.string.remove_mark), hw4Var));
            }
            hw4Var.k(arrayList);
            hw4Var.p(new f0(this, cVar));
            fw4 fw4Var2 = new fw4(this.c.getPageContext(), hw4Var);
            this.f0 = fw4Var2;
            fw4Var2.k();
        }
    }

    public void Z3(y48 y48Var, int i2, int i3, boolean z2, int i4, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int size;
        int i6;
        PbFragment pbFragment;
        y48 y48Var2;
        Parcelable e2;
        Parcelable e3;
        int size2;
        int i7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048682, this, new Object[]{y48Var, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) && y48Var != null && this.l != null) {
            this.O0 = y48Var;
            this.Q0 = i2;
            if (y48Var.Q() != null) {
                this.g1 = y48Var.Q().getCopyThreadRemindType();
                if (y48Var.Q().getAnchorLevel() != 0) {
                    this.e2 = true;
                }
                this.i0 = W1(y48Var.Q());
            }
            if (y48Var.X() != null) {
                this.f2 = y48Var.X().getUserId();
            }
            H1(y48Var);
            l0();
            this.S0 = false;
            this.N0 = z2;
            z3();
            h58 h58Var = y48Var.h;
            if (h58Var != null && h58Var.b()) {
                if (this.o == null) {
                    PbThreadPostView pbThreadPostView = new PbThreadPostView(this.c.getContext());
                    this.o = pbThreadPostView;
                    this.l.x(pbThreadPostView, 1);
                    this.o.setData(y48Var);
                    this.o.setChildOnClickLinstener(this.Q);
                }
            } else {
                PbThreadPostView pbThreadPostView2 = this.o;
                if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                    pbLandscapeListView.removeHeaderView(pbThreadPostView2);
                }
            }
            a4(y48Var, z2, i2, TbadkCoreApplication.getInst().getSkinType());
            P3(y48Var);
            this.w.Q(y48Var, this.P0);
            if (this.B1 == null) {
                this.B1 = new l88(this.c.getPageContext(), this.C1);
            }
            this.B1.a(y48Var.x());
            if (this.c.B5()) {
                if (this.K == null) {
                    kd8 kd8Var = new kd8(this.c.getPageContext());
                    this.K = kd8Var;
                    kd8Var.n();
                    this.K.f(this.g2);
                }
                this.l.setPullRefresh(this.K);
                W2();
                kd8 kd8Var2 = this.K;
                if (kd8Var2 != null) {
                    kd8Var2.H(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (y48Var.z().c() == 0 && z2) {
                this.l.setPullRefresh(null);
            } else {
                if (this.K == null) {
                    kd8 kd8Var3 = new kd8(this.c.getPageContext());
                    this.K = kd8Var3;
                    kd8Var3.n();
                    this.K.f(this.g2);
                }
                this.l.setPullRefresh(this.K);
                W2();
                kd8 kd8Var4 = this.K;
                if (kd8Var4 != null) {
                    kd8Var4.H(TbadkCoreApplication.getInst().getSkinType());
                }
                z1();
            }
            y0();
            this.F.p0(this.N0);
            this.F.m0(false);
            j78 j78Var = this.F;
            if (i2 == 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            j78Var.n0(z4);
            j78 j78Var2 = this.F;
            if (i2 == 6) {
                z5 = true;
            } else {
                z5 = false;
            }
            j78Var2.o0(z5);
            j78 j78Var3 = this.F;
            if (z3 && this.c2 && i2 != 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            j78Var3.k0(z6);
            this.F.h0(y48Var, false);
            this.F.Z();
            j78 j78Var4 = this.F;
            if (y48Var.z().b() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            j78Var4.b0(z7, y48Var.g());
            this.w.O(y48Var.Z(), y48Var.l0());
            if (y48Var.Q() != null && y48Var.Q().getPraise() != null && this.b != -1) {
                y48Var.Q().getPraise().setIsLike(this.b);
            }
            this.l.removeFooterView(this.b1);
            this.l.addFooterView(this.b1);
            if (TbadkCoreApplication.isLogin()) {
                this.l.setNextPage(this.L);
                this.f = 2;
                z1();
            } else {
                this.S0 = true;
                if (y48Var.z().b() == 1) {
                    if (this.M == null) {
                        PbFragment pbFragment2 = this.c;
                        this.M = new gd8(pbFragment2, pbFragment2);
                    }
                    this.l.setNextPage(this.M);
                } else {
                    this.l.setNextPage(this.L);
                }
                this.f = 3;
            }
            ArrayList<PostData> H = y48Var.H();
            if (y48Var.z().b() != 0 && H != null && H.size() >= y48Var.z().e()) {
                if (z3) {
                    if (this.c2) {
                        D0();
                        if (y48Var.z().b() != 0) {
                            this.L.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.L.C();
                        this.L.Q();
                    }
                } else {
                    this.L.C();
                    this.L.Q();
                }
                this.L.m();
            } else {
                if (ListUtils.getCount(H) != 0 && (ListUtils.getCount(H) != 1 || H.get(0) == null || H.get(0).F() != 1)) {
                    if (y48Var.z().b() == 0) {
                        this.L.F(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.L.F(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.L.m();
                } else {
                    a1 a1Var = this.e1;
                    if (a1Var != null && (pbReplyTitleViewHolder = a1Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.e1.c.getView().getTop() < 0) {
                            i5 = this.e1.c.getView().getHeight();
                        } else {
                            i5 = this.e1.c.getView().getBottom();
                        }
                    } else {
                        i5 = 0;
                    }
                    if (this.c.f6()) {
                        this.L.x(false);
                        if (ListUtils.isEmpty(y48Var.T())) {
                            this.L.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e78), i5);
                        }
                    } else if (ListUtils.isEmpty(y48Var.T())) {
                        this.L.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e79), i5);
                    }
                    if (this.c.I5() != null && !this.c.I5().p()) {
                        this.c.I5().x();
                    }
                }
                if (y48Var.z().b() == 0 || H == null) {
                    Q2();
                }
            }
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            if (i2 != 6) {
                                if (i2 == 8) {
                                    if (i3 == 0) {
                                        x98 x98Var = this.t;
                                        if (x98Var != null && x98Var.c() != null) {
                                            if (this.c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                                this.l.setSelectionFromTop((this.F.B() + this.l.getHeaderViewsCount()) - 1, this.t.d() - zi.u(this.c.getPageContext().getPageActivity()));
                                            } else {
                                                this.l.setSelectionFromTop((this.F.B() + this.l.getHeaderViewsCount()) - 1, this.t.d());
                                            }
                                        } else {
                                            this.l.setSelection(this.F.B() + this.l.getHeaderViewsCount());
                                        }
                                    } else if (ListUtils.isEmpty(y48Var.T())) {
                                        if (this.l.getData() == null && y48Var.H() == null) {
                                            size2 = 0;
                                        } else {
                                            size2 = (this.l.getData().size() - y48Var.H().size()) + this.l.getHeaderViewsCount();
                                        }
                                        PbLandscapeListView pbLandscapeListView2 = this.l;
                                        if (i3 > 0) {
                                            i7 = size2 + i3;
                                        } else {
                                            i7 = 0;
                                        }
                                        pbLandscapeListView2.setSelection(i7);
                                    } else {
                                        this.l.setSelection(y48Var.H().size() + this.l.getHeaderViewsCount());
                                    }
                                    this.L.g();
                                    this.L.F(this.c.getString(R.string.obfuscated_res_0x7f0f0e72));
                                    this.L.A();
                                }
                            } else if (i4 == 1 && (e3 = r88.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                                this.l.onRestoreInstanceState(e3);
                            } else {
                                this.l.setSelection(0);
                            }
                        } else {
                            this.l.setSelection(0);
                        }
                    } else {
                        this.c2 = false;
                    }
                } else if (i4 == 1 && (e2 = r88.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
                    this.l.post(new m0(this, e2, H, y48Var));
                }
            } else {
                if (this.l.getData() == null && y48Var.H() == null) {
                    size = 0;
                } else {
                    size = (this.l.getData().size() - y48Var.H().size()) + this.l.getHeaderViewsCount();
                }
                PbLandscapeListView pbLandscapeListView3 = this.l;
                if (i3 > 1) {
                    i6 = (size + i3) - 2;
                } else {
                    i6 = 0;
                }
                pbLandscapeListView3.setSelection(i6);
            }
            if (this.g1 == n2 && U1()) {
                s0();
            }
            if (this.m1) {
                K2();
                this.m1 = false;
                if (i4 == 0) {
                    o3(true);
                }
            }
            if (y48Var.d == 1 || y48Var.e == 1) {
                if (this.s1 == null) {
                    this.s1 = new PbTopTipView(this.c.getContext());
                }
                if (y48Var.e == 1 && "game_guide".equals(this.c.N5())) {
                    this.s1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0e84));
                    this.s1.l(this.d, this.R0);
                } else if (y48Var.d == 1 && "game_news".equals(this.c.N5())) {
                    this.s1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0e83));
                    this.s1.l(this.d, this.R0);
                }
            }
            this.l.removeFooterView(this.N1.a());
            if (!ListUtils.isEmpty(y48Var.K()) && y48Var.z().b() == 0) {
                this.l.removeFooterView(this.b1);
                this.N1.d(Math.max(this.u0.getMeasuredHeight(), this.L0 / 2));
                this.l.addFooterView(this.N1.a());
                this.N1.f(y48Var);
            }
            M2(y48Var);
            if (y48Var.j0() && this.c.M().a2() && this.c.J5() != null) {
                this.c.J5().d();
            }
            if (y48Var.g() != 3) {
                L1(y48Var);
            }
            this.y0.setText(TbSingleton.getInstance().getAdVertiComment(y48Var.r0(), y48Var.s0(), l1()));
            if (this.p != null && (y48Var2 = this.O0) != null && y48Var2.l() != null) {
                this.p.m(this.O0.l().getImage_url());
                this.p.n(this.O0.l().getName());
                PbFragment pbFragment3 = this.c;
                if (pbFragment3 != null && pbFragment3.M() != null) {
                    this.p.o(this.c.M().b);
                }
            }
            if (this.r != null) {
                y48 y48Var3 = this.O0;
                if (y48Var3 != null && y48Var3.l() != null && (pbFragment = this.c) != null && pbFragment.M() != null) {
                    this.r.q(this.c.M().b);
                }
                y48 y48Var4 = this.O0;
                if (y48Var4 != null && y48Var4.Q() != null && !ListUtils.isEmpty(this.O0.Q().getThreadRecommendInfoDataList()) && this.O0.Q().getThreadRecommendInfoDataList().get(0) != null && this.O0.Q().getThreadRecommendInfoDataList().get(0).businessType != 1) {
                    this.r.p(this.O0.Q().getThreadRecommendInfoDataList().get(0));
                } else {
                    this.r.p(null);
                }
            }
            if (G3()) {
                this.A.e(this.O0.Q());
            } else {
                this.A.d(this.l);
            }
        }
    }

    public SparseArray<Object> a1(y48 y48Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData Z;
        boolean z3;
        kt4 kt4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048684, this, new Object[]{y48Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (y48Var == null || (Z = y48Var.Z()) == null) {
                return null;
            }
            String userId = Z.r().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
            } else {
                z3 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, Z.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(y48Var.Y()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (Z.r() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, Z.r().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, Z.r().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, Z.r().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, Z.O());
                }
                sparseArray.put(R.id.tag_del_post_id, Z.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(y48Var.Y()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<fv4> p3 = y48Var.p();
                if (ListUtils.getCount(p3) > 0) {
                    sb = new StringBuilder();
                    for (fv4 fv4Var : p3) {
                        if (fv4Var != null && !StringUtils.isNull(fv4Var.d()) && (kt4Var = fv4Var.f) != null && kt4Var.a && !kt4Var.c && ((i3 = kt4Var.b) == 1 || i3 == 2)) {
                            sb.append(yi.cutString(fv4Var.d(), 12));
                            sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f068b));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f04c1), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void a4(y48 y48Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048687, this, new Object[]{y48Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && y48Var != null && y48Var.Q() != null) {
            if (this.c.u0()) {
                if (y48Var.h() != null) {
                    this.j0 = y48Var.h().d();
                    this.k0 = y48Var.h().b();
                }
                if (this.j0 == null && this.c.M() != null && this.c.M().K0() != null) {
                    this.j0 = this.c.M().K0();
                }
            }
            PostData Z = y48Var.Z();
            x3(Z, y48Var);
            int i4 = 8;
            this.w.L(8);
            int i5 = 1;
            if (y48Var.y0()) {
                this.o1 = true;
                this.h.C(true);
                this.h.a.hideBottomLine();
                if (this.t == null) {
                    this.t = new x98(this.c);
                }
                this.t.v(y48Var, Z, this.l, this.w, this.V0, this.h, this.j0, this.H1);
                this.t.s(this.d2);
                W2();
            } else {
                this.o1 = false;
                this.h.C(false);
                x98 x98Var = this.t;
                if (x98Var != null) {
                    x98Var.p(this.l);
                }
            }
            if (this.c.I5() != null) {
                this.c.I5().w(this.o1);
            }
            if (Z == null) {
                return;
            }
            this.P0 = Z;
            this.w.L(0);
            SparseArray<Object> w2 = this.w.w();
            w2.put(R.id.tag_clip_board, Z);
            w2.put(R.id.tag_is_subpb, Boolean.FALSE);
            this.x.e(y48Var, this.l);
            this.z.e(y48Var, this.J1, new j0(this));
            this.v.j(y48Var);
            this.u.h(y48Var, this.N0);
            this.u.g(y48Var);
            this.w.M(this.R0, this.O0, Z, this.d2);
            if (this.a1 != null) {
                if (y48Var.l0()) {
                    this.a1.getView().setVisibility(8);
                } else {
                    this.a1.getView().setVisibility(0);
                    l58 l58Var = new l58(l58.i);
                    if (y48Var.Q() != null) {
                        y48Var.Q().getReply_num();
                    }
                    l58Var.c = y48Var.g;
                    y48Var.c();
                    l58Var.d = this.c.f6();
                    l58Var.g = y48Var.f;
                    l58Var.h = y48Var.Q().isQuestionThread();
                    this.a1.h(l58Var);
                }
            }
            m4(Z);
            n4(y48Var);
            bh.a().post(new k0(this));
            this.y.f(this.l);
            if (Z.S) {
                this.y.g(Z.O());
                PbLandscapeListView pbLandscapeListView = this.l;
                this.y.c(this.l, (pbLandscapeListView == null || pbLandscapeListView.getHeaderViewsCount() <= 1) ? 0 : 0);
            }
            j78 j78Var = this.F;
            if (j78Var != null && j78Var.z() != null) {
                this.F.z().G(Z.S);
            }
            j78 j78Var2 = this.F;
            if (j78Var2 != null) {
                j78Var2.s0(Z.S);
            }
            MaskView maskView = this.O1;
            if (Z.S) {
                i4 = 0;
            }
            maskView.setVisibility(i4);
        }
    }

    public void b4(yv4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048691, this, cVar, z2) == null) {
            fw4 fw4Var = this.f0;
            if (fw4Var != null) {
                fw4Var.dismiss();
                this.f0 = null;
            }
            hw4 hw4Var = new hw4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            y48 y48Var = this.O0;
            if (y48Var != null && y48Var.Q() != null && !this.O0.Q().isBjh()) {
                arrayList.add(new dw4(0, this.c.getPageContext().getString(R.string.save_to_emotion), hw4Var));
            }
            if (!z2) {
                arrayList.add(new dw4(1, this.c.getPageContext().getString(R.string.save_to_local), hw4Var));
            }
            hw4Var.k(arrayList);
            hw4Var.p(new h0(this, cVar));
            fw4 fw4Var2 = new fw4(this.c.getPageContext(), hw4Var);
            this.f0 = fw4Var2;
            fw4Var2.k();
        }
    }

    public void w2(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048789, this, absListView, i2) == null) {
            x98 x98Var = this.t;
            if (x98Var != null) {
                x98Var.o(absListView, i2);
            }
            if (!this.l2 && i2 == 0) {
                this.j2 = o1();
                this.e1.c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.e1));
                I2(this.e1.c, true);
                u0();
                this.F.g0(true);
            }
            this.F.f0();
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.Q1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.q();
                }
                o0();
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.Q1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.p();
                }
            } else if (i2 == 2 && (rightFloatLayerView = this.Q1) != null) {
                rightFloatLayerView.r();
            }
        }
    }

    public final boolean h0(AbsListView absListView, int i2) {
        InterceptResult invokeLI;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048712, this, absListView, i2)) == null) {
            boolean z3 = false;
            if (absListView == null) {
                return false;
            }
            if (i2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && absListView.getChildCount() > 0) {
                if (absListView.getChildAt(0).getTop() < absListView.getListPaddingTop()) {
                    z3 = true;
                }
                return z3;
            }
            return z2;
        }
        return invokeLI.booleanValue;
    }

    public final CustomBlueCheckRadioButton r0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048762, this, str, str2)) == null) {
            Activity pageActivity = this.c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, zi.g(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.a0);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public void y3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048800, this, z2, postWriteCallBackData) == null) {
            this.c.hideProgressBar();
            if (z2) {
                v0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                w0();
            } else {
                v0();
            }
        }
    }

    public void j2(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048724, this, i2) != null) || this.R0 == i2) {
            return;
        }
        this.R0 = i2;
        o4(this.O0, this.N0);
        O2(this.O0, this.N0, this.Q0, i2);
        dr4 layoutMode = this.c.getBaseFragmentActivity().getLayoutMode();
        boolean z2 = true;
        if (i2 != 1) {
            z2 = false;
        }
        layoutMode.l(z2);
        this.c.getBaseFragmentActivity().getLayoutMode().k(this.d);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.p0, R.color.CAM_X0203);
        x98 x98Var = this.t;
        if (x98Var != null) {
            x98Var.h(i2);
        }
        t98 t98Var = this.x;
        if (t98Var != null) {
            t98Var.c(i2);
        }
        s98 s98Var = this.u;
        if (s98Var != null) {
            s98Var.e(i2);
        }
        u98 u98Var = this.v;
        if (u98Var != null) {
            u98Var.g(i2);
        }
        w98 w98Var = this.w;
        if (w98Var != null) {
            w98Var.C(i2);
        }
        v98 v98Var = this.y;
        if (v98Var != null) {
            v98Var.e();
        }
        r98 r98Var = this.z;
        if (r98Var != null) {
            r98Var.c();
        }
        MaskView maskView = this.O1;
        if (maskView != null) {
            maskView.f();
        }
        y88 y88Var = this.r;
        if (y88Var != null) {
            y88Var.n();
        }
        PbContentCollectionController pbContentCollectionController = this.A;
        if (pbContentCollectionController != null) {
            pbContentCollectionController.c();
        }
        PbListView pbListView = this.L;
        if (pbListView != null) {
            pbListView.e(i2);
        }
        if (this.N != null) {
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.N);
            SkinManager.setBackgroundResource(this.N, R.drawable.pb_foot_more_trans_selector);
        }
        if (this.O != null) {
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.O);
            SkinManager.setBackgroundResource(this.O, R.drawable.pb_foot_more_trans_selector);
        }
        wv4 wv4Var = this.G;
        if (wv4Var != null) {
            wv4Var.autoChangeSkinType(this.c.getPageContext());
        }
        t4(this.h0);
        this.F.Z();
        kd8 kd8Var = this.K;
        if (kd8Var != null) {
            kd8Var.H(i2);
        }
        EditorTools editorTools = this.n0;
        if (editorTools != null) {
            editorTools.y(i2);
        }
        gd8 gd8Var = this.M;
        if (gd8Var != null) {
            gd8Var.g(i2);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        z4();
        UtilHelper.setStatusBarBackground(this.e, i2);
        UtilHelper.setStatusBarBackground(this.Z0, i2);
        if (this.B != null) {
            xg5.a(this.c.getPageContext(), this.B);
        }
        v78 v78Var = this.k1;
        if (v78Var != null) {
            v78Var.l(i2);
        }
        fb8 fb8Var = this.h;
        if (fb8Var != null) {
            x98 x98Var2 = this.t;
            if (x98Var2 != null) {
                x98Var2.i(i2);
            } else {
                fb8Var.w(i2);
            }
        }
        HeadImageView headImageView = this.w0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.v0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(zi.g(this.c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        y48 y48Var = this.O0;
        if (y48Var != null && y48Var.r()) {
            WebPManager.setPureDrawable(this.C0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.C0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.A0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.x0, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        x4(this.O0);
        if (this.F0.getVisibility() == 0) {
            this.F0.setBackgroundDrawable(SkinManager.createShapeDrawable(zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i2));
        }
        SkinManager.setBackgroundColor(this.u0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.t0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.u1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.y0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.J0, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.I0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.I0, zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.H0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.H0, zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.B0;
        if (agreeView != null) {
            agreeView.w();
            this.B0.P(i2);
            AgreeData data = this.B0.getData();
            if (data != null) {
                L2(data, data.agreeNum);
            }
        }
        y68 y68Var = this.x1;
        if (y68Var != null) {
            y68Var.m(i2);
        }
        PbEmotionBar pbEmotionBar = this.f1;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i2);
        }
        jd8 jd8Var = this.G0;
        if (jd8Var != null) {
            jd8Var.j();
        }
        id8 id8Var = this.N1;
        if (id8Var != null) {
            id8Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.Q1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
        SkinManager.setBackgroundColor(this.Y0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.Y0.findViewById(R.id.tv_title), (int) R.color.CAM_X0105);
    }

    public void v2(AbsListView absListView, int i2, int i3, int i4) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        w98 w98Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048784, this, absListView, i2, i3, i4) == null) {
            y78 y78Var = this.q;
            if (y78Var != null) {
                y78Var.c(i2, i3);
            }
            x88 x88Var = this.s;
            if (x88Var != null) {
                x88Var.c(i2, i3);
            }
            x98 x98Var = this.t;
            if (x98Var != null) {
                x98Var.n(absListView, i2, i3, i4);
            }
            fb8 fb8Var = this.h;
            if (fb8Var != null && (w98Var = this.w) != null) {
                fb8Var.y(w98Var.u());
            }
            H2();
            a1 a1Var = this.e1;
            a1Var.a = i2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                a1Var.b = pbLandscapeListView.getHeaderViewsCount();
            }
            this.e1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.e1));
            N3(h0(absListView, i2));
            int i5 = 0;
            I2(this.e1.c, false);
            u0();
            if (this.L.p() && !this.L.C) {
                a1 a1Var2 = this.e1;
                if (a1Var2 != null && (pbReplyTitleViewHolder = a1Var2.c) != null && pbReplyTitleViewHolder.getView() != null) {
                    if (this.e1.c.getView().getTop() < 0) {
                        bottom = this.e1.c.getView().getHeight();
                    } else {
                        bottom = this.e1.c.getView().getBottom();
                    }
                    i5 = bottom;
                }
                this.L.f(i5);
                this.L.C = true;
            }
        }
    }

    public void x2(ArrayList<st4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048794, this, arrayList) == null) {
            if (this.Y == null) {
                this.Y = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.Y);
            if (this.X == null) {
                Dialog dialog = new Dialog(this.c.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003a9);
                this.X = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.X.setCancelable(true);
                this.m0 = (ScrollView) this.Y.findViewById(R.id.good_scroll);
                this.X.setContentView(this.Y);
                WindowManager.LayoutParams attributes = this.X.getWindow().getAttributes();
                attributes.width = zi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702db);
                this.X.getWindow().setAttributes(attributes);
                this.a0 = new d0(this);
                this.Z = (LinearLayout) this.Y.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.Y.findViewById(R.id.dialog_button_cancel);
                this.c0 = textView;
                textView.setOnClickListener(new e0(this));
                TextView textView2 = (TextView) this.Y.findViewById(R.id.dialog_button_ok);
                this.b0 = textView2;
                textView2.setOnClickListener(this.Q);
            }
            this.Z.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton r02 = r0("0", this.c.getPageContext().getString(R.string.thread_good_class));
            this.n.add(r02);
            r02.setChecked(true);
            this.Z.addView(r02);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    st4 st4Var = arrayList.get(i2);
                    if (st4Var != null && !TextUtils.isEmpty(st4Var.b()) && st4Var.a() > 0) {
                        CustomBlueCheckRadioButton r03 = r0(String.valueOf(st4Var.a()), st4Var.b());
                        this.n.add(r03);
                        View view2 = new View(this.c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, zi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.Z.addView(view2);
                        this.Z.addView(r03);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.m0.getLayoutParams();
                int size = arrayList.size();
                if (size != 0 && size != 1) {
                    if (size != 2) {
                        layoutParams2.height = zi.d(this.c.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = zi.d(this.c.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = zi.d(this.c.getPageContext().getPageActivity(), 120.0f);
                }
                this.m0.setLayoutParams(layoutParams2);
                this.m0.removeAllViews();
                LinearLayout linearLayout = this.Z;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.m0.addView(this.Z);
                }
            }
            dh.j(this.X, this.c.getPageContext());
        }
    }

    public void z2(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048804, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            A2(i2, str, i3, z2, str2, false);
        }
    }
}
