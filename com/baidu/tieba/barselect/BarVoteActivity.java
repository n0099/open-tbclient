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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.BarVoteModel;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes3.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel ewy = null;
    private com.baidu.tieba.barselect.a ewz = null;
    BarVoteModel.a ewA = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.ewz != null && BarVoteActivity.this.ewz.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.ewz.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.aZv() == null || fVar.aZv().getStatus() < 1 || fVar.aZv().getStatus() > 2) {
                        if (BarVoteActivity.this.ewy != null && BarVoteActivity.this.ewy.mPn == 0) {
                            if (BarVoteActivity.this.ewz.getListView() != null) {
                                BarVoteActivity.this.ewz.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.aZv() == null) {
                                BarVoteActivity.this.ewz.vP(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.aZv().getStatus() < 1 || fVar.aZv().getStatus() > 2) {
                                BarVoteActivity.this.ewz.vP(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.ewz.getListView() != null) {
                        BarVoteActivity.this.ewz.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.ewz.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.ewy != null && BarVoteActivity.this.ewy.mPn == 0) {
                        if (BarVoteActivity.this.ewz.getListView() != null) {
                            BarVoteActivity.this.ewz.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.ewz.vP(str);
                    }
                } else if (BarVoteActivity.this.ewy != null && BarVoteActivity.this.ewy.mPn == 0) {
                    if (BarVoteActivity.this.ewz.getListView() != null) {
                        BarVoteActivity.this.ewz.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.ewz.vP(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ewz = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.ewy = new BarVoteModel(this);
        this.ewy.a(this.ewA);
        this.ewz.d(new a());
        new an("c13440").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.source).ajq();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new an("c13440").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.source).ajq();
    }

    public void aYU() {
        if (this.ewy != null) {
            this.ewy.aJw();
        }
    }

    public void reload() {
        if (this.ewy != null) {
            this.ewy.refresh();
        }
    }

    public void refresh() {
        if (this.ewy != null) {
            this.ewy.aZc();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            ba.ajK().c(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.ewz != null && this.ewz.aZe() != null) {
                this.ewz.aZe().showLoading();
            }
            aYU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ewz != null) {
            this.ewz.nE(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ewz != null) {
            this.ewz.onDestroy();
        }
        if (this.ewy != null) {
            this.ewy.onDestroy();
        }
        super.onDestroy();
    }

    public void aJM() {
        this.ewz.aJM();
    }

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.kt()) {
                BarVoteActivity.this.ewz.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.ewz.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
