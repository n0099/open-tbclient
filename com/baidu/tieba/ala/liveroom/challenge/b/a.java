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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.ala.liveroom.challenge.message.AlaChallengeShowAllJinzhuListResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BdBaseModel {
    private long brk;
    private long gmc;
    private long hpW;
    private boolean hrk;
    private InterfaceC0657a hrl;
    private boolean mHasMore;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;
    private int mPn = 1;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> mList = new ArrayList();
    private final HttpMessageListener hrm = new HttpMessageListener(1021198) { // from class: com.baidu.tieba.ala.liveroom.challenge.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaChallengeShowAllJinzhuListResponse) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.brL) {
                AlaChallengeShowAllJinzhuListResponse alaChallengeShowAllJinzhuListResponse = (AlaChallengeShowAllJinzhuListResponse) httpResponsedMessage;
                UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SUGARDADDYRANKINFO_RESULT, "author_liveroom", !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 ? "challenge_sugardaddyrankinfo_s" : "challenge_getsugardaddyrankinfo_fail"), httpResponsedMessage, true);
                if (alaChallengeShowAllJinzhuListResponse.getError() != 0 || !alaChallengeShowAllJinzhuListResponse.isSuccess()) {
                    if (a.this.hrl != null) {
                        a.this.hrl.h(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), a.this.hrk);
                    }
                } else {
                    if (a.this.hrk) {
                        a.this.mList.addAll(alaChallengeShowAllJinzhuListResponse.getUserList());
                    } else {
                        a.this.mList.clear();
                        a.this.mList.addAll(alaChallengeShowAllJinzhuListResponse.getUserList());
                    }
                    a.this.mHasMore = alaChallengeShowAllJinzhuListResponse.isHasMore();
                    a.this.mPn = alaChallengeShowAllJinzhuListResponse.bJl() + 1;
                    if (a.this.hrl != null) {
                        a.this.hrl.f(a.this.mHasMore, a.this.mList);
                    }
                }
                a.this.hrk = false;
            }
        }
    };
    private BdUniqueId brL = BdUniqueId.gen();

    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0657a {
        void f(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list);

        void h(int i, String str, boolean z);
    }

    public a(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        registerTask();
        MessageManager.getInstance().registerListener(this.hrm);
    }

    public void a(InterfaceC0657a interfaceC0657a) {
        this.hrl = interfaceC0657a;
    }

    public void c(long j, long j2, long j3) {
        this.hpW = j;
        this.brk = j2;
        this.gmc = j3;
    }

    public void refresh() {
        this.hrk = false;
        this.mPn = 1;
        bEv();
    }

    public void bQy() {
        if (this.mHasMore && !this.hrk) {
            this.hrk = true;
            bEv();
        }
    }

    private void bEv() {
        HttpMessage httpMessage = new HttpMessage(1021198);
        httpMessage.addParam("challenge_id", this.hpW);
        httpMessage.addParam("live_id", this.brk);
        httpMessage.addParam("anchor_id", this.gmc);
        httpMessage.addParam("type", this.mType);
        httpMessage.addParam("page", this.mPn);
        httpMessage.setTag(this.brL);
        MessageManager.getInstance().sendMessage(httpMessage);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SUGARDADDYRANKINFO, "author_liveroom", ""));
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021198, TbConfig.SERVER_ADDRESS + "ala/challenge/getSugarDaddyRankInfo");
        tbHttpMessageTask.setResponsedClass(AlaChallengeShowAllJinzhuListResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1021198);
        MessageManager.getInstance().unRegisterListener(this.hrm);
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
