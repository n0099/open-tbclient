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
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateUtils;
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
import androidx.annotation.Nullable;
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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
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
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.core.view.FriendBotView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.breathetip.BreatheTipWidget;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.data.AdverSegmentData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.RightFloatLayerLottieView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeRelativeLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.youngster.utils.YoungsterVerifyUtils;
import com.baidu.tieba.aea;
import com.baidu.tieba.bl9;
import com.baidu.tieba.dj9;
import com.baidu.tieba.fz5;
import com.baidu.tieba.hz4;
import com.baidu.tieba.iz4;
import com.baidu.tieba.iz5;
import com.baidu.tieba.jd9;
import com.baidu.tieba.l45;
import com.baidu.tieba.ld9;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.pb.ejection.EjectionAnimationView;
import com.baidu.tieba.pb.mixplayer.TbLiveMixPlayerConfig;
import com.baidu.tieba.pb.mixplayer.TbMixPlayerView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.pb.main.controller.PbContentCollectionController;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.PbFallingView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.rg9;
import com.baidu.tieba.rz4;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.vi9;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.WaterRippleView;
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
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import tbclient.AbilityConf;
import tbclient.CallRobotEntrance;
import tbclient.ItemInfo;
import tbclient.RobotEntrance;
import tbclient.RobotSkillInfo;
import tbclient.StyleConf;
import tbclient.StyleContentInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class dk9 {
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
    public static aea.f v2;
    public transient /* synthetic */ FieldHolder $fh;
    public bl9 A;
    public ImageView A0;
    public boolean A1;
    public PbContentCollectionController B;
    public TextView B0;
    public boolean B1;
    public vi9 C;
    public WaterRippleView C0;
    public nj9 C1;
    public ti9 D;
    public ImageView D0;
    public NavigationBarCoverTip D1;
    public LinearLayout E;
    public AgreeView E0;
    public fz5 E1;
    public TextView F;
    public ImageView F0;
    public iz5 F1;
    public TextView G;
    public ImageView G0;
    public String G1;
    public ObservedChangeRelativeLayout H;
    public HeadImageView H0;
    public PermissionJudgePolicy H1;
    public li9 I;
    public View I0;
    public int I1;
    public hz4 J;
    public FriendBotView J0;
    public int J1;
    public iz4 K;
    public oo9 K0;
    public boolean K1;
    public View L;
    public TextView L0;
    public boolean L1;
    public EditText M;
    public TextView M0;
    public no9 M1;
    public po9 N;
    public boolean N0;
    public MaskView N1;
    public PbListView O;
    public int O0;
    public final PbFallingView O1;
    public ko9 P;
    public BlueCircleProgressDialog P0;
    public RightFloatLayerView P1;
    public View Q;
    public boolean Q0;
    public final FrameLayout Q1;
    public View R;
    public ye9 R0;
    public LinearLayout R1;
    public View S;
    public pea S0;
    public im9 S1;

    /* renamed from: T  reason: collision with root package name */
    public View.OnClickListener f1093T;
    public int T0;
    public final Object T1;
    public SortSwitchButton.f U;
    public int U0;
    public Runnable U1;
    public TbRichTextView.z V;
    public boolean V0;
    public CallRobotEntrance V1;
    public NoNetworkView.b W;
    public boolean W0;
    public TbMixPlayerView W1;
    public pz4 X;
    public ViewStub X0;
    public CustomMessageListener X1;
    public View.OnClickListener Y;
    public PbInterviewStatusView Y0;
    public View.OnClickListener Y1;
    public hz4 Z;
    public TextView Z0;
    public final FriendBotView.f Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public Dialog a0;
    public View a1;
    public CustomMessageListener a2;
    public CardForumHeadLayout b;
    public Dialog b0;
    public View b1;
    public Handler b2;
    public int c;
    public View c0;
    public View c1;
    public Runnable c2;
    public boolean d;
    public LinearLayout d0;
    public PbReplyTitleViewHolder d1;
    public CustomMessageListener d2;
    public int e;
    public CompoundButton.OnCheckedChangeListener e0;
    public View e1;
    public PbFragment.i3 e2;
    public PbFragment f;
    public TextView f0;
    public int f1;
    public boolean f2;
    public RelativeLayout g;
    public TextView g0;
    public boolean g1;
    public View.OnClickListener g2;
    public View h;
    public String h0;
    public g1 h1;
    public String h2;
    public int i;
    public pz4 i0;
    public int i1;
    public l45.g i2;
    public final Handler j;
    public pz4 j0;
    public int j1;
    public View.OnClickListener j2;
    public final xm9 k;
    public kz4 k0;
    public Runnable k1;
    public final List<TbImageView> k2;
    public wm9 l;
    public boolean l0;
    public PbFakeFloorModel l1;
    public boolean l2;
    public ViewStub m;
    public boolean m0;
    public aj9 m1;
    public ViewStub n;
    public String n0;
    public boolean n1;
    public PbLandscapeListView o;
    public String o0;
    public int o1;
    public NoNetworkView p;
    public tg9 p0;
    public boolean p1;
    public List<CustomBlueCheckRadioButton> q;
    public ScrollView q0;
    public boolean q1;
    public PbThreadPostView r;
    public EditorTools r0;
    public boolean r1;
    public zj9 s;
    public boolean s0;
    public int s1;
    public dj9 t;
    public View t0;
    public PbTopTipView t1;
    public dj9 u;
    public View u0;
    public PopupWindow u1;
    public cl9 v;
    public EjectionAnimationView v0;
    public TextView v1;
    public el9 w;
    public Button w0;
    public List<String> w1;
    public gl9 x;
    public View x0;
    public kl9 x1;
    public dl9 y;
    public View y0;
    public yh9 y1;
    public fl9 z;
    public LinearLayout z0;
    public PbLandscapeListView.c z1;

    public int A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.id.obfuscated_res_0x7f091f39 : invokeV.intValue;
    }

    public boolean I2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i2)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    public int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? R.id.obfuscated_res_0x7f091ae1 : invokeV.intValue;
    }

    public boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void z3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048821, this, z2) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        /* loaded from: classes5.dex */
        public class a implements zc5 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.zc5
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.a.v0.setVisibility(0);
                    this.a.a.v0.setBitmaps(list);
                    Rect rect = new Rect();
                    this.a.a.E0.getImgAgree().getGlobalVisibleRect(rect);
                    this.a.a.v0.setAnchorPosition((rect.right + rect.left) / 2, (rect.bottom + rect.top) / 2);
                    this.a.a.v0.k();
                }
            }
        }

        public b(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.b4();
            bd5.g().c(new a(this));
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.m3();
            this.a.v0.l();
        }
    }

    /* loaded from: classes5.dex */
    public class i implements dj9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ dk9 b;

        /* loaded from: classes5.dex */
        public class a implements ee9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ i b;

            public a(i iVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = iVar;
                this.a = str;
            }

            @Override // com.baidu.tieba.ee9
            public void onDismiss() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.b.b.J0 != null) {
                        this.b.b.W0 = false;
                        this.b.b.J0.x();
                    }
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("BotGuideManager", "底bar点击引导展示完毕隐藏,文案：" + this.a);
                }
            }

            @Override // com.baidu.tieba.ee9
            public void onShow() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    SharedPrefHelper.getInstance().putLong("pb_friend_bot_bottom_click_last_time", System.currentTimeMillis());
                    if (this.b.b.J0 != null) {
                        this.b.b.W0 = true;
                        this.b.b.J0.setDynamicLooping(true);
                        this.b.b.J0.r();
                    }
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("BotGuideManager", "底bar点击引导展示了,文案：" + this.a);
                }
            }
        }

        public i(dk9 dk9Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dk9Var;
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.dj9.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (YunDialogManager.isShowingDialog()) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("BotGuideManager", "底bar点击引导未展示,云弹窗正在展示：" + YunDialogManager.getShowingDialog());
                } else if (he9.c()) {
                    DefaultLog.getInstance().e("BotGuideManager", "底bar点击引导未展示,BotGuideManager在展示其他");
                } else {
                    long j = SharedPrefHelper.getInstance().getLong("pb_friend_bot_bottom_click_last_time", 0L);
                    if (!DateUtils.isToday(j) && !this.b.a3()) {
                        if (this.b.R0 == null) {
                            DefaultLog.getInstance().e("BotGuideManager", "底bar点击引导未展示,pbData为null");
                            return;
                        }
                        RobotEntrance K = this.b.R0.K();
                        if (K == null) {
                            DefaultLog.getInstance().e("BotGuideManager", "底bar点击引导未展示,pbData下robotEntrance为null");
                            return;
                        }
                        String str = K.bottom_bar_click_guide;
                        if (!TextUtils.isEmpty(str) && this.b.f != null) {
                            BaseFragmentActivity baseFragmentActivity = this.b.f.getBaseFragmentActivity();
                            if (baseFragmentActivity != null && this.b.J0 != null) {
                                he9.e(str, this.b.J0, this.a.l0(), new a(this, str));
                                return;
                            }
                            TbLog defaultLog2 = DefaultLog.getInstance();
                            defaultLog2.e("BotGuideManager", "底bar点击引导未展示,activity=" + baseFragmentActivity + ",mBottomBot=" + this.b.J0);
                            return;
                        }
                        TbLog defaultLog3 = DefaultLog.getInstance();
                        defaultLog3.e("BotGuideManager", "底bar点击引导未展示,guideText=" + str + ",mPbFragment=" + this.b.f);
                        return;
                    }
                    TbLog defaultLog4 = DefaultLog.getInstance();
                    defaultLog4.e("BotGuideManager", "底bar点击引导未展示,当天已经展示过了：" + DateUtils.isToday(j) + "，话题在展示：" + this.b.a3());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements dj9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        /* loaded from: classes5.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.s != null && this.a.a.f.l0() != null) {
                    xz4.g(Collections.singletonList(new ak9(this.a.a.f.l0(), this.a.a.s)));
                }
            }
        }

        public j(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // com.baidu.tieba.dj9.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.W0 && !this.a.f.N7() && this.a.o != null) {
                this.a.o.post(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbReplyTitleViewHolder b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ dk9 g;

        /* loaded from: classes5.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g.e1 != null && this.a.g.e1.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = this.a.g.e1.getLayoutParams();
                    layoutParams.height = this.a.g.j1;
                    this.a.g.e1.setLayoutParams(layoutParams);
                }
            }
        }

        public l(dk9 dk9Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = dk9Var;
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
                if (i2 >= 0 && i2 <= this.g.g.getMeasuredHeight()) {
                    int z1 = this.g.z1(this.b);
                    int i3 = this.a;
                    int i4 = z1 - i3;
                    if (this.c && i4 != 0 && i3 <= (i = this.d)) {
                        i4 = z1 - i;
                    }
                    if (this.g.e1 == null || (layoutParams = this.g.e1.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 != 0 && i4 <= this.g.g.getMeasuredHeight() && z1 < this.g.g.getMeasuredHeight()) {
                        if (layoutParams != null) {
                            int i5 = layoutParams.height;
                            if (i5 + i4 > 0 && i5 + i4 <= this.g.g.getMeasuredHeight()) {
                                layoutParams.height += i4;
                                if (this.g.o != null) {
                                    this.g.o.setSelectionFromTop(this.e, this.f);
                                }
                            }
                        }
                        layoutParams.height = this.g.j1;
                    } else {
                        layoutParams.height = this.g.j1;
                    }
                    this.g.e1.setLayoutParams(layoutParams);
                    SafeHandler.getInst().post(new a(this));
                }
                if (this.g.o != null) {
                    this.g.o.setOnLayoutListener(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements vi9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ n b;

            public a(n nVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = nVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.D != null && this.b.a.f.l0() != null) {
                    this.b.a.D.q(this.a);
                    xz4.g(Collections.singletonList(new wi9(this.b.a.f.l0(), this.b.a.D)));
                }
            }
        }

        public n(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // com.baidu.tieba.vi9.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && !this.a.f.N7() && !this.a.d && this.a.o != null) {
                this.a.o.post(new a(this, i));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ w0 a;

            public a(w0 w0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {w0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = w0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.f.HidenSoftKeyPad((InputMethodManager) this.a.a.f.getBaseFragmentActivity().getSystemService("input_method"), this.a.a.g);
            }
        }

        public w0(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.k1 == null) {
                    this.a.k1 = new a(this);
                }
                SafeHandler.getInst().postDelayed(this.a.k1, 150L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements xf9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        @Override // com.baidu.tieba.xf9
        public /* synthetic */ void onStart() {
            wf9.a(this);
        }

        public a(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // com.baidu.tieba.xf9
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.v0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public a0(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.a.f.N0 != null && this.a.f.N0.e() != null) {
                if (!this.a.f.N0.e().e()) {
                    this.a.f.N0.a(false);
                }
                this.a.f.N0.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && this.a.r0 != null && this.a.r0.getVisibility() == 0 && charSequence != null && charSequence.length() >= (i4 = i3 + i)) {
                String substring = charSequence.toString().substring(i, i4);
                if (TextUtils.isEmpty(substring)) {
                    return;
                }
                if (this.a.x1 == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(2, this.a.r0.getId());
                    dk9 dk9Var = this.a;
                    dk9Var.x1 = new kl9(dk9Var.f.getPageContext(), this.a.g, layoutParams);
                    if (!ListUtils.isEmpty(this.a.w1)) {
                        this.a.x1.q(this.a.w1);
                    }
                    this.a.x1.r(this.a.r0);
                }
                this.a.x1.p(substring);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a1 implements PbFallingView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public a1(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.p
        public void onClick() {
            String y1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null && this.a.f.e0() != null && this.a.f.e0().c2()) {
                    y1 = this.a.f.getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    y1 = this.a.y1();
                }
                if (!StringUtils.isNull(y1) && this.a.R0 != null) {
                    y1 = TbSingleton.getInstance().getAdVertiComment(this.a.R0.q0(), this.a.R0.r0(), y1);
                }
                if (this.a.f != null && this.a.f.B6() != null) {
                    this.a.f.B6().e0(y1);
                }
                if (this.a.B0 != null) {
                    this.a.B0.setText(y1);
                }
                this.a.k4(false);
                this.a.E4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements rz4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ dk9 b;

        public b0(dk9 dk9Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dk9Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) {
                this.b.X.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.T2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.e2 != null) {
                            this.b.e2.callback(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.f.L6(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        this.b.a5(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y65 a;
        public final /* synthetic */ dk9 b;

        public b1(dk9 dk9Var, y65 y65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, y65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dk9Var;
            this.a = y65Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.P1.setHomePbFloatLastCloseTime();
                this.b.Q1();
                this.b.P1.t(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public c(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.E0 != null && this.a.E0.getData() != null) {
                dk9 dk9Var = this.a;
                dk9Var.g3(dk9Var.E0.getData(), this.a.E0.getData().agreeNum);
                if (!this.a.E0.J()) {
                    dk9 dk9Var2 = this.a;
                    dk9Var2.Z2(dk9Var2.E0);
                }
                if (this.a.R0 != null && this.a.R0.O() != null && this.a.R0.O().isExcellentThread() && BreatheTipWidget.f()) {
                    ra5.a("c15279", this.a.R0.Q(), this.a.R0.l(), "1");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c1 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ dk9 b;

        public c1(dk9 dk9Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dk9Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.b.K1 && this.a != null && this.b.f.e0() != null && this.b.f.e0().g2()) {
                    this.b.K1 = true;
                    this.a.M5(false);
                }
                if (this.b.L1) {
                    return;
                }
                this.b.L1 = true;
                if (this.b.o2() && this.b.B != null) {
                    this.b.B.h();
                    this.b.B.g(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public d(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.I0.getVisibility() == 0) {
                    if (this.a.f != null && this.a.f.c2()) {
                        return;
                    }
                    SharedPrefHelper.getInstance().putBoolean("pb_share_red_dot_shown", true);
                    this.a.I0.setVisibility(8);
                }
                this.a.f1093T.onClick(view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ dk9 c;

        public d0(dk9 dk9Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dk9Var;
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
                    BdUtilHelper.showToast(this.c.f.l0(), (int) R.string.obfuscated_res_0x7f0f0e4f);
                } else {
                    this.c.f.Z5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements rg9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public d1(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // com.baidu.tieba.rg9.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f.P6();
            }
        }

        @Override // com.baidu.tieba.rg9.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.o != null) {
                this.a.o.setSelection(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public e(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
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
                    this.a.f.O5(sparseArray);
                    return;
                }
                this.a.Y2(view2);
            } else if (z2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.a.f.O5(sparseArray);
            } else if (z3) {
                this.a.T2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public e0(dk9 dk9Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, alertDialog};
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

    /* loaded from: classes5.dex */
    public class e1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyPrivacyCheckController a;
        public final /* synthetic */ hf5 b;
        public final /* synthetic */ dk9 c;

        public e1(dk9 dk9Var, ReplyPrivacyCheckController replyPrivacyCheckController, hf5 hf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, replyPrivacyCheckController, hf5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dk9Var;
            this.a = replyPrivacyCheckController;
            this.b = hf5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null && this.c.f != null && this.c.f.n6() != null && !this.a.checkPrivacyBeforeInvokeEditor(this.c.f.n6().replyPrivateFlag)) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.f.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                }
                this.c.V4();
                this.b.p0();
                this.c.K0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public f(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ dk9 c;

        public f0(dk9 dk9Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dk9Var;
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
                    BdUtilHelper.showToast(this.c.f.l0(), (int) R.string.obfuscated_res_0x7f0f0e4f);
                } else {
                    this.c.f.Z5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public f1(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.N2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public g(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(pea peaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, peaVar) == null) {
                this.a.l1.e0(peaVar);
                this.a.I.f0();
                this.a.m1.g();
                this.a.r0.t();
                this.a.k4(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements aea.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.aea.f
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

    /* loaded from: classes5.dex */
    public static class g1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PbReplyTitleViewHolder a;
        public BdUniqueId b;

        public g1() {
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

    /* loaded from: classes5.dex */
    public class h implements PbFallingView.r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public h(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.E4();
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.O1.setTag(Boolean.FALSE);
                if (this.a.P1 == null) {
                    return;
                }
                this.a.P1.setAutoCompleteShown(false);
                if (this.a.P1.getVisibility() == 0) {
                    this.a.P1.setTag(this.a.O1);
                    this.a.P1.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public h0(dk9 dk9Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, alertDialog};
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

    /* loaded from: classes5.dex */
    public class i0 implements fz5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz4 a;
        public final /* synthetic */ dk9 b;

        public i0(dk9 dk9Var, hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, hz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dk9Var;
            this.a = hz4Var;
        }

        @Override // com.baidu.tieba.fz5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.f.a6(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements iz5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ dk9 b;

        public j0(dk9 dk9Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dk9Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.iz5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.f.Z5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(dk9 dk9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, Integer.valueOf(i)};
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
            this.a = dk9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921757) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.a.h1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public k0(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.h0 = (String) compoundButton.getTag();
                if (this.a.q != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.q) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.h0 != null && !str.equals(this.a.h0)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public l0(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.b0 instanceof Dialog)) {
                hb.b(this.a.b0, this.a.f.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements ld9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public m(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // com.baidu.tieba.ld9.a
        public void a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (this.a.f != null && this.a.f.e0() != null) {
                    this.a.f.e0().o3();
                }
                if (this.a.V1 != null) {
                    this.a.J0.k(this.a.V1);
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0800);
                }
                hm9.d(str, str2, str3, 3);
                this.a.I.f0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements rz4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz4.c a;
        public final /* synthetic */ dk9 b;

        public m0(dk9 dk9Var, iz4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dk9Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) {
                this.b.j0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements rz4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz4.c a;
        public final /* synthetic */ dk9 b;

        public n0(dk9 dk9Var, iz4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dk9Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) {
                this.b.j0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public o(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.I0.getVisibility() == 0) {
                    SharedPrefHelper.getInstance().putBoolean("pb_share_red_dot_shown", true);
                    this.a.I0.setVisibility(8);
                }
                this.a.f1093T.onClick(this.a.G0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public o0(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((view2 instanceof HeadImageView) && this.a.R0 != null && this.a.R0.O() != null && this.a.R0.O().getAuthor() != null && this.a.R0.O().getAuthor().getAlaInfo() != null && this.a.R0.O().getAuthor().getAlaInfo().live_status == 1) {
                    StatisticItem statisticItem = new StatisticItem("c11851");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem("c13715");
                    statisticItem2.param("fid", this.a.R0.l());
                    statisticItem2.param("fname", this.a.R0.m());
                    if (this.a.R0.O().getAuthor().getAlaInfo().user_info != null) {
                        j = this.a.R0.O().getAuthor().getAlaInfo().user_info.user_id;
                    } else {
                        j = 0;
                    }
                    statisticItem2.param("obj_param1", j);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("tid", this.a.R0.Q());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.R0.O().getAuthor().getAlaInfo()));
                    if (this.a.R0.O().getAuthor().getAlaInfo().mYyExtData != null) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                        TiebaStaticHelper.addYYParam(statisticItem2, this.a.R0.O().getAuthor().getAlaInfo().mYyExtData);
                    }
                    TiebaStatic.log(statisticItem2);
                    if (this.a.R0.O().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                        YYLiveUtil.jumpYYLiveRoom(this.a.f.getPageContext(), this.a.R0.O().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        return;
                    }
                    return;
                }
                if (this.a.p1) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                }
                if (!this.a.p1 && this.a.R0 != null && this.a.R0.O() != null && this.a.R0.O().getAuthor() != null && this.a.R0.O().getAuthor().isBigV()) {
                    TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                }
                if (this.a.f.l0() != null) {
                    this.a.f.l0().c.b.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c15305").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements bl9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public p0(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // com.baidu.tieba.bl9.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.A.a(this.a.o);
                } else {
                    this.a.A.d(this.a.o);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements FriendBotView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public q(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // com.baidu.tbadk.core.view.FriendBotView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.O4(3, 4, z);
            this.a.g4();
        }

        @Override // com.baidu.tbadk.core.view.FriendBotView.f
        public void b(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) != null) || gr5.a()) {
                return;
            }
            this.a.O4(2, 4, z);
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.a.f.getContext());
            } else if (z2) {
                this.a.g4();
            } else if (!z) {
                if (this.a.V1.ability_conf == null) {
                    return;
                }
                dk9 dk9Var = this.a;
                dk9Var.s0(str, dk9Var.V1.ability_conf.bot_uk, this.a.V1.ability_conf.skill_id.intValue());
            } else {
                hm9.e(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public q0(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            dk9 dk9Var;
            xm9 xm9Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.I != null && (xm9Var = (dk9Var = this.a).k) != null && xm9Var.k != null && dk9Var.R0 != null && this.a.R0.O() != null && !this.a.R0.O().isVideoThreadType() && !this.a.s2() && this.a.R0.k() != null && !ad.isEmpty(this.a.R0.k().getName())) {
                if ((this.a.I.L() == null || !this.a.I.L().isShown()) && (linearLayout = this.a.k.k) != null) {
                    linearLayout.setVisibility(0);
                    this.a.k.h();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements jd9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public r(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // com.baidu.tieba.jd9.b
        public void a(@NonNull CallRobotEntrance callRobotEntrance) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, callRobotEntrance) != null) || this.a.J0 == null) {
                return;
            }
            boolean o = this.a.J0.o();
            this.a.y2(callRobotEntrance, o);
            if (o) {
                hm9.e(this.a.J0.getLoadingToast());
                return;
            }
            AbilityConf abilityConf = callRobotEntrance.ability_conf;
            if (abilityConf == null) {
                return;
            }
            BotEntranceManager.h().m(abilityConf.bot_uk, abilityConf.skill_id.intValue());
            this.a.V1 = callRobotEntrance;
            StyleConf styleConf = callRobotEntrance.style_conf;
            if (styleConf != null) {
                this.a.J0.setCallRobotEntranceData(new dw4(callRobotEntrance, styleConf.day, styleConf.dark, false));
            }
            this.a.W4();
            dk9 dk9Var = this.a;
            dk9Var.s0(dk9Var.J0.getLoadingToast(), abilityConf.bot_uk, abilityConf.skill_id.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y65 a;
        public final /* synthetic */ dk9 b;

        public r0(dk9 dk9Var, y65 y65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, y65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dk9Var;
            this.a = y65Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.R0 != null && this.b.P1 != null) {
                this.b.P1.g(this.a);
                this.b.P1.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements ee9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ dk9 b;

        public s(dk9 dk9Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dk9Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.ee9
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.J0 != null) {
                    this.b.J0.x();
                }
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e("BotGuideManager", "新手长按引导展示完毕隐藏,文案：" + this.a);
            }
        }

        @Override // com.baidu.tieba.ee9
        public void onShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.b.J0 != null) {
                    this.b.J0.setDynamicLooping(true);
                    this.b.J0.r();
                }
                SharedPrefHelper.getInstance().putLong("pb_friend_bot_bottom_click_last_time", System.currentTimeMillis());
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e("BotGuideManager", "新手长按引导展示了,文案：" + this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ dk9 b;

        public s0(dk9 dk9Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dk9Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (BdUtilHelper.isNetOk()) {
                    UrlManager.getInstance().dealOneLink(this.b.f.getPageContext(), new String[]{this.a});
                    this.b.f.finish();
                    return;
                }
                this.b.f.showToast(R.string.obfuscated_res_0x7f0f0e4f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ dk9 f;

        public t(dk9 dk9Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = dk9Var;
            this.d = str;
            this.e = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void f(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.f(i, str, r7);
                if (this.f.f == null) {
                    return;
                }
                this.f.f.showToast(str);
                if (this.f.f.e0() != null) {
                    this.f.f.e0().o3();
                }
                if (this.f.f.E6().T0() != null) {
                    this.f.f.E6().T0().f0();
                }
                if (this.f.J0 != null && this.f.V1 != null) {
                    this.f.J0.k(this.f.V1);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                super.i(r5);
                hm9.e(this.d);
                hm9.b(this.f.f.e0(), this.e);
                if (this.f.U1 != null) {
                    SafeHandler.getInst().removeCallbacks(this.f.U1);
                }
                dk9 dk9Var = this.f;
                dk9Var.U1 = new md9(this.e, dk9Var.f);
                SafeHandler.getInst().postDelayed(this.f.U1, 30000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ ye9 c;
        public final /* synthetic */ dk9 d;

        public t0(dk9 dk9Var, Parcelable parcelable, ArrayList arrayList, ye9 ye9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, parcelable, arrayList, ye9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = dk9Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = ye9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.d.o != null) {
                    this.d.o.onRestoreInstanceState(this.a);
                }
                if (this.d.O != null && ListUtils.getCount(this.b) > 1 && this.c.y().b() > 0) {
                    this.d.O.g();
                    this.d.O.H(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f100e));
                    this.d.O.B();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements PbFirstFloorDoubleClickAnimation.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public u(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0.W();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public u0(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.f != null && this.a.f.isAdded()) {
                if (i < 0 && f > this.a.s1) {
                    this.a.F0();
                    this.a.J2();
                }
                this.a.N0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(dk9 dk9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, Integer.valueOf(i)};
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
            this.a = dk9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && this.a.I != null) {
                this.a.I.f0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v0 implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public v0(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                this.a.F0();
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public w(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.E == null) {
                    this.a.Z1();
                }
                this.a.n.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(dk9 dk9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, Integer.valueOf(i)};
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
            this.a = dk9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.N0 = false;
        }
    }

    /* loaded from: classes5.dex */
    public class x0 implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public x0(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public y(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y0 implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public y0(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z implements dd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk9 a;

        public z(dk9 dk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk9Var;
        }

        @Override // com.baidu.tieba.dd5
        public void O(cd5 cd5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cd5Var) == null) {
                Object obj = cd5Var.c;
                if ((obj instanceof q75) && EmotionGroupType.isSendAsPic(((q75) obj).g())) {
                    if (this.a.H1 == null) {
                        this.a.H1 = new PermissionJudgePolicy();
                    }
                    this.a.H1.clearRequestPermissionList();
                    this.a.H1.appendRequestPermission(this.a.f.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.H1.startRequestPermission(this.a.f.getBaseFragmentActivity())) {
                        return;
                    }
                    q75 q75Var = (q75) cd5Var.c;
                    this.a.f.B6().f(q75Var);
                    if (q75Var.j()) {
                        this.a.f.B6().I(null, null);
                    } else {
                        this.a.f.B6().x(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ dk9 e;

        public z0(dk9 dk9Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = dk9Var;
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
                    this.e.u1.showAsDropDown(this.d);
                } else {
                    this.e.u1.showAsDropDown(this.e.y0, this.d.getLeft(), -this.e.y0.getHeight());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947707575, "Lcom/baidu/tieba/dk9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947707575, "Lcom/baidu/tieba/dk9;");
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
        t2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        u2 = 1;
        v2 = new g0();
    }

    public void A4() {
        pea peaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || !TbadkCoreApplication.isLogin() || this.R0 == null || !this.q1 || this.p1 || this.m0 || (peaVar = this.S0) == null || peaVar.t() == null || this.S0.t().getIsLike() || this.S0.t().hadConcerned()) {
        }
    }

    public void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            R4();
            this.I.g0(1);
            zj9 zj9Var = this.s;
            if (zj9Var != null) {
                zj9Var.j();
            }
            ti9 ti9Var = this.D;
            if (ti9Var != null) {
                ti9Var.g();
            }
            vi9 vi9Var = this.C;
            if (vi9Var != null) {
                vi9Var.j();
            }
            RightFloatLayerView rightFloatLayerView = this.P1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (p2()) {
                this.W1.n();
            }
        }
    }

    public pea a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            if (this.o == null) {
                return null;
            }
            int Z0 = Z0() - this.o.getHeaderViewsCount();
            int i2 = 0;
            if (Z0 < 0) {
                Z0 = 0;
            }
            if (this.I.A(Z0) != null && this.I.A(Z0) != pea.W0) {
                i2 = Z0 + 1;
            }
            if (!(this.I.z(i2) instanceof pea)) {
                return null;
            }
            return (pea) this.I.z(i2);
        }
        return (pea) invokeV.objValue;
    }

    public final int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null && pbLandscapeListView.getData() != null) {
                for (int i2 = 0; i2 < this.o.getData().size(); i2++) {
                    yh yhVar = this.o.getData().get(i2);
                    if (yhVar != null && yhVar.getType() == af9.k) {
                        return i2 + this.o.getHeaderViewsCount();
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final boolean o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) {
            if (Z3()) {
                for (int firstVisiblePosition = this.o.getFirstVisiblePosition(); firstVisiblePosition <= this.o.getLastVisiblePosition(); firstVisiblePosition++) {
                    View childAt = this.o.getListView2().getChildAt(firstVisiblePosition);
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

    public void r3() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048781, this) == null) && (pbListView = this.O) != null && pbListView.i() != null) {
            LinearLayout i2 = this.O.i();
            View findViewById = i2.findViewById(R.id.obfuscated_res_0x7f091ad4);
            if (i2.getVisibility() == 0 && findViewById != null && findViewById.getVisibility() == 0) {
                this.d = true;
                TiebaStatic.log(new StatisticItem("c15304").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    public dk9(PbFragment pbFragment, View.OnClickListener onClickListener, tg9 tg9Var, SortSwitchButton.f fVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, tg9Var, fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.d = false;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 0;
        this.j = new Handler();
        this.o = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.f1093T = null;
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
        this.h0 = null;
        this.i0 = null;
        this.j0 = null;
        this.k0 = null;
        this.l0 = false;
        this.m0 = false;
        this.n0 = null;
        this.o0 = null;
        this.q0 = null;
        this.s0 = false;
        this.w0 = null;
        this.y0 = null;
        this.B0 = null;
        this.N0 = true;
        this.P0 = null;
        this.Q0 = false;
        this.U0 = 3;
        this.V0 = false;
        this.W0 = false;
        this.X0 = null;
        this.f1 = 0;
        this.g1 = true;
        this.h1 = new g1();
        this.i1 = 0;
        this.n1 = false;
        this.o1 = 0;
        this.p1 = false;
        this.q1 = false;
        this.r1 = false;
        this.s1 = 0;
        this.A1 = false;
        this.B1 = false;
        this.J1 = 0;
        this.T1 = new Object();
        this.X1 = new k(this, 2921757);
        this.Y1 = new o(this);
        this.Z1 = new q(this);
        this.a2 = new v(this, 2005016);
        this.b2 = new Handler();
        this.d2 = new x(this, 2004009);
        this.f2 = true;
        this.g2 = new o0(this);
        this.h2 = null;
        this.k2 = new ArrayList();
        this.l2 = false;
        this.f = pbFragment;
        this.h1.b = pbFragment.getPageContext().getUniqueId();
        this.f1093T = onClickListener;
        this.U = fVar;
        this.p0 = tg9Var;
        this.s1 = BdUtilHelper.getEquipmentWidth(this.f.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d070a, (ViewGroup) null);
        this.g = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.t0 = this.g.findViewById(R.id.obfuscated_res_0x7f09047f);
        this.D1 = (NavigationBarCoverTip) this.g.findViewById(R.id.obfuscated_res_0x7f091b50);
        this.h = this.g.findViewById(R.id.obfuscated_res_0x7f0922ee);
        this.Q1 = (FrameLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091f5d);
        this.H = (ObservedChangeRelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0925de);
        this.p = (NoNetworkView) this.g.findViewById(R.id.view_no_network);
        PbLandscapeListView pbLandscapeListView = (PbLandscapeListView) this.g.findViewById(R.id.obfuscated_res_0x7f09196b);
        this.o = pbLandscapeListView;
        pbLandscapeListView.setDividerHeight(0);
        this.Z0 = new TextView(this.f.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, ck9.m(this.f));
        this.o.setOverScrollMode(2);
        this.o.w(this.Z0, 0);
        this.o.setTextViewAdded(true);
        this.j1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.e1 = new View(this.f.getPageContext().getPageActivity());
        if (YoungsterVerifyUtils.isYoungsterOpen()) {
            this.e1.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.e1.setLayoutParams(new AbsListView.LayoutParams(-1, this.j1));
        }
        MessageManager.getInstance().registerListener(this.X1);
        this.e1.setVisibility(4);
        this.o.addFooterView(this.e1);
        this.o.setOnTouchListener(this.f.L2);
        this.a = new c1(this, pbFragment);
        this.o.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.k = new xm9(pbFragment, this.g);
        if (this.f.u6()) {
            ViewStub viewStub = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f0916ed);
            this.m = viewStub;
            viewStub.setVisibility(0);
            wm9 wm9Var = new wm9(pbFragment);
            this.l = wm9Var;
            wm9Var.c();
            this.k.a.setVisibility(8);
            layoutParams.height = BdUtilHelper.getDimens(this.f.getActivity(), R.dimen.obfuscated_res_0x7f070364);
        }
        this.Z0.setLayoutParams(layoutParams);
        this.k.j().setOnTouchListener(new rg9(new d1(this)));
        this.x0 = this.g.findViewById(R.id.obfuscated_res_0x7f09295b);
        this.y0 = this.g.findViewById(R.id.obfuscated_res_0x7f091ae5);
        this.O0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703a2);
        this.A0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f0909a6);
        this.A0.setOnClickListener(new e1(this, new ReplyPrivacyCheckController(this.f.getPageContext()), this.f.B6()));
        L0();
        this.B0 = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091ae8);
        LinearLayout linearLayout = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091adf);
        this.z0 = linearLayout;
        linearLayout.setOnClickListener(new f1(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.g.findViewById(R.id.obfuscated_res_0x7f0909aa);
        this.v0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new a(this));
        this.D0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091ae6);
        this.N1 = (MaskView) this.g.findViewById(R.id.mask_view);
        this.D0.setOnClickListener(this.f1093T);
        AgreeView agreeView = (AgreeView) this.g.findViewById(R.id.obfuscated_res_0x7f091ae1);
        this.E0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.E0.x();
        this.E0.setAgreeLongClickListener(new b(this));
        this.E0.setAfterClickListener(new c(this));
        this.E0.setUseDynamicLikeRes("/pb");
        if (this.E0.getAgreeNumView() != null) {
            this.E0.getAgreeNumView().setVisibility(8);
        }
        if (this.E0.getMsgData() != null) {
            this.E0.getMsgData().uniqueId = BdUniqueId.gen();
        }
        boolean booleanExtra = this.f.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091ae4);
        this.F0 = imageView;
        imageView.setOnClickListener(this.f1093T);
        if (booleanExtra) {
            this.F0.setVisibility(8);
        } else {
            this.F0.setVisibility(0);
        }
        T1();
        View findViewById = this.g.findViewById(R.id.obfuscated_res_0x7f091aeb);
        this.I0 = findViewById;
        if (!SharedPrefHelper.getInstance().getBoolean("pb_share_red_dot_shown", false) && TbadkCoreApplication.isLogin()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        findViewById.setVisibility(i2);
        this.G0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091ae9);
        HeadImageView headImageView = (HeadImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091aea);
        this.H0 = headImageView;
        headImageView.setIsRound(true);
        this.H0.setOnClickListener(this.Y1);
        this.G0.setOnClickListener(new d(this));
        B2();
        oo9 oo9Var = new oo9(this.G0);
        this.K0 = oo9Var;
        oo9Var.m(this.H0);
        TextView textView = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091ae7);
        this.M0 = textView;
        textView.setVisibility(0);
        this.L0 = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091ae2);
        this.X0 = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f091196);
        this.E0.setVisibility(0);
        this.L0.setVisibility(0);
        this.v = new cl9(this.f, tg9Var);
        this.x = new gl9(this.f, tg9Var, this.f1093T);
        li9 li9Var = new li9(this.f, this.o);
        this.I = li9Var;
        li9Var.E0(this.f1093T);
        this.I.H0(this.p0);
        this.I.B0(this.V);
        this.I.D0(this.U);
        this.I.x0(this.j2);
        e eVar = new e(this);
        this.Y = eVar;
        this.I.z0(eVar);
        e2();
        X1();
        fl9 fl9Var = new fl9(this.f);
        this.z = fl9Var;
        fl9Var.f = 2;
        W1();
        U1();
        this.A.a(this.o);
        this.x.q(this.o);
        this.w.a(this.o);
        this.B.a(this.o);
        this.v.a(this.o);
        PbListView pbListView = new PbListView(this.f.getPageContext().getPageActivity());
        this.O = pbListView;
        this.Q = pbListView.c().findViewById(R.id.pb_more_view);
        this.R = this.O.c().findViewById(R.id.pb_check_more);
        if (!this.O.k().booleanValue()) {
            this.R.setVisibility(8);
        }
        View view2 = this.Q;
        if (view2 != null) {
            view2.setOnClickListener(this.f1093T);
            SkinManager.setBackgroundResource(this.Q, R.drawable.pb_foot_more_trans_selector);
        }
        View view3 = this.R;
        if (view3 != null) {
            view3.setOnClickListener(this.f1093T);
        }
        this.O.D();
        this.O.r(R.drawable.pb_foot_more_trans_selector);
        this.O.F(R.color.CAM_X0109);
        this.O.s(R.drawable.pb_foot_more_trans_selector);
        this.S = this.g.findViewById(R.id.obfuscated_res_0x7f092993);
        this.f.registerListener(this.d2);
        this.l1 = new PbFakeFloorModel(this.f.getPageContext());
        PbModel e02 = this.f.e0();
        this.l1.g0(e02.W(), e02.S(), e02.T(), e02.R(), e02.X());
        aj9 aj9Var = new aj9(this.f.getPageContext(), this.l1, this.g);
        this.m1 = aj9Var;
        aj9Var.p(new f(this));
        this.m1.s(this.f.q2);
        this.l1.i0(new g(this));
        if (this.f.e0() != null && !StringUtils.isNull(this.f.e0().v1())) {
            PbFragment pbFragment2 = this.f;
            pbFragment2.showToast(pbFragment2.e0().v1());
        }
        this.a1 = this.g.findViewById(R.id.obfuscated_res_0x7f091aed);
        this.b1 = this.g.findViewById(R.id.obfuscated_res_0x7f09047d);
        View findViewById2 = this.g.findViewById(R.id.obfuscated_res_0x7f0922fa);
        this.c1 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.f.e0() != null && this.f.e0().e1()) {
            this.a1.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.c1.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = m2;
            this.c1.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f.getPageContext(), this.g.findViewById(R.id.obfuscated_res_0x7f091b70));
        this.d1 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.t(pbFragment.e0);
        this.d1.g.setVisibility(8);
        this.d1.s(this.f1093T);
        this.d1.r(this.U);
        this.f.registerListener(this.a2);
        PbFragment pbFragment3 = this.f;
        this.M1 = new no9(pbFragment3, pbFragment3.getUniqueId());
        PbFallingView pbFallingView = (PbFallingView) this.g.findViewById(R.id.obfuscated_res_0x7f090afc);
        this.O1 = pbFallingView;
        if (pbFallingView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.O1.getLayoutParams()).setMargins(0, ck9.m(this.f), 0, 0);
        }
        v3();
        this.O1.setAnimationListener(new h(this));
        A0();
        this.u0 = this.g.findViewById(R.id.obfuscated_res_0x7f091ad5);
        z0(YoungsterVerifyUtils.isYoungsterOpen());
        this.s = new zj9(this.f.l0(), (ViewGroup) G1().findViewById(R.id.obfuscated_res_0x7f091b83));
        dj9 dj9Var = new dj9(this.o, -2);
        this.u = dj9Var;
        dj9Var.d(new i(this, pbFragment));
        dj9 dj9Var2 = new dj9(this.o, 5);
        this.t = dj9Var2;
        dj9Var2.d(new j(this));
        this.R1 = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f09281f);
        this.S1 = new im9(this.f.getActivity());
        b2();
        wo6.b().b(this.T1, new ld9(new m(this)));
    }

    public void A3(boolean z2) {
        li9 li9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z2) == null) && (li9Var = this.I) != null) {
            li9Var.p0(z2);
        }
    }

    public void B3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2) == null) {
            this.A1 = z2;
        }
    }

    public void C3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z2) == null) {
            this.I.r0(z2);
        }
    }

    public void D3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) {
            this.I.w0(z2);
        }
    }

    public void E3(l45.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, gVar) == null) {
            this.i2 = gVar;
            po9 po9Var = this.N;
            if (po9Var != null) {
                po9Var.a(gVar);
            }
        }
    }

    public void F3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onClickListener) == null) {
            this.j2 = onClickListener;
            li9 li9Var = this.I;
            if (li9Var != null) {
                li9Var.x0(onClickListener);
            }
        }
    }

    public void G3(String str) {
        wm9 wm9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, str) == null) && (wm9Var = this.l) != null) {
            wm9Var.b(str);
        }
    }

    public void H3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z2) == null) {
            this.n1 = z2;
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                this.o1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void I3(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, zVar) == null) {
            this.V = zVar;
            this.I.B0(zVar);
            this.y1.p(this.V);
        }
    }

    public final void I4(pea peaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, peaVar) == null) && peaVar != null) {
            this.B1 = !StringUtils.isNull(peaVar.g0());
            gl9 gl9Var = this.x;
            if (gl9Var != null) {
                gl9Var.t(peaVar);
            }
        }
    }

    public void J3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, bVar) == null) {
            this.W = bVar;
            NoNetworkView noNetworkView = this.p;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public void K3(BdListView.p pVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, pVar) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setOnSrollToBottomListener(pVar);
        }
    }

    public void L3(AbsListView.OnScrollListener onScrollListener) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, onScrollListener) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setOnScrollListener(onScrollListener);
        }
    }

    public void L4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.f.showToast(str);
        }
    }

    public void M2(bi biVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048638, this, biVar) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.b0 = biVar;
            pbLandscapeListView.W = true;
        }
    }

    public void M3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, onClickListener) == null) {
            this.I.F0(onClickListener);
        }
    }

    public void N3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            this.I1 = i2;
        }
    }

    public void O3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, onLongClickListener) == null) {
            this.x.J(onLongClickListener);
            this.I.C0(onLongClickListener);
            yh9 yh9Var = this.y1;
            if (yh9Var != null) {
                yh9Var.q(onLongClickListener);
            }
        }
    }

    public void S4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z2) == null) {
            this.l0 = z2;
        }
    }

    public void U3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048679, this, z2) == null) {
            this.x.L(z2);
        }
    }

    public void W3(int i2) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048689, this, i2) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setSelection(i2);
        }
    }

    public void X3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, list) == null) {
            this.w1 = list;
            kl9 kl9Var = this.x1;
            if (kl9Var != null) {
                kl9Var.q(list);
            }
        }
    }

    public void Y2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048698, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        X2(sparseArray, false);
    }

    public final void Y3(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048699, this, i2) == null) && (textView = this.Z0) != null && (textView.getLayoutParams() instanceof AbsListView.LayoutParams)) {
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.Z0.getLayoutParams();
            layoutParams.height = i2;
            this.Z0.setLayoutParams(layoutParams);
        }
    }

    public void b5(ye9 ye9Var) {
        cl9 cl9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048716, this, ye9Var) == null) && (cl9Var = this.v) != null) {
            cl9Var.h(ye9Var, this.Q0);
        }
    }

    public final boolean j2(ye9 ye9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048747, this, ye9Var)) == null) {
            return ck9.x(ye9Var);
        }
        return invokeL.booleanValue;
    }

    public void j4(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048749, this, z2) == null) {
            View view2 = this.t0;
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    public final void r0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048778, this, view2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.addRule(11);
            view2.setLayoutParams(layoutParams);
        }
    }

    public final int r1(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048779, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.Y0;
            if (pbInterviewStatusView == null || pbInterviewStatusView.getVisibility() != 0 || !z2) {
                return 0;
            }
            return 0 + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
        }
        return invokeZ.intValue;
    }

    public void t3(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048791, this, str) == null) && (pbListView = this.O) != null) {
            pbListView.H(str);
        }
    }

    public boolean u0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048793, this, z2)) == null) {
            EditorTools editorTools = this.r0;
            if (editorTools != null && editorTools.x()) {
                this.r0.t();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void w3(PbFragment.i3 i3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048806, this, i3Var) == null) {
            this.e2 = i3Var;
        }
    }

    public void x3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048811, this, z2) == null) {
            this.s0 = z2;
        }
    }

    public void y3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048816, this, z2) == null) {
            this.I.o0(z2);
        }
    }

    @SuppressLint({"CutPasteId"})
    public void K4(ye9 ye9Var, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048630, this, ye9Var, z2) != null) || ye9Var == null) {
            return;
        }
        Y4(ye9Var, z2);
        I0();
    }

    public final void P3(pea peaVar, ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048654, this, peaVar, ye9Var) == null) {
            this.x.K(peaVar, ye9Var);
        }
    }

    public void b3(AdverSegmentData adverSegmentData, int i2) {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048714, this, adverSegmentData, i2) == null) && (pbFallingView = this.O1) != null) {
            pbFallingView.A(adverSegmentData, this.f.getPageContext(), i2, false);
        }
    }

    public final boolean v2(AbsListView absListView, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048800, this, absListView, i2)) == null) {
            if (t0(absListView, i2) && !this.k.o() && !p2()) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            yh9 yh9Var = new yh9(this.f, this, (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f0917b7));
            this.y1 = yh9Var;
            yh9Var.n(this.f1093T);
            this.y1.o(this.Y);
            this.y1.p(this.V);
            this.y1.n(this.f1093T);
            this.y1.r(this.p0);
        }
    }

    public final void E4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            PbFallingView pbFallingView = this.O1;
            if (pbFallingView != null) {
                pbFallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.P1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.O1) {
                this.P1.setTag(null);
                this.P1.setAutoCompleteShown(true);
                this.P1.d();
            }
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.k.f();
            PbFragment pbFragment = this.f;
            if (pbFragment != null) {
                BdUtilHelper.hideSoftKeyPad(pbFragment.getContext(), this.M);
            }
            L1();
            pz4 pz4Var = this.i0;
            if (pz4Var != null) {
                pz4Var.dismiss();
            }
            J0();
            hz4 hz4Var = this.J;
            if (hz4Var != null) {
                hz4Var.dismiss();
            }
            iz4 iz4Var = this.K;
            if (iz4Var != null) {
                iz4Var.e();
            }
        }
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            hz4 hz4Var = this.Z;
            if (hz4Var != null) {
                hz4Var.dismiss();
            }
            Dialog dialog = this.a0;
            if (dialog != null) {
                hb.b(dialog, this.f.getPageContext());
            }
            Dialog dialog2 = this.b0;
            if (dialog2 != null) {
                hb.b(dialog2, this.f.getPageContext());
            }
            pz4 pz4Var = this.X;
            if (pz4Var != null) {
                pz4Var.dismiss();
            }
        }
    }

    public void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            this.I.g0(2);
            P2();
            z2();
            c5();
            P4();
            x0();
            vi9 vi9Var = this.C;
            if (vi9Var != null) {
                vi9Var.k();
            }
            if (p2()) {
                this.W1.o();
            }
        }
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            this.J0 = (FriendBotView) this.g.findViewById(R.id.obfuscated_res_0x7f091ae3);
            PbFragment pbFragment = this.f;
            if (pbFragment != null && pbFragment.e0() != null) {
                this.J0.setTid(this.f.e0().Q());
            }
            this.J0.l();
        }
    }

    public final void V4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048685, this) == null) && (pbFragment = this.f) != null && pbFragment.B6() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.f.B6().A())));
        }
    }

    public final void Z4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048705, this) != null) || !this.f.u6()) {
            return;
        }
        if (this.f.z6() == -1) {
            SkinManager.setViewTextColor(this.F, R.color.CAM_X0110, 1);
        }
        if (this.f.y6() == -1) {
            SkinManager.setViewTextColor(this.G, R.color.CAM_X0110, 1);
        }
    }

    public final boolean a4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            PbFragment pbFragment = this.f;
            if (pbFragment == null || pbFragment.e0().s1().k().getDeletedReasonInfo() == null || 1 != this.f.e0().s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048713, this) != null) || this.f.u1 == 3 || !TbadkCoreApplication.isLogin()) {
            return;
        }
        n nVar = new n(this);
        this.D = new ti9(this.f.l0());
        this.C = new vi9(this.o, nVar);
    }

    public final void m3() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048760, this) != null) || (pbFragment = this.f) == null || pbFragment.getActivity() == null || (waterRippleView = this.C0) == null) {
            return;
        }
        ViewParent parent = waterRippleView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.C0);
        }
        TextView textView = this.L0;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void n3() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048764, this) == null) && (pbLandscapeListView = this.o) != null) {
            this.A.d(pbLandscapeListView);
            this.w.h(this.o);
            this.x.H(this.o);
            this.y.d(this.o);
            this.v.f(this.o);
        }
    }

    public boolean r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048780, this)) == null) {
            View view2 = this.e1;
            if (view2 == null || view2.getParent() == null || this.O.p()) {
                return false;
            }
            int bottom = this.e1.getBottom();
            Rect rect = new Rect();
            this.e1.getWindowVisibleDisplayFrame(rect);
            if (bottom <= 0 || bottom > rect.bottom) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048785, this)) == null) {
            ye9 ye9Var = this.R0;
            if (ye9Var == null || ye9Var.k() == null || "0".equals(this.R0.k().getId())) {
                return true;
            }
            return "me0407".equals(this.R0.k().getName());
        }
        return invokeV.booleanValue;
    }

    public final boolean u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048795, this)) == null) {
            PbFragment pbFragment = this.f;
            if (pbFragment != null && pbFragment.E6() != null && this.f.E6().R0 != null && this.f.E6().R0.K() != null) {
                FriendBotView friendBotView = this.J0;
                if (friendBotView == null || friendBotView.getVisibility() != 8) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048798, this)) == null) {
            PbListView pbListView = this.O;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.j())) {
                return this.O.j().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048814, this)) == null) {
            if (!ad.isEmpty(this.G1)) {
                return this.G1;
            }
            if (this.f != null) {
                this.G1 = TbadkCoreApplication.getInst().getResources().getString(ck9.h());
            }
            return this.G1;
        }
        return (String) invokeV.objValue;
    }

    public void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h3(this.R0);
        }
    }

    public int B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.U0;
        }
        return invokeV.intValue;
    }

    public View C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public void C4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.S.setVisibility(0);
        }
    }

    public PbThreadPostView D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.r;
        }
        return (PbThreadPostView) invokeV.objValue;
    }

    public void D4() {
        li9 li9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (li9Var = this.I) != null) {
            li9Var.I0();
        }
    }

    public final boolean E1() {
        InterceptResult invokeV;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            ye9 ye9Var = this.R0;
            if (ye9Var == null || (O = ye9Var.O()) == null) {
                return false;
            }
            return !O.isDisableShare();
        }
        return invokeV.booleanValue;
    }

    public RelativeLayout F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.H;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void F4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && this.K0 != null && E1()) {
            this.K0.n(2);
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.k.f();
            pz4 pz4Var = this.i0;
            if (pz4Var != null) {
                pz4Var.dismiss();
            }
            J0();
            hz4 hz4Var = this.J;
            if (hz4Var != null) {
                hz4Var.dismiss();
            }
            iz4 iz4Var = this.K;
            if (iz4Var != null) {
                iz4Var.e();
            }
        }
    }

    public RelativeLayout G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.g;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void H0() {
        oo9 oo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (oo9Var = this.K0) != null) {
            oo9Var.k(false);
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.W1 != null) {
            Y3(ck9.m(this.f));
            this.W1.s();
            this.W1.setVisibility(8);
        }
    }

    public final boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.v.b(this.Q0);
        }
        return invokeV.booleanValue;
    }

    public void I1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            xm9 xm9Var = this.k;
            if (xm9Var != null && (view2 = xm9Var.f) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048622, this) != null) || this.y0 == null) {
            return;
        }
        this.x0.setVisibility(8);
        this.y0.setVisibility(8);
        this.N0 = false;
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", u2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", u2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void L1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048632, this) == null) && (editorTools = this.r0) != null) {
            editorTools.q();
            kl9 kl9Var = this.x1;
            if (kl9Var != null) {
                kl9Var.m();
            }
        }
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            PbListView pbListView = this.O;
            if (pbListView != null) {
                pbListView.B();
                this.O.g();
            }
            N1();
        }
    }

    public void M1() {
        xm9 xm9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && (xm9Var = this.k) != null) {
            xm9Var.k();
        }
    }

    public void M4() {
        im9 im9Var;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && (im9Var = this.S1) != null && (linearLayout = this.R1) != null) {
            im9Var.c(linearLayout);
        }
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.z(0L);
            }
            I0();
        }
    }

    public void N1() {
        BlueCircleProgressDialog blueCircleProgressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (blueCircleProgressDialog = this.P0) != null) {
            blueCircleProgressDialog.setDialogVisiable(false);
        }
    }

    public void N4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            this.f.showProgressBar();
        }
    }

    public void O1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            if (this.E == null) {
                Z1();
            }
            this.n.setVisibility(8);
            Handler handler = this.b2;
            if (handler != null && (runnable = this.c2) != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }

    public void P0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048651, this) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setForbidDragListener(true);
        }
    }

    public void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            this.S.setVisibility(8);
        }
    }

    public final void P2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048653, this) == null) && (pbFragment = this.f) != null && pbFragment.B6() != null) {
            this.f.B6().G();
        }
    }

    public final void P4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048655, this) != null) || !u2()) {
            return;
        }
        O4(1, 4, this.J0.o());
    }

    public void Q0() {
        FriendBotView friendBotView;
        CallRobotEntrance callRobotEntrance;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048656, this) == null) && (friendBotView = this.J0) != null && (callRobotEntrance = this.V1) != null) {
            friendBotView.k(callRobotEntrance);
        }
    }

    public void Q1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048657, this) == null) && (rightFloatLayerView = this.P1) != null) {
            rightFloatLayerView.c();
        }
    }

    public void Q4() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048660, this) == null) && (pbFallingView = this.O1) != null) {
            pbFallingView.C();
        }
    }

    public void R1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048662, this) == null) && (editorTools = this.r0) != null) {
            editorTools.t();
        }
    }

    public void R4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048665, this) == null) && this.k2 != null) {
            while (this.k2.size() > 0) {
                TbImageView remove = this.k2.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void S1() {
        im9 im9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048667, this) == null) && (im9Var = this.S1) != null) {
            im9Var.a();
        }
    }

    public void S3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048669, this) == null) && (pbFragment = this.f) != null && pbFragment.getBaseFragmentActivity() != null) {
            BdUtilHelper.hideSoftKeyPad(this.f.getPageContext().getPageActivity(), this.f.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public li9 T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.I;
        }
        return (li9) invokeV.objValue;
    }

    public void T3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            this.O.D();
            this.O.U();
        }
    }

    public final void U1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048677, this) == null) && this.B == null && (pbFragment = this.f) != null && pbFragment.getActivity() != null) {
            this.B = new PbContentCollectionController(this.f.getActivity());
        }
    }

    public FriendBotView V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.J0;
        }
        return (FriendBotView) invokeV.objValue;
    }

    public LinearLayout W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            return this.z0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final void W1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048687, this) == null) && this.A == null && (pbFragment = this.f) != null) {
            this.A = new bl9(pbFragment.getContext());
        }
    }

    public View X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            View view2 = this.c0;
            if (view2 != null) {
                return view2.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048692, this) == null) && this.w == null) {
            this.w = new el9(this.f, this.p0);
        }
    }

    public String Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            return this.h0;
        }
        return (String) invokeV.objValue;
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            return this.p;
        }
        return (NoNetworkView) invokeV.objValue;
    }

    public boolean a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            zj9 zj9Var = this.s;
            if (zj9Var != null && zj9Var.l()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public PbFallingView b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            return this.O1;
        }
        return (PbFallingView) invokeV.objValue;
    }

    public int d1() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                i2 = pbLandscapeListView.getFirstVisiblePosition();
            } else {
                i2 = 0;
            }
            return e1(i2);
        }
        return invokeV.intValue;
    }

    public void d4() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            int i2 = 0;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            xm9 xm9Var = this.k;
            if (xm9Var != null && (view2 = xm9Var.f) != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    i2 = 8;
                }
                view2.setVisibility(i2);
            }
        }
    }

    public final void e2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048727, this) == null) && this.y == null) {
            this.y = new dl9(this.f, this.f1093T);
        }
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            this.x.G(this.R0, this.S0, this.q1, this.p1);
        }
    }

    public Button f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            return this.w0;
        }
        return (Button) invokeV.objValue;
    }

    public int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                return pbLandscapeListView.getHeaderViewsCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void g4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048737, this) == null) {
            h4(null);
        }
    }

    public TextView h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            return this.x.w();
        }
        return (TextView) invokeV.objValue;
    }

    public final boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            ye9 ye9Var = this.R0;
            if (ye9Var != null && ye9Var.O() != null && this.R0.O().isAlaLiveMixThreadType()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
            oo9 oo9Var = this.K0;
            if (oo9Var != null) {
                return oo9Var.f();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            return this.N0;
        }
        return invokeV.booleanValue;
    }

    public PbInterviewStatusView j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            return this.Y0;
        }
        return (PbInterviewStatusView) invokeV.objValue;
    }

    public boolean k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            return this.A1;
        }
        return invokeV.booleanValue;
    }

    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public final void k3() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048752, this) == null) && (pbInterviewStatusView = this.Y0) != null && pbInterviewStatusView.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Y0.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.Y0.setLayoutParams(marginLayoutParams);
        }
    }

    public int l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return 0;
            }
            return e1(pbLandscapeListView.getLastVisiblePosition());
        }
        return invokeV.intValue;
    }

    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            EditorTools editorTools = this.r0;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void l3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048756, this) == null) && this.i != 2) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setNextPage(this.O);
            }
            this.i = 2;
        }
    }

    public BdTypeListView m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) {
            return this.o;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public final boolean n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) {
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.h2);
        }
        return invokeV.booleanValue;
    }

    public TbMixPlayerView o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048766, this)) == null) {
            return this.W1;
        }
        return (TbMixPlayerView) invokeV.objValue;
    }

    public yh9 p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048770, this)) == null) {
            return this.y1;
        }
        return (yh9) invokeV.objValue;
    }

    public final boolean p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) {
            TbMixPlayerView tbMixPlayerView = this.W1;
            if (tbMixPlayerView != null && tbMixPlayerView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048772, this) == null) {
            o3();
            L1();
            this.m1.g();
            k4(false);
        }
    }

    public View q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048774, this)) == null) {
            return this.R;
        }
        return (View) invokeV.objValue;
    }

    public void q3() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048776, this) != null) || (handler = this.b2) == null) {
            return;
        }
        Runnable runnable = this.c2;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        w wVar = new w(this);
        this.c2 = wVar;
        this.b2.postDelayed(wVar, 2000L);
    }

    public void q4() {
        xm9 xm9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048777, this) == null) && (xm9Var = this.k) != null && !this.r1) {
            xm9Var.w();
            this.r1 = true;
        }
    }

    public void r4() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048782, this) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setVisibility(0);
        }
    }

    public View s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048784, this)) == null) {
            return this.Q;
        }
        return (View) invokeV.objValue;
    }

    public void s4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048787, this) == null) {
            if (this.P0 == null) {
                this.P0 = new BlueCircleProgressDialog(this.f.getPageContext());
            }
            this.P0.setDialogVisiable(true);
        }
    }

    public PbListView t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048789, this)) == null) {
            return this.O;
        }
        return (PbListView) invokeV.objValue;
    }

    public int u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048794, this)) == null) {
            try {
                return Integer.parseInt(this.M.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public void u4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048797, this) == null) {
            this.I.n0(this.R0, false);
            this.I.f0();
        }
    }

    public View v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048799, this)) == null) {
            return this.a1;
        }
        return (View) invokeV.objValue;
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048801, this) == null) {
            this.O1.setFallingFeedbackListener(new a1(this));
        }
    }

    public PbFakeFloorModel w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048804, this)) == null) {
            return this.l1;
        }
        return (PbFakeFloorModel) invokeV.objValue;
    }

    public boolean w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048805, this)) == null) {
            oo9 oo9Var = this.K0;
            if (oo9Var == null) {
                return false;
            }
            return oo9Var.h();
        }
        return invokeV.booleanValue;
    }

    public aj9 x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048809, this)) == null) {
            return this.m1;
        }
        return (aj9) invokeV.objValue;
    }

    public boolean x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048810, this)) == null) {
            EditorTools editorTools = this.r0;
            if (editorTools != null && editorTools.x()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final CustomBlueCheckRadioButton B0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.f.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, BdUtilHelper.getDimens(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.e0);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public void C2(boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            dj9 dj9Var = this.t;
            if (dj9Var != null) {
                dj9Var.b(z2, i2);
            }
            dj9 dj9Var2 = this.u;
            if (dj9Var2 != null) {
                dj9Var2.b(z2, i2);
            }
            vi9 vi9Var = this.C;
            if (vi9Var != null) {
                vi9Var.m(this.R0.k());
                this.C.i(z2, i2);
            }
        }
    }

    public void Q3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048659, this, z2, postWriteCallBackData) == null) {
            this.f.hideProgressBar();
            if (z2) {
                F0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                G0();
            } else {
                F0();
            }
        }
    }

    public final boolean t0(AbsListView absListView, int i2) {
        InterceptResult invokeLI;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048788, this, absListView, i2)) == null) {
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

    public final void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            r0(this.F0);
            if (this.G0.getParent() != null) {
                ((ViewGroup) this.G0.getParent()).removeView(this.G0);
                ((ViewGroup) this.H0.getParent()).removeView(this.H0);
            }
            if (this.I0.getParent() != null) {
                ((ViewGroup) this.I0.getParent()).removeView(this.I0);
            }
            RelativeLayout relativeLayout = new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds138), -2));
            relativeLayout.addView(this.G0);
            relativeLayout.addView(this.H0);
            relativeLayout.addView(this.I0);
            this.k.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, relativeLayout, (View.OnClickListener) null);
            this.k.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).setClipChildren(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r5.J1 == 1) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E0() {
        no9 no9Var;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || (no9Var = this.M1) == null) {
            return;
        }
        if (this.o != null && no9Var.a() != null && this.M1.a().getParent() != null) {
            i2 = this.o.getPositionForView(this.M1.a());
        } else {
            i2 = -1;
        }
        boolean z3 = false;
        if (i2 != -1) {
            if (this.M1.a().getTop() + t2 <= this.a1.getBottom()) {
                this.J1 = 1;
                z2 = true;
            } else {
                this.J1 = 0;
                z2 = false;
            }
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.d1;
        if (this.J1 == 1) {
            z3 = true;
        }
        pbReplyTitleViewHolder.x(z3);
        this.M1.e(z2);
    }

    public void J2() {
        ye9 ye9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && this.f != null && this.I1 != 3 && (ye9Var = this.R0) != null && ye9Var.k() != null && !ad.isEmpty(this.R0.k().getName())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f.getContext()).createNormalCfg(this.R0.k().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.R0.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.R0.k().getId()));
        }
    }

    public void R3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            this.f.hideProgressBar();
            ye9 ye9Var = this.R0;
            if (ye9Var != null && this.O != null && ye9Var.y() != null && this.R0.y().b() == 0) {
                this.O.y(this.R0.s());
                if (this.R0.s()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.R0.l());
                    statisticItem.param("fname", this.R0.m());
                    statisticItem.param("tid", this.R0.Q());
                    TiebaStatic.log(statisticItem);
                }
            }
            M0();
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.z(0L);
            }
            I0();
        }
    }

    public int Z0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return 0;
            }
            int firstVisiblePosition = pbLandscapeListView.getFirstVisiblePosition();
            int lastVisiblePosition = this.o.getLastVisiblePosition();
            if (lastVisiblePosition > firstVisiblePosition) {
                int i2 = (lastVisiblePosition - firstVisiblePosition) + 1;
                int[] iArr = new int[i2];
                Rect rect = new Rect();
                int childCount = this.o.getChildCount();
                int i3 = 0;
                for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                    int i5 = i4 - firstVisiblePosition;
                    if (i5 < childCount && (childAt = this.o.getChildAt(i5)) != null) {
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

    public final void Z1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048702, this) != null) || !this.f.u6()) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f0916e8);
        this.n = viewStub;
        viewStub.setVisibility(0);
        if (this.E == null) {
            this.E = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0916e7);
            co5.a(this.f.getPageContext(), this.E);
        }
        if (this.F == null) {
            this.F = (TextView) this.E.findViewById(R.id.obfuscated_res_0x7f0916ec);
        }
        if (this.G == null) {
            this.G = (TextView) this.E.findViewById(R.id.obfuscated_res_0x7f0916eb);
        }
        this.F.setOnClickListener(this.f1093T);
        this.G.setOnClickListener(this.f1093T);
    }

    public final boolean Z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            ye9 ye9Var = this.R0;
            if (ye9Var != null && ye9Var.O() != null && !ListUtils.isEmpty(this.R0.O().getThreadRecommendInfoDataList()) && this.f != null && this.w.b() != null && this.w.b().getVisibility() == 0 && this.R0.O().getThreadRecommendInfoDataList().get(0) != null && this.R0.O().getThreadRecommendInfoDataList().get(0).businessType == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048708, this) == null) {
            if (this.f != null && this.r0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.r0.j();
                J1();
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final void c3() {
        xm9 xm9Var;
        ye9 ye9Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048719, this) == null) && this.w != null && (xm9Var = this.k) != null && xm9Var.j() != null && (ye9Var = this.R0) != null && ye9Var.O() != null && this.R0.O().isQuestionThread() && this.w.b() != null && this.w.b().getVisibility() == 0) {
            int[] iArr = new int[2];
            this.w.b().getLocationInWindow(iArr);
            boolean z3 = true;
            int height = iArr[1] + this.w.b().getHeight();
            if (this.w.b().getParent() != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            xm9 xm9Var2 = this.k;
            if (height > xm9Var2.j().getBottom() && z2) {
                z3 = false;
            }
            xm9Var2.z(z3, this.R0.O().getSpan_str());
        }
    }

    public final void o3() {
        PbFragment pbFragment;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048768, this) == null) && (pbFragment = this.f) != null && pbFragment.B6() != null && this.r0 != null) {
            cf5.a().c(0);
            hf5 B6 = this.f.B6();
            B6.O();
            B6.M();
            if (B6.w() != null) {
                WriteImagesInfo w2 = B6.w();
                if (B6.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                w2.setMaxImagesAllowed(i2);
            }
            B6.f0(SendView.h);
            B6.h(SendView.h);
            kd5 o3 = this.r0.o(23);
            kd5 o4 = this.r0.o(2);
            kd5 o5 = this.r0.o(5);
            if (o4 != null) {
                o4.display();
            }
            if (o5 != null) {
                o5.display();
            }
            if (o3 != null) {
                o3.hide();
            }
            this.r0.invalidate();
        }
    }

    public final void x0() {
        PbContentCollectionController pbContentCollectionController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048808, this) == null) {
            if (Z3() && this.R0 != null) {
                StatisticItem addParam = new StatisticItem(CommonStatisticKey.KEY_PB_PAGE_CONTENT_COLLECTION_SHOW).addParam("tid", this.R0.O().getTid()).addParam("obj_param1", this.R0.O().getThreadRecommendInfoDataList().get(0).businessId);
                int i2 = this.R0.O().getThreadRecommendInfoDataList().get(0).albumType;
                if (i2 != -1) {
                    addParam.addParam("obj_type", i2);
                }
                addParam.eventStat();
            }
            if (o2() && (pbContentCollectionController = this.B) != null) {
                pbContentCollectionController.h();
                this.B.g(true);
            }
        }
    }

    public final void B4(hz4 hz4Var, int i2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, hz4Var, i2) == null) && (pbFragment = this.f) != null && hz4Var != null) {
            if (this.E1 == null && this.v != null) {
                this.E1 = new fz5(pbFragment.getPageContext(), this.v.c());
            }
            AntiData n6 = this.f.n6();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (n6 != null && n6.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = n6.getDelThreadInfoList();
                for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                    }
                }
            }
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray);
            this.E1.B(new String[]{this.f.getString(R.string.delete_thread_reason_1), this.f.getString(R.string.delete_thread_reason_2), this.f.getString(R.string.delete_thread_reason_3), this.f.getString(R.string.delete_thread_reason_4), this.f.getString(R.string.delete_thread_reason_5)});
            this.E1.A(negativeFeedBackData);
            if (i2 != 1 && i2 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.E1.D(str);
            this.E1.C(new i0(this, hz4Var));
        }
    }

    public void G4(mx4 mx4Var, hz4.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048610, this, mx4Var, eVar) != null) || mx4Var == null) {
            return;
        }
        int a2 = mx4Var.a();
        int h2 = mx4Var.h();
        hz4 hz4Var = this.J;
        if (hz4Var != null) {
            hz4Var.show();
        } else {
            this.J = new hz4(this.f.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0268, (ViewGroup) null);
            this.L = inflate;
            this.J.setContentView(inflate);
            this.J.setPositiveButton(R.string.obfuscated_res_0x7f0f05a1, eVar);
            this.J.setNegativeButton(R.string.obfuscated_res_0x7f0f0596, new v0(this));
            this.J.setOnCalcelListener(new w0(this));
            this.J.create(this.f.getPageContext()).show();
        }
        EditText editText = (EditText) this.L.findViewById(R.id.obfuscated_res_0x7f09114a);
        this.M = editText;
        editText.setText("");
        TextView textView = (TextView) this.L.findViewById(R.id.obfuscated_res_0x7f09083b);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a2), Integer.valueOf(h2)));
        this.f.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.M, 150);
    }

    public boolean Y4(ye9 ye9Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048700, this, ye9Var, z2)) == null) {
            if (ye9Var == null) {
                return false;
            }
            if (this.w != null) {
                if (ye9Var.O() != null && ye9Var.O().getIsNoTitle() == 0 && !ye9Var.O().isVideoThreadType()) {
                    if (ye9Var.O() != null) {
                        ThreadData O = ye9Var.O();
                        O.parserSpecTitleForFrsAndPb(true, n4(ye9Var));
                        O.setResource(3);
                        O.setPbTitle("2");
                    }
                    if (ye9Var.O().isBJHArticleThreadType()) {
                        this.x.H(this.o);
                        this.w.h(this.o);
                        this.w.a(this.o);
                        this.x.q(this.o);
                        this.x.M(this.R0);
                        if (j2(ye9Var)) {
                            this.w.h(this.o);
                        } else {
                            this.w.i(ye9Var);
                        }
                    } else {
                        this.x.M(this.R0);
                        if (j2(ye9Var)) {
                            this.w.h(this.o);
                        } else {
                            this.w.k(ye9Var);
                        }
                    }
                } else if (ye9Var.O().getIsNoTitle() == 1) {
                    if (ye9Var.O() != null) {
                        this.w.h(this.o);
                        this.x.M(this.R0);
                    }
                } else {
                    this.w.h(this.o);
                    this.x.M(this.R0);
                }
            }
            I4(ye9Var.X());
            J4(ye9Var);
            this.Q0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final void f4(int i2, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048733, this, i2, sparseArray) == null) && (pbFragment = this.f) != null && pbFragment.e0() != null && this.f.e0().s1() != null && this.f.e0().s1().n() != null && this.f.e0().s1().k() != null && this.f.e0().s1().k().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
            }
            hz5 hz5Var = new hz5(this.f.e0().s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f.e0().s1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.f.e0().s1().n().has_forum_rule.intValue());
            hz5Var.i(this.f.e0().s1().k().getId(), this.f.e0().s1().k().getName());
            hz5Var.h(this.f.e0().s1().k().getImage_url());
            hz5Var.j(this.f.e0().s1().k().getUser_level());
            t4(sparseArray, i2, hz5Var, this.f.e0().s1().V(), true);
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !this.l2) {
            TiebaStatic.log("c10490");
            this.l2 = true;
            hz4 hz4Var = new hz4(this.f.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(o2, Integer.valueOf(q2));
            hz4Var.setTitle(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            hz4Var.setContentView(inflate);
            hz4Var.setYesButtonTag(sparseArray);
            hz4Var.setPositiveButton(R.string.grade_button_tips, this.f);
            hz4Var.setNegativeButton(R.string.look_again, new x0(this));
            hz4Var.create(this.f.getPageContext()).show();
        }
    }

    public final void W4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            if (he9.c()) {
                DefaultLog.getInstance().e("BotGuideManager", "新手长按引导未展示,BotGuideManager在展示其他");
            } else if (SharedPrefHelper.getInstance().getBoolean("pb_friend_bot_bottom_long_click_shown", false)) {
                DefaultLog.getInstance().e("BotGuideManager", "新手长按引导未展示,长按引导已经展示过");
            } else if (SharedPrefHelper.getInstance().getBoolean("pb_friend_bot_bottom_new_user_shown", false) && (pbFragment = this.f) != null) {
                BaseFragmentActivity baseFragmentActivity = pbFragment.getBaseFragmentActivity();
                if (baseFragmentActivity != null && this.J0 != null) {
                    String string = baseFragmentActivity.getString(R.string.obfuscated_res_0x7f0f1001);
                    he9.e(string, this.J0, baseFragmentActivity, new s(this, string));
                    SharedPrefHelper.getInstance().putBoolean("pb_friend_bot_bottom_long_click_shown", true);
                    return;
                }
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e("BotGuideManager", "新手长按引导未展示,activity=" + baseFragmentActivity + ",mBottomBot=" + this.J0);
            } else {
                TbLog defaultLog2 = DefaultLog.getInstance();
                defaultLog2.e("BotGuideManager", "新手长按引导未展示,新手引导未展示过，mPbFragment==" + this.f);
            }
        }
    }

    public final void b4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048715, this) == null) && (pbFragment = this.f) != null && pbFragment.getActivity() != null) {
            if (this.E0.getWidth() != 0 && this.E0.getHeight() != 0) {
                WaterRippleView waterRippleView = this.C0;
                if (waterRippleView == null) {
                    this.C0 = new WaterRippleView(this.f.getActivity());
                } else {
                    ViewParent parent = waterRippleView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(this.C0);
                    }
                }
                Rect rect = new Rect();
                this.g.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                this.E0.getImgAgree().getGlobalVisibleRect(rect2);
                int dimens = BdUtilHelper.getDimens(this.f.getActivity(), R.dimen.tbds166);
                int i2 = ((rect2.right + rect2.left) / 2) - dimens;
                int i3 = (rect.bottom - ((rect2.bottom + rect2.top) / 2)) - dimens;
                int i4 = dimens * 2;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, i4);
                layoutParams.addRule(12, -1);
                layoutParams.setMargins(i2, 0, 0, i3);
                this.g.addView(this.C0, layoutParams);
                TextView textView = this.L0;
                if (textView != null) {
                    textView.setVisibility(4);
                    return;
                }
                return;
            }
            BdLog.e("AgreeView not measured");
        }
    }

    public final void c4() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            if (!h2()) {
                H1();
                return;
            }
            AlaInfoData c2 = em9.c(this.R0);
            if (c2 != null && !StringUtils.isNull(c2.mFlv) && c2.live_status == 1) {
                if (this.W1 == null) {
                    this.W1 = (TbMixPlayerView) this.g.findViewById(R.id.obfuscated_res_0x7f091798);
                    em9.d(this, this.R0);
                }
                String str2 = null;
                if (this.W1.getTbMixPlayerConfig() instanceof TbLiveMixPlayerConfig) {
                    str2 = ((TbLiveMixPlayerConfig) this.W1.getTbMixPlayerConfig()).a().mFlv;
                }
                if (this.W1.getVisibility() != 0 || ((str = c2.mFlv) != null && !str.equals(str2))) {
                    this.W1.setVisibility(0);
                    this.W1.setMixPlayerConfig(new TbLiveMixPlayerConfig(c2));
                    this.W1.o();
                    Y3(ck9.m(this.f) + this.W1.getPlayerHeight());
                    oca.u("c15498", this.R0.O(), c2, 0L);
                    return;
                }
                return;
            }
            H1();
        }
    }

    public final void y0() {
        ye9 ye9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048813, this) == null) && this.B != null && (ye9Var = this.R0) != null && ye9Var.O() != null && !ListUtils.isEmpty(this.R0.O().getThreadRecommendInfoDataList()) && this.R0.O().getThreadRecommendInfoDataList().get(0) != null && this.w.b().getVisibility() == 0) {
            if (this.w.b().getParent() == null) {
                this.B.g(false);
                return;
            }
            int[] iArr = new int[2];
            this.B.b().getLocationInWindow(iArr);
            if (iArr[1] + this.B.b().getHeight() > this.k.j().getBottom()) {
                this.B.i();
                this.B.g(true);
                return;
            }
            this.B.g(false);
        }
    }

    public final void z2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048820, this) == null) && (pbFragment = this.f) != null && pbFragment.e0() != null && this.f.e0().G != null && this.f.e0().G.O() != null && this.f.e0().G.O().isQuestionThread()) {
            ThreadData O = this.f.e0().G.O();
            String F1 = this.f.e0().F1();
            String G1 = this.f.e0().G1();
            int i2 = 5;
            if ("question_answer_invite".equals(F1)) {
                i2 = 1;
            } else if ("3".equals(G1)) {
                i2 = 2;
            } else if ("answer_top".equals(F1)) {
                i2 = 3;
            } else if (this.f.e0().X0()) {
                i2 = 4;
            }
            TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", O.getId()).param("fid", O.getFid()).param("obj_source", i2));
        }
    }

    public void D0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            hz4 hz4Var = new hz4(this.f.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            hz4Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(o2, Integer.valueOf(r2));
            hz4Var.setYesButtonTag(sparseArray);
            hz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f182b, this.f);
            hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, new y0(this));
            hz4Var.create(this.f.getPageContext()).show();
        }
    }

    public void U4(xe9 xe9Var) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048680, this, xe9Var) != null) || xe9Var == null) {
            return;
        }
        this.k.C();
        if (!StringUtils.isNull(xe9Var.b)) {
            this.k.y(xe9Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1674);
        int i2 = JavaTypesHelper.toInt(xe9Var.a, 0);
        if (i2 != 100) {
            if (i2 != 300) {
                if (i2 != 400) {
                    string = "";
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f15e1);
                }
            } else {
                string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0338);
            }
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1386);
        }
        this.f.showNetRefreshView(this.g, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new s0(this, xe9Var.c));
    }

    public void X4(ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, ye9Var) == null) {
            if (ye9Var != null && AntiHelper.o(ye9Var.O())) {
                oo9 oo9Var = this.K0;
                if (oo9Var != null) {
                    oo9Var.k(false);
                    this.K0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.G0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.G0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.G0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else if (ye9Var != null && ye9Var.O() != null && ye9Var.O().isDisableShare()) {
                View view2 = this.I0;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.G0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.G0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.G0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                MaskView.e(this.G0, ye9Var.O().isDisableShare(), ye9Var.O().getDisableShareToast());
            } else {
                oo9 oo9Var2 = this.K0;
                if (oo9Var2 != null && oo9Var2.g()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams3 = this.G0.getLayoutParams();
                layoutParams3.height = -2;
                layoutParams3.width = -2;
                this.G0.setLayoutParams(layoutParams3);
                WebPManager.setPureDrawable(this.G0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void Z2(@NonNull View view2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048703, this, view2) == null) && this.E0.getData() != null && this.E0.getData().hasAgree && this.f.getActivity() != null) {
            PbFirstFloorDoubleClickAnimation pbFirstFloorDoubleClickAnimation = new PbFirstFloorDoubleClickAnimation(this.f.getContext());
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds774);
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0708fc);
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens2, dimens);
            layoutParams.leftMargin = ((view2.getWidth() / 2) + i2) - ((int) ((dimens2 * 1) / 1.45d));
            layoutParams.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
            pbFirstFloorDoubleClickAnimation.setLottieHeight(dimens);
            pbFirstFloorDoubleClickAnimation.setLayoutParmas(layoutParams);
            pbFirstFloorDoubleClickAnimation.setClippingEnable(false);
            if (this.R0 != null && (pbFragment = this.f) != null) {
                pbFirstFloorDoubleClickAnimation.showFireworks(true, pbFragment.getActivity().findViewById(16908290), 0, i3, this.R0.Q(), this.R0.l());
            }
            pbFirstFloorDoubleClickAnimation.setOnPraiseAnimatorListener(new u(this));
        }
    }

    public final boolean n4(ye9 ye9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048765, this, ye9Var)) == null) {
            if (ye9Var == null || ye9Var.O() == null) {
                return false;
            }
            if (ye9Var.O().getIsLive() != 1 && ye9Var.O().getThreadType() != 33 && ((ye9Var.O().getTopicData() == null || ye9Var.O().getTopicData().a() == 0) && ye9Var.O().getIs_top() != 1 && ye9Var.O().getIs_good() != 1 && !ye9Var.O().isActInfo() && !ye9Var.O().isInterviewLive() && !ye9Var.O().isVoteThreadType() && ye9Var.O().getYulePostActivityData() == null && ad.isEmpty(ye9Var.O().getCategory()) && !ye9Var.O().isGodThread() && !ye9Var.O().isRealGod())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void D2(AgreeMessageData agreeMessageData) {
        ye9 ye9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, agreeMessageData) == null) && agreeMessageData != null && agreeMessageData.agreeData != null && (ye9Var = this.R0) != null && ye9Var.O() != null && this.R0.O().getAgreeData() != null) {
            AgreeData agreeData = this.R0.O().getAgreeData();
            String str = agreeMessageData.agreeData.nid;
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                    return;
                }
            } else {
                String str2 = agreeMessageData.agreeData.threadId;
                String str3 = agreeData.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
            }
            AgreeData agreeData2 = agreeMessageData.agreeData;
            g3(agreeData2, agreeData2.agreeNum);
        }
    }

    public void H2(TbRichText tbRichText) {
        ye9 ye9Var;
        pea peaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, tbRichText) == null) && (ye9Var = this.R0) != null && ye9Var.F() != null && !this.R0.F().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i2 = 0; i2 < this.R0.F().size() && (peaVar = this.R0.F().get(i2)) != null && peaVar.t() != null && !StringUtils.isNull(peaVar.t().getUserId()); i2++) {
                if (this.R0.F().get(i2).t().getUserId().equals(tbRichText.getAuthorId())) {
                    yh9 yh9Var = this.y1;
                    if (yh9Var != null && yh9Var.k()) {
                        k4(false);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void H4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) && this.o != null && (textView = this.Z0) != null && this.h != null) {
            if (z2) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.h.setVisibility(0);
                } else {
                    this.h.setVisibility(8);
                    this.o.removeHeaderView(this.Z0);
                    this.o.setTextViewAdded(false);
                }
                if (this.Z0.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.Z0.getLayoutParams();
                    layoutParams.height = m2;
                    this.Z0.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            if (textView.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.Z0.getLayoutParams();
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + r1(true);
                this.Z0.setLayoutParams(layoutParams2);
            }
            k3();
        }
    }

    public final void J4(ye9 ye9Var) {
        boolean z2;
        el9 el9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, ye9Var) == null) && !this.B1 && ye9Var != null && ye9Var.O() != null && !ye9Var.O().isVideoThreadType()) {
            ThreadData O = ye9Var.O();
            boolean z3 = false;
            if (O.getIs_good() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (O.getIs_top() == 1) {
                z3 = true;
            }
            gl9 gl9Var = this.x;
            if (gl9Var != null) {
                gl9Var.u(ye9Var, z2, z3);
            }
            if (O.isShowTitle() && (el9Var = this.w) != null && el9Var.d() != null) {
                ck9.c(this.w.d(), O.isHeadLinePost, O.isGoodThread(), O.isTopThread());
            }
            if (T0() != null) {
                T0().J0(ye9Var);
            }
        }
    }

    public void K1(boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048627, this, z2) == null) && this.y0 != null && this.B0 != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            ye9 ye9Var = this.R0;
            if (ye9Var != null && ye9Var.q0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            ye9 ye9Var2 = this.R0;
            if (ye9Var2 != null && ye9Var2.r0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.B0.setText(tbSingleton.getAdVertiComment(z3, z4, y1()));
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.y0.startAnimation(alphaAnimation);
            }
            this.x0.setVisibility(0);
            this.y0.setVisibility(0);
            this.N0 = true;
        }
    }

    public final String R0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048661, this, j2)) == null) {
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

    public final String S0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048666, this, i2)) == null) {
            if (i2 == 0) {
                return this.f.getString(R.string.obfuscated_res_0x7f0f0ff6);
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

    public void a5(boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048711, this, z2) == null) {
            li9 li9Var = this.I;
            if (li9Var != null) {
                li9Var.A0(z2);
                this.I.f0();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.d1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.q(z2);
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder2 = this.h1.a;
            if (pbReplyTitleViewHolder2 != null) {
                pbReplyTitleViewHolder2.q(z2);
            }
            PbFragment pbFragment = this.f;
            if (pbFragment != null) {
                pbFragment.e8(z2);
            }
            if (z2) {
                jm9.d(this.f.getPageContext(), this.f.e0(), this.f.E6());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            ye9 ye9Var = this.R0;
            if (ye9Var != null) {
                str = ye9Var.l();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public final void e4(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048729, this, sparseArray) != null) || this.f == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f1403, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03d2, TBAlertConfig.OperateBtnStyle.SECONDARY);
        AlertDialog show = new TBAlertBuilder(this.f.l0()).setTitle(R.string.musk_my_thread_confirm).setDesc(R.string.musk_my_thread_confirm_subtitle).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new f0(this, show, sparseArray));
        operateBtnConfig2.setListener(new h0(this, show));
    }

    public final void f2(ye9 ye9Var) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048731, this, ye9Var) == null) && (pbListView = this.O) != null && pbListView.i() != null) {
            LinearLayout i2 = this.O.i();
            if (ye9Var.y().b() == 0 && !this.f.e0().X0() && !t2(ye9Var)) {
                if (this.b == null) {
                    V1();
                }
                ViewParent parent = this.b.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.b);
                }
                i2.addView(this.b);
                ForumData k2 = ye9Var.k();
                sw4 forumShowInfo = k2.getForumShowInfo();
                if (forumShowInfo != null) {
                    forumShowInfo.g(TbadkCoreApplication.getInst().getString(R.string.enter_forum));
                }
                this.b.setData(k2.getName(), k2.getImage_url(), k2.getPost_num(), k2.getMember_num(), k2.getPendants(), forumShowInfo);
                return;
            }
            i2.removeView(this.b);
            i2.setVisibility(8);
        }
    }

    public void s3(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048786, this, editorTools) == null) {
            this.r0 = editorTools;
            editorTools.setOnCancelClickListener(new y(this));
            this.r0.setId(R.id.obfuscated_res_0x7f091ae0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.r0.getParent() == null) {
                this.g.addView(this.r0, layoutParams);
            }
            this.r0.z(TbadkCoreApplication.getInst().getSkinType());
            this.r0.setActionListener(24, new z(this));
            L1();
            this.f.B6().g(new a0(this));
        }
    }

    public void E2(int i2) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048598, this, i2) != null) || this.U0 == i2) {
            return;
        }
        this.U0 = i2;
        K4(this.R0, this.Q0);
        j3(this.R0, this.Q0, this.T0, i2);
        BDLayoutMode layoutMode = this.f.getBaseFragmentActivity().getLayoutMode();
        if (i2 == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        layoutMode.setNightMode(z2);
        this.f.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.g);
        SkinManager.setBackgroundColor(this.g, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.t0, R.color.CAM_X0203);
        dl9 dl9Var = this.y;
        if (dl9Var != null) {
            dl9Var.c(i2);
        }
        cl9 cl9Var = this.v;
        if (cl9Var != null) {
            cl9Var.e(i2);
        }
        el9 el9Var = this.w;
        if (el9Var != null) {
            el9Var.g(i2);
        }
        gl9 gl9Var = this.x;
        if (gl9Var != null) {
            gl9Var.D(i2);
        }
        fl9 fl9Var = this.z;
        if (fl9Var != null) {
            fl9Var.e();
        }
        bl9 bl9Var = this.A;
        if (bl9Var != null) {
            bl9Var.c();
        }
        MaskView maskView = this.N1;
        if (maskView != null) {
            maskView.g();
        }
        zj9 zj9Var = this.s;
        if (zj9Var != null) {
            zj9Var.o();
        }
        ti9 ti9Var = this.D;
        if (ti9Var != null) {
            ti9Var.n();
        }
        PbContentCollectionController pbContentCollectionController = this.B;
        if (pbContentCollectionController != null) {
            pbContentCollectionController.c();
        }
        PbListView pbListView = this.O;
        if (pbListView != null) {
            pbListView.e(i2);
        }
        if (this.Q != null) {
            this.f.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.Q);
            SkinManager.setBackgroundResource(this.Q, R.drawable.pb_foot_more_trans_selector);
        }
        if (this.R != null) {
            this.f.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.R);
            SkinManager.setBackgroundResource(this.R, R.drawable.pb_foot_more_trans_selector);
        }
        hz4 hz4Var = this.J;
        if (hz4Var != null) {
            hz4Var.autoChangeSkinType(this.f.getPageContext());
        }
        S4(this.l0);
        this.I.f0();
        po9 po9Var = this.N;
        if (po9Var != null) {
            po9Var.D(i2);
        }
        EditorTools editorTools = this.r0;
        if (editorTools != null) {
            editorTools.z(i2);
        }
        ko9 ko9Var = this.P;
        if (ko9Var != null) {
            ko9Var.g(i2);
        }
        if (!ListUtils.isEmpty(this.q)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.q) {
                customBlueCheckRadioButton.c();
            }
        }
        Z4();
        UtilHelper.setStatusBarBackground(this.h, i2);
        UtilHelper.setStatusBarBackground(this.c1, i2);
        if (this.E != null) {
            co5.a(this.f.getPageContext(), this.E);
        }
        aj9 aj9Var = this.m1;
        if (aj9Var != null) {
            aj9Var.l(i2);
        }
        xm9 xm9Var = this.k;
        if (xm9Var != null) {
            xm9Var.p(i2);
        }
        LinearLayout linearLayout = this.z0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(this.f.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        ye9 ye9Var = this.R0;
        if (ye9Var != null && ye9Var.q()) {
            WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.D0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.A0, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        X4(this.R0);
        if (this.I0.getVisibility() == 0) {
            this.I0.setBackgroundDrawable(SkinManager.createShapeDrawable(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i2));
        }
        SkinManager.setBackgroundColor(this.y0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.x0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.v1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.B0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.M0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.M0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.L0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.L0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.E0;
        if (agreeView != null) {
            agreeView.x();
            this.E0.P(i2);
            AgreeData data = this.E0.getData();
            if (data != null) {
                g3(data, data.agreeNum);
            }
        }
        yh9 yh9Var = this.y1;
        if (yh9Var != null) {
            yh9Var.l(i2);
        }
        PbThreadPostView pbThreadPostView = this.r;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i2);
        }
        CardForumHeadLayout cardForumHeadLayout = this.b;
        if (cardForumHeadLayout != null) {
            cardForumHeadLayout.g();
            EMManager.from(this.b).setCorner(R.string.J_X05).setBackGroundRealColor(vca.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
        }
        oo9 oo9Var = this.K0;
        if (oo9Var != null) {
            oo9Var.i();
        }
        no9 no9Var = this.M1;
        if (no9Var != null) {
            no9Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.P1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.n();
        }
        SkinManager.setBackgroundColor(this.b1, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.b1.findViewById(R.id.tv_title), (int) R.color.CAM_X0105);
        LinearLayout linearLayout2 = this.R1;
        if (linearLayout2 != null) {
            EMManager.from(linearLayout2).setBackGroundColor(R.color.CAM_X0201);
        }
        im9 im9Var = this.S1;
        if (im9Var != null) {
            im9Var.b(i2);
        }
    }

    public void F2(Configuration configuration) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048603, this, configuration) != null) || configuration == null) {
            return;
        }
        F0();
        if (configuration.orientation == 2) {
            J1();
            L1();
        } else {
            p3();
        }
        aj9 aj9Var = this.m1;
        if (aj9Var != null) {
            aj9Var.g();
        }
        this.f.P6();
        this.H.setVisibility(8);
        this.k.v(false);
        this.f.f8(false);
    }

    public void K2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z2) == null) {
            if (z2) {
                q4();
            } else {
                M1();
            }
            this.h1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.h1));
            d3(this.h1.a, false);
        }
    }

    public void T4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048675, this, z2) == null) {
            this.k.B(z2);
            if (z2 && this.V0) {
                this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
                PbLandscapeListView pbLandscapeListView = this.o;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setNextPage(this.O);
                }
                this.i = 2;
            }
        }
    }

    public void d2(ye9 ye9Var) {
        y65 b02;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048723, this, ye9Var) != null) || ye9Var == null) {
            return;
        }
        if (ye9Var.q0()) {
            b02 = ye9Var.b0();
        } else {
            b02 = ye9Var.b0();
            if (b02 == null || b02.a()) {
                b02 = TbSingleton.getInstance().getPbAdFloatViewItemData();
            }
        }
        if (b02 != null && !b02.a()) {
            c2(ye9Var, b02);
        } else {
            Q1();
        }
    }

    public void k4(boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048753, this, z2) != null) || this.y0 == null) {
            return;
        }
        if (this.f.B6() != null && this.f.B6().A()) {
            z3 = true;
        } else {
            z3 = false;
        }
        x3(z3);
        if (this.s0) {
            o4(z2);
        } else {
            K1(z2);
        }
    }

    public void o4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048769, this, z2) == null) && this.y0 != null && (textView = this.B0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f0610);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.y0.startAnimation(alphaAnimation);
            }
            this.x0.setVisibility(0);
            this.y0.setVisibility(0);
            this.N0 = true;
        }
    }

    public final boolean q2(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        pea X;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048775, this, threadData)) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                ye9 ye9Var = this.R0;
                if (ye9Var != null && (X = ye9Var.X()) != null && X.t() != null) {
                    str = X.t().getUserId();
                } else {
                    str = "";
                }
                return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean t2(ye9 ye9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048790, this, ye9Var)) == null) {
            if (ye9Var == null) {
                return true;
            }
            ArrayList<pea> F = ye9Var.F();
            if (ListUtils.getCount(F) == 0) {
                return true;
            }
            if (ListUtils.getCount(F) == 1 && ListUtils.getItem(F, 0) != null && ((pea) ListUtils.getItem(F, 0)).L() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int z1(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048819, this, pbReplyTitleViewHolder)) == null) {
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

    public void G2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            RelativeLayout relativeLayout = this.g;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.g.getHandler().removeCallbacksAndMessages(null);
            }
            oo9 oo9Var = this.K0;
            if (oo9Var != null) {
                oo9Var.j();
            }
            nj9 nj9Var = this.C1;
            if (nj9Var != null) {
                nj9Var.c();
            }
            PbTopTipView pbTopTipView = this.t1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.f.hideProgressBar();
            NoNetworkView noNetworkView = this.p;
            if (noNetworkView != null && (bVar = this.W) != null) {
                noNetworkView.removeNetworkChangeListener(bVar);
            }
            aea.d();
            F0();
            M0();
            if (this.k1 != null) {
                SafeHandler.getInst().removeCallbacks(this.k1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.Y0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            MessageManager.getInstance().unRegisterListener(this.X1);
            wo6.b().a(this.T1);
            this.b2 = null;
            this.j.removeCallbacksAndMessages(null);
            this.I.g0(3);
            View view2 = this.h;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            li9 li9Var = this.I;
            if (li9Var != null) {
                li9Var.i0();
            }
            kl9 kl9Var = this.x1;
            if (kl9Var != null) {
                kl9Var.l();
            }
            gl9 gl9Var = this.x;
            if (gl9Var != null) {
                gl9Var.E();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.d1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.r(null);
            }
            this.z1 = null;
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setOnLayoutListener(null);
                this.o.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
                this.o.setListViewDragListener(null);
                this.o.K();
                this.o = null;
            }
            AgreeView agreeView = this.E0;
            if (agreeView != null) {
                agreeView.setAgreeLongClickListener(null);
                this.E0.setAfterClickListener(null);
            }
            g1 g1Var = this.h1;
            if (g1Var != null) {
                g1Var.a = null;
            }
            if (this.U1 != null) {
                SafeHandler.getInst().removeCallbacks(this.U1);
            }
            aj9 aj9Var = this.m1;
            if (aj9Var != null) {
                aj9Var.m();
            }
            he9.d();
            TbMixPlayerView tbMixPlayerView = this.W1;
            if (tbMixPlayerView != null) {
                tbMixPlayerView.s();
                this.W1.p();
            }
        }
    }

    public void N2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.f.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            V4();
            this.f.L7();
            PbFragment pbFragment = this.f;
            if (pbFragment != null && pbFragment.e0() != null && this.f.e0().s1() != null && this.f.e0().s1().O() != null && this.f.e0().s1().O().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f.e0().N1()).param("fid", this.f.e0().s1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f.e0().b).param("fid", this.f.e0().s1().l()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f.getContext());
            this.b = cardForumHeadLayout;
            cardForumHeadLayout.setId(R.id.obfuscated_res_0x7f091ad4);
            this.b.setNeedShowForumlable(false);
            this.b.setJumpCallFrom(2);
            this.b.setBarNameIncludePadding(false);
            this.b.setBarThreadLineSpace(BdUtilHelper.getDimens(this.f.getContext(), R.dimen.tbds26));
            this.b.setAttentionLineSpace(BdUtilHelper.getDimens(this.f.getContext(), R.dimen.tbds26));
            int dimens = BdUtilHelper.getDimens(this.f.getContext(), R.dimen.M_W_X006);
            int dimens2 = BdUtilHelper.getDimens(this.f.getContext(), R.dimen.tbds16);
            int dimens3 = BdUtilHelper.getDimens(this.f.getContext(), R.dimen.tbds15);
            int dimens4 = BdUtilHelper.getDimens(this.f.getContext(), R.dimen.M_W_X007);
            int dimens5 = BdUtilHelper.getDimens(this.f.getContext(), R.dimen.M_H_X005);
            this.b.setPadding(dimens, dimens2, dimens, dimens3);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.leftMargin = dimens4;
            marginLayoutParams.rightMargin = dimens4;
            marginLayoutParams.bottomMargin = dimens5;
            this.b.setLayoutParams(marginLayoutParams);
            EMManager.from(this.b).setCorner(R.string.J_X05).setBackGroundRealColor(vca.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
            this.b.setAfterClickListener(new p(this));
        }
    }

    public final void c5() {
        PbFragment pbFragment;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048721, this) == null) && (pbFragment = this.f) != null && pbFragment.e0() != null && this.f.e0().G != null && this.f.e0().G.O() != null && this.f.e0().G.O().isXiuXiuThread()) {
            ThreadData O = this.f.e0().G.O();
            int i3 = 0;
            if (this.f.e0().X0()) {
                i2 = 1;
            } else if (this.f.e0().a1()) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            ItemInfo itemInfo = TbSingleton.getInstance().getFrsItemInfoCache().get(O.getForum_name());
            if (itemInfo != null) {
                i3 = itemInfo.id.intValue();
                str = itemInfo.name;
            } else {
                str = "";
            }
            new StatisticItem("c15062").addParam("obj_locate", i2).addParam("fid", O.getFid()).addParam("fname", O.getForum_name()).addParam("post_id", O.getTid()).addParam("obj_id", i3).addParam("obj_name", str).eventStat();
        }
    }

    public void f3() {
        PbLandscapeListView pbLandscapeListView;
        int i2;
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048732, this) != null) || (pbLandscapeListView = this.o) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.o1;
        int i4 = 0;
        if (this.o.getFirstVisiblePosition() != 0 && this.o.getFirstVisiblePosition() + headerViewsCount >= 0) {
            i2 = this.o.getFirstVisiblePosition() + headerViewsCount;
        } else {
            i2 = 0;
        }
        View childAt = this.o.getChildAt(0);
        if (childAt != null) {
            i3 = childAt.getTop();
        } else {
            i3 = -1;
        }
        this.h1.a = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.h1));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.h1.a;
        int z1 = z1(pbReplyTitleViewHolder);
        int measuredHeight = this.H.getMeasuredHeight() + ((int) this.H.getY());
        boolean z3 = true;
        if (this.a1.getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.H.getY() >= 0.0f) {
            z3 = false;
        }
        if ((z2 && pbReplyTitleViewHolder != null) || i2 >= this.I.J() + this.o.getHeaderViewsCount()) {
            if (pbReplyTitleViewHolder != null) {
                i4 = pbReplyTitleViewHolder.g.getMeasuredHeight();
            }
            if (z3) {
                this.o.setSelectionFromTop(this.I.J() + this.o.getHeaderViewsCount(), m2 - i4);
            } else {
                this.o.setSelectionFromTop(this.I.J() + this.o.getHeaderViewsCount(), this.k.j().getMeasuredHeight() - i4);
            }
        } else {
            this.o.setSelectionFromTop(i2, i3);
        }
        if (this.T0 != 9) {
            return;
        }
        this.o.setOnLayoutListener(new l(this, z1, pbReplyTitleViewHolder, z2, measuredHeight, i2, i3));
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048803, this) == null) {
            if (!this.f.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                xn9.u("c10517", this.o0, 2);
            } else if (!this.f.Q5()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                hf5 B6 = this.f.B6();
                if (B6 != null && (B6.z() || B6.B())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.f.B6().x(false, null);
                    return;
                }
                if (this.r0 != null) {
                    a2();
                }
                EditorTools editorTools = this.r0;
                if (editorTools != null) {
                    this.N0 = false;
                    if (editorTools.p(2) != null) {
                        aea.c(this.f.getPageContext(), (View) this.r0.p(2).m, false, v2);
                    }
                }
                J1();
            }
        }
    }

    public void O0(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.f.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.f;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f14be));
            } else if (z3) {
                if (ad.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e4f);
                }
                this.f.showToast(str);
            }
        }
    }

    public void W2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048688, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(o2, Integer.valueOf(p2));
            if (z2) {
                e4(sparseArray);
            } else {
                f4(i2, sparseArray);
            }
        }
    }

    public final void O4(int i2, int i3, boolean z2) {
        String str;
        AbilityConf abilityConf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048650, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            CallRobotEntrance callRobotEntrance = this.V1;
            String str2 = "";
            if (callRobotEntrance == null || (abilityConf = callRobotEntrance.ability_conf) == null) {
                str = "";
            } else {
                str = abilityConf.bot_uk;
            }
            String l2 = this.R0.l();
            if (this.R0.O() != null) {
                str2 = String.valueOf(this.R0.O().getTid());
            }
            CommonStatisticUtils.statisticFriendBotView(i2, str, i3, z2, l2, str2);
        }
    }

    public void Q2(AbsListView absListView, int i2, int i3, int i4) {
        PbListView pbListView;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048658, this, absListView, i2, i3, i4) == null) {
            dj9 dj9Var = this.u;
            if (dj9Var != null) {
                dj9Var.c(i2, i3);
            }
            dj9 dj9Var2 = this.t;
            if (dj9Var2 != null) {
                dj9Var2.c(i2, i3);
            }
            vi9 vi9Var = this.C;
            if (vi9Var != null) {
                vi9Var.l(i2, i3);
            }
            xm9 xm9Var = this.k;
            if (xm9Var != null && this.x != null) {
                xm9Var.q(absListView, i2, i3, i4);
            }
            c3();
            this.h1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.h1));
            j4(v2(absListView, i2));
            d3(this.h1.a, false);
            E0();
            if (this.O.q() && !this.O.D) {
                g1 g1Var = this.h1;
                if (g1Var != null && (pbReplyTitleViewHolder = g1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                    if (this.h1.a.getView().getTop() < 0) {
                        i5 = this.h1.a.getView().getHeight();
                    } else {
                        i5 = this.h1.a.getView().getBottom();
                    }
                } else {
                    i5 = 0;
                }
                this.O.f(i5);
                this.O.D = true;
            }
            if (i2 > this.c && (pbListView = this.O) != null && pbListView.i() != null) {
                hi6.f(this.O.i(), 0);
            }
        }
    }

    public void R2(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048663, this, absListView, i2) == null) {
            if (i2 == 0) {
                this.h1.a = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.h1));
                d3(this.h1.a, true);
                E0();
                this.I.m0(true);
            }
            this.I.l0();
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.P1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.p();
                }
                y0();
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.P1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.o();
                }
            } else if (i2 == 2 && (rightFloatLayerView = this.P1) != null) {
                rightFloatLayerView.q();
            }
        }
    }

    public final void g3(AgreeData agreeData, long j2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048736, this, agreeData, j2) == null) && agreeData != null && (textView = this.L0) != null) {
            if (j2 > 0) {
                if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                    textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.L0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
                this.L0.setText(R0(j2));
                this.L0.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public void S2(ArrayList<zw4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, arrayList) == null) {
            if (this.c0 == null) {
                this.c0 = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.f.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.c0);
            if (this.b0 == null) {
                Dialog dialog = new Dialog(this.f.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003c6);
                this.b0 = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.b0.setCancelable(true);
                this.q0 = (ScrollView) this.c0.findViewById(R.id.good_scroll);
                this.b0.setContentView(this.c0);
                WindowManager.LayoutParams attributes = this.b0.getWindow().getAttributes();
                attributes.width = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703f5);
                this.b0.getWindow().setAttributes(attributes);
                this.e0 = new k0(this);
                this.d0 = (LinearLayout) this.c0.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.c0.findViewById(R.id.dialog_button_cancel);
                this.g0 = textView;
                textView.setOnClickListener(new l0(this));
                TextView textView2 = (TextView) this.c0.findViewById(R.id.dialog_button_ok);
                this.f0 = textView2;
                textView2.setOnClickListener(this.f1093T);
            }
            this.d0.removeAllViews();
            this.q = new ArrayList();
            CustomBlueCheckRadioButton B0 = B0("0", this.f.getPageContext().getString(R.string.thread_good_class));
            this.q.add(B0);
            B0.setChecked(true);
            this.d0.addView(B0);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    zw4 zw4Var = arrayList.get(i2);
                    if (zw4Var != null && !TextUtils.isEmpty(zw4Var.b()) && zw4Var.a() > 0) {
                        CustomBlueCheckRadioButton B02 = B0(String.valueOf(zw4Var.a()), zw4Var.b());
                        this.q.add(B02);
                        View view2 = new View(this.f.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.d0.addView(view2);
                        this.d0.addView(B02);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.q0.getLayoutParams();
                int size = arrayList.size();
                if (size != 0 && size != 1) {
                    if (size != 2) {
                        layoutParams2.height = BdUtilHelper.dip2px(this.f.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = BdUtilHelper.dip2px(this.f.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = BdUtilHelper.dip2px(this.f.getPageContext().getPageActivity(), 120.0f);
                }
                this.q0.setLayoutParams(layoutParams2);
                this.q0.removeAllViews();
                LinearLayout linearLayout = this.d0;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.q0.addView(this.d0);
                }
            }
            hb.j(this.b0, this.f.getPageContext());
        }
    }

    public void T2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048673, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            U2(i2, str, i3, z2, null);
        }
    }

    public void j3(ye9 ye9Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048748, this, new Object[]{ye9Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            w4(ye9Var, z2, i2, i3);
            this.x.D(i3);
        }
    }

    public void U2(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048678, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            V2(i2, str, i3, z2, str2, false);
        }
    }

    public void V2(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048683, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
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
            this.Z = new hz4(this.f.getActivity());
            if (StringUtils.isNull(str2)) {
                this.Z.setMessageId(i4);
            } else {
                this.Z.setOnlyMessageShowCenter(false);
                this.Z.setMessage(str2);
            }
            this.Z.setYesButtonTag(sparseArray);
            this.Z.setPositiveButton(R.string.obfuscated_res_0x7f0f05a1, this.f);
            this.Z.setNegativeButton(R.string.obfuscated_res_0x7f0f0596, new c0(this));
            this.Z.setCancelable(true);
            this.Z.create(this.f.getPageContext());
            if (z3) {
                m4(sparseArray, i5, i4);
            } else if (z2) {
                m4(sparseArray, i5, i4);
            } else if (a4()) {
                hz5 hz5Var = new hz5(this.f.e0().s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f.e0().s1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.f.e0().s1().n().has_forum_rule.intValue());
                hz5Var.i(this.f.e0().s1().k().getId(), this.f.e0().s1().k().getName());
                hz5Var.h(this.f.e0().s1().k().getImage_url());
                hz5Var.j(this.f.e0().s1().k().getUser_level());
                t4(sparseArray, i2, hz5Var, this.f.e0().s1().V(), false);
            } else {
                B4(this.Z, i2);
            }
        }
    }

    public void V3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, str) == null) {
            this.B0.performClick();
            if (!StringUtils.isNull(str) && this.f.B6() != null && this.f.B6().t() != null && this.f.B6().t().j() != null) {
                EditText j2 = this.f.B6().t().j();
                j2.setText(str);
                j2.setSelection(str.length());
            }
        }
    }

    public final void Y1(ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048697, this, ye9Var) != null) || ye9Var == null || ye9Var.O() == null || !ye9Var.O().isInterviewLive() || this.Y0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.X0.inflate();
        this.Y0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.f1093T);
        this.Y0.setCallback(this.f.t6());
        this.Y0.setData(this.f, ye9Var);
    }

    public final int e1(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048726, this, i2)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return 0;
            }
            ph adapter2 = pbLandscapeListView.getAdapter2();
            if (adapter2 == null) {
                return i2;
            }
            if (i2 < adapter2.getCount() && i2 >= 0 && (adapter2.getItem(i2) instanceof oea)) {
                i2++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i2 > o3) {
                i2 = o3;
            }
            if (this.o.getAdapter2() != null && (this.o.getAdapter2() instanceof ph)) {
                i3 = this.o.getAdapter2().n();
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

    public void h4(ee9 ee9Var) {
        ye9 ye9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048741, this, ee9Var) == null) && (ye9Var = this.R0) != null && ye9Var.K() != null && !ListUtils.isEmpty(this.R0.K().robot_skill_info) && !ListUtils.isEmpty(this.R0.K().bottom_bar_robot_skill)) {
            jd9.a(this.J0, BotEntranceManager.e(this.R0.K().robot_skill_info, this.R0.K().bottom_bar_robot_skill), new r(this), ee9Var);
        }
    }

    public void u3(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048796, this, str) == null) && this.O != null) {
            int i2 = 0;
            g1 g1Var = this.h1;
            if (g1Var != null && (pbReplyTitleViewHolder = g1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                i2 = this.h1.a.getView().getTop() < 0 ? this.h1.a.getView().getHeight() : this.h1.a.getView().getBottom();
            }
            this.O.K(str, i2);
        }
    }

    public void z0(boolean z2) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048818, this, z2) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            int i4 = 0;
            if (pbLandscapeListView != null) {
                if (z2) {
                    SkinManager.setBackgroundColor(pbLandscapeListView, R.color.CAM_X0202);
                } else {
                    pbLandscapeListView.setBackgroundResource(0);
                }
            }
            View view2 = this.u0;
            if (view2 != null) {
                if (z2) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                view2.setVisibility(i3);
            }
            PbListView pbListView = this.O;
            if (pbListView != null) {
                if (z2) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                pbListView.O(i2);
            }
            View view3 = this.Q;
            if (view3 != null) {
                if (z2) {
                    i4 = 8;
                }
                view3.setVisibility(i4);
            }
        }
    }

    public void X2(SparseArray<Object> sparseArray, boolean z2) {
        int i2;
        nz4 nz4Var;
        nz4 nz4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048693, this, sparseArray, z2) == null) {
            rz4 rz4Var = new rz4(this.f.getContext());
            rz4Var.u(this.f.getString(R.string.obfuscated_res_0x7f0f0326));
            rz4Var.r(new b0(this, z2));
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
                    nz4Var2 = new nz4(10, this.f.getString(R.string.obfuscated_res_0x7f0f0560), rz4Var);
                } else {
                    nz4Var2 = new nz4(10, this.f.getString(R.string.obfuscated_res_0x7f0f0551), rz4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                nz4Var2.d.setTag(sparseArray2);
                arrayList.add(nz4Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                nz4 nz4Var3 = new nz4(13, this.f.getString(R.string.multi_delete), rz4Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                nz4Var3.d.setTag(sparseArray3);
                arrayList.add(nz4Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                nz4 nz4Var4 = new nz4(11, this.f.getString(R.string.forbidden_person), rz4Var);
                nz4Var4.d.setTag(sparseArray4);
                arrayList.add(nz4Var4);
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
                    nz4Var = new nz4(12, this.f.getString(R.string.un_mute), rz4Var);
                } else {
                    nz4Var = new nz4(12, this.f.getString(R.string.obfuscated_res_0x7f0f0d27), rz4Var);
                }
                nz4Var.d.setTag(sparseArray5);
                arrayList.add(nz4Var);
            }
            fm9.f(arrayList);
            rz4Var.n(arrayList, true);
            pz4 pz4Var = new pz4(this.f.getPageContext(), rz4Var);
            this.X = pz4Var;
            pz4Var.l();
        }
    }

    public final void d3(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        boolean z3;
        int measuredHeight;
        TbMixPlayerView tbMixPlayerView;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048724, this, pbReplyTitleViewHolder, z2) == null) && !this.p1 && this.a1 != null && this.k.j() != null) {
            View u3 = T0().u();
            if (u3 != null) {
                int[] iArr = new int[2];
                u3.getLocationInWindow(iArr);
                int i3 = iArr[1];
                if (i3 != 0) {
                    if (this.a1.getVisibility() == 0 && i3 - this.k.j().getBottom() <= this.a1.getHeight()) {
                        this.b1.setVisibility(0);
                        if (i3 > this.k.j().getBottom()) {
                            i2 = -(((this.a1.getHeight() + this.b1.getHeight()) + this.k.j().getBottom()) - u3.getBottom());
                        } else {
                            i2 = -this.a1.getHeight();
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a1.getLayoutParams();
                        if (layoutParams.topMargin != i2) {
                            layoutParams.topMargin = i2;
                            this.a1.setLayoutParams(layoutParams);
                        }
                    } else {
                        this.b1.setVisibility(4);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.a1.getLayoutParams();
                        if (layoutParams2.topMargin != 0) {
                            layoutParams2.topMargin = 0;
                            this.a1.setLayoutParams(layoutParams2);
                        }
                    }
                }
            }
            int J = this.I.J();
            if (J > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                PbLandscapeListView pbLandscapeListView = this.o;
                if (pbLandscapeListView != null && J > pbLandscapeListView.getFirstVisiblePosition() - this.o.getHeaderViewsCount()) {
                    this.a1.setVisibility(4);
                    return;
                }
                this.a1.setVisibility(0);
                j4(false);
                this.k.a.hideBottomLine();
                if (this.a1.getParent() != null && ((ViewGroup) this.a1.getParent()).getHeight() <= this.a1.getTop()) {
                    this.a1.getParent().requestLayout();
                }
            } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.getView() != null && pbReplyTitleViewHolder.g != null) {
                int top = pbReplyTitleViewHolder.getView().getTop();
                if (pbReplyTitleViewHolder.getView().getParent() != null) {
                    if (this.g1) {
                        this.f1 = top;
                        this.g1 = false;
                    }
                    int i4 = this.f1;
                    if (top < i4) {
                        i4 = top;
                    }
                    this.f1 = i4;
                }
                if (top == 0 && !pbReplyTitleViewHolder.getView().isShown()) {
                    return;
                }
                if (this.H.getY() < 0.0f) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    measuredHeight = m2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
                } else {
                    measuredHeight = this.k.j().getMeasuredHeight() - pbReplyTitleViewHolder.g.getMeasuredHeight();
                    if (h2() && (tbMixPlayerView = this.W1) != null) {
                        measuredHeight += tbMixPlayerView.getPlayerHeight();
                    }
                    this.k.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.f1) {
                    this.a1.setVisibility(0);
                    j4(false);
                } else if (top < measuredHeight) {
                    this.a1.setVisibility(0);
                    j4(false);
                } else {
                    this.a1.setVisibility(4);
                    this.k.a.hideBottomLine();
                }
                if (z2) {
                    this.g1 = true;
                }
            } else {
                PbLandscapeListView pbLandscapeListView2 = this.o;
                if (pbLandscapeListView2 != null && pbLandscapeListView2.getFirstVisiblePosition() == 0) {
                    this.a1.setVisibility(4);
                    this.k.a.hideBottomLine();
                }
            }
        }
    }

    public final void c2(ye9 ye9Var, y65 y65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048718, this, ye9Var, y65Var) == null) && this.Q1 != null && ye9Var != null && y65Var != null && this.f.getContext() != null) {
            if (!RightFloatLayerView.k()) {
                Q1();
                return;
            }
            if (this.P1 == null) {
                RightFloatLayerView E = RightFloatLayerLottieView.E(y65Var, this.f.getContext());
                this.P1 = E;
                E.setPageContext(this.f.getPageContext());
                this.Q1.removeAllViews();
                this.Q1.addView(this.P1);
            }
            if ((this.O1.getTag() instanceof Boolean) && !((Boolean) this.O1.getTag()).booleanValue()) {
                this.P1.setAutoCompleteShown(false);
                this.P1.setTag(this.O1);
                this.P1.c();
            }
            if (y65Var.a()) {
                return;
            }
            this.P1.setData(y65Var);
            this.P1.setLogoListener(new r0(this, y65Var));
            this.P1.setFeedBackListener(new b1(this, y65Var));
        }
    }

    public void g2(ye9 ye9Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, ye9Var) == null) {
            int i2 = 0;
            this.I.n0(ye9Var, false);
            this.I.f0();
            I0();
            yh9 yh9Var = this.y1;
            if (yh9Var != null) {
                yh9Var.m();
            }
            ArrayList<pea> F = ye9Var.F();
            if (ye9Var.y().b() == 0 || F == null || F.size() < ye9Var.y().e()) {
                if (t2(ye9Var)) {
                    g1 g1Var = this.h1;
                    if (g1Var != null && (pbReplyTitleViewHolder = g1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.h1.a.getView().getTop() < 0) {
                            bottom = this.h1.a.getView().getHeight();
                        } else {
                            bottom = this.h1.a.getView().getBottom();
                        }
                        i2 = bottom;
                    }
                    if (this.f.Z6()) {
                        this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1014), i2);
                    } else {
                        this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1015), i2);
                    }
                } else {
                    if (ye9Var.y().b() == 0) {
                        this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
                    } else {
                        this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.O.n();
                }
            }
            h3(ye9Var);
        }
    }

    public final void h3(ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048740, this, ye9Var) == null) && ye9Var != null && ye9Var.O() != null) {
            X4(ye9Var);
            ImageView imageView = this.F0;
            if (imageView != null && imageView.getContext() != null) {
                if (ye9Var.q()) {
                    WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
                } else {
                    WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            String S0 = S0(ye9Var.O().getReply_num());
            TextView textView = this.M0;
            if (textView != null) {
                textView.setText(S0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, ye9Var.O()));
            g3(ye9Var.O().getAgreeData(), ye9Var.O().getAgreeNum());
            if (this.E0 != null && ye9Var.O() != null) {
                this.E0.setThreadData(ye9Var.O());
                int i2 = 1;
                if (ye9Var.O().getAgreeData() != null) {
                    ye9Var.O().getAgreeData().isInThread = true;
                }
                this.E0.setData(ye9Var.O().getAgreeData());
                pv4 pv4Var = new pv4();
                pv4Var.b = 26;
                if (ye9Var.O().isVideoThreadType() && ye9Var.O().getThreadVideoInfo() != null) {
                    i2 = 2;
                }
                pv4Var.c = i2;
                PbFragment pbFragment = this.f;
                if (pbFragment != null && pbFragment.e0() != null) {
                    pv4Var.j = this.f.e0().getFromForumId();
                    pv4Var.f = this.f.e0().r1();
                }
                this.E0.setStatisticData(pv4Var);
            }
        }
    }

    public final void i4(ye9 ye9Var) {
        boolean z2;
        StyleContentInfo styleContentInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048745, this, ye9Var) == null) {
            if (ye9Var != null && ye9Var.K() != null) {
                RobotEntrance K = ye9Var.K();
                if (!ListUtils.isEmpty(K.robot_skill_info) && !ListUtils.isEmpty(K.bottom_bar_robot_skill)) {
                    if (!ListUtils.isEmpty(K.bottom_bar_robot_skill)) {
                        CallRobotEntrance c2 = BotEntranceManager.h().c(K.robot_skill_info, K.bottom_bar_robot_skill);
                        this.V1 = c2;
                        if (c2 == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        RobotSkillInfo d2 = BotEntranceManager.h().d(K.robot_skill_info, K.bottom_bar_robot_skill);
                        StyleContentInfo styleContentInfo2 = null;
                        if (z2) {
                            if (d2 != null) {
                                styleContentInfo2 = d2.style_day;
                                styleContentInfo = d2.style_dark;
                            }
                            styleContentInfo = null;
                        } else {
                            StyleConf styleConf = this.V1.style_conf;
                            if (styleConf != null) {
                                styleContentInfo2 = styleConf.day;
                                styleContentInfo = styleConf.dark;
                            }
                            styleContentInfo = null;
                        }
                        if (styleContentInfo2 != null && styleContentInfo != null) {
                            this.J0.setVisibility(0);
                            r0(this.J0);
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.F0.getLayoutParams();
                            layoutParams.removeRule(11);
                            layoutParams.addRule(0, R.id.obfuscated_res_0x7f091ae3);
                            this.F0.setLayoutParams(layoutParams);
                            this.J0.setClickCallBack(this.Z1);
                            this.J0.setCallRobotEntranceData(new dw4(this.V1, styleContentInfo2, styleContentInfo, z2));
                            return;
                        }
                        this.J0.setVisibility(8);
                        r0(this.F0);
                        return;
                    }
                    return;
                }
                this.J0.setVisibility(8);
                r0(this.F0);
                return;
            }
            this.J0.setVisibility(8);
            r0(this.F0);
        }
    }

    public void l4(ye9 ye9Var) {
        pea peaVar;
        xm9 xm9Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048757, this, ye9Var) == null) && ye9Var != null && (peaVar = this.S0) != null && peaVar.t() != null && (xm9Var = this.k) != null) {
            boolean z3 = !this.p1;
            this.q1 = z3;
            xm9Var.A(z3);
            if (this.f.C6() != null) {
                this.f.C6().s(this.q1);
            }
            e3();
            PbFragment pbFragment = this.f;
            if (pbFragment != null && !pbFragment.P0() && !ListUtils.isEmpty(ye9Var.o())) {
                ly4 ly4Var = ye9Var.o().get(0);
                if (ly4Var != null) {
                    this.k.D(ye9Var, ly4Var.d(), ly4Var.b(), ly4Var.a(), ly4Var.f());
                }
            } else if (ye9Var.k() != null) {
                xm9 xm9Var2 = this.k;
                String name = ye9Var.k().getName();
                String id = ye9Var.k().getId();
                String image_url = ye9Var.k().getImage_url();
                if (ye9Var.k().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                xm9Var2.D(ye9Var, name, id, image_url, z2);
            }
            if (this.q1) {
                this.x.R(ye9Var, this.S0, this.m0);
                View view2 = this.c1;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                if (this.z1 == null) {
                    this.z1 = new u0(this);
                }
                PbLandscapeListView pbLandscapeListView = this.o;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setListViewDragListener(this.z1);
                    return;
                }
                return;
            }
            View view3 = this.c1;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            this.x.R(ye9Var, this.S0, this.m0);
            this.z1 = null;
            PbLandscapeListView pbLandscapeListView2 = this.o;
            if (pbLandscapeListView2 != null) {
                pbLandscapeListView2.setListViewDragListener(null);
            }
        }
    }

    public void p4(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048773, this, view2) != null) || SharedPrefHelper.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.y0.getGlobalVisibleRect(rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        view2.getGlobalVisibleRect(rect);
        int i4 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.f.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.f.getContext());
        this.v1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f04d7);
        this.v1.setGravity(17);
        this.v1.setPadding(BdUtilHelper.getDimens(this.f.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, BdUtilHelper.getDimens(this.f.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = BdUtilHelper.getDimens(this.f.getContext(), R.dimen.obfuscated_res_0x7f070253);
        if (this.v1.getParent() == null) {
            frameLayout.addView(this.v1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.f.getContext());
        this.u1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.u1.setHeight(-2);
        this.u1.setWidth(-2);
        this.u1.setFocusable(true);
        this.u1.setOutsideTouchable(false);
        this.u1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        GreyUtil.grey(this.u1);
        PbLandscapeListView pbLandscapeListView = this.o;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.postDelayed(new z0(this, i4, i2, i3, view2), 100L);
        }
        SharedPrefHelper.getInstance().putBoolean("show_long_press_collection_tips", true);
    }

    public void z4(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048822, this, onItemClickListener) == null) {
            kz4 kz4Var = this.k0;
            if (kz4Var != null) {
                kz4Var.d();
                this.k0 = null;
            }
            if (this.R0 == null) {
                return;
            }
            ArrayList<tz4> arrayList = new ArrayList<>();
            String string = this.f.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.R0.J() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new tz4(string, "", z2, Integer.toString(1)));
            String string2 = this.f.getContext().getString(R.string.my_fans);
            if (this.R0.J() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new tz4(string2, "", z3, Integer.toString(5)));
            String string3 = this.f.getContext().getString(R.string.my_attentions);
            if (this.R0.J() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new tz4(string3, "", z4, Integer.toString(6)));
            String string4 = this.f.getContext().getString(R.string.myself_only);
            if (this.R0.J() == 4) {
                z5 = true;
            }
            arrayList.add(new tz4(string4, "", z5, Integer.toString(7)));
            kz4 kz4Var2 = new kz4(this.f.getPageContext());
            kz4Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.k0 = kz4Var2;
            kz4Var2.k(arrayList, onItemClickListener);
            kz4Var2.c();
            this.k0.n();
        }
    }

    public void i3(int i2, ye9 ye9Var, boolean z2, int i3) {
        pea X;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048744, this, new Object[]{Integer.valueOf(i2), ye9Var, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) && i2 > 0 && ye9Var != null && (X = ye9Var.X()) != null && X.t() != null) {
            MetaData t3 = X.t();
            t3.setGiftNum(t3.getGiftNum() + i2);
        }
    }

    public final void m4(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048761, this, sparseArray, i2, i3) != null) || this.f == null) {
            return;
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f0551, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03d2, TBAlertConfig.OperateBtnStyle.SECONDARY);
        AlertDialog show = new TBAlertBuilder(this.f.l0()).setTitle(i2).setDesc(i3).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new d0(this, show, sparseArray));
        operateBtnConfig2.setListener(new e0(this, show));
    }

    public final void s0(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048783, this, new Object[]{str, str2, Long.valueOf(j2)}) != null) || this.R0.O() == null) {
            return;
        }
        zd9.c();
        String c2 = hm9.c(this.R0.O().getFirstPostId(), TbadkCoreApplication.getCurrentPortrait(), System.currentTimeMillis());
        hm9.a(this.f.getPageContext(), str2, j2, this.R0.O().getTid(), this.R0.O().getFirstPostId(), c2, new t(this, str, c2));
    }

    public SparseArray<Object> n1(ye9 ye9Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        pea X;
        boolean z3;
        qw4 qw4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048762, this, new Object[]{ye9Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (ye9Var == null || (X = ye9Var.X()) == null) {
                return null;
            }
            String userId = X.t().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
            } else {
                z3 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, X.U());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(ye9Var.W()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (X.t() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, X.t().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, X.t().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, X.t().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, X.U());
                }
                sparseArray.put(R.id.tag_del_post_id, X.U());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(ye9Var.W()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<ly4> o3 = ye9Var.o();
                if (ListUtils.getCount(o3) > 0) {
                    sb = new StringBuilder();
                    for (ly4 ly4Var : o3) {
                        if (ly4Var != null && !StringUtils.isNull(ly4Var.d()) && (qw4Var = ly4Var.h) != null && qw4Var.a && !qw4Var.c && ((i3 = qw4Var.b) == 1 || i3 == 2)) {
                            sb.append(ad.cutString(ly4Var.d(), 12));
                            sb.append(this.f.getString(R.string.obfuscated_res_0x7f0f0785));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.f.getString(R.string.obfuscated_res_0x7f0f0549), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public final void t4(SparseArray<Object> sparseArray, int i2, hz5 hz5Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048792, this, new Object[]{sparseArray, Integer.valueOf(i2), hz5Var, userData, Boolean.valueOf(z2)}) != null) || (pbFragment = this.f) == null) {
            return;
        }
        if (this.F1 == null && this.v != null) {
            this.F1 = new iz5(pbFragment.getPageContext(), this.v.c(), hz5Var, userData);
        }
        this.F1.F(z2);
        AntiData n6 = this.f.n6();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (n6 != null && n6.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = n6.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
        negativeFeedBackData.setFeedBackReasonMap(sparseArray2);
        this.F1.H(new String[]{this.f.getString(R.string.delete_thread_reason_1), this.f.getString(R.string.delete_thread_reason_2), this.f.getString(R.string.delete_thread_reason_3), this.f.getString(R.string.delete_thread_reason_4), this.f.getString(R.string.delete_thread_reason_5)});
        this.F1.G(negativeFeedBackData);
        if (i2 != 1 && i2 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.F1.J(str);
        this.F1.I(new j0(this, sparseArray));
    }

    public void y4(iz4.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048817, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            pz4 pz4Var = this.i0;
            if (pz4Var != null) {
                pz4Var.dismiss();
                this.i0 = null;
            }
            rz4 rz4Var = new rz4(this.f.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new nz4(0, this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f04eb), rz4Var));
            }
            if (z3) {
                arrayList.add(new nz4(1, this.f.getPageContext().getString(R.string.report_text), rz4Var));
            } else if (!z2) {
                arrayList.add(new nz4(1, this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c69), rz4Var));
            } else {
                arrayList.add(new nz4(1, this.f.getPageContext().getString(R.string.remove_mark), rz4Var));
            }
            rz4Var.m(arrayList);
            rz4Var.r(new m0(this, cVar));
            pz4 pz4Var2 = new pz4(this.f.getPageContext(), rz4Var);
            this.j0 = pz4Var2;
            pz4Var2.l();
        }
    }

    public void v4(ye9 ye9Var, int i2, int i3, boolean z2, int i4, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        PbFragment pbFragment;
        int size;
        int i6;
        Parcelable e2;
        Parcelable e3;
        int size2;
        int i7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048802, this, new Object[]{ye9Var, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) && ye9Var != null && this.o != null) {
            this.R0 = ye9Var;
            this.T0 = i2;
            if (ye9Var.O() != null) {
                this.i1 = ye9Var.O().getCopyThreadRemindType();
                this.m0 = q2(ye9Var.O());
            }
            if (ye9Var.V() != null) {
                this.h2 = ye9Var.V().getUserId();
            }
            Y1(ye9Var);
            this.V0 = false;
            this.Q0 = z2;
            R3();
            jf9 jf9Var = ye9Var.h;
            if (jf9Var != null && jf9Var.b()) {
                if (this.r == null) {
                    PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f.getContext());
                    this.r = pbThreadPostView;
                    this.o.w(pbThreadPostView, 1);
                    this.r.setData(ye9Var);
                    this.r.setChildOnClickLinstener(this.f1093T);
                }
            } else {
                PbThreadPostView pbThreadPostView2 = this.r;
                if (pbThreadPostView2 != null && (pbLandscapeListView = this.o) != null) {
                    pbLandscapeListView.removeHeaderView(pbThreadPostView2);
                }
            }
            w4(ye9Var, z2, i2, TbadkCoreApplication.getInst().getSkinType());
            l4(ye9Var);
            this.x.S(ye9Var, this.S0);
            if (this.C1 == null) {
                this.C1 = new nj9(this.f.getPageContext(), this.D1);
            }
            this.C1.a(ye9Var.w());
            if (this.f.u6()) {
                if (this.N == null) {
                    po9 po9Var = new po9(this.f.getPageContext());
                    this.N = po9Var;
                    po9Var.f();
                    this.N.a(this.i2);
                }
                this.o.setPullRefresh(this.N);
                po9 po9Var2 = this.N;
                if (po9Var2 != null) {
                    po9Var2.D(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (ye9Var.y().c() == 0 && z2) {
                this.o.setPullRefresh(null);
            } else {
                if (this.N == null) {
                    po9 po9Var3 = new po9(this.f.getPageContext());
                    this.N = po9Var3;
                    po9Var3.f();
                    this.N.a(this.i2);
                }
                this.o.setPullRefresh(this.N);
                po9 po9Var4 = this.N;
                if (po9Var4 != null) {
                    po9Var4.D(TbadkCoreApplication.getInst().getSkinType());
                }
                N1();
            }
            I0();
            this.I.v0(this.Q0);
            this.I.s0(false);
            li9 li9Var = this.I;
            if (i2 == 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            li9Var.t0(z4);
            li9 li9Var2 = this.I;
            if (i2 == 6) {
                z5 = true;
            } else {
                z5 = false;
            }
            li9Var2.u0(z5);
            li9 li9Var3 = this.I;
            if (z3 && this.f2 && i2 != 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            li9Var3.q0(z6);
            this.I.n0(ye9Var, false);
            this.I.f0();
            li9 li9Var4 = this.I;
            if (ye9Var.y().b() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            li9Var4.h0(z7, ye9Var.f());
            this.x.Q(ye9Var.X(), ye9Var.j0());
            if (ye9Var.O() != null && ye9Var.O().getPraise() != null && this.e != -1) {
                ye9Var.O().getPraise().setIsLike(this.e);
            }
            this.o.removeFooterView(this.e1);
            this.o.addFooterView(this.e1);
            if (TbadkCoreApplication.isLogin()) {
                this.o.setNextPage(this.O);
                this.i = 2;
                N1();
            } else {
                this.V0 = true;
                if (ye9Var.y().b() == 1) {
                    if (this.P == null) {
                        PbFragment pbFragment2 = this.f;
                        this.P = new ko9(pbFragment2, pbFragment2);
                    }
                    this.o.setNextPage(this.P);
                } else {
                    this.o.setNextPage(this.O);
                }
                this.i = 3;
            }
            ArrayList<pea> F = ye9Var.F();
            if (ye9Var.y().b() != 0 && F != null && F.size() >= ye9Var.y().e()) {
                if (z3) {
                    if (this.f2) {
                        M0();
                        if (ye9Var.y().b() != 0) {
                            this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.O.D();
                        this.O.R();
                    }
                } else {
                    this.O.D();
                    this.O.R();
                }
                this.O.n();
            } else {
                if (t2(ye9Var)) {
                    g1 g1Var = this.h1;
                    if (g1Var != null && (pbReplyTitleViewHolder = g1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.h1.a.getView().getTop() < 0) {
                            i5 = this.h1.a.getView().getHeight();
                        } else {
                            i5 = this.h1.a.getView().getBottom();
                        }
                    } else {
                        i5 = 0;
                    }
                    if (this.f.Z6()) {
                        this.O.y(false);
                        if (ListUtils.isEmpty(ye9Var.R())) {
                            this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1014), i5);
                        }
                    } else if (ListUtils.isEmpty(ye9Var.R())) {
                        this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1015), i5);
                    }
                    if (this.f.C6() != null && !this.f.C6().p()) {
                        this.f.C6().x();
                    }
                } else {
                    if (ye9Var.y().b() == 0) {
                        pea peaVar = (pea) ListUtils.getItem(F, ListUtils.getCount(F) - 1);
                        if (peaVar != null) {
                            peaVar.P = false;
                        }
                        this.O.E(-UtilHelper.getDimenPixelSize(R.dimen.tbds32));
                        this.o.setClipChildren(false);
                        this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
                    } else {
                        this.O.E(0);
                        this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.O.n();
                }
                if (ye9Var.y().b() == 0 || F == null) {
                    l3();
                }
            }
            switch (i2) {
                case 2:
                    if (this.o.getData() == null && ye9Var.F() == null) {
                        size = 0;
                    } else {
                        size = (this.o.getData().size() - ye9Var.F().size()) + this.o.getHeaderViewsCount();
                    }
                    PbLandscapeListView pbLandscapeListView2 = this.o;
                    if (i3 > 1) {
                        i6 = (i3 + size) - 2;
                    } else {
                        i6 = 0;
                    }
                    pbLandscapeListView2.setSelection(i6);
                    break;
                case 3:
                    if (i4 == 1 && (e2 = uj9.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
                        this.o.post(new t0(this, e2, F, ye9Var));
                        break;
                    }
                    break;
                case 4:
                    this.f2 = false;
                    break;
                case 5:
                    this.o.setSelection(0);
                    break;
                case 6:
                case 9:
                    if (i4 == 1 && (e3 = uj9.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                        this.o.onRestoreInstanceState(e3);
                        break;
                    } else {
                        this.o.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i3 == 0) {
                        this.o.setSelection(this.I.D() + this.o.getHeaderViewsCount());
                    } else if (ListUtils.isEmpty(ye9Var.R())) {
                        if (this.o.getData() == null && ye9Var.F() == null) {
                            size2 = 0;
                        } else {
                            size2 = (this.o.getData().size() - ye9Var.F().size()) + this.o.getHeaderViewsCount();
                        }
                        PbLandscapeListView pbLandscapeListView3 = this.o;
                        if (i3 > 0) {
                            i7 = i3 + size2;
                        } else {
                            i7 = 0;
                        }
                        pbLandscapeListView3.setSelection(i7);
                    } else {
                        this.o.setSelection(ye9Var.F().size() + this.o.getHeaderViewsCount());
                    }
                    this.O.g();
                    this.O.H(this.f.getString(R.string.obfuscated_res_0x7f0f100e));
                    this.O.E(0);
                    this.O.B();
                    break;
            }
            if (this.i1 == n2 && n2()) {
                C0();
            }
            if (this.n1) {
                f3();
                this.n1 = false;
                if (i4 == 0) {
                    H3(true);
                }
            }
            if (ye9Var.d == 1 || ye9Var.e == 1) {
                if (this.t1 == null) {
                    this.t1 = new PbTopTipView(this.f.getContext());
                }
                if (ye9Var.e == 1 && "game_guide".equals(this.f.G6())) {
                    this.t1.setText(this.f.getString(R.string.obfuscated_res_0x7f0f1020));
                    this.t1.l(this.g, this.U0);
                } else if (ye9Var.d == 1 && "game_news".equals(this.f.G6())) {
                    this.t1.setText(this.f.getString(R.string.obfuscated_res_0x7f0f101f));
                    this.t1.l(this.g, this.U0);
                }
            }
            f2(ye9Var);
            int i8 = this.c;
            if (i8 == -1) {
                i8 = c1();
            }
            this.c = i8;
            this.o.removeFooterView(this.M1.a());
            if (!ListUtils.isEmpty(ye9Var.H()) && ye9Var.y().b() == 0) {
                this.o.removeFooterView(this.e1);
                this.M1.d(Math.max(this.y0.getMeasuredHeight(), this.O0 / 2));
                this.o.addFooterView(this.M1.a());
                this.M1.f(ye9Var);
            }
            h3(ye9Var);
            if (ye9Var.h0() && this.f.e0().k2() && this.f.D6() != null) {
                this.f.D6().d();
            }
            if (ye9Var.f() != 3) {
                d2(ye9Var);
            }
            this.B0.setText(TbSingleton.getInstance().getAdVertiComment(ye9Var.q0(), ye9Var.r0(), y1()));
            if (this.s != null) {
                ye9 ye9Var2 = this.R0;
                if (ye9Var2 != null && ye9Var2.k() != null && (pbFragment = this.f) != null && pbFragment.e0() != null) {
                    this.s.r(this.f.e0().b);
                }
                ye9 ye9Var3 = this.R0;
                if (ye9Var3 != null && ye9Var3.O() != null && !ListUtils.isEmpty(this.R0.O().getThreadRecommendInfoDataList()) && this.R0.O().getThreadRecommendInfoDataList().get(0) != null && this.R0.O().getThreadRecommendInfoDataList().get(0).businessType != 1) {
                    this.s.q(this.R0.O().getThreadRecommendInfoDataList().get(0));
                } else {
                    this.s.q(null);
                }
            }
            if (this.D != null && this.R0.k() != null) {
                this.D.o(this.R0.k().getSpritePBGuide(), this.R0.k().getImage_url(), this.R0.k().getId());
            }
            if (Z3()) {
                this.B.e(this.R0.O());
            } else {
                this.B.d(this.o);
            }
            i4(this.R0);
            c4();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void w4(ye9 ye9Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048807, this, new Object[]{ye9Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && ye9Var != null && ye9Var.O() != null) {
            PbFragment pbFragment = this.f;
            if (pbFragment != null && ck9.D(pbFragment)) {
                this.x.H(this.o);
                this.w.h(this.o);
            }
            if (this.f.P0()) {
                if (ye9Var.g() != null) {
                    this.n0 = ye9Var.g().d();
                    this.o0 = ye9Var.g().b();
                }
                if (this.n0 == null && this.f.e0() != null && this.f.e0().R0() != null) {
                    this.n0 = this.f.e0().R0();
                }
            }
            pea X = ye9Var.X();
            P3(X, ye9Var);
            int i4 = 8;
            this.x.N(8);
            int i5 = 1;
            if (ye9Var.x0()) {
                this.p1 = true;
                this.k.u(true);
                this.k.a.hideBottomLine();
            } else {
                this.p1 = false;
                this.k.u(false);
            }
            if (this.f.C6() != null) {
                this.f.C6().w(this.p1);
            }
            if (X == null) {
                return;
            }
            this.S0 = X;
            this.x.N(0);
            this.y.e(ye9Var, this.o);
            this.A.e(ye9Var, this.I1, new p0(this));
            this.w.j(ye9Var);
            this.v.h(ye9Var, this.Q0);
            this.v.g(ye9Var);
            this.x.O(this.U0, this.R0, X, this.g2);
            if (this.d1 != null) {
                if (ye9Var.j0()) {
                    this.d1.getView().setVisibility(8);
                } else {
                    this.d1.getView().setVisibility(0);
                    nf9 nf9Var = new nf9(nf9.g);
                    nf9Var.b = ye9Var.g;
                    nf9Var.c = this.f.Z6();
                    nf9Var.e = ye9Var.f;
                    nf9Var.f = ye9Var.O().isQuestionThread();
                    this.d1.i(nf9Var);
                }
            }
            I4(X);
            J4(ye9Var);
            SafeHandler.getInst().post(new q0(this));
            this.z.f(this.o);
            if (X.f1148T) {
                this.z.g(X.U());
                PbLandscapeListView pbLandscapeListView = this.o;
                this.z.c(this.o, (pbLandscapeListView == null || pbLandscapeListView.getHeaderViewsCount() <= 1) ? 0 : 0);
            }
            li9 li9Var = this.I;
            if (li9Var != null && li9Var.B() != null) {
                this.I.B().V(X.f1148T);
            }
            li9 li9Var2 = this.I;
            if (li9Var2 != null) {
                li9Var2.y0(X.f1148T);
            }
            MaskView maskView = this.N1;
            if (X.f1148T) {
                i4 = 0;
            }
            maskView.setVisibility(i4);
        }
    }

    public void x4(iz4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048812, this, cVar, z2) == null) {
            pz4 pz4Var = this.j0;
            if (pz4Var != null) {
                pz4Var.dismiss();
                this.j0 = null;
            }
            rz4 rz4Var = new rz4(this.f.getContext());
            ArrayList arrayList = new ArrayList();
            ye9 ye9Var = this.R0;
            if (ye9Var != null && ye9Var.O() != null && !this.R0.O().isBjh()) {
                arrayList.add(new nz4(0, this.f.getPageContext().getString(R.string.save_to_emotion), rz4Var));
            }
            if (!z2) {
                arrayList.add(new nz4(1, this.f.getPageContext().getString(R.string.save_to_local), rz4Var));
            }
            rz4Var.m(arrayList);
            rz4Var.r(new n0(this, cVar));
            pz4 pz4Var2 = new pz4(this.f.getPageContext(), rz4Var);
            this.j0 = pz4Var2;
            pz4Var2.l();
        }
    }

    public final void y2(CallRobotEntrance callRobotEntrance, boolean z2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048815, this, callRobotEntrance, z2) != null) || callRobotEntrance == null) {
            return;
        }
        AbilityConf abilityConf = callRobotEntrance.ability_conf;
        StyleConf styleConf = callRobotEntrance.style_conf;
        if (abilityConf == null) {
            return;
        }
        String str3 = abilityConf.skill_id + "=";
        if (styleConf != null && !TextUtils.isEmpty(styleConf.content)) {
            str3 = str3 + styleConf.content;
        }
        String str4 = str3;
        ThreadData threadData = null;
        ye9 ye9Var = this.R0;
        if (ye9Var == null) {
            str = "";
        } else {
            threadData = ye9Var.O();
            str = this.R0.l();
        }
        if (threadData == null) {
            str2 = "";
        } else {
            str2 = String.valueOf(threadData.getTid());
        }
        CommonStatisticUtils.statisticBotSkillMenu(2, abilityConf.bot_uk, 4, z2, str, str4, str2);
    }
}
