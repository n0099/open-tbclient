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
/* loaded from: classes4.dex */
public class a {
    private int aKI;
    private long anchorId;
    private Dialog ben;
    private long challengeId;
    private Context context;
    private CountDownTimer gvC;
    private GetChallengeMvpToastInfoResponseMessage hdg;
    private b hdh;
    private i hdi;
    private long liveId;

    public a(Context context, long j, long j2, long j3, i iVar, GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage) {
        this.aKI = 10;
        this.context = context;
        this.liveId = j;
        this.anchorId = j2;
        this.challengeId = j3;
        this.hdi = iVar;
        this.hdg = getChallengeMvpToastInfoResponseMessage;
        if (com.baidu.live.aa.a.Ph().bms != null) {
            this.aKI = com.baidu.live.aa.a.Ph().bms.aKI;
            if (this.aKI == 0) {
                this.aKI = 10;
            }
        }
    }

    public void PA() {
        if (this.context != null && this.hdg != null) {
            View inflate = LayoutInflater.from(this.context).inflate(a.g.dialog_mvp_choose_punish, (ViewGroup) null);
            this.ben = new Dialog(this.context, a.i.sdk_TransparentDialog);
            this.ben.requestWindowFeature(1);
            this.ben.setCancelable(false);
            this.ben.setContentView(inflate);
            this.ben.setCanceledOnTouchOutside(false);
            this.ben.getWindow().getAttributes().width = this.context.getResources().getDimensionPixelSize(a.d.sdk_ds582);
            this.ben.getWindow().getAttributes().height = -2;
            ImageView imageView = (ImageView) inflate.findViewById(a.f.close_imageView);
            TextView textView = (TextView) inflate.findViewById(a.f.desc_textView);
            AlphaGradientHListView alphaGradientHListView = (AlphaGradientHListView) inflate.findViewById(a.f.punish_listView);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.choose_layout);
            final TextView textView2 = (TextView) inflate.findViewById(a.f.choose_textView);
            TextView textView3 = (TextView) inflate.findViewById(a.f.notPunish_textView);
            TextView textView4 = (TextView) inflate.findViewById(a.f.know_textView);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(a.f.countdown_layout);
            final TextView textView5 = (TextView) inflate.findViewById(a.f.countdown_textView);
            if (!TextUtils.isEmpty(this.hdg.toast)) {
                textView.setText(this.hdg.toast);
            }
            if (this.hdg.type == 0) {
                imageView.setVisibility(8);
                alphaGradientHListView.setVisibility(8);
                linearLayout.setVisibility(8);
                textView4.setVisibility(0);
                linearLayout2.setVisibility(8);
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.GM();
                    }
                });
            } else {
                imageView.setVisibility(0);
                alphaGradientHListView.setVisibility(0);
                linearLayout.setVisibility(0);
                textView4.setVisibility(8);
                linearLayout2.setVisibility(0);
                textView2.setEnabled(false);
                textView5.setText(this.aKI + "s");
                alphaGradientHListView.setDividerWidth(this.context.getResources().getDimensionPixelSize(a.d.sdk_ds18));
                alphaGradientHListView.setSelector(this.context.getResources().getDrawable(a.e.sdk_transparent_bg));
                this.hdh = new b(this.context, this.hdg.haj);
                alphaGradientHListView.setAdapter((ListAdapter) this.hdh);
                alphaGradientHListView.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.2
                    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
                    public void a(AdapterView<?> adapterView, View view, int i, long j) {
                        com.baidu.tieba.ala.liveroom.challenge.a.b bVar;
                        if (a.this.hdh != null && (bVar = (com.baidu.tieba.ala.liveroom.challenge.a.b) a.this.hdh.getItem(i)) != null) {
                            if (TextUtils.equals(a.this.hdh.gZJ, bVar.id)) {
                                a.this.hdh.gZJ = "";
                                textView2.setEnabled(false);
                            } else {
                                a.this.hdh.gZJ = bVar.id;
                                textView2.setEnabled(true);
                            }
                            a.this.hdh.notifyDataSetChanged();
                        }
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bg(3, a.this.hdh.gZJ);
                        a.this.release();
                    }
                });
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bg(2, "0");
                        a.this.release();
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.bg(1, "0");
                        a.this.release();
                    }
                });
                if (this.gvC != null) {
                    this.gvC.cancel();
                }
                this.gvC = new CountDownTimer(this.aKI * 1000, 200L) { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.6
                    @Override // android.os.CountDownTimer
                    public void onTick(long j) {
                        textView5.setText((j / 1000) + "s");
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        a.this.bg(1, "0");
                        a.this.GM();
                    }
                };
                this.gvC.start();
            }
            this.ben.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GM() {
        if (this.ben != null && this.ben.isShowing()) {
            Context context = this.ben.getContext();
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
                this.ben.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.ben = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(int i, String str) {
        if (this.hdi != null) {
            this.hdi.a(this.challengeId, this.liveId, this.anchorId, i, str);
        }
    }

    public void release() {
        if (this.gvC != null) {
            this.gvC.cancel();
        }
        GM();
    }
}
