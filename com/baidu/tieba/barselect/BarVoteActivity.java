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
import d.a.c.e.p.l;
import d.a.s0.x.b.f;
/* loaded from: classes5.dex */
public class BarVoteActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long fid;
    public BarVoteModel.c mCallBack;
    public BarVoteModel mModel;
    public BdUniqueId mPageId;
    public d.a.s0.x.a mView;
    public int source;

    /* loaded from: classes5.dex */
    public class a implements BarVoteModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BarVoteActivity f14308a;

        public a(BarVoteActivity barVoteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {barVoteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14308a = barVoteActivity;
        }

        @Override // com.baidu.tieba.barselect.BarVoteModel.c
        public void a(int i2, String str, f fVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i2, str, fVar) == null) || this.f14308a.mView == null || this.f14308a.mView.w() == null) {
                return;
            }
            BarVoteActivity barVoteActivity = this.f14308a;
            barVoteActivity.hideLoadingView(barVoteActivity.mView.w());
            if (i2 != 0) {
                if (i2 == 2430005) {
                    if (this.f14308a.mModel == null || this.f14308a.mModel.mPn != 0) {
                        return;
                    }
                    if (this.f14308a.mView.u() != null) {
                        this.f14308a.mView.u().setVisibility(8);
                    }
                    this.f14308a.mView.F(str);
                } else if (this.f14308a.mModel == null || this.f14308a.mModel.mPn != 0) {
                } else {
                    if (this.f14308a.mView.u() != null) {
                        this.f14308a.mView.u().setVisibility(8);
                    }
                    this.f14308a.mView.F(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            } else if (fVar == null || fVar.a() == null || fVar.a().g() < 1 || fVar.a().g() > 2) {
                if (this.f14308a.mModel == null || this.f14308a.mModel.mPn != 0) {
                    return;
                }
                if (this.f14308a.mView.u() != null) {
                    this.f14308a.mView.u().setVisibility(8);
                }
                if (fVar == null || fVar.a() == null) {
                    this.f14308a.mView.F(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                } else if (fVar.a().g() < 1 || fVar.a().g() > 2) {
                    this.f14308a.mView.F(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            } else {
                if (this.f14308a.mView.u() != null) {
                    this.f14308a.mView.u().setVisibility(0);
                }
                long j = this.f14308a.fid;
                if (j != 0) {
                    fVar.i(j);
                }
                if (fVar.g() == null) {
                    fVar.l(this.f14308a.mPageId);
                }
                this.f14308a.mView.C(fVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BarVoteActivity f14309e;

        public b(BarVoteActivity barVoteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {barVoteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14309e = barVoteActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.D()) {
                this.f14309e.mView.x();
                BarVoteActivity barVoteActivity = this.f14309e;
                barVoteActivity.showLoadingView(barVoteActivity.mView.w());
                this.f14309e.reload();
            }
        }
    }

    public BarVoteActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.s0.x.a aVar = this.mView;
            if (aVar != null) {
                aVar.z(i2);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (view.getId() == R.id.right_textview) {
                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
            } else if (view.getId() == R.id.pb_more) {
                d.a.s0.x.a aVar = this.mView;
                if (aVar != null && aVar.v() != null) {
                    this.mView.v().L();
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
            this.mView = new d.a.s0.x.a(this);
            this.fid = getIntent().getLongExtra("fid", 0L);
            this.source = getIntent().getIntExtra("source", 0);
            BarVoteModel barVoteModel = new BarVoteModel(this);
            this.mModel = barVoteModel;
            barVoteModel.B(this.mCallBack);
            this.mView.D(new b(this));
            new StatisticItem(TbadkCoreStatisticKey.KEY_VOTE_PAGE).param("obj_source", this.source).eventStat();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.a.s0.x.a aVar = this.mView;
            if (aVar != null) {
                aVar.y();
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
        barVoteModel.C();
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
