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
    private BarVoteModel hbQ = null;
    private com.baidu.tieba.barselect.a hbR = null;
    BarVoteModel.a hbS = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.hbR != null && BarVoteActivity.this.hbR.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.hbR.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.caS() == null || fVar.caS().getStatus() < 1 || fVar.caS().getStatus() > 2) {
                        if (BarVoteActivity.this.hbQ != null && BarVoteActivity.this.hbQ.mPn == 0) {
                            if (BarVoteActivity.this.hbR.getListView() != null) {
                                BarVoteActivity.this.hbR.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.caS() == null) {
                                BarVoteActivity.this.hbR.GS(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.caS().getStatus() < 1 || fVar.caS().getStatus() > 2) {
                                BarVoteActivity.this.hbR.GS(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.hbR.getListView() != null) {
                        BarVoteActivity.this.hbR.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.hbR.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.hbQ != null && BarVoteActivity.this.hbQ.mPn == 0) {
                        if (BarVoteActivity.this.hbR.getListView() != null) {
                            BarVoteActivity.this.hbR.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.hbR.GS(str);
                    }
                } else if (BarVoteActivity.this.hbQ != null && BarVoteActivity.this.hbQ.mPn == 0) {
                    if (BarVoteActivity.this.hbR.getListView() != null) {
                        BarVoteActivity.this.hbR.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.hbR.GS(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hbR = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.hbQ = new BarVoteModel(this);
        this.hbQ.a(this.hbS);
        this.hbR.f(new a());
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

    public void cat() {
        if (this.hbQ != null) {
            this.hbQ.bFD();
        }
    }

    public void reload() {
        if (this.hbQ != null) {
            this.hbQ.refresh();
        }
    }

    public void refresh() {
        if (this.hbQ != null) {
            this.hbQ.caB();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            be.bju().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.hbR != null && this.hbR.caD() != null) {
                this.hbR.caD().showLoading();
            }
            cat();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hbR != null) {
            this.hbR.tl(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hbR != null) {
            this.hbR.onDestroy();
        }
        if (this.hbQ != null) {
            this.hbQ.onDestroy();
        }
        super.onDestroy();
    }

    public void bFV() {
        this.hbR.bFV();
    }

    /* loaded from: classes15.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.hbR.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.hbR.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
