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
/* loaded from: classes6.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel fzC = null;
    private com.baidu.tieba.barselect.a fzD = null;
    BarVoteModel.a fzE = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.fzD != null && BarVoteActivity.this.fzD.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.fzD.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.bsC() == null || fVar.bsC().getStatus() < 1 || fVar.bsC().getStatus() > 2) {
                        if (BarVoteActivity.this.fzC != null && BarVoteActivity.this.fzC.mPn == 0) {
                            if (BarVoteActivity.this.fzD.getListView() != null) {
                                BarVoteActivity.this.fzD.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.bsC() == null) {
                                BarVoteActivity.this.fzD.zw(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.bsC().getStatus() < 1 || fVar.bsC().getStatus() > 2) {
                                BarVoteActivity.this.fzD.zw(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.fzD.getListView() != null) {
                        BarVoteActivity.this.fzD.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.fzD.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.fzC != null && BarVoteActivity.this.fzC.mPn == 0) {
                        if (BarVoteActivity.this.fzD.getListView() != null) {
                            BarVoteActivity.this.fzD.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.fzD.zw(str);
                    }
                } else if (BarVoteActivity.this.fzC != null && BarVoteActivity.this.fzC.mPn == 0) {
                    if (BarVoteActivity.this.fzD.getListView() != null) {
                        BarVoteActivity.this.fzD.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.fzD.zw(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fzD = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.fzC = new BarVoteModel(this);
        this.fzC.a(this.fzE);
        this.fzD.f(new a());
        new an("c13440").Z("obj_source", this.source).aEm();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new an("c13440").Z("obj_source", this.source).aEm();
    }

    public void bsc() {
        if (this.fzC != null) {
            this.fzC.aZN();
        }
    }

    public void reload() {
        if (this.fzC != null) {
            this.fzC.refresh();
        }
    }

    public void refresh() {
        if (this.fzC != null) {
            this.fzC.bsk();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            ba.aEt().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.fzD != null && this.fzD.bsm() != null) {
                this.fzD.bsm().showLoading();
            }
            bsc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fzD != null) {
            this.fzD.oU(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fzD != null) {
            this.fzD.onDestroy();
        }
        if (this.fzC != null) {
            this.fzC.onDestroy();
        }
        super.onDestroy();
    }

    public void bae() {
        this.fzD.bae();
    }

    /* loaded from: classes6.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.fzD.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.fzD.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
