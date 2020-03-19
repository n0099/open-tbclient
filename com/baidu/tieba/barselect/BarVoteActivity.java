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
    private BarVoteModel fCX = null;
    private com.baidu.tieba.barselect.a fCY = null;
    BarVoteModel.a fCZ = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.fCY != null && BarVoteActivity.this.fCY.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.fCY.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.buo() == null || fVar.buo().getStatus() < 1 || fVar.buo().getStatus() > 2) {
                        if (BarVoteActivity.this.fCX != null && BarVoteActivity.this.fCX.mPn == 0) {
                            if (BarVoteActivity.this.fCY.getListView() != null) {
                                BarVoteActivity.this.fCY.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.buo() == null) {
                                BarVoteActivity.this.fCY.zP(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.buo().getStatus() < 1 || fVar.buo().getStatus() > 2) {
                                BarVoteActivity.this.fCY.zP(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.fCY.getListView() != null) {
                        BarVoteActivity.this.fCY.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.fCY.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.fCX != null && BarVoteActivity.this.fCX.mPn == 0) {
                        if (BarVoteActivity.this.fCY.getListView() != null) {
                            BarVoteActivity.this.fCY.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.fCY.zP(str);
                    }
                } else if (BarVoteActivity.this.fCX != null && BarVoteActivity.this.fCX.mPn == 0) {
                    if (BarVoteActivity.this.fCY.getListView() != null) {
                        BarVoteActivity.this.fCY.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.fCY.zP(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fCY = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.fCX = new BarVoteModel(this);
        this.fCX.a(this.fCZ);
        this.fCY.f(new a());
        new an("c13440").X("obj_source", this.source).aGD();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new an("c13440").X("obj_source", this.source).aGD();
    }

    public void btO() {
        if (this.fCX != null) {
            this.fCX.bck();
        }
    }

    public void reload() {
        if (this.fCX != null) {
            this.fCX.refresh();
        }
    }

    public void refresh() {
        if (this.fCX != null) {
            this.fCX.btW();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            ba.aGK().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.fCY != null && this.fCY.btY() != null) {
                this.fCY.btY().showLoading();
            }
            btO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fCY != null) {
            this.fCY.pm(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fCY != null) {
            this.fCY.onDestroy();
        }
        if (this.fCX != null) {
            this.fCX.onDestroy();
        }
        super.onDestroy();
    }

    public void bcB() {
        this.fCY.bcB();
    }

    /* loaded from: classes8.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.fCY.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.fCY.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
