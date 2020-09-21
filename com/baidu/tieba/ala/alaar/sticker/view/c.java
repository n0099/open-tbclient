package com.baidu.tieba.ala.alaar.sticker.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.alaar.messages.GetArStickerListHttpResponseMessage;
import com.baidu.tieba.ala.alaar.messages.GetPicTxtStickerListHttpResponseMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.tencent.open.SocialConstants;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class c extends Dialog {
    private HttpMessageListener fCA;
    private AlaStickerTabHost fCL;
    private com.baidu.tieba.ala.alaar.sticker.view.a fCM;
    private com.baidu.tieba.ala.alaar.sticker.view.a fCN;
    private com.baidu.tieba.ala.alaar.sticker.view.a fCO;
    private BdUniqueId fCP;
    private BdUniqueId fCQ;
    a fCR;
    private HttpMessageListener fCS;
    private b fCe;

    /* loaded from: classes4.dex */
    public interface a {
        void bGn();

        void bGo();

        void bGp();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(FuFaceItem fuFaceItem, String str);

        boolean bGf();

        void bGg();
    }

    public c(@NonNull Context context, b bVar) {
        super(context);
        this.fCR = new a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bGn() {
                com.baidu.tieba.ala.alaar.sticker.a.f.a(c.this.fCQ, "text", 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bGo() {
                com.baidu.tieba.ala.alaar.sticker.a.f.a(c.this.fCP, SocialConstants.PARAM_AVATAR_URI, 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bGp() {
                com.baidu.tieba.ala.alaar.sticker.a.f.NZ();
            }
        };
        this.fCA = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.fCO != null) {
                        c.this.fCO.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.fCO != null) {
                    c.this.fCO.setDatas(getArStickerListHttpResponseMessage.fAR);
                }
            }
        };
        this.fCS = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.fCM != null) {
                        c.this.fCM.setDatas(null);
                    }
                    if (c.this.fCN != null) {
                        c.this.fCN.setDatas(null);
                        return;
                    }
                    return;
                }
                GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.fCP && c.this.fCM != null) {
                    c.this.fCM.setDatas(getPicTxtStickerListHttpResponseMessage.fAT);
                }
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.fCQ && c.this.fCN != null) {
                    c.this.fCN.setDatas(getPicTxtStickerListHttpResponseMessage.fAT);
                }
            }
        };
        this.fCe = bVar;
        getContext().setTheme(a.j.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bGl();
        setContentView(a.h.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.g.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.fCL = (AlaStickerTabHost) findViewById(a.g.ala_master_sticker_view_pager);
        bGm();
        MessageManager.getInstance().registerListener(this.fCS);
        MessageManager.getInstance().registerListener(this.fCA);
    }

    public void bGk() {
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fCP, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fCQ, "text", 1, 50);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fCS);
        MessageManager.getInstance().unRegisterListener(this.fCA);
    }

    private void bGl() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bGm() {
        LinkedList linkedList = new LinkedList();
        this.fCM = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 1, this.fCe, this.fCR);
        linkedList.add(this.fCM);
        this.fCN = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 2, this.fCe, this.fCR);
        linkedList.add(this.fCN);
        if (com.baidu.live.x.a.NN().bmW != null && com.baidu.live.x.a.NN().bmW.aKO != null && com.baidu.live.x.a.NN().bmW.aKO.Dm()) {
            this.fCO = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.fCe, this.fCR);
            linkedList.add(this.fCO);
            com.baidu.tieba.ala.alaar.sticker.a.f.NZ();
        }
        this.fCL.setData(linkedList);
        this.fCP = BdUniqueId.gen();
        this.fCQ = BdUniqueId.gen();
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fCP, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fCQ, "text", 1, 50);
    }
}
