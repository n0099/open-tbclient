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
/* loaded from: classes8.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel iod = null;
    private com.baidu.tieba.barselect.a ioe = null;
    BarVoteModel.a iof = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.ioe != null && BarVoteActivity.this.ioe.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.ioe.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.ctX() == null || fVar.ctX().getStatus() < 1 || fVar.ctX().getStatus() > 2) {
                        if (BarVoteActivity.this.iod != null && BarVoteActivity.this.iod.mPn == 0) {
                            if (BarVoteActivity.this.ioe.getListView() != null) {
                                BarVoteActivity.this.ioe.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.ctX() == null) {
                                BarVoteActivity.this.ioe.Jh(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.ctX().getStatus() < 1 || fVar.ctX().getStatus() > 2) {
                                BarVoteActivity.this.ioe.Jh(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.ioe.getListView() != null) {
                        BarVoteActivity.this.ioe.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.ioe.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.iod != null && BarVoteActivity.this.iod.mPn == 0) {
                        if (BarVoteActivity.this.ioe.getListView() != null) {
                            BarVoteActivity.this.ioe.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.ioe.Jh(str);
                    }
                } else if (BarVoteActivity.this.iod != null && BarVoteActivity.this.iod.mPn == 0) {
                    if (BarVoteActivity.this.ioe.getListView() != null) {
                        BarVoteActivity.this.ioe.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.ioe.Jh(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ioe = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.iod = new BarVoteModel(this);
        this.iod.a(this.iof);
        this.ioe.h(new a());
        new aq("c13440").an("obj_source", this.source).bwo();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new aq("c13440").an("obj_source", this.source).bwo();
    }

    public void ctv() {
        if (this.iod != null) {
            this.iod.bUq();
        }
    }

    public void reload() {
        if (this.iod != null) {
            this.iod.refresh();
        }
    }

    public void refresh() {
        if (this.iod != null) {
            this.iod.ctD();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            be.bwv().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.ioe != null && this.ioe.ctF() != null) {
                this.ioe.ctF().showLoading();
            }
            ctv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ioe != null) {
            this.ioe.vU(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ioe != null) {
            this.ioe.onDestroy();
        }
        if (this.iod != null) {
            this.iod.onDestroy();
        }
        super.onDestroy();
    }

    public void bUI() {
        this.ioe.bUI();
    }

    /* loaded from: classes8.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.ioe.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.ioe.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
