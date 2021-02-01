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
/* loaded from: classes8.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel ipc = null;
    private com.baidu.tieba.barselect.a ipd = null;
    BarVoteModel.a ipe = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.ipd != null && BarVoteActivity.this.ipd.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.ipd.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.crp() == null || fVar.crp().getStatus() < 1 || fVar.crp().getStatus() > 2) {
                        if (BarVoteActivity.this.ipc != null && BarVoteActivity.this.ipc.mPn == 0) {
                            if (BarVoteActivity.this.ipd.getListView() != null) {
                                BarVoteActivity.this.ipd.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.crp() == null) {
                                BarVoteActivity.this.ipd.IG(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.crp().getStatus() < 1 || fVar.crp().getStatus() > 2) {
                                BarVoteActivity.this.ipd.IG(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.ipd.getListView() != null) {
                        BarVoteActivity.this.ipd.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.ipd.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.ipc != null && BarVoteActivity.this.ipc.mPn == 0) {
                        if (BarVoteActivity.this.ipd.getListView() != null) {
                            BarVoteActivity.this.ipd.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.ipd.IG(str);
                    }
                } else if (BarVoteActivity.this.ipc != null && BarVoteActivity.this.ipc.mPn == 0) {
                    if (BarVoteActivity.this.ipd.getListView() != null) {
                        BarVoteActivity.this.ipd.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.ipd.IG(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ipd = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.ipc = new BarVoteModel(this);
        this.ipc.a(this.ipe);
        this.ipd.h(new a());
        new ar("c13440").ap("obj_source", this.source).bsO();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new ar("c13440").ap("obj_source", this.source).bsO();
    }

    public void cqN() {
        if (this.ipc != null) {
            this.ipc.bRc();
        }
    }

    public void reload() {
        if (this.ipc != null) {
            this.ipc.refresh();
        }
    }

    public void refresh() {
        if (this.ipc != null) {
            this.ipc.cqV();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            bf.bsV().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.ipd != null && this.ipd.cqX() != null) {
                this.ipd.cqX().showLoading();
            }
            cqN();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ipd != null) {
            this.ipd.uu(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ipd != null) {
            this.ipd.onDestroy();
        }
        if (this.ipc != null) {
            this.ipc.onDestroy();
        }
        super.onDestroy();
    }

    public void bRu() {
        this.ipd.bRu();
    }

    /* loaded from: classes8.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.ipd.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.ipd.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
