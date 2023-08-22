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
import com.baidu.tieba.al9;
import com.baidu.tieba.bn9;
import com.baidu.tieba.c46;
import com.baidu.tieba.c55;
import com.baidu.tieba.dj9;
import com.baidu.tieba.il9;
import com.baidu.tieba.jg9;
import com.baidu.tieba.lfa;
import com.baidu.tieba.lg9;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.p95;
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
import com.baidu.tieba.s45;
import com.baidu.tieba.t45;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.tieba.z36;
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
/* loaded from: classes6.dex */
public class hm9 {
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
    public static lfa.f v2;
    public transient /* synthetic */ FieldHolder $fh;
    public bn9 A;
    public ImageView A0;
    public boolean A1;
    public PbContentCollectionController B;
    public TextView B0;
    public boolean B1;
    public al9 C;
    public WaterRippleView C0;
    public sl9 C1;
    public yk9 D;
    public ImageView D0;
    public NavigationBarCoverTip D1;
    public LinearLayout E;
    public AgreeView E0;
    public z36 E1;
    public TextView F;
    public ImageView F0;
    public c46 F1;
    public TextView G;
    public ImageView G0;
    public String G1;
    public ObservedChangeRelativeLayout H;
    public HeadImageView H0;
    public PermissionJudgePolicy H1;
    public qk9 I;
    public View I0;
    public boolean I1;
    public s45 J;
    public FriendBotView J0;
    public int J1;
    public t45 K;
    public nq9 K0;
    public int K1;
    public View L;
    public TextView L0;
    public boolean L1;
    public EditText M;
    public TextView M0;
    public boolean M1;
    public oq9 N;
    public boolean N0;
    public mq9 N1;
    public PbListView O;
    public int O0;
    public MaskView O1;
    public jq9 P;
    public BlueCircleProgressDialog P0;
    public final PbFallingView P1;
    public View Q;
    public boolean Q0;
    public RightFloatLayerView Q1;
    public View R;
    public yh9 R0;
    public final FrameLayout R1;
    public View S;
    public zfa S0;
    public LinearLayout S1;

