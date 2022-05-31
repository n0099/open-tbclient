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
import com.repackage.li;
import com.repackage.mu5;
import com.repackage.su5;
/* loaded from: classes3.dex */
public class BarVoteActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long fid;
    public BarVoteModel.c mCallBack;
    public BarVoteModel mModel;
    public BdUniqueId mPageId;
    public mu5 mView;
    public int source;

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
        public void a(int i, String str, su5 su5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i, str, su5Var) == null) || this.a.mView == null || this.a.mView.w() == null) {
                return;
            }
            BarVoteActivity barVoteActivity = this.a;
            barVoteActivity.hideLoadingView(barVoteActivity.mView.w());
            if (i != 0) {
                if (i == 2430005) {
                    if (this.a.mModel == null || this.a.mModel.mPn != 0) {
                        return;
                    }
                    if (this.a.mView.u() != null) {
                        this.a.mView.u().setVisibility(8);
                    }
                    this.a.mView.F(str);
                } else if (this.a.mModel == null || this.a.mModel.mPn != 0) {
                } else {
                    if (this.a.mView.u() != null) {
                        this.a.mView.u().setVisibility(8);
                    }
                    this.a.mView.F(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f05a9));
                }
            } else if (su5Var == null || su5Var.a() == null || su5Var.a().g() < 1 || su5Var.a().g() > 2) {
                if (this.a.mModel == null || this.a.mModel.mPn != 0) {
                    return;
                }
                if (this.a.mView.u() != null) {
                    this.a.mView.u().setVisibility(8);
                }
                if (su5Var == null || su5Var.a() == null) {
                    this.a.mView.F(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c4d));
                } else if (su5Var.a().g() < 1 || su5Var.a().g() > 2) {
                    this.a.mView.F(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f05a9));
                }
            } else {
                if (this.a.mView.u() != null) {
                    this.a.mView.u().setVisibility(0);
                }
                long j = this.a.fid;
                if (j != 0) {
                    su5Var.i(j);
                }
                if (su5Var.g() == null) {
                    su5Var.l(this.a.mPageId);
                }
                this.a.mView.C(su5Var);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && li.D()) {
                this.a.mView.x();
                BarVoteActivity barVoteActivity = this.a;
                barVoteActivity.showLoadingView(barVoteActivity.mView.w());
                this.a.reload();
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
        this.mPageId = BdUniqueId.gen();
        this.mModel = null;
        this.mView = null;
        this.mCallBack = new a(this);
    }

    public void loadmore() {
        BarVoteModel barVoteModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (barVoteModel = this.mModel) == null) {
            return;
        }
        barVoteModel.loadMore();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            mu5 mu5Var = this.mView;
            if (mu5Var != null) {
                mu5Var.z(i);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091aa7) {
                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0916c3) {
                mu5 mu5Var = this.mView;
                if (mu5Var != null && mu5Var.v() != null) {
                    this.mView.v().N();
                }
                loadmore();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.mView = new mu5(this);
            this.fid = getIntent().getLongExtra("fid", 0L);
            this.source = getIntent().getIntExtra("source", 0);
            BarVoteModel barVoteModel = new BarVoteModel(this);
            this.mModel = barVoteModel;
            barVoteModel.D(this.mCallBack);
            this.mView.D(new b(this));
            new StatisticItem(TbadkCoreStatisticKey.KEY_VOTE_PAGE).param("obj_source", this.source).eventStat();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            mu5 mu5Var = this.mView;
            if (mu5Var != null) {
                mu5Var.y();
            }
            BarVoteModel barVoteModel = this.mModel;
            if (barVoteModel != null) {
                barVoteModel.onDestroy();
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, intent) == null) {
            super.onNewIntent(intent);
            setIntent(intent);
            this.fid = intent.getLongExtra("fid", 0L);
            this.source = intent.getIntExtra("source", 0);
            reload();
            new StatisticItem(TbadkCoreStatisticKey.KEY_VOTE_PAGE).param("obj_source", this.source).eventStat();
        }
    }

    public void refresh() {
        BarVoteModel barVoteModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (barVoteModel = this.mModel) == null) {
            return;
        }
        barVoteModel.E();
    }

    public void reload() {
        BarVoteModel barVoteModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (barVoteModel = this.mModel) == null) {
            return;
        }
        barVoteModel.refresh();
    }

    public void showNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mView.E();
        }
    }
}
