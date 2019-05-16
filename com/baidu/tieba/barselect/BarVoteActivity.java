package com.baidu.tieba.barselect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.BarVoteModel;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes3.dex */
public class BarVoteActivity extends BaseActivity {
    public long fid;
    public int source;
    public BdUniqueId mPageId = BdUniqueId.gen();
    private BarVoteModel epI = null;
    private com.baidu.tieba.barselect.a epJ = null;
    BarVoteModel.a epK = new BarVoteModel.a() { // from class: com.baidu.tieba.barselect.BarVoteActivity.1
        @Override // com.baidu.tieba.barselect.BarVoteModel.a
        public void a(int i, String str, f fVar) {
            if (BarVoteActivity.this.epJ != null && BarVoteActivity.this.epJ.getRootView() != null) {
                BarVoteActivity.this.hideLoadingView(BarVoteActivity.this.epJ.getRootView());
                if (i == 0) {
                    if (fVar == null || fVar.aWQ() == null || fVar.aWQ().getStatus() < 1 || fVar.aWQ().getStatus() > 2) {
                        if (BarVoteActivity.this.epI != null && BarVoteActivity.this.epI.mPn == 0) {
                            if (BarVoteActivity.this.epJ.getListView() != null) {
                                BarVoteActivity.this.epJ.getListView().setVisibility(8);
                            }
                            if (fVar == null || fVar.aWQ() == null) {
                                BarVoteActivity.this.epJ.uL(TbadkCoreApplication.getInst().getString(R.string.no_data_text));
                                return;
                            } else if (fVar.aWQ().getStatus() < 1 || fVar.aWQ().getStatus() > 2) {
                                BarVoteActivity.this.epJ.uL(TbadkCoreApplication.getInst().getString(R.string.error_status));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (BarVoteActivity.this.epJ.getListView() != null) {
                        BarVoteActivity.this.epJ.getListView().setVisibility(0);
                    }
                    if (BarVoteActivity.this.fid != 0) {
                        fVar.setFid(BarVoteActivity.this.fid);
                    }
                    if (fVar.getUniqueId() == null) {
                        fVar.setUniqueId(BarVoteActivity.this.mPageId);
                    }
                    BarVoteActivity.this.epJ.setData(fVar);
                } else if (i == 2430005) {
                    if (BarVoteActivity.this.epI != null && BarVoteActivity.this.epI.mPn == 0) {
                        if (BarVoteActivity.this.epJ.getListView() != null) {
                            BarVoteActivity.this.epJ.getListView().setVisibility(8);
                        }
                        BarVoteActivity.this.epJ.uL(str);
                    }
                } else if (BarVoteActivity.this.epI != null && BarVoteActivity.this.epI.mPn == 0) {
                    if (BarVoteActivity.this.epJ.getListView() != null) {
                        BarVoteActivity.this.epJ.getListView().setVisibility(8);
                    }
                    BarVoteActivity.this.epJ.uL(TbadkCoreApplication.getInst().getString(R.string.error_status));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.epJ = new com.baidu.tieba.barselect.a(this);
        this.fid = getIntent().getLongExtra("fid", 0L);
        this.source = getIntent().getIntExtra("source", 0);
        this.epI = new BarVoteModel(this);
        this.epI.a(this.epK);
        this.epJ.d(new a());
        new am("c13440").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.source).aif();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.fid = intent.getLongExtra("fid", 0L);
        this.source = intent.getIntExtra("source", 0);
        reload();
        new am("c13440").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.source).aif();
    }

    public void aWp() {
        if (this.epI != null) {
            this.epI.aHq();
        }
    }

    public void reload() {
        if (this.epI != null) {
            this.epI.refresh();
        }
    }

    public void refresh() {
        if (this.epI != null) {
            this.epI.aWx();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.right_textview) {
            ba.aiz().c(getPageContext(), new String[]{"http://c.tieba.baidu.com/mo/q/bzrecruitrule?nomenu=1"});
        } else if (view.getId() == R.id.pb_more) {
            if (this.epJ != null && this.epJ.aWz() != null) {
                this.epJ.aWz().showLoading();
            }
            aWp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.epJ != null) {
            this.epJ.nq(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.epJ != null) {
            this.epJ.onDestroy();
        }
        if (this.epI != null) {
            this.epI.onDestroy();
        }
        super.onDestroy();
    }

    public void aHG() {
        this.epJ.aHG();
    }

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.ki()) {
                BarVoteActivity.this.epJ.hideNoDataView();
                BarVoteActivity.this.showLoadingView(BarVoteActivity.this.epJ.getRootView());
                BarVoteActivity.this.reload();
            }
        }
    }
}
