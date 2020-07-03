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
/* loaded from: classes3.dex */
public class a {
    private Dialog aQQ;
    private long awn;
    private int azZ;
    private long challengeId;
    private Context context;
    private CountDownTimer fzZ;
    private GetChallengeMvpToastInfoResponseMessage gcl;
    private b gcm;
    private i gcn;
    private long liveId;

    public a(Context context, long j, long j2, long j3, i iVar, GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage) {
        this.azZ = 10;
        this.context = context;
        this.liveId = j;
        this.awn = j2;
        this.challengeId = j3;
        this.gcn = iVar;
        this.gcl = getChallengeMvpToastInfoResponseMessage;
        if (com.baidu.live.v.a.Hm().aZp != null) {
            this.azZ = com.baidu.live.v.a.Hm().aZp.azZ;
            if (this.azZ == 0) {
                this.azZ = 10;
            }
        }
    }

    public void showDialog() {
        if (this.context != null && this.gcl != null) {
            View inflate = LayoutInflater.from(this.context).inflate(a.h.dialog_mvp_choose_punish, (ViewGroup) null);
            this.aQQ = new Dialog(this.context, a.j.sdk_TransparentDialog);
            this.aQQ.requestWindowFeature(1);
            this.aQQ.setCancelable(false);
            this.aQQ.setContentView(inflate);
            this.aQQ.setCanceledOnTouchOutside(false);
            this.aQQ.getWindow().getAttributes().width = this.context.getResources().getDimensionPixelSize(a.e.sdk_ds582);
            this.aQQ.getWindow().getAttributes().height = -2;
            ImageView imageView = (ImageView) inflate.findViewById(a.g.close_imageView);
            TextView textView = (TextView) inflate.findViewById(a.g.desc_textView);
            AlphaGradientHListView alphaGradientHListView = (AlphaGradientHListView) inflate.findViewById(a.g.punish_listView);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.g.choose_layout);
            final TextView textView2 = (TextView) inflate.findViewById(a.g.choose_textView);
            TextView textView3 = (TextView) inflate.findViewById(a.g.notPunish_textView);
            TextView textView4 = (TextView) inflate.findViewById(a.g.know_textView);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(a.g.countdown_layout);
            final TextView textView5 = (TextView) inflate.findViewById(a.g.countdown_textView);
            if (!TextUtils.isEmpty(this.gcl.toast)) {
                textView.setText(this.gcl.toast);
            }
            if (this.gcl.type == 0) {
                imageView.setVisibility(8);
                alphaGradientHListView.setVisibility(8);
                linearLayout.setVisibility(8);
                textView4.setVisibility(0);
                linearLayout2.setVisibility(8);
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.yY();
                    }
                });
            } else {
                imageView.setVisibility(0);
                alphaGradientHListView.setVisibility(0);
                linearLayout.setVisibility(0);
                textView4.setVisibility(8);
                linearLayout2.setVisibility(0);
                textView2.setEnabled(false);
                textView5.setText(this.azZ + "s");
                alphaGradientHListView.setDividerWidth(this.context.getResources().getDimensionPixelSize(a.e.sdk_ds18));
                alphaGradientHListView.setSelector(this.context.getResources().getDrawable(a.f.sdk_transparent_bg));
                this.gcm = new b(this.context, this.gcl.fZy);
                alphaGradientHListView.setAdapter((ListAdapter) this.gcm);
                alphaGradientHListView.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.2
                    @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
                    public void a(AdapterView<?> adapterView, View view, int i, long j) {
                        com.baidu.tieba.ala.liveroom.challenge.a.b bVar;
                        if (a.this.gcm != null && (bVar = (com.baidu.tieba.ala.liveroom.challenge.a.b) a.this.gcm.getItem(i)) != null) {
                            if (TextUtils.equals(a.this.gcm.fZd, bVar.id)) {
                                a.this.gcm.fZd = "";
                                textView2.setEnabled(false);
                            } else {
                                a.this.gcm.fZd = bVar.id;
                                textView2.setEnabled(true);
                            }
                            a.this.gcm.notifyDataSetChanged();
                        }
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.aS(3, a.this.gcm.fZd);
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
                if (this.fzZ != null) {
                    this.fzZ.cancel();
                }
                this.fzZ = new CountDownTimer(this.azZ * 1000, 200L) { // from class: com.baidu.tieba.ala.liveroom.challenge.c.a.6
                    @Override // android.os.CountDownTimer
                    public void onTick(long j) {
                        textView5.setText((j / 1000) + "s");
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        a.this.aS(1, "0");
                        a.this.yY();
                    }
                };
                this.fzZ.start();
            }
            this.aQQ.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yY() {
        if (this.aQQ != null && this.aQQ.isShowing()) {
            Context context = this.aQQ.getContext();
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
                this.aQQ.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.aQQ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(int i, String str) {
        if (this.gcn != null) {
            this.gcn.a(this.challengeId, this.liveId, this.awn, i, str);
        }
    }

    public void release() {
        if (this.fzZ != null) {
            this.fzZ.cancel();
        }
        yY();
    }
}
