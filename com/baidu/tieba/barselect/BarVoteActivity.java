package com.baidu.tieba.barselect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.BarVoteModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ay5;
import com.repackage.gy5;
import com.repackage.qi;
/* loaded from: classes3.dex */
public class BarVoteActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public BarVoteModel b;
    public ay5 c;
    public long d;
    public int e;
    public BarVoteModel.c f;

    /* loaded from: classes3.dex */
    public class a implements BarVoteModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BarVoteActivity a;

        public a(BarVoteActivity barVoteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {barVoteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = barVoteActivity;
        }

        @Override // com.baidu.tieba.barselect.BarVoteModel.c
        public void a(int i, String str, gy5 gy5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i, str, gy5Var) == null) || this.a.c == null || this.a.c.w() == null) {
                return;
            }
            BarVoteActivity barVoteActivity = this.a;
            barVoteActivity.hideLoadingView(barVoteActivity.c.w());
            if (i != 0) {
                if (i == 2430005) {
                    if (this.a.b == null || this.a.b.mPn != 0) {
                        return;
                    }
                    if (this.a.c.u() != null) {
                        this.a.c.u().setVisibility(8);
                    }
                    this.a.c.F(str);
                } else if (this.a.b == null || this.a.b.mPn != 0) {
                } else {
                    if (this.a.c.u() != null) {
                        this.a.c.u().setVisibility(8);
                    }
                    this.a.c.F(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f05b1));
                }
            } else if (gy5Var == null || gy5Var.a() == null || gy5Var.a().h() < 1 || gy5Var.a().h() > 2) {
                if (this.a.b == null || this.a.b.mPn != 0) {
                    return;
                }
                if (this.a.c.u() != null) {
                    this.a.c.u().setVisibility(8);
                }
                if (gy5Var == null || gy5Var.a() == null) {
                    this.a.c.F(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c56));
                } else if (gy5Var.a().h() < 1 || gy5Var.a().h() > 2) {
                    this.a.c.F(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f05b1));
                }
            } else {
                if (this.a.c.u() != null) {
                    this.a.c.u().setVisibility(0);
                }
                long j = this.a.d;
                if (j != 0) {
                    gy5Var.i(j);
                }
                if (gy5Var.g() == null) {
                    gy5Var.l(this.a.a);
                }
                this.a.c.C(gy5Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BarVoteActivity a;

        public b(BarVoteActivity barVoteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {barVoteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = barVoteActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && qi.D()) {
                this.a.c.x();
                BarVoteActivity barVoteActivity = this.a;
                barVoteActivity.showLoadingView(barVoteActivity.c.w());
                this.a.C1();
            }
        }
    }

    public BarVoteActivity() {
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
        this.a = BdUniqueId.gen();
        this.b = null;
        this.c = null;
        this.f = new a(this);
    }

    public void B1() {
        BarVoteModel barVoteModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (barVoteModel = this.b) == null) {
            return;
        }
        barVoteModel.b();
    }

    public void C1() {
        BarVoteModel barVoteModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (barVoteModel = this.b) == null) {
            return;
        }
        barVoteModel.refresh();
    }

    public void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.E();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            ay5 ay5Var = this.c;
            if (ay5Var != null) {
                ay5Var.z(i);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091bf8) {
                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"https://tiebac.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091808) {
                ay5 ay5Var = this.c;
                if (ay5Var != null && ay5Var.v() != null) {
                    this.c.v().N();
                }
                B1();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            this.c = new ay5(this);
            this.d = getIntent().getLongExtra("fid", 0L);
            this.e = getIntent().getIntExtra("source", 0);
            BarVoteModel barVoteModel = new BarVoteModel(this);
            this.b = barVoteModel;
            barVoteModel.E(this.f);
            this.c.D(new b(this));
            new StatisticItem(TbadkCoreStatisticKey.KEY_VOTE_PAGE).param("obj_source", this.e).eventStat();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ay5 ay5Var = this.c;
            if (ay5Var != null) {
                ay5Var.y();
            }
            BarVoteModel barVoteModel = this.b;
            if (barVoteModel != null) {
                barVoteModel.onDestroy();
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, intent) == null) {
            super.onNewIntent(intent);
            setIntent(intent);
            this.d = intent.getLongExtra("fid", 0L);
            this.e = intent.getIntExtra("source", 0);
            C1();
            new StatisticItem(TbadkCoreStatisticKey.KEY_VOTE_PAGE).param("obj_source", this.e).eventStat();
        }
    }

    public void refresh() {
        BarVoteModel barVoteModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (barVoteModel = this.b) == null) {
            return;
        }
        barVoteModel.F();
    }
}
