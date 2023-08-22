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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FoldCommentActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
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
import com.baidu.tieba.c46;
import com.baidu.tieba.c55;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.BlankView;
import com.baidu.tieba.pb.pb.sub.SubPbView;
import com.baidu.tieba.s45;
import com.baidu.tieba.z36;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class ck9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public TbRichTextView.z B;
    public fj9 C;
    public View.OnLongClickListener D;
    public a55 E;
    public s45 F;
    public int G;
    public PbFragment.f3 H;
    public BlueCircleProgressDialog I;
    public z36 J;
    public c46 K;
    public String L;
    public PermissionJudgePolicy M;
    public boolean N;
    public EditorTools O;
    public fl9 P;
    public kn9 Q;
    public PbFakeFloorModel R;
    public BdListView.p S;

    /* renamed from: T  reason: collision with root package name */
    public CustomMessageListener f1097T;
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
    public hp9 p;
    public ProgressBar q;
    public ak9 r;
    public yh9 s;
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
        public final /* synthetic */ ck9 a;

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
                        TiebaStatic.log(new StatisticItem("c14445").param("tid", this.a.a.s.Q()).param("fname", this.a.a.s.m()).param("fid", this.a.a.s.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                    }
                }
            }
        }

        public t(ck9 ck9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ck9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0489));
                if (this.a.s != null) {
                    TiebaStatic.log(new StatisticItem("c14444").param("tid", this.a.s.Q()).param("fname", this.a.s.m()).param("fid", this.a.s.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                }
                TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f0b46, TBAlertConfig.OperateBtnStyle.MAIN);
                operateBtnConfig.setListener(new a(this));
                LinearLayout linearLayout = new LinearLayout(this.a.a);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                linearLayout.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X008), 0, 0);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView textView = new TextView(this.a.a);
                textView.setText(R.string.obfuscated_res_0x7f0f1838);
                textView.setTextSize(0, UtilHelper.getDimenPixelSize(R.dimen.T_X07));
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0304));
                textView.setOnClickListener(new b(this));
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
                ImageView imageView = new ImageView(this.a.a);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS));
                linearLayout.addView(imageView, new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.a.a, R.dimen.tbds36), BdUtilHelper.getDimens(this.a.a, R.dimen.tbds36)));
                ck9 ck9Var = this.a;
                ck9Var.l = new TBAlertBuilder(ck9Var.a).setTitle(R.string.obfuscated_res_0x7f0f0488).setDescStr(spannableString).setDescGravity(3).setCustomContentView(linearLayout).setDescLightStyle(true).setDescMovementMethod(LinkMovementMethod.getInstance()).setOperateBtn(operateBtnConfig).setCancelable(true).show();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ck9 a;

        public a(ck9 ck9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ck9Var;
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
        public final /* synthetic */ ck9 a;

        public b(ck9 ck9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ck9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.t2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements c55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ck9 b;

        public c(ck9 ck9Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ck9Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.c55.f
        public void J0(c55 c55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, c55Var, i, view2) == null) {
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
    public class d implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(ck9 ck9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var};
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

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ ck9 c;

        public e(ck9 ck9Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ck9Var;
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
                    BdUtilHelper.showToast(this.c.a, (int) R.string.obfuscated_res_0x7f0f0e29);
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

        public f(ck9 ck9Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var, alertDialog};
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
    public class g implements c46.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ ck9 b;

        public g(ck9 ck9Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ck9Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.c46.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.r2(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements z36.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s45 a;
        public final /* synthetic */ ck9 b;

        public h(ck9 ck9Var, s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var, s45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ck9Var;
            this.a = s45Var;
        }

        @Override // com.baidu.tieba.z36.h
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
        public final /* synthetic */ ck9 a;

        public i(ck9 ck9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ck9Var;
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
    public class j implements ai5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ck9 a;

        public j(ck9 ck9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ck9Var;
        }

        @Override // com.baidu.tieba.ai5
        public void E(zh5 zh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zh5Var) == null) {
                Object obj = zh5Var.c;
                if ((obj instanceof uc5) && EmotionGroupType.isSendAsPic(((uc5) obj).getType())) {
                    if (this.a.M == null) {
                        this.a.M = new PermissionJudgePolicy();
                    }
                    this.a.M.clearRequestPermissionList();
                    this.a.M.appendRequestPermission(this.a.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.M.startRequestPermission(this.a.a)) {
                        return;
                    }
                    this.a.a.E2().f((uc5) zh5Var.c);
                    this.a.a.E2().w(false, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ck9 a;

        public k(ck9 ck9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ck9Var;
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
        public final /* synthetic */ ck9 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public l(ck9 ck9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ck9Var;
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
                    ck9 ck9Var = this.a;
                    ck9Var.Q = new kn9(ck9Var.a.getPageContext(), this.a.e, layoutParams);
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
        public final /* synthetic */ ck9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(ck9 ck9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var, Integer.valueOf(i)};
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
            this.a = ck9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof qi9)) {
                qi9 qi9Var = (qi9) customResponsedMessage.getData();
                if (this.a.e != null) {
                    this.a.e.setSubPbViewData(qi9Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ck9 a;

        public n(ck9 ck9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ck9Var;
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
        public final /* synthetic */ ck9 a;

        public o(ck9 ck9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ck9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                return;
            }
            this.a.a.Y2();
            if (this.a.a != null && this.a.a.B2() != null && this.a.a.B2().s1() != null && this.a.a.B2().s1().O() != null && this.a.a.B2().s1().O().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.a.B2().N1()).param("fid", this.a.a.B2().s1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.a.B2().M1()).param("fid", this.a.a.B2().s1().l()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ck9 a;

        public p(ck9 ck9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ck9Var;
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
        public final /* synthetic */ ck9 a;

        public q(ck9 ck9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ck9Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(zfa zfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zfaVar) == null) {
                this.a.R.e0(zfaVar);
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
        public final /* synthetic */ ck9 a;

        public r(ck9 ck9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ck9Var;
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
        public final /* synthetic */ ck9 a;

        public s(ck9 ck9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ck9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.finish();
            }
        }
    }

    public ck9(FoldCommentActivity foldCommentActivity, View.OnClickListener onClickListener, TbRichTextView.z zVar, fj9 fj9Var, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {foldCommentActivity, onClickListener, zVar, fj9Var, onLongClickListener};
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
        this.f1097T = new m(this, 2921597);
        this.a = foldCommentActivity;
        this.b = foldCommentActivity.B2();
        this.z = onClickListener;
        this.B = zVar;
        this.C = fj9Var;
        this.D = onLongClickListener;
        SubPbView subPbView = (SubPbView) LayoutInflater.from(foldCommentActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0523, (ViewGroup) null);
        this.e = subPbView;
        this.f = (LinearLayout) subPbView.findViewById(R.id.navigation_bar_group);
        RelativeLayout relativeLayout = (RelativeLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090b94);
        this.v = relativeLayout;
        relativeLayout.setVisibility(8);
        this.u = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f090b95);
        this.c = (NoNetworkView) this.e.findViewById(R.id.view_no_network);
        F();
        this.n = (RelativeLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090b92);
        this.o = (BdTypeListView) this.e.findViewById(R.id.obfuscated_res_0x7f090b97);
        View view2 = new View(foldCommentActivity.getActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, 16));
        this.o.w(view2, 0);
        this.o.setOnSrollToBottomListener(this.S);
        this.e.setTopView(view2);
        this.e.setNavigationView(this.f);
        this.e.setListView(this.o);
        this.e.setContentView(this.n);
        hp9 hp9Var = new hp9(foldCommentActivity.getPageContext());
        this.p = hp9Var;
        hp9Var.B();
        this.p.G(new n(this));
        this.o.setNextPage(this.p);
        this.q = (ProgressBar) this.e.findViewById(R.id.obfuscated_res_0x7f091d87);
        this.y = this.e.findViewById(R.id.obfuscated_res_0x7f092968);
        LinearLayout linearLayout = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090b93);
        this.w = linearLayout;
        linearLayout.setOnClickListener(new o(this));
        HeadImageView headImageView = (HeadImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090b96);
        this.x = headImageView;
        headImageView.setVisibility(0);
        this.x.setIsRound(true);
        this.x.setBorderWidth(BdUtilHelper.getDimens(this.a, R.dimen.L_X01));
        this.x.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.x.setDefaultBgResource(0);
        this.x.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.x.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        J(TbadkCoreApplication.getInst().getSkinType());
        E();
        PbFakeFloorModel pbFakeFloorModel = new PbFakeFloorModel(this.a.getPageContext());
        this.R = pbFakeFloorModel;
        pbFakeFloorModel.g0(this.b.W(), this.b.S(), this.b.T(), this.b.R(), this.b.X());
        fl9 fl9Var = new fl9(this.a.getPageContext(), this.R, this.n);
        this.P = fl9Var;
        fl9Var.p(new p(this));
        this.P.s(this.a.P);
        this.R.i0(new q(this));
        this.a.registerListener(this.f1097T);
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

    public void U(PbFragment.f3 f3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, f3Var) == null) {
            this.H = f3Var;
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
        ak9 ak9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048609, this, z) == null) && (ak9Var = this.r) != null) {
            ak9Var.f(z);
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
            kn9 kn9Var = this.Q;
            if (kn9Var != null) {
                kn9Var.m();
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
                this.I = new BlueCircleProgressDialog(this.a.getPageContext());
            }
            this.I.setDialogVisiable(true);
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

    public fl9 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.P;
        }
        return (fl9) invokeV.objValue;
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
            ak9 ak9Var = new ak9(this.a, this.o);
            this.r = ak9Var;
            ak9Var.j(this.a.R0());
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
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (pbModel = this.b) != null && pbModel.s1() != null && this.b.s1().y() != null && BdUtilHelper.isNetOk()) {
            if (this.b.s1().y().b() == 0) {
                T();
                return;
            }
            hp9 hp9Var = this.p;
            if (hp9Var != null) {
                hp9Var.U();
            }
            if (this.b.p2(false)) {
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
        ek5 E2 = this.a.E2();
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
            int dimens = BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070420);
            int dimens2 = BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d4);
            NavigationBar navigationBar = (NavigationBar) this.e.findViewById(R.id.view_navigation_bar);
            this.g = navigationBar;
            navigationBar.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0762));
            this.i = this.g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0524, (ViewGroup) null);
            this.j = linearLayout;
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091902);
            this.k = imageView;
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b49, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.g.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.j, new t(this));
            ImageView backImageView = this.g.getBackImageView();
            this.h = backImageView;
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams.height = dimens;
                layoutParams.width = dimens;
                layoutParams.leftMargin = dimens2;
                backImageView.setLayoutParams(layoutParams);
            }
            View view2 = this.i;
            if (view2 != null && (view2.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams2.width = dimens;
                layoutParams2.height = dimens;
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
                this.d = NoDataViewFactory.a(pageActivity, this.n, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, BdUtilHelper.getDimens(pageActivity, R.dimen.obfuscated_res_0x7f0703a6)), eVar, a2);
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
            this.O.setId(R.id.obfuscated_res_0x7f091ab1);
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
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (i2 == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(this.e);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
            this.g.onChangeSkinType(this.a.getPageContext(), i2);
            PbModel pbModel = this.b;
            if (pbModel != null && (pbModel.e2() || this.b.d2())) {
                WebPManager.setPureDrawable(this.h, R.drawable.icon_topbar_return, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.h, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            this.c.onChangeSkinType(this.a.getPageContext(), i2);
            this.a.getLayoutMode().onModeChanged(this.p.c());
            this.p.e(i2);
            SkinManager.setViewTextColor(this.u, (int) R.color.CAM_X0110);
            this.u.setAlpha(0.95f);
            ak9 ak9Var = this.r;
            if (ak9Var != null) {
                ak9Var.b();
            }
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0203);
            this.x.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.w.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(this.a, R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            EMManager.from(this.v).setBackGroundColor(R.color.CAM_X0208);
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
            this.F = new s45(this.a);
            if (StringUtils.isNull(str2)) {
                this.F.setMessageId(i4);
            } else {
                this.F.setOnlyMessageShowCenter(false);
                this.F.setMessage(str2);
            }
            this.F.setYesButtonTag(sparseArray);
            this.F.setPositiveButton(R.string.obfuscated_res_0x7f0f0598, this.a);
            this.F.setNegativeButton(R.string.obfuscated_res_0x7f0f058d, new d(this));
            this.F.setCancelable(true);
            this.F.create(this.a.getPageContext());
            if (z2) {
                a0(sparseArray, i5, i4);
            } else if (z) {
                a0(sparseArray, i5, i4);
            } else if (Y()) {
                b46 b46Var = new b46(this.b.s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.b.s1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.b.s1().n().has_forum_rule.intValue());
                b46Var.i(this.b.s1().k().getId(), this.b.s1().k().getName());
                b46Var.h(this.b.s1().k().getImage_url());
                b46Var.j(this.b.s1().k().getUser_level());
                d0(sparseArray, i2, b46Var, this.b.s1().V(), false);
            } else {
                g0(this.F, i2);
            }
        }
    }

    public void N(SparseArray<Object> sparseArray, boolean z) {
        int i2;
        y45 y45Var;
        y45 y45Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, sparseArray, z) == null) {
            c55 c55Var = new c55(this.a);
            c55Var.t(this.a.getString(R.string.obfuscated_res_0x7f0f0323));
            c55Var.q(new c(this, z));
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
                    y45Var2 = new y45(10, this.a.getString(R.string.obfuscated_res_0x7f0f0557), c55Var);
                } else {
                    y45Var2 = new y45(10, this.a.getString(R.string.obfuscated_res_0x7f0f0548), c55Var);
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
                y45 y45Var3 = new y45(13, this.a.getString(R.string.multi_delete), c55Var);
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
                y45 y45Var4 = new y45(11, this.a.getString(R.string.forbidden_person), c55Var);
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
                if (z) {
                    y45Var = new y45(12, this.a.getString(R.string.un_mute), c55Var);
                } else {
                    y45Var = new y45(12, this.a.getString(R.string.obfuscated_res_0x7f0f0d01), c55Var);
                }
                y45Var.d.setTag(sparseArray5);
                arrayList.add(y45Var);
            }
            eo9.e(arrayList);
            c55Var.m(arrayList, true);
            a55 a55Var = new a55(this.a.getPageContext(), c55Var);
            this.E = a55Var;
            a55Var.l();
        }
    }

    public final void P() {
        FoldCommentActivity foldCommentActivity;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (foldCommentActivity = this.a) != null && foldCommentActivity.E2() != null && this.O != null) {
            zj5.a().c(0);
            ek5 E2 = this.a.E2();
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
            hi5 o2 = this.O.o(23);
            hi5 o3 = this.O.o(2);
            hi5 o4 = this.O.o(5);
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
                this.G = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07037a);
            }
            this.f.addView(this.m, 0, new LinearLayout.LayoutParams(-1, this.G));
            this.m.setVisibility(0);
            this.m.setOnClickListener(new r(this));
            this.e.setBlankView(this.m);
        }
    }

    public void R(yh9 yh9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048593, this, yh9Var, z) != null) || yh9Var == null) {
            return;
        }
        this.s = yh9Var;
        this.t = z;
        if (yh9Var.c0()) {
            this.p.U();
        } else {
            this.p.g();
        }
        this.r.d(this.t);
        this.r.i(yh9Var);
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
            if (this.a == null || this.b.s1().k().getDeletedReasonInfo() == null || 1 != this.b.s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
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
            if (!di.isEmpty(this.L)) {
                return this.L;
            }
            if (this.a != null) {
                this.L = TbadkCoreApplication.getInst().getResources().getString(gm9.g());
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
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f0548, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03cf, TBAlertConfig.OperateBtnStyle.SECONDARY);
        AlertDialog show = new TBAlertBuilder(this.a).setTitle(i2).setDesc(i3).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new e(this, show, sparseArray));
        operateBtnConfig2.setListener(new f(this, show));
    }

    public final void d0(SparseArray<Object> sparseArray, int i2, b46 b46Var, UserData userData, boolean z) {
        FoldCommentActivity foldCommentActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048605, this, new Object[]{sparseArray, Integer.valueOf(i2), b46Var, userData, Boolean.valueOf(z)}) != null) || (foldCommentActivity = this.a) == null) {
            return;
        }
        if (this.K == null) {
            this.K = new c46(foldCommentActivity.getPageContext(), null, b46Var, userData);
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
        NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
        negativeFeedBackData.setFeedBackReasonMap(sparseArray2);
        this.K.H(new String[]{this.a.getString(R.string.delete_thread_reason_1), this.a.getString(R.string.delete_thread_reason_2), this.a.getString(R.string.delete_thread_reason_3), this.a.getString(R.string.delete_thread_reason_4), this.a.getString(R.string.delete_thread_reason_5)});
        this.K.G(negativeFeedBackData);
        if (i2 != 1 && i2 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.K.J(str);
        this.K.I(new g(this, sparseArray));
    }

    public final void g0(s45 s45Var, int i2) {
        FoldCommentActivity foldCommentActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048608, this, s45Var, i2) == null) && (foldCommentActivity = this.a) != null && s45Var != null) {
            if (this.J == null) {
                this.J = new z36(foldCommentActivity.getPageContext(), null);
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
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray);
            this.J.B(new String[]{this.a.getString(R.string.delete_thread_reason_1), this.a.getString(R.string.delete_thread_reason_2), this.a.getString(R.string.delete_thread_reason_3), this.a.getString(R.string.delete_thread_reason_4), this.a.getString(R.string.delete_thread_reason_5)});
            this.J.A(negativeFeedBackData);
            if (i2 != 1 && i2 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.J.D(str);
            this.J.C(new h(this, s45Var));
        }
    }

    public void u(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.a.hideProgressBar();
            if (z && z2) {
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f1491));
            } else if (z2) {
                if (di.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e29);
                }
                this.a.showToast(str);
            }
        }
    }
}
