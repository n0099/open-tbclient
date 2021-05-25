package com.baidu.tieba.barselect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.BarVoteModel;
import d.a.c.e.p.l;
import d.a.n0.x.b.f;
/* loaded from: classes4.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    public BarVoteModel mModel = null;
    public d.a.n0.x.a mView = null;
    public BarVoteModel.c mCallBack = new a();

    /* loaded from: classes4.dex */
    public class a implements BarVoteModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.barselect.BarVoteModel.c
        public void a(int i2, String str, f fVar) {
            if (BarVoteActivity.this.mView == null || BarVoteActivity.this.mView.w() == null) {
                return;
            }
            BarVoteActivity barVoteActivity = BarVoteActivity.this;
            barVoteActivity.hideLoadingView(barVoteActivity.mView.w());
            if (i2 != 0) {
                if (i2 == 2430005) {
                    if (BarVoteActivity.this.mModel == null || BarVoteActivity.this.mModel.mPn != 0) {
                        return;
                    }
                    if (BarVoteActivity.this.mView.u() != null) {
                        BarVoteActivity.this.mView.u().setVisibility(8);
                    }
                    BarVoteActivity.this.mView.F(str);
                } else if (BarVoteActivity.this.mModel == null || BarVoteActivity.this.mModel.mPn != 0) {
                } else {
                    if (BarVoteActivity.this.mView.u() != null) {
                        BarVoteActivity.this.mView.u().setVisibility(8);
                    }
                    BarVoteActivity.this.mView.F(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            } else if (fVar == null || fVar.a() == null || fVar.a().g() < 1 || fVar.a().g() > 2) {
                if (BarVoteActivity.this.mModel == null || BarVoteActivity.this.mModel.mPn != 0) {
                    return;
                }
                if (BarVoteActivity.this.mView.u() != null) {
                    BarVoteActivity.this.mView.u().setVisibility(8);
                }
                if (fVar == null || fVar.a() == null) {
                    BarVoteActivity.this.mView.F(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                } else if (fVar.a().g() < 1 || fVar.a().g() > 2) {
                    BarVoteActivity.this.mView.F(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            } else {
                if (BarVoteActivity.this.mView.u() != null) {
                    BarVoteActivity.this.mView.u().setVisibility(0);
                }
                long j = BarVoteActivity.this.fid;
                if (j != 0) {
                    fVar.i(j);
                }
                if (fVar.g() == null) {
                    fVar.l(BarVoteActivity.this.mPageId);
                }
                BarVoteActivity.this.mView.C(fVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.D()) {
                BarVoteActivity.this.mView.x();
                BarVoteActivity barVoteActivity = BarVoteActivity.this;
                barVoteActivity.showLoadingView(barVoteActivity.mView.w());
                BarVoteActivity.this.reload();
            }
        }
    }

    public void loadmore() {
        BarVoteModel barVoteModel = this.mModel;
        if (barVoteModel != null) {
            barVoteModel.w();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.n0.x.a aVar = this.mView;
        if (aVar != null) {
            aVar.z(i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            d.a.n0.x.a aVar = this.mView;
            if (aVar != null && aVar.v() != null) {
                this.mView.v().L();
            }
            loadmore();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mView = new d.a.n0.x.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        BarVoteModel barVoteModel = new BarVoteModel(this);
        this.mModel = barVoteModel;
        barVoteModel.z(this.mCallBack);
        this.mView.D(new b());
        new StatisticItem(TbadkCoreStatisticKey.KEY_VOTE_PAGE).param("obj_source", this.source).eventStat();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        d.a.n0.x.a aVar = this.mView;
        if (aVar != null) {
            aVar.y();
        }
        BarVoteModel barVoteModel = this.mModel;
        if (barVoteModel != null) {
            barVoteModel.onDestroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new StatisticItem(TbadkCoreStatisticKey.KEY_VOTE_PAGE).param("obj_source", this.source).eventStat();
    }

    public void refresh() {
        BarVoteModel barVoteModel = this.mModel;
        if (barVoteModel != null) {
            barVoteModel.A();
        }
    }

    public void reload() {
        BarVoteModel barVoteModel = this.mModel;
        if (barVoteModel != null) {
            barVoteModel.x();
        }
    }

    public void showNetRefreshView() {
        this.mView.E();
    }
}
