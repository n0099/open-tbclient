package com.baidu.tieba.barselect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.BarVoteModel;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes3.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel euH = null;
    private com.baidu.tieba.barselect.a euI = null;
    BarVoteModel.a euJ = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.euI != null && BarVoteActivity.this.euI.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.euI.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.aYP() == null || fVar.aYP().getStatus() < 1 || fVar.aYP().getStatus() > 2) {
                        if (BarVoteActivity.this.euH != null && BarVoteActivity.this.euH.mPn == 0) {
                            if (BarVoteActivity.this.euI.getListView() != null) {
                                BarVoteActivity.this.euI.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.aYP() == null) {
                                BarVoteActivity.this.euI.vp(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.aYP().getStatus() < 1 || fVar.aYP().getStatus() > 2) {
                                BarVoteActivity.this.euI.vp(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.euI.getListView() != null) {
                        BarVoteActivity.this.euI.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.euI.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.euH != null && BarVoteActivity.this.euH.mPn == 0) {
                        if (BarVoteActivity.this.euI.getListView() != null) {
                            BarVoteActivity.this.euI.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.euI.vp(str);
                    }
                } else if (BarVoteActivity.this.euH != null && BarVoteActivity.this.euH.mPn == 0) {
                    if (BarVoteActivity.this.euI.getListView() != null) {
                        BarVoteActivity.this.euI.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.euI.vp(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.euI = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.euH = new BarVoteModel(this);
        this.euH.a(this.euJ);
        this.euI.d(new a());
        new an("c13440").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.source).aji();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new an("c13440").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.source).aji();
    }

    public void aYo() {
        if (this.euH != null) {
            this.euH.aIQ();
        }
    }

    public void reload() {
        if (this.euH != null) {
            this.euH.refresh();
        }
    }

    public void refresh() {
        if (this.euH != null) {
            this.euH.aYw();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            bb.ajC().c(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.euI != null && this.euI.aYy() != null) {
                this.euI.aYy().showLoading();
            }
            aYo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.euI != null) {
            this.euI.nz(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.euI != null) {
            this.euI.onDestroy();
        }
        if (this.euH != null) {
            this.euH.onDestroy();
        }
        super.onDestroy();
    }

    public void aJg() {
        this.euI.aJg();
    }

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.kt()) {
                BarVoteActivity.this.euI.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.euI.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
