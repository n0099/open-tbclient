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
    private b fyO;
    private BdUniqueId fzA;
    a fzB;
    private HttpMessageListener fzC;
    private HttpMessageListener fzk;
    private AlaStickerTabHost fzv;
    private com.baidu.tieba.ala.alaar.sticker.view.a fzw;
    private com.baidu.tieba.ala.alaar.sticker.view.a fzx;
    private com.baidu.tieba.ala.alaar.sticker.view.a fzy;
    private BdUniqueId fzz;

    /* loaded from: classes7.dex */
    public interface a {
        void bEW();

        void bEX();

        void bEY();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(FuFaceItem fuFaceItem, String str);

        boolean bEO();

        void bEP();
    }

    public c(@NonNull Context context, b bVar) {
        super(context);
        this.fzB = new a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bEW() {
                com.baidu.tieba.ala.alaar.sticker.a.f.a(c.this.fzA, "text", 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bEX() {
                com.baidu.tieba.ala.alaar.sticker.a.f.a(c.this.fzz, SocialConstants.PARAM_AVATAR_URI, 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bEY() {
                com.baidu.tieba.ala.alaar.sticker.a.f.Nw();
            }
        };
        this.fzk = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.fzy != null) {
                        c.this.fzy.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.fzy != null) {
                    c.this.fzy.setDatas(getArStickerListHttpResponseMessage.fxB);
                }
            }
        };
        this.fzC = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.fzw != null) {
                        c.this.fzw.setDatas(null);
                    }
                    if (c.this.fzx != null) {
                        c.this.fzx.setDatas(null);
                        return;
                    }
                    return;
                }
                GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.fzz && c.this.fzw != null) {
                    c.this.fzw.setDatas(getPicTxtStickerListHttpResponseMessage.fxD);
                }
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.fzA && c.this.fzx != null) {
                    c.this.fzx.setDatas(getPicTxtStickerListHttpResponseMessage.fxD);
                }
            }
        };
        this.fyO = bVar;
        getContext().setTheme(a.j.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bEU();
        setContentView(a.h.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.g.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.fzv = (AlaStickerTabHost) findViewById(a.g.ala_master_sticker_view_pager);
        bEV();
        MessageManager.getInstance().registerListener(this.fzC);
        MessageManager.getInstance().registerListener(this.fzk);
    }

    public void bET() {
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fzz, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fzA, "text", 1, 50);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fzC);
        MessageManager.getInstance().unRegisterListener(this.fzk);
    }

    private void bEU() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bEV() {
        LinkedList linkedList = new LinkedList();
        this.fzw = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 1, this.fyO, this.fzB);
        linkedList.add(this.fzw);
        this.fzx = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 2, this.fyO, this.fzB);
        linkedList.add(this.fzx);
        if (com.baidu.live.w.a.Nk().bka != null && com.baidu.live.w.a.Nk().bka.aJw != null && com.baidu.live.w.a.Nk().bka.aJw.CW()) {
            this.fzy = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.fyO, this.fzB);
            linkedList.add(this.fzy);
            com.baidu.tieba.ala.alaar.sticker.a.f.Nw();
        }
        this.fzv.setData(linkedList);
        this.fzz = BdUniqueId.gen();
        this.fzA = BdUniqueId.gen();
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fzz, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fzA, "text", 1, 50);
    }
}
