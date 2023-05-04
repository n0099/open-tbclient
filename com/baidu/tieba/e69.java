package com.baidu.tieba;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.flow.data.ApkDownloadInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.personCenter.view.AutoDownloadBannerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class e69 extends kh6<w59> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public RelativeLayout j;
    public TextView k;
    public AutoDownloadBannerView l;
    public List<ApkDownloadInfoData> m;
    public nr5 n;
    public TbPageContext<?> o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public long r;
    public o35<ApkDownloadInfoData> s;
    public d t;

    @Override // com.baidu.tieba.kh6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.obfuscated_res_0x7f0d0764 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e69 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e69 e69Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e69Var, Integer.valueOf(i)};
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
            this.a = e69Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921742 && this.a.l != null && this.a.l.getCoverFlowView() != null) {
                this.a.l.getCoverFlowView().x();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e69 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e69 e69Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e69Var, Integer.valueOf(i)};
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
            this.a = e69Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<ApkDownloadInfoData> list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (!(data instanceof Intent)) {
                    return;
                }
                String z = this.a.z((Intent) data);
                if (!TextUtils.isEmpty(z) && (list = this.a.m) != null && list.size() != 0) {
                    Iterator<ApkDownloadInfoData> it = this.a.m.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ApkDownloadInfoData next = it.next();
                        if (next != null && next.getApkPackageName() != null && next.getApkPackageName().equals(z) && this.a.n != null && next.getmApkPath() != null && !TextUtils.isEmpty(next.getmApkPath().getAbsolutePath())) {
                            this.a.n.a(next.getmApkPath().getAbsolutePath());
                            break;
                        }
                    }
                    this.a.C(z);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements o35<ApkDownloadInfoData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e69 a;

        public c(e69 e69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e69Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o35
        /* renamed from: c */
        public void a(int i, boolean z, ApkDownloadInfoData apkDownloadInfoData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), apkDownloadInfoData}) == null) && this.a.l != null && apkDownloadInfoData != null && this.a.l.a(i)) {
                if (z) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = apkDownloadInfoData.getApkPackageName();
                    this.a.t.removeMessages(1);
                    this.a.t.sendMessageDelayed(obtain, 300L);
                }
                if (System.currentTimeMillis() - this.a.r >= 500) {
                    this.a.r = System.currentTimeMillis();
                    List<ApkDownloadInfoData> list = this.a.m;
                    if (list != null && list.size() == 1) {
                        i = 1;
                    }
                    TiebaStatic.log(new StatisticItem("c14966").param("obj_source", apkDownloadInfoData.getmApkName()).param("obj_param1", i));
                    ClogBuilder v = new ClogBuilder().y(ClogBuilder.LogType.FREE_SHOW).v(nr5.f);
                    if (apkDownloadInfoData.getAdDownloadBean() != null && apkDownloadInfoData.getAdDownloadBean().p != null && !TextUtils.isEmpty(apkDownloadInfoData.getAdDownloadBean().p.a)) {
                        v.p(apkDownloadInfoData.getAdDownloadBean().p.a);
                    }
                    o11.b(v);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o35
        /* renamed from: d */
        public void b(int i, ApkDownloadInfoData apkDownloadInfoData, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), apkDownloadInfoData, Boolean.valueOf(z)}) == null) && apkDownloadInfoData != null && !TextUtils.isEmpty(apkDownloadInfoData.getApkPackageName()) && apkDownloadInfoData.getmApkPath() != null && !TextUtils.isEmpty(apkDownloadInfoData.getmApkPath().getAbsolutePath()) && this.a.l.a(i)) {
                this.a.n.r(apkDownloadInfoData.getApkPackageName(), false);
                this.a.l.getCoverFlowView().x();
                if (this.a.n.j(apkDownloadInfoData.getApkPackageName())) {
                    ii.P(this.a.c, R.string.person_page_apk_installd);
                    this.a.C(apkDownloadInfoData.getApkPackageName());
                } else if (!this.a.n.i(apkDownloadInfoData.getmApkPath().getAbsolutePath())) {
                    ii.P(this.a.c, R.string.person_page_apk_delete);
                    this.a.C(apkDownloadInfoData.getApkPackageName());
                } else {
                    this.a.n.h(apkDownloadInfoData.getmApkPath().getAbsolutePath());
                    List<ApkDownloadInfoData> list = this.a.m;
                    int i2 = 1;
                    if (list != null && list.size() == 1) {
                        i = 1;
                    }
                    if (!z) {
                        i2 = 2;
                    }
                    TiebaStatic.log(new StatisticItem("c14967").param("obj_source", apkDownloadInfoData.getmApkName()).param("obj_param1", i).param("obj_type", i2));
                    ClogBuilder v = new ClogBuilder().y(ClogBuilder.LogType.FREE_CLICK).v(nr5.f);
                    if (z) {
                        v.i(ClogBuilder.Area.INSTALL_NOW_BUTTON);
                    } else {
                        v.i(ClogBuilder.Area.HOTAREA);
                    }
                    if (apkDownloadInfoData.getAdDownloadBean() != null && apkDownloadInfoData.getAdDownloadBean().p != null && !TextUtils.isEmpty(apkDownloadInfoData.getAdDownloadBean().p.a)) {
                        v.p(apkDownloadInfoData.getAdDownloadBean().p.a);
                    }
                    o11.b(v);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e69 a;

        public d(e69 e69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e69Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 1) {
                    this.a.n.r((String) message.obj, false);
                    this.a.l.getCoverFlowView().x();
                }
            }
        }

        public /* synthetic */ d(e69 e69Var, a aVar) {
            this(e69Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e69(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new ArrayList();
        this.p = new a(this, 2921742);
        this.q = new b(this, 2002501);
        this.r = -1L;
        this.s = new c(this);
        this.t = new d(this, null);
        this.o = tbPageContext;
        this.i = h();
        int g = ii.g(this.c, R.dimen.M_W_X003);
        this.i.setPadding(g, 0, g, 0);
        this.j = (RelativeLayout) this.i.findViewById(R.id.rl_viewpager_download);
        this.k = (TextView) this.i.findViewById(R.id.tv_title);
        AutoDownloadBannerView autoDownloadBannerView = (AutoDownloadBannerView) this.i.findViewById(R.id.obfuscated_res_0x7f091a6c);
        this.l = autoDownloadBannerView;
        autoDownloadBannerView.getCoverFlowView().setCallback(this.s);
        this.n = nr5.c();
        this.o.registerListener(this.q);
        this.o.registerListener(this.p);
    }

    public final String z(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent)) == null) {
            String dataString = intent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                return null;
            }
            String[] split = dataString.split(":");
            if (split != null && split.length == 2) {
                return split[1];
            }
            return dataString;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kh6
    /* renamed from: A */
    public void i(w59 w59Var) {
        List<ApkDownloadInfoData> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, w59Var) == null) {
            j(this.b, TbadkCoreApplication.getInst().getSkinType());
            if (this.j != null && w59Var != null && (list = w59Var.b) != null && this.l != null && list.size() != 0) {
                List<ApkDownloadInfoData> list2 = w59Var.b;
                this.m = list2;
                this.l.c(list2);
                return;
            }
            this.i.setVisibility(8);
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            for (ApkDownloadInfoData apkDownloadInfoData : this.m) {
                if (apkDownloadInfoData.getApkPackageName().equals(str)) {
                    this.m.remove(apkDownloadInfoData);
                    this.n.l(str);
                    this.l.getCoverFlowView().y(this.m);
                    return;
                }
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            nr5 nr5Var = this.n;
            if (nr5Var != null && nr5Var.d()) {
                this.l.getCoverFlowView().u();
            } else {
                D();
            }
        }
    }

    public void D() {
        AutoDownloadBannerView autoDownloadBannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (autoDownloadBannerView = this.l) != null) {
            autoDownloadBannerView.e();
        }
    }

    @Override // com.baidu.tieba.kh6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i) == null) && this.a != i) {
            AutoDownloadBannerView autoDownloadBannerView = this.l;
            if (autoDownloadBannerView != null) {
                autoDownloadBannerView.d(i);
            }
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            g35 d2 = g35.d(this.j);
            d2.o(R.string.J_X06);
            d2.f(R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
            this.a = i;
        }
    }
}
