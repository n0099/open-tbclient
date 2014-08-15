package com.baidu.tieba.guide;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.model.af;
import com.baidu.tieba.model.bf;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    private NewUserGuideActivity a;
    private InterestFrsData.Tag b;
    private a c;
    private af d;
    private bf e;

    public t(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, p pVar) {
        this.a = newUserGuideActivity;
        this.b = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.c = new r(this.a, y.NewUserDialog);
        } else if (btype == 2) {
            this.c = new e(this.a, y.NewUserDialog);
        } else if (btype == 3) {
            this.c = new i(this.a, y.NewUserDialog);
        }
        this.d = new af();
        this.d.setLoadDataCallBack(new u(this));
        this.e = new bf();
        this.e.a(new v(this));
        this.c.a(this);
        this.c.a(this.b);
        ((Dialog) this.c).setOnDismissListener(new w(this, pVar));
    }

    public void a(int i, boolean z) {
        for (int i2 = 0; i2 < this.b.getCard_list().size(); i2++) {
            if (this.b.getCard_list().get(i2).getFid() == i) {
                this.b.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.u.box_close_layout) {
            this.c.hide();
        } else if ((view.getId() == com.baidu.tieba.u.ll_like || view.getId() == com.baidu.tieba.u.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.e.a(card.getFname(), card.getFid());
            } else {
                this.d.a(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void a() {
        if (!(this.a instanceof Activity) || com.baidu.adp.lib.e.d.a((Activity) this.a)) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.c.a().setAnimation(scaleAnimation);
            this.c.show();
        }
    }
}
