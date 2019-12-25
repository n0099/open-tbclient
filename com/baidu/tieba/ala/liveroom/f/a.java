package com.baidu.tieba.ala.liveroom.f;

import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.webkit.JsResult;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.view.d;
import com.baidu.live.view.web.e;
import com.baidu.tieba.ala.liveroom.f.b;
/* loaded from: classes2.dex */
public class a implements e, b.a {
    private CustomMessageListener alh;
    private b eUb;
    private d eUc;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        ti();
    }

    public void ys(String str) {
        this.eUb = new b(this.mPageContext.getPageActivity());
        this.eUb.a(this);
        this.eUb.b(this);
        this.eUb.baV().setBackgroundColor(xl(str));
        this.eUb.show(str);
    }

    public void resume() {
        if (this.eUb != null && this.eUb.isShowing() && this.eUb.baV() != null) {
            this.eUb.baV().onResume();
            this.eUb.baV().reload();
        }
    }

    public void pause() {
        if (this.eUb != null && this.eUb.isShowing() && this.eUb.baV() != null) {
            this.eUb.baV().onPause();
        }
    }

    public void release() {
        biT();
        MessageManager.getInstance().unRegisterListener(this.alh);
    }

    @Override // com.baidu.tieba.ala.liveroom.f.b.a
    public boolean a(String str, final JsResult jsResult) {
        this.eUc = new d(this.mPageContext.getPageActivity());
        this.eUc.setCancelable(false);
        this.eUc.setCanceledOnTouchOutside(false);
        this.eUc.bl(false);
        this.eUc.k(this.mPageContext.getString(a.i.sdk_live_disclaimer), str, this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.eUc.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
            @Override // com.baidu.live.view.d.a
            public void yC() {
                if (jsResult != null) {
                    jsResult.confirm();
                }
            }

            @Override // com.baidu.live.view.d.a
            public void yD() {
                if (jsResult != null) {
                    jsResult.cancel();
                }
            }
        });
        this.eUc.show();
        return true;
    }

    private void ti() {
        this.alh = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.f.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.biT();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.alh);
    }

    private int xl(String str) {
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
    public void biT() {
        if (this.eUb != null) {
            this.eUb.dismiss();
        }
        if (this.eUc != null) {
            this.eUc.release();
        }
    }

    @Override // com.baidu.live.view.web.e
    public void cH(int i) {
        biT();
    }
}
