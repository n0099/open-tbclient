package com.baidu.tieba.game.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
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
    private c aJd;
    private TextView aKq;
    private e aKr;
    private boolean aKs;
    private GameInfoData aKt;
    private d aKu;
    private final CustomMessageListener aKv;
    public View.OnClickListener aKw;
    private Context mContext;
    private int mStatus;

    public void setItemClickCallBack(c cVar) {
        this.aJd = cVar;
    }

    public void setItemDownloadCallBack(d dVar) {
        this.aKu = dVar;
    }

    public GameDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKv = new a(this, 2001122);
        this.aKw = new b(this);
        init(context);
    }

    public GameDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKv = new a(this, 2001122);
        this.aKw = new b(this);
        init(context);
    }

    public GameDownloadView(Context context) {
        super(context);
        this.aKv = new a(this, 2001122);
        this.aKw = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aKq = new TextView(context);
        this.aKq.setLayoutParams(new RelativeLayout.LayoutParams(m.c(context, t.ds120), m.c(context, t.ds60)));
        this.aKq.setGravity(17);
        this.aKq.setTextSize(0, m.c(context, t.ds26));
        addView(this.aKq);
        this.aKr = new e(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m.c(context, t.ds58), m.c(context, t.ds58));
        layoutParams.addRule(13, -1);
        this.aKr.setLayoutParams(layoutParams);
        addView(this.aKr);
        setOnClickListener(this.aKw);
    }

    public void a(BdUniqueId bdUniqueId, GameInfoData gameInfoData) {
        if (gameInfoData != null) {
            this.aKt = gameInfoData;
            setTag(this.aKt);
            clear();
            this.aKv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aKv);
            if (gameInfoData.getGameType() == 2) {
                cp(true);
                this.aKq.setText(this.mContext.getResources().getString(y.game_center_start));
                aw.b(this.aKq, s.cp_cont_g, 1);
                this.aKq.setBackgroundDrawable(aw.getDrawable(u.game_center_start_btn));
                return;
            }
            this.mStatus = ab.Hu().o(gameInfoData);
            switch (this.mStatus) {
                case 1:
                    It();
                    return;
                case 2:
                    v(ab.Hu().d(gameInfoData));
                    return;
                case 3:
                    Is();
                    return;
                case 4:
                    t(((float) ab.Hu().m(gameInfoData)) / ((com.baidu.adp.lib.g.c.a(gameInfoData.getPackageSize(), 0.0f) * 1024.0f) * 1024.0f));
                    return;
                case 5:
                    Ip();
                    return;
                case 6:
                    Iq();
                    return;
                case 7:
                    Ir();
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
        MessageManager.getInstance().unRegisterListener(this.aKv);
        this.aKr.Iv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ip() {
        cp(true);
        this.aKq.setText(this.mContext.getResources().getString(y.game_center_install));
        aw.b(this.aKq, s.cp_cont_g, 1);
        this.aKq.setBackgroundDrawable(aw.getDrawable(u.game_center_start_btn));
    }

    private void Iq() {
        cp(true);
        this.aKq.setText(this.mContext.getResources().getString(y.game_center_start));
        aw.b(this.aKq, s.cp_cont_g, 1);
        this.aKq.setBackgroundDrawable(aw.getDrawable(u.game_center_start_btn));
    }

    private void Ir() {
        cp(true);
        this.aKq.setText(this.mContext.getResources().getString(y.game_center_upgrade));
        aw.b(this.aKq, s.cp_cont_b, 1);
        this.aKq.setBackgroundDrawable(aw.getDrawable(u.btn_pop_comment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(float f) {
        if (f < 1.0E-6d) {
            It();
        } else {
            u(Math.max(0.0f, f));
        }
    }

    private void u(float f) {
        cp(false);
        this.aKr.w(f);
        this.aKr.Iv();
        this.aKr.setStatus(4);
        this.aKr.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f) {
        cp(false);
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.aKr.w(f);
        this.aKr.Iv();
        this.aKr.setStatus(2);
        this.aKr.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Is() {
        cp(false);
        this.aKr.setStatus(3);
        this.aKr.Iu();
    }

    private void It() {
        cp(true);
        this.aKq.setText(this.mContext.getResources().getString(y.game_center_download));
        aw.b(this.aKq, s.cp_cont_b, 1);
        this.aKq.setBackgroundDrawable(aw.getDrawable(u.btn_pop_comment));
    }

    private void cp(boolean z) {
        if (this.aKs != z) {
            this.aKq.setVisibility(z ? 0 : 8);
            this.aKr.setVisibility(z ? 8 : 0);
            this.aKs = z;
        }
    }
}
