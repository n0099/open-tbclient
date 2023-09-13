package com.baidu.tieba.barselect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.BarVoteModel;
import com.baidu.tieba.di6;
import com.baidu.tieba.ji6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BarVoteActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public BarVoteModel b;
    public di6 c;
    public long d;
    public int e;
    public BarVoteModel.c f;

    /* loaded from: classes5.dex */
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
        public void a(int i, String str, ji6 ji6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, ji6Var) == null) && this.a.c != null && this.a.c.w() != null) {
                BarVoteActivity barVoteActivity = this.a;
                barVoteActivity.hideLoadingView(barVoteActivity.c.w());
                if (i == 0) {
                    if (ji6Var != null && ji6Var.a() != null && ji6Var.a().h() >= 1 && ji6Var.a().h() <= 2) {
                        if (this.a.c.u() != null) {
                            this.a.c.u().setVisibility(0);
                        }
                        long j = this.a.d;
                        if (j != 0) {
                            ji6Var.i(j);
                        }
                        if (ji6Var.g() == null) {
                            ji6Var.l(this.a.a);
                        }
                        this.a.c.C(ji6Var);
                    } else if (this.a.b != null && this.a.b.mPn == 0) {
                        if (this.a.c.u() != null) {
                            this.a.c.u().setVisibility(8);
                        }
                        if (ji6Var != null && ji6Var.a() != null) {
                            if (ji6Var.a().h() < 1 || ji6Var.a().h() > 2) {
                                this.a.c.F(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            }
                            return;
                        }
                        this.a.c.F(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                    }
                } else if (i == 2430005) {
                    if (this.a.b != null && this.a.b.mPn == 0) {
                        if (this.a.c.u() != null) {
                            this.a.c.u().setVisibility(8);
                        }
                        this.a.c.F(str);
                    }
                } else if (this.a.b != null && this.a.b.mPn == 0) {
                    if (this.a.c.u() != null) {
                        this.a.c.u().setVisibility(8);
                    }
                    this.a.c.F(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdUtilHelper.isNetOk()) {
                this.a.c.x();
                BarVoteActivity barVoteActivity = this.a;
                barVoteActivity.showLoadingView(barVoteActivity.c.w());
                this.a.s1();
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

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            di6 di6Var = this.c;
            if (di6Var != null) {
                di6Var.z(i);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            if (view2.getId() == R.id.right_textview) {
                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"https://tiebac.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
            } else if (view2.getId() == R.id.pb_more) {
                di6 di6Var = this.c;
                if (di6Var != null && di6Var.v() != null) {
                    this.c.v().R();
                }
                q1();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            this.c = new di6(this);
            this.d = getIntent().getLongExtra("fid", 0L);
            this.e = getIntent().getIntExtra("source", 0);
            BarVoteModel barVoteModel = new BarVoteModel(this);
            this.b = barVoteModel;
            barVoteModel.R(this.f);
            this.c.D(new b(this));
            new StatisticItem(TbadkCoreStatisticKey.KEY_VOTE_PAGE).param("obj_source", this.e).eventStat();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            di6 di6Var = this.c;
            if (di6Var != null) {
                di6Var.y();
            }
            BarVoteModel barVoteModel = this.b;
            if (barVoteModel != null) {
                barVoteModel.onDestroy();
            }
            super.onDestroy();
        }
    }

    public void q1() {
        BarVoteModel barVoteModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (barVoteModel = this.b) != null) {
            barVoteModel.b();
        }
    }

    public void refresh() {
        BarVoteModel barVoteModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (barVoteModel = this.b) != null) {
            barVoteModel.S();
        }
    }

    public void s1() {
        BarVoteModel barVoteModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (barVoteModel = this.b) != null) {
            barVoteModel.refresh();
        }
    }

    public void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.c.E();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            super.onNewIntent(intent);
            setIntent(intent);
            this.d = intent.getLongExtra("fid", 0L);
            this.e = intent.getIntExtra("source", 0);
            s1();
            new StatisticItem(TbadkCoreStatisticKey.KEY_VOTE_PAGE).param("obj_source", this.e).eventStat();
        }
    }
}
