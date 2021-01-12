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
/* loaded from: classes7.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel iju = null;
    private com.baidu.tieba.barselect.a ijv = null;
    BarVoteModel.a ijw = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.ijv != null && BarVoteActivity.this.ijv.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.ijv.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.cqf() == null || fVar.cqf().getStatus() < 1 || fVar.cqf().getStatus() > 2) {
                        if (BarVoteActivity.this.iju != null && BarVoteActivity.this.iju.mPn == 0) {
                            if (BarVoteActivity.this.ijv.getListView() != null) {
                                BarVoteActivity.this.ijv.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.cqf() == null) {
                                BarVoteActivity.this.ijv.HW(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.cqf().getStatus() < 1 || fVar.cqf().getStatus() > 2) {
                                BarVoteActivity.this.ijv.HW(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.ijv.getListView() != null) {
                        BarVoteActivity.this.ijv.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.ijv.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.iju != null && BarVoteActivity.this.iju.mPn == 0) {
                        if (BarVoteActivity.this.ijv.getListView() != null) {
                            BarVoteActivity.this.ijv.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.ijv.HW(str);
                    }
                } else if (BarVoteActivity.this.iju != null && BarVoteActivity.this.iju.mPn == 0) {
                    if (BarVoteActivity.this.ijv.getListView() != null) {
                        BarVoteActivity.this.ijv.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.ijv.HW(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ijv = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.iju = new BarVoteModel(this);
        this.iju.a(this.ijw);
        this.ijv.h(new a());
        new aq("c13440").an("obj_source", this.source).bsu();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new aq("c13440").an("obj_source", this.source).bsu();
    }

    public void cpD() {
        if (this.iju != null) {
            this.iju.bQy();
        }
    }

    public void reload() {
        if (this.iju != null) {
            this.iju.refresh();
        }
    }

    public void refresh() {
        if (this.iju != null) {
            this.iju.cpL();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            be.bsB().b(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.ijv != null && this.ijv.cpN() != null) {
                this.ijv.cpN().showLoading();
            }
            cpD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ijv != null) {
            this.ijv.uo(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ijv != null) {
            this.ijv.onDestroy();
        }
        if (this.iju != null) {
            this.iju.onDestroy();
        }
        super.onDestroy();
    }

    public void bQQ() {
        this.ijv.bQQ();
    }

    /* loaded from: classes7.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                BarVoteActivity.this.ijv.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.ijv.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
