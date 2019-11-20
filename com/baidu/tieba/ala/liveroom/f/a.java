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
    private CustomMessageListener adk;
    private b eeh;
    private d eei;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        ru();
    }

    public void tB(String str) {
        this.eeh = new b(this.mPageContext.getPageActivity());
        this.eeh.a(this);
        this.eeh.b(this);
        this.eeh.aNC().setBackgroundColor(tC(str));
        this.eeh.tD(str);
    }

    public void resume() {
        if (this.eeh != null && this.eeh.isShowing() && this.eeh.aNC() != null) {
            this.eeh.aNC().onResume();
            this.eeh.aNC().reload();
        }
    }

    public void pause() {
        if (this.eeh != null && this.eeh.isShowing() && this.eeh.aNC() != null) {
            this.eeh.aNC().onPause();
        }
    }

    public void release() {
        aRs();
        MessageManager.getInstance().unRegisterListener(this.adk);
    }

    @Override // com.baidu.tieba.ala.liveroom.f.b.a
    public boolean a(String str, final JsResult jsResult) {
        this.eei = new d(this.mPageContext.getPageActivity());
        this.eei.setCancelable(false);
        this.eei.setCanceledOnTouchOutside(false);
        this.eei.aU(false);
        this.eei.k(this.mPageContext.getString(a.i.sdk_live_disclaimer), str, this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.eei.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
            @Override // com.baidu.live.view.d.a
            public void qy() {
                if (jsResult != null) {
                    jsResult.confirm();
                }
            }

            @Override // com.baidu.live.view.d.a
            public void qz() {
                if (jsResult != null) {
                    jsResult.cancel();
                }
            }
        });
        this.eei.show();
        return true;
    }

    private void ru() {
        this.adk = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.f.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.aRs();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.adk);
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
    public void aRs() {
        if (this.eeh != null) {
            this.eeh.dismiss();
        }
        if (this.eei != null) {
            this.eei.release();
        }
    }

    @Override // com.baidu.live.view.web.e
    public void cs(int i) {
        aRs();
    }
}
