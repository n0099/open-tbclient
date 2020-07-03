package com.baidu.tieba.barselect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.BarVoteModel;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes8.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel gJu = null;
    private com.baidu.tieba.barselect.a gJv = null;
    BarVoteModel.a gJw = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.gJv != null && BarVoteActivity.this.gJv.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.gJv.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.bNv() == null || fVar.bNv().getStatus() < 1 || fVar.bNv().getStatus() > 2) {
                        if (BarVoteActivity.this.gJu != null && BarVoteActivity.this.gJu.mPn == 0) {
                            if (BarVoteActivity.this.gJv.getListView() != null) {
                                BarVoteActivity.this.gJv.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.bNv() == null) {
                                BarVoteActivity.this.gJv.DI(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.bNv().getStatus() < 1 || fVar.bNv().getStatus() > 2) {
                                BarVoteActivity.this.gJv.DI(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.gJv.getListView() != null) {
                        BarVoteActivity.this.gJv.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.gJv.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.gJu != null && BarVoteActivity.this.gJu.mPn == 0) {
                        if (BarVoteActivity.this.gJv.getListView() != null) {
                            BarVoteActivity.this.gJv.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.gJv.DI(str);
                    }
                } else if (BarVoteActivity.this.gJu != null && BarVoteActivity.this.gJu.mPn == 0) {
                    if (BarVoteActivity.this.gJv.getListView() != null) {
                        BarVoteActivity.this.gJv.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.gJv.DI(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gJv = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.gJu = new BarVoteModel(this);
        this.gJu.a(this.gJw);
        this.gJv.f(new a());
        new ao("c13440").ag("obj_source", this.source).aWN();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new ao("c13440").ag("obj_source", this.source).aWN();
    }

    public void bMW() {
        if (this.gJu != null) {
            this.gJu.btu();
        }
    }

    public void reload() {
        if (this.gJu != null) {
            this.gJu.refresh();
        }
    }

    public void refresh() {
        if (this.gJu != null) {
            this.gJu.bNe();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            bc.aWU().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.gJv != null && this.gJv.bNg() != null) {
                this.gJv.bNg().showLoading();
            }
            bMW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gJv != null) {
            this.gJv.qJ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gJv != null) {
            this.gJv.onDestroy();
        }
        if (this.gJu != null) {
            this.gJu.onDestroy();
        }
        super.onDestroy();
    }

    public void btM() {
        this.gJv.btM();
    }

    /* loaded from: classes8.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.gJv.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.gJv.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
