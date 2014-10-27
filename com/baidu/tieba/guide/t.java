package com.baidu.tieba.guide;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.model.ag;
import com.baidu.tieba.model.bc;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    private NewUserGuideActivity aLI;
    private a aLJ;
    private bc aLK;
    private InterestFrsData.Tag aLe;
    private ag avr;

    public t(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, p pVar) {
        this.aLI = newUserGuideActivity;
        this.aLe = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.aLJ = new r(this.aLI, z.NewUserDialog);
        } else if (btype == 2) {
            this.aLJ = new e(this.aLI, z.NewUserDialog);
        } else if (btype == 3) {
            this.aLJ = new i(this.aLI, z.NewUserDialog);
        }
        this.avr = new ag(newUserGuideActivity);
        this.avr.setLoadDataCallBack(new u(this));
        this.aLK = new bc();
        this.aLK.a(new v(this));
        this.aLJ.setOnClickListener(this);
        this.aLJ.a(this.aLe);
        ((Dialog) this.aLJ).setOnDismissListener(new w(this, pVar));
    }

    public void n(int i, boolean z) {
        for (int i2 = 0; i2 < this.aLe.getCard_list().size(); i2++) {
            if (this.aLe.getCard_list().get(i2).getFid() == i) {
                this.aLe.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.box_close_layout) {
            this.aLJ.hide();
        } else if ((view.getId() == com.baidu.tieba.v.ll_like || view.getId() == com.baidu.tieba.v.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.aLK.g(card.getFname(), card.getFid());
            } else {
                this.avr.o(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (!(this.aLI instanceof Activity) || com.baidu.adp.lib.g.j.e(this.aLI)) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.aLJ.getRootView().setAnimation(scaleAnimation);
            this.aLJ.show();
        }
    }
}
