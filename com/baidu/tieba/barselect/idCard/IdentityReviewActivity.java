package com.baidu.tieba.barselect.idCard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.CommitCardInfoReqMsg;
import com.baidu.tieba.cn;
import com.baidu.tieba.ed6;
import com.baidu.tieba.fb;
import com.baidu.tieba.fd6;
import com.baidu.tieba.jd6;
import com.baidu.tieba.kg;
import com.baidu.tieba.lg;
import com.baidu.tieba.ri;
import com.baidu.tieba.sd6;
import com.baidu.tieba.ug;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes4.dex */
public class IdentityReviewActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fd6 a;
    public ed6 b;
    public long c;
    public boolean d;
    public String e;
    public String f;
    public View g;
    public NavigationBar h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TbImageView m;
    public TbImageView n;
    public TextView o;
    public TextView p;
    public sd6 q;
    public int r;
    public int s;
    public View.OnClickListener t;
    public kg<cn> u;
    public fb v;
    public HttpMessageListener w;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IdentityReviewActivity a;

        public a(IdentityReviewActivity identityReviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {identityReviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = identityReviewActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090ff5) {
                    IdentityReviewActivity identityReviewActivity = this.a;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(identityReviewActivity, identityReviewActivity.e, CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT, 101)));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ff3) {
                    IdentityReviewActivity identityReviewActivity2 = this.a;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921412, new CameraActivityConfig(identityReviewActivity2, identityReviewActivity2.f, CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK, 102)));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090462) {
                    IdentityReviewActivity identityReviewActivity3 = this.a;
                    new jd6(identityReviewActivity3.e, 1, identityReviewActivity3.a).execute(new Void[0]);
                    this.a.d = true;
                    this.a.q = new sd6(this.a);
                    this.a.q.setCancelable(true);
                    this.a.q.setCanceledOnTouchOutside(false);
                    this.a.q.setMessage(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f041a));
                    ug.i(this.a.q, this.a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends kg<cn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IdentityReviewActivity a;

        public b(IdentityReviewActivity identityReviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {identityReviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = identityReviewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg
        public void onLoaded(cn cnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, cnVar, str, i) == null) {
                super.onLoaded((b) cnVar, str, i);
                if (str != null && cnVar != null) {
                    if (str.equals(this.a.e)) {
                        cnVar.h(this.a.m);
                        this.a.o.setVisibility(0);
                    } else if (str.equals(this.a.f)) {
                        cnVar.h(this.a.n);
                        this.a.p.setVisibility(0);
                    }
                }
                if (str != null) {
                    TbImageMemoryCache u = TbImageMemoryCache.u();
                    u.r(str + 32);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends fb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IdentityReviewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(IdentityReviewActivity identityReviewActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {identityReviewActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = identityReviewActivity;
        }

        @Override // com.baidu.tieba.fb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                int error = responsedMessage.getError();
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof CommitCardInfoReqMsg) {
                    if (error == 0) {
                        int i = ((CommitCardInfoReqMsg) extra).card_type;
                        if (i == 1) {
                            this.a.r = 2;
                        } else if (i == 2) {
                            this.a.s = 2;
                        }
                        if (this.a.r >= 2 && this.a.s >= 2) {
                            if (this.a.b != null) {
                                this.a.b.a(this.a.c);
                            } else if (this.a.q != null) {
                                ug.a(this.a.q, this.a);
                            }
                        } else if (this.a.s == 1) {
                            if (this.a.a != null) {
                                IdentityReviewActivity identityReviewActivity = this.a;
                                new jd6(identityReviewActivity.f, 2, identityReviewActivity.a).execute(new Void[0]);
                            } else if (this.a.q != null) {
                                ug.a(this.a.q, this.a);
                            }
                        }
                    } else if (error == -100000303 && this.a.d) {
                        this.a.r = 1;
                        this.a.s = 1;
                        if (this.a.a != null) {
                            this.a.d = false;
                            IdentityReviewActivity identityReviewActivity2 = this.a;
                            new jd6(identityReviewActivity2.e, 1, identityReviewActivity2.a).execute(new Void[0]);
                        }
                    } else {
                        if (this.a.q != null && this.a.q.isShowing()) {
                            ug.a(this.a.q, this.a);
                        }
                        ri.N(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                        this.a.r = 1;
                        this.a.s = 1;
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IdentityReviewActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(IdentityReviewActivity identityReviewActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {identityReviewActivity, Integer.valueOf(i)};
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
            this.a = identityReviewActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if (this.a.q != null && this.a.q.isShowing()) {
                    ug.a(this.a.q, this.a);
                }
                String str = "https://tieba.baidu.com/mo/q/newmanagerapplyresult?passIDCert=1&nomenu=1&forum_id=" + this.a.c;
                if (error == 0) {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str});
                    this.a.setResult(-1);
                    this.a.finish();
                    return;
                }
                ri.N(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                this.a.r = 1;
                this.a.s = 1;
            }
        }
    }

    public IdentityReviewActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.r = 0;
        this.s = 0;
        this.t = new a(this);
        this.u = new b(this);
        this.v = new c(this, CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643);
        this.w = new d(this, CmdConfigHttp.CMD_CHECK_CARD_INFO);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                if (i == 101) {
                    lg.h().m(this.e, 32, this.u, getUniqueId());
                    this.r = 1;
                } else if (i == 102) {
                    lg.h().m(this.f, 32, this.u, getUniqueId());
                    this.s = 1;
                }
                TextView textView = this.i;
                if (textView != null) {
                    if (this.s >= 1 && this.r >= 1) {
                        textView.setEnabled(true);
                    } else {
                        this.i.setEnabled(false);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            NavigationBar navigationBar = this.h;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i);
            }
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0101, 1, i);
            SkinManager.setBackgroundResource(this.i, R.drawable.bg_id_card_button, i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1, i);
            int g = ri.g(this, R.dimen.tbds10);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0101, 1, i);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0101, 1, i);
            SkinManager.setBackgroundShapeDrawable(this.o, g, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
            SkinManager.setBackgroundShapeDrawable(this.p, g, R.color.cp_cont_b_alpha42, R.color.cp_cont_b_alpha42, i);
            if (this.r < 1) {
                SkinManager.setImageResource(this.m, R.drawable.pic_id_front, i);
            }
            if (this.s < 1) {
                SkinManager.setImageResource(this.n, R.drawable.pic_id_back, i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0408);
            this.c = getIntent().getLongExtra("fid", 0L);
            this.a = new fd6(getPageContext());
            this.b = new ed6(getPageContext());
            this.e = new File(TbadkCoreApplication.getInst().getFilesDir(), "positive.jpg").getAbsolutePath();
            this.f = new File(TbadkCoreApplication.getInst().getFilesDir(), "negative.jpg").getAbsolutePath();
            this.g = findViewById(R.id.obfuscated_res_0x7f090fc7);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f090fe0);
            this.h = navigationBar;
            navigationBar.setCenterTextTitle(getResources().getString(R.string.obfuscated_res_0x7f0f031a));
            this.h.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090462);
            this.i = textView;
            textView.setEnabled(false);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff9);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f091c26);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f091852);
            this.m = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090ff5);
            this.n = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090ff3);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff6);
            this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff4);
            MessageManager.getInstance().registerListener(this.v);
            MessageManager.getInstance().registerListener(this.w);
            this.m.setOnClickListener(this.t);
            this.n.setOnClickListener(this.t);
            this.i.setOnClickListener(this.t);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.v);
            MessageManager.getInstance().unRegisterListener(this.w);
            sd6 sd6Var = this.q;
            if (sd6Var != null && sd6Var.isShowing()) {
                ug.a(this.q, this);
            }
            super.onDestroy();
        }
    }
}
