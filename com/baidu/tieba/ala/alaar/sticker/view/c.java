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
/* loaded from: classes11.dex */
public class c extends Dialog {
    private AlaStickerTabHost guK;
    private com.baidu.tieba.ala.alaar.sticker.view.a guL;
    private com.baidu.tieba.ala.alaar.sticker.view.a guM;
    private com.baidu.tieba.ala.alaar.sticker.view.a guN;
    private LinkedList<com.baidu.live.view.tabhost.a> guO;
    private BdUniqueId guP;
    private BdUniqueId guQ;
    a guR;
    private HttpMessageListener guS;
    private b gub;
    private HttpMessageListener gux;

    /* loaded from: classes11.dex */
    public interface a {
        void bQv();

        void bQw();

        void bQx();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a(FuFaceItem fuFaceItem, String str);

        boolean bQn();

        void bQo();

        void onCompleted();
    }

    public c(@NonNull Context context, b bVar) {
        super(context);
        this.guO = new LinkedList<>();
        this.guR = new a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bQv() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.guQ, "text", 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bQw() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.guP, SocialConstants.PARAM_AVATAR_URI, 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bQx() {
                com.baidu.tieba.ala.alaar.sticker.a.g.QF();
            }
        };
        this.gux = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.guN != null) {
                        c.this.guN.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.guN != null) {
                    c.this.guN.setDatas(getArStickerListHttpResponseMessage.gsM);
                }
            }
        };
        this.guS = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.guL != null) {
                        c.this.guL.setDatas(null);
                    }
                    if (c.this.guM != null) {
                        c.this.guM.setDatas(null);
                        return;
                    }
                    return;
                }
                GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.guP && c.this.guL != null) {
                    c.this.guL.setDatas(getPicTxtStickerListHttpResponseMessage.gsO);
                }
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.guQ && c.this.guM != null) {
                    c.this.guM.setDatas(getPicTxtStickerListHttpResponseMessage.gsO);
                }
            }
        };
        this.gub = bVar;
        getContext().setTheme(a.i.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bQt();
        setContentView(a.g.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.f.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.guK = (AlaStickerTabHost) findViewById(a.f.ala_master_sticker_view_pager);
        bQu();
        MessageManager.getInstance().registerListener(this.guS);
        MessageManager.getInstance().registerListener(this.gux);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (!ListUtils.isEmpty(this.guO)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.guO.size()) {
                    com.baidu.live.view.tabhost.a aVar = this.guO.get(i2);
                    if (this.guM == aVar) {
                        FN("texttab_show");
                    } else if (this.guL == aVar) {
                        FN("pictab_show");
                    } else if (this.guN == aVar) {
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
        if (this.gub != null) {
            this.gub.onCompleted();
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
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "author_liveroom", str).setContentExt(jSONObject));
    }

    public void bQs() {
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.guP, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.guQ, "text", 1, 50);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.guS);
        MessageManager.getInstance().unRegisterListener(this.gux);
    }

    private void bQt() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bQu() {
        this.guL = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 1, this.gub, this.guR);
        this.guO.add(this.guL);
        this.guM = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 2, this.gub, this.guR);
        this.guO.add(this.guM);
        if (com.baidu.live.ae.a.Qj().bAS != null && com.baidu.live.ae.a.Qj().bAS.aPK != null && com.baidu.live.ae.a.Qj().bAS.aPK.Cz()) {
            this.guN = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.gub, this.guR);
            this.guO.add(this.guN);
            com.baidu.tieba.ala.alaar.sticker.a.g.QF();
        }
        this.guK.setData(this.guO);
        this.guK.setPageSelectedListener(new AlaStickerTabHost.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.b
            public void onPageSelected(int i) {
            }
        });
        this.guP = BdUniqueId.gen();
        this.guQ = BdUniqueId.gen();
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.guP, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.guQ, "text", 1, 50);
    }
}
