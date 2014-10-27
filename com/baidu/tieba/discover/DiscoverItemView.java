package com.baidu.tieba.discover;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class DiscoverItemView extends LinearLayout {
    public static final int anN = com.baidu.tieba.u.icon_news_down_bar_one;
    public static final int anO = com.baidu.tieba.u.icon_news_head_new;
    TextView JM;
    String abo;
    ViewGroup anE;
    private TbImageView anF;
    private ImageView anG;
    private TextView anH;
    private TextView anI;
    String anJ;
    int anK;
    private boolean anL;
    private boolean anM;
    private int anP;
    private View.OnClickListener anQ;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public DiscoverItemView(Context context) {
        super(context);
        this.abo = null;
        this.anJ = null;
        this.anK = 0;
        this.anL = false;
        this.anM = false;
        this.anP = anO;
        this.anQ = new k(this);
        init(context);
    }

    public DiscoverItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abo = null;
        this.anJ = null;
        this.anK = 0;
        this.anL = false;
        this.anM = false;
        this.anP = anO;
        this.anQ = new k(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.discover_item, this, true);
        setOrientation(1);
        this.anE = (ViewGroup) findViewById(com.baidu.tieba.v.item_container);
        this.anF = (TbImageView) findViewById(com.baidu.tieba.v.item_image);
        this.anF.setSupportNoImage(false);
        this.JM = (TextView) findViewById(com.baidu.tieba.v.title);
        this.anG = (ImageView) findViewById(com.baidu.tieba.v.newIcon);
        this.anH = (TextView) findViewById(com.baidu.tieba.v.dis_divider_bottom);
        this.anI = (TextView) findViewById(com.baidu.tieba.v.dis_divider_top);
    }

    public void setIconAutoChange(boolean z) {
        this.anF.setAutoChangeStyle(z);
    }

    public DiscoverItemView em(int i) {
        this.anK = i;
        this.anF.setAutoChangeStyle(false);
        aw.c(this.anF, this.anK);
        return this;
    }

    public DiscoverItemView eA(String str) {
        int dimension = (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.ds60);
        this.anF.setTag(str);
        this.anF.setAutoChangeStyle(true);
        this.anF.a(str, 10, dimension, dimension, false);
        return this;
    }

    public DiscoverItemView eB(String str) {
        this.abo = str;
        return this;
    }

    public DiscoverItemView en(int i) {
        this.JM.setText(i);
        return this;
    }

    public DiscoverItemView eC(String str) {
        this.JM.setText(str);
        return this;
    }

    public DiscoverItemView eo(int i) {
        this.anP = i;
        return this;
    }

    public DiscoverItemView bw(boolean z) {
        this.anL = z;
        this.anG.setVisibility(z ? 0 : 8);
        return this;
    }

    public DiscoverItemView bx(boolean z) {
        this.anM = z;
        return this;
    }

    public DiscoverItemView by(boolean z) {
        this.anI.setVisibility(z ? 0 : 8);
        return this;
    }

    public DiscoverItemView bz(boolean z) {
        this.anH.setVisibility(z ? 0 : 8);
        return this;
    }

    public DiscoverItemView eD(String str) {
        this.anJ = str;
        return this;
    }

    public DiscoverItemView f(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        return this;
    }

    public void onChangeSkinType(int i) {
        if (this.mContext instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.mContext;
            baseActivity.getLayoutMode().L(i == 1);
            baseActivity.getLayoutMode().h(this);
        } else if (this.mContext instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.mContext;
            baseFragmentActivity.getLayoutMode().L(i == 1);
            baseFragmentActivity.getLayoutMode().h(this);
        }
        if (this.anK != 0) {
            aw.c(this.anF, this.anK);
        }
        this.anF.refresh();
        bn.a(this, i);
        aw.h(this, com.baidu.tieba.u.list_item_selector);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (ay.aA(this.anJ)) {
            this.anJ = String.valueOf(this.JM.getText());
        }
        boolean z = this.anL;
        if (this.anL) {
            if (this.anP == anN) {
                aw.c(this.anG, this.anP);
            }
            if (this.anM) {
                z = !TbadkSettings.getInst().loadBoolean(com.baidu.adp.lib.util.u.aE(this.anJ), false);
            }
        }
        this.anG.setVisibility(z ? 0 : 8);
        setOnClickListener(this.anQ);
    }
}
