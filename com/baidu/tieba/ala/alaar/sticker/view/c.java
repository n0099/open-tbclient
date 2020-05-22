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
    private a eXC;
    private AlaStickerTabHost eXV;
    private com.baidu.tieba.ala.alaar.sticker.view.a eXW;
    private com.baidu.tieba.ala.alaar.sticker.view.a eXX;
    private com.baidu.tieba.ala.alaar.sticker.view.a eXY;
    private BdUniqueId eXZ;
    private BdUniqueId eYa;
    private HttpMessageListener eYb;
    private HttpMessageListener eYc;

    /* loaded from: classes3.dex */
    public interface a {
        void a(FuFaceItem fuFaceItem, String str);

        void bpX();
    }

    public c(@NonNull Context context, a aVar) {
        super(context);
        this.eYb = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.eXY != null) {
                        c.this.eXY.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.eXY != null) {
                    c.this.eXY.setDatas(getArStickerListHttpResponseMessage.eWz);
                }
            }
        };
        this.eYc = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if ((httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                    if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.eXZ && c.this.eXW != null) {
                        c.this.eXW.setDatas(getPicTxtStickerListHttpResponseMessage.eWB);
                    }
                    if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.eYa && c.this.eXX != null) {
                        c.this.eXX.setDatas(getPicTxtStickerListHttpResponseMessage.eWB);
                    }
                }
            }
        };
        this.eXC = aVar;
        getContext().setTheme(a.j.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bpY();
        setContentView(a.h.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.g.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.eXV = (AlaStickerTabHost) findViewById(a.g.ala_master_sticker_view_pager);
        bpZ();
        MessageManager.getInstance().registerListener(this.eYc);
        MessageManager.getInstance().registerListener(this.eYb);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.eYc);
        MessageManager.getInstance().unRegisterListener(this.eYb);
    }

    private void bpY() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bpZ() {
        LinkedList linkedList = new LinkedList();
        if (com.baidu.live.v.a.Ge().aYP != null && com.baidu.live.v.a.Ge().aYP.aAG != null && com.baidu.live.v.a.Ge().aYP.aAG.ws()) {
            this.eXY = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.eXC);
            linkedList.add(this.eXY);
            com.baidu.tieba.ala.alaar.sticker.a.f.bpP();
        }
        this.eXV.setData(linkedList);
        this.eXZ = BdUniqueId.gen();
        this.eYa = BdUniqueId.gen();
    }
}
