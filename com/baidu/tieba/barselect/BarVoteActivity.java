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
    private BarVoteModel euO = null;
    private com.baidu.tieba.barselect.a euP = null;
    BarVoteModel.a euQ = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.euP != null && BarVoteActivity.this.euP.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.euP.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.aYR() == null || fVar.aYR().getStatus() < 1 || fVar.aYR().getStatus() > 2) {
                        if (BarVoteActivity.this.euO != null && BarVoteActivity.this.euO.mPn == 0) {
                            if (BarVoteActivity.this.euP.getListView() != null) {
                                BarVoteActivity.this.euP.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.aYR() == null) {
                                BarVoteActivity.this.euP.vq(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.aYR().getStatus() < 1 || fVar.aYR().getStatus() > 2) {
                                BarVoteActivity.this.euP.vq(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.euP.getListView() != null) {
                        BarVoteActivity.this.euP.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.euP.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.euO != null && BarVoteActivity.this.euO.mPn == 0) {
                        if (BarVoteActivity.this.euP.getListView() != null) {
                            BarVoteActivity.this.euP.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.euP.vq(str);
                    }
                } else if (BarVoteActivity.this.euO != null && BarVoteActivity.this.euO.mPn == 0) {
                    if (BarVoteActivity.this.euP.getListView() != null) {
                        BarVoteActivity.this.euP.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.euP.vq(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.euP = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.euO = new BarVoteModel(this);
        this.euO.a(this.euQ);
        this.euP.d(new a());
        new an("c13440").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.source).ajk();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new an("c13440").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.source).ajk();
    }

    public void aYq() {
        if (this.euO != null) {
            this.euO.aIS();
        }
    }

    public void reload() {
        if (this.euO != null) {
            this.euO.refresh();
        }
    }

    public void refresh() {
        if (this.euO != null) {
            this.euO.aYy();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            bb.ajE().c(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.euP != null && this.euP.aYA() != null) {
                this.euP.aYA().showLoading();
            }
            aYq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.euP != null) {
            this.euP.nA(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.euP != null) {
            this.euP.onDestroy();
        }
        if (this.euO != null) {
            this.euO.onDestroy();
        }
        super.onDestroy();
    }

    public void aJi() {
        this.euP.aJi();
    }

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.kt()) {
                BarVoteActivity.this.euP.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.euP.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
