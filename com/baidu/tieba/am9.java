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
import com.baidu.tbadk.core.data.MetaData;
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
import com.baidu.tieba.i36;
import com.baidu.tieba.l36;
import com.baidu.tieba.m45;
import com.baidu.tieba.n45;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.rl5;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.w45;
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
/* loaded from: classes5.dex */
public class am9 {
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
    public rba G;
    public String H;
    public Runnable I;
    public r85 J;
    public AgreeMessageData K;
    public final View.OnLongClickListener L;
    public w45.f M;
    public boolean N;
    public final n45.c O;
    public AbsVideoPbFragment a;
    public u45 b;
    public w45 c;
    public u45 d;
    public m45 e;
    public Dialog f;
    public Dialog g;
    public p45 h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public u45 q;
    public BlueCircleProgressDialog r;
    public n45 s;
    public AlertDialog t;
    public lh9 u;
    public i36 v;
    public l36 w;
    public xk9 x;
    public PbFragment.f3 y;
    public hi9 z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947620124, "Lcom/baidu/tieba/am9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947620124, "Lcom/baidu/tieba/am9;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(am9 am9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var};
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
    public class a0 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ am9 d;

        public a0(am9 am9Var, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = am9Var;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                if (m45Var != null) {
                    m45Var.dismiss();
                }
                this.d.a.g3(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements n45.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ am9 a;

        public b(am9 am9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = am9Var;
        }

        @Override // com.baidu.tieba.n45.c
        public void a(n45 n45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n45Var, i, view2) == null) {
                if (n45Var != null) {
                    n45Var.e();
                }
                if (this.a.A != null && !TextUtils.isEmpty(this.a.B)) {
                    if (i == 0) {
                        if (this.a.C == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                        } else {
                            rl5.a aVar = new rl5.a();
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
                            am9 am9Var = this.a;
                            am9Var.z = new hi9(am9Var.a.getPageContext());
                        }
                        this.a.z.b(this.a.B, this.a.A.getImageByte());
                    }
                    this.a.A = null;
                    this.a.B = null;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b0(am9 am9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var};
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
    public class c implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ am9 a;

        public c(am9 am9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = am9Var;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.a.a.f3(m45Var, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements w45.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ am9 e;

        public c0(am9 am9Var, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = am9Var;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tieba.w45.f
        public void K0(w45 w45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, w45Var, i, view2) == null) {
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
                    this.e.F0(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(am9 am9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var};
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
    public class d0 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ am9 a;

        public d0(am9 am9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = am9Var;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                TiebaStatic.log("c10025");
                m45Var.dismiss();
                ek9.a(this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ am9 c;

        public e(am9 am9Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = am9Var;
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
                    BdUtilHelper.showToast(this.c.a.Y(), (int) R.string.obfuscated_res_0x7f0f0e21);
                } else {
                    this.c.a.e3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public f(am9 am9Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var, alertDialog};
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

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ am9 c;

        public g(am9 am9Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = am9Var;
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
                    BdUtilHelper.showToast(this.c.a.Y(), (int) R.string.obfuscated_res_0x7f0f0e21);
                } else {
                    this.c.a.e3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public h(am9 am9Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var, alertDialog};
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

    /* loaded from: classes5.dex */
    public class i implements i36.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m45 a;
        public final /* synthetic */ am9 b;

        public i(am9 am9Var, m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var, m45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = am9Var;
            this.a = m45Var;
        }

        @Override // com.baidu.tieba.i36.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.f3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements l36.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ am9 b;

        public j(am9 am9Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = am9Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.l36.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.e3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ am9 a;

        public k(am9 am9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = am9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.t != null) {
                jg.a(this.a.t, this.a.a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements w45.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ am9 b;

        public l(am9 am9Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = am9Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.w45.f
        public void K0(w45 w45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, w45Var, i, view2) == null) {
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
                        if (absVideoPbFragment != null && absVideoPbFragment.q3() != null) {
                            this.b.a.q3().w2(true);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements n45.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ am9 a;

        public m(am9 am9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = am9Var;
        }

        @Override // com.baidu.tieba.n45.c
        public void a(n45 n45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n45Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    am9 am9Var = this.a;
                    am9Var.H = am9Var.H.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new gg9(this.a.a.R().M1(), this.a.H, "1").start();
                    n45Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    am9 am9Var2 = this.a;
                    am9Var2.H = am9Var2.H.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new gg9(this.a.a.R().M1(), this.a.H, "2").start();
                    n45Var.e();
                } else if (i == 2) {
                    am9 am9Var3 = this.a;
                    am9Var3.H = am9Var3.H.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    n45Var.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements w45.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u45 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ am9 c;

        public n(am9 am9Var, u45 u45Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var, u45Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = am9Var;
            this.a = u45Var;
            this.b = view2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.c.a.R().K1() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.w45.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void K0(w45 w45Var, int i, View view2) {
            boolean m3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, w45Var, i, view2) == null) {
                this.a.dismiss();
                int i2 = 3;
                int i3 = 0;
                if (this.c.a.R().K1() != 1 || i != 1) {
                    if (this.c.a.R().K1() == 2 && i == 0) {
                        i2 = 1;
                    } else if (this.c.a.R().K1() == 3 && i != 2) {
                        i2 = 2;
                    } else if (i == 2) {
                    }
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f091b24) {
                        i3 = 1;
                    }
                    TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.R().s1().f != null && this.c.a.R().s1().f.size() > i) {
                        i = this.c.a.R().s1().f.get(i).sort_type.intValue();
                    }
                    m3 = this.c.a.R().m3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.R().J1()));
                    if (!m3) {
                        this.c.a.u4(true);
                        return;
                    }
                    return;
                }
                i2 = 0;
                TiebaStatic.log("c12097");
                StatisticItem statisticItem2 = new StatisticItem("c12097");
                if (this.b.getId() != R.id.obfuscated_res_0x7f091b24) {
                }
                TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                if (this.c.a.R().s1().f != null) {
                    i = this.c.a.R().s1().f.get(i).sort_type.intValue();
                }
                m3 = this.c.a.R().m3(i);
                this.b.setTag(Integer.valueOf(this.c.a.R().J1()));
                if (!m3) {
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        public o(am9 am9Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var, metaData};
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

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ am9 b;

        public p(am9 am9Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = am9Var;
            this.a = metaData;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                m45Var.dismiss();
                if (this.b.a.n3() != null) {
                    this.b.a.n3().i(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.a.getPageContext().getUniqueId(), this.b.a.R().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q(am9 am9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var};
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
    public class r implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ am9 b;

        public r(am9 am9Var, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = am9Var;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.b.w0();
                MessageManager.getInstance().sendMessage(this.a);
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s(am9 am9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var};
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
    public class t implements w45.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n45.c a;
        public final /* synthetic */ am9 b;

        public t(am9 am9Var, n45.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = am9Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.w45.f
        public void K0(w45 w45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, w45Var, i, view2) == null) {
                this.b.d.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ am9 a;

        public u(am9 am9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = am9Var;
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

    /* loaded from: classes5.dex */
    public class v implements w45.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ am9 a;

        public v(am9 am9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = am9Var;
        }

        @Override // com.baidu.tieba.w45.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null) {
                this.a.c.r(zj9.g(this.a.G));
                ArrayList arrayList = new ArrayList();
                for (v45 v45Var : this.a.c.g()) {
                    if (v45Var instanceof s45) {
                        arrayList.add((s45) v45Var);
                    }
                }
                zj9.e(arrayList);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ am9 a;

        public w(am9 am9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = am9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.g instanceof Dialog)) {
                jg.b(this.a.g, this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ am9 a;

        public x(am9 am9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = am9Var;
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

    /* loaded from: classes5.dex */
    public class y implements PbFragment.f3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ am9 a;

        public y(am9 am9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = am9Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.f3
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
                String valueOf = String.valueOf(this.a.a.R().s1().V().getUserId());
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
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.R().s1().k().getId(), this.a.a.R().s1().k().getName(), this.a.a.R().s1().O().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z implements w45.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ am9 a;

        public z(am9 am9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = am9Var;
        }

        @Override // com.baidu.tieba.w45.f
        public void K0(w45 w45Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, w45Var, i, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.G0(i);
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
                                                    rl5.a aVar = new rl5.a();
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
                                                    am9 am9Var = this.a;
                                                    am9Var.z = new hi9(am9Var.a.getPageContext());
                                                }
                                                this.a.z.b(this.a.B, this.a.A.getImageByte());
                                                this.a.A = null;
                                                this.a.B = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            rba rbaVar = this.a.G;
                                            if (rbaVar != null) {
                                                rbaVar.P0();
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
                                            if (this.a.a.R().s1().O() != null && this.a.a.R().s1().O().getAuthor() != null && this.a.a.R().s1().O().getAuthor().getUserId() != null && this.a.a.y3() != null) {
                                                am9 am9Var2 = this.a;
                                                int T2 = am9Var2.T(am9Var2.a.R().s1());
                                                ThreadData O = this.a.a.R().s1().O();
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
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.R().M1()).param("obj_locate", 2).param("obj_id", this.a.a.R().s1().O().getAuthor().getUserId()).param("obj_type", !this.a.a.y3().e()).param("obj_source", T2).param("obj_param1", i2));
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
                                                if (absVideoPbFragment != null && absVideoPbFragment.Y() != null) {
                                                    boolean G = this.a.a.Y().G(TbadkCoreApplication.getCurrentAccount());
                                                    if (G) {
                                                        if (booleanValue2) {
                                                            this.a.h0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, G);
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
                                            rba rbaVar2 = (rba) sparseArray.get(R.id.tag_clip_board);
                                            if (rbaVar2.o() == null) {
                                                return;
                                            }
                                            br5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                            if (findPageExtraByView != null) {
                                                rbaVar2.o().objSource = findPageExtraByView.a();
                                            }
                                            this.a.D(rbaVar2.o());
                                            return;
                                        case 9:
                                            AbsVideoPbFragment absVideoPbFragment2 = this.a.a;
                                            if (absVideoPbFragment2 != null && absVideoPbFragment2.R() != null && this.a.a.R().s1() != null && ViewHelper.checkUpIsLogin(this.a.a.getContext()) && this.a.a.Y() != null) {
                                                this.a.a.Y().T1(bka.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                AbsVideoPbFragment absVideoPbFragment3 = this.a.a;
                                if (absVideoPbFragment3 != null && absVideoPbFragment3.q3() != null) {
                                    this.a.a.q3().w2(true);
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

    public am9(AbsVideoPbFragment absVideoPbFragment) {
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
        this.L = new x(this);
        this.M = new z(this);
        this.O = new b(this);
        this.a = absVideoPbFragment;
        this.D = absVideoPbFragment.getUniqueId();
        xk9 xk9Var = new xk9(this.a.getContext());
        this.x = xk9Var;
        xk9Var.b(this.a.getUniqueId());
        this.y = new y(this);
    }

    public final boolean a0(boolean z2) {
        InterceptResult invokeZ;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048607, this, z2)) == null) {
            if (this.a.R() != null && this.a.R().s1() != null) {
                if (this.a.R().s1().W() != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3 || this.a.R().s1().O() == null || this.a.R().s1().O().getAuthor() == null || TextUtils.equals(this.a.R().s1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
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
        if ((interceptable != null && interceptable.invokeL(1048623, this, sparseArray) != null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f13cb, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03ce, TBAlertConfig.OperateBtnStyle.SECONDARY);
        androidx.appcompat.app.AlertDialog show = new TBAlertBuilder(this.a.Y()).setTitle(R.string.musk_my_thread_confirm).setDesc(R.string.musk_my_thread_confirm_subtitle).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new g(this, show, sparseArray));
        operateBtnConfig2.setListener(new h(this, show));
    }

    public void v0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048628, this, metaData) != null) || metaData == null) {
            return;
        }
        m45 m45Var = new m45(this.a.getActivity());
        m45Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c3f));
        m45Var.setTitleShowCenter(true);
        m45Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c40));
        m45Var.setMessageShowCenter(true);
        m45Var.setCancelable(false);
        m45Var.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c41), new o(this, metaData));
        m45Var.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c42), new p(this, metaData));
        m45Var.create(this.a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public boolean Z(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, view2)) == null) {
            if (!(view2 instanceof TbImageView) && !(view2 instanceof TbMemeImageView) && !(view2 instanceof GifView)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
            BrowserHelper.startWebActivity(this.a.getContext(), "", str, false, true, true, bundle);
        }
    }

    public final void c0(View view2) {
        SparseArray sparseArray;
        rba rbaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (rbaVar = (rba) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            d0(rbaVar);
        }
    }

    public void k0(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048617, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        j0(sparseArray, false);
    }

    public void n0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z2) == null) {
            this.N = z2;
        }
    }

    public void o0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.H = str;
        }
    }

    public void A0(n45.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cVar, z2) == null) {
            u45 u45Var = this.d;
            if (u45Var != null) {
                u45Var.dismiss();
                this.d = null;
            }
            w45 w45Var = new w45(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.R().s1() != null && this.a.R().s1().O() != null && !this.a.R().s1().O().isBjh()) {
                arrayList.add(new s45(0, this.a.getPageContext().getString(R.string.save_to_emotion), w45Var));
            }
            if (!z2) {
                arrayList.add(new s45(1, this.a.getPageContext().getString(R.string.save_to_local), w45Var));
            }
            w45Var.l(arrayList);
            w45Var.q(new t(this, cVar));
            u45 u45Var2 = new u45(this.a.getPageContext(), w45Var);
            this.d = u45Var2;
            u45Var2.l();
        }
    }

    public void B0(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onItemClickListener) == null) {
            p45 p45Var = this.h;
            if (p45Var != null) {
                p45Var.d();
                this.h = null;
            }
            if (this.a.R() == null) {
                return;
            }
            ArrayList<y45> arrayList = new ArrayList<>();
            String string = this.a.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.a.R().C1() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new y45(string, "", z2, Integer.toString(1)));
            String string2 = this.a.getContext().getString(R.string.my_fans);
            if (this.a.R().C1() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new y45(string2, "", z3, Integer.toString(5)));
            String string3 = this.a.getContext().getString(R.string.my_attentions);
            if (this.a.R().C1() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new y45(string3, "", z4, Integer.toString(6)));
            String string4 = this.a.getContext().getString(R.string.myself_only);
            if (this.a.R().C1() == 4) {
                z5 = true;
            }
            arrayList.add(new y45(string4, "", z5, Integer.toString(7)));
            p45 p45Var2 = new p45(this.a.getPageContext());
            p45Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.h = p45Var2;
            p45Var2.k(arrayList, onItemClickListener);
            p45Var2.c();
            this.h.n();
        }
    }

    public void D0(View view2) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && (absVideoPbFragment = this.a) != null && absVideoPbFragment.R() != null) {
            u45 u45Var = new u45(this.a.getPageContext());
            if (this.a.R().s1().f == null || this.a.R().s1().f.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                strArr = new String[this.a.R().s1().f.size()];
                for (int i2 = 0; i2 < this.a.R().s1().f.size(); i2++) {
                    strArr[i2] = this.a.R().s1().f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                }
            }
            u45Var.i(null, strArr, new n(this, u45Var, view2));
            u45Var.l();
        }
    }

    public void C(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            w0();
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

    public final void G0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.R().M1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(zj9.m(i2))));
        }
    }

    public int T(td9 td9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, td9Var)) == null) {
            if (td9Var != null && td9Var.O() != null) {
                if (td9Var.O().getThreadType() == 0) {
                    return 1;
                }
                if (td9Var.O().getThreadType() == 54) {
                    return 2;
                }
                if (td9Var.O().getThreadType() == 40) {
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
        if ((interceptable != null && interceptable.invokeL(1048618, this, view2) != null) || view2 == null) {
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

    public final void C0(m45 m45Var, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, m45Var, i2) == null) && (absVideoPbFragment = this.a) != null && m45Var != null) {
            if (this.v == null && absVideoPbFragment.getView() != null) {
                this.v = new i36(this.a.getPageContext(), this.a.getView());
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
            this.v.C(new i(this, m45Var));
        }
    }

    public final void r0(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048624, this, i2, sparseArray) != null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        k36 k36Var = new k36(this.a.R().s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.R().s1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.R().s1().n().has_forum_rule.intValue());
        k36Var.i(this.a.R().s1().k().getId(), this.a.R().s1().k().getName());
        k36Var.h(this.a.R().s1().k().getImage_url());
        k36Var.j(this.a.R().s1().k().getUser_level());
        x0(sparseArray, i2, k36Var, this.a.R().s1().V(), true);
    }

    public void z0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048632, this, z2, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            u45 u45Var = this.b;
            if (u45Var != null && u45Var.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            w45 w45Var = new w45(this.a.getBaseFragmentActivity());
            w45Var.q(new c0(this, sparseArray, z2, str2, str));
            ArrayList arrayList = new ArrayList();
            int i2 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i2 == 1) {
                arrayList.add(new s45(0, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0546), w45Var));
            }
            if (z2) {
                arrayList.add(new s45(1, TbadkCoreApplication.getInst().getResources().getString(R.string.un_mute), w45Var));
            } else {
                arrayList.add(new s45(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0cf9), w45Var));
            }
            w45Var.l(arrayList);
            u45 u45Var2 = new u45(this.a.getPageContext(), w45Var);
            this.b = u45Var2;
            u45Var2.l();
        }
    }

    public final void D(AgreeData agreeData) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.J == null) {
            this.J = new r85();
        }
        if (this.K == null) {
            AgreeMessageData agreeMessageData = new AgreeMessageData();
            this.K = agreeMessageData;
            agreeMessageData.uniqueId = this.a.getUniqueId();
        }
        w05 w05Var = new w05();
        w05Var.b = 5;
        w05Var.h = 8;
        w05Var.g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.R() != null) {
            w05Var.f = this.a.R().r1();
        }
        w05Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                w05Var.i = 0;
                this.J.c(agreeData, i2, this.a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.a;
                if (absVideoPbFragment == null && absVideoPbFragment.R() != null && this.a.R().s1() != null) {
                    this.J.b(this.a.Y(), w05Var, agreeData, this.a.R().s1().O());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            w05Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            w05Var.i = 1;
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
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            if (this.a.R() != null && this.a.R().s1() != null && this.a.R().s1().j0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.R().M1(), str);
                ThreadData O = this.a.R().s1().O();
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

    public void d0(rba rbaVar) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, rbaVar) != null) || rbaVar == null) {
            return;
        }
        if (rbaVar.S() != null && rbaVar.S().equals(this.a.R().n1())) {
            z2 = true;
        } else {
            z2 = false;
        }
        MarkData m1 = this.a.R().m1(rbaVar);
        if (this.a.R().s1() != null && this.a.R().s1().j0()) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            rba r3 = absVideoPbFragment.r3(absVideoPbFragment.R().s1());
            if (r3 != null) {
                m1 = this.a.R().m1(r3);
            }
        }
        if (m1 == null) {
            return;
        }
        this.a.y4();
        if (this.a.y3() != null) {
            this.a.y3().i(m1);
            if (!z2) {
                this.a.y3().a();
            } else {
                this.a.y3().d();
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

    public void E0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (str == null) {
                str = "";
            }
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment != null && absVideoPbFragment.getPageContext() != null) {
                m45 m45Var = new m45(this.a.getPageContext().getPageActivity());
                m45Var.setMessage(str);
                m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b3e, new q(this));
                m45Var.create(this.a.getPageContext()).show();
            }
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
        s45 s45Var;
        s45 s45Var2;
        s45 s45Var3;
        s45 s45Var4;
        s45 s45Var5;
        s45 s45Var6;
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
                            A0(this.O, this.A.isGif());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                rba rbaVar = (rba) sparseArray.get(R.id.tag_clip_board);
                this.G = rbaVar;
                if (rbaVar == null || this.a.y3() == null) {
                    return true;
                }
                if (this.a.y3().e() && this.G.S() != null && this.G.S().equals(this.a.R().n1())) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.a.R().s1() != null && this.a.R().s1().j0()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.c == null) {
                    w45 w45Var = new w45(this.a.getContext());
                    this.c = w45Var;
                    w45Var.q(this.M);
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
                        arrayList.add(new s45(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.c));
                    } else {
                        z14 = z10;
                        z15 = z11;
                        z16 = z12;
                    }
                    if (z5) {
                        arrayList.add(new s45(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.c));
                    }
                    if (!z4 && !z5) {
                        s45 s45Var7 = new s45(3, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04e1), this.c);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.tag_clip_board, this.G);
                        s45Var7.d.setTag(sparseArray3);
                        arrayList.add(s45Var7);
                    }
                    if (!z6 && !z3) {
                        if (z2) {
                            s45Var6 = new s45(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.c);
                        } else {
                            s45Var6 = new s45(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c3d), this.c);
                        }
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_clip_board, this.G);
                        sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                        s45Var6.d.setTag(sparseArray4);
                        arrayList.add(s45Var6);
                    }
                    if (TbadkCoreApplication.isLogin()) {
                        if (!Y() && !z9 && z8) {
                            s45 s45Var8 = new s45(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0cfd), this.c);
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
                            s45Var8.d.setTag(sparseArray5);
                            arrayList.add(s45Var8);
                        } else {
                            if (a0(z7) && TbadkCoreApplication.isLogin()) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17 && !z3) {
                                s45 s45Var9 = new s45(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.c);
                                s45Var9.d.setTag(str);
                                arrayList.add(s45Var9);
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
                                    s45Var5 = new s45(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0546), this.c);
                                    s45Var5.d.setTag(sparseArray6);
                                    s45Var2 = new s45(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0322), this.c);
                                    s45Var2.d.setTag(sparseArray6);
                                    s45Var3 = s45Var5;
                                    s45Var = null;
                                }
                            } else {
                                sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                            }
                            s45Var5 = null;
                            s45Var2 = new s45(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0322), this.c);
                            s45Var2.d.setTag(sparseArray6);
                            s45Var3 = s45Var5;
                            s45Var = null;
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
                            if (this.a.R().s1().W() == 1002 && !z7) {
                                s45Var4 = new s45(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.c);
                            } else {
                                s45Var4 = new s45(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0546), this.c);
                            }
                            s45Var4.d.setTag(sparseArray7);
                            if (z18) {
                                s45Var = new s45(13, TbadkCoreApplication.getInst().getString(R.string.multi_delete), this.c);
                                s45Var3 = s45Var4;
                            } else {
                                s45Var3 = s45Var4;
                                s45Var = null;
                            }
                            s45Var2 = null;
                        } else {
                            s45Var = null;
                            s45Var2 = null;
                            s45Var3 = null;
                        }
                        if (s45Var3 != null) {
                            arrayList.add(s45Var3);
                        }
                        if (s45Var != null) {
                            arrayList.add(s45Var);
                        }
                        if (s45Var2 != null) {
                            arrayList.add(s45Var2);
                        }
                        zj9.b(arrayList, this.c, this.G, this.a.R());
                    }
                    List<s45> c2 = zj9.c(arrayList, this.G.o(), sparseArray, this.c);
                    zj9.l(c2, this.N);
                    zj9.e(c2);
                    this.c.r(zj9.g(this.G));
                    this.c.m(c2, true);
                    this.b = new u45(this.a.getPageContext(), this.c);
                    this.c.p(new v(this));
                    this.b.l();
                    StatisticItem param = new StatisticItem("c13272").param("tid", this.a.R().M1()).param("fid", this.a.R().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.a.R().P());
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

    public final void F0(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                w0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            m45 m45Var = new m45(this.a.getBaseFragmentActivity());
            if (!bi.isEmpty(str)) {
                m45Var.setMessage(str);
            } else {
                m45Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
            }
            m45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c1, new r(this, userMuteAddAndDelCustomMessage));
            m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new s(this));
            m45Var.create(this.a.getPageContext()).show();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            J();
            this.a.K3();
            u45 u45Var = this.b;
            if (u45Var != null) {
                u45Var.dismiss();
            }
            this.a.L3();
            L();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            J();
            this.a.K3();
            u45 u45Var = this.b;
            if (u45Var != null) {
                u45Var.dismiss();
            }
            L();
        }
    }

    public void I() {
        u45 u45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (u45Var = this.b) != null) {
            u45Var.dismiss();
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            SafeHandler.getInst().postDelayed(this.I, 100L);
        }
    }

    public void K() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (alertDialog = this.t) != null) {
            jg.a(alertDialog, this.a.getPageContext().getPageActivity());
        }
    }

    public View N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    public Object P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.E;
        }
        return invokeV.objValue;
    }

    public View.OnLongClickListener Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.L;
        }
        return (View.OnLongClickListener) invokeV.objValue;
    }

    public lh9 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.u;
        }
        return (lh9) invokeV.objValue;
    }

    public n45 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.s;
        }
        return (n45) invokeV.objValue;
    }

    public void W() {
        BlueCircleProgressDialog blueCircleProgressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (blueCircleProgressDialog = this.r) != null) {
            blueCircleProgressDialog.setDialogVisiable(false);
        }
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return zj9.i(this.a.R());
        }
        return invokeV.booleanValue;
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.x.i();
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            if (this.r == null) {
                this.r = new BlueCircleProgressDialog(this.a.getPageContext());
            }
            this.r.setDialogVisiable(true);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            m45 m45Var = this.e;
            if (m45Var != null) {
                m45Var.dismiss();
            }
            Dialog dialog = this.f;
            if (dialog != null) {
                jg.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.g;
            if (dialog2 != null) {
                jg.b(dialog2, this.a.getPageContext());
            }
            u45 u45Var = this.q;
            if (u45Var != null) {
                u45Var.dismiss();
            }
        }
    }

    public AntiData M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.a.R() != null && this.a.R().s1() != null) {
                return this.a.R().s1().c();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.R().s1().k().getDeletedReasonInfo() == null || 1 != this.a.R().s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
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
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
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
            F0(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || this.s != null) {
            return;
        }
        this.s = new n45(this.a.getPageContext().getPageActivity());
        String[] strArr = {this.a.getPageContext().getString(R.string.call_phone), this.a.getPageContext().getString(R.string.sms_phone), this.a.getPageContext().getString(R.string.search_in_baidu)};
        n45 n45Var = this.s;
        n45Var.j(strArr, new m(this));
        n45Var.g(n45.b.a);
        n45Var.h(17);
        n45Var.c(this.a.getPageContext());
    }

    public void e0(ArrayList<g25> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, arrayList) == null) {
            if (this.i == null) {
                this.i = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.i);
            if (this.g == null) {
                Dialog dialog = new Dialog(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003c1);
                this.g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.g.setCancelable(true);
                this.o = (ScrollView) this.i.findViewById(R.id.good_scroll);
                this.g.setContentView(this.i);
                WindowManager.LayoutParams attributes = this.g.getWindow().getAttributes();
                attributes.width = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703f5);
                this.g.getWindow().setAttributes(attributes);
                this.p = new u(this);
                this.j = (LinearLayout) this.i.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.i.findViewById(R.id.dialog_button_cancel);
                this.l = textView;
                textView.setOnClickListener(new w(this));
                TextView textView2 = (TextView) this.i.findViewById(R.id.dialog_button_ok);
                this.k = textView2;
                textView2.setOnClickListener(this.a.v3());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton E = E("0", this.a.getPageContext().getString(R.string.thread_good_class));
            this.m.add(E);
            E.setChecked(true);
            this.j.addView(E);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    g25 g25Var = arrayList.get(i2);
                    if (g25Var != null && !TextUtils.isEmpty(g25Var.b()) && g25Var.a() > 0) {
                        CustomBlueCheckRadioButton E2 = E(String.valueOf(g25Var.a()), g25Var.b());
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
            jg.j(this.g, this.a.getPageContext());
        }
    }

    public void f0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            g0(i2, str, i3, z2, null);
        }
    }

    public void g0(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            h0(i2, str, i3, z2, str2, false);
        }
    }

    public void h0(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
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
            this.e = new m45(this.a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.e.setMessageId(i4);
            } else {
                this.e.setOnlyMessageShowCenter(false);
                this.e.setMessage(str2);
            }
            this.e.setYesButtonTag(sparseArray);
            this.e.setPositiveButton(R.string.obfuscated_res_0x7f0f0596, new c(this));
            this.e.setNegativeButton(R.string.obfuscated_res_0x7f0f058b, new d(this));
            this.e.setCancelable(true);
            this.e.create(this.a.getPageContext());
            if (z3) {
                t0(sparseArray, i5, i4);
            } else if (z2) {
                t0(sparseArray, i5, i4);
            } else if (p0()) {
                k36 k36Var = new k36(this.a.R().s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.R().s1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.R().s1().n().has_forum_rule.intValue());
                k36Var.i(this.a.R().s1().k().getId(), this.a.R().s1().k().getName());
                k36Var.h(this.a.R().s1().k().getImage_url());
                k36Var.j(this.a.R().s1().k().getUser_level());
                x0(sparseArray, i2, k36Var, this.a.R().s1().V(), false);
            } else {
                C0(this.e, i2);
            }
        }
    }

    public void i0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
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
        s45 s45Var;
        s45 s45Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048616, this, sparseArray, z2) == null) {
            w45 w45Var = new w45(this.a.getContext());
            w45Var.t(this.a.getString(R.string.obfuscated_res_0x7f0f0322));
            w45Var.q(new l(this, z2));
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
                    s45Var2 = new s45(10, this.a.getString(R.string.obfuscated_res_0x7f0f0555), w45Var);
                } else {
                    s45Var2 = new s45(10, this.a.getString(R.string.obfuscated_res_0x7f0f0546), w45Var);
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
                s45 s45Var3 = new s45(13, this.a.getString(R.string.multi_delete), w45Var);
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
                s45 s45Var4 = new s45(11, this.a.getString(R.string.forbidden_person), w45Var);
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
                    s45Var = new s45(12, this.a.getString(R.string.un_mute), w45Var);
                } else {
                    s45Var = new s45(12, this.a.getString(R.string.obfuscated_res_0x7f0f0cf9), w45Var);
                }
                s45Var.d.setTag(sparseArray5);
                arrayList.add(s45Var);
            }
            zj9.e(arrayList);
            w45Var.m(arrayList, true);
            u45 u45Var = this.q;
            if (u45Var == null) {
                this.q = new u45(this.a.getPageContext(), w45Var);
            } else {
                u45Var.h(w45Var);
            }
            this.q.l();
        }
    }

    public final void s0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            zj9.d(this.a.getActivity(), this.a.getPageContext(), new a0(this, sparseArray, i2, z2), new b0(this));
        }
    }

    public final void t0(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048626, this, sparseArray, i2, i3) != null) || this.a == null) {
            return;
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f0546, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03ce, TBAlertConfig.OperateBtnStyle.SECONDARY);
        androidx.appcompat.app.AlertDialog show = new TBAlertBuilder(this.a.Y()).setTitle(i2).setDesc(i3).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new e(this, show, sparseArray));
        operateBtnConfig2.setListener(new f(this, show));
    }

    public void u0(SparseArray<Object> sparseArray) {
        AbsVideoPbFragment absVideoPbFragment;
        rba rbaVar;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        String str;
        boolean z8;
        s45 s45Var;
        s45 s45Var2;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048627, this, sparseArray) != null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.R() == null || sparseArray == null || (rbaVar = (rba) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        if (this.c == null) {
            w45 w45Var = new w45(this.a.getContext());
            this.c = w45Var;
            w45Var.q(this.M);
        }
        ArrayList arrayList = new ArrayList();
        if (this.a.R().s1() != null && this.a.R().s1().j0()) {
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
            s45 s45Var3 = null;
            if (sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String) {
                str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
            } else {
                str = null;
            }
            if (rbaVar.o() != null) {
                boolean z9 = rbaVar.o().hasAgree;
                int q2 = rbaVar.q();
                if (z9 && q2 == 5) {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.action_cancel_dislike;
                } else {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.action_dislike;
                }
                s45 s45Var4 = new s45(8, absVideoPbFragment2.getString(i2), this.c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_clip_board, rbaVar);
                s45Var4.d.setTag(sparseArray2);
                arrayList.add(s45Var4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!z5 && z4) {
                    s45 s45Var5 = new s45(5, this.a.getString(R.string.obfuscated_res_0x7f0f0cfd), this.c);
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
                    s45Var5.d.setTag(sparseArray3);
                    arrayList.add(s45Var5);
                } else {
                    if (a0(z3) && TbadkCoreApplication.isLogin()) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z8 && !z2) {
                        s45 s45Var6 = new s45(5, this.a.getString(R.string.report_text), this.c);
                        s45Var6.d.setTag(str);
                        arrayList.add(s45Var6);
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
                        s45 s45Var7 = new s45(6, this.a.getString(R.string.obfuscated_res_0x7f0f0546), this.c);
                        s45Var7.d.setTag(sparseArray4);
                        s45Var3 = s45Var7;
                    } else {
                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    s45 s45Var8 = new s45(7, this.a.getString(R.string.obfuscated_res_0x7f0f0322), this.c);
                    s45Var8.d.setTag(sparseArray4);
                    s45Var2 = s45Var8;
                    s45Var = s45Var3;
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
                    if (this.a.R().s1().W() == 1002 && !z3) {
                        s45Var = new s45(6, this.a.getString(R.string.report_text), this.c);
                    } else {
                        s45Var = new s45(6, this.a.getString(R.string.obfuscated_res_0x7f0f0546), this.c);
                    }
                    s45Var.d.setTag(sparseArray5);
                    s45Var2 = null;
                } else {
                    s45Var = null;
                    s45Var2 = null;
                }
                if (s45Var != null) {
                    arrayList.add(s45Var);
                }
                if (s45Var2 != null) {
                    arrayList.add(s45Var2);
                }
                if (!z3) {
                    arrayList.add(new s45(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0365), this.c));
                }
            }
            this.c.l(arrayList);
            u45 u45Var = new u45(this.a.getPageContext(), this.c);
            this.b = u45Var;
            u45Var.l();
        }
    }

    public final void x0(SparseArray<Object> sparseArray, int i2, k36 k36Var, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048630, this, new Object[]{sparseArray, Integer.valueOf(i2), k36Var, userData, Boolean.valueOf(z2)}) != null) || (absVideoPbFragment = this.a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new l36(this.a.getPageContext(), this.a.getView(), k36Var, userData);
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

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            m45 m45Var = new m45(this.a.getPageContext().getPageActivity());
            m45Var.setMessage(this.a.getResources().getString(R.string.mute_is_super_member_function));
            m45Var.setPositiveButton(R.string.open_now, new d0(this));
            m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new a(this));
            m45Var.create(this.a.getPageContext()).show();
        }
    }
}
