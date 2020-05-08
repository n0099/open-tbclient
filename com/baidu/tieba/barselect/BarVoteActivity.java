package com.baidu.tieba.barselect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.BarVoteModel;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes8.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel ghE = null;
    private com.baidu.tieba.barselect.a ghF = null;
    BarVoteModel.a ghG = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.ghF != null && BarVoteActivity.this.ghF.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.ghF.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.bDW() == null || fVar.bDW().getStatus() < 1 || fVar.bDW().getStatus() > 2) {
                        if (BarVoteActivity.this.ghE != null && BarVoteActivity.this.ghE.mPn == 0) {
                            if (BarVoteActivity.this.ghF.getListView() != null) {
                                BarVoteActivity.this.ghF.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.bDW() == null) {
                                BarVoteActivity.this.ghF.By(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.bDW().getStatus() < 1 || fVar.bDW().getStatus() > 2) {
                                BarVoteActivity.this.ghF.By(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.ghF.getListView() != null) {
                        BarVoteActivity.this.ghF.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.ghF.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.ghE != null && BarVoteActivity.this.ghE.mPn == 0) {
                        if (BarVoteActivity.this.ghF.getListView() != null) {
                            BarVoteActivity.this.ghF.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.ghF.By(str);
                    }
                } else if (BarVoteActivity.this.ghE != null && BarVoteActivity.this.ghE.mPn == 0) {
                    if (BarVoteActivity.this.ghF.getListView() != null) {
                        BarVoteActivity.this.ghF.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.ghF.By(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ghF = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.ghE = new BarVoteModel(this);
        this.ghE.a(this.ghG);
        this.ghF.f(new a());
        new an("c13440").af("obj_source", this.source).aOO();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new an("c13440").af("obj_source", this.source).aOO();
    }

    public void bDx() {
        if (this.ghE != null) {
            this.ghE.bkZ();
        }
    }

    public void reload() {
        if (this.ghE != null) {
            this.ghE.refresh();
        }
    }

    public void refresh() {
        if (this.ghE != null) {
            this.ghE.bDF();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            ba.aOV().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.ghF != null && this.ghF.bDH() != null) {
                this.ghF.bDH().showLoading();
            }
            bDx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ghF != null) {
            this.ghF.pH(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ghF != null) {
            this.ghF.onDestroy();
        }
        if (this.ghE != null) {
            this.ghE.onDestroy();
        }
        super.onDestroy();
    }

    public void blq() {
        this.ghF.blq();
    }

    /* loaded from: classes8.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.ghF.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.ghF.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
