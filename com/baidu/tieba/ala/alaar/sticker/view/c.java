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
    private HttpMessageListener glI;
    private AlaStickerTabHost glV;
    private com.baidu.tieba.ala.alaar.sticker.view.a glW;
    private com.baidu.tieba.ala.alaar.sticker.view.a glX;
    private com.baidu.tieba.ala.alaar.sticker.view.a glY;
    private LinkedList<com.baidu.live.view.tabhost.a> glZ;
    private b glm;
    private BdUniqueId gma;
    private BdUniqueId gmb;
    a gmc;
    private HttpMessageListener gmd;

    /* loaded from: classes4.dex */
    public interface a {
        void bRd();

        void bRe();

        void bRf();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(FuFaceItem fuFaceItem, String str);

        boolean bQV();

        void bQW();

        void onCompleted();
    }

    public c(@NonNull Context context, b bVar) {
        super(context);
        this.glZ = new LinkedList<>();
        this.gmc = new a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bRd() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.gmb, "text", 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bRe() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.gma, SocialConstants.PARAM_AVATAR_URI, 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bRf() {
                com.baidu.tieba.ala.alaar.sticker.a.g.RV();
            }
        };
        this.glI = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.glY != null) {
                        c.this.glY.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.glY != null) {
                    c.this.glY.setDatas(getArStickerListHttpResponseMessage.gjW);
                }
            }
        };
        this.gmd = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.glW != null) {
                        c.this.glW.setDatas(null);
                    }
                    if (c.this.glX != null) {
                        c.this.glX.setDatas(null);
                        return;
                    }
                    return;
                }
                GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.gma && c.this.glW != null) {
                    c.this.glW.setDatas(getPicTxtStickerListHttpResponseMessage.gjY);
                }
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.gmb && c.this.glX != null) {
                    c.this.glX.setDatas(getPicTxtStickerListHttpResponseMessage.gjY);
                }
            }
        };
        this.glm = bVar;
        getContext().setTheme(a.i.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bRb();
        setContentView(a.g.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.f.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.glV = (AlaStickerTabHost) findViewById(a.f.ala_master_sticker_view_pager);
        bRc();
        MessageManager.getInstance().registerListener(this.gmd);
        MessageManager.getInstance().registerListener(this.glI);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (!ListUtils.isEmpty(this.glZ)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.glZ.size()) {
                    com.baidu.live.view.tabhost.a aVar = this.glZ.get(i2);
                    if (this.glX == aVar) {
                        GC("texttab_show");
                    } else if (this.glW == aVar) {
                        GC("pictab_show");
                    } else if (this.glY == aVar) {
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
        if (this.glm != null) {
            this.glm.onCompleted();
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

    public void bRa() {
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.gma, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.gmb, "text", 1, 50);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gmd);
        MessageManager.getInstance().unRegisterListener(this.glI);
    }

    private void bRb() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bRc() {
        this.glW = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 1, this.glm, this.gmc);
        this.glZ.add(this.glW);
        this.glX = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 2, this.glm, this.gmc);
        this.glZ.add(this.glX);
        if (com.baidu.live.ae.a.RB().bxq != null && com.baidu.live.ae.a.RB().bxq.aQK != null && com.baidu.live.ae.a.RB().bxq.aQK.FR()) {
            this.glY = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.glm, this.gmc);
            this.glZ.add(this.glY);
            com.baidu.tieba.ala.alaar.sticker.a.g.RV();
        }
        this.glV.setData(this.glZ);
        this.glV.setPageSelectedListener(new AlaStickerTabHost.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.b
            public void onPageSelected(int i) {
            }
        });
        this.gma = BdUniqueId.gen();
        this.gmb = BdUniqueId.gen();
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.gma, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.gmb, "text", 1, 50);
    }
}
