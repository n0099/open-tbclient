package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import d.a.c.c.g.c;
import d.a.k0.e1.f.j.d;
import java.util.List;
/* loaded from: classes4.dex */
public class OfficialBarHistoryActivity extends BaseActivity<OfficialBarHistoryActivity> implements BdListView.p {
    public List<ResponseHistoryMessage.a> mDataList;
    public a mListener;
    public b mLocalListener;
    public d mView;
    public int mforumId = 0;
    public boolean isRefreshing = false;

    /* loaded from: classes4.dex */
    public class a extends c {

        /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0181a implements Runnable {
            public RunnableC0181a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (OfficialBarHistoryActivity.this.mView.f()) {
                    return;
                }
                OfficialBarHistoryActivity.this.getNextPage();
            }
        }

        public a() {
            super(208002);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            OfficialBarHistoryActivity.this.hideProgressBar();
            OfficialBarHistoryActivity.this.isRefreshing = false;
            if (socketResponsedMessage == null) {
                OfficialBarHistoryActivity.this.showToast(R.string.neterror);
                OfficialBarHistoryActivity.this.mView.j(OfficialBarHistoryActivity.this.mDataList);
            } else if (socketResponsedMessage.getError() != 0) {
                OfficialBarHistoryActivity.this.showToast(socketResponsedMessage.getErrorString());
                OfficialBarHistoryActivity.this.mView.j(OfficialBarHistoryActivity.this.mDataList);
            } else if (socketResponsedMessage.getCmd() != 208002 || !(socketResponsedMessage instanceof ResponseHistoryMessage)) {
                OfficialBarHistoryActivity.this.mView.j(OfficialBarHistoryActivity.this.mDataList);
                OfficialBarHistoryActivity.this.showToast(R.string.neterror);
            } else {
                ResponseHistoryMessage responseHistoryMessage = (ResponseHistoryMessage) socketResponsedMessage;
                if (responseHistoryMessage.getMsg().isEmpty()) {
                    OfficialBarHistoryActivity.this.mView.j(OfficialBarHistoryActivity.this.mDataList);
                    return;
                }
                RequestHistoryMessage requestHistoryMessage = (RequestHistoryMessage) responseHistoryMessage.getOrginalMessage();
                if (requestHistoryMessage == null) {
                    OfficialBarHistoryActivity.this.mView.j(OfficialBarHistoryActivity.this.mDataList);
                    return;
                }
                if (requestHistoryMessage.getRequestId() != 0) {
                    OfficialBarHistoryActivity.this.mDataList.addAll(responseHistoryMessage.getMsg());
                } else {
                    OfficialBarHistoryActivity.this.mDataList = responseHistoryMessage.getMsg();
                }
                OfficialBarHistoryActivity.this.mView.g(OfficialBarHistoryActivity.this.mDataList);
                if (responseHistoryMessage.getMsg().size() == 0) {
                    OfficialBarHistoryActivity.this.mView.j(OfficialBarHistoryActivity.this.mDataList);
                } else {
                    new Handler().post(new RunnableC0181a());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (responseLocalHistoryMessage.getData().isEmpty()) {
                    return;
                }
                if (OfficialBarHistoryActivity.this.mDataList == null || OfficialBarHistoryActivity.this.mDataList.isEmpty()) {
                    OfficialBarHistoryActivity.this.mDataList = responseLocalHistoryMessage.getData();
                    OfficialBarHistoryActivity.this.mView.g(OfficialBarHistoryActivity.this.mDataList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNextPage() {
        int i2;
        List<ResponseHistoryMessage.a> list = this.mDataList;
        if (list == null || list.isEmpty()) {
            i2 = 0;
        } else {
            List<ResponseHistoryMessage.a> list2 = this.mDataList;
            i2 = list2.get(list2.size() - 1).f17203d;
        }
        this.isRefreshing = true;
        MessageManager.getInstance().sendMessage(new RequestHistoryMessage(this.mforumId, d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), i2));
    }

    private void initData(Bundle bundle) {
        this.mforumId = getIntent().getIntExtra("forum_id", 0);
        MessageManager.getInstance().sendMessage(new RequestLocalHistoryMessage(String.valueOf(this.mforumId)));
        getNextPage();
    }

    private void initListener() {
        this.mListener = new a();
        this.mLocalListener = new b();
        registerListener(this.mListener);
        registerListener(this.mLocalListener);
    }

    private void initUI() {
        d dVar = new d(this);
        this.mView = dVar;
        dVar.h(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mView.onChangeSkinType(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initListener();
        initUI();
        initData(bundle);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        if (this.isRefreshing) {
            return;
        }
        getNextPage();
    }
}
