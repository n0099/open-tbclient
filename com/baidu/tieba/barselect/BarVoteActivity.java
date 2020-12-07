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
/* loaded from: classes21.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel ibB = null;
    private com.baidu.tieba.barselect.a ibC = null;
    BarVoteModel.a ibD = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.ibC != null && BarVoteActivity.this.ibC.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.ibC.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.crc() == null || fVar.crc().getStatus() < 1 || fVar.crc().getStatus() > 2) {
                        if (BarVoteActivity.this.ibB != null && BarVoteActivity.this.ibB.mPn == 0) {
                            if (BarVoteActivity.this.ibC.getListView() != null) {
                                BarVoteActivity.this.ibC.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.crc() == null) {
                                BarVoteActivity.this.ibC.Jk(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.crc().getStatus() < 1 || fVar.crc().getStatus() > 2) {
                                BarVoteActivity.this.ibC.Jk(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.ibC.getListView() != null) {
                        BarVoteActivity.this.ibC.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.ibC.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.ibB != null && BarVoteActivity.this.ibB.mPn == 0) {
                        if (BarVoteActivity.this.ibC.getListView() != null) {
                            BarVoteActivity.this.ibC.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.ibC.Jk(str);
                    }
                } else if (BarVoteActivity.this.ibB != null && BarVoteActivity.this.ibB.mPn == 0) {
                    if (BarVoteActivity.this.ibC.getListView() != null) {
                        BarVoteActivity.this.ibC.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.ibC.Jk(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ibC = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.ibB = new BarVoteModel(this);
        this.ibB.a(this.ibD);
        this.ibC.g(new a());
        new ar("c13440").al("obj_source", this.source).btT();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new ar("c13440").al("obj_source", this.source).btT();
    }

    public void cqA() {
        if (this.ibB != null) {
            this.ibB.bRM();
        }
    }

    public void reload() {
        if (this.ibB != null) {
            this.ibB.refresh();
        }
    }

    public void refresh() {
        if (this.ibB != null) {
            this.ibB.cqI();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            bf.bua().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.ibC != null && this.ibC.cqK() != null) {
                this.ibC.cqK().showLoading();
            }
            cqA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ibC != null) {
            this.ibC.vJ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ibC != null) {
            this.ibC.onDestroy();
        }
        if (this.ibB != null) {
            this.ibB.onDestroy();
        }
        super.onDestroy();
    }

    public void bSe() {
        this.ibC.bSe();
    }

    /* loaded from: classes21.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.ibC.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.ibC.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
