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
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private long brr;
    private long ggl;
    private long hiH;
    private boolean hjV;
    private InterfaceC0682a hjW;
    private boolean mHasMore;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;
    private int mPn = 1;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> mList = new ArrayList();
    private final HttpMessageListener hjX = new HttpMessageListener(1021198) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaChallengeShowAllJinzhuListResponse) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.brR) {
                AlaChallengeShowAllJinzhuListResponse alaChallengeShowAllJinzhuListResponse = (AlaChallengeShowAllJinzhuListResponse) httpResponsedMessage;
                if (alaChallengeShowAllJinzhuListResponse.getError() != 0 || !alaChallengeShowAllJinzhuListResponse.isSuccess()) {
                    if (a.this.hjW != null) {
                        a.this.hjW.h(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), a.this.hjV);
                    }
                } else {
                    if (a.this.hjV) {
                        a.this.mList.addAll(alaChallengeShowAllJinzhuListResponse.getUserList());
                    } else {
                        a.this.mList.clear();
                        a.this.mList.addAll(alaChallengeShowAllJinzhuListResponse.getUserList());
                    }
                    a.this.mHasMore = alaChallengeShowAllJinzhuListResponse.isHasMore();
                    a.this.mPn = alaChallengeShowAllJinzhuListResponse.bKK() + 1;
                    if (a.this.hjW != null) {
                        a.this.hjW.e(a.this.mHasMore, a.this.mList);
                    }
                }
                a.this.hjV = false;
            }
        }
    };
    private BdUniqueId brR = BdUniqueId.gen();

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0682a {
        void e(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list);

        void h(int i, String str, boolean z);
    }

    public a(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        registerTask();
        MessageManager.getInstance().registerListener(this.hjX);
    }

    public void a(InterfaceC0682a interfaceC0682a) {
        this.hjW = interfaceC0682a;
    }

    public void c(long j, long j2, long j3) {
        this.hiH = j;
        this.brr = j2;
        this.ggl = j3;
    }

    public void refresh() {
        this.hjV = false;
        this.mPn = 1;
        bFR();
    }

    public void bRN() {
        if (this.mHasMore && !this.hjV) {
            this.hjV = true;
            bFR();
        }
    }

    private void bFR() {
        HttpMessage httpMessage = new HttpMessage(1021198);
        httpMessage.addParam("challenge_id", this.hiH);
        httpMessage.addParam("live_id", this.brr);
        httpMessage.addParam("anchor_id", this.ggl);
        httpMessage.addParam("type", this.mType);
        httpMessage.addParam("page", this.mPn);
        httpMessage.setTag(this.brR);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021198, TbConfig.SERVER_ADDRESS + "ala/challenge/getSugarDaddyRankInfo");
        tbHttpMessageTask.setResponsedClass(AlaChallengeShowAllJinzhuListResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1021198);
        MessageManager.getInstance().unRegisterListener(this.hjX);
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
