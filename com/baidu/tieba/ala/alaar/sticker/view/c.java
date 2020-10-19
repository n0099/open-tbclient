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
    private HttpMessageListener fOJ;
    private AlaStickerTabHost fOU;
    private com.baidu.tieba.ala.alaar.sticker.view.a fOV;
    private com.baidu.tieba.ala.alaar.sticker.view.a fOW;
    private com.baidu.tieba.ala.alaar.sticker.view.a fOX;
    private BdUniqueId fOY;
    private BdUniqueId fOZ;
    private b fOn;
    a fPa;
    private HttpMessageListener fPb;

    /* loaded from: classes4.dex */
    public interface a {
        void bIZ();

        void bJa();

        void bJb();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(FuFaceItem fuFaceItem, String str);

        boolean bIR();

        void bIS();
    }

    public c(@NonNull Context context, b bVar) {
        super(context);
        this.fPa = new a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bIZ() {
                com.baidu.tieba.ala.alaar.sticker.a.f.a(c.this.fOZ, "text", 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bJa() {
                com.baidu.tieba.ala.alaar.sticker.a.f.a(c.this.fOY, SocialConstants.PARAM_AVATAR_URI, 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bJb() {
                com.baidu.tieba.ala.alaar.sticker.a.f.Pe();
            }
        };
        this.fOJ = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.fOX != null) {
                        c.this.fOX.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.fOX != null) {
                    c.this.fOX.setDatas(getArStickerListHttpResponseMessage.fNa);
                }
            }
        };
        this.fPb = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.fOV != null) {
                        c.this.fOV.setDatas(null);
                    }
                    if (c.this.fOW != null) {
                        c.this.fOW.setDatas(null);
                        return;
                    }
                    return;
                }
                GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.fOY && c.this.fOV != null) {
                    c.this.fOV.setDatas(getPicTxtStickerListHttpResponseMessage.fNc);
                }
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.fOZ && c.this.fOW != null) {
                    c.this.fOW.setDatas(getPicTxtStickerListHttpResponseMessage.fNc);
                }
            }
        };
        this.fOn = bVar;
        getContext().setTheme(a.j.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bIX();
        setContentView(a.h.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.g.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.fOU = (AlaStickerTabHost) findViewById(a.g.ala_master_sticker_view_pager);
        bIY();
        MessageManager.getInstance().registerListener(this.fPb);
        MessageManager.getInstance().registerListener(this.fOJ);
    }

    public void bIW() {
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fOY, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fOZ, "text", 1, 50);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fPb);
        MessageManager.getInstance().unRegisterListener(this.fOJ);
    }

    private void bIX() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bIY() {
        LinkedList linkedList = new LinkedList();
        this.fOV = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 1, this.fOn, this.fPa);
        linkedList.add(this.fOV);
        this.fOW = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 2, this.fOn, this.fPa);
        linkedList.add(this.fOW);
        if (com.baidu.live.x.a.OS().bqJ != null && com.baidu.live.x.a.OS().bqJ.aNT != null && com.baidu.live.x.a.OS().bqJ.aNT.Ej()) {
            this.fOX = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.fOn, this.fPa);
            linkedList.add(this.fOX);
            com.baidu.tieba.ala.alaar.sticker.a.f.Pe();
        }
        this.fOU.setData(linkedList);
        this.fOY = BdUniqueId.gen();
        this.fOZ = BdUniqueId.gen();
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fOY, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fOZ, "text", 1, 50);
    }
}
