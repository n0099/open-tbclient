package com.baidu.tieba.ala.alaar.sticker.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
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
/* loaded from: classes10.dex */
public class c extends Dialog {
    private AlaStickerTabHost grM;
    private com.baidu.tieba.ala.alaar.sticker.view.a grN;
    private com.baidu.tieba.ala.alaar.sticker.view.a grO;
    private com.baidu.tieba.ala.alaar.sticker.view.a grP;
    private LinkedList<com.baidu.live.view.tabhost.a> grQ;
    private BdUniqueId grR;
    private BdUniqueId grS;
    a grT;
    private HttpMessageListener grU;
    private b grd;
    private HttpMessageListener grz;

    /* loaded from: classes10.dex */
    public interface a {
        void bPK();

        void bPL();

        void bPM();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(FuFaceItem fuFaceItem, String str);

        boolean bPC();

        void bPD();

        void onCompleted();
    }

    public c(@NonNull Context context, b bVar) {
        super(context);
        this.grQ = new LinkedList<>();
        this.grT = new a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bPK() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.grS, "text", 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bPL() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.grR, SocialConstants.PARAM_AVATAR_URI, 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bPM() {
                com.baidu.tieba.ala.alaar.sticker.a.g.Pe();
            }
        };
        this.grz = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.grP != null) {
                        c.this.grP.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.grP != null) {
                    c.this.grP.setDatas(getArStickerListHttpResponseMessage.gpO);
                }
            }
        };
        this.grU = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.grN != null) {
                        c.this.grN.setDatas(null);
                    }
                    if (c.this.grO != null) {
                        c.this.grO.setDatas(null);
                        return;
                    }
                    return;
                }
                GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.grR && c.this.grN != null) {
                    c.this.grN.setDatas(getPicTxtStickerListHttpResponseMessage.gpQ);
                }
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.grS && c.this.grO != null) {
                    c.this.grO.setDatas(getPicTxtStickerListHttpResponseMessage.gpQ);
                }
            }
        };
        this.grd = bVar;
        getContext().setTheme(a.i.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bPI();
        setContentView(a.g.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.f.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.grM = (AlaStickerTabHost) findViewById(a.f.ala_master_sticker_view_pager);
        bPJ();
        MessageManager.getInstance().registerListener(this.grU);
        MessageManager.getInstance().registerListener(this.grz);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (!ListUtils.isEmpty(this.grQ)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.grQ.size()) {
                    com.baidu.live.view.tabhost.a aVar = this.grQ.get(i2);
                    if (this.grO == aVar) {
                        Fo("texttab_show");
                    } else if (this.grN == aVar) {
                        Fo("pictab_show");
                    } else if (this.grP == aVar) {
                        Fo("arstab_show");
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
        if (this.grd != null) {
            this.grd.onCompleted();
        }
        super.dismiss();
    }

    private void Fo(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "sticker");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "author_liveroom", str).setContentExt(jSONObject));
    }

    public void bPH() {
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.grR, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.grS, "text", 1, 50);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.grU);
        MessageManager.getInstance().unRegisterListener(this.grz);
    }

    private void bPI() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bPJ() {
        this.grN = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 1, this.grd, this.grT);
        this.grQ.add(this.grN);
        this.grO = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 2, this.grd, this.grT);
        this.grQ.add(this.grO);
        if (com.baidu.live.af.a.OJ().bxp != null && com.baidu.live.af.a.OJ().bxp.aMM != null && com.baidu.live.af.a.OJ().bxp.aMM.Bm()) {
            this.grP = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.grd, this.grT);
            this.grQ.add(this.grP);
            com.baidu.tieba.ala.alaar.sticker.a.g.Pe();
        }
        this.grM.setData(this.grQ);
        this.grM.setPageSelectedListener(new AlaStickerTabHost.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.b
            public void onPageSelected(int i) {
            }
        });
        this.grR = BdUniqueId.gen();
        this.grS = BdUniqueId.gen();
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.grR, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.grS, "text", 1, 50);
    }
}
