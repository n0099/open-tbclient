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
    private AlaStickerTabHost gdK;
    private com.baidu.tieba.ala.alaar.sticker.view.a gdL;
    private com.baidu.tieba.ala.alaar.sticker.view.a gdM;
    private com.baidu.tieba.ala.alaar.sticker.view.a gdN;
    private LinkedList<com.baidu.live.view.tabhost.a> gdO;
    private BdUniqueId gdP;
    private BdUniqueId gdQ;
    a gdR;
    private HttpMessageListener gdS;
    private b gdb;
    private HttpMessageListener gdx;

    /* loaded from: classes4.dex */
    public interface a {
        void bNr();

        void bNs();

        void bNt();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(FuFaceItem fuFaceItem, String str);

        boolean bNj();

        void bNk();

        void onCompleted();
    }

    public c(@NonNull Context context, b bVar) {
        super(context);
        this.gdO = new LinkedList<>();
        this.gdR = new a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bNr() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.gdQ, "text", 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bNs() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.gdP, SocialConstants.PARAM_AVATAR_URI, 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bNt() {
                com.baidu.tieba.ala.alaar.sticker.a.g.PB();
            }
        };
        this.gdx = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.gdN != null) {
                        c.this.gdN.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.gdN != null) {
                    c.this.gdN.setDatas(getArStickerListHttpResponseMessage.gbJ);
                }
            }
        };
        this.gdS = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.gdL != null) {
                        c.this.gdL.setDatas(null);
                    }
                    if (c.this.gdM != null) {
                        c.this.gdM.setDatas(null);
                        return;
                    }
                    return;
                }
                GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.gdP && c.this.gdL != null) {
                    c.this.gdL.setDatas(getPicTxtStickerListHttpResponseMessage.gbL);
                }
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.gdQ && c.this.gdM != null) {
                    c.this.gdM.setDatas(getPicTxtStickerListHttpResponseMessage.gbL);
                }
            }
        };
        this.gdb = bVar;
        getContext().setTheme(a.i.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bNp();
        setContentView(a.g.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.f.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.gdK = (AlaStickerTabHost) findViewById(a.f.ala_master_sticker_view_pager);
        bNq();
        MessageManager.getInstance().registerListener(this.gdS);
        MessageManager.getInstance().registerListener(this.gdx);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (!ListUtils.isEmpty(this.gdO)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gdO.size()) {
                    com.baidu.live.view.tabhost.a aVar = this.gdO.get(i2);
                    if (this.gdM == aVar) {
                        FN("texttab_show");
                    } else if (this.gdL == aVar) {
                        FN("pictab_show");
                    } else if (this.gdN == aVar) {
                        FN("arstab_show");
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
        if (this.gdb != null) {
            this.gdb.onCompleted();
        }
        super.dismiss();
    }

    private void FN(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "sticker");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, str).setContentExt(jSONObject));
    }

    public void bNo() {
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.gdP, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.gdQ, "text", 1, 50);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gdS);
        MessageManager.getInstance().unRegisterListener(this.gdx);
    }

    private void bNp() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bNq() {
        this.gdL = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 1, this.gdb, this.gdR);
        this.gdO.add(this.gdL);
        this.gdM = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 2, this.gdb, this.gdR);
        this.gdO.add(this.gdM);
        if (com.baidu.live.aa.a.Ph().bsh != null && com.baidu.live.aa.a.Ph().bsh.aNK != null && com.baidu.live.aa.a.Ph().bsh.aNK.Eg()) {
            this.gdN = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.gdb, this.gdR);
            this.gdO.add(this.gdN);
            com.baidu.tieba.ala.alaar.sticker.a.g.PB();
        }
        this.gdK.setData(this.gdO);
        this.gdK.setPageSelectedListener(new AlaStickerTabHost.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.b
            public void onPageSelected(int i) {
            }
        });
        this.gdP = BdUniqueId.gen();
        this.gdQ = BdUniqueId.gen();
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.gdP, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.gdQ, "text", 1, 50);
    }
}
