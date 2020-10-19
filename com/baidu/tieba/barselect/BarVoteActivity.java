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
/* loaded from: classes21.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel hxO = null;
    private com.baidu.tieba.barselect.a hxP = null;
    BarVoteModel.a hxQ = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.hxP != null && BarVoteActivity.this.hxP.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.hxP.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.chE() == null || fVar.chE().getStatus() < 1 || fVar.chE().getStatus() > 2) {
                        if (BarVoteActivity.this.hxO != null && BarVoteActivity.this.hxO.mPn == 0) {
                            if (BarVoteActivity.this.hxP.getListView() != null) {
                                BarVoteActivity.this.hxP.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.chE() == null) {
                                BarVoteActivity.this.hxP.Id(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.chE().getStatus() < 1 || fVar.chE().getStatus() > 2) {
                                BarVoteActivity.this.hxP.Id(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.hxP.getListView() != null) {
                        BarVoteActivity.this.hxP.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.hxP.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.hxO != null && BarVoteActivity.this.hxO.mPn == 0) {
                        if (BarVoteActivity.this.hxP.getListView() != null) {
                            BarVoteActivity.this.hxP.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.hxP.Id(str);
                    }
                } else if (BarVoteActivity.this.hxO != null && BarVoteActivity.this.hxO.mPn == 0) {
                    if (BarVoteActivity.this.hxP.getListView() != null) {
                        BarVoteActivity.this.hxP.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.hxP.Id(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hxP = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.hxO = new BarVoteModel(this);
        this.hxO.a(this.hxQ);
        this.hxP.f(new a());
        new aq("c13440").aj("obj_source", this.source).bmR();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new aq("c13440").aj("obj_source", this.source).bmR();
    }

    public void chc() {
        if (this.hxO != null) {
            this.hxO.bJG();
        }
    }

    public void reload() {
        if (this.hxO != null) {
            this.hxO.refresh();
        }
    }

    public void refresh() {
        if (this.hxO != null) {
            this.hxO.chk();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            be.bmY().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.hxP != null && this.hxP.chm() != null) {
                this.hxP.chm().showLoading();
            }
            chc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hxP != null) {
            this.hxP.uc(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hxP != null) {
            this.hxP.onDestroy();
        }
        if (this.hxO != null) {
            this.hxO.onDestroy();
        }
        super.onDestroy();
    }

    public void bJY() {
        this.hxP.bJY();
    }

    /* loaded from: classes21.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.hxP.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.hxP.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
