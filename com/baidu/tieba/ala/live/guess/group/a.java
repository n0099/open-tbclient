package com.baidu.tieba.ala.live.guess.group;

import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.live.data.AlaGuessQuesData;
import com.baidu.live.data.ab;
import com.baidu.live.data.n;
import com.baidu.live.guess.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.utils.j;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private ab hfI;
    private e hfO;
    private AlaGuessGroupView hgl;
    private e.b hgn;
    private AlaGuessQuesData hgo;
    private boolean hgm = false;
    private Handler mHandler = new Handler();
    private Runnable hgp = new Runnable() { // from class: com.baidu.tieba.ala.live.guess.group.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hgo != null) {
                a.this.hgo.setIsFirst(0);
                a.this.g(a.this.hgo);
            }
        }
    };

    public a(Context context, e eVar) {
        this.hgl = new AlaGuessGroupView(context);
        this.hfO = eVar;
        if (this.hfO != null) {
            this.hfO.a(new e.b() { // from class: com.baidu.tieba.ala.live.guess.group.a.2
                @Override // com.baidu.live.guess.e.b
                public void N(List<n> list) {
                    if (a.this.hgn != null) {
                        a.this.hgn.N(list);
                    }
                }

                @Override // com.baidu.live.guess.e.b
                public void onFailure(int i, String str) {
                    if (a.this.hgn != null) {
                        a.this.hgn.onFailure(i, str);
                    }
                }
            });
        }
    }

    public void bXo() {
        bXp();
        this.mHandler.postDelayed(this.hgp, 5000L);
    }

    public void bXp() {
        this.mHandler.removeCallbacks(this.hgp);
    }

    public void b(e.b bVar) {
        this.hgn = bVar;
    }

    public void a(ab abVar) {
        this.hfI = abVar;
    }

    public void g(AlaGuessQuesData alaGuessQuesData) {
        this.hgo = alaGuessQuesData;
        if (this.hfO != null && this.hfI.aIz != null) {
            this.hfO.c(ExtraParamsManager.getEncryptionUserId(String.valueOf(this.hfI.aIz.userId)), this.hgo.getQuesId(), alaGuessQuesData.isFirst());
        }
    }

    public boolean bXq() {
        return this.hgm;
    }

    public void av(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (viewGroup.getVisibility() == 8) {
                viewGroup.setVisibility(0);
            }
            viewGroup.addView(this.hgl, new ViewGroup.LayoutParams(-1, -1));
            this.hgm = true;
        }
    }

    public void aw(ViewGroup viewGroup) {
        if (viewGroup != null && this.hgl != null) {
            if (viewGroup.getChildCount() > 0) {
                viewGroup.removeView(this.hgl);
            }
            this.hgm = false;
        }
    }

    public void a(n nVar, AlaGuessGroupInfoView alaGuessGroupInfoView) {
        if (nVar != null && alaGuessGroupInfoView != null) {
            alaGuessGroupInfoView.setHeadImage(nVar.getAvatar());
            alaGuessGroupInfoView.setNickName(j.K(nVar.getNickname(), 8));
            if (!nVar.Bw()) {
                alaGuessGroupInfoView.getTickImage().setVisibility(8);
            } else {
                alaGuessGroupInfoView.getTickImage().setVisibility(0);
            }
            a(nVar, alaGuessGroupInfoView.getStatusImage());
        }
    }

    private void a(n nVar, ImageView imageView) {
        if (nVar.Bv()) {
            imageView.setImageResource(a.e.ala_guess_state_answer);
        } else {
            imageView.setImageResource(a.e.ala_guess_state_unanswer);
        }
    }

    public void a(n nVar) {
        a(nVar, this.hgl.getFirstInfo());
    }

    public void b(n nVar) {
        a(nVar, this.hgl.getSecondInfo());
    }

    public void c(n nVar) {
        a(nVar, this.hgl.getThirdInfo());
    }

    public void o(List<n> list, boolean z) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).bv(z);
            if (i == 0) {
                a(list.get(0));
            } else if (i == 1) {
                b(list.get(1));
            } else {
                c(list.get(2));
            }
        }
    }
}
