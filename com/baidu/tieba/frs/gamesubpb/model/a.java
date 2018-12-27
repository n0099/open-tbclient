package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.h;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private String dZf;
    private FrsGameSubPbActivity dZr;
    private InterfaceC0226a dZs;
    private boolean dZv;
    private boolean hasMore;
    private int mForumId;
    private String dZt = "0";
    private int dZu = 1;
    private HttpMessageListener dZw = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gamesubpb.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.dZs != null) {
                if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof FrsSelectSubCommentReponseMessage) || ((FrsSelectSubCommentReponseMessage) httpResponsedMessage).getSelectSubCommentData() == null) {
                    a.this.dZs.a(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), false, a.this.dZv, null, null);
                } else {
                    FrsSelectSubCommentReponseMessage frsSelectSubCommentReponseMessage = (FrsSelectSubCommentReponseMessage) httpResponsedMessage;
                    if (1003379 == httpResponsedMessage.getCmd()) {
                        a.this.hasMore = frsSelectSubCommentReponseMessage.getSelectSubCommentData().hasMore;
                        if (!a.this.dZv || 1 == frsSelectSubCommentReponseMessage.getSelectSubCommentData().dZu) {
                            a.this.mDataList.clear();
                        } else {
                            a.c(a.this);
                        }
                        if (!v.I(frsSelectSubCommentReponseMessage.getSelectSubCommentData().dZF)) {
                            a.this.mDataList.addAll(frsSelectSubCommentReponseMessage.getSelectSubCommentData().dZF);
                        }
                        a.this.dZs.a(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), a.this.hasMore, a.this.dZv, frsSelectSubCommentReponseMessage.getSelectSubCommentData().dZE, a.this.mDataList);
                    }
                }
                a.this.dZv = false;
            }
        }
    };
    private HttpMessageListener dZx = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gamesubpb.model.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.dZs != null) {
                if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof FrsAddSubCommentResponseMessage) || ((FrsAddSubCommentResponseMessage) httpResponsedMessage).getSubCommentData() == null) {
                    a.this.dZs.a(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), null);
                    return;
                }
                FrsAddSubCommentResponseMessage frsAddSubCommentResponseMessage = (FrsAddSubCommentResponseMessage) httpResponsedMessage;
                if (1003380 == httpResponsedMessage.getCmd()) {
                    a.this.dZs.a(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), frsAddSubCommentResponseMessage.getSubCommentData());
                }
            }
        }
    };
    private HttpMessageListener dZy = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gamesubpb.model.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.dZs != null) {
                if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof FrsDeleteSubCommentResponseMessage) || ((FrsDeleteSubCommentResponseMessage) httpResponsedMessage).getSubCommentData() == null) {
                    a.this.dZs.b(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), null);
                    return;
                }
                FrsDeleteSubCommentResponseMessage frsDeleteSubCommentResponseMessage = (FrsDeleteSubCommentResponseMessage) httpResponsedMessage;
                if (1003381 == httpResponsedMessage.getCmd()) {
                    a.this.dZs.b(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), frsDeleteSubCommentResponseMessage.getSubCommentData());
                }
            }
        }
    };
    private List<h> mDataList = new ArrayList();

    /* renamed from: com.baidu.tieba.frs.gamesubpb.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0226a {
        void a(boolean z, int i, String str, d dVar);

        void a(boolean z, int i, String str, boolean z2, boolean z3, b bVar, List<h> list);

        void b(boolean z, int i, String str, d dVar);
    }

    static /* synthetic */ int c(a aVar) {
        int i = aVar.dZu;
        aVar.dZu = i + 1;
        return i;
    }

    public a(FrsGameSubPbActivity frsGameSubPbActivity, int i, String str) {
        this.dZr = frsGameSubPbActivity;
        this.mForumId = i;
        this.dZf = str;
        aFT();
        aFU();
        aFV();
    }

    private void aFT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SELECT_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/selectSubComment");
        tbHttpMessageTask.setResponsedClass(FrsSelectSubCommentReponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dZr.registerListener(CmdConfigHttp.CMD_SELECT_SUB_COMMENT, this.dZw);
    }

    private void aFU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/addSubComment");
        tbHttpMessageTask.setResponsedClass(FrsAddSubCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dZr.registerListener(CmdConfigHttp.CMD_ADD_SUB_COMMENT, this.dZx);
    }

    private void aFV() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DELETE_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/deleteSubComment");
        tbHttpMessageTask.setResponsedClass(FrsDeleteSubCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dZr.registerListener(CmdConfigHttp.CMD_DELETE_SUB_COMMENT, this.dZy);
    }

    public void a(InterfaceC0226a interfaceC0226a) {
        this.dZs = interfaceC0226a;
    }

    public void loadData(boolean z) {
        if (!z || this.hasMore) {
            this.dZv = z;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SELECT_SUB_COMMENT);
            httpMessage.addParam(Config.PACKAGE_NAME, z ? this.dZu + 1 : 1);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("forum_id", this.mForumId);
            httpMessage.addParam("main_tower_id", this.dZf);
            httpMessage.addParam(ImageViewerConfig.LAST_ID, this.dZt);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void os(String str) {
        this.dZt = str;
    }
}
