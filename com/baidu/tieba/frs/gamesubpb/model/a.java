package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private String dui;
    private FrsGameSubPbActivity duu;
    private InterfaceC0156a duv;
    private boolean duy;
    private boolean hasMore;
    private int mForumId;
    private String duw = "0";
    private int dux = 1;
    private HttpMessageListener duz = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gamesubpb.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.duv != null) {
                if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof FrsSelectSubCommentReponseMessage) || ((FrsSelectSubCommentReponseMessage) httpResponsedMessage).getSelectSubCommentData() == null) {
                    a.this.duv.a(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), false, a.this.duy, null, null);
                } else {
                    FrsSelectSubCommentReponseMessage frsSelectSubCommentReponseMessage = (FrsSelectSubCommentReponseMessage) httpResponsedMessage;
                    if (1003379 == httpResponsedMessage.getCmd()) {
                        a.this.hasMore = frsSelectSubCommentReponseMessage.getSelectSubCommentData().hasMore;
                        if (!a.this.duy || 1 == frsSelectSubCommentReponseMessage.getSelectSubCommentData().dux) {
                            a.this.mDataList.clear();
                        } else {
                            a.c(a.this);
                        }
                        if (!w.z(frsSelectSubCommentReponseMessage.getSelectSubCommentData().duI)) {
                            a.this.mDataList.addAll(frsSelectSubCommentReponseMessage.getSelectSubCommentData().duI);
                        }
                        a.this.duv.a(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), a.this.hasMore, a.this.duy, frsSelectSubCommentReponseMessage.getSelectSubCommentData().duH, a.this.mDataList);
                    }
                }
                a.this.duy = false;
            }
        }
    };
    private HttpMessageListener duA = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gamesubpb.model.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.duv != null) {
                if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof FrsAddSubCommentResponseMessage) || ((FrsAddSubCommentResponseMessage) httpResponsedMessage).getSubCommentData() == null) {
                    a.this.duv.a(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), null);
                    return;
                }
                FrsAddSubCommentResponseMessage frsAddSubCommentResponseMessage = (FrsAddSubCommentResponseMessage) httpResponsedMessage;
                if (1003380 == httpResponsedMessage.getCmd()) {
                    a.this.duv.a(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), frsAddSubCommentResponseMessage.getSubCommentData());
                }
            }
        }
    };
    private HttpMessageListener duB = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gamesubpb.model.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.duv != null) {
                if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof FrsDeleteSubCommentResponseMessage) || ((FrsDeleteSubCommentResponseMessage) httpResponsedMessage).getSubCommentData() == null) {
                    a.this.duv.b(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), null);
                    return;
                }
                FrsDeleteSubCommentResponseMessage frsDeleteSubCommentResponseMessage = (FrsDeleteSubCommentResponseMessage) httpResponsedMessage;
                if (1003381 == httpResponsedMessage.getCmd()) {
                    a.this.duv.b(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), frsDeleteSubCommentResponseMessage.getSubCommentData());
                }
            }
        }
    };
    private List<h> mDataList = new ArrayList();

    /* renamed from: com.baidu.tieba.frs.gamesubpb.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0156a {
        void a(boolean z, int i, String str, d dVar);

        void a(boolean z, int i, String str, boolean z2, boolean z3, b bVar, List<h> list);

        void b(boolean z, int i, String str, d dVar);
    }

    static /* synthetic */ int c(a aVar) {
        int i = aVar.dux;
        aVar.dux = i + 1;
        return i;
    }

    public a(FrsGameSubPbActivity frsGameSubPbActivity, int i, String str) {
        this.duu = frsGameSubPbActivity;
        this.mForumId = i;
        this.dui = str;
        axi();
        axj();
        axk();
    }

    private void axi() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SELECT_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/selectSubComment");
        tbHttpMessageTask.setResponsedClass(FrsSelectSubCommentReponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.duu.registerListener(CmdConfigHttp.CMD_SELECT_SUB_COMMENT, this.duz);
    }

    private void axj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/addSubComment");
        tbHttpMessageTask.setResponsedClass(FrsAddSubCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.duu.registerListener(CmdConfigHttp.CMD_ADD_SUB_COMMENT, this.duA);
    }

    private void axk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DELETE_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/deleteSubComment");
        tbHttpMessageTask.setResponsedClass(FrsDeleteSubCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.duu.registerListener(CmdConfigHttp.CMD_DELETE_SUB_COMMENT, this.duB);
    }

    public void a(InterfaceC0156a interfaceC0156a) {
        this.duv = interfaceC0156a;
    }

    public void loadData(boolean z) {
        if (!z || this.hasMore) {
            this.duy = z;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SELECT_SUB_COMMENT);
            httpMessage.addParam("pn", z ? this.dux + 1 : 1);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("forum_id", this.mForumId);
            httpMessage.addParam("main_tower_id", this.dui);
            httpMessage.addParam(ImageViewerConfig.LAST_ID, this.duw);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void mH(String str) {
        this.duw = str;
    }
}
