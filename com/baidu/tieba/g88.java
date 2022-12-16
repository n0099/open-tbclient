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
import com.baidu.tbadk.core.util.GreyUtil;
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
import com.baidu.tieba.lv4;
import com.baidu.tieba.n95;
import com.baidu.tieba.nv4;
import com.baidu.tieba.oq5;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.rq5;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.wv4;
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
public class g88 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int P = 0;
    public static int Q = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public in A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public PostData G;
    public String H;
    public Runnable I;
    public ny4 J;
    public bs8 K;
    public final View.OnLongClickListener L;
    public wv4.e M;
    public boolean N;
    public final nv4.c O;
    public AbsVideoPbFragment a;
    public uv4 b;
    public wv4 c;
    public uv4 d;
    public lv4 e;
    public Dialog f;
    public Dialog g;
    public pv4 h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public uv4 q;
    public uy4 r;
    public nv4 s;
    public AlertDialog t;
    public s38 u;
    public oq5 v;
    public rq5 w;
    public o68 x;
    public PbFragment.h3 y;
    public q48 z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947747906, "Lcom/baidu/tieba/g88;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947747906, "Lcom/baidu/tieba/g88;");
        }
    }

    public boolean a0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) ? i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 : invokeI.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a implements nv4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g88 a;

        public a(g88 g88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g88Var;
        }

        @Override // com.baidu.tieba.nv4.c
        public void a(nv4 nv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nv4Var, i, view2) == null) {
                if (nv4Var != null) {
                    nv4Var.e();
                }
                if (this.a.A != null && !TextUtils.isEmpty(this.a.B)) {
                    if (i == 0) {
                        if (this.a.C == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                        } else {
                            n95.a aVar = new n95.a();
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
                            g88 g88Var = this.a;
                            g88Var.z = new q48(g88Var.a.getPageContext());
                        }
                        this.a.z.b(this.a.B, this.a.A.n());
                    }
                    this.a.A = null;
                    this.a.B = null;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a0 implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ g88 e;

        public a0(g88 g88Var, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = g88Var;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tieba.wv4.e
        public void n0(wv4 wv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wv4Var, i, view2) == null) {
                if (this.e.b != null) {
                    this.e.b.dismiss();
                }
                if (i == 0) {
                    this.e.g0(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.D);
                    userMuteAddAndDelCustomMessage.setTag(this.e.D);
                    this.e.M0(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g88 a;

        public b(g88 g88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g88Var;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                this.a.a.B3(lv4Var, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g88 a;

        public b0(g88 g88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g88Var;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                TiebaStatic.log("c10025");
                lv4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(g88 g88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c0 implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(g88 g88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ g88 c;

        public d(g88 g88Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g88Var;
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
                    yi.P(this.c.a.R(), R.string.obfuscated_res_0x7f0f0cb8);
                } else {
                    this.c.a.A3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public e(g88 g88Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var, alertDialog};
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

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ g88 c;

        public f(g88 g88Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g88Var;
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
                    yi.P(this.c.a.R(), R.string.obfuscated_res_0x7f0f0cb8);
                } else {
                    this.c.a.A3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public g(g88 g88Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var, alertDialog};
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

    /* loaded from: classes4.dex */
    public class h implements oq5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv4 a;
        public final /* synthetic */ g88 b;

        public h(g88 g88Var, lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var, lv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g88Var;
            this.a = lv4Var;
        }

        @Override // com.baidu.tieba.oq5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.B3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements rq5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ g88 b;

        public i(g88 g88Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g88Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.rq5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.A3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ g88 b;

        public j(g88 g88Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g88Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.wv4.e
        public void n0(wv4 wv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wv4Var, i, view2) == null) {
                this.b.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.g0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.y != null) {
                            this.b.y.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.T(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        AbsVideoPbFragment absVideoPbFragment = this.b.a;
                        if (absVideoPbFragment != null && absVideoPbFragment.N3() != null) {
                            this.b.a.N3().r2(true);
                            return;
                        }
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
        public final /* synthetic */ g88 a;

        public k(g88 g88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g88Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.t != null) {
                ch.a(this.a.t, this.a.a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements nv4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g88 a;

        public l(g88 g88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g88Var;
        }

        @Override // com.baidu.tieba.nv4.c
        public void a(nv4 nv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nv4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    g88 g88Var = this.a;
                    g88Var.H = g88Var.H.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new n28(this.a.a.M().F1(), this.a.H, "1").start();
                    nv4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    g88 g88Var2 = this.a;
                    g88Var2.H = g88Var2.H.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new n28(this.a.a.M().F1(), this.a.H, "2").start();
                    nv4Var.e();
                } else if (i == 2) {
                    g88 g88Var3 = this.a;
                    g88Var3.H = g88Var3.H.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    nv4Var.e();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uv4 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ g88 c;

        public m(g88 g88Var, uv4 uv4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var, uv4Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g88Var;
            this.a = uv4Var;
            this.b = view2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.c.a.M().C1() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.wv4.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void n0(wv4 wv4Var, int i, View view2) {
            boolean f3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wv4Var, i, view2) == null) {
                this.a.dismiss();
                int i2 = 3;
                int i3 = 0;
                if (this.c.a.M().C1() != 1 || i != 1) {
                    if (this.c.a.M().C1() == 2 && i == 0) {
                        i2 = 1;
                    } else if (this.c.a.M().C1() == 3 && i != 2) {
                        i2 = 2;
                    } else if (i == 2) {
                    }
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f091925) {
                        i3 = 1;
                    }
                    TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.M().l1().f != null && this.c.a.M().l1().f.size() > i) {
                        i = this.c.a.M().l1().f.get(i).sort_type.intValue();
                    }
                    f3 = this.c.a.M().f3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.M().B1()));
                    if (!f3) {
                        this.c.a.m5(true);
                        return;
                    }
                    return;
                }
                i2 = 0;
                TiebaStatic.log("c12097");
                StatisticItem statisticItem2 = new StatisticItem("c12097");
                if (this.b.getId() != R.id.obfuscated_res_0x7f091925) {
                }
                TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                if (this.c.a.M().l1().f != null) {
                    i = this.c.a.M().l1().f.get(i).sort_type.intValue();
                }
                f3 = this.c.a.M().f3(i);
                this.b.setTag(Integer.valueOf(this.c.a.M().B1()));
                if (!f3) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        public n(g88 g88Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var, metaData};
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

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ g88 b;

        public o(g88 g88Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g88Var;
            this.a = metaData;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                lv4Var.dismiss();
                if (this.b.a.K3() != null) {
                    this.b.a.K3().i(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.a.getPageContext().getUniqueId(), this.b.a.M().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(g88 g88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ g88 b;

        public q(g88 g88Var, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g88Var;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                this.b.C0();
                MessageManager.getInstance().sendMessage(this.a);
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r(g88 g88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv4.c a;
        public final /* synthetic */ g88 b;

        public s(g88 g88Var, nv4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g88Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.wv4.e
        public void n0(wv4 wv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wv4Var, i, view2) == null) {
                this.b.d.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g88 a;

        public t(g88 g88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g88Var;
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
        public final /* synthetic */ g88 a;

        public u(g88 g88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g88Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            return this.a.E(view2);
        }
    }

    /* loaded from: classes4.dex */
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g88 a;

        public v(g88 g88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g88Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.g instanceof Dialog)) {
                ch.b(this.a.g, this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements PbFragment.h3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g88 a;

        public w(g88 g88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g88Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.h3
        public void a(Object obj) {
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
                String valueOf = String.valueOf(this.a.a.M().l1().X().getUserId());
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
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.M().l1().l().getId(), this.a.a.M().l1().l().getName(), this.a.a.M().l1().Q().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g88 a;

        public x(g88 g88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g88Var;
        }

        @Override // com.baidu.tieba.wv4.e
        public void n0(wv4 wv4Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wv4Var, i, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.N0(i);
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
                                                    n95.a aVar = new n95.a();
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
                                                    g88 g88Var = this.a;
                                                    g88Var.z = new q48(g88Var.a.getPageContext());
                                                }
                                                this.a.z.b(this.a.B, this.a.A.n());
                                                this.a.A = null;
                                                this.a.B = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            PostData postData = this.a.G;
                                            if (postData != null) {
                                                postData.F0();
                                                this.a.G = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (this.a.a.checkUpIsLogin()) {
                                                this.a.d0(view2);
                                                if (this.a.a.M().l1().Q() != null && this.a.a.M().l1().Q().getAuthor() != null && this.a.a.M().l1().Q().getAuthor().getUserId() != null && this.a.a.X3() != null) {
                                                    g88 g88Var2 = this.a;
                                                    int S = g88Var2.S(g88Var2.a.M().l1());
                                                    ThreadData Q = this.a.a.M().l1().Q();
                                                    if (Q.isBJHArticleThreadType()) {
                                                        i2 = 2;
                                                    } else if (Q.isBJHVideoThreadType()) {
                                                        i2 = 3;
                                                    } else if (!Q.isBJHNormalThreadType()) {
                                                        if (Q.isBJHVideoDynamicThreadType()) {
                                                            i2 = 5;
                                                        } else {
                                                            i2 = 1;
                                                        }
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.M().F1()).param("obj_locate", 2).param("obj_id", this.a.a.M().l1().Q().getAuthor().getUserId()).param("obj_type", !this.a.a.X3().e()).param("obj_source", S).param("obj_param1", i2));
                                                    return;
                                                }
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
                                                this.a.U((String) tag);
                                                return;
                                            } else if (tag instanceof SparseArray) {
                                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray2.put(R.id.tag_from, 0);
                                                    sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                    this.a.B(sparseArray2);
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
                                                if (absVideoPbFragment != null && absVideoPbFragment.R() != null) {
                                                    boolean E = this.a.a.R().E(TbadkCoreApplication.getCurrentAccount());
                                                    if (E) {
                                                        if (booleanValue2) {
                                                            this.a.i0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, E);
                                                            return;
                                                        } else {
                                                            this.a.u0(sparseArray3, intValue, booleanValue);
                                                            return;
                                                        }
                                                    } else if (!booleanValue || booleanValue2) {
                                                        this.a.g0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                                        return;
                                                    } else {
                                                        this.a.u0(sparseArray3, intValue, booleanValue);
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
                                                    this.a.B(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                }
                                                sparseArray4.put(R.id.tag_mul_del_post_type, Boolean.TRUE);
                                                this.a.l0(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.g0(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!ViewHelper.checkUpIsLogin(this.a.a.getContext()) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                            if (postData2.p() == null) {
                                                return;
                                            }
                                            pe5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                            if (findPageExtraByView != null) {
                                                postData2.p().objSource = findPageExtraByView.a();
                                            }
                                            this.a.C(postData2.p());
                                            return;
                                        case 9:
                                            AbsVideoPbFragment absVideoPbFragment2 = this.a.a;
                                            if (absVideoPbFragment2 != null && absVideoPbFragment2.M() != null && this.a.a.M().l1() != null && ViewHelper.checkUpIsLogin(this.a.a.getContext()) && this.a.a.R() != null) {
                                                this.a.a.R().u1(oz8.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                AbsVideoPbFragment absVideoPbFragment3 = this.a.a;
                                if (absVideoPbFragment3 != null && absVideoPbFragment3.N3() != null) {
                                    this.a.a.N3().r2(true);
                                    return;
                                }
                                return;
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                            this.a.n0(view3);
                            AgreeView agreeView = (AgreeView) view3;
                            if (agreeView != null && agreeView.getImgAgree() != null) {
                                agreeView.getImgAgree().performClick();
                                return;
                            }
                            return;
                        }
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                        AgreeView agreeView2 = (AgreeView) view4;
                        this.a.n0(view4);
                        if (agreeView2 != null && agreeView2.getImgDisagree() != null) {
                            agreeView2.getImgDisagree().performClick();
                            return;
                        }
                        return;
                    }
                    View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_reply);
                    this.a.n0(view5);
                    if (view5 != null) {
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                this.a.n0(view6);
                if (view6 != null) {
                    view6.performClick();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ g88 d;

        public y(g88 g88Var, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = g88Var;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                if (lv4Var != null) {
                    lv4Var.dismiss();
                }
                this.d.a.C3(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z(g88 g88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
            }
        }
    }

    public g88(AbsVideoPbFragment absVideoPbFragment) {
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
        this.L = new u(this);
        this.M = new x(this);
        this.O = new a(this);
        this.a = absVideoPbFragment;
        this.D = absVideoPbFragment.getUniqueId();
        o68 o68Var = new o68(this.a.getContext());
        this.x = o68Var;
        o68Var.b(this.a.getUniqueId());
        this.y = new w(this);
    }

    public void B0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) != null) || metaData == null) {
            return;
        }
        lv4 lv4Var = new lv4(this.a.getActivity());
        lv4Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0afe));
        lv4Var.setTitleShowCenter(true);
        lv4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0aff));
        lv4Var.setMessageShowCenter(true);
        lv4Var.setCancelable(false);
        lv4Var.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b00), new n(this, metaData));
        lv4Var.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b01), new o(this, metaData));
        lv4Var.create(this.a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public boolean Z(int i2) {
        InterceptResult invokeI;
        boolean z2;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) {
            if (i2 == 1) {
                return true;
            }
            if (i2 != 2 && i2 != 3 && i2 != 4) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2 && this.a.M().l1().X() != null && (forumToolAuth = this.a.M().l1().X().getForumToolAuth()) != null) {
                for (int i3 = 0; i3 < forumToolAuth.size(); i3++) {
                    ForumToolPerm forumToolPerm = forumToolAuth.get(i3);
                    if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final boolean b0(boolean z2) {
        InterceptResult invokeZ;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048617, this, z2)) == null) {
            if (this.a.M() != null && this.a.M().l1() != null) {
                if (this.a.M().l1().Y() != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3 || this.a.M().l1().Q() == null || this.a.M().l1().Q().getAuthor() == null || TextUtils.equals(this.a.M().l1().Q().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void s0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048634, this, sparseArray) != null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1206, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f037c, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.R());
        tBAlertBuilder.v(R.string.musk_my_thread_confirm);
        tBAlertBuilder.m(R.string.musk_my_thread_confirm_subtitle);
        tBAlertBuilder.o(true);
        tBAlertBuilder.t(aVar2, aVar);
        tBAlertBuilder.j(false);
        androidx.appcompat.app.AlertDialog y2 = tBAlertBuilder.y();
        aVar.a(new f(this, y2, sparseArray));
        aVar2.a(new g(this, y2));
    }

    public boolean Y(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, view2)) == null) {
            if (!(view2 instanceof TbImageView) && !(view2 instanceof TbMemeImageView) && !(view2 instanceof GifView)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
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
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            e0(postData);
        }
    }

    public void l0(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048627, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        k0(sparseArray, false);
    }

    public void p0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            this.N = z2;
        }
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.H = str;
        }
    }

    public final boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.M() == null || !this.a.M().D1()) {
                return false;
            }
            if (this.a.M().j1() != null && this.a.M().j1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            lv4 lv4Var = new lv4(this.a.getPageContext().getPageActivity());
            lv4Var.setMessage(this.a.getResources().getString(R.string.mute_is_super_member_function));
            lv4Var.setPositiveButton(R.string.open_now, new b0(this));
            lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037c, new c0(this));
            lv4Var.create(this.a.getPageContext()).show();
        }
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            C0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = xg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = xg.g((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.D;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.E = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final void N0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.M().F1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(f68.n(i2))));
        }
    }

    public int S(h08 h08Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, h08Var)) == null) {
            if (h08Var != null && h08Var.Q() != null) {
                if (h08Var.Q().getThreadType() == 0) {
                    return 1;
                }
                if (h08Var.Q().getThreadType() == 54) {
                    return 2;
                }
                if (h08Var.Q().getThreadType() == 40) {
                    return 3;
                }
                return 4;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void n0(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048629, this, view2) != null) || view2 == null) {
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

    public final void C(AgreeData agreeData) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.J == null) {
            this.J = new ny4();
        }
        if (this.K == null) {
            bs8 bs8Var = new bs8();
            this.K = bs8Var;
            bs8Var.a = this.a.getUniqueId();
        }
        bs4 bs4Var = new bs4();
        bs4Var.b = 5;
        bs4Var.h = 8;
        bs4Var.g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.M() != null) {
            bs4Var.f = this.a.M().k1();
        }
        bs4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                bs4Var.i = 0;
                this.J.c(agreeData, i2, this.a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.a;
                if (absVideoPbFragment == null && absVideoPbFragment.M() != null && this.a.M().l1() != null) {
                    this.J.b(this.a.R(), bs4Var, agreeData, this.a.M().l1().Q());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            bs4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            bs4Var.i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        absVideoPbFragment = this.a;
        if (absVideoPbFragment == null) {
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            if (this.a.M() != null && this.a.M().l1() != null && this.a.M().l1().l0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.M().F1(), str);
                ThreadData Q2 = this.a.M().l1().Q();
                if (Q2.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (Q2.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (Q2.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                c0(format);
                return;
            }
            this.x.a(str);
        }
    }

    public void e0(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, postData) != null) || postData == null) {
            return;
        }
        boolean z2 = false;
        if (postData.M() != null && postData.M().equals(this.a.M().g1())) {
            z2 = true;
        }
        MarkData f1 = this.a.M().f1(postData);
        if (this.a.M().l1() != null && this.a.M().l1().l0()) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            PostData P3 = absVideoPbFragment.P3(absVideoPbFragment.M().l1());
            if (P3 != null) {
                f1 = this.a.M().f1(P3);
            }
        }
        if (f1 == null) {
            return;
        }
        this.a.s5();
        if (this.a.X3() != null) {
            this.a.X3().i(f1);
            if (!z2) {
                this.a.X3().a();
            } else {
                this.a.X3().d();
            }
        }
    }

    public final boolean y0(boolean z2) {
        InterceptResult invokeZ;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048640, this, z2)) == null) {
            if (z2 || (absVideoPbFragment = this.a) == null || absVideoPbFragment.M() == null || this.a.M().l1() == null || (this.a.M().l1().l() != null && this.a.M().l1().l().isBlockBawuDelete)) {
                return false;
            }
            h08 l1 = this.a.M().l1();
            if ((l1.Q() != null && l1.Q().getAuthor() != null && l1.Q().getAuthor().isForumBusinessAccount() && !pl6.isOn()) || this.a.M().O()) {
                return false;
            }
            if ((l1.Q() != null && l1.Q().isBlocked()) || this.a.M().l1().Y() == 0 || this.a.M().l1().Y() == 3) {
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.r == null) {
                this.r = new uy4(this.a.getPageContext());
            }
            this.r.h(true);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.a.k4();
            uv4 uv4Var = this.b;
            if (uv4Var != null) {
                uv4Var.dismiss();
            }
            this.a.l4();
            K();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.a.k4();
            uv4 uv4Var = this.b;
            if (uv4Var != null) {
                uv4Var.dismiss();
            }
            K();
        }
    }

    public void H() {
        uv4 uv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (uv4Var = this.b) != null) {
            uv4Var.dismiss();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            ah.a().postDelayed(this.I, 100L);
        }
    }

    public void J() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (alertDialog = this.t) != null) {
            ch.a(alertDialog, this.a.getPageContext().getPageActivity());
        }
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            View view2 = this.i;
            if (view2 != null) {
                return view2.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    public Object O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.E;
        }
        return invokeV.objValue;
    }

    public final void O0() {
        s38 s38Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || (s38Var = this.u) == null) {
            return;
        }
        s38Var.C();
    }

    public View.OnLongClickListener P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.L;
        }
        return (View.OnLongClickListener) invokeV.objValue;
    }

    public s38 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.u;
        }
        return (s38) invokeV.objValue;
    }

    public nv4 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.s;
        }
        return (nv4) invokeV.objValue;
    }

    public void V() {
        uy4 uy4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (uy4Var = this.r) != null) {
            uy4Var.h(false);
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return f68.j(this.a.M());
        }
        return invokeV.booleanValue;
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.x.i();
        }
    }

    public final CustomBlueCheckRadioButton D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, yi.g(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.p);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public final void D0(SparseArray<Object> sparseArray, int i2, qq5 qq5Var, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048582, this, new Object[]{sparseArray, Integer.valueOf(i2), qq5Var, userData, Boolean.valueOf(z2)}) != null) || (absVideoPbFragment = this.a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new rq5(this.a.getPageContext(), this.a.getView(), qq5Var, userData);
        }
        this.w.F(z2);
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
        rt4 rt4Var = new rt4();
        rt4Var.j(sparseArray2);
        this.w.H(new String[]{this.a.getString(R.string.delete_thread_reason_1), this.a.getString(R.string.delete_thread_reason_2), this.a.getString(R.string.delete_thread_reason_3), this.a.getString(R.string.delete_thread_reason_4), this.a.getString(R.string.delete_thread_reason_5)});
        this.w.G(rt4Var);
        if (i2 != 1 && i2 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.w.J(str);
        this.w.I(new i(this, sparseArray));
    }

    public final boolean E(View view2) {
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
        List<sv4> c2;
        int i2;
        boolean z17;
        sv4 sv4Var;
        sv4 sv4Var2;
        sv4 sv4Var3;
        sv4 sv4Var4;
        sv4 sv4Var5;
        sv4 sv4Var6;
        in inVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment != null && absVideoPbFragment.isAdded()) {
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
                            if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                                this.B = gifView.getBdImage().q();
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
                                if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                    this.B = tbMemeImageView.getBdImage().q();
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
                            G0(this.O, this.A.t());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                this.G = postData;
                if (postData == null || this.a.X3() == null) {
                    return true;
                }
                if (this.a.X3().e() && this.G.M() != null && this.G.M().equals(this.a.M().g1())) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.a.M().l1() != null && this.a.M().l1().l0()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.c == null) {
                    wv4 wv4Var = new wv4(this.a.getContext());
                    this.c = wv4Var;
                    wv4Var.n(this.M);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 != null && sparseArray != null) {
                    if (Y(view2) && !z3) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (Y(view2) && (inVar = this.A) != null && !inVar.t()) {
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
                        arrayList.add(new sv4(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.c));
                    } else {
                        z14 = z10;
                        z15 = z11;
                        z16 = z12;
                    }
                    if (z5) {
                        arrayList.add(new sv4(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.c));
                    }
                    if (!z4 && !z5) {
                        sv4 sv4Var7 = new sv4(3, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0462), this.c);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.tag_clip_board, this.G);
                        sv4Var7.d.setTag(sparseArray3);
                        arrayList.add(sv4Var7);
                    }
                    if (!z6 && !z3) {
                        if (z2) {
                            sv4Var6 = new sv4(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.c);
                        } else {
                            sv4Var6 = new sv4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0afc), this.c);
                        }
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_clip_board, this.G);
                        sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                        sv4Var6.d.setTag(sparseArray4);
                        arrayList.add(sv4Var6);
                    }
                    if (TbadkCoreApplication.isLogin()) {
                        if (!X() && !z9 && z8) {
                            sv4 sv4Var8 = new sv4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ba1), this.c);
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
                            sv4Var8.d.setTag(sparseArray5);
                            arrayList.add(sv4Var8);
                        } else {
                            if (b0(z7) && TbadkCoreApplication.isLogin()) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17 && !z3) {
                                sv4 sv4Var9 = new sv4(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.c);
                                sv4Var9.d.setTag(str);
                                arrayList.add(sv4Var9);
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
                            if (!X() && z14) {
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
                                    sv4Var5 = new sv4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c1), this.c);
                                    sv4Var5.d.setTag(sparseArray6);
                                    sv4Var2 = new sv4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ee), this.c);
                                    sv4Var2.d.setTag(sparseArray6);
                                    sv4Var3 = sv4Var5;
                                    sv4Var = null;
                                }
                            } else {
                                sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                            }
                            sv4Var5 = null;
                            sv4Var2 = new sv4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ee), this.c);
                            sv4Var2.d.setTag(sparseArray6);
                            sv4Var3 = sv4Var5;
                            sv4Var = null;
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
                            if (this.a.M().l1().Y() == 1002 && !z7) {
                                sv4Var4 = new sv4(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.c);
                            } else {
                                sv4Var4 = new sv4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c1), this.c);
                            }
                            sv4Var4.d.setTag(sparseArray7);
                            if (z18) {
                                sv4Var = new sv4(13, TbadkCoreApplication.getInst().getString(R.string.multi_delete), this.c);
                                sv4Var3 = sv4Var4;
                            } else {
                                sv4Var3 = sv4Var4;
                                sv4Var = null;
                            }
                            sv4Var2 = null;
                        } else {
                            sv4Var = null;
                            sv4Var2 = null;
                            sv4Var3 = null;
                        }
                        if (sv4Var3 != null) {
                            arrayList.add(sv4Var3);
                        }
                        if (sv4Var != null) {
                            arrayList.add(sv4Var);
                        }
                        if (sv4Var2 != null) {
                            arrayList.add(sv4Var2);
                        }
                        f68.b(arrayList, this.c, this.G, this.a.M());
                    }
                    if (UbsABTestHelper.isPBPlanA()) {
                        c2 = f68.d(arrayList, this.G.p(), sparseArray, this.c);
                    } else {
                        c2 = f68.c(arrayList, this.G.p(), sparseArray, this.c);
                    }
                    f68.m(c2, this.N);
                    f68.f(c2);
                    this.c.o(f68.h(this.G));
                    if (UbsABTestHelper.isPBPlanA()) {
                        this.c.k(c2, false);
                    } else {
                        this.c.k(c2, true);
                    }
                    uv4 uv4Var = new uv4(this.a.getPageContext(), this.c);
                    this.b = uv4Var;
                    uv4Var.k();
                    StatisticItem param = new StatisticItem("c13272").param("tid", this.a.M().F1()).param("fid", this.a.M().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.a.M().I());
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

    public void F0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048586, this, z2, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            uv4 uv4Var = this.b;
            if (uv4Var != null && uv4Var.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            wv4 wv4Var = new wv4(this.a.getBaseFragmentActivity());
            wv4Var.n(new a0(this, sparseArray, z2, str2, str));
            ArrayList arrayList = new ArrayList();
            int i2 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i2 == 1) {
                arrayList.add(new sv4(0, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04c1), wv4Var));
            }
            if (z2) {
                arrayList.add(new sv4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.un_mute), wv4Var));
            } else {
                arrayList.add(new sv4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b9d), wv4Var));
            }
            wv4Var.j(arrayList);
            uv4 uv4Var2 = new uv4(this.a.getPageContext(), wv4Var);
            this.b = uv4Var2;
            uv4Var2.k();
        }
    }

    public final void J0(lv4 lv4Var, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048594, this, lv4Var, i2) == null) && (absVideoPbFragment = this.a) != null && lv4Var != null) {
            if (this.v == null && absVideoPbFragment.getView() != null) {
                this.v = new oq5(this.a.getPageContext(), this.a.getView());
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
            rt4 rt4Var = new rt4();
            rt4Var.j(sparseArray);
            this.v.B(new String[]{this.a.getString(R.string.delete_thread_reason_1), this.a.getString(R.string.delete_thread_reason_2), this.a.getString(R.string.delete_thread_reason_3), this.a.getString(R.string.delete_thread_reason_4), this.a.getString(R.string.delete_thread_reason_5)});
            this.v.A(rt4Var);
            if (i2 != 1 && i2 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.v.D(str);
            this.v.C(new h(this, lv4Var));
        }
    }

    public final void t0(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048635, this, i2, sparseArray) != null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        qq5 qq5Var = new qq5(this.a.M().l1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.M().l1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.M().l1().o().has_forum_rule.intValue());
        qq5Var.i(this.a.M().l1().l().getId(), this.a.M().l1().l().getName());
        qq5Var.h(this.a.M().l1().l().getImage_url());
        qq5Var.j(this.a.M().l1().l().getUser_level());
        D0(sparseArray, i2, qq5Var, this.a.M().l1().X(), true);
    }

    public final boolean v0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        at4 at4Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048637, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.M() == null || this.a.M().l1() == null) {
                return false;
            }
            h08 l1 = this.a.M().l1();
            ThreadData Q2 = l1.Q();
            if (Q2 != null) {
                if (Q2.isBJHArticleThreadType() || Q2.isBJHVideoThreadType()) {
                    return false;
                }
                if (Q2.isBJHNormalThreadType() || Q2.isBJHVideoDynamicThreadType()) {
                    return z2;
                }
            }
            if (z2) {
                return true;
            }
            if ((Q2 != null && Q2.getAuthor() != null && Q2.getAuthor().isForumBusinessAccount() && !pl6.isOn()) || this.a.M().O() || Q2.isWorksInfo() || Q2.isScoreThread() || z3) {
                return false;
            }
            if (l1.l() != null && l1.l().isBlockBawuDelete) {
                return false;
            }
            if (l1.Q() != null && l1.Q().isBlocked()) {
                return false;
            }
            if (l1.Y() != 0) {
                if (l1.Y() == 3) {
                    return false;
                }
                return true;
            }
            List<uu4> p2 = l1.p();
            if (ListUtils.getCount(p2) <= 0) {
                return false;
            }
            for (uu4 uu4Var : p2) {
                if (uu4Var != null && (at4Var = uu4Var.f) != null && at4Var.a && !at4Var.c && ((i2 = at4Var.b) == 1 || i2 == 2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void G0(nv4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, cVar, z2) == null) {
            uv4 uv4Var = this.d;
            if (uv4Var != null) {
                uv4Var.dismiss();
                this.d = null;
            }
            wv4 wv4Var = new wv4(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.M().l1() != null && this.a.M().l1().Q() != null && !this.a.M().l1().Q().isBjh()) {
                arrayList.add(new sv4(0, this.a.getPageContext().getString(R.string.save_to_emotion), wv4Var));
            }
            if (!z2) {
                arrayList.add(new sv4(1, this.a.getPageContext().getString(R.string.save_to_local), wv4Var));
            }
            wv4Var.j(arrayList);
            wv4Var.n(new s(this, cVar));
            uv4 uv4Var2 = new uv4(this.a.getPageContext(), wv4Var);
            this.d = uv4Var2;
            uv4Var2.k();
        }
    }

    public void H0(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onItemClickListener) == null) {
            pv4 pv4Var = this.h;
            if (pv4Var != null) {
                pv4Var.d();
                this.h = null;
            }
            if (this.a.M() == null) {
                return;
            }
            ArrayList<yv4> arrayList = new ArrayList<>();
            String string = this.a.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.a.M().u1() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new yv4(string, "", z2, Integer.toString(1)));
            String string2 = this.a.getContext().getString(R.string.my_fans);
            if (this.a.M().u1() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new yv4(string2, "", z3, Integer.toString(5)));
            String string3 = this.a.getContext().getString(R.string.my_attentions);
            if (this.a.M().u1() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new yv4(string3, "", z4, Integer.toString(6)));
            String string4 = this.a.getContext().getString(R.string.myself_only);
            if (this.a.M().u1() == 4) {
                z5 = true;
            }
            arrayList.add(new yv4(string4, "", z5, Integer.toString(7)));
            pv4 pv4Var2 = new pv4(this.a.getPageContext());
            pv4Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.h = pv4Var2;
            pv4Var2.k(arrayList, onItemClickListener);
            pv4Var2.c();
            this.h.n();
        }
    }

    public void K0(View view2) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, view2) == null) && (absVideoPbFragment = this.a) != null && absVideoPbFragment.M() != null) {
            uv4 uv4Var = new uv4(this.a.getPageContext());
            if (this.a.M().l1().f == null || this.a.M().l1().f.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                strArr = new String[this.a.M().l1().f.size()];
                for (int i2 = 0; i2 < this.a.M().l1().f.size(); i2++) {
                    strArr[i2] = this.a.M().l1().f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                }
            }
            uv4Var.i(null, strArr, new m(this, uv4Var, view2));
            uv4Var.k();
        }
    }

    public void I0(t38 t38Var) {
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
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, t38Var) != null) || this.a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.a;
        this.u = new s38(absVideoPbFragment, absVideoPbFragment.A1);
        AlertDialog create = new AlertDialog.Builder(this.a.getContext(), R.style.obfuscated_res_0x7f100107).create();
        this.t = create;
        GreyUtil.grey(create);
        boolean z16 = true;
        this.t.setCanceledOnTouchOutside(true);
        ch.i(this.t, this.a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = yi.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f1003fa);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.y());
        s38 s38Var = this.u;
        boolean z17 = false;
        if (t38Var == null) {
            z2 = false;
        } else {
            z2 = t38Var.a;
        }
        s38Var.Q(z2);
        s38 s38Var2 = this.u;
        if (t38Var == null) {
            z3 = false;
        } else {
            z3 = t38Var.n;
        }
        s38Var2.D(z3);
        s38 s38Var3 = this.u;
        if (t38Var == null) {
            z4 = false;
        } else {
            z4 = t38Var.e;
        }
        s38Var3.F(z4);
        s38 s38Var4 = this.u;
        if (t38Var == null) {
            z5 = false;
        } else {
            z5 = t38Var.i;
        }
        s38Var4.L(z5);
        s38 s38Var5 = this.u;
        if (t38Var == null) {
            z6 = false;
        } else {
            z6 = t38Var.f;
        }
        s38Var5.G(z6);
        s38 s38Var6 = this.u;
        if (t38Var != null) {
            z16 = t38Var.c;
        }
        s38Var6.S(z16);
        s38 s38Var7 = this.u;
        if (t38Var == null) {
            z7 = false;
        } else {
            z7 = t38Var.k;
        }
        s38Var7.P(z7);
        s38 s38Var8 = this.u;
        if (t38Var == null) {
            z8 = false;
        } else {
            z8 = t38Var.l;
        }
        s38Var8.H(z8, t38Var.t);
        if (t38Var == null) {
            this.u.N(false, false);
            this.u.M(false, false);
        } else {
            this.u.N(t38Var.g, t38Var.s);
            this.u.M(t38Var.h, t38Var.r);
        }
        if (t38Var == null) {
            z9 = false;
        } else {
            z9 = t38Var.q;
        }
        if (t38Var == null) {
            z10 = false;
        } else {
            z10 = t38Var.o;
        }
        if (t38Var == null) {
            z11 = false;
        } else {
            z11 = t38Var.d;
        }
        if (t38Var == null) {
            z12 = false;
        } else {
            z12 = t38Var.b;
        }
        if (t38Var == null) {
            z13 = false;
        } else {
            z13 = t38Var.p;
        }
        if (t38Var == null) {
            z14 = false;
        } else {
            z14 = t38Var.j;
        }
        if (t38Var == null) {
            z15 = false;
        } else {
            z15 = t38Var.m;
        }
        this.u.J(z11, z10);
        this.u.R(z12, z9);
        this.u.O(z14, z13);
        this.u.U(z15);
        if (t38Var != null) {
            s38 s38Var9 = this.u;
            boolean z18 = t38Var.u;
            s38Var9.w = z18;
            if (z18) {
                s38Var9.m().setText(R.string.report_text);
                this.u.G(false);
            }
        }
        s38 s38Var10 = this.u;
        if (t38Var != null) {
            z17 = t38Var.v;
        }
        s38Var10.E(z17);
        if (!TbSingleton.getInstance().mCanCallFans && this.a.M() != null && this.a.M().l1() != null && this.a.M().l1().S() != null && this.a.M().l1().S().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.k().setText(R.string.have_called_fans_short);
        }
        O0();
    }

    public void f0(ArrayList<it4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, arrayList) == null) {
            if (this.i == null) {
                this.i = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().k(this.i);
            if (this.g == null) {
                Dialog dialog = new Dialog(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003a9);
                this.g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.g.setCancelable(true);
                this.o = (ScrollView) this.i.findViewById(R.id.good_scroll);
                this.g.setContentView(this.i);
                WindowManager.LayoutParams attributes = this.g.getWindow().getAttributes();
                attributes.width = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702db);
                this.g.getWindow().setAttributes(attributes);
                this.p = new t(this);
                this.j = (LinearLayout) this.i.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.i.findViewById(R.id.dialog_button_cancel);
                this.l = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.i.findViewById(R.id.dialog_button_ok);
                this.k = textView2;
                textView2.setOnClickListener(this.a.U3());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.a.getPageContext().getString(R.string.thread_good_class));
            this.m.add(D);
            D.setChecked(true);
            this.j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    it4 it4Var = arrayList.get(i2);
                    if (it4Var != null && !TextUtils.isEmpty(it4Var.b()) && it4Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(it4Var.a()), it4Var.b());
                        this.m.add(D2);
                        View view2 = new View(this.a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.j.addView(view2);
                        this.j.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size != 0 && size != 1) {
                    if (size != 2) {
                        layoutParams2.height = yi.d(this.a.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = yi.d(this.a.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = yi.d(this.a.getPageContext().getPageActivity(), 120.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.j);
                }
            }
            ch.j(this.g, this.a.getPageContext());
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            lv4 lv4Var = this.e;
            if (lv4Var != null) {
                lv4Var.dismiss();
            }
            Dialog dialog = this.f;
            if (dialog != null) {
                ch.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.g;
            if (dialog2 != null) {
                ch.b(dialog2, this.a.getPageContext());
            }
            uv4 uv4Var = this.q;
            if (uv4Var != null) {
                uv4Var.dismiss();
            }
        }
    }

    public AntiData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.a.M() != null && this.a.M().l1() != null) {
                return this.a.M().l1().d();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    public final boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.M().l1().l().getDeletedReasonInfo() == null || 1 != this.a.M().l1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void L0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            if (str == null) {
                str = "";
            }
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment != null && absVideoPbFragment.getPageContext() != null) {
                lv4 lv4Var = new lv4(this.a.getPageContext().getPageActivity());
                lv4Var.setMessage(str);
                lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a07, new p(this));
                lv4Var.create(this.a.getPageContext()).show();
            }
        }
    }

    public final void M0(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                C0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            lv4 lv4Var = new lv4(this.a.getBaseFragmentActivity());
            if (!xi.isEmpty(str)) {
                lv4Var.setMessage(str);
            } else {
                lv4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
            }
            lv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0446, new q(this, userMuteAddAndDelCustomMessage));
            lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037c, new r(this));
            lv4Var.create(this.a.getPageContext()).show();
        }
    }

    public void T(boolean z2, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
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
            M0(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048612, this) != null) || this.s != null) {
            return;
        }
        this.s = new nv4(this.a.getPageContext().getPageActivity());
        String[] strArr = {this.a.getPageContext().getString(R.string.call_phone), this.a.getPageContext().getString(R.string.sms_phone), this.a.getPageContext().getString(R.string.search_in_baidu)};
        nv4 nv4Var = this.s;
        nv4Var.j(strArr, new l(this));
        nv4Var.g(nv4.b.a);
        nv4Var.h(17);
        nv4Var.c(this.a.getPageContext());
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
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
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
            this.e = new lv4(this.a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.e.setMessageId(i4);
            } else {
                this.e.setOnlyMessageShowCenter(false);
                this.e.setMessage(str2);
            }
            this.e.setYesButtonTag(sparseArray);
            this.e.setPositiveButton(R.string.obfuscated_res_0x7f0f0509, new b(this));
            this.e.setNegativeButton(R.string.obfuscated_res_0x7f0f0501, new c(this));
            this.e.setCancelable(true);
            this.e.create(this.a.getPageContext());
            if (z3) {
                w0(sparseArray, i5, i4);
            } else if (z2) {
                w0(sparseArray, i5, i4);
            } else if (r0()) {
                qq5 qq5Var = new qq5(this.a.M().l1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.M().l1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.M().l1().o().has_forum_rule.intValue());
                qq5Var.i(this.a.M().l1().l().getId(), this.a.M().l1().l().getName());
                qq5Var.h(this.a.M().l1().l().getImage_url());
                qq5Var.j(this.a.M().l1().l().getUser_level());
                D0(sparseArray, i2, qq5Var, this.a.M().l1().X(), false);
            } else {
                J0(this.e, i2);
            }
        }
    }

    public void j0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(P, Integer.valueOf(Q));
            if (z2) {
                s0(sparseArray);
            } else {
                t0(i2, sparseArray);
            }
        }
    }

    public void k0(SparseArray<Object> sparseArray, boolean z2) {
        int i2;
        sv4 sv4Var;
        sv4 sv4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048626, this, sparseArray, z2) == null) {
            wv4 wv4Var = new wv4(this.a.getContext());
            wv4Var.q(this.a.getString(R.string.obfuscated_res_0x7f0f02ee));
            wv4Var.n(new j(this, z2));
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
                    sv4Var2 = new sv4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04ce), wv4Var);
                } else {
                    sv4Var2 = new sv4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04c1), wv4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sv4Var2.d.setTag(sparseArray2);
                arrayList.add(sv4Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                sv4 sv4Var3 = new sv4(13, this.a.getString(R.string.multi_delete), wv4Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sv4Var3.d.setTag(sparseArray3);
                arrayList.add(sv4Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                sv4 sv4Var4 = new sv4(11, this.a.getString(R.string.forbidden_person), wv4Var);
                sv4Var4.d.setTag(sparseArray4);
                arrayList.add(sv4Var4);
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
                    sv4Var = new sv4(12, this.a.getString(R.string.un_mute), wv4Var);
                } else {
                    sv4Var = new sv4(12, this.a.getString(R.string.obfuscated_res_0x7f0f0b9d), wv4Var);
                }
                sv4Var.d.setTag(sparseArray5);
                arrayList.add(sv4Var);
            }
            f68.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                wv4Var.k(arrayList, false);
            } else {
                wv4Var.k(arrayList, true);
            }
            uv4 uv4Var = this.q;
            if (uv4Var == null) {
                this.q = new uv4(this.a.getPageContext(), wv4Var);
            } else {
                uv4Var.h(wv4Var);
            }
            this.q.k();
        }
    }

    public void m0() {
        AbsVideoPbFragment absVideoPbFragment;
        h08 l1;
        ThreadData Q2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && (absVideoPbFragment = this.a) != null && absVideoPbFragment.M() != null && this.a.M().l1() != null && (Q2 = (l1 = this.a.M().l1()).Q()) != null && Q2.getAuthor() != null) {
            this.a.k4();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), Q2.getAuthor().getUserId());
            t38 t38Var = new t38();
            int Y = this.a.M().l1().Y();
            boolean z6 = true;
            if (Y != 1 && Y != 3) {
                t38Var.g = false;
            } else {
                t38Var.g = true;
                if (Q2.getIs_top() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                t38Var.s = z2;
            }
            if (Z(Y)) {
                t38Var.h = true;
                if (Q2.getIs_good() == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                t38Var.r = z5;
            } else {
                t38Var.h = false;
            }
            if (Y == 1002 && !equals) {
                t38Var.u = true;
            }
            t38Var.n = z0(Q2.isBlocked(), l1.o0(), equals, Y, Q2.isWorksInfo(), Q2.isScoreThread());
            t38Var.e = v0(equals, l1.o0());
            t38Var.i = A0();
            t38Var.f = y0(equals);
            if (equals && l1.X() != null && l1.X().showPbPrivate()) {
                z3 = true;
            } else {
                z3 = false;
            }
            t38Var.k = z3;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                t38Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            t38Var.t = equals;
            t38Var.q = this.a.M().D1();
            t38Var.b = true;
            t38Var.a = b0(equals);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            t38Var.p = z4;
            t38Var.j = true;
            t38Var.o = this.a.M().O0();
            t38Var.d = true;
            if (Q2.getThreadVideoInfo() == null) {
                t38Var.c = true;
            } else {
                t38Var.c = false;
            }
            if (l1.l0()) {
                t38Var.b = false;
                t38Var.d = false;
                t38Var.c = false;
                t38Var.g = false;
                t38Var.h = false;
            }
            t38Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !l1.l0()) ? false : false;
            AbsVideoPbFragment absVideoPbFragment2 = this.a;
            if (absVideoPbFragment2.P3(absVideoPbFragment2.M().l1()) != null) {
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                t38Var.w = absVideoPbFragment3.P3(absVideoPbFragment3.M().l1()).S;
            }
            if (Q2.isBlocked()) {
                t38Var.n = false;
                t38Var.g = false;
                t38Var.h = false;
            }
            I0(t38Var);
        }
    }

    public final void u0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            f68.e(this.a.getActivity(), this.a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final void w0(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048638, this, sparseArray, i2, i3) != null) || this.a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04c1, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f037c, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.R());
        tBAlertBuilder.v(i2);
        tBAlertBuilder.m(i3);
        tBAlertBuilder.o(true);
        tBAlertBuilder.t(aVar2, aVar);
        tBAlertBuilder.j(false);
        androidx.appcompat.app.AlertDialog y2 = tBAlertBuilder.y();
        aVar.a(new d(this, y2, sparseArray));
        aVar2.a(new e(this, y2));
    }

    public void x0(SparseArray<Object> sparseArray) {
        AbsVideoPbFragment absVideoPbFragment;
        PostData postData;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        String str;
        boolean z8;
        sv4 sv4Var;
        sv4 sv4Var2;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048639, this, sparseArray) != null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.M() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        if (this.c == null) {
            wv4 wv4Var = new wv4(this.a.getContext());
            this.c = wv4Var;
            wv4Var.n(this.M);
        }
        ArrayList arrayList = new ArrayList();
        if (this.a.M().l1() != null && this.a.M().l1().l0()) {
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
            sv4 sv4Var3 = null;
            if (sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String) {
                str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
            } else {
                str = null;
            }
            if (postData.p() != null) {
                boolean z9 = postData.p().hasAgree;
                int q2 = postData.q();
                if (z9 && q2 == 5) {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.action_cancel_dislike;
                } else {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.action_dislike;
                }
                sv4 sv4Var4 = new sv4(8, absVideoPbFragment2.getString(i2), this.c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_clip_board, postData);
                sv4Var4.d.setTag(sparseArray2);
                arrayList.add(sv4Var4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!z5 && z4) {
                    sv4 sv4Var5 = new sv4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0ba1), this.c);
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
                    sv4Var5.d.setTag(sparseArray3);
                    arrayList.add(sv4Var5);
                } else {
                    if (b0(z3) && TbadkCoreApplication.isLogin()) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z8 && !z2) {
                        sv4 sv4Var6 = new sv4(5, this.a.getString(R.string.report_text), this.c);
                        sv4Var6.d.setTag(str);
                        arrayList.add(sv4Var6);
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
                        sv4 sv4Var7 = new sv4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04c1), this.c);
                        sv4Var7.d.setTag(sparseArray4);
                        sv4Var3 = sv4Var7;
                    } else {
                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    sv4 sv4Var8 = new sv4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02ee), this.c);
                    sv4Var8.d.setTag(sparseArray4);
                    sv4Var2 = sv4Var8;
                    sv4Var = sv4Var3;
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
                    if (this.a.M().l1().Y() == 1002 && !z3) {
                        sv4Var = new sv4(6, this.a.getString(R.string.report_text), this.c);
                    } else {
                        sv4Var = new sv4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04c1), this.c);
                    }
                    sv4Var.d.setTag(sparseArray5);
                    sv4Var2 = null;
                } else {
                    sv4Var = null;
                    sv4Var2 = null;
                }
                if (sv4Var != null) {
                    arrayList.add(sv4Var);
                }
                if (sv4Var2 != null) {
                    arrayList.add(sv4Var2);
                }
                if (!z3) {
                    arrayList.add(new sv4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f032a), this.c));
                }
            }
            this.c.j(arrayList);
            uv4 uv4Var = new uv4(this.a.getPageContext(), this.c);
            this.b = uv4Var;
            uv4Var.k();
        }
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
            if (!z3 || (!z4 && !a0(i2))) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
