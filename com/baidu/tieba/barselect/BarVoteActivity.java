package com.baidu.tieba.barselect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.BarVoteModel;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes21.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel hKk = null;
    private com.baidu.tieba.barselect.a hKl = null;
    BarVoteModel.a hKm = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.hKl != null && BarVoteActivity.this.hKl.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.hKl.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.ckL() == null || fVar.ckL().getStatus() < 1 || fVar.ckL().getStatus() > 2) {
                        if (BarVoteActivity.this.hKk != null && BarVoteActivity.this.hKk.mPn == 0) {
                            if (BarVoteActivity.this.hKl.getListView() != null) {
                                BarVoteActivity.this.hKl.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.ckL() == null) {
                                BarVoteActivity.this.hKl.IC(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.ckL().getStatus() < 1 || fVar.ckL().getStatus() > 2) {
                                BarVoteActivity.this.hKl.IC(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.hKl.getListView() != null) {
                        BarVoteActivity.this.hKl.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.hKl.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.hKk != null && BarVoteActivity.this.hKk.mPn == 0) {
                        if (BarVoteActivity.this.hKl.getListView() != null) {
                            BarVoteActivity.this.hKl.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.hKl.IC(str);
                    }
                } else if (BarVoteActivity.this.hKk != null && BarVoteActivity.this.hKk.mPn == 0) {
                    if (BarVoteActivity.this.hKl.getListView() != null) {
                        BarVoteActivity.this.hKl.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.hKl.IC(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hKl = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.hKk = new BarVoteModel(this);
        this.hKk.a(this.hKm);
        this.hKl.f(new a());
        new aq("c13440").aj("obj_source", this.source).boK();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new aq("c13440").aj("obj_source", this.source).boK();
    }

    public void ckj() {
        if (this.hKk != null) {
            this.hKk.bMi();
        }
    }

    public void reload() {
        if (this.hKk != null) {
            this.hKk.refresh();
        }
    }

    public void refresh() {
        if (this.hKk != null) {
            this.hKk.ckr();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            be.boR().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.hKl != null && this.hKl.ckt() != null) {
                this.hKl.ckt().showLoading();
            }
            ckj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hKl != null) {
            this.hKl.uu(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hKl != null) {
            this.hKl.onDestroy();
        }
        if (this.hKk != null) {
            this.hKk.onDestroy();
        }
        super.onDestroy();
    }

    public void bMA() {
        this.hKl.bMA();
    }

    /* loaded from: classes21.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.hKl.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.hKl.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
