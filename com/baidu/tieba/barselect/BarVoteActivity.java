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
/* loaded from: classes7.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel iqZ = null;
    private com.baidu.tieba.barselect.a ira = null;
    BarVoteModel.a irb = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.ira != null && BarVoteActivity.this.ira.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.ira.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.crC() == null || fVar.crC().getStatus() < 1 || fVar.crC().getStatus() > 2) {
                        if (BarVoteActivity.this.iqZ != null && BarVoteActivity.this.iqZ.mPn == 0) {
                            if (BarVoteActivity.this.ira.getListView() != null) {
                                BarVoteActivity.this.ira.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.crC() == null) {
                                BarVoteActivity.this.ira.IQ(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.crC().getStatus() < 1 || fVar.crC().getStatus() > 2) {
                                BarVoteActivity.this.ira.IQ(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.ira.getListView() != null) {
                        BarVoteActivity.this.ira.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.ira.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.iqZ != null && BarVoteActivity.this.iqZ.mPn == 0) {
                        if (BarVoteActivity.this.ira.getListView() != null) {
                            BarVoteActivity.this.ira.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.ira.IQ(str);
                    }
                } else if (BarVoteActivity.this.iqZ != null && BarVoteActivity.this.iqZ.mPn == 0) {
                    if (BarVoteActivity.this.ira.getListView() != null) {
                        BarVoteActivity.this.ira.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.ira.IQ(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ira = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.iqZ = new BarVoteModel(this);
        this.iqZ.a(this.irb);
        this.ira.h(new a());
        new ar("c13440").aq("obj_source", this.source).bsR();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new ar("c13440").aq("obj_source", this.source).bsR();
    }

    public void cra() {
        if (this.iqZ != null) {
            this.iqZ.bRp();
        }
    }

    public void reload() {
        if (this.iqZ != null) {
            this.iqZ.refresh();
        }
    }

    public void refresh() {
        if (this.iqZ != null) {
            this.iqZ.cri();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            bf.bsY().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.ira != null && this.ira.crk() != null) {
                this.ira.crk().showLoading();
            }
            cra();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ira != null) {
            this.ira.uw(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ira != null) {
            this.ira.onDestroy();
        }
        if (this.iqZ != null) {
            this.iqZ.onDestroy();
        }
        super.onDestroy();
    }

    public void bRH() {
        this.ira.bRH();
    }

    /* loaded from: classes7.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.ira.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.ira.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
