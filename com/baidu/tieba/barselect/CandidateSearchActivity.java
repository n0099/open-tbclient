package com.baidu.tieba.barselect;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.model.CandidateSearchHttpResMsg;
import com.baidu.tieba.barselect.model.CandidateSearchSocketResMsg;
import com.baidu.tieba.bb;
import com.baidu.tieba.hy5;
import com.baidu.tieba.km8;
import com.baidu.tieba.pg;
import com.baidu.tieba.qi;
import com.baidu.tieba.ri;
import com.baidu.tieba.sg;
import com.baidu.tieba.sy5;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CandidateSearchActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public BdRecyclerView b;
    public CandidateSearchAdapter c;
    public sy5 d;
    public String e;
    public View f;
    public View g;
    public ImageView h;
    public EditText i;
    public ImageView j;
    public TextView k;
    public List<hy5> l;
    public View.OnClickListener m;
    public bb n;
    public TextView.OnEditorActionListener o;
    public HttpMessageListener p;
    public TextWatcher q;
    public Runnable r;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CandidateSearchActivity a;

        public a(CandidateSearchActivity candidateSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = candidateSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() != this.a.k.getId()) {
                    if (view2.getId() == this.a.j.getId()) {
                        this.a.i.setText("");
                        this.a.b.setVisibility(0);
                        this.a.f.setVisibility(8);
                        this.a.c.setData(new ArrayList());
                        return;
                    }
                    return;
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends bb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CandidateSearchActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CandidateSearchActivity candidateSearchActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchActivity, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = candidateSearchActivity;
        }

        @Override // com.baidu.tieba.bb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            hy5 hy5Var = null;
            if (responsedMessage instanceof CandidateSearchHttpResMsg) {
                hy5Var = ((CandidateSearchHttpResMsg) responsedMessage).candidateData;
            } else if (responsedMessage instanceof CandidateSearchSocketResMsg) {
                hy5Var = ((CandidateSearchSocketResMsg) responsedMessage).candidateData;
            }
            if (responsedMessage.getError() != 0 || hy5Var == null) {
                this.a.b.setVisibility(8);
                this.a.f.setVisibility(0);
                return;
            }
            this.a.b.setVisibility(0);
            this.a.f.setVisibility(8);
            if (this.a.i.getText() != null) {
                hy5Var.j = this.a.i.getText().toString();
            }
            if (this.a.l != null) {
                this.a.l.clear();
            } else {
                this.a.l = new ArrayList();
            }
            this.a.l.add(hy5Var);
            this.a.c.setData(this.a.l);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CandidateSearchActivity a;

        public c(CandidateSearchActivity candidateSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = candidateSearchActivity;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i == 3) {
                    if (this.a.i.getText() != null && !TextUtils.isEmpty(this.a.i.getText().toString()) && !TextUtils.isEmpty(this.a.e)) {
                        this.a.d.a(pg.e(this.a.i.getText().toString(), 0), pg.g(this.a.e, 0L));
                    }
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CandidateSearchActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(CandidateSearchActivity candidateSearchActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchActivity, Integer.valueOf(i)};
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
            this.a = candidateSearchActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            int error = httpResponsedMessage.getError();
            if (error == 0) {
                ri.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f02ec);
                if (this.a.l != null) {
                    for (hy5 hy5Var : this.a.l) {
                        hy5Var.k = true;
                    }
                }
            } else if (error == 3250023) {
                km8.b(error, "", null);
            } else if (error == 3250021) {
                if (httpResponsedMessage instanceof CommitVoteResMsg) {
                    km8.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), null);
                }
            } else if (error != 3250002 && error != 3250004) {
                ri.N(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
            } else {
                BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                blockPopInfoData.block_info = qi.isEmpty(httpResponsedMessage.getErrorString()) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0324) : httpResponsedMessage.getErrorString();
                blockPopInfoData.ahead_info = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0322);
                blockPopInfoData.ok_info = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09a4);
                blockPopInfoData.ahead_url = "https://tieba.baidu.com/mo/q/userappeal";
                AntiHelper.s(this.a, blockPopInfoData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CandidateSearchActivity a;

        public e(CandidateSearchActivity candidateSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = candidateSearchActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.K1(!StringUtils.isNull(editable.toString()));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CandidateSearchActivity a;

        public f(CandidateSearchActivity candidateSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = candidateSearchActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.i == null) {
                return;
            }
            this.a.i.requestFocus();
            CandidateSearchActivity candidateSearchActivity = this.a;
            ri.L(candidateSearchActivity, candidateSearchActivity.i);
        }
    }

    public CandidateSearchActivity() {
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
        this.m = new a(this);
        this.n = new b(this, CmdConfigHttp.CMD_CANDIDATE_SEARCH, 309641);
        this.o = new c(this);
        this.p = new d(this, CmdConfigHttp.CMD_BAR_VOTE);
        this.q = new e(this);
        this.r = new f(this);
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091626);
            this.a = navigationBar;
            navigationBar.showBottomLine();
            View addCustomView = this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.obfuscated_res_0x7f0d016f, (View.OnClickListener) null);
            this.g = addCustomView;
            this.h = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f091d90);
            this.i = (EditText) this.g.findViewById(R.id.obfuscated_res_0x7f090d6f);
            ImageView imageView = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f090d5f);
            this.j = imageView;
            imageView.setOnClickListener(this.m);
            this.k = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f090d5e);
            K1(false);
            this.k.setText(getString(R.string.obfuscated_res_0x7f0f0371));
            this.k.setOnClickListener(this.m);
            this.i.setOnEditorActionListener(this.o);
            this.i.addTextChangedListener(this.q);
        }
    }

    public void K1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.j.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.onChangeSkinType(getPageContext(), i);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0109, null);
            this.i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setNavbarTitleColor(this.i, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f0809c2, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0302, 1);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d002e);
            if (getIntent() != null) {
                this.e = getIntent().getStringExtra("forum_id");
            }
            J1();
            BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.obfuscated_res_0x7f091b76);
            this.b = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.f = findViewById(R.id.obfuscated_res_0x7f0920d4);
            CandidateSearchAdapter candidateSearchAdapter = new CandidateSearchAdapter();
            this.c = candidateSearchAdapter;
            this.b.setAdapter(candidateSearchAdapter);
            registerListener(this.n);
            registerListener(this.p);
            this.d = new sy5(getPageContext());
            sg.a().postDelayed(this.r, 100L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            sg.a().removeCallbacks(this.r);
        }
    }
}
