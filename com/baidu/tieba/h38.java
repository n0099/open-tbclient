package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.ao5;
import com.baidu.tieba.do5;
import com.baidu.tieba.i85;
import com.baidu.tieba.nu4;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pu4;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.yu4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.ForumToolPerm;
/* loaded from: classes4.dex */
public class h38 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Q = 0;
    public static int R = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public on A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public PostData G;
    public String H;
    public Runnable I;
    public kx4 J;
    public an8 K;
    public boolean L;
    public final View.OnLongClickListener M;
    public yu4.e N;
    public boolean O;
    public final pu4.c P;
    public AbsVideoPbFragment a;
    public wu4 b;
    public yu4 c;
    public wu4 d;
    public nu4 e;
    public Dialog f;
    public Dialog g;
    public ru4 h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public wu4 q;
    public sx4 r;
    public pu4 s;
    public AlertDialog t;
    public uy7 u;
    public ao5 v;
    public do5 w;
    public p18 x;
    public PbFragment.h3 y;
    public sz7 z;

    /* loaded from: classes4.dex */
    public class a implements pu4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h38 a;

        public a(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h38Var;
        }

        @Override // com.baidu.tieba.pu4.c
        public void a(pu4 pu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, pu4Var, i, view2) == null) {
                if (pu4Var != null) {
                    pu4Var.e();
                }
                if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.C == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                    } else {
                        i85.a aVar = new i85.a();
                        aVar.a = this.a.B;
                        String str = "";
                        if (this.a.C.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.a.C.memeInfo.pck_id;
                        }
                        aVar.b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (this.a.F == null) {
                        this.a.F = new PermissionJudgePolicy();
                    }
                    this.a.F.clearRequestPermissionList();
                    this.a.F.appendRequestPermission(this.a.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.F.startRequestPermission(this.a.a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.a.z == null) {
                        h38 h38Var = this.a;
                        h38Var.z = new sz7(h38Var.a.getPageContext());
                    }
                    this.a.z.b(this.a.B, this.a.A.n());
                }
                this.a.A = null;
                this.a.B = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a0 implements yu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ h38 e;

        public a0(h38 h38Var, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = h38Var;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tieba.yu4.e
        public void n0(yu4 yu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yu4Var, i, view2) == null) {
                if (this.e.b != null) {
                    this.e.b.dismiss();
                }
                if (i == 0) {
                    this.e.g0(((Integer) this.a.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f09203f), ((Integer) this.a.get(R.id.obfuscated_res_0x7f09205d)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f092040)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f092096);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f092098);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f092097);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.D);
                    userMuteAddAndDelCustomMessage.setTag(this.e.D);
                    this.e.M0(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f092094));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h38 a;

        public b(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h38Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                this.a.a.w3(nu4Var, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h38 a;

        public b0(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h38Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                TiebaStatic.log("c10025");
                nu4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c0 implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ h38 c;

        public d(h38 h38Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h38Var;
            this.a = alertDialog;
            this.b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                androidx.appcompat.app.AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    ej.M(this.c.a.P(), R.string.obfuscated_res_0x7f0f0c59);
                } else {
                    this.c.a.v3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public e(h38 h38Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var, alertDialog};
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
            androidx.appcompat.app.AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ h38 c;

        public f(h38 h38Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h38Var;
            this.a = alertDialog;
            this.b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                androidx.appcompat.app.AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    ej.M(this.c.a.P(), R.string.obfuscated_res_0x7f0f0c59);
                } else {
                    this.c.a.v3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public g(h38 h38Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var, alertDialog};
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
            androidx.appcompat.app.AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements ao5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu4 a;
        public final /* synthetic */ h38 b;

        public h(h38 h38Var, nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var, nu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h38Var;
            this.a = nu4Var;
        }

        @Override // com.baidu.tieba.ao5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.w3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements do5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ h38 b;

        public i(h38 h38Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h38Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.do5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.v3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements yu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ h38 b;

        public j(h38 h38Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h38Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.yu4.e
        public void n0(yu4 yu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yu4Var, i, view2) == null) {
                this.b.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f09203f), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09205d)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092040)).booleanValue());
                        return;
                    case 11:
                        if (this.b.y != null) {
                            this.b.y.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f09205d), sparseArray.get(R.id.obfuscated_res_0x7f09204a), sparseArray.get(R.id.obfuscated_res_0x7f09204d), sparseArray.get(R.id.obfuscated_res_0x7f09204b), sparseArray.get(R.id.obfuscated_res_0x7f09204c)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.T(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f092095), sparseArray);
                        return;
                    case 13:
                        AbsVideoPbFragment absVideoPbFragment = this.b.a;
                        if (absVideoPbFragment == null || absVideoPbFragment.I3() == null) {
                            return;
                        }
                        this.b.a.I3().l2(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h38 a;

        public k(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h38Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.t == null) {
                return;
            }
            ih.a(this.a.t, this.a.a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes4.dex */
    public class l implements pu4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h38 a;

        public l(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h38Var;
        }

        @Override // com.baidu.tieba.pu4.c
        public void a(pu4 pu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, pu4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    h38 h38Var = this.a;
                    h38Var.H = h38Var.H.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new px7(this.a.a.K().m2(), this.a.H, "1").start();
                    pu4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    h38 h38Var2 = this.a;
                    h38Var2.H = h38Var2.H.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new px7(this.a.a.K().m2(), this.a.H, "2").start();
                    pu4Var.e();
                } else if (i == 2) {
                    h38 h38Var3 = this.a;
                    h38Var3.H = h38Var3.H.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    pu4Var.e();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements yu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wu4 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ h38 c;

        public m(h38 h38Var, wu4 wu4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var, wu4Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h38Var;
            this.a = wu4Var;
            this.b = view2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.c.a.K().j2() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.yu4.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void n0(yu4 yu4Var, int i, View view2) {
            boolean L3;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, yu4Var, i, view2) != null) {
                return;
            }
            this.a.dismiss();
            int i2 = 3;
            if (this.c.a.K().j2() != 1 || i != 1) {
                if (this.c.a.K().j2() == 2 && i == 0) {
                    i2 = 1;
                } else if (this.c.a.K().j2() == 3 && i != 2) {
                    i2 = 2;
                } else if (i == 2) {
                }
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f09187d ? 1 : 0).param("obj_type", i2));
                if (this.c.a.K().S1().f != null && this.c.a.K().S1().f.size() > i) {
                    i = this.c.a.K().S1().f.get(i).sort_type.intValue();
                }
                L3 = this.c.a.K().L3(i);
                this.b.setTag(Integer.valueOf(this.c.a.K().i2()));
                if (L3) {
                    return;
                }
                this.c.a.h5(true);
                return;
            }
            i2 = 0;
            TiebaStatic.log("c12097");
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f09187d ? 1 : 0).param("obj_type", i2));
            if (this.c.a.K().S1().f != null) {
                i = this.c.a.K().S1().f.get(i).sort_type.intValue();
            }
            L3 = this.c.a.K().L3(i);
            this.b.setTag(Integer.valueOf(this.c.a.K().i2()));
            if (L3) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        public n(h38 h38Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = metaData;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                nu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ h38 b;

        public o(h38 h38Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h38Var;
            this.a = metaData;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                nu4Var.dismiss();
                if (this.b.a.F3() != null) {
                    this.b.a.F3().l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.a.getPageContext().getUniqueId(), this.b.a.K().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ h38 b;

        public q(h38 h38Var, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h38Var;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                this.b.C0();
                MessageManager.getInstance().sendMessage(this.a);
                nu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements yu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4.c a;
        public final /* synthetic */ h38 b;

        public s(h38 h38Var, pu4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h38Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.yu4.e
        public void n0(yu4 yu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yu4Var, i, view2) == null) {
                this.b.d.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h38 a;

        public t(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h38Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.n = (String) compoundButton.getTag();
                if (this.a.m != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.m) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.n != null && !str.equals(this.a.n)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h38 a;

        public u(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h38Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) ? this.a.E(view2) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h38 a;

        public v(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h38Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.g instanceof Dialog)) {
                ih.b(this.a.g, this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements PbFragment.h3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h38 a;

        public w(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h38Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.h3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.K().S1().l().getId(), this.a.a.K().S1().l().getName(), this.a.a.K().S1().O().getId(), String.valueOf(this.a.a.K().S1().V().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x implements yu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h38 a;

        public x(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h38Var;
        }

        @Override // com.baidu.tieba.yu4.e
        public void n0(yu4 yu4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yu4Var, i, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.N0(i);
                if (i == -4) {
                    View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917ee);
                    this.a.n0(view3);
                    if (view3 != null) {
                        view3.performClick();
                    }
                } else if (i == -3) {
                    View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917ed);
                    this.a.n0(view4);
                    if (view4 != null) {
                        view4.performClick();
                    }
                } else if (i == -2) {
                    View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917f0);
                    AgreeView agreeView = (AgreeView) view5;
                    this.a.n0(view5);
                    if (agreeView == null || agreeView.getImgDisagree() == null) {
                        return;
                    }
                    agreeView.getImgDisagree().performClick();
                } else if (i == -1) {
                    View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917f0);
                    this.a.n0(view6);
                    AgreeView agreeView2 = (AgreeView) view6;
                    if (agreeView2 == null || agreeView2.getImgAgree() == null) {
                        return;
                    }
                    agreeView2.getImgAgree().performClick();
                } else if (i != 13) {
                    int i2 = 4;
                    switch (i) {
                        case 1:
                            if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                                return;
                            }
                            if (this.a.C == null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                            } else {
                                i85.a aVar = new i85.a();
                                aVar.a = this.a.B;
                                String str = "";
                                if (this.a.C.memeInfo.pck_id.intValue() >= 0) {
                                    str = "" + this.a.C.memeInfo.pck_id;
                                }
                                aVar.b = str;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                            }
                            this.a.A = null;
                            this.a.B = null;
                            return;
                        case 2:
                            if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                                return;
                            }
                            if (this.a.F == null) {
                                this.a.F = new PermissionJudgePolicy();
                            }
                            this.a.F.clearRequestPermissionList();
                            this.a.F.appendRequestPermission(this.a.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (this.a.F.startRequestPermission(this.a.a.getPageContext().getPageActivity())) {
                                return;
                            }
                            if (this.a.z == null) {
                                h38 h38Var = this.a;
                                h38Var.z = new sz7(h38Var.a.getPageContext());
                            }
                            this.a.z.b(this.a.B, this.a.A.n());
                            this.a.A = null;
                            this.a.B = null;
                            return;
                        case 3:
                            PostData postData = this.a.G;
                            if (postData != null) {
                                postData.C0();
                                this.a.G = null;
                                return;
                            }
                            return;
                        case 4:
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                            if (this.a.a.checkUpIsLogin()) {
                                this.a.d0(view2);
                                if (this.a.a.K().S1().O() == null || this.a.a.K().S1().O().getAuthor() == null || this.a.a.K().S1().O().getAuthor().getUserId() == null || this.a.a.S3() == null) {
                                    return;
                                }
                                h38 h38Var2 = this.a;
                                int S = h38Var2.S(h38Var2.a.K().S1());
                                ThreadData O = this.a.a.K().S1().O();
                                if (O.isBJHArticleThreadType()) {
                                    i2 = 2;
                                } else if (O.isBJHVideoThreadType()) {
                                    i2 = 3;
                                } else if (!O.isBJHNormalThreadType()) {
                                    i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                                }
                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.K().m2()).param("obj_locate", 2).param("obj_id", this.a.a.K().S1().O().getAuthor().getUserId()).param("obj_type", !this.a.a.S3().e()).param("obj_source", S).param("obj_param1", i2));
                                return;
                            }
                            return;
                        case 5:
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                return;
                            }
                            Object tag = view2.getTag();
                            if (tag instanceof String) {
                                TiebaStatic.log(new StatisticItem("c13079"));
                                this.a.U((String) tag);
                                return;
                            } else if (tag instanceof SparseArray) {
                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                if ((sparseArray2.get(R.id.obfuscated_res_0x7f092099) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f092099)).booleanValue()) {
                                    sparseArray2.put(R.id.obfuscated_res_0x7f092050, 0);
                                    sparseArray2.put(R.id.obfuscated_res_0x7f092039, 2);
                                    this.a.B(sparseArray2);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        case 6:
                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                            if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f092041) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f09203f) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f09205d) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f092040) instanceof Boolean)) {
                                boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f092040)).booleanValue();
                                int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f09205d)).intValue();
                                boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f092051)).booleanValue();
                                AbsVideoPbFragment absVideoPbFragment = this.a.a;
                                if (absVideoPbFragment == null || absVideoPbFragment.P() == null) {
                                    return;
                                }
                                boolean F = this.a.a.P().F(TbadkCoreApplication.getCurrentAccount());
                                if (F) {
                                    if (!booleanValue2) {
                                        this.a.u0(sparseArray3, intValue, booleanValue);
                                        return;
                                    } else {
                                        this.a.i0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f09203f), intValue, booleanValue, null, F);
                                        return;
                                    }
                                } else if (booleanValue && !booleanValue2) {
                                    this.a.u0(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.g0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f09203f), intValue, booleanValue);
                                    return;
                                }
                            }
                            return;
                        case 7:
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                return;
                            }
                            SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                            if (sparseArray4 == null) {
                                return;
                            }
                            boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092085)).booleanValue();
                            boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092083)).booleanValue();
                            boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092099)).booleanValue();
                            boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f092055) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092055)).booleanValue() : false;
                            if (!booleanValue3) {
                                if (booleanValue4) {
                                    this.a.g0(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f09203f), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f09205d)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092040)).booleanValue());
                                    return;
                                }
                                return;
                            } else if (booleanValue5) {
                                sparseArray4.put(R.id.obfuscated_res_0x7f092050, 1);
                                sparseArray4.put(R.id.obfuscated_res_0x7f092039, 2);
                                this.a.B(sparseArray4);
                                return;
                            } else {
                                if (booleanValue6) {
                                    sparseArray4.put(R.id.obfuscated_res_0x7f092039, 2);
                                }
                                sparseArray4.put(R.id.obfuscated_res_0x7f09205e, Boolean.TRUE);
                                this.a.l0(view2);
                                return;
                            }
                        case 8:
                            if (ViewHelper.checkUpIsLogin(this.a.a.getContext()) && (sparseArray = (SparseArray) view2.getTag()) != null) {
                                PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203d);
                                if (postData2.q() == null) {
                                    return;
                                }
                                oc5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                if (findPageExtraByView != null) {
                                    postData2.q().objSource = findPageExtraByView.a();
                                }
                                this.a.C(postData2.q());
                                return;
                            }
                            return;
                        case 9:
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.a;
                            if (absVideoPbFragment2 == null || absVideoPbFragment2.K() == null || this.a.a.K().S1() == null || !ViewHelper.checkUpIsLogin(this.a.a.getContext()) || this.a.a.P() == null) {
                                return;
                            }
                            this.a.a.P().u1(hu8.c(view2));
                            return;
                        default:
                            return;
                    }
                } else {
                    AbsVideoPbFragment absVideoPbFragment3 = this.a.a;
                    if (absVideoPbFragment3 == null || absVideoPbFragment3.I3() == null) {
                        return;
                    }
                    this.a.a.I3().l2(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ h38 d;

        public y(h38 h38Var, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = h38Var;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                if (nu4Var != null) {
                    nu4Var.dismiss();
                }
                this.d.a.x3(((Integer) this.a.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f09203f), this.b, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z(h38 h38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947772892, "Lcom/baidu/tieba/h38;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947772892, "Lcom/baidu/tieba/h38;");
        }
    }

    public h38(AbsVideoPbFragment absVideoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {absVideoPbFragment};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.G = null;
        this.L = UbsABTestHelper.showTrisectionAndFeedback();
        this.M = new u(this);
        this.N = new x(this);
        this.P = new a(this);
        this.a = absVideoPbFragment;
        this.D = absVideoPbFragment.getUniqueId();
        p18 p18Var = new p18(this.a.getContext());
        this.x = p18Var;
        p18Var.b(this.a.getUniqueId());
        this.y = new w(this);
    }

    public final boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.K() == null || !this.a.K().k2()) {
                return false;
            }
            return this.a.K().Q1() == null || this.a.K().Q1().c() != 0;
        }
        return invokeV.booleanValue;
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            C0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = dh.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = dh.g((String) sparseArray.get(R.id.obfuscated_res_0x7f092095), 0L);
            BdUniqueId bdUniqueId = this.D;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.E = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public void B0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) == null) || metaData == null) {
            return;
        }
        nu4 nu4Var = new nu4(this.a.getActivity());
        nu4Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0aac));
        nu4Var.setTitleShowCenter(true);
        nu4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0aad));
        nu4Var.setMessageShowCenter(true);
        nu4Var.setCancelable(false);
        nu4Var.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0aae), new n(this, metaData));
        nu4Var.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0aaf), new o(this, metaData));
        nu4Var.create(this.a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void C(AgreeData agreeData) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.J == null) {
            this.J = new kx4();
        }
        if (this.K == null) {
            an8 an8Var = new an8();
            this.K = an8Var;
            an8Var.a = this.a.getUniqueId();
        }
        er4 er4Var = new er4();
        er4Var.b = 5;
        er4Var.h = 8;
        er4Var.g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.K() != null) {
            er4Var.f = this.a.K().R1();
        }
        er4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                er4Var.i = 0;
                this.J.c(agreeData, i2, this.a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.a;
                if (absVideoPbFragment != null || absVideoPbFragment.K() == null || this.a.K().S1() == null) {
                    return;
                }
                this.J.b(this.a.P(), er4Var, agreeData, this.a.K().S1().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            er4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            er4Var.i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        absVideoPbFragment = this.a;
        if (absVideoPbFragment != null) {
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.r == null) {
                this.r = new sx4(this.a.getPageContext());
            }
            this.r.h(true);
        }
    }

    public final CustomBlueCheckRadioButton D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, ej.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.p);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public final void D0(SparseArray<Object> sparseArray, int i2, co5 co5Var, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{sparseArray, Integer.valueOf(i2), co5Var, userData, Boolean.valueOf(z2)}) == null) || (absVideoPbFragment = this.a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new do5(this.a.getPageContext(), this.a.getView(), co5Var, userData);
        }
        this.w.C(z2);
        AntiData L = L();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (L != null && L.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = L.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        vs4 vs4Var = new vs4();
        vs4Var.j(sparseArray2);
        this.w.E(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04c4), this.a.getString(R.string.obfuscated_res_0x7f0f04c5), this.a.getString(R.string.obfuscated_res_0x7f0f04c6), this.a.getString(R.string.obfuscated_res_0x7f0f04c7), this.a.getString(R.string.obfuscated_res_0x7f0f04c8)});
        this.w.D(vs4Var);
        this.w.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.w.F(new i(this, sparseArray));
    }

    public final boolean E(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        List<uu4> c2;
        uu4 uu4Var;
        uu4 uu4Var2;
        uu4 uu4Var3;
        uu4 uu4Var4;
        uu4 uu4Var5;
        uu4 uu4Var6;
        on onVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || !absVideoPbFragment.isAdded()) {
                return true;
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (Y(view2)) {
                    if (view2 instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view2;
                        this.A = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.B = url;
                        if (this.A == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view2.getTag(R.id.obfuscated_res_0x7f092079) != null && (view2.getTag(R.id.obfuscated_res_0x7f092079) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092079);
                        } else {
                            this.C = null;
                        }
                    } else if (view2 instanceof GifView) {
                        GifView gifView = (GifView) view2;
                        if (gifView.getBdImage() == null) {
                            return true;
                        }
                        this.A = gifView.getBdImage();
                        if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                            this.B = gifView.getBdImage().q();
                        }
                        if (view2.getTag(R.id.obfuscated_res_0x7f092079) != null && (view2.getTag(R.id.obfuscated_res_0x7f092079) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092079);
                        } else {
                            this.C = null;
                        }
                    } else if (view2 instanceof TbMemeImageView) {
                        TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                        if (tbMemeImageView.getBdImage() != null) {
                            this.A = tbMemeImageView.getBdImage();
                            if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                this.B = tbMemeImageView.getBdImage().q();
                            }
                            if (view2.getTag(R.id.obfuscated_res_0x7f092079) != null && (view2.getTag(R.id.obfuscated_res_0x7f092079) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092079);
                            } else {
                                this.C = null;
                            }
                        }
                    }
                    if (view2.getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                        }
                    } else if (view2.getParent().getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view2.getParent().getParent()).getTag();
                        } catch (ClassCastException e4) {
                            e4.printStackTrace();
                        }
                    } else {
                        G0(this.P, this.A.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203d);
            this.G = postData;
            if (postData == null || this.a.S3() == null) {
                return true;
            }
            boolean z5 = this.a.S3().e() && this.G.L() != null && this.G.L().equals(this.a.K().N1());
            boolean z6 = this.a.K().S1() != null && this.a.K().S1().i0();
            if (this.c == null) {
                yu4 yu4Var = new yu4(this.a.getContext());
                this.c = yu4Var;
                yu4Var.n(this.N);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 == null || sparseArray == null) {
                return true;
            }
            boolean z7 = Y(view2) && !z6;
            boolean z8 = (!Y(view2) || (onVar = this.A) == null || onVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092056) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092056)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092040) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092040)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092099) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092099)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f092085) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092085)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f092099) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092099)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f092083) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092083)).booleanValue() : false;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f09204d) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f09204d) : null;
            boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f092055) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092055)).booleanValue() : false;
            boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f09205e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09205e)).booleanValue() : false;
            if (z7) {
                z4 = booleanValue7;
                z3 = booleanValue6;
                z2 = booleanValue5;
                arrayList.add(new uu4(1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10af), this.c));
            } else {
                z2 = booleanValue5;
                z3 = booleanValue6;
                z4 = booleanValue7;
            }
            if (z8) {
                arrayList.add(new uu4(2, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10b0), this.c));
            }
            if (!z7 && !z8) {
                uu4 uu4Var7 = new uu4(3, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0452), this.c);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f09203d, this.G);
                uu4Var7.d.setTag(sparseArray3);
                arrayList.add(uu4Var7);
            }
            if (!booleanValue && !z6) {
                if (z5) {
                    uu4Var6 = new uu4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ff2), this.c);
                } else {
                    uu4Var6 = new uu4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0aaa), this.c);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f09203d, this.G);
                sparseArray4.put(R.id.obfuscated_res_0x7f092056, Boolean.FALSE);
                uu4Var6.d.setTag(sparseArray4);
                arrayList.add(uu4Var6);
            }
            if (TbadkCoreApplication.isLogin() && !this.L) {
                if (!X() && !booleanValue4 && booleanValue3) {
                    uu4 uu4Var8 = new uu4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b4d), this.c);
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f092099, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f092054, sparseArray.get(R.id.obfuscated_res_0x7f092054));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                    sparseArray5.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                    sparseArray5.put(R.id.obfuscated_res_0x7f09205d, sparseArray.get(R.id.obfuscated_res_0x7f09205d));
                    uu4Var8.d.setTag(sparseArray5);
                    arrayList.add(uu4Var8);
                } else {
                    if ((b0(booleanValue2) && TbadkCoreApplication.isLogin()) && !z6) {
                        uu4 uu4Var9 = new uu4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1017), this.c);
                        uu4Var9.d.setTag(str);
                        arrayList.add(uu4Var9);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray6 = new SparseArray();
                    sparseArray6.put(R.id.obfuscated_res_0x7f092085, Boolean.TRUE);
                    sparseArray6.put(R.id.obfuscated_res_0x7f09205d, sparseArray.get(R.id.obfuscated_res_0x7f09205d));
                    sparseArray6.put(R.id.obfuscated_res_0x7f09204a, sparseArray.get(R.id.obfuscated_res_0x7f09204a));
                    sparseArray6.put(R.id.obfuscated_res_0x7f09204b, sparseArray.get(R.id.obfuscated_res_0x7f09204b));
                    sparseArray6.put(R.id.obfuscated_res_0x7f09204c, sparseArray.get(R.id.obfuscated_res_0x7f09204c));
                    sparseArray6.put(R.id.obfuscated_res_0x7f09204d, str);
                    if (!X() && z2) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f092099, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f092054, sparseArray.get(R.id.obfuscated_res_0x7f092054));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f092099, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f092083, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(booleanValue2));
                        sparseArray6.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
                        if (z4) {
                            uu4Var5 = new uu4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b0), this.c);
                            uu4Var5.d.setTag(sparseArray6);
                            uu4Var2 = new uu4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02e8), this.c);
                            uu4Var2.d.setTag(sparseArray6);
                            uu4Var3 = uu4Var5;
                            uu4Var = null;
                        }
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f092083, Boolean.FALSE);
                    }
                    uu4Var5 = null;
                    uu4Var2 = new uu4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02e8), this.c);
                    uu4Var2.d.setTag(sparseArray6);
                    uu4Var3 = uu4Var5;
                    uu4Var = null;
                } else if (z3) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.obfuscated_res_0x7f092085, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f092099, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f092083, Boolean.TRUE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f09205d, sparseArray.get(R.id.obfuscated_res_0x7f09205d));
                    sparseArray7.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(booleanValue2));
                    sparseArray7.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                    sparseArray7.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                    sparseArray7.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
                    if (this.a.K().S1().W() == 1002 && !booleanValue2) {
                        uu4Var4 = new uu4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1017), this.c);
                    } else {
                        uu4Var4 = new uu4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b0), this.c);
                    }
                    uu4Var4.d.setTag(sparseArray7);
                    if (booleanValue8) {
                        uu4Var = new uu4(13, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b3d), this.c);
                        uu4Var3 = uu4Var4;
                    } else {
                        uu4Var3 = uu4Var4;
                        uu4Var = null;
                    }
                    uu4Var2 = null;
                } else {
                    uu4Var = null;
                    uu4Var2 = null;
                    uu4Var3 = null;
                }
                if (uu4Var3 != null) {
                    arrayList.add(uu4Var3);
                }
                if (uu4Var != null) {
                    arrayList.add(uu4Var);
                }
                if (uu4Var2 != null) {
                    arrayList.add(uu4Var2);
                }
                g18.b(arrayList, this.c, this.G, this.a.K());
            }
            if (UbsABTestHelper.isPBPlanA()) {
                c2 = g18.d(arrayList, this.G.q(), sparseArray, this.c);
            } else {
                c2 = g18.c(arrayList, this.G.q(), sparseArray, this.c);
            }
            g18.l(c2, this.O);
            g18.f(c2);
            this.c.o(g18.g(this.G));
            if (UbsABTestHelper.isPBPlanA()) {
                this.c.k(c2, false);
            } else {
                this.c.k(c2, true);
            }
            wu4 wu4Var = new wu4(this.a.getPageContext(), this.c);
            this.b = wu4Var;
            wu4Var.k();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.a.K().m2()).param("fid", this.a.K().getForumId()).param("uid", this.a.K().S1().O().getAuthor().getUserId()).param("post_id", this.a.K().B()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            nu4 nu4Var = new nu4(this.a.getPageContext().getPageActivity());
            nu4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b4c));
            nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d13, new b0(this));
            nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new c0(this));
            nu4Var.create(this.a.getPageContext()).show();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.a.f4();
            wu4 wu4Var = this.b;
            if (wu4Var != null) {
                wu4Var.dismiss();
            }
            this.a.g4();
            K();
        }
    }

    public void F0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048586, this, z2, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f092095) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f092099) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f092039) instanceof Integer)) {
            wu4 wu4Var = this.b;
            if (wu4Var != null && wu4Var.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f092093);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092095);
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092099)).booleanValue()) {
                yu4 yu4Var = new yu4(this.a.getBaseFragmentActivity());
                yu4Var.n(new a0(this, sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.obfuscated_res_0x7f092039) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092039)).intValue() : -1) == 1) {
                    arrayList.add(new uu4(0, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04b0), yu4Var));
                }
                if (z2) {
                    arrayList.add(new uu4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14bd), yu4Var));
                } else {
                    arrayList.add(new uu4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b49), yu4Var));
                }
                yu4Var.j(arrayList);
                wu4 wu4Var2 = new wu4(this.a.getPageContext(), yu4Var);
                this.b = wu4Var2;
                wu4Var2.k();
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.a.f4();
            wu4 wu4Var = this.b;
            if (wu4Var != null) {
                wu4Var.dismiss();
            }
            K();
        }
    }

    public void G0(pu4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, cVar, z2) == null) {
            wu4 wu4Var = this.d;
            if (wu4Var != null) {
                wu4Var.dismiss();
                this.d = null;
            }
            yu4 yu4Var = new yu4(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.K().S1() != null && this.a.K().S1().O() != null && !this.a.K().S1().O().isBjh()) {
                arrayList.add(new uu4(0, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10af), yu4Var));
            }
            if (!z2) {
                arrayList.add(new uu4(1, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10b0), yu4Var));
            }
            yu4Var.j(arrayList);
            yu4Var.n(new s(this, cVar));
            wu4 wu4Var2 = new wu4(this.a.getPageContext(), yu4Var);
            this.d = wu4Var2;
            wu4Var2.k();
        }
    }

    public void H() {
        wu4 wu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (wu4Var = this.b) == null) {
            return;
        }
        wu4Var.dismiss();
    }

    public void H0(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onItemClickListener) == null) {
            ru4 ru4Var = this.h;
            if (ru4Var != null) {
                ru4Var.d();
                this.h = null;
            }
            if (this.a.K() == null) {
                return;
            }
            ArrayList<av4> arrayList = new ArrayList<>();
            arrayList.add(new av4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0275), "", this.a.K().b2() == 1, Integer.toString(1)));
            arrayList.add(new av4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b59), "", this.a.K().b2() == 2, Integer.toString(5)));
            arrayList.add(new av4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b56), "", this.a.K().b2() == 3, Integer.toString(6)));
            arrayList.add(new av4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b77), "", this.a.K().b2() == 4, Integer.toString(7)));
            ru4 ru4Var2 = new ru4(this.a.getPageContext());
            ru4Var2.l(R.string.obfuscated_res_0x7f0f0e03);
            this.h = ru4Var2;
            ru4Var2.k(arrayList, onItemClickListener);
            ru4Var2.c();
            this.h.n();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            gh.a().postDelayed(this.I, 100L);
        }
    }

    public void I0(vy7 vy7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, vy7Var) == null) || this.a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.a;
        this.u = new uy7(absVideoPbFragment, absVideoPbFragment.B1);
        AlertDialog create = new AlertDialog.Builder(this.a.getContext(), R.style.obfuscated_res_0x7f100107).create();
        this.t = create;
        create.setCanceledOnTouchOutside(true);
        ih.i(this.t, this.a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = ej.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f1003f7);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.y());
        this.u.Q(vy7Var == null ? false : vy7Var.a);
        this.u.D(vy7Var == null ? false : vy7Var.n);
        this.u.F(vy7Var == null ? false : vy7Var.e);
        this.u.L(vy7Var == null ? false : vy7Var.i);
        this.u.G(vy7Var == null ? false : vy7Var.f);
        this.u.S(vy7Var != null ? vy7Var.c : true);
        this.u.P(vy7Var == null ? false : vy7Var.k);
        this.u.H(vy7Var == null ? false : vy7Var.l, vy7Var.t);
        if (vy7Var == null) {
            this.u.N(false, false);
            this.u.M(false, false);
        } else {
            this.u.N(vy7Var.g, vy7Var.s);
            this.u.M(vy7Var.h, vy7Var.r);
        }
        boolean z2 = vy7Var == null ? false : vy7Var.q;
        boolean z3 = vy7Var == null ? false : vy7Var.o;
        boolean z4 = vy7Var == null ? false : vy7Var.d;
        boolean z5 = vy7Var == null ? false : vy7Var.b;
        boolean z6 = vy7Var == null ? false : vy7Var.p;
        boolean z7 = vy7Var == null ? false : vy7Var.j;
        boolean z8 = vy7Var == null ? false : vy7Var.m;
        this.u.I(z4, z3);
        this.u.R(z5, z2);
        this.u.O(z7, z6);
        this.u.U(z8);
        if (vy7Var != null) {
            uy7 uy7Var = this.u;
            boolean z9 = vy7Var.u;
            uy7Var.w = z9;
            if (z9) {
                uy7Var.m().setText(R.string.obfuscated_res_0x7f0f1017);
                this.u.G(false);
            }
        }
        this.u.E(vy7Var != null ? vy7Var.v : false);
        if (!TbSingleton.getInstance().mCanCallFans && this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().Q() != null && this.a.K().S1().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.k().setText(R.string.obfuscated_res_0x7f0f084b);
        }
        O0();
    }

    public void J() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (alertDialog = this.t) == null) {
            return;
        }
        ih.a(alertDialog, this.a.getPageContext().getPageActivity());
    }

    public final void J0(nu4 nu4Var, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048594, this, nu4Var, i2) == null) || (absVideoPbFragment = this.a) == null || nu4Var == null) {
            return;
        }
        if (this.v == null && absVideoPbFragment.getView() != null) {
            this.v = new ao5(this.a.getPageContext(), this.a.getView());
        }
        AntiData L = L();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (L != null && L.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = L.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        vs4 vs4Var = new vs4();
        vs4Var.j(sparseArray);
        this.v.y(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04c4), this.a.getString(R.string.obfuscated_res_0x7f0f04c5), this.a.getString(R.string.obfuscated_res_0x7f0f04c6), this.a.getString(R.string.obfuscated_res_0x7f0f04c7), this.a.getString(R.string.obfuscated_res_0x7f0f04c8)});
        this.v.x(vs4Var);
        this.v.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.v.z(new h(this, nu4Var));
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            nu4 nu4Var = this.e;
            if (nu4Var != null) {
                nu4Var.dismiss();
            }
            Dialog dialog = this.f;
            if (dialog != null) {
                ih.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.g;
            if (dialog2 != null) {
                ih.b(dialog2, this.a.getPageContext());
            }
            wu4 wu4Var = this.q;
            if (wu4Var != null) {
                wu4Var.dismiss();
            }
        }
    }

    public void K0(View view2) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, view2) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.K() == null) {
            return;
        }
        wu4 wu4Var = new wu4(this.a.getPageContext());
        if (this.a.K().S1().f == null || this.a.K().S1().f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11d2), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11d3)};
        } else {
            strArr = new String[this.a.K().S1().f.size()];
            for (int i2 = 0; i2 < this.a.K().S1().f.size(); i2++) {
                strArr[i2] = this.a.K().S1().f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11d0);
            }
        }
        wu4Var.i(null, strArr, new m(this, wu4Var, view2));
        wu4Var.k();
    }

    public AntiData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.a.K() == null || this.a.K().S1() == null) {
                return null;
            }
            return this.a.K().S1().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public void L0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            if (str == null) {
                str = "";
            }
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPageContext() == null) {
                return;
            }
            nu4 nu4Var = new nu4(this.a.getPageContext().getPageActivity());
            nu4Var.setMessage(str);
            nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09b7, new p(this));
            nu4Var.create(this.a.getPageContext()).show();
        }
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            View view2 = this.i;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f0907b9);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void M0(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                C0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            nu4 nu4Var = new nu4(this.a.getBaseFragmentActivity());
            if (dj.isEmpty(str)) {
                nu4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0323, str3));
            } else {
                nu4Var.setMessage(str);
            }
            nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0436, new q(this, userMuteAddAndDelCustomMessage));
            nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new r(this));
            nu4Var.create(this.a.getPageContext()).show();
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public final void N0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.K().m2()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(g18.m(i2))));
        }
    }

    public Object O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.E : invokeV.objValue;
    }

    public final void O0() {
        uy7 uy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (uy7Var = this.u) == null) {
            return;
        }
        uy7Var.C();
    }

    public View.OnLongClickListener P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.M : (View.OnLongClickListener) invokeV.objValue;
    }

    public uy7 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.u : (uy7) invokeV.objValue;
    }

    public pu4 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.s : (pu4) invokeV.objValue;
    }

    public int S(jv7 jv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, jv7Var)) == null) {
            if (jv7Var == null || jv7Var.O() == null) {
                return 0;
            }
            if (jv7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (jv7Var.O().getThreadType() == 54) {
                return 2;
            }
            return jv7Var.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public void T(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f092096) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092096) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092098) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f092097) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092097) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f092093) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092093) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f092094) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092094) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str4, 1, str5, this.D);
            userMuteAddAndDelCustomMessage.setTag(this.D);
            M0(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            if (this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().i0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.K().m2(), str);
                ThreadData O = this.a.K().S1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                c0(format);
                return;
            }
            this.x.a(str);
        }
    }

    public void V() {
        sx4 sx4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (sx4Var = this.r) == null) {
            return;
        }
        sx4Var.h(false);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.s == null) {
            this.s = new pu4(this.a.getPageContext().getPageActivity());
            String[] strArr = {this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f036a), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f11cc), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10e1)};
            pu4 pu4Var = this.s;
            pu4Var.j(strArr, new l(this));
            pu4Var.g(pu4.b.obfuscated_res_0x7f1003ad);
            pu4Var.h(17);
            pu4Var.c(this.a.getPageContext());
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? g18.i(this.a.K()) : invokeV.booleanValue;
    }

    public boolean Y(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, view2)) == null) ? (view2 instanceof TbImageView) || (view2 instanceof TbMemeImageView) || (view2 instanceof GifView) : invokeL.booleanValue;
    }

    public boolean Z(int i2) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) {
            if (i2 != 1) {
                if ((i2 == 2 || i2 == 3 || i2 == 4) && this.a.K().S1().V() != null && (forumToolAuth = this.a.K().S1().V().getForumToolAuth()) != null) {
                    for (int i3 = 0; i3 < forumToolAuth.size(); i3++) {
                        ForumToolPerm forumToolPerm = forumToolAuth.get(i3);
                        if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean a0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) ? i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 : invokeI.booleanValue;
    }

    public final boolean b0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048617, this, z2)) == null) {
            if (this.a.K() != null && this.a.K().S1() != null) {
                return ((this.a.K().S1().W() != 0) || this.a.K().S1().O() == null || this.a.K().S1().O().getAuthor() == null || TextUtils.equals(this.a.K().S1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void d0(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203d)) == null) {
                return;
            }
            e0(postData);
        }
    }

    public void e0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, postData) == null) || postData == null) {
            return;
        }
        boolean z2 = false;
        if (postData.L() != null && postData.L().equals(this.a.K().N1())) {
            z2 = true;
        }
        MarkData M1 = this.a.K().M1(postData);
        if (this.a.K().S1() != null && this.a.K().S1().i0()) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            PostData K3 = absVideoPbFragment.K3(absVideoPbFragment.K().S1());
            if (K3 != null) {
                M1 = this.a.K().M1(K3);
            }
        }
        if (M1 == null) {
            return;
        }
        this.a.n5();
        if (this.a.S3() != null) {
            this.a.S3().i(M1);
            if (!z2) {
                this.a.S3().a();
            } else {
                this.a.S3().d();
            }
        }
    }

    public void f0(ArrayList<ls4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, arrayList) == null) {
            if (this.i == null) {
                this.i = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e6, (ViewGroup) null);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().k(this.i);
            if (this.g == null) {
                Dialog dialog = new Dialog(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003a8);
                this.g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.g.setCancelable(true);
                this.o = (ScrollView) this.i.findViewById(R.id.obfuscated_res_0x7f090cde);
                this.g.setContentView(this.i);
                WindowManager.LayoutParams attributes = this.g.getWindow().getAttributes();
                attributes.width = ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702db);
                this.g.getWindow().setAttributes(attributes);
                this.p = new t(this);
                this.j = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f090cdd);
                TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0907b8);
                this.l = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0907b9);
                this.k = textView2;
                textView2.setOnClickListener(this.a.P3());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f13ec));
            this.m.add(D);
            D.setChecked(true);
            this.j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    ls4 ls4Var = arrayList.get(i2);
                    if (ls4Var != null && !TextUtils.isEmpty(ls4Var.b()) && ls4Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(ls4Var.a()), ls4Var.b());
                        this.m.add(D2);
                        View view2 = new View(this.a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.j.addView(view2);
                        this.j.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = ej.d(this.a.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = ej.d(this.a.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = ej.d(this.a.getPageContext().getPageActivity(), 186.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.j);
                }
            }
            ih.j(this.g, this.a.getPageContext());
        }
    }

    public void g0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            h0(i2, str, i3, z2, null);
        }
    }

    public void h0(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            i0(i2, str, i3, z2, str2, false);
        }
    }

    public void i0(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f09203f, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092041, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f09205d, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            int i4 = (i3 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f04a5 : R.string.obfuscated_res_0x7f0f1014;
            int i5 = R.string.obfuscated_res_0x7f0f043e;
            if (i2 == 0) {
                if (i3 != 1002 || z2) {
                    i5 = R.string.obfuscated_res_0x7f0f04a9;
                    i4 = R.string.obfuscated_res_0x7f0f04aa;
                } else {
                    i4 = R.string.obfuscated_res_0x7f0f1018;
                }
            }
            this.e = new nu4(this.a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.e.setMessageId(i4);
            } else {
                this.e.setOnlyMessageShowCenter(false);
                this.e.setMessage(str2);
            }
            this.e.setYesButtonTag(sparseArray);
            this.e.setPositiveButton(R.string.dialog_ok, new b(this));
            this.e.setNegativeButton(R.string.dialog_cancel, new c(this));
            this.e.setCancelable(true);
            this.e.create(this.a.getPageContext());
            if (z3) {
                w0(sparseArray, i5, i4);
            } else if (z2) {
                w0(sparseArray, i5, i4);
            } else if (r0()) {
                co5 co5Var = new co5(this.a.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.K().S1().o().has_forum_rule.intValue());
                co5Var.i(this.a.K().S1().l().getId(), this.a.K().S1().l().getName());
                co5Var.h(this.a.K().S1().l().getImage_url());
                co5Var.j(this.a.K().S1().l().getUser_level());
                D0(sparseArray, i2, co5Var, this.a.K().S1().V(), false);
            } else {
                J0(this.e, i2);
            }
        }
    }

    public void j0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f09203f, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092041, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f09205d, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            if (z2) {
                s0(sparseArray);
            } else {
                t0(i2, sparseArray);
            }
        }
    }

    public void k0(SparseArray<Object> sparseArray, boolean z2) {
        uu4 uu4Var;
        uu4 uu4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048626, this, sparseArray, z2) == null) {
            yu4 yu4Var = new yu4(this.a.getContext());
            yu4Var.q(this.a.getString(R.string.obfuscated_res_0x7f0f02e8));
            yu4Var.n(new j(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f092039) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092039)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f09203f)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f092041) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092041)).intValue() : -1) == 0) {
                    uu4Var2 = new uu4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04bb), yu4Var);
                } else {
                    uu4Var2 = new uu4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04b0), yu4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                sparseArray2.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                sparseArray2.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                sparseArray2.put(R.id.obfuscated_res_0x7f09205d, sparseArray.get(R.id.obfuscated_res_0x7f09205d));
                uu4Var2.d.setTag(sparseArray2);
                arrayList.add(uu4Var2);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f09205e) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09205e)).booleanValue()) {
                uu4 uu4Var3 = new uu4(13, this.a.getString(R.string.obfuscated_res_0x7f0f0b3d), yu4Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                sparseArray3.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                sparseArray3.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                sparseArray3.put(R.id.obfuscated_res_0x7f09205d, sparseArray.get(R.id.obfuscated_res_0x7f09205d));
                uu4Var3.d.setTag(sparseArray3);
                arrayList.add(uu4Var3);
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f09204a)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f09204b))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f09204a, sparseArray.get(R.id.obfuscated_res_0x7f09204a));
                sparseArray4.put(R.id.obfuscated_res_0x7f09204b, sparseArray.get(R.id.obfuscated_res_0x7f09204b));
                sparseArray4.put(R.id.obfuscated_res_0x7f09204c, sparseArray.get(R.id.obfuscated_res_0x7f09204c));
                sparseArray4.put(R.id.obfuscated_res_0x7f09205d, sparseArray.get(R.id.obfuscated_res_0x7f09205d));
                sparseArray4.put(R.id.obfuscated_res_0x7f09204d, sparseArray.get(R.id.obfuscated_res_0x7f09204d));
                uu4 uu4Var4 = new uu4(11, this.a.getString(R.string.obfuscated_res_0x7f0f0668), yu4Var);
                uu4Var4.d.setTag(sparseArray4);
                arrayList.add(uu4Var4);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f092099) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092099)).booleanValue()) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.obfuscated_res_0x7f092054, sparseArray.get(R.id.obfuscated_res_0x7f092054));
                sparseArray5.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                sparseArray5.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                sparseArray5.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                sparseArray5.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                sparseArray5.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                sparseArray5.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                if (z2) {
                    uu4Var = new uu4(12, this.a.getString(R.string.obfuscated_res_0x7f0f14bd), yu4Var);
                } else {
                    uu4Var = new uu4(12, this.a.getString(R.string.obfuscated_res_0x7f0f0b49), yu4Var);
                }
                uu4Var.d.setTag(sparseArray5);
                arrayList.add(uu4Var);
            }
            g18.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                yu4Var.k(arrayList, false);
            } else {
                yu4Var.k(arrayList, true);
            }
            wu4 wu4Var = this.q;
            if (wu4Var == null) {
                this.q = new wu4(this.a.getPageContext(), yu4Var);
            } else {
                wu4Var.h(yu4Var);
            }
            this.q.k();
        }
    }

    public void l0(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        k0(sparseArray, false);
    }

    public void m0() {
        AbsVideoPbFragment absVideoPbFragment;
        jv7 S1;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.K() == null || this.a.K().S1() == null || (O = (S1 = this.a.K().S1()).O()) == null || O.getAuthor() == null) {
            return;
        }
        this.a.f4();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
        vy7 vy7Var = new vy7();
        int W = this.a.K().S1().W();
        boolean z2 = true;
        if (W != 1 && W != 3) {
            vy7Var.g = false;
        } else {
            vy7Var.g = true;
            vy7Var.s = O.getIs_top() == 1;
        }
        if (Z(W)) {
            vy7Var.h = true;
            vy7Var.r = O.getIs_good() == 1;
        } else {
            vy7Var.h = false;
        }
        if (W == 1002 && !equals) {
            vy7Var.u = true;
        }
        vy7Var.n = z0(O.isBlocked(), S1.k0(), equals, W, O.isWorksInfo(), O.isScoreThread());
        vy7Var.e = v0(equals, S1.k0());
        vy7Var.i = A0();
        vy7Var.f = y0(equals);
        vy7Var.k = equals && S1.V() != null && S1.V().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            vy7Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
        }
        vy7Var.t = equals;
        vy7Var.q = this.a.K().k2();
        vy7Var.b = true;
        vy7Var.a = b0(equals);
        vy7Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        vy7Var.j = true;
        vy7Var.o = this.a.K().v1();
        vy7Var.d = true;
        if (O.getThreadVideoInfo() == null) {
            vy7Var.c = true;
        } else {
            vy7Var.c = false;
        }
        if (S1.i0()) {
            vy7Var.b = false;
            vy7Var.d = false;
            vy7Var.c = false;
            vy7Var.g = false;
            vy7Var.h = false;
        }
        vy7Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !S1.i0()) ? false : false;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2.K3(absVideoPbFragment2.K().S1()) != null) {
            AbsVideoPbFragment absVideoPbFragment3 = this.a;
            vy7Var.w = absVideoPbFragment3.K3(absVideoPbFragment3.K().S1()).R;
        }
        if (O.isBlocked()) {
            vy7Var.n = false;
            vy7Var.g = false;
            vy7Var.h = false;
        }
        I0(vy7Var);
    }

    public final void n0(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, view2) == null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09188c, Integer.valueOf(this.O ? 2 : 3));
        view2.setTag(sparseArray);
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.x.i();
        }
    }

    public void p0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            this.O = z2;
        }
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.H = str;
        }
    }

    public final boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            return (absVideoPbFragment == null || absVideoPbFragment.K().S1().l().getDeletedReasonInfo() == null || 1 != this.a.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void s0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f092053, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1195, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0375, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.P());
        tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f0b45);
        tBAlertBuilder.k(R.string.obfuscated_res_0x7f0f0b46);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        androidx.appcompat.app.AlertDialog w2 = tBAlertBuilder.w();
        aVar.a(new f(this, w2, sparseArray));
        aVar2.a(new g(this, w2));
    }

    public final void t0(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048635, this, i2, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f092053, Boolean.TRUE);
        }
        co5 co5Var = new co5(this.a.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.K().S1().o().has_forum_rule.intValue());
        co5Var.i(this.a.K().S1().l().getId(), this.a.K().S1().l().getName());
        co5Var.h(this.a.K().S1().l().getImage_url());
        co5Var.j(this.a.K().S1().l().getUser_level());
        D0(sparseArray, i2, co5Var, this.a.K().S1().V(), true);
    }

    public final void u0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            g18.e(this.a.getActivity(), this.a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final boolean v0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        ds4 ds4Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048637, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.K() == null || this.a.K().S1() == null) {
                return false;
            }
            jv7 S1 = this.a.K().S1();
            ThreadData O = S1.O();
            if (O != null) {
                if (O.isBJHArticleThreadType() || O.isBJHVideoThreadType()) {
                    return false;
                }
                if (O.isBJHNormalThreadType() || O.isBJHVideoDynamicThreadType()) {
                    return z2;
                }
            }
            if (z2) {
                return true;
            }
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !qi6.isOn()) || this.a.K().H() || O.isWorksInfo() || O.isScoreThread() || z3) {
                return false;
            }
            if (S1.l() == null || !S1.l().isBlockBawuDelete) {
                if (S1.O() == null || !S1.O().isBlocked()) {
                    if (S1.W() != 0) {
                        return S1.W() != 3;
                    }
                    List<xt4> p2 = S1.p();
                    if (ListUtils.getCount(p2) > 0) {
                        for (xt4 xt4Var : p2) {
                            if (xt4Var != null && (ds4Var = xt4Var.g) != null && ds4Var.a && !ds4Var.c && ((i2 = ds4Var.b) == 1 || i2 == 2)) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void w0(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048638, this, sparseArray, i2, i3) == null) || this.a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04b0, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0375, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.P());
        tBAlertBuilder.t(i2);
        tBAlertBuilder.k(i3);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        androidx.appcompat.app.AlertDialog w2 = tBAlertBuilder.w();
        aVar.a(new d(this, w2, sparseArray));
        aVar2.a(new e(this, w2));
    }

    public void x0(SparseArray<Object> sparseArray) {
        AbsVideoPbFragment absVideoPbFragment;
        PostData postData;
        uu4 uu4Var;
        uu4 uu4Var2;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048639, this, sparseArray) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.K() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203d)) == null) {
            return;
        }
        if (this.c == null) {
            yu4 yu4Var = new yu4(this.a.getContext());
            this.c = yu4Var;
            yu4Var.n(this.N);
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = this.a.K().S1() != null && this.a.K().S1().i0();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092040) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092040)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092099) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092099)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092085) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092085)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f092099) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092099)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f092083) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092083)).booleanValue() : false;
            uu4 uu4Var3 = null;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f09204d) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f09204d) : null;
            if (postData.q() != null) {
                boolean z3 = postData.q().hasAgree;
                int r2 = postData.r();
                if (z3 && r2 == 5) {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.obfuscated_res_0x7f0f0085;
                } else {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.obfuscated_res_0x7f0f0087;
                }
                uu4 uu4Var4 = new uu4(8, absVideoPbFragment2.getString(i2), this.c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f09203d, postData);
                uu4Var4.d.setTag(sparseArray2);
                arrayList.add(uu4Var4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    uu4 uu4Var5 = new uu4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b4d), this.c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f092099, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f092054, sparseArray.get(R.id.obfuscated_res_0x7f092054));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09205d, sparseArray.get(R.id.obfuscated_res_0x7f09205d));
                    uu4Var5.d.setTag(sparseArray3);
                    arrayList.add(uu4Var5);
                } else {
                    if ((b0(booleanValue) && TbadkCoreApplication.isLogin()) && !z2) {
                        uu4 uu4Var6 = new uu4(5, this.a.getString(R.string.obfuscated_res_0x7f0f1017), this.c);
                        uu4Var6.d.setTag(str);
                        arrayList.add(uu4Var6);
                    }
                }
                if (booleanValue3) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f092085, Boolean.TRUE);
                    sparseArray4.put(R.id.obfuscated_res_0x7f09205d, sparseArray.get(R.id.obfuscated_res_0x7f09205d));
                    sparseArray4.put(R.id.obfuscated_res_0x7f09204a, sparseArray.get(R.id.obfuscated_res_0x7f09204a));
                    sparseArray4.put(R.id.obfuscated_res_0x7f09204b, sparseArray.get(R.id.obfuscated_res_0x7f09204b));
                    sparseArray4.put(R.id.obfuscated_res_0x7f09204c, sparseArray.get(R.id.obfuscated_res_0x7f09204c));
                    sparseArray4.put(R.id.obfuscated_res_0x7f09204d, str);
                    if (booleanValue4) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092099, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f092054, sparseArray.get(R.id.obfuscated_res_0x7f092054));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092099, Boolean.FALSE);
                    }
                    if (booleanValue5) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092083, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(booleanValue));
                        sparseArray4.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
                        uu4 uu4Var7 = new uu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04b0), this.c);
                        uu4Var7.d.setTag(sparseArray4);
                        uu4Var3 = uu4Var7;
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092083, Boolean.FALSE);
                    }
                    uu4 uu4Var8 = new uu4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e8), this.c);
                    uu4Var8.d.setTag(sparseArray4);
                    uu4Var2 = uu4Var8;
                    uu4Var = uu4Var3;
                } else if (booleanValue5) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f092085, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f092099, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f092083, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f09205d, sparseArray.get(R.id.obfuscated_res_0x7f09205d));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(booleanValue));
                    sparseArray5.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
                    if (this.a.K().S1().W() == 1002 && !booleanValue) {
                        uu4Var = new uu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f1017), this.c);
                    } else {
                        uu4Var = new uu4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04b0), this.c);
                    }
                    uu4Var.d.setTag(sparseArray5);
                    uu4Var2 = null;
                } else {
                    uu4Var = null;
                    uu4Var2 = null;
                }
                if (uu4Var != null) {
                    arrayList.add(uu4Var);
                }
                if (uu4Var2 != null) {
                    arrayList.add(uu4Var2);
                }
                if (!booleanValue) {
                    arrayList.add(new uu4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0324), this.c));
                }
            }
            this.c.j(arrayList);
            wu4 wu4Var = new wu4(this.a.getPageContext(), this.c);
            this.b = wu4Var;
            wu4Var.k();
        }
    }

    public final boolean y0(boolean z2) {
        InterceptResult invokeZ;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048640, this, z2)) == null) {
            if (z2 || (absVideoPbFragment = this.a) == null || absVideoPbFragment.K() == null || this.a.K().S1() == null || (this.a.K().S1().l() != null && this.a.K().S1().l().isBlockBawuDelete)) {
                return false;
            }
            jv7 S1 = this.a.K().S1();
            if ((S1.O() == null || S1.O().getAuthor() == null || !S1.O().getAuthor().isForumBusinessAccount() || qi6.isOn()) && !this.a.K().H()) {
                return ((S1.O() != null && S1.O().isBlocked()) || this.a.K().S1().W() == 0 || this.a.K().S1().W() == 3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final boolean z0(boolean z2, boolean z3, boolean z4, int i2, boolean z5, boolean z6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048641, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i2), Boolean.valueOf(z5), Boolean.valueOf(z6)})) == null) {
            if (z2) {
                return false;
            }
            if (z5 || z6) {
                return true;
            }
            return z3 && (z4 || a0(i2));
        }
        return invokeCommon.booleanValue;
    }
}
