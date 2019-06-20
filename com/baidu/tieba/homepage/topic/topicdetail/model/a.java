package com.baidu.tieba.homepage.topic.topicdetail.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView;
import java.util.Date;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class a {
    private BdUniqueId cwi;
    private final com.baidu.adp.framework.listener.a eHz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.homepage.topic.topicdetail.model.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                a.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                a.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private TopicDetailView gfF;

    public a(TopicDetailView topicDetailView) {
        this.gfF = topicDetailView;
    }

    public void i(BdUniqueId bdUniqueId) {
        this.cwi = bdUniqueId;
        this.eHz.setTag(bdUniqueId);
        this.eHz.getHttpMessageListener().setSelfListener(true);
        this.eHz.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.eHz);
    }

    public RunnableC0322a p(long j, long j2) {
        return new RunnableC0322a(j2, j);
    }

    /* renamed from: com.baidu.tieba.homepage.topic.topicdetail.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0322a implements Runnable {
        private long postId;
        private long threadId;

        public RunnableC0322a(long j, long j2) {
            this.threadId = j;
            this.postId = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int af = l.af(TbadkCoreApplication.getInst());
            int ah = l.ah(TbadkCoreApplication.getInst());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i = 1;
            if (ar.ail().ain()) {
                i = 2;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(a.this.cwi);
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, af, ah, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i == 0 && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder2.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.author = builder2.build(true);
            ThreadInfo build = builder.build(true);
            bg bgVar = new bg();
            bgVar.a(build);
            bgVar.ap(new Date().getTime());
            if (k.V(bgVar)) {
                this.gfF.ar(bgVar);
            }
        }
    }

    private void a(User.Builder builder, User_Info user_Info) {
        if (user_Info != null) {
            builder.id = user_Info.id;
            builder.gender = user_Info.gender;
            builder.type = user_Info.type;
            builder.name = user_Info.name;
            builder.name_show = user_Info.name_show;
            builder.portrait = user_Info.portrait;
            builder.god_data = user_Info.god_data;
            builder.fans_num = user_Info.fans_num;
        }
    }
}
