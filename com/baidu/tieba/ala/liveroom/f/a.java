package com.baidu.tieba.ala.liveroom.f;

import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.webkit.JsResult;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
import com.baidu.live.view.d;
import com.baidu.live.view.web.e;
import com.baidu.tieba.ala.liveroom.f.b;
/* loaded from: classes3.dex */
public class a implements e, b.a {
    private CustomMessageListener aoi;
    private b eZC;
    private d eZD;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        uQ();
    }

    public void yR(String str) {
        this.eZC = new b(this.mPageContext.getPageActivity());
        this.eZC.a(this);
        this.eZC.b(this);
        this.eZC.bdH().setBackgroundColor(xK(str));
        this.eZC.show(str);
    }

    public void resume() {
        if (this.eZC != null && this.eZC.isShowing() && this.eZC.bdH() != null) {
            this.eZC.bdH().onResume();
            this.eZC.bdH().reload();
        }
    }

    public void pause() {
        if (this.eZC != null && this.eZC.isShowing() && this.eZC.bdH() != null) {
            this.eZC.bdH().onPause();
        }
    }

    public void release() {
        blw();
        MessageManager.getInstance().unRegisterListener(this.aoi);
    }

    @Override // com.baidu.tieba.ala.liveroom.f.b.a
    public boolean a(String str, final JsResult jsResult) {
        this.eZD = new d(this.mPageContext.getPageActivity());
        this.eZD.setCancelable(false);
        this.eZD.setCanceledOnTouchOutside(false);
        this.eZD.by(false);
        this.eZD.n(this.mPageContext.getString(a.i.sdk_live_disclaimer), str, this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.eZD.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
            @Override // com.baidu.live.view.d.a
            public void Bn() {
                if (jsResult != null) {
                    jsResult.confirm();
                }
            }

            @Override // com.baidu.live.view.d.a
            public void Bo() {
                if (jsResult != null) {
                    jsResult.cancel();
                }
            }
        });
        this.eZD.show();
        return true;
    }

    private void uQ() {
        this.aoi = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.f.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.blw();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aoi);
    }

    private int xK(String str) {
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
    public void blw() {
        if (this.eZC != null) {
            this.eZC.dismiss();
        }
        if (this.eZD != null) {
            this.eZD.release();
        }
    }

    @Override // com.baidu.live.view.web.e
    public void cY(int i) {
        blw();
    }
}
