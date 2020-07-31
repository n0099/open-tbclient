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
    private HttpMessageListener fnO;
    private AlaStickerTabHost fnZ;
    private a fnt;
    private com.baidu.tieba.ala.alaar.sticker.view.a foa;
    private com.baidu.tieba.ala.alaar.sticker.view.a fob;
    private com.baidu.tieba.ala.alaar.sticker.view.a foc;
    private BdUniqueId fod;
    private BdUniqueId foe;
    private HttpMessageListener fof;

    /* loaded from: classes4.dex */
    public interface a {
        void a(FuFaceItem fuFaceItem, String str);

        boolean bvT();

        void bvU();
    }

    public c(@NonNull Context context, a aVar) {
        super(context);
        this.fnO = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.foc != null) {
                        c.this.foc.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.foc != null) {
                    c.this.foc.setDatas(getArStickerListHttpResponseMessage.fmf);
                }
            }
        };
        this.fof = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if ((httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                    if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.fod && c.this.foa != null) {
                        c.this.foa.setDatas(getPicTxtStickerListHttpResponseMessage.fmh);
                    }
                    if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.foe && c.this.fob != null) {
                        c.this.fob.setDatas(getPicTxtStickerListHttpResponseMessage.fmh);
                    }
                }
            }
        };
        this.fnt = aVar;
        getContext().setTheme(a.j.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bvZ();
        setContentView(a.h.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.g.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.fnZ = (AlaStickerTabHost) findViewById(a.g.ala_master_sticker_view_pager);
        bwa();
        MessageManager.getInstance().registerListener(this.fof);
        MessageManager.getInstance().registerListener(this.fnO);
    }

    public void bvY() {
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fod, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.foe, "text", 1, 50);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fof);
        MessageManager.getInstance().unRegisterListener(this.fnO);
    }

    private void bvZ() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bwa() {
        LinkedList linkedList = new LinkedList();
        this.foa = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 1, this.fnt);
        linkedList.add(this.foa);
        this.fob = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 2, this.fnt);
        linkedList.add(this.fob);
        if (com.baidu.live.v.a.Hs().beo != null && com.baidu.live.v.a.Hs().beo.aEm != null && com.baidu.live.v.a.Hs().beo.aEm.xt()) {
            this.foc = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.fnt);
            linkedList.add(this.foc);
            com.baidu.tieba.ala.alaar.sticker.a.f.HD();
        }
        this.fnZ.setData(linkedList);
        this.fod = BdUniqueId.gen();
        this.foe = BdUniqueId.gen();
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.fod, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.f.a(this.foe, "text", 1, 50);
    }
}
