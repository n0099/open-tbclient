package com.baidu.tieba.barselect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.BarVoteModel;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes15.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel gPa = null;
    private com.baidu.tieba.barselect.a gPb = null;
    BarVoteModel.a gPc = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.gPb != null && BarVoteActivity.this.gPb.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.gPb.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.bQH() == null || fVar.bQH().getStatus() < 1 || fVar.bQH().getStatus() > 2) {
                        if (BarVoteActivity.this.gPa != null && BarVoteActivity.this.gPa.mPn == 0) {
                            if (BarVoteActivity.this.gPb.getListView() != null) {
                                BarVoteActivity.this.gPb.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.bQH() == null) {
                                BarVoteActivity.this.gPb.Et(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.bQH().getStatus() < 1 || fVar.bQH().getStatus() > 2) {
                                BarVoteActivity.this.gPb.Et(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.gPb.getListView() != null) {
                        BarVoteActivity.this.gPb.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.gPb.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.gPa != null && BarVoteActivity.this.gPa.mPn == 0) {
                        if (BarVoteActivity.this.gPb.getListView() != null) {
                            BarVoteActivity.this.gPb.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.gPb.Et(str);
                    }
                } else if (BarVoteActivity.this.gPa != null && BarVoteActivity.this.gPa.mPn == 0) {
                    if (BarVoteActivity.this.gPb.getListView() != null) {
                        BarVoteActivity.this.gPb.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.gPb.Et(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gPb = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.gPa = new BarVoteModel(this);
        this.gPa.a(this.gPc);
        this.gPb.f(new a());
        new ap("c13440").ah("obj_source", this.source).baO();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new ap("c13440").ah("obj_source", this.source).baO();
    }

    public void bQi() {
        if (this.gPa != null) {
            this.gPa.bwE();
        }
    }

    public void reload() {
        if (this.gPa != null) {
            this.gPa.refresh();
        }
    }

    public void refresh() {
        if (this.gPa != null) {
            this.gPa.bQq();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            bd.baV().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.gPb != null && this.gPb.bQs() != null) {
                this.gPb.bQs().showLoading();
            }
            bQi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gPb != null) {
            this.gPb.qZ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gPb != null) {
            this.gPb.onDestroy();
        }
        if (this.gPa != null) {
            this.gPa.onDestroy();
        }
        super.onDestroy();
    }

    public void bwW() {
        this.gPb.bwW();
    }

    /* loaded from: classes15.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.gPb.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.gPb.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
