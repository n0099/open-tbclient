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
    private HttpMessageListener gdQ;
    private b gdu;
    private AlaStickerTabHost ged;
    private com.baidu.tieba.ala.alaar.sticker.view.a gee;
    private com.baidu.tieba.ala.alaar.sticker.view.a gef;
    private com.baidu.tieba.ala.alaar.sticker.view.a geg;
    private LinkedList<com.baidu.live.view.tabhost.a> geh;
    private BdUniqueId gei;
    private BdUniqueId gej;
    a gek;
    private HttpMessageListener gel;

    /* loaded from: classes4.dex */
    public interface a {
        void bNY();

        void bNZ();

        void bOa();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(FuFaceItem fuFaceItem, String str);

        boolean bNQ();

        void bNR();

        void onCompleted();
    }

    public c(@NonNull Context context, b bVar) {
        super(context);
        this.geh = new LinkedList<>();
        this.gek = new a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bNY() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.gej, "text", 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bNZ() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.gei, SocialConstants.PARAM_AVATAR_URI, 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bOa() {
                com.baidu.tieba.ala.alaar.sticker.a.g.Qk();
            }
        };
        this.gdQ = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.geg != null) {
                        c.this.geg.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.geg != null) {
                    c.this.geg.setDatas(getArStickerListHttpResponseMessage.gcc);
                }
            }
        };
        this.gel = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.gee != null) {
                        c.this.gee.setDatas(null);
                    }
                    if (c.this.gef != null) {
                        c.this.gef.setDatas(null);
                        return;
                    }
                    return;
                }
                GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.gei && c.this.gee != null) {
                    c.this.gee.setDatas(getPicTxtStickerListHttpResponseMessage.gce);
                }
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.gej && c.this.gef != null) {
                    c.this.gef.setDatas(getPicTxtStickerListHttpResponseMessage.gce);
                }
            }
        };
        this.gdu = bVar;
        getContext().setTheme(a.i.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bNW();
        setContentView(a.g.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.f.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.ged = (AlaStickerTabHost) findViewById(a.f.ala_master_sticker_view_pager);
        bNX();
        MessageManager.getInstance().registerListener(this.gel);
        MessageManager.getInstance().registerListener(this.gdQ);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (!ListUtils.isEmpty(this.geh)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.geh.size()) {
                    com.baidu.live.view.tabhost.a aVar = this.geh.get(i2);
                    if (this.gef == aVar) {
                        Gm("texttab_show");
                    } else if (this.gee == aVar) {
                        Gm("pictab_show");
                    } else if (this.geg == aVar) {
                        Gm("arstab_show");
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
        if (this.gdu != null) {
            this.gdu.onCompleted();
        }
        super.dismiss();
    }

    private void Gm(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "sticker");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, str).setContentExt(jSONObject));
    }

    public void bNV() {
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.gei, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.gej, "text", 1, 50);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gel);
        MessageManager.getInstance().unRegisterListener(this.gdQ);
    }

    private void bNW() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bNX() {
        this.gee = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 1, this.gdu, this.gek);
        this.geh.add(this.gee);
        this.gef = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 2, this.gdu, this.gek);
        this.geh.add(this.gef);
        if (com.baidu.live.aa.a.PQ().btT != null && com.baidu.live.aa.a.PQ().btT.aPv != null && com.baidu.live.aa.a.PQ().btT.aPv.EP()) {
            this.geg = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.gdu, this.gek);
            this.geh.add(this.geg);
            com.baidu.tieba.ala.alaar.sticker.a.g.Qk();
        }
        this.ged.setData(this.geh);
        this.ged.setPageSelectedListener(new AlaStickerTabHost.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.b
            public void onPageSelected(int i) {
            }
        });
        this.gei = BdUniqueId.gen();
        this.gej = BdUniqueId.gen();
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.gei, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.gej, "text", 1, 50);
    }
}
