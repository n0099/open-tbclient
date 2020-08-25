package com.baidu.tieba.ala.liveroom.challenge.b;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaChallengeShowAllJinzhuListResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BdBaseModel {
    private long bew;
    private long fuJ;
    private long gpI;
    private boolean gqP;
    private InterfaceC0625a gqQ;
    private boolean mHasMore;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;
    private int mPn = 1;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> mList = new ArrayList();
    private final HttpMessageListener gqR = new HttpMessageListener(1021198) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaChallengeShowAllJinzhuListResponse) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.beV) {
                AlaChallengeShowAllJinzhuListResponse alaChallengeShowAllJinzhuListResponse = (AlaChallengeShowAllJinzhuListResponse) httpResponsedMessage;
                if (alaChallengeShowAllJinzhuListResponse.getError() != 0 || !alaChallengeShowAllJinzhuListResponse.isSuccess()) {
                    if (a.this.gqQ != null) {
                        a.this.gqQ.f(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), a.this.gqP);
                    }
                } else {
                    if (a.this.gqP) {
                        a.this.mList.addAll(alaChallengeShowAllJinzhuListResponse.getUserList());
                    } else {
                        a.this.mList.clear();
                        a.this.mList.addAll(alaChallengeShowAllJinzhuListResponse.getUserList());
                    }
                    a.this.mHasMore = alaChallengeShowAllJinzhuListResponse.isHasMore();
                    a.this.mPn = alaChallengeShowAllJinzhuListResponse.bzD() + 1;
                    if (a.this.gqQ != null) {
                        a.this.gqQ.f(a.this.mHasMore, a.this.mList);
                    }
                }
                a.this.gqP = false;
            }
        }
    };
    private BdUniqueId beV = BdUniqueId.gen();

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0625a {
        void f(int i, String str, boolean z);

        void f(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list);
    }

    public a(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        registerTask();
        MessageManager.getInstance().registerListener(this.gqR);
    }

    public void a(InterfaceC0625a interfaceC0625a) {
        this.gqQ = interfaceC0625a;
    }

    public void c(long j, long j2, long j3) {
        this.gpI = j;
        this.bew = j2;
        this.fuJ = j3;
    }

    public void refresh() {
        this.gqP = false;
        this.mPn = 1;
        buQ();
    }

    public void bFD() {
        if (this.mHasMore && !this.gqP) {
            this.gqP = true;
            buQ();
        }
    }

    private void buQ() {
        HttpMessage httpMessage = new HttpMessage(1021198);
        httpMessage.addParam("challenge_id", this.gpI);
        httpMessage.addParam("live_id", this.bew);
        httpMessage.addParam("anchor_id", this.fuJ);
        httpMessage.addParam("type", this.mType);
        httpMessage.addParam("page", this.mPn);
        httpMessage.setTag(this.beV);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021198, TbConfig.SERVER_ADDRESS + "ala/challenge/getSugarDaddyRankInfo");
        tbHttpMessageTask.setResponsedClass(AlaChallengeShowAllJinzhuListResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1021198);
        MessageManager.getInstance().unRegisterListener(this.gqR);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
