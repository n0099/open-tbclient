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
/* loaded from: classes5.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel fwr = null;
    private com.baidu.tieba.barselect.a fws = null;
    BarVoteModel.a fwt = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.fws != null && BarVoteActivity.this.fws.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.fws.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.brA() == null || fVar.brA().getStatus() < 1 || fVar.brA().getStatus() > 2) {
                        if (BarVoteActivity.this.fwr != null && BarVoteActivity.this.fwr.mPn == 0) {
                            if (BarVoteActivity.this.fws.getListView() != null) {
                                BarVoteActivity.this.fws.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.brA() == null) {
                                BarVoteActivity.this.fws.zm(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.brA().getStatus() < 1 || fVar.brA().getStatus() > 2) {
                                BarVoteActivity.this.fws.zm(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.fws.getListView() != null) {
                        BarVoteActivity.this.fws.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.fws.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.fwr != null && BarVoteActivity.this.fwr.mPn == 0) {
                        if (BarVoteActivity.this.fws.getListView() != null) {
                            BarVoteActivity.this.fws.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.fws.zm(str);
                    }
                } else if (BarVoteActivity.this.fwr != null && BarVoteActivity.this.fwr.mPn == 0) {
                    if (BarVoteActivity.this.fws.getListView() != null) {
                        BarVoteActivity.this.fws.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.fws.zm(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fws = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.fwr = new BarVoteModel(this);
        this.fwr.a(this.fwt);
        this.fws.g(new a());
        new an("c13440").Z("obj_source", this.source).aDT();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new an("c13440").Z("obj_source", this.source).aDT();
    }

    public void bra() {
        if (this.fwr != null) {
            this.fwr.aZs();
        }
    }

    public void reload() {
        if (this.fwr != null) {
            this.fwr.refresh();
        }
    }

    public void refresh() {
        if (this.fwr != null) {
            this.fwr.bri();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            ba.aEa().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.fws != null && this.fws.brk() != null) {
                this.fws.brk().showLoading();
            }
            bra();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fws != null) {
            this.fws.oT(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fws != null) {
            this.fws.onDestroy();
        }
        if (this.fwr != null) {
            this.fwr.onDestroy();
        }
        super.onDestroy();
    }

    public void aZJ() {
        this.fws.aZJ();
    }

    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.fws.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.fws.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
