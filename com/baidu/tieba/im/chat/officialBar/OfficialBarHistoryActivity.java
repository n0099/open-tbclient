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
    private e dTP;
    private a dTQ;
    private b dTR;
    private List<ResponseHistoryMessage.a> mDataList;
    private int dTO = 0;
    private boolean bkG = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initListener();
        initUI();
        initData(bundle);
    }

    private void initListener() {
        this.dTQ = new a();
        this.dTR = new b();
        registerListener(this.dTQ);
        registerListener(this.dTR);
    }

    private void initUI() {
        this.dTP = new e(this);
        this.dTP.d(this);
    }

    private void initData(Bundle bundle) {
        this.dTO = getIntent().getIntExtra("forum_id", 0);
        MessageManager.getInstance().sendMessage(new RequestLocalHistoryMessage(String.valueOf(this.dTO)));
        aBg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBg() {
        int i = 0;
        if (this.mDataList != null && !this.mDataList.isEmpty()) {
            i = this.mDataList.get(this.mDataList.size() - 1).id;
        }
        this.bkG = true;
        MessageManager.getInstance().sendMessage(new RequestHistoryMessage(this.dTO, com.baidu.adp.lib.g.b.c(TbadkApplication.getCurrentAccount(), 0L), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dTP.onChangeSkinType(i);
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
                        OfficialBarHistoryActivity.this.dTP.setData(OfficialBarHistoryActivity.this.mDataList);
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
            OfficialBarHistoryActivity.this.bkG = false;
            if (socketResponsedMessage == null) {
                OfficialBarHistoryActivity.this.showToast(d.k.neterror);
                OfficialBarHistoryActivity.this.dTP.bT(OfficialBarHistoryActivity.this.mDataList);
            } else if (socketResponsedMessage.getError() != 0) {
                OfficialBarHistoryActivity.this.showToast(socketResponsedMessage.getErrorString());
                OfficialBarHistoryActivity.this.dTP.bT(OfficialBarHistoryActivity.this.mDataList);
            } else if (socketResponsedMessage.getCmd() != 208002 || !(socketResponsedMessage instanceof ResponseHistoryMessage)) {
                OfficialBarHistoryActivity.this.dTP.bT(OfficialBarHistoryActivity.this.mDataList);
                OfficialBarHistoryActivity.this.showToast(d.k.neterror);
            } else {
                ResponseHistoryMessage responseHistoryMessage = (ResponseHistoryMessage) socketResponsedMessage;
                if (responseHistoryMessage.getMsg().isEmpty()) {
                    OfficialBarHistoryActivity.this.dTP.bT(OfficialBarHistoryActivity.this.mDataList);
                    return;
                }
                RequestHistoryMessage requestHistoryMessage = (RequestHistoryMessage) responseHistoryMessage.getOrginalMessage();
                if (requestHistoryMessage == null) {
                    OfficialBarHistoryActivity.this.dTP.bT(OfficialBarHistoryActivity.this.mDataList);
                    return;
                }
                if (requestHistoryMessage.getRequestId() != 0) {
                    OfficialBarHistoryActivity.this.mDataList.addAll(responseHistoryMessage.getMsg());
                } else {
                    OfficialBarHistoryActivity.this.mDataList = responseHistoryMessage.getMsg();
                }
                OfficialBarHistoryActivity.this.dTP.setData(OfficialBarHistoryActivity.this.mDataList);
                if (responseHistoryMessage.getMsg().size() == 0) {
                    OfficialBarHistoryActivity.this.dTP.bT(OfficialBarHistoryActivity.this.mDataList);
                } else {
                    new Handler().post(new Runnable() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryActivity.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!OfficialBarHistoryActivity.this.dTP.aBh()) {
                                OfficialBarHistoryActivity.this.aBg();
                            }
                        }
                    });
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!this.bkG) {
            aBg();
        }
    }
}
