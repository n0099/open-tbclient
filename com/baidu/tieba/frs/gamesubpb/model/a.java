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
    private String dOJ;
    private FrsGameSubPbActivity dOV;
    private InterfaceC0190a dOW;
    private boolean dOZ;
    private boolean hasMore;
    private int mForumId;
    private String dOX = "0";
    private int dOY = 1;
    private HttpMessageListener dPa = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gamesubpb.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.dOW != null) {
                if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof FrsSelectSubCommentReponseMessage) || ((FrsSelectSubCommentReponseMessage) httpResponsedMessage).getSelectSubCommentData() == null) {
                    a.this.dOW.a(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), false, a.this.dOZ, null, null);
                } else {
                    FrsSelectSubCommentReponseMessage frsSelectSubCommentReponseMessage = (FrsSelectSubCommentReponseMessage) httpResponsedMessage;
                    if (1003379 == httpResponsedMessage.getCmd()) {
                        a.this.hasMore = frsSelectSubCommentReponseMessage.getSelectSubCommentData().hasMore;
                        if (!a.this.dOZ || 1 == frsSelectSubCommentReponseMessage.getSelectSubCommentData().dOY) {
                            a.this.mDataList.clear();
                        } else {
                            a.c(a.this);
                        }
                        if (!v.J(frsSelectSubCommentReponseMessage.getSelectSubCommentData().dPj)) {
                            a.this.mDataList.addAll(frsSelectSubCommentReponseMessage.getSelectSubCommentData().dPj);
                        }
                        a.this.dOW.a(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), a.this.hasMore, a.this.dOZ, frsSelectSubCommentReponseMessage.getSelectSubCommentData().dPi, a.this.mDataList);
                    }
                }
                a.this.dOZ = false;
            }
        }
    };
    private HttpMessageListener dPb = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gamesubpb.model.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.dOW != null) {
                if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof FrsAddSubCommentResponseMessage) || ((FrsAddSubCommentResponseMessage) httpResponsedMessage).getSubCommentData() == null) {
                    a.this.dOW.a(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), null);
                    return;
                }
                FrsAddSubCommentResponseMessage frsAddSubCommentResponseMessage = (FrsAddSubCommentResponseMessage) httpResponsedMessage;
                if (1003380 == httpResponsedMessage.getCmd()) {
                    a.this.dOW.a(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), frsAddSubCommentResponseMessage.getSubCommentData());
                }
            }
        }
    };
    private HttpMessageListener dPc = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gamesubpb.model.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.dOW != null) {
                if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof FrsDeleteSubCommentResponseMessage) || ((FrsDeleteSubCommentResponseMessage) httpResponsedMessage).getSubCommentData() == null) {
                    a.this.dOW.b(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), null);
                    return;
                }
                FrsDeleteSubCommentResponseMessage frsDeleteSubCommentResponseMessage = (FrsDeleteSubCommentResponseMessage) httpResponsedMessage;
                if (1003381 == httpResponsedMessage.getCmd()) {
                    a.this.dOW.b(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), frsDeleteSubCommentResponseMessage.getSubCommentData());
                }
            }
        }
    };
    private List<h> mDataList = new ArrayList();

    /* renamed from: com.baidu.tieba.frs.gamesubpb.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0190a {
        void a(boolean z, int i, String str, d dVar);

        void a(boolean z, int i, String str, boolean z2, boolean z3, b bVar, List<h> list);

        void b(boolean z, int i, String str, d dVar);
    }

    static /* synthetic */ int c(a aVar) {
        int i = aVar.dOY;
        aVar.dOY = i + 1;
        return i;
    }

    public a(FrsGameSubPbActivity frsGameSubPbActivity, int i, String str) {
        this.dOV = frsGameSubPbActivity;
        this.mForumId = i;
        this.dOJ = str;
        aDY();
        aDZ();
        aEa();
    }

    private void aDY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SELECT_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/selectSubComment");
        tbHttpMessageTask.setResponsedClass(FrsSelectSubCommentReponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dOV.registerListener(CmdConfigHttp.CMD_SELECT_SUB_COMMENT, this.dPa);
    }

    private void aDZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/addSubComment");
        tbHttpMessageTask.setResponsedClass(FrsAddSubCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dOV.registerListener(CmdConfigHttp.CMD_ADD_SUB_COMMENT, this.dPb);
    }

    private void aEa() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DELETE_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/deleteSubComment");
        tbHttpMessageTask.setResponsedClass(FrsDeleteSubCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dOV.registerListener(CmdConfigHttp.CMD_DELETE_SUB_COMMENT, this.dPc);
    }

    public void a(InterfaceC0190a interfaceC0190a) {
        this.dOW = interfaceC0190a;
    }

    public void loadData(boolean z) {
        if (!z || this.hasMore) {
            this.dOZ = z;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SELECT_SUB_COMMENT);
            httpMessage.addParam(Config.PACKAGE_NAME, z ? this.dOY + 1 : 1);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("forum_id", this.mForumId);
            httpMessage.addParam("main_tower_id", this.dOJ);
            httpMessage.addParam(ImageViewerConfig.LAST_ID, this.dOX);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void nN(String str) {
        this.dOX = str;
    }
}
