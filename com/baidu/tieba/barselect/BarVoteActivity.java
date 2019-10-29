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
/* loaded from: classes3.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel eFk = null;
    private com.baidu.tieba.barselect.a eFl = null;
    BarVoteModel.a eFm = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.eFl != null && BarVoteActivity.this.eFl.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.eFl.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.aZy() == null || fVar.aZy().getStatus() < 1 || fVar.aZy().getStatus() > 2) {
                        if (BarVoteActivity.this.eFk != null && BarVoteActivity.this.eFk.mPn == 0) {
                            if (BarVoteActivity.this.eFl.getListView() != null) {
                                BarVoteActivity.this.eFl.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.aZy() == null) {
                                BarVoteActivity.this.eFl.us(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.aZy().getStatus() < 1 || fVar.aZy().getStatus() > 2) {
                                BarVoteActivity.this.eFl.us(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.eFl.getListView() != null) {
                        BarVoteActivity.this.eFl.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.eFl.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.eFk != null && BarVoteActivity.this.eFk.mPn == 0) {
                        if (BarVoteActivity.this.eFl.getListView() != null) {
                            BarVoteActivity.this.eFl.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.eFl.us(str);
                    }
                } else if (BarVoteActivity.this.eFk != null && BarVoteActivity.this.eFk.mPn == 0) {
                    if (BarVoteActivity.this.eFl.getListView() != null) {
                        BarVoteActivity.this.eFl.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.eFl.us(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eFl = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.eFk = new BarVoteModel(this);
        this.eFk.a(this.eFm);
        this.eFl.e(new a());
        new an("c13440").O("obj_source", this.source).amK();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new an("c13440").O("obj_source", this.source).amK();
    }

    public void aYY() {
        if (this.eFk != null) {
            this.eFk.aIW();
        }
    }

    public void reload() {
        if (this.eFk != null) {
            this.eFk.refresh();
        }
    }

    public void refresh() {
        if (this.eFk != null) {
            this.eFk.aZg();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            ba.amQ().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.eFl != null && this.eFl.aZi() != null) {
                this.eFl.aZi().showLoading();
            }
            aYY();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eFl != null) {
            this.eFl.mE(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eFl != null) {
            this.eFl.onDestroy();
        }
        if (this.eFk != null) {
            this.eFk.onDestroy();
        }
        super.onDestroy();
    }

    public void aJn() {
        this.eFl.aJn();
    }

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.eFl.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.eFl.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
