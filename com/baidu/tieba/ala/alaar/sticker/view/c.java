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
/* loaded from: classes3.dex */
public class c extends Dialog {
    private HttpMessageListener fiH;
    private AlaStickerTabHost fiS;
    private com.baidu.tieba.ala.alaar.sticker.view.a fiT;
    private com.baidu.tieba.ala.alaar.sticker.view.a fiU;
    private com.baidu.tieba.ala.alaar.sticker.view.a fiV;
    private BdUniqueId fiW;
    private BdUniqueId fiX;
    private HttpMessageListener fiY;
    private a fil;

    /* loaded from: classes3.dex */
    public interface a {
        void a(FuFaceItem fuFaceItem, String str);

        boolean bsK();

        void bsL();
    }

    public c(@NonNull Context context, a aVar) {
        super(context);
        this.fiH = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.fiV != null) {
                        c.this.fiV.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.fiV != null) {
                    c.this.fiV.setDatas(getArStickerListHttpResponseMessage.fgX);
                }
            }
        };
        this.fiY = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if ((httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                    if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.fiW && c.this.fiT != null) {
                        c.this.fiT.setDatas(getPicTxtStickerListHttpResponseMessage.fgZ);
                    }
                    if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.fiX && c.this.fiU != null) {
                        c.this.fiU.setDatas(getPicTxtStickerListHttpResponseMessage.fgZ);
                    }
                }
            }
        };
        this.fil = aVar;
        getContext().setTheme(a.j.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bsQ();
        setContentView(a.h.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.g.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.fiS = (AlaStickerTabHost) findViewById(a.g.ala_master_sticker_view_pager);
        bsR();
        MessageManager.getInstance().registerListener(this.fiY);
        MessageManager.getInstance().registerListener(this.fiH);
    }

    public void bsP() {
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fiW, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fiX, "text", 1, 50);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fiY);
        MessageManager.getInstance().unRegisterListener(this.fiH);
    }

    private void bsQ() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bsR() {
        LinkedList linkedList = new LinkedList();
        this.fiT = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 1, this.fil);
        linkedList.add(this.fiT);
        this.fiU = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 2, this.fil);
        linkedList.add(this.fiU);
        if (com.baidu.live.v.a.Hm().bdV != null && com.baidu.live.v.a.Hm().bdV.aCR != null && com.baidu.live.v.a.Hm().bdV.aCR.wQ()) {
            this.fiV = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.fil);
            linkedList.add(this.fiV);
            com.baidu.tieba.ala.alaar.sticker.a.f.Hx();
        }
        this.fiS.setData(linkedList);
        this.fiW = BdUniqueId.gen();
        this.fiX = BdUniqueId.gen();
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fiW, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fiX, "text", 1, 50);
    }
}
