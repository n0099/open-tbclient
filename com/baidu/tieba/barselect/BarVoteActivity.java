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
    private BarVoteModel gwv = null;
    private com.baidu.tieba.barselect.a gww = null;
    BarVoteModel.a gwx = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.gww != null && BarVoteActivity.this.gww.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.gww.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.bKo() == null || fVar.bKo().getStatus() < 1 || fVar.bKo().getStatus() > 2) {
                        if (BarVoteActivity.this.gwv != null && BarVoteActivity.this.gwv.mPn == 0) {
                            if (BarVoteActivity.this.gww.getListView() != null) {
                                BarVoteActivity.this.gww.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.bKo() == null) {
                                BarVoteActivity.this.gww.Dh(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.bKo().getStatus() < 1 || fVar.bKo().getStatus() > 2) {
                                BarVoteActivity.this.gww.Dh(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.gww.getListView() != null) {
                        BarVoteActivity.this.gww.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.gww.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.gwv != null && BarVoteActivity.this.gwv.mPn == 0) {
                        if (BarVoteActivity.this.gww.getListView() != null) {
                            BarVoteActivity.this.gww.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.gww.Dh(str);
                    }
                } else if (BarVoteActivity.this.gwv != null && BarVoteActivity.this.gwv.mPn == 0) {
                    if (BarVoteActivity.this.gww.getListView() != null) {
                        BarVoteActivity.this.gww.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.gww.Dh(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gww = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.gwv = new BarVoteModel(this);
        this.gwv.a(this.gwx);
        this.gww.f(new a());
        new an("c13440").ag("obj_source", this.source).aUS();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new an("c13440").ag("obj_source", this.source).aUS();
    }

    public void bJP() {
        if (this.gwv != null) {
            this.gwv.bqv();
        }
    }

    public void reload() {
        if (this.gwv != null) {
            this.gwv.refresh();
        }
    }

    public void refresh() {
        if (this.gwv != null) {
            this.gwv.bJX();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            ba.aUZ().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.gww != null && this.gww.bJZ() != null) {
                this.gww.bJZ().showLoading();
            }
            bJP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gww != null) {
            this.gww.qi(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gww != null) {
            this.gww.onDestroy();
        }
        if (this.gwv != null) {
            this.gwv.onDestroy();
        }
        super.onDestroy();
    }

    public void bqN() {
        this.gww.bqN();
    }

    /* loaded from: classes8.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.gww.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.gww.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
