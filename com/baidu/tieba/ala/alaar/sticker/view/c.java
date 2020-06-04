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
    private a eXN;
    private AlaStickerTabHost eYg;
    private com.baidu.tieba.ala.alaar.sticker.view.a eYh;
    private com.baidu.tieba.ala.alaar.sticker.view.a eYi;
    private com.baidu.tieba.ala.alaar.sticker.view.a eYj;
    private BdUniqueId eYk;
    private BdUniqueId eYl;
    private HttpMessageListener eYm;
    private HttpMessageListener eYn;

    /* loaded from: classes3.dex */
    public interface a {
        void a(FuFaceItem fuFaceItem, String str);

        void bpZ();
    }

    public c(@NonNull Context context, a aVar) {
        super(context);
        this.eYm = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.eYj != null) {
                        c.this.eYj.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.eYj != null) {
                    c.this.eYj.setDatas(getArStickerListHttpResponseMessage.eWK);
                }
            }
        };
        this.eYn = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if ((httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                    if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.eYk && c.this.eYh != null) {
                        c.this.eYh.setDatas(getPicTxtStickerListHttpResponseMessage.eWM);
                    }
                    if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.eYl && c.this.eYi != null) {
                        c.this.eYi.setDatas(getPicTxtStickerListHttpResponseMessage.eWM);
                    }
                }
            }
        };
        this.eXN = aVar;
        getContext().setTheme(a.j.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bqa();
        setContentView(a.h.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.g.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.eYg = (AlaStickerTabHost) findViewById(a.g.ala_master_sticker_view_pager);
        bqb();
        MessageManager.getInstance().registerListener(this.eYn);
        MessageManager.getInstance().registerListener(this.eYm);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.eYn);
        MessageManager.getInstance().unRegisterListener(this.eYm);
    }

    private void bqa() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bqb() {
        LinkedList linkedList = new LinkedList();
        if (com.baidu.live.v.a.Ge().aYP != null && com.baidu.live.v.a.Ge().aYP.aAG != null && com.baidu.live.v.a.Ge().aYP.aAG.ws()) {
            this.eYj = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.eXN);
            linkedList.add(this.eYj);
            com.baidu.tieba.ala.alaar.sticker.a.f.bpR();
        }
        this.eYg.setData(linkedList);
        this.eYk = BdUniqueId.gen();
        this.eYl = BdUniqueId.gen();
    }
}
