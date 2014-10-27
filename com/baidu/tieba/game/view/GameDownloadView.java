package com.baidu.tieba.game.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.game.ab;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class GameDownloadView extends RelativeLayout {
    private c aIQ;
    private TextView aKc;
    private e aKd;
    private boolean aKe;
    private GameInfoData aKf;
    private d aKg;
    private final CustomMessageListener aKh;
    public View.OnClickListener aKi;
    private Context mContext;
    private int mStatus;

    public void setItemClickCallBack(c cVar) {
        this.aIQ = cVar;
    }

    public void setItemDownloadCallBack(d dVar) {
        this.aKg = dVar;
    }

    public GameDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKh = new a(this, 2001122);
        this.aKi = new b(this);
        init(context);
    }

    public GameDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKh = new a(this, 2001122);
        this.aKi = new b(this);
        init(context);
    }

    public GameDownloadView(Context context) {
        super(context);
        this.aKh = new a(this, 2001122);
        this.aKi = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aKc = new TextView(context);
        this.aKc.setLayoutParams(new RelativeLayout.LayoutParams(m.c(context, t.ds120), m.c(context, t.ds60)));
        this.aKc.setGravity(17);
        this.aKc.setTextSize(0, m.c(context, t.ds26));
        addView(this.aKc);
        this.aKd = new e(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m.c(context, t.ds58), m.c(context, t.ds58));
        layoutParams.addRule(13, -1);
        this.aKd.setLayoutParams(layoutParams);
        addView(this.aKd);
        setOnClickListener(this.aKi);
    }

    public void setData(GameInfoData gameInfoData) {
        if (gameInfoData != null) {
            this.aKf = gameInfoData;
            setTag(this.aKf);
            clear();
            MessageManager.getInstance().registerListener(this.aKh);
            if (gameInfoData.getGameType() == 2) {
                cp(true);
                this.aKc.setText(this.mContext.getResources().getString(y.game_center_start));
                aw.b(this.aKc, s.cp_cont_g, 1);
                this.aKc.setBackgroundDrawable(aw.getDrawable(u.game_center_start_btn));
                return;
            }
            this.mStatus = ab.Hs().n(gameInfoData);
            switch (this.mStatus) {
                case 1:
                    Ip();
                    return;
                case 2:
                    v(ab.Hs().c(gameInfoData));
                    return;
                case 3:
                    Io();
                    return;
                case 4:
                    t(((float) ab.Hs().l(gameInfoData)) / ((com.baidu.adp.lib.g.c.a(gameInfoData.getPackageSize(), 0.0f) * 1024.0f) * 1024.0f));
                    return;
                case 5:
                    Il();
                    return;
                case 6:
                    Im();
                    return;
                case 7:
                    In();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clear();
    }

    private void clear() {
        MessageManager.getInstance().unRegisterListener(this.aKh);
        this.aKd.Ir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Il() {
        cp(true);
        this.aKc.setText(this.mContext.getResources().getString(y.game_center_install));
        aw.b(this.aKc, s.cp_cont_g, 1);
        this.aKc.setBackgroundDrawable(aw.getDrawable(u.game_center_start_btn));
    }

    private void Im() {
        cp(true);
        this.aKc.setText(this.mContext.getResources().getString(y.game_center_start));
        aw.b(this.aKc, s.cp_cont_g, 1);
        this.aKc.setBackgroundDrawable(aw.getDrawable(u.game_center_start_btn));
    }

    private void In() {
        cp(true);
        this.aKc.setText(this.mContext.getResources().getString(y.game_center_upgrade));
        aw.b(this.aKc, s.cp_cont_b, 1);
        this.aKc.setBackgroundDrawable(aw.getDrawable(u.btn_pop_comment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(float f) {
        if (f < 1.0E-6d) {
            Ip();
        } else {
            u(Math.max(0.0f, f));
        }
    }

    private void u(float f) {
        cp(false);
        this.aKd.w(f);
        this.aKd.Ir();
        this.aKd.setStatus(4);
        this.aKd.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f) {
        cp(false);
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.aKd.w(f);
        this.aKd.Ir();
        this.aKd.setStatus(2);
        this.aKd.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Io() {
        cp(false);
        this.aKd.setStatus(3);
        this.aKd.Iq();
    }

    private void Ip() {
        cp(true);
        this.aKc.setText(this.mContext.getResources().getString(y.game_center_download));
        aw.b(this.aKc, s.cp_cont_b, 1);
        this.aKc.setBackgroundDrawable(aw.getDrawable(u.btn_pop_comment));
    }

    private void cp(boolean z) {
        if (this.aKe != z) {
            this.aKc.setVisibility(z ? 0 : 8);
            this.aKd.setVisibility(z ? 8 : 0);
            this.aKe = z;
        }
    }
}
