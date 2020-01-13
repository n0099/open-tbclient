package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import java.util.List;
/* loaded from: classes11.dex */
public class OfficialBarHistoryActivity extends BaseActivity<OfficialBarHistoryActivity> implements BdListView.e {
    private e hsv;
    private a hsw;
    private b hsx;
    private List<ResponseHistoryMessage.a> mDataList;
    private int hsu = 0;
    private boolean egy = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initListener();
        initUI();
        initData(bundle);
    }

    private void initListener() {
        this.hsw = new a();
        this.hsx = new b();
        registerListener(this.hsw);
        registerListener(this.hsx);
    }

    private void initUI() {
        this.hsv = new e(this);
        this.hsv.c(this);
    }

    private void initData(Bundle bundle) {
        this.hsu = getIntent().getIntExtra("forum_id", 0);
        MessageManager.getInstance().sendMessage(new RequestLocalHistoryMessage(String.valueOf(this.hsu)));
        aqd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqd() {
        int i = 0;
        if (this.mDataList != null && !this.mDataList.isEmpty()) {
            i = this.mDataList.get(this.mDataList.size() - 1).id;
        }
        this.egy = true;
        MessageManager.getInstance().sendMessage(new RequestHistoryMessage(this.hsu, com.baidu.adp.lib.f.b.toLong(TbadkApplication.getCurrentAccount(), 0L), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hsv.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends CustomMessageListener {
        public b() {
            super(CmdConfigCustom.CMD_QUERY_OFFICIAL_LOCAL_HISTORY);
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
                        OfficialBarHistoryActivity.this.hsv.setData(OfficialBarHistoryActivity.this.mDataList);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends com.baidu.adp.framework.listener.c {
        public a() {
            super(CmdConfigSocket.CMD_QUERY_OFFICIAL_BAR_HISTORY);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarHistoryActivity.this.hideProgressBar();
            OfficialBarHistoryActivity.this.egy = false;
            if (socketResponsedMessage == null) {
                OfficialBarHistoryActivity.this.showToast(R.string.neterror);
                OfficialBarHistoryActivity.this.hsv.cQ(OfficialBarHistoryActivity.this.mDataList);
            } else if (socketResponsedMessage.getError() != 0) {
                OfficialBarHistoryActivity.this.showToast(socketResponsedMessage.getErrorString());
                OfficialBarHistoryActivity.this.hsv.cQ(OfficialBarHistoryActivity.this.mDataList);
            } else if (socketResponsedMessage.getCmd() != 208002 || !(socketResponsedMessage instanceof ResponseHistoryMessage)) {
                OfficialBarHistoryActivity.this.hsv.cQ(OfficialBarHistoryActivity.this.mDataList);
                OfficialBarHistoryActivity.this.showToast(R.string.neterror);
            } else {
                ResponseHistoryMessage responseHistoryMessage = (ResponseHistoryMessage) socketResponsedMessage;
                if (responseHistoryMessage.getMsg().isEmpty()) {
                    OfficialBarHistoryActivity.this.hsv.cQ(OfficialBarHistoryActivity.this.mDataList);
                    return;
                }
                RequestHistoryMessage requestHistoryMessage = (RequestHistoryMessage) responseHistoryMessage.getOrginalMessage();
                if (requestHistoryMessage == null) {
                    OfficialBarHistoryActivity.this.hsv.cQ(OfficialBarHistoryActivity.this.mDataList);
                    return;
                }
                if (requestHistoryMessage.getRequestId() != 0) {
                    OfficialBarHistoryActivity.this.mDataList.addAll(responseHistoryMessage.getMsg());
                } else {
                    OfficialBarHistoryActivity.this.mDataList = responseHistoryMessage.getMsg();
                }
                OfficialBarHistoryActivity.this.hsv.setData(OfficialBarHistoryActivity.this.mDataList);
                if (responseHistoryMessage.getMsg().size() == 0) {
                    OfficialBarHistoryActivity.this.hsv.cQ(OfficialBarHistoryActivity.this.mDataList);
                } else {
                    new Handler().post(new Runnable() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryActivity.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!OfficialBarHistoryActivity.this.hsv.bQV()) {
                                OfficialBarHistoryActivity.this.aqd();
                            }
                        }
                    });
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!this.egy) {
            aqd();
        }
    }
}
