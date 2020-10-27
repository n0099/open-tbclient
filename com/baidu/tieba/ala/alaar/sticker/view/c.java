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
    private b fXD;
    private HttpMessageListener fXZ;
    private AlaStickerTabHost fYm;
    private com.baidu.tieba.ala.alaar.sticker.view.a fYn;
    private com.baidu.tieba.ala.alaar.sticker.view.a fYo;
    private com.baidu.tieba.ala.alaar.sticker.view.a fYp;
    private LinkedList<com.baidu.live.view.tabhost.a> fYq;
    private BdUniqueId fYr;
    private BdUniqueId fYs;
    a fYt;
    private HttpMessageListener fYu;

    /* loaded from: classes4.dex */
    public interface a {
        void bLA();

        void bLB();

        void bLz();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(FuFaceItem fuFaceItem, String str);

        boolean bLr();

        void bLs();

        void onCompleted();
    }

    public c(@NonNull Context context, b bVar) {
        super(context);
        this.fYq = new LinkedList<>();
        this.fYt = new a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bLz() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.fYs, "text", 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bLA() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.fYr, SocialConstants.PARAM_AVATAR_URI, 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bLB() {
                com.baidu.tieba.ala.alaar.sticker.a.g.PK();
            }
        };
        this.fXZ = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.fYp != null) {
                        c.this.fYp.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.fYp != null) {
                    c.this.fYp.setDatas(getArStickerListHttpResponseMessage.fWl);
                }
            }
        };
        this.fYu = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.fYn != null) {
                        c.this.fYn.setDatas(null);
                    }
                    if (c.this.fYo != null) {
                        c.this.fYo.setDatas(null);
                        return;
                    }
                    return;
                }
                GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.fYr && c.this.fYn != null) {
                    c.this.fYn.setDatas(getPicTxtStickerListHttpResponseMessage.fWn);
                }
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.fYs && c.this.fYo != null) {
                    c.this.fYo.setDatas(getPicTxtStickerListHttpResponseMessage.fWn);
                }
            }
        };
        this.fXD = bVar;
        getContext().setTheme(a.j.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bLx();
        setContentView(a.h.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.g.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.fYm = (AlaStickerTabHost) findViewById(a.g.ala_master_sticker_view_pager);
        bLy();
        MessageManager.getInstance().registerListener(this.fYu);
        MessageManager.getInstance().registerListener(this.fXZ);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (!ListUtils.isEmpty(this.fYq)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fYq.size()) {
                    com.baidu.live.view.tabhost.a aVar = this.fYq.get(i2);
                    if (this.fYo == aVar) {
                        FY("texttab_show");
                    } else if (this.fYn == aVar) {
                        FY("pictab_show");
                    } else if (this.fYp == aVar) {
                        FY("arstab_show");
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
        if (this.fXD != null) {
            this.fXD.onCompleted();
        }
        super.dismiss();
    }

    private void FY(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "sticker");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, str).setContentExt(jSONObject));
    }

    public void bLw() {
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.fYr, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.fYs, "text", 1, 50);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fYu);
        MessageManager.getInstance().unRegisterListener(this.fXZ);
    }

    private void bLx() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bLy() {
        this.fYn = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 1, this.fXD, this.fYt);
        this.fYq.add(this.fYn);
        this.fYo = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 2, this.fXD, this.fYt);
        this.fYq.add(this.fYo);
        if (com.baidu.live.z.a.Pq().bsy != null && com.baidu.live.z.a.Pq().bsy.aOy != null && com.baidu.live.z.a.Pq().bsy.aOy.Es()) {
            this.fYp = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.fXD, this.fYt);
            this.fYq.add(this.fYp);
            com.baidu.tieba.ala.alaar.sticker.a.g.PK();
        }
        this.fYm.setData(this.fYq);
        this.fYm.setPageSelectedListener(new AlaStickerTabHost.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.b
            public void onPageSelected(int i) {
            }
        });
        this.fYr = BdUniqueId.gen();
        this.fYs = BdUniqueId.gen();
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.fYr, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.fYs, "text", 1, 50);
    }
}
