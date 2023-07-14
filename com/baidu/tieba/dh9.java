package com.baidu.tieba;

import android.app.Activity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FoldCommentActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.a65;
import com.baidu.tieba.a66;
import com.baidu.tieba.d66;
import com.baidu.tieba.p55;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.BlankView;
import com.baidu.tieba.pb.pb.sub.SubPbView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class dh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public TbRichTextView.z B;
    public gg9 C;
    public View.OnLongClickListener D;
    public y55 E;
    public p55 F;
    public int G;
    public PbFragment.e3 H;
    public ma5 I;
    public a66 J;
    public d66 K;
    public String L;
    public PermissionJudgePolicy M;
    public boolean N;
    public EditorTools O;
    public gi9 P;
    public lk9 Q;
    public PbFakeFloorModel R;
    public BdListView.p S;

    /* renamed from: T  reason: collision with root package name */
    public CustomMessageListener f1093T;
    public FoldCommentActivity a;
    public PbModel b;
    public NoNetworkView c;
    public NoDataView d;
    public SubPbView e;
    public LinearLayout f;
    public NavigationBar g;
    public ImageView h;
    public View i;
    public View j;
    public ImageView k;
    public AlertDialog l;
    public BlankView m;
    public RelativeLayout n;
    public BdTypeListView o;
    public im9 p;
    public ProgressBar q;
    public bh9 r;
    public ze9 s;
    public boolean t;
    public TextView u;
    public RelativeLayout v;
    public LinearLayout w;
    public HeadImageView x;
    public View y;
    public View.OnClickListener z;

    /* loaded from: classes5.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh9 a;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ t a;

            public a(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a.l != null) {
                    this.a.a.l.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ t a;

            public b(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_COMMUNITY_CONVENTION_CLICK).addParam("obj_locate", "3").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                    UrlManager.getInstance().dealOneLink(this.a.a.a.getPageContext(), new String[]{TbConfig.COMMUNITY_CONVENTION});
                    if (this.a.a.s != null) {
                        TiebaStatic.log(new StatisticItem("c14445").param("tid", this.a.a.s.P()).param("fname", this.a.a.s.m()).param("fid", this.a.a.s.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                    }
                }
            }
        }

        public t(dh9 dh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0488));
                if (this.a.s != null) {
                    TiebaStatic.log(new StatisticItem("c14444").param("tid", this.a.s.P()).param("fname", this.a.s.m()).param("fid", this.a.s.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                }
                TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0b3d, TBAlertConfig.OperateBtnStyle.MAIN);
                aVar.c(new a(this));
                LinearLayout linearLayout = new LinearLayout(this.a.a);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                linearLayout.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X008), 0, 0);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView textView = new TextView(this.a.a);
                textView.setText(R.string.obfuscated_res_0x7f0f1826);
                textView.setTextSize(0, UtilHelper.getDimenPixelSize(R.dimen.T_X07));
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0304));
                textView.setOnClickListener(new b(this));
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
                ImageView imageView = new ImageView(this.a.a);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS));
                linearLayout.addView(imageView, new LinearLayout.LayoutParams(yi.g(this.a.a, R.dimen.tbds36), yi.g(this.a.a, R.dimen.tbds36)));
                dh9 dh9Var = this.a;
                TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(dh9Var.a);
                tBAlertBuilder.w(R.string.obfuscated_res_0x7f0f0487);
                tBAlertBuilder.q(spannableString);
                tBAlertBuilder.n(3);
                tBAlertBuilder.k(linearLayout);
                tBAlertBuilder.o(true);
                tBAlertBuilder.p(LinkMovementMethod.getInstance());
                tBAlertBuilder.u(aVar);
                tBAlertBuilder.j(true);
                dh9Var.l = tBAlertBuilder.z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh9 a;

        public a(dh9 dh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh9Var;
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
                    this.a.a.l2(sparseArray);
                    return;
                }
                this.a.O(view2);
            } else if (z2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.a.a.l2(sparseArray);
            } else if (z3) {
                this.a.K(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh9 a;

        public b(dh9 dh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.z2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a65.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ dh9 b;

        public c(dh9 dh9Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dh9Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.a65.f
        public void L0(a65 a65Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, a65Var, i, view2) == null) {
                this.b.E.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.K(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.H != null) {
                            this.b.H.callback(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.a.I2(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        this.b.h0(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(dh9 dh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ dh9 c;

        public e(dh9 dh9Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dh9Var;
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
                    yi.Q(this.c.a, R.string.obfuscated_res_0x7f0f0e1f);
                } else {
                    this.c.a.r2(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public f(dh9 dh9Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var, alertDialog};
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
    public class g implements d66.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ dh9 b;

        public g(dh9 dh9Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dh9Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.d66.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.r2(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements a66.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p55 a;
        public final /* synthetic */ dh9 b;

        public h(dh9 dh9Var, p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var, p55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dh9Var;
            this.a = p55Var;
        }

        @Override // com.baidu.tieba.a66.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.s2(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh9 a;

        public i(dh9 dh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.Q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements aj5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh9 a;

        public j(dh9 dh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh9Var;
        }

        @Override // com.baidu.tieba.aj5
        public void B(zi5 zi5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zi5Var) == null) {
                Object obj = zi5Var.c;
                if ((obj instanceof yd5) && EmotionGroupType.isSendAsPic(((yd5) obj).getType())) {
                    if (this.a.M == null) {
                        this.a.M = new PermissionJudgePolicy();
                    }
                    this.a.M.clearRequestPermissionList();
                    this.a.M.appendRequestPermission(this.a.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.M.startRequestPermission(this.a.a)) {
                        return;
                    }
                    this.a.a.E2().f((yd5) zi5Var.c);
                    this.a.a.E2().w(false, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh9 a;

        public k(dh9 dh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh9Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.I();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh9 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public l(dh9 dh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh9Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.a.a.s != null && this.a.a.s.e() != null) {
                if (!this.a.a.s.e().e()) {
                    this.a.a.s.a(false);
                }
                this.a.a.s.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && this.a.O != null && this.a.O.getVisibility() == 0 && charSequence != null && charSequence.length() >= (i4 = i3 + i)) {
                String substring = charSequence.toString().substring(i, i4);
                if (TextUtils.isEmpty(substring)) {
                    return;
                }
                if (this.a.Q == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(2, this.a.O.getId());
                    dh9 dh9Var = this.a;
                    dh9Var.Q = new lk9(dh9Var.a.getPageContext(), this.a.e, layoutParams);
                    this.a.Q.r(this.a.O);
                }
                this.a.Q.p(substring);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(dh9 dh9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var, Integer.valueOf(i)};
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
            this.a = dh9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof rf9)) {
                rf9 rf9Var = (rf9) customResponsedMessage.getData();
                if (this.a.e != null) {
                    this.a.e.setSubPbViewData(rf9Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh9 a;

        public n(dh9 dh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.I();
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh9 a;

        public o(dh9 dh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                return;
            }
            this.a.a.Y2();
            if (this.a.a != null && this.a.a.B2() != null && this.a.a.B2().z1() != null && this.a.a.B2().z1().N() != null && this.a.a.B2().z1().N().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.a.B2().T1()).param("fid", this.a.a.B2().z1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.a.B2().S1()).param("fid", this.a.a.B2().z1().l()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh9 a;

        public p(dh9 dh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.Q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh9 a;

        public q(dh9 dh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh9Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(yca ycaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ycaVar) == null) {
                this.a.R.m0(ycaVar);
                this.a.r.b();
                this.a.P.g();
                this.a.O.t();
                this.a.Z(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh9 a;

        public r(dh9 dh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.e != null) {
                this.a.e.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh9 a;

        public s(dh9 dh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.finish();
            }
        }
    }

    public dh9(FoldCommentActivity foldCommentActivity, View.OnClickListener onClickListener, TbRichTextView.z zVar, gg9 gg9Var, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {foldCommentActivity, onClickListener, zVar, gg9Var, onLongClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        this.q = null;
        this.E = null;
        this.F = null;
        this.G = 0;
        this.I = null;
        this.N = false;
        this.S = new k(this);
        this.f1093T = new m(this, 2921597);
        this.a = foldCommentActivity;
        this.b = foldCommentActivity.B2();
        this.z = onClickListener;
        this.B = zVar;
        this.C = gg9Var;
        this.D = onLongClickListener;
        SubPbView subPbView = (SubPbView) LayoutInflater.from(foldCommentActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0517, (ViewGroup) null);
        this.e = subPbView;
        this.f = (LinearLayout) subPbView.findViewById(R.id.navigation_bar_group);
        RelativeLayout relativeLayout = (RelativeLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090b77);
        this.v = relativeLayout;
        relativeLayout.setVisibility(8);
        this.u = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f090b78);
        this.c = (NoNetworkView) this.e.findViewById(R.id.view_no_network);
        F();
        this.n = (RelativeLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090b75);
        this.o = (BdTypeListView) this.e.findViewById(R.id.obfuscated_res_0x7f090b7a);
        View view2 = new View(foldCommentActivity.getActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, 16));
        this.o.w(view2, 0);
        this.o.setOnSrollToBottomListener(this.S);
        this.e.setTopView(view2);
        this.e.setNavigationView(this.f);
        this.e.setListView(this.o);
        this.e.setContentView(this.n);
        im9 im9Var = new im9(foldCommentActivity.getPageContext());
        this.p = im9Var;
        im9Var.B();
        this.p.G(new n(this));
        this.o.setNextPage(this.p);
        this.q = (ProgressBar) this.e.findViewById(R.id.obfuscated_res_0x7f091d48);
        this.y = this.e.findViewById(R.id.obfuscated_res_0x7f092917);
        LinearLayout linearLayout = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090b76);
        this.w = linearLayout;
        linearLayout.setOnClickListener(new o(this));
        HeadImageView headImageView = (HeadImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090b79);
        this.x = headImageView;
        headImageView.setVisibility(0);
        this.x.setIsRound(true);
        this.x.setBorderWidth(yi.g(this.a, R.dimen.L_X01));
        this.x.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.x.setDefaultBgResource(0);
        this.x.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.x.N(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        J(TbadkCoreApplication.getInst().getSkinType());
        E();
        PbFakeFloorModel pbFakeFloorModel = new PbFakeFloorModel(this.a.getPageContext());
        this.R = pbFakeFloorModel;
        pbFakeFloorModel.o0(this.b.e0(), this.b.a0(), this.b.b0(), this.b.Z(), this.b.f0());
        gi9 gi9Var = new gi9(this.a.getPageContext(), this.R, this.n);
        this.P = gi9Var;
        gi9Var.p(new p(this));
        this.P.s(this.a.P);
        this.R.q0(new q(this));
        this.a.registerListener(this.f1093T);
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && this.v != null && z) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.v.startAnimation(alphaAnimation);
        }
    }

    public void O(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        N(sparseArray, false);
    }

    public void U(PbFragment.e3 e3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, e3Var) == null) {
            this.H = e3Var;
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.N = z;
        }
    }

    public void X(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, pbModel) == null) {
            this.b = pbModel;
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048603, this, z) == null) && this.v != null && z) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.v.startAnimation(alphaAnimation);
        }
    }

    public void e0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            G(NoDataViewFactory.e.d(null, this.a.getResources().getString(R.string.refresh_view_title_text)));
            this.v.setVisibility(8);
        }
    }

    public void h0(boolean z) {
        bh9 bh9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048609, this, z) == null) && (bh9Var = this.r) != null) {
            bh9Var.f(z);
            this.r.b();
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.v == null) {
            return;
        }
        this.y.setVisibility(8);
        this.v.setVisibility(8);
    }

    public void C() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (editorTools = this.O) != null) {
            editorTools.q();
            lk9 lk9Var = this.Q;
            if (lk9Var != null) {
                lk9Var.m();
            }
        }
    }

    public void D() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (noDataView = this.d) != null) {
            noDataView.setVisibility(8);
            this.o.setVisibility(0);
        }
    }

    public void H() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.a != null && (editorTools = this.O) != null) {
            editorTools.j();
            A();
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            P();
            C();
            this.P.g();
            Z(false);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.o.setVisibility(0);
            this.q.setVisibility(8);
            this.p.g();
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.o.setVisibility(0);
            this.q.setVisibility(8);
            this.p.V();
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.I == null) {
                this.I = new ma5(this.a.getPageContext());
            }
            this.I.h(true);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            C();
        }
    }

    public BdTypeListView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.o;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public PbFakeFloorModel w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.R;
        }
        return (PbFakeFloorModel) invokeV.objValue;
    }

    public gi9 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.P;
        }
        return (gi9) invokeV.objValue;
    }

    public SubPbView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.e;
        }
        return (SubPbView) invokeV.objValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            bh9 bh9Var = new bh9(this.a, this.o);
            this.r = bh9Var;
            bh9Var.j(this.a.I0());
            this.r.k(this.a.F2());
            this.r.g(this.B);
            this.r.c(this.z);
            this.r.l(this.C);
            this.r.g(this.B);
            this.r.h(this.D);
            a aVar = new a(this);
            this.A = aVar;
            this.r.e(aVar);
            this.r.a();
        }
    }

    public final void I() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (pbModel = this.b) != null && pbModel.z1() != null && this.b.z1().y() != null && yi.G()) {
            if (this.b.z1().y().b() == 0) {
                T();
                return;
            }
            im9 im9Var = this.p;
            if (im9Var != null) {
                im9Var.U();
            }
            if (this.b.v2(false)) {
                W();
            } else {
                T();
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048611, this) != null) || !this.a.checkUpIsLogin() || !this.a.m2()) {
            return;
        }
        el5 E2 = this.a.E2();
        if (E2 != null && (E2.y() || E2.A())) {
            this.a.E2().w(false, null);
            return;
        }
        if (this.O != null) {
            H();
        }
        A();
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int g2 = yi.g(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070420);
            int g3 = yi.g(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d4);
            NavigationBar navigationBar = (NavigationBar) this.e.findViewById(R.id.view_navigation_bar);
            this.g = navigationBar;
            navigationBar.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0759));
            this.i = this.g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0518, (ViewGroup) null);
            this.j = linearLayout;
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0918ca);
            this.k = imageView;
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b38, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.g.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.j, new t(this));
            ImageView backImageView = this.g.getBackImageView();
            this.h = backImageView;
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams.height = g2;
                layoutParams.width = g2;
                layoutParams.leftMargin = g3;
                backImageView.setLayoutParams(layoutParams);
            }
            View view2 = this.i;
            if (view2 != null && (view2.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams2.width = g2;
                layoutParams2.height = g2;
                this.i.setLayoutParams(layoutParams2);
            }
            this.g.setIsClose(true);
            this.g.setIsCorner(true);
            this.g.isShowBottomLine(true);
            this.g.setBottomLineHeight(3);
            this.g.setStatusBarVisibility(8);
        }
    }

    public final void G(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getPageContext().getString(R.string.refresh_view_button_text), new b(this)));
            if (this.d == null) {
                Activity pageActivity = this.a.getPageContext().getPageActivity();
                this.d = NoDataViewFactory.a(pageActivity, this.n, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, yi.g(pageActivity, R.dimen.obfuscated_res_0x7f0703a6)), eVar, a2);
            }
            this.o.setVisibility(8);
            this.q.setVisibility(8);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
            this.d.setClickable(true);
            this.d.setTextOption(eVar);
            this.d.f(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.d.setVisibility(0);
        }
    }

    public void S(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, editorTools) == null) {
            this.O = editorTools;
            editorTools.setOnCancelClickListener(new i(this));
            this.O.setId(R.id.obfuscated_res_0x7f091a74);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.O.getParent() == null) {
                this.n.addView(this.O, layoutParams);
            }
            this.O.z(TbadkCoreApplication.getInst().getSkinType());
            this.O.setActionListener(24, new j(this));
            C();
            this.a.E2().g(new l(this));
        }
    }

    public void J(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            q05 layoutMode = this.a.getLayoutMode();
            if (i2 == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.e);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
            this.g.onChangeSkinType(this.a.getPageContext(), i2);
            PbModel pbModel = this.b;
            if (pbModel != null && (pbModel.k2() || this.b.j2())) {
                WebPManager.setPureDrawable(this.h, R.drawable.icon_topbar_return, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.h, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            this.c.d(this.a.getPageContext(), i2);
            this.a.getLayoutMode().k(this.p.c());
            this.p.e(i2);
            SkinManager.setViewTextColor(this.u, (int) R.color.CAM_X0110);
            this.u.setAlpha(0.95f);
            bh9 bh9Var = this.r;
            if (bh9Var != null) {
                bh9Var.b();
            }
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0203);
            this.x.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.w.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(yi.g(this.a, R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            d85.d(this.v).f(R.color.CAM_X0208);
        }
    }

    public void K(int i2, String str, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            L(i2, str, i3, z, null);
        }
    }

    public void L(int i2, String str, int i3, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), str2}) == null) {
            M(i2, str, i3, z, str2, false);
        }
    }

    public void M(int i2, String str, int i3, boolean z, String str2, boolean z2) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), str2, Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
            sparseArray.put(0, 3);
            if (i3 == 1002 && !z) {
                i4 = R.string.report_post_confirm;
            } else {
                i4 = R.string.del_all_post_confirm;
            }
            int i5 = R.string.confirm_title;
            if (i2 == 0) {
                if (i3 == 1002 && !z) {
                    i4 = R.string.report_thread_confirm;
                } else {
                    i5 = R.string.del_my_thread_confirm;
                    i4 = R.string.del_my_thread_confirm_subtitle;
                }
            }
            this.F = new p55(this.a);
            if (StringUtils.isNull(str2)) {
                this.F.setMessageId(i4);
            } else {
                this.F.setOnlyMessageShowCenter(false);
                this.F.setMessage(str2);
            }
            this.F.setYesButtonTag(sparseArray);
            this.F.setPositiveButton(R.string.obfuscated_res_0x7f0f0596, this.a);
            this.F.setNegativeButton(R.string.obfuscated_res_0x7f0f058b, new d(this));
            this.F.setCancelable(true);
            this.F.create(this.a.getPageContext());
            if (z2) {
                a0(sparseArray, i5, i4);
            } else if (z) {
                a0(sparseArray, i5, i4);
            } else if (Y()) {
                c66 c66Var = new c66(this.b.z1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.b.z1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.b.z1().n().has_forum_rule.intValue());
                c66Var.i(this.b.z1().k().getId(), this.b.z1().k().getName());
                c66Var.h(this.b.z1().k().getImage_url());
                c66Var.j(this.b.z1().k().getUser_level());
                d0(sparseArray, i2, c66Var, this.b.z1().U(), false);
            } else {
                g0(this.F, i2);
            }
        }
    }

    public void N(SparseArray<Object> sparseArray, boolean z) {
        int i2;
        w55 w55Var;
        w55 w55Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, sparseArray, z) == null) {
            a65 a65Var = new a65(this.a);
            a65Var.t(this.a.getString(R.string.obfuscated_res_0x7f0f0322));
            a65Var.q(new c(this, z));
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
                    w55Var2 = new w55(10, this.a.getString(R.string.obfuscated_res_0x7f0f0555), a65Var);
                } else {
                    w55Var2 = new w55(10, this.a.getString(R.string.obfuscated_res_0x7f0f0546), a65Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                w55Var2.d.setTag(sparseArray2);
                arrayList.add(w55Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                w55 w55Var3 = new w55(13, this.a.getString(R.string.multi_delete), a65Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                w55Var3.d.setTag(sparseArray3);
                arrayList.add(w55Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                w55 w55Var4 = new w55(11, this.a.getString(R.string.forbidden_person), a65Var);
                w55Var4.d.setTag(sparseArray4);
                arrayList.add(w55Var4);
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
                    w55Var = new w55(12, this.a.getString(R.string.un_mute), a65Var);
                } else {
                    w55Var = new w55(12, this.a.getString(R.string.obfuscated_res_0x7f0f0cf7), a65Var);
                }
                w55Var.d.setTag(sparseArray5);
                arrayList.add(w55Var);
            }
            fl9.e(arrayList);
            a65Var.m(arrayList, true);
            y55 y55Var = new y55(this.a.getPageContext(), a65Var);
            this.E = y55Var;
            y55Var.l();
        }
    }

    public final void P() {
        FoldCommentActivity foldCommentActivity;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (foldCommentActivity = this.a) != null && foldCommentActivity.E2() != null && this.O != null) {
            zk5.a().c(0);
            el5 E2 = this.a.E2();
            E2.N();
            E2.L();
            if (E2.v() != null) {
                WriteImagesInfo v = E2.v();
                if (E2.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                v.setMaxImagesAllowed(i2);
            }
            E2.e0(SendView.h);
            E2.h(SendView.h);
            hj5 o2 = this.O.o(23);
            hj5 o3 = this.O.o(2);
            hj5 o4 = this.O.o(5);
            if (o3 != null) {
                o3.display();
            }
            if (o4 != null) {
                o4.display();
            }
            if (o2 != null) {
                o2.hide();
            }
            this.O.invalidate();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.m = new BlankView(this.a.getPageContext().getPageActivity());
            FoldCommentActivity foldCommentActivity = this.a;
            if (foldCommentActivity != null && foldCommentActivity.getIntent() != null && this.a.getIntent().getIntExtra(FoldCommentActivityConfig.BLANK_VIEW_HEIGHT, 0) != 0) {
                this.G = this.a.getIntent().getIntExtra(FoldCommentActivityConfig.BLANK_VIEW_HEIGHT, 0);
            } else {
                this.G = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07037a);
            }
            this.f.addView(this.m, 0, new LinearLayout.LayoutParams(-1, this.G));
            this.m.setVisibility(0);
            this.m.setOnClickListener(new r(this));
            this.e.setBlankView(this.m);
        }
    }

    public void R(ze9 ze9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048593, this, ze9Var, z) != null) || ze9Var == null) {
            return;
        }
        this.s = ze9Var;
        this.t = z;
        if (ze9Var.b0()) {
            this.p.U();
        } else {
            this.p.g();
        }
        this.r.d(this.t);
        this.r.i(ze9Var);
        this.e.setEnableDragExit(true);
    }

    public void f0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048607, this, str, z) == null) {
            if (z) {
                G(NoDataViewFactory.e.d("", str));
            } else {
                G(NoDataViewFactory.e.d(str, this.a.getPageContext().getString(R.string.refresh_view_title_text)));
            }
            this.v.setVisibility(8);
        }
    }

    public final boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.a == null || this.b.z1().k().getDeletedReasonInfo() == null || 1 != this.b.z1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (!xi.isEmpty(this.L)) {
                return this.L;
            }
            if (this.a != null) {
                this.L = TbadkCoreApplication.getInst().getResources().getString(hj9.g());
            }
            return this.L;
        }
        return (String) invokeV.objValue;
    }

    public void Z(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048601, this, z) != null) || this.v == null) {
            return;
        }
        if (this.a.E2() != null && this.a.E2().z()) {
            z2 = true;
        } else {
            z2 = false;
        }
        V(z2);
        if (this.N) {
            b0(z);
        } else {
            B(z);
        }
    }

    public final void a0(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048602, this, sparseArray, i2, i3) != null) || this.a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0546, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f03ce, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a);
        tBAlertBuilder.w(i2);
        tBAlertBuilder.m(i3);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog z = tBAlertBuilder.z();
        aVar.c(new e(this, z, sparseArray));
        aVar2.c(new f(this, z));
    }

    public final void d0(SparseArray<Object> sparseArray, int i2, c66 c66Var, UserData userData, boolean z) {
        FoldCommentActivity foldCommentActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048605, this, new Object[]{sparseArray, Integer.valueOf(i2), c66Var, userData, Boolean.valueOf(z)}) != null) || (foldCommentActivity = this.a) == null) {
            return;
        }
        if (this.K == null) {
            this.K = new d66(foldCommentActivity.getPageContext(), null, c66Var, userData);
        }
        this.K.F(z);
        AntiData v2 = this.a.v2();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (v2 != null && v2.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = v2.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        s35 s35Var = new s35();
        s35Var.j(sparseArray2);
        this.K.H(new String[]{this.a.getString(R.string.delete_thread_reason_1), this.a.getString(R.string.delete_thread_reason_2), this.a.getString(R.string.delete_thread_reason_3), this.a.getString(R.string.delete_thread_reason_4), this.a.getString(R.string.delete_thread_reason_5)});
        this.K.G(s35Var);
        if (i2 != 1 && i2 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.K.J(str);
        this.K.I(new g(this, sparseArray));
    }

    public final void g0(p55 p55Var, int i2) {
        FoldCommentActivity foldCommentActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048608, this, p55Var, i2) == null) && (foldCommentActivity = this.a) != null && p55Var != null) {
            if (this.J == null) {
                this.J = new a66(foldCommentActivity.getPageContext(), null);
            }
            AntiData v2 = this.a.v2();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (v2 != null && v2.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = v2.getDelThreadInfoList();
                for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                    }
                }
            }
            s35 s35Var = new s35();
            s35Var.j(sparseArray);
            this.J.B(new String[]{this.a.getString(R.string.delete_thread_reason_1), this.a.getString(R.string.delete_thread_reason_2), this.a.getString(R.string.delete_thread_reason_3), this.a.getString(R.string.delete_thread_reason_4), this.a.getString(R.string.delete_thread_reason_5)});
            this.J.A(s35Var);
            if (i2 != 1 && i2 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.J.D(str);
            this.J.C(new h(this, p55Var));
        }
    }

    public void u(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.a.hideProgressBar();
            if (z && z2) {
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f147f));
            } else if (z2) {
                if (xi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e1f);
                }
                this.a.showToast(str);
            }
        }
    }
}
