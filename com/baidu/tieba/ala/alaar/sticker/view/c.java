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
/* loaded from: classes7.dex */
public class c extends Dialog {
    private b fyS;
    private com.baidu.tieba.ala.alaar.sticker.view.a fzA;
    private com.baidu.tieba.ala.alaar.sticker.view.a fzB;
    private com.baidu.tieba.ala.alaar.sticker.view.a fzC;
    private BdUniqueId fzD;
    private BdUniqueId fzE;
    a fzF;
    private HttpMessageListener fzG;
    private HttpMessageListener fzo;
    private AlaStickerTabHost fzz;

    /* loaded from: classes7.dex */
    public interface a {
        void bEX();

        void bEY();

        void bEZ();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(FuFaceItem fuFaceItem, String str);

        boolean bEP();

        void bEQ();
    }

    public c(@NonNull Context context, b bVar) {
        super(context);
        this.fzF = new a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bEX() {
                com.baidu.tieba.ala.alaar.sticker.a.f.a(c.this.fzE, "text", 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bEY() {
                com.baidu.tieba.ala.alaar.sticker.a.f.a(c.this.fzD, SocialConstants.PARAM_AVATAR_URI, 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bEZ() {
                com.baidu.tieba.ala.alaar.sticker.a.f.Nw();
            }
        };
        this.fzo = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.fzC != null) {
                        c.this.fzC.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.fzC != null) {
                    c.this.fzC.setDatas(getArStickerListHttpResponseMessage.fxF);
                }
            }
        };
        this.fzG = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.fzA != null) {
                        c.this.fzA.setDatas(null);
                    }
                    if (c.this.fzB != null) {
                        c.this.fzB.setDatas(null);
                        return;
                    }
                    return;
                }
                GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.fzD && c.this.fzA != null) {
                    c.this.fzA.setDatas(getPicTxtStickerListHttpResponseMessage.fxH);
                }
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.fzE && c.this.fzB != null) {
                    c.this.fzB.setDatas(getPicTxtStickerListHttpResponseMessage.fxH);
                }
            }
        };
        this.fyS = bVar;
        getContext().setTheme(a.j.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bEV();
        setContentView(a.h.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.g.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.fzz = (AlaStickerTabHost) findViewById(a.g.ala_master_sticker_view_pager);
        bEW();
        MessageManager.getInstance().registerListener(this.fzG);
        MessageManager.getInstance().registerListener(this.fzo);
    }

    public void bEU() {
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fzD, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fzE, "text", 1, 50);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fzG);
        MessageManager.getInstance().unRegisterListener(this.fzo);
    }

    private void bEV() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bEW() {
        LinkedList linkedList = new LinkedList();
        this.fzA = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 1, this.fyS, this.fzF);
        linkedList.add(this.fzA);
        this.fzB = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 2, this.fyS, this.fzF);
        linkedList.add(this.fzB);
        if (com.baidu.live.w.a.Nk().bkd != null && com.baidu.live.w.a.Nk().bkd.aJy != null && com.baidu.live.w.a.Nk().bkd.aJy.CW()) {
            this.fzC = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.fyS, this.fzF);
            linkedList.add(this.fzC);
            com.baidu.tieba.ala.alaar.sticker.a.f.Nw();
        }
        this.fzz.setData(linkedList);
        this.fzD = BdUniqueId.gen();
        this.fzE = BdUniqueId.gen();
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fzD, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fzE, "text", 1, 50);
    }
}
