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
    private HttpMessageListener eLA;
    private a eLa;
    private AlaStickerTabHost eLt;
    private com.baidu.tieba.ala.alaar.sticker.view.a eLu;
    private com.baidu.tieba.ala.alaar.sticker.view.a eLv;
    private com.baidu.tieba.ala.alaar.sticker.view.a eLw;
    private BdUniqueId eLx;
    private BdUniqueId eLy;
    private HttpMessageListener eLz;

    /* loaded from: classes3.dex */
    public interface a {
        void a(FuFaceItem fuFaceItem, String str);

        void bkF();
    }

    public c(@NonNull Context context, a aVar) {
        super(context);
        this.eLz = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.eLw != null) {
                        c.this.eLw.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.eLw != null) {
                    c.this.eLw.setDatas(getArStickerListHttpResponseMessage.eJX);
                }
            }
        };
        this.eLA = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if ((httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                    if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.eLx && c.this.eLu != null) {
                        c.this.eLu.setDatas(getPicTxtStickerListHttpResponseMessage.eJZ);
                    }
                    if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.eLy && c.this.eLv != null) {
                        c.this.eLv.setDatas(getPicTxtStickerListHttpResponseMessage.eJZ);
                    }
                }
            }
        };
        this.eLa = aVar;
        getContext().setTheme(a.j.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bkG();
        setContentView(a.h.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.g.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.eLt = (AlaStickerTabHost) findViewById(a.g.ala_master_sticker_view_pager);
        bkH();
        MessageManager.getInstance().registerListener(this.eLA);
        MessageManager.getInstance().registerListener(this.eLz);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.eLA);
        MessageManager.getInstance().unRegisterListener(this.eLz);
    }

    private void bkG() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bkH() {
        LinkedList linkedList = new LinkedList();
        if (com.baidu.live.v.a.Eo().aRw != null && com.baidu.live.v.a.Eo().aRw.avs != null && com.baidu.live.v.a.Eo().aRw.avs.ve()) {
            this.eLw = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.eLa);
            linkedList.add(this.eLw);
            com.baidu.tieba.ala.alaar.sticker.a.f.bkx();
        }
        this.eLt.setData(linkedList);
        this.eLx = BdUniqueId.gen();
        this.eLy = BdUniqueId.gen();
    }
}
