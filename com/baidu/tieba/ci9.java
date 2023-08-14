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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
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
import com.baidu.tieba.dba;
import com.baidu.tieba.dh9;
import com.baidu.tieba.ec9;
import com.baidu.tieba.gc9;
import com.baidu.tieba.i36;
import com.baidu.tieba.i95;
import com.baidu.tieba.l36;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.m45;
import com.baidu.tieba.n45;
import com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.pb.ejection.EjectionAnimationView;
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
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.vg9;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.tieba.w45;
import com.baidu.tieba.wi9;
import com.baidu.tieba.ye9;
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
public class ci9 {
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
    public static dba.f v2;
    public transient /* synthetic */ FieldHolder $fh;
    public wi9 A;
    public ImageView A0;
    public boolean A1;
    public PbContentCollectionController B;
    public TextView B0;
    public boolean B1;
    public vg9 C;
    public WaterRippleView C0;
    public nh9 C1;
    public tg9 D;
    public ImageView D0;
    public NavigationBarCoverTip D1;
    public LinearLayout E;
    public AgreeView E0;
    public i36 E1;
    public TextView F;
    public ImageView F0;
    public l36 F1;
    public TextView G;
    public ImageView G0;
    public String G1;
    public ObservedChangeRelativeLayout H;
    public HeadImageView H0;
    public PermissionJudgePolicy H1;
    public lg9 I;
    public View I0;
    public boolean I1;
    public m45 J;
    public FriendBotView J0;
    public int J1;
    public n45 K;
    public im9 K0;
    public int K1;
    public View L;
    public TextView L0;
    public boolean L1;
    public EditText M;
    public TextView M0;
    public boolean M1;
    public jm9 N;
    public boolean N0;
    public hm9 N1;
    public PbListView O;
    public int O0;
    public MaskView O1;
    public em9 P;
    public BlueCircleProgressDialog P0;
    public final PbFallingView P1;
    public View Q;
    public boolean Q0;
    public RightFloatLayerView Q1;
    public View R;
    public td9 R0;
    public final FrameLayout R1;
    public View S;
    public rba S0;
    public LinearLayout S1;

    /* renamed from: T  reason: collision with root package name */
    public View.OnClickListener f1092T;
    public int T0;
    public ck9 T1;
    public SortSwitchButton.f U;
    public int U0;
    public final Object U1;
    public TbRichTextView.z V;
    public boolean V0;
    public Runnable V1;
    public NoNetworkView.b W;
    public boolean W0;
    public CallRobotEntrance W1;
    public u45 X;
    public ViewStub X0;
    public CustomMessageListener X1;
    public View.OnClickListener Y;
    public PbInterviewStatusView Y0;
    public View.OnClickListener Y1;
    public m45 Z;
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
    public PbFragment.f3 e2;
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
    public u45 i0;
    public int i1;
    public i95.g i2;
    public final Handler j;
    public u45 j0;
    public int j1;
    public View.OnClickListener j2;
    public final rk9 k;
    public p45 k0;
    public Runnable k1;
    public final List<TbImageView> k2;
    public qk9 l;
    public boolean l0;
    public PbFakeFloorModel l1;
    public boolean l2;
    public ViewStub m;
    public boolean m0;
    public ah9 m1;
    public ViewStub n;
    public String n0;
    public boolean n1;
    public PbLandscapeListView o;
    public String o0;
    public int o1;
    public NoNetworkView p;
    public af9 p0;
    public boolean p1;
    public List<CustomBlueCheckRadioButton> q;
    public ScrollView q0;
    public boolean q1;
    public PbThreadPostView r;
    public EditorTools r0;
    public boolean r1;
    public yh9 s;
    public boolean s0;
    public int s1;
    public dh9 t;
    public View t0;
    public PbTopTipView t1;
    public dh9 u;
    public View u0;
    public PopupWindow u1;
    public xi9 v;
    public EjectionAnimationView v0;
    public TextView v1;
    public zi9 w;
    public Button w0;
    public List<String> w1;
    public bj9 x;
    public View x0;
    public fj9 x1;
    public yi9 y;
    public View y0;
    public yf9 y1;
    public aj9 z;
    public LinearLayout z0;
    public PbLandscapeListView.c z1;

