package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.fz5;
import com.baidu.tieba.hz4;
import com.baidu.tieba.iz4;
import com.baidu.tieba.iz5;
import com.baidu.tieba.l45;
import com.baidu.tieba.mj6;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.sub.BlankView;
import com.baidu.tieba.pb.pb.sub.EllipsizeRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.pb.pb.sub.SubPbView;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.rz4;
import com.baidu.tieba.sda;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tg9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class fn9 implements KeyboardEventLayout.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int o0;
    public static int p0;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadSkinView A;
    public BlueCircleProgressDialog B;
    public in9 C;
    public MorePopupWindow D;
    public iz4 E;
    public View F;
    public BlankView G;
    public View H;
    public pz4 I;
    public hz4 J;
    public View.OnClickListener K;
    public iz4 L;
    public boolean M;
    public ProgressBar N;
    public NewSubPbActivity.u0 O;
    public NewSubPbActivity.u0 P;
    public kf5 Q;
    public int R;
    public ArrayList<pea> S;

    /* renamed from: T  reason: collision with root package name */
    public pf9 f1101T;
    public TextView U;
    public RelativeLayout V;
    public ImageView W;
    public ImageView X;
    public LinearLayout Y;
    public ImageView Z;
    public SubPbView a;
    public View a0;
    public LinearLayout b;
    public int b0;
    public View c;
    public int c0;
    public BdTypeListView d;
    public SubPbModel d0;
    public po9 e;
    public int e0;
    public NewSubPbActivity f;
    public boolean f0;
    public NoNetworkView g;
    public fz5 g0;
    public NoDataView h;
    public iz5 h0;
    public View.OnClickListener i;
    public hn9 i0;
    public RelativeLayout j;
    public l45.g j0;
    public NavigationBar k;
    public MaskView k0;
    public ImageView l;
    public BdUniqueId l0;
    public View m;
    public final CustomMessageListener m0;
    public TextView n;
    public tg9 n0;
    public LinearLayout o;
    public HeadImageView p;
    public TextView q;
    public View r;
    public ImageView s;
    public TextView t;
    public TbImageView u;
    public TextView v;
    public EllipsizeRichTextView w;
    public TbImageView x;
    public PlayVoiceBntNew y;
    public TextView z;

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements sda.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fn9 a;

        public a(fn9 fn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fn9Var;
        }

        @Override // com.baidu.tieba.sda.h
        public void c(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                this.a.M();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fn9 a;

        public b(fn9 fn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fn9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.G != null) {
                this.a.a.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ fn9 b;

        public c(fn9 fn9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fn9Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int headerViewsCount = this.a + this.b.d.getHeaderViewsCount();
                if (headerViewsCount >= 1) {
                    headerViewsCount--;
                }
                this.b.d.setSelection(headerViewsCount);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fn9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(fn9 fn9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn9Var, Integer.valueOf(i)};
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
            this.a = fn9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2010045) {
                Object data = customResponsedMessage.getData();
                if (TbadkCoreApplication.getInst().getCurrentActivity() == this.a.f && (data instanceof Boolean)) {
                    this.a.a.setEnableDragExit(!((Boolean) data).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fn9 a;

        public e(fn9 fn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fn9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.d0 != null && (this.a.d0.a1() || this.a.d0.X0())) {
                    this.a.f.finish();
                } else if (this.a.G != null) {
                    this.a.a.g();
                } else {
                    this.a.f.finish();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements tg9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fn9 a;

        @Override // com.baidu.tieba.tg9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.tg9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public f(fn9 fn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fn9Var;
        }

        @Override // com.baidu.tieba.tg9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) != null) {
                return invokeLL.booleanValue;
            }
            this.a.q(false);
            this.a.q(true);
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements rz4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ fn9 b;

        public g(fn9 fn9Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn9Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fn9Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) {
                this.b.I.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.Z(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue(), false);
                        return;
                    case 11:
                        if (this.b.O != null) {
                            this.b.O.callback(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.f.p3(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        this.b.E0(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ fn9 b;

        public h(fn9 fn9Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn9Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fn9Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                if (this.b.P != null) {
                    this.b.P.callback(new Object[]{this.a.get(R.id.tag_del_post_id), this.a.get(R.id.tag_manage_user_identity), this.a.get(R.id.tag_del_post_is_self), this.a.get(R.id.tag_del_post_type)});
                }
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(fn9 fn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn9Var};
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
    public class j implements fz5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ fn9 b;

        public j(fn9 fn9Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn9Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fn9Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.fz5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.b.P != null) {
                    this.b.P.callback(new Object[]{this.a.get(R.id.tag_del_post_id), this.a.get(R.id.tag_manage_user_identity), this.a.get(R.id.tag_del_post_is_self), this.a.get(R.id.tag_del_post_type), JsonArrayToString});
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements iz5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ fn9 b;

        public k(fn9 fn9Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn9Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fn9Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.iz5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.b.P != null) {
                    this.b.P.callback(new Object[]{this.a.get(R.id.tag_del_post_id), this.a.get(R.id.tag_manage_user_identity), this.a.get(R.id.tag_del_post_is_self), this.a.get(R.id.tag_del_post_type), JsonArrayToString});
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ fn9 b;

        public l(fn9 fn9Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn9Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fn9Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.d.setEnabled(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947770040, "Lcom/baidu/tieba/fn9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947770040, "Lcom/baidu/tieba/fn9;");
                return;
            }
        }
        o0 = TbadkCoreApplication.getInst().getListItemRule().c();
        p0 = 2;
    }

    public View A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return (View) invokeV.objValue;
    }

    public ListView B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (ListView) invokeV.objValue;
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i0.a();
        }
        return invokeV.booleanValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.F;
        }
        return (View) invokeV.objValue;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            NavigationBar navigationBar = this.k;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public void D0() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (bdTypeListView = this.d) != null) {
            this.c0 = bdTypeListView.getLastVisiblePosition();
        }
    }

    public ImageView E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.X;
        }
        return (ImageView) invokeV.objValue;
    }

    public ImageView F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.W;
        }
        return (ImageView) invokeV.objValue;
    }

    public TextView G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.U;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.w;
        }
        return (TextView) invokeV.objValue;
    }

    public View I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public void K() {
        BlueCircleProgressDialog blueCircleProgressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (blueCircleProgressDialog = this.B) != null) {
            blueCircleProgressDialog.setDialogVisiable(false);
        }
    }

    public void L() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (noDataView = this.h) != null) {
            noDataView.setVisibility(8);
            this.d.setVisibility(0);
            this.V.setVisibility(0);
            this.a.setOnTouchListener(null);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.m0.setTag(this.l0);
            MessageManager.getInstance().registerListener(this.m0);
        }
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.a.e();
        }
        return invokeV.booleanValue;
    }

    public void T() {
        hn9 hn9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (hn9Var = this.i0) != null) {
            hn9Var.c();
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            SubPbView subPbView = this.a;
            if (subPbView != null) {
                subPbView.f();
            }
            kf5 kf5Var = this.Q;
            if (kf5Var != null) {
                kf5Var.G();
            }
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048605, this) != null) || this.f.J3()) {
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.d.setVisibility(0);
            this.N.setVisibility(8);
            this.C.g();
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.d.setVisibility(0);
            this.N.setVisibility(8);
            this.C.V();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            o0(this.f);
            this.d.setNextPage(this.C);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", p0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.N.bringToFront();
            this.N.setVisibility(0);
        }
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            BlankView blankView = this.G;
            if (blankView == null) {
                return 0;
            }
            return blankView.getHeight();
        }
        return invokeV.intValue;
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            if (this.B == null) {
                this.B = new BlueCircleProgressDialog(this.f.getPageContext());
            }
            this.B.setDialogVisiable(true);
        }
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            kf5 kf5Var = this.Q;
            if (kf5Var != null && kf5Var.a() != null) {
                return this.Q.a().getHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public ImageView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.Z;
        }
        return (ImageView) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.x;
        }
        return (View) invokeV.objValue;
    }

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.n;
        }
        return (View) invokeV.objValue;
    }

    public View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            this.d.setNextPage(this.C);
            this.C.U();
        }
    }

    public fn9(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.M = true;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = 0;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.b0 = 2;
        this.c0 = 0;
        this.e0 = 0;
        this.f0 = true;
        this.m0 = new d(this, 2010045);
        this.n0 = new tg9(new f(this));
        this.f = newSubPbActivity;
        this.K = onClickListener;
        this.a = (SubPbView) LayoutInflater.from(newSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0719, (ViewGroup) null);
        this.c = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0718, (ViewGroup) null);
        this.b = (LinearLayout) this.a.findViewById(R.id.navigation_bar_group);
        this.V = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092317);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092318);
        this.U = textView;
        textView.setOnClickListener(this.K);
        this.W = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09231a);
        ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092319);
        this.X = imageView;
        imageView.setOnClickListener(this.K);
        this.W.setOnClickListener(this.K);
        this.g = (NoNetworkView) this.a.findViewById(R.id.view_no_network);
        P();
        N();
        this.j = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09230a);
        this.d = (BdTypeListView) this.a.findViewById(R.id.obfuscated_res_0x7f091974);
        ThreadSkinView threadSkinView = (ThreadSkinView) LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0994, (ViewGroup) null);
        this.A = threadSkinView;
        this.d.addHeaderView(threadSkinView);
        this.d.addHeaderView(this.c);
        this.H = new TextView(newSubPbActivity.getActivity());
        this.H.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.d.w(this.H, 0);
        this.a.setTopView(this.H);
        this.a.setNavigationView(this.b);
        this.a.setListView(this.d);
        this.a.setContentView(this.j);
        in9 in9Var = new in9(this.f.getPageContext());
        this.C = in9Var;
        in9Var.B();
        this.F = this.C.c();
        this.d.setNextPage(this.C);
        this.C.G(this.K);
        this.d.setOnTouchListener(this.n0);
        po9 po9Var = new po9(newSubPbActivity.getPageContext());
        this.e = po9Var;
        po9Var.f();
        this.e.a(this.j0);
        this.e.D(TbadkCoreApplication.getInst().getSkinType());
        this.N = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f091d9d);
        this.k0 = (MaskView) this.a.findViewById(R.id.mask_view);
        this.a0 = this.a.findViewById(R.id.obfuscated_res_0x7f09295b);
        this.Y = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091adf);
        ImageView imageView2 = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0909a5);
        this.Z = imageView2;
        imageView2.setVisibility(0);
        this.Z.setOnClickListener(this.K);
        ImageView imageView3 = this.Z;
        if (imageView3 != null) {
            imageView3.setImageResource(R.drawable.icon_pure_post_expression24);
            p();
        }
        X(TbadkCoreApplication.getInst().getSkinType());
        View view2 = this.c;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        View a2 = aq4.b().a(this.f.getActivity(), 4);
        this.r = a2;
        if (a2 != null) {
            a2.setVisibility(8);
            this.o.addView(this.r, 3);
        }
        hn9 hn9Var = new hn9(this.f, this.d);
        this.i0 = hn9Var;
        hn9Var.f(this.M);
        this.i0.d(this.K);
        this.i0.b();
    }

    public void b0(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        a0(sparseArray, false);
    }

    public void d0(NewSubPbActivity.u0 u0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, u0Var) == null) {
            this.P = u0Var;
        }
    }

    public void f0(NewSubPbActivity.u0 u0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, u0Var) == null) {
            this.O = u0Var;
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.f0 = z;
        }
    }

    public void h0(l45.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, gVar) == null) {
            this.j0 = gVar;
            po9 po9Var = this.e;
            if (po9Var != null) {
                po9Var.a(gVar);
            }
        }
    }

    public void j0(SubPbModel subPbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, subPbModel) == null) {
            this.d0 = subPbModel;
        }
    }

    public void k0(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, zVar) == null) {
            this.i0.j(zVar);
        }
    }

    public void l0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onLongClickListener) == null) {
            this.i0.h(onLongClickListener);
        }
    }

    public void m0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, onClickListener) == null) {
            this.i = onClickListener;
        }
    }

    public void n0(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, onScrollListener) == null) {
            this.d.setOnScrollListener(onScrollListener);
        }
    }

    public void o0(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, pVar) == null) {
            this.d.setOnSrollToBottomListener(pVar);
        }
    }

    public void p0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, bdUniqueId) == null) {
            this.l0 = bdUniqueId;
            O();
        }
    }

    public final void q(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048630, this, z) == null) && (bdTypeListView = this.d) != null) {
            if (!z) {
                bdTypeListView.setEnabled(z);
            } else {
                bdTypeListView.postDelayed(new l(this, z), 10L);
            }
        }
    }

    public void v0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            Q(NoDataViewFactory.e.d(null, this.f.getResources().getString(R.string.refresh_view_title_text)));
            this.V.setVisibility(8);
        }
    }

    public void A0(pf9 pf9Var, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int i5;
        NewSubPbActivity newSubPbActivity;
        int top;
        String str;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{pf9Var, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || pf9Var == null) {
            return;
        }
        int i6 = 8;
        if (this.f0 && (view2 = this.c) != null) {
            view2.setVisibility(8);
            this.d.removeHeaderView(this.c);
            this.b0 = 1;
        }
        this.f1101T = pf9Var;
        if (pf9Var.g() != null) {
            this.f1101T.g().j0 = true;
        }
        View view3 = this.c;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        this.n.setText(R.string.obfuscated_res_0x7f0f1835);
        if (pf9Var.g() != null) {
            int L = pf9Var.g().L();
            this.R = L;
            if (L > 0) {
                this.k.setCenterTextTitle(String.format(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f14b5), Integer.valueOf(this.R)));
                NewSubPbActivity newSubPbActivity2 = this.f;
                if (newSubPbActivity2 != null) {
                    this.U.setText(newSubPbActivity2.h3());
                }
            } else {
                this.k.setCenterTextTitle(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f0c1e));
            }
            NewSubPbActivity newSubPbActivity3 = this.f;
            if (newSubPbActivity3 != null && newSubPbActivity3.G3()) {
                str = "PB";
            } else {
                str = null;
            }
            if (this.f != null && pf9Var.g().i0() != null) {
                this.A.setData(this.f.getPageContext(), pf9Var.g().i0(), vea.a("PB", "c0132", pf9Var.d().getId(), pf9Var.d().getName(), pf9Var.j().getId(), str));
            } else {
                this.A.setData(null, null, null);
            }
        }
        if (pf9Var.m()) {
            this.C.U();
            this.i0.g(true);
        } else {
            this.C.g();
            this.i0.g(false);
        }
        ArrayList<pea> i7 = pf9Var.i();
        this.S = i7;
        if (i7 != null && i7.size() > o0) {
            int size = this.S.size() - o0;
            c0(size);
            int firstVisiblePosition = this.d.getFirstVisiblePosition() - size;
            View childAt = this.d.getChildAt(0);
            if (childAt == null) {
                top = 0;
            } else {
                top = childAt.getTop();
            }
            i3 = size;
            i4 = firstVisiblePosition;
            i5 = top;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.S);
        if (ListUtils.isEmpty(this.S)) {
            this.d.setNextPage(null);
            if (this.f0) {
                arrayList.add(0, new nn9());
            }
        } else {
            this.d.setNextPage(this.C);
        }
        on9 on9Var = new on9();
        on9Var.b(pf9Var.k());
        arrayList.add(0, on9Var);
        if (this.f0) {
            arrayList.add(0, pf9Var.g());
        }
        NewSubPbActivity newSubPbActivity4 = this.f;
        if (newSubPbActivity4 != null && newSubPbActivity4.k3() != null) {
            MaskView maskView = this.k0;
            if (this.f.k3().b1()) {
                i6 = 0;
            }
            maskView.setVisibility(i6);
        }
        this.i0.e(this.f1101T.j(), arrayList);
        r(pf9Var, pf9Var.g(), pf9Var.e(), false, i2, z);
        if (i3 > 0) {
            this.d.setSelectionFromTop(i4, i5);
        } else if (z2 && (newSubPbActivity = this.f) != null && !ad.isEmpty(newSubPbActivity.k3().E0())) {
            String E0 = this.f.k3().E0();
            int i8 = 0;
            while (true) {
                if (i8 < arrayList.size()) {
                    if ((arrayList.get(i8) instanceof pea) && E0.equals(((pea) arrayList.get(i8)).U())) {
                        this.d.post(new c(this, i8));
                        break;
                    }
                    i8++;
                } else {
                    break;
                }
            }
        }
        if (this.f1101T.h() > 1) {
            this.d.setPullRefresh(this.e);
            this.a.setEnableDragExit(false);
            return;
        }
        this.d.setPullRefresh(null);
        this.a.setEnableDragExit(true);
    }

    public final void C0(MetaData metaData, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048581, this, metaData, z) != null) || metaData == null) {
            return;
        }
        String name_show = metaData.getName_show();
        int c2 = ns5.c(name_show);
        if (!StringUtils.isNull(metaData.getSealPrefix())) {
            i2 = ad.byteLength(metaData.getSealPrefix()) + 2;
        } else {
            i2 = 0;
        }
        if (c2 + i2 > 14) {
            String k2 = ns5.k(name_show, 0, 14);
            if (k2.length() == name_show.length()) {
                name_show = k2;
            } else {
                name_show = k2 + "...";
            }
        }
        if (!StringUtils.isNull(metaData.getSealPrefix())) {
            this.q.setText(J(metaData.getSealPrefix(), name_show));
        } else {
            this.q.setText(name_show);
        }
        if (metaData.getAlaUserData() != null && this.r != null) {
            if (metaData.getAlaUserData().anchor_live == 0) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                zp4 zp4Var = new zp4();
                zp4Var.a = metaData.getAlaUserData();
                zp4Var.b = 4;
                this.r.setTag(zp4Var);
            }
        }
        if (metaData.isBigV()) {
            SkinManager.setViewTextColor(this.q, (int) R.color.cp_cont_r);
        } else {
            EMManager.from(this.q).setTextColor(R.color.CAM_X0106);
        }
        this.p.setVisibility(0);
        this.p.setUserId(metaData.getUserId());
        this.p.setTargetScheme(metaData.getTargetScheme());
        this.p.setUserName(metaData.getUserName());
        this.p.setDefaultResource(R.drawable.transparent_bg);
        UtilHelper.showHeadImageViewBigV(this.p, metaData);
        dh9.a(this.p, metaData.getAvatarUrl(), metaData.getAvater(), 28);
        this.o.setTag(R.id.tag_user_id, metaData.getUserId());
        this.o.setTag(R.id.tag_user_target_scheme, metaData.getTargetScheme());
        this.o.setTag(R.id.tag_user_name, metaData.getUserName());
        this.o.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        if (z) {
            this.t.setVisibility(0);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0302);
            this.u.setVisibility(8);
            return;
        }
        this.t.setVisibility(8);
        if (ListUtils.isEmpty(metaData.getTags())) {
            this.u.setVisibility(8);
            return;
        }
        xk9.f(this.u, metaData.getTags().get(0).img_info);
    }

    public void E0(boolean z) {
        String str;
        NewSubPbActivity newSubPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            hn9 hn9Var = this.i0;
            if (hn9Var != null) {
                hn9Var.i(z);
                this.i0.c();
            }
            if (z && (newSubPbActivity = this.f) != null) {
                pm9.d(newSubPbActivity.getPageContext(), this.d0, this);
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            pf9 pf9Var = this.f1101T;
            if (pf9Var != null && pf9Var.d() != null) {
                str = this.f1101T.d().getId();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "2"));
        }
    }

    public final SpannableStringBuilder J(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null) {
                return spannableStringBuilder;
            }
            if (str != null) {
                arrayList.add(new mj6.a(str, R.drawable.pic_smalldot_title));
                return mj6.h(this.f.getActivity(), str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public void w0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048643, this, str, z) == null) {
            if (z) {
                Q(NoDataViewFactory.e.d("", str));
            } else {
                Q(NoDataViewFactory.e.d(str, this.f.getPageContext().getString(R.string.refresh_view_title_text)));
            }
            this.V.setVisibility(8);
        }
    }

    public void M() {
        kf5 kf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.U != null && (kf5Var = this.Q) != null) {
            if (kf5Var.z()) {
                this.U.setText(R.string.obfuscated_res_0x7f0f0610);
            } else {
                this.U.setText(this.f.h3());
            }
        }
    }

    public void m() {
        SubPbModel subPbModel;
        boolean z;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048622, this) != null) || (subPbModel = this.d0) == null) {
            return;
        }
        if ((B0() || (view2 = this.F) == null || !view2.isShown()) && !ListUtils.isEmpty(this.S)) {
            z = true;
        } else {
            z = false;
        }
        subPbModel.o1(z);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            MorePopupWindow morePopupWindow = this.D;
            if (morePopupWindow != null) {
                hb.d(morePopupWindow, this.f.getPageContext().getPageActivity());
            }
            iz4 iz4Var = this.E;
            if (iz4Var != null) {
                iz4Var.e();
            }
            hz4 hz4Var = this.J;
            if (hz4Var != null) {
                hz4Var.dismiss();
            }
            pz4 pz4Var = this.I;
            if (pz4Var != null) {
                hb.b(pz4Var, this.f.getPageContext());
            }
            ProgressBar progressBar = this.N;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09231b);
            this.o = linearLayout;
            linearLayout.setOnClickListener(this.K);
            HeadImageView headImageView = (HeadImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091c99);
            this.p = headImageView;
            headImageView.setRadius(BdUtilHelper.getDimens(this.f.getActivity(), R.dimen.tbds45));
            this.p.setClickable(false);
            this.q = (TextView) this.c.findViewById(R.id.user_name);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f092866);
            this.s = imageView;
            imageView.setVisibility(8);
            this.t = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090b87);
            this.u = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090b88);
            this.v = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f092570);
            EllipsizeRichTextView ellipsizeRichTextView = (EllipsizeRichTextView) this.c.findViewById(R.id.obfuscated_res_0x7f0907e3);
            this.w = ellipsizeRichTextView;
            ellipsizeRichTextView.setOnClickListener(this.K);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0105);
            this.w.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            this.w.setLineSpacing(0.0f, 1.25f);
            TbImageView tbImageView = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09230b);
            this.x = tbImageView;
            tbImageView.setOnClickListener(this.K);
            this.z = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090153);
            this.y = (PlayVoiceBntNew) this.c.findViewById(R.id.obfuscated_res_0x7f0929bf);
            this.c.setOnTouchListener(this.n0);
            this.c.setOnClickListener(this.K);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            int dimens = BdUtilHelper.getDimens(this.f.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070420);
            int dimens2 = BdUtilHelper.getDimens(this.f.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d4);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.k = navigationBar;
            this.m = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
            ImageView backImageView = this.k.getBackImageView();
            this.l = backImageView;
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.height = dimens;
                layoutParams.width = dimens;
                layoutParams.leftMargin = dimens2;
                backImageView.setLayoutParams(layoutParams);
            }
            View view2 = this.m;
            if (view2 != null && (view2.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams2.width = dimens;
                layoutParams2.height = dimens;
                this.m.setLayoutParams(layoutParams2);
            }
            this.k.hideBottomLine();
            TextView textView = new TextView(this.f);
            this.n = textView;
            EMManager.from(textView).setTextColor(R.color.CAM_X0304).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X01);
            this.k.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.n, (View.OnClickListener) null);
            ViewCommonUtil.setViewMarginByDimen(this.n, -1, -1, R.dimen.M_W_X007, -1);
            this.n.setOnClickListener(this.K);
        }
    }

    public final void Q(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f.getPageContext().getString(R.string.refresh_view_button_text), this.i));
            if (this.h == null) {
                Activity pageActivity = this.f.getPageContext().getPageActivity();
                this.h = NoDataViewFactory.a(pageActivity, this.j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, BdUtilHelper.getDimens(pageActivity, R.dimen.obfuscated_res_0x7f0703a6)), eVar, a2);
            }
            this.d.setVisibility(8);
            this.N.setVisibility(8);
            this.Q.B();
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            this.h.setClickable(true);
            this.h.setTextOption(eVar);
            this.h.f(this.f.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.h.setVisibility(0);
        }
    }

    public void s0(pea peaVar) {
        int i2;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048635, this, peaVar) != null) || peaVar == null) {
            return;
        }
        peaVar.f1(true);
        pea peaVar2 = new pea();
        peaVar2.m1(52);
        if (!B0() && (view2 = this.F) != null && view2.isShown()) {
            i2 = (this.c0 - this.b0) - 1;
        } else {
            i2 = this.c0 - this.b0;
        }
        int count = ListUtils.getCount(this.S);
        if (i2 > count) {
            i2 = count;
        }
        ArrayList arrayList = new ArrayList(ListUtils.subList(this.S, 0, i2));
        ListUtils.add(arrayList, peaVar2);
        ListUtils.add(arrayList, peaVar);
        this.d.smoothScrollToPosition(this.c0 + 2);
        this.d.setNextPage(null);
    }

    public void R(kf5 kf5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, kf5Var) == null) && kf5Var != null && kf5Var.a() != null) {
            this.Q = kf5Var;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.j.addView(kf5Var.a(), layoutParams);
            this.Q.V(new a(this));
        }
    }

    public final void c0(int i2) {
        ArrayList<pea> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048610, this, i2) != null) || (arrayList = this.S) == null) {
            return;
        }
        if (arrayList.size() <= i2) {
            this.S.clear();
        }
        int i3 = 0;
        Iterator<pea> it = this.S.iterator();
        while (it.hasNext()) {
            it.next();
            i3++;
            it.remove();
            if (i3 >= i2) {
                return;
            }
        }
    }

    public void X(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            BDLayoutMode layoutMode = this.f.getLayoutMode();
            if (i2 == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.f.getLayoutMode().onModeChanged(this.a);
            this.f.getLayoutMode().onModeChanged(this.c);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            this.k.onChangeSkinType(this.f.getPageContext(), i2);
            SubPbModel subPbModel = this.d0;
            if (subPbModel != null && (subPbModel.a1() || this.d0.X0())) {
                WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            TextView textView = this.n;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0304);
            }
            this.g.onChangeSkinType(this.f.getPageContext(), i2);
            this.f.getLayoutMode().onModeChanged(this.F);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0105);
            this.w.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            kf5 kf5Var = this.Q;
            if (kf5Var != null && kf5Var.a() != null) {
                this.Q.a().z(i2);
            }
            this.C.e(i2);
            this.y.b();
            SkinManager.setViewTextColor(this.U, (int) R.color.CAM_X0110);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0302);
            EMManager.from(this.q).setTextStyle(R.string.F_X01);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0106);
            this.U.setAlpha(0.95f);
            hn9 hn9Var = this.i0;
            if (hn9Var != null) {
                hn9Var.c();
            }
            SkinManager.setBackgroundColor(this.a0, R.color.CAM_X0203);
            WebPManager.setPureDrawable(this.Z, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            this.Y.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(this.f, R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            EMManager.from(this.V).setBackGroundColor(R.color.CAM_X0208);
        }
    }

    public void Z(int i2, String str, int i3, boolean z, boolean z2) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
            if (i3 == 1002 && !z) {
                i4 = R.string.report_post_confirm;
            } else {
                i4 = R.string.del_all_post_confirm;
            }
            if (i2 == 0) {
                if (i3 == 1002 && !z) {
                    i4 = R.string.report_thread_confirm;
                } else {
                    i4 = R.string.del_thread_confirm;
                }
            }
            hz4 hz4Var = new hz4(this.f.getPageContext().getPageActivity());
            this.J = hz4Var;
            hz4Var.setMessageId(i4);
            this.J.setYesButtonTag(sparseArray);
            this.J.setPositiveButton(R.string.obfuscated_res_0x7f0f05a1, new h(this, sparseArray));
            this.J.setNegativeButton(R.string.obfuscated_res_0x7f0f0596, new i(this));
            this.J.setCancelable(true);
            this.J.create(this.f.getPageContext());
            if (z2) {
                this.J.show();
            } else if (z) {
                this.J.show();
            } else if (1 == this.d0.A0()) {
                hz5 hz5Var = new hz5(this.d0.A0(), this.d0.z0(), this.d0.D0());
                hz5Var.i(this.f1101T.d().getId(), this.f1101T.d().getName());
                hz5Var.h(this.d0.B0());
                hz5Var.j(this.d0.R0());
                UserData userData = new UserData();
                userData.setIsManager(this.d0.F0());
                u0(sparseArray, hz5Var, userData);
            } else {
                y0(sparseArray);
            }
        }
    }

    public void a0(SparseArray<Object> sparseArray, boolean z) {
        int i2;
        nz4 nz4Var;
        nz4 nz4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048608, this, sparseArray, z) == null) {
            rz4 rz4Var = new rz4(this.f.getBaseContext());
            rz4Var.u(this.f.getString(R.string.obfuscated_res_0x7f0f0326));
            rz4Var.r(new g(this, z));
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
                if (z) {
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
            this.I = pz4Var;
            pz4Var.l();
        }
    }

    public void k(boolean z) {
        SubPbModel subPbModel;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048618, this, z) == null) && (subPbModel = this.d0) != null && subPbModel.Z0() && !z) {
            this.k.setIsClose(true);
            this.k.setIsCorner(true);
            this.k.isShowBottomLine(true);
            this.k.setBottomLineHeight(3);
            this.k.setStatusBarVisibility(8);
            this.G = new BlankView(this.f.getPageContext().getPageActivity());
            if (this.d0.a1()) {
                boolean isNotchScreen = TbSingleton.getInstance().isNotchScreen(this.f);
                boolean isCutoutScreen = TbSingleton.getInstance().isCutoutScreen(this.f);
                if (!isNotchScreen && !isCutoutScreen) {
                    i2 = UtilHelper.getStatusBarHeight();
                } else {
                    i2 = 0;
                }
                this.e0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds562) + i2;
            } else {
                this.e0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07037a);
            }
            this.b.addView(this.G, 0, new LinearLayout.LayoutParams(-1, this.e0));
            this.G.setVisibility(0);
            this.G.setOnClickListener(new b(this));
            this.a.setBlankView(this.G);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0250  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(pea peaVar, int i2, SparseArray<Object> sparseArray) {
        SparseArray<Object> sparseArray2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        int i3;
        boolean z5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048624, this, peaVar, i2, sparseArray) != null) || peaVar == null) {
            return;
        }
        if (sparseArray == null) {
            sparseArray2 = new SparseArray<>();
        } else {
            sparseArray2 = sparseArray;
        }
        if (i2 != 0) {
            if (i2 != 3) {
                z = true;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            String userId2 = peaVar.t().getUserId();
            if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = false;
            }
            if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                z = false;
            }
        } else {
            z = false;
            z2 = false;
        }
        pf9 pf9Var = this.f1101T;
        if (pf9Var != null && pf9Var.j() != null && this.f1101T.j().getAuthor() != null && peaVar.t() != null) {
            String userId3 = this.f1101T.j().getAuthor().getUserId();
            String userId4 = peaVar.t().getUserId();
            if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    z3 = false;
                    z4 = true;
                    userId = peaVar.t().getUserId();
                    if (userId != null) {
                        z2 = true;
                        z4 = true;
                    }
                    if (peaVar.L() == 1) {
                    }
                    if (z) {
                    }
                    if (z2) {
                    }
                    sparseArray2.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
                    sparseArray2.put(R.id.tag_forbid_user_post_id, peaVar.U());
                    if (z) {
                    }
                    if (z3) {
                    }
                    if (z2) {
                    }
                } else {
                    z2 = true;
                    z3 = true;
                    z4 = false;
                    userId = peaVar.t().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = true;
                    }
                    if (peaVar.L() == 1) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    if (z) {
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray2.put(R.id.tag_forbid_user_post_id, peaVar.U());
                        if (peaVar.t() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, peaVar.t().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, peaVar.t().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, peaVar.t().getPortrait());
                        }
                        z5 = true;
                    } else {
                        sparseArray2.put(R.id.tag_forbid_user_name, "");
                        sparseArray2.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray2.put(R.id.tag_forbid_user_portrait, "");
                        z5 = false;
                    }
                    if (z2) {
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.TRUE);
                        sparseArray2.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray2.put(R.id.tag_del_post_id, peaVar.U());
                        z5 = true;
                    } else {
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.FALSE);
                        sparseArray2.put(R.id.tag_del_post_type, 0);
                        sparseArray2.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray2.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
                    sparseArray2.put(R.id.tag_forbid_user_post_id, peaVar.U());
                    if (z) {
                        sparseArray2.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        if (peaVar.t() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, peaVar.t().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, peaVar.t().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, peaVar.t().getPortrait());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray2.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (peaVar.t() != null) {
                            sparseArray2.put(R.id.tag_user_mute_mute_userid, peaVar.t().getUserId());
                            sparseArray2.put(R.id.tag_user_mute_mute_username, peaVar.t().getUserName());
                            sparseArray2.put(R.id.tag_user_mute_mute_nameshow, peaVar.t().getName_show());
                        }
                        pf9 pf9Var2 = this.f1101T;
                        if (pf9Var2 != null && pf9Var2.j() != null) {
                            sparseArray2.put(R.id.tag_user_mute_thread_id, this.f1101T.j().getId());
                        }
                        sparseArray2.put(R.id.tag_user_mute_post_id, peaVar.U());
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (z2) {
                        sparseArray2.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray2.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray2.put(R.id.tag_del_post_id, peaVar.U());
                        sparseArray2.put(R.id.tag_has_sub_post, Boolean.valueOf(peaVar.A0()));
                        return;
                    }
                    sparseArray2.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    return;
                }
            }
        }
        z3 = false;
        z4 = false;
        userId = peaVar.t().getUserId();
        if (userId != null) {
        }
        if (peaVar.L() == 1) {
        }
        if (z) {
        }
        if (z2) {
        }
        sparseArray2.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
        sparseArray2.put(R.id.tag_forbid_user_post_id, peaVar.U());
        if (z) {
        }
        if (z3) {
        }
        if (z2) {
        }
    }

    public void r(pf9 pf9Var, pea peaVar, boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{pf9Var, peaVar, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) && peaVar != null && !this.f0) {
            if (!StringUtils.isNull(peaVar.K())) {
                this.x.setVisibility(0);
                this.x.startLoad(peaVar.K(), 10, true);
            } else {
                this.x.setVisibility(8);
            }
            iea C = peaVar.C();
            if (C != null && C.a) {
                this.z.setVisibility(0);
            } else {
                this.z.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.c.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.c.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, peaVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            n(peaVar, i2, sparseArray);
            this.q.setText((CharSequence) null);
            if (!this.f0) {
                C0(peaVar.t(), z);
            }
            this.v.setText(StringHelper.getFormatTime(peaVar.q0()));
            boolean r0 = r0(this.w, peaVar.f0());
            if (StringUtils.isNull(peaVar.K()) && !r0 && peaVar.x0() != null) {
                this.y.setVisibility(0);
                this.y.setTag(peaVar.x0());
                return;
            }
            this.y.setVisibility(8);
        }
    }

    public final boolean r0(TextView textView, TbRichText tbRichText) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048633, this, textView, tbRichText)) == null) {
            if (textView != null && tbRichText != null && tbRichText.P() != null) {
                TbRichTextData tbRichTextData = new TbRichTextData(1);
                Iterator<TbRichTextData> it = tbRichText.P().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        int type = next.getType();
                        if (type != 1) {
                            if (type != 2) {
                                if (type != 17) {
                                    if (type != 18 && type != 1282) {
                                    }
                                } else {
                                    String str = next.Q().mGifInfo.mSharpText;
                                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                                        String substring = str.substring(2, str.length() - 1);
                                        tbRichTextData.O(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                                    }
                                }
                            }
                            tbRichTextData.n0(true);
                            textView.setMovementMethod(xra.a());
                        } else {
                            tbRichTextData.O(next.Z());
                        }
                    }
                }
                if (!tbRichTextData.g0()) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                try {
                    if (tbRichTextData.Z() == null || tbRichTextData.Z().length() <= 0) {
                        return false;
                    }
                    textView.setText(tbRichTextData.Z());
                    return true;
                } catch (Exception unused) {
                    textView.setText("");
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void s(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            ProgressBar progressBar = this.N;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (z && z2) {
                NewSubPbActivity newSubPbActivity = this.f;
                newSubPbActivity.showToast(newSubPbActivity.getResources().getString(R.string.delete_success));
            } else if (str != null && z2) {
                this.f.showToast(str);
            }
        }
    }

    public final void u0(SparseArray<Object> sparseArray, hz5 hz5Var, UserData userData) {
        NewSubPbActivity newSubPbActivity;
        AntiData w0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048639, this, sparseArray, hz5Var, userData) == null) && (newSubPbActivity = this.f) != null && sparseArray != null && this.c != null) {
            if (this.h0 == null) {
                this.h0 = new iz5(newSubPbActivity.getPageContext(), this.c, hz5Var, userData);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            SubPbModel subPbModel = this.d0;
            if (subPbModel != null && (w0 = subPbModel.w0()) != null && w0.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = w0.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray2);
            this.h0.H(new String[]{this.f.getString(R.string.delete_thread_reason_1), this.f.getString(R.string.delete_thread_reason_2), this.f.getString(R.string.delete_thread_reason_3), this.f.getString(R.string.delete_thread_reason_4), this.f.getString(R.string.delete_thread_reason_5)});
            this.h0.G(negativeFeedBackData);
            this.h0.J("4");
            this.h0.I(new k(this, sparseArray));
        }
    }

    public void x0(iz4.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048645, this, cVar, z) == null) {
            iz4 iz4Var = this.L;
            if (iz4Var != null) {
                iz4Var.e();
                this.L = null;
            }
            iz4 iz4Var2 = new iz4(this.f.getPageContext().getPageActivity());
            this.L = iz4Var2;
            if (z) {
                iz4Var2.j(new String[]{this.f.getPageContext().getString(R.string.save_to_emotion)}, cVar);
            } else {
                iz4Var2.j(new String[]{this.f.getPageContext().getString(R.string.save_to_emotion), this.f.getPageContext().getString(R.string.save_to_local)}, cVar);
            }
            this.L.c(this.f.getPageContext());
            this.L.m();
        }
    }

    public final void y0(SparseArray<Object> sparseArray) {
        NewSubPbActivity newSubPbActivity;
        AntiData w0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048647, this, sparseArray) == null) && (newSubPbActivity = this.f) != null && sparseArray != null && this.c != null) {
            if (this.g0 == null) {
                this.g0 = new fz5(newSubPbActivity.getPageContext(), this.c);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            SubPbModel subPbModel = this.d0;
            if (subPbModel != null && (w0 = subPbModel.w0()) != null && w0.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = w0.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray2);
            this.g0.B(new String[]{this.f.getString(R.string.delete_thread_reason_1), this.f.getString(R.string.delete_thread_reason_2), this.f.getString(R.string.delete_thread_reason_3), this.f.getString(R.string.delete_thread_reason_4), this.f.getString(R.string.delete_thread_reason_5)});
            this.g0.A(negativeFeedBackData);
            this.g0.D("4");
            this.g0.C(new j(this, sparseArray));
        }
    }
}
