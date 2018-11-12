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
    private String dPM;
    private FrsGameSubPbActivity dPY;
    private InterfaceC0215a dPZ;
    private boolean dQc;
    private boolean hasMore;
    private int mForumId;
    private String dQa = "0";
    private int dQb = 1;
    private HttpMessageListener dQd = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gamesubpb.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.dPZ != null) {
                if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof FrsSelectSubCommentReponseMessage) || ((FrsSelectSubCommentReponseMessage) httpResponsedMessage).getSelectSubCommentData() == null) {
                    a.this.dPZ.a(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), false, a.this.dQc, null, null);
                } else {
                    FrsSelectSubCommentReponseMessage frsSelectSubCommentReponseMessage = (FrsSelectSubCommentReponseMessage) httpResponsedMessage;
                    if (1003379 == httpResponsedMessage.getCmd()) {
                        a.this.hasMore = frsSelectSubCommentReponseMessage.getSelectSubCommentData().hasMore;
                        if (!a.this.dQc || 1 == frsSelectSubCommentReponseMessage.getSelectSubCommentData().dQb) {
                            a.this.mDataList.clear();
                        } else {
                            a.c(a.this);
                        }
                        if (!v.I(frsSelectSubCommentReponseMessage.getSelectSubCommentData().dQm)) {
                            a.this.mDataList.addAll(frsSelectSubCommentReponseMessage.getSelectSubCommentData().dQm);
                        }
                        a.this.dPZ.a(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), a.this.hasMore, a.this.dQc, frsSelectSubCommentReponseMessage.getSelectSubCommentData().dQl, a.this.mDataList);
                    }
                }
                a.this.dQc = false;
            }
        }
    };
    private HttpMessageListener dQe = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gamesubpb.model.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.dPZ != null) {
                if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof FrsAddSubCommentResponseMessage) || ((FrsAddSubCommentResponseMessage) httpResponsedMessage).getSubCommentData() == null) {
                    a.this.dPZ.a(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), null);
                    return;
                }
                FrsAddSubCommentResponseMessage frsAddSubCommentResponseMessage = (FrsAddSubCommentResponseMessage) httpResponsedMessage;
                if (1003380 == httpResponsedMessage.getCmd()) {
                    a.this.dPZ.a(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), frsAddSubCommentResponseMessage.getSubCommentData());
                }
            }
        }
    };
    private HttpMessageListener dQf = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gamesubpb.model.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.dPZ != null) {
                if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof FrsDeleteSubCommentResponseMessage) || ((FrsDeleteSubCommentResponseMessage) httpResponsedMessage).getSubCommentData() == null) {
                    a.this.dPZ.b(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), null);
                    return;
                }
                FrsDeleteSubCommentResponseMessage frsDeleteSubCommentResponseMessage = (FrsDeleteSubCommentResponseMessage) httpResponsedMessage;
                if (1003381 == httpResponsedMessage.getCmd()) {
                    a.this.dPZ.b(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), frsDeleteSubCommentResponseMessage.getSubCommentData());
                }
            }
        }
    };
    private List<h> mDataList = new ArrayList();

    /* renamed from: com.baidu.tieba.frs.gamesubpb.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0215a {
        void a(boolean z, int i, String str, d dVar);

        void a(boolean z, int i, String str, boolean z2, boolean z3, b bVar, List<h> list);

        void b(boolean z, int i, String str, d dVar);
    }

    static /* synthetic */ int c(a aVar) {
        int i = aVar.dQb;
        aVar.dQb = i + 1;
        return i;
    }

    public a(FrsGameSubPbActivity frsGameSubPbActivity, int i, String str) {
        this.dPY = frsGameSubPbActivity;
        this.mForumId = i;
        this.dPM = str;
        aDs();
        aDt();
        aDu();
    }

    private void aDs() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SELECT_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/selectSubComment");
        tbHttpMessageTask.setResponsedClass(FrsSelectSubCommentReponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dPY.registerListener(CmdConfigHttp.CMD_SELECT_SUB_COMMENT, this.dQd);
    }

    private void aDt() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/addSubComment");
        tbHttpMessageTask.setResponsedClass(FrsAddSubCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dPY.registerListener(CmdConfigHttp.CMD_ADD_SUB_COMMENT, this.dQe);
    }

    private void aDu() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DELETE_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/deleteSubComment");
        tbHttpMessageTask.setResponsedClass(FrsDeleteSubCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dPY.registerListener(CmdConfigHttp.CMD_DELETE_SUB_COMMENT, this.dQf);
    }

    public void a(InterfaceC0215a interfaceC0215a) {
        this.dPZ = interfaceC0215a;
    }

    public void loadData(boolean z) {
        if (!z || this.hasMore) {
            this.dQc = z;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SELECT_SUB_COMMENT);
            httpMessage.addParam(Config.PACKAGE_NAME, z ? this.dQb + 1 : 1);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("forum_id", this.mForumId);
            httpMessage.addParam("main_tower_id", this.dPM);
            httpMessage.addParam(ImageViewerConfig.LAST_ID, this.dQa);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void nO(String str) {
        this.dQa = str;
    }
}
