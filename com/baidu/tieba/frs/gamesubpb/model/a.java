package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private FrsGameSubPbActivity hWH;
    private InterfaceC0635a hWI;
    private boolean hWL;
    private String hWv;
    private boolean hasMore;
    private int mForumId;
    private String hWJ = "0";
    private int hWK = 1;
    private HttpMessageListener hWM = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gamesubpb.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.hWI != null) {
                if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof FrsSelectSubCommentReponseMessage) || ((FrsSelectSubCommentReponseMessage) httpResponsedMessage).getSelectSubCommentData() == null) {
                    a.this.hWI.a(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), false, a.this.hWL, null, null);
                } else {
                    FrsSelectSubCommentReponseMessage frsSelectSubCommentReponseMessage = (FrsSelectSubCommentReponseMessage) httpResponsedMessage;
                    if (1003379 == httpResponsedMessage.getCmd()) {
                        a.this.hasMore = frsSelectSubCommentReponseMessage.getSelectSubCommentData().hasMore;
                        if (!a.this.hWL || 1 == frsSelectSubCommentReponseMessage.getSelectSubCommentData().hWK) {
                            a.this.mDataList.clear();
                        } else {
                            a.c(a.this);
                        }
                        if (!x.isEmpty(frsSelectSubCommentReponseMessage.getSelectSubCommentData().hWV)) {
                            a.this.mDataList.addAll(frsSelectSubCommentReponseMessage.getSelectSubCommentData().hWV);
                        }
                        a.this.hWI.a(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), a.this.hasMore, a.this.hWL, frsSelectSubCommentReponseMessage.getSelectSubCommentData().hWU, a.this.mDataList);
                    }
                }
                a.this.hWL = false;
            }
        }
    };
    private HttpMessageListener hWN = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gamesubpb.model.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.hWI != null) {
                if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof FrsAddSubCommentResponseMessage) || ((FrsAddSubCommentResponseMessage) httpResponsedMessage).getSubCommentData() == null) {
                    a.this.hWI.a(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), null);
                    return;
                }
                FrsAddSubCommentResponseMessage frsAddSubCommentResponseMessage = (FrsAddSubCommentResponseMessage) httpResponsedMessage;
                if (1003380 == httpResponsedMessage.getCmd()) {
                    a.this.hWI.a(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), frsAddSubCommentResponseMessage.getSubCommentData());
                }
            }
        }
    };
    private HttpMessageListener hWO = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gamesubpb.model.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.hWI != null) {
                if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof FrsDeleteSubCommentResponseMessage) || ((FrsDeleteSubCommentResponseMessage) httpResponsedMessage).getSubCommentData() == null) {
                    a.this.hWI.b(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), null);
                    return;
                }
                FrsDeleteSubCommentResponseMessage frsDeleteSubCommentResponseMessage = (FrsDeleteSubCommentResponseMessage) httpResponsedMessage;
                if (1003381 == httpResponsedMessage.getCmd()) {
                    a.this.hWI.b(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), frsDeleteSubCommentResponseMessage.getSubCommentData());
                }
            }
        }
    };
    private List<q> mDataList = new ArrayList();

    /* renamed from: com.baidu.tieba.frs.gamesubpb.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0635a {
        void a(boolean z, int i, String str, d dVar);

        void a(boolean z, int i, String str, boolean z2, boolean z3, b bVar, List<q> list);

        void b(boolean z, int i, String str, d dVar);
    }

    static /* synthetic */ int c(a aVar) {
        int i = aVar.hWK;
        aVar.hWK = i + 1;
        return i;
    }

    public a(FrsGameSubPbActivity frsGameSubPbActivity, int i, String str) {
        this.hWH = frsGameSubPbActivity;
        this.mForumId = i;
        this.hWv = str;
        cgf();
        cgg();
        cgh();
    }

    private void cgf() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003379, TbConfig.SERVER_ADDRESS + "game/client/selectSubComment");
        tbHttpMessageTask.setResponsedClass(FrsSelectSubCommentReponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hWH.registerListener(1003379, this.hWM);
    }

    private void cgg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003380, TbConfig.SERVER_ADDRESS + "game/client/addSubComment");
        tbHttpMessageTask.setResponsedClass(FrsAddSubCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hWH.registerListener(1003380, this.hWN);
    }

    private void cgh() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003381, TbConfig.SERVER_ADDRESS + "game/client/deleteSubComment");
        tbHttpMessageTask.setResponsedClass(FrsDeleteSubCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hWH.registerListener(1003381, this.hWO);
    }

    public void a(InterfaceC0635a interfaceC0635a) {
        this.hWI = interfaceC0635a;
    }

    public void kn(boolean z) {
        if (!z || this.hasMore) {
            this.hWL = z;
            HttpMessage httpMessage = new HttpMessage(1003379);
            httpMessage.addParam(Config.PACKAGE_NAME, z ? this.hWK + 1 : 1);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("forum_id", this.mForumId);
            httpMessage.addParam("main_tower_id", this.hWv);
            httpMessage.addParam(ImageViewerConfig.LAST_ID, this.hWJ);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void FY(String str) {
        this.hWJ = str;
    }
}
