package com.baidu.tieba.barselect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.BarVoteModel;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes21.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel ibD = null;
    private com.baidu.tieba.barselect.a ibE = null;
    BarVoteModel.a ibF = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.ibE != null && BarVoteActivity.this.ibE.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.ibE.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.crd() == null || fVar.crd().getStatus() < 1 || fVar.crd().getStatus() > 2) {
                        if (BarVoteActivity.this.ibD != null && BarVoteActivity.this.ibD.mPn == 0) {
                            if (BarVoteActivity.this.ibE.getListView() != null) {
                                BarVoteActivity.this.ibE.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.crd() == null) {
                                BarVoteActivity.this.ibE.Jk(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.crd().getStatus() < 1 || fVar.crd().getStatus() > 2) {
                                BarVoteActivity.this.ibE.Jk(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.ibE.getListView() != null) {
                        BarVoteActivity.this.ibE.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.ibE.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.ibD != null && BarVoteActivity.this.ibD.mPn == 0) {
                        if (BarVoteActivity.this.ibE.getListView() != null) {
                            BarVoteActivity.this.ibE.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.ibE.Jk(str);
                    }
                } else if (BarVoteActivity.this.ibD != null && BarVoteActivity.this.ibD.mPn == 0) {
                    if (BarVoteActivity.this.ibE.getListView() != null) {
                        BarVoteActivity.this.ibE.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.ibE.Jk(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ibE = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.ibD = new BarVoteModel(this);
        this.ibD.a(this.ibF);
        this.ibE.g(new a());
        new ar("c13440").al("obj_source", this.source).btT();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new ar("c13440").al("obj_source", this.source).btT();
    }

    public void cqB() {
        if (this.ibD != null) {
            this.ibD.bRN();
        }
    }

    public void reload() {
        if (this.ibD != null) {
            this.ibD.refresh();
        }
    }

    public void refresh() {
        if (this.ibD != null) {
            this.ibD.cqJ();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            bf.bua().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.ibE != null && this.ibE.cqL() != null) {
                this.ibE.cqL().showLoading();
            }
            cqB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ibE != null) {
            this.ibE.vJ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ibE != null) {
            this.ibE.onDestroy();
        }
        if (this.ibD != null) {
            this.ibD.onDestroy();
        }
        super.onDestroy();
    }

    public void bSf() {
        this.ibE.bSf();
    }

    /* loaded from: classes21.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.ibE.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.ibE.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
