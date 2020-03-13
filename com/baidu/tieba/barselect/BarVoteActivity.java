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
    private BarVoteModel fCp = null;
    private com.baidu.tieba.barselect.a fCq = null;
    BarVoteModel.a fCr = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.fCq != null && BarVoteActivity.this.fCq.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.fCq.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.buj() == null || fVar.buj().getStatus() < 1 || fVar.buj().getStatus() > 2) {
                        if (BarVoteActivity.this.fCp != null && BarVoteActivity.this.fCp.mPn == 0) {
                            if (BarVoteActivity.this.fCq.getListView() != null) {
                                BarVoteActivity.this.fCq.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.buj() == null) {
                                BarVoteActivity.this.fCq.zN(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.buj().getStatus() < 1 || fVar.buj().getStatus() > 2) {
                                BarVoteActivity.this.fCq.zN(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.fCq.getListView() != null) {
                        BarVoteActivity.this.fCq.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.fCq.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.fCp != null && BarVoteActivity.this.fCp.mPn == 0) {
                        if (BarVoteActivity.this.fCq.getListView() != null) {
                            BarVoteActivity.this.fCq.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.fCq.zN(str);
                    }
                } else if (BarVoteActivity.this.fCp != null && BarVoteActivity.this.fCp.mPn == 0) {
                    if (BarVoteActivity.this.fCq.getListView() != null) {
                        BarVoteActivity.this.fCq.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.fCq.zN(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fCq = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.fCp = new BarVoteModel(this);
        this.fCp.a(this.fCr);
        this.fCq.f(new a());
        new an("c13440").X("obj_source", this.source).aGz();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new an("c13440").X("obj_source", this.source).aGz();
    }

    public void btJ() {
        if (this.fCp != null) {
            this.fCp.bcg();
        }
    }

    public void reload() {
        if (this.fCp != null) {
            this.fCp.refresh();
        }
    }

    public void refresh() {
        if (this.fCp != null) {
            this.fCp.btR();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            ba.aGG().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.fCq != null && this.fCq.btT() != null) {
                this.fCq.btT().showLoading();
            }
            btJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fCq != null) {
            this.fCq.pk(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fCq != null) {
            this.fCq.onDestroy();
        }
        if (this.fCp != null) {
            this.fCp.onDestroy();
        }
        super.onDestroy();
    }

    public void bcx() {
        this.fCq.bcx();
    }

    /* loaded from: classes8.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.fCq.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.fCq.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
