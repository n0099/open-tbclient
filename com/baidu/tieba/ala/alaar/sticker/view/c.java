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
import com.baidu.live.u.a;
import com.baidu.tieba.ala.alaar.messages.GetArStickerListHttpResponseMessage;
import com.baidu.tieba.ala.alaar.messages.GetPicTxtStickerListHttpResponseMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class c extends Dialog {
    private com.baidu.tieba.ala.alaar.sticker.view.a eLA;
    private com.baidu.tieba.ala.alaar.sticker.view.a eLB;
    private BdUniqueId eLC;
    private BdUniqueId eLD;
    private HttpMessageListener eLE;
    private HttpMessageListener eLF;
    private a eLf;
    private AlaStickerTabHost eLy;
    private com.baidu.tieba.ala.alaar.sticker.view.a eLz;

    /* loaded from: classes3.dex */
    public interface a {
        void a(FuFaceItem fuFaceItem, String str);

        void bkD();
    }

    public c(@NonNull Context context, a aVar) {
        super(context);
        this.eLE = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.eLB != null) {
                        c.this.eLB.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.eLB != null) {
                    c.this.eLB.setDatas(getArStickerListHttpResponseMessage.eKc);
                }
            }
        };
        this.eLF = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if ((httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                    if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.eLC && c.this.eLz != null) {
                        c.this.eLz.setDatas(getPicTxtStickerListHttpResponseMessage.eKe);
                    }
                    if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.eLD && c.this.eLA != null) {
                        c.this.eLA.setDatas(getPicTxtStickerListHttpResponseMessage.eKe);
                    }
                }
            }
        };
        this.eLf = aVar;
        getContext().setTheme(a.j.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bkE();
        setContentView(a.h.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.g.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.eLy = (AlaStickerTabHost) findViewById(a.g.ala_master_sticker_view_pager);
        bkF();
        MessageManager.getInstance().registerListener(this.eLF);
        MessageManager.getInstance().registerListener(this.eLE);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.eLF);
        MessageManager.getInstance().unRegisterListener(this.eLE);
    }

    private void bkE() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bkF() {
        LinkedList linkedList = new LinkedList();
        if (com.baidu.live.v.a.En().aRB != null && com.baidu.live.v.a.En().aRB.avy != null && com.baidu.live.v.a.En().aRB.avy.vd()) {
            this.eLB = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.eLf);
            linkedList.add(this.eLB);
            com.baidu.tieba.ala.alaar.sticker.a.f.bkv();
        }
        this.eLy.setData(linkedList);
        this.eLC = BdUniqueId.gen();
        this.eLD = BdUniqueId.gen();
    }
}
