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
/* loaded from: classes20.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel hQH = null;
    private com.baidu.tieba.barselect.a hQI = null;
    BarVoteModel.a hQJ = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.hQI != null && BarVoteActivity.this.hQI.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.hQI.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.cmP() == null || fVar.cmP().getStatus() < 1 || fVar.cmP().getStatus() > 2) {
                        if (BarVoteActivity.this.hQH != null && BarVoteActivity.this.hQH.mPn == 0) {
                            if (BarVoteActivity.this.hQI.getListView() != null) {
                                BarVoteActivity.this.hQI.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.cmP() == null) {
                                BarVoteActivity.this.hQI.Iu(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.cmP().getStatus() < 1 || fVar.cmP().getStatus() > 2) {
                                BarVoteActivity.this.hQI.Iu(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.hQI.getListView() != null) {
                        BarVoteActivity.this.hQI.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.hQI.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.hQH != null && BarVoteActivity.this.hQH.mPn == 0) {
                        if (BarVoteActivity.this.hQI.getListView() != null) {
                            BarVoteActivity.this.hQI.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.hQI.Iu(str);
                    }
                } else if (BarVoteActivity.this.hQH != null && BarVoteActivity.this.hQH.mPn == 0) {
                    if (BarVoteActivity.this.hQI.getListView() != null) {
                        BarVoteActivity.this.hQI.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.hQI.Iu(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hQI = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.hQH = new BarVoteModel(this);
        this.hQH.a(this.hQJ);
        this.hQI.g(new a());
        new ar("c13440").ak("obj_source", this.source).bqy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new ar("c13440").ak("obj_source", this.source).bqy();
    }

    public void cmn() {
        if (this.hQH != null) {
            this.hQH.bOb();
        }
    }

    public void reload() {
        if (this.hQH != null) {
            this.hQH.refresh();
        }
    }

    public void refresh() {
        if (this.hQH != null) {
            this.hQH.cmv();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            bf.bqF().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.hQI != null && this.hQI.cmx() != null) {
                this.hQI.cmx().showLoading();
            }
            cmn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hQI != null) {
            this.hQI.vc(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hQI != null) {
            this.hQI.onDestroy();
        }
        if (this.hQH != null) {
            this.hQH.onDestroy();
        }
        super.onDestroy();
    }

    public void bOt() {
        this.hQI.bOt();
    }

    /* loaded from: classes20.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.hQI.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.hQI.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
