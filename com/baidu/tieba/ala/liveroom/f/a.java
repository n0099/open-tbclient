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
import com.baidu.live.view.web.f;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tieba.ala.liveroom.f.b;
/* loaded from: classes3.dex */
public class a implements f, b.a {
    private CustomMessageListener aGS;
    private b fEG;
    private d fEH;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        zq();
    }

    public void AE(String str) {
        this.fEG = new b(this.mPageContext.getPageActivity());
        this.fEG.a(this);
        this.fEG.b(this);
        this.fEG.bmC().setBackgroundColor(zt(str));
        this.fEG.show(str);
    }

    public void resume() {
        if (this.fEG != null && this.fEG.isShowing() && this.fEG.bmC() != null) {
            this.fEG.bmC().onResume();
            this.fEG.bmC().reload();
        }
    }

    public void pause() {
        if (this.fEG != null && this.fEG.isShowing() && this.fEG.bmC() != null) {
            this.fEG.bmC().onPause();
        }
    }

    public void release() {
        buT();
        MessageManager.getInstance().unRegisterListener(this.aGS);
    }

    @Override // com.baidu.tieba.ala.liveroom.f.b.a
    public boolean a(String str, final JsResult jsResult) {
        this.fEH = new d(this.mPageContext.getPageActivity());
        this.fEH.setCancelable(false);
        this.fEH.setCanceledOnTouchOutside(false);
        this.fEH.ci(false);
        this.fEH.n(this.mPageContext.getString(a.i.sdk_live_disclaimer), str, this.mPageContext.getString(a.i.sdk_live_iknow), this.mPageContext.getString(a.i.sdk_live_cancel));
        this.fEH.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.f.a.1
            @Override // com.baidu.live.view.d.a
            public void Hx() {
                if (jsResult != null) {
                    jsResult.confirm();
                }
            }

            @Override // com.baidu.live.view.d.a
            public void Hy() {
                if (jsResult != null) {
                    jsResult.cancel();
                }
            }
        });
        this.fEH.show();
        return true;
    }

    private void zq() {
        this.aGS = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.f.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.buT();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aGS);
    }

    private int zt(String str) {
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
            return (parseInt < 0 || parseInt > 255) ? 0 : ColorUtils.setAlphaComponent(Color.parseColor(UgcConstant.TOPIC_PATTERN_TAG + queryParameter.substring(0, 6)), parseInt);
        } catch (Exception e) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buT() {
        if (this.fEG != null) {
            this.fEG.dismiss();
        }
        if (this.fEH != null) {
            this.fEH.release();
        }
    }

    @Override // com.baidu.live.view.web.f
    /* renamed from: do */
    public void mo22do(int i) {
        buT();
    }
}
