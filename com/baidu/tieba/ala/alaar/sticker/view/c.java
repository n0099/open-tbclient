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
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.ala.alaar.messages.GetArStickerListHttpResponseMessage;
import com.baidu.tieba.ala.alaar.messages.GetPicTxtStickerListHttpResponseMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost;
import com.tencent.open.SocialConstants;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends Dialog {
    private HttpMessageListener glG;
    private AlaStickerTabHost glT;
    private com.baidu.tieba.ala.alaar.sticker.view.a glU;
    private com.baidu.tieba.ala.alaar.sticker.view.a glV;
    private com.baidu.tieba.ala.alaar.sticker.view.a glW;
    private LinkedList<com.baidu.live.view.tabhost.a> glX;
    private BdUniqueId glY;
    private BdUniqueId glZ;
    private b glk;
    a gma;
    private HttpMessageListener gmb;

    /* loaded from: classes4.dex */
    public interface a {
        void bRc();

        void bRd();

        void bRe();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(FuFaceItem fuFaceItem, String str);

        boolean bQU();

        void bQV();

        void onCompleted();
    }

    public c(@NonNull Context context, b bVar) {
        super(context);
        this.glX = new LinkedList<>();
        this.gma = new a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bRc() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.glZ, "text", 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bRd() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.glY, SocialConstants.PARAM_AVATAR_URI, 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bRe() {
                com.baidu.tieba.ala.alaar.sticker.a.g.RV();
            }
        };
        this.glG = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.glW != null) {
                        c.this.glW.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.glW != null) {
                    c.this.glW.setDatas(getArStickerListHttpResponseMessage.gjU);
                }
            }
        };
        this.gmb = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.glU != null) {
                        c.this.glU.setDatas(null);
                    }
                    if (c.this.glV != null) {
                        c.this.glV.setDatas(null);
                        return;
                    }
                    return;
                }
                GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.glY && c.this.glU != null) {
                    c.this.glU.setDatas(getPicTxtStickerListHttpResponseMessage.gjW);
                }
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.glZ && c.this.glV != null) {
                    c.this.glV.setDatas(getPicTxtStickerListHttpResponseMessage.gjW);
                }
            }
        };
        this.glk = bVar;
        getContext().setTheme(a.i.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bRa();
        setContentView(a.g.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.f.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.glT = (AlaStickerTabHost) findViewById(a.f.ala_master_sticker_view_pager);
        bRb();
        MessageManager.getInstance().registerListener(this.gmb);
        MessageManager.getInstance().registerListener(this.glG);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (!ListUtils.isEmpty(this.glX)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.glX.size()) {
                    com.baidu.live.view.tabhost.a aVar = this.glX.get(i2);
                    if (this.glV == aVar) {
                        GC("texttab_show");
                    } else if (this.glU == aVar) {
                        GC("pictab_show");
                    } else if (this.glW == aVar) {
                        GC("arstab_show");
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.glk != null) {
            this.glk.onCompleted();
        }
        super.dismiss();
    }

    private void GC(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "sticker");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "author_liveroom", str).setContentExt(jSONObject));
    }

    public void bQZ() {
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.glY, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.glZ, "text", 1, 50);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gmb);
        MessageManager.getInstance().unRegisterListener(this.glG);
    }

    private void bRa() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bRb() {
        this.glU = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 1, this.glk, this.gma);
        this.glX.add(this.glU);
        this.glV = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 2, this.glk, this.gma);
        this.glX.add(this.glV);
        if (com.baidu.live.ae.a.RB().bxq != null && com.baidu.live.ae.a.RB().bxq.aQK != null && com.baidu.live.ae.a.RB().bxq.aQK.FR()) {
            this.glW = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.glk, this.gma);
            this.glX.add(this.glW);
            com.baidu.tieba.ala.alaar.sticker.a.g.RV();
        }
        this.glT.setData(this.glX);
        this.glT.setPageSelectedListener(new AlaStickerTabHost.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.b
            public void onPageSelected(int i) {
            }
        });
        this.glY = BdUniqueId.gen();
        this.glZ = BdUniqueId.gen();
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.glY, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.glZ, "text", 1, 50);
    }
}