    public boolean C2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    public int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? R.id.obfuscated_res_0x7f091a8f : invokeV.intValue;
    }

    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048811, this)) == null) ? R.id.obfuscated_res_0x7f091f04 : invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class b implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        /* loaded from: classes5.dex */
        public class a implements ih5 {
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

            @Override // com.baidu.tieba.ih5
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

        public b(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.U3();
            kh5.g().c(new a(this));
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.g3();
            this.a.v0.l();
        }
    }

    /* loaded from: classes5.dex */
    public class i implements dh9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ ci9 b;

        /* loaded from: classes5.dex */
        public class a implements zc9 {
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

            @Override // com.baidu.tieba.zc9
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

            @Override // com.baidu.tieba.zc9
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

        public i(ci9 ci9Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci9Var;
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.dh9.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (YunDialogManager.isShowingDialog()) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("BotGuideManager", "底bar点击引导未展示,云弹窗正在展示：" + YunDialogManager.getShowingDialog());
                } else if (cd9.c()) {
                    DefaultLog.getInstance().e("BotGuideManager", "底bar点击引导未展示,BotGuideManager在展示其他");
                } else {
                    long j = SharedPrefHelper.getInstance().getLong("pb_friend_bot_bottom_click_last_time", 0L);
                    if (!DateUtils.isToday(j) && !this.b.U2()) {
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
                                cd9.e(str, this.b.J0, this.a.Y(), new a(this, str));
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
                    defaultLog4.e("BotGuideManager", "底bar点击引导未展示,当天已经展示过了：" + DateUtils.isToday(j) + "，话题在展示：" + this.b.U2());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements dh9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.s != null && this.a.a.f.Y() != null) {
                    c55.g(Collections.singletonList(new zh9(this.a.a.f.Y(), this.a.a.s)));
                }
            }
        }

        public j(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // com.baidu.tieba.dh9.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.W0 && !this.a.f.A6() && this.a.o != null) {
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
        public final /* synthetic */ ci9 g;

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

        public l(ci9 ci9Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ci9Var;
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
                    int y1 = this.g.y1(this.b);
                    int i3 = this.a;
                    int i4 = y1 - i3;
                    if (this.c && i4 != 0 && i3 <= (i = this.d)) {
                        i4 = y1 - i;
                    }
                    if (this.g.e1 == null || (layoutParams = this.g.e1.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 != 0 && i4 <= this.g.g.getMeasuredHeight() && y1 < this.g.g.getMeasuredHeight()) {
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
    public class n implements vg9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.D != null && this.b.a.f.Y() != null) {
                    this.b.a.D.q(this.a);
                    c55.g(Collections.singletonList(new wg9(this.b.a.f.Y(), this.b.a.D)));
                }
            }
        }

        public n(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // com.baidu.tieba.vg9.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && !this.a.f.A6() && !this.a.d && this.a.o != null) {
                this.a.o.post(new a(this, i));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

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

        public w0(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
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
    public class a implements se9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        @Override // com.baidu.tieba.se9
        public /* synthetic */ void onStart() {
            re9.a(this);
        }

        public a(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // com.baidu.tieba.se9
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
        public final /* synthetic */ ci9 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public a0(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.a.f.M0 != null && this.a.f.M0.e() != null) {
                if (!this.a.f.M0.e().e()) {
                    this.a.f.M0.a(false);
                }
                this.a.f.M0.e().l(false);
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
                    ci9 ci9Var = this.a;
                    ci9Var.x1 = new fj9(ci9Var.f.getPageContext(), this.a.g, layoutParams);
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
    public class a1 implements PbFallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public a1(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.q
        public void onClick() {
            String x1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null && this.a.f.R() != null && this.a.f.R().c2()) {
                    x1 = this.a.f.getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    x1 = this.a.x1();
                }
                if (!StringUtils.isNull(x1) && this.a.R0 != null) {
                    x1 = TbSingleton.getInstance().getAdVertiComment(this.a.R0.q0(), this.a.R0.r0(), x1);
                }
                if (this.a.f != null && this.a.f.J5() != null) {
                    this.a.f.J5().d0(x1);
                }
                if (this.a.B0 != null) {
                    this.a.B0.setText(x1);
                }
                this.a.c4(false);
                this.a.w4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements w45.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ci9 b;

        public b0(ci9 ci9Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci9Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.w45.f
        public void K0(w45 w45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, w45Var, i, view2) == null) {
                this.b.X.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.N2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.e2 != null) {
                            this.b.e2.callback(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.f.S5(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        this.b.S4(true);
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
        public final /* synthetic */ vb5 a;
        public final /* synthetic */ ci9 b;

        public b1(ci9 ci9Var, vb5 vb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, vb5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci9Var;
            this.a = vb5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.Q1.setHomePbFloatLastCloseTime();
                this.b.N1();
                this.b.Q1.t(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public c(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.E0 != null && this.a.E0.getData() != null) {
                ci9 ci9Var = this.a;
                ci9Var.a3(ci9Var.E0.getData(), this.a.E0.getData().agreeNum);
                if (!this.a.E0.K()) {
                    ci9 ci9Var2 = this.a;
                    ci9Var2.T2(ci9Var2.E0);
                }
                if (this.a.R0 != null && this.a.R0.O() != null && this.a.R0.O().isExcellentThread() && BreatheTipWidget.f()) {
                    jf5.a("c15279", this.a.R0.Q(), this.a.R0.l(), "1");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c1 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ ci9 b;

        public c1(ci9 ci9Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci9Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.b.L1 && this.a != null && this.b.f.R() != null && this.b.f.R().g2()) {
                    this.b.L1 = true;
                    this.a.a5(false);
                }
                if (this.b.M1) {
                    return;
                }
                this.b.M1 = true;
                if (this.b.k2() && this.b.B != null) {
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
        public final /* synthetic */ ci9 a;

        public d(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.I0.getVisibility() == 0) {
                    if (this.a.f != null && this.a.f.I1()) {
                        return;
                    }
                    SharedPrefHelper.getInstance().putBoolean("pb_share_red_dot_shown", true);
                    this.a.I0.setVisibility(8);
                }
                this.a.f1092T.onClick(view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ ci9 c;

        public d0(ci9 ci9Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ci9Var;
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
                    BdUtilHelper.showToast(this.c.f.Y(), (int) R.string.obfuscated_res_0x7f0f0e21);
                } else {
                    this.c.f.m5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements ye9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public d1(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // com.baidu.tieba.ye9.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f.V5();
            }
        }

        @Override // com.baidu.tieba.ye9.b
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
        public final /* synthetic */ ci9 a;

        public e(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
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
                    this.a.f.c5(sparseArray);
                    return;
                }
                this.a.S2(view2);
            } else if (z2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.a.f.c5(sparseArray);
            } else if (z3) {
                this.a.N2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public e0(ci9 ci9Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, alertDialog};
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
        public final /* synthetic */ qj5 b;
        public final /* synthetic */ ci9 c;

        public e1(ci9 ci9Var, ReplyPrivacyCheckController replyPrivacyCheckController, qj5 qj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, replyPrivacyCheckController, qj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ci9Var;
            this.a = replyPrivacyCheckController;
            this.b = qj5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null && this.c.f != null && this.c.f.t5() != null && !this.a.checkPrivacyBeforeInvokeEditor(this.c.f.t5().replyPrivateFlag)) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.f.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                }
                this.c.N4();
                this.b.o0();
                this.c.K0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public f(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ ci9 c;

        public f0(ci9 ci9Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ci9Var;
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
                    BdUtilHelper.showToast(this.c.f.Y(), (int) R.string.obfuscated_res_0x7f0f0e21);
                } else {
                    this.c.f.m5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public f1(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.H2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public g(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(rba rbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, rbaVar) == null) {
                this.a.l1.e0(rbaVar);
                this.a.I.f0();
                this.a.m1.g();
                this.a.r0.t();
                this.a.c4(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g0 implements dba.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.dba.f
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
        public final /* synthetic */ ci9 a;

        public h(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.w4();
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
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

    /* loaded from: classes5.dex */
    public class h0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public h0(ci9 ci9Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, alertDialog};
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
    public class i0 implements i36.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m45 a;
        public final /* synthetic */ ci9 b;

        public i0(ci9 ci9Var, m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, m45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci9Var;
            this.a = m45Var;
        }

        @Override // com.baidu.tieba.i36.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.f.n5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements l36.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ ci9 b;

        public j0(ci9 ci9Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci9Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.l36.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.f.m5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ci9 ci9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, Integer.valueOf(i)};
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
            this.a = ci9Var;
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
        public final /* synthetic */ ci9 a;

        public k0(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
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
        public final /* synthetic */ ci9 a;

        public l0(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.b0 instanceof Dialog)) {
                jg.b(this.a.b0, this.a.f.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements gc9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public m(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // com.baidu.tieba.gc9.a
        public void a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (this.a.f != null && this.a.f.R() != null) {
                    this.a.f.R().o3();
                }
                if (this.a.W1 != null) {
                    this.a.J0.k(this.a.W1);
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07ef);
                }
                bk9.d(str, str2, str3, 3);
                this.a.I.f0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements w45.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n45.c a;
        public final /* synthetic */ ci9 b;

        public m0(ci9 ci9Var, n45.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci9Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.w45.f
        public void K0(w45 w45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, w45Var, i, view2) == null) {
                this.b.j0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements w45.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n45.c a;
        public final /* synthetic */ ci9 b;

        public n0(ci9 ci9Var, n45.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci9Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.w45.f
        public void K0(w45 w45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, w45Var, i, view2) == null) {
                this.b.j0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public o(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.I0.getVisibility() == 0) {
                    SharedPrefHelper.getInstance().putBoolean("pb_share_red_dot_shown", true);
                    this.a.I0.setVisibility(8);
                }
                this.a.f1092T.onClick(this.a.G0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public o0(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
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
                if (this.a.f.Y() != null) {
                    this.a.f.Y().c.b.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
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
    public class p0 implements wi9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public p0(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // com.baidu.tieba.wi9.a
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
        public final /* synthetic */ ci9 a;

        public q(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // com.baidu.tbadk.core.view.FriendBotView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.G4(3, 4, z);
            this.a.Y3();
        }

        @Override // com.baidu.tbadk.core.view.FriendBotView.f
        public void b(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) != null) || kv5.a()) {
                return;
            }
            this.a.G4(2, 4, z);
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.a.f.getContext());
            } else if (z2) {
                this.a.Y3();
            } else if (!z) {
                if (this.a.W1.ability_conf == null) {
                    return;
                }
                ci9 ci9Var = this.a;
                ci9Var.s0(str, ci9Var.W1.ability_conf.bot_uk, this.a.W1.ability_conf.skill_id.intValue());
            } else {
                bk9.e(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public q0(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ci9 ci9Var;
            rk9 rk9Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.I != null && (rk9Var = (ci9Var = this.a).k) != null && rk9Var.k != null && ci9Var.R0 != null && this.a.R0.O() != null && !this.a.R0.O().isVideoThreadType() && !this.a.n2() && this.a.R0.k() != null && !bi.isEmpty(this.a.R0.k().getName())) {
                if ((this.a.I.L() == null || !this.a.I.L().isShown()) && (linearLayout = this.a.k.k) != null) {
                    linearLayout.setVisibility(0);
                    this.a.k.h();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements ec9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public r(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // com.baidu.tieba.ec9.b
        public void a(@NonNull CallRobotEntrance callRobotEntrance) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, callRobotEntrance) != null) || this.a.J0 == null) {
                return;
            }
            boolean o = this.a.J0.o();
            this.a.s2(callRobotEntrance, o);
            if (o) {
                bk9.e(this.a.J0.getLoadingToast());
                return;
            }
            AbilityConf abilityConf = callRobotEntrance.ability_conf;
            if (abilityConf == null) {
                return;
            }
            BotEntranceManager.h().m(abilityConf.bot_uk, abilityConf.skill_id.intValue());
            this.a.W1 = callRobotEntrance;
            StyleConf styleConf = callRobotEntrance.style_conf;
            if (styleConf != null) {
                this.a.J0.setCallRobotEntranceData(new k15(callRobotEntrance, styleConf.day, styleConf.dark, false));
            }
            this.a.O4();
            ci9 ci9Var = this.a;
            ci9Var.s0(ci9Var.J0.getLoadingToast(), abilityConf.bot_uk, abilityConf.skill_id.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vb5 a;
        public final /* synthetic */ ci9 b;

        public r0(ci9 ci9Var, vb5 vb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, vb5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci9Var;
            this.a = vb5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.R0 != null && this.b.Q1 != null) {
                this.b.Q1.g(this.a);
                this.b.Q1.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements zc9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ci9 b;

        public s(ci9 ci9Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci9Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.zc9
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

        @Override // com.baidu.tieba.zc9
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
        public final /* synthetic */ ci9 b;

        public s0(ci9 ci9Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci9Var;
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
                this.b.f.showToast(R.string.obfuscated_res_0x7f0f0e21);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ci9 d;

        public t(ci9 ci9Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ci9Var;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                if (this.d.f == null) {
                    return;
                }
                this.d.f.showToast(str);
                if (this.d.f.R() != null) {
                    this.d.f.R().o3();
                }
                if (this.d.f.M5().T0() != null) {
                    this.d.f.M5().T0().f0();
                }
                if (this.d.J0 != null && this.d.W1 != null) {
                    this.d.J0.k(this.d.W1);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                super.e(r5);
                bk9.e(this.b);
                bk9.b(this.d.f.R(), this.c);
                if (this.d.V1 != null) {
                    SafeHandler.getInst().removeCallbacks(this.d.V1);
                }
                ci9 ci9Var = this.d;
                ci9Var.V1 = new hc9(this.c, ci9Var.f);
                SafeHandler.getInst().postDelayed(this.d.V1, 30000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ td9 c;
        public final /* synthetic */ ci9 d;

        public t0(ci9 ci9Var, Parcelable parcelable, ArrayList arrayList, td9 td9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, parcelable, arrayList, td9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ci9Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = td9Var;
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
                    this.d.O.H(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fde));
                    this.d.O.B();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements PbFirstFloorDoubleClickAnimation.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public u(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0.X();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public u0(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.f != null && this.a.f.isAdded()) {
                if (i < 0 && f > this.a.s1) {
                    this.a.F0();
                    this.a.D2();
                }
                this.a.N0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(ci9 ci9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, Integer.valueOf(i)};
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
            this.a = ci9Var;
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
    public class v0 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public v0(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.a.F0();
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public w(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.E == null) {
                    this.a.W1();
                }
                this.a.n.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(ci9 ci9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, Integer.valueOf(i)};
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
            this.a = ci9Var;
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
    public class x0 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public x0(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public y(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y0 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public y0(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z implements mh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci9 a;

        public z(ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci9Var;
        }

        @Override // com.baidu.tieba.mh5
        public void B(lh5 lh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lh5Var) == null) {
                Object obj = lh5Var.c;
                if ((obj instanceof nc5) && EmotionGroupType.isSendAsPic(((nc5) obj).getType())) {
                    if (this.a.H1 == null) {
                        this.a.H1 = new PermissionJudgePolicy();
                    }
                    this.a.H1.clearRequestPermissionList();
                    this.a.H1.appendRequestPermission(this.a.f.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.H1.startRequestPermission(this.a.f.getBaseFragmentActivity())) {
                        return;
                    }
                    nc5 nc5Var = (nc5) lh5Var.c;
                    this.a.f.J5().f(nc5Var);
                    if (nc5Var.i()) {
                        this.a.f.J5().H(null, null);
                    } else {
                        this.a.f.J5().w(false, null);
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
        public final /* synthetic */ ci9 e;

        public z0(ci9 ci9Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ci9Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947675862, "Lcom/baidu/tieba/ci9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947675862, "Lcom/baidu/tieba/ci9;");
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

    public void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            J4();
            this.I.g0(1);
            yh9 yh9Var = this.s;
            if (yh9Var != null) {
                yh9Var.j();
            }
            tg9 tg9Var = this.D;
            if (tg9Var != null) {
                tg9Var.g();
            }
            vg9 vg9Var = this.C;
            if (vg9Var != null) {
                vg9Var.j();
            }
            RightFloatLayerView rightFloatLayerView = this.Q1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public rba a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            if (this.o == null) {
                return null;
            }
            int Z0 = Z0() - this.o.getHeaderViewsCount();
            int i2 = 0;
            if (Z0 < 0) {
                Z0 = 0;
            }
            if (this.I.A(Z0) != null && this.I.A(Z0) != rba.V0) {
                i2 = Z0 + 1;
            }
            if (!(this.I.z(i2) instanceof rba)) {
                return null;
            }
            return (rba) this.I.z(i2);
        }
        return (rba) invokeV.objValue;
    }

    public final int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null && pbLandscapeListView.getData() != null) {
                for (int i2 = 0; i2 < this.o.getData().size(); i2++) {
                    ym ymVar = this.o.getData().get(i2);
                    if (ymVar != null && ymVar.getType() == vd9.k) {
                        return i2 + this.o.getHeaderViewsCount();
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            if (S3()) {
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

    public void l3() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048748, this) == null) && (pbListView = this.O) != null && pbListView.i() != null) {
            LinearLayout i2 = this.O.i();
            View findViewById = i2.findViewById(R.id.obfuscated_res_0x7f091a82);
            if (i2.getVisibility() == 0 && findViewById != null && findViewById.getVisibility() == 0) {
                this.d = true;
                TiebaStatic.log(new StatisticItem("c15304").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    public void s4() {
        rba rbaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048779, this) != null) || !TbadkCoreApplication.isLogin() || this.R0 == null || !this.q1 || this.p1 || this.m0 || (rbaVar = this.S0) == null || rbaVar.r() == null || this.S0.r().getIsLike() || this.S0.r().hadConcerned()) {
        }
    }

    public ci9(PbFragment pbFragment, View.OnClickListener onClickListener, af9 af9Var, SortSwitchButton.f fVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, af9Var, fVar};
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
        this.f1092T = null;
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
        this.K1 = 0;
        this.U1 = new Object();
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
        this.f1092T = onClickListener;
        this.U = fVar;
        this.p0 = af9Var;
        this.s1 = BdUtilHelper.getEquipmentWidth(this.f.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0700, (ViewGroup) null);
        this.g = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.t0 = this.g.findViewById(R.id.obfuscated_res_0x7f09047a);
        this.D1 = (NavigationBarCoverTip) this.g.findViewById(R.id.obfuscated_res_0x7f091aff);
        this.h = this.g.findViewById(R.id.obfuscated_res_0x7f0922b2);
        this.R1 = (FrameLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091f27);
        this.H = (ObservedChangeRelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f092597);
        this.p = (NoNetworkView) this.g.findViewById(R.id.view_no_network);
        PbLandscapeListView pbLandscapeListView = (PbLandscapeListView) this.g.findViewById(R.id.obfuscated_res_0x7f091919);
        this.o = pbLandscapeListView;
        pbLandscapeListView.setDividerHeight(0);
        this.Z0 = new TextView(this.f.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + BdUtilHelper.getDimens(this.f.getActivity(), R.dimen.obfuscated_res_0x7f070420));
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
        this.k = new rk9(pbFragment, this.g);
        if (this.f.C5()) {
            ViewStub viewStub = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f0916ca);
            this.m = viewStub;
            viewStub.setVisibility(0);
            qk9 qk9Var = new qk9(pbFragment);
            this.l = qk9Var;
            qk9Var.c();
            this.k.a.setVisibility(8);
            layoutParams.height = BdUtilHelper.getDimens(this.f.getActivity(), R.dimen.obfuscated_res_0x7f070364);
        }
        this.Z0.setLayoutParams(layoutParams);
        this.k.j().setOnTouchListener(new ye9(new d1(this)));
        this.x0 = this.g.findViewById(R.id.obfuscated_res_0x7f092937);
        this.y0 = this.g.findViewById(R.id.obfuscated_res_0x7f091a93);
        this.O0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703a2);
        this.A0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f09098f);
        this.A0.setOnClickListener(new e1(this, new ReplyPrivacyCheckController(this.f.getPageContext()), this.f.J5()));
        L0();
        this.B0 = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091a96);
        LinearLayout linearLayout = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091a8d);
        this.z0 = linearLayout;
        linearLayout.setOnClickListener(new f1(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.g.findViewById(R.id.obfuscated_res_0x7f090993);
        this.v0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new a(this));
        this.D0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091a94);
        this.O1 = (MaskView) this.g.findViewById(R.id.mask_view);
        this.D0.setOnClickListener(this.f1092T);
        AgreeView agreeView = (AgreeView) this.g.findViewById(R.id.obfuscated_res_0x7f091a8f);
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
        ImageView imageView = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091a92);
        this.F0 = imageView;
        imageView.setOnClickListener(this.f1092T);
        if (booleanExtra) {
            this.F0.setVisibility(8);
        } else {
            this.F0.setVisibility(0);
        }
        Q1();
        View findViewById = this.g.findViewById(R.id.obfuscated_res_0x7f091a99);
        this.I0 = findViewById;
        if (!SharedPrefHelper.getInstance().getBoolean("pb_share_red_dot_shown", false) && TbadkCoreApplication.isLogin()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        findViewById.setVisibility(i2);
        this.G0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091a97);
        HeadImageView headImageView = (HeadImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091a98);
        this.H0 = headImageView;
        headImageView.setIsRound(true);
        this.H0.setOnClickListener(this.Y1);
        this.G0.setOnClickListener(new d(this));
        v2();
        im9 im9Var = new im9(this.G0);
        this.K0 = im9Var;
        im9Var.m(this.H0);
        TextView textView = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091a95);
        this.M0 = textView;
        textView.setVisibility(0);
        this.L0 = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091a90);
        this.X0 = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f091174);
        this.E0.setVisibility(0);
        this.L0.setVisibility(0);
        this.v = new xi9(this.f, af9Var);
        this.x = new bj9(this.f, af9Var, this.f1092T);
        lg9 lg9Var = new lg9(this.f, this.o);
        this.I = lg9Var;
        lg9Var.E0(this.f1092T);
        this.I.H0(this.p0);
        this.I.B0(this.V);
        this.I.D0(this.U);
        this.I.x0(this.j2);
        e eVar = new e(this);
        this.Y = eVar;
        this.I.z0(eVar);
        b2();
        U1();
        aj9 aj9Var = new aj9(this.f);
        this.z = aj9Var;
        aj9Var.f = 2;
        T1();
        R1();
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
            view2.setOnClickListener(this.f1092T);
            SkinManager.setBackgroundResource(this.Q, R.drawable.pb_foot_more_trans_selector);
        }
        View view3 = this.R;
        if (view3 != null) {
            view3.setOnClickListener(this.f1092T);
        }
        this.O.D();
        this.O.r(R.drawable.pb_foot_more_trans_selector);
        this.O.F(R.color.CAM_X0109);
        this.O.s(R.drawable.pb_foot_more_trans_selector);
        this.S = this.g.findViewById(R.id.obfuscated_res_0x7f09296f);
        this.f.registerListener(this.d2);
        this.l1 = new PbFakeFloorModel(this.f.getPageContext());
        PbModel R = this.f.R();
        this.l1.g0(R.W(), R.S(), R.T(), R.R(), R.X());
        ah9 ah9Var = new ah9(this.f.getPageContext(), this.l1, this.g);
        this.m1 = ah9Var;
        ah9Var.p(new f(this));
        this.m1.s(this.f.o2);
        this.l1.i0(new g(this));
        if (this.f.R() != null && !StringUtils.isNull(this.f.R().v1())) {
            PbFragment pbFragment2 = this.f;
            pbFragment2.showToast(pbFragment2.R().v1());
        }
        this.a1 = this.g.findViewById(R.id.obfuscated_res_0x7f091a9b);
        this.b1 = this.g.findViewById(R.id.obfuscated_res_0x7f090478);
        View findViewById2 = this.g.findViewById(R.id.obfuscated_res_0x7f0922be);
        this.c1 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.f.R() != null && this.f.R().e1()) {
            this.a1.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.c1.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = m2;
            this.c1.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f.getPageContext(), this.g.findViewById(R.id.obfuscated_res_0x7f091b1f));
        this.d1 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.t(pbFragment.d0);
        this.d1.g.setVisibility(8);
        this.d1.s(this.f1092T);
        this.d1.r(this.U);
        this.f.registerListener(this.a2);
        PbFragment pbFragment3 = this.f;
        this.N1 = new hm9(pbFragment3, pbFragment3.getUniqueId());
        this.P1 = (PbFallingView) this.g.findViewById(R.id.obfuscated_res_0x7f090ae4);
        p3();
        this.P1.setAnimationListener(new h(this));
        A0();
        this.u0 = this.g.findViewById(R.id.obfuscated_res_0x7f091a83);
        z0(YoungsterVerifyUtils.isYoungsterOpen());
        this.s = new yh9(this.f.Y(), (ViewGroup) E1().findViewById(R.id.obfuscated_res_0x7f091b32));
        dh9 dh9Var = new dh9(this.o, -2);
        this.u = dh9Var;
        dh9Var.d(new i(this, pbFragment));
        dh9 dh9Var2 = new dh9(this.o, 5);
        this.t = dh9Var2;
        dh9Var2.d(new j(this));
        this.S1 = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0927fb);
        this.T1 = new ck9(this.f.getActivity());
        Y1();
        sr6.b().a(this.U1, new gc9(new m(this)));
    }

    public void A3(String str) {
        qk9 qk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (qk9Var = this.l) != null) {
            qk9Var.b(str);
        }
    }

    public final void A4(rba rbaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, rbaVar) == null) && rbaVar != null) {
            this.B1 = !StringUtils.isNull(rbaVar.f0());
            bj9 bj9Var = this.x;
            if (bj9Var != null) {
                bj9Var.t(rbaVar);
            }
        }
    }

    public void B3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2) == null) {
            this.n1 = z2;
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                this.o1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void C3(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, zVar) == null) {
            this.V = zVar;
            this.I.B0(zVar);
            this.y1.p(this.V);
        }
    }

    public void D3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.W = bVar;
            NoNetworkView noNetworkView = this.p;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public void D4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f.showToast(str);
        }
    }

    public void E3(BdListView.p pVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, pVar) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setOnSrollToBottomListener(pVar);
        }
    }

    public void F3(AbsListView.OnScrollListener onScrollListener) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, onScrollListener) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setOnScrollListener(onScrollListener);
        }
    }

    public void G2(bn bnVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, bnVar) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.b0 = bnVar;
            pbLandscapeListView.W = true;
        }
    }

    public void G3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onClickListener) == null) {
            this.I.F0(onClickListener);
        }
    }

    public void H3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.J1 = i2;
        }
    }

    public void I3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, onLongClickListener) == null) {
            this.x.I(onLongClickListener);
            this.I.C0(onLongClickListener);
            yf9 yf9Var = this.y1;
            if (yf9Var != null) {
                yf9Var.q(onLongClickListener);
            }
        }
    }

    public void K4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z2) == null) {
            this.l0 = z2;
        }
    }

    public void O3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z2) == null) {
            this.x.K(z2);
        }
    }

    public void Q3(int i2) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048659, this, i2) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setSelection(i2);
        }
    }

    public void R3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, list) == null) {
            this.w1 = list;
            fj9 fj9Var = this.x1;
            if (fj9Var != null) {
                fj9Var.q(list);
            }
        }
    }

    public void S2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048668, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        R2(sparseArray, false);
    }

    public void T4(td9 td9Var) {
        xi9 xi9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048675, this, td9Var) == null) && (xi9Var = this.v) != null) {
            xi9Var.h(td9Var, this.Q0);
        }
    }

    public void b4(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048709, this, z2) == null) {
            View view2 = this.t0;
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    public final boolean f2(td9 td9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048723, this, td9Var)) == null) {
            return bi9.x(td9Var);
        }
        return invokeL.booleanValue;
    }

    public void n3(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048756, this, str) == null) && (pbListView = this.O) != null) {
            pbListView.H(str);
        }
    }

    public final int q1(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048766, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.Y0;
            if (pbInterviewStatusView == null || pbInterviewStatusView.getVisibility() != 0 || !z2) {
                return 0;
            }
            return 0 + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
        }
        return invokeZ.intValue;
    }

    public void q3(PbFragment.f3 f3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048768, this, f3Var) == null) {
            this.e2 = f3Var;
        }
    }

    public final void r0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048770, this, view2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.addRule(11);
            view2.setLayoutParams(layoutParams);
        }
    }

    public void r3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048773, this, z2) == null) {
            this.s0 = z2;
        }
    }

    public void s3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048778, this, z2) == null) {
            this.I.o0(z2);
        }
    }

    public void t3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048783, this, z2) == null) {
            this.I1 = z2;
        }
    }

    public boolean u0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048785, this, z2)) == null) {
            EditorTools editorTools = this.r0;
            if (editorTools != null && editorTools.x()) {
                this.r0.t();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void u3(boolean z2) {
        lg9 lg9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048788, this, z2) == null) && (lg9Var = this.I) != null) {
            lg9Var.p0(z2);
        }
    }

    public void v3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048793, this, z2) == null) {
            this.A1 = z2;
        }
    }

    public void w3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048798, this, z2) == null) {
            this.I.r0(z2);
        }
    }

    public void x3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048803, this, z2) == null) {
            this.I.w0(z2);
        }
    }

    public void y3(i95.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048808, this, gVar) == null) {
            this.i2 = gVar;
            jm9 jm9Var = this.N;
            if (jm9Var != null) {
                jm9Var.a(gVar);
            }
        }
    }

    public void z3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048813, this, onClickListener) == null) {
            this.j2 = onClickListener;
            lg9 lg9Var = this.I;
            if (lg9Var != null) {
                lg9Var.x0(onClickListener);
            }
        }
    }

    @SuppressLint({"CutPasteId"})
    public void C4(td9 td9Var, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048590, this, td9Var, z2) != null) || td9Var == null) {
            return;
        }
        Q4(td9Var, z2);
        I0();
    }

    public final void J3(rba rbaVar, td9 td9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, rbaVar, td9Var) == null) {
            this.x.J(rbaVar, td9Var);
        }
    }

    public void V2(AdverSegmentData adverSegmentData, int i2) {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048683, this, adverSegmentData, i2) == null) && (pbFallingView = this.P1) != null) {
            pbFallingView.A(adverSegmentData, this.f.getPageContext(), i2, false);
        }
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            yf9 yf9Var = new yf9(this.f, this, (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f09178f));
            this.y1 = yf9Var;
            yf9Var.n(this.f1092T);
            this.y1.o(this.Y);
            this.y1.p(this.V);
            this.y1.n(this.f1092T);
            this.y1.r(this.p0);
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
            I1();
            u45 u45Var = this.i0;
            if (u45Var != null) {
                u45Var.dismiss();
            }
            J0();
            m45 m45Var = this.J;
            if (m45Var != null) {
                m45Var.dismiss();
            }
            n45 n45Var = this.K;
            if (n45Var != null) {
                n45Var.e();
            }
        }
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            m45 m45Var = this.Z;
            if (m45Var != null) {
                m45Var.dismiss();
            }
            Dialog dialog = this.a0;
            if (dialog != null) {
                jg.b(dialog, this.f.getPageContext());
            }
            Dialog dialog2 = this.b0;
            if (dialog2 != null) {
                jg.b(dialog2, this.f.getPageContext());
            }
            u45 u45Var = this.X;
            if (u45Var != null) {
                u45Var.dismiss();
            }
        }
    }

    public final void N4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && (pbFragment = this.f) != null && pbFragment.J5() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.f.J5().z())));
        }
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            this.J0 = (FriendBotView) this.g.findViewById(R.id.obfuscated_res_0x7f091a91);
            PbFragment pbFragment = this.f;
            if (pbFragment != null && pbFragment.R() != null) {
                this.J0.setTid(this.f.R().Q());
            }
            this.J0.l();
        }
    }

    public final void R4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048665, this) != null) || !this.f.C5()) {
            return;
        }
        if (this.f.H5() == -1) {
            SkinManager.setViewTextColor(this.F, R.color.CAM_X0110, 1);
        }
        if (this.f.G5() == -1) {
            SkinManager.setViewTextColor(this.G, R.color.CAM_X0110, 1);
        }
    }

    public final boolean T3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            PbFragment pbFragment = this.f;
            if (pbFragment == null || pbFragment.R().s1().k().getDeletedReasonInfo() == null || 1 != this.f.R().s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048694, this) != null) || this.f.t1 == 3 || !TbadkCoreApplication.isLogin()) {
            return;
        }
        n nVar = new n(this);
        this.D = new tg9(this.f.Y());
        this.C = new vg9(this.o, nVar);
    }

    public final void g3() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048728, this) != null) || (pbFragment = this.f) == null || pbFragment.getActivity() == null || (waterRippleView = this.C0) == null) {
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

    public void h3() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048732, this) == null) && (pbLandscapeListView = this.o) != null) {
            this.A.d(pbLandscapeListView);
            this.w.h(this.o);
            this.x.G(this.o);
            this.y.d(this.o);
            this.v.f(this.o);
        }
    }

    public boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
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

    public boolean n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            td9 td9Var = this.R0;
            if (td9Var == null || td9Var.k() == null || "0".equals(this.R0.k().getId())) {
                return true;
            }
            return "me0407".equals(this.R0.k().getName());
        }
        return invokeV.booleanValue;
    }

    public final boolean p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) {
            PbFragment pbFragment = this.f;
            if (pbFragment != null && pbFragment.M5() != null && this.f.M5().R0 != null && this.f.M5().R0.K() != null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048790, this)) == null) {
            PbListView pbListView = this.O;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.j())) {
                return this.O.j().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void w4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048799, this) == null) {
            PbFallingView pbFallingView = this.P1;
            if (pbFallingView != null) {
                pbFallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.Q1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.P1) {
                this.Q1.setTag(null);
                this.Q1.setAutoCompleteShown(true);
                this.Q1.d();
            }
        }
    }

    public String x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048801, this)) == null) {
            if (!bi.isEmpty(this.G1)) {
                return this.G1;
            }
            if (this.f != null) {
                this.G1 = TbadkCoreApplication.getInst().getResources().getString(bi9.g());
            }
            return this.G1;
        }
        return (String) invokeV.objValue;
    }

    public int A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.U0;
        }
        return invokeV.intValue;
    }

    public View B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public PbThreadPostView C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.r;
        }
        return (PbThreadPostView) invokeV.objValue;
    }

    public RelativeLayout D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.H;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public RelativeLayout E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.g;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void E4() {
        ck9 ck9Var;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (ck9Var = this.T1) != null && (linearLayout = this.S1) != null) {
            ck9Var.c(linearLayout);
        }
    }

    public void F1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            rk9 rk9Var = this.k;
            if (rk9Var != null && (view2 = rk9Var.f) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void F4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.f.showProgressBar();
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.k.f();
            u45 u45Var = this.i0;
            if (u45Var != null) {
                u45Var.dismiss();
            }
            J0();
            m45 m45Var = this.J;
            if (m45Var != null) {
                m45Var.dismiss();
            }
            n45 n45Var = this.K;
            if (n45Var != null) {
                n45Var.e();
            }
        }
    }

    public void G1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048607, this) != null) || this.y0 == null) {
            return;
        }
        this.x0.setVisibility(8);
        this.y0.setVisibility(8);
        this.N0 = false;
    }

    public void H0() {
        im9 im9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (im9Var = this.K0) != null) {
            im9Var.k(false);
        }
    }

    public final void H4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048615, this) != null) || !p2()) {
            return;
        }
        G4(1, 4, this.J0.o());
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
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (editorTools = this.r0) != null) {
            editorTools.q();
            fj9 fj9Var = this.x1;
            if (fj9Var != null) {
                fj9Var.m();
            }
        }
    }

    public void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.I.g0(2);
            J2();
            t2();
            U4();
            H4();
            x0();
            vg9 vg9Var = this.C;
            if (vg9Var != null) {
                vg9Var.k();
            }
        }
    }

    public void I4() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (pbFallingView = this.P1) != null) {
            pbFallingView.C();
        }
    }

    public void J1() {
        rk9 rk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (rk9Var = this.k) != null) {
            rk9Var.k();
        }
    }

    public final void J2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (pbFragment = this.f) != null && pbFragment.J5() != null) {
            this.f.J5().F();
        }
    }

    public void J4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && this.k2 != null) {
            while (this.k2.size() > 0) {
                TbImageView remove = this.k2.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
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

    public void K1() {
        BlueCircleProgressDialog blueCircleProgressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && (blueCircleProgressDialog = this.P0) != null) {
            blueCircleProgressDialog.setDialogVisiable(false);
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
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (this.E == null) {
                W1();
            }
            this.n.setVisibility(8);
            Handler handler = this.b2;
            if (handler != null && (runnable = this.c2) != null) {
                handler.removeCallbacks(runnable);
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
            K1();
        }
    }

    public void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            this.S.setVisibility(8);
        }
    }

    public void M3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048639, this) == null) && (pbFragment = this.f) != null && pbFragment.getBaseFragmentActivity() != null) {
            BdUtilHelper.hideSoftKeyPad(this.f.getPageContext().getPageActivity(), this.f.getBaseFragmentActivity().getCurrentFocus());
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
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (rightFloatLayerView = this.Q1) != null) {
            rightFloatLayerView.c();
        }
    }

    public void N3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            this.O.D();
            this.O.U();
        }
    }

    public void O1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048647, this) == null) && (editorTools = this.r0) != null) {
            editorTools.t();
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
        ck9 ck9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048652, this) == null) && (ck9Var = this.T1) != null) {
            ck9Var.a();
        }
    }

    public void Q0() {
        FriendBotView friendBotView;
        CallRobotEntrance callRobotEntrance;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048656, this) == null) && (friendBotView = this.J0) != null && (callRobotEntrance = this.W1) != null) {
            friendBotView.k(callRobotEntrance);
        }
    }

    public final void R1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048662, this) == null) && this.B == null && (pbFragment = this.f) != null && pbFragment.getActivity() != null) {
            this.B = new PbContentCollectionController(this.f.getActivity());
        }
    }

    public lg9 T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.I;
        }
        return (lg9) invokeV.objValue;
    }

    public final void T1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048672, this) == null) && this.A == null && (pbFragment = this.f) != null) {
            this.A = new wi9(pbFragment.getContext());
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048677, this) == null) && this.w == null) {
            this.w = new zi9(this.f, this.p0);
        }
    }

    public boolean U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            yh9 yh9Var = this.s;
            if (yh9Var != null && yh9Var.l()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public FriendBotView V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.J0;
        }
        return (FriendBotView) invokeV.objValue;
    }

    public void V3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            int i2 = 0;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            rk9 rk9Var = this.k;
            if (rk9Var != null && (view2 = rk9Var.f) != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    i2 = 8;
                }
                view2.setVisibility(i2);
            }
        }
    }

    public LinearLayout W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.z0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public View X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            View view2 = this.c0;
            if (view2 != null) {
                return view2.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public String Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return this.h0;
        }
        return (String) invokeV.objValue;
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            this.x.F(this.R0, this.S0, this.q1, this.p1);
        }
    }

    public void Y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048696, this) == null) {
            Z3(null);
        }
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            return this.p;
        }
        return (NoNetworkView) invokeV.objValue;
    }

    public PbFallingView b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            return this.P1;
        }
        return (PbFallingView) invokeV.objValue;
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048707, this) == null) && this.y == null) {
            this.y = new yi9(this.f, this.f1092T);
        }
    }

    public int d1() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) {
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

    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            return this.N0;
        }
        return invokeV.booleanValue;
    }

    public final void e3() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048720, this) == null) && (pbInterviewStatusView = this.Y0) != null && pbInterviewStatusView.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Y0.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.Y0.setLayoutParams(marginLayoutParams);
        }
    }

    public Button f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            return this.w0;
        }
        return (Button) invokeV.objValue;
    }

    public void f3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048724, this) == null) && this.i != 2) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setNextPage(this.O);
            }
            this.i = 2;
        }
    }

    public int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                return pbLandscapeListView.getHeaderViewsCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public TextView h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            return this.x.v();
        }
        return (TextView) invokeV.objValue;
    }

    public boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            EditorTools editorTools = this.r0;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            im9 im9Var = this.K0;
            if (im9Var != null) {
                return im9Var.f();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public void i4() {
        rk9 rk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048737, this) == null) && (rk9Var = this.k) != null && !this.r1) {
            rk9Var.w();
            this.r1 = true;
        }
    }

    public PbInterviewStatusView j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            return this.Y0;
        }
        return (PbInterviewStatusView) invokeV.objValue;
    }

    public final boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.h2);
        }
        return invokeV.booleanValue;
    }

    public void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            i3();
            I1();
            this.m1.g();
            c4(false);
        }
    }

    public void j4() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048741, this) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setVisibility(0);
        }
    }

    public boolean k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
            return this.A1;
        }
        return invokeV.booleanValue;
    }

    public void k3() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048744, this) != null) || (handler = this.b2) == null) {
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

    public void k4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048745, this) == null) {
            if (this.P0 == null) {
                this.P0 = new BlueCircleProgressDialog(this.f.getPageContext());
            }
            this.P0.setDialogVisiable(true);
        }
    }

    public int l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return 0;
            }
            return e1(pbLandscapeListView.getLastVisiblePosition());
        }
        return invokeV.intValue;
    }

    public BdTypeListView m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            return this.o;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public void m4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            this.I.n0(this.R0, false);
            this.I.f0();
        }
    }

    public yf9 o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) {
            return this.y1;
        }
        return (yf9) invokeV.objValue;
    }

    public View p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) {
            return this.R;
        }
        return (View) invokeV.objValue;
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048764, this) == null) {
            this.P1.setFallingFeedbackListener(new a1(this));
        }
    }

    public boolean q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) {
            im9 im9Var = this.K0;
            if (im9Var == null) {
                return false;
            }
            return im9Var.h();
        }
        return invokeV.booleanValue;
    }

    public View r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) {
            return this.Q;
        }
        return (View) invokeV.objValue;
    }

    public boolean r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048772, this)) == null) {
            EditorTools editorTools = this.r0;
            if (editorTools != null && editorTools.x()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public PbListView s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) {
            return this.O;
        }
        return (PbListView) invokeV.objValue;
    }

    public int t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048781, this)) == null) {
            try {
                return Integer.parseInt(this.M.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public View u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048786, this)) == null) {
            return this.a1;
        }
        return (View) invokeV.objValue;
    }

    public void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048787, this) == null) {
            b3(this.R0);
        }
    }

    public void u4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048789, this) == null) {
            this.S.setVisibility(0);
        }
    }

    public PbFakeFloorModel v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048791, this)) == null) {
            return this.l1;
        }
        return (PbFakeFloorModel) invokeV.objValue;
    }

    public void v4() {
        lg9 lg9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048794, this) == null) && (lg9Var = this.I) != null) {
            lg9Var.I0();
        }
    }

    public ah9 w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048796, this)) == null) {
            return this.m1;
        }
        return (ah9) invokeV.objValue;
    }

    public void x4() {
        im9 im9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048804, this) != null) || (im9Var = this.K0) == null) {
            return;
        }
        im9Var.n(2);
    }

    public void A2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RelativeLayout relativeLayout = this.g;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.g.getHandler().removeCallbacksAndMessages(null);
            }
            im9 im9Var = this.K0;
            if (im9Var != null) {
                im9Var.j();
            }
            nh9 nh9Var = this.C1;
            if (nh9Var != null) {
                nh9Var.c();
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
            dba.d();
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
            sr6.b().unregister(this.U1);
            this.b2 = null;
            this.j.removeCallbacksAndMessages(null);
            this.I.g0(3);
            View view2 = this.h;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            lg9 lg9Var = this.I;
            if (lg9Var != null) {
                lg9Var.i0();
            }
            fj9 fj9Var = this.x1;
            if (fj9Var != null) {
                fj9Var.l();
            }
            bj9 bj9Var = this.x;
            if (bj9Var != null) {
                bj9Var.D();
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
            if (this.V1 != null) {
                SafeHandler.getInst().removeCallbacks(this.V1);
            }
            ah9 ah9Var = this.m1;
            if (ah9Var != null) {
                ah9Var.m();
            }
            cd9.d();
        }
    }

    public void D2() {
        rba rbaVar;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || this.f == null) {
            return;
        }
        if (!this.I1 && this.J1 != 17) {
            if (this.q1 && !this.p1 && (rbaVar = this.S0) != null && rbaVar.r() != null) {
                int i3 = 2;
                if (this.f.A0()) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                if (!this.p1) {
                    i3 = 1;
                }
                rl9.u("c12601", i3, i2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f.getPageContext().getPageActivity(), this.S0.r().getUserId(), this.S0.r().getUserName(), this.f.R().R0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
                return;
            }
            return;
        }
        td9 td9Var = this.R0;
        if (td9Var != null && td9Var.k() != null && !bi.isEmpty(this.R0.k().getName())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f.getContext()).createNormalCfg(this.R0.k().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.R0.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.R0.k().getId()));
        }
    }

    public void H2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.f.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            N4();
            this.f.y6();
            PbFragment pbFragment = this.f;
            if (pbFragment != null && pbFragment.R() != null && this.f.R().s1() != null && this.f.R().s1().O() != null && this.f.R().s1().O().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f.R().N1()).param("fid", this.f.R().s1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f.R().b).param("fid", this.f.R().s1().l()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f.getContext());
            this.b = cardForumHeadLayout;
            cardForumHeadLayout.setId(R.id.obfuscated_res_0x7f091a82);
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
            EMManager.from(this.b).setCorner(R.string.J_X05).setBackGroundRealColor(y9a.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
            this.b.setAfterClickListener(new p(this));
        }
    }

    public final void U4() {
        PbFragment pbFragment;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048680, this) == null) && (pbFragment = this.f) != null && pbFragment.R() != null && this.f.R().G != null && this.f.R().G.O() != null && this.f.R().G.O().isXiuXiuThread()) {
            ThreadData O = this.f.R().G.O();
            int i3 = 0;
            if (this.f.R().X0()) {
                i2 = 1;
            } else if (this.f.R().a1()) {
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

    public void Z2() {
        PbLandscapeListView pbLandscapeListView;
        int i2;
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048699, this) != null) || (pbLandscapeListView = this.o) == null) {
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
        int y1 = y1(pbReplyTitleViewHolder);
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
        this.o.setOnLayoutListener(new l(this, y1, pbReplyTitleViewHolder, z2, measuredHeight, i2, i3));
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048795, this) == null) {
            if (!this.f.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                rl9.v("c10517", this.o0, 2);
            } else if (!this.f.e5()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                qj5 J5 = this.f.J5();
                if (J5 != null && (J5.y() || J5.A())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.f.J5().w(false, null);
                    return;
                }
                if (this.r0 != null) {
                    X1();
                }
                EditorTools editorTools = this.r0;
                if (editorTools != null) {
                    this.N0 = false;
                    if (editorTools.p(2) != null) {
                        dba.c(this.f.getPageContext(), (View) this.r0.p(2).m, false, v2);
                    }
                }
                G1();
            }
        }
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

    public void K3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048629, this, z2, postWriteCallBackData) == null) {
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
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048780, this, absListView, i2)) == null) {
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

    public void w2(boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048797, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            dh9 dh9Var = this.t;
            if (dh9Var != null) {
                dh9Var.b(z2, i2);
            }
            dh9 dh9Var2 = this.u;
            if (dh9Var2 != null) {
                dh9Var2.b(z2, i2);
            }
            vg9 vg9Var = this.C;
            if (vg9Var != null) {
                vg9Var.m(this.R0.k());
                this.C.i(z2, i2);
            }
        }
    }

    public void B2(TbRichText tbRichText) {
        td9 td9Var;
        rba rbaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, tbRichText) == null) && (td9Var = this.R0) != null && td9Var.F() != null && !this.R0.F().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i2 = 0; i2 < this.R0.F().size() && (rbaVar = this.R0.F().get(i2)) != null && rbaVar.r() != null && !StringUtils.isNull(rbaVar.r().getUserId()); i2++) {
                if (this.R0.F().get(i2).r().getUserId().equals(tbRichText.getAuthorId())) {
                    yf9 yf9Var = this.y1;
                    if (yf9Var != null && yf9Var.k()) {
                        c4(false);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public final void B4(td9 td9Var) {
        boolean z2;
        zi9 zi9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, td9Var) == null) && !this.B1 && td9Var != null && td9Var.O() != null && !td9Var.O().isVideoThreadType()) {
            ThreadData O = td9Var.O();
            boolean z3 = false;
            if (O.getIs_good() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (O.getIs_top() == 1) {
                z3 = true;
            }
            bj9 bj9Var = this.x;
            if (bj9Var != null) {
                bj9Var.u(td9Var, z2, z3);
            }
            if (O.isShowTitle() && (zi9Var = this.w) != null && zi9Var.d() != null) {
                bi9.b(this.w.d(), O.isHeadLinePost, O.isGoodThread(), O.isTopThread());
            }
            if (T0() != null) {
                T0().J0(td9Var);
            }
        }
    }

    public void H1(boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048612, this, z2) == null) && this.y0 != null && this.B0 != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            td9 td9Var = this.R0;
            if (td9Var != null && td9Var.q0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            td9 td9Var2 = this.R0;
            if (td9Var2 != null && td9Var2.r0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.B0.setText(tbSingleton.getAdVertiComment(z3, z4, x1()));
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

    public void P4(td9 td9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, td9Var) == null) {
            if (td9Var != null && AntiHelper.o(td9Var.O())) {
                im9 im9Var = this.K0;
                if (im9Var != null) {
                    im9Var.k(false);
                    this.K0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.G0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.G0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.G0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            im9 im9Var2 = this.K0;
            if (im9Var2 != null && im9Var2.g()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.G0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.G0.setLayoutParams(layoutParams2);
            WebPManager.setPureDrawable(this.G0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
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
                return this.f.getString(R.string.obfuscated_res_0x7f0f0fc6);
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

    public void S4(boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z2) == null) {
            lg9 lg9Var = this.I;
            if (lg9Var != null) {
                lg9Var.A0(z2);
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
                pbFragment.O6(z2);
            }
            if (z2) {
                dk9.d(this.f.getPageContext(), this.f.R(), this.f.M5());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            td9 td9Var = this.R0;
            if (td9Var != null) {
                str = td9Var.l();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public final void W3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048688, this, sparseArray) != null) || this.f == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f13cb, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03ce, TBAlertConfig.OperateBtnStyle.SECONDARY);
        AlertDialog show = new TBAlertBuilder(this.f.Y()).setTitle(R.string.musk_my_thread_confirm).setDesc(R.string.musk_my_thread_confirm_subtitle).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new f0(this, show, sparseArray));
        operateBtnConfig2.setListener(new h0(this, show));
    }

    public void m3(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048752, this, editorTools) == null) {
            this.r0 = editorTools;
            editorTools.setOnCancelClickListener(new y(this));
            this.r0.setId(R.id.obfuscated_res_0x7f091a8e);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.r0.getParent() == null) {
                this.g.addView(this.r0, layoutParams);
            }
            this.r0.z(TbadkCoreApplication.getInst().getSkinType());
            this.r0.setActionListener(24, new z(this));
            I1();
            this.f.J5().g(new a0(this));
        }
    }

    public void x2(AgreeMessageData agreeMessageData) {
        td9 td9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048802, this, agreeMessageData) == null) && agreeMessageData != null && agreeMessageData.agreeData != null && (td9Var = this.R0) != null && td9Var.O() != null && this.R0.O().getAgreeData() != null) {
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
            a3(agreeData2, agreeData2.agreeNum);
        }
    }

    public void z4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048814, this, z2) == null) && this.o != null && (textView = this.Z0) != null && this.h != null) {
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
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + q1(true);
                this.Z0.setLayoutParams(layoutParams2);
            }
            e3();
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !this.l2) {
            TiebaStatic.log("c10490");
            this.l2 = true;
            m45 m45Var = new m45(this.f.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(o2, Integer.valueOf(q2));
            m45Var.setTitle(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            m45Var.setContentView(inflate);
            m45Var.setYesButtonTag(sparseArray);
            m45Var.setPositiveButton(R.string.grade_button_tips, this.f);
            m45Var.setNegativeButton(R.string.look_again, new x0(this));
            m45Var.create(this.f.getPageContext()).show();
        }
    }

    public final void O4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            if (cd9.c()) {
                DefaultLog.getInstance().e("BotGuideManager", "新手长按引导未展示,BotGuideManager在展示其他");
            } else if (SharedPrefHelper.getInstance().getBoolean("pb_friend_bot_bottom_long_click_shown", false)) {
                DefaultLog.getInstance().e("BotGuideManager", "新手长按引导未展示,长按引导已经展示过");
            } else if (SharedPrefHelper.getInstance().getBoolean("pb_friend_bot_bottom_new_user_shown", false) && (pbFragment = this.f) != null) {
                BaseFragmentActivity baseFragmentActivity = pbFragment.getBaseFragmentActivity();
                if (baseFragmentActivity != null && this.J0 != null) {
                    String string = baseFragmentActivity.getString(R.string.obfuscated_res_0x7f0f0fd1);
                    cd9.e(string, this.J0, baseFragmentActivity, new s(this, string));
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

    public final void U3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048679, this) == null) && (pbFragment = this.f) != null && pbFragment.getActivity() != null) {
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

    public final void t2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048782, this) == null) && (pbFragment = this.f) != null && pbFragment.R() != null && this.f.R().G != null && this.f.R().G.O() != null && this.f.R().G.O().isQuestionThread()) {
            ThreadData O = this.f.R().G.O();
            String F1 = this.f.R().F1();
            String G1 = this.f.R().G1();
            int i2 = 5;
            if ("question_answer_invite".equals(F1)) {
                i2 = 1;
            } else if ("3".equals(G1)) {
                i2 = 2;
            } else if ("answer_top".equals(F1)) {
                i2 = 3;
            } else if (this.f.R().X0()) {
                i2 = 4;
            }
            TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", O.getId()).param("fid", O.getFid()).param("obj_source", i2));
        }
    }

    public final void y0() {
        td9 td9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048805, this) == null) && this.B != null && (td9Var = this.R0) != null && td9Var.O() != null && !ListUtils.isEmpty(this.R0.O().getThreadRecommendInfoDataList()) && this.R0.O().getThreadRecommendInfoDataList().get(0) != null && this.w.b().getVisibility() == 0) {
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

    public void D0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            m45 m45Var = new m45(this.f.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            m45Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(o2, Integer.valueOf(r2));
            m45Var.setYesButtonTag(sparseArray);
            m45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f181f, this.f);
            m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new y0(this));
            m45Var.create(this.f.getPageContext()).show();
        }
    }

    public void M4(sd9 sd9Var) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048640, this, sd9Var) != null) || sd9Var == null) {
            return;
        }
        this.k.C();
        if (!StringUtils.isNull(sd9Var.b)) {
            this.k.y(sd9Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1639);
        int i2 = JavaTypesHelper.toInt(sd9Var.a, 0);
        if (i2 != 100) {
            if (i2 != 300) {
                if (i2 != 400) {
                    string = "";
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f15a6);
                }
            } else {
                string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0334);
            }
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f134e);
        }
        this.f.showNetRefreshView(this.g, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new s0(this, sd9Var.c));
    }

    public void T2(@NonNull View view2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048673, this, view2) == null) && this.E0.getData() != null && this.E0.getData().hasAgree && this.f.getActivity() != null) {
            PbFirstFloorDoubleClickAnimation pbFirstFloorDoubleClickAnimation = new PbFirstFloorDoubleClickAnimation(this.f.getContext());
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds774);
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0708fb);
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

    public final void c2(td9 td9Var) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048711, this, td9Var) == null) && (pbListView = this.O) != null && pbListView.i() != null) {
            LinearLayout i2 = this.O.i();
            if (UbsABTestHelper.isPbEnterForum() && td9Var.y().b() == 0 && !this.f.R().X0() && !o2(td9Var)) {
                if (this.b == null) {
                    S1();
                }
                ViewParent parent = this.b.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.b);
                }
                i2.addView(this.b);
                ForumData k2 = td9Var.k();
                z15 forumShowInfo = k2.getForumShowInfo();
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

    public final boolean f4(td9 td9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048725, this, td9Var)) == null) {
            if (td9Var == null || td9Var.O() == null) {
                return false;
            }
            if (td9Var.O().getIsLive() != 1 && td9Var.O().getThreadType() != 33 && ((td9Var.O().getTopicData() == null || td9Var.O().getTopicData().a() == 0) && td9Var.O().getIs_top() != 1 && td9Var.O().getIs_good() != 1 && !td9Var.O().isActInfo() && !td9Var.O().isInterviewLive() && !td9Var.O().isVoteThreadType() && td9Var.O().getYulePostActivityData() == null && bi.isEmpty(td9Var.O().getCategory()) && !td9Var.O().isGodThread() && !td9Var.O().isRealGod())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r5.K1 == 1) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E0() {
        hm9 hm9Var;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || (hm9Var = this.N1) == null) {
            return;
        }
        if (this.o != null && hm9Var.a() != null && this.N1.a().getParent() != null) {
            i2 = this.o.getPositionForView(this.N1.a());
        } else {
            i2 = -1;
        }
        boolean z3 = false;
        if (i2 != -1) {
            if (this.N1.a().getTop() + t2 <= this.a1.getBottom()) {
                this.K1 = 1;
                z2 = true;
            } else {
                this.K1 = 0;
                z2 = false;
            }
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.d1;
        if (this.K1 == 1) {
            z3 = true;
        }
        pbReplyTitleViewHolder.x(z3);
        this.N1.e(z2);
    }

    public void L3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.f.hideProgressBar();
            td9 td9Var = this.R0;
            if (td9Var != null && this.O != null && td9Var.y() != null && this.R0.y().b() == 0) {
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

    public final boolean S3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            td9 td9Var = this.R0;
            if (td9Var != null && td9Var.O() != null && !ListUtils.isEmpty(this.R0.O().getThreadRecommendInfoDataList()) && this.f != null && this.w.b() != null && this.w.b().getVisibility() == 0 && this.R0.O().getThreadRecommendInfoDataList().get(0) != null && this.R0.O().getThreadRecommendInfoDataList().get(0).businessType == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048686, this) != null) || !this.f.C5()) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f0916c5);
        this.n = viewStub;
        viewStub.setVisibility(0);
        if (this.E == null) {
            this.E = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0916c4);
            ks5.a(this.f.getPageContext(), this.E);
        }
        if (this.F == null) {
            this.F = (TextView) this.E.findViewById(R.id.obfuscated_res_0x7f0916c9);
        }
        if (this.G == null) {
            this.G = (TextView) this.E.findViewById(R.id.obfuscated_res_0x7f0916c8);
        }
        this.F.setOnClickListener(this.f1092T);
        this.G.setOnClickListener(this.f1092T);
    }

    public final void W2() {
        rk9 rk9Var;
        td9 td9Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048687, this) == null) && this.w != null && (rk9Var = this.k) != null && rk9Var.j() != null && (td9Var = this.R0) != null && td9Var.O() != null && this.R0.O().isQuestionThread() && this.w.b() != null && this.w.b().getVisibility() == 0) {
            int[] iArr = new int[2];
            this.w.b().getLocationInWindow(iArr);
            boolean z3 = true;
            int height = iArr[1] + this.w.b().getHeight();
            if (this.w.b().getParent() != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            rk9 rk9Var2 = this.k;
            if (height > rk9Var2.j().getBottom() && z2) {
                z3 = false;
            }
            rk9Var2.z(z3, this.R0.O().getSpan_str());
        }
    }

    public void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            if (this.f != null && this.r0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.r0.j();
                G1();
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public int Z0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
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

    public final void i3() {
        PbFragment pbFragment;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048736, this) == null) && (pbFragment = this.f) != null && pbFragment.J5() != null && this.r0 != null) {
            lj5.a().c(0);
            qj5 J5 = this.f.J5();
            J5.N();
            J5.L();
            if (J5.v() != null) {
                WriteImagesInfo v3 = J5.v();
                if (J5.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                v3.setMaxImagesAllowed(i2);
            }
            J5.e0(SendView.h);
            J5.h(SendView.h);
            th5 o3 = this.r0.o(23);
            th5 o4 = this.r0.o(2);
            th5 o5 = this.r0.o(5);
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

    public final void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048792, this) == null) {
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

    public final void x0() {
        PbContentCollectionController pbContentCollectionController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048800, this) == null) {
            if (S3() && this.R0 != null) {
                StatisticItem addParam = new StatisticItem(CommonStatisticKey.KEY_PB_PAGE_CONTENT_COLLECTION_SHOW).addParam("tid", this.R0.O().getTid()).addParam("obj_param1", this.R0.O().getThreadRecommendInfoDataList().get(0).businessId);
                int i2 = this.R0.O().getThreadRecommendInfoDataList().get(0).albumType;
                if (i2 != -1) {
                    addParam.addParam("obj_type", i2);
                }
                addParam.eventStat();
            }
            if (k2() && (pbContentCollectionController = this.B) != null) {
                pbContentCollectionController.h();
                this.B.g(true);
            }
        }
    }

    public void E2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) {
            if (z2) {
                i4();
            } else {
                J1();
            }
            this.h1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.h1));
            X2(this.h1.a, false);
        }
    }

    public void L4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z2) == null) {
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

    public void a2(td9 td9Var) {
        vb5 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048703, this, td9Var) != null) || td9Var == null) {
            return;
        }
        if (td9Var.q0()) {
            pbAdFloatViewItemData = td9Var.b0();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            Z1(td9Var, pbAdFloatViewItemData);
        } else {
            N1();
        }
    }

    public void c4(boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048713, this, z2) != null) || this.y0 == null) {
            return;
        }
        if (this.f.J5() != null && this.f.J5().z()) {
            z3 = true;
        } else {
            z3 = false;
        }
        r3(z3);
        if (this.s0) {
            g4(z2);
        } else {
            H1(z2);
        }
    }

    public void g4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048729, this, z2) == null) && this.y0 != null && (textView = this.B0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f0600);
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

    public final boolean l2(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        rba X;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048747, this, threadData)) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                td9 td9Var = this.R0;
                if (td9Var != null && (X = td9Var.X()) != null && X.r() != null) {
                    str = X.r().getUserId();
                } else {
                    str = "";
                }
                return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean o2(td9 td9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048759, this, td9Var)) == null) {
            if (td9Var == null) {
                return true;
            }
            ArrayList<rba> F = td9Var.F();
            if (ListUtils.getCount(F) == 0) {
                return true;
            }
            if (ListUtils.getCount(F) == 1 && ListUtils.getItem(F, 0) != null && ((rba) ListUtils.getItem(F, 0)).I() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int y1(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048806, this, pbReplyTitleViewHolder)) == null) {
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

    public void z2(Configuration configuration) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048812, this, configuration) != null) || configuration == null) {
            return;
        }
        F0();
        if (configuration.orientation == 2) {
            G1();
            I1();
        } else {
            j3();
        }
        ah9 ah9Var = this.m1;
        if (ah9Var != null) {
            ah9Var.g();
        }
        this.f.V5();
        this.H.setVisibility(8);
        this.k.v(false);
        this.f.P6(false);
    }

    public final void G4(int i2, int i3, boolean z2) {
        String str;
        AbilityConf abilityConf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            CallRobotEntrance callRobotEntrance = this.W1;
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

    public void K2(AbsListView absListView, int i2, int i3, int i4) {
        boolean z2;
        PbListView pbListView;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048628, this, absListView, i2, i3, i4) == null) {
            dh9 dh9Var = this.u;
            if (dh9Var != null) {
                dh9Var.c(i2, i3);
            }
            dh9 dh9Var2 = this.t;
            if (dh9Var2 != null) {
                dh9Var2.c(i2, i3);
            }
            vg9 vg9Var = this.C;
            if (vg9Var != null) {
                vg9Var.l(i2, i3);
            }
            rk9 rk9Var = this.k;
            if (rk9Var != null && this.x != null) {
                rk9Var.q(absListView, i2, i3, i4);
            }
            W2();
            this.h1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.h1));
            if (t0(absListView, i2) && !this.k.o()) {
                z2 = true;
            } else {
                z2 = false;
            }
            b4(z2);
            X2(this.h1.a, false);
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
                nl6.f(this.O.i(), 0);
            }
        }
    }

    public void L2(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048633, this, absListView, i2) == null) {
            if (i2 == 0) {
                this.h1.a = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.h1));
                X2(this.h1.a, true);
                E0();
                this.I.m0(true);
            }
            this.I.l0();
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.Q1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.p();
                }
                y0();
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.Q1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.o();
                }
            } else if (i2 == 2 && (rightFloatLayerView = this.Q1) != null) {
                rightFloatLayerView.q();
            }
        }
    }

    public final void a3(AgreeData agreeData, long j2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048704, this, agreeData, j2) == null) && agreeData != null && (textView = this.L0) != null) {
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

    public void M2(ArrayList<g25> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, arrayList) == null) {
            if (this.c0 == null) {
                this.c0 = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.f.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.c0);
            if (this.b0 == null) {
                Dialog dialog = new Dialog(this.f.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003c1);
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
                textView2.setOnClickListener(this.f1092T);
            }
            this.d0.removeAllViews();
            this.q = new ArrayList();
            CustomBlueCheckRadioButton B0 = B0("0", this.f.getPageContext().getString(R.string.thread_good_class));
            this.q.add(B0);
            B0.setChecked(true);
            this.d0.addView(B0);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    g25 g25Var = arrayList.get(i2);
                    if (g25Var != null && !TextUtils.isEmpty(g25Var.b()) && g25Var.a() > 0) {
                        CustomBlueCheckRadioButton B02 = B0(String.valueOf(g25Var.a()), g25Var.b());
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
            jg.j(this.b0, this.f.getPageContext());
        }
    }

    public void N2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            O2(i2, str, i3, z2, null);
        }
    }

    public void d3(td9 td9Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048716, this, new Object[]{td9Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            o4(td9Var, z2, i2, i3);
            this.x.C(i3);
        }
    }

    public void O0(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.f.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.f;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f1483));
            } else if (z3) {
                if (bi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e21);
                }
                this.f.showToast(str);
            }
        }
    }

    public void Q2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048658, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(o2, Integer.valueOf(p2));
            if (z2) {
                W3(sparseArray);
            } else {
                X3(i2, sparseArray);
            }
        }
    }

    public void O2(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048648, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            P2(i2, str, i3, z2, str2, false);
        }
    }

    public void P2(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048653, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
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
            this.Z = new m45(this.f.getActivity());
            if (StringUtils.isNull(str2)) {
                this.Z.setMessageId(i4);
            } else {
                this.Z.setOnlyMessageShowCenter(false);
                this.Z.setMessage(str2);
            }
            this.Z.setYesButtonTag(sparseArray);
            this.Z.setPositiveButton(R.string.obfuscated_res_0x7f0f0596, this.f);
            this.Z.setNegativeButton(R.string.obfuscated_res_0x7f0f058b, new c0(this));
            this.Z.setCancelable(true);
            this.Z.create(this.f.getPageContext());
            if (z3) {
                e4(sparseArray, i5, i4);
            } else if (z2) {
                e4(sparseArray, i5, i4);
            } else if (T3()) {
                k36 k36Var = new k36(this.f.R().s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f.R().s1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.f.R().s1().n().has_forum_rule.intValue());
                k36Var.i(this.f.R().s1().k().getId(), this.f.R().s1().k().getName());
                k36Var.h(this.f.R().s1().k().getImage_url());
                k36Var.j(this.f.R().s1().k().getUser_level());
                l4(sparseArray, i2, k36Var, this.f.R().s1().V(), false);
            } else {
                t4(this.Z, i2);
            }
        }
    }

    public void P3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, str) == null) {
            this.B0.performClick();
            if (!StringUtils.isNull(str) && this.f.J5() != null && this.f.J5().s() != null && this.f.J5().s().i() != null) {
                EditText i2 = this.f.J5().s().i();
                i2.setText(str);
                i2.setSelection(str.length());
            }
        }
    }

    public final void V1(td9 td9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048682, this, td9Var) != null) || td9Var == null || td9Var.O() == null || !td9Var.O().isInterviewLive() || this.Y0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.X0.inflate();
        this.Y0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.f1092T);
        this.Y0.setCallback(this.f.B5());
        this.Y0.setData(this.f, td9Var);
    }

    public void Z3(zc9 zc9Var) {
        td9 td9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048700, this, zc9Var) == null) && (td9Var = this.R0) != null && td9Var.K() != null && !ListUtils.isEmpty(this.R0.K().robot_skill_info) && !ListUtils.isEmpty(this.R0.K().bottom_bar_robot_skill)) {
            ec9.a(this.J0, BotEntranceManager.e(this.R0.K().robot_skill_info, this.R0.K().bottom_bar_robot_skill), new r(this), zc9Var);
        }
    }

    public final int e1(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048718, this, i2)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return 0;
            }
            pm adapter2 = pbLandscapeListView.getAdapter2();
            if (adapter2 == null) {
                return i2;
            }
            if (i2 < adapter2.getCount() && i2 >= 0 && (adapter2.getItem(i2) instanceof qba)) {
                i2++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i2 > o3) {
                i2 = o3;
            }
            if (this.o.getAdapter2() != null && (this.o.getAdapter2() instanceof pm)) {
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

    public void o3(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048760, this, str) == null) && this.O != null) {
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
        if (interceptable == null || interceptable.invokeZ(1048810, this, z2) == null) {
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

    public boolean Q4(td9 td9Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048660, this, td9Var, z2)) == null) {
            if (td9Var == null) {
                return false;
            }
            if (this.w != null) {
                if (td9Var.O() != null && td9Var.O().getIsNoTitle() == 0 && !td9Var.O().isVideoThreadType()) {
                    if (td9Var.O() != null) {
                        ThreadData O = td9Var.O();
                        O.parserSpecTitleForFrsAndPb(true, f4(td9Var));
                        O.setResource(3);
                        O.setPbTitle("2");
                    }
                    if (td9Var.O().isBJHArticleThreadType()) {
                        this.x.G(this.o);
                        this.w.h(this.o);
                        this.w.a(this.o);
                        this.x.q(this.o);
                        this.x.L(this.R0);
                        if (f2(td9Var)) {
                            this.w.h(this.o);
                        } else {
                            this.w.i(td9Var);
                        }
                    } else {
                        this.x.L(this.R0);
                        if (f2(td9Var)) {
                            this.w.h(this.o);
                        } else {
                            this.w.k(td9Var);
                        }
                    }
                } else if (td9Var.O().getIsNoTitle() == 1) {
                    if (td9Var.O() != null) {
                        this.w.h(this.o);
                        this.x.L(this.R0);
                    }
                } else {
                    this.w.h(this.o);
                    this.x.L(this.R0);
                }
            }
            A4(td9Var.X());
            B4(td9Var);
            this.Q0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final void X3(int i2, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048692, this, i2, sparseArray) == null) && (pbFragment = this.f) != null && pbFragment.R() != null && this.f.R().s1() != null && this.f.R().s1().n() != null && this.f.R().s1().k() != null && this.f.R().s1().k().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
            }
            k36 k36Var = new k36(this.f.R().s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f.R().s1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.f.R().s1().n().has_forum_rule.intValue());
            k36Var.i(this.f.R().s1().k().getId(), this.f.R().s1().k().getName());
            k36Var.h(this.f.R().s1().k().getImage_url());
            k36Var.j(this.f.R().s1().k().getUser_level());
            l4(sparseArray, i2, k36Var, this.f.R().s1().V(), true);
        }
    }

    public final void t4(m45 m45Var, int i2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048784, this, m45Var, i2) == null) && (pbFragment = this.f) != null && m45Var != null) {
            if (this.E1 == null && this.v != null) {
                this.E1 = new i36(pbFragment.getPageContext(), this.v.c());
            }
            AntiData t5 = this.f.t5();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (t5 != null && t5.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = t5.getDelThreadInfoList();
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
            this.E1.C(new i0(this, m45Var));
        }
    }

    public void y4(t25 t25Var, m45.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048809, this, t25Var, eVar) != null) || t25Var == null) {
            return;
        }
        int a2 = t25Var.a();
        int h2 = t25Var.h();
        m45 m45Var = this.J;
        if (m45Var != null) {
            m45Var.show();
        } else {
            this.J = new m45(this.f.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0263, (ViewGroup) null);
            this.L = inflate;
            this.J.setContentView(inflate);
            this.J.setPositiveButton(R.string.obfuscated_res_0x7f0f0596, eVar);
            this.J.setNegativeButton(R.string.obfuscated_res_0x7f0f058b, new v0(this));
            this.J.setOnCalcelListener(new w0(this));
            this.J.create(this.f.getPageContext()).show();
        }
        EditText editText = (EditText) this.L.findViewById(R.id.obfuscated_res_0x7f09112c);
        this.M = editText;
        editText.setText("");
        TextView textView = (TextView) this.L.findViewById(R.id.obfuscated_res_0x7f090830);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a2), Integer.valueOf(h2)));
        this.f.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.M, 150);
    }

    public void R2(SparseArray<Object> sparseArray, boolean z2) {
        int i2;
        s45 s45Var;
        s45 s45Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048663, this, sparseArray, z2) == null) {
            w45 w45Var = new w45(this.f.getContext());
            w45Var.t(this.f.getString(R.string.obfuscated_res_0x7f0f0322));
            w45Var.q(new b0(this, z2));
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
                    s45Var2 = new s45(10, this.f.getString(R.string.obfuscated_res_0x7f0f0555), w45Var);
                } else {
                    s45Var2 = new s45(10, this.f.getString(R.string.obfuscated_res_0x7f0f0546), w45Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                s45Var2.d.setTag(sparseArray2);
                arrayList.add(s45Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                s45 s45Var3 = new s45(13, this.f.getString(R.string.multi_delete), w45Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                s45Var3.d.setTag(sparseArray3);
                arrayList.add(s45Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                s45 s45Var4 = new s45(11, this.f.getString(R.string.forbidden_person), w45Var);
                s45Var4.d.setTag(sparseArray4);
                arrayList.add(s45Var4);
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
                    s45Var = new s45(12, this.f.getString(R.string.un_mute), w45Var);
                } else {
                    s45Var = new s45(12, this.f.getString(R.string.obfuscated_res_0x7f0f0cf9), w45Var);
                }
                s45Var.d.setTag(sparseArray5);
                arrayList.add(s45Var);
            }
            zj9.e(arrayList);
            w45Var.m(arrayList, true);
            u45 u45Var = new u45(this.f.getPageContext(), w45Var);
            this.X = u45Var;
            u45Var.l();
        }
    }

    public final void X2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        boolean z3;
        int measuredHeight;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048691, this, pbReplyTitleViewHolder, z2) == null) && !this.p1 && this.a1 != null && this.k.j() != null) {
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
                b4(false);
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
                    this.k.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.f1) {
                    this.a1.setVisibility(0);
                    b4(false);
                } else if (top < measuredHeight) {
                    this.a1.setVisibility(0);
                    b4(false);
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

    public final void Z1(td9 td9Var, vb5 vb5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048698, this, td9Var, vb5Var) == null) && this.R1 != null && td9Var != null && vb5Var != null && this.f.getContext() != null) {
            if (!RightFloatLayerView.k()) {
                N1();
                return;
            }
            if (this.Q1 == null) {
                RightFloatLayerView E = RightFloatLayerLottieView.E(vb5Var, this.f.getContext());
                this.Q1 = E;
                E.setPageContext(this.f.getPageContext());
                this.R1.removeAllViews();
                this.R1.addView(this.Q1);
            }
            if ((this.P1.getTag() instanceof Boolean) && !((Boolean) this.P1.getTag()).booleanValue()) {
                this.Q1.setAutoCompleteShown(false);
                this.Q1.setTag(this.P1);
                this.Q1.c();
            }
            if (vb5Var.a()) {
                return;
            }
            this.Q1.setData(vb5Var);
            this.Q1.setLogoListener(new r0(this, vb5Var));
            this.Q1.setFeedBackListener(new b1(this, vb5Var));
        }
    }

    public final void a4(td9 td9Var) {
        boolean z2;
        StyleContentInfo styleContentInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, td9Var) == null) {
            if (td9Var != null && td9Var.K() != null) {
                RobotEntrance K = td9Var.K();
                if (!ListUtils.isEmpty(K.robot_skill_info) && !ListUtils.isEmpty(K.bottom_bar_robot_skill)) {
                    if (!ListUtils.isEmpty(K.bottom_bar_robot_skill)) {
                        CallRobotEntrance c2 = BotEntranceManager.h().c(K.robot_skill_info, K.bottom_bar_robot_skill);
                        this.W1 = c2;
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
                            StyleConf styleConf = this.W1.style_conf;
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
                            layoutParams.addRule(0, R.id.obfuscated_res_0x7f091a91);
                            this.F0.setLayoutParams(layoutParams);
                            this.J0.setClickCallBack(this.Z1);
                            this.J0.setCallRobotEntranceData(new k15(this.W1, styleContentInfo2, styleContentInfo, z2));
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

    public final void b3(td9 td9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048708, this, td9Var) == null) && td9Var != null && td9Var.O() != null) {
            P4(td9Var);
            ImageView imageView = this.F0;
            if (imageView != null && imageView.getContext() != null) {
                if (td9Var.q()) {
                    WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
                } else {
                    WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            String S0 = S0(td9Var.O().getReply_num());
            TextView textView = this.M0;
            if (textView != null) {
                textView.setText(S0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, td9Var.O()));
            a3(td9Var.O().getAgreeData(), td9Var.O().getAgreeNum());
            if (this.E0 != null && td9Var.O() != null) {
                this.E0.setThreadData(td9Var.O());
                int i2 = 1;
                if (td9Var.O().getAgreeData() != null) {
                    td9Var.O().getAgreeData().isInThread = true;
                }
                this.E0.setData(td9Var.O().getAgreeData());
                w05 w05Var = new w05();
                w05Var.b = 26;
                if (td9Var.O().isVideoThreadType() && td9Var.O().getThreadVideoInfo() != null) {
                    i2 = 2;
                }
                w05Var.c = i2;
                PbFragment pbFragment = this.f;
                if (pbFragment != null && pbFragment.R() != null) {
                    w05Var.j = this.f.R().getFromForumId();
                    w05Var.f = this.f.R().r1();
                }
                this.E0.setStatisticData(w05Var);
            }
        }
    }

    public void d2(td9 td9Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, td9Var) == null) {
            int i2 = 0;
            this.I.n0(td9Var, false);
            this.I.f0();
            I0();
            yf9 yf9Var = this.y1;
            if (yf9Var != null) {
                yf9Var.m();
            }
            ArrayList<rba> F = td9Var.F();
            if (td9Var.y().b() == 0 || F == null || F.size() < td9Var.y().e()) {
                if (o2(td9Var)) {
                    g1 g1Var = this.h1;
                    if (g1Var != null && (pbReplyTitleViewHolder = g1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.h1.a.getView().getTop() < 0) {
                            bottom = this.h1.a.getView().getHeight();
                        } else {
                            bottom = this.h1.a.getView().getBottom();
                        }
                        i2 = bottom;
                    }
                    if (this.f.e6()) {
                        this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fe4), i2);
                    } else {
                        this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fe5), i2);
                    }
                } else {
                    if (td9Var.y().b() == 0) {
                        this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
                    } else {
                        this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.O.n();
                }
            }
            b3(td9Var);
        }
    }

    public void d4(td9 td9Var) {
        rba rbaVar;
        rk9 rk9Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048717, this, td9Var) == null) && td9Var != null && (rbaVar = this.S0) != null && rbaVar.r() != null && (rk9Var = this.k) != null) {
            boolean z3 = !this.p1;
            this.q1 = z3;
            rk9Var.A(z3);
            if (this.f.K5() != null) {
                this.f.K5().s(this.q1);
            }
            Y2();
            PbFragment pbFragment = this.f;
            if (pbFragment != null && !pbFragment.A0() && !ListUtils.isEmpty(td9Var.o())) {
                s35 s35Var = td9Var.o().get(0);
                if (s35Var != null) {
                    this.k.D(td9Var, s35Var.d(), s35Var.b(), s35Var.a(), s35Var.f());
                }
            } else if (td9Var.k() != null) {
                rk9 rk9Var2 = this.k;
                String name = td9Var.k().getName();
                String id = td9Var.k().getId();
                String image_url = td9Var.k().getImage_url();
                if (td9Var.k().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                rk9Var2.D(td9Var, name, id, image_url, z2);
            }
            if (this.q1) {
                this.x.Q(td9Var, this.S0, this.m0);
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
            this.x.Q(td9Var, this.S0, this.m0);
            this.z1 = null;
            PbLandscapeListView pbLandscapeListView2 = this.o;
            if (pbLandscapeListView2 != null) {
                pbLandscapeListView2.setListViewDragListener(null);
            }
        }
    }

    public void h4(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048733, this, view2) != null) || SharedPrefHelper.getInstance().getBoolean("show_long_press_collection_tips", false)) {
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
        textView.setText(R.string.obfuscated_res_0x7f0f04cd);
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

    public void r4(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048774, this, onItemClickListener) == null) {
            p45 p45Var = this.k0;
            if (p45Var != null) {
                p45Var.d();
                this.k0 = null;
            }
            if (this.R0 == null) {
                return;
            }
            ArrayList<y45> arrayList = new ArrayList<>();
            String string = this.f.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.R0.J() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new y45(string, "", z2, Integer.toString(1)));
            String string2 = this.f.getContext().getString(R.string.my_fans);
            if (this.R0.J() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new y45(string2, "", z3, Integer.toString(5)));
            String string3 = this.f.getContext().getString(R.string.my_attentions);
            if (this.R0.J() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new y45(string3, "", z4, Integer.toString(6)));
            String string4 = this.f.getContext().getString(R.string.myself_only);
            if (this.R0.J() == 4) {
                z5 = true;
            }
            arrayList.add(new y45(string4, "", z5, Integer.toString(7)));
            p45 p45Var2 = new p45(this.f.getPageContext());
            p45Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.k0 = p45Var2;
            p45Var2.k(arrayList, onItemClickListener);
            p45Var2.c();
            this.k0.n();
        }
    }

    public void c3(int i2, td9 td9Var, boolean z2, int i3) {
        rba X;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048712, this, new Object[]{Integer.valueOf(i2), td9Var, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) && i2 > 0 && td9Var != null && (X = td9Var.X()) != null && X.r() != null) {
            MetaData r3 = X.r();
            r3.setGiftNum(r3.getGiftNum() + i2);
        }
    }

    public final void e4(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048721, this, sparseArray, i2, i3) != null) || this.f == null) {
            return;
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f0546, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03ce, TBAlertConfig.OperateBtnStyle.SECONDARY);
        AlertDialog show = new TBAlertBuilder(this.f.Y()).setTitle(i2).setDesc(i3).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new d0(this, show, sparseArray));
        operateBtnConfig2.setListener(new e0(this, show));
    }

    public final void s0(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048775, this, new Object[]{str, str2, Long.valueOf(j2)}) != null) || this.R0.O() == null) {
            return;
        }
        uc9.c();
        String c2 = bk9.c(this.R0.O().getFirstPostId(), TbadkCoreApplication.getCurrentPortrait(), System.currentTimeMillis());
        bk9.a(this.f.getPageContext(), str2, j2, this.R0.O().getTid(), this.R0.O().getFirstPostId(), c2, new t(this, str, c2));
    }

    public final void l4(SparseArray<Object> sparseArray, int i2, k36 k36Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048749, this, new Object[]{sparseArray, Integer.valueOf(i2), k36Var, userData, Boolean.valueOf(z2)}) != null) || (pbFragment = this.f) == null) {
            return;
        }
        if (this.F1 == null && this.v != null) {
            this.F1 = new l36(pbFragment.getPageContext(), this.v.c(), k36Var, userData);
        }
        this.F1.F(z2);
        AntiData t5 = this.f.t5();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (t5 != null && t5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = t5.getDelThreadInfoList();
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

    public void q4(n45.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048769, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            u45 u45Var = this.i0;
            if (u45Var != null) {
                u45Var.dismiss();
                this.i0 = null;
            }
            w45 w45Var = new w45(this.f.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new s45(0, this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f04e1), w45Var));
            }
            if (z3) {
                arrayList.add(new s45(1, this.f.getPageContext().getString(R.string.report_text), w45Var));
            } else if (!z2) {
                arrayList.add(new s45(1, this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c3d), w45Var));
            } else {
                arrayList.add(new s45(1, this.f.getPageContext().getString(R.string.remove_mark), w45Var));
            }
            w45Var.l(arrayList);
            w45Var.q(new m0(this, cVar));
            u45 u45Var2 = new u45(this.f.getPageContext(), w45Var);
            this.j0 = u45Var2;
            u45Var2.l();
        }
    }

    public SparseArray<Object> n1(td9 td9Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        rba X;
        boolean z3;
        x15 x15Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048754, this, new Object[]{td9Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (td9Var == null || (X = td9Var.X()) == null) {
                return null;
            }
            String userId = X.r().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
            } else {
                z3 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, X.S());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(td9Var.W()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (X.r() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, X.r().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, X.r().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, X.r().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, X.S());
                }
                sparseArray.put(R.id.tag_del_post_id, X.S());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(td9Var.W()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<s35> o3 = td9Var.o();
                if (ListUtils.getCount(o3) > 0) {
                    sb = new StringBuilder();
                    for (s35 s35Var : o3) {
                        if (s35Var != null && !StringUtils.isNull(s35Var.d()) && (x15Var = s35Var.h) != null && x15Var.a && !x15Var.c && ((i3 = x15Var.b) == 1 || i3 == 2)) {
                            sb.append(bi.cutString(s35Var.d(), 12));
                            sb.append(this.f.getString(R.string.obfuscated_res_0x7f0f0774));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.f.getString(R.string.obfuscated_res_0x7f0f053e), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public void n4(td9 td9Var, int i2, int i3, boolean z2, int i4, boolean z3) {
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
        if ((interceptable == null || interceptable.invokeCommon(1048757, this, new Object[]{td9Var, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) && td9Var != null && this.o != null) {
            this.R0 = td9Var;
            this.T0 = i2;
            if (td9Var.O() != null) {
                this.i1 = td9Var.O().getCopyThreadRemindType();
                this.m0 = l2(td9Var.O());
            }
            if (td9Var.V() != null) {
                this.h2 = td9Var.V().getUserId();
            }
            V1(td9Var);
            this.V0 = false;
            this.Q0 = z2;
            L3();
            ee9 ee9Var = td9Var.h;
            if (ee9Var != null && ee9Var.b()) {
                if (this.r == null) {
                    PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f.getContext());
                    this.r = pbThreadPostView;
                    this.o.w(pbThreadPostView, 1);
                    this.r.setData(td9Var);
                    this.r.setChildOnClickLinstener(this.f1092T);
                }
            } else {
                PbThreadPostView pbThreadPostView2 = this.r;
                if (pbThreadPostView2 != null && (pbLandscapeListView = this.o) != null) {
                    pbLandscapeListView.removeHeaderView(pbThreadPostView2);
                }
            }
            o4(td9Var, z2, i2, TbadkCoreApplication.getInst().getSkinType());
            d4(td9Var);
            this.x.R(td9Var, this.S0);
            if (this.C1 == null) {
                this.C1 = new nh9(this.f.getPageContext(), this.D1);
            }
            this.C1.a(td9Var.w());
            if (this.f.C5()) {
                if (this.N == null) {
                    jm9 jm9Var = new jm9(this.f.getPageContext());
                    this.N = jm9Var;
                    jm9Var.i();
                    this.N.a(this.i2);
                }
                this.o.setPullRefresh(this.N);
                jm9 jm9Var2 = this.N;
                if (jm9Var2 != null) {
                    jm9Var2.C(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (td9Var.y().c() == 0 && z2) {
                this.o.setPullRefresh(null);
            } else {
                if (this.N == null) {
                    jm9 jm9Var3 = new jm9(this.f.getPageContext());
                    this.N = jm9Var3;
                    jm9Var3.i();
                    this.N.a(this.i2);
                }
                this.o.setPullRefresh(this.N);
                jm9 jm9Var4 = this.N;
                if (jm9Var4 != null) {
                    jm9Var4.C(TbadkCoreApplication.getInst().getSkinType());
                }
                K1();
            }
            I0();
            this.I.v0(this.Q0);
            this.I.s0(false);
            lg9 lg9Var = this.I;
            if (i2 == 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            lg9Var.t0(z4);
            lg9 lg9Var2 = this.I;
            if (i2 == 6) {
                z5 = true;
            } else {
                z5 = false;
            }
            lg9Var2.u0(z5);
            lg9 lg9Var3 = this.I;
            if (z3 && this.f2 && i2 != 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            lg9Var3.q0(z6);
            this.I.n0(td9Var, false);
            this.I.f0();
            lg9 lg9Var4 = this.I;
            if (td9Var.y().b() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            lg9Var4.h0(z7, td9Var.f());
            this.x.P(td9Var.X(), td9Var.j0());
            if (td9Var.O() != null && td9Var.O().getPraise() != null && this.e != -1) {
                td9Var.O().getPraise().setIsLike(this.e);
            }
            this.o.removeFooterView(this.e1);
            this.o.addFooterView(this.e1);
            if (TbadkCoreApplication.isLogin()) {
                this.o.setNextPage(this.O);
                this.i = 2;
                K1();
            } else {
                this.V0 = true;
                if (td9Var.y().b() == 1) {
                    if (this.P == null) {
                        PbFragment pbFragment2 = this.f;
                        this.P = new em9(pbFragment2, pbFragment2);
                    }
                    this.o.setNextPage(this.P);
                } else {
                    this.o.setNextPage(this.O);
                }
                this.i = 3;
            }
            ArrayList<rba> F = td9Var.F();
            if (td9Var.y().b() != 0 && F != null && F.size() >= td9Var.y().e()) {
                if (z3) {
                    if (this.f2) {
                        M0();
                        if (td9Var.y().b() != 0) {
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
                if (o2(td9Var)) {
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
                    if (this.f.e6()) {
                        this.O.y(false);
                        if (ListUtils.isEmpty(td9Var.R())) {
                            this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fe4), i5);
                        }
                    } else if (ListUtils.isEmpty(td9Var.R())) {
                        this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fe5), i5);
                    }
                    if (this.f.K5() != null && !this.f.K5().p()) {
                        this.f.K5().x();
                    }
                } else {
                    if (td9Var.y().b() == 0) {
                        rba rbaVar = (rba) ListUtils.getItem(F, ListUtils.getCount(F) - 1);
                        if (rbaVar != null) {
                            rbaVar.P = false;
                        }
                        this.O.E(-UtilHelper.getDimenPixelSize(R.dimen.tbds36));
                        this.o.setClipChildren(false);
                        this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
                    } else {
                        this.O.E(0);
                        this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.O.n();
                }
                if (td9Var.y().b() == 0 || F == null) {
                    f3();
                }
            }
            switch (i2) {
                case 2:
                    if (this.o.getData() == null && td9Var.F() == null) {
                        size = 0;
                    } else {
                        size = (this.o.getData().size() - td9Var.F().size()) + this.o.getHeaderViewsCount();
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
                    if (i4 == 1 && (e2 = th9.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
                        this.o.post(new t0(this, e2, F, td9Var));
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
                    if (i4 == 1 && (e3 = th9.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
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
                    } else if (ListUtils.isEmpty(td9Var.R())) {
                        if (this.o.getData() == null && td9Var.F() == null) {
                            size2 = 0;
                        } else {
                            size2 = (this.o.getData().size() - td9Var.F().size()) + this.o.getHeaderViewsCount();
                        }
                        PbLandscapeListView pbLandscapeListView3 = this.o;
                        if (i3 > 0) {
                            i7 = i3 + size2;
                        } else {
                            i7 = 0;
                        }
                        pbLandscapeListView3.setSelection(i7);
                    } else {
                        this.o.setSelection(td9Var.F().size() + this.o.getHeaderViewsCount());
                    }
                    this.O.g();
                    this.O.H(this.f.getString(R.string.obfuscated_res_0x7f0f0fde));
                    this.O.E(0);
                    this.O.B();
                    break;
            }
            if (this.i1 == n2 && j2()) {
                C0();
            }
            if (this.n1) {
                Z2();
                this.n1 = false;
                if (i4 == 0) {
                    B3(true);
                }
            }
            if (td9Var.d == 1 || td9Var.e == 1) {
                if (this.t1 == null) {
                    this.t1 = new PbTopTipView(this.f.getContext());
                }
                if (td9Var.e == 1 && "game_guide".equals(this.f.O5())) {
                    this.t1.setText(this.f.getString(R.string.obfuscated_res_0x7f0f0ff0));
                    this.t1.l(this.g, this.U0);
                } else if (td9Var.d == 1 && "game_news".equals(this.f.O5())) {
                    this.t1.setText(this.f.getString(R.string.obfuscated_res_0x7f0f0fef));
                    this.t1.l(this.g, this.U0);
                }
            }
            c2(td9Var);
            int i8 = this.c;
            if (i8 == -1) {
                i8 = c1();
            }
            this.c = i8;
            this.o.removeFooterView(this.N1.a());
            if (!ListUtils.isEmpty(td9Var.H()) && td9Var.y().b() == 0) {
                this.o.removeFooterView(this.e1);
                this.N1.d(Math.max(this.y0.getMeasuredHeight(), this.O0 / 2));
                this.o.addFooterView(this.N1.a());
                this.N1.f(td9Var);
            }
            b3(td9Var);
            if (td9Var.h0() && this.f.R().k2() && this.f.L5() != null) {
                this.f.L5().d();
            }
            if (td9Var.f() != 3) {
                a2(td9Var);
            }
            this.B0.setText(TbSingleton.getInstance().getAdVertiComment(td9Var.q0(), td9Var.r0(), x1()));
            if (this.s != null) {
                td9 td9Var2 = this.R0;
                if (td9Var2 != null && td9Var2.k() != null && (pbFragment = this.f) != null && pbFragment.R() != null) {
                    this.s.r(this.f.R().b);
                }
                td9 td9Var3 = this.R0;
                if (td9Var3 != null && td9Var3.O() != null && !ListUtils.isEmpty(this.R0.O().getThreadRecommendInfoDataList()) && this.R0.O().getThreadRecommendInfoDataList().get(0) != null && this.R0.O().getThreadRecommendInfoDataList().get(0).businessType != 1) {
                    this.s.q(this.R0.O().getThreadRecommendInfoDataList().get(0));
                } else {
                    this.s.q(null);
                }
            }
            if (this.D != null && this.R0.k() != null) {
                this.D.o(this.R0.k().getSpritePBGuide(), this.R0.k().getImage_url(), this.R0.k().getId());
            }
            if (S3()) {
                this.B.e(this.R0.O());
            } else {
                this.B.d(this.o);
            }
            a4(this.R0);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void o4(td9 td9Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048761, this, new Object[]{td9Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && td9Var != null && td9Var.O() != null) {
            PbFragment pbFragment = this.f;
            if (pbFragment != null && bi9.D(pbFragment)) {
                this.x.G(this.o);
                this.w.h(this.o);
            }
            if (this.f.A0()) {
                if (td9Var.g() != null) {
                    this.n0 = td9Var.g().d();
                    this.o0 = td9Var.g().b();
                }
                if (this.n0 == null && this.f.R() != null && this.f.R().R0() != null) {
                    this.n0 = this.f.R().R0();
                }
            }
            rba X = td9Var.X();
            J3(X, td9Var);
            int i4 = 8;
            this.x.M(8);
            int i5 = 1;
            if (td9Var.x0()) {
                this.p1 = true;
                this.k.u(true);
                this.k.a.hideBottomLine();
            } else {
                this.p1 = false;
                this.k.u(false);
            }
            if (this.f.K5() != null) {
                this.f.K5().w(this.p1);
            }
            if (X == null) {
                return;
            }
            this.S0 = X;
            this.x.M(0);
            this.y.e(td9Var, this.o);
            this.A.e(td9Var, this.J1, new p0(this));
            this.w.j(td9Var);
            this.v.h(td9Var, this.Q0);
            this.v.g(td9Var);
            this.x.N(this.U0, this.R0, X, this.g2);
            if (this.d1 != null) {
                if (td9Var.j0()) {
                    this.d1.getView().setVisibility(8);
                } else {
                    this.d1.getView().setVisibility(0);
                    ie9 ie9Var = new ie9(ie9.g);
                    ie9Var.b = td9Var.g;
                    ie9Var.c = this.f.e6();
                    ie9Var.e = td9Var.f;
                    ie9Var.f = td9Var.O().isQuestionThread();
                    this.d1.j(ie9Var);
                }
            }
            A4(X);
            B4(td9Var);
            SafeHandler.getInst().post(new q0(this));
            this.z.f(this.o);
            if (X.f1156T) {
                this.z.g(X.S());
                PbLandscapeListView pbLandscapeListView = this.o;
                this.z.c(this.o, (pbLandscapeListView == null || pbLandscapeListView.getHeaderViewsCount() <= 1) ? 0 : 0);
            }
            lg9 lg9Var = this.I;
            if (lg9Var != null && lg9Var.B() != null) {
                this.I.B().W(X.f1156T);
            }
            lg9 lg9Var2 = this.I;
            if (lg9Var2 != null) {
                lg9Var2.y0(X.f1156T);
            }
            MaskView maskView = this.O1;
            if (X.f1156T) {
                i4 = 0;
            }
            maskView.setVisibility(i4);
        }
    }

    public void p4(n45.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048765, this, cVar, z2) == null) {
            u45 u45Var = this.j0;
            if (u45Var != null) {
                u45Var.dismiss();
                this.j0 = null;
            }
            w45 w45Var = new w45(this.f.getContext());
            ArrayList arrayList = new ArrayList();
            td9 td9Var = this.R0;
            if (td9Var != null && td9Var.O() != null && !this.R0.O().isBjh()) {
                arrayList.add(new s45(0, this.f.getPageContext().getString(R.string.save_to_emotion), w45Var));
            }
            if (!z2) {
                arrayList.add(new s45(1, this.f.getPageContext().getString(R.string.save_to_local), w45Var));
            }
            w45Var.l(arrayList);
            w45Var.q(new n0(this, cVar));
            u45 u45Var2 = new u45(this.f.getPageContext(), w45Var);
            this.j0 = u45Var2;
            u45Var2.l();
        }
    }

    public final void s2(CallRobotEntrance callRobotEntrance, boolean z2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048777, this, callRobotEntrance, z2) != null) || callRobotEntrance == null) {
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
        td9 td9Var = this.R0;
        if (td9Var == null) {
            str = "";
        } else {
            threadData = td9Var.O();
            str = this.R0.l();
        }
        if (threadData == null) {
            str2 = "";
        } else {
            str2 = String.valueOf(threadData.getTid());
        }
        CommonStatisticUtils.statisticBotSkillMenu(2, abilityConf.bot_uk, 4, z2, str, str4, str2);
    }

    public void y2(int i2) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048807, this, i2) != null) || this.U0 == i2) {
            return;
        }
        this.U0 = i2;
        C4(this.R0, this.Q0);
        d3(this.R0, this.Q0, this.T0, i2);
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
        yi9 yi9Var = this.y;
        if (yi9Var != null) {
            yi9Var.c(i2);
        }
        xi9 xi9Var = this.v;
        if (xi9Var != null) {
            xi9Var.e(i2);
        }
        zi9 zi9Var = this.w;
        if (zi9Var != null) {
            zi9Var.g(i2);
        }
        bj9 bj9Var = this.x;
        if (bj9Var != null) {
            bj9Var.C(i2);
        }
        aj9 aj9Var = this.z;
        if (aj9Var != null) {
            aj9Var.e();
        }
        wi9 wi9Var = this.A;
        if (wi9Var != null) {
            wi9Var.c();
        }
        MaskView maskView = this.O1;
        if (maskView != null) {
            maskView.f();
        }
        yh9 yh9Var = this.s;
        if (yh9Var != null) {
            yh9Var.o();
        }
        tg9 tg9Var = this.D;
        if (tg9Var != null) {
            tg9Var.n();
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
        m45 m45Var = this.J;
        if (m45Var != null) {
            m45Var.autoChangeSkinType(this.f.getPageContext());
        }
        K4(this.l0);
        this.I.f0();
        jm9 jm9Var = this.N;
        if (jm9Var != null) {
            jm9Var.C(i2);
        }
        EditorTools editorTools = this.r0;
        if (editorTools != null) {
            editorTools.z(i2);
        }
        em9 em9Var = this.P;
        if (em9Var != null) {
            em9Var.g(i2);
        }
        if (!ListUtils.isEmpty(this.q)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.q) {
                customBlueCheckRadioButton.c();
            }
        }
        R4();
        UtilHelper.setStatusBarBackground(this.h, i2);
        UtilHelper.setStatusBarBackground(this.c1, i2);
        if (this.E != null) {
            ks5.a(this.f.getPageContext(), this.E);
        }
        ah9 ah9Var = this.m1;
        if (ah9Var != null) {
            ah9Var.l(i2);
        }
        rk9 rk9Var = this.k;
        if (rk9Var != null) {
            rk9Var.p(i2);
        }
        LinearLayout linearLayout = this.z0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(this.f.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        td9 td9Var = this.R0;
        if (td9Var != null && td9Var.q()) {
            WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.D0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.A0, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        P4(this.R0);
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
            this.E0.Q(i2);
            AgreeData data = this.E0.getData();
            if (data != null) {
                a3(data, data.agreeNum);
            }
        }
        yf9 yf9Var = this.y1;
        if (yf9Var != null) {
            yf9Var.l(i2);
        }
        PbThreadPostView pbThreadPostView = this.r;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i2);
        }
        CardForumHeadLayout cardForumHeadLayout = this.b;
        if (cardForumHeadLayout != null) {
            cardForumHeadLayout.g();
            EMManager.from(this.b).setCorner(R.string.J_X05).setBackGroundRealColor(y9a.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
        }
        im9 im9Var = this.K0;
        if (im9Var != null) {
            im9Var.i();
        }
        hm9 hm9Var = this.N1;
        if (hm9Var != null) {
            hm9Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.Q1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.n();
        }
        SkinManager.setBackgroundColor(this.b1, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.b1.findViewById(R.id.tv_title), (int) R.color.CAM_X0105);
        LinearLayout linearLayout2 = this.S1;
        if (linearLayout2 != null) {
            EMManager.from(linearLayout2).setBackGroundColor(R.color.CAM_X0201);
        }
        ck9 ck9Var = this.T1;
        if (ck9Var != null) {
            ck9Var.b(i2);
        }
    }
}
