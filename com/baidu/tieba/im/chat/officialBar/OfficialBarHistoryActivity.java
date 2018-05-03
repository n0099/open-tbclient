package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarHistoryActivity extends BaseActivity<OfficialBarHistoryActivity> implements BdListView.e {
    private e dSI;
    private a dSJ;
    private b dSK;
    private List<ResponseHistoryMessage.a> mDataList;
    private int dSH = 0;
    private boolean bkr = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initListener();
        initUI();
        initData(bundle);
    }

    private void initListener() {
        this.dSJ = new a();
        this.dSK = new b();
        registerListener(this.dSJ);
        registerListener(this.dSK);
    }

    private void initUI() {
        this.dSI = new e(this);
        this.dSI.d(this);
    }

    private void initData(Bundle bundle) {
        this.dSH = getIntent().getIntExtra("forum_id", 0);
        MessageManager.getInstance().sendMessage(new RequestLocalHistoryMessage(String.valueOf(this.dSH)));
        aBi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBi() {
        int i = 0;
        if (this.mDataList != null && !this.mDataList.isEmpty()) {
            i = this.mDataList.get(this.mDataList.size() - 1).id;
        }
        this.bkr = true;
        MessageManager.getInstance().sendMessage(new RequestHistoryMessage(this.dSH, com.baidu.adp.lib.g.b.c(TbadkApplication.getCurrentAccount(), 0L), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dSI.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b() {
            super(2001152);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            OfficialBarHistoryActivity.this.hideProgressBar();
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001152 && (customResponsedMessage instanceof ResponseLocalHistoryMessage)) {
                ResponseLocalHistoryMessage responseLocalHistoryMessage = (ResponseLocalHistoryMessage) customResponsedMessage;
                if (!responseLocalHistoryMessage.getData().isEmpty()) {
                    if (OfficialBarHistoryActivity.this.mDataList == null || OfficialBarHistoryActivity.this.mDataList.isEmpty()) {
                        OfficialBarHistoryActivity.this.mDataList = responseLocalHistoryMessage.getData();
                        OfficialBarHistoryActivity.this.dSI.setData(OfficialBarHistoryActivity.this.mDataList);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends com.baidu.adp.framework.listener.c {
        public a() {
            super(208002);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarHistoryActivity.this.hideProgressBar();
            OfficialBarHistoryActivity.this.bkr = false;
            if (socketResponsedMessage == null) {
                OfficialBarHistoryActivity.this.showToast(d.k.neterror);
                OfficialBarHistoryActivity.this.dSI.bQ(OfficialBarHistoryActivity.this.mDataList);
            } else if (socketResponsedMessage.getError() != 0) {
                OfficialBarHistoryActivity.this.showToast(socketResponsedMessage.getErrorString());
                OfficialBarHistoryActivity.this.dSI.bQ(OfficialBarHistoryActivity.this.mDataList);
            } else if (socketResponsedMessage.getCmd() != 208002 || !(socketResponsedMessage instanceof ResponseHistoryMessage)) {
                OfficialBarHistoryActivity.this.dSI.bQ(OfficialBarHistoryActivity.this.mDataList);
                OfficialBarHistoryActivity.this.showToast(d.k.neterror);
            } else {
                ResponseHistoryMessage responseHistoryMessage = (ResponseHistoryMessage) socketResponsedMessage;
                if (responseHistoryMessage.getMsg().isEmpty()) {
                    OfficialBarHistoryActivity.this.dSI.bQ(OfficialBarHistoryActivity.this.mDataList);
                    return;
                }
                RequestHistoryMessage requestHistoryMessage = (RequestHistoryMessage) responseHistoryMessage.getOrginalMessage();
                if (requestHistoryMessage == null) {
                    OfficialBarHistoryActivity.this.dSI.bQ(OfficialBarHistoryActivity.this.mDataList);
                    return;
                }
                if (requestHistoryMessage.getRequestId() != 0) {
                    OfficialBarHistoryActivity.this.mDataList.addAll(responseHistoryMessage.getMsg());
                } else {
                    OfficialBarHistoryActivity.this.mDataList = responseHistoryMessage.getMsg();
                }
                OfficialBarHistoryActivity.this.dSI.setData(OfficialBarHistoryActivity.this.mDataList);
                if (responseHistoryMessage.getMsg().size() == 0) {
                    OfficialBarHistoryActivity.this.dSI.bQ(OfficialBarHistoryActivity.this.mDataList);
                } else {
                    new Handler().post(new Runnable() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryActivity.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!OfficialBarHistoryActivity.this.dSI.aBj()) {
                                OfficialBarHistoryActivity.this.aBi();
                            }
                        }
                    });
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!this.bkr) {
            aBi();
        }
    }
}
