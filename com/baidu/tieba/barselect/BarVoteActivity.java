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
/* loaded from: classes15.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel hbU = null;
    private com.baidu.tieba.barselect.a hbV = null;
    BarVoteModel.a hbW = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.hbV != null && BarVoteActivity.this.hbV.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.hbV.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.caT() == null || fVar.caT().getStatus() < 1 || fVar.caT().getStatus() > 2) {
                        if (BarVoteActivity.this.hbU != null && BarVoteActivity.this.hbU.mPn == 0) {
                            if (BarVoteActivity.this.hbV.getListView() != null) {
                                BarVoteActivity.this.hbV.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.caT() == null) {
                                BarVoteActivity.this.hbV.GT(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.caT().getStatus() < 1 || fVar.caT().getStatus() > 2) {
                                BarVoteActivity.this.hbV.GT(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.hbV.getListView() != null) {
                        BarVoteActivity.this.hbV.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.hbV.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.hbU != null && BarVoteActivity.this.hbU.mPn == 0) {
                        if (BarVoteActivity.this.hbV.getListView() != null) {
                            BarVoteActivity.this.hbV.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.hbV.GT(str);
                    }
                } else if (BarVoteActivity.this.hbU != null && BarVoteActivity.this.hbU.mPn == 0) {
                    if (BarVoteActivity.this.hbV.getListView() != null) {
                        BarVoteActivity.this.hbV.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.hbV.GT(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hbV = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.hbU = new BarVoteModel(this);
        this.hbU.a(this.hbW);
        this.hbV.f(new a());
        new aq("c13440").ai("obj_source", this.source).bjn();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new aq("c13440").ai("obj_source", this.source).bjn();
    }

    public void cau() {
        if (this.hbU != null) {
            this.hbU.bFE();
        }
    }

    public void reload() {
        if (this.hbU != null) {
            this.hbU.refresh();
        }
    }

    public void refresh() {
        if (this.hbU != null) {
            this.hbU.caC();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            be.bju().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.hbV != null && this.hbV.caE() != null) {
                this.hbV.caE().showLoading();
            }
            cau();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hbV != null) {
            this.hbV.tl(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hbV != null) {
            this.hbV.onDestroy();
        }
        if (this.hbU != null) {
            this.hbU.onDestroy();
        }
        super.onDestroy();
    }

    public void bFW() {
        this.hbV.bFW();
    }

    /* loaded from: classes15.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.hbV.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.hbV.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
