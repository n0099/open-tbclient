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
    private long aCw;
    private int aGy;
    private Dialog aXy;
    private long challengeId;
    private Context context;
    private CountDownTimer fQB;
    private GetChallengeMvpToastInfoResponseMessage gtG;
    private b gtH;
    private i gtI;
    private long liveId;

    public a(Context context, long j, long j2, long j3, i iVar, GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage) {
        this.aGy = 10;
        this.context = context;
        this.liveId = j;
        this.aCw = j2;
        this.challengeId = j3;
        this.gtI = iVar;
        this.gtG = getChallengeMvpToastInfoResponseMessage;
        if (com.baidu.live.w.a.Nk().beJ != null) {
            this.aGy = com.baidu.live.w.a.Nk().beJ.aGy;
            if (this.aGy == 0) {
                this.aGy = 10;
            }
        }
    }

    public void Nv() {
        if (this.context != null && this.gtG != null) {
            View inflate = LayoutInflater.from(this.context).inflate(a.h.dialog_mvp_choose_punish, (ViewGroup) null);
            this.aXy = new Dialog(this.context, a.j.sdk_TransparentDialog);
            this.aXy.requestWindowFeature(1);
            this.aXy.setCancelable(false);
            this.aXy.setContentView(inflate);
            this.aXy.setCanceledOnTouchOutside(false);
            this.aXy.getWindow().getAttributes().width = this.context.getResources().getDimensionPixelSize(a.e.sdk_ds582);
            this.aXy.getWindow().getAttributes().height = -2;
            ImageView imageView = (ImageView) inflate.findViewById(a.g.close_imageView);
            TextView textView = (TextView) inflate.findViewById(a.g.desc_textView);
            AlphaGradientHListView alphaGradientHListView = (AlphaGradientHListView) inflate.findViewById(a.g.punish_listView);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.g.choose_layout);
            final TextView textView2 = (TextView) inflate.findViewById(a.g.choose_textView);
            TextView textView3 = (TextView) inflate.findViewById(a.g.notPunish_textView);
            TextView textView4 = (TextView) inflate.findViewById(a.g.know_textView);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(a.g.countdown_layout);
            final TextView textView5 = (TextView) inflate.findViewById(a.g.countdown_textView);
            if (!TextUtils.isEmpty(this.gtG.toast)) {
                textView.setText(this.gtG.toast);
            }
            if (this.gtG.type == 0) {
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
                textView5.setText(this.aGy + "s");
                alphaGradientHListView.setDividerWidth(this.context.getResources().getDimensionPixelSize(a.e.sdk_ds18));
                alphaGradientHListView.setSelector(this.context.getResources().getDrawable(a.f.sdk_transparent_bg));
                this.gtH = new b(this.context, this.gtG.gqS);
                alphaGradientHListView.setAdapter((ListAdapter) this.gtH);
                alphaGradientHListView.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.2
                    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
                    public void a(AdapterView<?> adapterView, View view, int i, long j) {
                        com.baidu.tieba.ala.liveroom.challenge.a.b bVar;
                        if (a.this.gtH != null && (bVar = (com.baidu.tieba.ala.liveroom.challenge.a.b) a.this.gtH.getItem(i)) != null) {
                            if (TextUtils.equals(a.this.gtH.gqx, bVar.id)) {
                                a.this.gtH.gqx = "";
                                textView2.setEnabled(false);
                            } else {
                                a.this.gtH.gqx = bVar.id;
                                textView2.setEnabled(true);
                            }
                            a.this.gtH.notifyDataSetChanged();
                        }
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aR(3, a.this.gtH.gqx);
                        a.this.release();
                    }
                });
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aR(2, "0");
                        a.this.release();
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aR(1, "0");
                        a.this.release();
                    }
                });
                if (this.fQB != null) {
                    this.fQB.cancel();
                }
                this.fQB = new CountDownTimer(this.aGy * 1000, 200L) { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.6
                    @Override // android.os.CountDownTimer
                    public void onTick(long j) {
                        textView5.setText((j / 1000) + "s");
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        a.this.aR(1, "0");
                        a.this.Fd();
                    }
                };
                this.fQB.start();
            }
            this.aXy.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd() {
        if (this.aXy != null && this.aXy.isShowing()) {
            Context context = this.aXy.getContext();
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
                this.aXy.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.aXy = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(int i, String str) {
        if (this.gtI != null) {
            this.gtI.a(this.challengeId, this.liveId, this.aCw, i, str);
        }
    }

    public void release() {
        if (this.fQB != null) {
            this.fQB.cancel();
        }
        Fd();
    }
}
