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
/* loaded from: classes11.dex */
public class a {
    private int aOh;
    private long anchorId;
    private Dialog bkh;
    private long challengeId;
    private Context context;
    private CountDownTimer gPY;
    private GetChallengeMvpToastInfoResponseMessage hyL;
    private b hyM;
    private i hyN;
    private long liveId;

    public a(Context context, long j, long j2, long j3, i iVar, GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage) {
        this.aOh = 10;
        this.context = context;
        this.liveId = j;
        this.anchorId = j2;
        this.challengeId = j3;
        this.hyN = iVar;
        this.hyL = getChallengeMvpToastInfoResponseMessage;
        if (com.baidu.live.af.a.SE().bwi != null) {
            this.aOh = com.baidu.live.af.a.SE().bwi.aOh;
            if (this.aOh == 0) {
                this.aOh = 10;
            }
        }
    }

    public void SY() {
        if (this.context != null && this.hyL != null) {
            View inflate = LayoutInflater.from(this.context).inflate(a.g.dialog_mvp_choose_punish, (ViewGroup) null);
            this.bkh = new Dialog(this.context, a.i.sdk_TransparentDialog);
            this.bkh.requestWindowFeature(1);
            this.bkh.setCancelable(false);
            this.bkh.setContentView(inflate);
            this.bkh.setCanceledOnTouchOutside(false);
            this.bkh.getWindow().getAttributes().width = this.context.getResources().getDimensionPixelSize(a.d.sdk_ds582);
            this.bkh.getWindow().getAttributes().height = -2;
            ImageView imageView = (ImageView) inflate.findViewById(a.f.close_imageView);
            TextView textView = (TextView) inflate.findViewById(a.f.desc_textView);
            AlphaGradientHListView alphaGradientHListView = (AlphaGradientHListView) inflate.findViewById(a.f.punish_listView);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.choose_layout);
            final TextView textView2 = (TextView) inflate.findViewById(a.f.choose_textView);
            TextView textView3 = (TextView) inflate.findViewById(a.f.notPunish_textView);
            TextView textView4 = (TextView) inflate.findViewById(a.f.know_textView);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(a.f.countdown_layout);
            final TextView textView5 = (TextView) inflate.findViewById(a.f.countdown_textView);
            if (!TextUtils.isEmpty(this.hyL.toast)) {
                textView.setText(this.hyL.toast);
            }
            if (this.hyL.type == 0) {
                imageView.setVisibility(8);
                alphaGradientHListView.setVisibility(8);
                linearLayout.setVisibility(8);
                textView4.setVisibility(0);
                linearLayout2.setVisibility(8);
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.If();
                    }
                });
            } else {
                imageView.setVisibility(0);
                alphaGradientHListView.setVisibility(0);
                linearLayout.setVisibility(0);
                textView4.setVisibility(8);
                linearLayout2.setVisibility(0);
                textView2.setEnabled(false);
                textView5.setText(this.aOh + "s");
                alphaGradientHListView.setDividerWidth(this.context.getResources().getDimensionPixelSize(a.d.sdk_ds18));
                alphaGradientHListView.setSelector(this.context.getResources().getDrawable(a.e.sdk_transparent_bg));
                this.hyM = new b(this.context, this.hyL.hvP);
                alphaGradientHListView.setAdapter((ListAdapter) this.hyM);
                alphaGradientHListView.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.2
                    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
                    public void a(AdapterView<?> adapterView, View view, int i, long j) {
                        com.baidu.tieba.ala.liveroom.challenge.a.b bVar;
                        if (a.this.hyM != null && (bVar = (com.baidu.tieba.ala.liveroom.challenge.a.b) a.this.hyM.getItem(i)) != null) {
                            if (TextUtils.equals(a.this.hyM.hvp, bVar.id)) {
                                a.this.hyM.hvp = "";
                                textView2.setEnabled(false);
                            } else {
                                a.this.hyM.hvp = bVar.id;
                                textView2.setEnabled(true);
                            }
                            a.this.hyM.notifyDataSetChanged();
                        }
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bi(3, a.this.hyM.hvp);
                        a.this.release();
                    }
                });
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bi(2, "0");
                        a.this.release();
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bi(1, "0");
                        a.this.release();
                    }
                });
                if (this.gPY != null) {
                    this.gPY.cancel();
                }
                this.gPY = new CountDownTimer(this.aOh * 1000, 200L) { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.6
                    @Override // android.os.CountDownTimer
                    public void onTick(long j) {
                        textView5.setText((j / 1000) + "s");
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        a.this.bi(1, "0");
                        a.this.If();
                    }
                };
                this.gPY.start();
            }
            this.bkh.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void If() {
        if (this.bkh != null && this.bkh.isShowing()) {
            Context context = this.bkh.getContext();
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
                this.bkh.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.bkh = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(int i, String str) {
        if (this.hyN != null) {
            this.hyN.a(this.challengeId, this.liveId, this.anchorId, i, str);
        }
    }

    public void release() {
        if (this.gPY != null) {
            this.gPY.cancel();
        }
        If();
    }
}
