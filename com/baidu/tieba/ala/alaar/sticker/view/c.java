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
    private b gtN;
    private LinkedList<com.baidu.live.view.tabhost.a> guA;
    private BdUniqueId guB;
    private BdUniqueId guC;
    a guD;
    private HttpMessageListener guE;
    private HttpMessageListener guj;
    private AlaStickerTabHost guw;
    private com.baidu.tieba.ala.alaar.sticker.view.a gux;
    private com.baidu.tieba.ala.alaar.sticker.view.a guy;
    private com.baidu.tieba.ala.alaar.sticker.view.a guz;

    /* loaded from: classes11.dex */
    public interface a {
        void bQo();

        void bQp();

        void bQq();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a(FuFaceItem fuFaceItem, String str);

        boolean bQg();

        void bQh();

        void onCompleted();
    }

    public c(@NonNull Context context, b bVar) {
        super(context);
        this.guA = new LinkedList<>();
        this.guD = new a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bQo() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.guC, "text", 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bQp() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.guB, SocialConstants.PARAM_AVATAR_URI, 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bQq() {
                com.baidu.tieba.ala.alaar.sticker.a.g.QF();
            }
        };
        this.guj = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.guz != null) {
                        c.this.guz.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.guz != null) {
                    c.this.guz.setDatas(getArStickerListHttpResponseMessage.gsy);
                }
            }
        };
        this.guE = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.gux != null) {
                        c.this.gux.setDatas(null);
                    }
                    if (c.this.guy != null) {
                        c.this.guy.setDatas(null);
                        return;
                    }
                    return;
                }
                GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.guB && c.this.gux != null) {
                    c.this.gux.setDatas(getPicTxtStickerListHttpResponseMessage.gsA);
                }
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.guC && c.this.guy != null) {
                    c.this.guy.setDatas(getPicTxtStickerListHttpResponseMessage.gsA);
                }
            }
        };
        this.gtN = bVar;
        getContext().setTheme(a.i.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bQm();
        setContentView(a.g.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.f.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.guw = (AlaStickerTabHost) findViewById(a.f.ala_master_sticker_view_pager);
        bQn();
        MessageManager.getInstance().registerListener(this.guE);
        MessageManager.getInstance().registerListener(this.guj);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (!ListUtils.isEmpty(this.guA)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.guA.size()) {
                    com.baidu.live.view.tabhost.a aVar = this.guA.get(i2);
                    if (this.guy == aVar) {
                        FM("texttab_show");
                    } else if (this.gux == aVar) {
                        FM("pictab_show");
                    } else if (this.guz == aVar) {
                        FM("arstab_show");
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
        if (this.gtN != null) {
            this.gtN.onCompleted();
        }
        super.dismiss();
    }

    private void FM(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "sticker");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "author_liveroom", str).setContentExt(jSONObject));
    }

    public void bQl() {
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.guB, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.guC, "text", 1, 50);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.guE);
        MessageManager.getInstance().unRegisterListener(this.guj);
    }

    private void bQm() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bQn() {
        this.gux = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 1, this.gtN, this.guD);
        this.guA.add(this.gux);
        this.guy = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 2, this.gtN, this.guD);
        this.guA.add(this.guy);
        if (com.baidu.live.ae.a.Qj().bAS != null && com.baidu.live.ae.a.Qj().bAS.aPK != null && com.baidu.live.ae.a.Qj().bAS.aPK.Cz()) {
            this.guz = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.gtN, this.guD);
            this.guA.add(this.guz);
            com.baidu.tieba.ala.alaar.sticker.a.g.QF();
        }
        this.guw.setData(this.guA);
        this.guw.setPageSelectedListener(new AlaStickerTabHost.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.b
            public void onPageSelected(int i) {
            }
        });
        this.guB = BdUniqueId.gen();
        this.guC = BdUniqueId.gen();
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.guB, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.guC, "text", 1, 50);
    }
}
