package com.baidu.tieba.ala.liveroom.turntable;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.widget.PopupWindow;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.view.web.f;
/* loaded from: classes6.dex */
public class e {
    private CustomMessageListener dUi;
    private d eol;
    private PopupWindow.OnDismissListener eom;
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
        aNB();
    }

    public void a(String str, long j, long j2, long j3) {
        this.eol = new d(this.mContext);
        this.eol.setOnDismissListener(this.eom);
        this.eol.aNC().setBackgroundColor(tC(str));
        f fVar = new f();
        fVar.az(this.mContext).a(this.eol).a(this.eol.aNC().getSchemeCallback());
        com.baidu.live.view.web.a[] wP = fVar.wP();
        for (com.baidu.live.view.web.a aVar : wP) {
            this.eol.aNC().addJavascriptInterface(aVar, aVar.getName());
        }
        this.eol.tD(b(str, j, j2, j3));
    }

    public void resume() {
        if (this.eol != null && this.eol.isShowing() && this.eol.aNC() != null) {
            this.eol.aNC().onResume();
        }
    }

    public void pause() {
        if (this.eol != null && this.eol.isShowing() && this.eol.aNC() != null) {
            this.eol.aNC().onPause();
        }
    }

    public void dismiss() {
        if (this.eol != null) {
            this.eol.aND();
        }
    }

    public void bw(int i) {
        if (this.eol != null && this.eol.isShowing()) {
            this.eol.bw(i);
        }
    }

    public void rt() {
        dismiss();
    }

    public void release() {
        rt();
        MessageManager.getInstance().unRegisterListener(this.dUi);
    }

    private void aNB() {
        this.dUi = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.turntable.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.eol != null && e.this.eol.isShowing()) {
                    e.this.eol.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dUi);
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

    private String b(String str, long j, long j2, long j3) {
        StringBuilder sb = new StringBuilder(str);
        if (str.contains("?")) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append("live_id=");
        sb.append(j);
        sb.append("&user_id=");
        sb.append(j2);
        sb.append("&anchor_id=");
        sb.append(j3);
        sb.append("&subapp_type=");
        sb.append(TbConfig.getSubappType());
        sb.append("&client_type=");
        sb.append("2");
        return sb.toString();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.eom = onDismissListener;
    }

    public PopupWindow.OnDismissListener aWg() {
        return this.eom;
    }
}
