package com.baidu.tieba.ala.liveroom.g;

import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.webkit.JsResult;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.view.d;
import com.baidu.live.view.web.e;
import com.baidu.tieba.ala.liveroom.g.b;
/* loaded from: classes2.dex */
public class a implements e, b.a {
    private CustomMessageListener alV;
    private b eVK;
    private d eVL;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        tA();
    }

    public void yw(String str) {
        this.eVK = new b(this.mPageContext.getPageActivity());
        this.eVK.a(this);
        this.eVK.b(this);
        this.eVK.bbq().setBackgroundColor(xq(str));
        this.eVK.show(str);
    }

    public void resume() {
        if (this.eVK != null && this.eVK.isShowing() && this.eVK.bbq() != null) {
            this.eVK.bbq().onResume();
            this.eVK.bbq().reload();
        }
    }

    public void pause() {
        if (this.eVK != null && this.eVK.isShowing() && this.eVK.bbq() != null) {
            this.eVK.bbq().onPause();
        }
    }

    public void release() {
        bjF();
        MessageManager.getInstance().unRegisterListener(this.alV);
    }

    @Override // com.baidu.tieba.ala.liveroom.g.b.a
    public boolean a(String str, final JsResult jsResult) {
        this.eVL = new d(this.mPageContext.getPageActivity());
        this.eVL.setCancelable(false);
        this.eVL.setCanceledOnTouchOutside(false);
        this.eVL.bq(false);
        this.eVL.k(this.mPageContext.getString(a.i.sdk_live_disclaimer), str, this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.eVL.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.g.a.1
            @Override // com.baidu.live.view.d.a
            public void yV() {
                if (jsResult != null) {
                    jsResult.confirm();
                }
            }

            @Override // com.baidu.live.view.d.a
            public void yW() {
                if (jsResult != null) {
                    jsResult.cancel();
                }
            }
        });
        this.eVL.show();
        return true;
    }

    private void tA() {
        this.alV = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.g.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.bjF();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.alV);
    }

    private int xq(String str) {
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
    public void bjF() {
        if (this.eVK != null) {
            this.eVK.dismiss();
        }
        if (this.eVL != null) {
            this.eVL.release();
        }
    }

    @Override // com.baidu.live.view.web.e
    public void cI(int i) {
        bjF();
    }
}