    /* renamed from: T  reason: collision with root package name */
    public View.OnClickListener f1116T;
    public int T0;
    public ho9 T1;
    public SortSwitchButton.f U;
    public int U0;
    public final Object U1;
    public TbRichTextView.z V;
    public boolean V0;
    public Runnable V1;
    public NoNetworkView.b W;
    public boolean W0;
    public CallRobotEntrance W1;
    public a55 X;
    public ViewStub X0;
    public CustomMessageListener X1;
    public View.OnClickListener Y;
    public PbInterviewStatusView Y0;
    public View.OnClickListener Y1;
    public s45 Z;
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
    public a55 i0;
    public int i1;
    public p95.g i2;
    public final Handler j;
    public a55 j0;
    public int j1;
    public View.OnClickListener j2;
    public final wo9 k;
    public v45 k0;
    public Runnable k1;
    public final List<TbImageView> k2;
    public vo9 l;
    public boolean l0;
    public PbFakeFloorModel l1;
    public boolean l2;
    public ViewStub m;
    public boolean m0;
    public fl9 m1;
    public ViewStub n;
    public String n0;
    public boolean n1;
    public PbLandscapeListView o;
    public String o0;
    public int o1;
    public NoNetworkView p;
    public fj9 p0;
    public boolean p1;
    public List<CustomBlueCheckRadioButton> q;
    public ScrollView q0;
    public boolean q1;
    public PbThreadPostView r;
    public EditorTools r0;
    public boolean r1;
    public dm9 s;
    public boolean s0;
    public int s1;
    public il9 t;
    public View t0;
    public PbTopTipView t1;
    public il9 u;
    public View u0;
    public PopupWindow u1;
    public cn9 v;
    public EjectionAnimationView v0;
    public TextView v1;
    public en9 w;
    public Button w0;
    public List<String> w1;
    public gn9 x;
    public View x0;
    public kn9 x1;
    public dn9 y;
    public View y0;
    public dk9 y1;
    public fn9 z;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? R.id.obfuscated_res_0x7f091ab2 : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048811, this)) == null) ? R.id.obfuscated_res_0x7f091f27 : invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class b implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        /* loaded from: classes6.dex */
        public class a implements wh5 {
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

            @Override // com.baidu.tieba.wh5
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

        public b(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.U3();
            yh5.g().c(new a(this));
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

    /* loaded from: classes6.dex */
    public class i implements il9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ hm9 b;

        /* loaded from: classes6.dex */
        public class a implements eh9 {
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

            @Override // com.baidu.tieba.eh9
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

            @Override // com.baidu.tieba.eh9
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

        public i(hm9 hm9Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hm9Var;
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.il9.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (YunDialogManager.isShowingDialog()) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("BotGuideManager", "底bar点击引导未展示,云弹窗正在展示：" + YunDialogManager.getShowingDialog());
                } else if (hh9.c()) {
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
                                hh9.e(str, this.b.J0, this.a.d0(), new a(this, str));
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

    /* loaded from: classes6.dex */
    public class j implements il9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        /* loaded from: classes6.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.s != null && this.a.a.f.d0() != null) {
                    i55.g(Collections.singletonList(new em9(this.a.a.f.d0(), this.a.a.s)));
                }
            }
        }

        public j(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // com.baidu.tieba.il9.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.W0 && !this.a.f.M6() && this.a.o != null) {
                this.a.o.post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbReplyTitleViewHolder b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ hm9 g;

        /* loaded from: classes6.dex */
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

        public l(hm9 hm9Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = hm9Var;
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

    /* loaded from: classes6.dex */
    public class n implements al9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        /* loaded from: classes6.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.D != null && this.b.a.f.d0() != null) {
                    this.b.a.D.q(this.a);
                    i55.g(Collections.singletonList(new bl9(this.b.a.f.d0(), this.b.a.D)));
                }
            }
        }

        public n(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // com.baidu.tieba.al9.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && !this.a.f.M6() && !this.a.d && this.a.o != null) {
                this.a.o.post(new a(this, i));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        /* loaded from: classes6.dex */
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

        public w0(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
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

    /* loaded from: classes6.dex */
    public class a implements xi9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        @Override // com.baidu.tieba.xi9
        public /* synthetic */ void onStart() {
            wi9.a(this);
        }

        public a(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // com.baidu.tieba.xi9
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.v0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public a0(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
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
                    hm9 hm9Var = this.a;
                    hm9Var.x1 = new kn9(hm9Var.f.getPageContext(), this.a.g, layoutParams);
                    if (!ListUtils.isEmpty(this.a.w1)) {
                        this.a.x1.q(this.a.w1);
                    }
                    this.a.x1.r(this.a.r0);
                }
                this.a.x1.p(substring);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a1 implements PbFallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public a1(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.q
        public void onClick() {
            String x1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null && this.a.f.W() != null && this.a.f.W().c2()) {
                    x1 = this.a.f.getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    x1 = this.a.x1();
                }
                if (!StringUtils.isNull(x1) && this.a.R0 != null) {
                    x1 = TbSingleton.getInstance().getAdVertiComment(this.a.R0.q0(), this.a.R0.r0(), x1);
                }
                if (this.a.f != null && this.a.f.V5() != null) {
                    this.a.f.V5().d0(x1);
                }
                if (this.a.B0 != null) {
                    this.a.B0.setText(x1);
                }
                this.a.c4(false);
                this.a.w4();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements c55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ hm9 b;

        public b0(hm9 hm9Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hm9Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.c55.f
        public void J0(c55 c55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, c55Var, i, view2) == null) {
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
                        this.b.f.e6(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
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

    /* loaded from: classes6.dex */
    public class b1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cc5 a;
        public final /* synthetic */ hm9 b;

        public b1(hm9 hm9Var, cc5 cc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, cc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hm9Var;
            this.a = cc5Var;
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

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public c(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.E0 != null && this.a.E0.getData() != null) {
                hm9 hm9Var = this.a;
                hm9Var.a3(hm9Var.E0.getData(), this.a.E0.getData().agreeNum);
                if (!this.a.E0.K()) {
                    hm9 hm9Var2 = this.a;
                    hm9Var2.T2(hm9Var2.E0);
                }
                if (this.a.R0 != null && this.a.R0.O() != null && this.a.R0.O().isExcellentThread() && BreatheTipWidget.f()) {
                    qf5.a("c15279", this.a.R0.Q(), this.a.R0.l(), "1");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                s45Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c1 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ hm9 b;

        public c1(hm9 hm9Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hm9Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.b.L1 && this.a != null && this.b.f.W() != null && this.b.f.W().g2()) {
                    this.b.L1 = true;
                    this.a.m5(false);
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

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public d(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.I0.getVisibility() == 0) {
                    if (this.a.f != null && this.a.f.U1()) {
                        return;
                    }
                    SharedPrefHelper.getInstance().putBoolean("pb_share_red_dot_shown", true);
                    this.a.I0.setVisibility(8);
                }
                this.a.f1116T.onClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ hm9 c;

        public d0(hm9 hm9Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hm9Var;
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
                    BdUtilHelper.showToast(this.c.f.d0(), (int) R.string.obfuscated_res_0x7f0f0e29);
                } else {
                    this.c.f.y5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d1 implements dj9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public d1(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // com.baidu.tieba.dj9.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f.h6();
            }
        }

        @Override // com.baidu.tieba.dj9.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.o != null) {
                this.a.o.setSelection(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public e(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
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
                    this.a.f.o5(sparseArray);
                    return;
                }
                this.a.S2(view2);
            } else if (z2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.a.f.o5(sparseArray);
            } else if (z3) {
                this.a.N2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public e0(hm9 hm9Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, alertDialog};
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

    /* loaded from: classes6.dex */
    public class e1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyPrivacyCheckController a;
        public final /* synthetic */ ek5 b;
        public final /* synthetic */ hm9 c;

        public e1(hm9 hm9Var, ReplyPrivacyCheckController replyPrivacyCheckController, ek5 ek5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, replyPrivacyCheckController, ek5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hm9Var;
            this.a = replyPrivacyCheckController;
            this.b = ek5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null && this.c.f != null && this.c.f.F5() != null && !this.a.checkPrivacyBeforeInvokeEditor(this.c.f.F5().replyPrivateFlag)) {
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

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public f(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ hm9 c;

        public f0(hm9 hm9Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hm9Var;
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
                    BdUtilHelper.showToast(this.c.f.d0(), (int) R.string.obfuscated_res_0x7f0f0e29);
                } else {
                    this.c.f.y5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public f1(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.H2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public g(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(zfa zfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zfaVar) == null) {
                this.a.l1.e0(zfaVar);
                this.a.I.f0();
                this.a.m1.g();
                this.a.r0.t();
                this.a.c4(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g0 implements lfa.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.lfa.f
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class h implements PbFallingView.r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public h(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
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

    /* loaded from: classes6.dex */
    public class h0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public h0(hm9 hm9Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, alertDialog};
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

    /* loaded from: classes6.dex */
    public class i0 implements z36.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s45 a;
        public final /* synthetic */ hm9 b;

        public i0(hm9 hm9Var, s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, s45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hm9Var;
            this.a = s45Var;
        }

        @Override // com.baidu.tieba.z36.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.f.z5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j0 implements c46.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ hm9 b;

        public j0(hm9 hm9Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hm9Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.c46.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.f.y5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(hm9 hm9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, Integer.valueOf(i)};
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
            this.a = hm9Var;
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

    /* loaded from: classes6.dex */
    public class k0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public k0(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
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

    /* loaded from: classes6.dex */
    public class l0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public l0(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.b0 instanceof Dialog)) {
                jg.b(this.a.b0, this.a.f.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements lg9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public m(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // com.baidu.tieba.lg9.a
        public void a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (this.a.f != null && this.a.f.W() != null) {
                    this.a.f.W().o3();
                }
                if (this.a.W1 != null) {
                    this.a.J0.k(this.a.W1);
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07f7);
                }
                go9.d(str, str2, str3, 3);
                this.a.I.f0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m0 implements c55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t45.c a;
        public final /* synthetic */ hm9 b;

        public m0(hm9 hm9Var, t45.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hm9Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.c55.f
        public void J0(c55 c55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, c55Var, i, view2) == null) {
                this.b.j0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n0 implements c55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t45.c a;
        public final /* synthetic */ hm9 b;

        public n0(hm9 hm9Var, t45.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hm9Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.c55.f
        public void J0(c55 c55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, c55Var, i, view2) == null) {
                this.b.j0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public o(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.I0.getVisibility() == 0) {
                    SharedPrefHelper.getInstance().putBoolean("pb_share_red_dot_shown", true);
                    this.a.I0.setVisibility(8);
                }
                this.a.f1116T.onClick(this.a.G0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public o0(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
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
                if (this.a.f.d0() != null) {
                    this.a.f.d0().c.b.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
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

    /* loaded from: classes6.dex */
    public class p0 implements bn9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public p0(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // com.baidu.tieba.bn9.a
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

    /* loaded from: classes6.dex */
    public class q implements FriendBotView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public q(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
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
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) != null) || bw5.a()) {
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
                hm9 hm9Var = this.a;
                hm9Var.s0(str, hm9Var.W1.ability_conf.bot_uk, this.a.W1.ability_conf.skill_id.intValue());
            } else {
                go9.e(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public q0(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            hm9 hm9Var;
            wo9 wo9Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.I != null && (wo9Var = (hm9Var = this.a).k) != null && wo9Var.k != null && hm9Var.R0 != null && this.a.R0.O() != null && !this.a.R0.O().isVideoThreadType() && !this.a.n2() && this.a.R0.k() != null && !di.isEmpty(this.a.R0.k().getName())) {
                if ((this.a.I.L() == null || !this.a.I.L().isShown()) && (linearLayout = this.a.k.k) != null) {
                    linearLayout.setVisibility(0);
                    this.a.k.h();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements jg9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public r(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // com.baidu.tieba.jg9.b
        public void a(@NonNull CallRobotEntrance callRobotEntrance) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, callRobotEntrance) != null) || this.a.J0 == null) {
                return;
            }
            boolean o = this.a.J0.o();
            this.a.s2(callRobotEntrance, o);
            if (o) {
                go9.e(this.a.J0.getLoadingToast());
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
                this.a.J0.setCallRobotEntranceData(new q15(callRobotEntrance, styleConf.day, styleConf.dark, false));
            }
            this.a.O4();
            hm9 hm9Var = this.a;
            hm9Var.s0(hm9Var.J0.getLoadingToast(), abilityConf.bot_uk, abilityConf.skill_id.intValue());
        }
    }

    /* loaded from: classes6.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cc5 a;
        public final /* synthetic */ hm9 b;

        public r0(hm9 hm9Var, cc5 cc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, cc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hm9Var;
            this.a = cc5Var;
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

    /* loaded from: classes6.dex */
    public class s implements eh9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ hm9 b;

        public s(hm9 hm9Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hm9Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.eh9
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

        @Override // com.baidu.tieba.eh9
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

    /* loaded from: classes6.dex */
    public class s0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ hm9 b;

        public s0(hm9 hm9Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hm9Var;
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
                this.b.f.showToast(R.string.obfuscated_res_0x7f0f0e29);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ hm9 d;

        public t(hm9 hm9Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = hm9Var;
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
                if (this.d.f.W() != null) {
                    this.d.f.W().o3();
                }
                if (this.d.f.Y5().T0() != null) {
                    this.d.f.Y5().T0().f0();
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
                go9.e(this.b);
                go9.b(this.d.f.W(), this.c);
                if (this.d.V1 != null) {
                    SafeHandler.getInst().removeCallbacks(this.d.V1);
                }
                hm9 hm9Var = this.d;
                hm9Var.V1 = new mg9(this.c, hm9Var.f);
                SafeHandler.getInst().postDelayed(this.d.V1, 30000L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ yh9 c;
        public final /* synthetic */ hm9 d;

        public t0(hm9 hm9Var, Parcelable parcelable, ArrayList arrayList, yh9 yh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, parcelable, arrayList, yh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = hm9Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = yh9Var;
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
                    this.d.O.H(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fe8));
                    this.d.O.B();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements PbFirstFloorDoubleClickAnimation.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public u(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0.X();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public u0(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
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

    /* loaded from: classes6.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(hm9 hm9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, Integer.valueOf(i)};
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
            this.a = hm9Var;
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

    /* loaded from: classes6.dex */
    public class v0 implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public v0(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                this.a.F0();
                s45Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public w(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
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

    /* loaded from: classes6.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(hm9 hm9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, Integer.valueOf(i)};
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
            this.a = hm9Var;
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

    /* loaded from: classes6.dex */
    public class x0 implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public x0(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                s45Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public y(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y0 implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public y0(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                s45Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements ai5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public z(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // com.baidu.tieba.ai5
        public void E(zh5 zh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zh5Var) == null) {
                Object obj = zh5Var.c;
                if ((obj instanceof uc5) && EmotionGroupType.isSendAsPic(((uc5) obj).getType())) {
                    if (this.a.H1 == null) {
                        this.a.H1 = new PermissionJudgePolicy();
                    }
                    this.a.H1.clearRequestPermissionList();
                    this.a.H1.appendRequestPermission(this.a.f.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.H1.startRequestPermission(this.a.f.getBaseFragmentActivity())) {
                        return;
                    }
                    uc5 uc5Var = (uc5) zh5Var.c;
                    this.a.f.V5().f(uc5Var);
                    if (uc5Var.i()) {
                        this.a.f.V5().H(null, null);
                    } else {
                        this.a.f.V5().w(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ hm9 e;

        public z0(hm9 hm9Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = hm9Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947828661, "Lcom/baidu/tieba/hm9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947828661, "Lcom/baidu/tieba/hm9;");
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
            dm9 dm9Var = this.s;
            if (dm9Var != null) {
                dm9Var.j();
            }
            yk9 yk9Var = this.D;
            if (yk9Var != null) {
                yk9Var.g();
            }
            al9 al9Var = this.C;
            if (al9Var != null) {
                al9Var.j();
            }
            RightFloatLayerView rightFloatLayerView = this.Q1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public zfa a1() {
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
            if (this.I.A(Z0) != null && this.I.A(Z0) != zfa.V0) {
                i2 = Z0 + 1;
            }
            if (!(this.I.z(i2) instanceof zfa)) {
                return null;
            }
            return (zfa) this.I.z(i2);
        }
        return (zfa) invokeV.objValue;
    }

    public final int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null && pbLandscapeListView.getData() != null) {
                for (int i2 = 0; i2 < this.o.getData().size(); i2++) {
                    bn bnVar = this.o.getData().get(i2);
                    if (bnVar != null && bnVar.getType() == ai9.k) {
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
            View findViewById = i2.findViewById(R.id.obfuscated_res_0x7f091aa5);
            if (i2.getVisibility() == 0 && findViewById != null && findViewById.getVisibility() == 0) {
                this.d = true;
                TiebaStatic.log(new StatisticItem("c15304").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    public void s4() {
        zfa zfaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048779, this) != null) || !TbadkCoreApplication.isLogin() || this.R0 == null || !this.q1 || this.p1 || this.m0 || (zfaVar = this.S0) == null || zfaVar.r() == null || this.S0.r().getIsLike() || this.S0.r().hadConcerned()) {
        }
    }

    public hm9(PbFragment pbFragment, View.OnClickListener onClickListener, fj9 fj9Var, SortSwitchButton.f fVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, fj9Var, fVar};
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
        this.f1116T = null;
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
        this.f1116T = onClickListener;
        this.U = fVar;
        this.p0 = fj9Var;
        this.s1 = BdUtilHelper.getEquipmentWidth(this.f.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0705, (ViewGroup) null);
        this.g = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.t0 = this.g.findViewById(R.id.obfuscated_res_0x7f09047d);
        this.D1 = (NavigationBarCoverTip) this.g.findViewById(R.id.obfuscated_res_0x7f091b22);
        this.h = this.g.findViewById(R.id.obfuscated_res_0x7f0922d9);
        this.R1 = (FrameLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091f4a);
        this.H = (ObservedChangeRelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0925c6);
        this.p = (NoNetworkView) this.g.findViewById(R.id.view_no_network);
        PbLandscapeListView pbLandscapeListView = (PbLandscapeListView) this.g.findViewById(R.id.obfuscated_res_0x7f09193c);
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
        this.k = new wo9(pbFragment, this.g);
        if (this.f.O5()) {
            ViewStub viewStub = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f0916e1);
            this.m = viewStub;
            viewStub.setVisibility(0);
            vo9 vo9Var = new vo9(pbFragment);
            this.l = vo9Var;
            vo9Var.c();
            this.k.a.setVisibility(8);
            layoutParams.height = BdUtilHelper.getDimens(this.f.getActivity(), R.dimen.obfuscated_res_0x7f070364);
        }
        this.Z0.setLayoutParams(layoutParams);
        this.k.j().setOnTouchListener(new dj9(new d1(this)));
        this.x0 = this.g.findViewById(R.id.obfuscated_res_0x7f092968);
        this.y0 = this.g.findViewById(R.id.obfuscated_res_0x7f091ab6);
        this.O0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703a2);
        this.A0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f09099b);
        this.A0.setOnClickListener(new e1(this, new ReplyPrivacyCheckController(this.f.getPageContext()), this.f.V5()));
        L0();
        this.B0 = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091ab9);
        LinearLayout linearLayout = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091ab0);
        this.z0 = linearLayout;
        linearLayout.setOnClickListener(new f1(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.g.findViewById(R.id.obfuscated_res_0x7f09099f);
        this.v0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new a(this));
        this.D0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091ab7);
        this.O1 = (MaskView) this.g.findViewById(R.id.mask_view);
        this.D0.setOnClickListener(this.f1116T);
        AgreeView agreeView = (AgreeView) this.g.findViewById(R.id.obfuscated_res_0x7f091ab2);
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
        ImageView imageView = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091ab5);
        this.F0 = imageView;
        imageView.setOnClickListener(this.f1116T);
        if (booleanExtra) {
            this.F0.setVisibility(8);
        } else {
            this.F0.setVisibility(0);
        }
        Q1();
        View findViewById = this.g.findViewById(R.id.obfuscated_res_0x7f091abc);
        this.I0 = findViewById;
        if (!SharedPrefHelper.getInstance().getBoolean("pb_share_red_dot_shown", false) && TbadkCoreApplication.isLogin()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        findViewById.setVisibility(i2);
        this.G0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091aba);
        HeadImageView headImageView = (HeadImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091abb);
        this.H0 = headImageView;
        headImageView.setIsRound(true);
        this.H0.setOnClickListener(this.Y1);
        this.G0.setOnClickListener(new d(this));
        v2();
        nq9 nq9Var = new nq9(this.G0);
        this.K0 = nq9Var;
        nq9Var.m(this.H0);
        TextView textView = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091ab8);
        this.M0 = textView;
        textView.setVisibility(0);
        this.L0 = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091ab3);
        this.X0 = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f091189);
        this.E0.setVisibility(0);
        this.L0.setVisibility(0);
        this.v = new cn9(this.f, fj9Var);
        this.x = new gn9(this.f, fj9Var, this.f1116T);
        qk9 qk9Var = new qk9(this.f, this.o);
        this.I = qk9Var;
        qk9Var.E0(this.f1116T);
        this.I.H0(this.p0);
        this.I.B0(this.V);
        this.I.D0(this.U);
        this.I.x0(this.j2);
        e eVar = new e(this);
        this.Y = eVar;
        this.I.z0(eVar);
        b2();
        U1();
        fn9 fn9Var = new fn9(this.f);
        this.z = fn9Var;
        fn9Var.f = 2;
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
            view2.setOnClickListener(this.f1116T);
            SkinManager.setBackgroundResource(this.Q, R.drawable.pb_foot_more_trans_selector);
        }
        View view3 = this.R;
        if (view3 != null) {
            view3.setOnClickListener(this.f1116T);
        }
        this.O.D();
        this.O.r(R.drawable.pb_foot_more_trans_selector);
        this.O.F(R.color.CAM_X0109);
        this.O.s(R.drawable.pb_foot_more_trans_selector);
        this.S = this.g.findViewById(R.id.obfuscated_res_0x7f0929a0);
        this.f.registerListener(this.d2);
        this.l1 = new PbFakeFloorModel(this.f.getPageContext());
        PbModel W = this.f.W();
        this.l1.g0(W.W(), W.S(), W.T(), W.R(), W.X());
        fl9 fl9Var = new fl9(this.f.getPageContext(), this.l1, this.g);
        this.m1 = fl9Var;
        fl9Var.p(new f(this));
        this.m1.s(this.f.o2);
        this.l1.i0(new g(this));
        if (this.f.W() != null && !StringUtils.isNull(this.f.W().v1())) {
            PbFragment pbFragment2 = this.f;
            pbFragment2.showToast(pbFragment2.W().v1());
        }
        this.a1 = this.g.findViewById(R.id.obfuscated_res_0x7f091abe);
        this.b1 = this.g.findViewById(R.id.obfuscated_res_0x7f09047b);
        View findViewById2 = this.g.findViewById(R.id.obfuscated_res_0x7f0922e5);
        this.c1 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.f.W() != null && this.f.W().e1()) {
            this.a1.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.c1.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = m2;
            this.c1.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f.getPageContext(), this.g.findViewById(R.id.obfuscated_res_0x7f091b42));
        this.d1 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.t(pbFragment.d0);
        this.d1.g.setVisibility(8);
        this.d1.s(this.f1116T);
        this.d1.r(this.U);
        this.f.registerListener(this.a2);
        PbFragment pbFragment3 = this.f;
        this.N1 = new mq9(pbFragment3, pbFragment3.getUniqueId());
        this.P1 = (PbFallingView) this.g.findViewById(R.id.obfuscated_res_0x7f090af1);
        p3();
        this.P1.setAnimationListener(new h(this));
        A0();
        this.u0 = this.g.findViewById(R.id.obfuscated_res_0x7f091aa6);
        z0(YoungsterVerifyUtils.isYoungsterOpen());
        this.s = new dm9(this.f.d0(), (ViewGroup) E1().findViewById(R.id.obfuscated_res_0x7f091b55));
        il9 il9Var = new il9(this.o, -2);
        this.u = il9Var;
        il9Var.d(new i(this, pbFragment));
        il9 il9Var2 = new il9(this.o, 5);
        this.t = il9Var2;
        il9Var2.d(new j(this));
        this.S1 = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f09282c);
        this.T1 = new ho9(this.f.getActivity());
        Y1();
        dt6.b().a(this.U1, new lg9(new m(this)));
    }

    public void A3(String str) {
        vo9 vo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (vo9Var = this.l) != null) {
            vo9Var.b(str);
        }
    }

    public final void A4(zfa zfaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, zfaVar) == null) && zfaVar != null) {
            this.B1 = !StringUtils.isNull(zfaVar.f0());
            gn9 gn9Var = this.x;
            if (gn9Var != null) {
                gn9Var.t(zfaVar);
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

    public void G2(en enVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, enVar) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.b0 = enVar;
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
            dk9 dk9Var = this.y1;
            if (dk9Var != null) {
                dk9Var.q(onLongClickListener);
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
            kn9 kn9Var = this.x1;
            if (kn9Var != null) {
                kn9Var.q(list);
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

    public void T4(yh9 yh9Var) {
        cn9 cn9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048675, this, yh9Var) == null) && (cn9Var = this.v) != null) {
            cn9Var.h(yh9Var, this.Q0);
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

    public final boolean f2(yh9 yh9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048723, this, yh9Var)) == null) {
            return gm9.x(yh9Var);
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
        qk9 qk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048788, this, z2) == null) && (qk9Var = this.I) != null) {
            qk9Var.p0(z2);
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

    public void y3(p95.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048808, this, gVar) == null) {
            this.i2 = gVar;
            oq9 oq9Var = this.N;
            if (oq9Var != null) {
                oq9Var.a(gVar);
            }
        }
    }

    public void z3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048813, this, onClickListener) == null) {
            this.j2 = onClickListener;
            qk9 qk9Var = this.I;
            if (qk9Var != null) {
                qk9Var.x0(onClickListener);
            }
        }
    }

    @SuppressLint({"CutPasteId"})
    public void C4(yh9 yh9Var, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048590, this, yh9Var, z2) != null) || yh9Var == null) {
            return;
        }
        Q4(yh9Var, z2);
        I0();
    }

    public final void J3(zfa zfaVar, yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, zfaVar, yh9Var) == null) {
            this.x.J(zfaVar, yh9Var);
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
            dk9 dk9Var = new dk9(this.f, this, (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f0917a6));
            this.y1 = dk9Var;
            dk9Var.n(this.f1116T);
            this.y1.o(this.Y);
            this.y1.p(this.V);
            this.y1.n(this.f1116T);
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
            a55 a55Var = this.i0;
            if (a55Var != null) {
                a55Var.dismiss();
            }
            J0();
            s45 s45Var = this.J;
            if (s45Var != null) {
                s45Var.dismiss();
            }
            t45 t45Var = this.K;
            if (t45Var != null) {
                t45Var.e();
            }
        }
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            s45 s45Var = this.Z;
            if (s45Var != null) {
                s45Var.dismiss();
            }
            Dialog dialog = this.a0;
            if (dialog != null) {
                jg.b(dialog, this.f.getPageContext());
            }
            Dialog dialog2 = this.b0;
            if (dialog2 != null) {
                jg.b(dialog2, this.f.getPageContext());
            }
            a55 a55Var = this.X;
            if (a55Var != null) {
                a55Var.dismiss();
            }
        }
    }

    public final void N4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && (pbFragment = this.f) != null && pbFragment.V5() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.f.V5().z())));
        }
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            this.J0 = (FriendBotView) this.g.findViewById(R.id.obfuscated_res_0x7f091ab4);
            PbFragment pbFragment = this.f;
            if (pbFragment != null && pbFragment.W() != null) {
                this.J0.setTid(this.f.W().Q());
            }
            this.J0.l();
        }
    }

    public final void R4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048665, this) != null) || !this.f.O5()) {
            return;
        }
        if (this.f.T5() == -1) {
            SkinManager.setViewTextColor(this.F, R.color.CAM_X0110, 1);
        }
        if (this.f.S5() == -1) {
            SkinManager.setViewTextColor(this.G, R.color.CAM_X0110, 1);
        }
    }

    public final boolean T3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            PbFragment pbFragment = this.f;
            if (pbFragment == null || pbFragment.W().s1().k().getDeletedReasonInfo() == null || 1 != this.f.W().s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
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
        this.D = new yk9(this.f.d0());
        this.C = new al9(this.o, nVar);
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
            yh9 yh9Var = this.R0;
            if (yh9Var == null || yh9Var.k() == null || "0".equals(this.R0.k().getId())) {
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
            if (pbFragment != null && pbFragment.Y5() != null && this.f.Y5().R0 != null && this.f.Y5().R0.K() != null) {
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
            if (!di.isEmpty(this.G1)) {
                return this.G1;
            }
            if (this.f != null) {
                this.G1 = TbadkCoreApplication.getInst().getResources().getString(gm9.g());
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
        ho9 ho9Var;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (ho9Var = this.T1) != null && (linearLayout = this.S1) != null) {
            ho9Var.c(linearLayout);
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
            wo9 wo9Var = this.k;
            if (wo9Var != null && (view2 = wo9Var.f) != null) {
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
            a55 a55Var = this.i0;
            if (a55Var != null) {
                a55Var.dismiss();
            }
            J0();
            s45 s45Var = this.J;
            if (s45Var != null) {
                s45Var.dismiss();
            }
            t45 t45Var = this.K;
            if (t45Var != null) {
                t45Var.e();
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
        nq9 nq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (nq9Var = this.K0) != null) {
            nq9Var.k(false);
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
            kn9 kn9Var = this.x1;
            if (kn9Var != null) {
                kn9Var.m();
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
            al9 al9Var = this.C;
            if (al9Var != null) {
                al9Var.k();
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
        wo9 wo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (wo9Var = this.k) != null) {
            wo9Var.k();
        }
    }

    public final void J2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (pbFragment = this.f) != null && pbFragment.V5() != null) {
            this.f.V5().F();
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
        ho9 ho9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048652, this) == null) && (ho9Var = this.T1) != null) {
            ho9Var.a();
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

    public qk9 T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.I;
        }
        return (qk9) invokeV.objValue;
    }

    public final void T1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048672, this) == null) && this.A == null && (pbFragment = this.f) != null) {
            this.A = new bn9(pbFragment.getContext());
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048677, this) == null) && this.w == null) {
            this.w = new en9(this.f, this.p0);
        }
    }

    public boolean U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            dm9 dm9Var = this.s;
            if (dm9Var != null && dm9Var.l()) {
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
            wo9 wo9Var = this.k;
            if (wo9Var != null && (view2 = wo9Var.f) != null) {
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
            this.y = new dn9(this.f, this.f1116T);
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
            nq9 nq9Var = this.K0;
            if (nq9Var != null) {
                return nq9Var.f();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public void i4() {
        wo9 wo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048737, this) == null) && (wo9Var = this.k) != null && !this.r1) {
            wo9Var.w();
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

    public dk9 o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) {
            return this.y1;
        }
        return (dk9) invokeV.objValue;
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
            nq9 nq9Var = this.K0;
            if (nq9Var == null) {
                return false;
            }
            return nq9Var.h();
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
        qk9 qk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048794, this) == null) && (qk9Var = this.I) != null) {
            qk9Var.I0();
        }
    }

    public fl9 w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048796, this)) == null) {
            return this.m1;
        }
        return (fl9) invokeV.objValue;
    }

    public void x4() {
        nq9 nq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048804, this) != null) || (nq9Var = this.K0) == null) {
            return;
        }
        nq9Var.n(2);
    }

    public void A2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RelativeLayout relativeLayout = this.g;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.g.getHandler().removeCallbacksAndMessages(null);
            }
            nq9 nq9Var = this.K0;
            if (nq9Var != null) {
                nq9Var.j();
            }
            sl9 sl9Var = this.C1;
            if (sl9Var != null) {
                sl9Var.c();
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
            lfa.d();
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
            dt6.b().unregister(this.U1);
            this.b2 = null;
            this.j.removeCallbacksAndMessages(null);
            this.I.g0(3);
            View view2 = this.h;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            qk9 qk9Var = this.I;
            if (qk9Var != null) {
                qk9Var.i0();
            }
            kn9 kn9Var = this.x1;
            if (kn9Var != null) {
                kn9Var.l();
            }
            gn9 gn9Var = this.x;
            if (gn9Var != null) {
                gn9Var.D();
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
            fl9 fl9Var = this.m1;
            if (fl9Var != null) {
                fl9Var.m();
            }
            hh9.d();
        }
    }

    public void D2() {
        zfa zfaVar;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || this.f == null) {
            return;
        }
        if (!this.I1 && this.J1 != 17) {
            if (this.q1 && !this.p1 && (zfaVar = this.S0) != null && zfaVar.r() != null) {
                int i3 = 2;
                if (this.f.H0()) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                if (!this.p1) {
                    i3 = 1;
                }
                wp9.u("c12601", i3, i2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f.getPageContext().getPageActivity(), this.S0.r().getUserId(), this.S0.r().getUserName(), this.f.W().R0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
                return;
            }
            return;
        }
        yh9 yh9Var = this.R0;
        if (yh9Var != null && yh9Var.k() != null && !di.isEmpty(this.R0.k().getName())) {
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
            this.f.K6();
            PbFragment pbFragment = this.f;
            if (pbFragment != null && pbFragment.W() != null && this.f.W().s1() != null && this.f.W().s1().O() != null && this.f.W().s1().O().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f.W().N1()).param("fid", this.f.W().s1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f.W().b).param("fid", this.f.W().s1().l()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f.getContext());
            this.b = cardForumHeadLayout;
            cardForumHeadLayout.setId(R.id.obfuscated_res_0x7f091aa5);
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
            EMManager.from(this.b).setCorner(R.string.J_X05).setBackGroundRealColor(gea.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
            this.b.setAfterClickListener(new p(this));
        }
    }

    public final void U4() {
        PbFragment pbFragment;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048680, this) == null) && (pbFragment = this.f) != null && pbFragment.W() != null && this.f.W().G != null && this.f.W().G.O() != null && this.f.W().G.O().isXiuXiuThread()) {
            ThreadData O = this.f.W().G.O();
            int i3 = 0;
            if (this.f.W().X0()) {
                i2 = 1;
            } else if (this.f.W().a1()) {
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
                wp9.v("c10517", this.o0, 2);
            } else if (!this.f.q5()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                ek5 V5 = this.f.V5();
                if (V5 != null && (V5.y() || V5.A())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.f.V5().w(false, null);
                    return;
                }
                if (this.r0 != null) {
                    X1();
                }
                EditorTools editorTools = this.r0;
                if (editorTools != null) {
                    this.N0 = false;
                    if (editorTools.p(2) != null) {
                        lfa.c(this.f.getPageContext(), (View) this.r0.p(2).m, false, v2);
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
            il9 il9Var = this.t;
            if (il9Var != null) {
                il9Var.b(z2, i2);
            }
            il9 il9Var2 = this.u;
            if (il9Var2 != null) {
                il9Var2.b(z2, i2);
            }
            al9 al9Var = this.C;
            if (al9Var != null) {
                al9Var.m(this.R0.k());
                this.C.i(z2, i2);
            }
        }
    }

    public void B2(TbRichText tbRichText) {
        yh9 yh9Var;
        zfa zfaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, tbRichText) == null) && (yh9Var = this.R0) != null && yh9Var.F() != null && !this.R0.F().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i2 = 0; i2 < this.R0.F().size() && (zfaVar = this.R0.F().get(i2)) != null && zfaVar.r() != null && !StringUtils.isNull(zfaVar.r().getUserId()); i2++) {
                if (this.R0.F().get(i2).r().getUserId().equals(tbRichText.getAuthorId())) {
                    dk9 dk9Var = this.y1;
                    if (dk9Var != null && dk9Var.k()) {
                        c4(false);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public final void B4(yh9 yh9Var) {
        boolean z2;
        en9 en9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, yh9Var) == null) && !this.B1 && yh9Var != null && yh9Var.O() != null && !yh9Var.O().isVideoThreadType()) {
            ThreadData O = yh9Var.O();
            boolean z3 = false;
            if (O.getIs_good() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (O.getIs_top() == 1) {
                z3 = true;
            }
            gn9 gn9Var = this.x;
            if (gn9Var != null) {
                gn9Var.u(yh9Var, z2, z3);
            }
            if (O.isShowTitle() && (en9Var = this.w) != null && en9Var.d() != null) {
                gm9.b(this.w.d(), O.isHeadLinePost, O.isGoodThread(), O.isTopThread());
            }
            if (T0() != null) {
                T0().J0(yh9Var);
            }
        }
    }

    public void H1(boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048612, this, z2) == null) && this.y0 != null && this.B0 != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            yh9 yh9Var = this.R0;
            if (yh9Var != null && yh9Var.q0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            yh9 yh9Var2 = this.R0;
            if (yh9Var2 != null && yh9Var2.r0()) {
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

    public void P4(yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, yh9Var) == null) {
            if (yh9Var != null && AntiHelper.o(yh9Var.O())) {
                nq9 nq9Var = this.K0;
                if (nq9Var != null) {
                    nq9Var.k(false);
                    this.K0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.G0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.G0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.G0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            nq9 nq9Var2 = this.K0;
            if (nq9Var2 != null && nq9Var2.g()) {
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
                return this.f.getString(R.string.obfuscated_res_0x7f0f0fd0);
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
            qk9 qk9Var = this.I;
            if (qk9Var != null) {
                qk9Var.A0(z2);
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
                pbFragment.a7(z2);
            }
            if (z2) {
                io9.d(this.f.getPageContext(), this.f.W(), this.f.Y5());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            yh9 yh9Var = this.R0;
            if (yh9Var != null) {
                str = yh9Var.l();
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
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f13d8, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03cf, TBAlertConfig.OperateBtnStyle.SECONDARY);
        AlertDialog show = new TBAlertBuilder(this.f.d0()).setTitle(R.string.musk_my_thread_confirm).setDesc(R.string.musk_my_thread_confirm_subtitle).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new f0(this, show, sparseArray));
        operateBtnConfig2.setListener(new h0(this, show));
    }

    public final void c2(yh9 yh9Var) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048711, this, yh9Var) == null) && (pbListView = this.O) != null && pbListView.i() != null) {
            LinearLayout i2 = this.O.i();
            if (yh9Var.y().b() == 0 && !this.f.W().X0() && !o2(yh9Var)) {
                if (this.b == null) {
                    S1();
                }
                ViewParent parent = this.b.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.b);
                }
                i2.addView(this.b);
                ForumData k2 = yh9Var.k();
                f25 forumShowInfo = k2.getForumShowInfo();
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

    public void m3(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048752, this, editorTools) == null) {
            this.r0 = editorTools;
            editorTools.setOnCancelClickListener(new y(this));
            this.r0.setId(R.id.obfuscated_res_0x7f091ab1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.r0.getParent() == null) {
                this.g.addView(this.r0, layoutParams);
            }
            this.r0.z(TbadkCoreApplication.getInst().getSkinType());
            this.r0.setActionListener(24, new z(this));
            I1();
            this.f.V5().g(new a0(this));
        }
    }

    public void x2(AgreeMessageData agreeMessageData) {
        yh9 yh9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048802, this, agreeMessageData) == null) && agreeMessageData != null && agreeMessageData.agreeData != null && (yh9Var = this.R0) != null && yh9Var.O() != null && this.R0.O().getAgreeData() != null) {
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
            s45 s45Var = new s45(this.f.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(o2, Integer.valueOf(q2));
            s45Var.setTitle(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            s45Var.setContentView(inflate);
            s45Var.setYesButtonTag(sparseArray);
            s45Var.setPositiveButton(R.string.grade_button_tips, this.f);
            s45Var.setNegativeButton(R.string.look_again, new x0(this));
            s45Var.create(this.f.getPageContext()).show();
        }
    }

    public final void O4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            if (hh9.c()) {
                DefaultLog.getInstance().e("BotGuideManager", "新手长按引导未展示,BotGuideManager在展示其他");
            } else if (SharedPrefHelper.getInstance().getBoolean("pb_friend_bot_bottom_long_click_shown", false)) {
                DefaultLog.getInstance().e("BotGuideManager", "新手长按引导未展示,长按引导已经展示过");
            } else if (SharedPrefHelper.getInstance().getBoolean("pb_friend_bot_bottom_new_user_shown", false) && (pbFragment = this.f) != null) {
                BaseFragmentActivity baseFragmentActivity = pbFragment.getBaseFragmentActivity();
                if (baseFragmentActivity != null && this.J0 != null) {
                    String string = baseFragmentActivity.getString(R.string.obfuscated_res_0x7f0f0fdb);
                    hh9.e(string, this.J0, baseFragmentActivity, new s(this, string));
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
        if ((interceptable == null || interceptable.invokeV(1048782, this) == null) && (pbFragment = this.f) != null && pbFragment.W() != null && this.f.W().G != null && this.f.W().G.O() != null && this.f.W().G.O().isQuestionThread()) {
            ThreadData O = this.f.W().G.O();
            String F1 = this.f.W().F1();
            String G1 = this.f.W().G1();
            int i2 = 5;
            if ("question_answer_invite".equals(F1)) {
                i2 = 1;
            } else if ("3".equals(G1)) {
                i2 = 2;
            } else if ("answer_top".equals(F1)) {
                i2 = 3;
            } else if (this.f.W().X0()) {
                i2 = 4;
            }
            TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", O.getId()).param("fid", O.getFid()).param("obj_source", i2));
        }
    }

    public final void y0() {
        yh9 yh9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048805, this) == null) && this.B != null && (yh9Var = this.R0) != null && yh9Var.O() != null && !ListUtils.isEmpty(this.R0.O().getThreadRecommendInfoDataList()) && this.R0.O().getThreadRecommendInfoDataList().get(0) != null && this.w.b().getVisibility() == 0) {
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
            s45 s45Var = new s45(this.f.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            s45Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(o2, Integer.valueOf(r2));
            s45Var.setYesButtonTag(sparseArray);
            s45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f182d, this.f);
            s45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03cf, new y0(this));
            s45Var.create(this.f.getPageContext()).show();
        }
    }

    public void M4(xh9 xh9Var) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048640, this, xh9Var) != null) || xh9Var == null) {
            return;
        }
        this.k.C();
        if (!StringUtils.isNull(xh9Var.b)) {
            this.k.y(xh9Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1647);
        int i2 = JavaTypesHelper.toInt(xh9Var.a, 0);
        if (i2 != 100) {
            if (i2 != 300) {
                if (i2 != 400) {
                    string = "";
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f15b4);
                }
            } else {
                string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0335);
            }
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f135b);
        }
        this.f.showNetRefreshView(this.g, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new s0(this, xh9Var.c));
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

    public final boolean f4(yh9 yh9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048725, this, yh9Var)) == null) {
            if (yh9Var == null || yh9Var.O() == null) {
                return false;
            }
            if (yh9Var.O().getIsLive() != 1 && yh9Var.O().getThreadType() != 33 && ((yh9Var.O().getTopicData() == null || yh9Var.O().getTopicData().a() == 0) && yh9Var.O().getIs_top() != 1 && yh9Var.O().getIs_good() != 1 && !yh9Var.O().isActInfo() && !yh9Var.O().isInterviewLive() && !yh9Var.O().isVoteThreadType() && yh9Var.O().getYulePostActivityData() == null && di.isEmpty(yh9Var.O().getCategory()) && !yh9Var.O().isGodThread() && !yh9Var.O().isRealGod())) {
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
        mq9 mq9Var;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || (mq9Var = this.N1) == null) {
            return;
        }
        if (this.o != null && mq9Var.a() != null && this.N1.a().getParent() != null) {
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
            yh9 yh9Var = this.R0;
            if (yh9Var != null && this.O != null && yh9Var.y() != null && this.R0.y().b() == 0) {
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
            yh9 yh9Var = this.R0;
            if (yh9Var != null && yh9Var.O() != null && !ListUtils.isEmpty(this.R0.O().getThreadRecommendInfoDataList()) && this.f != null && this.w.b() != null && this.w.b().getVisibility() == 0 && this.R0.O().getThreadRecommendInfoDataList().get(0) != null && this.R0.O().getThreadRecommendInfoDataList().get(0).businessType == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048686, this) != null) || !this.f.O5()) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f0916dc);
        this.n = viewStub;
        viewStub.setVisibility(0);
        if (this.E == null) {
            this.E = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0916db);
            bt5.a(this.f.getPageContext(), this.E);
        }
        if (this.F == null) {
            this.F = (TextView) this.E.findViewById(R.id.obfuscated_res_0x7f0916e0);
        }
        if (this.G == null) {
            this.G = (TextView) this.E.findViewById(R.id.obfuscated_res_0x7f0916df);
        }
        this.F.setOnClickListener(this.f1116T);
        this.G.setOnClickListener(this.f1116T);
    }

    public final void W2() {
        wo9 wo9Var;
        yh9 yh9Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048687, this) == null) && this.w != null && (wo9Var = this.k) != null && wo9Var.j() != null && (yh9Var = this.R0) != null && yh9Var.O() != null && this.R0.O().isQuestionThread() && this.w.b() != null && this.w.b().getVisibility() == 0) {
            int[] iArr = new int[2];
            this.w.b().getLocationInWindow(iArr);
            boolean z3 = true;
            int height = iArr[1] + this.w.b().getHeight();
            if (this.w.b().getParent() != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            wo9 wo9Var2 = this.k;
            if (height > wo9Var2.j().getBottom() && z2) {
                z3 = false;
            }
            wo9Var2.z(z3, this.R0.O().getSpan_str());
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
        if ((interceptable == null || interceptable.invokeV(1048736, this) == null) && (pbFragment = this.f) != null && pbFragment.V5() != null && this.r0 != null) {
            zj5.a().c(0);
            ek5 V5 = this.f.V5();
            V5.N();
            V5.L();
            if (V5.v() != null) {
                WriteImagesInfo v3 = V5.v();
                if (V5.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                v3.setMaxImagesAllowed(i2);
            }
            V5.e0(SendView.h);
            V5.h(SendView.h);
            hi5 o3 = this.r0.o(23);
            hi5 o4 = this.r0.o(2);
            hi5 o5 = this.r0.o(5);
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

    public void a2(yh9 yh9Var) {
        cc5 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048703, this, yh9Var) != null) || yh9Var == null) {
            return;
        }
        if (yh9Var.q0()) {
            pbAdFloatViewItemData = yh9Var.b0();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            Z1(yh9Var, pbAdFloatViewItemData);
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
        if (this.f.V5() != null && this.f.V5().z()) {
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
            textView.setText(R.string.obfuscated_res_0x7f0f0607);
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
        zfa X;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048747, this, threadData)) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                yh9 yh9Var = this.R0;
                if (yh9Var != null && (X = yh9Var.X()) != null && X.r() != null) {
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

    public final boolean o2(yh9 yh9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048759, this, yh9Var)) == null) {
            if (yh9Var == null) {
                return true;
            }
            ArrayList<zfa> F = yh9Var.F();
            if (ListUtils.getCount(F) == 0) {
                return true;
            }
            if (ListUtils.getCount(F) == 1 && ListUtils.getItem(F, 0) != null && ((zfa) ListUtils.getItem(F, 0)).I() == 1) {
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
        fl9 fl9Var = this.m1;
        if (fl9Var != null) {
            fl9Var.g();
        }
        this.f.h6();
        this.H.setVisibility(8);
        this.k.v(false);
        this.f.b7(false);
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
            il9 il9Var = this.u;
            if (il9Var != null) {
                il9Var.c(i2, i3);
            }
            il9 il9Var2 = this.t;
            if (il9Var2 != null) {
                il9Var2.c(i2, i3);
            }
            al9 al9Var = this.C;
            if (al9Var != null) {
                al9Var.l(i2, i3);
            }
            wo9 wo9Var = this.k;
            if (wo9Var != null && this.x != null) {
                wo9Var.q(absListView, i2, i3, i4);
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
                sm6.f(this.O.i(), 0);
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

    public void M2(ArrayList<m25> arrayList) {
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
                textView2.setOnClickListener(this.f1116T);
            }
            this.d0.removeAllViews();
            this.q = new ArrayList();
            CustomBlueCheckRadioButton B0 = B0("0", this.f.getPageContext().getString(R.string.thread_good_class));
            this.q.add(B0);
            B0.setChecked(true);
            this.d0.addView(B0);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    m25 m25Var = arrayList.get(i2);
                    if (m25Var != null && !TextUtils.isEmpty(m25Var.b()) && m25Var.a() > 0) {
                        CustomBlueCheckRadioButton B02 = B0(String.valueOf(m25Var.a()), m25Var.b());
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

    public void d3(yh9 yh9Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048716, this, new Object[]{yh9Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            o4(yh9Var, z2, i2, i3);
            this.x.C(i3);
        }
    }

    public void O0(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.f.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.f;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f1491));
            } else if (z3) {
                if (di.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e29);
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
            this.Z = new s45(this.f.getActivity());
            if (StringUtils.isNull(str2)) {
                this.Z.setMessageId(i4);
            } else {
                this.Z.setOnlyMessageShowCenter(false);
                this.Z.setMessage(str2);
            }
            this.Z.setYesButtonTag(sparseArray);
            this.Z.setPositiveButton(R.string.obfuscated_res_0x7f0f0598, this.f);
            this.Z.setNegativeButton(R.string.obfuscated_res_0x7f0f058d, new c0(this));
            this.Z.setCancelable(true);
            this.Z.create(this.f.getPageContext());
            if (z3) {
                e4(sparseArray, i5, i4);
            } else if (z2) {
                e4(sparseArray, i5, i4);
            } else if (T3()) {
                b46 b46Var = new b46(this.f.W().s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f.W().s1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.f.W().s1().n().has_forum_rule.intValue());
                b46Var.i(this.f.W().s1().k().getId(), this.f.W().s1().k().getName());
                b46Var.h(this.f.W().s1().k().getImage_url());
                b46Var.j(this.f.W().s1().k().getUser_level());
                l4(sparseArray, i2, b46Var, this.f.W().s1().V(), false);
            } else {
                t4(this.Z, i2);
            }
        }
    }

    public void P3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, str) == null) {
            this.B0.performClick();
            if (!StringUtils.isNull(str) && this.f.V5() != null && this.f.V5().s() != null && this.f.V5().s().i() != null) {
                EditText i2 = this.f.V5().s().i();
                i2.setText(str);
                i2.setSelection(str.length());
            }
        }
    }

    public final void V1(yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048682, this, yh9Var) != null) || yh9Var == null || yh9Var.O() == null || !yh9Var.O().isInterviewLive() || this.Y0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.X0.inflate();
        this.Y0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.f1116T);
        this.Y0.setCallback(this.f.N5());
        this.Y0.setData(this.f, yh9Var);
    }

    public void Z3(eh9 eh9Var) {
        yh9 yh9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048700, this, eh9Var) == null) && (yh9Var = this.R0) != null && yh9Var.K() != null && !ListUtils.isEmpty(this.R0.K().robot_skill_info) && !ListUtils.isEmpty(this.R0.K().bottom_bar_robot_skill)) {
            jg9.a(this.J0, BotEntranceManager.e(this.R0.K().robot_skill_info, this.R0.K().bottom_bar_robot_skill), new r(this), eh9Var);
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
            sm adapter2 = pbLandscapeListView.getAdapter2();
            if (adapter2 == null) {
                return i2;
            }
            if (i2 < adapter2.getCount() && i2 >= 0 && (adapter2.getItem(i2) instanceof yfa)) {
                i2++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i2 > o3) {
                i2 = o3;
            }
            if (this.o.getAdapter2() != null && (this.o.getAdapter2() instanceof sm)) {
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

    public boolean Q4(yh9 yh9Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048660, this, yh9Var, z2)) == null) {
            if (yh9Var == null) {
                return false;
            }
            if (this.w != null) {
                if (yh9Var.O() != null && yh9Var.O().getIsNoTitle() == 0 && !yh9Var.O().isVideoThreadType()) {
                    if (yh9Var.O() != null) {
                        ThreadData O = yh9Var.O();
                        O.parserSpecTitleForFrsAndPb(true, f4(yh9Var));
                        O.setResource(3);
                        O.setPbTitle("2");
                    }
                    if (yh9Var.O().isBJHArticleThreadType()) {
                        this.x.G(this.o);
                        this.w.h(this.o);
                        this.w.a(this.o);
                        this.x.q(this.o);
                        this.x.L(this.R0);
                        if (f2(yh9Var)) {
                            this.w.h(this.o);
                        } else {
                            this.w.i(yh9Var);
                        }
                    } else {
                        this.x.L(this.R0);
                        if (f2(yh9Var)) {
                            this.w.h(this.o);
                        } else {
                            this.w.k(yh9Var);
                        }
                    }
                } else if (yh9Var.O().getIsNoTitle() == 1) {
                    if (yh9Var.O() != null) {
                        this.w.h(this.o);
                        this.x.L(this.R0);
                    }
                } else {
                    this.w.h(this.o);
                    this.x.L(this.R0);
                }
            }
            A4(yh9Var.X());
            B4(yh9Var);
            this.Q0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final void X3(int i2, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048692, this, i2, sparseArray) == null) && (pbFragment = this.f) != null && pbFragment.W() != null && this.f.W().s1() != null && this.f.W().s1().n() != null && this.f.W().s1().k() != null && this.f.W().s1().k().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
            }
            b46 b46Var = new b46(this.f.W().s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f.W().s1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.f.W().s1().n().has_forum_rule.intValue());
            b46Var.i(this.f.W().s1().k().getId(), this.f.W().s1().k().getName());
            b46Var.h(this.f.W().s1().k().getImage_url());
            b46Var.j(this.f.W().s1().k().getUser_level());
            l4(sparseArray, i2, b46Var, this.f.W().s1().V(), true);
        }
    }

    public final void t4(s45 s45Var, int i2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048784, this, s45Var, i2) == null) && (pbFragment = this.f) != null && s45Var != null) {
            if (this.E1 == null && this.v != null) {
                this.E1 = new z36(pbFragment.getPageContext(), this.v.c());
            }
            AntiData F5 = this.f.F5();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (F5 != null && F5.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = F5.getDelThreadInfoList();
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
            this.E1.C(new i0(this, s45Var));
        }
    }

    public void y4(z25 z25Var, s45.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048809, this, z25Var, eVar) != null) || z25Var == null) {
            return;
        }
        int a2 = z25Var.a();
        int h2 = z25Var.h();
        s45 s45Var = this.J;
        if (s45Var != null) {
            s45Var.show();
        } else {
            this.J = new s45(this.f.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0266, (ViewGroup) null);
            this.L = inflate;
            this.J.setContentView(inflate);
            this.J.setPositiveButton(R.string.obfuscated_res_0x7f0f0598, eVar);
            this.J.setNegativeButton(R.string.obfuscated_res_0x7f0f058d, new v0(this));
            this.J.setOnCalcelListener(new w0(this));
            this.J.create(this.f.getPageContext()).show();
        }
        EditText editText = (EditText) this.L.findViewById(R.id.obfuscated_res_0x7f09113f);
        this.M = editText;
        editText.setText("");
        TextView textView = (TextView) this.L.findViewById(R.id.obfuscated_res_0x7f090834);
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
        y45 y45Var;
        y45 y45Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048663, this, sparseArray, z2) == null) {
            c55 c55Var = new c55(this.f.getContext());
            c55Var.t(this.f.getString(R.string.obfuscated_res_0x7f0f0323));
            c55Var.q(new b0(this, z2));
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
                    y45Var2 = new y45(10, this.f.getString(R.string.obfuscated_res_0x7f0f0557), c55Var);
                } else {
                    y45Var2 = new y45(10, this.f.getString(R.string.obfuscated_res_0x7f0f0548), c55Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                y45Var2.d.setTag(sparseArray2);
                arrayList.add(y45Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                y45 y45Var3 = new y45(13, this.f.getString(R.string.multi_delete), c55Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                y45Var3.d.setTag(sparseArray3);
                arrayList.add(y45Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                y45 y45Var4 = new y45(11, this.f.getString(R.string.forbidden_person), c55Var);
                y45Var4.d.setTag(sparseArray4);
                arrayList.add(y45Var4);
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
                    y45Var = new y45(12, this.f.getString(R.string.un_mute), c55Var);
                } else {
                    y45Var = new y45(12, this.f.getString(R.string.obfuscated_res_0x7f0f0d01), c55Var);
                }
                y45Var.d.setTag(sparseArray5);
                arrayList.add(y45Var);
            }
            eo9.e(arrayList);
            c55Var.m(arrayList, true);
            a55 a55Var = new a55(this.f.getPageContext(), c55Var);
            this.X = a55Var;
            a55Var.l();
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

    public final void Z1(yh9 yh9Var, cc5 cc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048698, this, yh9Var, cc5Var) == null) && this.R1 != null && yh9Var != null && cc5Var != null && this.f.getContext() != null) {
            if (!RightFloatLayerView.k()) {
                N1();
                return;
            }
            if (this.Q1 == null) {
                RightFloatLayerView E = RightFloatLayerLottieView.E(cc5Var, this.f.getContext());
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
            if (cc5Var.a()) {
                return;
            }
            this.Q1.setData(cc5Var);
            this.Q1.setLogoListener(new r0(this, cc5Var));
            this.Q1.setFeedBackListener(new b1(this, cc5Var));
        }
    }

    public final void a4(yh9 yh9Var) {
        boolean z2;
        StyleContentInfo styleContentInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, yh9Var) == null) {
            if (yh9Var != null && yh9Var.K() != null) {
                RobotEntrance K = yh9Var.K();
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
                            layoutParams.addRule(0, R.id.obfuscated_res_0x7f091ab4);
                            this.F0.setLayoutParams(layoutParams);
                            this.J0.setClickCallBack(this.Z1);
                            this.J0.setCallRobotEntranceData(new q15(this.W1, styleContentInfo2, styleContentInfo, z2));
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

    public final void b3(yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048708, this, yh9Var) == null) && yh9Var != null && yh9Var.O() != null) {
            P4(yh9Var);
            ImageView imageView = this.F0;
            if (imageView != null && imageView.getContext() != null) {
                if (yh9Var.q()) {
                    WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
                } else {
                    WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            String S0 = S0(yh9Var.O().getReply_num());
            TextView textView = this.M0;
            if (textView != null) {
                textView.setText(S0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, yh9Var.O()));
            a3(yh9Var.O().getAgreeData(), yh9Var.O().getAgreeNum());
            if (this.E0 != null && yh9Var.O() != null) {
                this.E0.setThreadData(yh9Var.O());
                int i2 = 1;
                if (yh9Var.O().getAgreeData() != null) {
                    yh9Var.O().getAgreeData().isInThread = true;
                }
                this.E0.setData(yh9Var.O().getAgreeData());
                c15 c15Var = new c15();
                c15Var.b = 26;
                if (yh9Var.O().isVideoThreadType() && yh9Var.O().getThreadVideoInfo() != null) {
                    i2 = 2;
                }
                c15Var.c = i2;
                PbFragment pbFragment = this.f;
                if (pbFragment != null && pbFragment.W() != null) {
                    c15Var.j = this.f.W().getFromForumId();
                    c15Var.f = this.f.W().r1();
                }
                this.E0.setStatisticData(c15Var);
            }
        }
    }

    public void d2(yh9 yh9Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, yh9Var) == null) {
            int i2 = 0;
            this.I.n0(yh9Var, false);
            this.I.f0();
            I0();
            dk9 dk9Var = this.y1;
            if (dk9Var != null) {
                dk9Var.m();
            }
            ArrayList<zfa> F = yh9Var.F();
            if (yh9Var.y().b() == 0 || F == null || F.size() < yh9Var.y().e()) {
                if (o2(yh9Var)) {
                    g1 g1Var = this.h1;
                    if (g1Var != null && (pbReplyTitleViewHolder = g1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.h1.a.getView().getTop() < 0) {
                            bottom = this.h1.a.getView().getHeight();
                        } else {
                            bottom = this.h1.a.getView().getBottom();
                        }
                        i2 = bottom;
                    }
                    if (this.f.q6()) {
                        this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fee), i2);
                    } else {
                        this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fef), i2);
                    }
                } else {
                    if (yh9Var.y().b() == 0) {
                        this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
                    } else {
                        this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.O.n();
                }
            }
            b3(yh9Var);
        }
    }

    public void d4(yh9 yh9Var) {
        zfa zfaVar;
        wo9 wo9Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048717, this, yh9Var) == null) && yh9Var != null && (zfaVar = this.S0) != null && zfaVar.r() != null && (wo9Var = this.k) != null) {
            boolean z3 = !this.p1;
            this.q1 = z3;
            wo9Var.A(z3);
            if (this.f.W5() != null) {
                this.f.W5().s(this.q1);
            }
            Y2();
            PbFragment pbFragment = this.f;
            if (pbFragment != null && !pbFragment.H0() && !ListUtils.isEmpty(yh9Var.o())) {
                y35 y35Var = yh9Var.o().get(0);
                if (y35Var != null) {
                    this.k.D(yh9Var, y35Var.d(), y35Var.b(), y35Var.a(), y35Var.f());
                }
            } else if (yh9Var.k() != null) {
                wo9 wo9Var2 = this.k;
                String name = yh9Var.k().getName();
                String id = yh9Var.k().getId();
                String image_url = yh9Var.k().getImage_url();
                if (yh9Var.k().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                wo9Var2.D(yh9Var, name, id, image_url, z2);
            }
            if (this.q1) {
                this.x.Q(yh9Var, this.S0, this.m0);
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
            this.x.Q(yh9Var, this.S0, this.m0);
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
        textView.setText(R.string.obfuscated_res_0x7f0f04cf);
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
            v45 v45Var = this.k0;
            if (v45Var != null) {
                v45Var.d();
                this.k0 = null;
            }
            if (this.R0 == null) {
                return;
            }
            ArrayList<e55> arrayList = new ArrayList<>();
            String string = this.f.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.R0.J() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new e55(string, "", z2, Integer.toString(1)));
            String string2 = this.f.getContext().getString(R.string.my_fans);
            if (this.R0.J() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new e55(string2, "", z3, Integer.toString(5)));
            String string3 = this.f.getContext().getString(R.string.my_attentions);
            if (this.R0.J() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new e55(string3, "", z4, Integer.toString(6)));
            String string4 = this.f.getContext().getString(R.string.myself_only);
            if (this.R0.J() == 4) {
                z5 = true;
            }
            arrayList.add(new e55(string4, "", z5, Integer.toString(7)));
            v45 v45Var2 = new v45(this.f.getPageContext());
            v45Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.k0 = v45Var2;
            v45Var2.k(arrayList, onItemClickListener);
            v45Var2.c();
            this.k0.n();
        }
    }

    public void c3(int i2, yh9 yh9Var, boolean z2, int i3) {
        zfa X;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048712, this, new Object[]{Integer.valueOf(i2), yh9Var, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) && i2 > 0 && yh9Var != null && (X = yh9Var.X()) != null && X.r() != null) {
            MetaData r3 = X.r();
            r3.setGiftNum(r3.getGiftNum() + i2);
        }
    }

    public final void e4(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048721, this, sparseArray, i2, i3) != null) || this.f == null) {
            return;
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f0548, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03cf, TBAlertConfig.OperateBtnStyle.SECONDARY);
        AlertDialog show = new TBAlertBuilder(this.f.d0()).setTitle(i2).setDesc(i3).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new d0(this, show, sparseArray));
        operateBtnConfig2.setListener(new e0(this, show));
    }

    public final void s0(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048775, this, new Object[]{str, str2, Long.valueOf(j2)}) != null) || this.R0.O() == null) {
            return;
        }
        zg9.c();
        String c2 = go9.c(this.R0.O().getFirstPostId(), TbadkCoreApplication.getCurrentPortrait(), System.currentTimeMillis());
        go9.a(this.f.getPageContext(), str2, j2, this.R0.O().getTid(), this.R0.O().getFirstPostId(), c2, new t(this, str, c2));
    }

    public final void l4(SparseArray<Object> sparseArray, int i2, b46 b46Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048749, this, new Object[]{sparseArray, Integer.valueOf(i2), b46Var, userData, Boolean.valueOf(z2)}) != null) || (pbFragment = this.f) == null) {
            return;
        }
        if (this.F1 == null && this.v != null) {
            this.F1 = new c46(pbFragment.getPageContext(), this.v.c(), b46Var, userData);
        }
        this.F1.F(z2);
        AntiData F5 = this.f.F5();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (F5 != null && F5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = F5.getDelThreadInfoList();
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

    public void q4(t45.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048769, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            a55 a55Var = this.i0;
            if (a55Var != null) {
                a55Var.dismiss();
                this.i0 = null;
            }
            c55 c55Var = new c55(this.f.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new y45(0, this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f04e3), c55Var));
            }
            if (z3) {
                arrayList.add(new y45(1, this.f.getPageContext().getString(R.string.report_text), c55Var));
            } else if (!z2) {
                arrayList.add(new y45(1, this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c45), c55Var));
            } else {
                arrayList.add(new y45(1, this.f.getPageContext().getString(R.string.remove_mark), c55Var));
            }
            c55Var.l(arrayList);
            c55Var.q(new m0(this, cVar));
            a55 a55Var2 = new a55(this.f.getPageContext(), c55Var);
            this.j0 = a55Var2;
            a55Var2.l();
        }
    }

    public SparseArray<Object> n1(yh9 yh9Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        zfa X;
        boolean z3;
        d25 d25Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048754, this, new Object[]{yh9Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (yh9Var == null || (X = yh9Var.X()) == null) {
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(yh9Var.W()));
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(yh9Var.W()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<y35> o3 = yh9Var.o();
                if (ListUtils.getCount(o3) > 0) {
                    sb = new StringBuilder();
                    for (y35 y35Var : o3) {
                        if (y35Var != null && !StringUtils.isNull(y35Var.d()) && (d25Var = y35Var.h) != null && d25Var.a && !d25Var.c && ((i3 = d25Var.b) == 1 || i3 == 2)) {
                            sb.append(di.cutString(y35Var.d(), 12));
                            sb.append(this.f.getString(R.string.obfuscated_res_0x7f0f077c));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.f.getString(R.string.obfuscated_res_0x7f0f0540), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public void n4(yh9 yh9Var, int i2, int i3, boolean z2, int i4, boolean z3) {
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
        if ((interceptable == null || interceptable.invokeCommon(1048757, this, new Object[]{yh9Var, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) && yh9Var != null && this.o != null) {
            this.R0 = yh9Var;
            this.T0 = i2;
            if (yh9Var.O() != null) {
                this.i1 = yh9Var.O().getCopyThreadRemindType();
                this.m0 = l2(yh9Var.O());
            }
            if (yh9Var.V() != null) {
                this.h2 = yh9Var.V().getUserId();
            }
            V1(yh9Var);
            this.V0 = false;
            this.Q0 = z2;
            L3();
            ji9 ji9Var = yh9Var.h;
            if (ji9Var != null && ji9Var.b()) {
                if (this.r == null) {
                    PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f.getContext());
                    this.r = pbThreadPostView;
                    this.o.w(pbThreadPostView, 1);
                    this.r.setData(yh9Var);
                    this.r.setChildOnClickLinstener(this.f1116T);
                }
            } else {
                PbThreadPostView pbThreadPostView2 = this.r;
                if (pbThreadPostView2 != null && (pbLandscapeListView = this.o) != null) {
                    pbLandscapeListView.removeHeaderView(pbThreadPostView2);
                }
            }
            o4(yh9Var, z2, i2, TbadkCoreApplication.getInst().getSkinType());
            d4(yh9Var);
            this.x.R(yh9Var, this.S0);
            if (this.C1 == null) {
                this.C1 = new sl9(this.f.getPageContext(), this.D1);
            }
            this.C1.a(yh9Var.w());
            if (this.f.O5()) {
                if (this.N == null) {
                    oq9 oq9Var = new oq9(this.f.getPageContext());
                    this.N = oq9Var;
                    oq9Var.i();
                    this.N.a(this.i2);
                }
                this.o.setPullRefresh(this.N);
                oq9 oq9Var2 = this.N;
                if (oq9Var2 != null) {
                    oq9Var2.C(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (yh9Var.y().c() == 0 && z2) {
                this.o.setPullRefresh(null);
            } else {
                if (this.N == null) {
                    oq9 oq9Var3 = new oq9(this.f.getPageContext());
                    this.N = oq9Var3;
                    oq9Var3.i();
                    this.N.a(this.i2);
                }
                this.o.setPullRefresh(this.N);
                oq9 oq9Var4 = this.N;
                if (oq9Var4 != null) {
                    oq9Var4.C(TbadkCoreApplication.getInst().getSkinType());
                }
                K1();
            }
            I0();
            this.I.v0(this.Q0);
            this.I.s0(false);
            qk9 qk9Var = this.I;
            if (i2 == 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            qk9Var.t0(z4);
            qk9 qk9Var2 = this.I;
            if (i2 == 6) {
                z5 = true;
            } else {
                z5 = false;
            }
            qk9Var2.u0(z5);
            qk9 qk9Var3 = this.I;
            if (z3 && this.f2 && i2 != 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            qk9Var3.q0(z6);
            this.I.n0(yh9Var, false);
            this.I.f0();
            qk9 qk9Var4 = this.I;
            if (yh9Var.y().b() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            qk9Var4.h0(z7, yh9Var.f());
            this.x.P(yh9Var.X(), yh9Var.j0());
            if (yh9Var.O() != null && yh9Var.O().getPraise() != null && this.e != -1) {
                yh9Var.O().getPraise().setIsLike(this.e);
            }
            this.o.removeFooterView(this.e1);
            this.o.addFooterView(this.e1);
            if (TbadkCoreApplication.isLogin()) {
                this.o.setNextPage(this.O);
                this.i = 2;
                K1();
            } else {
                this.V0 = true;
                if (yh9Var.y().b() == 1) {
                    if (this.P == null) {
                        PbFragment pbFragment2 = this.f;
                        this.P = new jq9(pbFragment2, pbFragment2);
                    }
                    this.o.setNextPage(this.P);
                } else {
                    this.o.setNextPage(this.O);
                }
                this.i = 3;
            }
            ArrayList<zfa> F = yh9Var.F();
            if (yh9Var.y().b() != 0 && F != null && F.size() >= yh9Var.y().e()) {
                if (z3) {
                    if (this.f2) {
                        M0();
                        if (yh9Var.y().b() != 0) {
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
                if (o2(yh9Var)) {
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
                    if (this.f.q6()) {
                        this.O.y(false);
                        if (ListUtils.isEmpty(yh9Var.R())) {
                            this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fee), i5);
                        }
                    } else if (ListUtils.isEmpty(yh9Var.R())) {
                        this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fef), i5);
                    }
                    if (this.f.W5() != null && !this.f.W5().p()) {
                        this.f.W5().x();
                    }
                } else {
                    if (yh9Var.y().b() == 0) {
                        zfa zfaVar = (zfa) ListUtils.getItem(F, ListUtils.getCount(F) - 1);
                        if (zfaVar != null) {
                            zfaVar.P = false;
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
                if (yh9Var.y().b() == 0 || F == null) {
                    f3();
                }
            }
            switch (i2) {
                case 2:
                    if (this.o.getData() == null && yh9Var.F() == null) {
                        size = 0;
                    } else {
                        size = (this.o.getData().size() - yh9Var.F().size()) + this.o.getHeaderViewsCount();
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
                    if (i4 == 1 && (e2 = yl9.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
                        this.o.post(new t0(this, e2, F, yh9Var));
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
                    if (i4 == 1 && (e3 = yl9.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
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
                    } else if (ListUtils.isEmpty(yh9Var.R())) {
                        if (this.o.getData() == null && yh9Var.F() == null) {
                            size2 = 0;
                        } else {
                            size2 = (this.o.getData().size() - yh9Var.F().size()) + this.o.getHeaderViewsCount();
                        }
                        PbLandscapeListView pbLandscapeListView3 = this.o;
                        if (i3 > 0) {
                            i7 = i3 + size2;
                        } else {
                            i7 = 0;
                        }
                        pbLandscapeListView3.setSelection(i7);
                    } else {
                        this.o.setSelection(yh9Var.F().size() + this.o.getHeaderViewsCount());
                    }
                    this.O.g();
                    this.O.H(this.f.getString(R.string.obfuscated_res_0x7f0f0fe8));
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
            if (yh9Var.d == 1 || yh9Var.e == 1) {
                if (this.t1 == null) {
                    this.t1 = new PbTopTipView(this.f.getContext());
                }
                if (yh9Var.e == 1 && "game_guide".equals(this.f.a6())) {
                    this.t1.setText(this.f.getString(R.string.obfuscated_res_0x7f0f0ffa));
                    this.t1.l(this.g, this.U0);
                } else if (yh9Var.d == 1 && "game_news".equals(this.f.a6())) {
                    this.t1.setText(this.f.getString(R.string.obfuscated_res_0x7f0f0ff9));
                    this.t1.l(this.g, this.U0);
                }
            }
            c2(yh9Var);
            int i8 = this.c;
            if (i8 == -1) {
                i8 = c1();
            }
            this.c = i8;
            this.o.removeFooterView(this.N1.a());
            if (!ListUtils.isEmpty(yh9Var.H()) && yh9Var.y().b() == 0) {
                this.o.removeFooterView(this.e1);
                this.N1.d(Math.max(this.y0.getMeasuredHeight(), this.O0 / 2));
                this.o.addFooterView(this.N1.a());
                this.N1.f(yh9Var);
            }
            b3(yh9Var);
            if (yh9Var.h0() && this.f.W().k2() && this.f.X5() != null) {
                this.f.X5().d();
            }
            if (yh9Var.f() != 3) {
                a2(yh9Var);
            }
            this.B0.setText(TbSingleton.getInstance().getAdVertiComment(yh9Var.q0(), yh9Var.r0(), x1()));
            if (this.s != null) {
                yh9 yh9Var2 = this.R0;
                if (yh9Var2 != null && yh9Var2.k() != null && (pbFragment = this.f) != null && pbFragment.W() != null) {
                    this.s.r(this.f.W().b);
                }
                yh9 yh9Var3 = this.R0;
                if (yh9Var3 != null && yh9Var3.O() != null && !ListUtils.isEmpty(this.R0.O().getThreadRecommendInfoDataList()) && this.R0.O().getThreadRecommendInfoDataList().get(0) != null && this.R0.O().getThreadRecommendInfoDataList().get(0).businessType != 1) {
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
    public final void o4(yh9 yh9Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048761, this, new Object[]{yh9Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && yh9Var != null && yh9Var.O() != null) {
            PbFragment pbFragment = this.f;
            if (pbFragment != null && gm9.D(pbFragment)) {
                this.x.G(this.o);
                this.w.h(this.o);
            }
            if (this.f.H0()) {
                if (yh9Var.g() != null) {
                    this.n0 = yh9Var.g().d();
                    this.o0 = yh9Var.g().b();
                }
                if (this.n0 == null && this.f.W() != null && this.f.W().R0() != null) {
                    this.n0 = this.f.W().R0();
                }
            }
            zfa X = yh9Var.X();
            J3(X, yh9Var);
            int i4 = 8;
            this.x.M(8);
            int i5 = 1;
            if (yh9Var.x0()) {
                this.p1 = true;
                this.k.u(true);
                this.k.a.hideBottomLine();
            } else {
                this.p1 = false;
                this.k.u(false);
            }
            if (this.f.W5() != null) {
                this.f.W5().w(this.p1);
            }
            if (X == null) {
                return;
            }
            this.S0 = X;
            this.x.M(0);
            this.y.e(yh9Var, this.o);
            this.A.e(yh9Var, this.J1, new p0(this));
            this.w.j(yh9Var);
            this.v.h(yh9Var, this.Q0);
            this.v.g(yh9Var);
            this.x.N(this.U0, this.R0, X, this.g2);
            if (this.d1 != null) {
                if (yh9Var.j0()) {
                    this.d1.getView().setVisibility(8);
                } else {
                    this.d1.getView().setVisibility(0);
                    ni9 ni9Var = new ni9(ni9.g);
                    ni9Var.b = yh9Var.g;
                    ni9Var.c = this.f.q6();
                    ni9Var.e = yh9Var.f;
                    ni9Var.f = yh9Var.O().isQuestionThread();
                    this.d1.j(ni9Var);
                }
            }
            A4(X);
            B4(yh9Var);
            SafeHandler.getInst().post(new q0(this));
            this.z.f(this.o);
            if (X.f1192T) {
                this.z.g(X.S());
                PbLandscapeListView pbLandscapeListView = this.o;
                this.z.c(this.o, (pbLandscapeListView == null || pbLandscapeListView.getHeaderViewsCount() <= 1) ? 0 : 0);
            }
            qk9 qk9Var = this.I;
            if (qk9Var != null && qk9Var.B() != null) {
                this.I.B().W(X.f1192T);
            }
            qk9 qk9Var2 = this.I;
            if (qk9Var2 != null) {
                qk9Var2.y0(X.f1192T);
            }
            MaskView maskView = this.O1;
            if (X.f1192T) {
                i4 = 0;
            }
            maskView.setVisibility(i4);
        }
    }

    public void p4(t45.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048765, this, cVar, z2) == null) {
            a55 a55Var = this.j0;
            if (a55Var != null) {
                a55Var.dismiss();
                this.j0 = null;
            }
            c55 c55Var = new c55(this.f.getContext());
            ArrayList arrayList = new ArrayList();
            yh9 yh9Var = this.R0;
            if (yh9Var != null && yh9Var.O() != null && !this.R0.O().isBjh()) {
                arrayList.add(new y45(0, this.f.getPageContext().getString(R.string.save_to_emotion), c55Var));
            }
            if (!z2) {
                arrayList.add(new y45(1, this.f.getPageContext().getString(R.string.save_to_local), c55Var));
            }
            c55Var.l(arrayList);
            c55Var.q(new n0(this, cVar));
            a55 a55Var2 = new a55(this.f.getPageContext(), c55Var);
            this.j0 = a55Var2;
            a55Var2.l();
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
        yh9 yh9Var = this.R0;
        if (yh9Var == null) {
            str = "";
        } else {
            threadData = yh9Var.O();
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
        dn9 dn9Var = this.y;
        if (dn9Var != null) {
            dn9Var.c(i2);
        }
        cn9 cn9Var = this.v;
        if (cn9Var != null) {
            cn9Var.e(i2);
        }
        en9 en9Var = this.w;
        if (en9Var != null) {
            en9Var.g(i2);
        }
        gn9 gn9Var = this.x;
        if (gn9Var != null) {
            gn9Var.C(i2);
        }
        fn9 fn9Var = this.z;
        if (fn9Var != null) {
            fn9Var.e();
        }
        bn9 bn9Var = this.A;
        if (bn9Var != null) {
            bn9Var.c();
        }
        MaskView maskView = this.O1;
        if (maskView != null) {
            maskView.f();
        }
        dm9 dm9Var = this.s;
        if (dm9Var != null) {
            dm9Var.o();
        }
        yk9 yk9Var = this.D;
        if (yk9Var != null) {
            yk9Var.n();
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
        s45 s45Var = this.J;
        if (s45Var != null) {
            s45Var.autoChangeSkinType(this.f.getPageContext());
        }
        K4(this.l0);
        this.I.f0();
        oq9 oq9Var = this.N;
        if (oq9Var != null) {
            oq9Var.C(i2);
        }
        EditorTools editorTools = this.r0;
        if (editorTools != null) {
            editorTools.z(i2);
        }
        jq9 jq9Var = this.P;
        if (jq9Var != null) {
            jq9Var.g(i2);
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
            bt5.a(this.f.getPageContext(), this.E);
        }
        fl9 fl9Var = this.m1;
        if (fl9Var != null) {
            fl9Var.l(i2);
        }
        wo9 wo9Var = this.k;
        if (wo9Var != null) {
            wo9Var.p(i2);
        }
        LinearLayout linearLayout = this.z0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(this.f.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        yh9 yh9Var = this.R0;
        if (yh9Var != null && yh9Var.q()) {
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
        dk9 dk9Var = this.y1;
        if (dk9Var != null) {
            dk9Var.l(i2);
        }
        PbThreadPostView pbThreadPostView = this.r;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i2);
        }
        CardForumHeadLayout cardForumHeadLayout = this.b;
        if (cardForumHeadLayout != null) {
            cardForumHeadLayout.g();
            EMManager.from(this.b).setCorner(R.string.J_X05).setBackGroundRealColor(gea.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
        }
        nq9 nq9Var = this.K0;
        if (nq9Var != null) {
            nq9Var.i();
        }
        mq9 mq9Var = this.N1;
        if (mq9Var != null) {
            mq9Var.c();
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
        ho9 ho9Var = this.T1;
        if (ho9Var != null) {
            ho9Var.b(i2);
        }
    }
}
