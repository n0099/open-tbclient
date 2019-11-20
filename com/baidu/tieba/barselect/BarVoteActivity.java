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
/* loaded from: classes3.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel eEt = null;
    private com.baidu.tieba.barselect.a eEu = null;
    BarVoteModel.a eEv = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.eEu != null && BarVoteActivity.this.eEu.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.eEu.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.aZw() == null || fVar.aZw().getStatus() < 1 || fVar.aZw().getStatus() > 2) {
                        if (BarVoteActivity.this.eEt != null && BarVoteActivity.this.eEt.mPn == 0) {
                            if (BarVoteActivity.this.eEu.getListView() != null) {
                                BarVoteActivity.this.eEu.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.aZw() == null) {
                                BarVoteActivity.this.eEu.us(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.aZw().getStatus() < 1 || fVar.aZw().getStatus() > 2) {
                                BarVoteActivity.this.eEu.us(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.eEu.getListView() != null) {
                        BarVoteActivity.this.eEu.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.eEu.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.eEt != null && BarVoteActivity.this.eEt.mPn == 0) {
                        if (BarVoteActivity.this.eEu.getListView() != null) {
                            BarVoteActivity.this.eEu.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.eEu.us(str);
                    }
                } else if (BarVoteActivity.this.eEt != null && BarVoteActivity.this.eEt.mPn == 0) {
                    if (BarVoteActivity.this.eEu.getListView() != null) {
                        BarVoteActivity.this.eEu.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.eEu.us(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eEu = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.eEt = new BarVoteModel(this);
        this.eEt.a(this.eEv);
        this.eEu.e(new a());
        new an("c13440").O("obj_source", this.source).amI();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new an("c13440").O("obj_source", this.source).amI();
    }

    public void aYW() {
        if (this.eEt != null) {
            this.eEt.aIU();
        }
    }

    public void reload() {
        if (this.eEt != null) {
            this.eEt.refresh();
        }
    }

    public void refresh() {
        if (this.eEt != null) {
            this.eEt.aZe();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            ba.amO().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.eEu != null && this.eEu.aZg() != null) {
                this.eEu.aZg().showLoading();
            }
            aYW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eEu != null) {
            this.eEu.mD(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eEu != null) {
            this.eEu.onDestroy();
        }
        if (this.eEt != null) {
            this.eEt.onDestroy();
        }
        super.onDestroy();
    }

    public void aJl() {
        this.eEu.aJl();
    }

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.eEu.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.eEu.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
