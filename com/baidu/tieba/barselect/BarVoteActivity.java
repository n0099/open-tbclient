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
    private BarVoteModel fCa = null;
    private com.baidu.tieba.barselect.a fCb = null;
    BarVoteModel.a fCc = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.fCb != null && BarVoteActivity.this.fCb.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.fCb.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.bug() == null || fVar.bug().getStatus() < 1 || fVar.bug().getStatus() > 2) {
                        if (BarVoteActivity.this.fCa != null && BarVoteActivity.this.fCa.mPn == 0) {
                            if (BarVoteActivity.this.fCb.getListView() != null) {
                                BarVoteActivity.this.fCb.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.bug() == null) {
                                BarVoteActivity.this.fCb.zM(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.bug().getStatus() < 1 || fVar.bug().getStatus() > 2) {
                                BarVoteActivity.this.fCb.zM(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.fCb.getListView() != null) {
                        BarVoteActivity.this.fCb.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.fCb.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.fCa != null && BarVoteActivity.this.fCa.mPn == 0) {
                        if (BarVoteActivity.this.fCb.getListView() != null) {
                            BarVoteActivity.this.fCb.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.fCb.zM(str);
                    }
                } else if (BarVoteActivity.this.fCa != null && BarVoteActivity.this.fCa.mPn == 0) {
                    if (BarVoteActivity.this.fCb.getListView() != null) {
                        BarVoteActivity.this.fCb.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.fCb.zM(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fCb = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.fCa = new BarVoteModel(this);
        this.fCa.a(this.fCc);
        this.fCb.f(new a());
        new an("c13440").X("obj_source", this.source).aGx();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new an("c13440").X("obj_source", this.source).aGx();
    }

    public void btG() {
        if (this.fCa != null) {
            this.fCa.bcd();
        }
    }

    public void reload() {
        if (this.fCa != null) {
            this.fCa.refresh();
        }
    }

    public void refresh() {
        if (this.fCa != null) {
            this.fCa.btO();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            ba.aGE().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.fCb != null && this.fCb.btQ() != null) {
                this.fCb.btQ().showLoading();
            }
            btG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fCb != null) {
            this.fCb.pk(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fCb != null) {
            this.fCb.onDestroy();
        }
        if (this.fCa != null) {
            this.fCa.onDestroy();
        }
        super.onDestroy();
    }

    public void bcu() {
        this.fCb.bcu();
    }

    /* loaded from: classes8.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.fCb.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.fCb.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
