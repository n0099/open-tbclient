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
    private CustomMessageListener aoj;
    private b eZP;
    private d eZQ;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        uQ();
    }

    public void yS(String str) {
        this.eZP = new b(this.mPageContext.getPageActivity());
        this.eZP.a(this);
        this.eZP.b(this);
        this.eZP.bdI().setBackgroundColor(xL(str));
        this.eZP.show(str);
    }

    public void resume() {
        if (this.eZP != null && this.eZP.isShowing() && this.eZP.bdI() != null) {
            this.eZP.bdI().onResume();
            this.eZP.bdI().reload();
        }
    }

    public void pause() {
        if (this.eZP != null && this.eZP.isShowing() && this.eZP.bdI() != null) {
            this.eZP.bdI().onPause();
        }
    }

    public void release() {
        blx();
        MessageManager.getInstance().unRegisterListener(this.aoj);
    }

    @Override // com.baidu.tieba.ala.liveroom.f.b.a
    public boolean a(String str, final JsResult jsResult) {
        this.eZQ = new d(this.mPageContext.getPageActivity());
        this.eZQ.setCancelable(false);
        this.eZQ.setCanceledOnTouchOutside(false);
        this.eZQ.by(false);
        this.eZQ.n(this.mPageContext.getString(a.i.sdk_live_disclaimer), str, this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.eZQ.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
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
        this.eZQ.show();
        return true;
    }

    private void uQ() {
        this.aoj = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.f.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.blx();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aoj);
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
    public void blx() {
        if (this.eZP != null) {
            this.eZP.dismiss();
        }
        if (this.eZQ != null) {
            this.eZQ.release();
        }
    }

    @Override // com.baidu.live.view.web.e
    public void cY(int i) {
        blx();
    }
}
