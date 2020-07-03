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
/* loaded from: classes3.dex */
public class a extends BdBaseModel {
    private long aZe;
    private long fTw;
    private long fYs;
    private InterfaceC0568a fZA;
    private boolean fZz;
    private boolean mHasMore;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;
    private int mPn = 1;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> mList = new ArrayList();
    private final HttpMessageListener fZB = new HttpMessageListener(1021198) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaChallengeShowAllJinzhuListResponse) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.aZD) {
                AlaChallengeShowAllJinzhuListResponse alaChallengeShowAllJinzhuListResponse = (AlaChallengeShowAllJinzhuListResponse) httpResponsedMessage;
                if (alaChallengeShowAllJinzhuListResponse.getError() != 0 || !alaChallengeShowAllJinzhuListResponse.isSuccess()) {
                    if (a.this.fZA != null) {
                        a.this.fZA.g(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), a.this.fZz);
                    }
                } else {
                    if (a.this.fZz) {
                        a.this.mList.addAll(alaChallengeShowAllJinzhuListResponse.getUserList());
                    } else {
                        a.this.mList.clear();
                        a.this.mList.addAll(alaChallengeShowAllJinzhuListResponse.getUserList());
                    }
                    a.this.mHasMore = alaChallengeShowAllJinzhuListResponse.isHasMore();
                    a.this.mPn = alaChallengeShowAllJinzhuListResponse.bmK() + 1;
                    if (a.this.fZA != null) {
                        a.this.fZA.e(a.this.mHasMore, a.this.mList);
                    }
                }
                a.this.fZz = false;
            }
        }
    };
    private BdUniqueId aZD = BdUniqueId.gen();

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0568a {
        void e(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list);

        void g(int i, String str, boolean z);
    }

    public a(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        xp();
        MessageManager.getInstance().registerListener(this.fZB);
    }

    public void a(InterfaceC0568a interfaceC0568a) {
        this.fZA = interfaceC0568a;
    }

    public void c(long j, long j2, long j3) {
        this.fYs = j;
        this.aZe = j2;
        this.fTw = j3;
    }

    public void refresh() {
        this.fZz = false;
        this.mPn = 1;
        bis();
    }

    public void btu() {
        if (this.mHasMore && !this.fZz) {
            this.fZz = true;
            bis();
        }
    }

    private void bis() {
        HttpMessage httpMessage = new HttpMessage(1021198);
        httpMessage.addParam("challenge_id", this.fYs);
        httpMessage.addParam("live_id", this.aZe);
        httpMessage.addParam("anchor_id", this.fTw);
        httpMessage.addParam("type", this.mType);
        httpMessage.addParam("page", this.mPn);
        httpMessage.setTag(this.aZD);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void xp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021198, TbConfig.SERVER_ADDRESS + "ala/challenge/getSugarDaddyRankInfo");
        tbHttpMessageTask.setResponsedClass(AlaChallengeShowAllJinzhuListResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1021198);
        MessageManager.getInstance().unRegisterListener(this.fZB);
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
