package com.baidu.tieba.ala.liveroom.f;

import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.webkit.JsResult;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.view.d;
import com.baidu.live.view.web.e;
import com.baidu.tieba.ala.liveroom.f.b;
/* loaded from: classes6.dex */
public class a implements e, b.a {
    private CustomMessageListener adC;
    private b eeY;
    private d eeZ;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        rt();
    }

    public void tB(String str) {
        this.eeY = new b(this.mPageContext.getPageActivity());
        this.eeY.a(this);
        this.eeY.b(this);
        this.eeY.aNE().setBackgroundColor(tC(str));
        this.eeY.tD(str);
    }

    public void resume() {
        if (this.eeY != null && this.eeY.isShowing() && this.eeY.aNE() != null) {
            this.eeY.aNE().onResume();
            this.eeY.aNE().reload();
        }
    }

    public void pause() {
        if (this.eeY != null && this.eeY.isShowing() && this.eeY.aNE() != null) {
            this.eeY.aNE().onPause();
        }
    }

    public void release() {
        aRu();
        MessageManager.getInstance().unRegisterListener(this.adC);
    }

    @Override // com.baidu.tieba.ala.liveroom.f.b.a
    public boolean a(String str, final JsResult jsResult) {
        this.eeZ = new d(this.mPageContext.getPageActivity());
        this.eeZ.setCancelable(false);
        this.eeZ.setCanceledOnTouchOutside(false);
        this.eeZ.aU(false);
        this.eeZ.k(this.mPageContext.getString(a.i.sdk_live_disclaimer), str, this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.eeZ.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
            @Override // com.baidu.live.view.d.a
            public void qx() {
                if (jsResult != null) {
                    jsResult.confirm();
                }
            }

            @Override // com.baidu.live.view.d.a
            public void qy() {
                if (jsResult != null) {
                    jsResult.cancel();
                }
            }
        });
        this.eeZ.show();
        return true;
    }

    private void rt() {
        this.adC = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.f.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.aRu();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.adC);
    }

    private int tC(String str) {
        int indexOf;
        String queryParameter = Uri.parse(str).getQueryParameter("background");
        if ((TextUtils.isEmpty(queryParameter) || queryParameter.length() != 8) && (indexOf = str.indexOf("background=")) >= 0 && indexOf + 19 <= str.length()) {
            queryParameter = str.substring(indexOf + 11, indexOf + 19);
        }
        if (TextUtils.isEmpty(queryParameter) || queryParameter.length() != 8) {
            return 0;
        }
        try {
            int parseInt = Integer.parseInt(queryParameter.substring(6, 8), 16);
            return (parseInt < 0 || parseInt > 255) ? 0 : ColorUtils.setAlphaComponent(Color.parseColor('#' + queryParameter.substring(0, 6)), parseInt);
        } catch (Exception e) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRu() {
        if (this.eeY != null) {
            this.eeY.dismiss();
        }
        if (this.eeZ != null) {
            this.eeZ.release();
        }
    }

    @Override // com.baidu.live.view.web.e
    public void cs(int i) {
        aRu();
    }
}
