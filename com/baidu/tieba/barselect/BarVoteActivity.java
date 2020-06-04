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
    private BarVoteModel gwG = null;
    private com.baidu.tieba.barselect.a gwH = null;
    BarVoteModel.a gwI = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.gwH != null && BarVoteActivity.this.gwH.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.gwH.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.bKq() == null || fVar.bKq().getStatus() < 1 || fVar.bKq().getStatus() > 2) {
                        if (BarVoteActivity.this.gwG != null && BarVoteActivity.this.gwG.mPn == 0) {
                            if (BarVoteActivity.this.gwH.getListView() != null) {
                                BarVoteActivity.this.gwH.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.bKq() == null) {
                                BarVoteActivity.this.gwH.Dh(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.bKq().getStatus() < 1 || fVar.bKq().getStatus() > 2) {
                                BarVoteActivity.this.gwH.Dh(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.gwH.getListView() != null) {
                        BarVoteActivity.this.gwH.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.gwH.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.gwG != null && BarVoteActivity.this.gwG.mPn == 0) {
                        if (BarVoteActivity.this.gwH.getListView() != null) {
                            BarVoteActivity.this.gwH.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.gwH.Dh(str);
                    }
                } else if (BarVoteActivity.this.gwG != null && BarVoteActivity.this.gwG.mPn == 0) {
                    if (BarVoteActivity.this.gwH.getListView() != null) {
                        BarVoteActivity.this.gwH.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.gwH.Dh(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gwH = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.gwG = new BarVoteModel(this);
        this.gwG.a(this.gwI);
        this.gwH.f(new a());
        new an("c13440").ag("obj_source", this.source).aUT();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new an("c13440").ag("obj_source", this.source).aUT();
    }

    public void bJR() {
        if (this.gwG != null) {
            this.gwG.bqx();
        }
    }

    public void reload() {
        if (this.gwG != null) {
            this.gwG.refresh();
        }
    }

    public void refresh() {
        if (this.gwG != null) {
            this.gwG.bJZ();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            ba.aVa().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.gwH != null && this.gwH.bKb() != null) {
                this.gwH.bKb().showLoading();
            }
            bJR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gwH != null) {
            this.gwH.qk(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gwH != null) {
            this.gwH.onDestroy();
        }
        if (this.gwG != null) {
            this.gwG.onDestroy();
        }
        super.onDestroy();
    }

    public void bqP() {
        this.gwH.bqP();
    }

    /* loaded from: classes8.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.gwH.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.gwH.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
