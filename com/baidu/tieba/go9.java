package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.fz5;
import com.baidu.tieba.hz4;
import com.baidu.tieba.ih5;
import com.baidu.tieba.iz4;
import com.baidu.tieba.iz5;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.rz4;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
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
/* loaded from: classes6.dex */
public class go9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int P = 0;
    public static int Q = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public BdImage A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public pea G;
    public String H;
    public Runnable I;
    public t35 J;
    public AgreeMessageData K;
    public final View.OnLongClickListener L;
    public rz4.f M;
    public boolean N;
    public final iz4.c O;
    public AbsVideoPbFragment a;
    public pz4 b;
    public rz4 c;
    public pz4 d;
    public hz4 e;
    public Dialog f;
    public Dialog g;
    public kz4 h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public pz4 q;
    public BlueCircleProgressDialog r;
    public iz4 s;
    public AlertDialog t;
    public lj9 u;
    public fz5 v;
    public iz5 w;
    public dn9 x;
    public PbFragment.i3 y;
    public ik9 z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947800792, "Lcom/baidu/tieba/go9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947800792, "Lcom/baidu/tieba/go9;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(go9 go9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var};
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

    /* loaded from: classes6.dex */
    public class a0 implements rz4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ go9 e;

        public a0(go9 go9Var, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = go9Var;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) {
                if (this.e.b != null) {
                    this.e.b.dismiss();
                }
                if (i == 0) {
                    this.e.f0(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.D);
                    userMuteAddAndDelCustomMessage.setTag(this.e.D);
                    this.e.E0(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements iz4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ go9 a;

        public b(go9 go9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = go9Var;
        }

        @Override // com.baidu.tieba.iz4.c
        public void a(iz4 iz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iz4Var, i, view2) == null) {
                if (iz4Var != null) {
                    iz4Var.e();
                }
                if (this.a.A != null && !TextUtils.isEmpty(this.a.B)) {
                    if (i == 0) {
                        if (this.a.C == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                        } else {
                            ih5.a aVar = new ih5.a();
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
                            go9 go9Var = this.a;
                            go9Var.z = new ik9(go9Var.a.getPageContext());
                        }
                        this.a.z.b(this.a.B, this.a.A.getImageByte());
                    }
                    this.a.A = null;
                    this.a.B = null;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ go9 a;

        public b0(go9 go9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = go9Var;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                TiebaStatic.log("c10025");
                hz4Var.dismiss();
                km9.a(this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ go9 a;

        public c(go9 go9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = go9Var;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                this.a.a.z3(hz4Var, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(go9 go9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var};
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

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ go9 c;

        public e(go9 go9Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = go9Var;
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
                    BdUtilHelper.showToast(this.c.a.l0(), (int) R.string.obfuscated_res_0x7f0f0e4f);
                } else {
                    this.c.a.y3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public f(go9 go9Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var, alertDialog};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (alertDialog = this.a) != null) {
                alertDialog.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ go9 c;

        public g(go9 go9Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = go9Var;
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
                    BdUtilHelper.showToast(this.c.a.l0(), (int) R.string.obfuscated_res_0x7f0f0e4f);
                } else {
                    this.c.a.y3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public h(go9 go9Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var, alertDialog};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (alertDialog = this.a) != null) {
                alertDialog.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements fz5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz4 a;
        public final /* synthetic */ go9 b;

        public i(go9 go9Var, hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var, hz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = go9Var;
            this.a = hz4Var;
        }

        @Override // com.baidu.tieba.fz5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.z3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements iz5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ go9 b;

        public j(go9 go9Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = go9Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.iz5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.y3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ go9 a;

        public k(go9 go9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = go9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.t != null) {
                hb.a(this.a.t, this.a.a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements rz4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ go9 b;

        public l(go9 go9Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = go9Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) {
                this.b.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.f0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.y != null) {
                            this.b.y.callback(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.U(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        AbsVideoPbFragment absVideoPbFragment = this.b.a;
                        if (absVideoPbFragment != null && absVideoPbFragment.J3() != null) {
                            this.b.a.J3().Q2(true);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements iz4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ go9 a;

        public m(go9 go9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = go9Var;
        }

        @Override // com.baidu.tieba.iz4.c
        public void a(iz4 iz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iz4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    go9 go9Var = this.a;
                    go9Var.H = go9Var.H.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new gi9(this.a.a.e0().M1(), this.a.H, "1").start();
                    iz4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    go9 go9Var2 = this.a;
                    go9Var2.H = go9Var2.H.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new gi9(this.a.a.e0().M1(), this.a.H, "2").start();
                    iz4Var.e();
                } else if (i == 2) {
                    go9 go9Var3 = this.a;
                    go9Var3.H = go9Var3.H.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    iz4Var.e();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements rz4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz4 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ go9 c;

        public n(go9 go9Var, pz4 pz4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var, pz4Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = go9Var;
            this.a = pz4Var;
            this.b = view2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.c.a.e0().K1() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.rz4.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void G0(rz4 rz4Var, int i, View view2) {
            boolean m3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) {
                this.a.dismiss();
                int i2 = 3;
                int i3 = 0;
                if (this.c.a.e0().K1() != 1 || i != 1) {
                    if (this.c.a.e0().K1() == 2 && i == 0) {
                        i2 = 1;
                    } else if (this.c.a.e0().K1() == 3 && i != 2) {
                        i2 = 2;
                    } else if (i == 2) {
                    }
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f091b75) {
                        i3 = 1;
                    }
                    TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.e0().s1().f != null && this.c.a.e0().s1().f.size() > i) {
                        i = this.c.a.e0().s1().f.get(i).sort_type.intValue();
                    }
                    m3 = this.c.a.e0().m3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.e0().J1()));
                    if (!m3) {
                        this.c.a.L4(true);
                        return;
                    }
                    return;
                }
                i2 = 0;
                TiebaStatic.log("c12097");
                StatisticItem statisticItem2 = new StatisticItem("c12097");
                if (this.b.getId() != R.id.obfuscated_res_0x7f091b75) {
                }
                TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                if (this.c.a.e0().s1().f != null) {
                    i = this.c.a.e0().s1().f.get(i).sort_type.intValue();
                }
                m3 = this.c.a.e0().m3(i);
                this.b.setTag(Integer.valueOf(this.c.a.e0().J1()));
                if (!m3) {
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(go9 go9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var};
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

    /* loaded from: classes6.dex */
    public class p implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ go9 b;

        public p(go9 go9Var, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = go9Var;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                this.b.v0();
                MessageManager.getInstance().sendMessage(this.a);
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q(go9 go9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var};
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

    /* loaded from: classes6.dex */
    public class r implements rz4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz4.c a;
        public final /* synthetic */ go9 b;

        public r(go9 go9Var, iz4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = go9Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) {
                this.b.d.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ go9 a;

        public s(go9 go9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = go9Var;
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

    /* loaded from: classes6.dex */
    public class t implements rz4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ go9 a;

        public t(go9 go9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = go9Var;
        }

        @Override // com.baidu.tieba.rz4.d
        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null) {
                this.a.c.s(fm9.h(this.a.G));
                ArrayList arrayList = new ArrayList();
                for (qz4 qz4Var : this.a.c.h()) {
                    if (qz4Var instanceof nz4) {
                        arrayList.add((nz4) qz4Var);
                    }
                }
                fm9.f(arrayList);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ go9 a;

        public u(go9 go9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = go9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.g instanceof Dialog)) {
                hb.b(this.a.g, this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ go9 a;

        public v(go9 go9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = go9Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            return this.a.F(view2);
        }
    }

    /* loaded from: classes6.dex */
    public class w implements PbFragment.i3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ go9 a;

        public w(go9 go9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = go9Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.i3
        public void callback(Object obj) {
            String str;
            String str2;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.a.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(this.a.a.e0().s1().V().getUserId());
                if (objArr.length <= 1) {
                    str = "";
                } else {
                    str = String.valueOf(objArr[1]);
                }
                if (objArr.length <= 2) {
                    str2 = "";
                } else {
                    str2 = String.valueOf(objArr[2]);
                }
                if (objArr.length <= 3) {
                    str3 = "";
                } else {
                    str3 = String.valueOf(objArr[3]);
                }
                if (objArr.length <= 4) {
                    str4 = "";
                } else {
                    str4 = String.valueOf(objArr[4]);
                }
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.e0().s1().k().getId(), this.a.a.e0().s1().k().getName(), this.a.a.e0().s1().O().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x implements rz4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ go9 a;

        public x(go9 go9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = go9Var;
        }

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.F0(i);
                if (i != -4) {
                    if (i != -3) {
                        if (i != -2) {
                            if (i != -1) {
                                if (i != 13) {
                                    int i2 = 4;
                                    switch (i) {
                                        case 1:
                                            if (this.a.A != null && !TextUtils.isEmpty(this.a.B)) {
                                                if (this.a.C == null) {
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                                                } else {
                                                    ih5.a aVar = new ih5.a();
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
                                            }
                                            return;
                                        case 2:
                                            if (this.a.A != null && !TextUtils.isEmpty(this.a.B)) {
                                                if (this.a.F == null) {
                                                    this.a.F = new PermissionJudgePolicy();
                                                }
                                                this.a.F.clearRequestPermissionList();
                                                this.a.F.appendRequestPermission(this.a.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                if (this.a.F.startRequestPermission(this.a.a.getPageContext().getPageActivity())) {
                                                    return;
                                                }
                                                if (this.a.z == null) {
                                                    go9 go9Var = this.a;
                                                    go9Var.z = new ik9(go9Var.a.getPageContext());
                                                }
                                                this.a.z.b(this.a.B, this.a.A.getImageByte());
                                                this.a.A = null;
                                                this.a.B = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            pea peaVar = this.a.G;
                                            if (peaVar != null) {
                                                peaVar.S0();
                                                this.a.G = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.c0(view2);
                                            if (this.a.a.e0().s1().O() != null && this.a.a.e0().s1().O().getAuthor() != null && this.a.a.e0().s1().O().getAuthor().getUserId() != null && this.a.a.R3() != null) {
                                                go9 go9Var2 = this.a;
                                                int T2 = go9Var2.T(go9Var2.a.e0().s1());
                                                ThreadData O = this.a.a.e0().s1().O();
                                                if (O.isBJHArticleThreadType()) {
                                                    i2 = 2;
                                                } else if (O.isBJHVideoThreadType()) {
                                                    i2 = 3;
                                                } else if (!O.isBJHNormalThreadType()) {
                                                    if (O.isBJHVideoDynamicThreadType()) {
                                                        i2 = 5;
                                                    } else {
                                                        i2 = 1;
                                                    }
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.e0().M1()).param("obj_locate", 2).param("obj_id", this.a.a.e0().s1().O().getAuthor().getUserId()).param("obj_type", !this.a.a.R3().e()).param("obj_source", T2).param("obj_param1", i2));
                                                return;
                                            }
                                            return;
                                        case 5:
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag = view2.getTag();
                                            if (tag instanceof String) {
                                                TiebaStatic.log(new StatisticItem("c13079"));
                                                this.a.V((String) tag);
                                                return;
                                            } else if (tag instanceof SparseArray) {
                                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray2.put(R.id.tag_from, 0);
                                                    sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                    this.a.C(sparseArray2);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 6:
                                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                            if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                boolean booleanValue = ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue();
                                                int intValue = ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue();
                                                boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.tag_has_sub_post)).booleanValue();
                                                AbsVideoPbFragment absVideoPbFragment = this.a.a;
                                                if (absVideoPbFragment != null && absVideoPbFragment.l0() != null) {
                                                    boolean S = this.a.a.l0().S(TbadkCoreApplication.getCurrentAccount());
                                                    if (S) {
                                                        if (booleanValue2) {
                                                            this.a.h0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, S);
                                                            return;
                                                        } else {
                                                            this.a.s0(sparseArray3, intValue, booleanValue);
                                                            return;
                                                        }
                                                    } else if (!booleanValue || booleanValue2) {
                                                        this.a.f0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                                        return;
                                                    } else {
                                                        this.a.s0(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                            return;
                                        case 7:
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                                            if (sparseArray4 == null) {
                                                return;
                                            }
                                            boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                                            boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                                            boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                            if (sparseArray4.get(R.id.tag_is_self_post) instanceof Boolean) {
                                                z = ((Boolean) sparseArray4.get(R.id.tag_is_self_post)).booleanValue();
                                            } else {
                                                z = false;
                                            }
                                            if (booleanValue3) {
                                                if (booleanValue5) {
                                                    sparseArray4.put(R.id.tag_from, 1);
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                    this.a.C(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                }
                                                sparseArray4.put(R.id.tag_mul_del_post_type, Boolean.TRUE);
                                                this.a.k0(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.f0(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!ViewHelper.checkUpIsLogin(this.a.a.getContext()) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            pea peaVar2 = (pea) sparseArray.get(R.id.tag_clip_board);
                                            if (peaVar2.p() == null) {
                                                return;
                                            }
                                            tm5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                            if (findPageExtraByView != null) {
                                                peaVar2.p().objSource = findPageExtraByView.a();
                                            }
                                            this.a.D(peaVar2.p());
                                            return;
                                        case 9:
                                            AbsVideoPbFragment absVideoPbFragment2 = this.a.a;
                                            if (absVideoPbFragment2 != null && absVideoPbFragment2.e0() != null && this.a.a.e0().s1() != null && ViewHelper.checkUpIsLogin(this.a.a.getContext()) && this.a.a.l0() != null) {
                                                this.a.a.l0().T1(hna.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                AbsVideoPbFragment absVideoPbFragment3 = this.a.a;
                                if (absVideoPbFragment3 != null && absVideoPbFragment3.J3() != null) {
                                    this.a.a.J3().Q2(true);
                                    return;
                                }
                                return;
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                            this.a.l0(view3);
                            AgreeView agreeView = (AgreeView) view3;
                            if (agreeView != null && agreeView.getImgAgree() != null) {
                                agreeView.getImgAgree().performClick();
                                return;
                            }
                            return;
                        }
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                        AgreeView agreeView2 = (AgreeView) view4;
                        this.a.l0(view4);
                        if (agreeView2 != null && agreeView2.getImgDisagree() != null) {
                            agreeView2.getImgDisagree().performClick();
                            return;
                        }
                        return;
                    }
                    View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_reply);
                    this.a.l0(view5);
                    if (view5 != null) {
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                this.a.l0(view6);
                if (view6 != null) {
                    view6.performClick();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ go9 d;

        public y(go9 go9Var, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = go9Var;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                if (hz4Var != null) {
                    hz4Var.dismiss();
                }
                this.d.a.A3(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z(go9 go9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go9Var};
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

    public go9(AbsVideoPbFragment absVideoPbFragment) {
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
        this.L = new v(this);
        this.M = new x(this);
        this.O = new b(this);
        this.a = absVideoPbFragment;
        this.D = absVideoPbFragment.getUniqueId();
        dn9 dn9Var = new dn9(this.a.getContext());
        this.x = dn9Var;
        dn9Var.b(this.a.getUniqueId());
        this.y = new w(this);
    }

    public final boolean a0(boolean z2) {
        InterceptResult invokeZ;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048606, this, z2)) == null) {
            if (this.a.e0() != null && this.a.e0().s1() != null) {
                if (this.a.e0().s1().W() != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3 || this.a.e0().s1().O() == null || this.a.e0().s1().O().getAuthor() == null || TextUtils.equals(this.a.e0().s1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                    return false;
                }
                return !z2;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void q0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048622, this, sparseArray) != null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f1403, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03d2, TBAlertConfig.OperateBtnStyle.SECONDARY);
        androidx.appcompat.app.AlertDialog show = new TBAlertBuilder(this.a.l0()).setTitle(R.string.musk_my_thread_confirm).setDesc(R.string.musk_my_thread_confirm_subtitle).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new g(this, show, sparseArray));
        operateBtnConfig2.setListener(new h(this, show));
    }

    public boolean Z(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, view2)) == null) {
            if (!(view2 instanceof TbImageView) && !(view2 instanceof TbMemeImageView) && !(view2 instanceof GifView)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
            BrowserHelper.startWebActivity(this.a.getContext(), "", str, false, true, true, bundle);
        }
    }

    public final void c0(View view2) {
        SparseArray sparseArray;
        pea peaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (peaVar = (pea) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            d0(peaVar);
        }
    }

    public void k0(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048616, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        j0(sparseArray, false);
    }

    public void n0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) {
            this.N = z2;
        }
    }

    public void o0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.H = str;
        }
    }

    public void A0(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onItemClickListener) == null) {
            kz4 kz4Var = this.h;
            if (kz4Var != null) {
                kz4Var.d();
                this.h = null;
            }
            if (this.a.e0() == null) {
                return;
            }
            ArrayList<tz4> arrayList = new ArrayList<>();
            String string = this.a.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.a.e0().C1() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new tz4(string, "", z2, Integer.toString(1)));
            String string2 = this.a.getContext().getString(R.string.my_fans);
            if (this.a.e0().C1() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new tz4(string2, "", z3, Integer.toString(5)));
            String string3 = this.a.getContext().getString(R.string.my_attentions);
            if (this.a.e0().C1() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new tz4(string3, "", z4, Integer.toString(6)));
            String string4 = this.a.getContext().getString(R.string.myself_only);
            if (this.a.e0().C1() == 4) {
                z5 = true;
            }
            arrayList.add(new tz4(string4, "", z5, Integer.toString(7)));
            kz4 kz4Var2 = new kz4(this.a.getPageContext());
            kz4Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.h = kz4Var2;
            kz4Var2.k(arrayList, onItemClickListener);
            kz4Var2.c();
            this.h.n();
        }
    }

    public void C0(View view2) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && (absVideoPbFragment = this.a) != null && absVideoPbFragment.e0() != null) {
            pz4 pz4Var = new pz4(this.a.getPageContext());
            if (this.a.e0().s1().f == null || this.a.e0().s1().f.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                strArr = new String[this.a.e0().s1().f.size()];
                for (int i2 = 0; i2 < this.a.e0().s1().f.size(); i2++) {
                    strArr[i2] = this.a.e0().s1().f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                }
            }
            pz4Var.i(null, strArr, new n(this, pz4Var, view2));
            pz4Var.l();
        }
    }

    public final void B0(hz4 hz4Var, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hz4Var, i2) == null) && (absVideoPbFragment = this.a) != null && hz4Var != null) {
            if (this.v == null && absVideoPbFragment.getView() != null) {
                this.v = new fz5(this.a.getPageContext(), this.a.getView());
            }
            AntiData M = M();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (M != null && M.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = M.getDelThreadInfoList();
                for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                    }
                }
            }
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray);
            this.v.B(new String[]{this.a.getString(R.string.delete_thread_reason_1), this.a.getString(R.string.delete_thread_reason_2), this.a.getString(R.string.delete_thread_reason_3), this.a.getString(R.string.delete_thread_reason_4), this.a.getString(R.string.delete_thread_reason_5)});
            this.v.A(negativeFeedBackData);
            if (i2 != 1 && i2 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.v.D(str);
            this.v.C(new i(this, hz4Var));
        }
    }

    public final void r0(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048623, this, i2, sparseArray) != null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        hz5 hz5Var = new hz5(this.a.e0().s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.e0().s1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.e0().s1().n().has_forum_rule.intValue());
        hz5Var.i(this.a.e0().s1().k().getId(), this.a.e0().s1().k().getName());
        hz5Var.h(this.a.e0().s1().k().getImage_url());
        hz5Var.j(this.a.e0().s1().k().getUser_level());
        w0(sparseArray, i2, hz5Var, this.a.e0().s1().V(), true);
    }

    public void y0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048630, this, z2, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            pz4 pz4Var = this.b;
            if (pz4Var != null && pz4Var.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            rz4 rz4Var = new rz4(this.a.getBaseFragmentActivity());
            rz4Var.r(new a0(this, sparseArray, z2, str2, str));
            ArrayList arrayList = new ArrayList();
            int i2 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i2 == 1) {
                arrayList.add(new nz4(0, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0551), rz4Var));
            }
            if (z2) {
                arrayList.add(new nz4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.un_mute), rz4Var));
            } else {
                arrayList.add(new nz4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0d27), rz4Var));
            }
            rz4Var.m(arrayList);
            pz4 pz4Var2 = new pz4(this.a.getPageContext(), rz4Var);
            this.b = pz4Var2;
            pz4Var2.l();
        }
    }

    public void C(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            v0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = JavaTypesHelper.toLong(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = JavaTypesHelper.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.D;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.E = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final void F0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.e0().M1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(fm9.n(i2))));
        }
    }

    public int T(ye9 ye9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, ye9Var)) == null) {
            if (ye9Var != null && ye9Var.O() != null) {
                if (ye9Var.O().getThreadType() == 0) {
                    return 1;
                }
                if (ye9Var.O().getThreadType() == 54) {
                    return 2;
                }
                if (ye9Var.O().getThreadType() == 40) {
                    return 3;
                }
                return 4;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void l0(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048617, this, view2) != null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        if (this.N) {
            i2 = 2;
        } else {
            i2 = 3;
        }
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(i2));
        view2.setTag(sparseArray);
    }

    public final void D(AgreeData agreeData) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.J == null) {
            this.J = new t35();
        }
        if (this.K == null) {
            AgreeMessageData agreeMessageData = new AgreeMessageData();
            this.K = agreeMessageData;
            agreeMessageData.uniqueId = this.a.getUniqueId();
        }
        pv4 pv4Var = new pv4();
        pv4Var.b = 5;
        pv4Var.h = 8;
        pv4Var.g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.e0() != null) {
            pv4Var.f = this.a.e0().r1();
        }
        pv4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                pv4Var.i = 0;
                this.J.c(agreeData, i2, this.a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.a;
                if (absVideoPbFragment == null && absVideoPbFragment.e0() != null && this.a.e0().s1() != null) {
                    this.J.b(this.a.l0(), pv4Var, agreeData, this.a.e0().s1().O());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            pv4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            pv4Var.i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        absVideoPbFragment = this.a;
        if (absVideoPbFragment == null) {
        }
    }

    public void V(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            if (this.a.e0() != null && this.a.e0().s1() != null && this.a.e0().s1().j0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.e0().M1(), str);
                ThreadData O = this.a.e0().s1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                b0(format);
                return;
            }
            this.x.a(str);
        }
    }

    public void d0(pea peaVar) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, peaVar) != null) || peaVar == null) {
            return;
        }
        if (peaVar.U() != null && peaVar.U().equals(this.a.e0().n1())) {
            z2 = true;
        } else {
            z2 = false;
        }
        MarkData m1 = this.a.e0().m1(peaVar);
        if (this.a.e0().s1() != null && this.a.e0().s1().j0()) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            pea K3 = absVideoPbFragment.K3(absVideoPbFragment.e0().s1());
            if (K3 != null) {
                m1 = this.a.e0().m1(K3);
            }
        }
        if (m1 == null) {
            return;
        }
        this.a.P4();
        if (this.a.R3() != null) {
            this.a.R3().i(m1);
            if (!z2) {
                this.a.R3().a();
            } else {
                this.a.R3().d();
            }
        }
    }

    public void D0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (str == null) {
                str = "";
            }
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment != null && absVideoPbFragment.getPageContext() != null) {
                hz4 hz4Var = new hz4(this.a.getPageContext().getPageActivity());
                hz4Var.setMessage(str);
                hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b68, new o(this));
                hz4Var.create(this.a.getPageContext()).show();
            }
        }
    }

    public final CustomBlueCheckRadioButton E(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, BdUtilHelper.getDimens(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.p);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public final void E0(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                v0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            hz4 hz4Var = new hz4(this.a.getBaseFragmentActivity());
            if (!ad.isEmpty(str)) {
                hz4Var.setMessage(str);
            } else {
                hz4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
            }
            hz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c8, new p(this, userMuteAddAndDelCustomMessage));
            hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, new q(this));
            hz4Var.create(this.a.getPageContext()).show();
        }
    }

    public final boolean F(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        String str;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        int i2;
        boolean z17;
        nz4 nz4Var;
        nz4 nz4Var2;
        nz4 nz4Var3;
        nz4 nz4Var4;
        nz4 nz4Var5;
        nz4 nz4Var6;
        BdImage bdImage;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment != null && absVideoPbFragment.isAdded()) {
                try {
                    sparseArray = (SparseArray) view2.getTag();
                } catch (ClassCastException e2) {
                    e2.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null) {
                    if (Z(view2)) {
                        if (view2 instanceof TbImageView) {
                            TbImageView tbImageView = (TbImageView) view2;
                            this.A = tbImageView.getBdImage();
                            String url = tbImageView.getUrl();
                            this.B = url;
                            if (this.A == null || TextUtils.isEmpty(url)) {
                                return true;
                            }
                            if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.C = null;
                            }
                        } else if (view2 instanceof GifView) {
                            GifView gifView = (GifView) view2;
                            if (gifView.getBdImage() == null) {
                                return true;
                            }
                            this.A = gifView.getBdImage();
                            if (!TextUtils.isEmpty(gifView.getBdImage().getUrl())) {
                                this.B = gifView.getBdImage().getUrl();
                            }
                            if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.C = null;
                            }
                        } else if (view2 instanceof TbMemeImageView) {
                            TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                            if (tbMemeImageView.getBdImage() != null) {
                                this.A = tbMemeImageView.getBdImage();
                                if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().getUrl())) {
                                    this.B = tbMemeImageView.getBdImage().getUrl();
                                }
                                if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                    this.C = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
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
                            z0(this.O, this.A.isGif());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                pea peaVar = (pea) sparseArray.get(R.id.tag_clip_board);
                this.G = peaVar;
                if (peaVar == null || this.a.R3() == null) {
                    return true;
                }
                if (this.a.R3().e() && this.G.U() != null && this.G.U().equals(this.a.e0().n1())) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.a.e0().s1() != null && this.a.e0().s1().j0()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.c == null) {
                    rz4 rz4Var = new rz4(this.a.getContext());
                    this.c = rz4Var;
                    rz4Var.r(this.M);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 != null && sparseArray != null) {
                    if (Z(view2) && !z3) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (Z(view2) && (bdImage = this.A) != null && !bdImage.isGif()) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (sparseArray.get(R.id.tag_is_subpb) instanceof Boolean) {
                        z6 = ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue();
                    } else {
                        z6 = false;
                    }
                    if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                        z7 = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    } else {
                        z7 = false;
                    }
                    if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                        z8 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                    } else {
                        z8 = false;
                    }
                    if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                        z9 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
                    } else {
                        z9 = false;
                    }
                    if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                        z10 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                    } else {
                        z10 = false;
                    }
                    if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                        z11 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
                    } else {
                        z11 = false;
                    }
                    if (sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String) {
                        str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                    } else {
                        str = null;
                    }
                    if (sparseArray.get(R.id.tag_is_self_post) instanceof Boolean) {
                        z12 = ((Boolean) sparseArray.get(R.id.tag_is_self_post)).booleanValue();
                    } else {
                        z12 = false;
                    }
                    if (sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) {
                        z13 = ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue();
                    } else {
                        z13 = false;
                    }
                    boolean z18 = z13;
                    if (z4) {
                        z16 = z12;
                        z15 = z11;
                        z14 = z10;
                        arrayList.add(new nz4(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.c));
                    } else {
                        z14 = z10;
                        z15 = z11;
                        z16 = z12;
                    }
                    if (z5) {
                        arrayList.add(new nz4(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.c));
                    }
                    if (!z4 && !z5) {
                        nz4 nz4Var7 = new nz4(3, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04eb), this.c);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.tag_clip_board, this.G);
                        nz4Var7.d.setTag(sparseArray3);
                        arrayList.add(nz4Var7);
                    }
                    if (!z6 && !z3) {
                        if (z2) {
                            nz4Var6 = new nz4(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.c);
                        } else {
                            nz4Var6 = new nz4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c69), this.c);
                        }
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_clip_board, this.G);
                        sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                        nz4Var6.d.setTag(sparseArray4);
                        arrayList.add(nz4Var6);
                    }
                    if (TbadkCoreApplication.isLogin()) {
                        if (!Y() && !z9 && z8) {
                            nz4 nz4Var8 = new nz4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0d2b), this.c);
                            SparseArray sparseArray5 = new SparseArray();
                            sparseArray5.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                            sparseArray5.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                            sparseArray5.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                            sparseArray5.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                            sparseArray5.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                            sparseArray5.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                            sparseArray5.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                            sparseArray5.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                            sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                            nz4Var8.d.setTag(sparseArray5);
                            arrayList.add(nz4Var8);
                        } else {
                            if (a0(z7) && TbadkCoreApplication.isLogin()) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17 && !z3) {
                                nz4 nz4Var9 = new nz4(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.c);
                                nz4Var9.d.setTag(str);
                                arrayList.add(nz4Var9);
                            }
                        }
                        if (z9) {
                            SparseArray sparseArray6 = new SparseArray();
                            sparseArray6.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                            sparseArray6.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                            sparseArray6.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                            sparseArray6.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                            sparseArray6.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                            sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                            if (!Y() && z14) {
                                sparseArray6.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                sparseArray6.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                                sparseArray6.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                                sparseArray6.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                                sparseArray6.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                                sparseArray6.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                                sparseArray6.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                            } else {
                                sparseArray6.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                            }
                            if (z15) {
                                sparseArray6.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                                sparseArray6.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                sparseArray6.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                sparseArray6.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                                if (z16) {
                                    nz4Var5 = new nz4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0551), this.c);
                                    nz4Var5.d.setTag(sparseArray6);
                                    nz4Var2 = new nz4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0326), this.c);
                                    nz4Var2.d.setTag(sparseArray6);
                                    nz4Var3 = nz4Var5;
                                    nz4Var = null;
                                }
                            } else {
                                sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                            }
                            nz4Var5 = null;
                            nz4Var2 = new nz4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0326), this.c);
                            nz4Var2.d.setTag(sparseArray6);
                            nz4Var3 = nz4Var5;
                            nz4Var = null;
                        } else if (z15) {
                            SparseArray sparseArray7 = new SparseArray();
                            sparseArray7.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                            sparseArray7.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                            sparseArray7.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                            sparseArray7.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                            sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                            sparseArray7.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray7.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            sparseArray7.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                            if (this.a.e0().s1().W() == 1002 && !z7) {
                                nz4Var4 = new nz4(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.c);
                            } else {
                                nz4Var4 = new nz4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0551), this.c);
                            }
                            nz4Var4.d.setTag(sparseArray7);
                            if (z18) {
                                nz4Var = new nz4(13, TbadkCoreApplication.getInst().getString(R.string.multi_delete), this.c);
                                nz4Var3 = nz4Var4;
                            } else {
                                nz4Var3 = nz4Var4;
                                nz4Var = null;
                            }
                            nz4Var2 = null;
                        } else {
                            nz4Var = null;
                            nz4Var2 = null;
                            nz4Var3 = null;
                        }
                        if (nz4Var3 != null) {
                            arrayList.add(nz4Var3);
                        }
                        if (nz4Var != null) {
                            arrayList.add(nz4Var);
                        }
                        if (nz4Var2 != null) {
                            arrayList.add(nz4Var2);
                        }
                        fm9.b(arrayList, this.c, this.G, this.a.e0());
                    }
                    List<nz4> c2 = fm9.c(arrayList, this.G.p(), sparseArray, this.c);
                    fm9.m(c2, this.N);
                    fm9.f(c2);
                    this.c.s(fm9.h(this.G));
                    this.c.n(c2, true);
                    this.b = new pz4(this.a.getPageContext(), this.c);
                    this.c.q(new t(this));
                    this.b.l();
                    StatisticItem param = new StatisticItem("c13272").param("tid", this.a.e0().M1()).param("fid", this.a.e0().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.a.e0().P());
                    if (z6) {
                        i2 = 2;
                    } else {
                        i2 = 1;
                    }
                    TiebaStatic.log(param.param("obj_source", i2));
                    return true;
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            J();
            this.a.d4();
            pz4 pz4Var = this.b;
            if (pz4Var != null) {
                pz4Var.dismiss();
            }
            this.a.e4();
            L();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            J();
            this.a.d4();
            pz4 pz4Var = this.b;
            if (pz4Var != null) {
                pz4Var.dismiss();
            }
            L();
        }
    }

    public void I() {
        pz4 pz4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (pz4Var = this.b) != null) {
            pz4Var.dismiss();
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            SafeHandler.getInst().postDelayed(this.I, 100L);
        }
    }

    public void K() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (alertDialog = this.t) != null) {
            hb.a(alertDialog, this.a.getPageContext().getPageActivity());
        }
    }

    public View N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            View view2 = this.i;
            if (view2 != null) {
                return view2.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    public Object P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.E;
        }
        return invokeV.objValue;
    }

    public View.OnLongClickListener Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.L;
        }
        return (View.OnLongClickListener) invokeV.objValue;
    }

    public lj9 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.u;
        }
        return (lj9) invokeV.objValue;
    }

    public iz4 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.s;
        }
        return (iz4) invokeV.objValue;
    }

    public void W() {
        BlueCircleProgressDialog blueCircleProgressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (blueCircleProgressDialog = this.r) != null) {
            blueCircleProgressDialog.setDialogVisiable(false);
        }
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return fm9.j(this.a.e0());
        }
        return invokeV.booleanValue;
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.x.i();
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            if (this.r == null) {
                this.r = new BlueCircleProgressDialog(this.a.getPageContext());
            }
            this.r.setDialogVisiable(true);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            hz4 hz4Var = this.e;
            if (hz4Var != null) {
                hz4Var.dismiss();
            }
            Dialog dialog = this.f;
            if (dialog != null) {
                hb.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.g;
            if (dialog2 != null) {
                hb.b(dialog2, this.a.getPageContext());
            }
            pz4 pz4Var = this.q;
            if (pz4Var != null) {
                pz4Var.dismiss();
            }
        }
    }

    public AntiData M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.a.e0() != null && this.a.e0().s1() != null) {
                return this.a.e0().s1().c();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.e0().s1().k().getDeletedReasonInfo() == null || 1 != this.a.e0().s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void U(boolean z2, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str6 = "";
            if (!(sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String)) {
                str2 = "";
            } else {
                str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
            }
            if (!(sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String)) {
                str3 = "";
            } else {
                str3 = (String) sparseArray.get(R.id.tag_user_mute_thread_id);
            }
            if (!(sparseArray.get(R.id.tag_user_mute_post_id) instanceof String)) {
                str4 = "";
            } else {
                str4 = (String) sparseArray.get(R.id.tag_user_mute_post_id);
            }
            if (!(sparseArray.get(R.id.tag_user_mute_msg) instanceof String)) {
                str5 = "";
            } else {
                str5 = (String) sparseArray.get(R.id.tag_user_mute_msg);
            }
            if (sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
                str6 = (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow);
            }
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str4, 1, str5, this.D);
            userMuteAddAndDelCustomMessage.setTag(this.D);
            E0(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048603, this) != null) || this.s != null) {
            return;
        }
        this.s = new iz4(this.a.getPageContext().getPageActivity());
        String[] strArr = {this.a.getPageContext().getString(R.string.call_phone), this.a.getPageContext().getString(R.string.sms_phone), this.a.getPageContext().getString(R.string.search_in_baidu)};
        iz4 iz4Var = this.s;
        iz4Var.j(strArr, new m(this));
        iz4Var.g(iz4.b.a);
        iz4Var.h(17);
        iz4Var.c(this.a.getPageContext());
    }

    public void e0(ArrayList<zw4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, arrayList) == null) {
            if (this.i == null) {
                this.i = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.i);
            if (this.g == null) {
                Dialog dialog = new Dialog(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003c6);
                this.g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.g.setCancelable(true);
                this.o = (ScrollView) this.i.findViewById(R.id.good_scroll);
                this.g.setContentView(this.i);
                WindowManager.LayoutParams attributes = this.g.getWindow().getAttributes();
                attributes.width = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703f5);
                this.g.getWindow().setAttributes(attributes);
                this.p = new s(this);
                this.j = (LinearLayout) this.i.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.i.findViewById(R.id.dialog_button_cancel);
                this.l = textView;
                textView.setOnClickListener(new u(this));
                TextView textView2 = (TextView) this.i.findViewById(R.id.dialog_button_ok);
                this.k = textView2;
                textView2.setOnClickListener(this.a.O3());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton E = E("0", this.a.getPageContext().getString(R.string.thread_good_class));
            this.m.add(E);
            E.setChecked(true);
            this.j.addView(E);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    zw4 zw4Var = arrayList.get(i2);
                    if (zw4Var != null && !TextUtils.isEmpty(zw4Var.b()) && zw4Var.a() > 0) {
                        CustomBlueCheckRadioButton E2 = E(String.valueOf(zw4Var.a()), zw4Var.b());
                        this.m.add(E2);
                        View view2 = new View(this.a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.j.addView(view2);
                        this.j.addView(E2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size != 0 && size != 1) {
                    if (size != 2) {
                        layoutParams2.height = BdUtilHelper.dip2px(this.a.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = BdUtilHelper.dip2px(this.a.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = BdUtilHelper.dip2px(this.a.getPageContext().getPageActivity(), 120.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.j);
                }
            }
            hb.j(this.g, this.a.getPageContext());
        }
    }

    public void f0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            g0(i2, str, i3, z2, null);
        }
    }

    public void g0(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            h0(i2, str, i3, z2, str2, false);
        }
    }

    public void h0(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(P, Integer.valueOf(Q));
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
            this.e = new hz4(this.a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.e.setMessageId(i4);
            } else {
                this.e.setOnlyMessageShowCenter(false);
                this.e.setMessage(str2);
            }
            this.e.setYesButtonTag(sparseArray);
            this.e.setPositiveButton(R.string.obfuscated_res_0x7f0f05a1, new c(this));
            this.e.setNegativeButton(R.string.obfuscated_res_0x7f0f0596, new d(this));
            this.e.setCancelable(true);
            this.e.create(this.a.getPageContext());
            if (z3) {
                t0(sparseArray, i5, i4);
            } else if (z2) {
                t0(sparseArray, i5, i4);
            } else if (p0()) {
                hz5 hz5Var = new hz5(this.a.e0().s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.e0().s1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.e0().s1().n().has_forum_rule.intValue());
                hz5Var.i(this.a.e0().s1().k().getId(), this.a.e0().s1().k().getName());
                hz5Var.h(this.a.e0().s1().k().getImage_url());
                hz5Var.j(this.a.e0().s1().k().getUser_level());
                w0(sparseArray, i2, hz5Var, this.a.e0().s1().V(), false);
            } else {
                B0(this.e, i2);
            }
        }
    }

    public void i0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(P, Integer.valueOf(Q));
            if (z2) {
                q0(sparseArray);
            } else {
                r0(i2, sparseArray);
            }
        }
    }

    public void j0(SparseArray<Object> sparseArray, boolean z2) {
        int i2;
        nz4 nz4Var;
        nz4 nz4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048615, this, sparseArray, z2) == null) {
            rz4 rz4Var = new rz4(this.a.getContext());
            rz4Var.u(this.a.getString(R.string.obfuscated_res_0x7f0f0326));
            rz4Var.r(new l(this, z2));
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
                    nz4Var2 = new nz4(10, this.a.getString(R.string.obfuscated_res_0x7f0f0560), rz4Var);
                } else {
                    nz4Var2 = new nz4(10, this.a.getString(R.string.obfuscated_res_0x7f0f0551), rz4Var);
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
                nz4 nz4Var3 = new nz4(13, this.a.getString(R.string.multi_delete), rz4Var);
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
                nz4 nz4Var4 = new nz4(11, this.a.getString(R.string.forbidden_person), rz4Var);
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
                    nz4Var = new nz4(12, this.a.getString(R.string.un_mute), rz4Var);
                } else {
                    nz4Var = new nz4(12, this.a.getString(R.string.obfuscated_res_0x7f0f0d27), rz4Var);
                }
                nz4Var.d.setTag(sparseArray5);
                arrayList.add(nz4Var);
            }
            fm9.f(arrayList);
            rz4Var.n(arrayList, true);
            pz4 pz4Var = this.q;
            if (pz4Var == null) {
                this.q = new pz4(this.a.getPageContext(), rz4Var);
            } else {
                pz4Var.h(rz4Var);
            }
            this.q.l();
        }
    }

    public final void s0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            fm9.e(this.a.getActivity(), this.a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final void t0(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048625, this, sparseArray, i2, i3) != null) || this.a == null) {
            return;
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f0551, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03d2, TBAlertConfig.OperateBtnStyle.SECONDARY);
        androidx.appcompat.app.AlertDialog show = new TBAlertBuilder(this.a.l0()).setTitle(i2).setDesc(i3).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new e(this, show, sparseArray));
        operateBtnConfig2.setListener(new f(this, show));
    }

    public void u0(SparseArray<Object> sparseArray) {
        AbsVideoPbFragment absVideoPbFragment;
        pea peaVar;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        String str;
        boolean z8;
        nz4 nz4Var;
        nz4 nz4Var2;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048626, this, sparseArray) != null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.e0() == null || sparseArray == null || (peaVar = (pea) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        if (this.c == null) {
            rz4 rz4Var = new rz4(this.a.getContext());
            this.c = rz4Var;
            rz4Var.r(this.M);
        }
        ArrayList arrayList = new ArrayList();
        if (this.a.e0().s1() != null && this.a.e0().s1().j0()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (sparseArray != null) {
            if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                z3 = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
            } else {
                z3 = false;
            }
            if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                z4 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
            } else {
                z4 = false;
            }
            if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                z5 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
            } else {
                z5 = false;
            }
            if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                z6 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
            } else {
                z6 = false;
            }
            if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                z7 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
            } else {
                z7 = false;
            }
            nz4 nz4Var3 = null;
            if (sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String) {
                str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
            } else {
                str = null;
            }
            if (peaVar.p() != null) {
                boolean z9 = peaVar.p().hasAgree;
                int q2 = peaVar.q();
                if (z9 && q2 == 5) {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.action_cancel_dislike;
                } else {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.action_dislike;
                }
                nz4 nz4Var4 = new nz4(8, absVideoPbFragment2.getString(i2), this.c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_clip_board, peaVar);
                nz4Var4.d.setTag(sparseArray2);
                arrayList.add(nz4Var4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!z5 && z4) {
                    nz4 nz4Var5 = new nz4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0d2b), this.c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray3.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                    sparseArray3.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                    sparseArray3.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                    sparseArray3.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                    sparseArray3.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                    sparseArray3.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                    sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                    sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                    sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                    sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                    nz4Var5.d.setTag(sparseArray3);
                    arrayList.add(nz4Var5);
                } else {
                    if (a0(z3) && TbadkCoreApplication.isLogin()) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z8 && !z2) {
                        nz4 nz4Var6 = new nz4(5, this.a.getString(R.string.report_text), this.c);
                        nz4Var6.d.setTag(str);
                        arrayList.add(nz4Var6);
                    }
                }
                if (z5) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                    sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                    sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                    sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                    sparseArray4.put(R.id.tag_forbid_user_post_id, str);
                    if (z6) {
                        sparseArray4.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                        sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                        sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                        sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                        sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                        sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                    } else {
                        sparseArray4.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (z7) {
                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                        sparseArray4.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                        sparseArray4.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                        sparseArray4.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                        nz4 nz4Var7 = new nz4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0551), this.c);
                        nz4Var7.d.setTag(sparseArray4);
                        nz4Var3 = nz4Var7;
                    } else {
                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    nz4 nz4Var8 = new nz4(7, this.a.getString(R.string.obfuscated_res_0x7f0f0326), this.c);
                    nz4Var8.d.setTag(sparseArray4);
                    nz4Var2 = nz4Var8;
                    nz4Var = nz4Var3;
                } else if (z7) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    sparseArray5.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    sparseArray5.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                    sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                    sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                    sparseArray5.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                    if (this.a.e0().s1().W() == 1002 && !z3) {
                        nz4Var = new nz4(6, this.a.getString(R.string.report_text), this.c);
                    } else {
                        nz4Var = new nz4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0551), this.c);
                    }
                    nz4Var.d.setTag(sparseArray5);
                    nz4Var2 = null;
                } else {
                    nz4Var = null;
                    nz4Var2 = null;
                }
                if (nz4Var != null) {
                    arrayList.add(nz4Var);
                }
                if (nz4Var2 != null) {
                    arrayList.add(nz4Var2);
                }
                if (!z3) {
                    arrayList.add(new nz4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0369), this.c));
                }
            }
            this.c.m(arrayList);
            pz4 pz4Var = new pz4(this.a.getPageContext(), this.c);
            this.b = pz4Var;
            pz4Var.l();
        }
    }

    public final void w0(SparseArray<Object> sparseArray, int i2, hz5 hz5Var, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048628, this, new Object[]{sparseArray, Integer.valueOf(i2), hz5Var, userData, Boolean.valueOf(z2)}) != null) || (absVideoPbFragment = this.a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new iz5(this.a.getPageContext(), this.a.getView(), hz5Var, userData);
        }
        this.w.F(z2);
        AntiData M = M();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (M != null && M.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = M.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
        negativeFeedBackData.setFeedBackReasonMap(sparseArray2);
        this.w.H(new String[]{this.a.getString(R.string.delete_thread_reason_1), this.a.getString(R.string.delete_thread_reason_2), this.a.getString(R.string.delete_thread_reason_3), this.a.getString(R.string.delete_thread_reason_4), this.a.getString(R.string.delete_thread_reason_5)});
        this.w.G(negativeFeedBackData);
        if (i2 != 1 && i2 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.w.J(str);
        this.w.I(new j(this, sparseArray));
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            hz4 hz4Var = new hz4(this.a.getPageContext().getPageActivity());
            hz4Var.setMessage(this.a.getResources().getString(R.string.mute_is_super_member_function));
            hz4Var.setPositiveButton(R.string.open_now, new b0(this));
            hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, new a(this));
            hz4Var.create(this.a.getPageContext()).show();
        }
    }

    public void z0(iz4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048631, this, cVar, z2) == null) {
            pz4 pz4Var = this.d;
            if (pz4Var != null) {
                pz4Var.dismiss();
                this.d = null;
            }
            rz4 rz4Var = new rz4(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.e0().s1() != null && this.a.e0().s1().O() != null && !this.a.e0().s1().O().isBjh()) {
                arrayList.add(new nz4(0, this.a.getPageContext().getString(R.string.save_to_emotion), rz4Var));
            }
            if (!z2) {
                arrayList.add(new nz4(1, this.a.getPageContext().getString(R.string.save_to_local), rz4Var));
            }
            rz4Var.m(arrayList);
            rz4Var.r(new r(this, cVar));
            pz4 pz4Var2 = new pz4(this.a.getPageContext(), rz4Var);
            this.d = pz4Var2;
            pz4Var2.l();
        }
    }
}
