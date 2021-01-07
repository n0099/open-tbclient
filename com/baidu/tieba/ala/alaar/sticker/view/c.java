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
    private b gvK;
    a gwA;
    private HttpMessageListener gwB;
    private HttpMessageListener gwg;
    private AlaStickerTabHost gwt;
    private com.baidu.tieba.ala.alaar.sticker.view.a gwu;
    private com.baidu.tieba.ala.alaar.sticker.view.a gwv;
    private com.baidu.tieba.ala.alaar.sticker.view.a gww;
    private LinkedList<com.baidu.live.view.tabhost.a> gwx;
    private BdUniqueId gwy;
    private BdUniqueId gwz;

    /* loaded from: classes11.dex */
    public interface a {
        void bTC();

        void bTD();

        void bTE();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a(FuFaceItem fuFaceItem, String str);

        boolean bTu();

        void bTv();

        void onCompleted();
    }

    public c(@NonNull Context context, b bVar) {
        super(context);
        this.gwx = new LinkedList<>();
        this.gwA = new a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.2
            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bTC() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.gwz, "text", 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bTD() {
                com.baidu.tieba.ala.alaar.sticker.a.g.a(c.this.gwy, SocialConstants.PARAM_AVATAR_URI, 1, 50);
            }

            @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
            public void bTE() {
                com.baidu.tieba.ala.alaar.sticker.a.g.SZ();
            }
        };
        this.gwg = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetArStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.gww != null) {
                        c.this.gww.setDatas(null);
                        return;
                    }
                    return;
                }
                GetArStickerListHttpResponseMessage getArStickerListHttpResponseMessage = (GetArStickerListHttpResponseMessage) httpResponsedMessage;
                if (c.this.gww != null) {
                    c.this.gww.setDatas(getArStickerListHttpResponseMessage.guv);
                }
            }
        };
        this.gwB = new HttpMessageListener(1021156) { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (!(httpResponsedMessage instanceof GetPicTxtStickerListHttpResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    if (c.this.gwu != null) {
                        c.this.gwu.setDatas(null);
                    }
                    if (c.this.gwv != null) {
                        c.this.gwv.setDatas(null);
                        return;
                    }
                    return;
                }
                GetPicTxtStickerListHttpResponseMessage getPicTxtStickerListHttpResponseMessage = (GetPicTxtStickerListHttpResponseMessage) httpResponsedMessage;
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.gwy && c.this.gwu != null) {
                    c.this.gwu.setDatas(getPicTxtStickerListHttpResponseMessage.gux);
                }
                if (getPicTxtStickerListHttpResponseMessage.getOrginalMessage() != null && getPicTxtStickerListHttpResponseMessage.getOrginalMessage().getTag() == c.this.gwz && c.this.gwv != null) {
                    c.this.gwv.setDatas(getPicTxtStickerListHttpResponseMessage.gux);
                }
            }
        };
        this.gvK = bVar;
        getContext().setTheme(a.i.theme_operation_portrait_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        bTA();
        setContentView(a.g.ala_master_sticker_layout);
        ViewGroup.LayoutParams layoutParams = findViewById(a.f.ala_master_sticker_root_view).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = BdUtilHelper.getScreenDimensions(getContext())[0];
        }
        this.gwt = (AlaStickerTabHost) findViewById(a.f.ala_master_sticker_view_pager);
        bTB();
        MessageManager.getInstance().registerListener(this.gwB);
        MessageManager.getInstance().registerListener(this.gwg);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (!ListUtils.isEmpty(this.gwx)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gwx.size()) {
                    com.baidu.live.view.tabhost.a aVar = this.gwx.get(i2);
                    if (this.gwv == aVar) {
                        Gz("texttab_show");
                    } else if (this.gwu == aVar) {
                        Gz("pictab_show");
                    } else if (this.gww == aVar) {
                        Gz("arstab_show");
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
        if (this.gvK != null) {
            this.gvK.onCompleted();
        }
        super.dismiss();
    }

    private void Gz(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "sticker");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "author_liveroom", str).setContentExt(jSONObject));
    }

    public void bTz() {
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.gwy, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.gwz, "text", 1, 50);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gwB);
        MessageManager.getInstance().unRegisterListener(this.gwg);
    }

    private void bTA() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    private void bTB() {
        this.gwu = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 1, this.gvK, this.gwA);
        this.gwx.add(this.gwu);
        this.gwv = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 2, this.gvK, this.gwA);
        this.gwx.add(this.gwv);
        if (com.baidu.live.af.a.SE().bCb != null && com.baidu.live.af.a.SE().bCb.aRz != null && com.baidu.live.af.a.SE().bCb.aRz.Fh()) {
            this.gww = new com.baidu.tieba.ala.alaar.sticker.view.a(getContext(), 3, this.gvK, this.gwA);
            this.gwx.add(this.gww);
            com.baidu.tieba.ala.alaar.sticker.a.g.SZ();
        }
        this.gwt.setData(this.gwx);
        this.gwt.setPageSelectedListener(new AlaStickerTabHost.b() { // from class: com.baidu.tieba.ala.alaar.sticker.view.c.1
            @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.b
            public void onPageSelected(int i) {
            }
        });
        this.gwy = BdUniqueId.gen();
        this.gwz = BdUniqueId.gen();
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.gwy, SocialConstants.PARAM_AVATAR_URI, 1, 50);
        com.baidu.tieba.ala.alaar.sticker.a.g.a(this.gwz, "text", 1, 50);
    }
}
