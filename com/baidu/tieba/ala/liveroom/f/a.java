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
    private CustomMessageListener aot;
    private b fan;
    private d fao;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        uV();
    }

    public void yS(String str) {
        this.fan = new b(this.mPageContext.getPageActivity());
        this.fan.a(this);
        this.fan.b(this);
        this.fan.bdN().setBackgroundColor(xL(str));
        this.fan.show(str);
    }

    public void resume() {
        if (this.fan != null && this.fan.isShowing() && this.fan.bdN() != null) {
            this.fan.bdN().onResume();
            this.fan.bdN().reload();
        }
    }

    public void pause() {
        if (this.fan != null && this.fan.isShowing() && this.fan.bdN() != null) {
            this.fan.bdN().onPause();
        }
    }

    public void release() {
        blC();
        MessageManager.getInstance().unRegisterListener(this.aot);
    }

    @Override // com.baidu.tieba.ala.liveroom.f.b.a
    public boolean a(String str, final JsResult jsResult) {
        this.fao = new d(this.mPageContext.getPageActivity());
        this.fao.setCancelable(false);
        this.fao.setCanceledOnTouchOutside(false);
        this.fao.bz(false);
        this.fao.n(this.mPageContext.getString(a.i.sdk_live_disclaimer), str, this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.fao.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
            @Override // com.baidu.live.view.d.a
            public void Bu() {
                if (jsResult != null) {
                    jsResult.confirm();
                }
            }

            @Override // com.baidu.live.view.d.a
            public void Bv() {
                if (jsResult != null) {
                    jsResult.cancel();
                }
            }
        });
        this.fao.show();
        return true;
    }

    private void uV() {
        this.aot = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.f.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.blC();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aot);
    }

    private int xL(String str) {
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
    public void blC() {
        if (this.fan != null) {
            this.fan.dismiss();
        }
        if (this.fao != null) {
            this.fao.release();
        }
    }

    @Override // com.baidu.live.view.web.e
    public void cY(int i) {
        blC();
    }
}
