package com.baidu.tieba.ala.liveroom.challenge.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.challenge.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
import com.baidu.tieba.ala.liveroom.challenge.adapter.b;
import com.baidu.tieba.ala.liveroom.challenge.message.GetChallengeMvpToastInfoResponseMessage;
/* loaded from: classes7.dex */
public class a {
    private long aCu;
    private int aGw;
    private Dialog aXw;
    private long challengeId;
    private Context context;
    private CountDownTimer fQx;
    private GetChallengeMvpToastInfoResponseMessage gtC;
    private b gtD;
    private i gtE;
    private long liveId;

    public a(Context context, long j, long j2, long j3, i iVar, GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage) {
        this.aGw = 10;
        this.context = context;
        this.liveId = j;
        this.aCu = j2;
        this.challengeId = j3;
        this.gtE = iVar;
        this.gtC = getChallengeMvpToastInfoResponseMessage;
        if (com.baidu.live.w.a.Nk().beH != null) {
            this.aGw = com.baidu.live.w.a.Nk().beH.aGw;
            if (this.aGw == 0) {
                this.aGw = 10;
            }
        }
    }

    public void Nv() {
        if (this.context != null && this.gtC != null) {
            View inflate = LayoutInflater.from(this.context).inflate(a.h.dialog_mvp_choose_punish, (ViewGroup) null);
            this.aXw = new Dialog(this.context, a.j.sdk_TransparentDialog);
            this.aXw.requestWindowFeature(1);
            this.aXw.setCancelable(false);
            this.aXw.setContentView(inflate);
            this.aXw.setCanceledOnTouchOutside(false);
            this.aXw.getWindow().getAttributes().width = this.context.getResources().getDimensionPixelSize(a.e.sdk_ds582);
            this.aXw.getWindow().getAttributes().height = -2;
            ImageView imageView = (ImageView) inflate.findViewById(a.g.close_imageView);
            TextView textView = (TextView) inflate.findViewById(a.g.desc_textView);
            AlphaGradientHListView alphaGradientHListView = (AlphaGradientHListView) inflate.findViewById(a.g.punish_listView);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.g.choose_layout);
            final TextView textView2 = (TextView) inflate.findViewById(a.g.choose_textView);
            TextView textView3 = (TextView) inflate.findViewById(a.g.notPunish_textView);
            TextView textView4 = (TextView) inflate.findViewById(a.g.know_textView);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(a.g.countdown_layout);
            final TextView textView5 = (TextView) inflate.findViewById(a.g.countdown_textView);
            if (!TextUtils.isEmpty(this.gtC.toast)) {
                textView.setText(this.gtC.toast);
            }
            if (this.gtC.type == 0) {
                imageView.setVisibility(8);
                alphaGradientHListView.setVisibility(8);
                linearLayout.setVisibility(8);
                textView4.setVisibility(0);
                linearLayout2.setVisibility(8);
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.Fd();
                    }
                });
            } else {
                imageView.setVisibility(0);
                alphaGradientHListView.setVisibility(0);
                linearLayout.setVisibility(0);
                textView4.setVisibility(8);
                linearLayout2.setVisibility(0);
                textView2.setEnabled(false);
                textView5.setText(this.aGw + "s");
                alphaGradientHListView.setDividerWidth(this.context.getResources().getDimensionPixelSize(a.e.sdk_ds18));
                alphaGradientHListView.setSelector(this.context.getResources().getDrawable(a.f.sdk_transparent_bg));
                this.gtD = new b(this.context, this.gtC.gqO);
                alphaGradientHListView.setAdapter((ListAdapter) this.gtD);
                alphaGradientHListView.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.2
                    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
                    public void a(AdapterView<?> adapterView, View view, int i, long j) {
                        com.baidu.tieba.ala.liveroom.challenge.a.b bVar;
                        if (a.this.gtD != null && (bVar = (com.baidu.tieba.ala.liveroom.challenge.a.b) a.this.gtD.getItem(i)) != null) {
                            if (TextUtils.equals(a.this.gtD.gqt, bVar.id)) {
                                a.this.gtD.gqt = "";
                                textView2.setEnabled(false);
                            } else {
                                a.this.gtD.gqt = bVar.id;
                                textView2.setEnabled(true);
                            }
                            a.this.gtD.notifyDataSetChanged();
                        }
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aS(3, a.this.gtD.gqt);
                        a.this.release();
                    }
                });
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aS(2, "0");
                        a.this.release();
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aS(1, "0");
                        a.this.release();
                    }
                });
                if (this.fQx != null) {
                    this.fQx.cancel();
                }
                this.fQx = new CountDownTimer(this.aGw * 1000, 200L) { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.6
                    @Override // android.os.CountDownTimer
                    public void onTick(long j) {
                        textView5.setText((j / 1000) + "s");
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        a.this.aS(1, "0");
                        a.this.Fd();
                    }
                };
                this.fQx.start();
            }
            this.aXw.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd() {
        if (this.aXw != null && this.aXw.isShowing()) {
            Context context = this.aXw.getContext();
            if (context != null && (context instanceof Activity)) {
                Activity activity = (Activity) context;
                if (Build.VERSION.SDK_INT >= 17) {
                    if (activity.isDestroyed() || activity.isFinishing()) {
                        return;
                    }
                } else if (activity.isFinishing()) {
                    return;
                }
            }
            try {
                this.aXw.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.aXw = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(int i, String str) {
        if (this.gtE != null) {
            this.gtE.a(this.challengeId, this.liveId, this.aCu, i, str);
        }
    }

    public void release() {
        if (this.fQx != null) {
            this.fQx.cancel();
        }
        Fd();
    }
}
