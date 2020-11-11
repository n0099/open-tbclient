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
    private BarVoteModel hQh = null;
    private com.baidu.tieba.barselect.a hQi = null;
    BarVoteModel.a hQj = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.hQi != null && BarVoteActivity.this.hQi.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.hQi.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.cnn() == null || fVar.cnn().getStatus() < 1 || fVar.cnn().getStatus() > 2) {
                        if (BarVoteActivity.this.hQh != null && BarVoteActivity.this.hQh.mPn == 0) {
                            if (BarVoteActivity.this.hQi.getListView() != null) {
                                BarVoteActivity.this.hQi.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.cnn() == null) {
                                BarVoteActivity.this.hQi.IT(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.cnn().getStatus() < 1 || fVar.cnn().getStatus() > 2) {
                                BarVoteActivity.this.hQi.IT(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.hQi.getListView() != null) {
                        BarVoteActivity.this.hQi.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.hQi.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.hQh != null && BarVoteActivity.this.hQh.mPn == 0) {
                        if (BarVoteActivity.this.hQi.getListView() != null) {
                            BarVoteActivity.this.hQi.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.hQi.IT(str);
                    }
                } else if (BarVoteActivity.this.hQh != null && BarVoteActivity.this.hQh.mPn == 0) {
                    if (BarVoteActivity.this.hQi.getListView() != null) {
                        BarVoteActivity.this.hQi.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.hQi.IT(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hQi = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.hQh = new BarVoteModel(this);
        this.hQh.a(this.hQj);
        this.hQi.g(new a());
        new aq("c13440").al("obj_source", this.source).brk();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new aq("c13440").al("obj_source", this.source).brk();
    }

    public void cmL() {
        if (this.hQh != null) {
            this.hQh.bOI();
        }
    }

    public void reload() {
        if (this.hQh != null) {
            this.hQh.refresh();
        }
    }

    public void refresh() {
        if (this.hQh != null) {
            this.hQh.cmT();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            be.brr().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.hQi != null && this.hQi.cmV() != null) {
                this.hQi.cmV().showLoading();
            }
            cmL();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hQi != null) {
            this.hQi.uE(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hQi != null) {
            this.hQi.onDestroy();
        }
        if (this.hQh != null) {
            this.hQh.onDestroy();
        }
        super.onDestroy();
    }

    public void bPa() {
        this.hQi.bPa();
    }

    /* loaded from: classes21.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.hQi.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.hQi.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
