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
/* loaded from: classes20.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel hiT = null;
    private com.baidu.tieba.barselect.a hiU = null;
    BarVoteModel.a hiV = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.hiU != null && BarVoteActivity.this.hiU.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.hiU.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.cei() == null || fVar.cei().getStatus() < 1 || fVar.cei().getStatus() > 2) {
                        if (BarVoteActivity.this.hiT != null && BarVoteActivity.this.hiT.mPn == 0) {
                            if (BarVoteActivity.this.hiU.getListView() != null) {
                                BarVoteActivity.this.hiU.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.cei() == null) {
                                BarVoteActivity.this.hiU.Hq(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.cei().getStatus() < 1 || fVar.cei().getStatus() > 2) {
                                BarVoteActivity.this.hiU.Hq(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.hiU.getListView() != null) {
                        BarVoteActivity.this.hiU.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.hiU.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.hiT != null && BarVoteActivity.this.hiT.mPn == 0) {
                        if (BarVoteActivity.this.hiU.getListView() != null) {
                            BarVoteActivity.this.hiU.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.hiU.Hq(str);
                    }
                } else if (BarVoteActivity.this.hiT != null && BarVoteActivity.this.hiT.mPn == 0) {
                    if (BarVoteActivity.this.hiU.getListView() != null) {
                        BarVoteActivity.this.hiU.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.hiU.Hq(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hiU = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.hiT = new BarVoteModel(this);
        this.hiT.a(this.hiV);
        this.hiU.f(new a());
        new aq("c13440").ai("obj_source", this.source).bki();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new aq("c13440").ai("obj_source", this.source).bki();
    }

    public void cdG() {
        if (this.hiT != null) {
            this.hiT.bGU();
        }
    }

    public void reload() {
        if (this.hiT != null) {
            this.hiT.refresh();
        }
    }

    public void refresh() {
        if (this.hiT != null) {
            this.hiT.cdO();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            be.bkp().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.hiU != null && this.hiU.cdQ() != null) {
                this.hiU.cdQ().showLoading();
            }
            cdG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hiU != null) {
            this.hiU.tE(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hiU != null) {
            this.hiU.onDestroy();
        }
        if (this.hiT != null) {
            this.hiT.onDestroy();
        }
        super.onDestroy();
    }

    public void bHm() {
        this.hiU.bHm();
    }

    /* loaded from: classes20.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.hiU.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.hiU.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
